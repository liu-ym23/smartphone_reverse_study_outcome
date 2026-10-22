package com.bytedance.android.livesdk.chatroom.replay.ui;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class x extends ir1.c {
    public x() {
    }

    public final void o(TextView r100, View r101) {
        SettingKey<VSFoldFixConfig> r102 = LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG;
        if (r102.getValue().getEnable() == false) goto L7;
        if (a() == false) goto L7;
    L37:
        long r103 = com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118163e;
        if (r103 != (-2)) goto L57;
        if (r100 == null) goto L73;
        r100.setText(s1.B(R.string.ttlive_vs_schedule_close));
        if (r102.getValue().getEnable() == false) goto L45;
        if (a() == false) goto L45;
        return;
    L45:
        if (g() == true) goto L49;
        if (d() == true) goto L49;
        return;
    L49:
        if (i() == false) goto L51;
    L54:
        int r104 = s1.h(R.color.ttlive_replay_toolbar_portrait_icon_name_color);
    L55:
        r100.setTextColor(r104);
        return;
    L51:
        if (g() == true) goto L54;
        r104 = s1.h(R.color.ttlive_replay_toolbar_icon_name_color_land);
        goto L55
    L73:
        return;
    L57:
        if (r102.getValue().getEnable() == false) goto L61;
        if (a() == false) goto L61;
    L66:
        if (r100 != null) goto L68;
        return;
    L68:
        if (r103 != (-1)) goto L70;
        String r105 = s1.B(R.string.ttlive_vs_schedule_close_until_now);
    L71:
        r100.setText(r105);
        return;
    L70:
        r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.o.b(r103);
    L61:
        if (g() == false) goto L63;
    L64:
        if (r100 == null) goto L66;
        r100.setTextColor(s1.h(R.color.ttlive_vs_only_ta_item_selected_color));
        goto L66
    L63:
        if (d() == false) goto L66;
    L7:
        if (g() == true) goto L11;
        if (d() == false) goto L37;
    L11:
        if (com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a.f118163e != (-2)) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L29;
        if (e() == true) goto L18;
    L24:
        if (r101 == null) goto L26;
        r101.setBackgroundResource(R.drawable.ttlive_vs_schedule_close_portrait);
    L26:
        if (r101 == null) goto L37;
        r101.setAlpha(0.7f);
        goto L37
    L18:
        if (g() == true) goto L24;
        if (r101 == null) goto L22;
        r101.setBackgroundResource(R.drawable.ttlive_vs_schedule_close_landscape_opt);
    L22:
        if (r101 == null) goto L37;
        r101.setAlpha(1.0f);
        goto L37
    L29:
        if (e() == true) goto L31;
    L35:
        if (r101 == null) goto L37;
        r101.setBackgroundResource(R.drawable.ttlive_vs_schedule_close_active_portrait);
        goto L37
    L31:
        if (g() == true) goto L35;
        if (r101 == null) goto L37;
        r101.setBackgroundResource(R.drawable.ttlive_vs_schedule_close_active_landscape_opt);
        goto L37
    L13:
        r106 = false;
        goto L14
    }
}
