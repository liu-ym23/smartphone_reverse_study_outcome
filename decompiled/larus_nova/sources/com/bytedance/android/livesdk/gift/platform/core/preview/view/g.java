package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f131093b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "giftInteractGiftPoolSubTitle", "getGiftInteractGiftPoolSubTitle()Ljava/lang/String;", 1))};
        f131092a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_interact_gift_library_hint_text", "添加即可展示在礼物面板“互动”专区", String.class, false);
        f131093b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
