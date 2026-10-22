package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class i {

    @SerializedName("bool_array_val")
    public List<Boolean> defaultBooleanArrayValue;

    @SerializedName("default_bool")
    public boolean defaultBooleanValue;

    @SerializedName("float64_array_val")
    public List<Double> defaultDoubleArrayValue;

    @SerializedName("default_float64")
    public double defaultDoubleValue;

    @SerializedName("int64_array_val")
    public List<Long> defaultLongArrayValue;

    @SerializedName("default_int64")
    public long defaultLongValue;

    @SerializedName("default_map")
    public Map<String, String> defaultMapValue;

    @SerializedName("string_array_val")
    public List<String> defaultStringArrayValue;

    @SerializedName("default_string")
    public String defaultStringValue;

    @SerializedName("result_type")
    public int resultType;

    public i() {
    }
}
