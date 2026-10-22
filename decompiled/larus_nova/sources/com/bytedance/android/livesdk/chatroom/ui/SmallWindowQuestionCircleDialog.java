package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/SmallWindowQuestionCircleDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmallWindowQuestionCircleDialog extends CommonStandardBottomDialog {
    public boolean B;

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_small_window_question_circle_layout;
    }

    public SmallWindowQuestionCircleDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        LinearLayout r101 = (LinearLayout) findViewById(R.id.lottery_view);
        String r102 = com.bytedance.android.livesdk.floatview.inner.h.f125183a;
        if (com.bytedance.android.livesdk.config.g4.f120254a.getValue().booleanValue() == false) goto L6;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        if (this.B == true) goto L32;
        return;
    L32:
        View r103 = findViewById(R.id.bg_border);     // Catch: Exception -> L31
        if (r103 == null) goto L14;
        r103.setBackgroundResource(R.drawable.ttlive_bg_long_press_v2);     // Catch: Exception -> L31
    L14:
        View r104 = findViewById(R.id.divider);     // Catch: Exception -> L31
        if (r104 == null) goto L17;
        r104.setBackgroundColor(Color.parseColor("#33161823"));     // Catch: Exception -> L31
    L17:
        TextView r105 = (TextView) findViewById(R.id.more_dialog_title);     // Catch: Exception -> L31
        if (r105 == null) goto L21;
        r105.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L21:
        TextView r106 = (TextView) findViewById(R.id.hint_text);     // Catch: Exception -> L31
        if (r106 == null) goto L24;
        r106.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L24:
        TextView r107 = (TextView) findViewById(R.id.lottery_text);     // Catch: Exception -> L31
        if (r107 == null) goto L27;
        r107.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
    L27:
        TextView r108 = (TextView) findViewById(R.id.red_package_text);     // Catch: Exception -> L31
        if (r108 == null) goto L35;
        r108.setTextColor(Color.parseColor("#99161823"));     // Catch: Exception -> L31
        return;
    L35:
        return;
    L36:
        return;
    L6:
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        goto L9
    }
}
