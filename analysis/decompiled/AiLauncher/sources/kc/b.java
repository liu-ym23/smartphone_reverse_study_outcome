package kc;

import com.amap.api.services.core.AMapException;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
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
import lc.C4885a;
import lc.InterfaceC4886b;
import mc.f;
import mc.g;
import nc.h;
import nc.i;
import org.java_websocket.d;
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
import vc.c;

/* loaded from: classes5.dex */
public class b extends AbstractC4846a {

    /* renamed from: c, reason: collision with root package name */
    public final c f34672c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC4886b f34673d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC4886b f34674e;

    /* renamed from: f, reason: collision with root package name */
    public List<InterfaceC4886b> f34675f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC4886b f34676g;

    /* renamed from: h, reason: collision with root package name */
    public oc.a f34677h;

    /* renamed from: i, reason: collision with root package name */
    public List<oc.a> f34678i;

    /* renamed from: j, reason: collision with root package name */
    public f f34679j;

    /* renamed from: k, reason: collision with root package name */
    public final List<ByteBuffer> f34680k;

    /* renamed from: l, reason: collision with root package name */
    public ByteBuffer f34681l;

    /* renamed from: m, reason: collision with root package name */
    public final SecureRandom f34682m;

    /* renamed from: n, reason: collision with root package name */
    public int f34683n;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f34684a;

        /* renamed from: b, reason: collision with root package name */
        public int f34685b;

        public a(int i10, int i11) {
            this.f34684a = i10;
            this.f34685b = i11;
        }

        public final int c() {
            return this.f34684a;
        }

        public final int d() {
            return this.f34685b;
        }
    }

    public b() {
        this(Collections.EMPTY_LIST);
    }

    public final HandshakeState A(String str) {
        for (oc.a aVar : this.f34678i) {
            if (aVar.b(str)) {
                this.f34677h = aVar;
                this.f34672c.m("acceptHandshake - Matching protocol found: {}", aVar);
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    public final ByteBuffer B(f fVar) {
        ByteBuffer byteBufferF = fVar.f();
        int i10 = 0;
        boolean z10 = this.f34670a == Role.CLIENT;
        int iO = O(byteBufferF);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((iO > 1 ? iO + 1 : iO) + 1 + (z10 ? 4 : 0) + byteBufferF.remaining());
        byte bC = (byte) (C(fVar.c()) | ((byte) (fVar.e() ? -128 : 0)));
        if (fVar.a()) {
            bC = (byte) (bC | M(1));
        }
        if (fVar.b()) {
            bC = (byte) (bC | M(2));
        }
        if (fVar.d()) {
            bC = (byte) (M(3) | bC);
        }
        byteBufferAllocate.put(bC);
        byte[] bArrW = W(byteBufferF.remaining(), iO);
        if (iO == 1) {
            byteBufferAllocate.put((byte) (bArrW[0] | I(z10)));
        } else if (iO == 2) {
            byteBufferAllocate.put((byte) (I(z10) | 126));
            byteBufferAllocate.put(bArrW);
        } else {
            if (iO != 8) {
                throw new IllegalStateException("Size representation not supported/specified");
            }
            byteBufferAllocate.put((byte) (I(z10) | 127));
            byteBufferAllocate.put(bArrW);
        }
        if (z10) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
            byteBufferAllocate2.putInt(this.f34682m.nextInt());
            byteBufferAllocate.put(byteBufferAllocate2.array());
            while (byteBufferF.hasRemaining()) {
                byteBufferAllocate.put((byte) (byteBufferF.get() ^ byteBufferAllocate2.get(i10 % 4)));
                i10++;
            }
        } else {
            byteBufferAllocate.put(byteBufferF);
            byteBufferF.flip();
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public final byte C(Opcode opcode) {
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

    public final String D(String str) throws NoSuchAlgorithmException {
        try {
            return pc.a.g(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final long E() {
        long jLimit;
        synchronized (this.f34680k) {
            try {
                jLimit = 0;
                while (this.f34680k.iterator().hasNext()) {
                    jLimit += r5.next().limit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jLimit;
    }

    public InterfaceC4886b F() {
        return this.f34673d;
    }

    public List<InterfaceC4886b> G() {
        return this.f34675f;
    }

    public List<oc.a> H() {
        return this.f34678i;
    }

    public final byte I(boolean z10) {
        return z10 ? (byte) -128 : (byte) 0;
    }

    public int J() {
        return this.f34683n;
    }

    public final ByteBuffer K() throws LimitExceededException {
        ByteBuffer byteBufferAllocate;
        synchronized (this.f34680k) {
            try {
                long jLimit = 0;
                while (this.f34680k.iterator().hasNext()) {
                    jLimit += r1.next().limit();
                }
                y();
                byteBufferAllocate = ByteBuffer.allocate((int) jLimit);
                Iterator<ByteBuffer> it = this.f34680k.iterator();
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

    public oc.a L() {
        return this.f34677h;
    }

    public final byte M(int i10) {
        if (i10 == 1) {
            return (byte) 64;
        }
        if (i10 != 2) {
            return i10 != 3 ? (byte) 0 : (byte) 16;
        }
        return (byte) 32;
    }

    public final String N() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    public final int O(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    public final void P(d dVar, RuntimeException runtimeException) {
        this.f34672c.error("Runtime exception during onWebsocketMessage", runtimeException);
        dVar.s().l(dVar, runtimeException);
    }

    public final void Q(d dVar, f fVar) {
        try {
            dVar.s().c(dVar, fVar.f());
        } catch (RuntimeException e10) {
            P(dVar, e10);
        }
    }

    public final void R(d dVar, f fVar) {
        int iO;
        String strP;
        if (fVar instanceof mc.b) {
            mc.b bVar = (mc.b) fVar;
            iO = bVar.o();
            strP = bVar.p();
        } else {
            iO = 1005;
            strP = "";
        }
        if (dVar.r() == ReadyState.CLOSING) {
            dVar.f(iO, strP, true);
        } else if (j() == CloseHandshakeType.TWOWAY) {
            dVar.c(iO, strP, true);
        } else {
            dVar.o(iO, strP, false);
        }
    }

    public final void S(d dVar, f fVar, Opcode opcode) throws InvalidDataException {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            U(fVar);
        } else if (fVar.e()) {
            T(dVar, fVar);
        } else if (this.f34679j == null) {
            this.f34672c.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !pc.c.b(fVar.f())) {
            this.f34672c.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(AMapException.CODE_AMAP_INVALID_USER_DOMAIN);
        }
        if (opcode != opcode2 || this.f34679j == null) {
            return;
        }
        x(fVar.f());
    }

    public final void T(d dVar, f fVar) throws InvalidDataException {
        if (this.f34679j == null) {
            this.f34672c.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        x(fVar.f());
        y();
        if (this.f34679j.c() == Opcode.TEXT) {
            ((g) this.f34679j).j(K());
            ((g) this.f34679j).h();
            try {
                dVar.s().m(dVar, pc.c.e(this.f34679j.f()));
            } catch (RuntimeException e10) {
                P(dVar, e10);
            }
        } else if (this.f34679j.c() == Opcode.BINARY) {
            ((g) this.f34679j).j(K());
            ((g) this.f34679j).h();
            try {
                dVar.s().c(dVar, this.f34679j.f());
            } catch (RuntimeException e11) {
                P(dVar, e11);
            }
        }
        this.f34679j = null;
        z();
    }

    public final void U(f fVar) throws InvalidDataException {
        if (this.f34679j != null) {
            this.f34672c.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        }
        this.f34679j = fVar;
        x(fVar.f());
        y();
    }

    public final void V(d dVar, f fVar) throws InvalidDataException {
        try {
            dVar.s().m(dVar, pc.c.e(fVar.f()));
        } catch (RuntimeException e10) {
            P(dVar, e10);
        }
    }

    public final byte[] W(long j10, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = (i10 * 8) - 8;
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) (j10 >>> (i11 - (i12 * 8)));
        }
        return bArr;
    }

    public final Opcode X(byte b10) throws InvalidFrameException {
        if (b10 == 0) {
            return Opcode.CONTINUOUS;
        }
        if (b10 == 1) {
            return Opcode.TEXT;
        }
        if (b10 == 2) {
            return Opcode.BINARY;
        }
        switch (b10) {
            case 8:
                return Opcode.CLOSING;
            case 9:
                return Opcode.PING;
            case 10:
                return Opcode.PONG;
            default:
                throw new InvalidFrameException("Unknown opcode " + ((int) b10));
        }
    }

    public final f Y(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        b bVar;
        ByteBuffer byteBuffer2;
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int iRemaining = byteBuffer.remaining();
        int iD = 2;
        a0(iRemaining, 2);
        byte b10 = byteBuffer.get();
        boolean z10 = (b10 >> 8) != 0;
        boolean z11 = (b10 & 64) != 0;
        boolean z12 = (b10 & 32) != 0;
        boolean z13 = (b10 & 16) != 0;
        byte b11 = byteBuffer.get();
        boolean z14 = (b11 & (-128)) != 0;
        int iC = (byte) (b11 & 127);
        Opcode opcodeX = X((byte) (b10 & 15));
        if (iC < 0 || iC > 125) {
            bVar = this;
            byteBuffer2 = byteBuffer;
            a aVarB0 = bVar.b0(byteBuffer2, opcodeX, iC, iRemaining, 2);
            iC = aVarB0.c();
            iD = aVarB0.d();
        } else {
            bVar = this;
            byteBuffer2 = byteBuffer;
        }
        bVar.Z(iC);
        bVar.a0(iRemaining, iD + (z14 ? 4 : 0) + iC);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bVar.d(iC));
        if (z14) {
            byte[] bArr = new byte[4];
            byteBuffer2.get(bArr);
            for (int i10 = 0; i10 < iC; i10++) {
                byteBufferAllocate.put((byte) (byteBuffer2.get() ^ bArr[i10 % 4]));
            }
        } else {
            byteBufferAllocate.put(byteBuffer2.array(), byteBuffer2.position(), byteBufferAllocate.limit());
            byteBuffer2.position(byteBuffer2.position() + byteBufferAllocate.limit());
        }
        g gVarG = g.g(opcodeX);
        gVarG.i(z10);
        gVarG.k(z11);
        gVarG.l(z12);
        gVarG.m(z13);
        byteBufferAllocate.flip();
        gVarG.j(byteBufferAllocate);
        if (gVarG.c() != Opcode.CONTINUOUS) {
            if (gVarG.a() || gVarG.b() || gVarG.d()) {
                bVar.f34676g = bVar.F();
            } else {
                bVar.f34676g = bVar.f34674e;
            }
        }
        if (bVar.f34676g == null) {
            bVar.f34676g = bVar.f34674e;
        }
        bVar.f34676g.g(gVarG);
        bVar.f34676g.c(gVarG);
        if (bVar.f34672c.isTraceEnabled()) {
            bVar.f34672c.b("afterDecoding({}): {}", Integer.valueOf(gVarG.f().remaining()), gVarG.f().remaining() > 1000 ? "too big to display" : new String(gVarG.f().array()));
        }
        gVarG.h();
        return gVarG;
    }

    public final void Z(long j10) throws LimitExceededException {
        if (j10 > 2147483647L) {
            this.f34672c.trace("Limit exedeed: Payloadsize is to big...");
            throw new LimitExceededException("Payloadsize is to big...");
        }
        int i10 = this.f34683n;
        if (j10 > i10) {
            this.f34672c.b("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i10), Long.valueOf(j10));
            throw new LimitExceededException("Payload limit reached.", this.f34683n);
        }
        if (j10 >= 0) {
            return;
        }
        this.f34672c.trace("Limit underflow: Payloadsize is to little...");
        throw new LimitExceededException("Payloadsize is to little...");
    }

    @Override // kc.AbstractC4846a
    public HandshakeState a(nc.a aVar, h hVar) throws InvalidHandshakeException {
        if (!c(hVar)) {
            this.f34672c.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        if (!aVar.c("Sec-WebSocket-Key") || !hVar.c("Sec-WebSocket-Accept")) {
            this.f34672c.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
        if (!D(aVar.i("Sec-WebSocket-Key")).equals(hVar.i("Sec-WebSocket-Accept"))) {
            this.f34672c.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String strI = hVar.i("Sec-WebSocket-Extensions");
        Iterator<InterfaceC4886b> it = this.f34675f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InterfaceC4886b next = it.next();
            if (next.e(strI)) {
                this.f34673d = next;
                handshakeState = HandshakeState.MATCHED;
                this.f34672c.m("acceptHandshakeAsClient - Matching extension found: {}", next);
                break;
            }
        }
        HandshakeState handshakeStateA = A(hVar.i("Sec-WebSocket-Protocol"));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (handshakeStateA == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.f34672c.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public final void a0(int i10, int i11) throws IncompleteException {
        if (i10 >= i11) {
            return;
        }
        this.f34672c.trace("Incomplete frame: maxpacketsize < realpacketsize");
        throw new IncompleteException(i11);
    }

    @Override // kc.AbstractC4846a
    public HandshakeState b(nc.a aVar) throws InvalidHandshakeException {
        if (p(aVar) != 13) {
            this.f34672c.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String strI = aVar.i("Sec-WebSocket-Extensions");
        Iterator<InterfaceC4886b> it = this.f34675f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InterfaceC4886b next = it.next();
            if (next.b(strI)) {
                this.f34673d = next;
                handshakeState = HandshakeState.MATCHED;
                this.f34672c.m("acceptHandshakeAsServer - Matching extension found: {}", next);
                break;
            }
        }
        HandshakeState handshakeStateA = A(aVar.i("Sec-WebSocket-Protocol"));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (handshakeStateA == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.f34672c.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public final a b0(ByteBuffer byteBuffer, Opcode opcode, int i10, int i11, int i12) throws IncompleteException, LimitExceededException, InvalidFrameException {
        int i13;
        int iIntValue;
        if (opcode == Opcode.PING || opcode == Opcode.PONG || opcode == Opcode.CLOSING) {
            this.f34672c.trace("Invalid frame: more than 125 octets");
            throw new InvalidFrameException("more than 125 octets");
        }
        if (i10 == 126) {
            i13 = i12 + 2;
            a0(i11, i13);
            iIntValue = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
        } else {
            i13 = i12 + 8;
            a0(i11, i13);
            byte[] bArr = new byte[8];
            for (int i14 = 0; i14 < 8; i14++) {
                bArr[i14] = byteBuffer.get();
            }
            long jLongValue = new BigInteger(bArr).longValue();
            Z(jLongValue);
            iIntValue = (int) jLongValue;
        }
        return new a(iIntValue, i13);
    }

    @Override // kc.AbstractC4846a
    public AbstractC4846a e() {
        ArrayList arrayList = new ArrayList();
        Iterator<InterfaceC4886b> it = G().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<oc.a> it2 = H().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().a());
        }
        return new b(arrayList, arrayList2, this.f34683n);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f34683n != bVar.J()) {
                return false;
            }
            InterfaceC4886b interfaceC4886b = this.f34673d;
            if (interfaceC4886b == null ? bVar.F() != null : !interfaceC4886b.equals(bVar.F())) {
                return false;
            }
            oc.a aVar = this.f34677h;
            if (aVar != null) {
                return aVar.equals(bVar.L());
            }
            if (bVar.L() == null) {
                return true;
            }
        }
        return false;
    }

    @Override // kc.AbstractC4846a
    public ByteBuffer f(f fVar) {
        F().f(fVar);
        if (this.f34672c.isTraceEnabled()) {
            this.f34672c.b("afterEnconding({}): {}", Integer.valueOf(fVar.f().remaining()), fVar.f().remaining() > 1000 ? "too big to display" : new String(fVar.f().array()));
        }
        return B(fVar);
    }

    @Override // kc.AbstractC4846a
    public List<f> g(ByteBuffer byteBuffer, boolean z10) {
        mc.a aVar = new mc.a();
        aVar.j(byteBuffer);
        aVar.n(z10);
        try {
            aVar.h();
            return Collections.singletonList(aVar);
        } catch (InvalidDataException e10) {
            throw new NotSendableException(e10);
        }
    }

    public int hashCode() {
        InterfaceC4886b interfaceC4886b = this.f34673d;
        int iHashCode = (interfaceC4886b != null ? interfaceC4886b.hashCode() : 0) * 31;
        oc.a aVar = this.f34677h;
        int iHashCode2 = aVar != null ? aVar.hashCode() : 0;
        int i10 = this.f34683n;
        return ((iHashCode + iHashCode2) * 31) + (i10 ^ (i10 >>> 32));
    }

    @Override // kc.AbstractC4846a
    public CloseHandshakeType j() {
        return CloseHandshakeType.TWOWAY;
    }

    @Override // kc.AbstractC4846a
    public nc.b k(nc.b bVar) {
        bVar.a("Upgrade", "websocket");
        bVar.a(e.f30851j, "Upgrade");
        byte[] bArr = new byte[16];
        this.f34682m.nextBytes(bArr);
        bVar.a("Sec-WebSocket-Key", pc.a.g(bArr));
        bVar.a("Sec-WebSocket-Version", "13");
        StringBuilder sb2 = new StringBuilder();
        for (InterfaceC4886b interfaceC4886b : this.f34675f) {
            if (interfaceC4886b.d() != null && interfaceC4886b.d().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(interfaceC4886b.d());
            }
        }
        if (sb2.length() != 0) {
            bVar.a("Sec-WebSocket-Extensions", sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        for (oc.a aVar : this.f34678i) {
            if (aVar.c().length() != 0) {
                if (sb3.length() > 0) {
                    sb3.append(", ");
                }
                sb3.append(aVar.c());
            }
        }
        if (sb3.length() != 0) {
            bVar.a("Sec-WebSocket-Protocol", sb3.toString());
        }
        return bVar;
    }

    @Override // kc.AbstractC4846a
    public nc.c l(nc.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a("Upgrade", "websocket");
        iVar.a(e.f30851j, aVar.i(e.f30851j));
        String strI = aVar.i("Sec-WebSocket-Key");
        if (strI == null || "".equals(strI)) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        iVar.a("Sec-WebSocket-Accept", D(strI));
        if (F().h().length() != 0) {
            iVar.a("Sec-WebSocket-Extensions", F().h());
        }
        if (L() != null && L().c().length() != 0) {
            iVar.a("Sec-WebSocket-Protocol", L().c());
        }
        iVar.h("Web Socket Protocol Handshake");
        iVar.a(e.f30855n, "TooTallNate Java-WebSocket");
        iVar.a(e.f30854m, N());
        return iVar;
    }

    @Override // kc.AbstractC4846a
    public void m(d dVar, f fVar) throws InvalidDataException {
        Opcode opcodeC = fVar.c();
        if (opcodeC == Opcode.CLOSING) {
            R(dVar, fVar);
            return;
        }
        if (opcodeC == Opcode.PING) {
            dVar.s().h(dVar, fVar);
            return;
        }
        if (opcodeC == Opcode.PONG) {
            dVar.C();
            dVar.s().a(dVar, fVar);
            return;
        }
        if (!fVar.e() || opcodeC == Opcode.CONTINUOUS) {
            S(dVar, fVar, opcodeC);
            return;
        }
        if (this.f34679j != null) {
            this.f34672c.error("Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        }
        if (opcodeC == Opcode.TEXT) {
            V(dVar, fVar);
        } else if (opcodeC == Opcode.BINARY) {
            Q(dVar, fVar);
        } else {
            this.f34672c.error("non control or continious frame expected");
            throw new InvalidDataException(1002, "non control or continious frame expected");
        }
    }

    @Override // kc.AbstractC4846a
    public void q() {
        this.f34681l = null;
        InterfaceC4886b interfaceC4886b = this.f34673d;
        if (interfaceC4886b != null) {
            interfaceC4886b.reset();
        }
        this.f34673d = new C4885a();
        this.f34677h = null;
    }

    @Override // kc.AbstractC4846a
    public List<f> s(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.f34681l == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int iRemaining = byteBuffer.remaining();
                int iRemaining2 = this.f34681l.remaining();
                if (iRemaining2 > iRemaining) {
                    this.f34681l.put(byteBuffer.array(), byteBuffer.position(), iRemaining);
                    byteBuffer.position(byteBuffer.position() + iRemaining);
                    return Collections.EMPTY_LIST;
                }
                this.f34681l.put(byteBuffer.array(), byteBuffer.position(), iRemaining2);
                byteBuffer.position(byteBuffer.position() + iRemaining2);
                linkedList.add(Y((ByteBuffer) this.f34681l.duplicate().position(0)));
                this.f34681l = null;
            } catch (IncompleteException e10) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(d(e10.a()));
                this.f34681l.rewind();
                byteBufferAllocate.put(this.f34681l);
                this.f34681l = byteBufferAllocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(Y(byteBuffer));
            } catch (IncompleteException e11) {
                byteBuffer.reset();
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(d(e11.a()));
                this.f34681l = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    @Override // kc.AbstractC4846a
    public String toString() {
        String string = super.toString();
        if (F() != null) {
            string = string + " extension: " + F().toString();
        }
        if (L() != null) {
            string = string + " protocol: " + L().toString();
        }
        return string + " max frame size: " + this.f34683n;
    }

    public final void x(ByteBuffer byteBuffer) {
        synchronized (this.f34680k) {
            this.f34680k.add(byteBuffer);
        }
    }

    public final void y() throws LimitExceededException {
        long jE = E();
        if (jE <= this.f34683n) {
            return;
        }
        z();
        this.f34672c.b("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.f34683n), Long.valueOf(jE));
        throw new LimitExceededException(this.f34683n);
    }

    public final void z() {
        synchronized (this.f34680k) {
            this.f34680k.clear();
        }
    }

    public b(List<InterfaceC4886b> list) {
        this(list, Collections.singletonList(new oc.b("")));
    }

    public b(List<InterfaceC4886b> list, List<oc.a> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public b(List<InterfaceC4886b> list, List<oc.a> list2, int i10) {
        this.f34672c = vc.e.l(b.class);
        this.f34673d = new C4885a();
        this.f34674e = new C4885a();
        this.f34682m = new SecureRandom();
        if (list != null && list2 != null && i10 >= 1) {
            this.f34675f = new ArrayList(list.size());
            this.f34678i = new ArrayList(list2.size());
            this.f34680k = new ArrayList();
            Iterator<InterfaceC4886b> it = list.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (it.next().getClass().equals(C4885a.class)) {
                    z10 = true;
                }
            }
            this.f34675f.addAll(list);
            if (!z10) {
                List<InterfaceC4886b> list3 = this.f34675f;
                list3.add(list3.size(), this.f34673d);
            }
            this.f34678i.addAll(list2);
            this.f34683n = i10;
            this.f34676g = null;
            return;
        }
        throw new IllegalArgumentException();
    }
}
