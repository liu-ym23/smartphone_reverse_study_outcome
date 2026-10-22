package androidx.appcompat.widget;

import k.C0663q;

/* loaded from: classes.dex */
public final /* synthetic */ class Z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3046a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3047b;

    public /* synthetic */ Z0(Toolbar toolbar, int i4) {
        this.f3046a = i4;
        this.f3047b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3046a;
        Toolbar toolbar = this.f3047b;
        switch (i4) {
            case 0:
                c1 c1Var = toolbar.f2978L;
                C0663q c0663q = c1Var == null ? null : c1Var.f3072b;
                if (c0663q != null) {
                    c0663q.collapseActionView();
                    break;
                }
                break;
            default:
                toolbar.l();
                break;
        }
    }
}
