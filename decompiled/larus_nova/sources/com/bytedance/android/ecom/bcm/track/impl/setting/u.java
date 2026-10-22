package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/u;", "", "", "switch", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "", "targetEvents", "Ljava/util/List;", "c", "()Ljava/util/List;", "targetBtm", "b", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class u {

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f79switch;

    @SerializedName("target_btm")
    private final List<String> targetBtm;

    @SerializedName("target_events")
    private final List<String> targetEvents;

    public u() {
        this.targetEvents = CollectionsKt.listOf("page_view");
        this.targetBtm = CollectionsKt.listOf("a1.b7411.c0.d0");
    }

    public final int a() {
        return this.f79switch;
    }

    public final List<String> b() {
        return this.targetBtm;
    }

    public final List<String> c() {
        return this.targetEvents;
    }
}
