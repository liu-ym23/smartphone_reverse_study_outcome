package com.stepos.agentframework.chatui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1336y;
import androidx.core.widget.NestedScrollView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001jB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0013J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0018\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u001aJ/\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J7\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010!J7\u0010&\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010'J?\u0010&\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010(JG\u0010&\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010)J'\u0010-\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J/\u0010/\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u000f2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b7\u00106J\u0017\u00109\u001a\u00020\u000f2\u0006\u00108\u001a\u000203H\u0016¢\u0006\u0004\b9\u00106J\u000f\u0010:\u001a\u00020\u0014H\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00142\u0006\u0010>\u001a\u00020*H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0014H\u0002¢\u0006\u0004\bA\u0010;J\u0017\u0010B\u001a\u00020\u00142\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0014H\u0002¢\u0006\u0004\bD\u0010;J'\u0010G\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020*H\u0002¢\u0006\u0004\bJ\u0010KJ\u0011\u0010L\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0014H\u0002¢\u0006\u0004\bN\u0010;R*\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010^R\u0016\u0010`\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\\R\u0016\u0010a\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010\\R\u0016\u0010b\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010\\R\u0016\u0010c\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010\\R\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010\\R\u0016\u0010h\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010^¨\u0006k"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/FeedbackDragDismissLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/core/view/y;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "child", "target", "axes", "", "onStartNestedScroll", "(Landroid/view/View;Landroid/view/View;I)Z", "type", "(Landroid/view/View;Landroid/view/View;II)Z", "LY8/t;", "onNestedScrollAccepted", "(Landroid/view/View;Landroid/view/View;I)V", "(Landroid/view/View;Landroid/view/View;II)V", "onStopNestedScroll", "(Landroid/view/View;)V", "(Landroid/view/View;I)V", "dx", "dy", "", "consumed", "onNestedPreScroll", "(Landroid/view/View;II[I)V", "(Landroid/view/View;II[II)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "(Landroid/view/View;IIII)V", "(Landroid/view/View;IIIII)V", "(Landroid/view/View;IIIII[I)V", "", "velocityX", "velocityY", "onNestedPreFling", "(Landroid/view/View;FF)Z", "onNestedFling", "(Landroid/view/View;FFZ)Z", "getNestedScrollAxes", "()I", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onInterceptTouchEvent", "event", "onTouchEvent", "onDetachedFromWindow", "()V", Const.INTENT_KEY_UMID, "(F)F", "velocityDown", "settle", "(F)V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/MotionEvent;)V", "f", "rawX", "rawY", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(FFLandroid/view/View;)Z", "y", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(F)Z", "e", "()Landroid/view/View;", "k", "Lkotlin/Function0;", "onDismissRequested", "Lp9/a;", "getOnDismissRequested", "()Lp9/a;", "setOnDismissRequested", "(Lp9/a;)V", "Landroidx/core/view/z;", "parentHelper", "Landroidx/core/view/z;", "touchSlop", "I", "minFlingVelocity", "F", "nestedScrollInProgress", "Z", "intercepting", "downX", "downY", "downRawY", "downTranslationY", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/VelocityTracker;", "lastNestedFlingY", "imeHiddenForDrag", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedbackDragDismissLayout extends ConstraintLayout implements InterfaceC1336y {
    private static final float DISMISS_DISTANCE_FRACTION = 0.2f;
    private float downRawY;
    private float downTranslationY;
    private float downX;
    private float downY;
    private boolean imeHiddenForDrag;
    private boolean intercepting;
    private float lastNestedFlingY;
    private final float minFlingVelocity;
    private boolean nestedScrollInProgress;
    private InterfaceC5063a<Y8.t> onDismissRequested;
    private final C1337z parentHelper;
    private final int touchSlop;
    private VelocityTracker velocityTracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedbackDragDismissLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void settle(float velocityDown) {
        if (getTranslationY() <= 0.0f) {
            this.imeHiddenForDrag = false;
            return;
        }
        if ((getTranslationY() > getHeight() * 0.2f || velocityDown > this.minFlingVelocity * 2.0f) && getHeight() > 0) {
            animate().translationY(getHeight()).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.agentframework.chatui.dialog.B
                @Override // java.lang.Runnable
                public final void run() {
                    FeedbackDragDismissLayout.settle$lambda$0(this.f22879a);
                }
            }).start();
        } else {
            animate().translationY(0.0f).setDuration(180L).start();
            this.imeHiddenForDrag = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void settle$lambda$0(FeedbackDragDismissLayout feedbackDragDismissLayout) {
        InterfaceC5063a<Y8.t> interfaceC5063a = feedbackDragDismissLayout.onDismissRequested;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final float d(float dy) {
        if (dy == 0.0f) {
            return 0.0f;
        }
        float translationY = getTranslationY();
        float fE = C5685n.e(translationY - dy, 0.0f);
        if (fE == translationY) {
            return 0.0f;
        }
        setTranslationY(fE);
        g();
        return translationY - fE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            h(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof NestedScrollView) {
                return childAt;
            }
        }
        return null;
    }

    public final void f() {
        Object systemService = getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public final void g() {
        if (this.imeHiddenForDrag || getTranslationY() <= 0.0f) {
            return;
        }
        this.imeHiddenForDrag = true;
        f();
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.parentHelper.a();
    }

    public final InterfaceC5063a<Y8.t> getOnDismissRequested() {
        return this.onDismissRequested;
    }

    public final void h(MotionEvent ev) {
        EditText editText = (EditText) findViewById(R$id.et_feedback);
        if (editText == null || !editText.hasFocus() || j(ev.getRawX(), ev.getRawY(), editText)) {
            return;
        }
        editText.clearFocus();
        f();
    }

    public final boolean i(float y10) {
        View viewE = e();
        return viewE == null || y10 < ((float) viewE.getTop());
    }

    public final boolean j(float rawX, float rawY, View target) {
        if (target.getVisibility() == 0 && target.getWidth() > 0 && target.getHeight() > 0) {
            int[] iArr = new int[2];
            target.getLocationOnScreen(iArr);
            if (rawX >= iArr[0] && rawX <= r1 + target.getWidth()) {
                if (rawY >= iArr[1] && rawY <= r3 + target.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void k() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        k();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r6, r0)
            int r0 = r6.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L7b
            if (r0 == r2) goto L6b
            r3 = 2
            if (r0 == r3) goto L17
            r3 = 3
            if (r0 == r3) goto L6b
            goto La8
        L17:
            android.view.VelocityTracker r0 = r5.velocityTracker
            if (r0 == 0) goto L1e
            r0.addMovement(r6)
        L1e:
            boolean r0 = r5.intercepting
            if (r0 == 0) goto L23
            return r2
        L23:
            boolean r0 = r5.nestedScrollInProgress
            if (r0 == 0) goto L28
            return r1
        L28:
            float r0 = r6.getY()
            float r3 = r5.downY
            float r0 = r0 - r3
            float r3 = r6.getX()
            float r4 = r5.downX
            float r3 = r3 - r4
            int r4 = r5.touchSlop
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto La8
            float r3 = java.lang.Math.abs(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto La8
            android.view.View r0 = r5.e()
            float r3 = r5.downY
            boolean r3 = r5.i(r3)
            if (r0 == 0) goto L5a
            r4 = -1
            boolean r0 = r0.canScrollVertically(r4)
            if (r0 != r2) goto L5a
            r0 = r2
            goto L5b
        L5a:
            r0 = r1
        L5b:
            if (r3 != 0) goto L5f
            if (r0 != 0) goto La8
        L5f:
            r5.intercepting = r2
            android.view.ViewParent r5 = r5.getParent()
            if (r5 == 0) goto L6a
            r5.requestDisallowInterceptTouchEvent(r2)
        L6a:
            return r2
        L6b:
            android.view.VelocityTracker r0 = r5.velocityTracker
            if (r0 == 0) goto L72
            r0.addMovement(r6)
        L72:
            boolean r0 = r5.intercepting
            if (r0 == 0) goto L77
            return r2
        L77:
            r5.k()
            goto La8
        L7b:
            r5.intercepting = r1
            float r0 = r6.getX()
            r5.downX = r0
            float r0 = r6.getY()
            r5.downY = r0
            float r0 = r6.getRawY()
            r5.downRawY = r0
            float r0 = r5.getTranslationY()
            r5.downTranslationY = r0
            android.view.ViewPropertyAnimator r0 = r5.animate()
            r0.cancel()
            r5.k()
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r0.addMovement(r6)
            r5.velocityTracker = r0
        La8:
            boolean r0 = r5.intercepting
            if (r0 != 0) goto Lb4
            boolean r5 = super.onInterceptTouchEvent(r6)
            if (r5 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r1
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.dialog.FeedbackDragDismissLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        kotlin.jvm.internal.p.i(target, "target");
        this.lastNestedFlingY = velocityY;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        onNestedPreScroll(target, dx, dy, consumed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View child, View target, int axes) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScrollAccepted(child, target, axes, 0);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        return type == 0 && (axes & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View target) {
        kotlin.jvm.internal.p.i(target, "target");
        onStopNestedScroll(target, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.p.i(r7, r0)
            android.view.VelocityTracker r0 = r6.velocityTracker
            if (r0 == 0) goto Lc
            r0.addMovement(r7)
        Lc:
            int r0 = r7.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La3
            r3 = 0
            if (r0 == r2) goto L78
            r4 = 2
            if (r0 == r4) goto L1f
            r4 = 3
            if (r0 == r4) goto L78
            goto Lae
        L1f:
            float r0 = r7.getY()
            float r4 = r6.downY
            float r0 = r0 - r4
            float r4 = r7.getX()
            float r5 = r6.downX
            float r4 = r4 - r5
            boolean r5 = r6.intercepting
            if (r5 != 0) goto L57
            boolean r5 = r6.nestedScrollInProgress
            if (r5 != 0) goto L57
            int r5 = r6.touchSlop
            float r5 = (float) r5
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 <= 0) goto L57
            float r4 = java.lang.Math.abs(r4)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L57
            float r0 = r6.downY
            boolean r0 = r6.i(r0)
            if (r0 == 0) goto L57
            r6.intercepting = r2
            android.view.ViewParent r0 = r6.getParent()
            if (r0 == 0) goto L57
            r0.requestDisallowInterceptTouchEvent(r2)
        L57:
            boolean r0 = r6.intercepting
            if (r0 != 0) goto L63
            float r0 = r6.getTranslationY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto Lae
        L63:
            float r0 = r6.downTranslationY
            float r7 = r7.getRawY()
            float r0 = r0 + r7
            float r7 = r6.downRawY
            float r0 = r0 - r7
            float r7 = v9.C5685n.e(r0, r3)
            r6.setTranslationY(r7)
            r6.g()
            return r2
        L78:
            boolean r0 = r6.intercepting
            if (r0 != 0) goto L89
            float r0 = r6.getTranslationY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L85
            goto L89
        L85:
            r6.k()
            goto Lae
        L89:
            r6.intercepting = r1
            android.view.VelocityTracker r7 = r6.velocityTracker
            if (r7 == 0) goto L94
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.computeCurrentVelocity(r0)
        L94:
            android.view.VelocityTracker r7 = r6.velocityTracker
            if (r7 == 0) goto L9c
            float r3 = r7.getYVelocity()
        L9c:
            r6.k()
            r6.settle(r3)
            return r2
        La3:
            float r0 = r7.getY()
            boolean r0 = r6.i(r0)
            if (r0 == 0) goto Lae
            return r2
        Lae:
            boolean r0 = r6.intercepting
            if (r0 != 0) goto Lba
            boolean r6 = super.onTouchEvent(r7)
            if (r6 == 0) goto Lb9
            goto Lba
        Lb9:
            return r1
        Lba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.dialog.FeedbackDragDismissLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setOnDismissRequested(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onDismissRequested = interfaceC5063a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackDragDismissLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.parentHelper = new C1337z(this);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.minFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        if (type != 0) {
            return;
        }
        if (getTranslationY() > 0.0f && dy > 0) {
            float fI = C5685n.i(dy, getTranslationY());
            d(fI);
            consumed[1] = (int) fI;
        } else {
            if (dy >= 0 || target.canScrollVertically(-1)) {
                return;
            }
            float fD = d(dy);
            if (fD == 0.0f) {
                return;
            }
            consumed[1] = (int) fD;
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, new int[2]);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        this.parentHelper.c(child, target, axes, type);
        this.nestedScrollInProgress = true;
        this.lastNestedFlingY = 0.0f;
        animate().cancel();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int axes) {
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(target, "target");
        return onStartNestedScroll(child, target, axes, 0);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View target, int type) {
        kotlin.jvm.internal.p.i(target, "target");
        this.parentHelper.e(target, type);
        if (type != 0) {
            return;
        }
        this.nestedScrollInProgress = false;
        settle(-this.lastNestedFlingY);
        this.lastNestedFlingY = 0.0f;
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(consumed, "consumed");
        if (type != 0 || dyUnconsumed >= 0) {
            return;
        }
        consumed[1] = (int) d(dyUnconsumed);
    }

    public /* synthetic */ FeedbackDragDismissLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
