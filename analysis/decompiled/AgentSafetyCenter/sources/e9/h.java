package e9;

import android.content.Context;
import java.lang.invoke.VarHandle;
import java.text.Collator;
import java.util.Locale;
import nc.k0;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final f7.f f3655f = new f7.f(28);

    /* renamed from: g, reason: collision with root package name */
    public static volatile h f3656g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3657a;

    /* renamed from: b, reason: collision with root package name */
    public final j0 f3658b;

    /* renamed from: c, reason: collision with root package name */
    public final Collator f3659c;

    /* renamed from: d, reason: collision with root package name */
    public final t0 f3660d;

    /* renamed from: e, reason: collision with root package name */
    public final nc.f0 f3661e;

    public h(Context context) {
        this.f3657a = context;
        j0 j0Var = new j0();
        j0Var.f3671a = context.getContentResolver();
        j0Var.f3672b = new m7.e();
        j0Var.f3673c = j0.f3668g;
        j0Var.f3674d = j0.f3669h;
        j0Var.f3675e = j0.i;
        j0Var.f3676f = j0.f3670j;
        VarHandle.storeStoreFence();
        this.f3658b = j0Var;
        this.f3659c = Collator.getInstance(Locale.getDefault());
        t0 t0VarA = k0.a(new z(15));
        this.f3660d = t0VarA;
        this.f3661e = new nc.f0(t0VarA);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(e9.h r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.h.a(e9.h):void");
    }
}
