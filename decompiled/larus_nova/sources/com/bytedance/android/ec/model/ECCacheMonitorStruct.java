package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/ECCacheMonitorStruct;", "Ljava/io/Serializable;", "optimizeOn", "", "defaultTimeSeconds", "", "cacheNum", "(ZII)V", "getCacheNum", "()I", "getDefaultTimeSeconds", "getOptimizeOn", "()Z", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECCacheMonitorStruct implements Serializable {

    @SerializedName("cache_num")
    private final int cacheNum;

    @SerializedName("default_time")
    private final int defaultTimeSeconds;

    @SerializedName("optimize_on")
    private final boolean optimizeOn;

    public ECCacheMonitorStruct() {
        this(false, 0, 0, 7, null);
    }

    public final int getCacheNum() {
        return this.cacheNum;
    }

    public final int getDefaultTimeSeconds() {
        return this.defaultTimeSeconds;
    }

    public final boolean getOptimizeOn() {
        return this.optimizeOn;
    }

    public ECCacheMonitorStruct(boolean r100, int r101, int r102) {
        this.optimizeOn = r100;
        this.defaultTimeSeconds = r101;
        this.cacheNum = r102;
    }

    public /* synthetic */ ECCacheMonitorStruct(boolean r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
