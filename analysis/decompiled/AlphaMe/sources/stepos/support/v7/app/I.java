package stepos.support.v7.app;

import android.app.Activity;
import android.util.Log;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes2.dex */
public final class I {

    /* renamed from: g, reason: collision with root package name */
    public static I f14282g;

    /* renamed from: a, reason: collision with root package name */
    public Activity f14283a;

    /* renamed from: b, reason: collision with root package name */
    public PopupNestedScrollingLayout f14284b;

    /* renamed from: c, reason: collision with root package name */
    public final W.m f14285c;

    /* renamed from: d, reason: collision with root package name */
    public final W.m f14286d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14287e;

    /* renamed from: f, reason: collision with root package name */
    public int f14288f = -1;

    public I() {
        W.m mVar = new W.m(new W.l());
        this.f14285c = mVar;
        mVar.b(new H(this, 0));
        W.m mVar2 = new W.m(new W.l());
        this.f14286d = mVar2;
        mVar2.b(new H(this, 1));
    }

    public static I b() {
        if (f14282g == null) {
            f14282g = new I();
        }
        return f14282g;
    }

    public final void a() {
        if (!this.f14287e || this.f14283a == null || (this.f14284b.getPositionState() != this.f14288f && this.f14284b.getPositionState() != 1)) {
            Log.e(D.POPUP_STACK_TAG, "  call bottom stack do stackExit , but state error, return ");
            return;
        }
        Log.d(D.POPUP_STACK_TAG, " bottom stack exit success!! ");
        int i4 = -((int) m2.o.c(this.f14283a, 10.0f));
        if (this.f14284b.getPositionState() == 0) {
            i4 = -((int) m2.o.c(this.f14283a, 35.0f));
        }
        W.n nVar = new W.n();
        nVar.a(0.93f);
        nVar.b(400.0f);
        W.m mVar = this.f14285c;
        mVar.f1974m = nVar;
        mVar.g(this.f14284b.getCurrentScrollY());
        mVar.f1974m.f1985i = this.f14284b.getCurrentScrollY() + i4;
        mVar.i();
        W.n nVar2 = new W.n();
        nVar2.a(0.93f);
        nVar2.b(400.0f);
        W.m mVar2 = this.f14286d;
        mVar2.f1974m = nVar2;
        mVar2.g(93.0f);
        mVar2.f1974m.f1985i = 100.0f;
        mVar2.i();
        this.f14287e = false;
    }
}
