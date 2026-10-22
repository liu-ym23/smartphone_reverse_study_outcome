package com.stepos.datacenter.vector;

import Z8.C1173v;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/stepos/datacenter/vector/MaintenanceReport;", "", "flushedCollections", "", "quarantineFilesPruned", "unhealthyCollections", "", "", "algorithmMismatches", "algorithmSwitchedAuto", "algorithmSwitchFailures", "<init>", "(IILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFlushedCollections", "()I", "getQuarantineFilesPruned", "getUnhealthyCollections", "()Ljava/util/List;", "getAlgorithmMismatches", "getAlgorithmSwitchedAuto", "getAlgorithmSwitchFailures", "hasIssues", "", "getHasIssues", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MaintenanceReport {
    private final List<String> algorithmMismatches;
    private final List<String> algorithmSwitchFailures;
    private final List<String> algorithmSwitchedAuto;
    private final int flushedCollections;
    private final int quarantineFilesPruned;
    private final List<String> unhealthyCollections;

    public MaintenanceReport() {
        this(0, 0, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MaintenanceReport copy$default(MaintenanceReport maintenanceReport, int i10, int i11, List list, List list2, List list3, List list4, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = maintenanceReport.flushedCollections;
        }
        if ((i12 & 2) != 0) {
            i11 = maintenanceReport.quarantineFilesPruned;
        }
        if ((i12 & 4) != 0) {
            list = maintenanceReport.unhealthyCollections;
        }
        if ((i12 & 8) != 0) {
            list2 = maintenanceReport.algorithmMismatches;
        }
        if ((i12 & 16) != 0) {
            list3 = maintenanceReport.algorithmSwitchedAuto;
        }
        if ((i12 & 32) != 0) {
            list4 = maintenanceReport.algorithmSwitchFailures;
        }
        List list5 = list3;
        List list6 = list4;
        return maintenanceReport.copy(i10, i11, list, list2, list5, list6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFlushedCollections() {
        return this.flushedCollections;
    }

    /* renamed from: component2, reason: from getter */
    public final int getQuarantineFilesPruned() {
        return this.quarantineFilesPruned;
    }

    public final List<String> component3() {
        return this.unhealthyCollections;
    }

    public final List<String> component4() {
        return this.algorithmMismatches;
    }

    public final List<String> component5() {
        return this.algorithmSwitchedAuto;
    }

    public final List<String> component6() {
        return this.algorithmSwitchFailures;
    }

    public final MaintenanceReport copy(int flushedCollections, int quarantineFilesPruned, List<String> unhealthyCollections, List<String> algorithmMismatches, List<String> algorithmSwitchedAuto, List<String> algorithmSwitchFailures) {
        p.i(unhealthyCollections, "unhealthyCollections");
        p.i(algorithmMismatches, "algorithmMismatches");
        p.i(algorithmSwitchedAuto, "algorithmSwitchedAuto");
        p.i(algorithmSwitchFailures, "algorithmSwitchFailures");
        return new MaintenanceReport(flushedCollections, quarantineFilesPruned, unhealthyCollections, algorithmMismatches, algorithmSwitchedAuto, algorithmSwitchFailures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaintenanceReport)) {
            return false;
        }
        MaintenanceReport maintenanceReport = (MaintenanceReport) other;
        return this.flushedCollections == maintenanceReport.flushedCollections && this.quarantineFilesPruned == maintenanceReport.quarantineFilesPruned && p.d(this.unhealthyCollections, maintenanceReport.unhealthyCollections) && p.d(this.algorithmMismatches, maintenanceReport.algorithmMismatches) && p.d(this.algorithmSwitchedAuto, maintenanceReport.algorithmSwitchedAuto) && p.d(this.algorithmSwitchFailures, maintenanceReport.algorithmSwitchFailures);
    }

    public final List<String> getAlgorithmMismatches() {
        return this.algorithmMismatches;
    }

    public final List<String> getAlgorithmSwitchFailures() {
        return this.algorithmSwitchFailures;
    }

    public final List<String> getAlgorithmSwitchedAuto() {
        return this.algorithmSwitchedAuto;
    }

    public final int getFlushedCollections() {
        return this.flushedCollections;
    }

    public final boolean getHasIssues() {
        return (this.unhealthyCollections.isEmpty() && this.algorithmSwitchFailures.isEmpty()) ? false : true;
    }

    public final int getQuarantineFilesPruned() {
        return this.quarantineFilesPruned;
    }

    public final List<String> getUnhealthyCollections() {
        return this.unhealthyCollections;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.flushedCollections) * 31) + Integer.hashCode(this.quarantineFilesPruned)) * 31) + this.unhealthyCollections.hashCode()) * 31) + this.algorithmMismatches.hashCode()) * 31) + this.algorithmSwitchedAuto.hashCode()) * 31) + this.algorithmSwitchFailures.hashCode();
    }

    public String toString() {
        return "MaintenanceReport(flushedCollections=" + this.flushedCollections + ", quarantineFilesPruned=" + this.quarantineFilesPruned + ", unhealthyCollections=" + this.unhealthyCollections + ", algorithmMismatches=" + this.algorithmMismatches + ", algorithmSwitchedAuto=" + this.algorithmSwitchedAuto + ", algorithmSwitchFailures=" + this.algorithmSwitchFailures + ")";
    }

    public MaintenanceReport(int i10, int i11, List<String> unhealthyCollections, List<String> algorithmMismatches, List<String> algorithmSwitchedAuto, List<String> algorithmSwitchFailures) {
        p.i(unhealthyCollections, "unhealthyCollections");
        p.i(algorithmMismatches, "algorithmMismatches");
        p.i(algorithmSwitchedAuto, "algorithmSwitchedAuto");
        p.i(algorithmSwitchFailures, "algorithmSwitchFailures");
        this.flushedCollections = i10;
        this.quarantineFilesPruned = i11;
        this.unhealthyCollections = unhealthyCollections;
        this.algorithmMismatches = algorithmMismatches;
        this.algorithmSwitchedAuto = algorithmSwitchedAuto;
        this.algorithmSwitchFailures = algorithmSwitchFailures;
    }

    public /* synthetic */ MaintenanceReport(int i10, int i11, List list, List list2, List list3, List list4, int i12, i iVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? C1173v.m() : list, (i12 & 8) != 0 ? C1173v.m() : list2, (i12 & 16) != 0 ? C1173v.m() : list3, (i12 & 32) != 0 ? C1173v.m() : list4);
    }
}
