package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onCheckStateChanged", "", "switch", "Landroid/widget/Switch;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ boolean $isAnchor;
    final /* synthetic */ GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 $showCloseEffectConfirmDialog$2;

    public GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$3(boolean r100, GiftEffectConfigurationCommonItemKt$buildSoundAndVibrationSwitchItem$2 r101) {
        this.$isAnchor = r100;
        this.$showCloseEffectConfirmDialog$2 = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Switch r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Switch r100) {
        Intrinsics.checkNotNullParameter(r100, "switch");
        final boolean r101 = r100.isChecked();
        if (r101 == true) goto L12;
        if (this.$isAnchor == false) goto L8;
        this.$showCloseEffectConfirmDialog$2.invoke2(new AnonymousClass1(r100));
        return;
    L8:
        if (((Boolean) ay1.b.W.getValue(null, ay1.b.f16675a[60])).booleanValue() == true) goto L10;
        this.$showCloseEffectConfirmDialog$2.invoke2(new AnonymousClass2(r100, r101));
        return;
    L10:
        int r102 = p.f131989a;
        p.e("gift_voice_switch", Boolean.FALSE);
        GiftEffectConfigurationCommonItemKt.b(r101);
        ay1.b.A(r100.isChecked());
        return;
    L12:
        if (this.$isAnchor == true) goto L14;
        ay1.b.A(true);
        GiftEffectConfigurationCommonItemKt.b(r101);
        int r103 = p.f131989a;
        p.e("gift_voice_switch", Boolean.TRUE);
        return;
    L14:
        ay1.b.B(true);
        int r104 = p.f131989a;
        ClickType r105 = ClickType.GiftVoice;
        p.b(r105, Boolean.TRUE);
        p.c(r105, true, true);
    }
}
