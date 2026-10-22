package com.android.contacts.common.logging;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class SearchState implements Parcelable {
    public static final Parcelable.Creator<SearchState> CREATOR = null;
    public int numPartitions;
    public int numResults;
    public int numResultsInSelectedPartition;
    public int queryLength;
    public int selectedIndex;
    public int selectedIndexInPartition;
    public int selectedPartition;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public SearchState() {
        this.numResultsInSelectedPartition = -1;
        this.selectedPartition = -1;
        this.selectedIndexInPartition = -1;
        this.selectedIndex = -1;
    }

    protected SearchState(Parcel r2) {
        this.numResultsInSelectedPartition = -1;
        this.selectedPartition = -1;
        this.selectedIndexInPartition = -1;
        this.selectedIndex = -1;
        readFromParcel(r2);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("queryLength", this.queryLength).add("numPartitions", this.numPartitions).add("numResults", this.numResults).add("numResultsInSelectedPartition", this.numResultsInSelectedPartition).add("selectedPartition", this.selectedPartition).add("selectedIndexInPartition", this.selectedIndexInPartition).add("selectedIndex", this.selectedIndex).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.queryLength);
        r1.writeInt(this.numPartitions);
        r1.writeInt(this.numResults);
        r1.writeInt(this.numResultsInSelectedPartition);
        r1.writeInt(this.selectedPartition);
        r1.writeInt(this.selectedIndexInPartition);
        r1.writeInt(this.selectedIndex);
    }

    private void readFromParcel(Parcel r2) {
        this.queryLength = r2.readInt();
        this.numPartitions = r2.readInt();
        this.numResults = r2.readInt();
        this.numResultsInSelectedPartition = r2.readInt();
        this.selectedPartition = r2.readInt();
        this.selectedIndexInPartition = r2.readInt();
        this.selectedIndex = r2.readInt();
    }
}
