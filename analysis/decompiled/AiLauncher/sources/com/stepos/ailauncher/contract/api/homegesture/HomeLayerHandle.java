package com.stepos.ailauncher.contract.api.homegesture;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "", "layerId", "", "getLayerId", "()Ljava/lang/String;", "rootToken", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "kind", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "getKind", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "isShowing", "", DidiCardProvider.ACTION_DISMISS, "reason", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "suspendForPeek", "resumeAfterPeek", "homeGroupExitParticipant", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HomeLayerHandle {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static HomeGroupExitParticipant homeGroupExitParticipant(HomeLayerHandle homeLayerHandle) {
            return HomeLayerHandle.super.homeGroupExitParticipant();
        }

        @Deprecated
        public static boolean resumeAfterPeek(HomeLayerHandle homeLayerHandle) {
            return HomeLayerHandle.super.resumeAfterPeek();
        }

        @Deprecated
        public static boolean suspendForPeek(HomeLayerHandle homeLayerHandle) {
            return HomeLayerHandle.super.suspendForPeek();
        }
    }

    boolean dismiss(HomeDismissReason reason);

    HomeTopKind getKind();

    String getLayerId();

    HomeRootToken getRootToken();

    default HomeGroupExitParticipant homeGroupExitParticipant() {
        return null;
    }

    boolean isShowing();

    default boolean resumeAfterPeek() {
        return false;
    }

    default boolean suspendForPeek() {
        return false;
    }
}
