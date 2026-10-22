package com.bytedance.android.gamecp.business.download;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class u0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f52941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f52943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f52946f;

    public interface a {
        void onContinue();

        void onWaitWifi();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.gamecp.common.ui.f r100 = com.bytedance.android.gamecp.common.ui.f.a();
        r100.getClass();
        com.bytedance.android.gamecp.common.ui.f.f56987c++;
        r100.f56988a.postValue(Boolean.TRUE);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.gamecp.common.ui.f.a().b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L10;
        WindowManager.LayoutParams r101 = r100.getAttributes();
    L11:
        if (r101 == null) goto L13;
        r101.width = com.bytedance.android.gamecp.common.utils.y0.b(280.0f);
    L13:
        Window r102 = getWindow();
        if (r102 == null) goto L20;
        r102.setAttributes(r101);
        return;
    L20:
        return;
    L10:
        r101 = null;
        goto L11
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_game_union_flow_tips, null));
        ((TextView) findViewById(R.id.tv_continue)).setOnClickListener(new v0(this));
        ((TextView) findViewById(R.id.tv_wait_wifi)).setOnClickListener(new w0(this));
        if (TextUtils.isEmpty(this.f52941a) == true) goto L6;
        ((TextView) findViewById(R.id.tv_no_wifi_tip)).setText(this.f52941a);
    L6:
        if (TextUtils.isEmpty(this.f52942b) == true) goto L9;
        ((TextView) findViewById(R.id.tv_wait_wifi)).setText(this.f52942b);
    L9:
        if (TextUtils.isEmpty(this.f52943c) == true) goto L12;
        ((TextView) findViewById(R.id.tv_continue)).setText(this.f52943c);
        return;
    }

    public u0(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        this.f52946f = r101;
    }
}
