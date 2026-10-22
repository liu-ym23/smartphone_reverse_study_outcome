package org.tukaani.xz.lzma;

/* JADX INFO: loaded from: classes3.dex */
final class State {
    private static final int LIT_LIT = 0;
    private static final int LIT_LONGREP = 8;
    private static final int LIT_MATCH = 7;
    private static final int LIT_SHORTREP = 9;
    private static final int LIT_STATES = 7;
    private static final int MATCH_LIT = 4;
    private static final int MATCH_LIT_LIT = 1;
    private static final int NONLIT_MATCH = 10;
    private static final int NONLIT_REP = 11;
    private static final int REP_LIT = 5;
    private static final int REP_LIT_LIT = 2;
    private static final int SHORTREP_LIT = 6;
    private static final int SHORTREP_LIT_LIT = 3;
    static final int STATES = 12;
    private int state;

    State() {
    }

    State(State other) {
        this.state = other.state;
    }

    void reset() {
        this.state = 0;
    }

    int get() {
        return this.state;
    }

    void set(State other) {
        this.state = other.state;
    }

    void updateLiteral() {
        if (this.state > 3) goto L6;
        this.state = 0;
        return;
    L6:
        if (this.state > 9) goto L8;
        this.state -= 3;
        return;
    L8:
        this.state -= 6;
    }

    void updateMatch() {
        int r1 = 7;
        if (this.state < 7) goto L6;
        r1 = 10;
    L6:
        this.state = r1;
    }

    void updateLongRep() {
        if (this.state >= 7) goto L5;
        int r0 = 8;
    L6:
        this.state = r0;
        return;
    L5:
        r0 = 11;
        goto L6
    }

    void updateShortRep() {
        if (this.state >= 7) goto L5;
        int r0 = 9;
    L6:
        this.state = r0;
        return;
    L5:
        r0 = 11;
        goto L6
    }

    boolean isLiteral() {
        if (this.state >= 7) goto L5;
        return true;
    L5:
        return false;
    }
}
