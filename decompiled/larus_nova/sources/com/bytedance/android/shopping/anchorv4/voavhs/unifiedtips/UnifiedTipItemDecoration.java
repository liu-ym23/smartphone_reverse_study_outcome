package com.bytedance.android.shopping.anchorv4.voavhs.unifiedtips;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/unifiedtips/UnifiedTipItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnifiedTipItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f170122c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f170123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170124b;

    public static final class a {
    }

    static {
    }

    public UnifiedTipItemDecoration() {
        this.f170123a = b.b(8);
        this.f170124b = b.b(12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r101, "view");
        Object r104 = r101.getTag(R.string.ec_unified_tip_need_decoration);
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == true) goto L5;
        return;
    L5:
        int r106 = this.f170123a;
        r100.left = r106;
        r100.right = r106;
        Intrinsics.checkNotNullParameter(r101, "view");
        if (Intrinsics.areEqual(r101.getTag(R.string.ec_unified_tip_is_first), r105) == false) goto L9;
        r100.top = this.f170124b;
        return;
    }
}
