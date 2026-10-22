package com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse;

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
import com.bytedance.android.ec.core.MainCommentLinearLayoutManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.crash.d;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sh.a;
import sh.b;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/CommentPagePhotoViewerDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommentPagePhotoViewerDialog extends Dialog implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f45286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f45287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnPageSelectedListener f45288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnDismissListener f45289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f45290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f45291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f45292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f45293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f45294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<IIndicatorView> f45295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f45296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f45297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TransitionPagerAdapter<?> f45298m;

    public void c(int r100) {
    }

    public void onPageSelected(int r100) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f45298m.onDestroy();
        OnDismissListener r100 = this.f45289d;
        if (r100 == null) goto L5;
        r100.onDismiss(this.f45292g);
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (isShowing() == false) goto L21;
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r101 == null) goto L18;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r100.getLooper()) goto L9;
        r100.post(DialogLancet.createDismissRunnable(this));
        return;
    L21:
        this.f45298m.onDestroy();
    }

    private final void d(int r100) {
        int r101 = this.f45292g;
        if (r101 == r100) goto L20;
        if (r100 <= r101) goto L6;
        Direction r102 = Direction.RIGHT;
    L7:
        this.f45291f = r101;
        c(r101);
        this.f45292g = r100;
        Iterator<IIndicatorView> r103 = this.f45295j.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().onPageSelected(this.f45292g);
        goto L9
    L11:
        onPageSelected(this.f45292g);
        OnPageSelectedListener r104 = this.f45288c;
        if (r104 == null) goto L15;
        r104.onPageSelected(this.f45292g);
    L15:
        if (this.f45291f == (-1)) goto L23;
        Iterator<T> r105 = this.f45290e.iterator();
    L18:
        if (r105.hasNext() == false) goto L24;
        ((b) r105.next()).a(r102);
        goto L18
    L24:
        return;
    L23:
        return;
    L6:
        r102 = Direction.LEFT;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(IIndicatorView r100) {
        Intrinsics.checkNotNullParameter(r100, "indicatorView");
        this.f45295j.add(r100);
        this.f45287b.addView((View) r100);
        r100.onAttach(this.f45292g, this.f45298m);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.requestFeature(1);
    L5:
        setContentView(this.f45287b);
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
        View r105 = r102.getDecorView();
        if (c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == c.f346341a) goto L13;
        c.a(r106, "getDecorView");
    L13:
        r105.setSystemUiVisibility(ISmModel.VERSION_0300);
        if (r104 <= 28) goto L16;
        r103.layoutInDisplayCutoutMode = 1;
    L16:
        this.f45287b.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.f45294i == false) goto L20;
        this.f45287b.getBackground().setAlpha(0);
        this.f45296k = 0.0f;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [T, com.bytedance.android.ec.core.MainCommentLinearLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, androidx.recyclerview.widget.LinearLayoutManager] */
    public CommentPagePhotoViewerDialog(Context r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transitionAdapter");
        super(r100);
        this.f45298m = r101;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r103 = Unit.INSTANCE;
        this.f45287b = r102;
        this.f45290e = new ArrayList();
        this.f45291f = -1;
        this.f45292g = -1;
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
        this.f45293h = r104;
        this.f45295j = new ArrayList();
        this.f45296k = 1.0f;
        this.f45297l = 1.0f;
        RecyclerView r115 = new RecyclerView(r100);
        r115.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f45286a = r115;
        final Ref.ObjectRef r116 = new Ref.ObjectRef();
        r116.element = new LinearLayoutManager(r100);
        Lazy r117 = ECAppInfoService.f48110a;
        if (ECAppInfoService.j() == false) goto L21;
        r116.element = new MainCommentLinearLayoutManager(r100, r115);
    L21:
        LinearLayoutManager r118 = (LinearLayoutManager) r116.element;
        r118.setOrientation(0);
        r115.setLayoutManager(r118);
        new PagerSnapHelper().attachToRecyclerView(r115);
        r102.addView(r115, 0);
        r115.addOnScrollListener(new AnonymousClass3(this, r116));
        r115.setAdapter(r101);
        r101.setInternalTransitionListener(new a(this));
        r101.registerAdapterDataObserver(new CommentPagePhotoViewerDialog$initAdapter$2(this));
        if ((r100 instanceof FragmentActivity) == true) goto L24;
        r100 = null;
    L24:
        FragmentActivity r119 = (FragmentActivity) r100;
        if (r119 == null) goto L30;
        Lifecycle r120 = r119.getLifecycle();
        if (r120 == null) goto L31;
        r120.addObserver(this);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r112 = 0;
    L9:
        r108 = 0;
        goto L10
    }

    public static final /* synthetic */ void a(CommentPagePhotoViewerDialog r100, int r101) {
        r100.d(r101);
    }

    public final void e(int r100, View r101) {
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
        Rect r108 = TransitionUtils.calculateStartRect(r101, new int[]{r106, r107});
    L36:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    L17:
        if (isShowing() == false) goto L19;
        return;
    L19:
        if (r100 < this.f45298m.getItemCount()) goto L26;
        d(0);     // Catch: Exception -> L36
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L36
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L25:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L36
        show();     // Catch: Exception -> L36
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L36
        return;
    L26:
        d(r100);     // Catch: Exception -> L36
        this.f45286a.scrollToPosition(r100);     // Catch: Exception -> L36
        TransitionPagerAdapter<?> r109 = this.f45298m;     // Catch: Exception -> L36
        if (r108 != null) goto L29;
        r108 = this.f45293h;     // Catch: Exception -> L36
    L29:
        r109.setEnterAnimationParams(r100, r108);     // Catch: Exception -> L36
        this.f45294i = true;     // Catch: Exception -> L36
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L36
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L34:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L36
        show();     // Catch: Exception -> L36
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L36
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
}
