package com.bytedance.android.live.profit.privilege.model.danmu;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b1\u00102J\u0011\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003Jm\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0013\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0014\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b(\u0010'R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b)\u0010$R\u0017\u0010\u0016\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b-\u0010,R\u001f\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/PrivilegeBarrageResponse;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "component1", "", "component2", "", "component3", "component4", "component5", "", "component6", "component7", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component8", "user", "orderId", "leftDiamond", RemoteMessageConst.MSGID, "toast", "skin", "showIdentity", "identityLabel", "copy", "toString", "hashCode", "other", "", "equals", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Ljava/lang/String;", "getOrderId", "()Ljava/lang/String;", "J", "getLeftDiamond", "()J", "getMsgId", "getToast", "I", "getSkin", "()I", "getShowIdentity", "Lpy/k;", "getIdentityLabel", "()Lpy/k;", "<init>", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;Ljava/lang/String;JJLjava/lang/String;IILpy/k;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeBarrageResponse {
    private final k identityLabel;
    private final long leftDiamond;
    private final long msgId;
    private final String orderId;
    private final int showIdentity;
    private final int skin;
    private final String toast;
    private final IBaseUser user;

    public static /* synthetic */ PrivilegeBarrageResponse copy$default(PrivilegeBarrageResponse r110, IBaseUser r111, String r112, long r113, long r114, String r115, int r116, int r210, k r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        IBaseUser r100 = r110.user;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.orderId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.leftDiamond;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.msgId;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.toast;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.skin;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r117 = r110.showIdentity;
    L31:
        if ((r212 & 128) == 0) goto L33;
        k r106 = r110.identityLabel;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
    L33:
        r106 = r211;
        goto L35
    L29:
        r117 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final IBaseUser component1() {
        return this.user;
    }

    public final String component2() {
        return this.orderId;
    }

    public final long component3() {
        return this.leftDiamond;
    }

    public final long component4() {
        return this.msgId;
    }

    public final String component5() {
        return this.toast;
    }

    public final int component6() {
        return this.skin;
    }

    public final int component7() {
        return this.showIdentity;
    }

    public final k component8() {
        return this.identityLabel;
    }

    public final PrivilegeBarrageResponse copy(IBaseUser r110, String r111, long r112, long r113, String r114, int r210, int r211, k r212) {
        return new PrivilegeBarrageResponse(r110, r111, r112, r113, r114, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PrivilegeBarrageResponse) == false) goto L22;
        PrivilegeBarrageResponse r101 = (PrivilegeBarrageResponse) r100;
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderId, r101.orderId) == true) goto L10;
        return false;
    L10:
        if (this.leftDiamond == r101.leftDiamond) goto L12;
        return false;
    L12:
        if (this.msgId == r101.msgId) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L16;
        return false;
    L16:
        if (this.skin == r101.skin) goto L18;
        return false;
    L18:
        if (this.showIdentity == r101.showIdentity) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.identityLabel, r101.identityLabel) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        IBaseUser r100 = this.user;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.orderId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.leftDiamond;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.msgId;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.toast;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (((((r110 + r112) * 31) + this.skin) * 31) + this.showIdentity) * 31;
        k r114 = this.identityLabel;
        if (r114 == null) goto L18;
        r101 = r114.hashCode();
    L18:
        return r113 + r101;
    L13:
        r112 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PrivilegeBarrageResponse(user=" + this.user + ", orderId=" + this.orderId + ", leftDiamond=" + this.leftDiamond + ", msgId=" + this.msgId + ", toast=" + this.toast + ", skin=" + this.skin + ", showIdentity=" + this.showIdentity + ", identityLabel=" + this.identityLabel + ")";
    }

    public final k getIdentityLabel() {
        return this.identityLabel;
    }

    public final long getLeftDiamond() {
        return this.leftDiamond;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getShowIdentity() {
        return this.showIdentity;
    }

    public final int getSkin() {
        return this.skin;
    }

    public final String getToast() {
        return this.toast;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    public PrivilegeBarrageResponse(IBaseUser r100, String r101, long r102, long r103, String r104, int r105, int r106, k r110) {
        this.user = r100;
        this.orderId = r101;
        this.leftDiamond = r102;
        this.msgId = r103;
        this.toast = r104;
        this.skin = r105;
        this.showIdentity = r106;
        this.identityLabel = r110;
    }
}
