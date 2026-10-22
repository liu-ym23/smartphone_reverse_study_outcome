package com.bytedance.android.live.effect.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.b;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class EffectGestureDetectorV2 implements b, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GestureDetectorCompat f68005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f68006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f68007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f68010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f68011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f68012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Type f68013j;

    public static final enum Type extends Enum<Type> {
        public static final Type BEF_GESTURE_TYPE_LONG_PRESS = null;
        public static final Type BEF_GESTURE_TYPE_PAN = null;
        public static final Type BEF_GESTURE_TYPE_ROTATE = null;
        public static final Type BEF_GESTURE_TYPE_SCALE = null;
        public static final Type BEF_GESTURE_TYPE_TAP = null;
        public static final Type BEF_GESTURE_TYPE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f68014a = null;

        static {
            Type r100 = new Type("BEF_GESTURE_TYPE_UNKNOWN", 0);
            BEF_GESTURE_TYPE_UNKNOWN = r100;
            Type r101 = new Type("BEF_GESTURE_TYPE_TAP", 1);
            BEF_GESTURE_TYPE_TAP = r101;
            Type r102 = new Type("BEF_GESTURE_TYPE_PAN", 2);
            BEF_GESTURE_TYPE_PAN = r102;
            Type r103 = new Type("BEF_GESTURE_TYPE_ROTATE", 3);
            BEF_GESTURE_TYPE_ROTATE = r103;
            Type r104 = new Type("BEF_GESTURE_TYPE_SCALE", 4);
            BEF_GESTURE_TYPE_SCALE = r104;
            Type r105 = new Type("BEF_GESTURE_TYPE_LONG_PRESS", 5);
            BEF_GESTURE_TYPE_LONG_PRESS = r105;
            f68014a = new Type[]{r100, r101, r102, r103, r104, r105};
        }

        public static Type[] values() {
            return (Type[]) f68014a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        return true;
    }

    public final boolean d() {
        LiveEffectContextFactoryDelegate$Type r100 = this.f68004a;
        List<String> r101 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r102 = LiveEffectContext.a.a(r100).a();
        if (r102 == null) goto L8;
        boolean r103 = c(r102.o(d0.f66753c));
        if (r103 == false) goto L7;
        return r103;
    L7:
        return c(r102.o("livegame"));
    L8:
        return false;
    }

    public static boolean c(List r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.size() <= 0) goto L22;
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L23;
        List<String> r102 = ((Sticker) r101.next()).getTypes();
        if (r102 == null) goto L7;
        if (r102.size() <= 0) goto L7;
        return r102.contains("TouchGes");
    L23:
        return false;
    L22:
        return false;
    }

    public final boolean f(MotionEvent r100) {
        if (d() == true) goto L6;
        return false;
    L6:
        if ((r100.getAction() & 255) != 2) goto L11;
        int r101 = 0;
    L9:
        if (r101 >= r100.getPointerCount()) goto L12;
        xs2.b.a().post(new a(207, a(r100, r100.getPointerId(r101))));
        r101 = r101 + 1;
    L12:
        Logger.e("AmazingEngineTouch", "notifyTouchEvent: ACTION_AMAZING_TOUCH");
        int r102 = r100.getAction() & 255;
        this.f68006c.onTouchEvent(r100);
        if (r102 != 0) goto L16;
        this.f68007d = false;
    L16:
        if (r100.getPointerCount() <= 1) goto L19;
        this.f68007d = true;
    L19:
        if (this.f68007d == true) goto L21;
        this.f68005b.onTouchEvent(r100);
    L21:
        if (r102 != 1) goto L24;
        e(202, b(r100, true));
    L24:
        return true;
    L11:
        xs2.b.a().post(new a(207, a(r100, r100.getPointerId(r100.getActionIndex()))));
        goto L12
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        e(208, b(r100, false));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        e(201, b(r100, true));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        this.f68013j = Type.BEF_GESTURE_TYPE_LONG_PRESS;
        e(204, b(r100, false));
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        this.f68013j = Type.BEF_GESTURE_TYPE_SCALE;
        float r101 = r100.getScaleFactor() / this.f68012i;
        a.C1112a r102 = new a.C1112a();
        r102.f68020c = r101;
        e(205, r102);
        this.f68012i = r100.getScaleFactor();
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
        this.f68012i = 1.0f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        this.f68013j = Type.BEF_GESTURE_TYPE_TAP;
        e(206, b(r100, false));
        return false;
    }

    public EffectGestureDetectorV2(Context r100, LiveEffectContextFactoryDelegate$Type r101) {
        this.f68007d = false;
        this.f68012i = 1.0f;
        this.f68013j = Type.BEF_GESTURE_TYPE_PAN;
        this.f68004a = r101;
        Resources r102 = r100.getApplicationContext().getResources();
        this.f68008e = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        Resources r103 = r100.getApplicationContext().getResources();
        this.f68009f = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).heightPixels;
        GestureDetectorCompat r104 = new GestureDetectorCompat(r100, this);
        this.f68005b = r104;
        r104.setIsLongpressEnabled(false);
        r104.setOnDoubleTapListener(this);
        this.f68006c = new ScaleGestureDetector(r100, this);
    }

    public static void e(int r100, a.C1112a r101) {
        Logger.e("EffectGestureDetector", "notifyTouchEvent:" + r100 + " type:" + r101.f68018a);
        xs2.b.a().post(new a(r100, r101));
    }

    public final a.C1112a a(MotionEvent r100, long r101) {
        a.C1112a r102 = new a.C1112a();
        r102.f68021d = r101;
        if (this.f68011h <= 10) goto L5;
        float r103 = r100.getX(r100.findPointerIndex((int) r101)) - this.f68011h;
    L6:
        r102.f68019b = r103 / this.f68008e;
        if (this.f68010g <= 10) goto L9;
        float r104 = r100.getY(r100.findPointerIndex((int) r101)) - this.f68010g;
    L10:
        float r105 = r104 / this.f68009f;
        float r106 = r102.f68019b;
        if (r106 > 0.0f) goto L13;
        r106 = 0.0f;
    L17:
        r102.f68019b = r106;
        int r107 = (r105 > 0.0f ? 1 : (r105 == 0.0f ? 0 : -1));
        r100.getPressure(r100.findPointerIndex((int) r101));
        int r108 = r100.getActionMasked();
        if (r108 != 0) goto L20;
    L27:
        r100.getPointerCount();
        return r102;
    L20:
        if (r108 == 1) goto L27;
        if (r108 == 2) goto L27;
        if (r108 == 3) goto L27;
        if (r108 == 5) goto L27;
        goto L27
    L13:
        if (r106 < 1.0f) goto L17;
        r106 = 1.0f;
        goto L17
    L9:
        r104 = r100.getY(r100.findPointerIndex((int) r101));
        goto L10
    L5:
        r103 = r100.getX(r100.findPointerIndex((int) r101));
        goto L6
    }

    public final a.C1112a b(MotionEvent r100, boolean r101) {
        a.C1112a r102 = new a.C1112a();
        r102.f68019b = r100.getX() / this.f68008e;
        r100.getY();
        if (r101 == false) goto L7;
        Type r103 = this.f68013j;
        if (r103 == null) goto L7;
        r102.f68018a = r103.ordinal();
    L7:
        return r102;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        this.f68013j = Type.BEF_GESTURE_TYPE_PAN;
        a.C1112a r104 = b(r101, false);
        r104.getClass();
        r104.getClass();
        r104.getClass();
        e(203, r104);
        return true;
    }
}
