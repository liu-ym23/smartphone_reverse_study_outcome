package a;

import ad.j0;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.provider.Settings;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import c1.c;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import d1.l0;
import d1.p;
import d2.q;
import e2.h;
import f2.d;
import f7.i;
import hc.o;
import i1.e;
import i1.f;
import i1.h0;
import i1.j;
import i1.m;
import i1.n;
import i1.u;
import id.k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.invoke.VarHandle;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import jb.g;
import k0.c1;
import k0.v1;
import k0.y0;
import k0.z;
import kb.s;
import n3.t;
import n6.b;
import o1.d0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s1.f0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static f f0a;

    public static final long A(long j10) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) / 2.0f;
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final f B() {
        f fVar = f0a;
        if (fVar != null) {
            return fVar;
        }
        e eVar = new e("Filled.Check", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = h0.f5700a;
        l0 l0Var = new l0(p.f3019b);
        ArrayList arrayList = new ArrayList(32);
        arrayList.add(new n(9.0f, 16.17f));
        arrayList.add(new m(4.83f, 12.0f));
        arrayList.add(new u(-1.42f, 1.41f));
        arrayList.add(new m(9.0f, 19.0f));
        arrayList.add(new m(21.0f, 7.0f));
        arrayList.add(new u(-1.41f, -1.41f));
        arrayList.add(j.f5707c);
        eVar.a(arrayList, 0, "", l0Var, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f);
        f fVarD = eVar.d();
        f0a = fVarD;
        return fVarD;
    }

    public static final float C(Layout layout, int i, Paint paint) {
        float fAbs;
        float width;
        float lineLeft = layout.getLineLeft(i);
        h hVar = e2.j.f3449a;
        if (layout.getEllipsisCount(i) <= 0 || layout.getParagraphDirection(i) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float fMeasureText = paint.measureText("…") + (layout.getPrimaryHorizontal(layout.getEllipsisStart(i) + layout.getLineStart(i)) - lineLeft);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if ((paragraphAlignment == null ? -1 : d.f3873a[paragraphAlignment.ordinal()]) == 1) {
            fAbs = Math.abs(lineLeft);
            width = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            fAbs = Math.abs(lineLeft);
            width = layout.getWidth() - fMeasureText;
        }
        return width + fAbs;
    }

    public static final float D(Layout layout, int i, Paint paint) {
        float width;
        float width2;
        h hVar = e2.j.f3449a;
        if (layout.getEllipsisCount(i) <= 0) {
            return 0.0f;
        }
        if (layout.getParagraphDirection(i) != -1 || layout.getWidth() >= layout.getLineRight(i)) {
            return 0.0f;
        }
        float fMeasureText = paint.measureText("…") + (layout.getLineRight(i) - layout.getPrimaryHorizontal(layout.getEllipsisStart(i) + layout.getLineStart(i)));
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if ((paragraphAlignment != null ? d.f3873a[paragraphAlignment.ordinal()] : -1) == 1) {
            width = layout.getWidth() - layout.getLineRight(i);
            width2 = (layout.getWidth() - fMeasureText) / 2.0f;
        } else {
            width = layout.getWidth() - layout.getLineRight(i);
            width2 = layout.getWidth() - fMeasureText;
        }
        return width - width2;
    }

    public static t E(Display display, int i) {
        int i3;
        RoundedCorner roundedCorner = display.getRoundedCorner(i);
        if (roundedCorner == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i3 = 1;
            if (position != 1) {
                i3 = 2;
                if (position != 2) {
                    i3 = 3;
                    if (position != 3) {
                        g5.f.s(k0.a.j(position, "Invalid position: "));
                        return null;
                    }
                }
            }
        } else {
            i3 = 0;
        }
        int radius = roundedCorner.getRadius();
        Point center = roundedCorner.getCenter();
        int i10 = center.x;
        int i11 = center.y;
        t tVar = new t();
        tVar.f8750a = i3;
        tVar.f8751b = radius;
        tVar.f8752c = new Point(i10, i11);
        VarHandle.storeStoreFence();
        return tVar;
    }

    public static final int I(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        g5.f.s(k0.a.k(i, "Could not convert ", " to BackoffPolicy"));
        return 0;
    }

    public static final int J(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        g5.f.s(k0.a.k(i, "Could not convert ", " to NetworkType"));
        return 0;
    }

    public static final int K(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        g5.f.s(k0.a.k(i, "Could not convert ", " to OutOfQuotaPolicy"));
        return 0;
    }

    public static final int L(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        g5.f.s(k0.a.k(i, "Could not convert ", " to State"));
        return 0;
    }

    public static final boolean M(androidx.room.a aVar, int i, int i3) {
        aVar.getClass();
        if (i > i3 && aVar.f1494l) {
            return false;
        }
        Set set = aVar.f1495m;
        return aVar.f1493k && (set == null || !set.contains(Integer.valueOf(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ad.c N(ad.n r26) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.N(ad.n):ad.c");
    }

    public static k6.e O(k6.d dVar, String str, int i) {
        if (i >= str.length()) {
            return null;
        }
        int length = str.length() - i;
        char cCharAt = str.charAt(i);
        if (cCharAt == 'Z' || cCharAt == 'z') {
            k(dVar, str, i);
            return k6.e.f7269c;
        }
        char cCharAt2 = str.charAt(i);
        if (cCharAt2 != '+' && cCharAt2 != '-') {
            k.M(str, i, 'Z', 'z', '+', '-');
            throw null;
        }
        if (length < 6) {
            throw new DateTimeParseException("Invalid timezone offset: ".concat(str), str, i);
        }
        int iB = b.b(i + 1, i + 3, str);
        int iB2 = b.b(i + 4, i + 6, str);
        if (cCharAt2 == '-') {
            iB = -iB;
            iB2 = -iB2;
            if (iB == 0 && iB2 == 0) {
                throw new DateTimeParseException("Unknown 'Local Offset Convention' date-time not allowed", str, i);
            }
        }
        k(dVar, str, i + 5);
        return new k6.e(iB, iB2);
    }

    public static Long P(ContentResolver contentResolver) {
        String string;
        String string2 = Settings.Global.getString(contentResolver, "stepos_agentsafetycenter_screen_perception_switch_deadline_epoch_ms");
        if (string2 != null && (string = hc.h.w0(string2).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return o.W(string);
            }
        }
        return null;
    }

    public static g Q(ContentResolver contentResolver) {
        Object next;
        i9.h hVarR = R(contentResolver);
        if (hVarR == null) {
            return new g(Boolean.FALSE, i9.b.f5834g);
        }
        f8.b bVar = i9.b.f5833f;
        String str = hVarR.f5864b;
        bVar.getClass();
        Iterator it = i9.b.f5837k.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((i9.b) next).f5838c.equals(str)) {
                break;
            }
        }
        i9.b bVar2 = (i9.b) next;
        if (bVar2 == null) {
            bVar2 = i9.b.f5834g;
        }
        return new g(Boolean.valueOf(hVarR.f5863a), bVar2);
    }

    public static i9.h R(ContentResolver contentResolver) {
        String string;
        String string2 = Settings.Global.getString(contentResolver, "stepos_agentsafetycenter_screen_perception_enabled");
        if (string2 == null || (string = Settings.Global.getString(contentResolver, "stepos_agentsafetycenter_screen_perception_authorization_scope")) == null) {
            return null;
        }
        Long lP = P(contentResolver);
        boolean zEquals = string2.equals("1");
        i9.h hVar = new i9.h();
        hVar.f5863a = zEquals;
        hVar.f5864b = string;
        hVar.f5865c = lP;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public static final void S(Object[] objArr, int i, int i3) {
        objArr.getClass();
        while (i < i3) {
            objArr[i] = null;
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kb.s] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.ArrayList] */
    public static final g T(Map map) {
        ?? arrayList;
        Object obj = map.get("path");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("paths");
        if (obj2 instanceof List) {
            arrayList = new ArrayList();
            for (Object obj3 : (Iterable) obj2) {
                if (obj3 instanceof String) {
                    arrayList.add(obj3);
                }
            }
        } else {
            arrayList = s.f7404c;
        }
        return new g(str, arrayList.isEmpty() ? null : arrayList);
    }

    public static final o2.j U(c cVar) {
        return new o2.j(Math.round(cVar.f2167a), Math.round(cVar.f2168b), Math.round(cVar.f2169c), Math.round(cVar.f2170d));
    }

    public static void V(View view, i iVar) {
        z6.a aVar = iVar.f3954f.f3938c;
        if (aVar == null || !aVar.f16463a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        f7.g gVar = iVar.f3954f;
        if (gVar.f3947m != elevation) {
            gVar.f3947m = elevation;
            iVar.o();
        }
    }

    public static final int W(int i) {
        if (i == 0) {
            throw null;
        }
        int iC = s.f.c(i);
        if (iC == 0) {
            return 0;
        }
        int i3 = 1;
        if (iC != 1) {
            i3 = 2;
            if (iC != 2) {
                i3 = 3;
                if (iC != 3) {
                    i3 = 4;
                    if (iC != 4) {
                        if (iC == 5) {
                            return 5;
                        }
                        g5.f.a();
                        return 0;
                    }
                }
            }
        }
        return i3;
    }

    public static final String X(int i) {
        if (i == 0) {
            return "0";
        }
        char[] cArr = pd.b.f9998a;
        int i3 = 0;
        char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
        while (i3 < 8 && cArr2[i3] == '0') {
            i3++;
        }
        if (i3 < 0) {
            g5.f.q(k0.a.k(i3, "startIndex: ", ", endIndex: 8, size: 8"));
            return null;
        }
        if (i3 <= 8) {
            return new String(cArr2, i3, 8 - i3);
        }
        g5.f.s(k0.a.k(i3, "startIndex: ", " > endIndex: 8"));
        return null;
    }

    public static final JSONObject Y(g9.o oVar) throws JSONException {
        oVar.getClass();
        JSONObject jSONObjectPut = new JSONObject().put("group_id", oVar.f4548a).put("current_mode", oVar.f4552e).put("available_modes", new JSONArray((Collection) oVar.f4551d));
        jSONObjectPut.getClass();
        return jSONObjectPut;
    }

    public static final String Z(g9.p pVar) {
        pVar.getClass();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayListU = u(pVar);
        int size = arrayListU.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListU.get(i);
            i++;
            jSONArray.put(Y((g9.o) obj));
        }
        String string = new JSONObject().put("groups", jSONArray).toString();
        string.getClass();
        return string;
    }

    public static h1.a a(d1.e eVar, int i) {
        Bitmap bitmap = eVar.f2966a;
        h1.a aVar = new h1.a(eVar, (bitmap.getWidth() << 32) | (bitmap.getHeight() & 4294967295L));
        aVar.f5273k = i;
        return aVar;
    }

    public static final q5.d a0(byte[] bArr) throws IOException {
        bArr.getClass();
        if (bArr.length == 0) {
            return new q5.d(null);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                int i = objectInputStream.readInt();
                int[] iArr = new int[i];
                for (int i3 = 0; i3 < i; i3++) {
                    iArr[i3] = objectInputStream.readInt();
                }
                int i10 = objectInputStream.readInt();
                int[] iArr2 = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr2[i11] = objectInputStream.readInt();
                }
                q5.d dVarN = td.h.n(iArr2, iArr);
                objectInputStream.close();
                byteArrayInputStream.close();
                return dVarN;
            } finally {
            }
        } finally {
        }
    }

    public static final void b(d2.g gVar, w0.m mVar, d2.l0 l0Var, boolean z10, int i, int i3, l lVar, l lVar2, k0.s sVar, int i10) {
        l lVar3;
        w0.m mVar2;
        int i11;
        boolean z11;
        int i12;
        sVar.Z(-246609449);
        int i13 = i10 | (sVar.f(gVar) ? 4 : 2) | 1797168 | (sVar.h(lVar2) ? 8388608 : 4194304);
        if ((4793491 & i13) == 4793490 && sVar.B()) {
            sVar.S();
            mVar2 = mVar;
            z11 = z10;
            i11 = i;
            i12 = i3;
            lVar3 = lVar;
        } else {
            b0.l lVar4 = b0.l.f1760f;
            Object objM = sVar.M();
            nb.c cVar = null;
            y0 y0Var = k0.m.f6974a;
            if (objM == y0Var) {
                objM = z.v(null);
                sVar.i0(objM);
            }
            c1 c1Var = (c1) objM;
            boolean z12 = (29360128 & i13) == 8388608;
            Object objM2 = sVar.M();
            if (z12 || objM2 == y0Var) {
                objM2 = new androidx.lifecycle.l0(c1Var, lVar2, cVar, 1);
                sVar.i0(objM2);
            }
            w0.j jVar = w0.j.f15113c;
            w0.m mVarA = d0.a(jVar, lVar2, (xb.p) objM2);
            Object objM3 = sVar.M();
            if (objM3 == y0Var) {
                objM3 = new b0.f(c1Var, 2);
                sVar.i0(objM3);
            }
            td.h.a(gVar, mVarA, l0Var, (l) objM3, 1, true, Reader.READ_DONE, 0, null, sVar, (i13 & 58254) | 1769472, 896);
            lVar3 = lVar4;
            mVar2 = jVar;
            i11 = 1;
            z11 = true;
            i12 = Integer.MAX_VALUE;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.m(gVar, mVar2, l0Var, z11, i11, i12, lVar3, lVar2, i10);
        }
    }

    public static final g b0(g gVar) {
        String string;
        String str = (String) gVar.f6759c;
        List list = (List) gVar.f6760f;
        ArrayList arrayList = null;
        if (str == null || (string = hc.h.w0(str).toString()) == null || string.length() <= 0) {
            string = null;
        }
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(kb.m.m0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k0.a.A((String) it.next(), arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                if (((String) obj).length() > 0) {
                    arrayList3.add(obj);
                }
            }
            if (!arrayList3.isEmpty()) {
                arrayList = arrayList3;
            }
        }
        return new g(string, arrayList);
    }

    public static final a0.b c(float f5) {
        a0.b bVar = new a0.b();
        bVar.f1a = f5;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public static boolean c0(Context context, boolean z10, String str, Long l2) {
        boolean zL0 = ac.a.l0(z10, str, l2);
        if (!zL0) {
            Log.w("ScrPerceptGlobal", "writeGlobalPolicy via AppPlatform failed");
        }
        return zL0;
    }

    public static final void d(boolean z10, xb.a aVar, w0.m mVar, boolean z11, s0.c cVar, s0.c cVar2, k0.s sVar, int i) {
        int i3;
        aVar.getClass();
        sVar.Z(2010403168);
        if ((i & 6) == 0) {
            i3 = (sVar.g(z10) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(aVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.f(mVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        int i10 = i3 | 3072;
        if ((i & 24576) == 0) {
            i10 |= sVar.h(cVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= sVar.h(cVar2) ? 131072 : 65536;
        }
        if (sVar.P(i10 & 1, (74899 & i10) != 74898)) {
            p5.f.a(z10, aVar, sVar, i10 & 112);
            w0.m mVarD = mVar.d(androidx.compose.foundation.layout.c.f904c);
            f0 f0VarE = w.p.e(w0.b.f15089c, false);
            int iHashCode = Long.hashCode(sVar.T);
            s0.g gVarL = sVar.l();
            w0.m mVarM = t.o.m(sVar, mVarD);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            z.B(f0VarE, sVar, u1.i.f13836e);
            z.B(gVarL, sVar, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            z.B(mVarM, sVar, u1.i.f13834c);
            cVar.invoke(sVar, Integer.valueOf((i10 >> 12) & 14));
            cVar2.invoke(sVar, Integer.valueOf((i10 >> 15) & 14));
            sVar.q(true);
            z11 = true;
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            n9.d dVar = new n9.d();
            dVar.f8792c = z10;
            dVar.f8793f = aVar;
            dVar.f8794g = mVar;
            dVar.f8795h = z11;
            dVar.i = cVar;
            dVar.f8796j = cVar2;
            dVar.f8797k = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = dVar;
        }
    }

    public static final long e(float f5, float f10) {
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public static final ExecutorService f(boolean z10) {
        g5.b bVar = new g5.b();
        bVar.f4281f = z10;
        bVar.f4280c = new AtomicInteger(0);
        VarHandle.storeStoreFence();
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), bVar);
        executorServiceNewFixedThreadPool.getClass();
        return executorServiceNewFixedThreadPool;
    }

    public static final void g(dd.a aVar, dd.c cVar, String str) {
        dd.d dVar = dd.d.f3311h;
        dd.d.i.fine(cVar.f3306b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f3299a);
    }

    public static final String h(Object[] objArr, int i, int i3, kb.f fVar) {
        StringBuilder sb2 = new StringBuilder((i3 * 3) + 2);
        sb2.append("[");
        for (int i10 = 0; i10 < i3; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object obj = objArr[i + i10];
            if (obj == fVar) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(obj);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static final boolean i(byte[] bArr, int i, int i3, byte[] bArr2, int i10) {
        bArr.getClass();
        bArr2.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11 + i] != bArr2[i11 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final boolean j(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (!(obj instanceof String)) {
            return ((obj instanceof Number) && ((Number) obj).intValue() == 0) ? false : true;
        }
        Boolean boolV0 = hc.h.v0((String) obj);
        if (boolV0 != null) {
            return boolV0.booleanValue();
        }
        return true;
    }

    public static void k(k6.d dVar, String str, int i) {
        dVar.getClass();
        int i3 = i + 1;
        if (str.length() > i3) {
            throw new DateTimeParseException(String.format("Trailing junk data after position %d: %s", Integer.valueOf(i + 2), str), str, i3);
        }
    }

    public static final LinkedHashSet l(byte[] bArr) throws IOException {
        ObjectInputStream objectInputStream;
        bArr.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                int i = objectInputStream.readInt();
                for (int i3 = 0; i3 < i; i3++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean z10 = objectInputStream.readBoolean();
                    uri.getClass();
                    g5.c cVar = new g5.c();
                    cVar.f4282a = uri;
                    cVar.f4283b = z10;
                    VarHandle.storeStoreFence();
                    linkedHashSet.add(cVar);
                }
                objectInputStream.close();
                byteArrayInputStream.close();
                return linkedHashSet;
            } finally {
            }
        } finally {
        }
    }

    public static final void m(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final void n(int i, int i3) {
        if (i <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i3 + ").");
    }

    public static td.h o(int i) {
        return i != 0 ? i != 1 ? new f7.k() : new f7.e() : new f7.k();
    }

    public static final qb.b p(Enum[] enumArr) {
        qb.b bVar = new qb.b();
        bVar.f10215f = enumArr;
        VarHandle.storeStoreFence();
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e A[EDGE_INSN: B:45:0x008e->B:41:0x008e BREAK  A[LOOP:0: B:11:0x0014->B:49:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List q(androidx.room.t r9, int r10, int r11) {
        /*
            r9.getClass()
            if (r10 != r11) goto L8
            kb.s r9 = kb.s.f7404c
            return r9
        L8:
            r0 = 0
            r1 = 1
            if (r11 <= r10) goto Le
            r2 = r1
            goto Lf
        Le:
            r2 = r0
        Lf:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L14:
            if (r2 == 0) goto L19
            if (r10 >= r11) goto L8f
            goto L1b
        L19:
            if (r10 <= r11) goto L8f
        L1b:
            java.util.LinkedHashMap r4 = r9.f1627b
            r5 = 0
            if (r2 == 0) goto L38
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r6)
            java.util.TreeMap r4 = (java.util.TreeMap) r4
            if (r4 != 0) goto L2e
        L2c:
            r7 = r5
            goto L4e
        L2e:
            java.util.NavigableSet r6 = r4.descendingKeySet()
            jb.g r7 = new jb.g
            r7.<init>(r4, r6)
            goto L4e
        L38:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r6)
            java.util.TreeMap r4 = (java.util.TreeMap) r4
            if (r4 != 0) goto L45
            goto L2c
        L45:
            java.util.Set r6 = r4.keySet()
            jb.g r7 = new jb.g
            r7.<init>(r4, r6)
        L4e:
            if (r7 != 0) goto L51
            goto L8e
        L51:
            java.lang.Object r4 = r7.f6759c
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r6 = r7.f6760f
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L5d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8b
            java.lang.Object r7 = r6.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r2 == 0) goto L76
            int r8 = r10 + 1
            if (r8 > r7) goto L5d
            if (r7 > r11) goto L5d
            goto L7a
        L76:
            if (r11 > r7) goto L5d
            if (r7 >= r10) goto L5d
        L7a:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            java.lang.Object r10 = r4.get(r10)
            r10.getClass()
            r3.add(r10)
            r4 = r1
            r10 = r7
            goto L8c
        L8b:
            r4 = r0
        L8c:
            if (r4 != 0) goto L14
        L8e:
            return r5
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.q(androidx.room.t, int, int):java.util.List");
    }

    public static final int r(int i, List list) {
        int i3;
        int i10 = ((q) kb.l.C0(list)).f3161c;
        if (i > ((q) kb.l.C0(list)).f3161c) {
            i2.a.a("Index " + i + " should be less or equal than last line's end " + i10);
        }
        int size = list.size() - 1;
        int i11 = 0;
        while (true) {
            if (i11 > size) {
                i3 = -(i11 + 1);
                break;
            }
            i3 = (i11 + size) >>> 1;
            q qVar = (q) list.get(i3);
            char c9 = qVar.f3160b > i ? (char) 1 : qVar.f3161c <= i ? (char) 65535 : (char) 0;
            if (c9 >= 0) {
                if (c9 <= 0) {
                    break;
                }
                size = i3 - 1;
            } else {
                i11 = i3 + 1;
            }
        }
        if (i3 >= 0 && i3 < list.size()) {
            return i3;
        }
        StringBuilder sbT = k0.a.t(i3, "Found paragraph index ", " should be in range [0, ");
        sbT.append(list.size());
        sbT.append(").\nDebug info: index=");
        sbT.append(i);
        sbT.append(", paragraphs=[");
        sbT.append(q2.a.a(list, null, new a9.d(15), 31));
        sbT.append(']');
        i2.a.a(sbT.toString());
        return i3;
    }

    public static final int s(int i, List list) {
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i10 = (i3 + size) >>> 1;
            q qVar = (q) list.get(i10);
            char c9 = qVar.f3162d > i ? (char) 1 : qVar.f3163e <= i ? (char) 65535 : (char) 0;
            if (c9 < 0) {
                i3 = i10 + 1;
            } else {
                if (c9 <= 0) {
                    return i10;
                }
                size = i10 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final int t(ArrayList arrayList, float f5) {
        if (f5 <= 0.0f) {
            return 0;
        }
        if (f5 >= ((q) kb.l.C0(arrayList)).f3165g) {
            return arrayList.size() - 1;
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i3 = (i + size) >>> 1;
            q qVar = (q) arrayList.get(i3);
            char c9 = qVar.f3164f > f5 ? (char) 1 : qVar.f3165g <= f5 ? (char) 65535 : (char) 0;
            if (c9 < 0) {
                i = i3 + 1;
            } else {
                if (c9 <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i + 1);
    }

    public static final ArrayList u(g9.p pVar) {
        pVar.getClass();
        List list = pVar.f4572a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kb.q.p0(((g9.n) it.next()).f4539c, arrayList);
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static j0 v(String str) {
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return j0.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return j0.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return j0.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return j0.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return j0.SSL_3_0;
        }
        g5.f.s("Unexpected TLS version: ".concat(str));
        return null;
    }

    public static final String w(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - 500000000) / 1000000000) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - 500000) / 1000000) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - 500) / 1000) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + 500) / 1000) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + 500000) / 1000000) + " ms";
        } else {
            str = ((j10 + 500000000) / 1000000000) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public static c0.b x(c0.b bVar, o2.l lVar, d2.l0 l0Var, o2.c cVar, g2.d dVar) {
        if (bVar != null && lVar == bVar.f2096a && yb.k.a(l0Var, bVar.f2097b) && cVar.a() == bVar.f2098c.a() && dVar == bVar.f2099d) {
            return bVar;
        }
        c0.b bVar2 = c0.b.f2095h;
        if (bVar2 != null && lVar == bVar2.f2096a && yb.k.a(l0Var, bVar2.f2097b) && cVar.a() == bVar2.f2098c.a() && dVar == bVar2.f2099d) {
            return bVar2;
        }
        d2.l0 l0VarO = h5.t.O(l0Var, lVar);
        c0.b bVar3 = new c0.b();
        bVar3.f2096a = lVar;
        bVar3.f2097b = l0VarO;
        bVar3.f2098c = cVar;
        bVar3.f2099d = dVar;
        bVar3.f2100e = h5.t.O(l0VarO, lVar);
        bVar3.f2101f = Float.NaN;
        bVar3.f2102g = Float.NaN;
        VarHandle.storeStoreFence();
        c0.b.f2095h = bVar3;
        return bVar3;
    }

    public static Account y(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.stepos.account");
        Log.e("[Cloud]Account.SDK", "getAccount length: " + accountsByType.length);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            Log.e("[Cloud]Account.SDK", "more than 1 stepos account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public static final int z(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                Bitmap.Config config = bitmap.getConfig();
                return height * (config == Bitmap.Config.ALPHA_8 ? 1 : (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) ? 2 : config == Bitmap.Config.RGBA_F16 ? 8 : 4);
            }
        }
        StringBuilder sb2 = new StringBuilder("Cannot obtain size for recycled bitmap: ");
        sb2.append(bitmap);
        int width = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap.Config config2 = bitmap.getConfig();
        sb2.append(" [");
        sb2.append(width);
        sb2.append(" x ");
        sb2.append(height2);
        sb2.append("] + ");
        sb2.append(config2);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public abstract int F(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int G();

    public abstract ViewPropertyAnimator H(int i, View view);
}
