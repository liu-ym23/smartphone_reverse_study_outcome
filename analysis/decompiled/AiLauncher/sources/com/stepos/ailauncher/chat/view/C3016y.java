package com.stepos.ailauncher.chat.view;

import Z8.C1172u;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.ResultReceiver;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.drawerlayout.widget.DrawerLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.controller.AgentSpaceController;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatAction;
import com.stepos.ailauncher.container.api.IMemoryTrimmable;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.container.api.OverlayPageResumeReason;
import h8.C4148a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import o5.ChatLaunchPayload;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001pB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\"\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010 0\u001f\"\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0014¢\u0006\u0004\b'\u0010\u000eJ7\u0010-\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0014¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00142\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b3\u00102J\u0017\u00104\u001a\u00020\u00142\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b4\u00102J\u0017\u00107\u001a\u00020\f2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\fH\u0016¢\u0006\u0004\b=\u0010\u000eJ\u000f\u0010>\u001a\u00020\fH\u0016¢\u0006\u0004\b>\u0010\u000eJ\u0017\u0010@\u001a\u00020\f2\u0006\u0010:\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0014H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010\u000eJ\u0017\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u00020\f2\b\u0010I\u001a\u0004\u0018\u00010HH\u0014¢\u0006\u0004\bJ\u0010KJ\u001f\u0010P\u001a\u00020\f2\u0006\u0010M\u001a\u00020L2\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\f2\u0006\u0010$\u001a\u00020R¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u0014¢\u0006\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010gR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006q"}, d2 = {"Lcom/stepos/ailauncher/chat/view/y;", "Landroidx/drawerlayout/widget/DrawerLayout;", "Lcom/stepos/ailauncher/container/api/IOverlayPageView;", "Lcom/stepos/ailauncher/container/api/IMemoryTrimmable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "h0", "()V", "f0", "e0", "x", "y", "direction", "", "d0", "(III)Z", "Landroid/view/View;", "view", "g0", "(Landroid/view/View;III)Z", "i0", "(Landroid/view/View;II)Z", "", "message", "", "", "args", "l0", "(Ljava/lang/String;[Ljava/lang/Object;)V", "action", "b0", "(I)Ljava/lang/String;", "onAttachedToWindow", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "dispatchTouchEvent", "onInterceptTouchEvent", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "host", "onPageCreate", "(Lcom/stepos/ailauncher/container/api/IOverlayPageHost;)V", "Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "reason", "onPageResume", "(Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;)V", "onPagePause", "onPageStop", "Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "onPageDestroy", "(Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;)V", "onBackPressed", "()Z", "onNavigateHome", "level", "onTrimMemory", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lo5/e;", "payload", "Landroid/os/ResultReceiver;", "receiver", "c0", "(Lo5/e;Landroid/os/ResultReceiver;)V", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "k0", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;)V", x5.d.EXTRA_ENABLED, "setLockScreenMode", "(Z)V", "Lcom/stepos/ailauncher/chat/controller/AgentSpaceController;", "controller", "Lcom/stepos/ailauncher/chat/controller/AgentSpaceController;", "touchSlop", "I", "bottomDeadZone", "", "startX", "F", "startY", "gestureDecided", "Z", "decidedForDrawer", "inBottomDeadZone", "leftDragger", "Ljava/lang/Object;", "Ljava/lang/reflect/Field;", "edgeSizeField", "Ljava/lang/reflect/Field;", "leftCallback", "Ljava/lang/reflect/Method;", "peekCancelMethod", "Ljava/lang/reflect/Method;", "Companion", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3016y extends DrawerLayout implements IOverlayPageView, IMemoryTrimmable {
    private static final int DEFAULT_EDGE_SIZE_DP = 20;
    public static final String FOREGROUND_PAGE_KEY = "agent_space";
    private static final String TAG = "AgentSpaceView";
    private static final boolean VERBOSE_TOUCH_LOG = false;
    private final int bottomDeadZone;
    private final AgentSpaceController controller;
    private boolean decidedForDrawer;
    private Field edgeSizeField;
    private boolean gestureDecided;
    private boolean inBottomDeadZone;
    private Object leftCallback;
    private Object leftDragger;
    private Method peekCancelMethod;
    private float startX;
    private float startY;
    private final int touchSlop;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/view/y$a", "Landroidx/drawerlayout/widget/DrawerLayout$g;", "Landroid/view/View;", "drawerView", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", Const.INTENT_KEY_PKGNAME, "", "newState", "c", "(I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.y$a */
    public static final class a extends DrawerLayout.g {
        public a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View drawerView) throws IllegalAccessException, IllegalArgumentException {
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            C3016y.this.f0();
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View drawerView) throws IllegalAccessException, IllegalArgumentException {
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            C3016y.this.f0();
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int newState) {
            if (newState == 1) {
                C3016y.this.controller.w1();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3016y(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.controller = new AgentSpaceController(this);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bottomDeadZone = (int) (80 * getResources().getDisplayMetrics().density);
        LayoutInflater.from(context).inflate(R$layout.view_assistant_home, (ViewGroup) this, true);
        h0();
        a(new a());
    }

    public static final void j0(C3016y c3016y) {
        c3016y.setSystemGestureExclusionRects(C1172u.e(new Rect(0, 0, 200, c3016y.getHeight())));
    }

    public final String b0(int action) {
        if (action == 0) {
            return "DOWN";
        }
        if (action == 1) {
            return "UP";
        }
        if (action == 2) {
            return "MOVE";
        }
        if (action == 3) {
            return "CANCEL";
        }
        if (action == 5) {
            return "PTR_DOWN";
        }
        if (action == 6) {
            return "PTR_UP";
        }
        return "ACT_" + action;
    }

    public final void c0(ChatLaunchPayload payload, ResultReceiver receiver) {
        kotlin.jvm.internal.p.i(payload, "payload");
        this.controller.c1(payload, receiver);
    }

    public final boolean d0(int x10, int y10, int direction) {
        View viewFindViewById = findViewById(R$id.agent_space_content);
        if (viewFindViewById == null) {
            return false;
        }
        return g0(viewFindViewById, x10, y10, direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(ev, "ev");
        int actionMasked = ev.getActionMasked();
        l0("dispatchTouchEvent action=%s x=%.0f y=%.0f", b0(actionMasked), Float.valueOf(ev.getX()), Float.valueOf(ev.getY()));
        if (actionMasked == 0 && this.controller.r4(ev.getRawX(), ev.getRawY())) {
            this.startX = ev.getX();
            this.startY = ev.getY();
            this.gestureDecided = false;
            this.decidedForDrawer = false;
            this.inBottomDeadZone = ev.getY() > ((float) (getHeight() - this.bottomDeadZone));
            return true;
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(ev);
        if (actionMasked != 0 && actionMasked != 5) {
            return zDispatchTouchEvent;
        }
        e0();
        return zDispatchTouchEvent;
    }

    public final void e0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = this.peekCancelMethod;
            if (method != null) {
                method.invoke(this.leftCallback, null);
            }
        } catch (Exception unused) {
        }
    }

    public final void f0() throws IllegalAccessException, IllegalArgumentException {
        Object obj;
        Field field;
        if (this.controller.getLockScreenMode() || (obj = this.leftDragger) == null || (field = this.edgeSizeField) == null) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (getWidth() > 0) {
            iMin = Math.min(getWidth(), iMin);
        }
        if (C(8388611)) {
            iMin = (int) (20 * displayMetrics.density);
        }
        try {
            field.setInt(obj, iMin);
        } catch (Exception e10) {
            C4148a.t(TAG, "expandDrawerEdgeSize failed", e10, false, 8, null);
        }
    }

    public final boolean g0(View view, int x10, int y10, int direction) {
        if (!i0(view, x10, y10)) {
            return false;
        }
        if (view.canScrollHorizontally(direction)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int left = (x10 - viewGroup.getLeft()) + viewGroup.getScrollX();
            int top = (y10 - viewGroup.getTop()) + viewGroup.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                kotlin.jvm.internal.p.f(childAt);
                if (g0(childAt, left, top, direction)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h0() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField;
        Method declaredMethod;
        try {
            Field declaredField2 = DrawerLayout.class.getDeclaredField("mLeftDragger");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this);
            this.leftDragger = obj;
            Method method = null;
            if (obj == null || (declaredField = obj.getClass().getDeclaredField("mEdgeSize")) == null) {
                declaredField = null;
            } else {
                declaredField.setAccessible(true);
            }
            this.edgeSizeField = declaredField;
            Field declaredField3 = DrawerLayout.class.getDeclaredField("mLeftCallback");
            declaredField3.setAccessible(true);
            Object obj2 = declaredField3.get(this);
            this.leftCallback = obj2;
            if (obj2 != null && (declaredMethod = obj2.getClass().getDeclaredMethod("removeCallbacks", null)) != null) {
                declaredMethod.setAccessible(true);
                method = declaredMethod;
            }
            this.peekCancelMethod = method;
        } catch (Exception e10) {
            C4148a.t(TAG, "initReflection failed", e10, false, 8, null);
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public /* bridge */ void hideImeForHomeConsume() {
        super.hideImeForHomeConsume();
    }

    public final boolean i0(View view, int x10, int y10) {
        return x10 >= view.getLeft() && x10 < view.getRight() && y10 >= view.getTop() && y10 < view.getBottom();
    }

    public final void k0(LockScreenChatAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        AgentSpaceController.q3(this.controller, action, 0, 2, null);
    }

    public final void l0(String message, Object... args) {
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public /* bridge */ void onAllTasksEntryVisibilityChanged(boolean z10) {
        super.onAllTasksEntryVisibilityChanged(z10);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.x
            @Override // java.lang.Runnable
            public final void run() {
                C3016y.j0(this.f26408a);
            }
        });
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public boolean onBackPressed() {
        return this.controller.M2();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.controller.N2();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public /* bridge */ void onEnterSystemRecents() {
        super.onEnterSystemRecents();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ViewParent parent;
        kotlin.jvm.internal.p.i(ev, "ev");
        if (this.controller.getLockScreenMode()) {
            return false;
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.startX = ev.getX();
            this.startY = ev.getY();
            this.gestureDecided = false;
            this.decidedForDrawer = false;
            this.inBottomDeadZone = ev.getY() > ((float) (getHeight() - this.bottomDeadZone));
            Float fValueOf = Float.valueOf(ev.getX());
            Float fValueOf2 = Float.valueOf(ev.getY());
            Boolean boolValueOf = Boolean.valueOf(this.inBottomDeadZone);
            ViewParent parent2 = getParent();
            l0("INTERCEPT DOWN x=%.0f y=%.0f inDeadZone=%b parent=%s", fValueOf, fValueOf2, boolValueOf, parent2 != null ? parent2.getClass().getSimpleName() : null);
            if (this.inBottomDeadZone) {
                if (F(8388611) && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
            ViewParent parent3 = getParent();
            if (parent3 != null) {
                parent3.requestDisallowInterceptTouchEvent(true);
            }
            l0("INTERCEPT DOWN requestDisallow(true) done", new Object[0]);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(ev);
            l0("INTERCEPT DOWN superResult=%b", Boolean.valueOf(zOnInterceptTouchEvent));
            return zOnInterceptTouchEvent;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.inBottomDeadZone) {
                    return false;
                }
                if (this.gestureDecided) {
                    boolean zOnInterceptTouchEvent2 = this.decidedForDrawer ? super.onInterceptTouchEvent(ev) : false;
                    l0("INTERCEPT MOVE (already decided) forDrawer=%b result=%b", Boolean.valueOf(this.decidedForDrawer), Boolean.valueOf(zOnInterceptTouchEvent2));
                    return zOnInterceptTouchEvent2;
                }
                if (ev.getPointerCount() > 1) {
                    this.gestureDecided = true;
                    this.decidedForDrawer = false;
                    l0("INTERCEPT MOVE multi-pointer(%d) → NOT FOR DRAWER, keep disallow", Integer.valueOf(ev.getPointerCount()));
                    return false;
                }
                float x10 = ev.getX() - this.startX;
                float y10 = ev.getY() - this.startY;
                l0("INTERCEPT MOVE dx=%.1f dy=%.1f touchSlop=%d absDx>slop=%b absDy>slop=%b", Float.valueOf(x10), Float.valueOf(y10), Integer.valueOf(this.touchSlop), Boolean.valueOf(Math.abs(x10) > ((float) this.touchSlop)), Boolean.valueOf(Math.abs(y10) > ((float) this.touchSlop)));
                if (Math.abs(x10) <= this.touchSlop && Math.abs(y10) <= this.touchSlop) {
                    return false;
                }
                this.gestureDecided = true;
                boolean z10 = Math.abs(x10) > Math.abs(y10) * ((float) 2);
                l0("INTERCEPT MOVE DECIDED isHorizontal=%b dx=%.1f dy=%.1f", Boolean.valueOf(z10), Float.valueOf(x10), Float.valueOf(y10));
                if (z10) {
                    boolean zF = F(8388611);
                    int i10 = x10 > 0.0f ? -1 : 1;
                    boolean zD0 = d0((int) this.startX, (int) this.startY, i10);
                    l0("INTERCEPT MOVE HORIZONTAL dx=%.1f drawerVisible=%b childCanScroll(dir=%d)=%b", Float.valueOf(x10), Boolean.valueOf(zF), Integer.valueOf(i10), Boolean.valueOf(zD0));
                    if (x10 > 0.0f && !zF && !zD0) {
                        this.decidedForDrawer = true;
                        l0("INTERCEPT MOVE → DRAWER OPEN (right swipe)", new Object[0]);
                        this.controller.w1();
                        return super.onInterceptTouchEvent(ev);
                    }
                    if (x10 < 0.0f && zF) {
                        this.decidedForDrawer = true;
                        l0("INTERCEPT MOVE → DRAWER CLOSE (left swipe)", new Object[0]);
                        return super.onInterceptTouchEvent(ev);
                    }
                    if (zD0) {
                        l0("INTERCEPT MOVE → CHILD SCROLL, keep disallow", new Object[0]);
                        return false;
                    }
                }
                l0("INTERCEPT MOVE → NOT FOR DRAWER, releasing disallow", new Object[0]);
                ViewParent parent4 = getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
            if (actionMasked != 3) {
                return super.onInterceptTouchEvent(ev);
            }
        }
        l0("INTERCEPT %s releasing disallow", ev.getActionMasked() == 1 ? "UP" : "CANCEL");
        ViewParent parent5 = getParent();
        if (parent5 != null) {
            parent5.requestDisallowInterceptTouchEvent(false);
        }
        boolean zOnInterceptTouchEvent3 = super.onInterceptTouchEvent(ev);
        this.gestureDecided = false;
        this.decidedForDrawer = false;
        return zOnInterceptTouchEvent3;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) throws IllegalAccessException, IllegalArgumentException {
        super.onLayout(changed, left, top, right, bottom);
        f0();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onNavigateHome() {
        this.controller.R2();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageCreate(IOverlayPageHost host) {
        kotlin.jvm.internal.p.i(host, "host");
        this.controller.S2(host);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageDestroy(OverlayPageDestroyReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        this.controller.T2(reason);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPagePause() {
        this.controller.U2();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageResume(OverlayPageResumeReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        this.controller.V2(reason);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageView
    public void onPageStop() {
        this.controller.X2();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        l0("onTouchEvent action=%s x=%.0f y=%.0f inDeadZone=%b", b0(ev.getActionMasked()), Float.valueOf(ev.getX()), Float.valueOf(ev.getY()), Boolean.valueOf(this.inBottomDeadZone));
        if (!this.inBottomDeadZone || F(8388611)) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override // com.stepos.ailauncher.container.api.IMemoryTrimmable
    public void onTrimMemory(int level) {
        this.controller.b3(level);
    }

    public final void setLockScreenMode(boolean enabled) {
        this.controller.N3(enabled);
    }

    public /* synthetic */ C3016y(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
