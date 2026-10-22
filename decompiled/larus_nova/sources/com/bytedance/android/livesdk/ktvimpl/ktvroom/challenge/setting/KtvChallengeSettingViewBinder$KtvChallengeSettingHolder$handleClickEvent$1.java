package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeSettingViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$handleClickEvent$1 extends FunctionReferenceImpl implements Function2<Integer, Long, Unit> {
    public KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$handleClickEvent$1(KtvChallengeSettingViewBinder.KtvChallengeSettingHolder r100) {
        super(2, r100, KtvChallengeSettingViewBinder.KtvChallengeSettingHolder.class, "updateCustomTargetSetting", "updateCustomTargetSetting(IJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Long r101) {
        invoke(r100.intValue(), r101.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, long r101) {
        KtvChallengeSettingViewModel r102 = ((KtvChallengeSettingViewBinder.KtvChallengeSettingHolder) this.receiver).f144589b.f144587b;
        if (r102 == null) goto L6;
        r102.updateChallengeTargetValue(r100, r101);
        return;
    }
}
