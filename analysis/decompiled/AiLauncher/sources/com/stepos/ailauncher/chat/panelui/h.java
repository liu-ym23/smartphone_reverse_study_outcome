package com.stepos.ailauncher.chat.panelui;

import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/h;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "Lcom/stepos/ailauncher/chat/panelui/e;", "layer", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "<init>", "(Lcom/stepos/ailauncher/chat/panelui/e;Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)V", "", "isShowing", "()Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "reason", DidiCardProvider.ACTION_DISMISS, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;)Z", "suspendForPeek", "resumeAfterPeek", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getRootToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "layerRef", "Ljava/lang/ref/WeakReference;", "", "layerId", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "kind", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "getKind", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h implements HomeLayerHandle {
    private final HomeTopKind kind;
    private final String layerId;
    private final WeakReference<e> layerRef;
    private final HomeRootToken rootToken;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PanelHomePolicy.values().length];
            try {
                iArr[PanelHomePolicy.KEEP_AND_CONSUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PanelHomePolicy.CLEANUP_THEN_PANEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PanelHomePolicy.DISMISS_TOP_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public h(e layer, HomeRootToken rootToken) {
        kotlin.jvm.internal.p.i(layer, "layer");
        kotlin.jvm.internal.p.i(rootToken, "rootToken");
        this.rootToken = rootToken;
        this.layerRef = new WeakReference<>(layer);
        this.layerId = layer.getLayerId();
        this.kind = HomeTopKind.POPUP;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean dismiss(HomeDismissReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        e eVar = this.layerRef.get();
        if (eVar == null) {
            return false;
        }
        if (reason == HomeDismissReason.RECENTS) {
            return eVar.e(PanelLayerDismissReason.OVERVIEW);
        }
        int i10 = a.$EnumSwitchMapping$0[eVar.getHomePolicy().ordinal()];
        if (i10 == 1) {
            C4148a.k("HomePopupRegistrar", "KEEP_AND_CONSUME id=" + eVar.getLayerId(), false, 4, null);
            return true;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return eVar.e(PanelLayerDismissReason.HOME);
            }
            throw new NoWhenBranchMatchedException();
        }
        C4148a.h("HomePopupRegistrar", "CLEANUP_THEN_PANEL forbidden; dismiss top only id=" + eVar.getLayerId(), false, 4, null);
        return eVar.e(PanelLayerDismissReason.HOME);
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
        e eVar = this.layerRef.get();
        return eVar != null && eVar.isShowing();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean resumeAfterPeek() {
        e eVar = this.layerRef.get();
        if (eVar != null) {
            return eVar.d(0L, PanelLayerRecentsPhase.PEEK);
        }
        return false;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle
    public boolean suspendForPeek() {
        e eVar = this.layerRef.get();
        if (eVar != null) {
            return eVar.c(0L, PanelLayerRecentsPhase.PEEK);
        }
        return false;
    }
}
