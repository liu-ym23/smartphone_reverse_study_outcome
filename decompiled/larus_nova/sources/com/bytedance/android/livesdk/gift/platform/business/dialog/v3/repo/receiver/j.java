package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.t2;
import com.bytedance.android.livesdk.gift.model.w0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IBaseUser> f128476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f128477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t2> f128478c;

    public /* synthetic */ j() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f128476a, r101.f128476a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f128477b, r101.f128477b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f128478c, r101.f128478c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<IBaseUser> r100 = this.f128476a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        w0 r104 = this.f128477b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<t2> r107 = this.f128478c;
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
        return "GiftReceiverListData(userList=" + this.f128476a + ", groupShowInfo=" + this.f128477b + ", newGroupUserInfo=" + this.f128478c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends IBaseUser> r100, w0 r101, List<? extends t2> r102) {
        Intrinsics.checkNotNullParameter(r100, "userList");
        this.f128476a = r100;
        this.f128477b = r101;
        this.f128478c = r102;
    }
}
