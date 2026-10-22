package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import ch0.f;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.battle.i;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.profit.dress.s;
import com.bytedance.android.live.ui.k;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import nh0.m;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f78073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f78074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f78076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkMicQuickInteractView f78077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MultiLinkMicSeatGiftIconElement f78078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ThemedCompetitionQuickInteractView f78079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f78080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f78081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ke0.a f78082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final xg0.a f78083k;

    public final void b(String r100) {
        if (((Boolean) vm2.d.Z2.getValue(null, vm2.d.f555776a[205(0xcd, float:2.87E-43)])).booleanValue() == false) goto L5;
        this.f78080h = null;
    L5:
        f(r100);
        HSImageView r101 = this.f78073a;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r101);
    L8:
        HSImageView r102 = this.f78073a;
        if (r102 == null) goto L12;
        r102.setController(null);
        return;
    }

    public final void f(String r100) {
        if (this.f78075c == false) goto L16;
        if (r100 == null) goto L17;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r101 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b(r100, 1, null);
        r101.f72213a = true;
        ke0.a r102 = this.f78082j;
        if (r102 == null) goto L8;
        r102.b(r101);
    L8:
        Integer r103 = this.f78076d;
        if (r103 == null) goto L18;
        int r104 = r103.intValue();
        xg0.a r105 = this.f78083k;
        if (r105 == null) goto L19;
        ig0.b r106 = r105.P6(r104);
        if (r106 == null) goto L20;
        r106.b(r101);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void d(boolean r100, ch0.e r101) {
        String r102 = null;
        if (r101 == null) goto L5;
        ILinkPlayerInfoBridge r103 = r101.f23724a;
    L7:
        if (r100 == false) goto L20;
        if (r103 != null) goto L10;
    L16:
        HSImageView r104 = this.f78073a;
        if (r104 == null) goto L19;
        UtilityKotlinExtentionsKt.u(r104);
    L19:
        ALogger.w("CommonMicWidgetManager", "#onMediaTypeChanged# set fight seat effect gone. isVideoOrAvatar=" + r100 + ", guestInfo=" + r103);
        return;
    L10:
        if (r103.isBackground() == false) goto L16;
        IBaseUser r105 = r103.getUser();
        if (r105 == null) goto L15;
        r102 = r105.getIdString();
    L15:
        if (Intrinsics.areEqual(r102, je0.d.b0()) == true) goto L16;
    L20:
        HSImageView r106 = this.f78073a;
        if (r106 == null) goto L25;
        Intrinsics.checkNotNullParameter(r106, "$this$setVisibilityVisibleIfNeed");
        if (this.f78075c == true) goto L25;
        UIUtils.setViewVisibility(r106, 0);
    L25:
        ALogger.w("CommonMicWidgetManager", "#onMediaTypeChanged# set fight seat effect visible. isVideoOrAvatar=" + r100 + ", guestInfo=" + r103);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void g(boolean r100, ch0.e r101) {
        String r102 = null;
        if (r101 == null) goto L5;
        ILinkPlayerInfoBridge r103 = r101.f23724a;
    L6:
        boolean r104 = true;
        if (r100 == false) goto L28;
        int r105 = ki0.a.f503598a;
        if (r103 != null) goto L11;
    L13:
        if (r103 == null) goto L18;
        IBaseUser r106 = r103.getUser();
        if (r106 == null) goto L18;
        r102 = r106.getIdString();
    L18:
        if ((!Intrinsics.areEqual(r102, je0.d.b0())) == true) goto L21;
    L20:
        r104 = false;
    L21:
        if (r104 == false) goto L35;
        HSImageView r107 = this.f78073a;
        if (r107 == null) goto L27;
        Intrinsics.checkNotNullParameter(r107, "$this$setVisibilityVisibleIfNeed");
        if (this.f78075c == true) goto L27;
        UIUtils.setViewVisibility(r107, 0);
    L27:
        ALogger.w("CommonMicWidgetManager", "#updateBackgroundStatus# set fight seat effect visible. isBackground=" + r100 + ", totalBackground=false, guestInfo=" + r103);
        return;
    L35:
        return;
    L11:
        if (r103.getSilenceStatus() != 0) goto L13;
    L28:
        if (r101 != null) goto L30;
    L32:
        r104 = false;
    L33:
        d(r104, r101);
        return;
    L30:
        if (f.b(r101) != true) goto L32;
    L5:
        r103 = null;
        goto L6
    }

    public static void e(LinkMicQuickInteractView r100, MultiLinkMicSeatGiftIconElement r101, m r102) {
        if (r102 == null) goto L7;
        Integer r103 = r102.m();
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        String r105 = null;
        if (r100 == null) goto L14;
        if (r102 == null) goto L12;
        String r106 = r102.h();
    L13:
        r100.l(r104, r106);
        goto L14
    L12:
        r106 = null;
    L14:
        if (r100 == null) goto L16;
        r100.h(null);
    L16:
        if (r100 == null) goto L18;
        r100.g("#33000000");
    L18:
        if (r100 == null) goto L20;
        r100.setAnimationBackground("#57FE2C55");
    L20:
        if (r100 == null) goto L22;
        r100.i(null);
    L22:
        if (r100 == null) goto L29;
        if (r102 == null) goto L25;
        long r107 = r102.n();
    L26:
        if (r102 == null) goto L28;
        r105 = r102.h();
    L28:
        r100.f79538s = r107;
        r100.f79539t = r105;
        r100.k(false);
        goto L29
    L25:
        r107 = 0;
    L29:
        if (r101 != null) goto L31;
        return;
    L31:
        if (r101.f75667d == true) goto L33;
        return;
    L33:
        if (r104 != 2) goto L36;
        if (r100 == null) goto L41;
        r100.setVisibility(0);
        return;
    L41:
        return;
    L36:
        if (r104 != 0) goto L43;
        r101.e(r101.f75665b);
        return;
    L43:
        return;
    L7:
        r104 = 0;
        goto L8
    }

    public static void h(LinkMicQuickInteractView r100, MultiLinkMicSeatGiftIconElement r101, m r102) {
        if (r102 == null) goto L7;
        Integer r103 = r102.m();
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        String r105 = null;
        if (r100 == null) goto L14;
        if (r102 == null) goto L12;
        String r106 = r102.h();
    L13:
        r100.l(r104, r106);
        goto L14
    L12:
        r106 = null;
    L14:
        String r107 = "";
        if (r100 == null) goto L27;
        int r108 = i.f78024a;
        if (r102 == null) goto L20;
        String r109 = r102.h();
        if (r109 == null) goto L20;
    L21:
        Uri r110 = i.d(r109);
        if (r110 == null) goto L24;
        String r111 = r110.toString();
    L25:
        r100.h(r111);
        goto L27
    L24:
        r111 = null;
    L20:
        r109 = "";
    L27:
        if (r102 == null) goto L36;
        String r112 = r102.g();
        if (r112 == null) goto L36;
        if (r112.length() <= 0) goto L33;
        boolean r113 = true;
    L34:
        if (r113 != true) goto L36;
        String r114 = r102.g();
    L42:
        if (r100 == null) goto L44;
        r100.g(r114);
    L44:
        if (r100 == null) goto L51;
        int r115 = i.f78024a;
        if (r102 == null) goto L49;
        String r116 = r102.h();
        if (r116 == null) goto L49;
    L50:
        r100.setAnimationBackground(i.b(r116));
    L49:
        r116 = "";
    L51:
        if (r100 == null) goto L59;
        int r117 = i.f78024a;
        if (r102 == null) goto L58;
        String r118 = r102.h();
        if (r118 == null) goto L58;
        r107 = r118;
    L58:
        r100.i(i.c(r107));
    L59:
        if (r100 == null) goto L66;
        if (r102 == null) goto L62;
        long r119 = r102.n();
    L63:
        if (r102 == null) goto L65;
        r105 = r102.h();
    L65:
        r100.f79538s = r119;
        r100.f79539t = r105;
        r100.k(false);
        goto L66
    L62:
        r119 = 0;
    L66:
        if (r101 != null) goto L68;
        return;
    L68:
        if (r101.f75667d == true) goto L70;
        return;
    L70:
        if (r104 != 2) goto L73;
        if (r100 == null) goto L78;
        r100.setVisibility(0);
        return;
    L78:
        return;
    L73:
        if (r104 != 0) goto L80;
        r101.e(r101.f75665b);
        return;
    L80:
        return;
    L33:
        r113 = false;
    L36:
        int r120 = i.f78024a;
        if (r102 == null) goto L40;
        String r121 = r102.h();
        if (r121 == null) goto L40;
    L41:
        r114 = i.b(r121);
    L40:
        r121 = "";
    L7:
        r104 = 0;
        goto L8
    }

    public final void a(String r110, String r111, boolean r112) {
        if (r111 == null) goto L5;
        Object r113 = r111;
    L22:
        gj0.i.a("CommonMicWidgetManager", "animateRightTopIcon  hatUrl : " + r111 + " animationUri : " + r113 + "  isVideoOrAvatar : " + r112);
        if (r113 != null) goto L25;
        return;
    L25:
        HSImageView r114 = this.f78073a;
        if (r114 == null) goto L28;
        int r100 = qy.a.f535172a;
        k.c(r114, qy.a.a(r113.toString()), 0, null);
    L28:
        HSImageView r115 = this.f78073a;
        if (r115 == null) goto L31;
        r115.setAlpha(0.0f);
    L31:
        HSImageView r116 = this.f78073a;
        if (r116 == null) goto L34;
        UtilityKotlinExtentionsKt.d(r116, 500);
    L34:
        if (r112 == false) goto L38;
        HSImageView r117 = this.f78073a;
        if (r117 == null) goto L42;
        UtilityKotlinExtentionsKt.u(r117);
        return;
    L42:
        return;
    L38:
        HSImageView r118 = this.f78073a;
        if (r118 == null) goto L44;
        UtilityKotlinExtentionsKt.w(r118);
        return;
    L44:
        return;
    L5:
        int r101 = i.f78024a;
        Intrinsics.checkNotNullParameter(r110, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getCrownSettingIcon] dressId " + r110);
        if (r110 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L17;
        zt0.e r103 = yt0.c.a();
        Intrinsics.checkNotNull(r110);
        s r119 = (s) r103.getDressData(r110, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.c());
        if (r119 == null) goto L17;
        String r120 = r119.f87163e;
    L19:
        if (TextUtils.isEmpty(r120) == false) goto L21;
        r113 = null;
        goto L22
    L21:
        r113 = UriProtector.parse(r120);
    L17:
        r120 = null;
        goto L19
    L8:
        if (r110.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final void c(m r210, boolean r211, boolean r212) {
        StringBuilder r100 = new StringBuilder("handleWidgetInfo ");
        r100.append(r210);
        r100.append(", isVideoOrAvatar ");
        r100.append(r211);
        r100.append(" isBind ");
        r100.append(r212);
        r100.append(". postion: ");
        r100.append(this.f78076d);
        r100.append(" showingDressId: ");
        r100.append(this.f78080h);
        r100.append(" guestSendGiftView ");
        r100.append(this.f78077e);
        r100.append(" themedScoreView: ");
        r100.append(this.f78079g);
        r100.append(" style : ");
        String r101 = null;
        if (r210 == null) goto L5;
        Integer r102 = r210.m();
    L6:
        r100.append(r102);
        ALogger.i("CommonMicWidgetManager", r100.toString());
        boolean r103 = false;
        if (c.a(r210) == false) goto L22;
        if (r210 == null) goto L10;
        String r104 = r210.c();
    L11:
        f(r104);
        HSImageView r105 = this.f78073a;
        if (r105 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r105);
    L14:
        HSImageView r106 = this.f78073a;
        if (r106 == null) goto L17;
        r106.setController(null);
    L17:
        e(this.f78077e, this.f78078f, r210);
        e(null, null, r210);
        ThemedCompetitionQuickInteractView r107 = this.f78079g;
        if (r107 == null) goto L20;
        r107.d(null, null, null, 0);
    L20:
        this.f78080h = null;
        return;
    L10:
        r104 = null;
        goto L11
    L22:
        String r108 = this.f78080h;
        if (r210 == null) goto L25;
        String r109 = r210.h();
    L27:
        if (Intrinsics.areEqual(r108, r109) == false) goto L43;
        if (r210 != null) goto L30;
    L31:
        if (r210 == null) goto L33;
        Integer r110 = r210.m();
    L34:
        if (r110 != null) goto L37;
    L38:
        StringBuilder r111 = new StringBuilder("try to show same dressId ");
        if (r210 == null) goto L41;
        r101 = r210.h();
    L41:
        r111.append(r101);
        r111.append(", do nothing.");
        ALogger.i("CommonMicWidgetManager", r111.toString());
        return;
    L37:
        if (r110.intValue() == 2) goto L43;
    L33:
        r110 = null;
        goto L34
    L30:
        if (r210.i() != true) goto L31;
    L43:
        h(this.f78077e, this.f78078f, r210);
        h(null, null, r210);
        ThemedCompetitionQuickInteractView r112 = this.f78079g;
        final String r113 = "";
        if (r112 == null) goto L70;
        int r114 = i.f78024a;
        if (r210 == null) goto L49;
        String r115 = r210.h();
        if (r115 == null) goto L49;
    L50:
        Uri r116 = i.d(r115);
        if (r116 == null) goto L53;
        String r117 = r116.toString();
    L54:
        if (r210 == null) goto L57;
        String r118 = r210.h();
        if (r118 == null) goto L57;
    L58:
        String r119 = i.b(r118);
        if (r210 == null) goto L62;
        String r120 = r210.h();
        if (r120 == null) goto L62;
    L63:
        String r121 = i.c(r120);
        if (r210 == null) goto L68;
        Integer r122 = r210.m();
        if (r122 == null) goto L68;
        int r123 = r122.intValue();
    L69:
        r112.d(r117, r119, r121, r123);
    L68:
        r123 = 0;
    L62:
        r120 = "";
    L57:
        r118 = "";
        goto L58
    L53:
        r117 = null;
    L49:
        r115 = "";
    L70:
        if (r210 == null) goto L74;
        String r124 = r210.c();
        if (r124 == null) goto L74;
    L75:
        f(r124);
        HSImageView r125 = this.f78073a;
        if (r125 == null) goto L78;
        r125.setController(null);
    L78:
        if (r212 == false) goto L97;
        if (r210 == null) goto L84;
        String r126 = r210.h();
        if (r126 == null) goto L84;
        r113 = r126;
    L84:
        if (r210 == null) goto L86;
        String r127 = r210.j();
    L87:
        if (r211 == false) goto L96;
        if (r210 == null) goto L90;
        Integer r128 = r210.m();
    L91:
        if (r128 != null) goto L94;
    L95:
        r103 = true;
        goto L96
    L94:
        if (r128.intValue() == 2) goto L96;
    L90:
        r128 = null;
    L96:
        a(r113, r127, r103);
    L190:
        if (r210 == null) goto L192;
        r101 = r210.h();
    L192:
        this.f78080h = r101;
        return;
    L86:
        r127 = null;
        goto L87
    L97:
        if (r210 == null) goto L99;
        PlayType r129 = r210.k();
    L101:
        if (r129 != PlayType.PLAY_TYPE_NONE) goto L114;
        String r130 = r210.h();
        if (r130 == null) goto L105;
        r113 = r130;
    L105:
        String r131 = r210.j();
        if (r211 == false) goto L113;
        Integer r132 = r210.m();
        if (r132 != null) goto L111;
    L112:
        r103 = true;
        goto L113
    L111:
        if (r132.intValue() != 2) goto L112;
    L113:
        a(r113, r131, r103);
        goto L190
    L114:
        if (r210 == null) goto L116;
        PlayType r133 = r210.k();
    L118:
        if (r133 != PlayType.PLAY_TYPE_SEAT) goto L173;
        String r134 = r210.c().toString();
        String r135 = r210.h();
        if (r135 == null) goto L122;
        r113 = r135;
    L122:
        final String r136 = r210.j();
        if (r211 == false) goto L130;
        Integer r137 = r210.m();
        if (r137 != null) goto L128;
    L129:
        final boolean r138 = true;
    L131:
        String r139 = r210.l();
        if (r138 == false) goto L134;
        a(r113, r136, r138);
        goto L190
    L134:
        HSImageView r140 = this.f78073a;
        if (r140 == null) goto L137;
        UtilityKotlinExtentionsKt.u(r140);
    L137:
        int r141 = i.f78024a;
        Intrinsics.checkNotNullParameter(r113, "dressId");
        if (r113.length() != 0) goto L140;
        boolean r142 = true;
    L141:
        if (r142 == true) goto L146;
        zt0.e r143 = yt0.c.a();
        Intrinsics.checkNotNull(r113);
        s r144 = (s) r143.getDressData(r113, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.b());
        if (r144 == null) goto L146;
        String r145 = r144.f87161c;
    L148:
        if (TextUtils.isEmpty(r145) == false) goto L150;
        Uri r213 = null;
    L151:
        Intrinsics.checkNotNullParameter(r113, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getSponsorBgColorByDressId] dressId ".concat(r113));
        if (r113.length() != 0) goto L154;
        r103 = true;
    L154:
        if (r103 == true) goto L159;
        zt0.e r146 = yt0.c.a();
        Intrinsics.checkNotNull(r113);
        s r147 = (s) r146.getDressData(r113, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.e());
        if (r147 == null) goto L159;
        String r148 = r147.f87167i;
    L160:
        if (r213 == null) goto L172;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r149 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b(r134, 1, -1, r213, r139, r148, new CommonMicWidgetManager$playSeatCrownAnim$animEvent$1(this, r113, r136, r138));
        r149.f72214b = true;
        ke0.a r150 = this.f78082j;
        if (r150 == null) goto L164;
        r150.b(r149);
    L164:
        Integer r151 = this.f78076d;
        if (r151 == null) goto L171;
        int r152 = r151.intValue();
        xg0.a r153 = this.f78083k;
        if (r153 == null) goto L171;
        ig0.b r154 = r153.P6(r152);
        if (r154 == null) goto L171;
        r154.b(r149);
    L171:
        this.f78075c = true;
        goto L190
    L172:
        ALogger.e("CommonMicWidgetManager", "playSeatCrownAnim error, dressId " + r113 + " userId " + r134);
        a(r113, r136, r138);
    L159:
        r148 = null;
        goto L160
    L150:
        r213 = UriProtector.parse(r145);
    L146:
        r145 = null;
        goto L148
    L140:
        r142 = false;
        goto L141
    L128:
        if (r137.intValue() != 2) goto L129;
    L130:
        r138 = false;
        goto L131
    L173:
        if (r210 == null) goto L177;
        String r155 = r210.h();
        if (r155 == null) goto L177;
        r113 = r155;
    L177:
        if (r210 == null) goto L179;
        String r156 = r210.j();
    L180:
        if (r211 == false) goto L189;
        if (r210 == null) goto L183;
        Integer r157 = r210.m();
    L184:
        if (r157 != null) goto L187;
    L188:
        r103 = true;
        goto L189
    L187:
        if (r157.intValue() == 2) goto L189;
    L183:
        r157 = null;
    L189:
        a(r113, r156, r103);
        goto L190
    L179:
        r156 = null;
        goto L180
    L116:
        r133 = null;
        goto L118
    L99:
        r129 = null;
    L74:
        r124 = null;
        goto L75
    L25:
        r109 = null;
        goto L27
    L5:
        r102 = null;
        goto L6
    }

    public b(ViewGroup r100, ke0.a r101, boolean r102, xg0.a r103) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f78081i = r100;
        this.f78082j = r101;
        this.f78083k = r103;
        this.f78073a = (HSImageView) r100.findViewById(R.id.ttlive_avatar_right_top_widget);
        this.f78074b = (ViewGroup) r100.findViewById(R.id.ttlive_avatar_right_top_widget_container);
        View r104 = r100.findViewById(R.id.guide_content_view_point);
        if (r104 == null) goto L6;
        r104.post(new a(this, r104));
        return;
    }
}
