package t4;

import a6.r;
import android.content.Context;
import android.content.Intent;
import com.stepos.zeroclaw.ipc.IZeroClawService;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.w1;
import java.util.concurrent.CancellationException;
import k5.s;
import k5.t;
import la.k0;
import la.u0;
import q7.k;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final na.d f9737a;

    /* renamed from: b, reason: collision with root package name */
    public final e f9738b;

    /* renamed from: c, reason: collision with root package name */
    public final t f9739c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9740d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f9741e;

    /* renamed from: f, reason: collision with root package name */
    public final u0 f9742f;

    /* renamed from: g, reason: collision with root package name */
    public final u0 f9743g;

    /* renamed from: h, reason: collision with root package name */
    public w1 f9744h;

    /* renamed from: i, reason: collision with root package name */
    public int f9745i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9746j;

    /* renamed from: k, reason: collision with root package name */
    public final f f9747k;

    public g(Context context, na.d dVar, e eVar, t tVar, String str) {
        k.e(context, "context");
        k.e(tVar, "logger");
        this.f9737a = dVar;
        this.f9738b = eVar;
        this.f9739c = tVar;
        this.f9740d = str;
        this.f9741e = context.getApplicationContext();
        u0 u0VarC = k0.c(c.f9733a);
        this.f9742f = u0VarC;
        this.f9743g = u0VarC;
        this.f9747k = new f(this);
    }

    public final void a() {
        u0 u0Var = this.f9742f;
        if (u0Var.getValue() instanceof c) {
            u0Var.getClass();
            u0Var.g(null, b.f9732a);
            Intent intent = new Intent(IZeroClawService.DESCRIPTOR);
            String str = this.f9740d;
            intent.setPackage(str);
            boolean zBindService = this.f9741e.bindService(intent, this.f9747k, 1);
            this.f9746j = zBindService;
            if (zBindService) {
                return;
            }
            s.warn$default(this.f9739c, "ZeroClawConn", "bindService returned false for package=".concat(str), null, 4, null);
            u0Var.getClass();
            u0Var.g(null, c.f9733a);
            b();
        }
    }

    public final void b() {
        w1 w1Var = this.f9744h;
        g7.d dVar = null;
        if (w1Var != null) {
            f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f9744h = d0.s(this.f9737a, null, null, new r(this, dVar, 11), 3);
    }
}
