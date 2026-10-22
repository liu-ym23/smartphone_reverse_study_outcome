package com.bytedance.android.shopping.anchorv3.detail;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/StaggeredGridDoubleColumnDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StaggeredGridDoubleColumnDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f164806g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f164807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f164808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f164809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f164810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f164811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<View, Boolean> f164812f;

    public static final class a {
        public a() {
        }

        public static boolean a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            return Intrinsics.areEqual("need_decoration", r100.getTag());
        }

        public static void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r101 == false) goto L5;
            r100.setTag("need_decoration");
            return;
        L5:
            r100.setTag(null);
        }
    }

    static {
        f164806g = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (this.f164812f.invoke(r101).booleanValue() == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L17;
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (r105.isFullSpan() == false) goto L11;
        int r106 = this.f164810d;
        r100.left = r106;
        r100.right = r106;
        r100.top = this.f164811e;
        return;
    L11:
        if ((r105.getSpanIndex() % 2) != 0) goto L13;
        r100.left = this.f164808b;
        r100.right = this.f164809c;
    L14:
        r100.top = this.f164807a;
        return;
    L13:
        r100.left = this.f164809c;
        r100.right = this.f164808b;
        goto L14
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StaggeredGridDoubleColumnDecoration(float r100, float r101, float r102, float r103, float r104, Function1<? super View, Boolean> r105) {
        Intrinsics.checkNotNullParameter(r105, "needDecoration");
        this.f164812f = r105;
        ECAppInfoService r106 = ECAppInfoService.f48114e;
        this.f164807a = (int) UIUtils.dip2Px(r106.getApplicationContext(), r104);
        this.f164808b = (int) UIUtils.dip2Px(r106.getApplicationContext(), r102);
        this.f164809c = (int) (UIUtils.dip2Px(r106.getApplicationContext(), r103) / 2);
        this.f164810d = (int) UIUtils.dip2Px(r106.getApplicationContext(), r100);
        this.f164811e = (int) UIUtils.dip2Px(r106.getApplicationContext(), r101);
    }
}
