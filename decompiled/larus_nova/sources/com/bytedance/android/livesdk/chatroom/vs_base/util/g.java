package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class g {
    public static void a(Activity r100, OnBindPhoneListener r101, View.OnClickListener r102) {
        AlertDialog.Builder r103 = new AlertDialog.Builder(r100);
        SpannableString r104 = new SpannableString(r100.getString(R.string.ttlive_replay_bind_mobile_dialog_title));
        r104.setSpan(new ForegroundColorSpan(r100.getResources().getColor(R.color.ttlive_replay_light_blue)), 1, 16, 33);
        TextView r105 = new TextView(r100);
        r105.setTextSize(1, 18.0f);
        r105.setText(r104);
        r105.setPadding(s1.f(30.0f), s1.f(20.0f), s1.f(30.0f), s1.f(10.0f));
        r105.setTextColor(-16777216);
        r105.setOnClickListener(r102);
        r103.setCustomTitle(r105).setNegativeButton(R.string.ttlive_replay_bind_mobile_dialog_cancel, new f()).setPositiveButton(R.string.ttlive_replay_bind_mobile_dialog_sure, new e(r100, r101)).setCancelable(false);
        AlertDialog r106 = r103.create();
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r106);
    L7:
        r106.getButton(-1).setTextColor(r100.getResources().getColor(R.color.ttlive_replay_light_blue));
        r106.getButton(-2).setTextColor(r100.getResources().getColor(R.color.ttlive_hs_s44));
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L7
    }
}
