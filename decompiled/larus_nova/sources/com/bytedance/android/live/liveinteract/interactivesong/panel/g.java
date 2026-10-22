package com.bytedance.android.live.liveinteract.interactivesong.panel;

import com.bytedance.android.livesdk.chatroom.model.interact.IMVTab;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMVTab f74147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IMVTab> f74148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f74149c;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f74147a, r101.f74147a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f74148b, r101.f74148b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f74149c, r101.f74149c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IMVTab r100 = this.f74147a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<IMVTab> r104 = this.f74148b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.f74149c;
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
        return "MvSelectUIState(defaultTab=" + this.f74147a + ", tabList=" + this.f74148b + ", tabMvData=" + this.f74149c + ")";
    }

    public /* synthetic */ g(int r100) {
        this((IMVTab) vh7.f.c(IMVTab.class), CollectionsKt.emptyList(), new f(null, 3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(IMVTab r100, List<? extends IMVTab> r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "defaultTab");
        Intrinsics.checkNotNullParameter(r101, "tabList");
        Intrinsics.checkNotNullParameter(r102, "tabMvData");
        this.f74147a = r100;
        this.f74148b = r101;
        this.f74149c = r102;
    }

    public static g a(g r100, IMVTab r101, List r102, f r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f74147a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f74148b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f74149c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "defaultTab");
        Intrinsics.checkNotNullParameter(r102, "tabList");
        Intrinsics.checkNotNullParameter(r103, "tabMvData");
        return new g(r101, r102, r103);
    }
}
