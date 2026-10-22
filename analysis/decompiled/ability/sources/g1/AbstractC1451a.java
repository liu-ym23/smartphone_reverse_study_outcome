package g1;

import B9.C0177d;
import B9.P;
import B9.b0;
import B9.c0;
import D2.b;
import D7.A;
import D7.v;
import H.h;
import N9.j;
import Q8.o;
import V4.l;
import Y7.f;
import Z7.d;
import Z7.t;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.core.os.EnvironmentCompat;
import b8.AbstractC0857s;
import b8.i0;
import b8.v0;
import c8.e;
import ca.AbstractC0897f;
import com.stepos.ability.App;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import e1.C1403b;
import e3.C1416e;
import e3.C1419h;
import e3.n;
import j9.AbstractC1607a;
import j9.m;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import k2.C1621a;
import kotlin.Result;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q0.AbstractC1795a;
import s2.C1912a;
import u1.c;
import z9.C2200b;
import z9.g;

/* renamed from: g1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1451a {

    /* renamed from: B, reason: collision with root package name */
    public static boolean f4465B = false;

    /* renamed from: C, reason: collision with root package name */
    public static SimpleDateFormat f4466C = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4467a = false;
    public static Application b = null;
    public static C1912a c = null;
    public static String d = null;
    public static Boolean e = null;
    public static String f = null;
    public static int g = -1;
    public static String h = null;
    public static int i = -1;

    /* renamed from: j, reason: collision with root package name */
    public static String f4468j = null;
    public static String k = null;
    public static long l = -1;
    public static long m = 0;
    public static int n = -1;
    public static JSONObject o = null;
    public static HashMap p = null;

    /* renamed from: q, reason: collision with root package name */
    public static long f4469q = -1;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f4470r = false;

    /* renamed from: s, reason: collision with root package name */
    public static B5.a f4471s = null;

    /* renamed from: t, reason: collision with root package name */
    public static String f4472t = "";
    public static String u = "";

    /* renamed from: v, reason: collision with root package name */
    public static String f4473v = "";

    /* renamed from: x, reason: collision with root package name */
    public static C1621a f4475x;
    public static String y;

    /* renamed from: w, reason: collision with root package name */
    public static J0.a f4474w = new C1912a();

    /* renamed from: z, reason: collision with root package name */
    public static final C1403b f4476z = new C1403b(9);

    /* renamed from: A, reason: collision with root package name */
    public static c f4464A = new C1912a();

    public static String A() {
        if (d == null) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (d == null) {
                        c.getClass();
                        Application application = h.f711a;
                        d = b.a();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public static final HashSet B(Iterable iterable) {
        k.f(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setE = ((o) it.next()).e();
            if (setE == null) {
                return null;
            }
            A.e0(setE, hashSet);
        }
        return hashSet;
    }

    public static String C() {
        c.getClass();
        L.a aVar = h.e;
        if (aVar != null) {
            return aVar.getDid();
        }
        return null;
    }

    public static final d D(g gVar) {
        k.f(gVar, "<this>");
        if (gVar instanceof C2200b) {
            return ((C2200b) gVar).b;
        }
        if (gVar instanceof c0) {
            return D(((c0) gVar).f236a);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [C7.f, java.lang.Object] */
    public static final Field E(t tVar) {
        k.f(tVar, "<this>");
        i0 i0VarC = v0.c(tVar);
        if (i0VarC != null) {
            return (Field) i0VarC.k.getF4884a();
        }
        return null;
    }

    public static final Method F(Z7.g gVar) {
        e eVarD;
        k.f(gVar, "<this>");
        AbstractC0857s abstractC0857sA = v0.a(gVar);
        Member member = (abstractC0857sA == null || (eVarD = abstractC0857sA.d()) == null) ? null : eVarD.getMember();
        if (member instanceof Method) {
            return (Method) member;
        }
        return null;
    }

    public static final x9.b G(x9.b bVar) {
        k.f(bVar, "<this>");
        return bVar.getDescriptor().b() ? bVar : new P(bVar);
    }

    public static String H() {
        Object objA;
        B5.a aVar = f4471s;
        if (aVar != null) {
            try {
                objA = j.y((App) aVar.b);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str = (String) objA;
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static final String I(l lVar, int i6) {
        try {
            byte[] bArrDecode = Base64.decode(lVar.f1364a, 2);
            k.e(bArrDecode, "decode(...)");
            String str = (String) v.D0(i6, m.D0(new String(bArrDecode, AbstractC1607a.f4778a), new String[]{"|"}, 6));
            if (str == null) {
                return null;
            }
            if (str.length() > 0) {
                return str;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static long J() {
        if (m <= 0) {
            m = System.currentTimeMillis();
        }
        return m;
    }

    public static JSONObject K() {
        if (o == null) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (o == null) {
                        c.getClass();
                        H.j jVar = h.f714r;
                        o = jVar != null ? jVar.h : null;
                    }
                } finally {
                }
            }
        }
        return o;
    }

    public static long L() {
        if (l < 0) {
            l = System.currentTimeMillis();
        }
        return l;
    }

    public static int M() {
        if (g == -1) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (g == -1) {
                        c.getClass();
                        H.j jVar = h.f714r;
                        g = jVar != null ? jVar.c : 0;
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public static Map N() {
        HashMap map;
        if (p == null) {
            HashMap map2 = new HashMap();
            p = map2;
            map2.put("aid", String.valueOf(q()));
            p.put("os", "Android");
            p.put("device_platform", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);
            p.put("os_api", Build.VERSION.SDK_INT + "");
            p.put("update_version_code", String.valueOf(M()));
            p.put("version_code", y());
            p.put("channel", z());
            p.put("device_model", Build.MODEL);
            p.put("device_brand", Build.BRAND);
        }
        p.put("device_id", C());
        if (f4467a) {
            p.put("_log_level", BuildConfig.BUILD_TYPE);
        }
        try {
            c.getClass();
            H.j jVar = h.f714r;
            if (jVar != null) {
                map = jVar.i;
                map.put("user_id", h.e.getUserId());
                map.put("device_id", h.e.getDid());
            } else {
                map = null;
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    p.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return p;
    }

    public static int O() {
        if (i == -1) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (i == -1) {
                        c.getClass();
                        H.j jVar = h.f714r;
                        i = jVar != null ? jVar.c : 0;
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public static boolean P() {
        if (e == null) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (e == null) {
                        String strA = A();
                        if (strA == null || !strA.contains(":")) {
                            e = Boolean.valueOf(strA != null && strA.equals(b.getPackageName()));
                        } else {
                            e = Boolean.FALSE;
                        }
                    }
                } finally {
                }
            }
        }
        return e.booleanValue();
    }

    public static M2.d Q(M2.c cVar, String str, int i6) {
        if (i6 >= str.length()) {
            return null;
        }
        int length = str.length() - i6;
        char cCharAt = str.charAt(i6);
        if (cCharAt == 'Z' || cCharAt == 'z') {
            n(cVar, str, i6);
            return M2.d.c;
        }
        char cCharAt2 = str.charAt(i6);
        if (cCharAt2 != '+' && cCharAt2 != '-') {
            H4.o.T(str, new char[]{'Z', 'z', '+', '-'}, i6);
            throw null;
        }
        if (length < 6) {
            throw new DateTimeParseException("Invalid timezone offset: ".concat(str), str, i6);
        }
        int iB = O2.b.b(i6 + 1, i6 + 3, str);
        int iB2 = O2.b.b(i6 + 4, i6 + 6, str);
        if (cCharAt2 == '-') {
            iB = -iB;
            iB2 = -iB2;
            if (iB == 0 && iB2 == 0) {
                throw new DateTimeParseException("Unknown 'Local Offset Convention' date-time not allowed", str, i6);
            }
        }
        n(cVar, str, i6 + 5);
        return new M2.d(iB, iB2);
    }

    public static int R(W7.c random, f fVar) {
        k.f(random, "random");
        try {
            return j.M(random, fVar);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    public static Y7.d S(f fVar) {
        return new Y7.d(fVar.b, fVar.f1569a, -fVar.c);
    }

    public static void T(View view, e3.k kVar) {
        Z2.a aVar = kVar.b.c;
        if (aVar == null || !aVar.f1583a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        C1419h c1419h = kVar.b;
        if (c1419h.m != elevation) {
            c1419h.m = elevation;
            kVar.z();
        }
    }

    public static Y7.d U(f fVar, int i6) {
        k.f(fVar, "<this>");
        boolean z10 = i6 > 0;
        Integer numValueOf = Integer.valueOf(i6);
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i10 = fVar.f1569a;
        int i11 = fVar.b;
        if (fVar.c <= 0) {
            i6 = -i6;
        }
        return new Y7.d(i10, i11, i6);
    }

    public static final C7.k V(String str) {
        int i6;
        AbstractC0897f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        if (k.g(cCharAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i6 = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i10, iDivideUnsigned) > 0) {
                if (iDivideUnsigned != 119304647) {
                    return null;
                }
                iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                if (Integer.compareUnsigned(i10, iDivideUnsigned) > 0) {
                    return null;
                }
            }
            int i11 = i10 * 10;
            int i12 = iDigit + i11;
            if (Integer.compareUnsigned(i12, i11) < 0) {
                return null;
            }
            i6++;
            i10 = i12;
        }
        return new C7.k(i10);
    }

    public static final C7.m W(String str) {
        k.f(str, "<this>");
        AbstractC0897f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        if (k.g(cCharAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j5 = 10;
        long j6 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j6, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, j5);
                if (Long.compareUnsigned(j6, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j10 = j6 * j5;
            long j11 = (iDigit & 4294967295L) + j10;
            if (Long.compareUnsigned(j11, j10) < 0) {
                return null;
            }
            i6++;
            j6 = j11;
        }
        return new C7.m(j6);
    }

    public static f X(int i6, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new f(i6, i10 - 1, 1);
        }
        f fVar = f.d;
        return f.d;
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void b(Parcel parcel, Parcelable parcelable, int i6) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i6);
        }
    }

    public static final b0 c(d kClass, x9.b elementSerializer) {
        k.f(kClass, "kClass");
        k.f(elementSerializer, "elementSerializer");
        return new b0(kClass, elementSerializer);
    }

    public static final C0177d d(x9.b elementSerializer) {
        k.f(elementSerializer, "elementSerializer");
        return new C0177d(elementSerializer);
    }

    public static String e() {
        if (y == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i6 = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i6 >= strArr.length) {
                            break;
                        }
                        sb.append(strArr[i6]);
                        if (i6 != strArr.length - 1) {
                            sb.append(", ");
                        }
                        i6++;
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    y = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                y = sb.toString();
            } catch (Exception unused) {
                y = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        }
        return y;
    }

    public static String f(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        if (!com.apm.insight.g.u) {
            return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
        }
        StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + "\n");
        sb.append("processName: " + processErrorStateInfo.processName + "\n");
        sb.append("pid: " + processErrorStateInfo.pid + "\n");
        sb.append("uid: " + processErrorStateInfo.uid + "\n");
        sb.append("tag: " + processErrorStateInfo.tag + "\n");
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
        sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }

    public static String g(Context context, boolean z10, String str, String str2) throws IOException {
        if (TextUtils.isEmpty(f4472t)) {
            if (TextUtils.isEmpty(str)) {
                f4472t = h(TextUtils.isEmpty(h.f716t) ? "yuNttCSojTyxZods" : h.f716t, l(context, "webview_monitor_js_file/hybrid-rangers-site-sdk.js", true));
            } else {
                f4472t = h(TextUtils.isEmpty(h.f716t) ? "yuNttCSojTyxZods" : h.f716t, l(context, str, false));
            }
        }
        if (TextUtils.isEmpty(u)) {
            u = h(TextUtils.isEmpty(h.f716t) ? "yuNttCSojTyxZods" : h.f716t, l(context, "webview_monitor_js_file/slardar_bridge.js", true));
        }
        f4473v = str2;
        if (str2 == null) {
            str2 = "";
        }
        f4473v = str2;
        if (!z10) {
            f4472t = "";
            f4473v = "";
        }
        StringBuilder sb = new StringBuilder(" javascript:(  function(){ ");
        sb.append(f4472t);
        sb.append(u);
        return B7.a.q(sb, f4473v, " }  )() ");
    }

    public static String h(String str, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            byte[] bArrDoFinal = new byte[0];
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(2, secretKeySpec);
                bArrDoFinal = cipher.doFinal(bArr);
            } catch (Exception unused) {
            }
            return new String(bArrDoFinal);
        } catch (Exception unused2) {
            return "";
        }
    }

    public static DateFormat i() {
        if (f4466C == null) {
            f4466C = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return f4466C;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r0 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void j(org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.AbstractC1451a.j(org.json.JSONObject):void");
    }

    public static boolean k(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, ActivityManager.ProcessErrorStateInfo processErrorStateInfo2) {
        return String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(processErrorStateInfo2.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(processErrorStateInfo2.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(processErrorStateInfo2.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(processErrorStateInfo2.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(processErrorStateInfo2.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(processErrorStateInfo2.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(processErrorStateInfo2.longMsg));
    }

    public static byte[] l(Context context, String str, boolean z10) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = z10 ? context.getAssets().open(str) : new FileInputStream(str);
        } catch (Exception unused) {
            if (inputStreamOpen != null) {
                break;
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        while (true) {
            int i6 = inputStreamOpen.read(bArr);
            if (i6 != -1) {
                byteArrayOutputStream.write(bArr, 0, i6);
            }
            try {
                break;
            } catch (Exception unused3) {
            }
        }
        inputStreamOpen.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] m(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() > 0) {
                return str.getBytes("UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static void n(M2.c cVar, String str, int i6) {
        cVar.getClass();
        int i10 = i6 + 1;
        if (str.length() > i10) {
            throw new DateTimeParseException(String.format("Trailing junk data after position %d: %s", Integer.valueOf(i6 + 2), str), str, i10);
        }
    }

    public static void o(JSONObject jSONObject) {
        Object obj;
        try {
            switch (AbstractC1795a.f5572a[b.d(h.f711a).ordinal()]) {
                case 1:
                    obj = "wifi";
                    break;
                case 2:
                    obj = "2g";
                    break;
                case 3:
                    obj = "3g";
                    break;
                case 4:
                    obj = "4g";
                    break;
                case 5:
                    obj = "mobile";
                    break;
                case 6:
                    obj = "5g";
                    break;
                default:
                    obj = "";
                    break;
            }
            jSONObject.put("access", obj);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) h.f711a.getApplicationContext().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x039d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p(com.stepos.widget.list.StepOSListItem r20, F6.a r21, u1.d r22, java.lang.CharSequence r23, java.lang.CharSequence r24, android.graphics.drawable.Drawable r25, boolean r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.AbstractC1451a.p(com.stepos.widget.list.StepOSListItem, F6.a, u1.d, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Drawable, boolean):void");
    }

    public static int q() {
        c.getClass();
        H.j jVar = h.f714r;
        if (jVar != null) {
            return jVar.f722a;
        }
        return 0;
    }

    public static void r(e eVar, Object[] args) {
        k.f(args, "args");
        if (z2.l.y(eVar) == args.length) {
            return;
        }
        StringBuilder sb = new StringBuilder("Callable expects ");
        sb.append(z2.l.y(eVar));
        sb.append(" arguments, but ");
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.o(sb, " were provided.", args.length));
    }

    public static double s(double d6, double d10, double d11) {
        if (d10 <= d11) {
            return d6 < d10 ? d10 : d6 > d11 ? d11 : d6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d11 + " is less than minimum " + d10 + '.');
    }

    public static float t(float f7, float f9, float f10) {
        if (f9 <= f10) {
            return f7 < f9 ? f9 : f7 > f10 ? f10 : f7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f10 + " is less than minimum " + f9 + '.');
    }

    public static int u(int i6, int i10, int i11) {
        if (i10 <= i11) {
            return i6 < i10 ? i10 : i6 > i11 ? i11 : i6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i11 + " is less than minimum " + i10 + '.');
    }

    public static long v(long j5, long j6, long j10) {
        if (j6 <= j10) {
            return j5 < j6 ? j6 : j5 > j10 ? j10 : j5;
        }
        StringBuilder sb = new StringBuilder("Cannot coerce value to an empty range: maximum ");
        sb.append(j10);
        sb.append(" is less than minimum ");
        throw new IllegalArgumentException(B7.a.p(sb, j6, '.'));
    }

    public static Comparable w(Comparable comparable, Y7.b range) {
        k.f(range, "range");
        Y7.a aVar = (Y7.a) range;
        float f7 = aVar.b;
        float f9 = aVar.f1568a;
        if (!aVar.a()) {
            return (!aVar.b(comparable, Float.valueOf(f9)) || aVar.b(Float.valueOf(f9), comparable)) ? (!aVar.b(Float.valueOf(f7), comparable) || aVar.b(comparable, Float.valueOf(f7))) ? comparable : Float.valueOf(f7) : Float.valueOf(f9);
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static com.stepos.statsrpk.d x(int i6) {
        if (i6 != 0 && i6 == 1) {
            return new C1416e();
        }
        return new n();
    }

    public static String y() {
        if (TextUtils.isEmpty(f4468j)) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (TextUtils.isEmpty(f4468j)) {
                        c.getClass();
                        H.j jVar = h.f714r;
                        f4468j = jVar != null ? jVar.f : null;
                    }
                } finally {
                }
            }
        }
        return f4468j;
    }

    public static String z() {
        if (f == null) {
            synchronized (AbstractC1451a.class) {
                try {
                    if (f == null) {
                        c.getClass();
                        H.j jVar = h.f714r;
                        f = jVar != null ? jVar.b : null;
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
