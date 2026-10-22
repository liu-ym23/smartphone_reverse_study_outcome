package com.bytedance.android.livesdk.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/model/r0;", "", "", "x", "D", "c", "()D", ce.f26391f, "(D)V", "y", "d", "h", "w", "b", "f", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private double f153944h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private double f153945w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private double f153946x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private double f153947y;

    public r0() {
    }

    public final double a() {
        return this.f153944h;
    }

    public final double b() {
        return this.f153945w;
    }

    public final double c() {
        return this.f153946x;
    }

    public final double d() {
        return this.f153947y;
    }

    public final void e(double r100) {
        this.f153944h = r100;
    }

    public final void f(double r100) {
        this.f153945w = r100;
    }

    public final void g(double r100) {
        this.f153946x = r100;
    }

    public final void h(double r100) {
        this.f153947y = r100;
    }
}
