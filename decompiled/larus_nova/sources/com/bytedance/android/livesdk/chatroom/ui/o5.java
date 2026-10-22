package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o5 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f113741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f113742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f113743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f113744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f113745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f113746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f113747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f113748h;

    public o5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_live_dialog);
        setContentView(R.layout.ttlive_dialog_ban_tips_layout);
        setCanceledOnTouchOutside(false);
        this.f113742b = (TextView) findViewById(R.id.room_center_title);
        this.f113743c = (TextView) findViewById(R.id.room_center_content);
        this.f113744d = (TextView) findViewById(R.id.tips_enter);
        this.f113746f = (Button) findViewById(R.id.room_right_button);
        this.f113741a = findViewById(R.id.tips_enter_container);
        this.f113745e = findViewById(R.id.tips_enter_icon);
        this.f113747g = (Button) findViewById(R.id.room_left_button);
        this.f113748h = (TextView) findViewById(R.id.room_center_padding);
    }
}
