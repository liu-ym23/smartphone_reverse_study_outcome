package com.bytedance.android.format.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast_avatar_device_render.Quaternion")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/format/model/w0;", "", "", "x", "Ljava/lang/Float;", "getX", "()Ljava/lang/Float;", "setX", "(Ljava/lang/Float;)V", "y", "getY", "setY", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getZ", "setZ", "w", "getW", "setW", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 implements vh7.h {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    protected Float f51368w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    protected Float f51369x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    protected Float f51370y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    protected Float f51371z;

    public w0() {
        Float r100 = Float.valueOf(0.0f);
        this.f51369x = r100;
        this.f51370y = r100;
        this.f51371z = r100;
        this.f51368w = r100;
    }

    public w0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.f51369x = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.f51370y = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.f51371z = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.f51368w = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.f51369x != null) goto L22;
        this.f51369x = Float.valueOf(0.0f);
    L22:
        if (this.f51370y != null) goto L25;
        this.f51370y = Float.valueOf(0.0f);
    L25:
        if (this.f51371z != null) goto L28;
        this.f51371z = Float.valueOf(0.0f);
    L28:
        if (this.f51368w != null) goto L46;
        this.f51368w = Float.valueOf(0.0f);
        return;
    }
}
