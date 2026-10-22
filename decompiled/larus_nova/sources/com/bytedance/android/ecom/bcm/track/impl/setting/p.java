package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/p;", "", "", "switch", "I", "c", "()I", "", "Lcom/bytedance/android/ecom/bcm/track/impl/setting/x;", "pages", "Ljava/util/List;", "b", "()Ljava/util/List;", "fixBcmInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class p {

    @SerializedName("fix_bcm_info")
    private final int fixBcmInfo;

    @SerializedName("pages")
    private final List<x> pages;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f74switch;

    public p() {
        this.f74switch = 1;
        this.pages = CollectionsKt.listOf(new x());
        this.fixBcmInfo = 1;
    }

    public final int a() {
        return this.fixBcmInfo;
    }

    public final List<x> b() {
        return this.pages;
    }

    public final int c() {
        return this.f74switch;
    }
}
