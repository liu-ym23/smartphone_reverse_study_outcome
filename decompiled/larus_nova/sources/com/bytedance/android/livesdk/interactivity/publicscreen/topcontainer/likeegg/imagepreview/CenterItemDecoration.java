package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/CenterItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CenterItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f139962a;

    public static final class a {
    }

    static {
    }

    public CenterItemDecoration(Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWidth");
        this.f139962a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r103.getItemCount();
        int r105 = r102.getChildAdapterPosition(r101);
        if (r105 != 0) goto L5;
    L7:
        int r106 = (r102.getMeasuredWidth() - this.f139962a.invoke().intValue()) / 2;
        if (r105 != 0) goto L11;
        r100.left = r106;
        return;
    L11:
        if (r105 != (r104 - 1)) goto L15;
        r100.right = r106;
        return;
    L15:
        return;
    L5:
        if (r105 == (r104 - 1)) goto L7;
    }
}
