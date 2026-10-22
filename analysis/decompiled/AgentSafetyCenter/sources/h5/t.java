package h5;

import ad.j0;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.agentsafetycenter.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import d1.i0;
import d2.l0;
import g9.x0;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.security.cert.Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import k0.c1;
import k0.g1;
import k0.k1;
import k0.o2;
import k0.v1;
import k0.y0;
import nc.k0;
import nc.r0;
import org.json.JSONArray;
import org.json.JSONObject;
import p.f0;
import p.g0;
import r.h0;
import r.n0;
import s.e1;
import s.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static b.b f5380a;

    /* renamed from: b, reason: collision with root package name */
    public static i1.f f5381b;

    /* renamed from: c, reason: collision with root package name */
    public static Field f5382c;

    /* renamed from: d, reason: collision with root package name */
    public static Field f5383d;

    public static String A() {
        b.b bVar = f5380a;
        return bVar == null ? "" : r8.a.b((AgentSafetyApplication) bVar.f1685f);
    }

    public static boolean B(Context context) {
        context.getClass();
        if (Environment.isExternalStorageManager()) {
            Log.d("FileTrashPerm", "granted via MANAGE_EXTERNAL_STORAGE");
            return true;
        }
        List listF = ac.a.F(PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO, PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF) {
            if (d3.a.a(context, (String) obj) != 0) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            Log.d("FileTrashPerm", "granted via READ_MEDIA_*");
            return true;
        }
        Log.w("FileTrashPerm", "denied missing READ_MEDIA permissions=" + arrayList);
        return false;
    }

    public static int C(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        g5.f.s(k0.a.j(i, "type needs to be >= FIRST and <= LAST, type="));
        return 0;
    }

    public static final int D(int i, int i3) {
        return (i >> i3) & 31;
    }

    public static final int E(int i, int i3) {
        return (i >> i3) & 31;
    }

    public static boolean F(byte b10) {
        return b10 > -65;
    }

    public static jb.d G(jb.e eVar, xb.a aVar) {
        jb.s sVar = jb.s.f6773a;
        int iOrdinal = eVar.ordinal();
        if (iOrdinal == 0) {
            return new jb.k(aVar);
        }
        if (iOrdinal == 1) {
            jb.j jVar = new jb.j();
            jVar.f6764c = aVar;
            jVar.f6765f = sVar;
            return jVar;
        }
        if (iOrdinal != 2) {
            g5.f.a();
            return null;
        }
        jb.w wVar = new jb.w();
        wVar.f6775c = aVar;
        wVar.f6776f = sVar;
        return wVar;
    }

    public static jb.k H(xb.a aVar) {
        aVar.getClass();
        return new jb.k(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final g9.p I(String str, String str2) {
        jb.h hVarL;
        JSONArray jSONArray;
        int i;
        int i3;
        JSONArray jSONArray2;
        int i10;
        int i11;
        List listK;
        str.getClass();
        str2.getClass();
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject(str);
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("categories");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            lb.c cVarO = ac.a.o();
            int length = jSONArrayOptJSONArray.length();
            int i12 = 0;
            while (i12 < length) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i12);
                if (jSONObjectOptJSONObject2 == null) {
                    jSONArray = jSONArrayOptJSONArray;
                    i = length;
                    i3 = i12;
                } else {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("groups");
                    if (jSONArrayOptJSONArray2 == null) {
                        jSONArrayOptJSONArray2 = new JSONArray();
                    }
                    lb.c cVarO2 = ac.a.o();
                    int length2 = jSONArrayOptJSONArray2.length();
                    int i13 = 0;
                    while (i13 < length2) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i13);
                        if (jSONObjectOptJSONObject3 == null) {
                            jSONArray2 = jSONArrayOptJSONArray;
                            i10 = length;
                            i11 = i12;
                        } else {
                            String strOptString = jSONObjectOptJSONObject3.optString("group_id");
                            strOptString.getClass();
                            String strA = x0.a(jSONObjectOptJSONObject3, "name", str2);
                            String strA2 = x0.a(jSONObjectOptJSONObject3, "description", str2);
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("available_modes");
                            if (jSONArrayOptJSONArray3 == null) {
                                listK = kb.s.f7404c;
                                jSONArray2 = jSONArrayOptJSONArray;
                                i10 = length;
                                i11 = i12;
                            } else {
                                jSONArray2 = jSONArrayOptJSONArray;
                                lb.c cVarO3 = ac.a.o();
                                i10 = length;
                                int length3 = jSONArrayOptJSONArray3.length();
                                i11 = i12;
                                int i14 = 0;
                                while (i14 < length3) {
                                    String strOptString2 = jSONArrayOptJSONArray3.optString(i14);
                                    strOptString2.getClass();
                                    int i15 = length3;
                                    String string = hc.h.w0(strOptString2).toString();
                                    if (string.length() > 0) {
                                        cVarO3.add(string);
                                    }
                                    i14++;
                                    length3 = i15;
                                }
                                listK = ac.a.k(cVarO3);
                            }
                            List list = listK;
                            String strOptString3 = jSONObjectOptJSONObject3.optString("current_mode");
                            strOptString3.getClass();
                            String strOptString4 = jSONObjectOptJSONObject3.optString("default_mode");
                            strOptString4.getClass();
                            cVarO2.add(new g9.o(strOptString, strA, strA2, list, strOptString3, strOptString4, jSONObjectOptJSONObject3.optBoolean("is_user_config")));
                        }
                        i13++;
                        jSONArrayOptJSONArray = jSONArray2;
                        length = i10;
                        i12 = i11;
                    }
                    jSONArray = jSONArrayOptJSONArray;
                    i = length;
                    i3 = i12;
                    lb.c cVarK = ac.a.k(cVarO2);
                    String strOptString5 = jSONObjectOptJSONObject2.optString("category_id");
                    strOptString5.getClass();
                    cVarO.add(new g9.n(strOptString5, x0.a(jSONObjectOptJSONObject2, "category_name", str2), cVarK));
                }
                i12 = i3 + 1;
                jSONArrayOptJSONArray = jSONArray;
                length = i;
            }
            lb.c cVarK2 = ac.a.k(cVarO);
            cVarK2.getClass();
            g9.p pVar = new g9.p();
            pVar.f4572a = cVarK2;
            hVarL = pVar;
        } catch (Throwable th) {
            hVarL = id.c.l(th);
        }
        boolean z10 = hVarL instanceof jb.h;
        Object obj = hVarL;
        if (z10) {
            obj = null;
        }
        return (g9.p) obj;
    }

    public static final boolean J(String str) {
        str.getClass();
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final List K(x4.c cVar) {
        int i = com.stepos.statsrpk.h.i(cVar, "id");
        int i3 = com.stepos.statsrpk.h.i(cVar, "seq");
        int i10 = com.stepos.statsrpk.h.i(cVar, "from");
        int i11 = com.stepos.statsrpk.h.i(cVar, "to");
        lb.c cVarO = ac.a.o();
        while (cVar.G()) {
            int i12 = (int) cVar.getLong(i);
            int i13 = (int) cVar.getLong(i3);
            String strZ = cVar.z(i10);
            String strZ2 = cVar.z(i11);
            strZ.getClass();
            strZ2.getClass();
            s4.d dVar = new s4.d();
            dVar.f11383c = i12;
            dVar.f11384f = i13;
            dVar.f11385g = strZ;
            dVar.f11386h = strZ2;
            VarHandle.storeStoreFence();
            cVarO.add(dVar);
        }
        return kb.l.H0(ac.a.k(cVarO));
    }

    public static final s4.g L(x4.a aVar, String str, boolean z10) {
        x4.c cVarK = aVar.K("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int i = com.stepos.statsrpk.h.i(cVarK, "seqno");
            int i3 = com.stepos.statsrpk.h.i(cVarK, "cid");
            int i10 = com.stepos.statsrpk.h.i(cVarK, "name");
            int i11 = com.stepos.statsrpk.h.i(cVarK, "desc");
            if (i != -1 && i3 != -1 && i10 != -1 && i11 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (cVarK.G()) {
                    if (((int) cVarK.getLong(i3)) >= 0) {
                        int i12 = (int) cVarK.getLong(i);
                        String strZ = cVarK.z(i10);
                        String str2 = cVarK.getLong(i11) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i12), strZ);
                        linkedHashMap2.put(Integer.valueOf(i12), str2);
                    }
                }
                List listI0 = kb.l.I0(linkedHashMap.entrySet(), new a9.n(6));
                ArrayList arrayList = new ArrayList(kb.m.m0(listI0, 10));
                Iterator it = listI0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listL0 = kb.l.L0(arrayList);
                List listI02 = kb.l.I0(linkedHashMap2.entrySet(), new a9.n(7));
                ArrayList arrayList2 = new ArrayList(kb.m.m0(listI02, 10));
                Iterator it2 = listI02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                s4.g gVar = new s4.g(str, z10, listL0, kb.l.L0(arrayList2));
                t2.a.h(cVarK, null);
                return gVar;
            }
            t2.a.h(cVarK, null);
            return null;
        } finally {
        }
    }

    public static final boolean M(f0 f0Var, Object obj, Object obj2) {
        Object objG = f0Var.g(obj);
        if (objG == null) {
            return false;
        }
        if (!(objG instanceof g0)) {
            if (!objG.equals(obj2)) {
                return false;
            }
            f0Var.k(obj);
            return true;
        }
        g0 g0Var = (g0) objG;
        boolean zK = g0Var.k(obj2);
        if (zK && g0Var.g()) {
            f0Var.k(obj);
        }
        return zK;
    }

    public static final void N(f0 f0Var, Object obj) {
        boolean zG;
        long[] jArr = f0Var.f9552a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj2 = f0Var.f9553b[i11];
                        Object obj3 = f0Var.f9554c[i11];
                        if (obj3 instanceof g0) {
                            g0 g0Var = (g0) obj3;
                            g0Var.k(obj);
                            zG = g0Var.g();
                        } else {
                            zG = obj3 == obj;
                        }
                        if (zG) {
                            f0Var.l(i11);
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public static final l0 O(l0 l0Var, o2.l lVar) {
        d2.e0 e0Var = l0Var.f3140a;
        n2.o oVar = d2.f0.f3099d;
        n2.o oVar2 = e0Var.f3081a;
        if (oVar2.equals(n2.n.f8667a)) {
            oVar2 = d2.f0.f3099d;
        }
        n2.o oVar3 = oVar2;
        long j10 = e0Var.f3082b;
        o2.o[] oVarArr = o2.n.f9127b;
        if ((j10 & 1095216660480L) == 0) {
            j10 = d2.f0.f3096a;
        }
        long j11 = j10;
        g2.k kVar = e0Var.f3083c;
        if (kVar == null) {
            kVar = g2.k.f4252g;
        }
        g2.k kVar2 = kVar;
        g2.i iVar = e0Var.f3084d;
        int i = iVar != null ? iVar.f4249a : 0;
        g2.i iVar2 = new g2.i();
        iVar2.f4249a = i;
        VarHandle.storeStoreFence();
        g2.j jVar = e0Var.f3085e;
        int i3 = jVar != null ? jVar.f4250a : ExifInterface.COLOR_SPACE_UNCALIBRATED;
        g2.j jVar2 = new g2.j();
        jVar2.f4250a = i3;
        VarHandle.storeStoreFence();
        g2.q qVar = e0Var.f3086f;
        if (qVar == null) {
            qVar = g2.q.f4259a;
        }
        g2.q qVar2 = qVar;
        String str = e0Var.f3087g;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j12 = e0Var.f3088h;
        if ((j12 & 1095216660480L) == 0) {
            j12 = d2.f0.f3097b;
        }
        long j13 = j12;
        n2.a aVar = e0Var.i;
        float f5 = aVar != null ? aVar.f8644a : 0.0f;
        n2.a aVar2 = new n2.a();
        aVar2.f8644a = f5;
        VarHandle.storeStoreFence();
        n2.p pVar = e0Var.f3089j;
        if (pVar == null) {
            pVar = n2.p.f8668c;
        }
        n2.p pVar2 = pVar;
        j2.b bVarQ = e0Var.f3090k;
        if (bVarQ == null) {
            j2.b bVar = j2.b.f6544g;
            bVarQ = com.stepos.statsrpk.h.q();
        }
        j2.b bVar2 = bVarQ;
        long j14 = e0Var.f3091l;
        if (j14 == 16) {
            j14 = d2.f0.f3098c;
        }
        long j15 = j14;
        n2.l lVar2 = e0Var.f3092m;
        if (lVar2 == null) {
            lVar2 = n2.l.f8663b;
        }
        n2.l lVar3 = lVar2;
        i0 i0Var = e0Var.f3093n;
        if (i0Var == null) {
            i0Var = i0.f2997d;
        }
        i0 i0Var2 = i0Var;
        td.h hVar = e0Var.f3094o;
        if (hVar == null) {
            hVar = f1.f.f3864e;
        }
        d2.e0 e0Var2 = new d2.e0(oVar3, j11, kVar2, iVar2, jVar2, qVar2, str2, j13, aVar2, pVar2, bVar2, j15, lVar3, i0Var2, hVar);
        d2.t tVar = l0Var.f3141b;
        int i10 = d2.u.f3178b;
        int i11 = tVar.f3169a;
        int i12 = 5;
        if (i11 == Integer.MIN_VALUE) {
            i11 = 5;
        }
        int i13 = tVar.f3170b;
        if (i13 == 3) {
            int iOrdinal = lVar.ordinal();
            if (iOrdinal == 0) {
                i12 = 4;
            } else if (iOrdinal != 1) {
                g5.f.a();
                return null;
            }
        } else if (i13 == Integer.MIN_VALUE) {
            int iOrdinal2 = lVar.ordinal();
            if (iOrdinal2 == 0) {
                i12 = 1;
            } else {
                if (iOrdinal2 != 1) {
                    g5.f.a();
                    return null;
                }
                i12 = 2;
            }
        } else {
            i12 = i13;
        }
        long j16 = tVar.f3171c;
        if ((j16 & 1095216660480L) == 0) {
            j16 = d2.u.f3177a;
        }
        n2.q qVar3 = tVar.f3172d;
        if (qVar3 == null) {
            qVar3 = n2.q.f8671c;
        }
        d2.v vVar = tVar.f3173e;
        n2.i iVar3 = tVar.f3174f;
        int i14 = tVar.f3175g;
        if (i14 == 0) {
            i14 = n2.e.f8649b;
        }
        int i15 = tVar.f3176h;
        if (i15 == Integer.MIN_VALUE) {
            i15 = 1;
        }
        n2.s sVar = tVar.i;
        if (sVar == null) {
            sVar = n2.s.f8675c;
        }
        return new l0(e0Var2, new d2.t(i11, i12, j16, qVar3, vVar, iVar3, i14, i15, sVar), l0Var.f3142c);
    }

    public static Set P(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        setSingleton.getClass();
        return setSingleton;
    }

    public static final r.v Q(h0 h0Var, r.i0 i0Var) {
        n0 n0VarE = e(3);
        r.v vVar = new r.v();
        vVar.f10344a = h0Var;
        vVar.f10345b = i0Var;
        vVar.f10346c = new g1(0.0f);
        vVar.f10347d = n0VarE;
        VarHandle.storeStoreFence();
        return vVar;
    }

    public static final void a(Object obj, w0.m mVar, xb.l lVar, w0.e eVar, String str, xb.l lVar2, s0.c cVar, k0.s sVar, int i) {
        xb.l lVar3;
        w0.e eVar2;
        sVar.Z(2132720749);
        int i3 = i | (sVar.f(obj) ? 4 : 2) | 199680;
        if ((599187 & i3) == 599186 && sVar.B()) {
            sVar.S();
            eVar2 = eVar;
            lVar3 = lVar2;
        } else {
            w0.e eVar3 = w0.b.f15089c;
            r.c cVar2 = r.c.f10248f;
            b(s.g1.b(obj, str, sVar, (i3 & 14) | 48), mVar, lVar, cVar2, cVar, sVar, 224688);
            lVar3 = cVar2;
            eVar2 = eVar3;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r.d(obj, mVar, lVar, eVar2, str, lVar3, cVar, i);
        }
    }

    public static final void b(e1 e1Var, w0.m mVar, xb.l lVar, xb.l lVar2, s0.c cVar, k0.s sVar, int i) {
        u0.q qVar;
        r.n nVar;
        xb.l lVar3;
        u0.q qVar2;
        k0.s sVar2;
        k0.s sVar3;
        e1 e1Var2 = e1Var;
        w0.e eVar = w0.b.f15089c;
        sVar.Z(-114689412);
        int i3 = (i & 6) == 0 ? (sVar.f(e1Var2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= sVar.f(mVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.h(lVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= sVar.f(eVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= sVar.h(lVar2) ? 16384 : 8192;
        }
        s0.c cVar2 = cVar;
        if ((196608 & i) == 0) {
            i3 |= sVar.h(cVar2) ? 131072 : 65536;
        }
        if ((74899 & i3) == 74898 && sVar.B()) {
            sVar.S();
            lVar3 = lVar;
            sVar3 = sVar;
        } else {
            int i10 = i3 & 14;
            boolean z10 = i10 == 4;
            Object objM = sVar.M();
            y0 y0Var = k0.m.f6974a;
            Object obj = objM;
            if (z10 || objM == y0Var) {
                r.n nVar2 = new r.n();
                nVar2.f10319a = e1Var2;
                nVar2.f10320b = k0.z.v(o2.k.a(0L));
                long[] jArr = p.n0.f9597a;
                nVar2.f10321c = new f0();
                VarHandle.storeStoreFence();
                sVar.i0(nVar2);
                obj = nVar2;
            }
            r.n nVar3 = (r.n) obj;
            boolean z11 = i10 == 4;
            Object objM2 = sVar.M();
            Object obj2 = objM2;
            if (z11 || objM2 == y0Var) {
                Object[] objArr = {e1Var2.c()};
                u0.q qVar3 = new u0.q();
                qVar3.addAll(kb.k.u0(objArr));
                sVar.i0(qVar3);
                obj2 = qVar3;
            }
            u0.q qVar4 = (u0.q) obj2;
            boolean z12 = i10 == 4;
            Object objM3 = sVar.M();
            if (z12 || objM3 == y0Var) {
                long[] jArr2 = p.n0.f9597a;
                objM3 = new f0();
                sVar.i0(objM3);
            }
            f0 f0Var = (f0) objM3;
            Object objC = e1Var2.c();
            k1 k1Var = e1Var2.f10992d;
            if (!qVar4.contains(objC)) {
                qVar4.clear();
                qVar4.add(e1Var2.c());
            }
            if (yb.k.a(e1Var2.c(), k1Var.getValue())) {
                if (qVar4.size() != 1 || !yb.k.a(qVar4.get(0), e1Var2.c())) {
                    qVar4.clear();
                    qVar4.add(e1Var2.c());
                }
                if (f0Var.f9556e != 1 || f0Var.c(e1Var2.c())) {
                    f0Var.a();
                }
                nVar3.getClass();
            }
            if (!yb.k.a(e1Var2.c(), k1Var.getValue()) && !qVar4.contains(k1Var.getValue())) {
                ListIterator listIterator = qVar4.listIterator();
                int i11 = 0;
                while (true) {
                    lb.a aVar = (lb.a) listIterator;
                    if (!aVar.hasNext()) {
                        i11 = -1;
                        break;
                    } else if (yb.k.a(lVar2.invoke(aVar.next()), lVar2.invoke(k1Var.getValue()))) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 == -1) {
                    qVar4.add(k1Var.getValue());
                } else {
                    qVar4.set(i11, k1Var.getValue());
                }
            }
            if (f0Var.c(k1Var.getValue()) && f0Var.c(e1Var2.c())) {
                sVar.X(915535767);
                sVar.q(false);
                qVar = qVar4;
                nVar = nVar3;
                lVar3 = lVar;
            } else {
                sVar.X(912931457);
                f0Var.a();
                int size = qVar4.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj3 = qVar4.get(i12);
                    r.n nVar4 = nVar3;
                    s0.c cVar3 = cVar2;
                    u0.q qVar5 = qVar4;
                    f0Var.m(obj3, s0.h.d(885640742, new r.h(e1Var2, obj3, lVar, nVar4, qVar5, cVar3), sVar));
                    i12++;
                    e1Var2 = e1Var;
                    nVar3 = nVar4;
                    qVar4 = qVar5;
                    cVar2 = cVar;
                }
                qVar = qVar4;
                nVar = nVar3;
                lVar3 = lVar;
                sVar.q(false);
            }
            boolean zF = sVar.f(e1Var.f()) | sVar.f(nVar);
            Object objM4 = sVar.M();
            if (zF || objM4 == y0Var) {
                objM4 = (r.v) lVar3.invoke(nVar);
                sVar.i0(objM4);
            }
            r.v vVar = (r.v) objM4;
            e1 e1Var3 = nVar.f10319a;
            boolean zF2 = sVar.f(nVar);
            Object objM5 = sVar.M();
            if (zF2 || objM5 == y0Var) {
                objM5 = k0.z.v(Boolean.FALSE);
                sVar.i0(objM5);
            }
            c1 c1Var = (c1) objM5;
            c1 c1VarZ = k0.z.z(vVar.f10347d, sVar);
            if (yb.k.a(e1Var3.c(), e1Var3.f10992d.getValue())) {
                c1Var.setValue(Boolean.FALSE);
            } else if (c1VarZ.getValue() != null) {
                c1Var.setValue(Boolean.TRUE);
            }
            boolean zBooleanValue = ((Boolean) c1Var.getValue()).booleanValue();
            w0.m mVarH = w0.j.f15113c;
            if (zBooleanValue) {
                sVar.X(249037309);
                qVar2 = qVar;
                k0.s sVar4 = sVar;
                s.y0 y0VarA = s.g1.a(nVar.f10319a, i1.f11033h, null, sVar4, 0, 2);
                boolean zF3 = sVar4.f(y0VarA);
                Object objM6 = sVar4.M();
                if (zF3 || objM6 == y0Var) {
                    n0 n0Var = (n0) c1VarZ.getValue();
                    if (n0Var == null || n0Var.f10322a) {
                        mVarH = com.stepos.statsrpk.h.h(mVarH);
                    }
                    r.m mVar2 = new r.m();
                    mVar2.f10317g = nVar;
                    mVar2.f10315c = y0VarA;
                    mVar2.f10316f = c1VarZ;
                    VarHandle.storeStoreFence();
                    objM6 = mVarH.d(mVar2);
                    sVar4.i0(objM6);
                }
                mVarH = (w0.m) objM6;
                sVar4.q(false);
                sVar2 = sVar4;
            } else {
                k0.s sVar5 = sVar;
                qVar2 = qVar;
                sVar5.X(249353726);
                sVar5.q(false);
                sVar2 = sVar5;
            }
            w0.m mVarD = mVar.d(mVarH);
            Object objM7 = sVar2.M();
            Object obj4 = objM7;
            if (objM7 == y0Var) {
                r.j jVar = new r.j();
                jVar.f10307a = nVar;
                VarHandle.storeStoreFence();
                sVar2.i0(jVar);
                obj4 = jVar;
            }
            r.j jVar2 = (r.j) obj4;
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarD);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(jVar2, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            sVar2.X(-1491001814);
            int size2 = qVar2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                Object obj5 = qVar2.get(i13);
                sVar2.T(lVar2.invoke(obj5), 1908315325, 0, null);
                xb.p pVar = (xb.p) f0Var.g(obj5);
                if (pVar == null) {
                    sVar2.X(-971711888);
                } else {
                    sVar2.X(1908317105);
                    pVar.invoke(sVar2, 0);
                }
                sVar2.q(false);
                sVar2.q(false);
            }
            sVar2.q(false);
            sVar2.q(true);
            sVar3 = sVar2;
        }
        v1 v1VarS = sVar3.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new r.i(e1Var, mVar, lVar3, lVar2, cVar, i, 0);
        }
    }

    public static mc.e c(int i, int i3, mc.a aVar) {
        if ((i3 & 2) != 0) {
            aVar = mc.a.f8550c;
        }
        if (i == -2) {
            if (aVar != mc.a.f8550c) {
                return new mc.p(1, aVar);
            }
            mc.i.f8593b.getClass();
            return new mc.e(mc.h.f8592b);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? aVar == mc.a.f8550c ? new mc.e(i) : new mc.p(i, aVar) : new mc.e(Reader.READ_DONE) : aVar == mc.a.f8550c ? new mc.e(0) : new mc.p(1, aVar);
        }
        if (aVar == mc.a.f8550c) {
            return new mc.p(1, mc.a.f8551f);
        }
        g5.f.s("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    public static long d(float f5) {
        return (Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L);
    }

    public static n0 e(int i) {
        boolean z10 = (i & 1) != 0;
        n0 n0Var = new n0();
        n0Var.f10322a = z10;
        VarHandle.storeStoreFence();
        return n0Var;
    }

    public static final long f(float f5, float f10) {
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public static final int g(float[] fArr) {
        int i = 0;
        if (fArr.length < 16) {
            return 0;
        }
        int i3 = (fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f) ? 1 : 0;
        if (fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f) {
            i = 1;
        }
        return (i3 << 1) | i;
    }

    public static final hc.f h(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        charSequence.getClass();
        hc.f fVar = new hc.f();
        fVar.f5461a = matcher;
        fVar.f5462b = charSequence;
        VarHandle.storeStoreFence();
        return fVar;
    }

    public static final Object[] i(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        kb.k.k0(objArr, objArr2, 0, i, 6);
        kb.k.i0(objArr, objArr2, i + 2, i, objArr.length);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    public static final Object[] j(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 2];
        kb.k.k0(objArr, objArr2, 0, i, 6);
        kb.k.i0(objArr, objArr2, i, i + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] k(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 1];
        kb.k.k0(objArr, objArr2, 0, i, 6);
        kb.k.i0(objArr, objArr2, i, i + 1, objArr.length);
        return objArr2;
    }

    public static final void l(f0 f0Var, Object obj, Object obj2) {
        int iF = f0Var.f(obj);
        boolean z10 = iF < 0;
        Object obj3 = z10 ? null : f0Var.f9554c[iF];
        if (obj3 != null) {
            if (obj3 instanceof g0) {
                ((g0) obj3).a(obj2);
            } else if (obj3 != obj2) {
                g0 g0Var = new g0();
                g0Var.a(obj3);
                g0Var.a(obj2);
                obj2 = g0Var;
            }
            obj2 = obj3;
        }
        if (!z10) {
            f0Var.f9554c[iF] = obj2;
            return;
        }
        int i = ~iF;
        f0Var.f9553b[i] = obj;
        f0Var.f9554c[i] = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(androidx.lifecycle.q r6, pb.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof i6.a
            if (r0 == 0) goto L13
            r0 = r7
            i6.a r0 = (i6.a) r0
            int r1 = r0.f5801h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5801h = r1
            goto L18
        L13:
            i6.a r0 = new i6.a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f5800g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5801h
            jb.v r3 = jb.v.f6774a
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2f
            yb.u r6 = r0.f5799f
            androidx.lifecycle.q r0 = r0.f5798c
            id.c.I(r7)     // Catch: java.lang.Throwable -> L2d
            goto L75
        L2d:
            r7 = move-exception
            goto L84
        L2f:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L36:
            id.c.I(r7)
            androidx.lifecycle.p r7 = r6.b()
            androidx.lifecycle.p r2 = androidx.lifecycle.p.f1421h
            int r7 = r7.compareTo(r2)
            if (r7 < 0) goto L46
            return r3
        L46:
            yb.u r7 = new yb.u
            r7.<init>()
            r0.f5798c = r6     // Catch: java.lang.Throwable -> L7f
            r0.f5799f = r7     // Catch: java.lang.Throwable -> L7f
            r0.f5801h = r4     // Catch: java.lang.Throwable -> L7f
            kc.g r2 = new kc.g     // Catch: java.lang.Throwable -> L7f
            nb.c r0 = td.h.y(r0)     // Catch: java.lang.Throwable -> L7f
            r2.<init>(r4, r0)     // Catch: java.lang.Throwable -> L7f
            r2.s()     // Catch: java.lang.Throwable -> L7f
            i6.b r0 = new i6.b     // Catch: java.lang.Throwable -> L7f
            r0.<init>()     // Catch: java.lang.Throwable -> L7f
            r0.f5802c = r2     // Catch: java.lang.Throwable -> L7f
            java.lang.invoke.VarHandle.storeStoreFence()     // Catch: java.lang.Throwable -> L7f
            r7.f16098c = r0     // Catch: java.lang.Throwable -> L7f
            r6.a(r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r0 = r2.r()     // Catch: java.lang.Throwable -> L7f
            if (r0 != r1) goto L73
            return r1
        L73:
            r0 = r6
            r6 = r7
        L75:
            java.lang.Object r6 = r6.f16098c
            androidx.lifecycle.w r6 = (androidx.lifecycle.w) r6
            if (r6 == 0) goto L7e
            r0.c(r6)
        L7e:
            return r3
        L7f:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L84:
            java.lang.Object r6 = r6.f16098c
            androidx.lifecycle.w r6 = (androidx.lifecycle.w) r6
            if (r6 == 0) goto L8d
            r0.c(r6)
        L8d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.t.m(androidx.lifecycle.q, pb.c):java.lang.Object");
    }

    public static lb.i n(lb.i iVar) {
        lb.f fVar = iVar.f7855c;
        fVar.b();
        return fVar.f7845m > 0 ? iVar : lb.i.f7854f;
    }

    public static final Bundle o(jb.g... gVarArr) {
        Bundle bundle = new Bundle(gVarArr.length);
        for (jb.g gVar : gVarArr) {
            String str = (String) gVar.f6759c;
            Object obj = gVar.f6760f;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                componentType.getClass();
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        b8.z.o("Illegal value array type ", componentType.getCanonicalName(), " for key \"", str, 34);
                        return null;
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                bundle.putSize(str, (Size) obj);
            } else {
                if (!(obj instanceof SizeF)) {
                    b8.z.o("Illegal value type ", obj.getClass().getCanonicalName(), " for key \"", str, 34);
                    return null;
                }
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }

    public static void p(Object obj, boolean z10) throws NoSuchFieldException, SecurityException {
        if (!z10 || f5383d == null) {
            if (z10 || f5382c == null) {
                Field declaredField = null;
                try {
                    declaredField = obj.getClass().getDeclaredField("mStateSaved");
                    declaredField.setAccessible(true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (z10) {
                    f5383d = declaredField;
                } else {
                    f5382c = declaredField;
                }
            }
        }
    }

    public static final c1 q(nc.g gVar, Object obj, androidx.lifecycle.q qVar, k0.s sVar, int i) {
        androidx.lifecycle.p pVar = androidx.lifecycle.p.f1421h;
        Object obj2 = nb.h.f8811c;
        Object[] objArr = {gVar, qVar, pVar, obj2};
        boolean zH = ((((i & 7168) ^ 3072) > 2048 && sVar.d(pVar.ordinal())) || (i & 3072) == 2048) | sVar.h(qVar) | sVar.h(obj2) | sVar.h(gVar);
        Object objM = sVar.M();
        nb.c cVar = null;
        Object obj3 = k0.m.f6974a;
        if (zH || objM == obj3) {
            objM = new androidx.lifecycle.l0(qVar, gVar, (nb.c) null);
            sVar.i0(objM);
        }
        xb.p pVar2 = (xb.p) objM;
        Object objM2 = sVar.M();
        if (objM2 == obj3) {
            objM2 = k0.z.v(obj);
            sVar.i0(objM2);
        }
        c1 c1Var = (c1) objM2;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
        boolean zH2 = sVar.h(pVar2);
        Object objM3 = sVar.M();
        if (zH2 || objM3 == obj3) {
            objM3 = new o2(pVar2, c1Var, cVar, 2);
            sVar.i0(objM3);
        }
        k0.z.i(objArrCopyOf, (xb.p) objM3, sVar);
        return c1Var;
    }

    public static final c1 r(nc.g gVar, Object obj, k0.s sVar) {
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) sVar.j(f4.c.f3915a);
        androidx.lifecycle.p pVar = androidx.lifecycle.p.f1418c;
        return q(gVar, obj, xVar.getLifecycle(), sVar, 0);
    }

    public static final c1 s(r0 r0Var, k0.s sVar) {
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) sVar.j(f4.c.f3915a);
        androidx.lifecycle.p pVar = androidx.lifecycle.p.f1418c;
        return q(r0Var, r0Var.getValue(), xVar.getLifecycle(), sVar, 0);
    }

    public static f0 t() {
        long[] jArr = p.n0.f9597a;
        return new f0();
    }

    public static ThreadPoolExecutor u(String str) {
        a4.a aVar = new a4.a();
        aVar.f154c = str;
        VarHandle.storeStoreFence();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static final r v(Context context, g5.a aVar) throws Resources.NotFoundException {
        androidx.room.r rVarB;
        context.getClass();
        ExecutorService executorService = aVar.f4270c;
        p5.i iVar = new p5.i();
        iVar.f9732g = new Handler(Looper.getMainLooper());
        int i = 0;
        r5.a aVar2 = new r5.a(0);
        aVar2.f10462f = iVar;
        VarHandle.storeStoreFence();
        iVar.f9733h = aVar2;
        int i3 = 2;
        androidx.room.b0 b0Var = new androidx.room.b0(i3);
        b0Var.i = executorService;
        b0Var.f1510g = new ArrayDeque();
        b0Var.f1509f = new Object();
        VarHandle.storeStoreFence();
        iVar.f9730c = b0Var;
        kc.p pVarK = kc.w.k(b0Var);
        iVar.f9731f = pVarK;
        VarHandle.storeStoreFence();
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        g5.j jVar = aVar.f4271d;
        boolean z10 = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        jVar.getClass();
        int i10 = 1;
        if (z10) {
            rVarB = new androidx.room.r(applicationContext, WorkDatabase.class, null);
            rVarB.i = true;
        } else {
            rVarB = q8.g.b(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            o oVar = new o();
            oVar.f5362a = applicationContext;
            VarHandle.storeStoreFence();
            rVarB.f1612h = oVar;
        }
        rVarB.f1610f = b0Var;
        androidx.room.p pVar = new androidx.room.p(i10);
        pVar.f1597b = jVar;
        VarHandle.storeStoreFence();
        rVarB.f1608d.add(pVar);
        rVarB.a(b.f5298h);
        e eVar = new e(i3, 3, i);
        eVar.f5337d = applicationContext;
        VarHandle.storeStoreFence();
        rVarB.a(eVar);
        rVarB.a(b.i);
        rVarB.a(b.f5299j);
        e eVar2 = new e(5, 6, i);
        eVar2.f5337d = applicationContext;
        VarHandle.storeStoreFence();
        rVarB.a(eVar2);
        rVarB.a(b.f5300k);
        rVarB.a(b.f5301l);
        rVarB.a(b.f5302m);
        int i11 = 10;
        e eVar3 = new e(9, i11, i10);
        eVar3.f5337d = applicationContext;
        VarHandle.storeStoreFence();
        rVarB.a(eVar3);
        e eVar4 = new e(i11, 11, i);
        eVar4.f5337d = applicationContext;
        VarHandle.storeStoreFence();
        rVarB.a(eVar4);
        rVarB.a(b.f5294d);
        rVarB.a(b.f5295e);
        rVarB.a(b.f5296f);
        rVarB.a(b.f5297g);
        e eVar5 = new e(21, 22, i);
        eVar5.f5337d = applicationContext;
        VarHandle.storeStoreFence();
        rVarB.a(eVar5);
        rVarB.f1619p = false;
        rVarB.f1620q = true;
        WorkDatabase workDatabase = (WorkDatabase) rVarB.b();
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        Context applicationContext3 = applicationContext2.getApplicationContext();
        applicationContext3.getClass();
        n5.a aVar3 = new n5.a(applicationContext3, iVar, 0);
        Context applicationContext4 = applicationContext2.getApplicationContext();
        applicationContext4.getClass();
        n5.a aVar4 = new n5.a(applicationContext4, iVar, 1);
        Context applicationContext5 = applicationContext2.getApplicationContext();
        applicationContext5.getClass();
        String str = n5.h.f8773a;
        n5.g gVar = new n5.g(applicationContext5, iVar);
        Object systemService = gVar.f8766b.getSystemService("connectivity");
        systemService.getClass();
        gVar.f8771f = (ConnectivityManager) systemService;
        gVar.f8772g = new d6.f(gVar, i10);
        VarHandle.storeStoreFence();
        Context applicationContext6 = applicationContext2.getApplicationContext();
        applicationContext6.getClass();
        n5.a aVar5 = new n5.a(applicationContext6, iVar, 2);
        ad.y yVar = new ad.y();
        yVar.f631a = applicationContext2;
        yVar.f632b = aVar3;
        yVar.f633c = aVar4;
        yVar.f634d = gVar;
        yVar.f635e = aVar5;
        VarHandle.storeStoreFence();
        Context applicationContext7 = context.getApplicationContext();
        d dVar = new d();
        dVar.f5316a = applicationContext7;
        dVar.f5317b = aVar;
        dVar.f5318c = iVar;
        dVar.f5319d = workDatabase;
        dVar.f5321f = new HashMap();
        dVar.f5320e = new HashMap();
        dVar.f5323h = new HashSet();
        dVar.i = new ArrayList();
        dVar.f5324j = new Object();
        dVar.f5322g = new HashMap();
        VarHandle.storeStoreFence();
        int i12 = s.f5379m;
        String str2 = i.f5347a;
        JobScheduler jobSchedulerA = k5.a.a(context);
        g5.j jVar2 = aVar.f4271d;
        boolean z11 = aVar.f4278l;
        k5.b bVar = new k5.b();
        bVar.f7246b = jVar2;
        bVar.f7245a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
        bVar.f7247c = z11;
        VarHandle.storeStoreFence();
        k5.c cVar = new k5.c();
        cVar.f7249c = context;
        cVar.f7250f = jobSchedulerA;
        cVar.f7251g = bVar;
        cVar.f7252h = workDatabase;
        cVar.i = aVar;
        VarHandle.storeStoreFence();
        q5.e.a(context, SystemJobService.class, true);
        g5.u.d().a(i.f5347a, "Created SystemJobScheduler and enabled SystemJobService");
        p5.e eVar6 = new p5.e(dVar, iVar);
        i5.c cVar2 = new i5.c();
        cVar2.f5786f = new HashMap();
        cVar2.i = new Object();
        cVar2.f5789j = k.a();
        cVar2.f5793n = new HashMap();
        cVar2.f5785c = context;
        a2.i iVar2 = aVar.f4274g;
        i5.a aVar6 = new i5.a();
        aVar6.f5778a = cVar2;
        aVar6.f5779b = iVar2;
        aVar6.f5780c = jVar2;
        aVar6.f5781d = new HashMap();
        VarHandle.storeStoreFence();
        cVar2.f5787g = aVar6;
        iVar2.getClass();
        p5.i iVar3 = new p5.i();
        iVar3.f9730c = iVar2;
        iVar3.f9731f = eVar6;
        iVar3.f9732g = new Object();
        iVar3.f9733h = new LinkedHashMap();
        VarHandle.storeStoreFence();
        cVar2.f5797r = iVar3;
        cVar2.f5796q = iVar;
        cVar2.f5795p = new ne.b(yVar);
        cVar2.f5792m = aVar;
        cVar2.f5790k = dVar;
        cVar2.f5791l = eVar6;
        VarHandle.storeStoreFence();
        List listF = ac.a.F(cVar, cVar2);
        Context applicationContext8 = context.getApplicationContext();
        r rVar = new r();
        rVar.f5377h = false;
        Context applicationContext9 = applicationContext8.getApplicationContext();
        jb.g gVar2 = null;
        if (applicationContext9.isDeviceProtectedStorage()) {
            od.f.e("Cannot initialize WorkManager in direct boot mode");
            return null;
        }
        g5.u uVar = new g5.u(aVar.f4275h);
        synchronized (g5.u.f4342b) {
            try {
                if (g5.u.f4343c == null) {
                    g5.u.f4343c = uVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        rVar.f5370a = applicationContext9;
        rVar.f5373d = iVar;
        rVar.f5372c = workDatabase;
        rVar.f5375f = dVar;
        rVar.f5378j = yVar;
        rVar.f5371b = aVar;
        rVar.f5374e = listF;
        pc.c cVarA = kc.w.a(pVarK);
        a2.i iVar4 = new a2.i(23);
        iVar4.f49f = workDatabase;
        VarHandle.storeStoreFence();
        rVar.f5376g = iVar4;
        g gVar3 = new g();
        gVar3.f5339c = b0Var;
        gVar3.f5340f = listF;
        gVar3.f5341g = aVar;
        gVar3.f5342h = workDatabase;
        VarHandle.storeStoreFence();
        dVar.a(gVar3);
        q5.b bVar2 = new q5.b();
        bVar2.f10077c = applicationContext9.getApplicationContext();
        bVar2.f10078f = rVar;
        bVar2.f10079g = iVar4;
        bVar2.f10080h = 0;
        VarHandle.storeStoreFence();
        iVar.q(bVar2);
        String str3 = m.f5352a;
        if (!q5.f.a(applicationContext9, aVar)) {
            VarHandle.storeStoreFence();
            return rVar;
        }
        p5.s sVarC = workDatabase.C();
        sVarC.getClass();
        androidx.room.x xVarD = androidx.room.x.d(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
        WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
        p5.r rVar2 = new p5.r();
        rVar2.f9790f = sVarC;
        rVar2.f9789c = xVarD;
        VarHandle.storeStoreFence();
        a9.e eVar7 = new a9.e(5);
        eVar7.f257f = rVar2;
        VarHandle.storeStoreFence();
        androidx.room.f fVarI = workDatabase_Impl.i();
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"workspec"}, 1);
        androidx.room.n0 n0Var = fVarI.f1525b;
        n0Var.getClass();
        lb.i iVar5 = new lb.i();
        for (String str4 : strArr) {
            HashMap map = n0Var.f1587b;
            String lowerCase = str4.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) map.get(lowerCase);
            if (set != null) {
                iVar5.addAll(set);
            } else {
                iVar5.add(str4);
            }
        }
        int i13 = 0;
        String[] strArr2 = (String[]) n(iVar5).toArray(new String[0]);
        int length = strArr2.length;
        int[] iArr = new int[length];
        while (true) {
            if (i13 >= length) {
                gVar2 = new jb.g(strArr2, iArr);
                break;
            }
            String str5 = strArr2[i13];
            LinkedHashMap linkedHashMap = n0Var.f1590e;
            String lowerCase2 = str5.toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            Integer num = (Integer) linkedHashMap.get(lowerCase2);
            if (num == null) {
                g5.f.s("There is no table with name ".concat(str5));
                break;
            }
            iArr[i13] = num.intValue();
            i13++;
        }
        String[] strArr3 = (String[]) gVar2.f6759c;
        int[] iArr2 = (int[]) gVar2.f6760f;
        strArr3.getClass();
        iArr2.getClass();
        nb.c cVar3 = null;
        nc.g gVarD = k0.d(k0.k(new androidx.lifecycle.i0(n0Var, iArr2, strArr3, cVar3, 1)), -1);
        int i14 = 1;
        nc.c0 c0Var = new nc.c0(i14);
        c0Var.f8829f = gVarD;
        c0Var.f8830g = workDatabase_Impl;
        c0Var.f8831h = eVar7;
        VarHandle.storeStoreFence();
        l lVar = new l(4, null);
        nc.n nVar = new nc.n(i14);
        nVar.f8888f = c0Var;
        nVar.f8889g = lVar;
        VarHandle.storeStoreFence();
        nc.g gVarG = k0.g(k0.d(nVar, -1));
        e9.g gVar4 = new e9.g(applicationContext9, null);
        nc.n nVar2 = new nc.n(4);
        nVar2.f8889g = gVarG;
        nVar2.f8888f = gVar4;
        VarHandle.storeStoreFence();
        kc.w.u(cVarA, null, null, new androidx.room.e(nVar2, cVar3, 6), 3);
        VarHandle.storeStoreFence();
        return rVar;
    }

    public static final float w(float f5) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f5) & 8589934591L) / 3)) + 709952852);
        float f10 = fIntBitsToFloat - ((fIntBitsToFloat - (f5 / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f10 - ((f10 - (f5 / (f10 * f10))) * 0.33333334f);
    }

    public static ad.m x(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        List listK = kb.s.f7404c;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            od.f.e("cipherSuite == null");
            return null;
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            od.f.l("cipherSuite == ".concat(cipherSuite));
            return null;
        }
        ad.g gVarC = ad.g.f485b.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            od.f.e("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            od.f.l("tlsVersion == NONE");
            return null;
        }
        j0 j0VarV = a.a.v(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
        }
        List listK2 = peerCertificates != null ? bd.b.k(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listK;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listK = bd.b.k(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new ad.m(j0VarV, gVarC, listK, new ad.l(listK2, 0));
    }

    public static final Rect y(TextPaint textPaint, CharSequence charSequence, int i, int i3) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.nextSpanTransition(i - 1, i3, MetricAffectingSpan.class) != i3) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i < i3) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i, i3, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    kb.b bVarD = yb.k.d(metricAffectingSpanArr);
                    while (bVarD.hasNext()) {
                        MetricAffectingSpan metricAffectingSpan = (MetricAffectingSpan) bVarD.next();
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    textPaint2.getTextBounds(charSequence, i, iNextSpanTransition, rect2);
                    rect.right = rect2.width() + rect.right;
                    rect.top = Math.min(rect.top, rect2.top);
                    rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    i = iNextSpanTransition;
                }
                return rect;
            }
        }
        Rect rect3 = new Rect();
        textPaint.getTextBounds(charSequence, i, i3, rect3);
        return rect3;
    }

    public static final i1.f z() {
        i1.f fVar = f5381b;
        if (fVar != null) {
            return fVar;
        }
        i1.e eVar = new i1.e("Filled.KeyboardArrowDown", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = i1.h0.f5700a;
        d1.l0 l0Var = new d1.l0(d1.p.f3019b);
        ArrayList arrayList = new ArrayList(32);
        arrayList.add(new i1.n(7.41f, 8.59f));
        arrayList.add(new i1.m(12.0f, 13.17f));
        arrayList.add(new i1.u(4.59f, -4.58f));
        arrayList.add(new i1.m(18.0f, 10.0f));
        arrayList.add(new i1.u(-6.0f, 6.0f));
        arrayList.add(new i1.u(-6.0f, -6.0f));
        arrayList.add(new i1.u(1.41f, -1.41f));
        arrayList.add(i1.j.f5707c);
        eVar.a(arrayList, 0, "", l0Var, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f);
        i1.f fVarD = eVar.d();
        f5381b = fVarD;
        return fVarD;
    }
}
