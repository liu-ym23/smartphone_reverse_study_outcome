package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import f2.C0711p;

/* loaded from: classes.dex */
public class CategoricalUsingTimeStats extends UsingTimeStats {
    public static final Parcelable.Creator<CategoricalUsingTimeStats> CREATOR = new a();
    private static final String TAG = "CategoricalUsingTimeStats";
    private long[] mCategoryUsingArray;

    class a implements Parcelable.Creator<CategoricalUsingTimeStats> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CategoricalUsingTimeStats createFromParcel(Parcel parcel) {
            return new CategoricalUsingTimeStats(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CategoricalUsingTimeStats[] newArray(int i5) {
            return new CategoricalUsingTimeStats[i5];
        }
    }

    public CategoricalUsingTimeStats() {
        this.mCategoryUsingArray = new long[W1.a.d().length];
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    public long[] getCategoryUsingArray() {
        return this.mCategoryUsingArray;
    }

    public void setCategoryUsingArray(long[] jArr) {
        this.mCategoryUsingArray = jArr;
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoricalUsingTimeStats{");
        sb.append(" usingTime=");
        sb.append(C0711p.m(P1.a.a(), getUsingTime()));
        sb.append(" startTime=");
        sb.append(C0711p.h(getStartTime(), true));
        sb.append(" updateTime=");
        sb.append(C0711p.h(getUpdateTime(), true));
        sb.append(" interval=");
        sb.append(getInterval());
        sb.append(" mCategoryUsingArray = [");
        for (int i5 = 0; i5 < this.mCategoryUsingArray.length; i5++) {
            if (i5 > 0) {
                sb.append(",");
            }
            sb.append("{");
            sb.append(P1.a.b(W1.c.m(i5), new Object[0]));
            sb.append(",");
            sb.append(C0711p.m(P1.a.a(), this.mCategoryUsingArray[i5]));
            sb.append("}");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.UsingTimeStats, com.stepos.digitalwellbeing.server.data.StepOSUsageStats, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeLongArray(this.mCategoryUsingArray);
    }

    protected CategoricalUsingTimeStats(Parcel parcel) {
        super(parcel);
        long[] jArr = new long[W1.a.d().length];
        this.mCategoryUsingArray = jArr;
        parcel.readLongArray(jArr);
    }

    public CategoricalUsingTimeStats(int i5, long j5, long j6, long j7, long[] jArr) {
        super(i5, j5, j6, j7);
        long[] jArr2 = new long[W1.a.d().length];
        this.mCategoryUsingArray = jArr;
    }
}
