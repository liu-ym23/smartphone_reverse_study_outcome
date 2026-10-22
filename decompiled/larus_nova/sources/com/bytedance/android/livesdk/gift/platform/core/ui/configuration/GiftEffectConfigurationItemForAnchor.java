package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.android.livesdk.widget.x0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftEffectConfigurationItemForAnchor implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f131950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GiftEffectConfigurationViewModelForAnchor f131951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f131952c;

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final List<i> a() {
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1 r100 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$3 r101 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$4 r102 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$4(this);
        GiftEffectSwitchConfigType r110 = GiftEffectSwitchConfigType.EffectGame;
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$1 r103 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$2 r104 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$2(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$3 r105 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$3(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$1 r106 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3 r107 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$4 r108 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$4(this);
        GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1 r109 = GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1.INSTANCE;
        final GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$3 r111 = new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$4 r112 = new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$4(this);
        return CollectionsKt.listOf(new i[]{new i(r110, "接收玩法礼物", new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$5(r100), new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$6(r101), this.f131950a, new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$7(r102), "玩法礼物说明"), new i(GiftEffectSwitchConfigType.StickerGiftSwitch, "展示人脸礼物特效", new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$4(r103), new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$5(r105), this.f131950a, new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$6(r104), "人脸礼物说明"), new i(r110, "展示角色技能特效", new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$5(r106), new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$6(r107), this.f131950a, new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$7(r108), "角色技能特效说明"), new i(GiftEffectSwitchConfigType.NormalGiftSwitch, "主播侧展示普通礼物特效", GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$5.INSTANCE, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$6(r111), this.f131950a, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$7(r112), "普通礼物特效说明"), GiftEffectConfigurationCommonItemKt.a(this.f131952c, true, new GiftEffectConfigurationItemForAnchor$loadGiftEffectConfigurationItems$1(this))});
    }

    public GiftEffectConfigurationItemForAnchor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f131952c = r100;
        if (((String) a.f131962d.getValue(null, a.f131959a[2])).length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.f131950a = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final void b(GiftEffectConfigurationViewModelForAnchor r100) {
        this.f131951b = r100;
    }

    public static final void c(GiftEffectConfigurationItemForAnchor r100, String r101) {
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        HashMap r103 = new HashMap();     // Catch: Throwable -> L17
        r103.put("gift_switch_type", r101);     // Catch: Throwable -> L17
        GiftEffectConfigurationViewModelForAnchor r104 = r100.f131951b;     // Catch: Throwable -> L17
        boolean r105 = true;
        if (r104 != null) goto L6;
    L8:
        String r106 = "live_now_page";
    L9:
        r103.put("request_page", r106);     // Catch: Throwable -> L17
        String r107 = (String) a.f131962d.getValue(null, a.f131959a[2]);     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftEffectConfiguration", "openEffectIntroDialog " + r101 + ", schema [" + r107 + ']');     // Catch: Throwable -> L17
        if (r107.length() > 0) goto L13;
        r105 = false;
    L13:
        if (r105 == false) goto L15;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(s1.getContext(), u.b(r107, r103));     // Catch: Throwable -> L17
    L15:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L25;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftEffectConfiguration", "openEffectIntroDialog error, " + r101 + ", " + Log.getStackTraceString(r109));
        return;
    L25:
        return;
    L6:
        if (r104.isBeforeLive() != true) goto L8;
        r106 = "open_live_page";
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static final void d(GiftEffectConfigurationItemForAnchor r100, String r101, Function1 r102) {
        r100.getClass();
        Context r103 = r100.f131952c;
        x0.d r104 = new x0.d();
        r104.f162243b = r103;
        r104.f162242a = 0;
        r104.f162242a = 4;
        r104.f162245d = r101;
        j r105 = new j(r102);
        x0.c[] r106 = r104.f162248g;
        x0.c r107 = r106[0];
        if (r107 != null) goto L5;
        r107 = new x0.c();
        r106[0] = r107;
    L5:
        r107.f162239a = "确认关闭";
        r107.f162240b = r105;
        k r108 = new k(r102);
        x0.c[] r109 = r104.f162248g;
        x0.c r110 = r109[1];
        if (r110 != null) goto L8;
        r110 = new x0.c();
        r109[1] = r110;
    L8:
        r110.f162239a = "取消";
        r110.f162240b = r108;
        r104.f162249h = new l(r102);
        x0.b.g(new x0(r104.f162243b, r104));
    }
}
