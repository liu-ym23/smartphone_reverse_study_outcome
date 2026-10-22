package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB%\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/PriceView;", "Landroid/widget/LinearLayout;", "", "colorString", "", "setColorRedValue", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f177485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f177486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f177487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f177488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f177489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f177490f;

    public PriceView(Context r110) {
        super(r110);
        Lazy r111 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r112 = "#FE496A";
    L6:
        this.f177485a = ColorProtector.parseColor(r112);
        TextView r113 = new TextView(getContext());
        r113.setTextColor(this.f177485a);
        r113.setTextSize(1, 13.0f);
        r113.setIncludeFontPadding(false);
        r113.setMaxLines(1);
        r113.setEllipsize(TextUtils.TruncateAt.END);
        Unit r100 = Unit.INSTANCE;
        this.f177486b = r113;
        TextView r101 = new TextView(getContext());
        r101.setTextColor(this.f177485a);
        r101.setTextSize(1, 18.0f);
        r101.setIncludeFontPadding(false);
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        this.f177487c = r101;
        TextView r102 = new TextView(getContext());
        r102.setTextColor(this.f177485a);
        r102.setTextSize(1, 13.0f);
        r102.setIncludeFontPadding(false);
        r102.setMaxLines(1);
        r102.setEllipsize(TextUtils.TruncateAt.END);
        this.f177488d = r102;
        TextView r103 = new TextView(getContext());
        r103.setTextColor(this.f177485a);
        r103.setTextSize(1, 11.0f);
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        this.f177489e = r103;
        TextView r104 = new TextView(getContext());
        r104.setTextColor(this.f177485a);
        r104.setTextSize(1, 11.0f);
        r104.setIncludeFontPadding(false);
        r104.setMaxLines(1);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        this.f177490f = r104;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -2);
        r105.bottomMargin = b0.c(1);
        addView(r113, r105);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.setMargins(b0.c(1), 0, 0, 0);
        addView(r101, r114);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -2);
        r115.bottomMargin = b0.c(1);
        addView(r102, r115);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r103, r116);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -2);
        r117.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r104, r117);
        return;
    L5:
        r112 = "#FF002A";
        goto L6
    }

    public final void setColorRedValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "colorString");
        this.f177485a = Color.parseColor(r100);     // Catch: Exception -> L5
    L7:
        this.f177486b.setTextColor(this.f177485a);
        this.f177487c.setTextColor(this.f177485a);
        this.f177488d.setTextColor(this.f177485a);
        this.f177489e.setTextColor(this.f177485a);
        this.f177490f.setTextColor(this.f177485a);
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "an error occurs when parsing color " + r100);
        goto L7
    }

    public PriceView(Context r100, AttributeSet r110) {
        super(r100, r110);
        Lazy r101 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r102 = "#FE496A";
    L6:
        this.f177485a = ColorProtector.parseColor(r102);
        TextView r103 = new TextView(getContext());
        r103.setTextColor(this.f177485a);
        r103.setTextSize(1, 13.0f);
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        Unit r104 = Unit.INSTANCE;
        this.f177486b = r103;
        TextView r105 = new TextView(getContext());
        r105.setTextColor(this.f177485a);
        r105.setTextSize(1, 18.0f);
        r105.setIncludeFontPadding(false);
        r105.setMaxLines(1);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        this.f177487c = r105;
        TextView r106 = new TextView(getContext());
        r106.setTextColor(this.f177485a);
        r106.setTextSize(1, 13.0f);
        r106.setIncludeFontPadding(false);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        this.f177488d = r106;
        TextView r107 = new TextView(getContext());
        r107.setTextColor(this.f177485a);
        r107.setTextSize(1, 11.0f);
        r107.setIncludeFontPadding(false);
        r107.setMaxLines(1);
        r107.setEllipsize(TextUtils.TruncateAt.END);
        this.f177489e = r107;
        TextView r108 = new TextView(getContext());
        r108.setTextColor(this.f177485a);
        r108.setTextSize(1, 11.0f);
        r108.setIncludeFontPadding(false);
        r108.setMaxLines(1);
        r108.setEllipsize(TextUtils.TruncateAt.END);
        this.f177490f = r108;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -2);
        r109.bottomMargin = b0.c(1);
        addView(r103, r109);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r111.setMargins(b0.c(1), 0, 0, 0);
        addView(r105, r111);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.bottomMargin = b0.c(1);
        addView(r106, r112);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
        r113.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r107, r113);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r108, r114);
        return;
    L5:
        r102 = "#FF002A";
        goto L6
    }

    public PriceView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        Lazy r102 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.m() == false) goto L5;
        String r103 = "#FE496A";
    L6:
        this.f177485a = ColorProtector.parseColor(r103);
        TextView r104 = new TextView(getContext());
        r104.setTextColor(this.f177485a);
        r104.setTextSize(1, 13.0f);
        r104.setIncludeFontPadding(false);
        r104.setMaxLines(1);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        Unit r105 = Unit.INSTANCE;
        this.f177486b = r104;
        TextView r106 = new TextView(getContext());
        r106.setTextColor(this.f177485a);
        r106.setTextSize(1, 18.0f);
        r106.setIncludeFontPadding(false);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        this.f177487c = r106;
        TextView r107 = new TextView(getContext());
        r107.setTextColor(this.f177485a);
        r107.setTextSize(1, 13.0f);
        r107.setIncludeFontPadding(false);
        r107.setMaxLines(1);
        r107.setEllipsize(TextUtils.TruncateAt.END);
        this.f177488d = r107;
        TextView r111 = new TextView(getContext());
        r111.setTextColor(this.f177485a);
        r111.setTextSize(1, 11.0f);
        r111.setIncludeFontPadding(false);
        r111.setMaxLines(1);
        r111.setEllipsize(TextUtils.TruncateAt.END);
        this.f177489e = r111;
        TextView r108 = new TextView(getContext());
        r108.setTextColor(this.f177485a);
        r108.setTextSize(1, 11.0f);
        r108.setIncludeFontPadding(false);
        r108.setMaxLines(1);
        r108.setEllipsize(TextUtils.TruncateAt.END);
        this.f177490f = r108;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -2);
        r109.bottomMargin = b0.c(1);
        addView(r104, r109);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.setMargins(b0.c(1), 0, 0, 0);
        addView(r106, r112);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
        r113.bottomMargin = b0.c(1);
        addView(r107, r113);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.setMargins(b0.c(1), 0, 0, b0.c(1));
        addView(r111, r114);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -2);
        r115.setMargins(b0.c(4), 0, b0.c(7), b0.c(1));
        addView(r108, r115);
        return;
    L5:
        r103 = "#FF002A";
        goto L6
    }
}
