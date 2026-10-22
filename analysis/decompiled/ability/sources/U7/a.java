package U7;

import D7.D;
import D7.E;
import D7.v;
import G8.f;
import H7.c;
import H7.h;
import S7.n;
import V9.g;
import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.F;
import X8.K;
import X8.N;
import X8.S;
import X8.U;
import X8.w;
import a.AbstractC0291a;
import a7.AbstractC0305a;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material3.DatePickerDefaults;
import androidx.core.os.EnvironmentCompat;
import com.google.android.material.datepicker.O;
import com.volcengine.tos.TosClientException;
import e8.i;
import e8.o;
import h7.C1491a;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.d0;
import i8.InterfaceC1561g;
import i9.j;
import j9.AbstractC1607a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import k8.AbstractC1629B;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.json.JSONException;
import org.json.JSONObject;
import p8.b;
import q8.AbstractC1841n;
import x.d;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final X0.a f1277a = new X0.a();
    public static String b;
    public static String c;

    public static String A(long j5, Locale locale) {
        return O.b("MMMd", locale).format(new Date(j5));
    }

    public static final w B(InterfaceC1507O interfaceC1507O) {
        Object obj;
        List upperBounds = interfaceC1507O.getUpperBounds();
        k.e(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        List upperBounds2 = interfaceC1507O.getUpperBounds();
        k.e(upperBounds2, "getUpperBounds(...)");
        Iterator it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC1524g interfaceC1524gD = ((w) next).Q().d();
            InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            if (interfaceC1522e != null && interfaceC1522e.getKind() != ClassKind.b && interfaceC1522e.getKind() != ClassKind.e) {
                obj = next;
                break;
            }
        }
        w wVar = (w) obj;
        if (wVar != null) {
            return wVar;
        }
        List upperBounds3 = interfaceC1507O.getUpperBounds();
        k.e(upperBounds3, "getUpperBounds(...)");
        Object objA0 = v.A0(upperBounds3);
        k.e(objA0, "first(...)");
        return (w) objA0;
    }

    public static String C(long j5, Locale locale) {
        return O.b(DatePickerDefaults.YearAbbrMonthDaySkeleton, locale).format(new Date(j5));
    }

    public static void D(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 64; i++) {
            jArr[i] = E(jArr2, jArr2[i]);
        }
    }

    public static long E(long[] jArr, long j5) {
        int i = 0;
        long j6 = 0;
        while (j5 != 0) {
            if ((j5 & 1) == 1) {
                j6 ^= jArr[i];
            }
            j5 >>>= 1;
            i++;
        }
        return j6;
    }

    public static final boolean F(InterfaceC1507O typeParameter, K k, Set set) {
        k.f(typeParameter, "typeParameter");
        List upperBounds = typeParameter.getUpperBounds();
        k.e(upperBounds, "getUpperBounds(...)");
        List<w> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (w wVar : list) {
            k.c(wVar);
            if (t(wVar, typeParameter.g().Q(), set) && (k == null || k.b(wVar.Q(), k))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean G(InterfaceC1507O interfaceC1507O, K k, int i) {
        if ((i & 2) != 0) {
            k = null;
        }
        return F(interfaceC1507O, k, null);
    }

    public static void H(Context context) throws NoSuchAlgorithmException {
        String string;
        String string2;
        Context applicationContext = context.getApplicationContext();
        k.c(applicationContext);
        try {
            string = Settings.Global.getString(applicationContext.getContentResolver(), "com.zyql.ability.DEVICE_ID");
        } catch (Exception e) {
            Log.e("GlobalDeviceIdUtils", "Failed to read global device id.", e);
            string = null;
        }
        if (string != null && string.length() > 0) {
            b = string;
            C1491a.a("DeviceIdManager", "Loaded DeviceId from Global Settings: ".concat(string));
            String str = b;
            k.c(str);
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("sdk_device_id_pref", 0);
            k.e(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("local_device_id", str);
            editorEdit.apply();
        }
        String string3 = applicationContext.getSharedPreferences("sdk_device_id_pref", 0).getString("local_device_id", null);
        b = string3;
        if (string3 == null) {
            String string4 = Settings.Secure.getString(applicationContext.getContentResolver(), "android_id");
            if (string4 == null || string4.length() == 0 || string4.equals("9774d56d682e549c")) {
                string2 = UUID.randomUUID().toString();
                k.c(string2);
            } else {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] bytes = string4.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                byte[] bArrDigest = messageDigest.digest(bytes);
                k.c(bArrDigest);
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "");
                int i = 0;
                for (byte b5 : bArrDigest) {
                    i++;
                    if (i > 1) {
                        sb.append((CharSequence) "");
                    }
                    sb.append((CharSequence) String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b5)}, 1)));
                }
                sb.append((CharSequence) "");
                string2 = sb.toString();
            }
            b = string2;
            C1491a.b("DeviceIdManager", "Generated TEMPORARY local deviceId: " + string2 + ". Will sync with Service later.");
            String str2 = b;
            k.c(str2);
            SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("sdk_device_id_pref", 0);
            k.e(sharedPreferences2, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
            editorEdit2.putString("local_device_id", str2);
            editorEdit2.apply();
        }
    }

    public static c I(c cVar) {
        c<Object> cVarIntercepted;
        k.f(cVar, "<this>");
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return (continuationImpl == null || (cVarIntercepted = continuationImpl.intercepted()) == null) ? cVar : cVarIntercepted;
    }

    public static final boolean J(g isProbablyUtf8) {
        g gVar;
        int i;
        k.f(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            gVar = new g();
            long j5 = isProbablyUtf8.b;
            long j6 = 64;
            if (j5 <= 64) {
                j6 = j5;
            }
            isProbablyUtf8.k(gVar, 0L, j6);
        } catch (EOFException unused) {
        }
        for (i = 0; i < 16; i++) {
            if (gVar.n()) {
                return true;
            }
            int iH = gVar.H();
            if (Character.isISOControl(iH) && !Character.isWhitespace(iH)) {
                return false;
            }
        }
        return true;
    }

    public static j K(n nVar) {
        j jVar = new j();
        jVar.d = u(jVar, jVar, nVar);
        return jVar;
    }

    public static final void L(String message, Throwable th) {
        k.f(message, "message");
        N9.j.G(message + "\n" + Log.getStackTraceString(th), "RobotTrace");
    }

    public static String M(long j5) {
        if (j5 == 0) {
            return "0";
        }
        if (j5 > 0) {
            return Long.toString(j5, 10);
        }
        char[] cArr = new char[64];
        long j6 = (j5 >>> 1) / 5;
        long j10 = 10;
        int i = 63;
        cArr[63] = Character.forDigit((int) (j5 - (j6 * j10)), 10);
        while (j6 > 0) {
            i--;
            cArr[i] = Character.forDigit((int) (j6 % j10), 10);
            j6 /= j10;
        }
        return new String(cArr, i, 64 - i);
    }

    public static final U N(w wVar) {
        k.f(wVar, "<this>");
        U uG = S.g(wVar, true);
        k.e(uG, "makeNullable(...)");
        return uG;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object O(X8.w r21, z8.t r22, S7.o r23) {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U7.a.O(X8.w, z8.t, S7.o):java.lang.Object");
    }

    public static final void P(b bVar, p8.a from, InterfaceC1494B scopeOwner, f name) {
        k.f(bVar, "<this>");
        k.f(from, "from");
        k.f(scopeOwner, "scopeOwner");
        k.f(name, "name");
        ((AbstractC1629B) scopeOwner).e.b();
        k.e(name.b(), "asString(...)");
    }

    public static final w Q(w wVar, InterfaceC1561g interfaceC1561g) {
        return (wVar.getAnnotations().isEmpty() && interfaceC1561g.isEmpty()) ? wVar : wVar.Z().m0(AbstractC0272c.s(wVar.M(), interfaceC1561g));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [X8.U] */
    public static final U R(w wVar) {
        A aR;
        k.f(wVar, "<this>");
        U uZ = wVar.Z();
        if (uZ instanceof AbstractC0285p) {
            AbstractC0285p abstractC0285p = (AbstractC0285p) uZ;
            A aR2 = abstractC0285p.b;
            if (!aR2.Q().getParameters().isEmpty() && aR2.Q().d() != null) {
                List parameters = aR2.Q().getParameters();
                k.e(parameters, "getParameters(...)");
                List list = parameters;
                ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new F((InterfaceC1507O) it.next()));
                }
                aR2 = AbstractC0272c.r(aR2, arrayList, null, 2);
            }
            A aR3 = abstractC0285p.c;
            if (!aR3.Q().getParameters().isEmpty() && aR3.Q().d() != null) {
                List parameters2 = aR3.Q().getParameters();
                k.e(parameters2, "getParameters(...)");
                List list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(D7.w.c0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new F((InterfaceC1507O) it2.next()));
                }
                aR3 = AbstractC0272c.r(aR3, arrayList2, null, 2);
            }
            aR = AbstractC0272c.f(aR2, aR3);
        } else {
            if (!(uZ instanceof A)) {
                throw new NoWhenBranchMatchedException();
            }
            A a3 = (A) uZ;
            boolean zIsEmpty = a3.Q().getParameters().isEmpty();
            aR = a3;
            if (!zIsEmpty) {
                InterfaceC1524g interfaceC1524gD = a3.Q().d();
                aR = a3;
                if (interfaceC1524gD != null) {
                    List parameters3 = a3.Q().getParameters();
                    k.e(parameters3, "getParameters(...)");
                    List list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(D7.w.c0(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new F((InterfaceC1507O) it3.next()));
                    }
                    aR = AbstractC0272c.r(a3, arrayList3, null, 2);
                }
            }
        }
        return AbstractC0272c.i(aR, uZ);
    }

    public static final boolean S(w wVar) {
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD != null && ((J8.g.b(interfaceC1524gD) && J8.g.f(interfaceC1524gD) && !kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g((InterfaceC1522e) interfaceC1524gD).equals(o.h)) || J8.g.h(wVar))) {
            return true;
        }
        InterfaceC1524g interfaceC1524gD2 = wVar.Q().d();
        InterfaceC1507O interfaceC1507O = interfaceC1524gD2 instanceof InterfaceC1507O ? (InterfaceC1507O) interfaceC1524gD2 : null;
        return interfaceC1507O != null && S(B(interfaceC1507O));
    }

    public static int T(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static int U(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    public static long V(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    public static final Pair W(String str) {
        return new Pair("sessionId", str);
    }

    public static final C1531n X(d0 d0Var) {
        k.f(d0Var, "<this>");
        C1531n c1531n = (C1531n) AbstractC1841n.d.get(d0Var);
        return c1531n == null ? AbstractC1532o.f(d0Var) : c1531n;
    }

    public static final Class Y(ClassLoader classLoader, String fqName) {
        k.f(fqName, "fqName");
        try {
            return Class.forName(fqName, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static long Z(String str) {
        if (AbstractC0291a.x(str)) {
            return 0L;
        }
        int i = AbstractC0305a.c[10] - 1;
        long j5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            int iDigit = Character.digit(str.charAt(i6), 10);
            if (iDigit == -1) {
                throw new TosClientException("not found digit in unsigned long: ".concat(str), null);
            }
            if (i6 > i) {
                if (j5 >= 0) {
                    long j6 = AbstractC0305a.f1647a[10];
                    if (j5 >= j6 && (j5 > j6 || iDigit > AbstractC0305a.b[10])) {
                    }
                }
                throw new TosClientException("too large for unsigned long: ".concat(str), null);
            }
            j5 = (j5 * 10) + iDigit;
        }
        return j5;
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void a0(Context context, String str) {
        if (str.length() <= 0 || str.equals(b)) {
            return;
        }
        C1491a.b("DeviceIdManager", "Right! Update local ID from Service. Old: " + b + ", New: " + str);
        b = str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("sdk_device_id_pref", 0);
        k.e(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("local_device_id", str);
        editorEdit.apply();
    }

    public static void b(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static Object b0(n nVar, Object obj, c cVar) {
        k.f(nVar, "<this>");
        h context = cVar.getContext();
        Object intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.f4908a ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(cVar) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(context, cVar);
        p.e(2, nVar);
        return nVar.invoke(obj, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
    }

    public static Float c(HashMap map) {
        float fFloatValue = 0.0f;
        for (Float f : map.values()) {
            if (f != null) {
                fFloatValue = f.floatValue() + fFloatValue;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    public static Long d(HashMap map, String str) {
        if (map == null) {
            return -1L;
        }
        Long l = (Long) map.get(str);
        long jValueOf = l != null ? Long.valueOf(l.longValue() + 1) : 1L;
        map.put(str, jValueOf);
        return jValueOf;
    }

    public static String e(String[] strArr) {
        StringBuilder sb = new StringBuilder(400);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static JSONObject f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        k(jSONObject2, jSONObject);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("oaid");
            d dVar = x.f.f6862a;
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("id", null) : null;
            if (TextUtils.isEmpty(strOptString)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strOptString);
            return jSONObject2;
        } catch (Exception e) {
            w.h.b(e);
            return jSONObject2;
        }
    }

    public static void g(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                w.h.b(th);
            }
        }
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void i(Exception exc, String str, Object... objArr) {
        String str2 = String.format(str, objArr) + '\n' + Log.getStackTraceString(exc);
        Object[] objArr2 = new Object[0];
        if (AbstractC0291a.f1622a) {
            String str3 = String.format(str2, objArr2);
            if (str3.length() < 4000) {
                Log.d("ApmInsight:memory", str3);
                return;
            }
            for (String str4 : str3.split("\n", -1)) {
                Log.d("ApmInsight:memory", str4);
            }
        }
    }

    public static void j(String str, Object... objArr) {
        if (AbstractC0291a.f1622a) {
            String str2 = String.format(str, objArr);
            if (str2.length() < 4000) {
                Log.d("ApmInsight:memory", str2);
                return;
            }
            for (String str3 : str2.split("\n", -1)) {
                Log.d("ApmInsight:memory", str3);
            }
        }
    }

    public static void k(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            w.h.b(e);
        }
    }

    public static boolean l(String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str) || EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z10 = true;
                break;
            }
            if (str.charAt(i) != '0') {
                break;
            }
            i++;
        }
        return !z10;
    }

    public static boolean m(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public static byte[] n(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            throw new Error("HttpClient requires ASCII support");
        }
    }

    public static void o(String str, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < length; i += 2) {
            try {
                jSONObject.put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.i(str, e(new String[]{jSONObject.toString()}));
    }

    public static final F p(w wVar) {
        k.f(wVar, "<this>");
        return new F(wVar);
    }

    public static boolean q(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static long r(long j5, long j6, long j10) {
        if (j10 == 0) {
            return j5;
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j11 = 1;
        for (int i = 1; i < 64; i++) {
            jArr2[i] = j11;
            j11 <<= 1;
        }
        D(jArr, jArr2);
        D(jArr2, jArr);
        long j12 = j10;
        do {
            D(jArr, jArr2);
            if ((j12 & 1) == 1) {
                j5 = E(jArr, j5);
            }
            long j13 = j12 >>> 1;
            if (j13 == 0) {
                break;
            }
            D(jArr2, jArr);
            if ((j13 & 1) == 1) {
                j5 = E(jArr2, j5);
            }
            j12 >>>= 2;
        } while (j12 != 0);
        return j5 ^ j6;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String s(h8.InterfaceC1522e r3, z8.C2196h r4) {
        /*
            java.lang.String r0 = "klass"
            kotlin.jvm.internal.k.f(r3, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.k.f(r4, r0)
            h8.j r0 = r3.d()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            G8.f r1 = r3.getName()
            if (r1 == 0) goto L20
            G8.f r2 = G8.h.f692a
            boolean r2 = r1.b
            if (r2 != 0) goto L20
            goto L22
        L20:
            G8.f r1 = G8.h.c
        L22:
            java.lang.String r1 = r1.c()
            boolean r2 = r0 instanceof h8.InterfaceC1494B
            if (r2 == 0) goto L56
            h8.B r0 = (h8.InterfaceC1494B) r0
            k8.B r0 = (k8.AbstractC1629B) r0
            G8.c r3 = r0.e
            boolean r4 = r3.d()
            if (r4 == 0) goto L37
            return r1
        L37:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r3 = r3.b()
            r0 = 46
            r2 = 47
            java.lang.String r3 = j9.t.b0(r3, r0, r2)
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L56:
            boolean r2 = r0 instanceof h8.InterfaceC1522e
            if (r2 == 0) goto L5e
            r2 = r0
            h8.e r2 = (h8.InterfaceC1522e) r2
            goto L5f
        L5e:
            r2 = 0
        L5f:
            if (r2 == 0) goto L7a
            java.lang.String r3 = s(r2, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r3 = 36
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L7a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected container: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = " for "
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: U7.a.s(h8.e, z8.h):java.lang.String");
    }

    public static final boolean t(w wVar, K k, Set set) {
        boolean zT;
        if (k.b(wVar.Q(), k)) {
            return true;
        }
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        InterfaceC1525h interfaceC1525h = interfaceC1524gD instanceof InterfaceC1525h ? (InterfaceC1525h) interfaceC1524gD : null;
        List listH = interfaceC1525h != null ? interfaceC1525h.h() : null;
        Iterable iterableL1 = v.l1(wVar.L());
        if (!(iterableL1 instanceof Collection) || !((Collection) iterableL1).isEmpty()) {
            Iterator it = iterableL1.iterator();
            do {
                E e = (E) it;
                if (e.b.hasNext()) {
                    D d = (D) e.next();
                    int i = d.f393a;
                    N n = (N) d.b;
                    InterfaceC1507O interfaceC1507O = listH != null ? (InterfaceC1507O) v.D0(i, listH) : null;
                    if ((interfaceC1507O == null || set == null || !set.contains(interfaceC1507O)) && !n.c()) {
                        w wVarB = n.b();
                        k.e(wVarB, "getType(...)");
                        zT = t(wVarB, k, set);
                    } else {
                        zT = false;
                    }
                }
            } while (!zT);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c u(final c cVar, final c cVar2, final n nVar) {
        k.f(nVar, "<this>");
        if (nVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) nVar).create(cVar, cVar2);
        }
        final h context = cVar2.getContext();
        return context == EmptyCoroutineContext.f4908a ? new RestrictedContinuationImpl(cVar2) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

            /* renamed from: a, reason: collision with root package name */
            public int f4910a;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.f4910a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f4910a = 2;
                    kotlin.b.b(obj);
                    return obj;
                }
                this.f4910a = 1;
                kotlin.b.b(obj);
                n nVar2 = nVar;
                k.d(nVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                p.e(2, nVar2);
                return nVar2.invoke(cVar, this);
            }
        } : new ContinuationImpl(cVar2, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: a, reason: collision with root package name */
            public int f4911a;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.f4911a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.f4911a = 2;
                    kotlin.b.b(obj);
                    return obj;
                }
                this.f4911a = 1;
                kotlin.b.b(obj);
                n nVar2 = nVar;
                k.d(nVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                p.e(2, nVar2);
                return nVar2.invoke(cVar, this);
            }
        };
    }

    public static final F v(w type, Variance variance, InterfaceC1507O interfaceC1507O) {
        k.f(type, "type");
        if ((interfaceC1507O != null ? interfaceC1507O.r() : null) == variance) {
            variance = Variance.c;
        }
        return new F(type, variance);
    }

    public static final void w(w wVar, A a3, LinkedHashSet linkedHashSet, Set set) {
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD instanceof InterfaceC1507O) {
            if (!k.b(wVar.Q(), a3.Q())) {
                linkedHashSet.add(interfaceC1524gD);
                return;
            }
            for (w wVar2 : ((InterfaceC1507O) interfaceC1524gD).getUpperBounds()) {
                k.c(wVar2);
                w(wVar2, a3, linkedHashSet, set);
            }
            return;
        }
        InterfaceC1524g interfaceC1524gD2 = wVar.Q().d();
        InterfaceC1525h interfaceC1525h = interfaceC1524gD2 instanceof InterfaceC1525h ? (InterfaceC1525h) interfaceC1524gD2 : null;
        List listH = interfaceC1525h != null ? interfaceC1525h.h() : null;
        int i = 0;
        for (N n : wVar.L()) {
            int i6 = i + 1;
            InterfaceC1507O interfaceC1507O = listH != null ? (InterfaceC1507O) v.D0(i, listH) : null;
            if ((interfaceC1507O == null || set == null || !set.contains(interfaceC1507O)) && !n.c() && !v.u0(linkedHashSet, n.b().Q().d()) && !k.b(n.b().Q(), a3.Q())) {
                w wVarB = n.b();
                k.e(wVarB, "getType(...)");
                w(wVarB, a3, linkedHashSet, set);
            }
            i = i6;
        }
    }

    public static final i x(w wVar) {
        k.f(wVar, "<this>");
        i iVarC = wVar.Q().c();
        k.e(iVarC, "getBuiltIns(...)");
        return iVarC;
    }

    public static androidx.core.util.Pair y(Long l, Long l5) {
        if (l == null && l5 == null) {
            return androidx.core.util.Pair.create(null, null);
        }
        if (l == null) {
            return androidx.core.util.Pair.create(null, z(l5.longValue()));
        }
        if (l5 == null) {
            return androidx.core.util.Pair.create(z(l.longValue()), null);
        }
        Calendar calendarF = O.f();
        Calendar calendarG = O.g(null);
        calendarG.setTimeInMillis(l.longValue());
        Calendar calendarG2 = O.g(null);
        calendarG2.setTimeInMillis(l5.longValue());
        return calendarG.get(1) == calendarG2.get(1) ? calendarG.get(1) == calendarF.get(1) ? androidx.core.util.Pair.create(A(l.longValue(), Locale.getDefault()), A(l5.longValue(), Locale.getDefault())) : androidx.core.util.Pair.create(A(l.longValue(), Locale.getDefault()), C(l5.longValue(), Locale.getDefault())) : androidx.core.util.Pair.create(C(l.longValue(), Locale.getDefault()), C(l5.longValue(), Locale.getDefault()));
    }

    public static String z(long j5) {
        Calendar calendarF = O.f();
        Calendar calendarG = O.g(null);
        calendarG.setTimeInMillis(j5);
        return calendarF.get(1) == calendarG.get(1) ? A(j5, Locale.getDefault()) : C(j5, Locale.getDefault());
    }
}
