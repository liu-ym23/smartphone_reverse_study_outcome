package com.stepos.common.scrollbarview;

import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes3.dex */
public class a extends StepOSScrollBarView.a {
    private static final int MIN_LENGTH_FACTOR = 2;

    public int a() {
        return 1;
    }

    public int b(int i10, int i11, int i12, int i13, int i14) {
        return Math.round((i10 * (i14 - i13)) / (i11 - i12));
    }

    public int c(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i11 * 2;
        float f10 = i10;
        int iRound = Math.round((i12 * f10) / i13);
        if (i14 != 0) {
            iRound = (int) (iRound * (1.0f - (i14 / (f10 * 0.3f))));
        }
        return Math.max(iRound, i15);
    }

    public int d(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i10 - i11;
        int iRound = Math.round((i16 * i14) / (i13 - i12));
        return iRound > i16 ? i16 : iRound;
    }
}
