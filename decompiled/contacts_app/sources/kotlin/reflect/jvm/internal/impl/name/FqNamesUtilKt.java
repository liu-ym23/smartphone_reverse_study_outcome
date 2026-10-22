package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FqNamesUtilKt {

    /* JADX INFO: compiled from: FqNamesUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[State.values().length];
            r0[State.BEGINNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[State.AFTER_DOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[State.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final boolean isSubpackageOf(FqName r2, FqName r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        if (Intrinsics.areEqual(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r3.isRoot() == true) goto L11;
        String r4 = r2.asString();
        Intrinsics.checkNotNullExpressionValue(r4, "this.asString()");
        String r5 = r3.asString();
        Intrinsics.checkNotNullExpressionValue(r5, "packageName.asString()");
        return isSubpackageOf(r4, r5);
    L11:
        return true;
    }

    public static final boolean isChildOf(FqName r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        return Intrinsics.areEqual(parentOrNull(r1), r2);
    }

    private static final boolean isSubpackageOf(String r3, String r4) {
        if (StringsKt.startsWith$default(r3, r4, false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r3.charAt(r4.length()) != '.') goto L9;
        return true;
    L9:
        return false;
    }

    public static final FqName tail(FqName r2, FqName r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        if (isSubpackageOf(r2, r3) == true) goto L5;
        return r2;
    L5:
        if (r3.isRoot() == false) goto L8;
        return r2;
    L8:
        if (Intrinsics.areEqual(r2, r3) == false) goto L10;
        FqName r4 = FqName.ROOT;
        Intrinsics.checkNotNullExpressionValue(r4, "ROOT");
        return r4;
    L10:
        String r5 = r2.asString();
        Intrinsics.checkNotNullExpressionValue(r5, "asString()");
        String r6 = r5.substring(r3.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
        return new FqName(r6);
    }

    public static final FqName parentOrNull(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isRoot() == false) goto L6;
        return null;
    L6:
        return r1.parent();
    }

    public static final boolean isValidJavaFqName(String r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        State r1 = State.BEGINNING;
        int r2 = 0;
    L7:
        if (r2 >= r7.length()) goto L27;
        char r3 = r7.charAt(r2);
        int r5 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L22;
        if (r5 != 3) goto L25;
        if (r3 != '.') goto L19;
        r1 = State.AFTER_DOT;
        goto L25
    L19:
        if (Character.isJavaIdentifierPart(r3) == true) goto L25;
        return false;
    L25:
        r2 = r2 + 1;
    L22:
        if (Character.isJavaIdentifierPart(r3) == false) goto L23;
        r1 = State.MIDDLE;
        goto L25
    L23:
        return false;
    L27:
        if (r1 != State.AFTER_DOT) goto L29;
        return false;
    L29:
        return true;
    }

    public static final <V> V findValueForMostSpecificFqname(FqName r5, Map<FqName, ? extends V> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "values");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> r7 = r6.entrySet().iterator();
    L3:
        boolean r2 = true;
        if (r7.hasNext() == false) goto L14;
        Map.Entry<FqName, ? extends V> r1 = r7.next();
        FqName r3 = r1.getKey();
        if (Intrinsics.areEqual(r5, r3) == false) goto L8;
    L11:
        if (r2 == false) goto L3;
        r0.put(r1.getKey(), r1.getValue());
        goto L3
    L8:
        if (isChildOf(r5, r3) == true) goto L11;
        r2 = false;
        goto L11
    L14:
        if ((!r0.isEmpty()) == true) goto L17;
        r0 = null;
    L17:
        if (r0 != null) goto L19;
        return null;
    L19:
        Iterator r8 = r0.entrySet().iterator();
        if (r8.hasNext() == true) goto L22;
        Object r4 = null;
    L31:
        Map.Entry r9 = (Map.Entry) r4;
        if (r9 != null) goto L34;
        return null;
    L34:
        return (V) r9.getValue();
    L22:
        r4 = r8.next();
        if (r8.hasNext() == false) goto L31;
        int r10 = tail((FqName) ((Map.Entry) r4).getKey(), r5).asString().length();
    L26:
        Object r11 = r8.next();
        int r12 = tail((FqName) ((Map.Entry) r11).getKey(), r5).asString().length();
        if (r10 <= r12) goto L30;
        r4 = r11;
        r10 = r12;
    L30:
        if (r8.hasNext() == true) goto L26;
        goto L31
    }
}
