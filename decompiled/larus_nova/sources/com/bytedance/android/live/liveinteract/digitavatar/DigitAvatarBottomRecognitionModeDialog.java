package com.bytedance.android.live.liveinteract.digitavatar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarBottomRecognitionModeDialog;", "Lcom/bytedance/android/livesdk/common/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DigitAvatarBottomRecognitionModeDialog extends com.bytedance.android.livesdk.common.b implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f72524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f72525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f72526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f72527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f72528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f72529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f72530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f72531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f72532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f72533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupMenu.OnMenuItemClickListener f72534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f72535m;

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f72535m.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        r100.setWindowAnimations(0);
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("cmd_dismiss_digit_avatar_recogntion_mode_dialog", r101.getKey()) == false) goto L27;
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setGravity(80);
        r101.setLayout(-1, -2);
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_bottom_recognition_mode_layout, null));
        ((TextView) this.f72524b.getValue()).setOnClickListener(new b(this));
        ((ImageView) this.f72525c.getValue()).setOnClickListener(new c(this));
        ((TextView) this.f72526d.getValue()).setOnClickListener(new d(this));
        ((ImageView) this.f72527e.getValue()).setOnClickListener(new e(this));
        ((TextView) this.f72528f.getValue()).setOnClickListener(new f(this));
        ((TextView) this.f72529g.getValue()).setOnClickListener(new g(this));
        this.f72535m.observe("cmd_dismiss_digit_avatar_recogntion_mode_dialog", this);
    }

    public DigitAvatarBottomRecognitionModeDialog(Context r100, m.a r101, m.b r102, m.c r103, m.d r104, m.e r105, DataCenter r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "optionActionPhoto");
        Intrinsics.checkNotNullParameter(r102, "optionActionCamera");
        Intrinsics.checkNotNullParameter(r103, "optionActionDefault");
        Intrinsics.checkNotNullParameter(r104, "optionActionRecognitionRule");
        Intrinsics.checkNotNullParameter(r105, "cancelAction");
        Intrinsics.checkNotNullParameter(r106, "dataCenter");
        super(r100, true);
        this.f72530h = r101;
        this.f72531i = r102;
        this.f72532j = r103;
        this.f72533k = r104;
        this.f72534l = r105;
        this.f72535m = r106;
        this.f72524b = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionPhoto$2(this));
        this.f72525c = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$recognitionRuleForPhoto$2(this));
        this.f72526d = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionCamera$2(this));
        this.f72527e = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$recognitionRuleForCamera$2(this));
        this.f72528f = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$tvRecognitionDefault$2(this));
        this.f72529g = InfraKotlinExtsKt.mainThreadLazy(new DigitAvatarBottomRecognitionModeDialog$cancelView$2(this));
    }
}
