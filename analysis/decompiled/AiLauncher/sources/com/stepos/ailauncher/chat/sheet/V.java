package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/V;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "<init>", "()V", "", "isShowing", "()Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "reason", DidiCardProvider.ACTION_DISMISS, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;)Z", "suspendForPeek", "resumeAfterPeek", "", "layerId", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "kind", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "getKind", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V implements HomeLayerHandle {
    public static final String LAYER_ID = "external-ui-cover";
    private final String layerId = LAYER_ID;
    private final HomeRootToken rootToken = HomeRootToken.DESKTOP;
    private final HomeTopKind kind = HomeTopKind.POPUP;

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean dismiss(HomeDismissReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        return DesktopChatResidentController.Z0(reason);
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public HomeTopKind getKind() {
        return this.kind;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public String getLayerId() {
        return this.layerId;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public HomeRootToken getRootToken() {
        return this.rootToken;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public /* bridge */ HomeGroupExitParticipant homeGroupExitParticipant() {
        return super.homeGroupExitParticipant();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean isShowing() {
        return DesktopChatResidentController.T1();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean resumeAfterPeek() {
        return false;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean suspendForPeek() {
        return false;
    }
}
