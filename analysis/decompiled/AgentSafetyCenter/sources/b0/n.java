package b0;

import android.graphics.Rect;
import android.view.MotionEvent;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import d1.k0;
import d2.i0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import k0.c1;
import k0.r2;
import p.f0;
import s.c0;
import s.d1;
import s.e0;
import s.e1;
import s.p1;
import s.z0;
import s1.f1;
import s1.n0;
import s1.o0;
import s1.s0;
import t.b1;
import u.o1;
import u.p0;
import u.t0;
import u1.g0;
import u1.l0;
import v1.a1;
import v1.u1;
import w.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1771c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1772f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1773g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i, Object obj, Object obj2) {
        super(1);
        this.f1771c = i;
        this.f1772f = obj;
        this.f1773g = obj2;
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [xb.l, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f1771c;
        int i3 = 0;
        jb.v vVar = jb.v.f6774a;
        Object obj2 = this.f1773g;
        Object obj3 = this.f1772f;
        switch (i) {
            case 0:
                long j10 = ((c1.b) obj).f2165a;
                i0 i0Var = (i0) ((c1) obj3).getValue();
                if (i0Var != null) {
                    xb.l lVar = (xb.l) obj2;
                    ArrayList arrayList = i0Var.f3123b.f3156h;
                    d2.q qVar = (d2.q) arrayList.get(a.a.t(arrayList, Float.intBitsToFloat((int) (j10 & 4294967295L))));
                    int i10 = qVar.f3161c;
                    int offsetForHorizontal = qVar.f3160b;
                    if (i10 - offsetForHorizontal != 0) {
                        d2.a aVar = qVar.f3159a;
                        long jFloatToRawIntBits = (Float.floatToRawIntBits(Float.intBitsToFloat(r1) - qVar.f3164f) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j10 >> 32))) << 32);
                        e2.i iVar = aVar.f3039d;
                        int lineForVertical = iVar.f3438e.getLineForVertical(((int) Float.intBitsToFloat((int) (4294967295L & jFloatToRawIntBits))) - iVar.f3440g);
                        offsetForHorizontal += iVar.f3438e.getOffsetForHorizontal(lineForVertical, (iVar.b(lineForVertical) * (-1)) + Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)));
                    }
                    lVar.invoke(Integer.valueOf(offsetForHorizontal));
                }
                return vVar;
            case 1:
                n0 n0Var = (n0) obj;
                ArrayList arrayListG = td.h.g((List) obj3, ((o) obj2).f1774a);
                if (arrayListG != null) {
                    int size = arrayListG.size();
                    while (i3 < size) {
                        jb.g gVar = (jb.g) arrayListG.get(i3);
                        o0 o0Var = (o0) gVar.f6759c;
                        xb.a aVar2 = (xb.a) gVar.f6760f;
                        n0.k(n0Var, o0Var, aVar2 != null ? ((o2.i) aVar2.invoke()).f9116a : 0L);
                        i3++;
                    }
                }
                return vVar;
            case 2:
                n0 n0Var2 = (n0) obj;
                List list = (List) obj3;
                if (list != null) {
                    int size2 = list.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        jb.g gVar2 = (jb.g) list.get(i11);
                        n0.k(n0Var2, (o0) gVar2.f6759c, ((o2.i) gVar2.f6760f).f9116a);
                    }
                }
                List list2 = (List) obj2;
                if (list2 != null) {
                    int size3 = list2.size();
                    while (i3 < size3) {
                        jb.g gVar3 = (jb.g) list2.get(i3);
                        o0 o0Var2 = (o0) gVar3.f6759c;
                        xb.a aVar3 = (xb.a) gVar3.f6760f;
                        n0.k(n0Var2, o0Var2, aVar3 != null ? ((o2.i) aVar3.invoke()).f9116a : 0L);
                        i3++;
                    }
                }
                return vVar;
            case 3:
                n0.o((n0) obj, (o0) obj3, 0, 0, ((d1.m) obj2).f3014s, 4);
                return vVar;
            case 4:
                n0.o((n0) obj, (o0) obj3, 0, 0, ((k0) obj2).D, 4);
                return vVar;
            case 5:
                int iIntValue = ((Number) obj).intValue();
                return ((d2.x) obj3).invoke(Integer.valueOf(iIntValue), ((List) obj2).get(iIntValue));
            case 6:
                w.a0 a0Var = new w.a0();
                a0Var.f14949a = (y0) obj2;
                a0Var.f14950b = (y0) obj;
                VarHandle.storeStoreFence();
                ((i0.c) obj3).f5596a.setValue(a0Var);
                return vVar;
            case 7:
                Throwable th = (Throwable) obj;
                if (th instanceof h5.u) {
                    ((g5.t) obj3).f4340c.compareAndSet(-256, ((h5.u) th).f5384c);
                }
                ((l7.a) obj2).cancel(false);
                return vVar;
            case 8:
                int iIntValue2 = ((Number) obj).intValue();
                return ((d2.x) obj3).invoke(Integer.valueOf(iIntValue2), ((List) obj2).get(iIntValue2));
            case 9:
                MotionEvent motionEvent = (MotionEvent) obj;
                o1.z zVar = (o1.z) obj2;
                if (motionEvent.getActionMasked() == 0) {
                    p5.i iVar2 = (p5.i) obj3;
                    o1.a0 a0Var2 = zVar.f9104c;
                    if (a0Var2 == null) {
                        yb.k.f("onTouchEvent");
                        throw null;
                    }
                    iVar2.f9731f = ((Boolean) a0Var2.invoke(motionEvent)).booleanValue() ? o1.x.f9099f : o1.x.f9100g;
                } else {
                    o1.a0 a0Var3 = zVar.f9104c;
                    if (a0Var3 == null) {
                        yb.k.f("onTouchEvent");
                        throw null;
                    }
                    a0Var3.invoke(motionEvent);
                }
                return vVar;
            case 10:
                ((n0) obj).g((o0) obj3, 0, 0, ((r.v) obj2).f10346c.g());
                return vVar;
            case 11:
                z0 z0Var = (z0) obj;
                f0 f0Var = ((r.n) obj3).f10321c;
                r2 r2Var = (r2) f0Var.g(z0Var.b());
                long j11 = r2Var != null ? ((o2.k) r2Var.getValue()).f9122a : 0L;
                r2 r2Var2 = (r2) f0Var.g(z0Var.c());
                long j12 = r2Var2 != null ? ((o2.k) r2Var2.getValue()).f9122a : 0L;
                if (((r.n0) ((r.m) obj2).f10316f.getValue()) == null) {
                    return s.d.m(7, null);
                }
                o2.k.a(j11);
                o2.k.a(j12);
                Object obj4 = p1.f11096a;
                return s.d.m(1, o2.k.a(ac.a.b(1, 1)));
            case 12:
                ((g0) obj3).d0(((w0.m) obj).d((w0.m) obj2));
                return vVar;
            case 13:
                e0 e0Var = (e0) obj3;
                c0 c0Var = (c0) obj2;
                e0Var.f10985a.b(c0Var);
                e0Var.f10986b.setValue(Boolean.TRUE);
                t tVar = new t(4);
                tVar.f1786b = e0Var;
                tVar.f1787c = c0Var;
                VarHandle.storeStoreFence();
                return tVar;
            case 14:
                s.g gVar4 = (s.g) obj;
                ((p0) obj3).invoke(gVar4.f11009e.getValue(), ((yb.l) ((n6.a) obj2).f8777f).invoke(gVar4.f11010f));
                return vVar;
            case 15:
                kc.w.u((kc.t) obj3, null, kc.u.f7484h, new g0.v((e1) obj2, null), 1);
                return new d1();
            case 16:
                e1 e1Var = (e1) obj3;
                e1 e1Var2 = (e1) obj2;
                e1Var.f10997j.add(e1Var2);
                t tVar2 = new t(5);
                tVar2.f1786b = e1Var;
                tVar2.f1787c = e1Var2;
                VarHandle.storeStoreFence();
                return tVar2;
            case 17:
                t tVar3 = new t(6);
                tVar3.f1786b = (e1) obj3;
                tVar3.f1787c = (s.y0) obj2;
                VarHandle.storeStoreFence();
                return tVar3;
            case 18:
                l0 l0Var = (l0) obj;
                s0 s0Var = (s0) obj3;
                if (s0Var.f11294s.f11284j.g() > 0) {
                    l0Var.f13861c = true;
                    u1.o0 o0Var3 = l0Var.f13864h;
                    s1.q qVarH0 = o0Var3.h0();
                    if (o2.i.b(l0Var.f13862f, 9223372034707292159L)) {
                        l0Var.f13862f = td.h.H(qVarH0.m(0L));
                        l0Var.f13863g = qVarH0.l();
                    }
                    o0Var3.o0().I.b();
                    long jL = qVarH0.l();
                    f0 f0Var2 = ((s1.p) obj2).i;
                    int i12 = (int) (jL >> 32);
                    int i13 = (int) (4294967295L & jL);
                    for (s1.d1 d1Var : androidx.compose.ui.layout.b.f978b) {
                        Object objG = f0Var2.g(d1Var);
                        objG.getClass();
                        f1 f1Var = (f1) objG;
                        s1.e1 e1Var3 = (s1.e1) d1Var;
                        androidx.compose.ui.layout.b.a(l0Var, e1Var3.f11238c, f1Var.f11248h, i12, i13);
                        if (((Boolean) f1Var.f11242b.getValue()).booleanValue()) {
                            androidx.compose.ui.layout.b.a(l0Var, f1Var.f11246f, f1Var.f11249j, i12, i13);
                            androidx.compose.ui.layout.b.a(l0Var, f1Var.f11247g, f1Var.f11250k, i12, i13);
                        }
                        androidx.compose.ui.layout.b.a(l0Var, e1Var3.f11239d, f1Var.i, i12, i13);
                    }
                    if (s0Var.f11294s.f11285k.h()) {
                        p.a0 a0Var4 = s0Var.f11294s.f11285k;
                        Object[] objArr = a0Var4.f9516a;
                        int i14 = a0Var4.f9517b;
                        while (i3 < i14) {
                            c1 c1Var = (c1) objArr[i3];
                            s1.o oVar = (s1.o) s0Var.f11294s.f11286l.get(i3);
                            Rect rect = (Rect) c1Var.getValue();
                            l0Var.b(oVar.b(), rect.left);
                            l0Var.b(oVar.d(), rect.top);
                            l0Var.b(oVar.c(), rect.right);
                            l0Var.b(oVar.a(), rect.bottom);
                            i3++;
                        }
                    }
                }
                return vVar;
            case 19:
                int iIntValue3 = ((Number) obj).intValue();
                return ((k8.d) obj3).invoke(Integer.valueOf(iIntValue3), ((List) obj2).get(iIntValue3));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                int iIntValue4 = ((Number) obj).intValue();
                return ((k8.d) obj3).invoke(Integer.valueOf(iIntValue4), ((List) obj2).get(iIntValue4));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                int iIntValue5 = ((Number) obj).intValue();
                return ((k8.d) obj3).invoke(Integer.valueOf(iIntValue5), ((List) obj2).get(iIntValue5));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return ((d2.y) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                u1.i0 i0Var2 = (u1.i0) obj;
                i0Var2.b();
                f1.d.x(i0Var2, ((d1.z) obj3).f3035a, (d1.f0) obj2, 0.0f, null, 60);
                return vVar;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                u1.i0 i0Var3 = (u1.i0) obj;
                i0Var3.b();
                f1.d.x(i0Var3, (d1.h) obj3, (d1.f0) obj2, 0.0f, null, 60);
                return vVar;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                ((v.k) obj3).b((v.j) obj2);
                return vVar;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                ((m0.e) ((sa.c) obj3).f12170f).j((u.h) obj2);
                return vVar;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                b8.p pVar = (b8.p) obj3;
                p1.c cVar = (p1.c) pVar.f2003f;
                p1.c cVar2 = (p1.c) pVar.f2005h;
                id.c.d(pVar, (o1.s) obj);
                t0 t0Var = (t0) obj2;
                float fD = ((u1) u1.f.h(t0Var, a1.f14373s)).d();
                long jF = h5.t.f(fD, fD);
                if (o2.p.c(jF) <= 0.0f || o2.p.d(jF) <= 0.0f) {
                    r1.a.b("maximumVelocity should be a positive value. You specified=" + ((Object) o2.p.g(jF)));
                }
                long jF2 = h5.t.f(cVar2.b(o2.p.c(jF)), cVar.b(o2.p.d(jF)));
                p1.a[] aVarArr = cVar2.f9687c;
                kb.k.m0(null, 0, aVarArr, aVarArr.length);
                cVar2.f9688d = 0;
                p1.a[] aVarArr2 = cVar.f9687c;
                kb.k.m0(null, 0, aVarArr2, aVarArr2.length);
                cVar.f9688d = 0;
                pVar.f2004g = 0L;
                mc.e eVar = t0Var.f13590y;
                if (eVar != null) {
                    int i15 = u.c0.f13433a;
                    long jF3 = h5.t.f(Float.isNaN(o2.p.c(jF2)) ? 0.0f : o2.p.c(jF2), Float.isNaN(o2.p.d(jF2)) ? 0.0f : o2.p.d(jF2));
                    u.p pVar2 = new u.p();
                    pVar2.f13546a = jF3;
                    VarHandle.storeStoreFence();
                    mc.l.a(eVar.h(pVar2));
                }
                return vVar;
            case 28:
                u.y0 y0Var = (u.y0) obj3;
                long j13 = ((u.n) obj).f13530a;
                long jB = ((u.z0) obj2).f13627d == u.f0.f13454f ? c1.b.b(1, j13) : c1.b.b(2, j13);
                u.z0 z0Var2 = y0Var.f13619a;
                z0Var2.f13630g = 1;
                b1 b1Var = z0Var2.f13625b;
                if (b1Var == null || !(z0Var2.f13624a.d() || z0Var2.f13624a.b())) {
                    u.z0.a(z0Var2, z0Var2.f13631h, jB, 1);
                } else {
                    b1Var.c(jB, z0Var2.f13630g, z0Var2.f13632j);
                }
                return vVar;
            default:
                ((Number) obj).longValue();
                o1 o1Var = (o1) obj3;
                float f5 = o1Var.f13545e;
                o1Var.f13545e = 0.0f;
                ((xb.l) obj2).invoke(Float.valueOf(f5));
                return vVar;
        }
    }
}
