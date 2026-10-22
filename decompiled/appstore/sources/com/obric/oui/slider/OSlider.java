package com.obric.oui.slider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.constant.CommonKey;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.utils.log.L;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\b\u0017\u0018\u0000 |2\u00020\u0001:\u0001\\B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\r*\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\n2\b\b\u0001\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010\"\u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u001eJ\u0017\u0010$\u001a\u00020\n2\b\b\u0001\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u001eJ\u0017\u0010&\u001a\u00020\n2\b\b\u0001\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u001eJ\u0017\u0010(\u001a\u00020\n2\b\b\u0001\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\u001eJ\u0017\u0010*\u001a\u00020\n2\b\b\u0001\u0010)\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u001eJ\u0017\u0010,\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u001eJ\u0015\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\n2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b1\u00100J\u0015\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020\r¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\n2\u0006\u00102\u001a\u00020\r¢\u0006\u0004\b5\u00104J\r\u00106\u001a\u00020\r¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\r¢\u0006\u0004\b8\u00107J\u0015\u00109\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\b9\u0010\u001eJ\u0015\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u00020\r¢\u0006\u0004\b;\u00104J\r\u0010<\u001a\u00020\r¢\u0006\u0004\b<\u00107J\r\u0010=\u001a\u00020\r¢\u0006\u0004\b=\u00107J\u0017\u0010@\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\r¢\u0006\u0004\bC\u00104J\u0015\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ%\u0010J\u001a\u00020\n2\u0006\u0010E\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020DH\u0016¢\u0006\u0004\bM\u0010GJ\r\u0010O\u001a\u00020N¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\n2\u0006\u0010Q\u001a\u00020DH\u0016¢\u0006\u0004\bR\u0010GJ\u0017\u0010U\u001a\u00020D2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010`\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010]R\u0016\u0010c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010bR\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010n\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0016\u0010o\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010iR\u0016\u0010q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010pR\u0016\u0010s\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010bR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010iR$\u0010x\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u00100R$\u0010{\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010t\u001a\u0004\by\u0010v\"\u0004\bz\u00100¨\u0006}"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "j", "()V", "", "o", "(F)F", "n", "decimals", "k", "(FI)F", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "thumbColor", "setThumbColorInt", "(I)V", "thumbColorResId", "setThumbColor", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "tickColor", "setTickColorInt", "tickColorResId", "setTickColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "setRightIcon", CommonKey.KEY_VALUE, "setMinValue", "(F)V", "setMaxValue", "getMinValue", "()F", "getMaxValue", "setTickMarkCount", "process", "setProgress", "getProgress", "getRealProgress", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "listener", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;)V", "seekBarHeight", "setSeekBarHeight", "", "isStyleSegmented", "setIsSegmented", "(Z)V", "tickMarkCount", "initTickPosition", "m", "(ZII)V", "enabled", "setEnabled", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "hapticFeedbackEnabled", "setHapticFeedbackEnabled", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "a", "Lcom/obric/oui/slider/SeekBarFloatCompat;", "seekBar", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "tvLeftIcon", "c", "tvRightIcon", "d", "F", "minValue", "e", "maxValue", "f", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "g", "Z", "enableVibrate", "h", "isTracking", "i", "optimizeEdgeTouchExperience", "isSeeking", "I", "sliderHeightPx", "l", "seekbarHeight", "Landroid/graphics/drawable/Drawable;", "getLeftImage", "()Landroid/graphics/drawable/Drawable;", "setLeftImage", "leftImage", "getRightImage", "setRightImage", "rightImage", "p", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OSlider extends ConstraintLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f16939p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SeekBarFloatCompat f16940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f16941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f16942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TickMarkSeekBar.OnSeekBarChangeListenerExt f16945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f16951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f16953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f16954o;

    public static final class a implements TickMarkSeekBar.OnSeekBarChangeListenerExt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSlider f16955a;

        public a(OSlider r10) {
            this.f16955a = r10;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onProgressChanged(SeekBar r10, float r11, boolean r12) {
            TickMarkSeekBar.OnSeekBarChangeListenerExt r13 = OSlider.g(this.f16955a);
            if (r13 == null) goto L7;
            r13.onProgressChanged(r10, OSlider.i(this.f16955a, r11), r12);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onSegmentedPositionChanged(int r10) {
            TickMarkSeekBar.OnSeekBarChangeListenerExt r11 = OSlider.g(this.f16955a);
            if (r11 == null) goto L7;
            r11.onSegmentedPositionChanged(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onStartTrackingTouch(SeekBar r10) {
            OSlider.h(this.f16955a, true);
            TickMarkSeekBar.OnSeekBarChangeListenerExt r11 = OSlider.g(this.f16955a);
            if (r11 == null) goto L7;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onStopTrackingTouch(SeekBar r10) {
            OSlider.h(this.f16955a, false);
            TickMarkSeekBar.OnSeekBarChangeListenerExt r11 = OSlider.g(this.f16955a);
            if (r11 == null) goto L7;
            r11.onStopTrackingTouch(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onTouchDown(SeekBar r10) {
            TickMarkSeekBar.OnSeekBarChangeListenerExt r11 = OSlider.g(this.f16955a);
            if (r11 == null) goto L7;
            r11.onTouchDown(r10);
            return;
        }

        @Override // com.obric.oui.slider.TickMarkSeekBar.OnSeekBarChangeListenerExt
        public void onTouchUp(SeekBar r10, float r11) {
            TickMarkSeekBar.OnSeekBarChangeListenerExt r12 = OSlider.g(this.f16955a);
            if (r12 == null) goto L7;
            r12.onTouchUp(r10, r11);
            return;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f16939p = new b(null);
    }

    @JvmOverloads
    public OSlider(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ TickMarkSeekBar.OnSeekBarChangeListenerExt g(OSlider r10) {
        return r10.f16945f;
    }

    public static final /* synthetic */ void h(OSlider r10, boolean r11) {
        r10.f16947h = r11;
    }

    public static final /* synthetic */ float i(OSlider r10, float r11) {
        return r10.o(r11);
    }

    private final void j() {
        this.f16950k = f.r(this, 32);
    }

    public static /* synthetic */ float l(OSlider r10, float r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = 2;
    L7:
        return r10.k(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    @Nullable
    public final Drawable getLeftImage() {
        return this.f16953n;
    }

    public final float getMaxValue() {
        return o(this.f16940a.getMaxValue());
    }

    public final float getMinValue() {
        return o(this.f16940a.getMinValue());
    }

    public final float getProgress() {
        return this.f16940a.getFloatProgress();
    }

    public final float getRealProgress() {
        return o(this.f16940a.getFloatProgress());
    }

    @Nullable
    public final Drawable getRightImage() {
        return this.f16954o;
    }

    @NotNull
    public final SeekBar getSeekBar() {
        return this.f16940a;
    }

    public final float k(float r10, int r11) {
        String r12 = String.format("%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        q.f(r12, "format(this, *args)");
        return Float.parseFloat(r12);
    }

    public final void m(boolean r10, int r11, int r12) {
        this.f16952m = r10;
        this.f16940a.K(r10, r11, r12);
    }

    public final float n(float r10) {
        float r11 = this.f16943d;
        return (((r10 - r11) / (this.f16944e - r11)) * 100.0f) + 0.0f;
    }

    public final float o(float r10) {
        float r11 = this.f16943d;
        return l(this, r11 + (((r10 - 0.0f) / 100.0f) * (this.f16944e - r11)), 0, 1, null);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(this.f16950k, Ints.MAX_POWER_OF_TWO));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        if (this.f16948i == false) goto L5;
        Rect r11 = new Rect();
        this.f16940a.getHitRect(r11);
        int r12 = r10.getActionMasked();
        if (r12 == 0) goto L27;
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L15;
        if (r12 == 3) goto L23;
    L30:
        L.a("OSlider", "onTouchEvent, " + r10.getAction() + ", super.onTouchEvent, isSeeking: " + this.f16949j);
        return super.onTouchEvent(r10);
    L15:
        if (this.f16949j == false) goto L19;
        MotionEvent r13 = MotionEvent.obtain(r10);
        r13.offsetLocation(-this.f16940a.getLeft(), -this.f16940a.getTop());
        this.f16940a.dispatchTouchEvent(r13);
        r13.recycle();
        return true;
    L19:
        if (r11.contains((int) r10.getX(), (int) r10.getY()) == false) goto L30;
        this.f16949j = true;
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.setAction(0);
        r14.offsetLocation(-this.f16940a.getLeft(), -this.f16940a.getTop());
        this.f16940a.dispatchTouchEvent(r14);
        r14.recycle();
        MotionEvent r15 = MotionEvent.obtain(r10);
        r15.offsetLocation(-this.f16940a.getLeft(), -this.f16940a.getTop());
        this.f16940a.dispatchTouchEvent(r15);
        r15.recycle();
        L.a("OSlider", q.p("onTouchEvent, ACTION_MOVE, case 3, isSeeking: ", Boolean.valueOf(this.f16949j)));
        return true;
    L23:
        if (this.f16949j == false) goto L30;
        MotionEvent r16 = MotionEvent.obtain(r10);
        r16.offsetLocation(-this.f16940a.getLeft(), -this.f16940a.getTop());
        this.f16940a.dispatchTouchEvent(r16);
        r16.recycle();
        this.f16949j = false;
        requestDisallowInterceptTouchEvent(false);
        L.a("OSlider", "onTouchEvent, " + r10.getAction() + ", case 4, isSeeking: " + this.f16949j);
        return true;
    L27:
        if (r11.contains((int) r10.getX(), (int) r10.getY()) == true) goto L30;
        this.f16949j = false;
        requestDisallowInterceptTouchEvent(true);
        L.a("OSlider", q.p("onTouchEvent, ACTION_DOWN, case 1, isSeeking: ", Boolean.valueOf(this.f16949j)));
        return true;
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f16940a.setEnabled(r10);
        this.f16941b.setEnabled(r10);
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        setAlpha(r11);
        return;
    L5:
        r11 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r10) {
        super.setHapticFeedbackEnabled(r10);
        this.f16940a.setHapticFeedbackEnabled(r10);
    }

    public final void setIsSegmented(boolean r10) {
        m(r10, 0, 0);
    }

    public final void setLeftIcon(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        this.f16941b.setImageDrawable(r10);
    }

    public final void setLeftImage(@Nullable Drawable r10) {
        this.f16953n = r10;
    }

    public final void setMaxValue(float r10) {
        Log.d("OSlider", q.p("setMaxValue >>> ", Float.valueOf(r10)));
        this.f16944e = r10;
        this.f16940a.setMinValue(0.0f);
        this.f16940a.setMaxValue(100.0f);
    }

    public final void setMinValue(float r10) {
        Log.d("OSlider", q.p("setMinValue >>> ", Float.valueOf(r10)));
        this.f16943d = r10;
        this.f16940a.setMinValue(0.0f);
        this.f16940a.setMaxValue(100.0f);
    }

    public final void setOnSeekBarChangeListenerExt(@Nullable TickMarkSeekBar.OnSeekBarChangeListenerExt r10) {
        this.f16945f = r10;
    }

    public final void setProcessBackgroundColor(@ColorRes int r10) {
        this.f16940a.setProcessBackgroundColor(r10);
    }

    public final void setProcessBackgroundColorInt(@ColorInt int r10) {
        this.f16940a.setProcessBackgroundColorInt(r10);
    }

    public final void setProcessProgressColor(@ColorRes int r10) {
        this.f16940a.setProcessProgressColor(r10);
    }

    public final void setProcessProgressColorInt(@ColorInt int r10) {
        this.f16940a.setProcessProgressColorInt(r10);
    }

    public final void setProgress(float r10) {
        this.f16940a.setProgress(n(r10));
    }

    public final void setRightIcon(@NotNull Drawable r10) {
        q.g(r10, "drawable");
        this.f16942c.setImageDrawable(r10);
    }

    public final void setRightImage(@Nullable Drawable r10) {
        this.f16954o = r10;
    }

    public final void setSeekBarHeight(float r10) {
        this.f16940a.setBackgroundHeight(r10);
    }

    public final void setThumbColor(@ColorRes int r10) {
        this.f16940a.setThumbColor(r10);
    }

    public final void setThumbColorInt(@ColorInt int r10) {
        this.f16940a.setThumbColorInt(r10);
    }

    public final void setTickColor(@ColorRes int r10) {
        this.f16940a.setTickColor(r10);
    }

    public final void setTickColorInt(@ColorInt int r10) {
        this.f16940a.setTickColorInt(r10);
    }

    public final void setTickMarkCount(int r10) {
        this.f16940a.setDefaultTickMarkCount(r10);
    }

    @JvmOverloads
    public OSlider(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSlider(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSlider(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16944e = 100.0f;
        this.f16946g = true;
        this.f16951l = f.r(this, 6);
        j();
        TypedArray r13 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OSlider, r12, 0);
        this.f16951l = r13.getDimensionPixelSize(R$styleable.OSlider_sliderHeight, f.r(this, 6));
        setLeftImage(r13.getDrawable(R$styleable.OSlider_oui_slider_left_icon));
        setRightImage(r13.getDrawable(R$styleable.OSlider_oui_slider_right_icon));
        LayoutInflater.from(r10).inflate(R$layout.o_slider, this);
        View r14 = findViewById(R$id.seekBar);
        q.f(r14, "findViewById(R.id.seekBar)");
        SeekBarFloatCompat r15 = (SeekBarFloatCompat) r14;
        this.f16940a = r15;
        r15.setBackgroundHeight(this.f16951l);
        View r16 = findViewById(R$id.tvLeftIcon);
        q.f(r16, "findViewById(R.id.tvLeftIcon)");
        ImageView r17 = (ImageView) r16;
        this.f16941b = r17;
        if (this.f16953n == null) goto L5;
        r17.setVisibility(0);
        r17.setImageDrawable(this.f16953n);
    L5:
        View r18 = findViewById(R$id.tvRightIcon);
        q.f(r18, "findViewById(R.id.tvRightIcon)");
        ImageView r19 = (ImageView) r18;
        this.f16942c = r19;
        Drawable r20 = this.f16954o;
        if (r20 == null) goto L8;
        r19.setImageDrawable(r20);
        r19.setVisibility(0);
    L8:
        r15.setOnSeekBarChangeListenerExt(new a(this));
        r15.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }
}
