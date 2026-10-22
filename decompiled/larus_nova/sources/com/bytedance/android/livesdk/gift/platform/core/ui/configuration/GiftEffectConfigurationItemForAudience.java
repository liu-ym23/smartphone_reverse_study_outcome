package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftEffectConfigurationItemForAudience implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2 f131956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f131957b;

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final List<i> a() {
        final GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1 r100 = new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2 r101 = new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$2(this);
        return CollectionsKt.listOf(new i[]{new i(GiftEffectSwitchConfigType.NormalGiftSwitch, "礼物特效", new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$3(r100), new GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$4(r101), false, null, ""), GiftEffectConfigurationCommonItemKt.a(this.f131957b, false, new GiftEffectConfigurationItemForAudience$loadGiftEffectConfigurationItems$1(this))});
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final void b(GiftEffectConfigurationViewModelForAnchor r100) {
    }

    public GiftEffectConfigurationItemForAudience(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f131957b = r100;
        i12.e r101 = i12.o.b();
        if (r101 == null) goto L5;
        Object r102 = com.bytedance.android.scope.m.f163449e.d(r101, i2.class);
    L6:
        this.f131956a = (i2) r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
