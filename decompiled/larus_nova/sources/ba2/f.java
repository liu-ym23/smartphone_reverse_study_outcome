package ba2;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ca2.c f18410e;

    public f(ca2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionZoomableControllerImp");
        super(r100);
        this.f18410e = r100;
    }

    @Override // ba2.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        ca2.c r101 = this.f18410e;
        if (r101.G == false) goto L5;
        r101.A.set(r101.f139335h);
        r101.k(true);
    L5:
        return true;
    }

    @Override // ba2.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (this.f18410e.f22925x != 3) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        super.onFling(r100, r101, r102, r103);
    L9:
        return false;
    L5:
        r104 = false;
        goto L6
    }
}
