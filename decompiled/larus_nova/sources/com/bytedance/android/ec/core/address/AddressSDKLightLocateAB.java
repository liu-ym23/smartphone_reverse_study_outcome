package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/address/AddressSDKLightLocateAB;", "", "", "delayFetchMillis", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "delaySDKInitMillis", "b", "", "isReportColdStartFlag", "Z", "d", "()Z", "enableLightLocation", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddressSDKLightLocateAB {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43664a = null;

    @SerializedName("delay_fetch_millis")
    private final int delayFetchMillis;

    @SerializedName("delay_sdk_init_millis")
    private final int delaySDKInitMillis;

    @SerializedName("enable_light_location")
    private final boolean enableLightLocation;

    @SerializedName("report_cold_start_flag")
    private final boolean isReportColdStartFlag;

    public static final class a {
    }

    public AddressSDKLightLocateAB() {
        this(0);
    }

    static {
        f43664a = LazyKt.lazy(AddressSDKLightLocateAB$Companion$value$2.INSTANCE);
    }

    public final int a() {
        return this.delayFetchMillis;
    }

    public final int b() {
        return this.delaySDKInitMillis;
    }

    public final boolean c() {
        return this.enableLightLocation;
    }

    public final boolean d() {
        return this.isReportColdStartFlag;
    }

    public AddressSDKLightLocateAB(int r100) {
        this.delayFetchMillis = 0;
        this.delaySDKInitMillis = 1000;
        this.isReportColdStartFlag = true;
        this.enableLightLocation = true;
    }
}
