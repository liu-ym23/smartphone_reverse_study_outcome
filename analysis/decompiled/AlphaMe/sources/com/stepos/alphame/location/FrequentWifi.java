package com.stepos.alphame.location;

import B0.g;
import androidx.room.AbstractC0351g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s.AbstractC0831a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/location/FrequentWifi;", "", "ssid", "", "bssid", "totalConnectedCount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBssid", "()Ljava/lang/String;", "getSsid", "getTotalConnectedCount", "()I", "setTotalConnectedCount", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FrequentWifi {

    @NotNull
    private final String bssid;

    @NotNull
    private final String ssid;
    private int totalConnectedCount;

    public FrequentWifi(@NotNull String ssid, @NotNull String bssid, int i4) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(bssid, "bssid");
        this.ssid = ssid;
        this.bssid = bssid;
        this.totalConnectedCount = i4;
    }

    public static /* synthetic */ FrequentWifi copy$default(FrequentWifi frequentWifi, String str, String str2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = frequentWifi.ssid;
        }
        if ((i5 & 2) != 0) {
            str2 = frequentWifi.bssid;
        }
        if ((i5 & 4) != 0) {
            i4 = frequentWifi.totalConnectedCount;
        }
        return frequentWifi.copy(str, str2, i4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSsid() {
        return this.ssid;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBssid() {
        return this.bssid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalConnectedCount() {
        return this.totalConnectedCount;
    }

    @NotNull
    public final FrequentWifi copy(@NotNull String ssid, @NotNull String bssid, int totalConnectedCount) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(bssid, "bssid");
        return new FrequentWifi(ssid, bssid, totalConnectedCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrequentWifi)) {
            return false;
        }
        FrequentWifi frequentWifi = (FrequentWifi) other;
        return Intrinsics.areEqual(this.ssid, frequentWifi.ssid) && Intrinsics.areEqual(this.bssid, frequentWifi.bssid) && this.totalConnectedCount == frequentWifi.totalConnectedCount;
    }

    @NotNull
    public final String getBssid() {
        return this.bssid;
    }

    @NotNull
    public final String getSsid() {
        return this.ssid;
    }

    public final int getTotalConnectedCount() {
        return this.totalConnectedCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.totalConnectedCount) + AbstractC0351g.d(this.bssid, this.ssid.hashCode() * 31, 31);
    }

    public final void setTotalConnectedCount(int i4) {
        this.totalConnectedCount = i4;
    }

    @NotNull
    public String toString() {
        String str = this.ssid;
        String str2 = this.bssid;
        return AbstractC0831a.d(g.x("FrequentWifi(ssid=", str, ", bssid=", str2, ", totalConnectedCount="), this.totalConnectedCount, ")");
    }
}
