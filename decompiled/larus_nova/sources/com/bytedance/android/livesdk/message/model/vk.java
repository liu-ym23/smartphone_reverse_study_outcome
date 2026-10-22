package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.SandwichBorder")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vk;", "", "", "top", "D", "d", "()D", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "left", "b", "right", "c", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class vk implements vh7.h {

    @SerializedName("bottom")
    protected double bottom;

    @SerializedName("left")
    protected double left;

    @SerializedName("right")
    protected double right;

    @SerializedName("top")
    protected double top;

    public vk() {
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

    public vk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.top = Double.longBitsToDouble(r100.h());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bottom = Double.longBitsToDouble(r100.h());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.left = Double.longBitsToDouble(r100.h());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.right = Double.longBitsToDouble(r100.h());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
