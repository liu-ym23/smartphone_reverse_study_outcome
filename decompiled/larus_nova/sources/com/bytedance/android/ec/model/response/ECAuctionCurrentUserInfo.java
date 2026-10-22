package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J5\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;", "Ljava/io/Serializable;", "userName", "", "userPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "userId", "", "isSelf", "", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JZ)V", "()Z", "setSelf", "(Z)V", "getUserId", "()J", "setUserId", "(J)V", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "getUserPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setUserPic", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionCurrentUserInfo implements Serializable {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SELF)
    private boolean isSelf;

    @SerializedName("user_id")
    private long userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private String userName;

    @SerializedName("user_pic")
    private ECUrlModel userPic;

    public ECAuctionCurrentUserInfo() {
        this(null, null, 0, false, 15, null);
    }

    public static /* synthetic */ ECAuctionCurrentUserInfo copy$default(ECAuctionCurrentUserInfo r100, String r101, ECUrlModel r102, long r103, boolean r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.userName;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.userPic;
    L8:
        ECUrlModel r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.userId;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.isSelf;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.userName;
    }

    public final ECUrlModel component2() {
        return this.userPic;
    }

    public final long component3() {
        return this.userId;
    }

    public final boolean component4() {
        return this.isSelf;
    }

    public final ECAuctionCurrentUserInfo copy(String r100, ECUrlModel r101, long r110, boolean r111) {
        return new ECAuctionCurrentUserInfo(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionCurrentUserInfo) == false) goto L14;
        ECAuctionCurrentUserInfo r101 = (ECAuctionCurrentUserInfo) r100;
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userPic, r101.userPic) == true) goto L10;
        return false;
    L10:
        if (this.userId == r101.userId) goto L12;
        return false;
    L12:
        if (this.isSelf == r101.isSelf) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        String r100 = this.userName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.userPic;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.userId;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        boolean r108 = this.isSelf;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECAuctionCurrentUserInfo(userName=" + this.userName + ", userPic=" + this.userPic + ", userId=" + this.userId + ", isSelf=" + this.isSelf + ")";
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final ECUrlModel getUserPic() {
        return this.userPic;
    }

    public final boolean isSelf() {
        return this.isSelf;
    }

    public final void setSelf(boolean r100) {
        this.isSelf = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setUserName(String r100) {
        this.userName = r100;
    }

    public final void setUserPic(ECUrlModel r100) {
        this.userPic = r100;
    }

    public ECAuctionCurrentUserInfo(String r100, ECUrlModel r101, long r102, boolean r103) {
        this.userName = r100;
        this.userPic = r101;
        this.userId = r102;
        this.isSelf = r103;
    }

    public /* synthetic */ ECAuctionCurrentUserInfo(String r100, ECUrlModel r101, long r102, boolean r103, int r104, DefaultConstructorMarker r110) {
        ECUrlModel r105 = null;
        if ((r104 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r104 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r104 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r106 = r102;
        if ((r104 & 8) == 0) goto L16;
        boolean r107 = false;
    L17:
        this(r111, r105, r106, r107);
        return;
    L16:
        r107 = r103;
        goto L17
    L5:
        r111 = r100;
        goto L7
    }
}
