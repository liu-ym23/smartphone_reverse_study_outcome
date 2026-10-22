package com.bytedance.android.live.broadcastgame.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.g0;
import com.bytedance.android.live.broadcastgame.network.BroadcastGameApi;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import j20.e;
import j20.f;
import j20.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/view/InteractGameFeedbackDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameFeedbackDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f61778i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j20.a f61779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f61780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f61781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f61782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f61783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f61784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f61785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f61786h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractGameFeedbackDialog f61787a;

        public b(InteractGameFeedbackDialog r100) {
            this.f61787a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Object r101 = r100.getTag();
            if (r101 == null) goto L10;
            r100.setSelected(!r100.isSelected());
            if (r100.isSelected() == false) goto L7;
            this.f61787a.f61780b.add(r101.toString());
        L8:
            InteractGameFeedbackDialog r102 = this.f61787a;
            int r103 = InteractGameFeedbackDialog.f61778i;
            r102.N0();
            return;
        L7:
            this.f61787a.f61780b.remove(r101.toString());
            goto L8
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractGameFeedbackDialog f61788a;

        public c(InteractGameFeedbackDialog r100) {
            this.f61788a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f61788a.f61780b.isEmpty() == false) goto L6;
            f2.c("请选择要反馈的玩法存在的问题", 0);
            return;
        L6:
            InteractGameFeedbackDialog r101 = this.f61788a;
            Set<String> r102 = r101.f61780b;
            String r103 = ((EditText) r101.findViewById(R.id.problem_detail)).getText().toString();
            if (r101.f61782d != null) goto L16;
            StringBuilder r104 = new StringBuilder();
            Iterator<T> r105 = r102.iterator();
        L11:
            if (r105.hasNext() == false) goto L13;
            r104.append((String) r105.next());
            r104.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            goto L11
        L13:
            r104.append(r103);
            RequestBody r106 = RequestBody.create(MediaType.parse("text/plain"), r104.toString());
            int r107 = g0.f59628a;
            Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
            r101.f61782d = ((BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class)).postGameFeedback(r106).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r101), new g(r101));
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractGameFeedbackDialog f61789a;

        public d(InteractGameFeedbackDialog r100) {
            this.f61789a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Rect r100 = new Rect();
            Window r101 = this.f61789a.getWindow();
            if (r101 == null) goto L7;
            View r102 = a(r101);
            if (r102 == null) goto L7;
            r102.getWindowVisibleDisplayFrame(r100);
        L7:
            Window r103 = this.f61789a.getWindow();
            if (r103 == null) goto L29;
            View r104 = a(r103);
            if (r104 == null) goto L30;
            View r105 = r104.getRootView();
            if (r105 == null) goto L31;
            int r106 = r105.getHeight() - r100.bottom;
            float r107 = (((Button) this.f61789a.findViewById(R.id.submit_btn)).getBottom() - ((EditText) this.f61789a.findViewById(R.id.problem_detail)).getBottom()) + s1.f(5.0f);
            if (r106 <= 0) goto L23;
            if ((((ConstraintLayout) this.f61789a.findViewById(R.id.feedback_root_layout)).getParent() instanceof View) == false) goto L32;
            Object r108 = ((ConstraintLayout) this.f61789a.findViewById(R.id.feedback_root_layout)).getParent();
            if (r108 == null) goto L21;
            ((View) r108).setTranslationY(r107);
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L32:
            return;
        L23:
            if ((((ConstraintLayout) this.f61789a.findViewById(R.id.feedback_root_layout)).getParent() instanceof View) == false) goto L34;
            Object r109 = ((ConstraintLayout) this.f61789a.findViewById(R.id.feedback_root_layout)).getParent();
            if (r109 == null) goto L28;
            ((View) r109).setTranslationY(0.0f);
            return;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L34:
            return;
        L31:
            return;
        L30:
            return;
        }

        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (this.f61786h == true) goto L11;
        Context r100 = getContext();
        if ((r100 instanceof ContextThemeWrapper) == true) goto L7;
        r100 = null;
    L7:
        ContextThemeWrapper r101 = (ContextThemeWrapper) r100;
        if (r101 == null) goto L11;
        r101.setTheme(R.style.ttlive_common_bottom_dialog_normal);
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public final void N0() {
        ((Button) findViewById(R.id.submit_btn)).setEnabled(!this.f61780b.isEmpty());
        if ((!this.f61780b.isEmpty()) == false) goto L5;
        String r100 = "#ffffff";
    L6:
        ((Button) findViewById(R.id.submit_btn)).setTextColor(ColorProtector.parseColor(r100));
        return;
    L5:
        r100 = "#57ffffff";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        Window r100 = getWindow();
        if (r100 == null) goto L7;
        r100.setSoftInputMode(18);
        return R.layout.ttlive_dialog_interact_game_feedback;
    L7:
        return R.layout.ttlive_dialog_interact_game_feedback;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ArrayList r100 = new ArrayList();
        r100.add("不理解规则");
        r100.add("画面卡顿延迟");
        r100.add("玩法无趣");
        r100.add("违法违禁");
        r100.add("政治敏感");
        r100.add("淫秽色情");
        r100.add("广告欺骗");
        Disposable r101 = this.f61781c;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        int r102 = g0.f59628a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        this.f61781c = ((BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class)).getGameFeedbackTagList(this.f61784f, this.f61783e, this.f61785g).compose(RxUtil.rxSchedulerHelper()).subscribe(new j20.d(this), new e(this, r100));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f61781c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f61782d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public static final void M0(InteractGameFeedbackDialog r100) {
        Disposable r101 = r100.f61782d;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        r100.f61782d = null;
        Handler r102 = DialogLancet.resolveDialogHandler(r100);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f61779a = new j20.a(new b(this));
        RecyclerView r101 = (RecyclerView) findViewById(R.id.problem_tag_list);
        j20.a r102 = this.f61779a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r101.setAdapter(r102);
        ((RecyclerView) findViewById(R.id.problem_tag_list)).setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        ((RecyclerView) findViewById(R.id.problem_tag_list)).addItemDecoration(new AnonymousClass2());
        if (this.f61786h == false) goto L22;
        Window r103 = getWindow();
        if (r103 == null) goto L12;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        if (r104 == null) goto L12;
        r104.width = s1.f(390.0f);
    L12:
        Window r105 = getWindow();
        if (r105 == null) goto L15;
        r105.setGravity(5);
    L15:
        Drawable r106 = ((ConstraintLayout) findViewById(R.id.feedback_root_layout)).getBackground();
        if ((r106 instanceof GradientDrawable) == true) goto L18;
        r106 = null;
    L18:
        GradientDrawable r107 = (GradientDrawable) r106;
        a1.k(findViewById(R.id.feedback_root_layout), s1.q(getContext()).heightPixels);
        float r108 = s1.e(12.0f);
        if (r107 == null) goto L21;
        r107.setCornerRadii(new float[]{r108, r108, 0.0f, 0.0f, 0.0f, 0.0f, r108, r108});
    L21:
        t8.d(getWindow());
    L22:
        N0();
        ((Button) findViewById(R.id.submit_btn)).setOnClickListener(new c(this));
        if (this.f61786h == true) goto L36;
        Window r109 = getWindow();
        if (r109 == null) goto L37;
        View r110 = r109.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L31;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r111 = ThreadMethodProxy.currentThread();
        if (r111 == com.larus.home.impl.utils.c.f346341a) goto L31;
        com.larus.home.impl.utils.c.a(r111, "getDecorView");
    L31:
        if (r110 == null) goto L38;
        ViewTreeObserver r112 = r110.getViewTreeObserver();
        if (r112 == null) goto L39;
        r112.addOnGlobalLayoutListener(new d(this));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (this.f61786h == false) goto L7;
        if (r100 == false) goto L8;
        t8.d(getWindow());
        return;
    L8:
        return;
    }

    public InteractGameFeedbackDialog(Context r100, long r101, long r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r104, false);
        this.f61783e = r101;
        this.f61784f = r102;
        this.f61785g = r103;
        this.f61786h = r104;
        this.f61780b = new LinkedHashSet();
    }
}
