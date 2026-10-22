package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/p;", "", "", "count", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "Lcom/bytedance/android/live/ktv/common/model/api/r;", "group_users", "Ljava/util/List;", "b", "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p implements vh7.h {

    @SerializedName("count")
    protected long count;

    @SerializedName("group_user")
    protected List<r> group_users;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (this.count == r101.count) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.group_users, r101.group_users) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.count;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<r> r102 = this.group_users;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "GroupData(count=" + this.count + ", group_users=" + this.group_users + ")";
    }

    public p() {
        this.count = 0;
        this.group_users = null;
    }

    public final long a() {
        return this.count;
    }

    public final List<r> b() {
        return this.group_users;
    }

    public p(am3.g r100) {
        this.group_users = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.count = r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.group_users.add(new r(r100));
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L15;
        this.count = 0;
    L15:
        if (this.group_users.isEmpty() == false) goto L27;
        this.group_users = null;
        return;
    }
}
