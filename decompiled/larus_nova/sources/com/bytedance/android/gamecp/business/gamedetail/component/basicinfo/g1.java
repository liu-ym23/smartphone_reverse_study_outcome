package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f53717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f53718b;

    public g1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        setContentView(R.layout.gamecp_detail_icp_dialog_layout);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        TextView r101 = (TextView) findViewById(R.id.gamecp_detail_icp_title);
        this.f53717a = (TextView) findViewById(R.id.gamecp_detail_icp_content);
        this.f53718b = (TextView) findViewById(R.id.gamecp_detail_icp_tv_confirm);
    }
}
