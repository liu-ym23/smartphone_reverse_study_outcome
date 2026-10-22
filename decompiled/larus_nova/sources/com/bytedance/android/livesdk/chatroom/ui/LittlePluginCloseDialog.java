package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LittlePluginCloseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LittlePluginCloseDialog extends AppCompatDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f112257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f112258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f112259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.model.e f112260d;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L16;
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        r101.copyFrom(r100.getAttributes());
        r101.width = com.bytedance.android.live.core.utils.s1.f(280.0f);
        r101.height = -2;
        r100.setAttributes(r101);
        View r102 = this.f112258b;
        if (r102 == null) goto L17;
        com.bytedance.android.live.core.utils.a1.p(r102, com.bytedance.android.live.core.utils.s1.f(280.0f));
        return;
    L17:
        return;
    L16:
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static void I0(LittlePluginCloseDialog r100) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.intValue() != R.id.ok) goto L19;
        I0(this);
        DataCenter r102 = this.f112259c;
        if (r102 == null) goto L20;
        r102.put("cmd_close_little_plugin", this.f112260d);
        return;
    L20:
        return;
    L19:
        return;
    L8:
        if (r101.intValue() != R.id.cancel) goto L10;
        I0(this);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_little_plugin, null);
        this.f112257a = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        this.f112258b = r101.findViewById(R.id.divider);
        View r102 = this.f112257a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        View r103 = r102.findViewById(R.id.cancel);
        if (r103 == null) goto L11;
        r103.setOnClickListener(this);
    L11:
        TextView r104 = (TextView) r102.findViewById(R.id.ok);
        if (r104 == null) goto L14;
        r104.setOnClickListener(this);
    L14:
        View r105 = this.f112257a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        setContentView(r105);
    }

    public LittlePluginCloseDialog(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.api.model.e r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, R.style.ttlive_live_dialog);
        this.f112259c = r101;
        this.f112260d = r102;
    }
}
