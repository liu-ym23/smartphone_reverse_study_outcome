package com.stepos.config.dag;

import android.util.Log;
import com.stepos.config.dag.ConfigNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class ConfigMonitor {
    private static final String TAG = "ConfigMonitor";
    private final ConfigurationRegistry registry;

    public ConfigMonitor(ConfigurationRegistry registry) {
        this.registry = registry;
    }

    public Map<String, Long> getInitStats() {
        Map<String, Long> stats = new HashMap<>();
        for (String configName : this.registry.getAllConfigNames()) {
            ConfigNode node = this.registry.getConfigNode(configName);
            if (node != null) {
                stats.put(configName, Long.valueOf(node.getInitDuration()));
            }
        }
        return stats;
    }

    public List<String> getSlowConfigs(final long thresholdMs) {
        return (List) getInitStats().entrySet().stream().filter(new Predicate() { // from class: com.stepos.config.dag.ConfigMonitor$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ConfigMonitor.lambda$getSlowConfigs$0(thresholdMs, (Map.Entry) obj);
            }
        }).sorted(Map.Entry.comparingByValue().reversed()).map(new Function() { // from class: com.stepos.config.dag.ConfigMonitor$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$getSlowConfigs$0(long thresholdMs, Map.Entry e) {
        return e.getValue() != null && ((Long) e.getValue()).longValue() > thresholdMs;
    }

    public List<String> getFailedConfigs() {
        return (List) this.registry.getAllConfigNames().stream().filter(new Predicate() { // from class: com.stepos.config.dag.ConfigMonitor$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$getFailedConfigs$1((String) obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getFailedConfigs$1(String name) {
        ConfigNode node = this.registry.getConfigNode(name);
        return node != null && node.getState() == ConfigNode.InitState.FAILED;
    }

    public List<String> getPendingConfigs() {
        return (List) this.registry.getAllConfigNames().stream().filter(new Predicate() { // from class: com.stepos.config.dag.ConfigMonitor$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.lambda$getPendingConfigs$2((String) obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getPendingConfigs$2(String name) {
        ConfigNode node = this.registry.getConfigNode(name);
        return node != null && (node.getState() == ConfigNode.InitState.UNINITIALIZED || node.getState() == ConfigNode.InitState.INITIALIZING);
    }

    public List<String> getDependencyChain(String configName) {
        List<String> chain = new ArrayList<>();
        buildDependencyChain(configName, chain, new HashSet());
        return chain;
    }

    private void buildDependencyChain(String configName, List<String> chain, Set<String> visited) {
        if (visited.contains(configName)) {
            return;
        }
        visited.add(configName);
        ConfigNode node = this.registry.getConfigNode(configName);
        if (node != null) {
            for (String dep : node.getDependencies()) {
                buildDependencyChain(dep, chain, visited);
            }
        }
        chain.add(configName);
    }

    public HealthStatus getHealthStatus() {
        int total = 0;
        int initialized = 0;
        int failed = 0;
        int pending = 0;
        for (String name : this.registry.getAllConfigNames()) {
            total++;
            ConfigNode node = this.registry.getConfigNode(name);
            if (node != null) {
                switch (node.getState()) {
                    case INITIALIZED:
                        initialized++;
                        break;
                    case FAILED:
                        failed++;
                        break;
                    case UNINITIALIZED:
                    case INITIALIZING:
                    case RECOVERING:
                        pending++;
                        break;
                }
            }
        }
        return new HealthStatus(total, initialized, failed, pending);
    }

    public void dumpStatus() {
        Log.i(TAG, "=== Config Status Dump ===");
        HealthStatus health = getHealthStatus();
        Log.i(TAG, "Total: " + health.total + ", Initialized: " + health.initialized + ", Failed: " + health.failed + ", Pending: " + health.pending);
        List<String> slow = getSlowConfigs(100L);
        if (!slow.isEmpty()) {
            Log.i(TAG, "Slow configs (>100ms): " + slow);
        }
        List<String> failed = getFailedConfigs();
        if (!failed.isEmpty()) {
            Log.w(TAG, "Failed configs: " + failed);
        }
    }

    public static class HealthStatus {
        public final int failed;
        public final int initialized;
        public final int pending;
        public final int total;

        public HealthStatus(int total, int initialized, int failed, int pending) {
            this.total = total;
            this.initialized = initialized;
            this.failed = failed;
            this.pending = pending;
        }

        public boolean isHealthy() {
            return this.failed == 0 && this.pending == 0;
        }
    }
}
