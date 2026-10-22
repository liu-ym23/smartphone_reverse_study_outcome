package ba2;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.ZoomableControllerImp;
import com.bytedance.android.livesdk.interactivity.publicscreen.preview.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f18383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.publicscreen.preview.e f18384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ZoomableControllerImp f18386d;

    public a(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomableControllerImp");
        this.f18386d = r100;
        this.f18383a = new PointF();
        this.f18385c = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        if (this.f18385c == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.preview.e r100 = this.f18384b;
        if (r100 != null) goto L8;
        return false;
    L8:
        final ZoomableControllerImp r101 = this.f18386d;
        PointF r102 = new PointF(r110.getX(), r110.getY());
        int r103 = r110.getActionMasked();
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L20;
        r101.f139335h.getValues(r101.f139337j);
        float r104 = r100.nextFactor(r101.f139337j[0]);
        if (r101.f139322q.isRunning() == false) goto L15;
        r101.j();
    L15:
        r101.f139327v = true;
        Runnable r105 = new h(r101);
        r101.f139319n.reset();
        Matrix r106 = r101.f139319n;
        float[] r107 = r101.f139337j;
        r107[0] = r102.x;
        r107[1] = r102.y;
        r101.f139335h.invert(r101.f139336i);
        r101.f139336i.mapPoints(r107, 0, r107, 0, 1);
        PointF r108 = new PointF(r107[0], r107[1]);
        r106.setScale(r104, r104, r108.x, r108.y);
        float r109 = r108.x;
        float r111 = r108.y;
        r106.getValues(r101.f139337j);
        float r112 = r101.f139337j[0];
        float r113 = Math.min(Math.max(1.0f, r112), r101.f139331d);
        if (r113 == r112) goto L18;
        float r114 = r113 / r112;
        r106.postScale(r114, r114, r109, r111);
    L18:
        r101.e(r106);
        r101.i(r101.f139319n, r101.f139323r, r105, null);
    L20:
        return true;
    L19:
        this.f18383a.set(r102);
        goto L20
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return super.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
        Intrinsics.checkNotNullParameter(r111, "e2");
        ZoomableControllerImp r114 = this.f18386d;
        r114.f139335h.getValues(r114.f139337j);
        if (r114.f139337j[0] <= 1.0f) goto L12;
        int r100 = (int) r112;
        int r101 = (int) r113;
        if (r114.f139322q.isRunning() == true) goto L12;
        if (r114.f139325t.computeScrollOffset() == true) goto L9;
    L11:
        r114.f139325t.fling(0, 0, r100, r101, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r114.f139321p.set(r114.f139335h);
        Matrix r115 = r114.f139335h;
        r115.set(r115);
        r114.a();
        goto L12
    L9:
        if (r114.f139325t.computeScrollOffset() == false) goto L11;
        r114.f139325t.forceFinished(true);
    L12:
        return false;
    }
}
