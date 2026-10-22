package org.bouncycastle.asn1;

import a8.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    private void set00Check(boolean z) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }

    public ASN1Encodable implParseObject(int i8) throws IOException {
        set00Check(false);
        int tagNumber = ASN1InputStream.readTagNumber(this._in, i8);
        int length = ASN1InputStream.readLength(this._in, this._limit, tagNumber == 3 || tagNumber == 4 || tagNumber == 16 || tagNumber == 17 || tagNumber == 8);
        if (length < 0) {
            if ((i8 & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit, this.tmpBuffers);
            int i9 = i8 & BERTags.PRIVATE;
            return i9 != 0 ? new BERTaggedObjectParser(i9, tagNumber, aSN1StreamParser) : aSN1StreamParser.parseImplicitConstructedIL(tagNumber);
        }
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this._in, length, this._limit);
        if ((i8 & BERTags.FLAGS) == 0) {
            return parseImplicitPrimitive(tagNumber, definiteLengthInputStream);
        }
        ASN1StreamParser aSN1StreamParser2 = new ASN1StreamParser(definiteLengthInputStream, definiteLengthInputStream.getLimit(), this.tmpBuffers);
        int i10 = i8 & BERTags.PRIVATE;
        if (i10 != 0) {
            return new DLTaggedObjectParser(i10, tagNumber, (i8 & 32) != 0, aSN1StreamParser2);
        }
        return aSN1StreamParser2.parseImplicitConstructedDL(tagNumber);
    }

    public ASN1Primitive loadTaggedDL(int i8, int i9, boolean z) {
        return !z ? ASN1TaggedObject.createPrimitive(i8, i9, ((DefiniteLengthInputStream) this._in).toByteArray()) : ASN1TaggedObject.createConstructedDL(i8, i9, readVector());
    }

    public ASN1Primitive loadTaggedIL(int i8, int i9) {
        return ASN1TaggedObject.createConstructedIL(i8, i9, readVector());
    }

    public ASN1Encodable parseImplicitConstructedDL(int i8) throws ASN1Exception {
        if (i8 == 3) {
            return new BERBitStringParser(this);
        }
        if (i8 == 4) {
            return new BEROctetStringParser(this);
        }
        if (i8 == 8) {
            return new DERExternalParser(this);
        }
        if (i8 == 16) {
            return new DLSequenceParser(this);
        }
        if (i8 == 17) {
            return new DLSetParser(this);
        }
        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(i8));
    }

    public ASN1Encodable parseImplicitConstructedIL(int i8) throws ASN1Exception {
        if (i8 == 3) {
            return new BERBitStringParser(this);
        }
        if (i8 == 4) {
            return new BEROctetStringParser(this);
        }
        if (i8 == 8) {
            return new DERExternalParser(this);
        }
        if (i8 == 16) {
            return new BERSequenceParser(this);
        }
        if (i8 == 17) {
            return new BERSetParser(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i8));
    }

    public ASN1Encodable parseImplicitPrimitive(int i8) {
        return parseImplicitPrimitive(i8, (DefiniteLengthInputStream) this._in);
    }

    public ASN1Encodable parseObject(int i8) throws IOException {
        if (i8 < 0 || i8 > 30) {
            throw new IllegalArgumentException(b.j(i8, "invalid universal tag number: "));
        }
        int i9 = this._in.read();
        if (i9 < 0) {
            return null;
        }
        if ((i9 & (-33)) == i8) {
            return implParseObject(i9);
        }
        throw new IOException(b.j(i9, "unexpected identifier encountered: "));
    }

    public ASN1TaggedObjectParser parseTaggedObject() throws IOException {
        int i8 = this._in.read();
        if (i8 < 0) {
            return null;
        }
        if ((i8 & BERTags.PRIVATE) != 0) {
            return (ASN1TaggedObjectParser) implParseObject(i8);
        }
        throw new ASN1Exception("no tagged object found");
    }

    public ASN1Encodable readObject() throws IOException {
        int i8 = this._in.read();
        if (i8 < 0) {
            return null;
        }
        return implParseObject(i8);
    }

    public ASN1EncodableVector readVector() throws IOException {
        int i8 = this._in.read();
        if (i8 < 0) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        do {
            ASN1Encodable aSN1EncodableImplParseObject = implParseObject(i8);
            aSN1EncodableVector.add(aSN1EncodableImplParseObject instanceof InMemoryRepresentable ? ((InMemoryRepresentable) aSN1EncodableImplParseObject).getLoadedObject() : aSN1EncodableImplParseObject.toASN1Primitive());
            i8 = this._in.read();
        } while (i8 >= 0);
        return aSN1EncodableVector;
    }

    public ASN1StreamParser(InputStream inputStream, int i8) {
        this(inputStream, i8, new byte[11][]);
    }

    public ASN1Encodable parseImplicitPrimitive(int i8, DefiniteLengthInputStream definiteLengthInputStream) throws ASN1Exception {
        if (i8 == 3) {
            return new DLBitStringParser(definiteLengthInputStream);
        }
        if (i8 == 4) {
            return new DEROctetStringParser(definiteLengthInputStream);
        }
        if (i8 == 8) {
            throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i8 == 16) {
            throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i8 == 17) {
            throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return ASN1InputStream.createPrimitiveDERObject(i8, definiteLengthInputStream, this.tmpBuffers);
        } catch (IllegalArgumentException e9) {
            throw new ASN1Exception("corrupted stream detected", e9);
        }
    }

    public ASN1StreamParser(InputStream inputStream, int i8, byte[][] bArr) {
        this._in = inputStream;
        this._limit = i8;
        this.tmpBuffers = bArr;
    }

    public ASN1StreamParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }
}
