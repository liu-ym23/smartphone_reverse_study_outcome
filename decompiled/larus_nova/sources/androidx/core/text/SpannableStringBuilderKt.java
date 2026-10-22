package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "color", "", CommodityText.BOLD, "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", SegmentStyle.UNDERLINE, "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringBuilderKt {
    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> r100) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        r100.invoke(r101);
        return new SpannedString(r101);
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        StyleSpan r102 = new StyleSpan(1);
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        StyleSpan r102 = new StyleSpan(2);
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        StrikethroughSpan r102 = new StrikethroughSpan();
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        SubscriptSpan r102 = new SubscriptSpan();
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        SuperscriptSpan r102 = new SuperscriptSpan();
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder r100, Function1<? super SpannableStringBuilder, Unit> r101) {
        UnderlineSpan r102 = new UnderlineSpan();
        int r103 = r100.length();
        r101.invoke(r100);
        r100.setSpan(r102, r103, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder r100, int r101, Function1<? super SpannableStringBuilder, Unit> r102) {
        BackgroundColorSpan r103 = new BackgroundColorSpan(r101);
        int r104 = r100.length();
        r102.invoke(r100);
        r100.setSpan(r103, r104, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder r100, int r101, Function1<? super SpannableStringBuilder, Unit> r102) {
        ForegroundColorSpan r103 = new ForegroundColorSpan(r101);
        int r104 = r100.length();
        r102.invoke(r100);
        r100.setSpan(r103, r104, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r100, Object[] r101, Function1<? super SpannableStringBuilder, Unit> r102) {
        int r103 = r100.length();
        r102.invoke(r100);
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r100.setSpan(r101[r105], r103, r100.length(), 17);
        r105 = r105 + 1;
        goto L3
    L5:
        return r100;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder r100, float r101, Function1<? super SpannableStringBuilder, Unit> r102) {
        RelativeSizeSpan r103 = new RelativeSizeSpan(r101);
        int r104 = r100.length();
        r102.invoke(r100);
        r100.setSpan(r103, r104, r100.length(), 17);
        return r100;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r100, Object r101, Function1<? super SpannableStringBuilder, Unit> r102) {
        int r103 = r100.length();
        r102.invoke(r100);
        r100.setSpan(r101, r103, r100.length(), 17);
        return r100;
    }
}
