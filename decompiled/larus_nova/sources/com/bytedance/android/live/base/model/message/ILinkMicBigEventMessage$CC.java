package com.bytedance.android.live.base.model.message;

import kotlin.Pair;

/* JADX INFO: renamed from: com.bytedance.android.live.base.model.message.ILinkMicBigEventMessage$-CC, reason: invalid class name */
/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class ILinkMicBigEventMessage$CC {
    public static int targetModeTransScene(int r100) {
        switch(r100) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L4;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L4;
            case 14: goto L7;
            case 15: goto L13;
            case 16: goto L6;
            case 17: goto L23;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 8;
    L7:
        return 11;
    L9:
        return 7;
    L11:
        return 6;
    L13:
        return 5;
    L15:
        return 4;
    L17:
        return 3;
    L19:
        return 2;
    L21:
        return 1;
    L23:
        return 9;
    L25:
        return 12;
    L27:
        return 8;
    }

    public static Pair<Integer, Integer> targetModeTransParam(int r100) {
        int r101 = targetModeTransScene(r100);
        if (r100 == 3) goto L9;
        switch(r100) {
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L6;
            default: goto L5;
        };
    L5:
        int r102 = 0;
    L11:
        return new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    L6:
        r102 = 63;
        goto L11
    L7:
        r102 = 61;
        goto L11
    L8:
        r102 = 7;
        goto L11
    L9:
        r102 = 2;
        goto L11
    }
}
