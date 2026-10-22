package com.obric.oui.stepper;

import android.text.InputFilter;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class InputFilterMinMax implements InputFilter {
    private a filterListener;
    private int max;
    private int min;

    interface a {
        void onBeyondLimit(int r1);
    }

    private boolean isInRange(int r2, int r3, int r4) {
        if (r3 <= r2) goto L7;
        if (r4 < r2) goto L11;
        if (r4 > r3) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r4 < r3) goto L11;
        if (r4 > r2) goto L11;
        return true;
    }

    public InputFilterMinMax(int r3, int r4, a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        this.min = r3;
        this.max = r4;
        this.filterListener = r6;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.aiagent.plugin");
        int r8 = Integer.parseInt(((Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.aiagent.plugin")).toString() + r7.toString());     // Catch: NumberFormatException -> L12
        if (isInRange(this.min, this.max, r8) == false) goto L7;
        return null;
    L7:
        a r0 = this.filterListener;     // Catch: NumberFormatException -> L12
        if (r0 == null) goto L15;
        r0.onBeyondLimit(r8);     // Catch: NumberFormatException -> L12
        return "";
    L15:
        return "";
    L16:
        return "";
    }
}
