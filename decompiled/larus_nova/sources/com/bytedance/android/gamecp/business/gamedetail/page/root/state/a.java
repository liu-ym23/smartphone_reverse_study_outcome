package com.bytedance.android.gamecp.business.gamedetail.page.root.state;

import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;
import dt.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f55589d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f55590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f55592c;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.page.root.state.a$a, reason: collision with other inner class name */
    public static final class C0896a {
        public static u a() {
            return new u("game_order_state");
        }
    }

    static {
    }

    public a() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55590a, r101.f55590a) == true) goto L8;
        return false;
    L8:
        if (this.f55591b == r101.f55591b) goto L10;
        return false;
    L10:
        if (this.f55592c == r101.f55592c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        h r100 = this.f55590a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f55591b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f55592c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderState(request=" + this.f55590a + ", orderSuccess=" + this.f55591b + ", isCancel=" + this.f55592c + ")";
    }

    public /* synthetic */ a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        h r102 = new h(false, false, 7);
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = false;
    L9:
        this(r102, r100, false);
        return;
    L5:
        r102 = null;
        goto L7
    }

    public a(h r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f55590a = r100;
        this.f55591b = r101;
        this.f55592c = r102;
    }

    public static a c(a r100, h r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f55590a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f55591b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f55592c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "request");
        return new a(r101, r102, r103);
    }
}
