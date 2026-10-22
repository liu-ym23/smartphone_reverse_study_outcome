package e6;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import androidx.lifecycle.x;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import v5.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Context f3530a;

    /* renamed from: b, reason: collision with root package name */
    public c f3531b = i6.c.f5803a;

    /* renamed from: c, reason: collision with root package name */
    public Object f3532c = null;

    /* renamed from: d, reason: collision with root package name */
    public stepos.support.v7.app.f f3533d = null;

    /* renamed from: e, reason: collision with root package name */
    public f6.d f3534e = null;

    /* renamed from: f, reason: collision with root package name */
    public s f3535f = null;

    /* renamed from: g, reason: collision with root package name */
    public kb.s f3536g = kb.s.f7404c;

    /* renamed from: h, reason: collision with root package name */
    public h6.e f3537h = null;
    public ne.b i = null;

    /* renamed from: j, reason: collision with root package name */
    public LinkedHashMap f3538j = null;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3539k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3540l = true;

    /* renamed from: m, reason: collision with root package name */
    public n f3541m = null;

    /* renamed from: n, reason: collision with root package name */
    public f6.h f3542n = null;

    /* renamed from: o, reason: collision with root package name */
    public f6.f f3543o = null;

    /* renamed from: p, reason: collision with root package name */
    public androidx.lifecycle.q f3544p = null;

    /* renamed from: q, reason: collision with root package name */
    public f6.h f3545q = null;

    /* renamed from: r, reason: collision with root package name */
    public f6.f f3546r = null;

    public h(Context context) {
        this.f3530a = context;
    }

    public final i a() {
        kc.p pVar;
        f6.h hVar;
        androidx.lifecycle.q lifecycle;
        Context context = this.f3530a;
        Object obj = this.f3532c;
        if (obj == null) {
            obj = k.f3572a;
        }
        stepos.support.v7.app.f fVar = this.f3533d;
        c cVar = this.f3531b;
        Bitmap.Config config = cVar.f3518g;
        f6.d dVar = this.f3534e;
        if (dVar == null) {
            dVar = cVar.f3517f;
        }
        s sVar = this.f3535f;
        kb.s sVar2 = this.f3536g;
        h6.e eVar = this.f3537h;
        if (eVar == null) {
            eVar = cVar.f3516e;
        }
        ne.b bVar = this.i;
        ad.n nVarD = bVar != null ? bVar.d() : null;
        if (nVarD == null) {
            nVarD = i6.d.f5805b;
        } else {
            Bitmap.Config config2 = i6.d.f5804a;
        }
        LinkedHashMap linkedHashMap = this.f3538j;
        r rVar = linkedHashMap != null ? new r(ac.a.h0(linkedHashMap)) : null;
        if (rVar == null) {
            rVar = r.f3599b;
        }
        boolean z10 = this.f3539k;
        this.f3531b.getClass();
        this.f3531b.getClass();
        boolean z11 = this.f3540l;
        c cVar2 = this.f3531b;
        b bVar2 = cVar2.f3519h;
        b bVar3 = cVar2.i;
        b bVar4 = cVar2.f3520j;
        kc.p pVar2 = cVar2.f3512a;
        kc.p pVar3 = cVar2.f3513b;
        kc.p pVar4 = cVar2.f3514c;
        kc.p pVar5 = cVar2.f3515d;
        androidx.lifecycle.q qVar = this.f3544p;
        if (qVar == null) {
            Object baseContext = context;
            pVar = pVar4;
            while (true) {
                if (baseContext instanceof x) {
                    lifecycle = ((x) baseContext).getLifecycle();
                    break;
                }
                if (!(baseContext instanceof ContextWrapper)) {
                    lifecycle = null;
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            if (lifecycle == null) {
                lifecycle = g.f3528b;
            }
            qVar = lifecycle;
        } else {
            pVar = pVar4;
        }
        f6.h hVar2 = this.f3542n;
        androidx.lifecycle.q qVar2 = qVar;
        if (hVar2 == null) {
            f6.h hVar3 = this.f3545q;
            f6.h hVar4 = hVar3;
            if (hVar3 == null) {
                f6.c cVar3 = new f6.c();
                cVar3.f3918c = context;
                VarHandle.storeStoreFence();
                hVar4 = cVar3;
            }
            hVar = hVar4;
        } else {
            hVar = hVar2;
        }
        f6.f fVar2 = this.f3543o;
        if (fVar2 == null && (fVar2 = this.f3546r) == null) {
            if ((hVar2 instanceof f6.i ? (f6.i) hVar2 : null) != null) {
                throw null;
            }
            fVar2 = f6.f.f3924f;
        }
        n nVar = this.f3541m;
        f6.f fVar3 = fVar2;
        p pVar6 = nVar != null ? new p(ac.a.h0(nVar.f3587c)) : null;
        if (pVar6 == null) {
            pVar6 = p.f3590f;
        }
        p pVar7 = pVar6;
        f6.h hVar5 = this.f3542n;
        f6.f fVar4 = this.f3543o;
        h6.e eVar2 = this.f3537h;
        f6.d dVar2 = this.f3534e;
        d dVar3 = new d();
        dVar3.f3521a = hVar5;
        dVar3.f3522b = fVar4;
        dVar3.f3523c = eVar2;
        dVar3.f3524d = dVar2;
        VarHandle.storeStoreFence();
        c cVar4 = this.f3531b;
        i iVar = new i();
        iVar.f3547a = context;
        iVar.f3548b = obj;
        iVar.f3549c = fVar;
        iVar.f3550d = config;
        iVar.f3551e = dVar;
        iVar.f3552f = sVar;
        iVar.f3553g = sVar2;
        iVar.f3554h = eVar;
        iVar.i = nVarD;
        iVar.f3555j = rVar;
        iVar.f3556k = z10;
        iVar.f3557l = true;
        iVar.f3558m = false;
        iVar.f3559n = z11;
        iVar.f3560o = bVar2;
        iVar.f3561p = bVar3;
        iVar.f3562q = bVar4;
        iVar.f3563r = pVar2;
        iVar.f3564s = pVar3;
        iVar.f3565t = pVar;
        iVar.f3566u = pVar5;
        iVar.f3567v = qVar2;
        iVar.f3568w = hVar;
        iVar.f3569x = fVar3;
        iVar.f3570y = pVar7;
        iVar.f3571z = dVar3;
        iVar.A = cVar4;
        VarHandle.storeStoreFence();
        return iVar;
    }
}
