package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ExpandableTextLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandableTextLayout extends FrameLayout {
    private final Bitmap arrowDown;
    private final Bitmap arrowUp;
    private boolean collapsed;
    private int maxCollapsedLines;
    private CharSequence originalText;
    private boolean showArrow;
    private final TextView textView;

    public ExpandableTextLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ExpandableTextLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$e0TXgaz-1H9iw7hCPJkBU3ip6Zc, reason: not valid java name */
    public static /* synthetic */ void m553lambda$e0TXgaz1H9iw7hCPJkBU3ip6Zc(ExpandableTextLayout r0) {
        setText$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$isGcjTZB8N208qz0gVxW6eq8jPk(ExpandableTextLayout r0) {
        updateText$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$ubcADwuzAE-aBT3FdiiZbApqCc0, reason: not valid java name */
    public static /* synthetic */ void m554lambda$ubcADwuzAEaBT3FdiiZbApqCc0(ExpandableTextLayout r0) {
        setTextImmediately$lambda$2(r0);
    }

    public /* synthetic */ ExpandableTextLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public ExpandableTextLayout(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13);
        TextView r16 = new TextView(r14);
        r16.setTextColor(-16777216);
        r16.setTextSize(14.0f);
        r16.setLineSpacing(3.0f, 1.1f);
        r16.setHighlightColor(0);
        r16.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.textView = r16;
        this.maxCollapsedLines = 2;
        this.collapsed = true;
        Drawable r3 = androidx.core.content.a.a(r14, ZeusTransformUtils.mapRes(R.drawable.ic_disclosure, "drawable", "ic_disclosure"));
        Bitmap r9 = null;
        if (r3 == null) goto L7;
        Bitmap r4 = androidx.core.graphics.drawable.b.a(r3, 0, 0, null, 7, null);
        if (r4 == null) goto L7;
        float r5 = 14;
        Bitmap r6 = Bitmap.createScaledBitmap(r4, d.i.a.a(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics())), true);
    L8:
        this.arrowDown = r6;
        Drawable r7 = androidx.core.content.a.a(r14, ZeusTransformUtils.mapRes(R.drawable.ic_disclosure_up, "drawable", "ic_disclosure_up"));
        if (r7 == null) goto L13;
        Bitmap r17 = androidx.core.graphics.drawable.b.a(r7, 0, 0, null, 7, null);
        if (r17 == null) goto L13;
        float r0 = 14;
        r9 = Bitmap.createScaledBitmap(r17, d.i.a.a(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), true);
    L13:
        this.arrowUp = r9;
        addView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final int getMaxCollapsedLines() {
        return this.maxCollapsedLines;
    }

    public final void setMaxCollapsedLines(int r1) {
        this.maxCollapsedLines = r1;
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.originalText = r4;
        if (getWidth() > 0) goto L5;
    L13:
        post(new $$Lambda$ExpandableTextLayout$e0TXgaz1H9iw7hCPJkBU3ip6Zc(this));
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
        updateText$default(this, false, 1, null);
        return;
    L7:
        if (r4.length() == 0) goto L10;
        r5 = false;
        goto L11
    }

    private static final void setText$lambda$1(ExpandableTextLayout r3) {
        updateText$default(r3, false, 1, null);
    }

    public final void setTextImmediately(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.originalText = r4;
        this.textView.setText(r4);
        post(new $$Lambda$ExpandableTextLayout$ubcADwuzAEaBT3FdiiZbApqCc0(this));
    }

    private static final void setTextImmediately$lambda$2(ExpandableTextLayout r3) {
        updateText$default(r3, false, 1, null);
    }

    public final CharSequence getText() {
        return this.originalText;
    }

    public final void setCollapsed(boolean r3) {
        this.collapsed = r3;
        updateText$default(this, false, 1, null);
    }

    public final void showArrow(boolean r3) {
        this.showArrow = r3;
        updateText$default(this, false, 1, null);
    }

    public final boolean isCollapsed() {
        return this.collapsed;
    }

    private final void toggle() {
        this.collapsed = !this.collapsed;
        updateText$default(this, false, 1, null);
    }

    static /* synthetic */ void updateText$default(ExpandableTextLayout r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.updateText(r1);
    }

    private final void updateText(boolean r11) {
        CharSequence r0 = this.originalText;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getWidth() != 0) goto L11;
        this.textView.setText(r0);
        if (r11 == false) goto L38;
        post(new $$Lambda$ExpandableTextLayout$isGcjTZB8N208qz0gVxW6eq8jPk(this));
        return;
    L38:
        return;
    L11:
        StaticLayout r12 = createStaticLayout(r0);
        int r1 = r12.getLineCount();
        int r2 = this.maxCollapsedLines;
        if (r1 > r2) goto L16;
        this.textView.setText(r0);
        return;
    L16:
        if (this.collapsed == false) goto L33;
        int r3 = r2 - 1;
        int r4 = r12.getLineEnd(r3);
        if (this.showArrow == false) goto L24;
        Bitmap r5 = this.arrowDown;
        if (r5 == null) goto L22;
        int r6 = r5.getWidth();
    L23:
        int r7 = r6 + d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    L25:
        int r8 = r12.getLineStart(r3);
        int r9 = 0;
    L26:
        if (r4 <= r8) goto L32;
        if (r9 >= 1000) goto L32;
        if ((this.textView.getPaint().measureText(r0.subSequence(r8, r4) + "... ") + r7) <= r12.getWidth()) goto L32;
        r4 = r4 - 1;
        r9 = r9 + 1;
    L32:
        setTextWithArrow(d.o.o.c(r0.subSequence(0, r4)), this.arrowDown, true);
        return;
    L22:
        r6 = 0;
        goto L23
    L24:
        r7 = d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        goto L25
    L33:
        setTextWithArrow(r0, this.arrowUp, false);
    }

    private static final void updateText$lambda$3(ExpandableTextLayout r1) {
        r1.updateText(false);
    }

    private final void setTextWithArrow(CharSequence r4, Bitmap r5, boolean r6) {
        SpannableStringBuilder r0 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r6 == false) goto L6;
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.aiagent.plugin"));
    L6:
        if (this.showArrow == false) goto L9;
        if (r5 == null) goto L9;
        ImageSpan r7 = new ImageSpan((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, 1);
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), r7, 33);
    L9:
        this.textView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final StaticLayout createStaticLayout(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        StaticLayout r4 = StaticLayout.Builder.obtain(r6, 0, r6.length(), this.textView.getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight()).setLineSpacing(this.textView.getLineSpacingExtra(), this.textView.getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(this.textView.getIncludeFontPadding()).setEllipsize(this.textView.getEllipsize()).setMaxLines(this.textView.getMaxLines()).setBreakStrategy(this.textView.getBreakStrategy()).build();
        o.c(r4, "build(...)");
        return r4;
    }
}
