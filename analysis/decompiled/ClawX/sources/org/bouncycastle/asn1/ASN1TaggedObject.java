package org.bouncycastle.asn1;

import a8.b;
import java.io.IOException;
import m0.f;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    private static final int DECLARED_EXPLICIT = 1;
    private static final int DECLARED_IMPLICIT = 2;
    private static final int PARSED_EXPLICIT = 3;
    private static final int PARSED_IMPLICIT = 4;
    final int explicitness;
    final ASN1Encodable obj;
    final int tagClass;
    final int tagNo;

    public ASN1TaggedObject(int i8, int i9, int i10, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'obj' cannot be null");
        }
        if (i9 == 0 || (i9 & BERTags.PRIVATE) != i9) {
            throw new IllegalArgumentException(b.j(i9, "invalid tag class: "));
        }
        this.explicitness = aSN1Encodable instanceof ASN1Choice ? 1 : i8;
        this.tagClass = i9;
        this.tagNo = i10;
        this.obj = aSN1Encodable;
    }

    private static ASN1TaggedObject checkInstance(Object obj) {
        if (obj != null) {
            return getInstance(obj);
        }
        throw new NullPointerException("'obj' cannot be null");
    }

    private static ASN1TaggedObject checkedCast(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: ".concat(aSN1Primitive.getClass().getName()));
    }

    public static ASN1Primitive createConstructedDL(int i8, int i9, ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() == 1 ? new DLTaggedObject(3, i8, i9, aSN1EncodableVector.get(0)) : new DLTaggedObject(4, i8, i9, DLFactory.createSequence(aSN1EncodableVector));
    }

    public static ASN1Primitive createConstructedIL(int i8, int i9, ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() == 1 ? new BERTaggedObject(3, i8, i9, aSN1EncodableVector.get(0)) : new BERTaggedObject(4, i8, i9, BERFactory.createSequence(aSN1EncodableVector));
    }

    public static ASN1Primitive createPrimitive(int i8, int i9, byte[] bArr) {
        return new DLTaggedObject(4, i8, i9, new DEROctetString(bArr));
    }

    public static ASN1TaggedObject getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                return (ASN1TaggedObject) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return checkedCast(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e9) {
                throw new IllegalArgumentException(f.a(e9, new StringBuilder("failed to construct tagged object from byte[]: ")));
            }
        }
        throw new IllegalArgumentException(f.b(obj, "unknown object in getInstance: "));
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) aSN1Encodable;
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.tagNo != aSN1TaggedObject.tagNo || this.tagClass != aSN1TaggedObject.tagClass) {
            return false;
        }
        if (this.explicitness != aSN1TaggedObject.explicitness && isExplicit() != aSN1TaggedObject.isExplicit()) {
            return false;
        }
        ASN1Primitive aSN1Primitive2 = this.obj.toASN1Primitive();
        ASN1Primitive aSN1Primitive3 = aSN1TaggedObject.obj.toASN1Primitive();
        if (aSN1Primitive2 == aSN1Primitive3) {
            return true;
        }
        if (isExplicit()) {
            return aSN1Primitive2.asn1Equals(aSN1Primitive3);
        }
        try {
            return Arrays.areEqual(getEncoded(), aSN1TaggedObject.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    public ASN1Object getBaseObject() {
        ASN1Encodable aSN1Encodable = this.obj;
        return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    public ASN1Primitive getBaseUniversal(boolean z, int i8) {
        ASN1UniversalType aSN1UniversalType = ASN1UniversalTypes.get(i8);
        if (aSN1UniversalType != null) {
            return getBaseUniversal(z, aSN1UniversalType);
        }
        throw new IllegalArgumentException(b.j(i8, "unsupported UNIVERSAL tag number: "));
    }

    public ASN1Object getExplicitBaseObject() {
        if (!isExplicit()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        ASN1Encodable aSN1Encodable = this.obj;
        return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    public ASN1TaggedObject getExplicitBaseTagged() {
        if (isExplicit()) {
            return checkedCast(this.obj.toASN1Primitive());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getImplicitBaseTagged(int i8, int i9) {
        if (i8 == 0 || (i8 & BERTags.PRIVATE) != i8) {
            throw new IllegalArgumentException(b.j(i8, "invalid base tag class: "));
        }
        int i10 = this.explicitness;
        if (i10 != 1) {
            return i10 != 2 ? replaceTag(i8, i9) : ASN1Util.checkTag(checkedCast(this.obj.toASN1Primitive()), i8, i9);
        }
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public int getTagClass() {
        return this.tagClass;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public boolean hasContextTag() {
        return this.tagClass == 128;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public boolean hasTag(int i8, int i9) {
        return this.tagClass == i8 && this.tagNo == i9;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public boolean hasTagClass(int i8) {
        return this.tagClass == i8;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.obj.toASN1Primitive().hashCode() ^ (((this.tagClass * 7919) ^ this.tagNo) ^ (isExplicit() ? 15 : 240));
    }

    public boolean isExplicit() {
        int i8 = this.explicitness;
        return i8 == 1 || i8 == 3;
    }

    public boolean isParsed() {
        int i8 = this.explicitness;
        return i8 == 3 || i8 == 4;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseBaseUniversal(boolean z, int i8) {
        ASN1Primitive baseUniversal = getBaseUniversal(z, i8);
        return i8 != 3 ? i8 != 4 ? i8 != 16 ? i8 != 17 ? baseUniversal : ((ASN1Set) baseUniversal).parser() : ((ASN1Sequence) baseUniversal).parser() : ((ASN1OctetString) baseUniversal).parser() : ((ASN1BitString) baseUniversal).parser();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseExplicitBaseObject() {
        return getExplicitBaseObject();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseExplicitBaseTagged() {
        return getExplicitBaseTagged();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i8, int i9) {
        return getImplicitBaseTagged(i8, i9);
    }

    public abstract ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive);

    public abstract ASN1TaggedObject replaceTag(int i8, int i9);

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    public String toString() {
        return ASN1Util.getTagText(this.tagClass, this.tagNo) + this.obj;
    }

    private static ASN1TaggedObject checkInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (!z) {
            throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
        }
        if (aSN1TaggedObject != null) {
            return aSN1TaggedObject;
        }
        throw new NullPointerException("'taggedObject' cannot be null");
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable, int i8) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.hasTagClass(i8)) {
            return null;
        }
        return optional;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public boolean hasContextTag(int i8) {
        return this.tagClass == 128 && this.tagNo == i8;
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable aSN1Encodable, int i8, int i9) {
        ASN1TaggedObject optional = getOptional(aSN1Encodable);
        if (optional == null || !optional.hasTag(i8, i9)) {
            return null;
        }
        return optional;
    }

    public ASN1TaggedObject(boolean z, int i8, int i9, ASN1Encodable aSN1Encodable) {
        this(z ? 1 : 2, i8, i9, aSN1Encodable);
    }

    public ASN1Primitive getBaseUniversal(boolean z, ASN1UniversalType aSN1UniversalType) {
        if (z) {
            if (isExplicit()) {
                return aSN1UniversalType.checkedCast(this.obj.toASN1Primitive());
            }
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        if (1 == this.explicitness) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
        int i8 = this.explicitness;
        return i8 != 3 ? i8 != 4 ? aSN1UniversalType.checkedCast(aSN1Primitive) : aSN1Primitive instanceof ASN1Sequence ? aSN1UniversalType.fromImplicitConstructed((ASN1Sequence) aSN1Primitive) : aSN1UniversalType.fromImplicitPrimitive((DEROctetString) aSN1Primitive) : aSN1UniversalType.fromImplicitConstructed(rebuildConstructed(aSN1Primitive));
    }

    public ASN1TaggedObject(boolean z, int i8, ASN1Encodable aSN1Encodable) {
        this(z, 128, i8, aSN1Encodable);
    }

    public static ASN1TaggedObject getInstance(Object obj, int i8) {
        return ASN1Util.checkTagClass(checkInstance(obj), i8);
    }

    public static ASN1TaggedObject getInstance(Object obj, int i8, int i9) {
        return ASN1Util.checkTag(checkInstance(obj), i8, i9);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, boolean z) {
        return ASN1Util.getExplicitBaseTagged(checkInstance(aSN1TaggedObject, z), i8, i9);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, int i8, boolean z) {
        return ASN1Util.getExplicitBaseTagged(checkInstance(aSN1TaggedObject, z), i8);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return ASN1Util.getExplicitContextBaseTagged(checkInstance(aSN1TaggedObject, z));
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public final ASN1Primitive getLoadedObject() {
        return this;
    }
}
