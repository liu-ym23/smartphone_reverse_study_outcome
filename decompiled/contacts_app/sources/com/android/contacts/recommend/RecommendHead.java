package com.android.contacts.recommend;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendHead extends BaseFlowAdapter.FlowEntry {
    public static final Parcelable.Creator<RecommendHead> CREATOR = null;
    public int headIndex;
    public CharSequence itemText;

    public RecommendHead(CharSequence r2, int r3) {
        super(0);
        this.itemText = r2;
        this.headIndex = r3;
    }

    public RecommendHead(Parcel r1) {
        super(r1);
        this.headIndex = r1.readInt();
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter.FlowEntry
    public int getHeadIndex() {
        return this.headIndex;
    }

    public String toString() {
        return "[RecommendHead: type=" + getItemType() + ", headIndex=" + this.headIndex + ", headText=" + this.itemText + "]";
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter.FlowEntry, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.headIndex);
    }
}
