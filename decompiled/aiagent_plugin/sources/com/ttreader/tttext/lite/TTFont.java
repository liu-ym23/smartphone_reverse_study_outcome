package com.ttreader.tttext.lite;

import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class TTFont {
    public Typeface face;
    public TTTextDefinition.FontStyle font_style;
    public TTTextDefinition.FontWeight font_weight;

    public TTFont() {
        this.face = null;
        this.font_weight = TTTextDefinition.FontWeight.kNormal_400;
        this.font_style = TTTextDefinition.FontStyle.kNormal;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        TTFont r6 = (TTFont) ZeusTransformUtils.preCheckCast(r5, TTFont.class, "com.obric.aiagent.plugin");
        if (this.font_weight != r6.font_weight) goto L18;
        if (this.font_style != r6.font_style) goto L18;
        if (Objects.equals(this.face, r6.face) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.face, this.font_weight, this.font_style});
    }
}
