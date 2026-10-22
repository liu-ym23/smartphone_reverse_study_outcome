package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.limit.data.room.RawPeriod;
import com.stepos.familyguard.db.entity.RawPeriodCache;
import f2.C0711p;
import java.util.Comparator;

/* loaded from: classes.dex */
public class RawPeriodInfo implements Parcelable {
    public static final Parcelable.Creator<RawPeriodInfo> CREATOR = new a();
    public static final long DEFAULT_END_TIME = 21600000;
    public static final long DEFAULT_START_TIME = 79200000;
    public static final int DEFAULT_WEEK_DAY_TYPE = 1;
    public static final long MINOR_DEFAULT_END_TIME = 21600000;
    public static final long MINOR_DEFAULT_START_TIME = 79200000;
    public static final int MINOR_DEFAULT_WEEK_DAY_TYPE = 0;
    private static final String TAG = "RawPeriodInfo";
    private long end;
    private long id;
    private long limitId;
    private long start;
    private int weekDayType;

    class a implements Parcelable.Creator<RawPeriodInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RawPeriodInfo createFromParcel(Parcel parcel) {
            return new RawPeriodInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RawPeriodInfo[] newArray(int i5) {
            return new RawPeriodInfo[i5];
        }
    }

    public static class b implements Comparator<RawPeriodInfo> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RawPeriodInfo rawPeriodInfo, RawPeriodInfo rawPeriodInfo2) {
            return (int) (rawPeriodInfo.getId() - rawPeriodInfo2.getId());
        }
    }

    public RawPeriodInfo() {
    }

    public static RawPeriodInfo getDefault() {
        return new RawPeriodInfo(1, 79200000L, 21600000L);
    }

    public static RawPeriodInfo getMinorDefault() {
        return new RawPeriodInfo(0, 79200000L, 21600000L);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof RawPeriodInfo)) {
            RawPeriodInfo rawPeriodInfo = (RawPeriodInfo) obj;
            if (this.start == rawPeriodInfo.start && this.end == rawPeriodInfo.end && this.weekDayType == rawPeriodInfo.weekDayType) {
                return true;
            }
        }
        return false;
    }

    public long getEnd() {
        return this.end;
    }

    public long getId() {
        return this.id;
    }

    public long getLimitId() {
        return this.limitId;
    }

    public long getStart() {
        return this.start;
    }

    public int getWeekDayType() {
        return this.weekDayType;
    }

    public void setEnd(long j5) {
        this.end = j5;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setLimitId(long j5) {
        this.limitId = j5;
    }

    public void setStart(long j5) {
        this.start = j5;
    }

    public void setWeekDayType(int i5) {
        this.weekDayType = i5;
    }

    public String toString() {
        return "RawPeriodInfo{id=" + this.id + ", weekDayType=" + this.weekDayType + ", start=" + C0711p.F(this.start) + ", end=" + C0711p.F(this.end) + ", limitId=" + this.limitId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.id);
        parcel.writeInt(this.weekDayType);
        parcel.writeLong(this.start);
        parcel.writeLong(this.end);
        parcel.writeLong(this.limitId);
    }

    public RawPeriodInfo(RawPeriodInfo rawPeriodInfo) {
        this.id = rawPeriodInfo.getId();
        this.weekDayType = rawPeriodInfo.getWeekDayType();
        this.start = rawPeriodInfo.getStart();
        this.end = rawPeriodInfo.getEnd();
        this.limitId = rawPeriodInfo.getLimitId();
    }

    protected RawPeriodInfo(Parcel parcel) {
        this.id = parcel.readLong();
        this.weekDayType = parcel.readInt();
        this.start = parcel.readLong();
        this.end = parcel.readLong();
        this.limitId = parcel.readLong();
    }

    public RawPeriodInfo(int i5, long j5, long j6) {
        this.weekDayType = i5;
        this.start = j5;
        this.end = j6;
        this.limitId = -1L;
        this.id = 0L;
    }

    public RawPeriodInfo(long j5, int i5, long j6, long j7) {
        this.weekDayType = i5;
        this.start = j6;
        this.end = j7;
        this.id = j5;
    }

    public RawPeriodInfo(long j5, long j6, int i5, long j7, long j8) {
        this.weekDayType = i5;
        this.start = j7;
        this.end = j8;
        this.id = j5;
        this.limitId = j6;
    }

    public RawPeriodInfo(RawPeriod rawPeriod) {
        this(rawPeriod.getId(), rawPeriod.getWeekDayType(), rawPeriod.getStart(), rawPeriod.getEnd());
    }

    public RawPeriodInfo(RawPeriodCache rawPeriodCache) {
        this(rawPeriodCache.getId(), rawPeriodCache.getLimitCacheId(), rawPeriodCache.getWeekDayType(), rawPeriodCache.getStart(), rawPeriodCache.getEnd());
    }
}
