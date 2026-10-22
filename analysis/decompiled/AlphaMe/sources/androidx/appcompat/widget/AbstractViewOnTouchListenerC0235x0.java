package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewConfiguration;
import k.InterfaceC0644E;

/* renamed from: androidx.appcompat.widget.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0235x0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f3196a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3197b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3198c;

    /* renamed from: d, reason: collision with root package name */
    public final View f3199d;

    /* renamed from: e, reason: collision with root package name */
    public RunnableC0233w0 f3200e;

    /* renamed from: f, reason: collision with root package name */
    public RunnableC0233w0 f3201f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3202g;

    /* renamed from: h, reason: collision with root package name */
    public int f3203h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f3204i = new int[2];

    public AbstractViewOnTouchListenerC0235x0(View view) {
        this.f3199d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f3196a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f3197b = tapTimeout;
        this.f3198c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0233w0 runnableC0233w0 = this.f3201f;
        View view = this.f3199d;
        if (runnableC0233w0 != null) {
            view.removeCallbacks(runnableC0233w0);
        }
        RunnableC0233w0 runnableC0233w02 = this.f3200e;
        if (runnableC0233w02 != null) {
            view.removeCallbacks(runnableC0233w02);
        }
    }

    public abstract InterfaceC0644E b();

    public abstract boolean c();

    public boolean d() {
        InterfaceC0644E interfaceC0644EB = b();
        if (interfaceC0644EB == null || !interfaceC0644EB.e()) {
            return true;
        }
        interfaceC0644EB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f3202g = false;
        this.f3203h = -1;
        RunnableC0233w0 runnableC0233w0 = this.f3200e;
        if (runnableC0233w0 != null) {
            this.f3199d.removeCallbacks(runnableC0233w0);
        }
    }
}
