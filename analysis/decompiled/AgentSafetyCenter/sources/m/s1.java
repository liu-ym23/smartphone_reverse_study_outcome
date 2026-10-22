package m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s1 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8075c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ w1 f8076f;

    public /* synthetic */ s1(int i) {
        this.f8075c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8075c) {
            case 0:
                j1 j1Var = this.f8076f.f8116g;
                if (j1Var != null) {
                    j1Var.setListSelectionHidden(true);
                    j1Var.requestLayout();
                    break;
                }
                break;
            default:
                w1 w1Var = this.f8076f;
                j1 j1Var2 = w1Var.f8116g;
                if (j1Var2 != null && j1Var2.isAttachedToWindow() && w1Var.f8116g.getCount() > w1Var.f8116g.getChildCount() && w1Var.f8116g.getChildCount() <= w1Var.f8125q) {
                    w1Var.D.setInputMethodMode(2);
                    w1Var.f();
                    break;
                }
                break;
        }
    }
}
