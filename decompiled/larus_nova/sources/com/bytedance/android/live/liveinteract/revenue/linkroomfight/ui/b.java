package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/b;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/d;", "volumeInfos", "Ljava/util/List;", "b", "()Ljava/util/List;", "setVolumeInfos", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/c;", "statsInfos", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setStatsInfos", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("StatsInfos")
    private List<c> statsInfos;

    @SerializedName("Type")
    private String type;

    @SerializedName("VolumeInfos")
    private List<d> volumeInfos;

    public final String toString() {
        return "PublicStreamSystemTypeSEI(type=" + this.type + ", volumeInfos=" + this.volumeInfos + ", statsInfos=" + this.statsInfos + ')';
    }

    public b() {
        this.volumeInfos = new ArrayList();
        this.statsInfos = new ArrayList();
    }

    public final List<c> a() {
        return this.statsInfos;
    }

    public final List<d> b() {
        return this.volumeInfos;
    }

    public final String getType() {
        return this.type;
    }
}
