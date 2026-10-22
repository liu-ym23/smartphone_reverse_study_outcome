package androidx.compose.ui.text.font;

import android.os.Build;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FontSynthesis_androidKt {
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m7133synthesizeTypefaceFxwP2eA(int r100, Object r101, Font r102, FontWeight r103, int r104) {
        if ((r101 instanceof android.graphics.Typeface) == true) goto L5;
        return r101;
    L5:
        boolean r105 = true;
        if (FontSynthesis.m7126isWeightOnimpl$ui_text(r100) == true) goto L8;
    L14:
        boolean r106 = false;
    L16:
        if (FontSynthesis.m7125isStyleOnimpl$ui_text(r100) == true) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L25;
        if (r106 == true) goto L25;
        return r101;
    L25:
        if (Build.VERSION.SDK_INT >= 28) goto L32;
        if (r107 == true) goto L28;
    L30:
        r105 = false;
    L31:
        android.graphics.Typeface r108 = (android.graphics.Typeface) r101;
        return android.graphics.Typeface.create(r108, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(r106, r105));
    L28:
        if (FontStyle.m7112equalsimpl0(r104, FontStyle.Companion.m7118getItalic_LCdwA()) == false) goto L30;
    L32:
        if (r106 == false) goto L34;
        int r109 = r103.getWeight();
    L35:
        if (r107 == false) goto L37;
        boolean r110 = FontStyle.m7112equalsimpl0(r104, FontStyle.Companion.m7118getItalic_LCdwA());
    L39:
        return TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) r101, r109, r110);
    L37:
        r110 = FontStyle.m7112equalsimpl0(r102.mo7064getStyle_LCdwA(), FontStyle.Companion.m7118getItalic_LCdwA());
        goto L39
    L34:
        r109 = r102.getWeight().getWeight();
        goto L35
    L18:
        if (FontStyle.m7112equalsimpl0(r104, r102.mo7064getStyle_LCdwA()) == true) goto L20;
        r107 = true;
        goto L21
    L8:
        if (Intrinsics.areEqual(r102.getWeight(), r103) == true) goto L14;
        FontWeight.Companion r111 = FontWeight.Companion;
        if (r103.compareTo2(AndroidFontUtils_androidKt.getAndroidBold(r111)) < 0) goto L14;
        if (r102.getWeight().compareTo2(AndroidFontUtils_androidKt.getAndroidBold(r111)) >= 0) goto L14;
        r106 = true;
        goto L16
    }
}
