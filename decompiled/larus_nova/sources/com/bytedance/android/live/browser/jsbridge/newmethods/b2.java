package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/b2;", "", "", "x", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "setX", "(Ljava/lang/Double;)V", "y", "d", "setY", "width", "b", "setWidth", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHeight", "", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b2 {

    @SerializedName("height")
    private Double height;

    @SerializedName("token")
    private String token;

    @SerializedName("width")
    private Double width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private Double f63303x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private Double f63304y;

    public b2() {
    }

    public final Double a() {
        return this.height;
    }

    public final Double b() {
        return this.width;
    }

    public final Double c() {
        return this.f63303x;
    }

    public final Double d() {
        return this.f63304y;
    }
}
