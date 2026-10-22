package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public class Label {
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    public Label() {
    }

    private void addReference(int r100, int r101, int r102) {
        if (this.srcAndRefPositions != null) goto L5;
        this.srcAndRefPositions = new int[6];
    L5:
        int r103 = this.referenceCount;
        int[] r104 = this.srcAndRefPositions;
        if (r103 < r104.length) goto L8;
        int[] r105 = new int[r104.length + 6];
        System.arraycopy(r104, 0, r105, 0, r104.length);
        this.srcAndRefPositions = r105;
    L8:
        int[] r106 = this.srcAndRefPositions;
        int r107 = this.referenceCount;
        int r108 = r107 + 1;
        r106[r107] = r100;
        this.referenceCount = r108 + 1;
        r106[r108] = r101 | r102;
    }

    public void resolve(MethodWriter r100, int r101, byte[] r102) {
        this.status |= 2;
        this.position = r101;
        int r103 = 0;
    L4:
        if (r103 >= this.referenceCount) goto L10;
        int[] r104 = this.srcAndRefPositions;
        int r105 = r103 + 1;
        int r106 = r104[r103];
        int r107 = r105 + 1;
        int r108 = r104[r105];
        int r109 = FORWARD_REFERENCE_HANDLE_MASK & r108;
        int r110 = r101 - r106;
        if ((r108 & (-268435456)) != 268435456) goto L8;
        r102[r109] = (byte) (r110 >>> 8);
        r102[r109 + 1] = (byte) r110;
    L9:
        r103 = r107;
        goto L4
    L8:
        int r111 = r109 + 1;
        r102[r109] = (byte) (r110 >>> 24);
        int r112 = r111 + 1;
        r102[r111] = (byte) (r110 >>> 16);
        r102[r112] = (byte) (r110 >>> 8);
        r102[r112 + 1] = (byte) r110;
        goto L9
    }

    public void put(MethodWriter r100, ByteVector r101, int r102, boolean r103) {
        if ((this.status & 2) == 0) goto L5;
        if (r103 == false) goto L10;
        r101.putInt(this.position - r102);
        return;
    L10:
        r101.putShort(this.position - r102);
        return;
    L5:
        if (r103 == false) goto L7;
        addReference(r102, r101.length, 536870912);
        r101.putInt(-1);
        return;
    L7:
        addReference(r102, r101.length, 268435456);
        r101.putShort(-1);
    }
}
