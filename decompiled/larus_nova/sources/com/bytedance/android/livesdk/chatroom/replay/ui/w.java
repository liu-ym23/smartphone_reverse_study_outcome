package com.bytedance.android.livesdk.chatroom.replay.ui;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.util.ReplayResolutionHelper;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.larus.nova.R;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w extends ir1.c {
    public w() {
    }

    public final void o(VideoResolutionItem r100, TextView r101, View r102) {
        Object r103 = null;
        String r104 = null;
        if (i() == false) goto L5;
    L20:
        if (r102 == null) goto L36;
        Iterator<T> r105 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.f117941a.iterator();
    L23:
        if (r105.hasNext() == false) goto L31;
        Object r106 = r105.next();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a r107 = (com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a) r106;
        if (r100 == null) goto L27;
        String r108 = r100.getKey();
    L29:
        if (Intrinsics.areEqual(r108, r107.f117942a) == false) goto L23;
        r103 = r106;
        goto L31
    L27:
        r108 = null;
    L31:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a r109 = (com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a) r103;
        if (r109 == null) goto L34;
        int r110 = r109.f117944c;
    L35:
        r102.setBackgroundResource(r110);
        goto L36
    L34:
        r110 = R.drawable.ttlive_icon_toolbar_resolution_sd;
    L36:
        int r111 = (int) 4279638051L;
        if (r102 == null) goto L50;
        Drawable r112 = r102.getBackground();
        if (r112 == null) goto L51;
        Drawable r113 = r112.mutate();
        if (r113 == null) goto L52;
        r113.setColorFilter(r111, PorterDuff.Mode.SRC_ATOP);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L5:
        if (g() == true) goto L20;
        if (r100 == null) goto L10;
        r104 = r100.getKey();
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.c(r104) == false) goto L13;
        if (r101 == null) goto L47;
        Rect r114 = new Rect(0, s1.f(7.0f), s1.f(63.0f), s1.f(28.0f));
        SpannableString r115 = new SpannableString("音画增强");
        Drawable r116 = s1.m(R.drawable.ttlive_ic_replay_hdr_resolution_select);
        r116.setBounds(r114);
        r115.setSpan(new ImageSpan(r116, 1), 0, 4, 17);
        r101.setText(r115);
        return;
    L47:
        return;
    L13:
        if (r101 == null) goto L49;
        if (r100 == null) goto L17;
        String r117 = r100.getName();
        if (r117 == null) goto L17;
    L18:
        r101.setText(ReplayResolutionHelper.a(r117, i()));
        return;
    L17:
        r117 = "";
        goto L18
    }
}
