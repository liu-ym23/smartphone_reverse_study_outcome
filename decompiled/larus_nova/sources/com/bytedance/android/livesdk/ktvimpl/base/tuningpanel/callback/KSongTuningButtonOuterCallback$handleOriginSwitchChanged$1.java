package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lac0/a;", "data", "", AbsMethodDelegate.TAG_INVOKE, "(Lac0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1 extends Lambda implements Function1<ac0.a, Unit> {
    final /* synthetic */ KSongTuningButtonOuterCallback this$0;

    public KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(KSongTuningButtonOuterCallback r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ac0.a r100) {
        if (r100 == null) goto L17;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.this$0.f143476e;
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        r100.f2530c = r102;
        ec0.a r103 = this.this$0.f();
        if (r103 != null) goto L12;
    L14:
        float r104 = 0.5f;
    L15:
        r100.f2532e = r104;
        return;
    L12:
        if (r103.g() != true) goto L14;
        r104 = 1.0f;
        goto L15
    L6:
        if (r101.R() != true) goto L8;
        r102 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ac0.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
