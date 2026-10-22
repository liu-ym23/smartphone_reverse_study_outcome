package com.bytedance.android.shopping.commentv3.base;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentApiCenter f172674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f172675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SlcRenderContext f172676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fc3.a f172677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.commentv3.data.b f172678e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f172674a, r101.f172674a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172675b, r101.f172675b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172676c, r101.f172676c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172677d, r101.f172677d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f172678e, r101.f172678e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        CommentApiCenter r100 = this.f172674a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f172675b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SlcRenderContext r107 = this.f172676c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        fc3.a r110 = this.f172677d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.shopping.commentv3.data.b r113 = this.f172678e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentContext(apiCenter=" + this.f172674a + ", fragment=" + this.f172675b + ", slcRenderContext=" + this.f172676c + ", actionContext=" + this.f172677d + ", viewModel=" + this.f172678e + ")";
    }

    public final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "number");
        return this.f172677d.f476337b.f476343e.invoke(r100).intValue();
    }

    public c(CommentApiCenter r100, Fragment r101, SlcRenderContext r102, fc3.a r103, com.bytedance.android.shopping.commentv3.data.b r104) {
        Intrinsics.checkNotNullParameter(r100, "apiCenter");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "actionContext");
        Intrinsics.checkNotNullParameter(r104, "viewModel");
        this.f172674a = r100;
        this.f172675b = r101;
        this.f172676c = r102;
        this.f172677d = r103;
        this.f172678e = r104;
    }
}
