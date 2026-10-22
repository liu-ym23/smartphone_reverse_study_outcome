package com.stepos.ailauncher.contract.api.homegesture;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "", "prepareSharedOffsetExit", "()Ljava/lang/Float;", "offsetPx", "progress", "LY8/t;", "applySharedOffsetExit", "(FF)V", "Lkotlin/Function0;", "startAnimation", "finishImmediately", "startSharedOffsetExit", "(Lp9/a;Lp9/a;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HomeSharedOffsetExitParticipant extends HomeGroupExitParticipant {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static HomeRootToken getVisualStackRootToken(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant) {
            return HomeSharedOffsetExitParticipant.super.getVisualStackRootToken();
        }

        @Deprecated
        public static void startSharedOffsetExit(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant, InterfaceC5063a<t> startAnimation, InterfaceC5063a<t> finishImmediately) {
            p.i(startAnimation, "startAnimation");
            p.i(finishImmediately, "finishImmediately");
            HomeSharedOffsetExitParticipant.super.startSharedOffsetExit(startAnimation, finishImmediately);
        }
    }

    void applySharedOffsetExit(float offsetPx, float progress);

    Float prepareSharedOffsetExit();

    default void startSharedOffsetExit(InterfaceC5063a<t> startAnimation, InterfaceC5063a<t> finishImmediately) {
        p.i(startAnimation, "startAnimation");
        p.i(finishImmediately, "finishImmediately");
        startAnimation.invoke();
    }
}
