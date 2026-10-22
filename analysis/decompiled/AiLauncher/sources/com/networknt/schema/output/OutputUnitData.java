package com.networknt.schema.output;

import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class OutputUnitData {
    private final Map<OutputUnitKey, Boolean> valid = new LinkedHashMap();
    private final Map<OutputUnitKey, Map<String, Object>> errors = new LinkedHashMap();
    private final Map<OutputUnitKey, Map<String, Object>> annotations = new LinkedHashMap();
    private final Map<OutputUnitKey, Map<String, Object>> droppedAnnotations = new LinkedHashMap();

    public static /* synthetic */ Map a(OutputUnitKey outputUnitKey) {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Map b(OutputUnitKey outputUnitKey) {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Map c(OutputUnitKey outputUnitKey) {
        return new LinkedHashMap();
    }

    public static String formatError(Error error) {
        return error.getMessage();
    }

    public static OutputUnitData from(List<Error> list, ExecutionContext executionContext, Function<Error, Object> function) {
        OutputUnitData outputUnitData = new OutputUnitData();
        Map<OutputUnitKey, Boolean> map = outputUnitData.valid;
        Map<OutputUnitKey, Map<String, Object>> map2 = outputUnitData.errors;
        Map<OutputUnitKey, Map<String, Object>> map3 = outputUnitData.annotations;
        Map<OutputUnitKey, Map<String, Object>> map4 = outputUnitData.droppedAnnotations;
        for (Error error : list) {
            OutputUnitKey outputUnitKey = new OutputUnitKey(error.getEvaluationPath().getParent(), new SchemaLocation(error.getSchemaLocation().getAbsoluteIri(), error.getSchemaLocation().getFragment().getParent()), error.getInstanceLocation());
            map.put(outputUnitKey, Boolean.FALSE);
            Map mapComputeIfAbsent = map2.computeIfAbsent(outputUnitKey, new Function() { // from class: com.networknt.schema.output.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return OutputUnitData.c((OutputUnitKey) obj);
                }
            });
            Object obj = mapComputeIfAbsent.get(error.getKeyword());
            if (obj == null) {
                mapComputeIfAbsent.put(error.getKeyword(), function.apply(error));
            } else if (obj instanceof List) {
                ((List) obj).add(function.apply(error));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj.toString());
                arrayList.add(function.apply(error));
                mapComputeIfAbsent.put(error.getKeyword(), arrayList);
            }
        }
        Iterator<List<Annotation>> it = executionContext.getAnnotations().asMap().values().iterator();
        while (it.hasNext()) {
            for (Annotation annotation : it.next()) {
                if (executionContext.getExecutionConfig().getAnnotationCollectionFilter().test(annotation.getKeyword())) {
                    OutputUnitKey outputUnitKey2 = new OutputUnitKey(annotation.getEvaluationPath().getParent(), new SchemaLocation(annotation.getSchemaLocation().getAbsoluteIri(), annotation.getSchemaLocation().getFragment().getParent()), annotation.getInstanceLocation());
                    boolean zIsValid = annotation.isValid();
                    map.put(outputUnitKey2, Boolean.valueOf(zIsValid));
                    if (zIsValid) {
                        map3.computeIfAbsent(outputUnitKey2, new Function() { // from class: com.networknt.schema.output.l
                            @Override // java.util.function.Function
                            public final Object apply(Object obj2) {
                                return OutputUnitData.a((OutputUnitKey) obj2);
                            }
                        }).put(annotation.getKeyword(), annotation.getValue());
                    } else {
                        map4.computeIfAbsent(outputUnitKey2, new Function() { // from class: com.networknt.schema.output.m
                            @Override // java.util.function.Function
                            public final Object apply(Object obj2) {
                                return OutputUnitData.b((OutputUnitKey) obj2);
                            }
                        }).put(annotation.getKeyword(), annotation.getValue());
                    }
                }
            }
        }
        return outputUnitData;
    }

    public Map<OutputUnitKey, Map<String, Object>> getAnnotations() {
        return this.annotations;
    }

    public Map<OutputUnitKey, Map<String, Object>> getDroppedAnnotations() {
        return this.droppedAnnotations;
    }

    public Map<OutputUnitKey, Map<String, Object>> getErrors() {
        return this.errors;
    }

    public Map<OutputUnitKey, Boolean> getValid() {
        return this.valid;
    }
}
