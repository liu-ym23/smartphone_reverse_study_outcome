package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/r;", "", "", "assetId", "displayName", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "entrySource", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/stepos/ailauncher/chat/wake/ChatEntrySource;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Z", Const.INTENT_KEY_UMID, "()Z", "Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "c", "()Lcom/stepos/ailauncher/chat/wake/ChatEntrySource;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.r, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstalledAgentRef {
    private final String assetId;
    private final String displayName;
    private final ChatEntrySource entrySource;
    private final boolean online;

    public InstalledAgentRef(String assetId, String displayName, boolean z10, ChatEntrySource entrySource) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(entrySource, "entrySource");
        this.assetId = assetId;
        this.displayName = displayName;
        this.online = z10;
        this.entrySource = entrySource;
    }

    /* renamed from: a, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: c, reason: from getter */
    public final ChatEntrySource getEntrySource() {
        return this.entrySource;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledAgentRef)) {
            return false;
        }
        InstalledAgentRef installedAgentRef = (InstalledAgentRef) other;
        return kotlin.jvm.internal.p.d(this.assetId, installedAgentRef.assetId) && kotlin.jvm.internal.p.d(this.displayName, installedAgentRef.displayName) && this.online == installedAgentRef.online && this.entrySource == installedAgentRef.entrySource;
    }

    public int hashCode() {
        return (((((this.assetId.hashCode() * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.online)) * 31) + this.entrySource.hashCode();
    }

    public String toString() {
        return "InstalledAgentRef(assetId=" + this.assetId + ", displayName=" + this.displayName + ", online=" + this.online + ", entrySource=" + this.entrySource + ")";
    }
}
