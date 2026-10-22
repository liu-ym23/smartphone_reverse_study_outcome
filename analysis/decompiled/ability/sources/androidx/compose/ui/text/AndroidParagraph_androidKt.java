package androidx.compose.ui.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0005\u001a\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0005\u001a\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001fH\u0002\u001a\u0013\u0010 \u001a\u00020\u0001*\u00020!H\u0002¢\u0006\u0004\b\"\u0010\u0005¨\u0006#"}, d2 = {"toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "attachIndentationFixSpan", "", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!SpannedExtensions_androidKt.hasSpan(spannableString, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i6 = 0; i6 < lineCount; i6++) {
            if (textLayout.getLineBottom(i6) > i) {
                return i6;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z10) {
        if (z10 && !TextUnit.m7035equalsimpl0(textStyle.m6347getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) && !TextUnit.m7035equalsimpl0(textStyle.m6347getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE())) {
            int iM6352getTextAligne0LSkKk = textStyle.m6352getTextAligne0LSkKk();
            TextAlign.Companion companion = TextAlign.INSTANCE;
            if (!TextAlign.m6724equalsimpl0(iM6352getTextAligne0LSkKk, companion.m6734getUnspecifiede0LSkKk()) && !TextAlign.m6724equalsimpl0(textStyle.m6352getTextAligne0LSkKk(), companion.m6733getStarte0LSkKk()) && !TextAlign.m6724equalsimpl0(textStyle.m6352getTextAligne0LSkKk(), companion.m6730getJustifye0LSkKk())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m6140toLayoutAlignaXe7zB0(int i) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m6724equalsimpl0(i, companion.m6731getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m6724equalsimpl0(i, companion.m6732getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m6724equalsimpl0(i, companion.m6728getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m6724equalsimpl0(i, companion.m6733getStarte0LSkKk()) && TextAlign.m6724equalsimpl0(i, companion.m6729getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m6141toLayoutBreakStrategyxImikfE(int i) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.INSTANCE;
        if (LineBreak.Strategy.m6653equalsimpl0(i, companion.m6659getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m6653equalsimpl0(i, companion.m6658getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m6653equalsimpl0(i, companion.m6657getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m6142toLayoutHyphenationFrequency3fSNIE(int i) {
        Hyphens.Companion companion = Hyphens.INSTANCE;
        if (Hyphens.m6622equalsimpl0(i, companion.m6626getAutovmbZdU8())) {
            return 4;
        }
        Hyphens.m6622equalsimpl0(i, companion.m6627getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m6143toLayoutLineBreakStylehpcqdu8(int i) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.INSTANCE;
        if (LineBreak.Strictness.m6664equalsimpl0(i, companion.m6668getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m6664equalsimpl0(i, companion.m6669getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m6664equalsimpl0(i, companion.m6670getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m6664equalsimpl0(i, companion.m6671getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m6144toLayoutLineBreakWordStylewPN0Rpw(int i) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.INSTANCE;
        return (!LineBreak.WordBreak.m6676equalsimpl0(i, companion.m6680getDefaultjp8hJ3c()) && LineBreak.WordBreak.m6676equalsimpl0(i, companion.m6681getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m6145toLayoutTextGranularityduNsdkg(int i) {
        TextGranularity.Companion companion = TextGranularity.INSTANCE;
        return (!TextGranularity.m6269equalsimpl0(i, companion.m6273getCharacterDRrd7Zo()) && TextGranularity.m6269equalsimpl0(i, companion.m6274getWordDRrd7Zo())) ? 1 : 0;
    }
}
