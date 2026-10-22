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

/* loaded from: classes2.dex */
public class NonBlockingByteBufferJsonParser extends NonBlockingUtf8JsonParserBase implements ByteBufferFeeder {
    private ByteBuffer _inputBuffer;

    public NonBlockingByteBufferJsonParser(IOContext iOContext, int i, ByteQuadsCanonicalizer byteQuadsCanonicalizer) {
        super(iOContext, i, byteQuadsCanonicalizer);
        this._inputBuffer = ByteBuffer.wrap(ParserMinimalBase.NO_BYTES);
    }

    @Override // com.fasterxml.jackson.core.async.ByteBufferFeeder
    public void feedInput(ByteBuffer byteBuffer) throws IOException {
        int i = this._inputPtr;
        int i6 = this._inputEnd;
        if (i < i6) {
            _reportError("Still have %d undecoded bytes, should not call 'feedInput'", Integer.valueOf(i6 - i));
        }
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        if (iLimit < iPosition) {
            _reportError("Input end (%d) may not be before start (%d)", Integer.valueOf(iLimit), Integer.valueOf(iPosition));
        }
        if (this._endOfInput) {
            _reportError("Already closed, can not feed more input");
        }
        long j5 = this._currInputProcessed + this._origBufferLen;
        this._currInputProcessed = j5;
        this._streamReadConstraints.validateDocumentLength(j5);
        this._currInputRowStart = iPosition - (this._inputEnd - this._currInputRowStart);
        this._currBufferStart = iPosition;
        this._inputBuffer = byteBuffer;
        this._inputPtr = iPosition;
        this._inputEnd = iLimit;
        this._origBufferLen = iLimit - iPosition;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getByteFromBuffer(int i) {
        return this._inputBuffer.get(i);
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public byte getNextSignedByteFromBuffer() {
        ByteBuffer byteBuffer = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return byteBuffer.get(i);
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingUtf8JsonParserBase
    public int getNextUnsignedByteFromBuffer() {
        ByteBuffer byteBuffer = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return byteBuffer.get(i) & 255;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public NonBlockingInputFeeder getNonBlockingInputFeeder() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase, com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i = this._inputEnd - this._inputPtr;
        if (i > 0) {
            Channels.newChannel(outputStream).write(this._inputBuffer);
        }
        return i;
    }
}
