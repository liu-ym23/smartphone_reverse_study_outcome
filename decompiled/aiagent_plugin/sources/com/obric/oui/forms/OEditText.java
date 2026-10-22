package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.a.r;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: OEditText.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OEditText extends AppCompatEditText {
    private a commitCompletionListener;
    private boolean isBottomFading;
    private boolean isLeftFading;
    private boolean isPerformingLongClick;
    private boolean isRightFading;
    private boolean isTopFading;
    private int mErrorBackgroundColor;
    private float mPasswordMaskDotSizeRatio;
    private float mPasswordMaskDotSpacingRatio;
    private final OnFocusChangeListenerWrapper onFocusChangeListenerWrapper;
    private final OnTouchListenerWrapper onTouchListenerWrapper;
    private final TextWatcherWrapper textWatcherWrapper;

    /* JADX INFO: compiled from: OEditText.kt */
    private static final class OnFocusChangeListenerWrapper implements View.OnFocusChangeListener {
        private b<? super Boolean, x> action;
        private View.OnFocusChangeListener listener;

        public OnFocusChangeListenerWrapper() {
        }

        public final b<Boolean, x> getAction() {
            return this.action;
        }

        public final void setAction(b<? super Boolean, x> r3) {
            this.action = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        }

        public final View.OnFocusChangeListener getListener() {
            return this.listener;
        }

        public final void setListener(View.OnFocusChangeListener r3) {
            this.listener = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r3, boolean r4) {
            b<? super Boolean, x> r0 = this.action;
            if (r0 == null) goto L6;
            r0.invoke(Boolean.valueOf(r4));
        L6:
            View.OnFocusChangeListener r2 = this.listener;
            if (r2 == null) goto L11;
            r2.onFocusChange(r3, r4);
            return;
        }
    }

    /* JADX INFO: compiled from: OEditText.kt */
    private static final class OnTouchListenerWrapper implements View.OnTouchListener {
        private b<? super MotionEvent, x> action;
        private View.OnTouchListener listener;

        public OnTouchListenerWrapper() {
        }

        public final b<MotionEvent, x> getAction() {
            return this.action;
        }

        public final void setAction(b<? super MotionEvent, x> r3) {
            this.action = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        }

        public final View.OnTouchListener getListener() {
            return this.listener;
        }

        public final void setListener(View.OnTouchListener r3) {
            this.listener = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnTouchListener.class, "com.obric.aiagent.plugin");
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r2, MotionEvent r3) {
            b<? super MotionEvent, x> r0 = this.action;
            if (r0 == null) goto L6;
            r0.invoke(r3);
        L6:
            View.OnTouchListener r1 = this.listener;
            if (r1 != null) goto L10;
            return false;
        L10:
            return r1.onTouch(r2, r3);
        }
    }

    /* JADX INFO: compiled from: OEditText.kt */
    private static final class TextWatcherWrapper implements TextWatcher {
        private b<? super Editable, x> afterTextChangedAction;
        private r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> beforeTextChangedAction;
        private r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> onTextChangedAction;

        public TextWatcherWrapper() {
        }

        public final r<CharSequence, Integer, Integer, Integer, x> getOnTextChangedAction() {
            return this.onTextChangedAction;
        }

        public final void setOnTextChangedAction(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r3) {
            this.onTextChangedAction = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        }

        public final r<CharSequence, Integer, Integer, Integer, x> getBeforeTextChangedAction() {
            return this.beforeTextChangedAction;
        }

        public final void setBeforeTextChangedAction(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r3) {
            this.beforeTextChangedAction = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        }

        public final b<Editable, x> getAfterTextChangedAction() {
            return this.afterTextChangedAction;
        }

        public final void setAfterTextChangedAction(b<? super Editable, x> r3) {
            this.afterTextChangedAction = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r2 = this.beforeTextChangedAction;
            if (r2 == null) goto L7;
            r2.a(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
            return;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r2 = this.onTextChangedAction;
            if (r2 == null) goto L7;
            r2.a(r7, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6));
            return;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            b<? super Editable, x> r2 = this.afterTextChangedAction;
            if (r2 == null) goto L7;
            r2.invoke(r4);
            return;
        }
    }

    /* JADX INFO: compiled from: OEditText.kt */
    public interface a {
        void a(CompletionInfo r1);
    }

    public OEditText(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OEditText(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    private final boolean isHiddenPasswordInputType(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r1 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r1 == true) goto L20;
        if (r2 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public /* synthetic */ OEditText(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OEditText(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        OnFocusChangeListenerWrapper r11 = new OnFocusChangeListenerWrapper();
        this.onFocusChangeListenerWrapper = r11;
        OnTouchListenerWrapper r12 = new OnTouchListenerWrapper();
        this.onTouchListenerWrapper = r12;
        TextWatcherWrapper r0 = new TextWatcherWrapper();
        this.textWatcherWrapper = r0;
        this.mPasswordMaskDotSizeRatio = 0.38f;
        this.mPasswordMaskDotSpacingRatio = 0.19f;
        this.mErrorBackgroundColor = androidx.core.content.a.c(r9, ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, "color", "oui_functional_red_2"));
        setOnFocusChangeListener((View.OnFocusChangeListener) ZeusTransformUtils.preCheckCast(r11, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin"));
        super.setOnTouchListener((View.OnTouchListener) ZeusTransformUtils.preCheckCast(r12, View.OnTouchListener.class, "com.obric.aiagent.plugin"));
        addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin"));
        setHighlightColor(r9.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_highlight_color, "color", "oui_text_highlight_color")));
        applyPasswordTransformationIfNeeded();
    }

    public final a getCommitCompletionListener() {
        return this.commitCompletionListener;
    }

    public final void setCommitCompletionListener(a r3) {
        this.commitCompletionListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void setTextFading$default(OEditText r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r13 & 8) == 0) goto L17;
        boolean r5 = false;
    L18:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final void setTextFading(boolean r1, boolean r2, boolean r3, boolean r4, int r5) {
        setFadingEdgeLength(r5);
        this.isLeftFading = r1;
        this.isTopFading = r2;
        this.isRightFading = r3;
        this.isBottomFading = r4;
        boolean r6 = false;
        if (r1 == true) goto L7;
        if (r3 == true) goto L7;
        boolean r7 = false;
    L8:
        setHorizontalFadingEdgeEnabled(r7);
        if (this.isTopFading == false) goto L11;
    L12:
        r6 = true;
    L13:
        setVerticalFadingEdgeEnabled(r6);
        return;
    L11:
        if (this.isBottomFading == false) goto L13;
    L7:
        r7 = true;
        goto L8
    }

    public final void onFocusChange$OUI_standardRelease(b<? super Boolean, x> r3) {
        b<? super Boolean, x> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.onFocusChangeListenerWrapper.setAction(r4);
    }

    public final void onOnTouchEvent$OUI_standardRelease(b<? super MotionEvent, x> r3) {
        b<? super MotionEvent, x> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.onTouchListenerWrapper.setAction(r4);
    }

    public final void beforeTextChanged$OUI_standardRelease(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r3) {
        r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.textWatcherWrapper.setBeforeTextChangedAction(r4);
    }

    public final void onTextChanged$OUI_standardRelease(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r3) {
        r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, x> r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.textWatcherWrapper.setOnTextChangedAction(r4);
    }

    public final void afterTextChanged$OUI_standardRelease(b<? super Editable, x> r3) {
        b<? super Editable, x> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        this.textWatcherWrapper.setAfterTextChangedAction(r4);
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.isLeftFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.isRightFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.isTopFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.isBottomFading == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r3) {
        View.OnTouchListener r4 = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnTouchListener.class, "com.obric.aiagent.plugin");
        this.onTouchListenerWrapper.setListener(r4);
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo r1) {
        super.onCommitCompletion(r1);
        a r0 = this.commitCompletionListener;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setInputType(int r1) {
        super.setInputType(r1);
        applyPasswordTransformationIfNeeded();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r2 = super.getOnFocusChangeListener();
        if (ZeusTransformUtils.instanceOf(r2, OnFocusChangeListenerWrapper.class) == true) goto L5;
        return r2;
    L5:
        return ((OnFocusChangeListenerWrapper) ZeusTransformUtils.preCheckCast(r2, OnFocusChangeListenerWrapper.class, "com.obric.aiagent.plugin")).getListener();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OnFocusChangeListenerWrapper.class) == false) goto L5;
        super.setOnFocusChangeListener(r4);
        return;
    L5:
        this.onFocusChangeListenerWrapper.setListener(r4);
    }

    public static /* synthetic */ void setPasswordMask$default(OEditText r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        r1.setPasswordMask(r2, r3);
    }

    public final void setPasswordMask(float r4, float r5) {
        float r6 = n.a(r4, 0.0f);
        float r7 = n.a(r5, 0.0f);
        boolean r1 = true;
        if (this.mPasswordMaskDotSizeRatio != r6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        this.mPasswordMaskDotSizeRatio = r6;
        this.mPasswordMaskDotSpacingRatio = r7;
        applyPasswordTransformationIfNeeded();
        return;
    L8:
        if (this.mPasswordMaskDotSpacingRatio == r7) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void clearPasswordMask() {
        setPasswordMask(0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.isPerformingLongClick = true;
        boolean r0 = super.performLongClick();
        this.isPerformingLongClick = false;
        return r0;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        boolean r3 = true;
    L7:
        if (this.isPerformingLongClick == true) goto L11;
        if (r3 == false) goto L12;
        com.obric.oui.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L7
    }

    private final void applyPasswordTransformationIfNeeded() {
        if (isHiddenPasswordInputType(getInputType()) == false) goto L5;
        TransformationMethod r0 = getTransformationMethod();
        if (ZeusTransformUtils.instanceOf(r0, OPasswordTransformationMethod.class) == false) goto L21;
        boolean r3 = true;
        if (((OPasswordTransformationMethod) ZeusTransformUtils.preCheckCast(r0, OPasswordTransformationMethod.class, "com.obric.aiagent.plugin")).getDotSizeRatio() != this.mPasswordMaskDotSizeRatio) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L21;
        if (((OPasswordTransformationMethod) ZeusTransformUtils.preCheckCast(r0, OPasswordTransformationMethod.class, "com.obric.aiagent.plugin")).getDotSpacingRatio() == this.mPasswordMaskDotSpacingRatio) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L21;
        return;
    L13:
        r1 = false;
    L21:
        super.setTransformationMethod((TransformationMethod) ZeusTransformUtils.preCheckCast(new OPasswordTransformationMethod(this.mPasswordMaskDotSizeRatio, this.mPasswordMaskDotSpacingRatio, this.mErrorBackgroundColor), TransformationMethod.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getTransformationMethod(), PasswordTransformationMethod.class) == false) goto L23;
        super.setTransformationMethod(null);
        return;
    }
}
