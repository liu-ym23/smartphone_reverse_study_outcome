package com.stepos.datacenter.vector;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/stepos/datacenter/vector/BackendCapabilities;", "", "", "multiIndex", "collectionPersistence", "diagnostics", "quarantine", "<init>", "(ZZZZ)V", "component1", "()Z", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(ZZZZ)Lcom/stepos/datacenter/vector/BackendCapabilities;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getMultiIndex", "getCollectionPersistence", "getDiagnostics", "getQuarantine", "Companion", Const.INTENT_KEY_APIKEY, "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BackendCapabilities {
    private final boolean collectionPersistence;
    private final boolean diagnostics;
    private final boolean multiIndex;
    private final boolean quarantine;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BackendCapabilities MINIMAL = new BackendCapabilities(false, false, false, false, 15, null);
    private static final BackendCapabilities ALL = new BackendCapabilities(true, true, true, true);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/datacenter/vector/BackendCapabilities$a;", "", "<init>", "()V", "Lcom/stepos/datacenter/vector/BackendCapabilities;", "ALL", "Lcom/stepos/datacenter/vector/BackendCapabilities;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/datacenter/vector/BackendCapabilities;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.BackendCapabilities$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final BackendCapabilities a() {
            return BackendCapabilities.ALL;
        }

        public Companion() {
        }
    }

    public BackendCapabilities() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ BackendCapabilities copy$default(BackendCapabilities backendCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = backendCapabilities.multiIndex;
        }
        if ((i10 & 2) != 0) {
            z11 = backendCapabilities.collectionPersistence;
        }
        if ((i10 & 4) != 0) {
            z12 = backendCapabilities.diagnostics;
        }
        if ((i10 & 8) != 0) {
            z13 = backendCapabilities.quarantine;
        }
        return backendCapabilities.copy(z10, z11, z12, z13);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getMultiIndex() {
        return this.multiIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCollectionPersistence() {
        return this.collectionPersistence;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDiagnostics() {
        return this.diagnostics;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getQuarantine() {
        return this.quarantine;
    }

    public final BackendCapabilities copy(boolean multiIndex, boolean collectionPersistence, boolean diagnostics, boolean quarantine) {
        return new BackendCapabilities(multiIndex, collectionPersistence, diagnostics, quarantine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackendCapabilities)) {
            return false;
        }
        BackendCapabilities backendCapabilities = (BackendCapabilities) other;
        return this.multiIndex == backendCapabilities.multiIndex && this.collectionPersistence == backendCapabilities.collectionPersistence && this.diagnostics == backendCapabilities.diagnostics && this.quarantine == backendCapabilities.quarantine;
    }

    public final boolean getCollectionPersistence() {
        return this.collectionPersistence;
    }

    public final boolean getDiagnostics() {
        return this.diagnostics;
    }

    public final boolean getMultiIndex() {
        return this.multiIndex;
    }

    public final boolean getQuarantine() {
        return this.quarantine;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.multiIndex) * 31) + Boolean.hashCode(this.collectionPersistence)) * 31) + Boolean.hashCode(this.diagnostics)) * 31) + Boolean.hashCode(this.quarantine);
    }

    public String toString() {
        return "BackendCapabilities(multiIndex=" + this.multiIndex + ", collectionPersistence=" + this.collectionPersistence + ", diagnostics=" + this.diagnostics + ", quarantine=" + this.quarantine + ")";
    }

    public BackendCapabilities(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.multiIndex = z10;
        this.collectionPersistence = z11;
        this.diagnostics = z12;
        this.quarantine = z13;
    }

    public /* synthetic */ BackendCapabilities(boolean z10, boolean z11, boolean z12, boolean z13, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13);
    }
}
