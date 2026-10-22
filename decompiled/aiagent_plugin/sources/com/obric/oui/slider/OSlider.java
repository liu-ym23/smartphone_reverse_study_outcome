package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.d.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OSlider.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSlider extends ConstraintLayout {
    private static final float BASE_MAX = 100.0f;
    private static final float BASE_MIN = 0.0f;
    public static final a Companion = null;
    private static final String TAG = "OSlider";
    private boolean enableVibrate;
    private boolean isSeeking;
    private boolean isStyleSegmented;
    private boolean isTracking;
    private Drawable leftImage;
    private TickMarkSeekBar.b listener;
    private float maxValue;
    private float minValue;
    private boolean optimizeEdgeTouchExperience;
    private Drawable rightImage;
    private final SeekBarFloatCompat seekBar;
    private float seekbarHeight;
    private int sliderHeightPx;
    private final ImageView tvLeftIcon;
    private final ImageView tvRightIcon;

    /* JADX INFO: compiled from: OSlider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OSlider(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSlider(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static final /* synthetic */ TickMarkSeekBar.b access$getListener$p(OSlider r0) {
        return r0.listener;
    }

    public static final /* synthetic */ void access$setTracking$p(OSlider r0, boolean r1) {
        r0.isTracking = r1;
    }

    public static final /* synthetic */ float access$toRealValue(OSlider r0, float r1) {
        return r0.toRealValue(r1);
    }

    public /* synthetic */ OSlider(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OSlider(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.maxValue = BASE_MAX;
        this.enableVibrate = true;
        this.seekbarHeight = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6);
        refreshDimensionCache();
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.OSlider, r8, 0);
        this.seekbarHeight = r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OSlider_sliderHeight, "styleable", "OSlider_sliderHeight"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 6));
        setLeftImage(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OSlider_oui_slider_left_icon, "styleable", "OSlider_oui_slider_left_icon")));
        setRightImage(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OSlider_oui_slider_right_icon, "styleable", "OSlider_oui_slider_right_icon")));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_slider, "layout", "o_slider"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.seekBar, DbHelper.COL_ID, "seekBar"));
        o.c(r12, "findViewById(R.id.seekBar)");
        SeekBarFloatCompat r13 = (SeekBarFloatCompat) ZeusTransformUtils.preCheckCast(r12, SeekBarFloatCompat.class, "com.obric.aiagent.plugin");
        this.seekBar = r13;
        r13.setBackgroundHeight(this.seekbarHeight);
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.tvLeftIcon, DbHelper.COL_ID, "tvLeftIcon"));
        o.c(r14, "findViewById(R.id.tvLeftIcon)");
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.aiagent.plugin");
        this.tvLeftIcon = r15;
        if (this.leftImage == null) goto L5;
        r15.setVisibility(0);
        r15.setImageDrawable(this.leftImage);
    L5:
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tvRightIcon, DbHelper.COL_ID, "tvRightIcon"));
        o.c(r16, "findViewById(R.id.tvRightIcon)");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.aiagent.plugin");
        this.tvRightIcon = r17;
        Drawable r18 = this.rightImage;
        if (r18 == null) goto L8;
        r17.setImageDrawable(r18);
        r17.setVisibility(0);
    L8:
        r13.setOnSeekBarChangeListenerExt((TickMarkSeekBar.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TickMarkSeekBar.b.class, "com.obric.aiagent.plugin"));
        r13.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }

    public final Drawable getLeftImage() {
        return this.leftImage;
    }

    public final void setLeftImage(Drawable r1) {
        this.leftImage = r1;
    }

    public final Drawable getRightImage() {
        return this.rightImage;
    }

    public final void setRightImage(Drawable r1) {
        this.rightImage = r1;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.sliderHeightPx, 1073741824));
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        this.sliderHeightPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 32);
    }

    public final void setThumbColorInt(int r1) {
        this.seekBar.setThumbColorInt(r1);
    }

    public final void setThumbColor(int r1) {
        this.seekBar.setThumbColor(r1);
    }

    public final void setProcessColorInt(int r1, int r2) {
        this.seekBar.setProcessColorInt(r1, r2);
    }

    public final void setProcessBackgroundColorInt(int r1) {
        this.seekBar.setProcessBackgroundColorInt(r1);
    }

    public final void setProcessProgressColorInt(int r1) {
        this.seekBar.setProcessProgressColorInt(r1);
    }

    public final void setProcessColor(int r1, int r2) {
        this.seekBar.setProcessColor(r1, r2);
    }

    public final void setProcessBackgroundColor(int r1) {
        this.seekBar.setProcessBackgroundColor(r1);
    }

    public final void setProcessProgressColor(int r1) {
        this.seekBar.setProcessProgressColor(r1);
    }

    public final void setTickColorInt(int r1) {
        this.seekBar.setTickColorInt(r1);
    }

    public final void setTickColor(int r1) {
        this.seekBar.setTickColor(r1);
    }

    public final void showLeftIcon() {
        this.tvLeftIcon.setVisibility(0);
    }

    public final void hideLeftIcon() {
        this.tvLeftIcon.setVisibility(8);
    }

    public final void setLeftIcon(Drawable r2) {
        o.e(r2, "drawable");
        this.tvLeftIcon.setImageDrawable(r2);
    }

    public final void showRightIcon() {
        this.tvRightIcon.setVisibility(0);
    }

    public final void hideRightIcon() {
        this.tvRightIcon.setVisibility(8);
    }

    public final void setRightIcon(Drawable r2) {
        o.e(r2, "drawable");
        this.tvRightIcon.setImageDrawable(r2);
    }

    private final void vibrate() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("vibrator");     // Catch: Exception -> L9
        if (r2 == null) goto L7;
        ((Vibrator) ZeusTransformUtils.preCheckCast(r2, Vibrator.class, "com.obric.aiagent.plugin")).vibrate(10);     // Catch: Exception -> L9
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");     // Catch: Exception -> L9
    }

    public final void setMinValue(float r3) {
        INVOKESTATIC_com_obric_oui_slider_OSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("setMinValue >>> ", Float.valueOf(r3)));
        this.minValue = r3;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final void setMaxValue(float r3) {
        INVOKESTATIC_com_obric_oui_slider_OSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("setMaxValue >>> ", Float.valueOf(r3)));
        this.maxValue = r3;
        this.seekBar.setMinValue(0.0f);
        this.seekBar.setMaxValue(BASE_MAX);
    }

    public final float getMinValue() {
        return toRealValue(this.seekBar.getMinValue());
    }

    public final float getMaxValue() {
        return toRealValue(this.seekBar.getMaxValue());
    }

    public final void setTickMarkCount(int r1) {
        this.seekBar.setDefaultTickMarkCount(r1);
    }

    public final void setProgress(float r2) {
        this.seekBar.setProgress(toFakeValue(r2));
    }

    public final void setProgress(float r2, boolean r3) {
        this.seekBar.setProgress(toFakeValue(r2), r3);
    }

    public final float getProgress() {
        return this.seekBar.getFloatProgress();
    }

    public final float getRealProgress() {
        return toRealValue(this.seekBar.getFloatProgress());
    }

    public final void setOnSeekBarChangeListenerExt(TickMarkSeekBar.b r3) {
        this.listener = (TickMarkSeekBar.b) ZeusTransformUtils.wrapperContextForParams(r3, TickMarkSeekBar.b.class, "com.obric.aiagent.plugin");
    }

    public final void setSeekBarHeight(float r1) {
        this.seekBar.setBackgroundHeight(r1);
    }

    public final void setIsSegmented(boolean r2) {
        setIsSegmented(r2, 0, 0);
    }

    public final void setIsSegmented(boolean r1, int r2, int r3) {
        this.isStyleSegmented = r1;
        this.seekBar.setIsSegmented(r1, r2, r3);
    }

    public final void enableVibrate(boolean r1) {
        this.enableVibrate = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.seekBar.setEnabled(r2);
        this.tvLeftIcon.setEnabled(r2);
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        setAlpha(r3);
        return;
    L5:
        r3 = 0.5f;
        goto L6
    }

    private final float toRealValue(float r4) {
        float r0 = this.minValue;
        return round$default(this, r0 + (((r4 - 0.0f) / BASE_MAX) * (this.maxValue - r0)), 0, 1, null);
    }

    private final float toFakeValue(float r2) {
        float r0 = this.minValue;
        return (((r2 - r0) / (this.maxValue - r0)) * BASE_MAX) + 0.0f;
    }

    private final float round(float r3, int r4) {
        String r2 = String.format("%." + r4 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r3)}, 1));
        o.c(r2, "format(this, *args)");
        return Float.parseFloat(r2);
    }

    static /* synthetic */ float round$default(OSlider r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.round(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    public final SeekBar getSeekBar() {
        return (SeekBar) ZeusTransformUtils.preCheckCast(this.seekBar, SeekBar.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r1) {
        super.setHapticFeedbackEnabled(r1);
        this.seekBar.setHapticFeedbackEnabled(r1);
    }

    public final void enableEdgeTouchOptimize(boolean r1) {
        this.optimizeEdgeTouchExperience = r1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        o.e(r8, "event");
        if (this.optimizeEdgeTouchExperience == false) goto L5;
        Rect r0 = new Rect();
        this.seekBar.getHitRect(r0);
        int r1 = r8.getActionMasked();
        if (r1 == 0) goto L27;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L23;
    L30:
        b.b(TAG, "onTouchEvent, " + r8.getAction() + ", super.onTouchEvent, isSeeking: " + this.isSeeking);
        return super.onTouchEvent(r8);
    L15:
        if (this.isSeeking == false) goto L19;
        MotionEvent r9 = MotionEvent.obtain(r8);
        r9.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r9);
        r9.recycle();
        return true;
    L19:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == false) goto L30;
        this.isSeeking = true;
        MotionEvent r2 = MotionEvent.obtain(r8);
        r2.setAction(0);
        r2.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r2);
        r2.recycle();
        MotionEvent r10 = MotionEvent.obtain(r8);
        r10.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r10);
        r10.recycle();
        b.b(TAG, o.a("onTouchEvent, ACTION_MOVE, case 3, isSeeking: ", Boolean.valueOf(this.isSeeking)));
        return true;
    L23:
        if (this.isSeeking == false) goto L30;
        MotionEvent r3 = MotionEvent.obtain(r8);
        r3.offsetLocation(-this.seekBar.getLeft(), -this.seekBar.getTop());
        this.seekBar.dispatchTouchEvent(r3);
        r3.recycle();
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(false);
        b.b(TAG, "onTouchEvent, " + r8.getAction() + ", case 4, isSeeking: " + this.isSeeking);
        return true;
    L27:
        if (r0.contains((int) r8.getX(), (int) r8.getY()) == true) goto L30;
        this.isSeeking = false;
        requestDisallowInterceptTouchEvent(true);
        b.b(TAG, o.a("onTouchEvent, ACTION_DOWN, case 1, isSeeking: ", Boolean.valueOf(this.isSeeking)));
        return true;
    L5:
        return super.onTouchEvent(r8);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_slider_OSlider_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
