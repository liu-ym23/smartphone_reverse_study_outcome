package androidx.datastore.preferences.protobuf;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.text.TextUtils;
import android.window.BackEvent;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.device.OaidResolver;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.builders.ListBuilder;
import kotlin.time.DurationUnit;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b1 implements f5.g {
    public static volatile b6.f h = null;

    /* renamed from: i, reason: collision with root package name */
    public static com.google.android.material.button.a f1786i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f1787j = "";

    /* renamed from: k, reason: collision with root package name */
    public static String f1788k = "";

    /* renamed from: l, reason: collision with root package name */
    public static String f1789l = "";

    /* renamed from: m, reason: collision with root package name */
    public static String f1790m = "";

    /* renamed from: n, reason: collision with root package name */
    public static String f1791n = "";

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1792g;

    public /* synthetic */ b1(int i10) {
        this.f1792g = i10;
    }

    public static final long A(long j10) {
        long j11 = (j10 << 1) + 1;
        int i10 = hc.a.f9403d;
        int i11 = hc.b.f9405a;
        return j11;
    }

    public static final long B(long j10) {
        return (-4611686018426L > j10 || j10 >= 4611686018427L) ? A(dc.h.b0(j10, -4611686018427387903L, 4611686018427387903L)) : C(j10 * 1000000);
    }

    public static final long C(long j10) {
        long j11 = j10 << 1;
        int i10 = hc.a.f9403d;
        int i11 = hc.b.f9405a;
        return j11;
    }

    public static final boolean E(char c9, char c10, boolean z) {
        if (c9 == c10) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c9);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String F(ByteString byteString) {
        StringBuilder sb2 = new StringBuilder(byteString.size());
        for (int i10 = 0; i10 < byteString.size(); i10++) {
            byte bA = byteString.a(i10);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bA);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static void G(Object obj, Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static void H(byte[] bArr) {
        int length = bArr.length;
        kotlin.jvm.internal.g.f(bArr, "<this>");
        Arrays.fill(bArr, 0, length, (byte) 0);
    }

    public static void I(long[] jArr) {
        int length = jArr.length;
        kotlin.jvm.internal.g.f(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static long K(BackEvent backEvent) {
        kotlin.jvm.internal.g.f(backEvent, "backEvent");
        return backEvent.getFrameTimeMillis();
    }

    public static Drawable L(int i10, Context context) {
        return androidx.appcompat.widget.n0.b().c(i10, context);
    }

    public static String M() {
        com.google.android.material.button.a aVar = f1786i;
        if (aVar != null) {
            String str = OaidResolver.INSTANCE.get((Application) aVar.f4761g);
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static boolean N(char c9) {
        return Character.isWhitespace(c9) || Character.isSpaceChar(c9);
    }

    public static final kotlin.jvm.internal.a O(Object[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        return new kotlin.jvm.internal.a(array);
    }

    public static List P(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.g.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static void Q(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap(8);
        map.put("en", str);
        map.put("ti", str3);
        if (TextUtils.isEmpty(str5)) {
            str5 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        map.put("ts", str5);
        map.put("pn", str2);
        map.put("pv", "5.0.7");
        map.put("nm", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("si", str4);
        map.put("di", "");
        try {
            String string = new JSONObject(map).toString();
            Intent intent = new Intent();
            intent.setPackage("com.stepos.pushservice");
            intent.setAction("com.stepos.cloud.pushservice.action.PUSH_TRACKER_SERVICE");
            intent.putExtra("extra_push_tracker", string);
            context.startService(intent);
            s7.a.a("UsageStatsUtils", "startTrackerService success" + string);
        } catch (Exception e10) {
            s7.a.c("UsageStatsUtils", "startTrackerService error " + e10.getMessage());
        }
    }

    public static BigDecimal R(String str) {
        k(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(str));
    }

    public static final long S(String str) {
        int length = str.length();
        int i10 = (length <= 0 || !gc.q.m0("+-", str.charAt(0))) ? 0 : 1;
        if (length - i10 > 16) {
            Iterable eVar = new dc.e(i10, gc.q.n0(str), 1);
            if (!(eVar instanceof Collection) || !((Collection) eVar).isEmpty()) {
                Iterator<Integer> it = eVar.iterator();
                while (((dc.d) it).f8456c) {
                    char cCharAt = str.charAt(((mb.t) it).nextInt());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return gc.o.k0(str, "+", false) ? Long.parseLong(gc.r.Q0(1, str)) : Long.parseLong(str);
    }

    public static d5.o T(k5.a aVar) {
        Strictness strictness = aVar.f9921b;
        if (strictness == Strictness.f5435b) {
            aVar.f9921b = Strictness.f5434a;
        }
        try {
            try {
                return a4.a.r(aVar);
            } catch (OutOfMemoryError e10) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e11);
            }
        } finally {
            aVar.U0(strictness);
        }
    }

    public static d5.o U(String str) {
        try {
            k5.a aVar = new k5.a(new StringReader(str));
            d5.o oVarT = T(aVar);
            oVarT.getClass();
            if (!(oVarT instanceof d5.p) && aVar.R0() != JsonToken.f5479m) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return oVarT;
        } catch (MalformedJsonException e10) {
            throw new JsonSyntaxException(e10);
        } catch (IOException e11) {
            throw new JsonIOException(e11);
        } catch (NumberFormatException e12) {
            throw new JsonSyntaxException(e12);
        }
    }

    public static void V(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        kotlin.jvm.internal.g.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static final long W(long j10, DurationUnit unit) {
        kotlin.jvm.internal.g.f(unit, "unit");
        DurationUnit durationUnit = DurationUnit.f10099b;
        long j11 = a4.a.j(4611686018426999999L, durationUnit, unit);
        if ((-j11) <= j10 && j10 <= j11) {
            return C(a4.a.j(j10, unit, durationUnit));
        }
        DurationUnit targetUnit = DurationUnit.f10100c;
        kotlin.jvm.internal.g.f(targetUnit, "targetUnit");
        return A(dc.h.b0(targetUnit.f10105a.convert(j10, unit.f10105a), -4611686018427387903L, 4611686018427387903L));
    }

    public static final lb.g X(String str) {
        int i10;
        l(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.g.g(cCharAt, 48) < 0) {
            i10 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i10 = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i11, iDivideUnsigned) > 0) {
                if (iDivideUnsigned != 119304647) {
                    return null;
                }
                iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                if (Integer.compareUnsigned(i11, iDivideUnsigned) > 0) {
                    return null;
                }
            }
            int i12 = i11 * 10;
            int i13 = iDigit + i12;
            if (Integer.compareUnsigned(i13, i12) < 0) {
                return null;
            }
            i10++;
            i11 = i13;
        }
        return new lb.g(i11);
    }

    public static final lb.i Y(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        l(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.g.g(cCharAt, 48) < 0) {
            i10 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j10 = 10;
        long j11 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i10 < length) {
            int iDigit = Character.digit((int) str.charAt(i10), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j11, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, j10);
                if (Long.compareUnsigned(j11, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j12 = j11 * j10;
            long j13 = (iDigit & 4294967295L) + j12;
            if (Long.compareUnsigned(j13, j12) < 0) {
                return null;
            }
            i10++;
            j11 = j13;
        }
        return new lb.i(j11);
    }

    public static byte[] a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    public static final void b(int i10, String str) {
        if (str.charAt(i10) == '-') {
            return;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Expected '-' (hyphen) at index ", ", but was '");
        sbK.append(str.charAt(i10));
        sbK.append('\'');
        throw new IllegalArgumentException(sbK.toString().toString());
    }

    public static final void d(long j10, byte[] bArr, int i10, int i11) {
        int i12 = (i11 * 2) + i10;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = gc.d.f9120a[(int) (255 & j10)];
            bArr[i12 - 1] = (byte) i14;
            i12 -= 2;
            bArr[i12] = (byte) (i14 >> 8);
            j10 >>= 8;
        }
    }

    public static final long e(String str) throws NumberFormatException {
        DurationUnit durationUnit;
        long jB;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i10 = hc.a.f9403d;
        char cCharAt2 = str.charAt(0);
        int i11 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z = i11 > 0 && str.length() > 0 && E(str.charAt(0), '-', false);
        if (length <= i11) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i11) != 'P') {
            throw new IllegalArgumentException();
        }
        int i12 = i11 + 1;
        if (i12 == length) {
            throw new IllegalArgumentException();
        }
        DurationUnit durationUnit2 = null;
        long jE = 0;
        boolean z3 = false;
        while (i12 < length) {
            if (str.charAt(i12) != 'T') {
                int i13 = i12;
                while (i13 < str.length() && (('0' <= (cCharAt = str.charAt(i13)) && cCharAt < ':') || gc.q.m0("+-.", cCharAt))) {
                    i13++;
                }
                String strSubstring = str.substring(i12, i13);
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i12;
                if (length2 < 0 || length2 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                int i14 = length2 + 1;
                if (z3) {
                    if (cCharAt3 == 'H') {
                        durationUnit = DurationUnit.h;
                    } else if (cCharAt3 == 'M') {
                        durationUnit = DurationUnit.f10102e;
                    } else {
                        if (cCharAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                        }
                        durationUnit = DurationUnit.f10101d;
                    }
                } else {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    durationUnit = DurationUnit.f10103j;
                }
                if (durationUnit2 != null && durationUnit2.compareTo(durationUnit) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iQ0 = gc.q.q0(strSubstring, '.', 0, 6);
                if (durationUnit != DurationUnit.f10101d || iQ0 <= 0) {
                    jE = hc.a.e(jE, W(S(strSubstring), durationUnit));
                } else {
                    String strSubstring2 = strSubstring.substring(0, iQ0);
                    kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
                    long jE2 = hc.a.e(jE, W(S(strSubstring2), durationUnit));
                    String strSubstring3 = strSubstring.substring(iQ0);
                    kotlin.jvm.internal.g.e(strSubstring3, "substring(...)");
                    double d8 = Double.parseDouble(strSubstring3);
                    double dI = a4.a.i(d8, durationUnit, DurationUnit.f10099b);
                    if (Double.isNaN(dI)) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.");
                    }
                    if (Double.isNaN(dI)) {
                        throw new IllegalArgumentException("Cannot round NaN value.");
                    }
                    long jRound = Math.round(dI);
                    if (-4611686018426999999L > jRound || jRound >= 4611686018427000000L) {
                        double dI2 = a4.a.i(d8, durationUnit, DurationUnit.f10100c);
                        if (Double.isNaN(dI2)) {
                            throw new IllegalArgumentException("Cannot round NaN value.");
                        }
                        jB = B(Math.round(dI2));
                    } else {
                        jB = C(jRound);
                    }
                    jE = hc.a.e(jE2, jB);
                }
                durationUnit2 = durationUnit;
                i12 = i14;
            } else {
                if (z3 || (i12 = i12 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                z3 = true;
            }
        }
        if (!z) {
            return jE;
        }
        long j10 = ((-(jE >> 1)) << 1) + (((int) jE) & 1);
        int i15 = hc.b.f9405a;
        return j10;
    }

    public static void f(StringBuilder sb2, Object obj, zb.l lVar) {
        if (lVar != null) {
            sb2.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb2.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb2.append(((Character) obj).charValue());
        } else {
            sb2.append((CharSequence) obj.toString());
        }
    }

    public static List g(Object[] objArr) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.g.e(listAsList, "asList(...)");
        return listAsList;
    }

    public static ListBuilder i(ListBuilder listBuilder) {
        listBuilder.g();
        listBuilder.f10012c = true;
        return listBuilder.f10011b > 0 ? listBuilder : ListBuilder.f10009d;
    }

    public static void j(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void k(String str) {
        if (str.length() <= 10000) {
            return;
        }
        throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
    }

    public static void l(int i10) {
        if (2 > i10 || i10 >= 37) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "radix ", " was not in valid range ");
            sbK.append(new dc.e(2, 36, 1));
            throw new IllegalArgumentException(sbK.toString());
        }
    }

    public static boolean m(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                Object obj2 = objArr2[i10];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!m((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof lb.f) && (obj2 instanceof lb.f)) {
                            if (!Arrays.equals(((lb.f) obj).f10397a, ((lb.f) obj2).f10397a)) {
                            }
                        } else if ((obj instanceof lb.m) && (obj2 instanceof lb.m)) {
                            if (!Arrays.equals(((lb.m) obj).f10410a, ((lb.m) obj2).f10410a)) {
                            }
                        } else if ((obj instanceof lb.h) && (obj2 instanceof lb.h)) {
                            if (!Arrays.equals(((lb.h) obj).f10401a, ((lb.h) obj2).f10401a)) {
                            }
                        } else if ((obj instanceof lb.j) && (obj2 instanceof lb.j)) {
                            if (!Arrays.equals(((lb.j) obj).f10405a, ((lb.j) obj2).f10405a)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void n(int i10, int i11, int i12, byte[] bArr, byte[] destination) {
        kotlin.jvm.internal.g.f(bArr, "<this>");
        kotlin.jvm.internal.g.f(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
    }

    public static void o(int i10, int i11, int[] iArr, int[] destination, int i12) {
        kotlin.jvm.internal.g.f(iArr, "<this>");
        kotlin.jvm.internal.g.f(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
    }

    public static void p(long[] jArr, long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.g.f(jArr, "<this>");
        kotlin.jvm.internal.g.f(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
    }

    public static void q(Object[] objArr, Object[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        kotlin.jvm.internal.g.f(destination, "destination");
        System.arraycopy(objArr, i11, destination, i10, i12 - i11);
    }

    public static /* synthetic */ void r(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = iArr.length;
        }
        o(i10, 0, iArr, iArr2, i11);
    }

    public static /* synthetic */ void s(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        n(i10, i11, i12, bArr, bArr2);
    }

    public static /* synthetic */ void t(Object[] objArr, Object[] objArr2, int i10, int i11, int i12) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = objArr.length;
        }
        q(objArr, objArr2, 0, i10, i11);
    }

    public static byte[] u(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.g.f(bArr, "<this>");
        x(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.g.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] v(Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        x(i11, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        kotlin.jvm.internal.g.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static short[] w(short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.g.f(sArr, "<this>");
        x(i11, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
        kotlin.jvm.internal.g.e(sArrCopyOfRange, "copyOfRange(...)");
        return sArrCopyOfRange;
    }

    public static final void x(int i10, int i11) {
        if (i10 > i11) {
            throw new IndexOutOfBoundsException(com.stepos.core.ota.d.e(i10, "toIndex (", i11, ") is greater than size (", ")."));
        }
    }

    public static ListBuilder y() {
        return new ListBuilder(10);
    }

    public void D() {
        Trace.endSection();
    }

    @Override // f5.g
    public Object c() {
        switch (this.f1792g) {
            case 9:
                return new LinkedHashSet();
            case 10:
                return new ArrayList();
            case 11:
                return new ConcurrentHashMap();
            default:
                return new LinkedHashMap();
        }
    }

    public void h(String label) {
        kotlin.jvm.internal.g.f(label, "label");
        Trace.beginSection(c2.a.a(label));
    }

    public long z() {
        return System.currentTimeMillis();
    }
}
