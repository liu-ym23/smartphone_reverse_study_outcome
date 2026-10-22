package stepos.support.v7.app;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.autofill.AutofillManager;
import java.lang.invoke.VarHandle;
import java.util.function.Supplier;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class f implements g, t, te.j, n3.s, n3.c, g6.a, u8.q, v3.f, y9.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12314c;

    /* renamed from: f, reason: collision with root package name */
    public Object f12315f;

    public f(w8.f fVar, int i) {
        this.f12314c = 9;
        this.f12315f = (i & 1) != 0 ? u8.g.f14207a : fVar;
        u8.p pVar = u8.p.f14243c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a7 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r15v9, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Iterable, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27, types: [int] */
    /* JADX WARN: Type inference failed for: r7v32 */
    @Override // u8.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.util.List r28, nb.c r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.f.a(java.util.List, nb.c):java.lang.Object");
    }

    @Override // v3.f
    public Object b(xb.p pVar, nb.c cVar) {
        return ((v3.f) this.f12315f).b(new y3.c(pVar, null, 0), cVar);
    }

    @Override // te.j
    public boolean c(te.l lVar, MenuItem menuItem) {
        return false;
    }

    @Override // te.j
    public void d(te.l lVar) {
        q0 q0Var = (q0) this.f12315f;
        p0 p0Var = q0Var.f12454c;
        if (p0Var != null) {
            if (q0Var.f12452a.f12871a.m()) {
                p0Var.onPanelClosed(108, lVar);
            } else if (p0Var.onPreparePanel(0, null, lVar)) {
                p0Var.onMenuOpened(108, lVar);
            }
        }
    }

    public y.m e(int i, int i3) {
        y.m mVar = new y.m();
        mVar.f15788a = i;
        mVar.f15789b = i3;
        if (i < 0) {
            g5.f.s("negative start index");
            return null;
        }
        if (i3 < i) {
            g5.f.s("end index greater than start");
            return null;
        }
        VarHandle.storeStoreFence();
        ((m0.e) this.f12315f).b(mVar);
        return mVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    public float f(int i) {
        Object obj;
        ?? r12 = ((x.r) this.f12315f).i().f15447j;
        if (r12.isEmpty()) {
            return 0.0f;
        }
        int size = r12.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = r12.get(i3);
            if (((x.n) obj).f15455a == i) {
                break;
            }
            i3++;
        }
        if (((x.n) obj) != null) {
            return r5.f15463j;
        }
        int size2 = r12.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size2; i11++) {
            i10 += ((x.n) r12.get(i11)).f15464k;
        }
        return ((i - r7.g()) * ((i10 / r12.size()) + r0.f15453p)) - r7.h();
    }

    public w7.l g() {
        return (w7.l) ((Supplier) this.f12315f).get();
    }

    @Override // v3.f
    public nc.g getData() {
        return ((v3.f) this.f12315f).getData();
    }

    @Override // y9.g
    public String getId() {
        a1.g gVar = y9.k.f16060c;
        return "gradient_blur";
    }

    public void h(View view, int i, boolean z10) {
        ((AutofillManager) this.f12315f).notifyViewVisibilityChanged(view, i, z10);
    }

    @Override // y9.g
    public y9.d i(View view, y9.j jVar) {
        aa.p pVar = (aa.p) jVar;
        view.getClass();
        pVar.getClass();
        ((f7.f) y9.k.f16060c.f19f).getClass();
        return f7.f.d(view, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.util.ArrayList r11, pb.c r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.f.j(java.util.ArrayList, pb.c):java.lang.Object");
    }

    @Override // y9.g
    public boolean k(Context context) {
        ((f7.f) y9.k.f16060c.f19f).getClass();
        return true;
    }

    @Override // n3.c
    public void m() {
        te.l lVar = ((te.m) this.f12315f).f13375n;
        lVar.f13349g = true;
        lVar.o(true);
    }

    @Override // stepos.support.v7.app.g
    public i newDialog(Context context, int i) {
        switch (this.f12314c) {
            case 0:
                h hVar = (h) this.f12315f;
                return new i(hVar.f12317a.f12293a, hVar.f12318b);
            default:
                f0 f0Var = ((h0) this.f12315f).f12328j;
                g0 g0Var = new g0(context, i);
                g0Var.f12316c = f0Var;
                return g0Var;
        }
    }

    @Override // y9.g
    public y9.j o() {
        aa.p pVar = new aa.p();
        y9.c cVar = (y9.c) this.f12315f;
        cVar.getClass();
        pVar.f350f = cVar.f16040a;
        pVar.f351g = cVar.f16041b;
        pVar.f352h = cVar.f16042c;
        pVar.i = cVar.f16043d;
        pVar.f353j = cVar.f16044e;
        pVar.f354k = cVar.f16045f;
        pVar.f355l = cVar.f16046g;
        return pVar;
    }

    @Override // n3.s
    public m1 p(View view, m1 m1Var) {
        view.setPadding(0, m1Var.d(), 0, 0);
        ((WebViewActivity) this.f12315f).f12263c = m1Var.a();
        return m1Var.f8737a.c();
    }

    public /* synthetic */ f(int i) {
        this.f12314c = i;
    }

    public f(Supplier supplier) {
        this.f12314c = 10;
        this.f12315f = supplier;
    }

    public f() {
        this.f12314c = 18;
        this.f12315f = null;
    }
}
