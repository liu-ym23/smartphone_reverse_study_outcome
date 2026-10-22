package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class y extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f184755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f184756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f184757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f184758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f184759e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = getBounds().right;
        int r101 = getBounds().bottom;
        this.f184755a.setColor(th.a.a(this.f184756b, R.color.shopping_std_line_black_3));
        this.f184755a.setAntiAlias(true);
        this.f184755a.setTextSize(UIUtils.dip2Px(this.f184756b, this.f184759e));
        r110.save();
        r110.rotate(this.f184758d);
        float r102 = this.f184755a.measureText(this.f184757c);
        int r103 = 0;
        Iterator<Integer> r104 = RangesKt.step(new IntRange(0, r101), vf4.a.b(Float.valueOf(120.0f))).iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        int r105 = ((IntIterator) r104).nextInt();
        IntProgression r106 = RangesKt.step(new IntRange((int) ((-r100) + ((r103 % 2) * r102)), r100), (int) (vf4.a.b(Float.valueOf(64.0f)) + r102));
        int r107 = r106.getFirst();
        int r108 = r106.getLast();
        int r109 = r106.getStep();
        if (r109 < 0) goto L9;
        if (r107 <= r108) goto L10;
    L13:
        r103 = r103 + 1;
    L10:
        r110.drawText(this.f184757c, r107, r105, this.f184755a);
        if (r107 == r108) goto L13;
        r107 = r107 + r109;
        goto L10
    L9:
        if (r107 < r108) goto L13;
    L14:
        r110.restore();
    }

    public y(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "label");
        this.f184756b = r100;
        this.f184757c = r101;
        this.f184758d = -15.0f;
        this.f184759e = 12.0f;
        this.f184755a = new Paint();
    }
}
