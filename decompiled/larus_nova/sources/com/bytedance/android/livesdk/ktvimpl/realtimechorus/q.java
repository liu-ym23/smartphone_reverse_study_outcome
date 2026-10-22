package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/q;", "", "", "ntp", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setNtp", "(J)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "b", "setPos", "isPaused", "c", "setPaused", "index", "getIndex", "setIndex", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q {

    @SerializedName("index")
    private long index;

    @SerializedName("br_st")
    private long isPaused;

    @SerializedName("ntp")
    private long ntp;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    private long pos;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L14;
        q r101 = (q) r100;
        if (this.ntp == r101.ntp) goto L8;
        return false;
    L8:
        if (this.pos == r101.pos) goto L10;
        return false;
    L10:
        if (this.isPaused == r101.isPaused) goto L12;
        return false;
    L12:
        if (this.index == r101.index) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.ntp;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.pos;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.isPaused;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.index;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "RealTimeChorusBgmSyncInfo(ntp=" + this.ntp + ", pos=" + this.pos + ", isPaused=" + this.isPaused + ", index=" + this.index + ")";
    }

    public q() {
        this(0, 0, 0, 0);
    }

    public final long a() {
        return this.ntp;
    }

    public final long b() {
        return this.pos;
    }

    public final long c() {
        return this.isPaused;
    }

    public q(long r100, long r101, long r102, long r103) {
        this.ntp = r100;
        this.pos = r101;
        this.isPaused = r102;
        this.index = r103;
    }
}
