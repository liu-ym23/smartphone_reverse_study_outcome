package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s.AbstractC0831a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "startTime", "", "endTime", "type", "", "(Ljava/lang/String;JJI)V", "getEndTime", "()J", "setEndTime", "(J)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getStartTime", "setStartTime", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TimeUsage {
    private long endTime;

    @NotNull
    private String packageName;
    private long startTime;
    private int type;

    public TimeUsage(@NotNull String packageName, long j4, long j5, int i4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.startTime = j4;
        this.endTime = j5;
        this.type = i4;
    }

    public static /* synthetic */ TimeUsage copy$default(TimeUsage timeUsage, String str, long j4, long j5, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = timeUsage.packageName;
        }
        if ((i5 & 2) != 0) {
            j4 = timeUsage.startTime;
        }
        long j6 = j4;
        if ((i5 & 4) != 0) {
            j5 = timeUsage.endTime;
        }
        long j7 = j5;
        if ((i5 & 8) != 0) {
            i4 = timeUsage.type;
        }
        return timeUsage.copy(str, j6, j7, i4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final TimeUsage copy(@NotNull String packageName, long startTime, long endTime, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new TimeUsage(packageName, startTime, endTime, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeUsage)) {
            return false;
        }
        TimeUsage timeUsage = (TimeUsage) other;
        return Intrinsics.areEqual(this.packageName, timeUsage.packageName) && this.startTime == timeUsage.startTime && this.endTime == timeUsage.endTime && this.type == timeUsage.type;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.type) + g.f(this.endTime, g.f(this.startTime, this.packageName.hashCode() * 31, 31), 31);
    }

    public final void setEndTime(long j4) {
        this.endTime = j4;
    }

    public final void setPackageName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setStartTime(long j4) {
        this.startTime = j4;
    }

    public final void setType(int i4) {
        this.type = i4;
    }

    @NotNull
    public String toString() {
        String str = this.packageName;
        long j4 = this.startTime;
        long j5 = this.endTime;
        int i4 = this.type;
        StringBuilder sb = new StringBuilder("TimeUsage(packageName=");
        sb.append(str);
        sb.append(", startTime=");
        sb.append(j4);
        sb.append(", endTime=");
        sb.append(j5);
        sb.append(", type=");
        return AbstractC0831a.d(sb, i4, ")");
    }
}
