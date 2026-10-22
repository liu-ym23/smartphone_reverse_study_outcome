package org.bouncycastle.asn1;

import a8.b;
import m0.f;

/* loaded from: classes.dex */
public abstract class ASN1Util {
    public static ASN1TaggedObject checkContextTag(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return checkTag(aSN1TaggedObject, 128, i8);
    }

    public static ASN1TaggedObject checkContextTagClass(ASN1TaggedObject aSN1TaggedObject) {
        return checkTagClass(aSN1TaggedObject, 128);
    }

    public static ASN1TaggedObject checkTag(ASN1TaggedObject aSN1TaggedObject, int i8, int i9) {
        if (aSN1TaggedObject.hasTag(i8, i9)) {
            return aSN1TaggedObject;
        }
        throw new IllegalStateException(b.p("Expected ", getTagText(i8, i9), " tag but found ", getTagText(aSN1TaggedObject)));
    }

    public static ASN1TaggedObject checkTagClass(ASN1TaggedObject aSN1TaggedObject, int i8) {
        if (aSN1TaggedObject.hasTagClass(i8)) {
            return aSN1TaggedObject;
        }
        throw new IllegalStateException(b.p("Expected ", getTagClassText(i8), " tag but found ", getTagClassText(aSN1TaggedObject)));
    }

    public static ASN1Primitive getBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, boolean z, int i10) {
        return checkTag(aSN1TaggedObject, i8, i9).getBaseUniversal(z, i10);
    }

    public static ASN1Primitive getContextBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i8, boolean z, int i9) {
        return getBaseUniversal(aSN1TaggedObject, 128, i8, z, i9);
    }

    public static ASN1Object getExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return checkTagClass(aSN1TaggedObject, i8).getExplicitBaseObject();
    }

    public static ASN1TaggedObject getExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return checkTagClass(aSN1TaggedObject, i8).getExplicitBaseTagged();
    }

    public static ASN1Object getExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject) {
        return getExplicitBaseObject(aSN1TaggedObject, 128);
    }

    public static ASN1TaggedObject getExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject) {
        return getExplicitBaseTagged(aSN1TaggedObject, 128);
    }

    public static ASN1TaggedObject getImplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, int i10, int i11) {
        return checkTag(aSN1TaggedObject, i8, i9).getImplicitBaseTagged(i10, i11);
    }

    public static ASN1TaggedObject getImplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, int i10) {
        return getImplicitBaseTagged(aSN1TaggedObject, 128, i8, i9, i10);
    }

    public static Object getInstanceChoiceBaseObject(ASN1TaggedObject aSN1TaggedObject, boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(f.d("Implicit tagging cannot be used with untagged choice type ", str, " (X.680 30.6, 30.8)."));
        }
        if (aSN1TaggedObject != null) {
            return getExplicitContextBaseObject(aSN1TaggedObject);
        }
        throw new NullPointerException("'taggedObject' cannot be null");
    }

    public static String getTagClassText(int i8) {
        return i8 != 64 ? i8 != 128 ? i8 != 192 ? "UNIVERSAL" : "PRIVATE" : "CONTEXT" : "APPLICATION";
    }

    public static String getTagText(int i8, int i9) {
        return b.k(i9, i8 != 64 ? i8 != 128 ? i8 != 192 ? "[UNIVERSAL " : "[PRIVATE " : "[CONTEXT " : "[APPLICATION ", "]");
    }

    public static Object getTaggedChoiceBaseObject(ASN1TaggedObject aSN1TaggedObject, boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(f.d("Implicit tagging cannot be used with untagged choice type ", str, " (X.680 30.6, 30.8)."));
        }
        if (aSN1TaggedObject != null) {
            return aSN1TaggedObject.getExplicitBaseObject();
        }
        throw new NullPointerException("'taggedObject' cannot be null");
    }

    public static ASN1Encodable parseBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, boolean z, int i10) {
        return checkTag(aSN1TaggedObjectParser, i8, i9).parseBaseUniversal(z, i10);
    }

    public static ASN1Encodable parseContextBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, boolean z, int i9) {
        return parseBaseUniversal(aSN1TaggedObjectParser, 128, i8, z, i9);
    }

    public static ASN1Encodable parseExplicitBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9) {
        return checkTag(aSN1TaggedObjectParser, i8, i9).parseExplicitBaseObject();
    }

    public static ASN1TaggedObjectParser parseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return checkTagClass(aSN1TaggedObjectParser, i8).parseExplicitBaseTagged();
    }

    public static ASN1Encodable parseExplicitContextBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return parseExplicitBaseObject(aSN1TaggedObjectParser, 128, i8);
    }

    public static ASN1TaggedObjectParser parseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return parseExplicitBaseTagged(aSN1TaggedObjectParser, 128);
    }

    public static ASN1TaggedObjectParser parseImplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, int i10, int i11) {
        return checkTag(aSN1TaggedObjectParser, i8, i9).parseImplicitBaseTagged(i10, i11);
    }

    public static ASN1TaggedObjectParser parseImplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, int i10) {
        return parseImplicitBaseTagged(aSN1TaggedObjectParser, 128, i8, i9, i10);
    }

    public static ASN1Primitive tryGetBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, boolean z, int i10) {
        if (aSN1TaggedObject.hasTag(i8, i9)) {
            return aSN1TaggedObject.getBaseUniversal(z, i10);
        }
        return null;
    }

    public static ASN1Primitive tryGetContextBaseUniversal(ASN1TaggedObject aSN1TaggedObject, int i8, boolean z, int i9) {
        return tryGetBaseUniversal(aSN1TaggedObject, 128, i8, z, i9);
    }

    public static ASN1Object tryGetExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8) {
        if (aSN1TaggedObject.hasTagClass(i8)) {
            return aSN1TaggedObject.getExplicitBaseObject();
        }
        return null;
    }

    public static ASN1TaggedObject tryGetExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8) {
        if (aSN1TaggedObject.hasTagClass(i8)) {
            return aSN1TaggedObject.getExplicitBaseTagged();
        }
        return null;
    }

    public static ASN1Object tryGetExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject) {
        return tryGetExplicitBaseObject(aSN1TaggedObject, 128);
    }

    public static ASN1TaggedObject tryGetExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject) {
        return tryGetExplicitBaseTagged(aSN1TaggedObject, 128);
    }

    public static ASN1TaggedObject tryGetImplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, int i10, int i11) {
        if (aSN1TaggedObject.hasTag(i8, i9)) {
            return aSN1TaggedObject.getImplicitBaseTagged(i10, i11);
        }
        return null;
    }

    public static ASN1TaggedObject tryGetImplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9, int i10) {
        return tryGetImplicitBaseTagged(aSN1TaggedObject, 128, i8, i9, i10);
    }

    public static ASN1Encodable tryParseBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, boolean z, int i10) {
        if (aSN1TaggedObjectParser.hasTag(i8, i9)) {
            return aSN1TaggedObjectParser.parseBaseUniversal(z, i10);
        }
        return null;
    }

    public static ASN1Encodable tryParseContextBaseUniversal(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, boolean z, int i9) {
        return tryParseBaseUniversal(aSN1TaggedObjectParser, 128, i8, z, i9);
    }

    public static ASN1Encodable tryParseExplicitBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9) {
        if (aSN1TaggedObjectParser.hasTag(i8, i9)) {
            return aSN1TaggedObjectParser.parseExplicitBaseObject();
        }
        return null;
    }

    public static ASN1TaggedObjectParser tryParseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        if (aSN1TaggedObjectParser.hasTagClass(i8)) {
            return aSN1TaggedObjectParser.parseExplicitBaseTagged();
        }
        return null;
    }

    public static ASN1Encodable tryParseExplicitContextBaseObject(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return tryParseExplicitBaseObject(aSN1TaggedObjectParser, 128, i8);
    }

    public static ASN1TaggedObjectParser tryParseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return tryParseExplicitBaseTagged(aSN1TaggedObjectParser, 128);
    }

    public static ASN1TaggedObjectParser tryParseImplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, int i10, int i11) {
        if (aSN1TaggedObjectParser.hasTag(i8, i9)) {
            return aSN1TaggedObjectParser.parseImplicitBaseTagged(i10, i11);
        }
        return null;
    }

    public static ASN1TaggedObjectParser tryParseImplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9, int i10) {
        return tryParseImplicitBaseTagged(aSN1TaggedObjectParser, 128, i8, i9, i10);
    }

    public static ASN1TaggedObjectParser checkContextTag(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return checkTag(aSN1TaggedObjectParser, 128, i8);
    }

    public static ASN1TaggedObjectParser checkContextTagClass(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return checkTagClass(aSN1TaggedObjectParser, 128);
    }

    public static ASN1Object getExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8, int i9) {
        return checkTag(aSN1TaggedObject, i8, i9).getExplicitBaseObject();
    }

    public static ASN1TaggedObject getExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9) {
        return checkTag(aSN1TaggedObject, i8, i9).getExplicitBaseTagged();
    }

    public static ASN1Object getExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return getExplicitBaseObject(aSN1TaggedObject, 128, i8);
    }

    public static ASN1TaggedObject getExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return getExplicitBaseTagged(aSN1TaggedObject, 128, i8);
    }

    public static String getTagClassText(ASN1Tag aSN1Tag) {
        return getTagClassText(aSN1Tag.getTagClass());
    }

    public static ASN1TaggedObjectParser parseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9) {
        return checkTag(aSN1TaggedObjectParser, i8, i9).parseExplicitBaseTagged();
    }

    public static ASN1TaggedObjectParser parseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return parseExplicitBaseTagged(aSN1TaggedObjectParser, 128, i8);
    }

    public static ASN1Object tryGetExplicitBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8, int i9) {
        if (aSN1TaggedObject.hasTag(i8, i9)) {
            return aSN1TaggedObject.getExplicitBaseObject();
        }
        return null;
    }

    public static ASN1TaggedObject tryGetExplicitBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8, int i9) {
        if (aSN1TaggedObject.hasTag(i8, i9)) {
            return aSN1TaggedObject.getExplicitBaseTagged();
        }
        return null;
    }

    public static ASN1Object tryGetExplicitContextBaseObject(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return tryGetExplicitBaseObject(aSN1TaggedObject, 128, i8);
    }

    public static ASN1TaggedObject tryGetExplicitContextBaseTagged(ASN1TaggedObject aSN1TaggedObject, int i8) {
        return tryGetExplicitBaseTagged(aSN1TaggedObject, 128, i8);
    }

    public static ASN1TaggedObjectParser tryParseExplicitBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9) {
        if (aSN1TaggedObjectParser.hasTag(i8, i9)) {
            return aSN1TaggedObjectParser.parseExplicitBaseTagged();
        }
        return null;
    }

    public static ASN1TaggedObjectParser tryParseExplicitContextBaseTagged(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        return tryParseExplicitBaseTagged(aSN1TaggedObjectParser, 128, i8);
    }

    public static String getTagClassText(ASN1TaggedObject aSN1TaggedObject) {
        return getTagClassText(aSN1TaggedObject.getTagClass());
    }

    public static String getTagClassText(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return getTagClassText(aSN1TaggedObjectParser.getTagClass());
    }

    public static String getTagText(ASN1Tag aSN1Tag) {
        return getTagText(aSN1Tag.getTagClass(), aSN1Tag.getTagNumber());
    }

    public static ASN1TaggedObjectParser checkTag(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8, int i9) {
        if (aSN1TaggedObjectParser.hasTag(i8, i9)) {
            return aSN1TaggedObjectParser;
        }
        throw new IllegalStateException(b.p("Expected ", getTagText(i8, i9), " tag but found ", getTagText(aSN1TaggedObjectParser)));
    }

    public static ASN1TaggedObjectParser checkTagClass(ASN1TaggedObjectParser aSN1TaggedObjectParser, int i8) {
        if (aSN1TaggedObjectParser.hasTagClass(i8)) {
            return aSN1TaggedObjectParser;
        }
        throw new IllegalStateException(b.p("Expected ", getTagClassText(i8), " tag but found ", getTagClassText(aSN1TaggedObjectParser)));
    }

    public static String getTagText(ASN1TaggedObject aSN1TaggedObject) {
        return getTagText(aSN1TaggedObject.getTagClass(), aSN1TaggedObject.getTagNo());
    }

    public static String getTagText(ASN1TaggedObjectParser aSN1TaggedObjectParser) {
        return getTagText(aSN1TaggedObjectParser.getTagClass(), aSN1TaggedObjectParser.getTagNo());
    }
}
