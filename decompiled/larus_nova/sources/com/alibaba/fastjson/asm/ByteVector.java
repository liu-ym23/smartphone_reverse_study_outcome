package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public class ByteVector {
    public byte[] data;
    public int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    public ByteVector(int r100) {
        this.data = new byte[r100];
    }

    private void enlarge(int r100) {
        byte[] r101 = this.data;
        int r102 = r101.length * 2;
        int r103 = this.length;
        int r104 = r100 + r103;
        if (r102 > r104) goto L6;
        r102 = r104;
    L6:
        byte[] r105 = new byte[r102];
        System.arraycopy(r101, 0, r105, 0, r103);
        this.data = r105;
    }

    public ByteVector putByte(int r100) {
        int r101 = this.length;
        int r102 = r101 + 1;
        if (r102 <= this.data.length) goto L5;
        enlarge(1);
    L5:
        this.data[r101] = (byte) r100;
        this.length = r102;
        return this;
    }

    public ByteVector putInt(int r100) {
        int r101 = this.length;
        if ((r101 + 4) <= this.data.length) goto L5;
        enlarge(4);
    L5:
        byte[] r102 = this.data;
        int r103 = r101 + 1;
        r102[r101] = (byte) (r100 >>> 24);
        int r104 = r103 + 1;
        r102[r103] = (byte) (r100 >>> 16);
        int r105 = r104 + 1;
        r102[r104] = (byte) (r100 >>> 8);
        r102[r105] = (byte) r100;
        this.length = r105 + 1;
        return this;
    }

    public ByteVector putShort(int r100) {
        int r101 = this.length;
        if ((r101 + 2) <= this.data.length) goto L5;
        enlarge(2);
    L5:
        byte[] r102 = this.data;
        int r103 = r101 + 1;
        r102[r101] = (byte) (r100 >>> 8);
        r102[r103] = (byte) r100;
        this.length = r103 + 1;
        return this;
    }

    public ByteVector putUTF8(String r100) {
        int r101 = r100.length();
        int r102 = this.length;
        if (((r102 + 2) + r101) <= this.data.length) goto L5;
        enlarge(r101 + 2);
    L5:
        byte[] r103 = this.data;
        int r104 = r102 + 1;
        r103[r102] = (byte) (r101 >>> 8);
        int r105 = r104 + 1;
        r103[r104] = (byte) r101;
        int r106 = 0;
    L6:
        if (r106 >= r101) goto L18;
        char r107 = r100.charAt(r106);
        if (r107 < 1) goto L12;
        if (r107 > 127) goto L12;
    L15:
        r103[r105] = (byte) r107;
        r106 = r106 + 1;
        r105 = r105 + 1;
    L12:
        if (r107 < 19968) goto L17;
        if (r107 <= 40959) goto L15;
    L17:
        throw new UnsupportedOperationException();
    L18:
        this.length = r105;
        return this;
    }

    public ByteVector put11(int r100, int r101) {
        int r102 = this.length;
        if ((r102 + 2) <= this.data.length) goto L5;
        enlarge(2);
    L5:
        byte[] r103 = this.data;
        int r104 = r102 + 1;
        r103[r102] = (byte) r100;
        r103[r104] = (byte) r101;
        this.length = r104 + 1;
        return this;
    }

    public ByteVector put12(int r100, int r101) {
        int r102 = this.length;
        if ((r102 + 3) <= this.data.length) goto L5;
        enlarge(3);
    L5:
        byte[] r103 = this.data;
        int r104 = r102 + 1;
        r103[r102] = (byte) r100;
        int r105 = r104 + 1;
        r103[r104] = (byte) (r101 >>> 8);
        r103[r105] = (byte) r101;
        this.length = r105 + 1;
        return this;
    }

    public ByteVector putByteArray(byte[] r100, int r101, int r102) {
        if ((this.length + r102) <= this.data.length) goto L5;
        enlarge(r102);
    L5:
        if (r100 == null) goto L7;
        System.arraycopy(r100, r101, this.data, this.length, r102);
    L7:
        this.length += r102;
        return this;
    }
}
