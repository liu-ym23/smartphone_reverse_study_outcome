package com.bytedance.android.live.search.impl.search.viewmodel;

import com.bytedance.android.live.base.model.user.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<User> f100849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f100850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f100851c;

    public a() {
        this(null, 0, true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f100849a, r101.f100849a) == true) goto L8;
        return false;
    L8:
        if (this.f100850b == r101.f100850b) goto L10;
        return false;
    L10:
        if (this.f100851c == r101.f100851c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        List<User> r100 = this.f100849a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f100850b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f100851c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveSearchUserResultCacheItem(userList=" + this.f100849a + ", cursor=" + this.f100850b + ", hasMore=" + this.f100851c + ")";
    }

    public a(List<User> r100, long r101, boolean r102) {
        this.f100849a = r100;
        this.f100850b = r101;
        this.f100851c = r102;
    }
}
