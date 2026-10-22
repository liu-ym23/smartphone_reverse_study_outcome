package com.bytedance.android.livesdkapi.depend.model.live.vs;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class BusinessConfigure implements Serializable {

    @SerializedName("BusinessID")
    public long businessId;

    @SerializedName("BusType")
    public long businessType;
    public long delayMills;

    @SerializedName("DelaySecond")
    public int delaySecond;

    @SerializedName("DelType")
    public long deliveryType;

    @SerializedName("DisplaySecond")
    public int displaySecond;
    public long expectedShowTS;

    @SerializedName("PreciseTime")
    public long preciseTime;
    public long remainDelayMills;

    @SerializedName("ResConfig")
    public BusinessResourceConfigure resourceConfig;

    public static class BusinessType {
        public static long SCREEN_BAR = 3;
        public static long STRONG_BARRAGE = 2;
        public static long WEAK_BARRAGE = 1;

        public BusinessType() {
        }
    }

    public static class DeliveryType {
        public static long ENTER = 1;
        public static long TIMING = 2;

        public DeliveryType() {
        }
    }

    public BusinessConfigure() {
    }
}
