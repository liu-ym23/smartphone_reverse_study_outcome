package g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2672a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1 f2673b;

    public /* synthetic */ b1(j1 j1Var, int i8) {
        this.f2672a = i8;
        this.f2673b = j1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2672a) {
            case 0:
                i1 i1Var = this.f2673b.f2739c;
                if (i1Var != null) {
                    i1Var.setListSelectionHidden(true);
                    i1Var.requestLayout();
                    break;
                }
                break;
            default:
                j1 j1Var = this.f2673b;
                i1 i1Var2 = j1Var.f2739c;
                if (i1Var2 != null && i1Var2.isAttachedToWindow() && j1Var.f2739c.getCount() > j1Var.f2739c.getChildCount() && j1Var.f2739c.getChildCount() <= Integer.MAX_VALUE) {
                    j1Var.f2757w.setInputMethodMode(2);
                    j1Var.a();
                    break;
                }
                break;
        }
    }
}
