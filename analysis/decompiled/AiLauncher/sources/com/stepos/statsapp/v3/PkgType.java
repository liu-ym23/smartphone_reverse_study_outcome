package com.stepos.statsapp.v3;

/* loaded from: classes2.dex */
public enum PkgType {
    APP(0),
    GAME(1),
    TV(2),
    PAD(3);

    private int type;

    PkgType(int i10) {
        this.type = i10;
    }

    public static PkgType fromValue(int i10) {
        if (i10 == 0) {
            return APP;
        }
        if (i10 == 1) {
            return GAME;
        }
        if (i10 == 2) {
            return TV;
        }
        if (i10 == 3) {
            return PAD;
        }
        return null;
    }

    public int value() {
        return this.type;
    }
}
