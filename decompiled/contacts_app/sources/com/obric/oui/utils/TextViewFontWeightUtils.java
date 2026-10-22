package com.obric.oui.utils;

import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextViewFontWeightUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/utils/TextViewFontWeightUtils;", "", "()V", "BOLD_FONT_WEIGHT_THRESHOLD", "", "applyTextFontWeight", "", "textView", "Landroid/widget/TextView;", "weight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextViewFontWeightUtils {
    public static final int BOLD_FONT_WEIGHT_THRESHOLD = 600;
    public static final TextViewFontWeightUtils INSTANCE = null;

    static {
        INSTANCE = new TextViewFontWeightUtils();
    }

    private TextViewFontWeightUtils() {
    }

    @JvmStatic
    public static final void applyTextFontWeight(TextView r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        Typeface r0 = r4.getTypeface();
        if (r0 != null) goto L5;
        r0 = Typeface.DEFAULT;
    L5:
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        r4.setTypeface(Typeface.create(r0, r5, r1));
        return;
    L9:
        if (r0.isItalic() != true) goto L11;
        r1 = true;
        goto L11
    }
}
