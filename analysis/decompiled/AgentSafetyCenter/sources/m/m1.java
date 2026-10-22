package m;

import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class m1 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final float f8002c;

    /* renamed from: f, reason: collision with root package name */
    public final int f8003f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8004g;

    /* renamed from: h, reason: collision with root package name */
    public final View f8005h;
    public l1 i;

    /* renamed from: j, reason: collision with root package name */
    public l1 f8006j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8007k;

    /* renamed from: l, reason: collision with root package name */
    public int f8008l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f8009m = new int[2];

    public m1(View view) {
        this.f8005h = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f8002c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f8003f = tapTimeout;
        this.f8004g = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        l1 l1Var = this.f8006j;
        View view = this.f8005h;
        if (l1Var != null) {
            view.removeCallbacks(l1Var);
        }
        l1 l1Var2 = this.i;
        if (l1Var2 != null) {
            view.removeCallbacks(l1Var2);
        }
    }

    public abstract l.b0 b();

    public abstract boolean c();

    public boolean d() {
        l.b0 b0VarB = b();
        if (b0VarB == null || !b0VarB.b()) {
            return true;
        }
        b0VarB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0108  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.m1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f8007k = false;
        this.f8008l = -1;
        l1 l1Var = this.i;
        if (l1Var != null) {
            this.f8005h.removeCallbacks(l1Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
