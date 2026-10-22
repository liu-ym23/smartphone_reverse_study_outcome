package com.alibaba.fastjson.asm;

/* loaded from: classes.dex */
public class Label {
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    private void addReference(int i4, int i5) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i6 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i6 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i7 = this.referenceCount;
        iArr3[i7] = i4;
        this.referenceCount = i7 + 2;
        iArr3[i7 + 1] = i5;
    }

    public void put(MethodWriter methodWriter, ByteVector byteVector, int i4) {
        if ((this.status & 2) != 0) {
            byteVector.putShort(this.position - i4);
        } else {
            addReference(i4, byteVector.length);
            byteVector.putShort(-1);
        }
    }

    public void resolve(MethodWriter methodWriter, int i4, byte[] bArr) {
        this.status |= 2;
        this.position = i4;
        int i5 = 0;
        while (i5 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i6 = i5 + 1;
            int i7 = iArr[i5];
            i5 += 2;
            int i8 = iArr[i6];
            int i9 = i4 - i7;
            bArr[i8] = (byte) (i9 >>> 8);
            bArr[i8 + 1] = (byte) i9;
        }
    }
}
