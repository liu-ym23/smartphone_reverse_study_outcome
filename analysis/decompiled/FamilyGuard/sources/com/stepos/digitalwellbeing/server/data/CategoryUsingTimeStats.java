package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CategoryUsingTimeStats extends UsingTimeStats {
    public static final Parcelable.Creator<CategoryUsingTimeStats> CREATOR = new a();
    private int mCategoryId;

    class a implements Parcelable.Creator<CategoryUsingTimeStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CategoryUsingTimeStats createFromParcel(Parcel parcel) {
            return new CategoryUsingTimeStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CategoryUsingTimeStats[] newArray(int i5) {
            return new CategoryUsingTimeStats[i5];
        }
    }

    public CategoryUsingTimeStats() {
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(int i5) {
        this.mCategoryId = i5;
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mCategoryId = " + getCategoryId() + "}").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(getCategoryId());
    }

    public CategoryUsingTimeStats(int i5, long j5, long j6, long j7, int i6) {
        super(i5, j5, j6, j7);
        setCategoryId(i6);
    }

    protected CategoryUsingTimeStats(Parcel parcel) {
        super(parcel);
        setCategoryId(parcel.readInt());
    }
}
