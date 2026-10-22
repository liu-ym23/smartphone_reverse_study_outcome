package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.data.n;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/CompositeImagePreviewDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CompositeImagePreviewDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int L0 = 0;
    public Function1<? super String, Unit> B;
    public Function0<Unit> C;
    public Function0<Unit> D;
    public k E;
    public String F;
    public DataCenter G;
    public View H;
    public boolean H0;
    public HSImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public TextView f139887J;
    public TextView K;
    public HSImageView L;
    public View M;
    public View N;
    public View O;
    public TextView P;
    public TextView Q;
    public View R;
    public View S;
    public RadiusLayout T;
    public View U;
    public TextView V;
    public Animator W;
    public Animator X;
    public boolean Y;
    public final CompositeDisposable Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f139888k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f139889p0;

    public static final class a {
        public static CompositeImagePreviewDialog a(Context r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101, DataCenter r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "msg");
            CompositeImagePreviewDialog r103 = new CompositeImagePreviewDialog(r100);
            com.bytedance.android.livesdk.chatroom.likeegg.a.b r104 = r101.jumpDetail;
            String r105 = null;
            if (r104 == null) goto L7;
            n r106 = r104.templatePhotoJumpDetail;
            if (r106 == null) goto L7;
            k r107 = r106.bgPhoto;
        L8:
            r103.E = r107;
            if (r104 == null) goto L13;
            n r108 = r104.templatePhotoJumpDetail;
            if (r108 == null) goto L13;
            r105 = r108.photoPanelTitle;
        L13:
            r103.F = r105;
            r103.G = r102;
            if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r103);
        L18:
            return r103;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L17:
            DialogLancet.beforeDialogShow(r103);
            r103.show();
            DialogLancet.afterDialogShow(r103);
        L7:
            r107 = null;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompositeImagePreviewDialog f139890a;

        public b(CompositeImagePreviewDialog r100) {
            this.f139890a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            CompositeImagePreviewDialog r102 = this.f139890a;
            int r103 = CompositeImagePreviewDialog.L0;
            r102.W0();
            CompositeImagePreviewDialog r104 = this.f139890a;
            Animator r105 = r104.W;
            if (r105 == null) goto L5;
            r105.cancel();
        L5:
            r104.W = null;
            r104.Y = false;
            View r106 = r104.M;
            if (r106 == null) goto L8;
            UtilityKotlinExtentionsKt.A(r106, false);
        L8:
            View r107 = r104.O;
            if (r107 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r107, true);
        L11:
            View r108 = r104.N;
            if (r108 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r108, false);
        L14:
            TextView r109 = r104.f139887J;
            if (r109 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r109, true);
        L17:
            TextView r110 = r104.K;
            if (r110 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r110, true);
        L20:
            HSImageView r111 = r104.I;
            if (r111 == null) goto L23;
            r111.setTranslationX(0.0f);
            r111.setTranslationY(0.0f);
            r111.setScaleX(1.0f);
            r111.setScaleY(1.0f);
        L23:
            View r112 = r104.M;
            if (r112 == null) goto L26;
            r112.setAlpha(0.0f);
        L26:
            TextView r113 = r104.f139887J;
            if (r113 == null) goto L29;
            r113.setAlpha(1.0f);
        L29:
            TextView r114 = r104.K;
            if (r114 == null) goto L33;
            r114.setAlpha(1.0f);
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompositeImagePreviewDialog f139891a;

        public c(CompositeImagePreviewDialog r100) {
            this.f139891a = r100;
        }

        public final void a() {
            TextView r100 = this.f139891a.P;
            if (r100 == null) goto L5;
            UtilityKotlinExtentionsKt.A(r100, false);
        L5:
            HSImageView r101 = this.f139891a.I;
            if (r101 == null) goto L8;
            UtilityKotlinExtentionsKt.A(r101, false);
        L8:
            TextView r102 = this.f139891a.f139887J;
            if (r102 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r102, false);
        L11:
            TextView r103 = this.f139891a.K;
            if (r103 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r103, false);
        L14:
            View r104 = this.f139891a.U;
            if (r104 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r104, false);
        L17:
            TextView r105 = this.f139891a.V;
            if (r105 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r105, false);
        L20:
            View r106 = this.f139891a.R;
            if (r106 == null) goto L24;
            UtilityKotlinExtentionsKt.A(r106, true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompositeImagePreviewDialog f139892a;

        public d(CompositeImagePreviewDialog r100) {
            this.f139892a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f139892a.U;
            if (r101 == null) goto L6;
            r101.setAlpha(1.0f);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r101 = this.f139892a.U;
            if (r101 == null) goto L6;
            r101.setAlpha(1.0f);
            return;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompositeImagePreviewDialog f139893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139894b;

        public e(CompositeImagePreviewDialog r100, String r101) {
            this.f139893a = r100;
            this.f139894b = r101;
        }

        public final void a() {
            CompositeImagePreviewDialog r100 = this.f139893a;
            String r101 = this.f139894b;
            r100.f139888k0 = r101;
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            ImageLoader.loadSdcardImage(r100.I, r100.f139888k0);
        L8:
            CompositeImagePreviewDialog r103 = this.f139893a;
            r103.getClass();
            ALogger.d("CompositeImagePreviewDialog", "onLoadSuccess");
            TextView r104 = r103.P;
            if (r104 == null) goto L11;
            UtilityKotlinExtentionsKt.A(r104, true);
        L11:
            HSImageView r105 = r103.I;
            if (r105 == null) goto L14;
            UtilityKotlinExtentionsKt.A(r105, true);
        L14:
            TextView r106 = r103.f139887J;
            if (r106 == null) goto L17;
            UtilityKotlinExtentionsKt.A(r106, true);
        L17:
            TextView r107 = r103.K;
            if (r107 == null) goto L20;
            UtilityKotlinExtentionsKt.A(r107, true);
        L20:
            View r108 = r103.U;
            if (r108 == null) goto L23;
            UtilityKotlinExtentionsKt.A(r108, false);
        L23:
            TextView r109 = r103.V;
            if (r109 == null) goto L26;
            UtilityKotlinExtentionsKt.A(r109, false);
        L26:
            View r110 = r103.R;
            if (r110 == null) goto L30;
            UtilityKotlinExtentionsKt.A(r110, false);
            return;
        L30:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final boolean V0() {
        return true;
    }

    public final void W0() {
        RadiusLayout r100 = this.T;
        if (r100 == null) goto L7;
        int r101 = a1.h(r100);
        HSImageView r102 = this.L;
        if (r102 == null) goto L7;
        a1.o(r102, r101);
    L7:
        RadiusLayout r103 = this.T;
        if (r103 == null) goto L12;
        int r104 = a1.g(r103);
        HSImageView r105 = this.L;
        if (r105 == null) goto L12;
        a1.n(r105, r104);
    L12:
        RadiusLayout r106 = this.T;
        if (r106 == null) goto L17;
        int r107 = a1.e(r106);
        HSImageView r108 = this.L;
        if (r108 == null) goto L17;
        a1.l(r108, r107);
    L17:
        RadiusLayout r109 = this.T;
        if (r109 == null) goto L20;
        a1.m(r109, 0);
    L20:
        RadiusLayout r110 = this.T;
        if (r110 == null) goto L23;
        a1.o(r110, 0);
    L23:
        RadiusLayout r111 = this.T;
        if (r111 == null) goto L26;
        a1.n(r111, 0);
    L26:
        RadiusLayout r112 = this.T;
        if (r112 == null) goto L29;
        a1.l(r112, 0);
    L29:
        RadiusLayout r113 = this.T;
        if (r113 == null) goto L32;
        int r114 = a1.i(r113);
    L33:
        HSImageView r115 = this.L;
        if (r115 == null) goto L36;
        a1.p(r115, r114);
    L36:
        RadiusLayout r116 = this.T;
        if (r116 == null) goto L39;
        a1.p(r116, -1);
    L39:
        TokenCert r117 = LikeEggHelper.f140022a;
        int r118 = LikeEggHelper.a(this.G);
        int r119 = r118 - UtilityKotlinExtentionsKt.i(180);
        int r120 = (int) (((double) r119) * 0.66d);
        HSImageView r121 = this.L;
        if (r121 == null) goto L42;
        a1.k(r121, r118);
    L42:
        HSImageView r122 = this.I;
        if (r122 == null) goto L45;
        a1.k(r122, r119);
    L45:
        HSImageView r123 = this.I;
        if (r123 == null) goto L48;
        a1.p(r123, r120);
    L48:
        RadiusLayout r124 = this.T;
        if (r124 == null) goto L51;
        a1.k(r124, -1);
    L51:
        RadiusLayout r125 = this.T;
        if (r125 == null) goto L55;
        r125.setMaxHeight(0);
        return;
    L55:
        return;
    L32:
        r114 = -1;
        goto L33
    }

    public final void X0() {
        ALogger.d("CompositeImagePreviewDialog", "onLoadFailed");
        MainThreadPostUtils.e(new c(this));
    }

    public final void Y0() {
        ALogger.d("CompositeImagePreviewDialog", "onStateLoading");
        TextView r100 = this.P;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r100, true);
    L5:
        HSImageView r101 = this.I;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r101, false);
    L8:
        TextView r102 = this.f139887J;
        if (r102 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r102, false);
    L11:
        TextView r103 = this.K;
        if (r103 == null) goto L14;
        UtilityKotlinExtentionsKt.A(r103, false);
    L14:
        View r104 = this.U;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.A(r104, true);
    L17:
        TextView r105 = this.V;
        if (r105 == null) goto L20;
        UtilityKotlinExtentionsKt.A(r105, true);
    L20:
        View r106 = this.R;
        if (r106 == null) goto L24;
        UtilityKotlinExtentionsKt.A(r106, false);
        return;
    }

    public final void Z0() {
        if (this.U != null) goto L5;
        return;
    L5:
        Animator r100 = this.X;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        AnimatorSet r101 = new AnimatorSet();
        r101.play(ObjectAnimator.ofFloat(this.U, View.ALPHA, new float[]{0.0f, 1.0f}));
        r101.setDuration(400);
        r101.setInterpolator(new AccelerateInterpolator());
        r101.addListener(new d(this));
        r101.start();
        Unit r102 = Unit.INSTANCE;
        this.X = r101;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        int r100 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_defined_cancel", new LinkedHashMap());
        if (this.H0 == true) goto L5;
        this.H0 = true;
        StringBuilder r101 = new StringBuilder("likeEggDialogCount decrement: ");
        EasterEggAnimationDialog.f139896i.getClass();
        r101.append(EasterEggAnimationDialog.f139895h.decrementAndGet());
        ALogger.d("CompositeImagePreviewDialog", r101.toString());
    L5:
        this.Z.dispose();
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(this));
    }

    public final void dismissDialog() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
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

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        return R.layout.ttlive_like_egg_composite_image_dialog_pad;
    L5:
        return R.layout.ttlive_like_egg_composite_image_dialog;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.f139888k0.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        ImageLoader.loadSdcardImage(this.I, this.f139888k0);
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public CompositeImagePreviewDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.Z = new CompositeDisposable();
        this.f139888k0 = "";
    }

    public final void a1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imagePath");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        MainThreadPostUtils.e(new e(this, r100));
        return;
    L8:
        X0();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setDimAmount(0.0f);
        r101.setLayout(-1, -1);
        r101.setType(1);
    L5:
        boolean r102 = false;
        setCanceledOnTouchOutside(false);
        View r103 = findViewById(R.id.ttlive_design_bottom_sheet);
        if (r103 == null) goto L8;
        a1.k(r103, -1);
    L8:
        this.T = (RadiusLayout) findViewById(R.id.ttlive_design_bottom_sheet);
        this.H = findViewById(R.id.composite_image_preview_container);
        this.I = (HSImageView) findViewById(R.id.preview_image);
        this.f139887J = (TextView) findViewById(R.id.btn_confirm);
        this.K = (TextView) findViewById(R.id.btn_cancel);
        this.L = (HSImageView) findViewById(R.id.dialog_root);
        this.M = findViewById(R.id.shadow_view);
        this.N = findViewById(R.id.preview_close_button);
        this.O = findViewById(R.id.click_outside);
        this.P = (TextView) findViewById(R.id.dialog_title);
        this.Q = (TextView) findViewById(R.id.network_retry);
        this.R = findViewById(R.id.loading_error_container);
        this.S = findViewById(R.id.btn_close);
        this.U = findViewById(R.id.loading_anim_view);
        this.V = (TextView) findViewById(R.id.loading_tip);
        HSImageView r104 = this.I;
        if (r104 == null) goto L11;
        r104.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.a(this));
    L11:
        View r105 = this.N;
        if (r105 == null) goto L14;
        r105.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.b(this));
    L14:
        TextView r106 = this.f139887J;
        if (r106 == null) goto L17;
        r106.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.c(this));
    L17:
        TextView r107 = this.K;
        if (r107 == null) goto L20;
        r107.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.d(this));
    L20:
        View r108 = this.O;
        if (r108 == null) goto L23;
        r108.setOnClickListener(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.e.f139925a);
    L23:
        View r109 = this.S;
        if (r109 == null) goto L26;
        r109.setOnClickListener(new f(this));
    L26:
        TextView r110 = this.Q;
        if (r110 == null) goto L29;
        r110.setOnClickListener(new g(this));
    L29:
        k r111 = this.E;
        if (r111 != null) goto L32;
    L34:
        TextView r112 = this.P;
        if (r112 == null) goto L45;
        String r113 = this.F;
        if (r113 != null) goto L39;
    L43:
        String r114 = getContext().getString(R.string.ttlive_like_egg_composite_image_dialog_title);
    L44:
        r112.setText(r114);
        goto L45
    L39:
        if (r113.length() <= 0) goto L41;
        r102 = true;
    L41:
        if (r102 != true) goto L43;
        r114 = this.F;
    L45:
        Y0();
        W0();
        if (PadConfigUtils.c() == false) goto L56;
        u r115 = r.u(this.G, null, 2);
        if (r115 == null) goto L56;
        com.bytedance.live.datacontext.n<PadOrientation> r116 = r115.w();
        if (r116 == null) goto L56;
        Observable<sh6.b<PadOrientation>> r117 = r116.a();
        if (r117 == null) goto L56;
        Disposable r118 = r117.subscribe(new b(this));
        if (r118 == null) goto L56;
        RxUtilKt.c(r118, this.Z);
    L56:
        int r119 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_defined_show", new LinkedHashMap());
        if (this.f139889p0 == true) goto L60;
        this.f139889p0 = true;
        StringBuilder r120 = new StringBuilder("likeEggDialogCount increment: ");
        EasterEggAnimationDialog.f139896i.getClass();
        r120.append(EasterEggAnimationDialog.f139895h.incrementAndGet());
        ALogger.d("CompositeImagePreviewDialog", r120.toString());
        return;
    L60:
        return;
    L32:
        if (r111.isValid() != true) goto L34;
        ImageLoader.bindImage(this.L, this.E);
        goto L34
    }
}
