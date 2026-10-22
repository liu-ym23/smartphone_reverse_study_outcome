package com.stepos.alphame.model.event;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageMzWindowMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "state", "mode", "", "(JLjava/lang/String;Ljava/lang/String;I)V", "getMode", "()I", "getPackageName", "()Ljava/lang/String;", "getRequestTime", "()J", "getState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageMzWindowMessage implements DailyUsageMessage {
    private final int mode;

    @NotNull
    private final String packageName;
    private final long requestTime;

    @NotNull
    private final String state;

    public DailyUsageMzWindowMessage(long j4, @NotNull String packageName, @NotNull String state, int i4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(state, "state");
        this.requestTime = j4;
        this.packageName = packageName;
        this.state = state;
        this.mode = i4;
    }

    public static /* synthetic */ DailyUsageMzWindowMessage copy$default(DailyUsageMzWindowMessage dailyUsageMzWindowMessage, long j4, String str, String str2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j4 = dailyUsageMzWindowMessage.requestTime;
        }
        long j5 = j4;
        if ((i5 & 2) != 0) {
            str = dailyUsageMzWindowMessage.packageName;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            str2 = dailyUsageMzWindowMessage.state;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i4 = dailyUsageMzWindowMessage.mode;
        }
        return dailyUsageMzWindowMessage.copy(j5, str3, str4, i4);
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
    /* renamed from: component3, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    @NotNull
    public final DailyUsageMzWindowMessage copy(long requestTime, @NotNull String packageName, @NotNull String state, int mode) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(state, "state");
        return new DailyUsageMzWindowMessage(requestTime, packageName, state, mode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageMzWindowMessage)) {
            return false;
        }
        DailyUsageMzWindowMessage dailyUsageMzWindowMessage = (DailyUsageMzWindowMessage) other;
        return this.requestTime == dailyUsageMzWindowMessage.requestTime && Intrinsics.areEqual(this.packageName, dailyUsageMzWindowMessage.packageName) && Intrinsics.areEqual(this.state, dailyUsageMzWindowMessage.state) && this.mode == dailyUsageMzWindowMessage.mode;
    }

    public final int getMode() {
        return this.mode;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return Integer.hashCode(this.mode) + AbstractC0351g.d(this.state, AbstractC0351g.d(this.packageName, Long.hashCode(this.requestTime) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageMzWindowMessage(requestTime=" + this.requestTime + ", packageName=" + this.packageName + ", state=" + this.state + ", mode=" + this.mode + ")";
    }
}
