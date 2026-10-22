package com.bytedance.android.live.liveinteract.api.data;

import am3.g;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.multilink.base.model.h;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/data/GalileoResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/h;", "", "component1", "component2", "component3", "component4", "component5", "speedShakeMillSecond", "acceleratedThreshold", "minShakeInterval", "shakeEndTimeIntervalThreshold", "shakeIntervalMillSecond", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "D", "getSpeedShakeMillSecond", "()D", "getAcceleratedThreshold", "getMinShakeInterval", "getShakeEndTimeIntervalThreshold", "getShakeIntervalMillSecond", "<init>", "(DDDDD)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GalileoResponse extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("accelerameter_threshold")
    protected double acceleratedThreshold;

    @SerializedName("min_shake_interval")
    protected double minShakeInterval;

    @SerializedName("shake_end_time_interval_threshold")
    protected double shakeEndTimeIntervalThreshold;

    @SerializedName("shake_interval_millsecond")
    protected double shakeIntervalMillSecond;

    @SerializedName("m_speed_shake_mill_seconds")
    protected double speedShakeMillSecond;

    public GalileoResponse(double r100, double r101, double r102, double r103, double r110) {
        super(h.class);
        this.speedShakeMillSecond = r100;
        this.acceleratedThreshold = r101;
        this.minShakeInterval = r102;
        this.shakeEndTimeIntervalThreshold = r103;
        this.shakeIntervalMillSecond = r110;
    }

    public static /* synthetic */ GalileoResponse copy$default(GalileoResponse r110, double r111, double r112, double r113, double r114, double r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        double r100 = r110.speedShakeMillSecond;
    L7:
        if ((r211 & 2) == 0) goto L9;
        double r101 = r110.acceleratedThreshold;
    L11:
        if ((r211 & 4) == 0) goto L13;
        double r102 = r110.minShakeInterval;
    L15:
        if ((r211 & 8) == 0) goto L17;
        double r103 = r110.shakeEndTimeIntervalThreshold;
    L19:
        if ((r211 & 16) == 0) goto L21;
        double r104 = r110.shakeIntervalMillSecond;
    L23:
        return r110.copy(r100, r101, r102, r103, r104);
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final double component1() {
        return this.speedShakeMillSecond;
    }

    public final double component2() {
        return this.acceleratedThreshold;
    }

    public final double component3() {
        return this.minShakeInterval;
    }

    public final double component4() {
        return this.shakeEndTimeIntervalThreshold;
    }

    public final double component5() {
        return this.shakeIntervalMillSecond;
    }

    public final GalileoResponse copy(double r110, double r111, double r112, double r113, double r210) {
        return new GalileoResponse(r110, r111, r112, r113, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GalileoResponse) == false) goto L16;
        GalileoResponse r101 = (GalileoResponse) r100;
        if (Double.compare(this.speedShakeMillSecond, r101.speedShakeMillSecond) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.acceleratedThreshold, r101.acceleratedThreshold) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.minShakeInterval, r101.minShakeInterval) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.shakeEndTimeIntervalThreshold, r101.shakeEndTimeIntervalThreshold) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.shakeIntervalMillSecond, r101.shakeIntervalMillSecond) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.speedShakeMillSecond);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.acceleratedThreshold);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.minShakeInterval);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.shakeEndTimeIntervalThreshold);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.shakeIntervalMillSecond);
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public String toString() {
        return "GalileoResponse(speedShakeMillSecond=" + this.speedShakeMillSecond + ", acceleratedThreshold=" + this.acceleratedThreshold + ", minShakeInterval=" + this.minShakeInterval + ", shakeEndTimeIntervalThreshold=" + this.shakeEndTimeIntervalThreshold + ", shakeIntervalMillSecond=" + this.shakeIntervalMillSecond + ")";
    }

    public GalileoResponse() {
        super(h.class);
        this.speedShakeMillSecond = 700.0d;
        this.acceleratedThreshold = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.minShakeInterval = 1024.0d;
        this.shakeEndTimeIntervalThreshold = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.shakeIntervalMillSecond = 55.0d;
    }

    public final double getAcceleratedThreshold() {
        return this.acceleratedThreshold;
    }

    public final double getMinShakeInterval() {
        return this.minShakeInterval;
    }

    public final double getShakeEndTimeIntervalThreshold() {
        return this.shakeEndTimeIntervalThreshold;
    }

    public final double getShakeIntervalMillSecond() {
        return this.shakeIntervalMillSecond;
    }

    public final double getSpeedShakeMillSecond() {
        return this.speedShakeMillSecond;
    }

    public GalileoResponse(g r100) {
        super(h.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.speedShakeMillSecond = Double.longBitsToDouble(r100.h());
        r101 = r101 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.acceleratedThreshold = Double.longBitsToDouble(r100.h());
        r101 = r101 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.minShakeInterval = Double.longBitsToDouble(r100.h());
        r101 = r101 | 4;
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.shakeEndTimeIntervalThreshold = Double.longBitsToDouble(r100.h());
        r101 = r101 | 8;
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this.shakeIntervalMillSecond = Double.longBitsToDouble(r100.h());
        r101 = r101 | 16;
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L25;
        this.speedShakeMillSecond = 700.0d;
    L25:
        if ((r101 & 2) != 0) goto L28;
        this.acceleratedThreshold = AudioStats.AUDIO_AMPLITUDE_NONE;
    L28:
        if ((r101 & 4) != 0) goto L31;
        this.minShakeInterval = 1024.0d;
    L31:
        if ((r101 & 8) != 0) goto L34;
        this.shakeEndTimeIntervalThreshold = AudioStats.AUDIO_AMPLITUDE_NONE;
    L34:
        if ((r101 & 16) != 0) goto L55;
        this.shakeIntervalMillSecond = 55.0d;
        return;
    }

    public /* synthetic */ GalileoResponse(double r110, double r111, double r112, double r113, double r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        double r100 = 700.0d;
    L6:
        int r101 = r211 & 2;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r101 == 0) goto L9;
        double r103 = 0.0d;
    L11:
        if ((r211 & 4) == 0) goto L13;
        double r104 = 1024.0d;
    L15:
        if ((r211 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r211 & 16) == 0) goto L21;
        double r105 = 55.0d;
    L22:
        this(r100, r103, r104, r102, r105);
        return;
    L21:
        r105 = r210;
        goto L22
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
