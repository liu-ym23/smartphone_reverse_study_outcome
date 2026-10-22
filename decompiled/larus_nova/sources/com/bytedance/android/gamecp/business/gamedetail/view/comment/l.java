package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f55847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f55848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f55849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f55850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f55851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f55852f;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.gamecp_comment_write_guide_dialog_layout);
        setCanceledOnTouchOutside(false);
        this.f55847a = (TextView) findViewById(R.id.comment_guide_know);
        this.f55848b = (TextView) findViewById(R.id.comment_guide_title);
        this.f55849c = (TextView) findViewById(R.id.comment_guide_content);
        TextView r101 = this.f55848b;
        if (r101 == null) goto L5;
        r101.setText(this.f55850d);
    L5:
        TextView r102 = this.f55849c;
        if (r102 == null) goto L8;
        r102.setText(this.f55851e);
    L8:
        TextView r103 = this.f55847a;
        if (r103 == null) goto L12;
        r103.setOnClickListener(new g(this));
        return;
    }

    public l(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        this.f55852f = r101;
        this.f55850d = y0.i(R.string.ttlive_game_promote_comment_guide_title);
        this.f55851e = y0.i(R.string.ttlive_game_promote_comment_guide_content);
    }
}
