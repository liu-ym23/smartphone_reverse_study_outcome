package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: JvmNameResolverBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = null;
    private static final List<String> PREDEFINED_STRINGS = null;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f7kotlin = null;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public JvmNameResolverBase(String[] r2, Set<Integer> r3, List<JvmProtoBuf.StringTableTypes.Record> r4) {
        Intrinsics.checkNotNullParameter(r2, "strings");
        Intrinsics.checkNotNullParameter(r3, "localNameIndices");
        Intrinsics.checkNotNullParameter(r4, "records");
        this.strings = r2;
        this.localNameIndices = r3;
        this.records = r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r15) {
        JvmProtoBuf.StringTableTypes.Record r0 = this.records.get(r15);
        if (r0.hasString() == false) goto L6;
        String r14 = r0.getString();
    L16:
        if (r0.getSubstringIndexCount() < 2) goto L24;
        List<Integer> r16 = r0.getSubstringIndexList();
        Intrinsics.checkNotNullExpressionValue(r16, "substringIndexList");
        Integer r6 = r16.get(0);
        Integer r17 = r16.get(1);
        Intrinsics.checkNotNullExpressionValue(r6, "begin");
        if (r6.intValue() < 0) goto L24;
        int r7 = r6.intValue();
        Intrinsics.checkNotNullExpressionValue(r17, TraceStatsConsts.STATS_KEY_END);
        if (r7 > r17.intValue()) goto L24;
        if (r17.intValue() > r14.length()) goto L24;
        Intrinsics.checkNotNullExpressionValue(r14, "string");
        r14 = r14.substring(r6.intValue(), r17.intValue());
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
    L24:
        String r8 = r14;
        if (r0.getReplaceCharCount() < 2) goto L27;
        List<Integer> r18 = r0.getReplaceCharList();
        Intrinsics.checkNotNullExpressionValue(r18, "replaceCharList");
        Integer r19 = r18.get(0);
        Integer r110 = r18.get(1);
        Intrinsics.checkNotNullExpressionValue(r8, "string");
        r8 = StringsKt.replace$default(r8, (char) r19.intValue(), (char) r110.intValue(), false, 4, null);
    L27:
        String r9 = r8;
        JvmProtoBuf.StringTableTypes.Record.Operation r111 = r0.getOperation();
        if (r111 != null) goto L30;
        r111 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    L30:
        int r112 = WhenMappings.$EnumSwitchMapping$0[r111.ordinal()];
        if (r112 != 2) goto L33;
        Intrinsics.checkNotNullExpressionValue(r9, "string");
        r9 = StringsKt.replace$default(r9, Typography.dollar, '.', false, 4, null);
    L40:
        Intrinsics.checkNotNullExpressionValue(r9, "string");
        return r9;
    L33:
        if (r112 != 3) goto L40;
        if (r9.length() < 2) goto L38;
        Intrinsics.checkNotNullExpressionValue(r9, "string");
        r9 = r9.substring(1, r9.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String…ing(startIndex, endIndex)");
    L38:
        String r10 = r9;
        Intrinsics.checkNotNullExpressionValue(r10, "string");
        r9 = StringsKt.replace$default(r10, Typography.dollar, '.', false, 4, null);
        goto L40
    L6:
        if (r0.hasPredefinedIndex() == false) goto L14;
        List<String> r1 = PREDEFINED_STRINGS;
        int r4 = r1.size();
        int r5 = r0.getPredefinedIndex();
        if (r5 < 0) goto L11;
        if (r5 >= r4) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        r14 = r1.get(r0.getPredefinedIndex());
    L11:
        r11 = false;
    L14:
        r14 = this.strings[r15];
        goto L16
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r1) {
        return getString(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r1) {
        return this.localNameIndices.contains(Integer.valueOf(r1));
    }

    static {
        Companion = new Companion(null);
        String r1 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f7kotlin = r1;
        List<String> r0 = CollectionsKt.listOf(new String[]{r1 + "/Any", r1 + "/Nothing", r1 + "/Unit", r1 + "/Throwable", r1 + "/Number", r1 + "/Byte", r1 + "/Double", r1 + "/Float", r1 + "/Int", r1 + "/Long", r1 + "/Short", r1 + "/Boolean", r1 + "/Char", r1 + "/CharSequence", r1 + "/String", r1 + "/Comparable", r1 + "/Enum", r1 + "/Array", r1 + "/ByteArray", r1 + "/DoubleArray", r1 + "/FloatArray", r1 + "/IntArray", r1 + "/LongArray", r1 + "/ShortArray", r1 + "/BooleanArray", r1 + "/CharArray", r1 + "/Cloneable", r1 + "/Annotation", r1 + "/collections/Iterable", r1 + "/collections/MutableIterable", r1 + "/collections/Collection", r1 + "/collections/MutableCollection", r1 + "/collections/List", r1 + "/collections/MutableList", r1 + "/collections/Set", r1 + "/collections/MutableSet", r1 + "/collections/Map", r1 + "/collections/MutableMap", r1 + "/collections/Map.Entry", r1 + "/collections/MutableMap.MutableEntry", r1 + "/collections/Iterator", r1 + "/collections/MutableIterator", r1 + "/collections/ListIterator", r1 + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = r0;
        Iterable r2 = CollectionsKt.withIndex(r0);
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        IndexedValue r5 = (IndexedValue) r4.next();
        r3.put((String) r5.getValue(), Integer.valueOf(r5.getIndex()));
        goto L4
    L6:
        PREDEFINED_STRINGS_MAP = r3;
    }
}
