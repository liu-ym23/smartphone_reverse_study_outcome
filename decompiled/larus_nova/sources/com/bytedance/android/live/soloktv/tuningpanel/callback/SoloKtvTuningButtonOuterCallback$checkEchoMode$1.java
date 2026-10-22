package com.bytedance.android.live.soloktv.tuningpanel.callback;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lac0/a;", "data", "", AbsMethodDelegate.TAG_INVOKE, "(Lac0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SoloKtvTuningButtonOuterCallback$checkEchoMode$1 extends Lambda implements Function1<ac0.a, Unit> {
    final /* synthetic */ Boolean $isWiredHeadsetConnected;
    final /* synthetic */ SoloKtvTuningButtonOuterCallback this$0;

    public SoloKtvTuningButtonOuterCallback$checkEchoMode$1(SoloKtvTuningButtonOuterCallback r100, Boolean r101) {
        this.this$0 = r100;
        this.$isWiredHeadsetConnected = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ac0.a r100) {
        if (r100 == null) goto L9;
        if (Intrinsics.areEqual(this.$isWiredHeadsetConnected, Boolean.TRUE) == false) goto L6;
        float r101 = 1.0f;
    L7:
        r100.f2532e = r101;
        goto L9
    L6:
        r101 = 0.5f;
    L9:
        if (Intrinsics.areEqual(this.$isWiredHeadsetConnected, Boolean.TRUE) == false) goto L15;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r102 = this.this$0.g();
        if (r102 == null) goto L21;
        if (r100 == null) goto L14;
        boolean r103 = r100.f2530c;
    L14:
        r102.k(false);
        return;
    L21:
        return;
    L15:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r104 = this.this$0.g();
        if (r104 == null) goto L23;
        if (r100 == null) goto L19;
        boolean r105 = r100.f2530c;
    L19:
        r104.k(false);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ac0.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
