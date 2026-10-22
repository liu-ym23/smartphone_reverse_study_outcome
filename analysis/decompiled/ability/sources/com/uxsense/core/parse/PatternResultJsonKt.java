package com.uxsense.core.parse;

import Ba.f;
import C7.r;
import C9.AbstractC0200b;
import C9.B;
import C9.d;
import C9.g;
import C9.l;
import C9.m;
import C9.x;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.task.executor.e;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.core.pattern.builder.NodePatternBuilderKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000e\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0015\u001a\u0019\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a%\u0010\u001a\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u001d\u001a\u0019\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u001e\u001a!\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u001f\u001a!\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010 \u001a%\u0010!\u001a\u00020\r*\u00020\r2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0019\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010#\u001a\u001f\u0010\u001a\u001a\u00020\r*\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\n¢\u0006\u0004\b\u001a\u0010%\u001a%\u0010\u0012\u001a\u00020\r*\u00020\r2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&¢\u0006\u0004\b\u0012\u0010*\"\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/uxsense/core/pattern/PatternMatchResult;", "", "toValueJson", "(Lcom/uxsense/core/pattern/PatternMatchResult;)Ljava/lang/String;", "LC9/x;", "toValueJsonObject", "(Lcom/uxsense/core/pattern/PatternMatchResult;)LC9/x;", "", "toValueMap", "(Lcom/uxsense/core/pattern/PatternMatchResult;)Ljava/util/Map;", "", "toValueJsonArray", "(Ljava/util/List;)Ljava/lang/String;", "LC9/d;", "toValueJsonArrayObject", "(Ljava/util/List;)LC9/d;", "key", "value", "plus", "(LC9/x;Ljava/lang/String;Ljava/lang/String;)LC9/x;", "LC9/l;", "(LC9/x;Ljava/lang/String;LC9/l;)LC9/x;", "other", "merge", "(LC9/x;LC9/x;)LC9/x;", "entries", "plusAll", "(LC9/x;Ljava/util/Map;)LC9/x;", "element", "(LC9/d;LC9/l;)LC9/d;", "(LC9/d;Ljava/lang/String;)LC9/d;", "(LC9/d;Ljava/lang/String;Ljava/lang/String;)LC9/d;", "(LC9/d;Ljava/lang/String;LC9/l;)LC9/d;", "plusObject", "(LC9/d;Ljava/util/Map;)LC9/d;", "(LC9/d;LC9/d;)LC9/d;", "elements", "(LC9/d;Ljava/util/List;)LC9/d;", "Lkotlin/Function1;", "Lcom/uxsense/core/parse/JsonArrayPlusBuilder;", "LC7/r;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(LC9/d;LS7/k;)LC9/d;", "LC9/b;", "json", "LC9/b;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PatternResultJsonKt {
    private static final AbstractC0200b json = e.b(new f(19));

    /* JADX INFO: Access modifiers changed from: private */
    public static final r json$lambda$0(g Json) {
        k.f(Json, "$this$Json");
        Json.c = true;
        return r.f317a;
    }

    public static final x merge(x xVar, x other) {
        k.f(xVar, "<this>");
        k.f(other, "other");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, l> entry : xVar.entrySet()) {
            String key = entry.getKey();
            l element = entry.getValue();
            k.f(key, "key");
            k.f(element, "element");
        }
        for (Map.Entry<String, l> entry2 : other.entrySet()) {
            String key2 = entry2.getKey();
            l element2 = entry2.getValue();
            k.f(key2, "key");
            k.f(element2, "element");
        }
        return new x(linkedHashMap);
    }

    public static final x plus(x xVar, String key, l value) {
        k.f(xVar, "<this>");
        k.f(key, "key");
        k.f(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, l> entry : xVar.entrySet()) {
            String key2 = entry.getKey();
            l element = entry.getValue();
            k.f(key2, "key");
            k.f(element, "element");
        }
        return new x(linkedHashMap);
    }

    public static final x plusAll(x xVar, Map<String, String> entries) {
        k.f(xVar, "<this>");
        k.f(entries, "entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, l> entry : xVar.entrySet()) {
            String key = entry.getKey();
            l element = entry.getValue();
            k.f(key, "key");
            k.f(element, "element");
        }
        for (Map.Entry<String, String> entry2 : entries.entrySet()) {
            String key2 = entry2.getKey();
            B element2 = m.b(entry2.getValue());
            k.f(key2, "key");
            k.f(element2, "element");
        }
        return new x(linkedHashMap);
    }

    public static final d plusObject(d dVar, Map<String, String> entries) {
        k.f(dVar, "<this>");
        k.f(entries, "entries");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            String key = entry.getKey();
            B element2 = m.b(entry.getValue());
            k.f(key, "key");
            k.f(element2, "element");
        }
        arrayList.add(new x(linkedHashMap));
        return new d(arrayList);
    }

    public static final String toValueJson(PatternMatchResult patternMatchResult) {
        k.f(patternMatchResult, "<this>");
        return json.b(x.Companion.serializer(), toValueJsonObject(patternMatchResult));
    }

    public static final String toValueJsonArray(List<PatternMatchResult> list) {
        k.f(list, "<this>");
        return json.b(d.Companion.serializer(), toValueJsonArrayObject(list));
    }

    public static final d toValueJsonArrayObject(List<PatternMatchResult> list) {
        k.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            x element = toValueJsonObject((PatternMatchResult) it.next());
            k.f(element, "element");
            arrayList.add(element);
        }
        return new d(arrayList);
    }

    public static final x toValueJsonObject(PatternMatchResult patternMatchResult) {
        k.f(patternMatchResult, "<this>");
        Map<String, String> valueMap = toValueMap(patternMatchResult);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.P(valueMap.size()));
        Iterator<T> it = valueMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), m.b((String) entry.getValue()));
        }
        return new x(linkedHashMap);
    }

    public static final Map<String, String> toValueMap(PatternMatchResult patternMatchResult) {
        k.f(patternMatchResult, "<this>");
        Set<String> setKeySet = patternMatchResult.getNodes().keySet();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!NodePatternBuilderKt.isAnonymousName((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            String value = patternMatchResult.getValue(str);
            Pair pair = null;
            if (value != null) {
                if (value.length() <= 0) {
                    value = null;
                }
                if (value != null) {
                    pair = new Pair(str, value);
                }
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return a.X(arrayList2);
    }

    public static final x plus(x xVar, String key, String value) {
        k.f(xVar, "<this>");
        k.f(key, "key");
        k.f(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, l> entry : xVar.entrySet()) {
            String key2 = entry.getKey();
            l element = entry.getValue();
            k.f(key2, "key");
            k.f(element, "element");
        }
        B element2 = m.b(value);
        k.f(element2, "element");
        return new x(linkedHashMap);
    }

    public static final d merge(d dVar, d other) {
        k.f(dVar, "<this>");
        k.f(other, "other");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        for (l element2 : other) {
            k.f(element2, "element");
            arrayList.add(element2);
        }
        return new d(arrayList);
    }

    public static final d plusAll(d dVar, List<? extends l> elements) {
        k.f(dVar, "<this>");
        k.f(elements, "elements");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        for (l element2 : elements) {
            k.f(element2, "element");
            arrayList.add(element2);
        }
        return new d(arrayList);
    }

    public static final d plus(d dVar, l element) {
        k.f(dVar, "<this>");
        k.f(element, "element");
        ArrayList arrayList = new ArrayList();
        for (l element2 : dVar) {
            k.f(element2, "element");
            arrayList.add(element2);
        }
        arrayList.add(element);
        return new d(arrayList);
    }

    public static final d plus(d dVar, String value) {
        k.f(dVar, "<this>");
        k.f(value, "value");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        B element2 = m.b(value);
        k.f(element2, "element");
        arrayList.add(element2);
        return new d(arrayList);
    }

    public static final d plus(d dVar, String key, l value) {
        k.f(dVar, "<this>");
        k.f(key, "key");
        k.f(value, "value");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        arrayList.add(new x(linkedHashMap));
        return new d(arrayList);
    }

    public static final d plus(d dVar, String key, String value) {
        k.f(dVar, "<this>");
        k.f(key, "key");
        k.f(value, "value");
        ArrayList arrayList = new ArrayList();
        for (l element : dVar) {
            k.f(element, "element");
            arrayList.add(element);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        B element2 = m.b(value);
        k.f(element2, "element");
        arrayList.add(new x(linkedHashMap));
        return new d(arrayList);
    }

    public static final d plus(d dVar, S7.k build) {
        k.f(dVar, "<this>");
        k.f(build, "build");
        JsonArrayPlusBuilder jsonArrayPlusBuilder = new JsonArrayPlusBuilder(dVar);
        build.invoke(jsonArrayPlusBuilder);
        return jsonArrayPlusBuilder.build();
    }
}
