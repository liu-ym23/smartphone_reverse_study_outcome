package com.fasterxml.jackson.core.json.async;

import com.fasterxml.jackson.core.async.ByteBufferFeeder;
import com.fasterxml.jackson.core.async.NonBlockingInputFeeder;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

/* loaded from: classes.dex */
public class NonBlockingByteBufferJsonParser extends NonBlockingUtf8JsonParserBase implements ByteBufferFeeder {
    private ByteBuffer _inputBuffer;

    public NonBlockingByteBufferJsonParser(IOContext iOContext, int i10, ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
        super(iOContext, i10, byteQuadsCanonicalizer);
        this._inputBuffer = ByteBuffer.wrap(ParserMinimalBase.NO_BYTES);
    }

    @Override // com.fasterxml.jackson.core.async.ByteBufferFeeder
    public void feedInput(ByteBuffer byteBuffer) throws IOException {
        int i10 = this._inputPtr;
        int i11 = this._inputEnd;
        if (i10 < i11) {
            _reportError("Still have %d undecoded bytes, should not call 'feedInput'", Integer.valueOf(i11 - i10));
        }
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        if (iLimit < iPosition) {
            _reportError("Input end (%d) may not be before start (%d)", Integer.valueOf(iLimit), Integer.valueOf(iPosition));
        }
        if (this._endOfInput) {
            _reportError("Already closed, can not feed more input");
        }
        long j10 = this._currInputProcessed + this._origBufferLen;
        this._currInputProcessed = j10;
        this._streamReadConstraints.validateDocumentLength(j10);
        this._currInputRowStart = iPosition - (this._inputEnd - this._currInputRowStart);
        this._currBufferStart = iPosition;
        this._inputBuffer = byteBuffer;
        this._inputPtr = iPosition;
        this._inputEnd = iLimit;
        this._origBufferLen = iLimit - iPosition;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getByteFromBuffer(int i10) {
        return this._inputBuffer.get(i10);
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getNextSignedByteFromBuffer() {
        ByteBuffer byteBuffer = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        return byteBuffer.get(i10);
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public int getNextUnsignedByteFromBuffer() {
        ByteBuffer byteBuffer = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        return byteBuffer.get(i10) & 255;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public NonBlockingInputFeeder getNonBlockingInputFeeder() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase, com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i10 = this._inputEnd - this._inputPtr;
        if (i10 > 0) {
            Channels.newChannel(outputStream).write(this._inputBuffer);
        }
        return i10;
    }
}
