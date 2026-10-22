package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/model/t0;", "", "Lcom/bytedance/android/livesdk/model/x0;", "forward", "Lcom/bytedance/android/livesdk/model/x0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/model/x0;", "setForward", "(Lcom/bytedance/android/livesdk/model/x0;)V", "right", "b", "setRight", "up", "c", "setUp", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("forward")
    private x0 forward;

    @SerializedName("right")
    private x0 right;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    @SerializedName("up")
    private x0 f153948up;

    public t0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t0) == false) goto L12;
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.forward, r101.forward) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f153948up, r101.f153948up) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        x0 r100 = this.forward;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        x0 r104 = this.right;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        x0 r107 = this.f153948up;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SpatialAudioHumanOrientation(forward=" + this.forward + ", right=" + this.right + ", up=" + this.f153948up + ")";
    }

    public final x0 a() {
        return this.forward;
    }

    public final x0 b() {
        return this.right;
    }

    public final x0 c() {
        return this.f153948up;
    }

    public t0(int r100) {
        x0 r101 = new x0(1.0f, 0.0f, 0.0f);
        x0 r102 = new x0(0.0f, 1.0f, 0.0f);
        x0 r103 = new x0(0.0f, 0.0f, 1.0f);
        this.forward = r101;
        this.right = r102;
        this.f153948up = r103;
    }
}
