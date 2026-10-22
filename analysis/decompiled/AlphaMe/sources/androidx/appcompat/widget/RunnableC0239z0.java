package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0239z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3218a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ G0 f3219b;

    public /* synthetic */ RunnableC0239z0(G0 g02, int i4) {
        this.f3218a = i4;
        this.f3219b = g02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3218a;
        G0 g02 = this.f3219b;
        switch (i4) {
            case 1:
                C0229u0 c0229u0 = g02.f2823c;
                if (c0229u0 != null) {
                    c0229u0.setListSelectionHidden(true);
                    c0229u0.requestLayout();
                    break;
                }
                break;
            default:
                C0229u0 c0229u02 = g02.f2823c;
                if (c0229u02 != null && c0229u02.isAttachedToWindow() && g02.f2823c.getCount() > g02.f2823c.getChildCount() && g02.f2823c.getChildCount() <= g02.f2833m) {
                    g02.f2846z.setInputMethodMode(2);
                    g02.g();
                    break;
                }
                break;
        }
    }
}
