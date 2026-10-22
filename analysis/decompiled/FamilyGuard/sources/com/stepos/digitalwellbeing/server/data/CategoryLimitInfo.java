package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.limit.data.room.CategoryLimit;
import com.stepos.familyguard.db.entity.CategoryLimitCache;

/* loaded from: classes.dex */
public class CategoryLimitInfo extends LimitInfo {
    public static final Parcelable.Creator<CategoryLimitInfo> CREATOR = new a();
    private int mCategoryId;

    class a implements Parcelable.Creator<CategoryLimitInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CategoryLimitInfo createFromParcel(Parcel parcel) {
            return new CategoryLimitInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CategoryLimitInfo[] newArray(int i5) {
            return new CategoryLimitInfo[i5];
        }
    }

    public CategoryLimitInfo(int i5, long j5, long j6, long j7, long j8, boolean z5, boolean z6, int i6) {
        super(i5, j5, j6, j7, j8, z5, z6, true);
        setCategoryId(i6);
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(int i5) {
        this.mCategoryId = i5;
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo
    public String toString() {
        String string = super.toString();
        int length = string.length();
        return new StringBuilder(string).replace(length - 2, length, ", mCategoryId " + getCategoryId() + "}").toString();
    }

    @Override // com.stepos.digitalwellbeing.server.data.LimitInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(getCategoryId());
    }

    public CategoryLimitInfo(CategoryLimitCache categoryLimitCache) {
        this(categoryLimitCache.toCategoryLimit(), categoryLimitCache.getLastHandleTime());
    }

    public CategoryLimitInfo(CategoryLimit categoryLimit, long j5) {
        super(categoryLimit.getInterval(), j5, 0L, categoryLimit.getWorkdayLimit(), categoryLimit.getOffDayLimit(), categoryLimit.isEnable(), categoryLimit.isNotifyOnly(), true);
        setCategoryId(categoryLimit.getCategoryId());
    }

    protected CategoryLimitInfo(Parcel parcel) {
        super(parcel);
        setCategoryId(parcel.readInt());
    }
}
