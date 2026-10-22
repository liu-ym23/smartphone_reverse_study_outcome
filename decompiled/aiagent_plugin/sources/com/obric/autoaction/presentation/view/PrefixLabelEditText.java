package com.obric.autoaction.presentation.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.b.g;
import com.obric.autoaction.presentation.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: PrefixLabelEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PrefixLabelEditText extends ConstraintLayout {
    private final g binding;
    private String hint;
    private final TextView hintView;
    private final EditText inputText;
    private a prefix;

    /* JADX INFO: compiled from: PrefixLabelEditText.kt */
    private static final class TextSpan extends ReplacementSpan {
        private final boolean onlyGetSize;
        private final String text;
        private final int textColor;
        private final Float textSizePx;

        public /* synthetic */ TextSpan(String r1, int r2, Float r3, boolean r4, int r5, h r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = false;
        L8:
            this(r1, r2, r3, r4);
        }

        public TextSpan(String r2, int r3, Float r4, boolean r5) {
            o.e(r2, "text");
            this.text = r2;
            this.textColor = r3;
            this.textSizePx = r4;
            this.onlyGetSize = r5;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r3, "paint");
            o.e(r8, "text");
            Paint r9 = update(r3, this.textSizePx);
            if (r7 != null) goto L5;
        L17:
            if (r7 == null) goto L37;
            if (r7.ascent != 0) goto L37;
            if (r7.descent != 0) goto L37;
            if (r7.top != 0) goto L37;
            if (r7.bottom != 0) goto L37;
            Object r10 = Float.valueOf(r3.getTextSize());
            if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L29;
            boolean r11 = true;
        L30:
            if (r11 == true) goto L33;
            r10 = null;
        L33:
            if (r10 != null) goto L35;
            r10 = Integer.valueOf(d.i.a.a(TypedValue.applyDimension(1, ((Number) ZeusTransformUtils.preCheckCast(16, Number.class, "com.obric.aiagent.plugin")).floatValue(), Resources.getSystem().getDisplayMetrics())));
        L35:
            int r12 = -((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue();
            r7.ascent = r12;
            r7.descent = 0;
            r7.top = r12;
            r7.bottom = 0;
            goto L37
        L29:
            r11 = false;
        L37:
            return (int) r9.measureText(this.text);
        L5:
            if (r7.ascent != 0) goto L17;
            if (r7.descent != 0) goto L17;
            if (r7.top != 0) goto L17;
            if (r7.bottom != 0) goto L17;
            Paint.FontMetricsInt r0 = r3.getFontMetricsInt();
            if (r0 == null) goto L17;
            if (r3.getTextSize() <= 0.0f) goto L17;
            r7.ascent = r0.ascent;
            r7.descent = r0.descent;
            r7.top = r0.top;
            r7.bottom = r0.bottom;
            goto L17
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r1, "canvas");
            o.e(r10, "text");
            o.e(r9, "paint");
            if (this.onlyGetSize == false) goto L5;
            return;
        L5:
            r1.drawText(this.text, r5, r7, update(r9, this.textSizePx));
        }

        static /* synthetic */ Paint update$default(TextSpan r0, Paint r1, Float r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.update(r1, r2);
        }

        private final Paint update(Paint r2, Float r3) {
            Paint r0 = new Paint(r2);
            if (r3 == null) goto L5;
            float r4 = r3.floatValue();
        L6:
            r0.setTextSize(r4);
            r0.setAntiAlias(true);
            r0.setColor(this.textColor);
            r0.setTypeface(Typeface.create(r0.getTypeface(), 1));
            return r0;
        L5:
            r4 = r0.getTextSize();
            goto L6
        }
    }

    /* JADX INFO: compiled from: PrefixLabelEditText.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f25120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f25121b;

        public a(String r2, String r3) {
            o.e(r2, "displayText");
            o.e(r3, "tag");
            this.f25120a = r2;
            this.f25121b = r3;
        }

        public final String a() {
            return this.f25120a;
        }

        public final String b() {
            return this.f25121b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrefixLabelEditText(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ PrefixLabelEditText(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ String access$getHint$p(PrefixLabelEditText r0) {
        return r0.hint;
    }

    public static final /* synthetic */ TextView access$getHintView$p(PrefixLabelEditText r0) {
        return r0.hintView;
    }

    public static final /* synthetic */ void access$setPrefix$p(PrefixLabelEditText r0, a r1) {
        r0.prefix = r1;
    }

    public PrefixLabelEditText(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        g r7 = g.a(LayoutInflater.from(r5), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        o.c(r7, "inflate(...)");
        this.binding = r7;
        EditText r8 = r7.f24613a;
        o.c(r8, "edit");
        this.inputText = r8;
        TextView r9 = r7.f24614b;
        o.c(r9, "hint");
        this.hintView = r9;
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r11 = new PrefixLabelEditText$special$$inlined$addTextChangedListener$default$1(this);
        r10.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r11, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r12 = (TextWatcher) ZeusTransformUtils.preCheckCast(r11, TextWatcher.class, "com.obric.aiagent.plugin");
        if (isInEditMode() == false) goto L6;
        setPrefix("定时任务", "设置定时任务");
        setHint("例如 “下午 3 点叫一杯少糖的冰美式”");
        return;
    }

    public final void setText(String r4) {
        o.e(r4, "text");
        this.inputText.setText((CharSequence) ZeusTransformUtils.preCheckCast(createPrefixSpanString().append((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final String getText() {
        String r0 = this.inputText.getText().toString();
        a r5 = this.prefix;
        if (r5 != null) goto L6;
        return r0;
    L6:
        if (d.o.o.b(r0, r5.b(), false, 2, null) == false) goto L9;
        String r6 = r0.substring(r5.b().length());
        o.c(r6, "substring(...)");
        return r6;
    L9:
        return r0;
    }

    public final void addTextChangedListener(b<? super Editable, x> r3) {
        final b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "afterTextChanged");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(this.inputText, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r0 = new PrefixLabelEditText$addTextChangedListener$$inlined$addTextChangedListener$default$1(r4);
        r2.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r5 = (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.aiagent.plugin");
    }

    public final void setFullText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "text");
        this.inputText.setText(r4);
    }

    public final String getFullText() {
        return this.inputText.getText().toString();
    }

    public final void setPrefix(String r3, String r4) {
        o.e(r3, "displayText");
        o.e(r4, "tag");
        this.prefix = new a(r3, r4);
        this.inputText.setText((CharSequence) ZeusTransformUtils.preCheckCast(createPrefixSpanString(), CharSequence.class, "com.obric.aiagent.plugin"));
        String r5 = this.hint;
        if (r5 == null) goto L6;
        setHint(r5);
        return;
    }

    public static /* synthetic */ void setHint$default(PrefixLabelEditText r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.setHint(r1);
    }

    public final void setHint(String r11) {
        this.hint = r11;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        ((View) ZeusTransformUtils.preCheckCast(this.hintView, View.class, "com.obric.aiagent.plugin")).setVisibility(8);
        return;
    L12:
        SpannableStringBuilder r2 = new SpannableStringBuilder();
        a r4 = this.prefix;
        if (r4 == null) goto L15;
        TextSpan r5 = new TextSpan(r4.a(), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6")), Float.valueOf(this.inputText.getTextSize()), true);
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.aiagent.plugin"));
        r2.setSpan(r5, 0, 1, 33);
    L15:
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        this.hintView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void showSoftKeyboard() {
        k.a(this.inputText);
    }

    public final boolean hasUserInput(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        a r3 = this.prefix;
        if (r3 != null) goto L15;
        return true;
    L15:
        return !o.a(r5.toString(), r3.b());
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void attach(final View r5) {
        o.e(r5, "view");
        EditText r0 = this.inputText;
        r5.setEnabled(hasUserInput((CharSequence) ZeusTransformUtils.preCheckCast(r0.getText(), CharSequence.class, "com.obric.aiagent.plugin")));
        r0.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new PrefixLabelEditText$attach$1$1(r5, this), TextWatcher.class, "com.obric.aiagent.plugin"));
    }

    private final SpannableStringBuilder createPrefixSpanString() {
        a r0 = this.prefix;
        if (r0 == null) goto L5;
        TextSpan r8 = new TextSpan(r0.a(), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_6, "color", "oui_ai_a_color2_6")), Float.valueOf(this.inputText.getTextSize()), false, 8, null);
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        r10.append((CharSequence) ZeusTransformUtils.preCheckCast(r0.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        r10.setSpan(r8, 0, r0.b().length(), 33);
        return r10;
    L5:
        return new SpannableStringBuilder();
    }
}
