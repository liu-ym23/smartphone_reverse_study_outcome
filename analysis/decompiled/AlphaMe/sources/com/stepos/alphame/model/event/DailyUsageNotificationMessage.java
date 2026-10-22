package com.stepos.alphame.model.event;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageNotificationMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "(JLjava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getRequestTime", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageNotificationMessage implements DailyUsageMessage {

    @NotNull
    private final String packageName;
    private final long requestTime;

    public DailyUsageNotificationMessage(long j4, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.requestTime = j4;
        this.packageName = packageName;
    }

    public static /* synthetic */ DailyUsageNotificationMessage copy$default(DailyUsageNotificationMessage dailyUsageNotificationMessage, long j4, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = dailyUsageNotificationMessage.requestTime;
        }
        if ((i4 & 2) != 0) {
            str = dailyUsageNotificationMessage.packageName;
        }
        return dailyUsageNotificationMessage.copy(j4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final DailyUsageNotificationMessage copy(long requestTime, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new DailyUsageNotificationMessage(requestTime, packageName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageNotificationMessage)) {
            return false;
        }
        DailyUsageNotificationMessage dailyUsageNotificationMessage = (DailyUsageNotificationMessage) other;
        return this.requestTime == dailyUsageNotificationMessage.requestTime && Intrinsics.areEqual(this.packageName, dailyUsageNotificationMessage.packageName);
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return this.packageName.hashCode() + (Long.hashCode(this.requestTime) * 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageNotificationMessage(requestTime=" + this.requestTime + ", packageName=" + this.packageName + ")";
    }
}
