package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006%"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "", "date", "", "mode", "", "userId", "notificationUsages", "", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;", "screenUsages", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsage;", "timeUsages", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "(JIJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDate", "()J", "getMode", "()I", "getNotificationUsages", "()Ljava/util/List;", "getScreenUsages", "getTimeUsages", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsage {
    private final long date;
    private final int mode;

    @NotNull
    private final List<NotificationUsage> notificationUsages;

    @NotNull
    private final List<ScreenUsage> screenUsages;

    @NotNull
    private final List<TimeUsage> timeUsages;
    private final long userId;

    public DailyUsage(long j4, int i4, long j5, @NotNull List<NotificationUsage> notificationUsages, @NotNull List<ScreenUsage> screenUsages, @NotNull List<TimeUsage> timeUsages) {
        Intrinsics.checkNotNullParameter(notificationUsages, "notificationUsages");
        Intrinsics.checkNotNullParameter(screenUsages, "screenUsages");
        Intrinsics.checkNotNullParameter(timeUsages, "timeUsages");
        this.date = j4;
        this.mode = i4;
        this.userId = j5;
        this.notificationUsages = notificationUsages;
        this.screenUsages = screenUsages;
        this.timeUsages = timeUsages;
    }

    /* renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    @NotNull
    public final List<NotificationUsage> component4() {
        return this.notificationUsages;
    }

    @NotNull
    public final List<ScreenUsage> component5() {
        return this.screenUsages;
    }

    @NotNull
    public final List<TimeUsage> component6() {
        return this.timeUsages;
    }

    @NotNull
    public final DailyUsage copy(long date, int mode, long userId, @NotNull List<NotificationUsage> notificationUsages, @NotNull List<ScreenUsage> screenUsages, @NotNull List<TimeUsage> timeUsages) {
        Intrinsics.checkNotNullParameter(notificationUsages, "notificationUsages");
        Intrinsics.checkNotNullParameter(screenUsages, "screenUsages");
        Intrinsics.checkNotNullParameter(timeUsages, "timeUsages");
        return new DailyUsage(date, mode, userId, notificationUsages, screenUsages, timeUsages);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsage)) {
            return false;
        }
        DailyUsage dailyUsage = (DailyUsage) other;
        return this.date == dailyUsage.date && this.mode == dailyUsage.mode && this.userId == dailyUsage.userId && Intrinsics.areEqual(this.notificationUsages, dailyUsage.notificationUsages) && Intrinsics.areEqual(this.screenUsages, dailyUsage.screenUsages) && Intrinsics.areEqual(this.timeUsages, dailyUsage.timeUsages);
    }

    public final long getDate() {
        return this.date;
    }

    public final int getMode() {
        return this.mode;
    }

    @NotNull
    public final List<NotificationUsage> getNotificationUsages() {
        return this.notificationUsages;
    }

    @NotNull
    public final List<ScreenUsage> getScreenUsages() {
        return this.screenUsages;
    }

    @NotNull
    public final List<TimeUsage> getTimeUsages() {
        return this.timeUsages;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.timeUsages.hashCode() + ((this.screenUsages.hashCode() + ((this.notificationUsages.hashCode() + g.f(this.userId, g.d(this.mode, Long.hashCode(this.date) * 31, 31), 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsage(date=" + this.date + ", mode=" + this.mode + ", userId=" + this.userId + ", notificationUsages=" + this.notificationUsages + ", screenUsages=" + this.screenUsages + ", timeUsages=" + this.timeUsages + ")";
    }

    public /* synthetic */ DailyUsage(long j4, int i4, long j5, List list, List list2, List list3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j4, i4, j5, (i5 & 8) != 0 ? new ArrayList() : list, (i5 & 16) != 0 ? new ArrayList() : list2, (i5 & 32) != 0 ? new ArrayList() : list3);
    }
}
