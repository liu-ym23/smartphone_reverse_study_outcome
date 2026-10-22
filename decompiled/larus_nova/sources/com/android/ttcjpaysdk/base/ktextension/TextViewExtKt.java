package com.android.ttcjpaysdk.base.ktextension;

import android.text.TextPaint;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"measureTextWidth", "", "Landroid/widget/TextView;", "setTextSizeInDip", "", "size", "showColorText", "text", "", "color", "", "showText", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextViewExtKt {
    public static final float measureTextWidth(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        TextPaint r101 = r100.getPaint();
        CharSequence r102 = r100.getText();
        if (r102 == null) goto L6;
        String r103 = r102.toString();
        if (r103 == null) goto L6;
    L8:
        return r101.measureText(r103);
    L6:
        r103 = "";
        goto L8
    }

    public static final void setTextSizeInDip(TextView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTextSize(1, r101);
    }

    public static final void showText(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        if ((!StringsKt.isBlank(r101)) == false) goto L5;
        String r102 = r101;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r100.setText(r102);
        if ((!StringsKt.isBlank(r101)) == false) goto L12;
        int r103 = 0;
    L13:
        r100.setVisibility(r103);
        return;
    L12:
        r103 = 8;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public static final void showColorText(TextView r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        showText(r100, r101);
        r100.setTextColor(r102);
    }
}
