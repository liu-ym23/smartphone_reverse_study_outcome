package org.bouncycastle.asn1;

import a8.b;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes.dex */
public class ASN1InputStream extends FilterInputStream implements BERTags {
    private final boolean lazyEvaluate;
    private final int limit;
    private final byte[][] tmpBuffers;

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    public static ASN1Primitive createPrimitiveDERObject(int i8, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        try {
            switch (i8) {
                case 1:
                    return ASN1Boolean.createPrimitive(getBuffer(definiteLengthInputStream, bArr));
                case 2:
                    return ASN1Integer.createPrimitive(definiteLengthInputStream.toByteArray());
                case 3:
                    return ASN1BitString.createPrimitive(definiteLengthInputStream.toByteArray());
                case 4:
                    return ASN1OctetString.createPrimitive(definiteLengthInputStream.toByteArray());
                case 5:
                    ASN1Null.checkContentsLength(definiteLengthInputStream.getRemaining());
                    return ASN1Null.createPrimitive();
                case 6:
                    ASN1ObjectIdentifier.checkContentsLength(definiteLengthInputStream.getRemaining());
                    return ASN1ObjectIdentifier.createPrimitive(getBuffer(definiteLengthInputStream, bArr), true);
                case 7:
                    return ASN1ObjectDescriptor.createPrimitive(definiteLengthInputStream.toByteArray());
                case 8:
                case 9:
                case BERTags.EMBEDDED_PDV /* 11 */:
                case 15:
                case 16:
                case 17:
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                default:
                    throw new IOException("unknown tag " + i8 + " encountered");
                case 10:
                    return ASN1Enumerated.createPrimitive(getBuffer(definiteLengthInputStream, bArr), true);
                case 12:
                    return ASN1UTF8String.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.RELATIVE_OID /* 13 */:
                    ASN1RelativeOID.checkContentsLength(definiteLengthInputStream.getRemaining());
                    return ASN1RelativeOID.createPrimitive(getBuffer(definiteLengthInputStream, bArr), true);
                case BERTags.TIME /* 14 */:
                case BERTags.DATE /* 31 */:
                case 32:
                case BERTags.DATE_TIME /* 33 */:
                case BERTags.DURATION /* 34 */:
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    throw new IOException("unsupported tag " + i8 + " encountered");
                case BERTags.NUMERIC_STRING /* 18 */:
                    return ASN1NumericString.createPrimitive(definiteLengthInputStream.toByteArray());
                case 19:
                    return ASN1PrintableString.createPrimitive(definiteLengthInputStream.toByteArray());
                case 20:
                    return ASN1T61String.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    return ASN1VideotexString.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.IA5_STRING /* 22 */:
                    return ASN1IA5String.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.UTC_TIME /* 23 */:
                    return ASN1UTCTime.createPrimitive(definiteLengthInputStream.toByteArray());
                case 24:
                    return ASN1GeneralizedTime.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.GRAPHIC_STRING /* 25 */:
                    return ASN1GraphicString.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.VISIBLE_STRING /* 26 */:
                    return ASN1VisibleString.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.GENERAL_STRING /* 27 */:
                    return ASN1GeneralString.createPrimitive(definiteLengthInputStream.toByteArray());
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    return ASN1UniversalString.createPrimitive(definiteLengthInputStream.toByteArray());
                case 30:
                    return ASN1BMPString.createPrimitive(getBMPCharBuffer(definiteLengthInputStream));
            }
        } catch (IllegalArgumentException e9) {
            throw new ASN1Exception(e9.getMessage(), e9);
        } catch (IllegalStateException e10) {
            throw new ASN1Exception(e10.getMessage(), e10);
        }
    }

    private static char[] getBMPCharBuffer(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        int remaining = definiteLengthInputStream.getRemaining();
        if ((remaining & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i8 = remaining / 2;
        char[] cArr = new char[i8];
        byte[] bArr = new byte[8];
        int i9 = 0;
        int i10 = 0;
        while (remaining >= 8) {
            if (Streams.readFully(definiteLengthInputStream, bArr, 0, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i10] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
            cArr[i10 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
            cArr[i10 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
            cArr[i10 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
            i10 += 4;
            remaining -= 8;
        }
        if (remaining > 0) {
            if (Streams.readFully(definiteLengthInputStream, bArr, 0, remaining) != remaining) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            do {
                int i11 = i9 + 1;
                int i12 = bArr[i9] << 8;
                i9 += 2;
                cArr[i10] = (char) ((bArr[i11] & 255) | i12);
                i10++;
            } while (i9 < remaining);
        }
        if (definiteLengthInputStream.getRemaining() == 0 && i8 == i10) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    private static byte[] getBuffer(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int remaining = definiteLengthInputStream.getRemaining();
        if (remaining >= bArr.length) {
            return definiteLengthInputStream.toByteArray();
        }
        byte[] bArr2 = bArr[remaining];
        if (bArr2 == null) {
            bArr2 = new byte[remaining];
            bArr[remaining] = bArr2;
        }
        definiteLengthInputStream.readAllIntoByteArray(bArr2);
        return bArr2;
    }

    public static int readTagNumber(InputStream inputStream, int i8) throws IOException {
        int i9 = i8 & 31;
        if (i9 != 31) {
            return i9;
        }
        int i10 = inputStream.read();
        if (i10 < 31) {
            if (i10 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        int i11 = i10 & 127;
        if (i11 == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((i10 & 128) != 0) {
            if ((i11 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            int i12 = i11 << 7;
            int i13 = inputStream.read();
            if (i13 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            i11 = i12 | (i13 & 127);
            i10 = i13;
        }
        return i11;
    }

    public ASN1BitString buildConstructedBitString(ASN1EncodableVector aSN1EncodableVector) throws ASN1Exception {
        int size = aSN1EncodableVector.size();
        ASN1BitString[] aSN1BitStringArr = new ASN1BitString[size];
        for (int i8 = 0; i8 != size; i8++) {
            ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(i8);
            if (!(aSN1Encodable instanceof ASN1BitString)) {
                throw new ASN1Exception("unknown object encountered in constructed BIT STRING: " + aSN1Encodable.getClass());
            }
            aSN1BitStringArr[i8] = (ASN1BitString) aSN1Encodable;
        }
        return new BERBitString(aSN1BitStringArr);
    }

    public ASN1OctetString buildConstructedOctetString(ASN1EncodableVector aSN1EncodableVector) throws ASN1Exception {
        int size = aSN1EncodableVector.size();
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
        for (int i8 = 0; i8 != size; i8++) {
            ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(i8);
            if (!(aSN1Encodable instanceof ASN1OctetString)) {
                throw new ASN1Exception("unknown object encountered in constructed OCTET STRING: " + aSN1Encodable.getClass());
            }
            aSN1OctetStringArr[i8] = (ASN1OctetString) aSN1Encodable;
        }
        return new BEROctetString(aSN1OctetStringArr);
    }

    public ASN1Primitive buildObject(int i8, int i9, int i10) throws IOException {
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i10, this.limit);
        if ((i8 & BERTags.FLAGS) == 0) {
            return createPrimitiveDERObject(i9, definiteLengthInputStream, this.tmpBuffers);
        }
        int i11 = i8 & BERTags.PRIVATE;
        if (i11 != 0) {
            return readTaggedObjectDL(i11, i9, (i8 & 32) != 0, definiteLengthInputStream);
        }
        if (i9 == 3) {
            return buildConstructedBitString(readVector(definiteLengthInputStream));
        }
        if (i9 == 4) {
            return buildConstructedOctetString(readVector(definiteLengthInputStream));
        }
        if (i9 == 8) {
            return DLFactory.createSequence(readVector(definiteLengthInputStream)).toASN1External();
        }
        if (i9 == 16) {
            return definiteLengthInputStream.getRemaining() < 1 ? DLFactory.EMPTY_SEQUENCE : this.lazyEvaluate ? new LazyEncodedSequence(definiteLengthInputStream.toByteArray()) : DLFactory.createSequence(readVector(definiteLengthInputStream));
        }
        if (i9 == 17) {
            return DLFactory.createSet(readVector(definiteLengthInputStream));
        }
        throw new IOException(b.k(i9, "unknown tag ", " encountered"));
    }

    public int getLimit() {
        return this.limit;
    }

    public void readFully(byte[] bArr) throws EOFException {
        if (Streams.readFully(this, bArr, 0, bArr.length) != bArr.length) {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    public int readLength() {
        return readLength(this, this.limit, false);
    }

    public ASN1Primitive readObject() {
        int i8 = read();
        if (i8 <= 0) {
            if (i8 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int tagNumber = readTagNumber(this, i8);
        int length = readLength();
        if (length >= 0) {
            try {
                return buildObject(i8, tagNumber, length);
            } catch (IllegalArgumentException e9) {
                throw new ASN1Exception("corrupted stream detected", e9);
            }
        }
        if ((i8 & 32) == 0) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit, this.tmpBuffers);
        int i9 = i8 & BERTags.PRIVATE;
        if (i9 != 0) {
            return aSN1StreamParser.loadTaggedIL(i9, tagNumber);
        }
        if (tagNumber == 3) {
            return BERBitStringParser.parse(aSN1StreamParser);
        }
        if (tagNumber == 4) {
            return BEROctetStringParser.parse(aSN1StreamParser);
        }
        if (tagNumber == 8) {
            return DERExternalParser.parse(aSN1StreamParser);
        }
        if (tagNumber == 16) {
            return BERSequenceParser.parse(aSN1StreamParser);
        }
        if (tagNumber == 17) {
            return BERSetParser.parse(aSN1StreamParser);
        }
        throw new IOException("unknown BER object encountered");
    }

    public ASN1Primitive readTaggedObjectDL(int i8, int i9, boolean z, DefiniteLengthInputStream definiteLengthInputStream) {
        return !z ? ASN1TaggedObject.createPrimitive(i8, i9, definiteLengthInputStream.toByteArray()) : ASN1TaggedObject.createConstructedDL(i8, i9, readVector(definiteLengthInputStream));
    }

    public ASN1EncodableVector readVector() {
        ASN1Primitive object = readObject();
        if (object == null) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        do {
            aSN1EncodableVector.add(object);
            object = readObject();
        } while (object != null);
        return aSN1EncodableVector;
    }

    public ASN1InputStream(InputStream inputStream, int i8) {
        this(inputStream, i8, false);
    }

    public static int readLength(InputStream inputStream, int i8, boolean z) throws IOException {
        int i9 = inputStream.read();
        if ((i9 >>> 7) == 0) {
            return i9;
        }
        if (128 == i9) {
            return -1;
        }
        if (i9 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (255 == i9) {
            throw new IOException("invalid long form definite-length 0xFF");
        }
        int i10 = i9 & 127;
        int i11 = 0;
        int i12 = 0;
        do {
            int i13 = inputStream.read();
            if (i13 < 0) {
                throw new EOFException("EOF found reading length");
            }
            if ((i11 >>> 23) != 0) {
                throw new IOException("long form definite-length more than 31 bits");
            }
            i11 = (i11 << 8) + i13;
            i12++;
        } while (i12 < i10);
        if (i11 < i8 || z) {
            return i11;
        }
        throw new IOException(b.i(i11, i8, "corrupted stream - out of bounds length found: ", " >= "));
    }

    public ASN1EncodableVector readVector(DefiniteLengthInputStream definiteLengthInputStream) {
        int remaining = definiteLengthInputStream.getRemaining();
        return remaining < 1 ? new ASN1EncodableVector(0) : new ASN1InputStream(definiteLengthInputStream, remaining, this.lazyEvaluate, this.tmpBuffers).readVector();
    }

    public ASN1InputStream(InputStream inputStream, int i8, boolean z) {
        this(inputStream, i8, z, new byte[11][]);
    }

    private ASN1InputStream(InputStream inputStream, int i8, boolean z, byte[][] bArr) {
        super(inputStream);
        this.limit = i8;
        this.lazyEvaluate = z;
        this.tmpBuffers = bArr;
    }

    public ASN1InputStream(InputStream inputStream, boolean z) {
        this(inputStream, StreamUtil.findLimit(inputStream), z);
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }
}
