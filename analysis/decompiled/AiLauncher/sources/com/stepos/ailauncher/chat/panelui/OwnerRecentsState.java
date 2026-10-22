package com.stepos.ailauncher.chat.panelui;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/g;", "", "Ljava/lang/ref/WeakReference;", "ownerKey", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "<init>", "(Ljava/lang/ref/WeakReference;JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/ref/WeakReference;", "J", "c", "()J", "e", "(J)V", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.panelui.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OwnerRecentsState {
    private final WeakReference<Object> ownerKey;
    private PanelLayerRecentsPhase phase;
    private long transitionId;

    public OwnerRecentsState(WeakReference<Object> ownerKey, long j10, PanelLayerRecentsPhase phase) {
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(phase, "phase");
        this.ownerKey = ownerKey;
        this.transitionId = j10;
        this.phase = phase;
    }

    public final WeakReference<Object> a() {
        return this.ownerKey;
    }

    /* renamed from: b, reason: from getter */
    public final PanelLayerRecentsPhase getPhase() {
        return this.phase;
    }

    /* renamed from: c, reason: from getter */
    public final long getTransitionId() {
        return this.transitionId;
    }

    public final void d(PanelLayerRecentsPhase panelLayerRecentsPhase) {
        kotlin.jvm.internal.p.i(panelLayerRecentsPhase, "<set-?>");
        this.phase = panelLayerRecentsPhase;
    }

    public final void e(long j10) {
        this.transitionId = j10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OwnerRecentsState)) {
            return false;
        }
        OwnerRecentsState ownerRecentsState = (OwnerRecentsState) other;
        return kotlin.jvm.internal.p.d(this.ownerKey, ownerRecentsState.ownerKey) && this.transitionId == ownerRecentsState.transitionId && this.phase == ownerRecentsState.phase;
    }

    public int hashCode() {
        return (((this.ownerKey.hashCode() * 31) + Long.hashCode(this.transitionId)) * 31) + this.phase.hashCode();
    }

    public String toString() {
        return "OwnerRecentsState(ownerKey=" + this.ownerKey + ", transitionId=" + this.transitionId + ", phase=" + this.phase + ")";
    }
}
