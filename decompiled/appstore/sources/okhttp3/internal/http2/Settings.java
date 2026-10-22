package okhttp3.internal.http2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values;

    public Settings() {
        this.values = new int[10];
    }

    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int get(int r10) {
        return this.values[r10];
    }

    public boolean getEnablePush(boolean r10) {
        if ((this.set & 4) == 0) goto L5;
        int r11 = this.values[2];
    L8:
        if (r11 == 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r10 == false) goto L7;
        r11 = 1;
        goto L8
    L7:
        r11 = 0;
        goto L8
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) goto L7;
        return -1;
    L7:
        return this.values[1];
    }

    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) goto L7;
        return 65535;
    L7:
        return this.values[7];
    }

    public int getMaxConcurrentStreams(int r10) {
        if ((this.set & 16) != 0) goto L5;
        return r10;
    L5:
        return this.values[4];
    }

    public int getMaxFrameSize(int r10) {
        if ((this.set & 32) != 0) goto L5;
        return r10;
    L5:
        return this.values[5];
    }

    public int getMaxHeaderListSize(int r10) {
        if ((this.set & 64) != 0) goto L5;
        return r10;
    L5:
        return this.values[6];
    }

    public boolean isSet(int r10) {
        int r11 = this.set;
        if ((r11 & (1 << r10)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void merge(Settings r10) {
        int r11 = 0;
    L4:
        if (r11 >= 10) goto L10;
        if (r10.isSet(r11) == false) goto L9;
        set(r11, r10.get(r11));
    L9:
        r11 = r11 + 1;
        goto L4
    }

    public Settings set(int r10, int r11) {
        if (r10 < 0) goto L7;
        int[] r12 = this.values;
        if (r10 >= r12.length) goto L7;
        this.set = (1 << r10) | this.set;
        r12[r10] = r11;
    L7:
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
