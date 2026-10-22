package com.networknt.schema.output;

import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.path.NodePath;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class HierarchicalOutputUnitFormatter {
    public static /* synthetic */ Map a(NodePath nodePath) {
        return new LinkedHashMap();
    }

    public static void buildIndex(OutputUnitKey outputUnitKey, Map<NodePath, Map<NodePath, OutputUnit>> map, Map<NodePath, Set<NodePath>> map2, OutputUnit outputUnit) {
        if (map.containsKey(outputUnitKey.getEvaluationPath())) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        for (NodePath evaluationPath = outputUnitKey.getEvaluationPath(); evaluationPath != null && evaluationPath.getElement(-1) != null; evaluationPath = evaluationPath.getParent()) {
            arrayDeque.push(evaluationPath);
        }
        while (!arrayDeque.isEmpty()) {
            NodePath nodePath = (NodePath) arrayDeque.pop();
            if (!map.containsKey(nodePath) && map2.containsKey(nodePath)) {
                for (NodePath nodePath2 : map2.get(nodePath)) {
                    OutputUnit outputUnit2 = new OutputUnit();
                    outputUnit2.setValid(true);
                    outputUnit2.setEvaluationPath(nodePath.toString());
                    outputUnit2.setInstanceLocation(nodePath2.toString());
                    map.computeIfAbsent(nodePath, new Function() { // from class: com.networknt.schema.output.i
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return HierarchicalOutputUnitFormatter.a((NodePath) obj);
                        }
                    }).put(nodePath2, outputUnit2);
                    if (outputUnit.getDetails() == null) {
                        outputUnit.setDetails(new ArrayList());
                    }
                    outputUnit.getDetails().add(outputUnit2);
                }
            }
            Map<NodePath, OutputUnit> map3 = map.get(nodePath);
            if (map3 != null) {
                Iterator<Map.Entry<NodePath, OutputUnit>> it = map3.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<NodePath, OutputUnit> next = it.next();
                        if (outputUnitKey.getInstanceLocation().startsWith(next.getKey())) {
                            outputUnit = next.getValue();
                            break;
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ Set d(NodePath nodePath) {
        return new LinkedHashSet();
    }

    public static OutputUnit format(final OutputUnit outputUnit, OutputUnitData outputUnitData, NodePath nodePath) {
        Map<OutputUnitKey, Boolean> valid = outputUnitData.getValid();
        Map<OutputUnitKey, Map<String, Object>> errors = outputUnitData.getErrors();
        Map<OutputUnitKey, Map<String, Object>> annotations = outputUnitData.getAnnotations();
        Map<OutputUnitKey, Map<String, Object>> droppedAnnotations = outputUnitData.getDroppedAnnotations();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(nodePath, outputUnit);
        linkedHashMap.put(nodePath, linkedHashMap2);
        final LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        errors.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                OutputUnitKey outputUnitKey = (OutputUnitKey) obj;
                ((Set) linkedHashMap3.computeIfAbsent(outputUnitKey.getEvaluationPath(), new Function() { // from class: com.networknt.schema.output.h
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return HierarchicalOutputUnitFormatter.j((NodePath) obj2);
                    }
                })).add(outputUnitKey.getInstanceLocation());
            }
        });
        annotations.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                OutputUnitKey outputUnitKey = (OutputUnitKey) obj;
                ((Set) linkedHashMap3.computeIfAbsent(outputUnitKey.getEvaluationPath(), new Function() { // from class: com.networknt.schema.output.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return HierarchicalOutputUnitFormatter.h((NodePath) obj2);
                    }
                })).add(outputUnitKey.getInstanceLocation());
            }
        });
        droppedAnnotations.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                OutputUnitKey outputUnitKey = (OutputUnitKey) obj;
                ((Set) linkedHashMap3.computeIfAbsent(outputUnitKey.getEvaluationPath(), new Function() { // from class: com.networknt.schema.output.j
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return HierarchicalOutputUnitFormatter.d((NodePath) obj2);
                    }
                })).add(outputUnitKey.getInstanceLocation());
            }
        });
        errors.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HierarchicalOutputUnitFormatter.buildIndex((OutputUnitKey) obj, linkedHashMap, linkedHashMap3, outputUnit);
            }
        });
        annotations.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HierarchicalOutputUnitFormatter.buildIndex((OutputUnitKey) obj, linkedHashMap, linkedHashMap3, outputUnit);
            }
        });
        droppedAnnotations.keySet().stream().forEach(new Consumer() { // from class: com.networknt.schema.output.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HierarchicalOutputUnitFormatter.buildIndex((OutputUnitKey) obj, linkedHashMap, linkedHashMap3, outputUnit);
            }
        });
        for (Map.Entry<OutputUnitKey, Map<String, Object>> entry : errors.entrySet()) {
            OutputUnitKey key = entry.getKey();
            OutputUnit outputUnit2 = (OutputUnit) ((Map) linkedHashMap.get(key.getEvaluationPath())).get(key.getInstanceLocation());
            outputUnit2.setInstanceLocation(key.getInstanceLocation().toString());
            outputUnit2.setSchemaLocation(key.getSchemaLocation().toString());
            outputUnit2.setValid(false);
            outputUnit2.setErrors(entry.getValue());
        }
        for (Map.Entry<OutputUnitKey, Map<String, Object>> entry2 : annotations.entrySet()) {
            OutputUnitKey key2 = entry2.getKey();
            OutputUnit outputUnit3 = (OutputUnit) ((Map) linkedHashMap.get(key2.getEvaluationPath())).get(key2.getInstanceLocation());
            String string = key2.getInstanceLocation().toString();
            String string2 = key2.getSchemaLocation().toString();
            if (outputUnit3.getInstanceLocation() != null && !outputUnit3.getInstanceLocation().equals(string)) {
                throw new IllegalArgumentException();
            }
            if (outputUnit3.getSchemaLocation() != null && !outputUnit3.getSchemaLocation().equals(string2)) {
                throw new IllegalArgumentException();
            }
            outputUnit3.setInstanceLocation(string);
            outputUnit3.setSchemaLocation(string2);
            outputUnit3.setAnnotations(entry2.getValue());
            outputUnit3.setValid(valid.get(key2).booleanValue());
        }
        for (Map.Entry<OutputUnitKey, Map<String, Object>> entry3 : droppedAnnotations.entrySet()) {
            OutputUnitKey key3 = entry3.getKey();
            OutputUnit outputUnit4 = (OutputUnit) ((Map) linkedHashMap.get(key3.getEvaluationPath())).get(key3.getInstanceLocation());
            String string3 = key3.getInstanceLocation().toString();
            String string4 = key3.getSchemaLocation().toString();
            if (outputUnit4.getInstanceLocation() != null && !outputUnit4.getInstanceLocation().equals(string3)) {
                throw new IllegalArgumentException();
            }
            if (outputUnit4.getSchemaLocation() != null && !outputUnit4.getSchemaLocation().equals(string4)) {
                throw new IllegalArgumentException();
            }
            outputUnit4.setInstanceLocation(string3);
            outputUnit4.setSchemaLocation(string4);
            outputUnit4.setDroppedAnnotations(entry3.getValue());
            outputUnit4.setValid(valid.get(key3).booleanValue());
        }
        return outputUnit;
    }

    public static /* synthetic */ Set h(NodePath nodePath) {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Set j(NodePath nodePath) {
        return new LinkedHashSet();
    }

    public static OutputUnit format(Schema schema, List<Error> list, ExecutionContext executionContext, SchemaContext schemaContext, Function<Error, Object> function) {
        OutputUnit outputUnit = new OutputUnit();
        outputUnit.setValid(list.isEmpty());
        outputUnit.setInstanceLocation(schemaContext.getSchemaRegistryConfig().getPathType().getRoot());
        outputUnit.setEvaluationPath(schemaContext.getSchemaRegistryConfig().getPathType().getRoot());
        outputUnit.setSchemaLocation(schema.getSchemaLocation().toString());
        return format(outputUnit, OutputUnitData.from(list, executionContext, function), new NodePath(schemaContext.getSchemaRegistryConfig().getPathType()));
    }
}
