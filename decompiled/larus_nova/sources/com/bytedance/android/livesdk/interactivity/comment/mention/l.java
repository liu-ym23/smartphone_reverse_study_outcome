package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f135310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f135311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f135312c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f135310a, r101.f135310a) == true) goto L8;
        return false;
    L8:
        if (this.f135311b == r101.f135311b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f135312c, r101.f135312c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        IBaseUser r100 = this.f135310a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f135311b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f135312c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MentionUserItem(user=" + this.f135310a + ", isSelected=" + this.f135311b + ", tags=" + this.f135312c + ")";
    }

    public l(IBaseUser r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f135310a = r100;
        this.f135311b = false;
        this.f135312c = r101;
    }
}
