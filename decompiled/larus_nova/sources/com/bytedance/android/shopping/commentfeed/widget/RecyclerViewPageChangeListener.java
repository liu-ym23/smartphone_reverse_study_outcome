package com.bytedance.android.shopping.commentfeed.widget;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/RecyclerViewPageChangeListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RecyclerViewPageChangeListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f172443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SnapHelper f172445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f172446d;

    public interface a {
        void a(int r100);

        void c();

        void onPageSelected(int r100);
    }

    public RecyclerViewPageChangeListener(PagerSnapHelper r100, com.bytedance.android.shopping.commentfeed.view.c r101) {
        Intrinsics.checkNotNullParameter(r100, "snapHelper");
        this.f172445c = r100;
        this.f172446d = r101;
        this.f172443a = -1;
        this.f172444b = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if (r102 == null) goto L7;
        View r103 = this.f172445c.findSnapView(r102);
        if (r103 == null) goto L7;
        int r104 = r102.getPosition(r103);
    L8:
        a r105 = this.f172446d;
        if (r105 == null) goto L11;
        r105.c();
    L11:
        if (r101 == 0) goto L13;
        return;
    L13:
        if (this.f172443a == r104) goto L19;
        this.f172443a = r104;
        a r106 = this.f172446d;
        if (r106 == null) goto L20;
        r106.onPageSelected(r104);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if (r103 == null) goto L7;
        View r104 = this.f172445c.findSnapView(r103);
        if (r104 == null) goto L7;
        int r105 = r103.getPosition(r104);
    L9:
        if (this.f172444b == r105) goto L14;
        this.f172444b = r105;
        a r106 = this.f172446d;
        if (r106 == null) goto L15;
        r106.a(r105);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r105 = 0;
        goto L9
    }
}
