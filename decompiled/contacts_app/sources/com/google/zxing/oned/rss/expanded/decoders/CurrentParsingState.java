package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes3.dex */
final class CurrentParsingState {
    private State encoding;
    private int position;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ALPHA = null;
        public static final State ISO_IEC_646 = null;
        public static final State NUMERIC = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("NUMERIC", 0);
            NUMERIC = r0;
            State r1 = new State("ALPHA", 1);
            ALPHA = r1;
            State r3 = new State("ISO_IEC_646", 2);
            ISO_IEC_646 = r3;
            $VALUES = new State[]{r0, r1, r3};
        }
    }

    CurrentParsingState() {
        this.position = 0;
        this.encoding = State.NUMERIC;
    }

    int getPosition() {
        return this.position;
    }

    void setPosition(int r1) {
        this.position = r1;
    }

    void incrementPosition(int r2) {
        this.position += r2;
    }

    boolean isAlpha() {
        if (this.encoding != State.ALPHA) goto L6;
        return true;
    L6:
        return false;
    }

    boolean isNumeric() {
        if (this.encoding != State.NUMERIC) goto L6;
        return true;
    L6:
        return false;
    }

    boolean isIsoIec646() {
        if (this.encoding != State.ISO_IEC_646) goto L6;
        return true;
    L6:
        return false;
    }

    void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    void setAlpha() {
        this.encoding = State.ALPHA;
    }

    void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
}
