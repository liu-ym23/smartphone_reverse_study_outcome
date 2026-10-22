package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/generated/BffLinkStatus;", "", "wsConnected", "", "authed", AppAgent.CONSTRUCT, "(ZZ)V", "getWsConnected", "()Z", "getAuthed", "ready", "getReady", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BffLinkStatus {
    private final boolean authed;
    private final boolean wsConnected;

    /* JADX WARN: Illegal instructions before constructor call */
    public BffLinkStatus() {
        boolean z10 = false;
        this(z10, z10, 3, null);
    }

    public static /* synthetic */ BffLinkStatus copy$default(BffLinkStatus bffLinkStatus, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = bffLinkStatus.wsConnected;
        }
        if ((i & 2) != 0) {
            z11 = bffLinkStatus.authed;
        }
        return bffLinkStatus.copy(z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getWsConnected() {
        return this.wsConnected;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAuthed() {
        return this.authed;
    }

    public final BffLinkStatus copy(boolean wsConnected, boolean authed) {
        return new BffLinkStatus(wsConnected, authed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffLinkStatus)) {
            return false;
        }
        BffLinkStatus bffLinkStatus = (BffLinkStatus) other;
        return this.wsConnected == bffLinkStatus.wsConnected && this.authed == bffLinkStatus.authed;
    }

    public final boolean getAuthed() {
        return this.authed;
    }

    public final boolean getReady() {
        return this.wsConnected && this.authed;
    }

    public final boolean getWsConnected() {
        return this.wsConnected;
    }

    public int hashCode() {
        return Boolean.hashCode(this.authed) + (Boolean.hashCode(this.wsConnected) * 31);
    }

    public String toString() {
        return "BffLinkStatus(wsConnected=" + this.wsConnected + ", authed=" + this.authed + ")";
    }

    public BffLinkStatus(boolean z10, boolean z11) {
        this.wsConnected = z10;
        this.authed = z11;
    }

    public /* synthetic */ BffLinkStatus(boolean z10, boolean z11, int i, e eVar) {
        this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? false : z11);
    }
}
