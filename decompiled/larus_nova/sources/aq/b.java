package aq;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final long c(Object r100) {
        long r101 = (long) u(r100);
    L6:
        return ~r101;
    L4:
        r101 = 0;
        goto L6
    }

    @JvmStatic
    public static final boolean m(Object r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof String) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @JvmStatic
    public static final Number r(Object r100) {
        if ((r100 instanceof Long) == false) goto L6;
        return Long.valueOf(-((Number) r100).longValue());
    L6:
        if ((r100 instanceof Double) == false) goto L9;
        return Double.valueOf(-((Number) r100).doubleValue());
    L9:
        if ((r100 instanceof Integer) == false) goto L12;
        return Integer.valueOf(-((Number) r100).intValue());
    L12:
        if ((r100 instanceof Float) == true) goto L24;
        double r101 = -u(r100);
    L18:
        return Double.valueOf(r101);
    L16:
        r101 = Double.NaN;
        goto L18
    L24:
        return Float.valueOf(-((Number) r100).floatValue());
    }

    @JvmStatic
    public static final double u(Object r100) {
        if (r100 != null) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if ((r100 instanceof Number) == false) goto L9;
        return ((Number) r100).doubleValue();
    L9:
        if ((r100 instanceof String) == false) goto L15;
        if (StringsKt.isBlank((CharSequence) r100) == false) goto L23;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L23:
        return CastDoubleProtector.parseDouble((String) r100);
    L15:
        if ((r100 instanceof Boolean) == false) goto L21;
        if (((Boolean) r100).booleanValue() == false) goto L24;
        return 1.0d;
    L24:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L21:
        throw new IllegalArgumentException();
    }

    @JvmStatic
    public static final String v(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        String r101 = cq.b.a(r100);
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101;
    }

    @JvmStatic
    public static final Object a(Object r100, Object r101) {
        if ((r100 instanceof Number) == false) goto L15;
        if ((r101 instanceof Number) == false) goto L8;
        return Double.valueOf(((Number) r100).doubleValue() + ((Number) r101).doubleValue());
    L8:
        if ((r101 instanceof String) == true) goto L32;
        if (r101 != null) goto L13;
        return (Serializable) r100;
    L13:
        return Intrinsics.stringPlus(cq.b.a(r100), v(r101));
    L32:
        return Intrinsics.stringPlus(cq.b.a(r100), r101);
    L15:
        if ((r100 instanceof String) == true) goto L17;
        if (r100 != null) goto L30;
        if ((r101 instanceof String) == true) goto L34;
        if (r101 != null) goto L25;
        return 0;
    L25:
        if ((r101 instanceof Number) == false) goto L28;
        return (Serializable) r101;
    L28:
        return "null".concat(v(r101));
    L34:
        return Intrinsics.stringPlus((String) r100, r101);
    L30:
        return v(r100).concat(v(r101));
    L17:
        return ((String) r100) + v(r101);
    }

    @JvmStatic
    public static final long b(Object r100, Object r101) {
        long r102 = 0;
        long r103 = (long) u(r100);
    L13:
        r102 = (long) u(r101);
    L9:
        return r103 & r102;
    L5:
        r103 = 0;
        goto L13
    }

    @JvmStatic
    public static final long d(Object r100, Object r101) {
        long r102 = 0;
        long r103 = (long) u(r100);
    L13:
        r102 = (long) u(r101);
    L9:
        return r103 | r102;
    L5:
        r103 = 0;
        goto L13
    }

    @JvmStatic
    public static final long e(Object r100, Object r101) {
        long r102 = 0;
        long r103 = (long) u(r100);
    L13:
        r102 = (long) u(r101);
    L9:
        return r103 ^ r102;
    L5:
        r103 = 0;
        goto L13
    }

    @JvmStatic
    public static final Object f(Object r100, Object r101) {
        double r102 = u(r100);     // Catch: Throwable -> L15
        double r103 = u(r101);     // Catch: Throwable -> L15
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        double r104 = r102 / r103;     // Catch: Throwable -> L15
    L13:
        return Double.valueOf(r104);
    L7:
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        r104 = Double.NaN;
        goto L13
    L10:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        r104 = Double.POSITIVE_INFINITY;
        goto L13
    L12:
        r104 = Double.NEGATIVE_INFINITY;
    L16:
        return Double.valueOf(Double.NaN);
    }

    @JvmStatic
    public static final boolean g(Object r100, Object r101) {
        if ((r100 instanceof String) == false) goto L12;
        if ((r101 instanceof String) == false) goto L12;
        if (((String) r100).compareTo((String) r101) > 0) goto L16;
        return false;
    L16:
        return true;
    L12:
        if (u(r100) > u(r101)) goto L17;
        return false;
    L17:
        return true;
    }

    @JvmStatic
    public static final boolean h(Object r100, Object r101) {
        if ((r100 instanceof String) == false) goto L12;
        if ((r101 instanceof String) == false) goto L12;
        if (((String) r100).compareTo((String) r101) < 0) goto L16;
        return false;
    L16:
        return true;
    L12:
        if (u(r100) < u(r101)) goto L17;
        return false;
    L17:
        return true;
    }

    @JvmStatic
    public static final boolean i(Object r100, Object r101) {
        boolean r102 = m(r100);     // Catch: Throwable -> L24
        boolean r103 = m(r101);     // Catch: Throwable -> L24
        if (r102 == false) goto L23;
        if (r103 == false) goto L23;
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if ((r100 instanceof String) == false) goto L17;
        if ((r101 instanceof String) == false) goto L17;
        return r100.equals(r101);
    L17:
        if (u(r100) != u(r101)) goto L26;
        return true;
    L26:
        return false;
    L21:
        return Intrinsics.areEqual(r100, r101);
    L23:
        return Intrinsics.areEqual(r100, r101);
    L24:
        return false;
    }

    @JvmStatic
    public static final boolean j(Object r100, Object r101) {
        boolean r102 = m(r100);     // Catch: Throwable -> L10
        boolean r103 = m(r101);     // Catch: Throwable -> L10
        if (r102 == false) goto L9;
        if (r103 == false) goto L9;
        return g(r100, r101);
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean k(Object r100, Object r101) {
        boolean r102 = m(r100);     // Catch: Throwable -> L11
        boolean r103 = m(r101);     // Catch: Throwable -> L11
        if (r102 == false) goto L10;
        if (r103 == false) goto L10;
        return !h(r100, r101);
    L10:
        return false;
    }

    @JvmStatic
    public static final Object l(Object r100, Object r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = -1;
        if ((r100 instanceof Collection) == false) goto L18;
        if (r101 == null) goto L16;
        if ((r101 instanceof Number) == false) goto L13;
        r102 = ((Number) r101).intValue();     // Catch: Throwable -> L43
    L45:
        goto L16
    L13:
        if ((r101 instanceof String) == false) goto L45;
        r102 = CastIntegerProtector.parseInt((String) r101);     // Catch: Throwable -> L43
    L16:
        return CollectionsKt.elementAtOrNull((Iterable) r100, r102);
    L18:
        if ((r100 instanceof Map) == false) goto L22;
        return ((Map) r100).get(r101);
    L22:
        if ((r100 instanceof String) == false) goto L31;
        if ((r101 instanceof Number) == false) goto L26;
        r102 = ((Number) r101).intValue();
    L26:
        Character r103 = StringsKt.getOrNull((CharSequence) r100, r102);
        if (r103 != null) goto L29;
        return null;
    L29:
        return String.valueOf(r103.charValue());
    L31:
        if ((r100 instanceof Object[]) == false) goto L42;
        if (r101 == null) goto L41;
        if ((r101 instanceof Number) == false) goto L38;
        r102 = ((Number) r101).intValue();     // Catch: Throwable -> L44
    L48:
        goto L41
    L38:
        if ((r101 instanceof String) == false) goto L48;
        r102 = CastIntegerProtector.parseInt((String) r101);     // Catch: Throwable -> L44
    L41:
        return ArraysKt.getOrNull((Object[]) r100, r102);
    L42:
        return null;
    }

    @JvmStatic
    public static final boolean n(Object r100, Object r101) {
        boolean r102 = m(r100);     // Catch: Throwable -> L10
        boolean r103 = m(r101);     // Catch: Throwable -> L10
        if (r102 == false) goto L9;
        if (r103 == false) goto L9;
        return h(r100, r101);
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean o(Object r100, Object r101) {
        boolean r102 = m(r100);     // Catch: Throwable -> L11
        boolean r103 = m(r101);     // Catch: Throwable -> L11
        if (r102 == false) goto L10;
        if (r103 == false) goto L10;
        return !g(r100, r101);
    L10:
        return false;
    }

    @JvmStatic
    public static final Object p(Object r100, Object r101) {
        double r102 = u(r100);     // Catch: Throwable -> L9
        double r103 = u(r101);     // Catch: Throwable -> L9
        if (r103 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        return Double.valueOf(Double.NaN);
    L8:
        return Double.valueOf(r102 % r103);
    L10:
        return Double.valueOf(Double.NaN);
    }

    @JvmStatic
    public static final Object q(Object r100, Object r101) {
        double r102 = u(r100) * u(r101);
    L6:
        return Double.valueOf(r102);
    L4:
        r102 = Double.NaN;
        goto L6
    }

    @JvmStatic
    public static final Object s(Object r100, Object r101) {
        double r102 = Math.pow(u(r100), u(r101));     // Catch: Throwable -> L4
    L6:
        return Double.valueOf(r102);
    L4:
        r102 = Double.NaN;
        goto L6
    }

    @JvmStatic
    public static final double t(Object r100, Object r101) {
        return u(r100) - u(r101);
    L4:
        return Double.NaN;
    }
}
