package com.stepos.ailauncher.contract.api.homegesture;

import M5.b;
import Y8.t;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH&¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010\u001eJ\u001f\u0010&\u001a\u00020\u00062\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H&¢\u0006\u0004\b(\u0010\u001eJ\u0017\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010\nJ\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010\n¨\u0006+À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/IHomeGestureCoordinator;", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "strategy", "LY8/t;", "registerRoot", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;)V", "unregisterRoot", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "handle", "registerPopup", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;)V", "", "layerId", "unregisterPopup", "(Ljava/lang/String;)V", "registerSheet", "unregisterSheet", "reason", "notifyTopologyChanged", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "currentSnapshot", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "snapshot", "beginPeek", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "endPeek", "()V", "", "expectedGeneration", "consume", "(J)V", "notifyConsumeStarted", "Lkotlin/Function0;", "listener", "setOnConsumeStarted", "(Lp9/a;)V", "dismissPopupsForRecents", "suspendPartition", "resumePartition", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IHomeGestureCoordinator {
    void beginPeek(HomeGestureEligibilitySnapshot snapshot);

    void consume(long expectedGeneration);

    HomeGestureEligibilitySnapshot currentSnapshot();

    void dismissPopupsForRecents();

    void endPeek();

    void notifyConsumeStarted();

    void notifyTopologyChanged(String reason);

    void registerPopup(HomeLayerHandle handle);

    void registerRoot(HomeRootToken token, RootStrategy strategy);

    void registerSheet(HomeLayerHandle handle);

    void resumePartition(HomeRootToken token);

    void setOnConsumeStarted(InterfaceC5063a<t> listener);

    void suspendPartition(HomeRootToken token);

    void unregisterPopup(String layerId);

    void unregisterRoot(HomeRootToken token);

    void unregisterSheet(String layerId);
}
