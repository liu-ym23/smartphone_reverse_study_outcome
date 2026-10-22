package com.bytedance.android.livesdk.interactivity.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final int c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toColorInt");
        return Color.parseColor("#" + r100);
    L5:
        return -1;
    }

    public static final boolean d(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        if ((r100 instanceof z) == true) goto L5;
        r100 = null;
    L5:
        z r101 = (z) r100;
        if (r101 == null) goto L13;
        long r102 = r101.f133720a.getChatSource();
        if (r102 != 9) goto L10;
    L11:
        return true;
    L10:
        if (r102 == 10) goto L11;
        return false;
    L13:
        return false;
    }

    public static final void a(tc2.j r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "selfSendInfo");
        long r102 = r100.f545393d;
        if (r102 <= 0) goto L15;
        long r103 = r100.f545391b;
        if (r103 <= r102) goto L16;
        long r104 = r100.f545394e;
        if (r104 > r103) goto L9;
        return;
    L9:
        if (r101 > r104) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r100.f545395f, "--default--") == true) goto L19;
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.d(EventName.ChatSendToShowDelay, MapsKt.mapOf(new Pair[]{TuplesKt.to("send_to_show_cost_time", String.valueOf(r101 - r100.f545393d)), TuplesKt.to("api_success_to_show_cost_time", String.valueOf(r101 - r100.f545394e)), TuplesKt.to("api_network_cost_time", String.valueOf(r100.f545394e - r100.f545391b)), TuplesKt.to("show_area", "danmaku"), TuplesKt.to("message_type", r100.f545395f)}));
        return;
    L19:
        return;
    L16:
        return;
    }

    public static final CharSequence b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getTalentTextContent");
        Intrinsics.checkNotNullParameter(r100, "$this$getTextContent");
        CharSequence r102 = r100.getChatContent();
        if ((r100 instanceof p0) == false) goto L5;
        r102 = ((p0) r100).getRenderSpan();
    L5:
        SpannableString r103 = ab2.a.f(r102, r101);
        String r104 = "";
        if (r100.a() == false) goto L18;
        IBaseUser r105 = r100.getUserInfo();
        if (r105 == null) goto L14;
        String r106 = r105.getNickName();
        if (r106 == null) goto L14;
        r104 = r106;
    L14:
        if (r104.length() < 12) goto L17;
        r104 = r104.subSequence(0, 6) + "..." + r104.subSequence(r104.length() - 5, r104.length());
    L17:
        return new SpannableStringBuilder(r104).append(": ").append(r103);
    L18:
        o1 r107 = r100.getLandscapeAreaCommon();
        if (r107 != null) goto L21;
    L30:
        return r103;
    L21:
        if (r107.isShowNickName() != true) goto L30;
        IBaseUser r108 = r100.getUserInfo();
        if (r108 == null) goto L29;
        String r109 = r108.getNickName();
        if (r109 == null) goto L29;
        r104 = r109;
    L29:
        return new SpannableStringBuilder(r104).append(": ").append(r103);
    }
}
