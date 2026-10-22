package a1;

import aa.p;
import ad.f0;
import ad.h0;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.t;
import androidx.fragment.app.v;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.stepos.common.drawble.ShadeBlurEntity;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import d1.q;
import d1.x;
import h.e0;
import h.o0;
import h0.d1;
import ie.l;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import l.d0;
import l.w;
import m.n;
import m.x1;
import n3.k0;
import n3.m1;
import n3.q0;
import n3.s;
import od.k;
import p5.m;
import r.l0;
import r.m0;
import r.p0;
import s.o;
import s.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements y9.g, d.b, s, w, q0, q, ie.f, l, x1, n, m4.e, x4.b, o {

    /* renamed from: g, reason: collision with root package name */
    public static g f17g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18c;

    /* renamed from: f, reason: collision with root package name */
    public Object f19f;

    public g(o2.c cVar) {
        this.f18c = 25;
        float f5 = p0.f10334a;
        l0 l0Var = new l0();
        l0Var.f10313a = f5;
        float fA = cVar.a();
        float f10 = m0.f10318a;
        l0Var.f10314b = fA * 386.0878f * 160.0f * 0.84f;
        VarHandle.storeStoreFence();
        this.f19f = l0Var;
    }

    public static e6.q v(z5.h hVar, e6.i iVar, c6.a aVar, c6.b bVar) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(iVar.f3547a.getResources(), bVar.f2209a);
        v5.f fVar = v5.f.f14784c;
        Map map = bVar.f2210b;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean z10 = false;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config config = i6.d.f5804a;
        if (hVar != null && hVar.f16461g) {
            z10 = true;
        }
        return new e6.q(bitmapDrawable, iVar, fVar, aVar, str, zBooleanValue, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0400 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList w(a1.g r38, java.lang.String r39) {
        /*
            Method dump skipped, instructions count: 1842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.g.w(a1.g, java.lang.String):java.util.ArrayList");
    }

    @Override // d.b
    public void a(Object obj) {
        v vVar = (v) this.f19f;
        t tVar = (t) vVar.f1327x.pollFirst();
        if (tVar == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
        } else {
            String str = tVar.f1303c;
            vVar.f1307c.a();
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    @Override // m4.e
    public void b() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // m4.e
    public void c(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f19f).setResultCode(i);
    }

    @Override // ie.l
    public Object convert(Object obj) {
        Charset charsetA;
        h0 h0Var = (h0) obj;
        f0 f0Var = h0Var.f511c;
        if (f0Var == null) {
            k kVarG = h0Var.g();
            ad.s sVarE = h0Var.e();
            if (sVarE == null || (charsetA = sVarE.a(hc.a.f5448a)) == null) {
                charsetA = hc.a.f5448a;
            }
            f0Var = new f0(kVarG, charsetA);
            h0Var.f511c = f0Var;
        }
        u7.a aVar = new u7.a(f0Var);
        aVar.f14161s = 2;
        try {
            Object obj2 = ((m7.n) this.f19f).read(aVar);
            if (aVar.Y() == u7.b.f14170n) {
                return obj2;
            }
            throw new m7.h("JSON document was not fully consumed.");
        } finally {
            h0Var.close();
        }
    }

    @Override // l.w
    public void d(l.l lVar, boolean z10) {
        switch (this.f18c) {
            case 11:
                ((e0) this.f19f).p(lVar);
                break;
            default:
                if (lVar instanceof d0) {
                    ((d0) lVar).f7544z.k().c(false);
                }
                w wVar = ((m.k) this.f19f).i;
                if (wVar != null) {
                    wVar.d(lVar, z10);
                    break;
                }
                break;
        }
    }

    @Override // d1.q
    public long e() {
        return ((d1) this.f19f).f4946b;
    }

    @Override // l.w
    public boolean f(l.l lVar) {
        switch (this.f18c) {
            case 11:
                Window.Callback callback = ((e0) this.f19f).f4795m.getCallback();
                if (callback == null) {
                    return true;
                }
                callback.onMenuOpened(108, lVar);
                return true;
            default:
                m.k kVar = (m.k) this.f19f;
                if (lVar != kVar.f7946g) {
                    ((d0) lVar).A.getClass();
                    w wVar = kVar.i;
                    if (wVar != null) {
                        return wVar.f(lVar);
                    }
                }
                return false;
        }
    }

    @Override // m.x1
    public void g(l.l lVar, MenuItem menuItem) {
        ((l.f) this.f19f).f7551j.removeCallbacksAndMessages(lVar);
    }

    @Override // s.o
    public y get(int i) {
        return (y) this.f19f;
    }

    @Override // y9.g
    public String getId() {
        return "gradient_blur";
    }

    @Override // n3.q0
    public void h() {
        ((View) ((o0) this.f19f).f4865d.getParent()).invalidate();
    }

    @Override // y9.g
    public y9.d i(View view, y9.j jVar) {
        p pVar = (p) jVar;
        view.getClass();
        pVar.getClass();
        ((f7.f) this.f19f).getClass();
        return f7.f.d(view, pVar);
    }

    @Override // x4.b
    public x4.a j(String str) {
        str.getClass();
        z4.c cVarW = ((y4.c) this.f19f).w();
        cVarW.getClass();
        p4.a aVar = new p4.a();
        aVar.f9697c = cVarW;
        return aVar;
    }

    @Override // y9.g
    public boolean k(Context context) {
        ((f7.f) this.f19f).getClass();
        return true;
    }

    @Override // ie.f
    public void l(ie.c cVar, ie.o0 o0Var) {
        ((kc.g) this.f19f).resumeWith(o0Var);
    }

    public f7.d m(f7.d dVar) {
        if (dVar instanceof f7.j) {
            return dVar;
        }
        float f5 = -((f7.i) this.f19f).e();
        f7.b bVar = new f7.b();
        while (dVar instanceof f7.b) {
            dVar = ((f7.b) dVar).f3930a;
            f5 += ((f7.b) dVar).f3931b;
        }
        bVar.f3930a = dVar;
        bVar.f3931b = f5;
        VarHandle.storeStoreFence();
        return bVar;
    }

    @Override // m.x1
    public void n(l.l lVar, l.n nVar) {
        l.f fVar = (l.f) this.f19f;
        Handler handler = fVar.f7551j;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = fVar.f7553l;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (lVar == ((l.e) arrayList.get(i)).f7546b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i3 = i + 1;
        l.e eVar = i3 < arrayList.size() ? (l.e) arrayList.get(i3) : null;
        com.stepos.statsrpk.c cVar = new com.stepos.statsrpk.c(2);
        cVar.i = this;
        cVar.f2853f = eVar;
        cVar.f2854g = nVar;
        cVar.f2855h = lVar;
        VarHandle.storeStoreFence();
        handler.postAtTime(cVar, lVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // y9.g
    public y9.j o() {
        return new p();
    }

    @Override // n3.s
    public m1 p(View view, m1 m1Var) {
        b3.a aVar;
        androidx.coordinatorlayout.widget.a aVar2 = (androidx.coordinatorlayout.widget.a) this.f19f;
        if (!Objects.equals(aVar2.f1027r, m1Var)) {
            aVar2.f1027r = m1Var;
            boolean z10 = m1Var.d() > 0;
            aVar2.f1028s = z10;
            aVar2.setWillNotDraw(!z10 && aVar2.getBackground() == null);
            if (!m1Var.f8737a.s()) {
                int childCount = aVar2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = aVar2.getChildAt(i);
                    WeakHashMap weakHashMap = k0.f8724a;
                    if (childAt.getFitsSystemWindows() && (aVar = ((b3.d) childAt.getLayoutParams()).f1877a) != null) {
                        m1Var = aVar.onApplyWindowInsets(aVar2, childAt, m1Var);
                        if (m1Var.f8737a.s()) {
                            break;
                        }
                    }
                }
            }
            aVar2.requestLayout();
        }
        return m1Var;
    }

    public r9.d q() {
        r9.c cVar = (r9.c) this.f19f;
        r9.d dVar = new r9.d();
        RuntimeShader runtimeShader = new RuntimeShader(ShadeBlurEntity.INSTANCE.getRuntimeShader());
        dVar.f10494a = runtimeShader;
        r9.b bVar = new r9.b(0);
        bVar.f10485b = dVar;
        VarHandle.storeStoreFence();
        dVar.f10499f = bVar;
        dVar.f10498e = cVar;
        runtimeShader.setFloatUniform("time", 0.0f);
        runtimeShader.setFloatUniform("glowRadius", cVar.f10489d);
        runtimeShader.setFloatUniform("glowIntensity", cVar.f10486a);
        runtimeShader.setFloatUniform("inner", cVar.f10488c ? 1.0f : -1.0f);
        runtimeShader.setColorUniform("rectColor", cVar.f10487b);
        runtimeShader.setFloatUniform("radius", cVar.f10490e);
        if (cVar.f10493h == 0) {
            dVar.b();
        } else {
            dVar.a();
        }
        VarHandle.storeStoreFence();
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0159 A[PHI: r16 r17
      0x0159: PHI (r16v3 c6.b) = (r16v0 c6.b), (r16v0 c6.b), (r16v0 c6.b), (r16v1 c6.b), (r16v1 c6.b), (r16v2 c6.b), (r16v2 c6.b), (r16v4 c6.b) binds: [B:86:0x013d, B:87:0x013f, B:90:0x0147, B:98:0x0154, B:99:0x0156, B:76:0x011a, B:78:0x0126, B:55:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r17v4 c6.b) = (r17v1 c6.b), (r17v1 c6.b), (r17v1 c6.b), (r17v2 c6.b), (r17v2 c6.b), (r17v3 c6.b), (r17v3 c6.b), (r17v5 c6.b) binds: [B:86:0x013d, B:87:0x013f, B:90:0x0147, B:98:0x0154, B:99:0x0156, B:76:0x011a, B:78:0x0126, B:55:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014a A[PHI: r16 r17 r18
      0x014a: PHI (r16v1 c6.b) = (r16v0 c6.b), (r16v0 c6.b), (r16v2 c6.b) binds: [B:90:0x0147, B:85:0x013b, B:78:0x0126] A[DONT_GENERATE, DONT_INLINE]
      0x014a: PHI (r17v2 c6.b) = (r17v1 c6.b), (r17v1 c6.b), (r17v3 c6.b) binds: [B:90:0x0147, B:85:0x013b, B:78:0x0126] A[DONT_GENERATE, DONT_INLINE]
      0x014a: PHI (r18v2 double) = (r18v1 double), (r18v1 double), (r18v3 double) binds: [B:90:0x0147, B:85:0x013b, B:78:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c6.b r(e6.i r18, c6.a r19, f6.g r20, f6.f r21) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.g.r(e6.i, c6.a, f6.g, f6.f):c6.b");
    }

    public void s(float f5, float f10, float f11, float f12) {
        m mVar = (m) this.f19f;
        d1.o oVarY = mVar.y();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (mVar.D() >> 32)) - (f11 + f5);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (mVar.D() & 4294967295L)) - (f12 + f10);
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        if (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) < 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) < 0.0f) {
            x.a("Width and height must be greater than or equal to zero");
        }
        mVar.R(jFloatToRawIntBits);
        oVarY.n(f5, f10);
    }

    @Override // ie.f
    public void t(ie.c cVar, Throwable th) {
        ((kc.g) this.f19f).resumeWith(id.c.l(th));
    }

    public c6.a u(e6.i iVar, Object obj, e6.m mVar, t5.c cVar) {
        String string;
        Map linkedHashMap;
        iVar.getClass();
        kb.s sVar = iVar.f3553g;
        List list = ((t5.g) this.f19f).f13197f.f13175c;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i < size) {
                jb.g gVar = (jb.g) list.get(i);
                a6.a aVar = (a6.a) gVar.f6759c;
                if (((Class) gVar.f6760f).isAssignableFrom(obj.getClass())) {
                    aVar.getClass();
                    switch (aVar.f225a) {
                        case 0:
                            File file = (File) obj;
                            string = file.getPath() + ':' + file.lastModified();
                            break;
                        default:
                            Uri uri = (Uri) obj;
                            if (yb.k.a(uri.getScheme(), "android.resource")) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(uri);
                                sb2.append('-');
                                Configuration configuration = mVar.f3573a.getResources().getConfiguration();
                                Bitmap.Config config = i6.d.f5804a;
                                sb2.append(configuration.uiMode & 48);
                                string = sb2.toString();
                                break;
                            } else {
                                string = uri.toString();
                                break;
                            }
                    }
                    if (string != null) {
                    }
                }
                i++;
            } else {
                string = null;
            }
        }
        if (string == null) {
            return null;
        }
        Map map = iVar.f3570y.f3591c;
        boolean zIsEmpty = map.isEmpty();
        kb.t tVar = kb.t.f7405c;
        if (zIsEmpty) {
            linkedHashMap = tVar;
        } else {
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                String str = ((e6.o) entry.getValue()).f3589b;
                if (str != null) {
                    linkedHashMap.put(entry.getKey(), str);
                }
            }
        }
        sVar.getClass();
        return linkedHashMap.isEmpty() ? new c6.a(string, tVar) : new c6.a(string, new LinkedHashMap(linkedHashMap));
    }

    public void x(int i) throws Resources.NotFoundException {
        ((Application) this.f19f).getResources().getResourceName(i);
    }

    public void y(float f5, float f10, long j10) {
        d1.o oVarY = ((m) this.f19f).y();
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        oVarY.n(Float.intBitsToFloat(i), Float.intBitsToFloat(i3));
        oVarY.c(f5, f10);
        oVarY.n(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i3));
    }

    public void z(float f5, float f10) {
        ((m) this.f19f).y().n(f5, f10);
    }

    public /* synthetic */ g(Object obj, int i) {
        this.f18c = i;
        this.f19f = obj;
    }

    public g(y4.c cVar) {
        this.f18c = 23;
        cVar.getClass();
        this.f19f = cVar;
    }

    public /* synthetic */ g(int i, boolean z10) {
        this.f18c = i;
    }

    public g(int i) {
        this.f18c = i;
        switch (i) {
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                r9.c cVar = new r9.c();
                cVar.f10493h = 1;
                this.f19f = cVar;
                break;
            default:
                this.f19f = new d1.a();
                break;
        }
    }
}
