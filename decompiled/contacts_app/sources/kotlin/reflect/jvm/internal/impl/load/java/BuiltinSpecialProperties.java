package kotlin.reflect.jvm.internal.impl.load.java;

import com.android.common.speech.LoggingEvents;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = null;
    public static final BuiltinSpecialProperties INSTANCE = null;
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = null;
    private static final Set<FqName> SPECIAL_FQ_NAMES = null;
    private static final Set<Name> SPECIAL_SHORT_NAMES = null;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        INSTANCE = new BuiltinSpecialProperties();
        Map<FqName, Name> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames._enum, "name"), Name.identifier("name")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, PerfConsts.PERF_DISK_FILE_SIZE), Name.identifier(PerfConsts.PERF_DISK_FILE_SIZE)), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, PerfConsts.PERF_DISK_FILE_SIZE), Name.identifier(PerfConsts.PERF_DISK_FILE_SIZE)), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, LoggingEvents.VoiceIme.EXTRA_TEXT_MODIFIED_LENGTH), Name.identifier(LoggingEvents.VoiceIme.EXTRA_TEXT_MODIFIED_LENGTH)), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.map, "entries"), Name.identifier("entrySet"))});
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = r0;
        Set<Map.Entry<FqName, Name>> r1 = r0.entrySet();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) r3.next();
        r2.add(new Pair(((FqName) r4.getKey()).shortName(), r4.getValue()));
        goto L4
    L6:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = r2.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Pair r7 = (Pair) r6.next();
        Name r8 = (Name) r7.getSecond();
        Object r9 = r5.get(r8);
        if (r9 != null) goto L12;
        r9 = (List) new ArrayList();
        r5.put(r8, r9);
    L12:
        ((List) r9).add((Name) r7.getFirst());
        goto L8
    L13:
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator r11 = r5.entrySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getKey(), CollectionsKt.distinct((Iterable) r12.getValue()));
        goto L15
    L17:
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = r10;
        Set<FqName> r13 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = r13;
        Set<FqName> r14 = r13;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        r15.add(((FqName) r16.next()).shortName());
        goto L19
    L21:
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(r15);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name r1) {
        Intrinsics.checkNotNullParameter(r1, "name1");
        List<Name> r0 = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }
}
