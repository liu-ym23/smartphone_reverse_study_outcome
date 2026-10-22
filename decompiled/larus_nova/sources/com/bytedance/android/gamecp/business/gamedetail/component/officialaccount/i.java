package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import wu.h3;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f54718a;

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.gamecp_official_item_intro_dialog);
        TextView r101 = (TextView) findViewById(R.id.tv_know_btn);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new h(this));
    L5:
        this.f54718a = (TextView) findViewById(R.id.tv_content);
        String r102 = h3.f561321a.getValue();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        String r104 = r102;
    L14:
        if (r104 == null) goto L20;
        TextView r105 = this.f54718a;
        if (r105 == null) goto L21;
        r105.setText(r102);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r104 = null;
        goto L14
    L10:
        r103 = false;
        goto L11
    }
}
