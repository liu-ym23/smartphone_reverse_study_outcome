package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f131960b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f131961c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f131962d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "stickerDialogContent", "getStickerDialogContent()Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/StickerDialogTipContent;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "stickerCloseDialogContent", "getStickerCloseDialogContent()Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/StickerDialogTipContent;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_INTRO_SCHEMA", "getLIVE_GIFT_EFFECT_INTRO_SCHEMA()Ljava/lang/String;", 1))};
        f131959a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sticker_gift_information_popup_dialog_configuration", new q("人脸礼物说明", "人脸礼物是指跟随主播脸部/肢体的礼物，包括：1）墨镜/亲吻等礼物 ；2）装饰礼物；3）大多数互动礼物等。"), q.class, false);
        f131960b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sticker_close_gift_information_popup_dialog_configuration", new q("关闭人脸礼物", "关闭后，观众将看不到赠送的人脸礼物特效，是否确认关闭？"), q.class, false);
        f131961c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_intro_schema", "", String.class, false);
        f131962d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
    }
}
