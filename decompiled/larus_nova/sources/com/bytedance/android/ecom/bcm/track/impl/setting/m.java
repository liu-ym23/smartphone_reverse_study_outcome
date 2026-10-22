package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/m;", "", "", "switch", "I", "b", "()I", "", "trackGraph", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "alogBtmListParamsSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "whiteKeys", "Ljava/util/List;", "d", "()Ljava/util/List;", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class m {

    @SerializedName("alog_btmlist_params_switch")
    private final int alogBtmListParamsSwitch;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f72switch;

    @SerializedName("track_graph")
    private final String trackGraph;

    @SerializedName("white_keys")
    private final List<String> whiteKeys;

    public m() {
        this.f72switch = 1;
        this.trackGraph = "";
        this.whiteKeys = CollectionsKt.listOf(new String[]{"room_id", "author_id", "anchor_id", "group_id", com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK, com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO, "promotion_id", "product_id", "start_btm"});
    }

    public final int a() {
        return this.alogBtmListParamsSwitch;
    }

    public final int b() {
        return this.f72switch;
    }

    public final String c() {
        return this.trackGraph;
    }

    public final List<String> d() {
        return this.whiteKeys;
    }
}
