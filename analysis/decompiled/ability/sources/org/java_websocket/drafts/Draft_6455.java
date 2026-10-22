package org.java_websocket.drafts;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import androidx.appfunctions.metadata.a;
import androidx.collection.SieveCacheKt;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;

/* loaded from: classes4.dex */
public class Draft_6455 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONNECTION = "Connection";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String UPGRADE = "Upgrade";
    private final List<ByteBuffer> byteBufferList;
    private Framedata currentContinuousFrame;
    private IExtension currentDecodingExtension;
    private IExtension defaultExtension;
    private ByteBuffer incompleteframe;
    private List<IExtension> knownExtensions;
    private List<IProtocol> knownProtocols;
    private final InterfaceC0315b log;
    private int maxFrameSize;
    private IExtension negotiatedExtension;
    private IProtocol protocol;
    private final SecureRandom reuseableRandom;

    public class TranslatedPayloadMetaData {
        private int payloadLength;
        private int realPackageSize;

        public TranslatedPayloadMetaData(int i, int i6) {
            this.payloadLength = i;
            this.realPackageSize = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getPayloadLength() {
            return this.payloadLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getRealPackageSize() {
            return this.realPackageSize;
        }
    }

    public Draft_6455() {
        this((List<IExtension>) Collections.EMPTY_LIST);
    }

    private void addToBufferList(ByteBuffer byteBuffer) {
        synchronized (this.byteBufferList) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() throws LimitExceededException {
        long byteBufferListSize = getByteBufferListSize();
        if (byteBufferListSize <= this.maxFrameSize) {
            return;
        }
        clearBufferList();
        this.log.b(Integer.valueOf(this.maxFrameSize), "Payload limit reached. Allowed: {} Current: {}", Long.valueOf(byteBufferListSize));
        throw new LimitExceededException(this.maxFrameSize);
    }

    private void clearBufferList() {
        synchronized (this.byteBufferList) {
            this.byteBufferList.clear();
        }
    }

    private HandshakeState containsRequestedProtocol(String str) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.acceptProvidedProtocol(str)) {
                this.protocol = iProtocol;
                this.log.g(iProtocol, "acceptHandshake - Matching protocol found: {}");
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i = 0;
        boolean z10 = this.role == Role.CLIENT;
        int sizeBytes = getSizeBytes(payloadData);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(payloadData.remaining() + (sizeBytes > 1 ? sizeBytes + 1 : sizeBytes) + 1 + (z10 ? 4 : 0));
        byte bFromOpcode = (byte) (fromOpcode(framedata.getOpcode()) | ((byte) (framedata.isFin() ? -128 : 0)));
        if (framedata.isRSV1()) {
            bFromOpcode = (byte) (bFromOpcode | getRSVByte(1));
        }
        if (framedata.isRSV2()) {
            bFromOpcode = (byte) (bFromOpcode | getRSVByte(2));
        }
        if (framedata.isRSV3()) {
            bFromOpcode = (byte) (getRSVByte(3) | bFromOpcode);
        }
        byteBufferAllocate.put(bFromOpcode);
        byte[] byteArray = toByteArray(payloadData.remaining(), sizeBytes);
        if (sizeBytes == 1) {
            byteBufferAllocate.put((byte) (byteArray[0] | getMaskByte(z10)));
        } else if (sizeBytes == 2) {
            byteBufferAllocate.put((byte) (getMaskByte(z10) | 126));
            byteBufferAllocate.put(byteArray);
        } else {
            if (sizeBytes != 8) {
                throw new IllegalStateException("Size representation not supported/specified");
            }
            byteBufferAllocate.put((byte) (getMaskByte(z10) | 127));
            byteBufferAllocate.put(byteArray);
        }
        if (z10) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.reuseableRandom.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (payloadData.hasRemaining()) {
                byteBufferAllocate.put((byte) (payloadData.get() ^ byteBufferAllocate2.get(i % 4)));
                i++;
            }
        } else {
            byteBufferAllocate.put(payloadData);
            payloadData.flip();
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Opcode.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) throws NoSuchAlgorithmException {
        String strL = a.l(str.trim(), "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest(strL.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private long getByteBufferListSize() {
        long jLimit;
        synchronized (this.byteBufferList) {
            try {
                jLimit = 0;
                while (this.byteBufferList.iterator().hasNext()) {
                    jLimit += r5.next().limit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jLimit;
    }

    private byte getMaskByte(boolean z10) {
        return z10 ? (byte) -128 : (byte) 0;
    }

    private ByteBuffer getPayloadFromByteBufferList() throws LimitExceededException {
        ByteBuffer byteBufferAllocate;
        synchronized (this.byteBufferList) {
            try {
                long jLimit = 0;
                while (this.byteBufferList.iterator().hasNext()) {
                    jLimit += r1.next().limit();
                }
                checkBufferLimit();
                byteBufferAllocate = ByteBuffer.allocate((int) jLimit);
                Iterator<ByteBuffer> it = this.byteBufferList.iterator();
                while (it.hasNext()) {
                    byteBufferAllocate.put(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private byte getRSVByte(int i) {
        if (i == 1) {
            return (byte) 64;
        }
        if (i != 2) {
            return i != 3 ? (byte) 0 : (byte) 16;
        }
        return (byte) 32;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        this.log.error("Runtime exception during onWebsocketMessage", runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, framedata.getPayloadData());
        } catch (RuntimeException e) {
            logRuntimeException(webSocketImpl, e);
        }
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int closeCode;
        String message;
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame) framedata;
            closeCode = closeFrame.getCloseCode();
            message = closeFrame.getMessage();
        } else {
            closeCode = 1005;
            message = "";
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(closeCode, message, true);
        } else if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(closeCode, message, true);
        } else {
            webSocketImpl.flushAndClose(closeCode, message, false);
        }
    }

    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) throws InvalidDataException {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            this.log.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            this.log.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        }
        if (opcode != opcode2 || this.currentContinuousFrame == null) {
            return;
        }
        addToBufferList(framedata.getPayloadData());
    }

    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame == null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        addToBufferList(framedata.getPayloadData());
        checkBufferLimit();
        if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
            ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
            ((FramedataImpl1) this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
            } catch (RuntimeException e) {
                logRuntimeException(webSocketImpl, e);
            }
        } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
            ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
            ((FramedataImpl1) this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, this.currentContinuousFrame.getPayloadData());
            } catch (RuntimeException e6) {
                logRuntimeException(webSocketImpl, e6);
            }
        }
        this.currentContinuousFrame = null;
        clearBufferList();
    }

    private void processFrameIsNotFin(Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame != null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        }
        this.currentContinuousFrame = framedata;
        addToBufferList(framedata.getPayloadData());
        checkBufferLimit();
    }

    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        } catch (RuntimeException e) {
            logRuntimeException(webSocketImpl, e);
        }
    }

    private byte[] toByteArray(long j5, int i) {
        byte[] bArr = new byte[i];
        int i6 = (i * 8) - 8;
        for (int i10 = 0; i10 < i; i10++) {
            bArr[i10] = (byte) (j5 >>> (i6 - (i10 * 8)));
        }
        return bArr;
    }

    private Opcode toOpcode(byte b) throws InvalidFrameException {
        if (b == 0) {
            return Opcode.CONTINUOUS;
        }
        if (b == 1) {
            return Opcode.TEXT;
        }
        if (b == 2) {
            return Opcode.BINARY;
        }
        switch (b) {
            case 8:
                return Opcode.CLOSING;
            case 9:
                return Opcode.PING;
            case 10:
                return Opcode.PONG;
            default:
                throw new InvalidFrameException("Unknown opcode " + ((int) b));
        }
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        Draft_6455 draft_6455;
        ByteBuffer byteBuffer2;
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int iRemaining = byteBuffer.remaining();
        int realPackageSize = 2;
        translateSingleFrameCheckPacketSize(iRemaining, 2);
        byte b = byteBuffer.get();
        boolean z10 = (b >> 8) != 0;
        boolean z11 = (b & 64) != 0;
        boolean z12 = (b & 32) != 0;
        boolean z13 = (b & 16) != 0;
        byte b5 = byteBuffer.get();
        boolean z14 = (b5 & (-128)) != 0;
        int payloadLength = (byte) (b5 & 127);
        Opcode opcode = toOpcode((byte) (b & 15));
        if (payloadLength < 0 || payloadLength > 125) {
            draft_6455 = this;
            byteBuffer2 = byteBuffer;
            TranslatedPayloadMetaData translatedPayloadMetaDataTranslateSingleFramePayloadLength = draft_6455.translateSingleFramePayloadLength(byteBuffer2, opcode, payloadLength, iRemaining, 2);
            payloadLength = translatedPayloadMetaDataTranslateSingleFramePayloadLength.getPayloadLength();
            realPackageSize = translatedPayloadMetaDataTranslateSingleFramePayloadLength.getRealPackageSize();
        } else {
            draft_6455 = this;
            byteBuffer2 = byteBuffer;
        }
        draft_6455.translateSingleFrameCheckLengthLimit(payloadLength);
        draft_6455.translateSingleFrameCheckPacketSize(iRemaining, realPackageSize + (z14 ? 4 : 0) + payloadLength);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(draft_6455.checkAlloc(payloadLength));
        if (z14) {
            byte[] bArr = new byte[4];
            byteBuffer2.get(bArr);
            for (int i = 0; i < payloadLength; i++) {
                byteBufferAllocate.put((byte) (byteBuffer2.get() ^ bArr[i % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer2.array(), byteBuffer2.position(), byteBufferAllocate.limit());
            byteBuffer2.position(byteBufferAllocate.limit() + byteBuffer2.position());
        }
        FramedataImpl1 framedataImpl1 = FramedataImpl1.get(opcode);
        framedataImpl1.setFin(z10);
        framedataImpl1.setRSV1(z11);
        framedataImpl1.setRSV2(z12);
        framedataImpl1.setRSV3(z13);
        byteBufferAllocate.flip();
        framedataImpl1.setPayload(byteBufferAllocate);
        if (framedataImpl1.getOpcode() != Opcode.CONTINUOUS) {
            if (framedataImpl1.isRSV1() || framedataImpl1.isRSV2() || framedataImpl1.isRSV3()) {
                draft_6455.currentDecodingExtension = draft_6455.getExtension();
            } else {
                draft_6455.currentDecodingExtension = draft_6455.defaultExtension;
            }
        }
        if (draft_6455.currentDecodingExtension == null) {
            draft_6455.currentDecodingExtension = draft_6455.defaultExtension;
        }
        draft_6455.currentDecodingExtension.isFrameValid(framedataImpl1);
        draft_6455.currentDecodingExtension.decodeFrame(framedataImpl1);
        if (draft_6455.log.isTraceEnabled()) {
            draft_6455.log.b(Integer.valueOf(framedataImpl1.getPayloadData().remaining()), "afterDecoding({}): {}", framedataImpl1.getPayloadData().remaining() > 1000 ? "too big to display" : new String(framedataImpl1.getPayloadData().array()));
        }
        framedataImpl1.isValid();
        return framedataImpl1;
    }

    private void translateSingleFrameCheckLengthLimit(long j5) throws LimitExceededException {
        if (j5 > SieveCacheKt.NodeLinkMask) {
            this.log.trace("Limit exedeed: Payloadsize is to big...");
            throw new LimitExceededException("Payloadsize is to big...");
        }
        int i = this.maxFrameSize;
        if (j5 > i) {
            this.log.b(Integer.valueOf(i), "Payload limit reached. Allowed: {} Current: {}", Long.valueOf(j5));
            throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
        }
        if (j5 >= 0) {
            return;
        }
        this.log.trace("Limit underflow: Payloadsize is to little...");
        throw new LimitExceededException("Payloadsize is to little...");
    }

    private void translateSingleFrameCheckPacketSize(int i, int i6) throws IncompleteException {
        if (i >= i6) {
            return;
        }
        this.log.trace("Incomplete frame: maxpacketsize < realpacketsize");
        throw new IncompleteException(i6);
    }

    private TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int i, int i6, int i10) throws IncompleteException, LimitExceededException, InvalidFrameException {
        int i11;
        int iIntValue;
        if (opcode == Opcode.PING || opcode == Opcode.PONG || opcode == Opcode.CLOSING) {
            this.log.trace("Invalid frame: more than 125 octets");
            throw new InvalidFrameException("more than 125 octets");
        }
        if (i == 126) {
            i11 = i10 + 2;
            translateSingleFrameCheckPacketSize(i6, i11);
            iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
        } else {
            i11 = i10 + 8;
            translateSingleFrameCheckPacketSize(i6, i11);
            byte[] bArr = new byte[8];
            for (int i12 = 0; i12 < 8; i12++) {
                bArr[i12] = byteBuffer.get();
            }
            long jLongValue = new BigInteger(bArr).longValue();
            translateSingleFrameCheckLengthLimit(jLongValue);
            iIntValue = (int) jLongValue;
        }
        return new TranslatedPayloadMetaData(iIntValue, i11);
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!basicAccept(serverHandshake)) {
            this.log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        if (!clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) || !serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            this.log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
        if (!generateFinalKey(clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY)).equals(serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT))) {
            this.log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String fieldValue = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Iterator<IExtension> it = this.knownExtensions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension next = it.next();
            if (next.acceptProvidedExtensionAsClient(fieldValue)) {
                this.negotiatedExtension = next;
                handshakeState = HandshakeState.MATCHED;
                this.log.g(next, "acceptHandshakeAsClient - Matching extension found: {}");
                break;
            }
        }
        HandshakeState handshakeStateContainsRequestedProtocol = containsRequestedProtocol(serverHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (handshakeStateContainsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (readVersion(clientHandshake) != 13) {
            this.log.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Iterator<IExtension> it = this.knownExtensions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension next = it.next();
            if (next.acceptProvidedExtensionAsServer(fieldValue)) {
                this.negotiatedExtension = next;
                handshakeState = HandshakeState.MATCHED;
                this.log.g(next, "acceptHandshakeAsServer - Matching extension found: {}");
                break;
            }
        }
        HandshakeState handshakeStateContainsRequestedProtocol = containsRequestedProtocol(clientHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (handshakeStateContainsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft copyInstance() {
        ArrayList arrayList = new ArrayList();
        Iterator<IExtension> it = getKnownExtensions().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<IProtocol> it2 = getKnownProtocols().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        getExtension().encodeFrame(framedata);
        if (this.log.isTraceEnabled()) {
            this.log.b(Integer.valueOf(framedata.getPayloadData().remaining()), "afterEnconding({}): {}", framedata.getPayloadData().remaining() > 1000 ? "too big to display" : new String(framedata.getPayloadData().array()));
        }
        return createByteBufferFromFramedata(framedata);
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z10) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(z10);
        try {
            binaryFrame.isValid();
            return Collections.singletonList(binaryFrame);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Draft_6455 draft_6455 = (Draft_6455) obj;
            if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
                return false;
            }
            IExtension iExtension = this.negotiatedExtension;
            if (iExtension == null ? draft_6455.getExtension() != null : !iExtension.equals(draft_6455.getExtension())) {
                return false;
            }
            IProtocol iProtocol = this.protocol;
            if (iProtocol != null) {
                return iProtocol.equals(draft_6455.getProtocol());
            }
            if (draft_6455.getProtocol() == null) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.drafts.Draft
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    public IExtension getExtension() {
        return this.negotiatedExtension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public IProtocol getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        IExtension iExtension = this.negotiatedExtension;
        int iHashCode = (iExtension != null ? iExtension.hashCode() : 0) * 31;
        IProtocol iProtocol = this.protocol;
        int iHashCode2 = iProtocol != null ? iProtocol.hashCode() : 0;
        int i = this.maxFrameSize;
        return ((iHashCode + iHashCode2) * 31) + (i ^ (i >>> 32));
    }

    @Override // org.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(UPGRADE, "websocket");
        clientHandshakeBuilder.put(CONNECTION, UPGRADE);
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(bArr));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (IExtension iExtension : this.knownExtensions) {
            if (iExtension.getProvidedExtensionAsClient() != null && iExtension.getProvidedExtensionAsClient().length() != 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(iExtension.getProvidedExtensionAsClient());
            }
        }
        if (sb.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(iProtocol.getProvidedProtocol());
            }
        }
        if (sb2.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, sb2.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put(UPGRADE, "websocket");
        serverHandshakeBuilder.put(CONNECTION, clientHandshake.getFieldValue(CONNECTION));
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (fieldValue == null || "".equals(fieldValue)) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, generateFinalKey(fieldValue));
        if (getExtension().getProvidedExtensionAsServer().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, getExtension().getProvidedExtensionAsServer());
        }
        if (getProtocol() != null && getProtocol().getProvidedProtocol().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, getProtocol().getProvidedProtocol());
        }
        serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
        serverHandshakeBuilder.put("Date", getServerTime());
        return serverHandshakeBuilder;
    }

    @Override // org.java_websocket.drafts.Draft
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            processFrameClosing(webSocketImpl, framedata);
            return;
        }
        if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
            return;
        }
        if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
            return;
        }
        if (!framedata.isFin() || opcode == Opcode.CONTINUOUS) {
            processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
            return;
        }
        if (this.currentContinuousFrame != null) {
            this.log.error("Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        }
        if (opcode == Opcode.TEXT) {
            processFrameText(webSocketImpl, framedata);
        } else if (opcode == Opcode.BINARY) {
            processFrameBinary(webSocketImpl, framedata);
        } else {
            this.log.error("non control or continious frame expected");
            throw new InvalidDataException(1002, "non control or continious frame expected");
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
        IExtension iExtension = this.negotiatedExtension;
        if (iExtension != null) {
            iExtension.reset();
        }
        this.negotiatedExtension = new DefaultExtension();
        this.protocol = null;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String string = super.toString();
        if (getExtension() != null) {
            StringBuilder sbX = a.x(string, " extension: ");
            sbX.append(getExtension().toString());
            string = sbX.toString();
        }
        if (getProtocol() != null) {
            StringBuilder sbX2 = a.x(string, " protocol: ");
            sbX2.append(getProtocol().toString());
            string = sbX2.toString();
        }
        StringBuilder sbX3 = a.x(string, " max frame size: ");
        sbX3.append(this.maxFrameSize);
        return sbX3.toString();
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.incompleteframe == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.incompleteframe.remaining();
                if (iRemaining2 > iRemaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                    byteBuffer.position(byteBuffer.position() + iRemaining);
                    return Collections.EMPTY_LIST;
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                byteBuffer.position(byteBuffer.position() + iRemaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(checkAlloc(e.getPreferredSize()));
                this.incompleteframe.rewind();
                byteBufferAllocate.put(this.incompleteframe);
                this.incompleteframe = byteBufferAllocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e6) {
                byteBuffer.reset();
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(checkAlloc(e6.getPreferredSize()));
                this.incompleteframe = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Draft_6455(IExtension iExtension) {
        this((List<IExtension>) Collections.singletonList(iExtension));
    }

    public Draft_6455(List<IExtension> list) {
        this(list, (List<IProtocol>) Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List<IExtension> list, int i) {
        this(list, Collections.singletonList(new Protocol("")), i);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int i) {
        this.log = AbstractC0317d.b(Draft_6455.class);
        this.negotiatedExtension = new DefaultExtension();
        this.defaultExtension = new DefaultExtension();
        this.reuseableRandom = new SecureRandom();
        if (list != null && list2 != null && i >= 1) {
            this.knownExtensions = new ArrayList(list.size());
            this.knownProtocols = new ArrayList(list2.size());
            this.byteBufferList = new ArrayList();
            Iterator<IExtension> it = list.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (it.next().getClass().equals(DefaultExtension.class)) {
                    z10 = true;
                }
            }
            this.knownExtensions.addAll(list);
            if (!z10) {
                List<IExtension> list3 = this.knownExtensions;
                list3.add(list3.size(), this.negotiatedExtension);
            }
            this.knownProtocols.addAll(list2);
            this.maxFrameSize = i;
            this.currentDecodingExtension = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z10) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
        textFrame.setTransferemasked(z10);
        try {
            textFrame.isValid();
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e) {
            throw new NotSendableException(e);
        }
    }
}
