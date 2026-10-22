package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/VolumeGainParams;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "softGain", "", "getSoftGain", "()I", "setSoftGain", "(I)V", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VolumeGainParams {
    private boolean enable;
    private int softGain;

    public VolumeGainParams() {
    }

    public String toString() {
        return "VolumeGainParams(enable=" + this.enable + ", softGain=" + this.softGain + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getSoftGain() {
        return this.softGain;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setSoftGain(int r100) {
        this.softGain = r100;
    }
}
