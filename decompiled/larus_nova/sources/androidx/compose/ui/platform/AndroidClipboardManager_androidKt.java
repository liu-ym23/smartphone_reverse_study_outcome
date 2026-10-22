package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\r\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\fH\u0000\u001a\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000*\n\u0010\b\"\u00020\t2\u00020\t¨\u00062"}, d2 = {"PLAIN_TEXT_LABEL", "", "toClipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "Landroid/content/ClipData;", "toClipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "Landroid/content/ClipDescription;", "NativeClipboard", "Landroid/content/ClipboardManager;", "convertToAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "", "convertToCharSequence", "UNIT_TYPE_UNSPECIFIED", "", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "FONT_STYLE_NORMAL", "FONT_STYLE_ITALIC", "FONT_SYNTHESIS_NONE", "FONT_SYNTHESIS_ALL", "FONT_SYNTHESIS_WEIGHT", "FONT_SYNTHESIS_STYLE", "COLOR_ID", "FONT_SIZE_ID", "FONT_WEIGHT_ID", "FONT_STYLE_ID", "FONT_SYNTHESIS_ID", "FONT_FEATURE_SETTINGS_ID", "LETTER_SPACING_ID", "BASELINE_SHIFT_ID", "TEXT_GEOMETRIC_TRANSFORM_ID", "BACKGROUND_ID", "TEXT_DECORATION_ID", "SHADOW_ID", "BYTE_SIZE", "", "INT_SIZE", "FLOAT_SIZE", "LONG_SIZE", "COLOR_SIZE", "TEXT_UNIT_SIZE", "FONT_WEIGHT_SIZE", "FONT_STYLE_SIZE", "FONT_SYNTHESIS_SIZE", "BASELINE_SHIFT_SIZE", "TEXT_GEOMETRIC_TRANSFORM_SIZE", "TEXT_DECORATION_SIZE", "SHADOW_SIZE", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidClipboardManager_androidKt {
    private static final byte BACKGROUND_ID = 10;
    private static final byte BASELINE_SHIFT_ID = 8;
    private static final int BASELINE_SHIFT_SIZE = 4;
    private static final int BYTE_SIZE = 1;
    private static final byte COLOR_ID = 1;
    private static final int COLOR_SIZE = 8;
    private static final int FLOAT_SIZE = 4;
    private static final byte FONT_FEATURE_SETTINGS_ID = 6;
    private static final byte FONT_SIZE_ID = 2;
    private static final byte FONT_STYLE_ID = 4;
    private static final byte FONT_STYLE_ITALIC = 1;
    private static final byte FONT_STYLE_NORMAL = 0;
    private static final int FONT_STYLE_SIZE = 1;
    private static final byte FONT_SYNTHESIS_ALL = 1;
    private static final byte FONT_SYNTHESIS_ID = 5;
    private static final byte FONT_SYNTHESIS_NONE = 0;
    private static final int FONT_SYNTHESIS_SIZE = 1;
    private static final byte FONT_SYNTHESIS_STYLE = 3;
    private static final byte FONT_SYNTHESIS_WEIGHT = 2;
    private static final byte FONT_WEIGHT_ID = 3;
    private static final int FONT_WEIGHT_SIZE = 4;
    private static final int INT_SIZE = 4;
    private static final byte LETTER_SPACING_ID = 7;
    private static final int LONG_SIZE = 8;
    private static final String PLAIN_TEXT_LABEL = "plain text";
    private static final byte SHADOW_ID = 12;
    private static final int SHADOW_SIZE = 20;
    private static final byte TEXT_DECORATION_ID = 11;
    private static final int TEXT_DECORATION_SIZE = 4;
    private static final byte TEXT_GEOMETRIC_TRANSFORM_ID = 9;
    private static final int TEXT_GEOMETRIC_TRANSFORM_SIZE = 8;
    private static final int TEXT_UNIT_SIZE = 5;
    private static final byte UNIT_TYPE_EM = 2;
    private static final byte UNIT_TYPE_SP = 1;
    private static final byte UNIT_TYPE_UNSPECIFIED = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final AnnotatedString convertToAnnotatedString(CharSequence r110) {
        List r100 = null;
        Object[] r101 = 0;
        if (r110 != null) goto L6;
        return null;
    L6:
        if ((r110 instanceof Spanned) == false) goto L8;
        Spanned r102 = (Spanned) r110;
        int r103 = 0;
        Annotation[] r104 = (Annotation[]) r102.getSpans(0, r102.length(), Annotation.class);
        ArrayList r105 = new ArrayList();
        int r106 = ArraysKt.getLastIndex(r104);
        if (r106 < 0) goto L18;
    L11:
        Annotation r107 = r104[r103];
        if (Intrinsics.areEqual(r107.getKey(), "androidx.compose.text.SpanStyle") == false) goto L15;
        int r108 = r102.getSpanStart(r107);
        int r109 = r102.getSpanEnd(r107);
        r105.add(new AnnotatedString.Range(new DecodeHelper(r107.getValue()).decodeSpanStyle(), r108, r109));
    L15:
        if (r103 == r106) goto L18;
        r103 = r103 + 1;
    L18:
        return new AnnotatedString(r110.toString(), r105, null, 4, null);
    L8:
        return new AnnotatedString(r110.toString(), r100, 2, r101 == true ? 1 : 0);
    }

    public static final CharSequence convertToCharSequence(AnnotatedString r100) {
        if (r100.getSpanStyles().isEmpty() == true) goto L5;
        SpannableString r101 = new SpannableString(r100.getText());
        EncodeHelper r102 = new EncodeHelper();
        List<AnnotatedString.Range<SpanStyle>> r103 = r100.getSpanStyles();
        int r104 = r103.size();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        AnnotatedString.Range r106 = (AnnotatedString.Range) ListProtector.get(r103, r105);
        SpanStyle r107 = (SpanStyle) r106.component1();
        int r108 = r106.component2();
        int r109 = r106.component3();
        r102.reset();
        r102.encode(r107);
        r101.setSpan(new Annotation("androidx.compose.text.SpanStyle", r102.encodedString()), r108, r109, 33);
        r105 = r105 + 1;
        goto L7
    L9:
        return r101;
    L5:
        return r100.getText();
    }

    public static final ClipEntry toClipEntry(ClipData r100) {
        return new ClipEntry(r100);
    }

    public static final ClipMetadata toClipMetadata(ClipDescription r100) {
        return new ClipMetadata(r100);
    }
}
