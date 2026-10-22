package androidx.appcompat.widget;

import com.stepos.alphame.utils.Property;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0197e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f3079b;

    public /* synthetic */ RunnableC0197e(ActionBarOverlayLayout actionBarOverlayLayout, int i4) {
        this.f3078a = i4;
        this.f3079b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3078a;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3079b;
        switch (i4) {
            case 0:
                actionBarOverlayLayout.b();
                actionBarOverlayLayout.f2781w = actionBarOverlayLayout.f2762d.animate().translationY(Property.DEFAULT_FLOAT_VALUE).setListener(actionBarOverlayLayout.f2782x);
                break;
            default:
                actionBarOverlayLayout.b();
                actionBarOverlayLayout.f2781w = actionBarOverlayLayout.f2762d.animate().translationY(-actionBarOverlayLayout.f2762d.getHeight()).setListener(actionBarOverlayLayout.f2782x);
                break;
        }
    }
}
