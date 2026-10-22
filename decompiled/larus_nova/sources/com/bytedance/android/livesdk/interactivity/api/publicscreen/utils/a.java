package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final int a(Boolean r100) {
        if (g2.b(r100) == false) goto L5;
        return R.dimen.ttlive_text_message_widget_bottom_margin_new;
    L5:
        return R.dimen.ttlive_text_message_widget_bottom_margin_old;
    }
}
