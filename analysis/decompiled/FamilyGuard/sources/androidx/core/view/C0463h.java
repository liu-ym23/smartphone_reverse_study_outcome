package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

@Deprecated
/* renamed from: androidx.core.view.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0463h {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f9814a;

    public C0463h(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f9814a.onTouchEvent(motionEvent);
    }

    public C0463h(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f9814a = new GestureDetector(context, onGestureListener, handler);
    }
}
