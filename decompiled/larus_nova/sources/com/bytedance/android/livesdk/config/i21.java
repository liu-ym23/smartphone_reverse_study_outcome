package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/i21;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "", "", "tipsConfig", "Ljava/util/Map;", "getTipsConfig", "()Ljava/util/Map;", "setTipsConfig", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i21 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("tips_config")
    private Map<Integer, String> tipsConfig;

    public i21() {
        this.tipsConfig = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(10, "因抖音被关闭，直播意外中断。如需关播建议使用平台关播功能，避免意外中断，导致观众流失"), TuplesKt.to(3, "因手机资源有限，直播意外中断。建议关闭其他后台应用，避免意外中断，导致观众流失"), TuplesKt.to(6, "因手机资源有限，直播意外中断。建议关闭其他后台应用，避免意外中断，导致观众流失"), TuplesKt.to(9, "因手机资源有限，直播意外中断。建议关闭其他后台应用，避免意外中断，导致观众流失")});
    }
}
