package com.stepos.ailauncher.chat.panelui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/e;", "", "", "isShowing", "()Z", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "c", "(JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)Z", "expectedPhase", Const.INTENT_KEY_UMID, "f", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "reason", "e", "(Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)Z", "", "getLayerId", "()Ljava/lang/String;", "layerId", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "ownerKey", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface e {
    Object a();

    PanelHomePolicy b();

    boolean c(long transitionId, PanelLayerRecentsPhase phase);

    boolean d(long transitionId, PanelLayerRecentsPhase expectedPhase);

    boolean e(PanelLayerDismissReason reason);

    boolean f();

    String getLayerId();

    boolean isShowing();
}
