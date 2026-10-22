package com.stepos.ailauncher.chat.voice.longpress;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/s;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "canTap", "LY8/t;", "onTap", "<init>", "(Landroid/content/Context;Lp9/a;Lp9/a;)V", Const.INTENT_KEY_UMID, "()V", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "performClick", "()Z", "onDetachedFromWindow", "Lp9/a;", "tapAllowedOnDown", "Z", "Landroid/view/GestureDetector;", "detector", "Landroid/view/GestureDetector;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.longpress.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3053s extends FrameLayout {
    private final InterfaceC5063a<Boolean> canTap;
    private final GestureDetector detector;
    private final InterfaceC5063a<Y8.t> onTap;
    private boolean tapAllowedOnDown;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/s$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "(Landroid/view/MotionEvent;)Z", "onSingleTapUp", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.s$a */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            C3053s c3053s = C3053s.this;
            c3053s.tapAllowedOnDown = ((Boolean) c3053s.canTap.invoke()).booleanValue();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            boolean z10 = C3053s.this.tapAllowedOnDown && e10.getEventTime() - e10.getDownTime() < ((long) ViewConfiguration.getLongPressTimeout());
            C3053s.this.d();
            if (z10) {
                C3053s.this.performClick();
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3053s(Context context, InterfaceC5063a<Boolean> canTap, InterfaceC5063a<Y8.t> onTap) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(canTap, "canTap");
        kotlin.jvm.internal.p.i(onTap, "onTap");
        this.canTap = canTap;
        this.onTap = onTap;
        GestureDetector gestureDetector = new GestureDetector(context, new a());
        gestureDetector.setOnDoubleTapListener(null);
        this.detector = gestureDetector;
    }

    public final void d() {
        this.tapAllowedOnDown = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        this.detector.onTouchEvent(event);
        if (event.getActionMasked() != 3 && event.getActionMasked() != 5) {
            return true;
        }
        d();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        if (!this.canTap.invoke().booleanValue()) {
            return true;
        }
        this.onTap.invoke();
        return true;
    }
}
