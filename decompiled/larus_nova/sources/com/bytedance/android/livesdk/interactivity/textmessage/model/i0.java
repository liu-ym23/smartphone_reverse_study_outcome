package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.d4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.l0;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.message.q0;
import com.bytedance.android.live.base.model.message.r2;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.message.w0;
import com.bytedance.android.live.base.model.message.w3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.ac;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.message.model.i7;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.message.model.na;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.qa;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i0 {
    public static int a(int r100) {
        return s1.getContext().getResources().getColor(r100);
    }

    public static Spannable b(String r100, int r101) {
        SpannableString r102 = new SpannableString(r100);
        r102.setSpan(new ForegroundColorSpan(r101), 0, r102.length(), 18);
        return r102;
    }

    public static com.bytedance.android.livesdk.interactivity.api.entity.f e(com.bytedance.android.live.base.model.message.t r100, MessageSceneType r101, IRoom r102) {
        return f(r100, r101, r102);
    L4:
        e = move-exception;
        SafetyGuard.a("TextMessageHelper error", e, null);
        return null;
    }

    public static com.bytedance.android.livesdk.interactivity.api.entity.f f(com.bytedance.android.live.base.model.message.t r110, MessageSceneType r111, IRoom r112) {
        String r100 = r110.getMessageMethod();
        if ("WebcastChatMessage".equals(r100) == false) goto L7;
        d r113 = new d((k0) r110, r111);
        r113.f133143d = 31000;
        return r113;
    L7:
        if ("WebcastAudioChatMessage".equals(r100) == false) goto L11;
        AudioChatTextMessage r114 = new AudioChatTextMessage((com.bytedance.android.live.base.model.message.r) r110, r111);
        r114.f133143d = 31000;
        return r114;
    L11:
        if ("WebcastGiftMessage".equals(r100) == false) goto L15;
        m r115 = new m((o7) r110, r111);
        r115.f133143d = 21000;
        return r115;
    L15:
        if ("WebcastExhibitionChatMessage".equals(r100) == false) goto L19;
        return new k((w0) r110);
    L19:
        if ("GiftGroupMessage".equals(r100) == false) goto L23;
        l r116 = new l((kc2.b) r110, r111);
        r116.f133143d = 21000;
        return r116;
    L23:
        if ("WebcastLikeMessage".equals(r100) == false) goto L27;
        h r117 = new h((q0) r110, r111);
        r117.f133143d = 42000;
        return r117;
    L27:
        if ("WebcastMemberMessage".equals(r100) == false) goto L35;
        va r118 = (va) r110;
        if (r118.getAction() != 1) goto L32;
        u r119 = new u(r118, r111);
        r119.f133143d = 42000;
        return r119;
    L32:
        v r120 = new v(r118, r111);
        r120.f133143d = 42000;
        return r120;
    L35:
        if ("WebcastRoomMessage".equals(r100) == false) goto L39;
        d0 r121 = new d0((c4) r110, r111);
        r121.f133143d = 11000;
        return r121;
    L39:
        if ("WebcastAnchorBoostMessage".equals(r100) == false) goto L43;
        a r122 = new a((com.bytedance.android.live.base.model.message.o) r110, r111);
        r122.f133143d = 11000;
        return r122;
    L43:
        if ("WebcastSocialMessage".equals(r100) == false) goto L46;
        h0 r123 = new h0((l4) r110, r111);
        r123.f133143d = 41000;
        return r123;
    L46:
        boolean r101 = true;
        if ("WebcastControlMessage".equals(r100) == false) goto L57;
        n0 r124 = (n0) r110;
        if (r112 != null) goto L51;
    L53:
        r101 = false;
    L54:
        f r125 = new f(r124, r101);
        r125.f133143d = 11000;
        return r125;
    L51:
        if (r112.isMediaRoom() == false) goto L53;
    L57:
        if ("WebcastScreenChatMessage".equals(r100) == false) goto L60;
        g0 r126 = new g0((h4) r110, r111);
        r126.f133143d = 11000;
        return r126;
    L60:
        com.bytedance.android.livesdk.interactivity.api.entity.f r127 = null;
        if ("WebcastLuckyBoxMessage".equals(r100) == false) goto L72;
        if ((r110 instanceof qa) == false) goto L68;
        qa r128 = (qa) r110;
        if (r128.getTextMessageParams() == null) goto L67;
        r127 = new t(r128);
        goto L68
    L67:
        r127 = new s(r128);
    L68:
        if (r127 == null) goto L70;
        r127.f133143d = 22000;
    L70:
        return r127;
    L72:
        if ("WebcastLotteryEventNewMessage".equals(r100) == false) goto L76;
        r r129 = new r((na) r110);
        r129.f133143d = 22000;
        return r129;
    L76:
        if ("WebcastFansclubMessage".equals(r100) == false) goto L80;
        i r130 = new i((h7) r110, r111);
        r130.f133143d = 31000;
        return r130;
    L80:
        if ("WebcastLinkMicSendEmojiMessage".equals(r100) == false) goto L84;
        return new q((w8) r110);
    L84:
        if ("WebcastRoomIntroMessage".equals(r100) == false) goto L109;
        b4 r131 = (b4) r110;
        Intrinsics.checkNotNullParameter(r131, "$this$tryUseLabelInRoom");
        if (r112 == null) goto L107;
        py.r r132 = r112.getRoomIntroLabel();
        if (r132 == null) goto L107;
        Iterator<py.r> r133 = r131.G1().iterator();
        int r102 = 0;
    L91:
        if (r133.hasNext() == false) goto L99;
        if (r133.next().getType() != 1) goto L95;
        boolean r103 = true;
    L96:
        if (r103 == true) goto L100;
        r102 = r102 + 1;
    L100:
        if (r102 >= 0) goto L102;
    L105:
        ListProtector.add(r131.G1(), 0, r132);
        goto L107
    L102:
        if (r102 >= r131.G1().size()) goto L105;
        ListProtector.set(r131.G1(), r102, r132);
        goto L107
    L95:
        r103 = false;
        goto L96
    L99:
        r102 = -1;
    L107:
        return new b0(r131);
    L109:
        if ("WebcastMediaRoomNoticeMessage".equals(r100) == false) goto L113;
        return new c0((d4) r110);
    L113:
        if ("WebcastKtvMessage".equals(r100) == false) goto L117;
        return new p((l8) r110);
    L117:
        if ("WebcastNoticeMessage".equals(r100) == false) goto L121;
        return new a0((w3) r110);
    L121:
        if ("WebcastLinkMessage".equals(r100) == false) goto L137;
        if ((r110 instanceof r2) == false) goto L135;
        r2 r134 = (r2) r110;
        ALogger.d("TextMessageHelper", "receive LinkerMessage, type is " + r134.getType());
        if (r134.getType() != 29) goto L135;
        if (r134.getGuestInviteContent() != null) goto L129;
    L131:
        r101 = false;
    L132:
        if (r101 == false) goto L135;
        n r135 = new n(r134);
        r135.f133143d = 42000;
        return r135;
    L129:
        if (r134.getGuestInviteContent().a() == null) goto L131;
    L135:
        return null;
    L137:
        if ("WebcastCommonTextMessage".equals(r100) == false) goto L141;
        return new e((l0) r110);
    L141:
        if ("WebcastTopAggregateChatMessage".equals(r100) == false) goto L145;
        return new j0((ac) r110);
    L145:
        if ("WebcastPrivilegeScreenChatMessage".equals(r100) == false) goto L149;
        return new y((s3) r110, r111);
    L149:
        if ("WebcastNobleUpgradeMessage".equals(r100) == false) goto L153;
        return new g(r110);
    L153:
        if ("WebcastFeaturedAIMessage".equals(r100) == false) goto L157;
        return new j((i7) r110);
    L157:
        return new g(r110);
    }

    public static Spannable d(IBaseUser r100, String r101, int r102, int r103, String r104) {
        if (r100 == null) goto L18;
        if (TextUtils.isEmpty(gm2.q.b(r100)) == true) goto L18;
        if (TextUtils.isEmpty(r101) == true) goto L18;
        if (TextUtils.isEmpty(r104) == false) goto L12;
        r104 = gm2.q.b(r100);
    L12:
        if (TextUtils.isEmpty(r104) == true) goto L14;
        ForegroundColorSpan r105 = new ForegroundColorSpan(r102);
        ForegroundColorSpan r106 = new ForegroundColorSpan(r103);
        SpannableString r107 = new SpannableString(r104 + tb2.c.DEFAULT_TEXT + r101);
        r107.setSpan(r105, 0, r104.length(), 33);
        r107.setSpan(r106, r104.length(), r107.length(), 18);
        return r107;
    L14:
        return sb2.a.f541209a;
    L18:
        return sb2.a.f541209a;
    }

    public static Spannable c(IBaseUser r100, String r101, String r102, int r103, int r104, String r105) {
        SpannableStringBuilder r106 = new SpannableStringBuilder(r102);
        if (r100 == null) goto L15;
        if (TextUtils.isEmpty(r106) == true) goto L15;
        if (TextUtils.isEmpty(r105) == false) goto L11;
        r105 = gm2.q.b(r100);
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L16;
        ForegroundColorSpan r107 = new ForegroundColorSpan(r103);
        ForegroundColorSpan r108 = new ForegroundColorSpan(r104);
        SpannableString r109 = new SpannableString(r105 + r101 + r106);
        r109.setSpan(r107, 0, r105.length() + 1, 33);
        r109.setSpan(r108, r105.length() + 1, r109.length(), 18);
        return r109;
    L16:
        return sb2.a.f541209a;
    L15:
        return sb2.a.f541209a;
    }
}
