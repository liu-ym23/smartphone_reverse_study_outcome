package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f55834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f55835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f55836c;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.gamecp_comment_editor_exit_confirm_dialog_layout);
        this.f55834a = (TextView) findViewById(R.id.comment_exit_cancel);
        this.f55835b = (TextView) findViewById(R.id.comment_exit_confirm);
        TextView r101 = this.f55834a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvCancel");
    L5:
        r101.setOnClickListener(new d(this));
        TextView r102 = this.f55835b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
    L8:
        r102.setOnClickListener(new e(this));
    }

    public f(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        this.f55836c = r101;
    }
}
