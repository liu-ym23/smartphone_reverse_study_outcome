package m;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7884c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ActionBarOverlayLayout f7885f;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7884c) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f7885f;
                actionBarOverlayLayout.b();
                actionBarOverlayLayout.A = actionBarOverlayLayout.f774h.animate().translationY(0.0f).setListener(actionBarOverlayLayout.B);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f7885f;
                actionBarOverlayLayout2.b();
                actionBarOverlayLayout2.A = actionBarOverlayLayout2.f774h.animate().translationY(-actionBarOverlayLayout2.f774h.getHeight()).setListener(actionBarOverlayLayout2.B);
                break;
        }
    }
}
