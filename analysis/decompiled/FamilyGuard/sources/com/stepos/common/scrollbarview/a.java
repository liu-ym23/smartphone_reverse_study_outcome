package com.stepos.common.scrollbarview;

import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes.dex */
public class a extends StepOSScrollBarView.a {
    public int a() {
        return 1;
    }

    public int b(int i5, int i6, int i7, int i8, int i9) {
        return Math.round((i5 * (i9 - i8)) / (i6 - i7));
    }

    public int c(int i5, int i6, int i7, int i8, int i9) {
        int i10 = i6 * 2;
        float f5 = i5;
        int iRound = Math.round((i7 * f5) / i8);
        if (i9 != 0) {
            iRound = (int) (iRound * (1.0f - (i9 / (f5 * 0.3f))));
        }
        return Math.max(iRound, i10);
    }

    public int d(int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i5 - i6;
        int iRound = Math.round((i11 * i9) / (i8 - i7));
        return iRound > i11 ? i11 : iRound;
    }
}
