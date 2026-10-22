package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "", "status", "", "rideEnable", "", "thirdUid", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getRideEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getThirdUid", "getDeviceId", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "equals", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DidiAuthStatusDto {

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("ride_enable")
    private final Boolean rideEnable;

    @SerializedName("status")
    private final String status;

    @SerializedName("third_uid")
    private final String thirdUid;

    public DidiAuthStatusDto() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DidiAuthStatusDto copy$default(DidiAuthStatusDto didiAuthStatusDto, String str, Boolean bool, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = didiAuthStatusDto.status;
        }
        if ((i10 & 2) != 0) {
            bool = didiAuthStatusDto.rideEnable;
        }
        if ((i10 & 4) != 0) {
            str2 = didiAuthStatusDto.thirdUid;
        }
        if ((i10 & 8) != 0) {
            str3 = didiAuthStatusDto.deviceId;
        }
        return didiAuthStatusDto.copy(str, bool, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getRideEnable() {
        return this.rideEnable;
    }

    /* renamed from: component3, reason: from getter */
    public final String getThirdUid() {
        return this.thirdUid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final DidiAuthStatusDto copy(String status, Boolean rideEnable, String thirdUid, String deviceId) {
        return new DidiAuthStatusDto(status, rideEnable, thirdUid, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiAuthStatusDto)) {
            return false;
        }
        DidiAuthStatusDto didiAuthStatusDto = (DidiAuthStatusDto) other;
        return p.d(this.status, didiAuthStatusDto.status) && p.d(this.rideEnable, didiAuthStatusDto.rideEnable) && p.d(this.thirdUid, didiAuthStatusDto.thirdUid) && p.d(this.deviceId, didiAuthStatusDto.deviceId);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final Boolean getRideEnable() {
        return this.rideEnable;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getThirdUid() {
        return this.thirdUid;
    }

    public int hashCode() {
        String str = this.status;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.rideEnable;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.thirdUid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceId;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DidiAuthStatusDto(status=" + this.status + ", rideEnable=" + this.rideEnable + ", thirdUid=" + this.thirdUid + ", deviceId=" + this.deviceId + ")";
    }

    public DidiAuthStatusDto(String str, Boolean bool, String str2, String str3) {
        this.status = str;
        this.rideEnable = bool;
        this.thirdUid = str2;
        this.deviceId = str3;
    }

    public /* synthetic */ DidiAuthStatusDto(String str, Boolean bool, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : bool, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3);
    }
}
