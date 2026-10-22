package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RealTimeIP;", "", "()V", "checkValidity", "", "getCheckValidity", "()Ljava/lang/Integer;", "setCheckValidity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enable", "getEnable", "setEnable", "preCreateEnable", "getPreCreateEnable", "setPreCreateEnable", "realTimeIPFlv", "", "getRealTimeIPFlv", "()Ljava/lang/String;", "setRealTimeIPFlv", "(Ljava/lang/String;)V", "realTimeIPRtm", "getRealTimeIPRtm", "setRealTimeIPRtm", "useRealTimeFirstly", "getUseRealTimeFirstly", "setUseRealTimeFirstly", "useRealtimeForPre302", "getUseRealtimeForPre302", "setUseRealtimeForPre302", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RealTimeIP {
    private Integer checkValidity;
    private Integer enable;
    private Integer preCreateEnable;
    private String realTimeIPFlv;
    private String realTimeIPRtm;
    private Integer useRealTimeFirstly;
    private Integer useRealtimeForPre302;

    public String toString() {
        return "RealTimeIP(enable=" + this.enable + ", Flv=" + this.realTimeIPFlv + ", Rtm=" + this.realTimeIPRtm + ", First=" + this.useRealTimeFirstly + ", Pre302=" + this.useRealtimeForPre302 + ')';
    }

    public RealTimeIP() {
        this.enable = -1;
        this.checkValidity = -1;
        this.realTimeIPFlv = "";
        this.realTimeIPRtm = "";
        this.useRealTimeFirstly = -1;
        this.useRealtimeForPre302 = -1;
        this.preCreateEnable = 1;
    }

    public final Integer getCheckValidity() {
        return this.checkValidity;
    }

    public final Integer getEnable() {
        return this.enable;
    }

    public final Integer getPreCreateEnable() {
        return this.preCreateEnable;
    }

    public final String getRealTimeIPFlv() {
        return this.realTimeIPFlv;
    }

    public final String getRealTimeIPRtm() {
        return this.realTimeIPRtm;
    }

    public final Integer getUseRealTimeFirstly() {
        return this.useRealTimeFirstly;
    }

    public final Integer getUseRealtimeForPre302() {
        return this.useRealtimeForPre302;
    }

    public final void setCheckValidity(Integer r100) {
        this.checkValidity = r100;
    }

    public final void setEnable(Integer r100) {
        this.enable = r100;
    }

    public final void setPreCreateEnable(Integer r100) {
        this.preCreateEnable = r100;
    }

    public final void setRealTimeIPFlv(String r100) {
        this.realTimeIPFlv = r100;
    }

    public final void setRealTimeIPRtm(String r100) {
        this.realTimeIPRtm = r100;
    }

    public final void setUseRealTimeFirstly(Integer r100) {
        this.useRealTimeFirstly = r100;
    }

    public final void setUseRealtimeForPre302(Integer r100) {
        this.useRealtimeForPre302 = r100;
    }
}
