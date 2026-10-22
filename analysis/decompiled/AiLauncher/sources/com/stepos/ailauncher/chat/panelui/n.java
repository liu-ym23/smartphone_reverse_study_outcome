package com.stepos.ailauncher.chat.panelui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\rJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/n;", "", "Lcom/stepos/ailauncher/chat/panelui/t;", "visibility", "<init>", "(Lcom/stepos/ailauncher/chat/panelui/t;)V", "", "newTransitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "newPhase", "", "alive", "c", "(JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;Z)Z", "expectedTransitionId", "expectedPhase", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "()Z", "Lcom/stepos/ailauncher/chat/panelui/t;", "transitionId", "J", "phase", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n {
    private PanelLayerRecentsPhase phase;
    private long transitionId;
    private final t visibility;

    public n(t visibility) {
        kotlin.jvm.internal.p.i(visibility, "visibility");
        this.visibility = visibility;
        this.transitionId = -1L;
    }

    public final boolean a() {
        return this.phase != null;
    }

    public final boolean b(long expectedTransitionId, PanelLayerRecentsPhase expectedPhase, boolean alive) {
        kotlin.jvm.internal.p.i(expectedPhase, "expectedPhase");
        if (!alive || this.transitionId != expectedTransitionId || this.phase != expectedPhase || !this.visibility.resume()) {
            return false;
        }
        this.transitionId = -1L;
        this.phase = null;
        return true;
    }

    public final boolean c(long newTransitionId, PanelLayerRecentsPhase newPhase, boolean alive) {
        kotlin.jvm.internal.p.i(newPhase, "newPhase");
        if (!alive) {
            return false;
        }
        if (this.phase != null) {
            this.transitionId = newTransitionId;
            this.phase = newPhase;
            return true;
        }
        if (!this.visibility.a()) {
            return false;
        }
        this.transitionId = newTransitionId;
        this.phase = newPhase;
        return true;
    }
}
