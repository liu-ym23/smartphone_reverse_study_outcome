package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/g;", "", "", "switch", "I", "d", "()I", "reportSuccess", "c", "", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/f;", "monitorList", "Ljava/util/List;", "b", "()Ljava/util/List;", "monitorEnabled", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class g {

    @SerializedName("enable_web_monitor")
    private final int monitorEnabled;

    @SerializedName("monitor_list")
    private final List<f> monitorList;

    @SerializedName("report_success")
    private final int reportSuccess;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f68switch;

    public g() {
        this.monitorList = CollectionsKt.emptyList();
        this.monitorEnabled = 1;
    }

    public final int a() {
        return this.monitorEnabled;
    }

    public final List<f> b() {
        return this.monitorList;
    }

    public final int c() {
        return this.reportSuccess;
    }

    public final int d() {
        return this.f68switch;
    }
}
