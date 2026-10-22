package org.tukaani.xz.lzma;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
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

    public State() {
    }

    public int get() {
        return this.state;
    }

    public boolean isLiteral() {
        return this.state < 7;
    }

    public void reset() {
        this.state = 0;
    }

    public void set(State state) {
        this.state = state.state;
    }

    public void updateLiteral() {
        int i8 = this.state;
        if (i8 <= 3) {
            this.state = 0;
        } else if (i8 <= 9) {
            this.state = i8 - 3;
        } else {
            this.state = i8 - 6;
        }
    }

    public void updateLongRep() {
        this.state = this.state < 7 ? 8 : 11;
    }

    public void updateMatch() {
        this.state = this.state >= 7 ? 10 : 7;
    }

    public void updateShortRep() {
        this.state = this.state < 7 ? 9 : 11;
    }

    public State(State state) {
        this.state = state.state;
    }
}
