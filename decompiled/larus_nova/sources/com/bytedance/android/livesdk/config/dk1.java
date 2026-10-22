package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/dk1;", "", "", "x", FaceService.girlLabel, "d", "()F", RXScreenCaptureService.KEY_INDEX, "(F)V", "y", "e", com.amap.api.col.s.ce.f26395j, "w", "c", "h", "b", com.amap.api.col.s.ce.f26391f, "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "f", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dk1 {

    @SerializedName("open")
    private boolean enable;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private float f120042h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private float f120043w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f120044x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f120045y;

    public dk1() {
    }

    public final boolean a() {
        return this.enable;
    }

    public final float b() {
        return this.f120042h;
    }

    public final float c() {
        return this.f120043w;
    }

    public final float d() {
        return this.f120044x;
    }

    public final float e() {
        return this.f120045y;
    }

    public final void f(boolean r100) {
        this.enable = r100;
    }

    public final void g(float r100) {
        this.f120042h = r100;
    }

    public final void h(float r100) {
        this.f120043w = r100;
    }

    public final void i(float r100) {
        this.f120044x = r100;
    }

    public final void j(float r100) {
        this.f120045y = r100;
    }
}
