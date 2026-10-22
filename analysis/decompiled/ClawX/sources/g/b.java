package g;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2670a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f2671b;

    public /* synthetic */ b(ActionBarOverlayLayout actionBarOverlayLayout, int i8) {
        this.f2670a = i8;
        this.f2671b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2670a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2671b;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.f308u = actionBarOverlayLayout.f292c.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f309v);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2671b;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.f308u = actionBarOverlayLayout2.f292c.animate().translationY(-actionBarOverlayLayout2.f292c.getHeight()).setListener(actionBarOverlayLayout2.f309v);
                break;
        }
    }
}
