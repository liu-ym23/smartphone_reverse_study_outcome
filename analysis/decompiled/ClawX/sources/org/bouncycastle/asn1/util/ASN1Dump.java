package org.bouncycastle.asn1.util;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import org.bouncycastle.asn1.ASN1BMPString;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1GraphicString;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1NumericString;
import org.bouncycastle.asn1.ASN1ObjectDescriptor;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1RelativeOID;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1T61String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.ASN1VideotexString;
import org.bouncycastle.asn1.ASN1VisibleString;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DLBitString;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    public static void _dumpAsString(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuilder sb) {
        String strLineSeparator = Strings.lineSeparator();
        sb.append(str);
        if (aSN1Primitive instanceof ASN1Null) {
            sb.append("NULL");
            sb.append(strLineSeparator);
            return;
        }
        int i8 = 0;
        if (aSN1Primitive instanceof ASN1Sequence) {
            sb.append(aSN1Primitive instanceof BERSequence ? "BER Sequence" : aSN1Primitive instanceof DERSequence ? "DER Sequence" : "Sequence");
            sb.append(strLineSeparator);
            ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
            String strN = b.n(str, TAB);
            int size = aSN1Sequence.size();
            while (i8 < size) {
                _dumpAsString(strN, z, aSN1Sequence.getObjectAt(i8).toASN1Primitive(), sb);
                i8++;
            }
            return;
        }
        if (aSN1Primitive instanceof ASN1Set) {
            sb.append(aSN1Primitive instanceof BERSet ? "BER Set" : aSN1Primitive instanceof DERSet ? "DER Set" : "Set");
            sb.append(strLineSeparator);
            ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
            String strN2 = b.n(str, TAB);
            int size2 = aSN1Set.size();
            while (i8 < size2) {
                _dumpAsString(strN2, z, aSN1Set.getObjectAt(i8).toASN1Primitive(), sb);
                i8++;
            }
            return;
        }
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            sb.append(aSN1Primitive instanceof BERTaggedObject ? "BER Tagged " : aSN1Primitive instanceof DERTaggedObject ? "DER Tagged " : "Tagged ");
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            sb.append(ASN1Util.getTagText(aSN1TaggedObject));
            if (!aSN1TaggedObject.isExplicit()) {
                sb.append(" IMPLICIT");
            }
            sb.append(strLineSeparator);
            _dumpAsString(str + TAB, z, aSN1TaggedObject.getBaseObject().toASN1Primitive(), sb);
            return;
        }
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            sb.append("ObjectIdentifier(" + ((ASN1ObjectIdentifier) aSN1Primitive).getId() + ")" + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1RelativeOID) {
            sb.append("RelativeOID(" + ((ASN1RelativeOID) aSN1Primitive).getId() + ")" + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1Boolean) {
            sb.append("Boolean(" + ((ASN1Boolean) aSN1Primitive).isTrue() + ")" + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1Integer) {
            sb.append("Integer(" + ((ASN1Integer) aSN1Primitive).getValue() + ")" + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            sb.append(aSN1Primitive instanceof BEROctetString ? "BER Constructed Octet String[" : "DER Octet String[");
            sb.append(aSN1OctetString.getOctetsLength() + "]" + strLineSeparator);
            if (z) {
                dumpBinaryDataAsString(sb, str, aSN1OctetString.getOctets());
                return;
            }
            return;
        }
        if (aSN1Primitive instanceof ASN1BitString) {
            ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
            sb.append(aSN1BitString instanceof DERBitString ? "DER Bit String[" : aSN1BitString instanceof DLBitString ? "DL Bit String[" : "BER Bit String[");
            sb.append(aSN1BitString.getBytesLength() + ", " + aSN1BitString.getPadBits() + "]" + strLineSeparator);
            if (z) {
                dumpBinaryDataAsString(sb, str, aSN1BitString.getBytes());
                return;
            }
            return;
        }
        if (aSN1Primitive instanceof ASN1IA5String) {
            sb.append("IA5String(" + ((ASN1IA5String) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1UTF8String) {
            sb.append("UTF8String(" + ((ASN1UTF8String) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1NumericString) {
            sb.append("NumericString(" + ((ASN1NumericString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1PrintableString) {
            sb.append("PrintableString(" + ((ASN1PrintableString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1VisibleString) {
            sb.append("VisibleString(" + ((ASN1VisibleString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1BMPString) {
            sb.append("BMPString(" + ((ASN1BMPString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1T61String) {
            sb.append("T61String(" + ((ASN1T61String) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1GraphicString) {
            sb.append("GraphicString(" + ((ASN1GraphicString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1VideotexString) {
            sb.append("VideotexString(" + ((ASN1VideotexString) aSN1Primitive).getString() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1UTCTime) {
            sb.append("UTCTime(" + ((ASN1UTCTime) aSN1Primitive).getTime() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            sb.append("GeneralizedTime(" + ((ASN1GeneralizedTime) aSN1Primitive).getTime() + ") " + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1Enumerated) {
            sb.append("DER Enumerated(" + ((ASN1Enumerated) aSN1Primitive).getValue() + ")" + strLineSeparator);
            return;
        }
        if (aSN1Primitive instanceof ASN1ObjectDescriptor) {
            sb.append("ObjectDescriptor(" + ((ASN1ObjectDescriptor) aSN1Primitive).getBaseGraphicString().getString() + ") " + strLineSeparator);
            return;
        }
        if (!(aSN1Primitive instanceof ASN1External)) {
            sb.append(aSN1Primitive.toString() + strLineSeparator);
            return;
        }
        ASN1External aSN1External = (ASN1External) aSN1Primitive;
        sb.append("External " + strLineSeparator);
        String str2 = str + TAB;
        if (aSN1External.getDirectReference() != null) {
            sb.append(str2 + "Direct Reference: " + aSN1External.getDirectReference().getId() + strLineSeparator);
        }
        if (aSN1External.getIndirectReference() != null) {
            sb.append(str2 + "Indirect Reference: " + aSN1External.getIndirectReference().toString() + strLineSeparator);
        }
        if (aSN1External.getDataValueDescriptor() != null) {
            _dumpAsString(str2, z, aSN1External.getDataValueDescriptor(), sb);
        }
        sb.append(str2 + "Encoding: " + aSN1External.getEncoding() + strLineSeparator);
        _dumpAsString(str2, z, aSN1External.getExternalContent(), sb);
    }

    private static void appendAscString(StringBuilder sb, byte[] bArr, int i8, int i9) {
        for (int i10 = i8; i10 != i8 + i9; i10++) {
            byte b9 = bArr[i10];
            if (b9 >= 32 && b9 <= 126) {
                sb.append((char) b9);
            }
        }
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    private static void dumpBinaryDataAsString(StringBuilder sb, String str, byte[] bArr) {
        if (bArr.length < 1) {
            return;
        }
        String strLineSeparator = Strings.lineSeparator();
        String strN = b.n(str, TAB);
        for (int i8 = 0; i8 < bArr.length; i8 += 32) {
            int iMin = Math.min(bArr.length - i8, 32);
            sb.append(strN);
            sb.append(Hex.toHexString(bArr, i8, iMin));
            for (int i9 = iMin; i9 < 32; i9++) {
                sb.append("  ");
            }
            sb.append(TAB);
            appendAscString(sb, bArr, i8, iMin);
            sb.append(strLineSeparator);
        }
    }

    public static String dumpAsString(Object obj, boolean z) {
        ASN1Primitive aSN1Primitive;
        if (obj instanceof ASN1Primitive) {
            aSN1Primitive = (ASN1Primitive) obj;
        } else {
            if (!(obj instanceof ASN1Encodable)) {
                return "unknown object type " + obj.toString();
            }
            aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
        }
        StringBuilder sb = new StringBuilder();
        _dumpAsString(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, z, aSN1Primitive, sb);
        return sb.toString();
    }
}
