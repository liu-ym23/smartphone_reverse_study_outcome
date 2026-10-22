package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001bJ\b\u00109\u001a\u000207H\u0016J\u0006\u0010:\u001a\u000207J\b\u0010;\u001a\u000207H\u0002J\u0012\u0010<\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u000207H\u0007J\u0010\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\fH\u0016J\u000e\u0010B\u001a\u0002072\u0006\u00108\u001a\u00020\u001bJ\u000e\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\fJ\u001a\u0010E\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0014J\u0016\u0010E\u001a\u0002072\u0006\u0010D\u001a\u00020\f2\u0006\u0010G\u001a\u00020HR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006I"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "transitionAdapter", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "(Landroid/content/Context;Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;)V", "backgroundAlphaFactor", "", "backgroundAlphaFactorWhenDragEnd", "value", "", "currentPosInternal", "setCurrentPosInternal", "(I)V", "currentPosition", "getCurrentPosition", "()I", "defaultStartRect", "Landroid/graphics/Rect;", "getDefaultStartRect", "()Landroid/graphics/Rect;", "setDefaultStartRect", "(Landroid/graphics/Rect;)V", "indicatorViews", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "Lkotlin/collections/ArrayList;", "isAnimatedShow", "", "onDismissListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;", "getOnDismissListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;", "setOnDismissListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnDismissListener;)V", "onPageSelectedListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/OnPageSelectedListener;)V", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView;", "pager", "getPager", "()Landroidx/recyclerview/widget/RecyclerView;", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "getTransitionAdapter", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "addIndicatorView", "", "indicatorView", "dismiss", "dispatchOnPageSelected", "initAdapter", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "onPageSelected", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "removeIndicatorView", "show", "position", "showAnimated", "startRect", "view", "Landroid/view/View;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoViewerDialog extends Dialog implements LifecycleObserver {
    private float backgroundAlphaFactor;
    private float backgroundAlphaFactorWhenDragEnd;
    private int currentPosInternal;
    private Rect defaultStartRect;
    private ArrayList<IIndicatorView> indicatorViews;
    private boolean isAnimatedShow;
    private OnDismissListener onDismissListener;
    private OnPageSelectedListener onPageSelectedListener;
    private RecyclerView pager;
    private final FrameLayout rootContainer;
    private final TransitionPagerAdapter<?> transitionAdapter;

    public static /* synthetic */ void access$000(Dialog r100) {
        super.dismiss();
    }

    public void onPageSelected(int r100) {
    }

    private final void initAdapter() {
        this.pager.setAdapter(this.transitionAdapter);
        this.transitionAdapter.setInternalTransitionListener(new AnonymousClass1(this));
        this.transitionAdapter.registerAdapterDataObserver(new AnonymousClass2(this));
    }

    public final void dispatchOnPageSelected() {
        Iterator<T> r100 = this.indicatorViews.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IIndicatorView) r100.next()).onPageSelected(this.currentPosInternal);
        goto L4
    L6:
        onPageSelected(this.currentPosInternal);
        OnPageSelectedListener r101 = this.onPageSelectedListener;
        if (r101 == null) goto L11;
        r101.onPageSelected(this.currentPosInternal);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing() == false) goto L9;
        this.transitionAdapter.onDestroy();
        OnDismissListener r100 = this.onDismissListener;
        if (r100 == null) goto L7;
        r100.onDismiss(this.currentPosInternal);
    L7:
        INVOKESPECIAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (isShowing() == false) goto L5;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    L5:
        this.transitionAdapter.onDestroy();
    }

    public final int getCurrentPosition() {
        return this.currentPosInternal;
    }

    public final Rect getDefaultStartRect() {
        return this.defaultStartRect;
    }

    public final OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    public final OnPageSelectedListener getOnPageSelectedListener() {
        return this.onPageSelectedListener;
    }

    public final RecyclerView getPager() {
        return this.pager;
    }

    public final FrameLayout getRootContainer() {
        return this.rootContainer;
    }

    public final TransitionPagerAdapter<?> getTransitionAdapter() {
        return this.transitionAdapter;
    }

    public static void INVOKESPECIAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$000(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(PhotoViewerDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(PhotoViewerDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ float access$getBackgroundAlphaFactor$p(PhotoViewerDialog r100) {
        return r100.backgroundAlphaFactor;
    }

    public static final /* synthetic */ float access$getBackgroundAlphaFactorWhenDragEnd$p(PhotoViewerDialog r100) {
        return r100.backgroundAlphaFactorWhenDragEnd;
    }

    public static final /* synthetic */ int access$getCurrentPosInternal$p(PhotoViewerDialog r100) {
        return r100.currentPosInternal;
    }

    public static final /* synthetic */ ArrayList access$getIndicatorViews$p(PhotoViewerDialog r100) {
        return r100.indicatorViews;
    }

    public static final /* synthetic */ RecyclerView access$getPager$p(PhotoViewerDialog r100) {
        return r100.pager;
    }

    private final void setCurrentPosInternal(int r100) {
        if (this.currentPosInternal == r100) goto L6;
        this.currentPosInternal = r100;
        dispatchOnPageSelected();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addIndicatorView(IIndicatorView r100) {
        Intrinsics.checkNotNullParameter(r100, "indicatorView");
        this.indicatorViews.add(r100);
        this.rootContainer.addView((View) r100);
        r100.onAttach(this.currentPosInternal, this.transitionAdapter);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.requestFeature(1);
    L5:
        setContentView(this.rootContainer);
        Window r102 = getWindow();
        if (r102 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.clearFlags(2);
        int r104 = Build.VERSION.SDK_INT;
        r102.addFlags(Integer.MIN_VALUE);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102).setSystemUiVisibility(1280);
        if (r104 <= 28) goto L11;
        r103.layoutInDisplayCutoutMode = 1;
    L11:
        this.rootContainer.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.isAnimatedShow == false) goto L14;
        this.rootContainer.getBackground().setAlpha(0);
        this.backgroundAlphaFactor = 0.0f;
    L14:
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102).setPadding(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeIndicatorView(IIndicatorView r100) {
        Intrinsics.checkNotNullParameter(r100, "indicatorView");
        this.indicatorViews.remove(r100);
        this.rootContainer.removeView((View) r100);
        r100.onDetach(this.currentPosInternal, this.transitionAdapter);
    }

    public final void setDefaultStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultStartRect = r100;
    }

    public final void setOnDismissListener(OnDismissListener r100) {
        this.onDismissListener = r100;
    }

    public final void setOnPageSelectedListener(OnPageSelectedListener r100) {
        this.onPageSelectedListener = r100;
    }

    public final void show(int r100) {
        if (isShowing() == true) goto L6;
        this.pager.scrollToPosition(Math.min(r100, this.transitionAdapter.getItemCount()));
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    }

    public PhotoViewerDialog(Context r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transitionAdapter");
        super(r100);
        this.transitionAdapter = r101;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r103 = Unit.INSTANCE;
        this.rootContainer = r102;
        this.currentPosInternal = -1;
        Rect r104 = new Rect();
        Window r105 = getWindow();
        if (r105 == null) goto L9;
        WindowManager r106 = r105.getWindowManager();
        if (r106 == null) goto L9;
        Display r107 = r106.getDefaultDisplay();
        if (r107 == null) goto L9;
        int r108 = r107.getWidth();
    L10:
        Window r109 = getWindow();
        if (r109 == null) goto L17;
        WindowManager r110 = r109.getWindowManager();
        if (r110 == null) goto L17;
        Display r111 = r110.getDefaultDisplay();
        if (r111 == null) goto L17;
        int r112 = r111.getHeight();
    L18:
        int r113 = r108 / 2;
        r104.left = r113;
        int r114 = r112 / 2;
        r104.top = r114;
        r104.right = r113;
        r104.bottom = r114;
        this.defaultStartRect = r104;
        this.indicatorViews = new ArrayList();
        this.backgroundAlphaFactor = 1.0f;
        this.backgroundAlphaFactorWhenDragEnd = 1.0f;
        RecyclerView r115 = new RecyclerView(r100);
        r115.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.pager = r115;
        final LinearLayoutManager r116 = new LinearLayoutManager(r100);
        RecyclerView r117 = this.pager;
        r116.setOrientation(0);
        r117.setLayoutManager(r116);
        new PagerSnapHelper().attachToRecyclerView(this.pager);
        r102.addView(this.pager, 0);
        this.pager.addOnScrollListener(new AnonymousClass3(this, r116));
        initAdapter();
        if ((r100 instanceof FragmentActivity) == true) goto L21;
        r100 = null;
    L21:
        FragmentActivity r118 = (FragmentActivity) r100;
        if (r118 == null) goto L27;
        Lifecycle r119 = r118.getLifecycle();
        if (r119 == null) goto L28;
        r119.addObserver(this);
        return;
    L28:
        return;
    L27:
        return;
    L17:
        r112 = 0;
    L9:
        r108 = 0;
        goto L10
    }

    public static final /* synthetic */ void access$setBackgroundAlphaFactor$p(PhotoViewerDialog r100, float r101) {
        r100.backgroundAlphaFactor = r101;
    }

    public static final /* synthetic */ void access$setBackgroundAlphaFactorWhenDragEnd$p(PhotoViewerDialog r100, float r101) {
        r100.backgroundAlphaFactorWhenDragEnd = r101;
    }

    public static final /* synthetic */ void access$setCurrentPosInternal$p(PhotoViewerDialog r100, int r101) {
        r100.setCurrentPosInternal(r101);
    }

    public static final /* synthetic */ void access$setIndicatorViews$p(PhotoViewerDialog r100, ArrayList r101) {
        r100.indicatorViews = r101;
    }

    public static final /* synthetic */ void access$setPager$p(PhotoViewerDialog r100, RecyclerView r101) {
        r100.pager = r101;
    }

    public final void showAnimated(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if ((r101 instanceof GenericDraweeView) == true) goto L5;
        View r102 = null;
    L6:
        GenericDraweeView r103 = (GenericDraweeView) r102;
        if (r103 == null) goto L11;
        GenericDraweeHierarchy r104 = r103.getHierarchy();
        if (r104 == null) goto L11;
        RectF r105 = new RectF();
        r104.getActualImageBounds(r105);
        int r106 = (int) r105.width();
        int r107 = (int) r105.height();
    L12:
        if (r107 == 0) goto L14;
        if (r106 == 0) goto L14;
    L15:
        showAnimated(r100, TransitionUtils.calculateStartRect(r101, new int[]{r106, r107}));
        return;
    L14:
        r106 = r101.getWidth();
        r107 = r101.getHeight();
    L11:
        r106 = 0;
        r107 = 0;
        goto L12
    L5:
        r102 = r101;
        goto L6
    }

    public final void showAnimated(int r100, Rect r101) {
        if (isShowing() == false) goto L5;
        return;
    L5:
        if (r100 < this.transitionAdapter.getItemCount()) goto L7;
        setCurrentPosInternal(0);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    L7:
        setCurrentPosInternal(r100);
        this.pager.scrollToPosition(r100);
        TransitionPagerAdapter<?> r102 = this.transitionAdapter;
        if (r101 != null) goto L10;
        r101 = this.defaultStartRect;
    L10:
        r102.setEnterAnimationParams(r100, r101);
        this.isAnimatedShow = true;
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_PhotoViewerDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
    }

    public static /* synthetic */ void showAnimated$default(PhotoViewerDialog r100, int r101, Rect r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.showAnimated(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAnimated");
    }
}
