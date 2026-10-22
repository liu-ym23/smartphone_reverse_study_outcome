package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/LiveHighlightRecordGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHighlightRecordGuideDialog extends CommonStandardBottomDialog implements d {
    public static final /* synthetic */ int L = 0;
    public final CompositeDisposable B;
    public View C;
    public View D;
    public View E;
    public HSImageView F;
    public View G;
    public View H;
    public View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Animator f136111J;
    public RecordGuideContext K;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_highlight_record_guide;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.d
    public final RecordGuideContext B() {
        RecordGuideContext r100 = this.K;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("guideContext");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        B().onDialogClose();
        this.B.clear();
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
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        B().onDialogCreate();
        Window r101 = getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L7;
        r102.dimAmount = 0.0f;
    L7:
        this.C = findViewById(R.id.tvBack);
        this.D = findViewById(R.id.tvSaveDraft);
        this.E = findViewById(R.id.flCoverContainer);
        this.F = (HSImageView) findViewById(R.id.ivCover);
        this.G = findViewById(R.id.llPublish);
        this.H = findViewById(R.id.ivPublishLoading);
        this.I = findViewById(R.id.llDownload);
        ImageUtil.loadImage(this.F, B().getHighlightData().c(), 0);
        setOnCancelListener(new h(this));
        View r103 = this.C;
        if (r103 == null) goto L10;
        r103.setOnClickListener(new i(this));
    L10:
        View r104 = this.D;
        if (r104 == null) goto L13;
        r104.setOnClickListener(new j(this));
    L13:
        View r105 = this.E;
        if (r105 == null) goto L16;
        r105.setOnClickListener(new k(this));
    L16:
        View r106 = this.G;
        if (r106 == null) goto L19;
        r106.setOnClickListener(new l(this));
    L19:
        View r107 = this.I;
        if (r107 == null) goto L22;
        r107.setOnClickListener(new m(this));
    L22:
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(B().getCloseGuideDialog()).subscribe(new f(this)), this.B);
        com.bytedance.revenue.platform.api.core.rx.f.a(RxUtilKt.h(B().getPublishLoadingShow()).subscribe(new g(this)), this.B);
    }

    public LiveHighlightRecordGuideDialog(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "info");
        super(r100, false);
        this.B = new CompositeDisposable();
    }
}
