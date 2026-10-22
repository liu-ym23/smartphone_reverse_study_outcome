package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/AutoEllipsesTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "content", "", "setContentText", "", "maxLines", "setMaxLines", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoEllipsesTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f138628f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f138629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f138630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f138631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f138632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f138633e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoEllipsesTextView f138634a;

        public a(AutoEllipsesTextView r100) {
            this.f138634a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AutoEllipsesTextView r100 = this.f138634a;     // Catch: Throwable -> L4
            int r101 = AutoEllipsesTextView.f138628f;     // Catch: Throwable -> L4
            r100.x();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AutoEllipsesTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoEllipsesTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void x() {
        if (this.f138629a != null) goto L6;
        return;
    L6:
        if (getMaxLines() > 0) goto L8;
        return;
    L8:
        if (getLayout() != null) goto L10;
        return;
    L10:
        if (getLayout().getWidth() > 0) goto L13;
        return;
    L13:
        if (getLayout().getLineCount() > getMaxLines()) goto L16;
        return;
    L16:
        if ((this.f138629a instanceof SpannableString) == true) goto L18;
        return;
    L18:
        int r100 = getLayout().getWidth();
        CharSequence r101 = this.f138629a;
        if (r101 == null) goto L78;
        SpannableString r110 = (SpannableString) r101;
        Object[] r102 = r110.getSpans(r110.length() - 1, r110.length(), Object.class);
        int r103 = r102.length;
        int r104 = 0;
    L22:
        if (r104 >= r103) goto L27;
        Object r105 = r102[r104];
        if ((r105 instanceof ClickableSpan) == true) goto L25;
        r104 = r104 + 1;
        goto L22
    L25:
        ClickableSpan r111 = (ClickableSpan) r105;
    L29:
        if (r111 != null) goto L35;
        int r106 = getLayout().getLineStart(getMaxLines() - 1);
        CharSequence r107 = TextUtils.ellipsize(r110.subSequence(r106, r110.length()), getPaint(), r100, TextUtils.TruncateAt.END);
        int r108 = this.f138632d.length();
        int r109 = r106 + r107.length();
        if (StringsKt.endsWith$default(r107, this.f138632d, false, 2, null) == false) goto L33;
        r109 = r109 - r108;
    L33:
        setText(new SpannableStringBuilder(r110.subSequence(0, r109)).append(this.f138632d));
        return;
    L35:
        SpannableStringBuilder r112 = new SpannableStringBuilder(this.f138629a);
        if (Build.VERSION.SDK_INT < 23) goto L38;
        StaticLayout r113 = StaticLayout.Builder.obtain(r112, 0, r112.length(), getPaint(), r100).setIncludePad(getIncludeFontPadding()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).build();
    L40:
        if (r113.getLineCount() <= getMaxLines()) goto L90;
        int r114 = r113.getLineStart(getMaxLines() - 1);
        int r115 = r110.getSpanStart(r111);
        int r116 = r110.getSpanEnd(r111);
        int r117 = r110.getSpanFlags(r111);
        CharSequence r118 = r110.subSequence(r115, r116);
        int r119 = r116 - r115;
        if ((r118 instanceof Spannable) == false) goto L53;
        ReplacementSpan[] r120 = (ReplacementSpan[]) ((Spannable) r118).getSpans(0, r118.length(), ReplacementSpan.class);
        int r121 = r120.length;
        int r122 = 0;
        int r210 = 0;
    L44:
        if (r122 >= r121) goto L55;
        ReplacementSpan r123 = r120[r122];
        Spannable r124 = (Spannable) r118;
        int r125 = r124.getSpanStart(r123) - r115;
        int r126 = r124.getSpanEnd(r123) - r115;
        if (r125 >= 0) goto L48;
        int r127 = r115;
    L49:
        if (r126 <= r119) goto L51;
        int r128 = r119;
    L52:
        r210 = r210 + r123.getSize(getPaint(), r118, r127, r128, getPaint().getFontMetricsInt());
        r122 = r122 + 1;
        goto L44
    L51:
        r128 = r126;
        goto L52
    L48:
        r127 = r125;
    L55:
        if (this.f138630b == false) goto L57;
        int r129 = (int) (getPaint().measureText(this.f138631c) + 0.5f);
    L58:
        CharSequence r130 = TextUtils.ellipsize(r110.subSequence(r114, r115 + 1), getPaint(), (r100 - r210) - r129, TextUtils.TruncateAt.END);
        int r131 = this.f138632d.length();
        int r132 = r114 + r130.length();
        if (StringsKt.endsWith$default(r130, this.f138632d, false, 2, null) == false) goto L61;
        r132 = r132 - r131;
    L61:
        SpannableStringBuilder r133 = new SpannableStringBuilder(r110.subSequence(0, r132)).append(this.f138632d);
        Object[] r134 = r110.getSpans(0, r132, Object.class);
        int r135 = r134.length;
        int r136 = 0;
    L62:
        if (r136 >= r135) goto L73;
        Object r137 = r134[r136];
        int r138 = r110.getSpanStart(r137);
        int r139 = r110.getSpanEnd(r137);
        int r140 = r132 - 1;
        if (r138 > r140) goto L71;
        if (r139 <= r140) goto L71;
        int r141 = r110.getSpanFlags(r137);
        r133.removeSpan(r137);
        if ((r137 instanceof ReplacementSpan) == false) goto L70;
        r133.setSpan(r137, r138, r132, r141);
        goto L71
    L70:
        r133.setSpan(r137, r138, r132 + r131, r141);
    L71:
        r136 = r136 + 1;
        goto L62
    L73:
        if (this.f138630b == false) goto L75;
        r133.append(this.f138631c);
    L75:
        int r142 = r133.length();
        r133.append(r118);
        r133.setSpan(r111, r142, r118.length() + r142, r117);
        setText(r133);
        return;
    L57:
        r129 = 0;
        goto L58
    L53:
        r210 = (int) getPaint().measureText(r118.toString());
        goto L55
    L90:
        return;
    L38:
        r113 = new StaticLayout(r112, getPaint(), r100, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
        goto L40
    L27:
        r111 = null;
        goto L29
    L78:
        throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
    }

    public final void y() {
        if (getLayout() != null) goto L5;
        removeCallbacks(this.f138633e);
        post(this.f138633e);
        return;
    L5:
        x();
    }

    public final void setContentText(CharSequence r100) {
        this.f138629a = r100;
        setText(r100);
        if (TextUtils.isEmpty(this.f138629a) == true) goto L6;
        y();
        return;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r100) {
        int r101 = getMaxLines();
        super.setMaxLines(r100);
        if (r101 == r100) goto L6;
        setText(this.f138629a);
        y();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        float r102 = getTextSize();
        super.setTextSize(r100, r101);
        if (r102 == getTextSize()) goto L6;
        setText(this.f138629a);
        y();
        return;
    }

    public AutoEllipsesTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138631c = " ";
        this.f138632d = "…";
        this.f138633e = new a(this);
    }

    public /* synthetic */ AutoEllipsesTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L14;
        if (r100 > 0) goto L6;
        return;
    L6:
        if (getVisibility() != 0) goto L12;
        if (r102 == 0) goto L12;
        if (r103 == 0) goto L12;
        if ((!Intrinsics.areEqual(this.f138629a, getText())) == false) goto L12;
        setText(this.f138629a);
    L12:
        y();
        return;
    }
}
