package p5;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.icu.text.Transliterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.activity.g0;
import androidx.activity.i0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.x;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import d2.l0;
import d2.y;
import g9.a1;
import h0.f0;
import h0.m0;
import h0.t1;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.net.IDN;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k0.c1;
import k0.e0;
import k0.v1;
import k0.z;
import kc.k1;
import kc.w;
import org.json.JSONArray;
import org.json.JSONObject;
import s8.e3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static i1.f f9724a;

    /* renamed from: b, reason: collision with root package name */
    public static Application f9725b;

    public static Set A() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static void B(Application application) {
        Executor executorD;
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f9725b;
        if (application2 != null) {
            if (application2.equals(application)) {
                return;
            }
            Application application3 = f9725b;
            j6.l lVar = j6.l.f6613g;
            lVar.f6615a.clear();
            application3.unregisterActivityLifecycleCallbacks(lVar);
            f9725b = application;
            lVar.getClass();
            application.registerActivityLifecycleCallbacks(lVar);
            return;
        }
        f9725b = application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = j6.l.f6613g;
        activityLifecycleCallbacks.getClass();
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        Runnable runnable = new Runnable[]{new a4.o(1)}[0];
        HashMap map = j6.k.f6612b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(-2);
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorD = j6.g.d();
                    concurrentHashMap.put(5, executorD);
                    map.put(-2, concurrentHashMap);
                } else {
                    executorD = (ExecutorService) map2.get(5);
                    if (executorD == null) {
                        executorD = j6.g.d();
                        map2.put(5, executorD);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        executorD.execute(runnable);
    }

    public static final boolean C(Activity activity) {
        activity.getClass();
        Boolean boolC = ac.a.C();
        if (boolC != null) {
            return boolC.booleanValue();
        }
        Object systemService = activity.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return keyguardManager != null && keyguardManager.isDeviceSecure();
    }

    public static final long D(float f5, long j10) {
        return (Float.isNaN(f5) || f5 >= 1.0f) ? j10 : d1.p.c(d1.p.e(j10) * f5, j10);
    }

    public static TypedValue E(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean F(Context context, int i, boolean z10) {
        TypedValue typedValueE = E(i, context);
        return (typedValueE == null || typedValueE.type != 18) ? z10 : typedValueE.data != 0;
    }

    public static String G(List list) {
        ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k0.a.A((String) it.next(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return "other";
        }
        int iOrdinal = e3.h((String) kb.l.w0(arrayList2)).ordinal();
        if (iOrdinal == 0) {
            return "image";
        }
        if (iOrdinal == 1) {
            return "video";
        }
        if (iOrdinal == 2) {
            return "audio";
        }
        if (iOrdinal == 3) {
            return "file";
        }
        g5.f.a();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd A[PHI: r0
      0x00dd: PHI (r0v36 long) = (r0v21 long), (r0v27 long), (r0v41 long) binds: [B:56:0x0141, B:50:0x0115, B:37:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void H(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.f.H(android.content.Context):void");
    }

    public static final String I(String str) {
        String strTransliterate;
        i9.a aVar = i9.a.f5826a;
        String string = hc.h.w0(str).toString();
        if (string.length() != 0) {
            Character chValueOf = null;
            if (string.length() == 0) {
                g5.f.m("Char sequence is empty.");
                return null;
            }
            int i = 0;
            char cCharAt = string.charAt(0);
            if ('A' <= cCharAt && cCharAt < '[') {
                return String.valueOf(cCharAt);
            }
            if ('a' <= cCharAt && cCharAt < '{') {
                return String.valueOf(Character.toUpperCase(cCharAt));
            }
            if (!Character.isDigit(cCharAt)) {
                if (string.length() == 0) {
                    string = "";
                } else {
                    Transliterator transliterator = i9.a.f5828c;
                    if (transliterator != null && (strTransliterate = transliterator.transliterate(string)) != null) {
                        StringBuilder sb2 = new StringBuilder();
                        int length = strTransliterate.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            char cCharAt2 = strTransliterate.charAt(i3);
                            if (Character.isLetter(cCharAt2) || com.stepos.statsrpk.h.v(cCharAt2)) {
                                sb2.append(cCharAt2);
                            }
                        }
                        String string2 = sb2.toString();
                        if (!hc.h.g0(string2)) {
                            string = string2;
                        }
                    }
                }
                while (true) {
                    if (i >= string.length()) {
                        break;
                    }
                    char cCharAt3 = string.charAt(i);
                    if (Character.isLetter(cCharAt3)) {
                        chValueOf = Character.valueOf(cCharAt3);
                        break;
                    }
                    i++;
                }
                if (chValueOf != null) {
                    ec.b bVar = new ec.b('a', 'z');
                    char cCharValue = chValueOf.charValue();
                    if (yb.k.b(bVar.f3753c, cCharValue) <= 0 && yb.k.b(cCharValue, bVar.f3754f) <= 0) {
                        return String.valueOf(Character.toUpperCase(chValueOf.charValue()));
                    }
                    ec.b bVar2 = new ec.b('A', 'Z');
                    char cCharValue2 = chValueOf.charValue();
                    return (yb.k.b(bVar2.f3753c, cCharValue2) > 0 || yb.k.b(cCharValue2, bVar2.f3754f) > 0) ? "#" : chValueOf.toString();
                }
            }
        }
        return "#";
    }

    public static final long J(float f5, long j10) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j10 >> 32)) - f5);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j10 & 4294967295L)) - f5);
        return (Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L);
    }

    public static String[] K(String str) {
        if (str.isEmpty()) {
            return new String[]{""};
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(47, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            arrayList.add(str.substring(i, iIndexOf));
            if (iIndexOf == str.length()) {
                break;
            }
            i = iIndexOf + 1;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static ec.f L(ec.g gVar, int i) {
        gVar.getClass();
        boolean z10 = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i3 = gVar.f3758c;
        int i10 = gVar.f3759f;
        if (gVar.f3760g <= 0) {
            i = -i;
        }
        return new ec.f(i3, i10, i);
    }

    public static final String M(String str) {
        str.getClass();
        int i = 0;
        int i3 = -1;
        if (!hc.h.X(str, ":", false)) {
            try {
                String ascii = IDN.toASCII(str);
                ascii.getClass();
                Locale locale = Locale.US;
                locale.getClass();
                String lowerCase = ascii.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = lowerCase.charAt(i10);
                    if (yb.k.b(cCharAt, 31) <= 0 || yb.k.b(cCharAt, 127) >= 0 || hc.h.d0(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressU = (hc.o.U(str, "[", false) && hc.o.P(str, "]", false)) ? u(1, str.length() - 1, str) : u(0, str.length(), str);
        if (inetAddressU == null) {
            return null;
        }
        byte[] address = inetAddressU.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressU.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < address.length) {
            int i13 = i11;
            while (i13 < 16 && address[i13] == 0 && address[i13 + 1] == 0) {
                i13 += 2;
            }
            int i14 = i13 - i11;
            if (i14 > i12 && i14 >= 4) {
                i3 = i11;
                i12 = i14;
            }
            i11 = i13 + 2;
        }
        od.i iVar = new od.i();
        while (i < address.length) {
            if (i == i3) {
                iVar.b0(58);
                i += i12;
                if (i == 16) {
                    iVar.b0(58);
                }
            } else {
                if (i > 0) {
                    iVar.b0(58);
                }
                byte b10 = address[i];
                byte[] bArr = bd.b.f2074a;
                iVar.d0(((b10 & 255) << 8) | (address[i + 1] & 255));
                i += 2;
            }
        }
        return iVar.U();
    }

    public static String N(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            a1 a1Var = (a1) obj;
            jSONArray.put(new JSONObject().put("group_id", a1Var.f4403a).put("mode", a1Var.f4404b).put("update_time", a1Var.f4405c));
        }
        String string = jSONArray.toString();
        string.getClass();
        return string;
    }

    public static ec.g O(int i, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new ec.g(i, i3 - 1, 1);
        }
        ec.g gVar = ec.g.f3761h;
        return ec.g.f3761h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [k0.s] */
    public static final void a(boolean z10, xb.a aVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-361453782);
        int i10 = 2;
        if ((i & 14) == 0) {
            i3 = (sVar.g(z10) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= sVar.f(aVar) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && sVar.B()) {
            sVar.S();
        } else {
            c1 c1VarZ = z.z(aVar, sVar);
            sVar.Y(-3687241);
            Object objM = sVar.M();
            Object obj = k0.m.f6974a;
            if (objM == obj) {
                objM = new b.i(c1VarZ, z10);
                sVar.i0(objM);
            }
            int i11 = 0;
            sVar.q(false);
            b.i iVar = (b.i) objM;
            Boolean boolValueOf = Boolean.valueOf(z10);
            sVar.Y(-3686552);
            boolean zF = sVar.f(boolValueOf) | sVar.f(iVar);
            Object objM2 = sVar.M();
            if (zF || objM2 == obj) {
                objM2 = new b.f(iVar, z10);
                sVar.i0(objM2);
            }
            sVar.q(false);
            z.j((xb.a) objM2, sVar);
            e0 e0Var = b.l.f1708a;
            sVar.Y(-2068013981);
            g0 next = (g0) sVar.j(b.l.f1708a);
            sVar.Y(1680121597);
            g0 g0Var = null;
            if (next == null) {
                View view = (View) sVar.j(AndroidCompositionLocals_androidKt.f986f);
                view.getClass();
                gc.k kVarS = gc.m.S(view, i0.f681f);
                i0 i0Var = i0.f682g;
                gc.i iVar2 = new gc.i(i10);
                iVar2.f4694b = kVarS;
                iVar2.f4695c = i0Var;
                gc.g gVar = (gc.g) new gc.h(iVar2, false, new y(13)).iterator();
                next = !gVar.hasNext() ? null : gVar.next();
            }
            sVar.q(false);
            if (next == null) {
                Context baseContext = (Context) sVar.j(AndroidCompositionLocals_androidKt.f982b);
                while (true) {
                    if (!(baseContext instanceof ContextWrapper)) {
                        break;
                    }
                    if (baseContext instanceof g0) {
                        g0Var = baseContext;
                        break;
                    }
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                }
                next = g0Var;
            }
            sVar.q(false);
            if (next == null) {
                od.f.e("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
                return;
            } else {
                androidx.activity.e0 onBackPressedDispatcher = next.getOnBackPressedDispatcher();
                x xVar = (x) sVar.j(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                z.c(xVar, onBackPressedDispatcher, new b.g(onBackPressedDispatcher, xVar, iVar, i11), sVar);
            }
        }
        v1 v1VarS = sVar.s();
        if (v1VarS == null) {
            return;
        }
        v1VarS.f7091d = new b.h(z10, aVar, i);
    }

    public static final o2.d b(float f5, float f10) {
        o2.d dVar = new o2.d();
        dVar.f9109c = f5;
        dVar.f9110f = f10;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public static final void c(long j10, l0 l0Var, s0.c cVar, k0.s sVar, int i) {
        sVar.Z(-716124955);
        int i3 = (sVar.e(j10) ? 4 : 2) | i | (sVar.f(l0Var) ? 32 : 16);
        if ((i & 384) == 0) {
            i3 |= sVar.h(cVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 147) == 146 && sVar.B()) {
            sVar.S();
        } else {
            e0 e0Var = t1.f5165a;
            z.b(new k0.t1[]{f0.f4961a.a(d1.p.a(j10)), e0Var.a(((l0) sVar.j(e0Var)).c(l0Var))}, cVar, sVar, ((i3 >> 3) & 112) | 8);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new m0(j10, l0Var, cVar, i);
        }
    }

    public static final c1.c d(long j10, long j11) {
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        return new c1.c(Float.intBitsToFloat(i), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat(i3));
    }

    public static void e(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static final int f(aa.p pVar) {
        if ((pVar.f352h >>> 24) == 0 && (pVar.i >>> 24) == 0 && (pVar.f353j >>> 24) == 0) {
            return 0;
        }
        aa.e eVar = pVar.f355l;
        if (eVar == null) {
            eVar = pVar.f350f;
        }
        return eVar.f314c;
    }

    public static long g(boolean z10, int i, int i3, long j10, long j11, int i10, boolean z11, long j12, long j13, long j14, long j15) {
        if (i3 == 0) {
            throw null;
        }
        if (j15 != Long.MAX_VALUE && z11) {
            if (i10 != 0) {
                long j16 = j11 + 900000;
                if (j15 < j16) {
                    return j16;
                }
            }
            return j15;
        }
        if (z10) {
            long jScalb = i3 == 2 ? j10 * i : (long) Math.scalb(j10, i - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j11 + jScalb;
        }
        if (z11) {
            long j17 = i10 == 0 ? j11 + j12 : j11 + j14;
            return (j13 == j14 || i10 != 0) ? j17 : (j14 - j13) + j17;
        }
        if (j11 == -1) {
            return Long.MAX_VALUE;
        }
        return j11 + j12;
    }

    public static void h(String str, boolean z10) {
        if (z10) {
            return;
        }
        g5.f.s(str);
    }

    public static final void i(WorkDatabase workDatabase, g5.a aVar, h5.n nVar) {
        int i;
        workDatabase.getClass();
        aVar.getClass();
        ArrayList arrayListI = ac.a.I(nVar);
        int i3 = 0;
        while (!arrayListI.isEmpty()) {
            List list = ((h5.n) kb.q.q0(arrayListI)).f5357d;
            list.getClass();
            if (list.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (!((g5.f0) it.next()).f4314b.f9772j.i.isEmpty() && (i = i + 1) < 0) {
                        ac.a.Z();
                        throw null;
                    }
                }
            }
            i3 += i;
        }
        if (i3 == 0) {
            return;
        }
        s sVarC = workDatabase.C();
        sVarC.getClass();
        androidx.room.x xVarD = androidx.room.x.d(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            int i10 = cursorD.moveToFirst() ? cursorD.getInt(0) : 0;
            cursorD.close();
            xVarD.e();
            int i11 = aVar.f4276j;
            if (i10 + i3 <= i11) {
                return;
            }
            g5.f.s(k0.a.r(k0.a.u("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", i11, ";\nalready enqueued count: ", ";\ncurrent enqueue operation count: ", i10), i3, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
        } catch (Throwable th) {
            cursorD.close();
            xVarD.e();
            throw th;
        }
    }

    public static final void j(int i, int i3) {
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        }
    }

    public static void k(Object obj, String str) {
        if (obj != null) {
            return;
        }
        g5.f.g(str);
    }

    public static final void l(int i, int i3) {
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        }
    }

    public static final void m(int i, int i3, int i10) {
        if (i < 0 || i3 > i10) {
            b8.z.i(i10, k0.a.u("fromIndex: ", i, ", toIndex: ", ", size: ", i3));
        } else {
            if (i <= i3) {
                return;
            }
            g5.f.s(androidx.activity.b.i("fromIndex: ", i, " > toIndex: ", i3));
        }
    }

    public static Comparable n(o2.f fVar, o2.f fVar2) {
        return fVar.compareTo(fVar2) < 0 ? fVar2 : fVar;
    }

    public static double o(double d7, double d10, double d11) {
        if (d10 <= d11) {
            return d7 < d10 ? d10 : d7 > d11 ? d11 : d7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d11 + " is less than minimum " + d10 + '.');
    }

    public static float p(float f5, float f10, float f11) {
        if (f10 <= f11) {
            return f5 < f10 ? f10 : f5 > f11 ? f11 : f5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f11 + " is less than minimum " + f10 + '.');
    }

    public static int q(int i, int i3, int i10) {
        if (i3 <= i10) {
            return i < i3 ? i3 : i > i10 ? i10 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i10 + " is less than minimum " + i3 + '.');
    }

    public static long r(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    public static Comparable s(o2.f fVar, o2.f fVar2, o2.f fVar3) {
        if (fVar2.compareTo(fVar3) <= 0) {
            return fVar.compareTo(fVar2) < 0 ? fVar2 : fVar.compareTo(fVar3) > 0 ? fVar3 : fVar;
        }
        b8.z.o("Cannot coerce value to an empty range: maximum ", fVar3, " is less than minimum ", fVar2, 46);
        return null;
    }

    public static final g2.e t(Context context) {
        context.getApplicationContext();
        int iA = g2.l.f4257a.a(context);
        g2.a aVar = new g2.a();
        aVar.f4242a = iA;
        VarHandle.storeStoreFence();
        u uVar = g2.f.f4246a;
        u uVar2 = g2.f.f4246a;
        w.a(g2.h.f4248a.plus(k2.i.f7204a).plus(nb.h.f8811c).plus(new k1(null)));
        a1.g gVar = new a1.g(10, false);
        gVar.f19f = new f8.b(3);
        VarHandle.storeStoreFence();
        g2.e eVar = new g2.e();
        eVar.f4243a = aVar;
        eVar.f4244b = uVar;
        eVar.f4245c = gVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cb, code lost:
    
        if (r7 == 16) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cd, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.net.InetAddress u(int r17, int r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.f.u(int, int, java.lang.String):java.net.InetAddress");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [jb.h] */
    public static List v(String str) {
        List listL;
        boolean zG0 = hc.h.g0(str);
        List list = kb.s.f7404c;
        if (zG0) {
            return list;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            lb.c cVarO = ac.a.o();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("group_id");
                    strOptString.getClass();
                    String string = hc.h.w0(strOptString).toString();
                    String strOptString2 = jSONObjectOptJSONObject.optString("mode");
                    strOptString2.getClass();
                    String string2 = hc.h.w0(strOptString2).toString();
                    long jOptLong = jSONObjectOptJSONObject.optLong("update_time", 0L);
                    if (string.length() > 0 && string2.length() > 0 && jOptLong > 0) {
                        cVarO.add(new a1(string, string2, jOptLong));
                    }
                }
            }
            listL = ac.a.k(cVarO);
        } catch (Throwable th) {
            listL = id.c.l(th);
        }
        if (!(listL instanceof jb.h)) {
            list = listL;
        }
        return list;
    }

    public static ad.x w(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return ad.x.HTTP_1_0;
        }
        if (str.equals("http/1.1")) {
            return ad.x.HTTP_1_1;
        }
        if (str.equals("h2_prior_knowledge")) {
            return ad.x.H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals("h2")) {
            return ad.x.HTTP_2;
        }
        if (str.equals("spdy/3.1")) {
            return ad.x.SPDY_3;
        }
        if (str.equals("quic")) {
            return ad.x.QUIC;
        }
        od.f.l("Unexpected protocol: ".concat(str));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.app.Application x() throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.ClassNotFoundException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.f.x():android.app.Application");
    }

    public static final int y(Cursor cursor, String str) {
        cursor.getClass();
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return -1;
    }

    public static final int z(Cursor cursor, String str) {
        String strS0;
        cursor.getClass();
        int iY = y(cursor, str);
        if (iY >= 0) {
            return iY;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            columnNames.getClass();
            strS0 = kb.k.s0(columnNames, 63);
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            strS0 = "unknown";
        }
        g5.f.s(androidx.activity.b.j("column '", str, "' does not exist. Available columns: ", strS0));
        return 0;
    }
}
