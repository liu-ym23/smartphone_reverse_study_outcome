package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/a0;", "", "", "x", FaceService.girlLabel, "getX", "()F", "b", "(F)V", "y", "getY", "c", "w", "getW", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private float f119752w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f119753x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f119754y;

    public a0() {
        this.f119753x = 0.8f;
        this.f119754y = 0.2f;
        this.f119752w = 0.2f;
    }

    public final void a() {
        this.f119752w = 0.2f;
    }

    public final void b() {
        this.f119753x = 0.78f;
    }

    public final void c(float r100) {
        this.f119754y = r100;
    }
}
