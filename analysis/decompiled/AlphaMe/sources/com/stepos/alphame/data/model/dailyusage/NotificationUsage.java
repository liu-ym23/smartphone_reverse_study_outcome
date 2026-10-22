package com.stepos.alphame.data.model.dailyusage;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "triggerTime", "", "(Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getTriggerTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class NotificationUsage {

    @NotNull
    private final String packageName;
    private final long triggerTime;

    public NotificationUsage(@NotNull String packageName, long j4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.packageName = packageName;
        this.triggerTime = j4;
    }

    public static /* synthetic */ NotificationUsage copy$default(NotificationUsage notificationUsage, String str, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = notificationUsage.packageName;
        }
        if ((i4 & 2) != 0) {
            j4 = notificationUsage.triggerTime;
        }
        return notificationUsage.copy(str, j4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTriggerTime() {
        return this.triggerTime;
    }

    @NotNull
    public final NotificationUsage copy(@NotNull String packageName, long triggerTime) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new NotificationUsage(packageName, triggerTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationUsage)) {
            return false;
        }
        NotificationUsage notificationUsage = (NotificationUsage) other;
        return Intrinsics.areEqual(this.packageName, notificationUsage.packageName) && this.triggerTime == notificationUsage.triggerTime;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public int hashCode() {
        return Long.hashCode(this.triggerTime) + (this.packageName.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "NotificationUsage(packageName=" + this.packageName + ", triggerTime=" + this.triggerTime + ")";
    }
}
