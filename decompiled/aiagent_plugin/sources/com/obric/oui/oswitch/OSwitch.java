package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.d.a.b;
import com.obric.oui.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: OSwitch.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSwitch extends SwitchCompat {
    public static final a Companion = null;
    private static final String TAG = "OSwitch";
    private static final boolean USE_CUSTOM_TRANSITION_DRAWABLE = true;
    private boolean changeAlphaWhenDisable;
    private int trackChecked;
    private int trackUnchecked;

    /* JADX INFO: compiled from: OSwitch.kt */
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

    public OSwitch(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OSwitch(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.attr.OUISwitchStyle, "attr", "OUISwitchStyle");
    L8:
        this(r7, r8, r4);
    }

    public OSwitch(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.changeAlphaWhenDisable = true;
        int[] r2 = R.styleable.OSwitch;
        o.c(r2, TAG);
        TypedArray r11 = r9.obtainStyledAttributes(r10, r2, r8, 0);
        o.c(r11, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.trackUnchecked = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_trackUnchecked, "styleable", "OSwitch_oui_trackUnchecked"), 0);
        this.trackChecked = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_trackChecked, "styleable", "OSwitch_oui_trackChecked"), 0);
        this.changeAlphaWhenDisable = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_disabledAlpha, "styleable", "OSwitch_oui_disabledAlpha"), true);
        r11.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(androidx.core.content.a.a(r9, ZeusTransformUtils.mapRes(R.drawable.o_switch_thumb, "drawable", "o_switch_thumb")));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable((Drawable) ZeusTransformUtils.preCheckCast(makeCustomTransitionDrawable(r9, isChecked()), Drawable.class, "com.obric.aiagent.plugin"));
    L8:
        setEnabled(isEnabled());
    }

    public final void setChangeAlphaWhenDisable(boolean r2) {
        if (this.changeAlphaWhenDisable == r2) goto L6;
        this.changeAlphaWhenDisable = r2;
        updateAlphaState();
        return;
    }

    private final void updateAlphaState() {
        if (this.changeAlphaWhenDisable == true) goto L5;
        Drawable r0 = getTrackDrawable();
        if (r0 == null) goto L36;
        r0.setAlpha(255);
    L36:
        Drawable r3 = getThumbDrawable();
        if (r3 == null) goto L47;
        r3.setAlpha(255);
        return;
    L47:
        return;
    L5:
        if (isEnabled() == false) goto L15;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L10;
        r1.setAlpha(255);
    L10:
        Drawable r4 = getThumbDrawable();
        if (r4 == null) goto L44;
        r4.setAlpha(255);
        return;
    L44:
        return;
    L15:
        if (isChecked() == false) goto L24;
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L20;
        r2.setAlpha(76);
    L20:
        Drawable r5 = getThumbDrawable();
        if (r5 == null) goto L45;
        r5.setAlpha(127);
        return;
    L45:
        return;
    L24:
        Drawable r6 = getTrackDrawable();
        if (r6 == null) goto L28;
        r6.setAlpha(76);
    L28:
        Drawable r7 = getThumbDrawable();
        if (r7 == null) goto L46;
        r7.setAlpha(255);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        updateAlphaState();
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        o.e(r4, "ev");
        if (r4.getAction() == 3) goto L7;
        if (r4.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r4);
    L7:
        if (getTouchMode() != 2) goto L11;
        stopDrag(r4);
        super.onTouchEvent(r4);
        return true;
    }

    private final void stopDrag(MotionEvent r4) {
        setIdleTouchMode();
        boolean r2 = true;
        if (r4.getAction() == 1) goto L5;
    L7:
        r2 = false;
    L8:
        boolean r0 = isChecked();
        if (r2 == false) goto L11;
        boolean r3 = getTargetCheckedState();
    L12:
        if (r3 == r0) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r3);
        MotionEvent r5 = MotionEvent.obtain(r4);
        r5.setAction(3);
        o.c(r5, "cancel");
        super.onTouchEvent(r5);
        r5.recycle();
        return;
    L11:
        r3 = r0;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r0 = SwitchCompat.class.getDeclaredField("mThumbPosition");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.aiagent.plugin")).floatValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0.0f;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final int getTouchMode() {
        Field r0 = SwitchCompat.class.getDeclaredField("mTouchMode");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final void setIdleTouchMode() {
        Field r0 = SwitchCompat.class.getDeclaredField("mTouchMode");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final void setCheckedWithoutFeedback(boolean r2) {
        setCheckedInner(r2, true);
    }

    private final void setCheckedInner(boolean r4, boolean r5) {
        if (r4 == isChecked()) goto L11;
        if (r5 == false) goto L11;
        if (ZeusTransformUtils.instanceOf(getTrackDrawable(), TransitionDrawable.class) == false) goto L11;
        if (r4 == false) goto L10;
        Drawable r2 = getTrackDrawable();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r2, TransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(180);
        goto L11
    L10:
        Drawable r3 = getTrackDrawable();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r3, TransitionDrawable.class, "com.obric.aiagent.plugin")).reverseTransition(180);
    L11:
        super.setChecked(r4);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        boolean r0 = isChecked();
        super.setChecked(r3);
        boolean r4 = isChecked();
        updateAlphaState();
        if (getWindowToken() != null) goto L5;
    L8:
        changeTrackDrawableStateWithoutAnim(r4);
        return;
    L5:
        if (hasValidSize() == false) goto L8;
        if (r0 == r4) goto L10;
        doTrackDrawableTransitionAnim(r4);
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r1) {
        super.setCheckedNoAnim(r1);
        changeTrackDrawableStateWithoutAnim(r1);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        increaseTouchArea$default(this, 0, 0, 3, null);
    }

    private final Drawable getUncheckedDrawable() {
        if (this.trackUnchecked != 0) goto L5;
        Drawable r3 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_switch_track_unchecked, "drawable", "o_switch_track_unchecked"));
        o.a(r3);
        Drawable r4 = r3.mutate();
        o.c(r4, "{\n            ContextCom…      .mutate()\n        }");
        return r4;
    L5:
        Drawable r5 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.trackUnchecked);
        o.a(r5);
        Drawable r6 = r5.mutate();
        o.c(r6, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r6;
    }

    private final Drawable getCheckedDrawable() {
        if (this.trackChecked != 0) goto L5;
        Drawable r3 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_switch_track_checked, "drawable", "o_switch_track_checked"));
        o.a(r3);
        Drawable r4 = r3.mutate();
        o.c(r4, "{\n            ContextCom…      .mutate()\n        }");
        return r4;
    L5:
        Drawable r5 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.trackChecked);
        o.a(r5);
        Drawable r6 = r5.mutate();
        o.c(r6, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r6;
    }

    private final CustomTransitionDrawable makeCustomTransitionDrawable(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        CustomTransitionDrawable r0 = new CustomTransitionDrawable(getUncheckedDrawable(), getCheckedDrawable());
        if (r4 == false) goto L5;
        r0.startTransition(0);
    L6:
        return r0;
    L5:
        r0.resetTransition();
        goto L6
    }

    private final Drawable makeAndroidTransitionDrawable(Context r4, boolean r5) {
        Drawable r3 = androidx.core.content.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_switch_track_transition, "drawable", "o_switch_track_transition"));
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r3, TransitionDrawable.class, "com.obric.aiagent.plugin")).setCrossFadeEnabled(true);
        if (r5 == false) goto L5;
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r3, TransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(0);
    L6:
        return r3;
    L5:
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r3, TransitionDrawable.class, "com.obric.aiagent.plugin")).resetTransition();
        goto L6
    }

    private final void doTrackDrawableTransitionAnim(boolean r5) {
        Drawable r4 = getTrackDrawable();
        if (ZeusTransformUtils.instanceOf(r4, TransitionDrawable.class) == false) goto L8;
        if (r5 == false) goto L6;
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r4, TransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(SwitchCompat.TRACK_ANIMATION_DURATION_ON);
        return;
    L6:
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r4, TransitionDrawable.class, "com.obric.aiagent.plugin")).reverseTransition(100);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, CustomTransitionDrawable.class) == false) goto L15;
        if (r5 == false) goto L11;
        ((CustomTransitionDrawable) ZeusTransformUtils.preCheckCast(r4, CustomTransitionDrawable.class, "com.obric.aiagent.plugin")).startTransition(SwitchCompat.TRACK_ANIMATION_DURATION_ON);
        return;
    L11:
        ((CustomTransitionDrawable) ZeusTransformUtils.preCheckCast(r4, CustomTransitionDrawable.class, "com.obric.aiagent.plugin")).reverseTransition(100);
        return;
    }

    private final void changeTrackDrawableStateWithoutAnim(boolean r4) {
        Drawable r0 = getTrackDrawable();
        if (ZeusTransformUtils.instanceOf(r0, TransitionDrawable.class) == false) goto L8;
        if (r4 == false) goto L6;
        reflectShowSecondLayer((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.aiagent.plugin")).resetTransition();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, CustomTransitionDrawable.class) == false) goto L15;
        if (r4 == false) goto L11;
        ((CustomTransitionDrawable) ZeusTransformUtils.preCheckCast(r0, CustomTransitionDrawable.class, "com.obric.aiagent.plugin")).showSecondLayer();
        return;
    L11:
        ((CustomTransitionDrawable) ZeusTransformUtils.preCheckCast(r0, CustomTransitionDrawable.class, "com.obric.aiagent.plugin")).resetTransition();
        return;
    }

    private final Object reflectShowSecondLayer(TransitionDrawable r4) {
        Method r3 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        b.b(TAG, "reflectShowSecondLayer, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    static /* synthetic */ void increaseTouchArea$default(OSwitch r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 20;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 20;
    L8:
        r1.increaseTouchArea(r2, r3);
    }

    private final void increaseTouchArea(int r11, int r12) {
        measure(0, 0);     // Catch: Exception -> L21
        int r2 = getMeasuredWidth();     // Catch: Exception -> L21
        int r3 = getMeasuredHeight();     // Catch: Exception -> L21
        if (r2 <= 0) goto L20;
        if (r3 <= 0) goto L26;
        int r13 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r11) + r2;     // Catch: Exception -> L21
        int r14 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r12) + r3;     // Catch: Exception -> L21
        c r4 = c.f35012a;     // Catch: Exception -> L21
        ViewParent r5 = getParent();     // Catch: Exception -> L21
        if (r5 != null) goto L11;
    L9:
        r5 = null;
    L12:
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L21
        if (r6 == null) goto L18;
        r6.measure(0, 0);     // Catch: Exception -> L21
        int r1 = r6.getMeasuredWidth();     // Catch: Exception -> L21
        if (r14 > r6.getMeasuredHeight()) goto L17;
        if (r13 <= r1) goto L18;
    L17:
        k.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), r13, r14, false, 4, null);     // Catch: Exception -> L21
    L18:
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r13, r14, false, 4, null);     // Catch: Exception -> L21
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L9;
    L26:
        return;
    L20:
        return;
    L21:
        e = move-exception;
        b.b(TAG, "increaseTouchArea, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
