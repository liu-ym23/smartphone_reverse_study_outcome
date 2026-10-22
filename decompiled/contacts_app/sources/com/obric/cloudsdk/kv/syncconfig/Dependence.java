package com.obric.cloudsdk.kv.syncconfig;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Dependence.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/cloudsdk/kv/syncconfig/Dependence;", "", "column", "", "dependenceTable", "dependenceColumn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColumn", "()Ljava/lang/String;", "getDependenceColumn", "getDependenceTable", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Dependence {

    @SerializedName("column")
    private final String column;

    @SerializedName("dependence_column")
    private final String dependenceColumn;

    @SerializedName("dependence_table")
    private final String dependenceTable;

    public static /* synthetic */ Dependence copy$default(Dependence r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.column;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.dependenceTable;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.dependenceColumn;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.column;
    }

    public final String component2() {
        return this.dependenceTable;
    }

    public final String component3() {
        return this.dependenceColumn;
    }

    public final Dependence copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "column");
        Intrinsics.checkNotNullParameter(r2, "dependenceTable");
        Intrinsics.checkNotNullParameter(r3, "dependenceColumn");
        return new Dependence(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Dependence) == true) goto L8;
        return false;
    L8:
        Dependence r6 = (Dependence) r5;
        if (Intrinsics.areEqual(this.column, r6.column) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dependenceTable, r6.dependenceTable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dependenceColumn, r6.dependenceColumn) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.column.hashCode() * 31) + this.dependenceTable.hashCode()) * 31) + this.dependenceColumn.hashCode();
    }

    public Dependence(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "column");
        Intrinsics.checkNotNullParameter(r3, "dependenceTable");
        Intrinsics.checkNotNullParameter(r4, "dependenceColumn");
        this.column = r2;
        this.dependenceTable = r3;
        this.dependenceColumn = r4;
    }

    public final String getColumn() {
        return this.column;
    }

    public final String getDependenceTable() {
        return this.dependenceTable;
    }

    public final String getDependenceColumn() {
        return this.dependenceColumn;
    }

    public String toString() {
        return "Dependence(column='" + this.column + "', dependenceTable='" + this.dependenceTable + "', dependenceColumn='" + this.dependenceColumn + "')";
    }
}
