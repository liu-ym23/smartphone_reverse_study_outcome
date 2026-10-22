package org.bouncycastle.asn1;

/* loaded from: classes.dex */
final class ASN1Tag {
    private final int tagClass;
    private final int tagNumber;

    private ASN1Tag(int i8, int i9) {
        this.tagClass = i8;
        this.tagNumber = i9;
    }

    public static ASN1Tag create(int i8, int i9) {
        return new ASN1Tag(i8, i9);
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNumber() {
        return this.tagNumber;
    }
}
