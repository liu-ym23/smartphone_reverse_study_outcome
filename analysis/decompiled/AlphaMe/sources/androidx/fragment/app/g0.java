package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class g0 extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3754a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f3755b;

    public /* synthetic */ g0(Rect rect, int i4) {
        this.f3754a = i4;
        this.f3755b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        int i4 = this.f3754a;
        Rect rect = this.f3755b;
        switch (i4) {
            case 0:
                break;
            default:
                if (rect == null || rect.isEmpty()) {
                }
                break;
        }
        return rect;
    }
}
