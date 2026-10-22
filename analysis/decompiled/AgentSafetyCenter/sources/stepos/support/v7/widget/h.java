package stepos.support.v7.widget;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12755c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ActionBarOverlayLayout f12756f;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12755c) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f12756f;
                int[] iArr = ActionBarOverlayLayout.U;
                actionBarOverlayLayout.j();
                n3.o0 o0VarA = n3.k0.a(actionBarOverlayLayout.f12584h);
                o0VarA.h(0.0f);
                o0VarA.e(actionBarOverlayLayout.J);
                actionBarOverlayLayout.A = o0VarA;
                ActionBarContainer actionBarContainer = actionBarOverlayLayout.f12583g;
                if (actionBarContainer != null && actionBarContainer.getVisibility() != 8) {
                    n3.o0 o0VarA2 = n3.k0.a(actionBarOverlayLayout.f12583g);
                    o0VarA2.h(0.0f);
                    o0VarA2.e(actionBarOverlayLayout.K);
                    actionBarOverlayLayout.B = o0VarA2;
                    break;
                }
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f12756f;
                int[] iArr2 = ActionBarOverlayLayout.U;
                actionBarOverlayLayout2.j();
                n3.o0 o0VarA3 = n3.k0.a(actionBarOverlayLayout2.f12584h);
                o0VarA3.h(-actionBarOverlayLayout2.f12584h.getHeight());
                o0VarA3.e(actionBarOverlayLayout2.J);
                actionBarOverlayLayout2.A = o0VarA3;
                ActionBarContainer actionBarContainer2 = actionBarOverlayLayout2.f12583g;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
                    n3.o0 o0VarA4 = n3.k0.a(actionBarOverlayLayout2.f12583g);
                    o0VarA4.h(actionBarOverlayLayout2.f12583g.getHeight());
                    o0VarA4.e(actionBarOverlayLayout2.K);
                    actionBarOverlayLayout2.B = o0VarA4;
                    break;
                }
                break;
        }
    }
}
