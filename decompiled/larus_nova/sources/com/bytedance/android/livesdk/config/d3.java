package com.bytedance.android.livesdk.config;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/d3;", "", "", "state", "I", "getState", "()I", "", "inDuration", "J", "getInDuration", "()J", "outDuration", "getOutDuration", "stayDuration", "getStayDuration", "extraDuration", "getExtraDuration", "switchDuration", "getSwitchDuration", "specialInDuration", "getSpecialInDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d3 {

    @SerializedName("extra")
    private final long extraDuration;

    @SerializedName("in")
    private final long inDuration;

    @SerializedName(Argument.OUT)
    private final long outDuration;

    @SerializedName("special_in")
    private final long specialInDuration;

    @SerializedName("state")
    private final int state;

    @SerializedName("stay")
    private final long stayDuration;

    @SerializedName("switch")
    private final long switchDuration;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d3) == false) goto L20;
        d3 r101 = (d3) r100;
        if (this.state == r101.state) goto L8;
        return false;
    L8:
        if (this.inDuration == r101.inDuration) goto L10;
        return false;
    L10:
        if (this.outDuration == r101.outDuration) goto L12;
        return false;
    L12:
        if (this.stayDuration == r101.stayDuration) goto L14;
        return false;
    L14:
        if (this.extraDuration == r101.extraDuration) goto L16;
        return false;
    L16:
        if (this.switchDuration == r101.switchDuration) goto L18;
        return false;
    L18:
        if (this.specialInDuration == r101.specialInDuration) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.state * 31;
        long r101 = this.inDuration;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.outDuration;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.stayDuration;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.extraDuration;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.switchDuration;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.specialInDuration;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    }

    public final String toString() {
        return "Duration(state=" + this.state + ", inDuration=" + this.inDuration + ", outDuration=" + this.outDuration + ", stayDuration=" + this.stayDuration + ", extraDuration=" + this.extraDuration + ", switchDuration=" + this.switchDuration + ", specialInDuration=" + this.specialInDuration + ")";
    }

    public d3() {
        this.state = 1;
        this.inDuration = 800;
        this.outDuration = 1000;
        this.stayDuration = 2000;
        this.extraDuration = 2000;
        this.switchDuration = 500;
        this.specialInDuration = 200;
    }
}
