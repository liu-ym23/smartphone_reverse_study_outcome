package com.bytedance.android.shopping.sameproduct;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements QuickDividerItemDecoration.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f182418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f182419b;

    public a() {
        Resources r100 = Resources.getSystem();
        this.f182418a = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r101 = Resources.getSystem();
        this.f182419b = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    @Override // com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration.a
    public final void a(Rect r100, QuickDividerItemDecoration.b r101) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r101.f174362c;
        if (r102 != 0) goto L8;
        int r103 = this.f182418a;
        r100.set(r103, 0, r103, 0);
        return;
    L8:
        if (r102 == 1) goto L10;
        int r104 = this.f182418a;
        r100.set(r104, 0, r104, this.f182419b);
        return;
    L10:
        int r105 = this.f182418a;
        r100.set(r105, 0, r105, r105);
    }
}
