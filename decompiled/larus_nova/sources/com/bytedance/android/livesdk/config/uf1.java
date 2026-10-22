package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/uf1;", "", "Lcom/bytedance/android/livesdk/config/yf1;", "forward", "Lcom/bytedance/android/livesdk/config/yf1;", "getForward", "()Lcom/bytedance/android/livesdk/config/yf1;", "setForward", "(Lcom/bytedance/android/livesdk/config/yf1;)V", "right", "getRight", "setRight", "up", "getUp", "setUp", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class uf1 {

    @SerializedName("forward")
    private yf1 forward;

    @SerializedName("right")
    private yf1 right;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    @SerializedName("up")
    private yf1 f121370up;

    public uf1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof uf1) == false) goto L12;
        uf1 r101 = (uf1) r100;
        if (Intrinsics.areEqual(this.forward, r101.forward) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f121370up, r101.f121370up) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        yf1 r100 = this.forward;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        yf1 r104 = this.right;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        yf1 r107 = this.f121370up;
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
        return "RevSpatialAudioHumanOrientation(forward=" + this.forward + ", right=" + this.right + ", up=" + this.f121370up + ")";
    }

    public uf1(int r100) {
        yf1 r101 = new yf1(1.0f, 0.0f, 0.0f);
        yf1 r102 = new yf1(0.0f, 1.0f, 0.0f);
        yf1 r103 = new yf1(0.0f, 0.0f, 1.0f);
        this.forward = r101;
        this.right = r102;
        this.f121370up = r103;
    }
}
