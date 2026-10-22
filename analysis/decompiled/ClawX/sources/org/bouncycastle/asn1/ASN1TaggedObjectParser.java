package org.bouncycastle.asn1;

/* loaded from: classes.dex */
public interface ASN1TaggedObjectParser extends ASN1Encodable, InMemoryRepresentable {
    int getTagClass();

    int getTagNo();

    boolean hasContextTag();

    boolean hasContextTag(int i8);

    boolean hasTag(int i8, int i9);

    boolean hasTagClass(int i8);

    ASN1Encodable parseBaseUniversal(boolean z, int i8);

    ASN1Encodable parseExplicitBaseObject();

    ASN1TaggedObjectParser parseExplicitBaseTagged();

    ASN1TaggedObjectParser parseImplicitBaseTagged(int i8, int i9);
}
