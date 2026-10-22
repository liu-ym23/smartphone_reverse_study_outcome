package com.bytedance.android.live.liveinteract.revenue.fight.dialog;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dialog/SelectDurationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectDurationDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f78106a;

    public SelectDurationDecoration() {
        Paint r100 = new Paint();
        this.f78106a = r100;
        r100.setAntiAlias(true);
        r100.setColor(ColorProtector.parseColor("#1F161823"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDrawOver(r110, r111, r112);
        float r100 = s1.f(48.0f);
        float r113 = r111.getPaddingLeft();
        float r101 = r100 * 2;
        float r114 = r111.getWidth() - r111.getPaddingRight();
        float r102 = 1;
        r110.drawRect(r113, r100, r114, r100 + r102, this.f78106a);
        r110.drawRect(r113, r101, r114, r102 + r101, this.f78106a);
    }
}
