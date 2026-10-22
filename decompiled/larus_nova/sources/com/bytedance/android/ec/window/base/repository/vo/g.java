package com.bytedance.android.ec.window.base.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/g;", "", "", "left", "D", "b", "()D", "right", "c", "top", "d", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("bottom")
    private final double bottom;

    @SerializedName("left")
    private final double left;

    @SerializedName("right")
    private final double right;

    @SerializedName("top")
    private final double top;

    public g() {
    }

    public final double a() {
        return this.bottom;
    }

    public final double b() {
        return this.left;
    }

    public final double c() {
        return this.right;
    }

    public final double d() {
        return this.top;
    }
}
