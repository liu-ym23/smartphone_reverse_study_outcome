package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User", "", "", "component1", "component2", "avatar", InstantPlayContext.NICKNAME, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "getNickname", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$User {
    private final String avatar;
    private final String nickname;

    public static /* synthetic */ CommonModel$User copy$default(CommonModel$User r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.avatar;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.nickname;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickname;
    }

    public final CommonModel$User copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        Intrinsics.checkNotNullParameter(r101, InstantPlayContext.NICKNAME);
        return new CommonModel$User(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$User) == false) goto L10;
        CommonModel$User r101 = (CommonModel$User) r100;
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.avatar;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nickname;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "User(avatar=" + this.avatar + ", nickname=" + this.nickname + ")";
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public CommonModel$User(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        Intrinsics.checkNotNullParameter(r101, InstantPlayContext.NICKNAME);
        this.avatar = r100;
        this.nickname = r101;
    }
}
