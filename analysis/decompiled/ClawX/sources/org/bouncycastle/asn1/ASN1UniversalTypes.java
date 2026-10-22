package org.bouncycastle.asn1;

/* loaded from: classes.dex */
final class ASN1UniversalTypes {
    private ASN1UniversalTypes() {
    }

    public static ASN1UniversalType get(int i8) {
        switch (i8) {
            case 1:
                return ASN1Boolean.TYPE;
            case 2:
                return ASN1Integer.TYPE;
            case 3:
                return ASN1BitString.TYPE;
            case 4:
                return ASN1OctetString.TYPE;
            case 5:
                return ASN1Null.TYPE;
            case 6:
                return ASN1ObjectIdentifier.TYPE;
            case 7:
                return ASN1ObjectDescriptor.TYPE;
            case 8:
                return ASN1External.TYPE;
            case 9:
            case BERTags.EMBEDDED_PDV /* 11 */:
            case BERTags.TIME /* 14 */:
            case 15:
            case BERTags.UNRESTRICTED_STRING /* 29 */:
            default:
                return null;
            case 10:
                return ASN1Enumerated.TYPE;
            case 12:
                return ASN1UTF8String.TYPE;
            case BERTags.RELATIVE_OID /* 13 */:
                return ASN1RelativeOID.TYPE;
            case 16:
                return ASN1Sequence.TYPE;
            case 17:
                return ASN1Set.TYPE;
            case BERTags.NUMERIC_STRING /* 18 */:
                return ASN1NumericString.TYPE;
            case 19:
                return ASN1PrintableString.TYPE;
            case 20:
                return ASN1T61String.TYPE;
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return ASN1VideotexString.TYPE;
            case BERTags.IA5_STRING /* 22 */:
                return ASN1IA5String.TYPE;
            case BERTags.UTC_TIME /* 23 */:
                return ASN1UTCTime.TYPE;
            case 24:
                return ASN1GeneralizedTime.TYPE;
            case BERTags.GRAPHIC_STRING /* 25 */:
                return ASN1GraphicString.TYPE;
            case BERTags.VISIBLE_STRING /* 26 */:
                return ASN1VisibleString.TYPE;
            case BERTags.GENERAL_STRING /* 27 */:
                return ASN1GeneralString.TYPE;
            case BERTags.UNIVERSAL_STRING /* 28 */:
                return ASN1UniversalString.TYPE;
            case 30:
                return ASN1BMPString.TYPE;
        }
    }
}
