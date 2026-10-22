package com.stepos.ailauncher.contract.api.homegesture;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "", "", "isShowing", "()Z", "prepareForHomeGroupExit", "", "positionPx", "progress", "LY8/t;", "applyHomeGroupExit", "(FF)V", "finishHomeGroupExit", "()V", "cancelHomeGroupExit", "", "getParticipantId", "()Ljava/lang/String;", "participantId", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getVisualStackRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "visualStackRootToken", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HomeGroupExitParticipant {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static HomeRootToken getVisualStackRootToken(HomeGroupExitParticipant homeGroupExitParticipant) {
            return HomeGroupExitParticipant.super.getVisualStackRootToken();
        }
    }

    void applyHomeGroupExit(float positionPx, float progress);

    void cancelHomeGroupExit();

    void finishHomeGroupExit();

    String getParticipantId();

    default HomeRootToken getVisualStackRootToken() {
        return null;
    }

    boolean isShowing();

    boolean prepareForHomeGroupExit();
}
