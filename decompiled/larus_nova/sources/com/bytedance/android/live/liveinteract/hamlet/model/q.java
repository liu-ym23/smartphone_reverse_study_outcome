package com.bytedance.android.live.liveinteract.hamlet.model;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/q;", "", "", "uid", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "", "avatarRending", "I", "getAvatarRending", "()I", "setAvatarRending", "(I)V", "", "x", FaceService.girlLabel, "d", "()F", "setX", "(F)V", "y", "e", "setY", "width", "c", "setWidth", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHeight", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q {

    @SerializedName("r")
    private int avatarRending;

    @SerializedName("h")
    private float height;

    @SerializedName("uid")
    private String uid;

    @SerializedName("w")
    private float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f73515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f73516y;

    public static final class a {
    }

    static {
    }

    public q() {
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final float a() {
        return this.height;
    }

    public final String b() {
        return this.uid;
    }

    public final float c() {
        return this.width;
    }

    public final float d() {
        return this.f73515x;
    }

    public final float e() {
        return this.f73516y;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if ((!Intrinsics.areEqual(this.uid, r101.uid)) == false) goto L11;
        return false;
    L11:
        if (this.avatarRending == r101.avatarRending) goto L14;
        return false;
    L14:
        if (Math.abs(this.f73515x - r101.f73515x) < 0.02f) goto L16;
        return false;
    L16:
        if (Math.abs(this.f73516y - r101.f73516y) < 0.02f) goto L18;
        return false;
    L18:
        if (Math.abs(this.width - r101.width) < 0.02f) goto L20;
        return false;
    L20:
        if (Math.abs(this.height - r101.height) >= 0.02f) goto L27;
        return true;
    L27:
        return false;
    }
}
