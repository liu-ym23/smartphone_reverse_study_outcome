package com.bytedance.android.shopping.feed.adapter;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.innerflow.jedi.JediBaseMultiTypeAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/QuickDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QuickDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f174356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f174357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f174358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f174359d;

    public interface a {
        void a(Rect r100, b r101);
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f174360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f174361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f174362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f174363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f174364e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ QuickDividerItemDecoration f174365f;

        public final String toString() {
            return "State{nextType=" + this.f174360a + ", preType=" + this.f174361b + ", pos=" + this.f174362c + ", curType=" + this.f174363d + ", count=" + this.f174364e + '}';
        }

        public b(QuickDividerItemDecoration r100) {
            this.f174365f = r100;
        }

        public final void a(int r100) {
            this.f174364e = this.f174365f.f174356a.getItemCount();
            int r101 = -1;
            if (r100 <= 0) goto L5;
            int r102 = this.f174365f.f174356a.getItemViewType(r100 - 1);
        L6:
            this.f174361b = r102;
            this.f174363d = this.f174365f.f174356a.getItemViewType(r100);
            if (r100 >= (this.f174365f.f174356a.getItemCount() - 2)) goto L9;
            r101 = this.f174365f.f174356a.getItemViewType(r100 + 1);
        L9:
            this.f174360a = r101;
            this.f174362c = r100;
            return;
        L5:
            r102 = -1;
            goto L6
        }
    }

    public QuickDividerItemDecoration(JediBaseMultiTypeAdapter r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, ChameleonOpenTracker.Stage.RENDER);
        new SparseArray();
        this.f174358c = new b(this);
        this.f174356a = r100;
        this.f174359d = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        super.onDraw(r100, r101, r102);
        if (this.f174356a.getItemCount() != 0) goto L5;
        return;
    L5:
        int r103 = r101.getChildCount();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        View r105 = r101.getChildAt(r104);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L14;
        RecyclerView.LayoutParams r107 = (RecyclerView.LayoutParams) r106;
        int r108 = r101.getChildAdapterPosition(r105);
        if (r108 > (this.f174356a.getItemCount() - 1)) goto L11;
        this.f174358c.a(r108);
        r104 = r104 + 1;
        goto L6
    L11:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        if (this.f174356a.getItemCount() != 0) goto L6;
        return;
    L6:
        if (this.f174357b != null) goto L8;
        this.f174357b = r102.getResources();
    L8:
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != (-1)) goto L11;
        return;
    L11:
        if (r104 > (this.f174356a.getItemCount() - 1)) goto L19;
        this.f174358c.a(r104);
        a r105 = this.f174359d;
        if (r105 == null) goto L18;
        r105.a(r100, this.f174358c);
        return;
    L18:
        return;
    }
}
