package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ej;", "", "", "giftId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setGiftId", "(Ljava/lang/Long;)V", "giftType", "getGiftType", "setGiftType", "", "giftName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "giftDiamondCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGiftDiamondCount", "icon", "d", "setIcon", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ej implements vh7.h {

    @SerializedName("gift_diamond_count")
    protected Long giftDiamondCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected Long giftId;

    @SerializedName("gift_name")
    protected String giftName;

    @SerializedName("gift_type")
    protected Long giftType;

    @SerializedName("icon")
    protected String icon;

    public ej() {
    }

    public final int hashCode() {
        Long r100 = this.giftId;
        int r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
        int r103 = (int) (r102 ^ (r102 >>> 32));
    L6:
        int r104 = r103 * 31;
        Long r105 = this.giftType;
        if (r105 == null) goto L9;
        long r106 = r105.longValue();
        int r107 = (int) (r106 ^ (r106 >>> 32));
    L10:
        int r108 = (r104 + r107) * 31;
        String r109 = this.giftName;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        Long r112 = this.giftDiamondCount;
        if (r112 == null) goto L18;
        long r113 = r112.longValue();
        r101 = (int) (r113 ^ (r113 >>> 32));
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final Long a() {
        return this.giftDiamondCount;
    }

    public final Long b() {
        return this.giftId;
    }

    public final String c() {
        return this.giftName;
    }

    public final String d() {
        return this.icon;
    }

    public ej(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.giftId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.giftType = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.giftName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.giftDiamondCount = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.icon = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(ej.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        ej r101 = (ej) r100;
        if ((!Intrinsics.areEqual(this.giftId, r101.giftId)) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(this.giftType, r101.giftType)) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(this.giftName, r101.giftName)) == false) goto L21;
        return false;
    L21:
        if ((!Intrinsics.areEqual(this.giftDiamondCount, r101.giftDiamondCount)) == false) goto L23;
        return false;
    L23:
        return true;
    }
}
