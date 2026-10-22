package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/AdapterScreenSimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterScreenSimpleDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f173871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f173872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f173873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f173875e;

    public AdapterScreenSimpleDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AdapterScreenSimpleDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        Integer r102 = this.f173875e;
        if (r102 == null) goto L8;
        if (r102.intValue() <= 0) goto L8;
        this.f173873c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f173872b.reset();
        this.f173872b.addRoundRect(this.f173873c, this.f173875e.intValue(), this.f173875e.intValue(), Path.Direction.CW);
        r100.clipPath(this.f173872b);
    L10:
        super.onDraw(r100);
        r100.restoreToCount(r101);
        return;
    L8:
        if (this.f173874d == false) goto L10;
        this.f173873c.set(0.0f, 0.0f, getWidth(), getHeight());
        r100.drawRect(this.f173873c, this.f173871a);
        goto L10
    }

    public AdapterScreenSimpleDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f173871a = r103;
        this.f173872b = new Path();
        this.f173873c = new RectF();
        a r105 = a.f173924e;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.customBg, R.attr.customMarginBottom, R.attr.customMarginLeft, R.attr.customMarginRight, R.attr.customMarginTop, R.attr.customRadius}, 0, 0);
        String r107 = r106.getString(0);
        if (r107 != null) goto L5;
    L10:
        int r108 = r106.getInt(5, 0);
        if (r105 == null) goto L13;
        DeepFeedFoldHelper.d();
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r110 = com.bytedance.android.ec.hybrid.list.util.c.c(Integer.valueOf(r108), r105.f173928d, true);
    L14:
        this.f173875e = Integer.valueOf(r110);
        r106.recycle();
        return;
    L13:
        int r111 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r110 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r108));
        goto L14
    L5:
        if (r107.length() <= 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == false) goto L10;
        r103.setColor(ColorProtector.parseColor(r107));
        this.f173874d = true;
        goto L10
    L7:
        r112 = false;
        goto L8
    }

    public /* synthetic */ AdapterScreenSimpleDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
