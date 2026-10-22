package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes17.dex */
public class BaseVector {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f15443bb;
    private int element_size;
    private int length;
    private int vector;

    public BaseVector() {
    }

    public void reset() {
        __reset(0, 0, null);
    }

    public int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public int __element(int r100) {
        return this.vector + (r100 * this.element_size);
    }

    public void __reset(int r100, int r101, ByteBuffer r102) {
        this.f15443bb = r102;
        if (r102 == null) goto L5;
        this.vector = r100;
        this.length = r102.getInt(r100 - 4);
        this.element_size = r101;
        return;
    L5:
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }
}
