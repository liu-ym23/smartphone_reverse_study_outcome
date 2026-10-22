package com.fasterxml.jackson.core.json.async;

import com.fasterxml.jackson.core.async.ByteArrayFeeder;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class NonBlockingJsonParser extends NonBlockingUtf8JsonParserBase implements ByteArrayFeeder {
    private byte[] _inputBuffer;

    public NonBlockingJsonParser(IOContext iOContext, int i10, ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
        super(iOContext, i10, byteQuadsCanonicalizer);
        this._inputBuffer = ParserMinimalBase.NO_BYTES;
    }

    @Override // com.fasterxml.jackson.core.async.ByteArrayFeeder
    public void feedInput(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this._inputPtr;
        int i13 = this._inputEnd;
        if (i12 < i13) {
            _reportError("Still have %d undecoded bytes, should not call 'feedInput'", Integer.valueOf(i13 - i12));
        }
        if (i11 < i10) {
            _reportError("Input end (%d) may not be before start (%d)", Integer.valueOf(i11), Integer.valueOf(i10));
        }
        if (this._endOfInput) {
            _reportError("Already closed, can not feed more input");
        }
        long j10 = this._currInputProcessed + this._origBufferLen;
        this._currInputProcessed = j10;
        this._streamReadConstraints.validateDocumentLength(j10);
        this._currInputRowStart = i10 - (this._inputEnd - this._currInputRowStart);
        this._currBufferStart = i10;
        this._inputBuffer = bArr;
        this._inputPtr = i10;
        this._inputEnd = i11;
        this._origBufferLen = i11 - i10;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getByteFromBuffer(int i10) {
        return this._inputBuffer[i10];
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getNextSignedByteFromBuffer() {
        byte[] bArr = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        return bArr[i10];
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public int getNextUnsignedByteFromBuffer() {
        byte[] bArr = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ByteArrayFeeder getNonBlockingInputFeeder() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase, com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i10 = this._inputEnd;
        int i11 = this._inputPtr;
        int i12 = i10 - i11;
        if (i12 > 0) {
            outputStream.write(this._inputBuffer, i11, i12);
        }
        return i12;
    }
}
