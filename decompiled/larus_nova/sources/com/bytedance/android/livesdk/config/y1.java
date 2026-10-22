package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/y1;", "", "", "x", FaceService.girlLabel, "c", "()F", com.amap.api.col.s.ce.f26391f, "(F)V", "y", "d", "h", "w", "b", "f", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private float f121645h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private float f121646w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f121647x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f121648y;

    public y1() {
    }

    public final void g() {
        this.f121647x = 0.0f;
    }

    public final void f() {
        this.f121646w = 1.0f;
    }

    public final float a() {
        return this.f121645h;
    }

    public final float b() {
        return this.f121646w;
    }

    public final float c() {
        return this.f121647x;
    }

    public final float d() {
        return this.f121648y;
    }

    public final void e(float r100) {
        this.f121645h = r100;
    }

    public final void h(float r100) {
        this.f121648y = r100;
    }
}
