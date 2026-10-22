package stepos.support.v7.widget;

import androidx.core.view.ViewCompat;

/* renamed from: stepos.support.v7.widget.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1995j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6620a;
    public final /* synthetic */ ActionBarOverlayLayout b;

    public /* synthetic */ RunnableC1995j(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f6620a = i;
        this.b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6620a;
        ActionBarOverlayLayout actionBarOverlayLayout = this.b;
        switch (i) {
            case 0:
                int[] iArr = ActionBarOverlayLayout.f6417U;
                actionBarOverlayLayout.e();
                actionBarOverlayLayout.f6440w = ViewCompat.animate(actionBarOverlayLayout.d).translationY(0.0f).setListener(actionBarOverlayLayout.f6422F);
                ActionBarContainer actionBarContainer = actionBarOverlayLayout.c;
                if (actionBarContainer != null && actionBarContainer.getVisibility() != 8) {
                    actionBarOverlayLayout.f6441x = ViewCompat.animate(actionBarOverlayLayout.c).translationY(0.0f).setListener(actionBarOverlayLayout.f6423G);
                    break;
                }
                break;
            default:
                int[] iArr2 = ActionBarOverlayLayout.f6417U;
                actionBarOverlayLayout.e();
                actionBarOverlayLayout.f6440w = ViewCompat.animate(actionBarOverlayLayout.d).translationY(-actionBarOverlayLayout.d.getHeight()).setListener(actionBarOverlayLayout.f6422F);
                ActionBarContainer actionBarContainer2 = actionBarOverlayLayout.c;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
                    actionBarOverlayLayout.f6441x = ViewCompat.animate(actionBarOverlayLayout.c).translationY(actionBarOverlayLayout.c.getHeight()).setListener(actionBarOverlayLayout.f6423G);
                    break;
                }
                break;
        }
    }
}
