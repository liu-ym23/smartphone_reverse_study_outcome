package io.ktor.util;

import Y8.t;
import Z8.A;
import Z8.C1168p;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001aO\u0010\b\u001a\u00020\u000726\u0010\u0004\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\f\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u000e\u001a\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000f\u001a1\u0010\b\u001a\u00020\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0013\u001a#\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0010*\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0003*\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001b\u001a\u00020\u0019*\u00020\u00072\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a5\u0010\u001f\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b\u001f\u0010 \u001a=\u0010#\u001a\u00020\u0019*\u00020!2\u0006\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010&\u001a\u00020!*\u00020!2\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020!*\u00020!2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)\u001a!\u0010*\u001a\u00020!*\u00020!2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b*\u0010)\u001a=\u0010&\u001a\u00020!*\u00020!2*\u0010\r\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b&\u0010+\u001aK\u0010&\u001a\u00020!*\u00020!26\u0010\r\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u0001H\u0007¢\u0006\u0004\b,\u0010+\u001a-\u0010&\u001a\u00020!*\u00020!2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u0010H\u0007¢\u0006\u0004\b,\u0010-\u001a%\u0010&\u001a\u00020!*\u00020!2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b&\u0010-\u001aO\u00102\u001a\u00020\u00052\u001e\u00100\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030/0.2\u001e\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030/0.H\u0002¢\u0006\u0004\b2\u00103\u001a7\u00107\u001a\u0002052\u001e\u00104\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030/0.2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108¨\u00069"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "", "caseInsensitiveKey", "Lio/ktor/util/StringValues;", "valuesOf", "([Lkotlin/Pair;Z)Lio/ktor/util/StringValues;", "name", UxipConstants.f30680s, "(Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/util/StringValues;", "values", "(Ljava/lang/String;Ljava/util/List;Z)Lio/ktor/util/StringValues;", "()Lio/ktor/util/StringValues;", "", "", C3081a.FOCUS_MAP_NAME, "(Ljava/util/Map;Z)Lio/ktor/util/StringValues;", "toMap", "(Lio/ktor/util/StringValues;)Ljava/util/Map;", "flattenEntries", "(Lio/ktor/util/StringValues;)Ljava/util/List;", "Lkotlin/Function2;", "LY8/t;", "block", "flattenForEach", "(Lio/ktor/util/StringValues;Lp9/p;)V", "keepEmpty", "predicate", "filter", "(Lio/ktor/util/StringValues;ZLp9/p;)Lio/ktor/util/StringValues;", "Lio/ktor/util/StringValuesBuilder;", "source", "appendFiltered", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValues;ZLp9/p;)V", "builder", "appendAll", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValuesBuilder;)Lio/ktor/util/StringValuesBuilder;", "appendIfNameAbsent", "(Lio/ktor/util/StringValuesBuilder;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/util/StringValuesBuilder;", "appendIfNameAndValueAbsent", "(Lio/ktor/util/StringValuesBuilder;[Lkotlin/Pair;)Lio/ktor/util/StringValuesBuilder;", "appendAllIterable", "(Lio/ktor/util/StringValuesBuilder;Ljava/util/Map;)Lio/ktor/util/StringValuesBuilder;", "", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "entriesEquals", "(Ljava/util/Set;Ljava/util/Set;)Z", "entries", "", "seed", "entriesHashCode", "(Ljava/util/Set;I)I", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringValuesKt {
    public static final StringValuesBuilder appendAll(StringValuesBuilder stringValuesBuilder, StringValuesBuilder builder) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(builder, "builder");
        Iterator<T> it = builder.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stringValuesBuilder.appendAll((String) entry.getKey(), (List) entry.getValue());
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendAllIterable(StringValuesBuilder stringValuesBuilder, Pair<String, ? extends Iterable<String>>... values) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(values, "values");
        for (Pair<String, ? extends Iterable<String>> pair : values) {
            stringValuesBuilder.appendAll(pair.a(), pair.b());
        }
        return stringValuesBuilder;
    }

    public static final void appendFiltered(final StringValuesBuilder stringValuesBuilder, StringValues source, final boolean z10, final p9.p<? super String, ? super String, Boolean> predicate) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        source.forEach(new p9.p() { // from class: io.ktor.util.q
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StringValuesKt.appendFiltered$lambda$10(z10, stringValuesBuilder, predicate, (String) obj, (List) obj2);
            }
        });
    }

    public static /* synthetic */ void appendFiltered$default(StringValuesBuilder stringValuesBuilder, StringValues stringValues, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        appendFiltered(stringValuesBuilder, stringValues, z10, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t appendFiltered$lambda$10(boolean z10, StringValuesBuilder stringValuesBuilder, p9.p pVar, String name, List value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        ArrayList arrayList = new ArrayList(value.size());
        for (Object obj : value) {
            if (((Boolean) pVar.invoke(name, (String) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        if (z10 || !arrayList.isEmpty()) {
            stringValuesBuilder.appendAll(name, arrayList);
        }
        return t.f7040a;
    }

    public static final StringValuesBuilder appendIfNameAbsent(StringValuesBuilder stringValuesBuilder, String name, String value) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        if (!stringValuesBuilder.contains(name)) {
            stringValuesBuilder.append(name, value);
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendIfNameAndValueAbsent(StringValuesBuilder stringValuesBuilder, String name, String value) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        if (!stringValuesBuilder.contains(name, value)) {
            stringValuesBuilder.append(name, value);
        }
        return stringValuesBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entriesEquals(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return kotlin.jvm.internal.p.d(set, set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int entriesHashCode(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i10) {
        return (i10 * 31) + set.hashCode();
    }

    public static final StringValues filter(StringValues stringValues, boolean z10, p9.p<? super String, ? super String, Boolean> predicate) {
        kotlin.jvm.internal.p.i(stringValues, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        Map mapCaseInsensitiveMap = stringValues.getCaseInsensitiveName() ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(setEntries.size());
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(((List) entry.getValue()).size());
            for (Object obj : iterable) {
                if (predicate.invoke(entry.getKey(), (String) obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            if (z10 || !arrayList.isEmpty()) {
                mapCaseInsensitiveMap.put(entry.getKey(), arrayList);
            }
        }
        return new StringValues(stringValues.getCaseInsensitiveName(), mapCaseInsensitiveMap);
    }

    public static /* synthetic */ StringValues filter$default(StringValues stringValues, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return filter(stringValues, z10, pVar);
    }

    public static final List<Pair<String, String>> flattenEntries(StringValues stringValues) {
        kotlin.jvm.internal.p.i(stringValues, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(C1174w.x(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Y8.j.a(entry.getKey(), (String) it2.next()));
            }
            A.E(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static final void flattenForEach(StringValues stringValues, final p9.p<? super String, ? super String, t> block) {
        kotlin.jvm.internal.p.i(stringValues, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        stringValues.forEach(new p9.p() { // from class: io.ktor.util.p
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StringValuesKt.flattenForEach$lambda$6(block, (String) obj, (List) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t flattenForEach$lambda$6(p9.p pVar, String name, List items) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(items, "items");
        Iterator it = items.iterator();
        while (it.hasNext()) {
            pVar.invoke(name, (String) it.next());
        }
        return t.f7040a;
    }

    public static final Map<String, List<String>> toMap(StringValues stringValues) {
        kotlin.jvm.internal.p.i(stringValues, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put((String) entry.getKey(), F.m1((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final StringValues valuesOf(Pair<String, ? extends List<String>>[] pairs, boolean z10) {
        kotlin.jvm.internal.p.i(pairs, "pairs");
        return new StringValues(z10, kotlin.collections.a.y(C1168p.d(pairs)));
    }

    public static /* synthetic */ StringValues valuesOf$default(Pair[] pairArr, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return valuesOf((Pair<String, ? extends List<String>>[]) pairArr, z10);
    }

    public static final StringValues valuesOf(String name, String value, boolean z10) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        return new StringValues(z10, name, C1172u.e(value));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return valuesOf(str, str2, z10);
    }

    public static final StringValuesBuilder appendAllIterable(StringValuesBuilder stringValuesBuilder, Map<String, ? extends Iterable<String>> values) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(values, "values");
        for (Map.Entry<String, ? extends Iterable<String>> entry : values.entrySet()) {
            stringValuesBuilder.appendAll(entry.getKey(), entry.getValue());
        }
        return stringValuesBuilder;
    }

    public static final StringValues valuesOf(String name, List<String> values, boolean z10) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        return new StringValues(z10, name, values);
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return valuesOf(str, (List<String>) list, z10);
    }

    public static final StringValuesBuilder appendAll(StringValuesBuilder stringValuesBuilder, Pair<String, String>... values) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(values, "values");
        for (Pair<String, String> pair : values) {
            stringValuesBuilder.append(pair.a(), pair.b());
        }
        return stringValuesBuilder;
    }

    public static final StringValues valuesOf() {
        return StringValues.INSTANCE.getEmpty();
    }

    public static /* synthetic */ StringValues valuesOf$default(Map map, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return valuesOf((Map<String, ? extends Iterable<String>>) map, z10);
    }

    public static final StringValues valuesOf(Map<String, ? extends Iterable<String>> map, boolean z10) {
        kotlin.jvm.internal.p.i(map, "map");
        int size = map.size();
        if (size == 1) {
            Map.Entry entry = (Map.Entry) F.W0(map.entrySet());
            return new StringValues(z10, (String) entry.getKey(), F.m1((Iterable) entry.getValue()));
        }
        Map mapCaseInsensitiveMap = z10 ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(size);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            mapCaseInsensitiveMap.put(entry2.getKey(), F.m1((Iterable) entry2.getValue()));
        }
        return new StringValues(z10, mapCaseInsensitiveMap);
    }

    public static final StringValuesBuilder appendAll(StringValuesBuilder stringValuesBuilder, Map<String, String> values) {
        kotlin.jvm.internal.p.i(stringValuesBuilder, "<this>");
        kotlin.jvm.internal.p.i(values, "values");
        for (Map.Entry<String, String> entry : values.entrySet()) {
            stringValuesBuilder.append(entry.getKey(), entry.getValue());
        }
        return stringValuesBuilder;
    }
}
