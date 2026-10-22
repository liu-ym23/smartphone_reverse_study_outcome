package com.bytedance.android.live.recharge.platform.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/ui/DiamondFitTextView;", "Lcom/bytedance/android/live/core/widget/LiveTextView;", "", "size", "", "setDesTextSize", "", "getAvailableWidth", "()I", "availableWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondFitTextView extends LiveTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f90250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f90251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f90252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f90253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f90254g;

    private final int getAvailableWidth() {
        ViewParent r100 = getParent();
        int r101 = 0;
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r102 = (ViewGroup) r100;
        if (r102.getWidth() != 0) goto L7;
        return 0;
    L7:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L8:
        if (r101 >= r103) goto L14;
        if (r102.getChildAt(r101) == this) goto L12;
        r104 = r104 + r102.getChildAt(r101).getWidth();
    L12:
        r101 = r101 + 1;
        goto L8
    L14:
        return (r102.getWidth() - r104) - 20;
    L15:
        return 0;
    }

    public DiamondFitTextView(Context r100) {
        this(r100, null);
    }

    public final void setDesTextSize(float r100) {
        this.f90251d = r100;
    }

    public final void y(String r100) {
        if (r100 != null) goto L4;
    L6:
        setTextSize(0, this.f90250c);
        z(r100, this.f90251d, false);
        return;
    L4:
        if (r100.length() <= 5) goto L6;
        this.f90250c = s1.f(15.0f);
        goto L6
    }

    public DiamondFitTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        new TextPaint();
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ttlive_fit_des_text_size});
        this.f90251d = r102.getDimensionPixelSize(0, s1.f(13.0f));
        r102.recycle();
    L5:
        new TextPaint().set(getPaint());
        this.f90250c = getTextSize();
    }

    public final void z(String r100, float r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r101 == 0.0f) goto L13;
        if (r102 == false) goto L9;
        y(r100);
        return;
    L9:
        SpannableStringBuilder r103 = new SpannableStringBuilder(Intrinsics.stringPlus(r100, this.f90254g));
        AbsoluteSizeSpan r104 = new AbsoluteSizeSpan((int) r101);
        Intrinsics.checkNotNull(r100);
        int r105 = r100.length();
        int r106 = r100.length();
        String r107 = this.f90254g;
        Intrinsics.checkNotNull(r107);
        r103.setSpan(r104, r105, r106 + r107.length(), 33);
        ForegroundColorSpan r108 = new ForegroundColorSpan(s1.h(this.f90252e));
        int r109 = r100.length();
        int r110 = r100.length();
        String r111 = this.f90254g;
        Intrinsics.checkNotNull(r111);
        r103.setSpan(r108, r109, r110 + r111.length(), 33);
        setText(r103);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        boolean r104 = getParent() instanceof ViewGroup;
        y(this.f90253f);
        return;
    }
}
