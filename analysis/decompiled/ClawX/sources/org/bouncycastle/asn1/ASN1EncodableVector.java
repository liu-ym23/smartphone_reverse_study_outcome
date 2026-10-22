package org.bouncycastle.asn1;

/* loaded from: classes.dex */
public class ASN1EncodableVector {
    private static final int DEFAULT_CAPACITY = 10;
    static final ASN1Encodable[] EMPTY_ELEMENTS = new ASN1Encodable[0];
    private boolean copyOnWrite;
    private int elementCount;
    private ASN1Encodable[] elements;

    public ASN1EncodableVector() {
        this(10);
    }

    public static ASN1Encodable[] cloneElements(ASN1Encodable[] aSN1EncodableArr) {
        return aSN1EncodableArr.length < 1 ? EMPTY_ELEMENTS : (ASN1Encodable[]) aSN1EncodableArr.clone();
    }

    private void doAddAll(ASN1Encodable[] aSN1EncodableArr, String str) {
        int length = aSN1EncodableArr.length;
        if (length < 1) {
            return;
        }
        int length2 = this.elements.length;
        int i8 = this.elementCount + length;
        int i9 = 0;
        if ((i8 > length2) | this.copyOnWrite) {
            reallocate(i8);
        }
        do {
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i9];
            if (aSN1Encodable == null) {
                throw new NullPointerException(str);
            }
            this.elements[this.elementCount + i9] = aSN1Encodable;
            i9++;
        } while (i9 < length);
        this.elementCount = i8;
    }

    private void reallocate(int i8) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[Math.max(this.elements.length, i8 + (i8 >> 1))];
        System.arraycopy(this.elements, 0, aSN1EncodableArr, 0, this.elementCount);
        this.elements = aSN1EncodableArr;
        this.copyOnWrite = false;
    }

    public void add(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        int length = this.elements.length;
        int i8 = this.elementCount + 1;
        if (this.copyOnWrite | (i8 > length)) {
            reallocate(i8);
        }
        this.elements[this.elementCount] = aSN1Encodable;
        this.elementCount = i8;
    }

    public void addAll(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector == null) {
            throw new NullPointerException("'other' cannot be null");
        }
        doAddAll(aSN1EncodableVector.elements, "'other' elements cannot be null");
    }

    public void addOptional(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            add(aSN1Encodable);
        }
    }

    public ASN1Encodable[] copyElements() {
        int i8 = this.elementCount;
        if (i8 == 0) {
            return EMPTY_ELEMENTS;
        }
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[i8];
        System.arraycopy(this.elements, 0, aSN1EncodableArr, 0, i8);
        return aSN1EncodableArr;
    }

    public ASN1Encodable get(int i8) {
        if (i8 < this.elementCount) {
            return this.elements[i8];
        }
        throw new ArrayIndexOutOfBoundsException(i8 + " >= " + this.elementCount);
    }

    public int size() {
        return this.elementCount;
    }

    public ASN1Encodable[] takeElements() {
        int i8 = this.elementCount;
        if (i8 == 0) {
            return EMPTY_ELEMENTS;
        }
        ASN1Encodable[] aSN1EncodableArr = this.elements;
        if (aSN1EncodableArr.length == i8) {
            this.copyOnWrite = true;
            return aSN1EncodableArr;
        }
        ASN1Encodable[] aSN1EncodableArr2 = new ASN1Encodable[i8];
        System.arraycopy(aSN1EncodableArr, 0, aSN1EncodableArr2, 0, i8);
        return aSN1EncodableArr2;
    }

    public ASN1EncodableVector(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.elements = i8 == 0 ? EMPTY_ELEMENTS : new ASN1Encodable[i8];
        this.elementCount = 0;
        this.copyOnWrite = false;
    }

    public void addAll(ASN1Encodable[] aSN1EncodableArr) {
        if (aSN1EncodableArr == null) {
            throw new NullPointerException("'others' cannot be null");
        }
        doAddAll(aSN1EncodableArr, "'others' elements cannot be null");
    }
}
