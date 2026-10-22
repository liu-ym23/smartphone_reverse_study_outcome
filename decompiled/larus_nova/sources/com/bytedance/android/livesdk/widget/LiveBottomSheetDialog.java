package com.bytedance.android.livesdk.widget;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.utility.reflect.ReflectException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public class LiveBottomSheetDialog extends AppCompatDialog implements WeakHandler.IHandler {
    private static final int MSG_WHAT_DISMISS_DIALOG = 1;
    protected LiveBottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheetView;
    boolean cancelable;
    private int currentBottomSheetBehaviorState;
    private boolean dismissHandlerEnable;
    boolean isNeedHookBottomSheetInterceptEvent;
    private LiveBottomSheetBehavior.c mBottomSheetCallback;
    private j mBottomSheetDismissProcessor;
    private l mBottomSheetPullUpProcessor;
    private m mBottomSheetSlideProcessor;
    private boolean mCanceledOnTouchOutside;
    private boolean mCanceledOnTouchOutsideSet;
    private boolean mEnablePullUp;
    private Animator mExitAnimator;
    private WeakHandler mHandler;
    private k mLiveBottomSheetOutsideListener;
    private LiveBottomSheetBehavior.c mStateCallback;
    private View mTargetExitAnimationView;
    protected View outsideView;
    private boolean popupEnable;
    private int webViewCollapsedHeight;

    public class a extends AccessibilityDelegateCompat {
        public a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setContentDescription("关闭");
            r101.setClassName(Button.class.getName());
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160946a;

        public b(LiveBottomSheetDialog r100) {
            this.f160946a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f160946a.cancel();
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160947a;

        public c(LiveBottomSheetDialog r100) {
            this.f160947a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f160947a.cancelable == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            LiveBottomSheetDialog r103 = this.f160947a;
            if (r103.cancelable == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class d implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }

        public d() {
        }
    }

    public class e extends LiveBottomSheetBehavior.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160948a;

        public e(LiveBottomSheetDialog r100) {
            this.f160948a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetBehavior.c
        public final void a(View r100, float r101) {
            if (LiveBottomSheetDialog.access$000(this.f160948a) == null) goto L6;
            LiveBottomSheetDialog.access$000(this.f160948a).a(r100, r101);
            return;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetBehavior.c
        public final void b(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f160948a.cancel();
        L6:
            if (LiveBottomSheetDialog.access$000(this.f160948a) == null) goto L9;
            LiveBottomSheetDialog.access$000(this.f160948a).b(r100, r101);
            return;
        }
    }

    public class f implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f160949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160950b;

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            if (this.f160949a.disableDragDown() == false) goto L5;
        L8:
            return true;
        L5:
            if (LiveBottomSheetDialog.access$100(this.f160950b) == false) goto L8;
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return this.f160949a.shouldInterceptSlide(r100);
        }

        public f(LiveBottomSheetDialog r100, m r101) {
            this.f160950b = r100;
            this.f160949a = r101;
        }
    }

    public class g implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f160951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160952b;

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final /* synthetic */ boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean a() {
            return this.f160951a.a();
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean c() {
            if (this.f160951a.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f160951a.c() == false) goto L7;
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean d() {
            if (this.f160951a.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f160951a.d() == false) goto L7;
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.l
        public final boolean e() {
            if (this.f160951a.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (LiveBottomSheetDialog.access$100(this.f160952b) == false) goto L7;
            return true;
        }

        public g(LiveBottomSheetDialog r100, l r101) {
            this.f160952b = r100;
            this.f160951a = r101;
        }
    }

    public class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160953a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public h(LiveBottomSheetDialog r100) {
            this.f160953a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            if (LiveBottomSheetDialog.access$200(this.f160953a) == null) goto L5;
            LiveBottomSheetDialog.access$200(this.f160953a).setVisibility(8);
        L5:
            LiveBottomSheetDialog.access$401(this.f160953a);
            com.bytedance.android.livesdk.e.b().d();
            com.bytedance.android.livesdk.f.d().f();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (LiveBottomSheetDialog.access$200(this.f160953a) == null) goto L5;
            LiveBottomSheetDialog.access$200(this.f160953a).setVisibility(8);
        L5:
            LiveBottomSheetDialog.access$301(this.f160953a);
            com.bytedance.android.livesdk.e.b().d();
            com.bytedance.android.livesdk.f.d().f();
        }
    }

    public class i implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBottomSheetDialog f160954a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public i(LiveBottomSheetDialog r100) {
            this.f160954a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            if (LiveBottomSheetDialog.access$200(this.f160954a) == null) goto L5;
            LiveBottomSheetDialog.access$200(this.f160954a).setVisibility(8);
        L5:
            LiveBottomSheetDialog.access$601(this.f160954a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (LiveBottomSheetDialog.access$200(this.f160954a) == null) goto L5;
            LiveBottomSheetDialog.access$200(this.f160954a).setVisibility(8);
        L5:
            LiveBottomSheetDialog.access$501(this.f160954a);
        }
    }

    public interface j {
        boolean a();
    }

    public interface k {
        void a(boolean r100);
    }

    public interface l {
        boolean a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();
    }

    public interface m {
        boolean disableDragDown();

        boolean shouldInterceptSlide(int r100);
    }

    public static /* synthetic */ boolean I0(LiveBottomSheetDialog r100) {
        return r100.lambda$new$1();
    }

    public static /* synthetic */ boolean J0(LiveBottomSheetDialog r100) {
        return r100.lambda$new$0();
    }

    public static /* synthetic */ boolean L0(LiveBottomSheetDialog r100) {
        return r100.lambda$new$2();
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$002(AppCompatDialog r100) {
        super.show();
    }

    public static /* synthetic */ void access$003(AppCompatDialog r100) {
        super.dismiss();
    }

    private void initDisableDragDownFromSettings() {
        this.popupEnable = j40.y1.f497326a.getValue().booleanValue();
    }

    private /* synthetic */ boolean lambda$new$0() {
        return !this.popupEnable;
    }

    private /* synthetic */ boolean lambda$new$1() {
        return !this.popupEnable;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.cancelable == true) goto L5;
    L18:
        k r100 = this.mLiveBottomSheetOutsideListener;
        if (r100 == null) goto L24;
        r100.a(false);
        return;
    L24:
        return;
    L5:
        if (isShowing() == false) goto L18;
        if (shouldWindowCloseOnTouchOutside() == false) goto L18;
        k r101 = this.mLiveBottomSheetOutsideListener;
        if (r101 == null) goto L11;
        r101.a(true);
    L11:
        Animator r102 = this.mExitAnimator;
        if (r102 != null) goto L14;
        super.cancel();
        return;
    L14:
        if (r102.isRunning() == false) goto L16;
        return;
    L16:
        this.mExitAnimator.addListener(new i(this));
        this.mExitAnimator.start();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Animator r100 = this.mExitAnimator;
        if (r100 != null) goto L5;
        j r101 = this.mBottomSheetDismissProcessor;
        if (r101 != null) goto L11;
    L13:
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
    L14:
        com.bytedance.android.livesdk.e.b().d();
        com.bytedance.android.livesdk.f.d().f();
        return;
    L11:
        if (r101.a() == false) goto L13;
        this.mHandler.sendEmptyMessage(1);
        goto L14
    L5:
        if (r100.isRunning() == false) goto L7;
        return;
    L7:
        this.mExitAnimator.addListener(new h(this));
        this.mExitAnimator.start();
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.mCanceledOnTouchOutsideSet == true) goto L6;
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.mCanceledOnTouchOutside = r100.getBoolean(0, true);
        r100.recycle();
        this.mCanceledOnTouchOutsideSet = true;
    L6:
        return this.mCanceledOnTouchOutside;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator r100 = this.mExitAnimator;
        if (r100 == null) goto L6;
        r100.removeAllListeners();
        this.mExitAnimator.cancel();
        this.mExitAnimator = null;
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        LiveBottomSheetBehavior<FrameLayout> r100 = this.behavior;
        if (r100 == null) goto L8;
        r100.setState(3);
        if (this.mEnablePullUp == false) goto L9;
        this.behavior.setState(4);
        return;
    L9:
        return;
    }

    public boolean shouldRemoveFitsSysWin() {
        Context r100 = getContext();
        if (r100 != null) goto L5;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L14;
    L16:
        return false;
    L14:
        if (PadConfigUtils.c() == true) goto L16;
        return true;
    L5:
        if (r100.getResources() == null) goto L11;
        if (r100.getResources().getConfiguration() == null) goto L11;
        if (r100.getResources().getConfiguration().orientation != 2) goto L11;
        r101 = true;
        goto L12
    }

    @Override // android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        com.bytedance.android.livesdk.e.b().a();
        com.bytedance.android.livesdk.f.d().a();
    }

    private /* synthetic */ boolean lambda$new$2() {
        return this.dismissHandlerEnable;
    }

    public View getBottomSheetView() {
        return this.bottomSheetView;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        cancel();
    }

    public LiveBottomSheetDialog(Context r100) {
        this(r100, 0);
    }

    public static void INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$003(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$002(r100);
        DialogLancet.afterDialogShow(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ LiveBottomSheetBehavior.c access$000(LiveBottomSheetDialog r100) {
        return r100.mStateCallback;
    }

    public static /* synthetic */ boolean access$100(LiveBottomSheetDialog r100) {
        return r100.popupEnable;
    }

    public static /* synthetic */ View access$200(LiveBottomSheetDialog r100) {
        return r100.mTargetExitAnimationView;
    }

    public static /* synthetic */ void access$301(LiveBottomSheetDialog r100) {
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
    }

    public static /* synthetic */ void access$401(LiveBottomSheetDialog r100) {
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
    }

    public static /* synthetic */ void access$501(LiveBottomSheetDialog r100) {
        super.cancel();
    }

    public static /* synthetic */ void access$601(LiveBottomSheetDialog r100) {
        super.cancel();
    }

    private void accessibilityCompat(boolean r100) {
        View r101 = this.outsideView;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.setImportantForAccessibility(1);
        this.outsideView.setFocusable(true);
        ViewCompat.setAccessibilityDelegate(this.outsideView, new a());
        return;
    L6:
        r101.setImportantForAccessibility(2);
        this.outsideView.setFocusable(false);
        ViewCompat.setAccessibilityDelegate(this.outsideView, null);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (1 != r100.what) goto L8;
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        initDisableDragDownFromSettings();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mLiveBottomSheetOutsideListener == null) goto L10;
        if (1 != r100.getAction()) goto L10;
        if (isOutOfBounds(getContext(), r100) == false) goto L10;
        this.mLiveBottomSheetOutsideListener.a(shouldWindowCloseOnTouchOutside());
    L10:
        return super.onTouchEvent(r100);
    }

    public void setBottomSheetPullUpProcessor(l r100) {
        g r101 = new g(this, r100);
        this.mBottomSheetPullUpProcessor = r101;
        LiveBottomSheetBehavior<FrameLayout> r102 = this.behavior;
        if (r102 == null) goto L6;
        r102.A = r101;
        return;
    }

    public void setBottomSheetSlideProcessor(m r100) {
        f r101 = new f(this, r100);
        this.mBottomSheetSlideProcessor = r101;
        LiveBottomSheetBehavior<FrameLayout> r102 = this.behavior;
        if (r102 == null) goto L6;
        r102.f160937z = r101;
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.cancelable == r100) goto L8;
        this.cancelable = r100;
        LiveBottomSheetBehavior<FrameLayout> r101 = this.behavior;
        if (r101 == null) goto L9;
        r101.f160921j = r100;
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.mCanceledOnTouchOutside = r100;
        this.mCanceledOnTouchOutsideSet = true;
        accessibilityCompat(r100);
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));     // Catch: Exception -> L5
    L19:
        accessibilityCompat(true);
        return;
    L5:
        e = move-exception;
        HashMap r101 = new HashMap();
        qm0.b r102 = om0.c.g();
        if (r102 != null) goto L24;
    L17:
        SafetyGuard.a("LiveBottomSheetDialog", e, "setContentView crash");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L19;
        throw e;
    L24:
        r101.put("dialog", getClass().getName());     // Catch: Exception -> L10 ClassNotFoundException -> L11 Resources.NotFoundException -> L12 ReflectException -> L14
        r101.put("theme", getContext().getResources().getResourceEntryName(((Integer) Reflect.on(getDelegate()).field("mThemeResId", new Class[0]).get()).intValue()));     // Catch: Exception -> L10 ClassNotFoundException -> L11 Resources.NotFoundException -> L12 ReflectException -> L14
        r102.sendLog("livesdk_dialog_theme_exception", r101, new Object[]{am2.x.class, INVOKESTATIC_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdkapi.depend.model.live.Room")});     // Catch: Exception -> L10 ClassNotFoundException -> L11 Resources.NotFoundException -> L12 ReflectException -> L14
    L16:
        ALogger.e("LiveBottomSheetDialog", "theme error" + r101.toString());
        goto L17
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L11:
        e.printStackTrace();
    L10:
        e.printStackTrace();
        goto L16
    }

    public void setLiveBottomSheetDismissProcessor(j r100) {
        this.mBottomSheetDismissProcessor = r100;
    }

    public void setLiveBottomSheetOutsideListener(k r100) {
        this.mLiveBottomSheetOutsideListener = r100;
    }

    public void setNeedHookBottomSheetInterceptEvent(boolean r100) {
        this.isNeedHookBottomSheetInterceptEvent = r100;
    }

    public void setPeekHeight(int r100) {
        LiveBottomSheetBehavior<FrameLayout> r101 = this.behavior;
        if (r101 == null) goto L6;
        r101.setPeekHeight(r100);
        return;
    }

    public void setStateCallback(LiveBottomSheetBehavior.c r100) {
        this.mStateCallback = r100;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
        accessibilityCompat(true);
    }

    public LiveBottomSheetDialog(Context r100, int r101) {
        super(r100, r101);
        this.cancelable = true;
        this.isNeedHookBottomSheetInterceptEvent = false;
        this.popupEnable = true;
        this.mCanceledOnTouchOutside = true;
        this.dismissHandlerEnable = false;
        this.mBottomSheetSlideProcessor = new m0(this);
        this.mBottomSheetPullUpProcessor = new n0(this);
        this.mBottomSheetDismissProcessor = new o0(this);
        this.currentBottomSheetBehaviorState = 4;
        this.mExitAnimator = null;
        this.mTargetExitAnimationView = null;
        this.mEnablePullUp = false;
        this.webViewCollapsedHeight = (int) UIUtils.dip2Px(getContext(), 484.0f);
        this.bottomSheetView = null;
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mBottomSheetCallback = new e(this);
        supportRequestWindowFeature(1);
    }

    private boolean isOutOfBounds(Context r100, MotionEvent r101) {
        int r102 = (int) r101.getX();
        int r103 = (int) r101.getY();
        int r104 = ViewConfiguration.get(r100).getScaledWindowTouchSlop();
        if (getWindow() != null) goto L5;
        return true;
    L5:
        View r105 = INVOKEVIRTUAL_com_bytedance_android_livesdk_widget_LiveBottomSheetDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow());
        int r106 = -r104;
        if (r102 < r106) goto L15;
        if (r103 >= r106) goto L9;
        return true;
    L9:
        if (r102 <= (r105.getWidth() + r104)) goto L11;
        return true;
    L11:
        if (r103 > (r105.getHeight() + r104)) goto L18;
        return false;
    L18:
        return true;
    L15:
        return true;
    }

    private void removeFitsSystemWindowIfNeed(FrameLayout r100, CoordinatorLayout r101) {
        if (r100 == null) goto L8;
        if (r101 != null) goto L5;
        return;
    L5:
        if (shouldRemoveFitsSysWin() == false) goto L10;
        r100.setFitsSystemWindows(false);
        r101.setFitsSystemWindows(false);
        return;
    L10:
        return;
    }

    public void injectExitAnimator(Animator r100, View r101) {
        this.mExitAnimator = r100;
        this.mTargetExitAnimationView = r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
        accessibilityCompat(true);
    }

    public LiveBottomSheetDialog(Context r100, boolean r101, DialogInterface.OnCancelListener r102) {
        super(r100, r101, r102);
        this.cancelable = true;
        this.isNeedHookBottomSheetInterceptEvent = false;
        this.popupEnable = true;
        this.mCanceledOnTouchOutside = true;
        this.dismissHandlerEnable = false;
        this.mBottomSheetSlideProcessor = new m0(this);
        this.mBottomSheetPullUpProcessor = new n0(this);
        this.mBottomSheetDismissProcessor = new o0(this);
        this.currentBottomSheetBehaviorState = 4;
        this.mExitAnimator = null;
        this.mTargetExitAnimationView = null;
        this.mEnablePullUp = false;
        this.webViewCollapsedHeight = (int) UIUtils.dip2Px(getContext(), 484.0f);
        this.bottomSheetView = null;
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mBottomSheetCallback = new e(this);
        supportRequestWindowFeature(1);
        this.cancelable = r101;
    }

    private View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        FrameLayout r103 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.ttlive_design_bottom_sheet_dialog, null);
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(com.larus.nova.R.id.ttlive_coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r104, false);
    L6:
        FrameLayout r105 = (FrameLayout) r104.findViewById(com.larus.nova.R.id.ttlive_design_bottom_sheet);
        this.bottomSheetView = r105;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof CoordinatorLayout.LayoutParams) == false) goto L37;
        CoordinatorLayout.Behavior r107 = ((CoordinatorLayout.LayoutParams) r106).getBehavior();
        if ((r107 instanceof LiveBottomSheetBehavior) == false) goto L35;
        LiveBottomSheetBehavior<FrameLayout> r108 = (LiveBottomSheetBehavior) r107;
        this.behavior = r108;
        r108.f160931t = this.mBottomSheetCallback;
        if (this.isNeedHookBottomSheetInterceptEvent == false) goto L13;
        r108.B = true;
    L13:
        r108.f160921j = this.cancelable;
        if (this.mEnablePullUp == false) goto L16;
        r108.setPeekHeight(this.webViewCollapsedHeight);
        this.behavior.f160922k = false;
    L17:
        m r109 = this.mBottomSheetSlideProcessor;
        if (r109 == null) goto L20;
        this.behavior.f160937z = r109;
    L20:
        l r110 = this.mBottomSheetPullUpProcessor;
        if (r110 == null) goto L23;
        this.behavior.A = r110;
    L23:
        if (r102 == null) goto L25;
        this.bottomSheetView.addView(r101, r102);
    L32:
        View r111 = r104.findViewById(com.larus.nova.R.id.ttlive_touch_outside);
        this.outsideView = r111;
        r111.setOnClickListener(new b(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheetView, new c(this));
        this.bottomSheetView.setOnTouchListener(new d());
        removeFitsSystemWindowIfNeed(r103, r104);
        return r103;
    L25:
        if (r101.getLayoutParams() == null) goto L28;
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(r101.getLayoutParams());
        r112.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        this.bottomSheetView.addView(r101, r112);
        goto L32
    L28:
        if (getWindow() == null) goto L30;
        WindowManager.LayoutParams r113 = getWindow().getAttributes();
        this.bottomSheetView.addView(r101, new FrameLayout.LayoutParams(r113.width, r113.height, r113.gravity));
        goto L32
    L30:
        this.bottomSheetView.addView(r101);
        goto L32
    L16:
        r108.f160922k = true;
        goto L17
    L35:
        throw new IllegalArgumentException("The view is not associated with LiveBottomSheetBehavior");
    L37:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void setEnablePullUp(boolean r100, int r101, int r102) {
        this.mEnablePullUp = r100;
        if (r102 <= 0) goto L6;
        this.webViewCollapsedHeight = (int) UIUtils.dip2Px(getContext(), r101 - r102);
        return;
    }
}
