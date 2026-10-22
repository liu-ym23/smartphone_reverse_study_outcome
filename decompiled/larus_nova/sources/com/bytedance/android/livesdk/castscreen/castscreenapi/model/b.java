package com.bytedance.android.livesdk.castscreen.castscreenapi.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.PcDeviceInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/castscreenapi/model/b;", "", "", "webId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setWebId", "(Ljava/lang/Long;)V", "", "deviceName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "systemName", "getSystemName", "setSystemName", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
    protected String deviceName;

    @SerializedName("system_name")
    protected String systemName;

    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_WEBID)
    protected Long webId;

    public final int hashCode() {
        Long r100 = this.webId;
        int r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
        int r103 = (int) (r102 ^ (r102 >>> 32));
    L6:
        int r104 = r103 * 31;
        String r105 = this.deviceName;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.systemName;
        if (r108 == null) goto L14;
        r101 = r108.hashCode();
    L14:
        return r107 + r101;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public b() {
        this.deviceName = "";
        this.systemName = "";
    }

    public final String a() {
        return this.deviceName;
    }

    public final Long b() {
        return this.webId;
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.webId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.deviceName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.systemName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.deviceName != null) goto L19;
        this.deviceName = "";
    L19:
        if (this.systemName != null) goto L34;
        this.systemName = "";
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(b.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        b r102 = (b) r100;
        if ((!Intrinsics.areEqual(this.webId, r102.webId)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.deviceName, r102.deviceName)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.systemName, r102.systemName)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.castscreen.castscreenapi.model.PcDeviceInfo");
    L8:
        r101 = null;
        goto L10
    }
}
