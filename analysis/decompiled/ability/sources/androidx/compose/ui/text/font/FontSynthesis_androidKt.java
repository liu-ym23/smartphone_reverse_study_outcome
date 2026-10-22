package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m6443synthesizeTypefaceFxwP2eA(int r4, java.lang.Object r5, androidx.compose.ui.text.font.Font r6, androidx.compose.ui.text.font.FontWeight r7, int r8) {
        /*
            boolean r0 = r5 instanceof android.graphics.Typeface
            if (r0 != 0) goto L5
            return r5
        L5:
            boolean r0 = androidx.compose.ui.text.font.FontSynthesis.m6436isWeightOnimpl$ui_text(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L33
            androidx.compose.ui.text.font.FontWeight r0 = r6.getWeight()
            boolean r0 = kotlin.jvm.internal.k.b(r0, r7)
            if (r0 != 0) goto L33
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.INSTANCE
            androidx.compose.ui.text.font.FontWeight r3 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r3 = r7.compareTo(r3)
            if (r3 < 0) goto L33
            androidx.compose.ui.text.font.FontWeight r3 = r6.getWeight()
            androidx.compose.ui.text.font.FontWeight r0 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r0 = r3.compareTo(r0)
            if (r0 >= 0) goto L33
            r0 = r2
            goto L34
        L33:
            r0 = r1
        L34:
            boolean r4 = androidx.compose.ui.text.font.FontSynthesis.m6435isStyleOnimpl$ui_text(r4)
            if (r4 == 0) goto L45
            int r4 = r6.getStyle()
            boolean r4 = androidx.compose.ui.text.font.FontStyle.m6422equalsimpl0(r8, r4)
            if (r4 != 0) goto L45
            r1 = r2
        L45:
            if (r1 != 0) goto L4a
            if (r0 != 0) goto L4a
            return r5
        L4a:
            if (r0 == 0) goto L51
            int r4 = r7.getWeight()
            goto L59
        L51:
            androidx.compose.ui.text.font.FontWeight r4 = r6.getWeight()
            int r4 = r4.getWeight()
        L59:
            if (r1 == 0) goto L66
            androidx.compose.ui.text.font.FontStyle$Companion r6 = androidx.compose.ui.text.font.FontStyle.INSTANCE
            int r6 = r6.m6428getItalic_LCdwA()
            boolean r6 = androidx.compose.ui.text.font.FontStyle.m6422equalsimpl0(r8, r6)
            goto L74
        L66:
            int r6 = r6.getStyle()
            androidx.compose.ui.text.font.FontStyle$Companion r7 = androidx.compose.ui.text.font.FontStyle.INSTANCE
            int r7 = r7.m6428getItalic_LCdwA()
            boolean r6 = androidx.compose.ui.text.font.FontStyle.m6422equalsimpl0(r6, r7)
        L74:
            androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 r7 = androidx.compose.ui.text.font.TypefaceHelperMethodsApi28.INSTANCE
            android.graphics.Typeface r5 = (android.graphics.Typeface) r5
            android.graphics.Typeface r4 = r7.create(r5, r4, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontSynthesis_androidKt.m6443synthesizeTypefaceFxwP2eA(int, java.lang.Object, androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.FontWeight, int):java.lang.Object");
    }
}
