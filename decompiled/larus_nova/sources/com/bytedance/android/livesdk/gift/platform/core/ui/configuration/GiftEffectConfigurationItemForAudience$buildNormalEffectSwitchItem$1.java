package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.widget.Switch;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"initialCheckStatus", "", "switch", "Landroid/widget/Switch;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1 extends Lambda implements Function1<Switch, Unit> {
    final /* synthetic */ GiftEffectConfigurationItemForAudience this$0;

    public GiftEffectConfigurationItemForAudience$buildNormalEffectSwitchItem$1(GiftEffectConfigurationItemForAudience r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Switch r100) {
        Intrinsics.checkNotNullParameter(r100, "switch");
        if (this.this$0.f131956a == null) goto L5;
        boolean r101 = i2.d();
    L6:
        r100.setChecked(r101);
        return;
    L5:
        r101 = true;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Switch r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
