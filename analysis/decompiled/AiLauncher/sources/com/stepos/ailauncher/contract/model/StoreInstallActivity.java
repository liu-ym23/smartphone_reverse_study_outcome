package com.stepos.ailauncher.contract.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;", "", "installingCount", "", "succeededCount", "agentListRevision", "agentInstalledCount", "testingAgentActivityCount", "<init>", "(IIIII)V", "getInstallingCount", "()I", "getSucceededCount", "getAgentListRevision", "getAgentInstalledCount", "getTestingAgentActivityCount", "installing", "", "getInstalling", "()Z", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StoreInstallActivity {
    private final int agentInstalledCount;
    private final int agentListRevision;
    private final int installingCount;
    private final int succeededCount;
    private final int testingAgentActivityCount;

    public StoreInstallActivity() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ StoreInstallActivity copy$default(StoreInstallActivity storeInstallActivity, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = storeInstallActivity.installingCount;
        }
        if ((i15 & 2) != 0) {
            i11 = storeInstallActivity.succeededCount;
        }
        if ((i15 & 4) != 0) {
            i12 = storeInstallActivity.agentListRevision;
        }
        if ((i15 & 8) != 0) {
            i13 = storeInstallActivity.agentInstalledCount;
        }
        if ((i15 & 16) != 0) {
            i14 = storeInstallActivity.testingAgentActivityCount;
        }
        int i16 = i14;
        int i17 = i12;
        return storeInstallActivity.copy(i10, i11, i17, i13, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getInstallingCount() {
        return this.installingCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSucceededCount() {
        return this.succeededCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAgentListRevision() {
        return this.agentListRevision;
    }

    /* renamed from: component4, reason: from getter */
    public final int getAgentInstalledCount() {
        return this.agentInstalledCount;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTestingAgentActivityCount() {
        return this.testingAgentActivityCount;
    }

    public final StoreInstallActivity copy(int installingCount, int succeededCount, int agentListRevision, int agentInstalledCount, int testingAgentActivityCount) {
        return new StoreInstallActivity(installingCount, succeededCount, agentListRevision, agentInstalledCount, testingAgentActivityCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreInstallActivity)) {
            return false;
        }
        StoreInstallActivity storeInstallActivity = (StoreInstallActivity) other;
        return this.installingCount == storeInstallActivity.installingCount && this.succeededCount == storeInstallActivity.succeededCount && this.agentListRevision == storeInstallActivity.agentListRevision && this.agentInstalledCount == storeInstallActivity.agentInstalledCount && this.testingAgentActivityCount == storeInstallActivity.testingAgentActivityCount;
    }

    public final int getAgentInstalledCount() {
        return this.agentInstalledCount;
    }

    public final int getAgentListRevision() {
        return this.agentListRevision;
    }

    public final boolean getInstalling() {
        return this.installingCount > 0;
    }

    public final int getInstallingCount() {
        return this.installingCount;
    }

    public final int getSucceededCount() {
        return this.succeededCount;
    }

    public final int getTestingAgentActivityCount() {
        return this.testingAgentActivityCount;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.installingCount) * 31) + Integer.hashCode(this.succeededCount)) * 31) + Integer.hashCode(this.agentListRevision)) * 31) + Integer.hashCode(this.agentInstalledCount)) * 31) + Integer.hashCode(this.testingAgentActivityCount);
    }

    public String toString() {
        return "StoreInstallActivity(installingCount=" + this.installingCount + ", succeededCount=" + this.succeededCount + ", agentListRevision=" + this.agentListRevision + ", agentInstalledCount=" + this.agentInstalledCount + ", testingAgentActivityCount=" + this.testingAgentActivityCount + ")";
    }

    public StoreInstallActivity(int i10, int i11, int i12, int i13, int i14) {
        this.installingCount = i10;
        this.succeededCount = i11;
        this.agentListRevision = i12;
        this.agentInstalledCount = i13;
        this.testingAgentActivityCount = i14;
    }

    public /* synthetic */ StoreInstallActivity(int i10, int i11, int i12, int i13, int i14, int i15, i iVar) {
        this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
    }
}
