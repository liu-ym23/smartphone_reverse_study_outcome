package com.networknt.schema.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.networknt.schema.annotation.Annotations;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.serialization.JsonMapperFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class Annotations {
    private final Map<NodePath, List<Annotation>> values = new LinkedHashMap();

    public static class Formatter {
        public static /* synthetic */ Map a(String str) {
            return new LinkedHashMap();
        }

        public static /* synthetic */ Map b(String str) {
            return new LinkedHashMap();
        }

        public static String format(Map<NodePath, List<Annotation>> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<List<Annotation>> it = map.values().iterator();
            while (it.hasNext()) {
                for (Annotation annotation : it.next()) {
                    String keyword = annotation.getKeyword();
                    String string = annotation.getInstanceLocation().toString();
                    ((Map) ((Map) linkedHashMap.computeIfAbsent(string, new Function() { // from class: com.networknt.schema.annotation.b
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return Annotations.Formatter.b((String) obj);
                        }
                    })).computeIfAbsent(keyword, new Function() { // from class: com.networknt.schema.annotation.c
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return Annotations.Formatter.a((String) obj);
                        }
                    })).put(annotation.getEvaluationPath().toString(), annotation.getValue());
                }
            }
            try {
                return JsonMapperFactory.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(linkedHashMap);
            } catch (JsonProcessingException unused) {
                return "";
            }
        }
    }

    public static /* synthetic */ List a(NodePath nodePath) {
        return new ArrayList();
    }

    public Map<NodePath, List<Annotation>> asMap() {
        return this.values;
    }

    public void put(Annotation annotation) {
        this.values.computeIfAbsent(annotation.getInstanceLocation(), new Function() { // from class: com.networknt.schema.annotation.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Annotations.a((NodePath) obj);
            }
        }).add(annotation);
    }

    public String toString() {
        return Formatter.format(this.values);
    }
}
