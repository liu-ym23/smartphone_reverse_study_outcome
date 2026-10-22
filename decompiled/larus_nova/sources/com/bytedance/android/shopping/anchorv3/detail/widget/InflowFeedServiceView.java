package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.feed.widget.HorizontalSplitTextViewGroup;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "Lcom/bytedance/android/shopping/feed/widget/HorizontalSplitTextViewGroup;", "", "Lcom/bytedance/android/shopping/feed/view/c;", "", "resId", "", "setDividerDrawableRes", "b", "I", "getTextColor", "()I", "setTextColor", "(I)V", "textColor", "", "c", FaceService.girlLabel, "getTextSizeDP", "()F", "setTextSizeDP", "(F)V", "textSizeDP", "d", "getDesiredChildHeight", "setDesiredChildHeight", "desiredChildHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedServiceView extends HorizontalSplitTextViewGroup<String> implements com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f164871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f164872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f164873d;

    public InflowFeedServiceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowFeedServiceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final int getDesiredChildHeight() {
        return this.f164873d;
    }

    public final int getTextColor() {
        return this.f164871b;
    }

    public final float getTextSizeDP() {
        return this.f164872c;
    }

    @Override // com.bytedance.android.shopping.feed.widget.HorizontalSplitTextViewGroup
    public final void b(List<? extends String> r100) {
        super.b(r100);
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        String r102 = (String) r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L6;
        TextView r103 = getServiceView();
        r103.setIncludeFontPadding(false);
        r103.setGravity(17);
        r103.setLayoutParams(new LinearLayout.LayoutParams(-2, this.f164873d));
        r103.setSingleLine();
        r103.setTextColor(this.f164871b);
        r103.setTextSize(1, this.f164872c);
        r103.setVisibility(0);
        r103.setText(r102);
        addView(r103);
        goto L6
    L16:
        return;
    }

    public final void setDesiredChildHeight(int r100) {
        this.f164873d = r100;
    }

    public final void setDividerDrawableRes(int r100) {
        setDividerDrawable(ag4.a.c(r100));
    }

    public final void setTextColor(int r100) {
        this.f164871b = r100;
    }

    public final void setTextSizeDP(float r100) {
        this.f164872c = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (View.MeasureSpec.getMode(r110) != 1073741824) goto L38;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r110), 0), r111);
        int r112 = View.MeasureSpec.getSize(r110);
        Iterator<T> r113 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r113.hasNext() == false) goto L37;
        Object r103 = r113.next();
        int r104 = r101 + 1;
        if (r101 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        View r105 = (View) r103;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r106 = null;
    L13:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r101 != 0) goto L23;
        int r108 = r105.getMeasuredWidth();
        if (r107 == null) goto L18;
        int r109 = r107.leftMargin;
    L19:
        int r114 = r108 + r109;
        if (r107 == null) goto L22;
        int r115 = r107.rightMargin;
    L32:
        r102 = r102 + (r114 + r115);
        if (r102 <= r112) goto L35;
        r105.setVisibility(8);
    L36:
        r101 = r104;
        goto L6
    L35:
        r100 = r102;
        goto L36
    L22:
        r115 = 0;
        goto L32
    L18:
        r109 = 0;
        goto L19
    L23:
        int r116 = r105.getMeasuredWidth();
        if (r107 == null) goto L26;
        int r117 = r107.leftMargin;
    L27:
        int r118 = r116 + r117;
        if (r107 == null) goto L30;
        int r119 = r107.rightMargin;
    L31:
        r114 = r118 + r119;
        Resources r120 = Resources.getSystem();
        r115 = MathKt.roundToInt(TypedValue.applyDimension(1, 9, WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics())));
        goto L32
    L30:
        r119 = 0;
        goto L31
    L26:
        r117 = 0;
        goto L27
    L37:
        setMeasuredDimension(r100, getMeasuredHeight());
        return;
    L38:
        super.onMeasure(r110, r111);
    }

    public InflowFeedServiceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164871b = ag4.a.b(R.color.commerce_color_161823);
        this.f164872c = 12.0f;
        Resources r103 = Resources.getSystem();
        this.f164873d = MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        setDividerDrawable(ag4.a.c(R.drawable.commerce_divider_feed_service));
        Resources r104 = Resources.getSystem();
        setDividerPadding(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
    }

    public /* synthetic */ InflowFeedServiceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
