package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/m;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "c", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "", "onlineCount", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "singText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m implements vh7.h {

    @SerializedName("inroom_user_count")
    protected Integer onlineCount;

    @SerializedName("singing_song_txt")
    protected String singText;

    @SerializedName("user")
    protected IBaseUser user;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.onlineCount, r101.onlineCount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.singText, r101.singText) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IBaseUser r100 = this.user;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.onlineCount;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.singText;
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
        return "RecommendItem(user=" + this.user + ", onlineCount=" + this.onlineCount + ", singText=" + this.singText + ")";
    }

    public m() {
        this.user = null;
        this.onlineCount = null;
        this.singText = null;
    }

    public final Integer a() {
        return this.onlineCount;
    }

    public final String b() {
        return this.singText;
    }

    public final IBaseUser c() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public m(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.onlineCount = Integer.valueOf((int) r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.singText = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.user != null) goto L19;
        this.user = null;
    L19:
        if (this.onlineCount != null) goto L22;
        this.onlineCount = null;
    L22:
        if (this.singText != null) goto L37;
        this.singText = null;
        return;
    }
}
