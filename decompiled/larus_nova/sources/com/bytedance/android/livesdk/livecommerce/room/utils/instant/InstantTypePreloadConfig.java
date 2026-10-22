package com.bytedance.android.livesdk.livecommerce.room.utils.instant;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/utils/instant/InstantTypePreloadConfig;", "Ljava/io/Serializable;", "instantType", "", "channels", "", "", "(ILjava/util/List;)V", "getChannels", "()Ljava/util/List;", "getInstantType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstantTypePreloadConfig implements Serializable {

    @SerializedName("channels")
    private final List<String> channels;

    @SerializedName("instant_type")
    private final int instantType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstantTypePreloadConfig copy$default(InstantTypePreloadConfig r100, int r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.instantType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.channels;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.instantType;
    }

    public final List<String> component2() {
        return this.channels;
    }

    public final InstantTypePreloadConfig copy(int r100, List<String> r101) {
        return new InstantTypePreloadConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InstantTypePreloadConfig) == false) goto L10;
        InstantTypePreloadConfig r101 = (InstantTypePreloadConfig) r100;
        if (this.instantType == r101.instantType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channels, r101.channels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.instantType * 31;
        List<String> r101 = this.channels;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "InstantTypePreloadConfig(instantType=" + this.instantType + ", channels=" + this.channels + ")";
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final int getInstantType() {
        return this.instantType;
    }

    public InstantTypePreloadConfig(int r100, List<String> r101) {
        this.instantType = r100;
        this.channels = r101;
    }
}
