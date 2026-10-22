package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/FirstRowTopPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstRowTopPaddingDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f127743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f127744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f127745c;

    public static final class a {
    }

    static {
    }

    public FirstRowTopPaddingDecoration() {
        this.f127744b = true;
        this.f127745c = 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f127745c;
        if (r104 < 0) goto L9;
        if (r105 < r104) goto L9;
        if (this.f127744b == false) goto L9;
        r100.top = (int) UtilityKotlinExtentionsKt.h(58);
        return;
    L9:
        r100.top = 0;
    }
}
