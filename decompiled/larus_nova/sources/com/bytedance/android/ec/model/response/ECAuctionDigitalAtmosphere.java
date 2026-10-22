package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionDigitalAtmosphere;", "Ljava/io/Serializable;", "frequencyKey", "", "frequencyCount", "", "data", "Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;", "(Ljava/lang/String;JLcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;)V", "getData", "()Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;", "getFrequencyCount", "()J", "getFrequencyKey", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionDigitalAtmosphere implements Serializable {

    @SerializedName("data")
    private final ECAuctionAtmosphereData data;

    @SerializedName("frequency_count")
    private final long frequencyCount;

    @SerializedName("frequency_key")
    private final String frequencyKey;

    public ECAuctionDigitalAtmosphere() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ ECAuctionDigitalAtmosphere copy$default(ECAuctionDigitalAtmosphere r100, String r101, long r102, ECAuctionAtmosphereData r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.frequencyKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.frequencyCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.frequencyKey;
    }

    public final long component2() {
        return this.frequencyCount;
    }

    public final ECAuctionAtmosphereData component3() {
        return this.data;
    }

    public final ECAuctionDigitalAtmosphere copy(String r100, long r101, ECAuctionAtmosphereData r102) {
        return new ECAuctionDigitalAtmosphere(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionDigitalAtmosphere) == false) goto L12;
        ECAuctionDigitalAtmosphere r101 = (ECAuctionDigitalAtmosphere) r100;
        if (Intrinsics.areEqual(this.frequencyKey, r101.frequencyKey) == true) goto L8;
        return false;
    L8:
        if (this.frequencyCount == r101.frequencyCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.frequencyKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.frequencyCount;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        ECAuctionAtmosphereData r105 = this.data;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECAuctionDigitalAtmosphere(frequencyKey=" + this.frequencyKey + ", frequencyCount=" + this.frequencyCount + ", data=" + this.data + ")";
    }

    public final ECAuctionAtmosphereData getData() {
        return this.data;
    }

    public final long getFrequencyCount() {
        return this.frequencyCount;
    }

    public final String getFrequencyKey() {
        return this.frequencyKey;
    }

    public ECAuctionDigitalAtmosphere(String r100, long r101, ECAuctionAtmosphereData r102) {
        this.frequencyKey = r100;
        this.frequencyCount = r101;
        this.data = r102;
    }

    public /* synthetic */ ECAuctionDigitalAtmosphere(String r100, long r101, ECAuctionAtmosphereData r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
