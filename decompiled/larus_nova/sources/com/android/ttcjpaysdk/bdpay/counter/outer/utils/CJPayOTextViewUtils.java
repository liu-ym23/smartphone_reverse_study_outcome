package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0002J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0002J>\u0010\u0018\u001a\u00020\u0012*\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOTextViewUtils;", "", "()V", "ELLIPSIS", "", "calculateTruncatedText", "text", "staticLayout", "Landroid/text/StaticLayout;", "maxLines", "", "availableWidth", "expandText", "paint", "Landroid/text/TextPaint;", "createStaticLayout", "textPaint", "setupExpandClickableSpan", "", "spannable", "Landroid/text/SpannableString;", "expandTextColor", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "setExpandableText", "Landroid/widget/TextView;", "", "expandCallback", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOTextViewUtils {
    private static final String ELLIPSIS = "… ";
    public static final CJPayOTextViewUtils INSTANCE = null;

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.bdpay.counter.outer.utils.CJPayOTextViewUtils$setExpandableText$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOTextViewUtils$setExpandableText$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Function0<Unit> $expandCallback;
        final /* synthetic */ String $expandText;
        final /* synthetic */ int $expandTextColor;
        final /* synthetic */ Ref.BooleanRef $isExpanded;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ CharSequence $text;
        final /* synthetic */ TextView $this_setExpandableText;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.$this_setExpandableText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int r100 = (this.$this_setExpandableText.getWidth() - this.$this_setExpandableText.getPaddingLeft()) - this.$this_setExpandableText.getPaddingRight();
            onGlobalLayout$updateText(this.$isExpanded, this.$this_setExpandableText, this.$text, r100, this.$maxLines, this.$expandText, this.$expandTextColor, this.$expandCallback);
        }

        public AnonymousClass2(TextView r100, Ref.BooleanRef r101, CharSequence r102, int r103, String r104, int r105, Function0<Unit> r106) {
            this.$this_setExpandableText = r100;
            this.$isExpanded = r101;
            this.$text = r102;
            this.$maxLines = r103;
            this.$expandText = r104;
            this.$expandTextColor = r105;
            this.$expandCallback = r106;
        }

        public static final /* synthetic */ void access$onGlobalLayout$updateText(Ref.BooleanRef r100, TextView r101, CharSequence r102, int r103, int r104, String r105, int r106, Function0 r107) {
            onGlobalLayout$updateText(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        private static final void onGlobalLayout$updateText(final Ref.BooleanRef r110, final TextView r111, final CharSequence r112, final int r113, final int r114, final String r115, final int r210, final Function0<Unit> r211) {
            if (r110.element == false) goto L5;
            r111.setText(r112);
            return;
        L5:
            CJPayOTextViewUtils r116 = CJPayOTextViewUtils.INSTANCE;
            StaticLayout r100 = CJPayOTextViewUtils.access$createStaticLayout(r116, r112.toString(), r113, r111.getPaint());
            if (r100.getLineCount() > r114) goto L8;
            r111.setText(r112);
            return;
        L8:
            SpannableString r117 = new SpannableString(CJPayOTextViewUtils.access$calculateTruncatedText(r116, r112.toString(), r100, r114, r113, r115, r111.getPaint()) + CJPayOTextViewUtils.ELLIPSIS + r115);
            CJPayOTextViewUtils.access$setupExpandClickableSpan(r116, r117, r115, r210, new CJPayOTextViewUtils$setExpandableText$2$onGlobalLayout$updateText$1(r110, r211, r111, r112, r113, r114, r115, r210));
            r111.setText(r117);
        }
    }

    static {
        INSTANCE = new CJPayOTextViewUtils();
    }

    private CJPayOTextViewUtils() {
    }

    private final StaticLayout createStaticLayout(String r110, int r111, TextPaint r112) {
        return new StaticLayout(r110, r112, r111, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public static final /* synthetic */ StaticLayout access$createStaticLayout(CJPayOTextViewUtils r100, String r101, int r102, TextPaint r103) {
        return r100.createStaticLayout(r101, r102, r103);
    }

    private final void setupExpandClickableSpan(SpannableString r100, String r101, final int r102, final Function0<Unit> r103) {
        ClickableSpan r104 = new CJPayOTextViewUtils$setupExpandClickableSpan$clickableSpan$1(r103, r102);
        int r105 = r100.length() - r101.length();
        r100.setSpan(r104, r105, r100.length(), 33);
        r100.setSpan(new ForegroundColorSpan(r102), r105, r100.length(), 33);
    }

    public static final /* synthetic */ void access$setupExpandClickableSpan(CJPayOTextViewUtils r100, SpannableString r101, String r102, int r103, Function0 r104) {
        r100.setupExpandClickableSpan(r101, r102, r103, r104);
    }

    private final String calculateTruncatedText(String r100, StaticLayout r101, int r102, int r103, String r104, TextPaint r110) {
        int r105 = r101.getLineEnd(r102 - 1);
        String r106 = r100.substring(0, r105);
    L3:
        if (r105 <= 0) goto L7;
        if (createStaticLayout(r106 + ELLIPSIS + r104, r103, r110).getLineCount() <= r102) goto L7;
        r105 = r105 - 1;
        r106 = r100.substring(0, r105);
    L7:
        return r106;
    }

    public static /* synthetic */ StaticLayout createStaticLayout$default(CJPayOTextViewUtils r100, String r101, int r102, TextPaint r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = new TextPaint();
    L6:
        return r100.createStaticLayout(r101, r102, r103);
    }

    public final void setExpandableText(TextView r110, CharSequence r111, int r112, String r113, int r114, Function0<Unit> r115) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r113, "expandText");
        Intrinsics.checkNotNullParameter(r115, "expandCallback");
        r110.setMovementMethod(LinkMovementMethod.getInstance());
        Ref.BooleanRef r100 = new Ref.BooleanRef();
        r110.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(r110, r100, r111, r112, r113, r114, r115));
        r110.setText(r111);
    }

    public static final /* synthetic */ String access$calculateTruncatedText(CJPayOTextViewUtils r100, String r101, StaticLayout r102, int r103, int r104, String r105, TextPaint r106) {
        return r100.calculateTruncatedText(r101, r102, r103, r104, r105, r106);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setExpandableText$default(CJPayOTextViewUtils r100, TextView r101, CharSequence r102, int r110, String r111, int r112, Function0 r113, int r114, Object r115) {
        if ((r114 & 4) == 0) goto L5;
        r111 = r101.getContext().getString(R.string.cj_pay_expand);
    L5:
        String r103 = r111;
        if ((r114 & 8) == 0) goto L8;
        r112 = ContextCompat.getColor(r101.getContext(), R.color.cj_pay_color_gray_161823_opacity_34);
    L8:
        int r104 = r112;
        if ((r114 & 16) == 0) goto L11;
        r113 = AnonymousClass1.INSTANCE;
    L11:
        r100.setExpandableText(r101, r102, r110, r103, r104, r113);
    }
}
