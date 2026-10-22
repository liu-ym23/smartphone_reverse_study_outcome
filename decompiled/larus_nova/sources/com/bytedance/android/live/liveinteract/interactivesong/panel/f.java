package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMVTab f74145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<i> f74146b;

    public f() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f74145a, r101.f74145a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f74146b, r101.f74146b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        IMVTab r100 = this.f74145a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<i> r104 = this.f74146b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MvSelectTabBean(tabName=" + this.f74145a + ", mvList=" + this.f74146b + ")";
    }

    public /* synthetic */ f(IMVTab r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = (IMVTab) vh7.f.c(IMVTab.class);
    L6:
        if ((r101 & 2) == 0) goto L8;
        ArrayList r102 = new ArrayList();
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public f(IMVTab r100, List<i> r101) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "mvList");
        this.f74145a = r100;
        this.f74146b = r101;
    }
}
