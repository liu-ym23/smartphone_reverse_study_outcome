package com.stepos.alphame.model.event;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageAudioMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "audioPlayedState", "", "(JLjava/lang/String;I)V", "getAudioPlayedState", "()I", "getPackageName", "()Ljava/lang/String;", "getRequestTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageAudioMessage implements DailyUsageMessage {
    private final int audioPlayedState;

    @NotNull
    private final String packageName;
    private final long requestTime;

    public DailyUsageAudioMessage(long j4, @NotNull String packageName, int i4) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.requestTime = j4;
        this.packageName = packageName;
        this.audioPlayedState = i4;
    }

    public static /* synthetic */ DailyUsageAudioMessage copy$default(DailyUsageAudioMessage dailyUsageAudioMessage, long j4, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j4 = dailyUsageAudioMessage.requestTime;
        }
        if ((i5 & 2) != 0) {
            str = dailyUsageAudioMessage.packageName;
        }
        if ((i5 & 4) != 0) {
            i4 = dailyUsageAudioMessage.audioPlayedState;
        }
        return dailyUsageAudioMessage.copy(j4, str, i4);
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

    /* renamed from: component3, reason: from getter */
    public final int getAudioPlayedState() {
        return this.audioPlayedState;
    }

    @NotNull
    public final DailyUsageAudioMessage copy(long requestTime, @NotNull String packageName, int audioPlayedState) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new DailyUsageAudioMessage(requestTime, packageName, audioPlayedState);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageAudioMessage)) {
            return false;
        }
        DailyUsageAudioMessage dailyUsageAudioMessage = (DailyUsageAudioMessage) other;
        return this.requestTime == dailyUsageAudioMessage.requestTime && Intrinsics.areEqual(this.packageName, dailyUsageAudioMessage.packageName) && this.audioPlayedState == dailyUsageAudioMessage.audioPlayedState;
    }

    public final int getAudioPlayedState() {
        return this.audioPlayedState;
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
        return Integer.hashCode(this.audioPlayedState) + AbstractC0351g.d(this.packageName, Long.hashCode(this.requestTime) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageAudioMessage(requestTime=" + this.requestTime + ", packageName=" + this.packageName + ", audioPlayedState=" + this.audioPlayedState + ")";
    }
}
