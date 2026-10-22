package com.bytedance.android.livesdk.interactivity.comment.input;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f135169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f135170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CheckBox f135171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f135172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f135173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f135174f;

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_live_dialog);
        setContentView(R.layout.ttlive_payment_confirm_dialog_layout);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f135169a = (TextView) findViewById(R.id.center_title);
        this.f135170b = (TextView) findViewById(R.id.center_content);
        this.f135171c = (CheckBox) findViewById(R.id.center_checkbox);
        TextView r101 = (TextView) findViewById(R.id.center_checked_text);
        this.f135172d = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkedText");
    L5:
        r101.setOnClickListener(new h(this));
        this.f135173e = (Button) findViewById(R.id.left_button);
        this.f135174f = (Button) findViewById(R.id.right_button);
    }
}
