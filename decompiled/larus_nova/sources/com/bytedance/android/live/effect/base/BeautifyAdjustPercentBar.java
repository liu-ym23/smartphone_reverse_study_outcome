package com.bytedance.android.live.effect.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001f\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/effect/base/BeautifyAdjustPercentBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "percent", "", "setPercent", "", "enable", "setEnableSingeAdjust", "Lcom/bytedance/android/live/effect/base/AdjustPercentBar$d;", "onLevelChangeListener", "setOnLevelChangeListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getBeautifyTitleTextView", "()Landroid/widget/TextView;", "beautifyTitleTextView", "Lcom/bytedance/android/live/effect/base/AdjustPercentBar;", "b", "getAdjustPercentBar", "()Lcom/bytedance/android/live/effect/base/AdjustPercentBar;", "adjustPercentBar", "Landroid/widget/ImageView;", "c", "getMinusIcon", "()Landroid/widget/ImageView;", "minusIcon", "d", "getPlusIcon", "plusIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyAdjustPercentBar extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f66941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f66942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f66943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f66944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AdjustPercentBar.d f66947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f66948h;

    public static final class a implements AdjustPercentBar.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BeautifyAdjustPercentBar f66949a;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r100) {
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
        }

        public a(BeautifyAdjustPercentBar r100) {
            this.f66949a = r100;
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r100) {
            ImageView r101 = BeautifyAdjustPercentBar.S5(this.f66949a);
            boolean r102 = true;
            if (r101 == null) goto L12;
            AdjustPercentBar r103 = BeautifyAdjustPercentBar.R5(this.f66949a);
            if (r103 == null) goto L7;
            int r104 = r103.getMinPercent();
        L8:
            if (r100 <= r104) goto L10;
            boolean r105 = true;
        L11:
            r101.setEnabled(r105);
            goto L12
        L10:
            r105 = false;
            goto L11
        L7:
            r104 = 0;
        L12:
            ImageView r106 = BeautifyAdjustPercentBar.T5(this.f66949a);
            if (r106 == null) goto L23;
            AdjustPercentBar r107 = BeautifyAdjustPercentBar.R5(this.f66949a);
            if (r107 == null) goto L17;
            int r108 = r107.getMaxPercent();
        L18:
            if (r100 < r108) goto L21;
            r102 = false;
        L21:
            r106.setEnabled(r102);
            return;
        L17:
            r108 = 0;
            goto L18
        }
    }

    public static final class b implements AdjustPercentBar.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BeautifyAdjustPercentBar f66950a;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
            AdjustPercentBar.d r100 = this.f66950a.f66947g;
            if (r100 == null) goto L5;
            r100.b();
        L5:
            this.f66950a.f66948h.getClass();
        }

        public b(BeautifyAdjustPercentBar r100) {
            this.f66950a = r100;
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r100) {
            AdjustPercentBar.d r101 = this.f66950a.f66947g;
            if (r101 == null) goto L5;
            r101.a(r100);
        L5:
            this.f66950a.f66948h.getClass();
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r100) {
            AdjustPercentBar.d r101 = this.f66950a.f66947g;
            if (r101 == null) goto L5;
            r101.onChanged(r100);
        L5:
            this.f66950a.f66948h.onChanged(r100);
        }
    }

    public BeautifyAdjustPercentBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BeautifyAdjustPercentBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final AdjustPercentBar getAdjustPercentBar() {
        return (AdjustPercentBar) this.f66942b.getValue();
    }

    private final TextView getBeautifyTitleTextView() {
        return (TextView) this.f66941a.getValue();
    }

    private final ImageView getMinusIcon() {
        return (ImageView) this.f66943c.getValue();
    }

    private final ImageView getPlusIcon() {
        return (ImageView) this.f66944d.getValue();
    }

    public final void Z5() {
        AdjustPercentBar r100 = getAdjustPercentBar();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.getPercent();
    L6:
        ImageView r103 = getMinusIcon();
        if (r103 == null) goto L16;
        AdjustPercentBar r104 = getAdjustPercentBar();
        if (r104 == null) goto L11;
        int r105 = r104.getMinPercent();
    L12:
        if (r102 <= r105) goto L14;
        boolean r106 = true;
    L15:
        r103.setEnabled(r106);
        goto L16
    L14:
        r106 = false;
        goto L15
    L11:
        r105 = 0;
    L16:
        ImageView r107 = getPlusIcon();
        if (r107 == null) goto L26;
        AdjustPercentBar r108 = getAdjustPercentBar();
        if (r108 == null) goto L21;
        int r109 = r108.getMaxPercent();
    L22:
        if (r102 >= r109) goto L24;
        r101 = true;
    L24:
        r107.setEnabled(r101);
        return;
    L21:
        r109 = 0;
        goto L22
    L26:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static final /* synthetic */ AdjustPercentBar R5(BeautifyAdjustPercentBar r100) {
        return r100.getAdjustPercentBar();
    }

    public static final /* synthetic */ ImageView S5(BeautifyAdjustPercentBar r100) {
        return r100.getMinusIcon();
    }

    public static final /* synthetic */ ImageView T5(BeautifyAdjustPercentBar r100) {
        return r100.getPlusIcon();
    }

    public final void setEnableSingeAdjust(boolean r100) {
        if (r100 == false) goto L9;
        ImageView r101 = getMinusIcon();
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        ImageView r102 = getPlusIcon();
        if (r102 == null) goto L16;
        r102.setVisibility(0);
        return;
    L16:
        return;
    L9:
        ImageView r103 = getMinusIcon();
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        ImageView r104 = getPlusIcon();
        if (r104 == null) goto L18;
        r104.setVisibility(8);
        return;
    }

    public final void setOnLevelChangeListener(AdjustPercentBar.d r100) {
        Intrinsics.checkNotNullParameter(r100, "onLevelChangeListener");
        this.f66947g = r100;
    }

    public final void setPercent(int r100) {
        AdjustPercentBar r101 = getAdjustPercentBar();
        if (r101 == null) goto L5;
        r101.setPercent(r100);
    L5:
        Z5();
    }

    public final void V5(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "title");
        if (r100 == false) goto L13;
        TextView r102 = getBeautifyTitleTextView();
        if (r102 == null) goto L7;
        r102.setVisibility(0);
    L7:
        ImageView r103 = getMinusIcon();
        if (r103 == null) goto L10;
        a1.m(r103, this.f66945e);
    L10:
        TextView r104 = getBeautifyTitleTextView();
        if (r104 == null) goto L20;
        r104.setText(r101);
        return;
    L20:
        return;
    L13:
        TextView r105 = getBeautifyTitleTextView();
        if (r105 == null) goto L16;
        r105.setVisibility(8);
    L16:
        ImageView r106 = getMinusIcon();
        if (r106 == null) goto L22;
        a1.m(r106, this.f66946f);
        return;
    }

    public BeautifyAdjustPercentBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f66941a = LazyKt.lazy(new BeautifyAdjustPercentBar$beautifyTitleTextView$2(this));
        this.f66942b = LazyKt.lazy(new BeautifyAdjustPercentBar$adjustPercentBar$2(this));
        this.f66943c = LazyKt.lazy(new BeautifyAdjustPercentBar$minusIcon$2(this));
        this.f66944d = LazyKt.lazy(new BeautifyAdjustPercentBar$plusIcon$2(this));
        this.f66945e = s1.f(7.0f);
        this.f66946f = s1.f(14.0f);
        this.f66948h = new a(this);
        b r103 = new b(this);
        ViewGroup.inflate(r100, R.layout.ttlive_effect_beautify_adjust_percent_bar, this);
        ImageView r104 = getMinusIcon();
        if (r104 == null) goto L5;
        r104.setOnClickListener(new c(this));
    L5:
        ImageView r105 = getPlusIcon();
        if (r105 == null) goto L8;
        r105.setOnClickListener(new d(this));
    L8:
        Z5();
        AdjustPercentBar r106 = getAdjustPercentBar();
        if (r106 == null) goto L11;
        r106.setOnLevelChangeListener(r103);
    L11:
        AdjustPercentBar r107 = getAdjustPercentBar();
        if (r107 == null) goto L15;
        r107.setDefaultCircleConfig(R.color.white);
        return;
    }

    public final void U5(int r100, int r101, int r102) {
        AdjustPercentBar r103 = getAdjustPercentBar();
        if (r103 == null) goto L5;
        r103.c(r100, r101, r102);
    L5:
        AdjustPercentBar r104 = getAdjustPercentBar();
        if (r104 == null) goto L9;
        r104.setDefaultCircleConfig(R.color.white);
        return;
    }

    public /* synthetic */ BeautifyAdjustPercentBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void Y5(int r100, int r101, int r102, boolean r103) {
        AdjustPercentBar r104 = getAdjustPercentBar();
        if (r104 == null) goto L5;
        r104.e(r100, r101, r102, r103);
    L5:
        Z5();
    }
}
