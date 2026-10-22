package stepos.support.v7.widget;

import com.stepos.alphame.utils.Property;

/* renamed from: stepos.support.v7.widget.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0888h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15086a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f15087b;

    public /* synthetic */ RunnableC0888h(ActionBarOverlayLayout actionBarOverlayLayout, int i4) {
        this.f15086a = i4;
        this.f15087b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f15086a;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f15087b;
        switch (i4) {
            case 0:
                int[] iArr = ActionBarOverlayLayout.f14752Q;
                actionBarOverlayLayout.d();
                K.e0 e0VarA = K.S.a(actionBarOverlayLayout.f14772d);
                e0VarA.h(Property.DEFAULT_FLOAT_VALUE);
                e0VarA.e(actionBarOverlayLayout.f14758F);
                actionBarOverlayLayout.f14791w = e0VarA;
                ActionBarContainer actionBarContainer = actionBarOverlayLayout.f14771c;
                if (actionBarContainer != null && actionBarContainer.getVisibility() != 8) {
                    K.e0 e0VarA2 = K.S.a(actionBarOverlayLayout.f14771c);
                    e0VarA2.h(Property.DEFAULT_FLOAT_VALUE);
                    e0VarA2.e(actionBarOverlayLayout.f14759G);
                    actionBarOverlayLayout.f14792x = e0VarA2;
                    break;
                }
                break;
            default:
                int[] iArr2 = ActionBarOverlayLayout.f14752Q;
                actionBarOverlayLayout.d();
                K.e0 e0VarA3 = K.S.a(actionBarOverlayLayout.f14772d);
                e0VarA3.h(-actionBarOverlayLayout.f14772d.getHeight());
                e0VarA3.e(actionBarOverlayLayout.f14758F);
                actionBarOverlayLayout.f14791w = e0VarA3;
                ActionBarContainer actionBarContainer2 = actionBarOverlayLayout.f14771c;
                if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
                    K.e0 e0VarA4 = K.S.a(actionBarOverlayLayout.f14771c);
                    e0VarA4.h(actionBarOverlayLayout.f14771c.getHeight());
                    e0VarA4.e(actionBarOverlayLayout.f14759G);
                    actionBarOverlayLayout.f14792x = e0VarA4;
                    break;
                }
                break;
        }
    }
}
