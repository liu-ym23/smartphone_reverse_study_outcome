package com.stepos.config.dag;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.ToIntFunction;

/* loaded from: classes.dex */
public class DependencyGraphBuilder {
    private static final String TAG = "DependencyGraph";
    private final Map<String, List<String>> adjacencyList = new HashMap();
    private final Map<String, Integer> dependencyCount = new HashMap();
    private final Map<String, ConfigNode> nodes = new HashMap();
    private final Set<String> missingPlaceholders = new HashSet();

    public void addNode(ConfigNode node) {
        String name = node.getConfigName();
        this.nodes.put(name, node);
        this.adjacencyList.putIfAbsent(name, new ArrayList());
        this.dependencyCount.putIfAbsent(name, 0);
        this.missingPlaceholders.remove(name);
    }

    public void addDependency(String from, String to) {
        if (!this.nodes.containsKey(to)) {
            Log.e(TAG, "Dependency target not found: " + to + " (required by " + from + ")");
            this.missingPlaceholders.add(to);
        } else {
            this.adjacencyList.get(to).add(from);
            this.dependencyCount.put(from, Integer.valueOf(this.dependencyCount.getOrDefault(from, 0).intValue() + 1));
        }
    }

    public void addMissingPlaceholder(String configName) {
        this.missingPlaceholders.add(configName);
    }

    public Set<String> getMissingDependencies() {
        return Collections.unmodifiableSet(this.missingPlaceholders);
    }

    public CycleDetectionResult detectCycle() {
        List<String> cycle;
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();
        for (String node : this.nodes.keySet()) {
            if (!visited.contains(node) && (cycle = detectCycleDFS(node, visited, recursionStack, parentMap)) != null) {
                Log.e(TAG, "Cycle detected: " + String.join(" -> ", cycle));
                return CycleDetectionResult.withCycle(cycle);
            }
        }
        return CycleDetectionResult.noCycle();
    }

    private List<String> detectCycleDFS(String node, Set<String> visited, Set<String> recursionStack, Map<String, String> parentMap) {
        visited.add(node);
        recursionStack.add(node);
        for (String neighbor : this.adjacencyList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                parentMap.put(neighbor, node);
                List<String> cycle = detectCycleDFS(neighbor, visited, recursionStack, parentMap);
                if (cycle != null) {
                    return cycle;
                }
            } else if (recursionStack.contains(neighbor)) {
                return buildCyclePath(neighbor, node, parentMap);
            }
        }
        recursionStack.remove(node);
        return null;
    }

    private List<String> buildCyclePath(String startNode, String endNode, Map<String, String> parentMap) {
        LinkedList<String> path = new LinkedList<>();
        path.addFirst(startNode);
        String current = endNode;
        while (current != null && !current.equals(startNode)) {
            path.addFirst(current);
            current = parentMap.get(current);
        }
        path.addFirst(startNode);
        return path;
    }

    public List<String> topologicalSort() throws ConfigInitException {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> tempDependencyCount = new HashMap<>(this.dependencyCount);
        for (Map.Entry<String, Integer> entry : tempDependencyCount.entrySet()) {
            if (entry.getValue().intValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            List<String> batch = new ArrayList<>(queue);
            batch.sort(Comparator.comparingInt(new ToIntFunction() { // from class: com.stepos.config.dag.DependencyGraphBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    return this.f$0.lambda$topologicalSort$0((String) obj);
                }
            }));
            queue.clear();
            for (String current : batch) {
                result.add(current);
                for (String dependent : this.adjacencyList.get(current)) {
                    int newCount = tempDependencyCount.get(dependent).intValue() - 1;
                    tempDependencyCount.put(dependent, Integer.valueOf(newCount));
                    if (newCount == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }
        if (result.size() != this.nodes.size()) {
            throw new ConfigInitException("Topological sort failed: circular dependency detected");
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$topologicalSort$0(String name) {
        return this.nodes.get(name).getPriority();
    }

    public List<String> getDependents(String configName) {
        return new ArrayList(this.adjacencyList.getOrDefault(configName, Collections.emptyList()));
    }

    public List<String> getDependencies(String configName) {
        ConfigNode node = this.nodes.get(configName);
        return node != null ? new ArrayList(node.getDependencies()) : Collections.emptyList();
    }

    public ConfigNode getNode(String configName) {
        return this.nodes.get(configName);
    }

    public int getNodeCount() {
        return this.nodes.size();
    }
}
