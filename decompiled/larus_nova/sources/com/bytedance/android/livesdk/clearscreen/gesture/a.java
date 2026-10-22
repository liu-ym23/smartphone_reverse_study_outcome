package com.bytedance.android.livesdk.clearscreen.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f119386d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.b.a f119387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC1764a f119388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GestureDetector f119389c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.clearscreen.gesture.a$a, reason: collision with other inner class name */
    public interface InterfaceC1764a {
        boolean onSingleTapUp(MotionEvent r100);
    }

    public static final class b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f119390a;

        public c(a r100) {
            this.f119390a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f119390a.f119388b != null) goto L5;
            int r101 = a.f119386d;
            ALogger.d("AdvanceCSClickGestureBehavior", "callback is null");
        L5:
            InterfaceC1764a r102 = this.f119390a.f119388b;
            if (r102 != null) goto L8;
        L10:
            return false;
        L8:
            if (r102.onSingleTapUp(r100) != true) goto L10;
            return true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final f0 getConfig() {
        return this.f119387a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f119387a = com.bytedance.android.livesdk.widget.b.a.f161416c;
        this.f119389c = new GestureDetector(r100, new c(this));
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean b(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ev");
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ev");
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean c(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ev");
        y.a.a(r100, r101);
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final boolean onTouchEvent(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "ev");
        boolean r102 = this.f119389c.onTouchEvent(r101);
        ALogger.d("AdvanceCSClickGestureBehavior", "onTouchEvent, consume=" + r102 + ", ev=" + r101);
        return r102;
    }
}
