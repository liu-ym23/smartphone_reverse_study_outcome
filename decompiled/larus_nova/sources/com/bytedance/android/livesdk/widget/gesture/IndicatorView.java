package com.bytedance.android.livesdk.widget.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0003¢\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010+\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/widget/gesture/IndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/widget/gesture/c;", "", "getLayoutId", "stepCount", "", "setStepCount", "", "getMinValue", "getMaxValue", "", "getIconArray", "", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getOptIndicator", "()Ljava/lang/Boolean;", "optIndicator", "b", "I", "getSTEP_COUNT", "()I", "STEP_COUNT", "c", FaceService.girlLabel, "getInitValue", "()F", "setInitValue", "(F)V", "initValue", "d", "getCurrentValue", "setCurrentValue", "currentValue", "e", "getStepValue", "setStepValue", "stepValue", "f", "getPercent", "setPercent", "percent", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IndicatorView extends LinearLayout implements com.bytedance.android.livesdk.widget.gesture.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f161712m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f161713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f161714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f161715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f161716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f161717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f161718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f161719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f161720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f161721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewPropertyAnimator f161722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f161723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f161724l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IndicatorView f161725a;

        public b(IndicatorView r100) {
            this.f161725a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            IndicatorView r102 = this.f161725a;
            e r103 = new e(this);
            int r104 = IndicatorView.f161712m;
            r102.f161722j.setDuration(200).alpha(0).setListener(r103).start();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f161726a = null;

        static {
            f161726a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Logger.e(r101.getMessage());
        }
    }

    static {
    }

    public IndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getLayoutId() {
        return R.layout.ttlive_brightness_volume_indicator_layout;
    }

    public abstract int[] getIconArray();

    public abstract float getMaxValue();

    public abstract float getMinValue();

    public final Boolean getOptIndicator() {
        return (Boolean) this.f161713a.getValue();
    }

    @Override // com.bytedance.android.livesdk.widget.gesture.c
    public final void hide() {
        setAlpha(0.0f);
        setVisibility(4);
        this.f161723k = true;
    }

    public abstract float k(boolean r100);

    public abstract void l(float r100, int r101);

    @Override // com.bytedance.android.livesdk.widget.gesture.c
    public final void a() {
        Logger.d("IndicatorView", "increase, isVisible=" + getVisibility() + ", alpha=" + getAlpha() + ", currentValue=" + this.f161716d);
        j();
        float r100 = this.f161716d + this.f161717e;
        if (r100 <= getMaxValue()) goto L5;
        r100 = getMaxValue();
    L5:
        i(r100, 1);
    }

    @Override // com.bytedance.android.livesdk.widget.gesture.c
    public final void e() {
        Logger.d("IndicatorView", "fadeOut, isVisible=" + getVisibility() + ", alpha=" + getAlpha());
        this.f161721i = Observable.timer(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.f161726a);
        this.f161723k = true;
    }

    @Override // com.bytedance.android.livesdk.widget.gesture.c
    public final void f() {
        Logger.d("IndicatorView", "decrease, isVisible=" + getVisibility() + ", alpha=" + getAlpha() + ", currentValue=" + this.f161716d);
        j();
        float r100 = this.f161716d - this.f161717e;
        if (r100 >= getMinValue()) goto L5;
        r100 = getMinValue();
    L5:
        i(r100, 2);
    }

    public void j() {
        Disposable r100 = this.f161721i;
        if (r100 == null) goto L11;
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        r100.dispose();
    L11:
        if (isShown() == true) goto L13;
        Logger.d("IndicatorView", "fadeIn, isVisible=" + getVisibility() + ", alpha=" + getAlpha());
        setVisibility(0);
        this.f161722j.setDuration(200).alpha((float) 1).setListener(null).start();
    L13:
        this.f161716d = k(false);
        float r101 = k(getOptIndicator().booleanValue());
        m(r101);
        n(r101, !getOptIndicator().booleanValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f161721i;
        if (r100 != null) goto L5;
    L10:
        this.f161722j.cancel();
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f161719g = (ImageView) findViewById(R.id.indicator_icon);
        this.f161720h = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public final float getCurrentValue() {
        return this.f161716d;
    }

    public final float getInitValue() {
        return this.f161715c;
    }

    public final float getPercent() {
        return this.f161718f;
    }

    public final int getSTEP_COUNT() {
        return this.f161714b;
    }

    public final float getStepValue() {
        return this.f161717e;
    }

    @Override // com.bytedance.android.livesdk.widget.gesture.c
    public final void b(float r100) {
        if (this.f161723k == false) goto L5;
        j();
        this.f161715c = this.f161716d;
        this.f161723k = false;
    L5:
        float r101 = (getMaxValue() * r100) * 1.1f;
        float r102 = this.f161715c + r101;
        if (r102 <= getMaxValue()) goto L9;
        r102 = getMaxValue();
    L11:
        i(r102, 0);
        return;
    L9:
        if (r102 >= getMinValue()) goto L11;
        r102 = getMinValue();
        goto L11
    }

    public final void m(float r100) {
        int r101 = 0;
        if (getIconArray().length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        if (getIconArray().length != 1) goto L15;
        ImageView r103 = this.f161719g;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L13:
        r103.setImageResource(getIconArray()[0]);
        return;
    L15:
        float r104 = (getMaxValue() - getMinValue()) / (getIconArray().length - 1);
        if (r100 <= getMinValue()) goto L20;
        r101 = 1;
    L20:
        if (r100 <= r104) goto L25;
    L22:
        if (r100 <= r104) goto L25;
        r100 = r100 - r104;
        r101 = r101 + 1;
    L25:
        if (r101 < getIconArray().length) goto L30;
        if (this.f161724l == (getIconArray().length - 1)) goto L30;
        r101 = getIconArray().length - 1;
    L30:
        if (this.f161724l != r101) goto L32;
        return;
    L32:
        if (r101 >= getIconArray().length) goto L41;
        this.f161724l = r101;
        ImageView r105 = this.f161719g;
        if (r105 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L37:
        r105.setImageResource(getIconArray()[r101]);
        Logger.d("IndicatorView", "updateIcon, icon index=" + r101);
        return;
    L41:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setCurrentValue(float r100) {
        this.f161716d = r100;
    }

    public final void setInitValue(float r100) {
        this.f161715c = r100;
    }

    public final void setPercent(float r100) {
        this.f161718f = r100;
    }

    public final void setStepCount(int r100) {
        float r101 = getMaxValue() / r100;
        this.f161717e = r101;
        if (0.0f != r101) goto L6;
        this.f161717e = 0.1f;
        return;
    }

    public final void setStepValue(float r100) {
        this.f161717e = r100;
    }

    public boolean i(float r100, int r101) {
        if (r100 != this.f161716d) goto L6;
        return false;
    L6:
        l(r100, r101);
        this.f161716d = r100;
        return true;
    }

    public final void n(float r100, final boolean r101) {
        this.f161718f = (100 * r100) / getMaxValue();
        UtilityKotlinExtentionsKt.s(0, false, !getOptIndicator().booleanValue(), new IndicatorView$updateProgressBar$1(this, r101), 3);
    }

    public IndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101, r102);
        this.f161713a = LazyKt.lazy(IndicatorView$optIndicator$2.INSTANCE);
        if (getOptIndicator().booleanValue() == false) goto L5;
        int r103 = 15;
    L6:
        this.f161714b = r103;
        this.f161715c = -1.0f;
        this.f161716d = -1.0f;
        this.f161723k = true;
        LinearLayout.inflate(r100, getLayoutId(), this);
        this.f161722j = animate();
        float r104 = getMaxValue() / r103;
        this.f161717e = r104;
        if (0.0f != r104) goto L9;
        this.f161717e = 0.1f;
    L9:
        this.f161724l = -1;
        return;
    L5:
        r103 = 10;
        goto L6
    }

    public /* synthetic */ IndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
