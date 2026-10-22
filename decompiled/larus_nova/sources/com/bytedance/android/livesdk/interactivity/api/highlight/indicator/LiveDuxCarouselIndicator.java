package com.bytedance.android.livesdk.interactivity.api.highlight.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/LiveDuxCarouselIndicator;", "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator;", "", "value", ce.f26396k, FaceService.girlLabel, "getDotsWidthFactor", "()F", "setDotsWidthFactor", "(F)V", "dotsWidthFactor", "", "l", "I", "getSelectedDotColor", "()I", "setSelectedDotColor", "(I)V", "selectedDotColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDuxCarouselIndicator extends DuxBaseIndicator {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f133239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f133240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f133241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArgbEvaluator f133242m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDuxCarouselIndicator f133243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DuxBaseIndicator.a f133245c;

        public b(LiveDuxCarouselIndicator r100, int r101, DuxBaseIndicator.a r102) {
            this.f133243a = r100;
            this.f133244b = r101;
            this.f133245c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f133243a.getDotsClickable() == true) goto L5;
            return;
        L5:
            if (this.f133244b >= this.f133245c.getCount()) goto L9;
            this.f133245c.a(this.f133244b);
            return;
        }
    }

    static {
    }

    public LiveDuxCarouselIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveDuxCarouselIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final q32.b b() {
        return new q32.b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void g() {
        LinearLayout r100 = this.f133239j;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        LinearLayout r101 = this.f133239j;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L8:
        r100.removeViewAt(r101.getChildCount() - 1);
        ArrayList<View> r102 = this.f133225a;
        ListProtector.remove(r102, r102.size() - 1);
    }

    public final float getDotsWidthFactor() {
        return this.f133240k;
    }

    public final int getSelectedDotColor() {
        return this.f133241l;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void a(int r100) {
        DuxBaseIndicator.a r101 = getPager();
        if (r101 != null) goto L5;
        return;
    L5:
        ImageView r102 = new ImageView(getContext());
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams((int) getDotsSize(), (int) getDotsSize());
        r103.setMargins((int) getDotsSpacing(), 0, (int) getDotsSpacing(), 0);
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        GradientDrawable r105 = new GradientDrawable();
        r105.setCornerRadius(getDotsCornerRadius());
        if (isInEditMode() == false) goto L12;
        if (r100 != 0) goto L9;
        int r106 = this.f133241l;
    L10:
        r105.setColor(r106);
    L16:
        r105.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
        r102.setBackground(r105);
        r102.setOnClickListener(new b(this, r100, r101));
        this.f133225a.add(r102);
        LinearLayout r107 = this.f133239j;
        if (r107 != 0) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L19:
        r107.addView(r102);
        return;
    L9:
        r106 = getDotsColor();
        goto L10
    L12:
        if (r101.getCurrentItem() != r100) goto L14;
        int r108 = this.f133241l;
    L15:
        r105.setColor(r108);
        goto L16
    L14:
        r108 = getDotsColor();
        goto L15
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator
    public final void c(int r100) {
        View r101 = (View) ListProtector.get(this.f133225a, r100);
        Drawable r102 = r101.getBackground();
        if ((r102 instanceof GradientDrawable) == true) goto L5;
        r102 = null;
    L5:
        GradientDrawable r103 = (GradientDrawable) r102;
        if (r103 == null) goto L13;
        DuxBaseIndicator.a r104 = getPager();
        if (r104 != null) goto L10;
    L12:
        r103.setColor(getDotsColor());
        goto L13
    L10:
        if (r100 != r104.getCurrentItem()) goto L12;
        r103.setColor(this.f133241l);
    L13:
        if (r103 == null) goto L15;
        r103.setCornerRadius(getDotsCornerRadius());
    L15:
        if (r103 == null) goto L17;
        r103.setStroke((int) getDotsStrokeWidth(), getDotsStrokeColor());
    L17:
        r101.setBackground(r103);
        r101.invalidate();
    }

    public final void setDotsWidthFactor(float r100) {
        if (this.f133240k != r100) goto L5;
        return;
    L5:
        if (r100 >= 1.0f) goto L7;
        r100 = 2.7f;
    L7:
        this.f133240k = r100;
    }

    public final void setSelectedDotColor(int r100) {
        if (this.f133241l == r100) goto L6;
        this.f133241l = r100;
        e();
        return;
    }

    public LiveDuxCarouselIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f133240k = 2.7f;
        this.f133241l = -1;
        this.f133242m = new ArgbEvaluator();
        LinearLayout r103 = new LinearLayout(getContext());
        this.f133239j = r103;
        int r104 = 0;
        r103.setOrientation(0);
        LinearLayout r105 = this.f133239j;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L5:
        addView(r105, -2, -2);
        if (isInEditMode() == true) goto L8;
        return;
    L8:
        if (r104 >= 5) goto L10;
        a(r104);
        r104 = r104 + 1;
        goto L8
    L10:
        d();
    }

    public /* synthetic */ LiveDuxCarouselIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
