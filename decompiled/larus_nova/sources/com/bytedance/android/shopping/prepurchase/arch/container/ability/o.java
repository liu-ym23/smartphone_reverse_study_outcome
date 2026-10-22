package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f180708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f180710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f180711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f180712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ti.k f180713f;

    public static final class a implements ti.k {
        public a() {
        }

        @Override // ti.k
        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        @Override // ti.k
        public final void onFirstScreen(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onLoadSuccess(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onRuntimeReady(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void g(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // ti.k
        public final void onLoadFailed(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void onPageStart(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }

        @Override // ti.k
        public final void s(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r100, "view");
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L18;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f180708a, r101.f180708a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180709b, r101.f180709b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180710c, r101.f180710c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180711d, r101.f180711d) == true) goto L14;
        return false;
    L14:
        if (this.f180712e == r101.f180712e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f180713f, r101.f180713f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        Context r100 = this.f180708a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f180709b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ViewGroup r107 = this.f180710c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.f180711d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f180712e;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        ti.k r116 = this.f180713f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
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
        return "LynxViewOption(context=" + this.f180708a + ", url=" + this.f180709b + ", viewGroup=" + this.f180710c + ", initData=" + this.f180711d + ", autoDetachIfFail=" + this.f180712e + ", callback=" + this.f180713f + ")";
    }

    public final Context getContext() {
        return this.f180708a;
    }

    public o(Context r100, String r101, ViewGroup r102, Map<String, ? extends Object> r103, boolean r104, ti.k r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r105, "callback");
        this.f180708a = r100;
        this.f180709b = r101;
        this.f180710c = r102;
        this.f180711d = r103;
        this.f180712e = r104;
        this.f180713f = r105;
    }

    public /* synthetic */ o(Context r110, String r111, ViewGroup r112, Map r113, boolean r114, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.c.b r115, int r116) {
        if ((r116 & 4) == 0) goto L5;
        ViewGroup r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r116 & 32) == 0) goto L17;
        ti.k r103 = new a();
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
