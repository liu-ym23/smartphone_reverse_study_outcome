package com.bytedance.android.live.profile.seeselftransition;

import com.bytedance.android.live.profile.p004enum.ProfileMode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/profile/enum/ProfileMode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2 extends FunctionReferenceImpl implements Function1<ProfileMode, Unit> {
    public NewProfileSeeSelfTransitionDialogLauncher$prepareTransitionDialogRequest$hideToShowDisposable$2(NewProfileSeeSelfTransitionDialogLauncher r100) {
        super(1, r100, NewProfileSeeSelfTransitionDialogLauncher.class, "onRequestError", "onRequestError(Lcom/bytedance/android/live/profile/enum/ProfileMode;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ProfileMode r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        NewProfileSeeSelfTransitionDialogLauncher.b((NewProfileSeeSelfTransitionDialogLauncher) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ProfileMode r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
