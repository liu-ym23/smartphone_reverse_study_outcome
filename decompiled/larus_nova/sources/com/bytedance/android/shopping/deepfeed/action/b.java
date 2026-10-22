package com.bytedance.android.shopping.deepfeed.action;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.DeepFeedProductFragment;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductSnapHelper;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f173048a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.action.b$a$a, reason: collision with other inner class name */
        public static final class C2589a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function0<RecyclerView> f173049a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CoroutineScope f173050b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Context f173051c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final DeepFeedProductViewModel f173052d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final LifecycleOwner f173053e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final SnapHelper f173054f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final Function0<Fragment> f173055g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final Function1<Boolean, Unit> f173056h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final Fragment f173057i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final boolean f173058j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final boolean f173059k;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2589a) == false) goto L28;
                C2589a r101 = (C2589a) r100;
                if (Intrinsics.areEqual(this.f173049a, r101.f173049a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f173050b, r101.f173050b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f173051c, r101.f173051c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f173052d, r101.f173052d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f173053e, r101.f173053e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f173054f, r101.f173054f) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f173055g, r101.f173055g) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.f173056h, r101.f173056h) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.f173057i, r101.f173057i) == true) goto L24;
                return false;
            L24:
                if (this.f173058j == r101.f173058j) goto L26;
                return false;
            L26:
                if (this.f173059k == r101.f173059k) goto L43;
                return false;
            L43:
                return true;
            L28:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v20, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23, types: [int] */
            /* JADX WARN: Type inference failed for: r2v24 */
            public final int hashCode() {
                Function0<RecyclerView> r100 = this.f173049a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                CoroutineScope r104 = this.f173050b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Context r107 = this.f173051c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                DeepFeedProductViewModel r110 = this.f173052d;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                LifecycleOwner r113 = this.f173053e;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                SnapHelper r116 = this.f173054f;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                Function0<Fragment> r119 = this.f173055g;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                Function1<Boolean, Unit> r122 = this.f173056h;
                if (r122 == null) goto L33;
                int r123 = r122.hashCode();
            L34:
                int r124 = (r121 + r123) * 31;
                Fragment r125 = this.f173057i;
                if (r125 == null) goto L37;
                r101 = r125.hashCode();
            L37:
                int r126 = (r124 + r101) * 31;
                boolean r127 = this.f173058j;
                ?? r128 = 1;
                ?? r129 = r127;
                if (r127 == false) goto L40;
                r129 = 1;
            L40:
                int r130 = (r126 + r129) * 31;
                boolean r131 = this.f173059k;
                if (r131 == true) goto L45;
                r128 = r131;
            L45:
                return r130 + r128;
            L33:
                r123 = 0;
                goto L34
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
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
                return "Config(rvProvider=" + this.f173049a + ", lifeScope=" + this.f173050b + ", context=" + this.f173051c + ", viewModel=" + this.f173052d + ", lifeOwner=" + this.f173053e + ", snapHelper=" + this.f173054f + ", fragment=" + this.f173055g + ", updateCurState=" + this.f173056h + ", container=" + this.f173057i + ", gestureTrackingEnabled=" + this.f173058j + ", infoSwipeEnterDetailEnabled=" + this.f173059k + ")";
            }

            public final Context getContext() {
                return this.f173051c;
            }

            public C2589a(Function0 r100, LifecycleCoroutineScope r101, FragmentActivity r102, DeepFeedProductViewModel r103, LifecycleOwner r104, DeepFeedProductSnapHelper r105, Function0 r106, Function1 r107, DeepFeedProductFragment r110, boolean r111, boolean r112) {
                Intrinsics.checkNotNullParameter(r100, "rvProvider");
                Intrinsics.checkNotNullParameter(r101, "lifeScope");
                Intrinsics.checkNotNullParameter(r103, "viewModel");
                Intrinsics.checkNotNullParameter(r104, "lifeOwner");
                Intrinsics.checkNotNullParameter(r105, "snapHelper");
                Intrinsics.checkNotNullParameter(r106, WidgetService.PARAM_FRAGMENT);
                Intrinsics.checkNotNullParameter(r107, "updateCurState");
                Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
                this.f173049a = r100;
                this.f173050b = r101;
                this.f173051c = r102;
                this.f173052d = r103;
                this.f173053e = r104;
                this.f173054f = r105;
                this.f173055g = r106;
                this.f173056h = r107;
                this.f173057i = r110;
                this.f173058j = r111;
                this.f173059k = r112;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void c() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void h() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void i() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void j() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void k() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void l() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void m() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void n() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void o() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void p(com.bytedance.android.shopping.deepfeed.viewmodel.b r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void q() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void r(com.bytedance.android.shopping.deepfeed.viewmodel.e r100) {
        Intrinsics.checkNotNullParameter(r100, "shopStatus");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void s() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void z() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public Context getContext() {
        return h.a.getContext(this);
    }

    public b() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "popupType");
        Intrinsics.checkNotNullParameter(r100, "popupType");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void t(com.bytedance.android.shopping.deepfeed.data.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void u(com.bytedance.android.shopping.deepfeed.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r100, "status");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.h
    public final void y(com.bytedance.android.shopping.deepfeed.data.d r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
    }
}
