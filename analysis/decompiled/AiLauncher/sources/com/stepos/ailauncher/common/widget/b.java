package com.stepos.ailauncher.common.widget;

import La.H;
import Y8.t;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p7.AppUI;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010JY\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JO\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/common/widget/b;", "", "<init>", "()V", "Landroid/widget/TextView;", "tv", "", "fullText", "", "collapsedLines", "moreLabel", "collapseLabel", "labelColor", "previewText", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)V", "width", "", "expanded", "f", "(Landroid/widget/TextView;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)V", "Lkotlin/Function0;", "onToggle", Const.INTENT_KEY_UMID, "(Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/CharSequence;IILp9/a;)Ljava/lang/CharSequence;", "Landroid/text/SpannableStringBuilder;", "builder", "label", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;ILp9/a;)Ljava/lang/CharSequence;", "text", "Landroid/text/Layout;", "e", "(Landroid/widget/TextView;Ljava/lang/CharSequence;I)Landroid/text/Layout;", "", "ELLIPSIS", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    private static final String ELLIPSIS = "… ";
    public static final b INSTANCE = new b();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnLayoutChangeListener {
        final /* synthetic */ CharSequence $collapseLabel$inlined;
        final /* synthetic */ int $collapsedLines$inlined;
        final /* synthetic */ CharSequence $fullText$inlined;
        final /* synthetic */ int $labelColor$inlined;
        final /* synthetic */ CharSequence $moreLabel$inlined;
        final /* synthetic */ CharSequence $previewText$inlined;
        final /* synthetic */ TextView $tv$inlined;

        public a(TextView textView, CharSequence charSequence, int i10, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4) {
            this.$tv$inlined = textView;
            this.$fullText$inlined = charSequence;
            this.$collapsedLines$inlined = i10;
            this.$moreLabel$inlined = charSequence2;
            this.$collapseLabel$inlined = charSequence3;
            this.$labelColor$inlined = i11;
            this.$previewText$inlined = charSequence4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            b.INSTANCE.b(this.$tv$inlined, this.$fullText$inlined, this.$collapsedLines$inlined, this.$moreLabel$inlined, this.$collapseLabel$inlined, this.$labelColor$inlined, this.$previewText$inlined);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/common/widget/b$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.widget.b$b, reason: collision with other inner class name */
    public static final class C0303b extends ClickableSpan {
        final /* synthetic */ int $labelColor;
        final /* synthetic */ InterfaceC5063a<t> $onToggle;

        public C0303b(InterfaceC5063a<t> interfaceC5063a, int i10) {
            this.$onToggle = interfaceC5063a;
            this.$labelColor = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            p.i(widget, "widget");
            this.$onToggle.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            p.i(ds, "ds");
            ds.setColor(this.$labelColor);
            ds.setUnderlineText(false);
        }
    }

    public static /* synthetic */ void c(b bVar, TextView textView, CharSequence charSequence, int i10, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, int i12, Object obj) {
        if ((i12 & 64) != 0) {
            charSequence4 = charSequence;
        }
        bVar.b(textView, charSequence, i10, charSequence2, charSequence3, i11, charSequence4);
    }

    public static final t g(TextView textView, CharSequence charSequence, CharSequence charSequence2, int i10, CharSequence charSequence3, CharSequence charSequence4, int i11, int i12, boolean z10) {
        INSTANCE.f(textView, charSequence, charSequence2, i10, charSequence3, charSequence4, i11, i12, !z10);
        return t.f7040a;
    }

    public final void b(TextView tv, CharSequence fullText, int collapsedLines, CharSequence moreLabel, CharSequence collapseLabel, int labelColor, CharSequence previewText) {
        p.i(tv, "tv");
        p.i(fullText, "fullText");
        p.i(moreLabel, "moreLabel");
        p.i(collapseLabel, "collapseLabel");
        p.i(previewText, "previewText");
        tv.setEllipsize(null);
        tv.setText(fullText);
        int width = (tv.getWidth() - tv.getPaddingLeft()) - tv.getPaddingRight();
        if (width <= 0) {
            if (!tv.isLaidOut() || tv.isLayoutRequested()) {
                tv.addOnLayoutChangeListener(new a(tv, fullText, collapsedLines, moreLabel, collapseLabel, labelColor, previewText));
                return;
            } else {
                INSTANCE.b(tv, fullText, collapsedLines, moreLabel, collapseLabel, labelColor, previewText);
                return;
            }
        }
        if (e(tv, fullText, width).getLineCount() > collapsedLines) {
            f(tv, fullText, previewText, collapsedLines, moreLabel, collapseLabel, labelColor, width, false);
        } else {
            tv.setMaxLines(Integer.MAX_VALUE);
            tv.setMovementMethod(null);
        }
    }

    public final CharSequence d(TextView tv, CharSequence fullText, int collapsedLines, CharSequence moreLabel, int labelColor, int width, InterfaceC5063a<t> onToggle) {
        for (int iJ = C5685n.j(e(tv, fullText, width).getLineEnd(Math.min(collapsedLines, r0.getLineCount()) - 1), fullText.length()); iJ > 0; iJ--) {
            SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(H.F1(fullText.subSequence(0, iJ).toString()).toString()).append((CharSequence) ELLIPSIS);
            p.h(spannableStringBuilderAppend, "append(...)");
            CharSequence charSequenceH = h(spannableStringBuilderAppend, moreLabel, labelColor, onToggle);
            if (e(tv, charSequenceH, width).getLineCount() <= collapsedLines) {
                return charSequenceH;
            }
        }
        return h(new SpannableStringBuilder(ELLIPSIS), moreLabel, labelColor, onToggle);
    }

    public final Layout e(TextView tv, CharSequence text, int width) {
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(text, 0, text.length(), tv.getPaint(), width).setLineSpacing(tv.getLineSpacingExtra(), tv.getLineSpacingMultiplier()).setIncludePad(tv.getIncludeFontPadding()).setBreakStrategy(tv.getBreakStrategy()).setHyphenationFrequency(tv.getHyphenationFrequency()).build();
        p.h(staticLayoutBuild, "build(...)");
        return staticLayoutBuild;
    }

    public final void f(final TextView tv, final CharSequence fullText, final CharSequence previewText, final int collapsedLines, final CharSequence moreLabel, final CharSequence collapseLabel, final int labelColor, final int width, final boolean expanded) {
        CharSequence charSequenceD;
        InterfaceC5063a<t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.widget.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b.g(tv, fullText, previewText, collapsedLines, moreLabel, collapseLabel, labelColor, width, expanded);
            }
        };
        tv.setMaxLines(expanded ? Integer.MAX_VALUE : collapsedLines);
        if (expanded) {
            SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(fullText).append(' ');
            p.h(spannableStringBuilderAppend, "append(...)");
            charSequenceD = h(spannableStringBuilderAppend, collapseLabel, labelColor, interfaceC5063a);
        } else {
            charSequenceD = d(tv, previewText, collapsedLines, moreLabel, labelColor, width, interfaceC5063a);
        }
        tv.setText(charSequenceD);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setHighlightColor(0);
    }

    public final CharSequence h(SpannableStringBuilder builder, CharSequence label, int labelColor, InterfaceC5063a<t> onToggle) {
        int length = builder.length();
        builder.append(label);
        builder.setSpan(new ForegroundColorSpan(labelColor), length, builder.length(), 33);
        builder.setSpan(new StyleSpan(1), length, builder.length(), 33);
        builder.setSpan(new C0303b(onToggle, labelColor), length, builder.length(), 33);
        return builder;
    }
}
