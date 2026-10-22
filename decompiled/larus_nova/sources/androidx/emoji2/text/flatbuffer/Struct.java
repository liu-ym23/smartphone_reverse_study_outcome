package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public class Struct {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f15450bb;
    protected int bb_pos;

    public Struct() {
    }

    public void __reset() {
        __reset(0, null);
    }

    public void __reset(int r100, ByteBuffer r101) {
        this.f15450bb = r101;
        if (r101 == null) goto L5;
        this.bb_pos = r100;
        return;
    L5:
        this.bb_pos = 0;
    }
}
