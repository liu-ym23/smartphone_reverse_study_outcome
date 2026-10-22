package kc;

import io.ktor.sse.ServerSentEventKt;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import nc.d;
import nc.e;
import nc.f;
import nc.h;
import nc.i;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import pc.c;

/* renamed from: kc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4846a {

    /* renamed from: a, reason: collision with root package name */
    public Role f34670a = null;

    /* renamed from: b, reason: collision with root package name */
    public Opcode f34671b = null;

    public static ByteBuffer n(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b10 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b11 = byteBuffer.get();
            byteBufferAllocate.put(b11);
            if (b10 == 13 && b11 == 10) {
                byteBufferAllocate.limit(byteBufferAllocate.position() - 2);
                byteBufferAllocate.position(0);
                return byteBufferAllocate;
            }
            b10 = b11;
        }
        byteBuffer.position(byteBuffer.position() - byteBufferAllocate.position());
        return null;
    }

    public static String o(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferN = n(byteBuffer);
        if (byteBufferN == null) {
            return null;
        }
        return c.d(byteBufferN.array(), 0, byteBufferN.limit());
    }

    public static nc.c u(ByteBuffer byteBuffer, Role role) throws InvalidHandshakeException {
        String strO = o(byteBuffer);
        if (strO == null) {
            throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
        }
        String[] strArrSplit = strO.split(" ", 3);
        if (strArrSplit.length != 3) {
            throw new InvalidHandshakeException();
        }
        nc.c cVarV = role == Role.CLIENT ? v(strArrSplit, strO) : w(strArrSplit, strO);
        String strO2 = o(byteBuffer);
        while (strO2 != null && strO2.length() > 0) {
            String[] strArrSplit2 = strO2.split(ServerSentEventKt.COLON, 2);
            if (strArrSplit2.length != 2) {
                throw new InvalidHandshakeException("not an http header");
            }
            if (cVarV.c(strArrSplit2[0])) {
                cVarV.a(strArrSplit2[0], cVarV.i(strArrSplit2[0]) + "; " + strArrSplit2[1].replaceFirst("^ +", ""));
            } else {
                cVarV.a(strArrSplit2[0], strArrSplit2[1].replaceFirst("^ +", ""));
            }
            strO2 = o(byteBuffer);
        }
        if (strO2 != null) {
            return cVarV;
        }
        throw new IncompleteHandshakeException();
    }

    public static nc.c v(String[] strArr, String str) throws InvalidHandshakeException {
        if (!"101".equals(strArr[1])) {
            throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[0])) {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
        e eVar = new e();
        eVar.f(Short.parseShort(strArr[1]));
        eVar.h(strArr[2]);
        return eVar;
    }

    public static nc.c w(String[] strArr, String str) throws InvalidHandshakeException {
        if (!"GET".equalsIgnoreCase(strArr[0])) {
            throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(strArr[2])) {
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
        d dVar = new d();
        dVar.g(strArr[1]);
        return dVar;
    }

    public abstract HandshakeState a(nc.a aVar, h hVar) throws InvalidHandshakeException;

    public abstract HandshakeState b(nc.a aVar) throws InvalidHandshakeException;

    public boolean c(f fVar) {
        return fVar.i("Upgrade").equalsIgnoreCase("websocket") && fVar.i(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j).toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public int d(int i10) throws InvalidDataException {
        if (i10 >= 0) {
            return i10;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public abstract AbstractC4846a e();

    public abstract ByteBuffer f(mc.f fVar);

    public abstract List<mc.f> g(ByteBuffer byteBuffer, boolean z10);

    public List<ByteBuffer> h(f fVar) {
        return i(fVar, true);
    }

    public List<ByteBuffer> i(f fVar, boolean z10) {
        StringBuilder sb2 = new StringBuilder(100);
        if (fVar instanceof nc.a) {
            sb2.append("GET ");
            sb2.append(((nc.a) fVar).d());
            sb2.append(" HTTP/1.1");
        } else {
            if (!(fVar instanceof h)) {
                throw new IllegalArgumentException("unknown role");
            }
            sb2.append("HTTP/1.1 101 ");
            sb2.append(((h) fVar).b());
        }
        sb2.append(ServerSentEventKt.END_OF_LINE);
        Iterator<String> itE = fVar.e();
        while (itE.hasNext()) {
            String next = itE.next();
            String strI = fVar.i(next);
            sb2.append(next);
            sb2.append(": ");
            sb2.append(strI);
            sb2.append(ServerSentEventKt.END_OF_LINE);
        }
        sb2.append(ServerSentEventKt.END_OF_LINE);
        byte[] bArrA = c.a(sb2.toString());
        byte[] content = z10 ? fVar.getContent() : null;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((content == null ? 0 : content.length) + bArrA.length);
        byteBufferAllocate.put(bArrA);
        if (content != null) {
            byteBufferAllocate.put(content);
        }
        byteBufferAllocate.flip();
        return Collections.singletonList(byteBufferAllocate);
    }

    public abstract CloseHandshakeType j();

    public abstract nc.b k(nc.b bVar) throws InvalidHandshakeException;

    public abstract nc.c l(nc.a aVar, i iVar) throws InvalidHandshakeException;

    public abstract void m(org.java_websocket.d dVar, mc.f fVar) throws InvalidDataException;

    public int p(f fVar) {
        String strI = fVar.i("Sec-WebSocket-Version");
        if (strI.length() > 0) {
            try {
                return Integer.parseInt(strI.trim());
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void q();

    public void r(Role role) {
        this.f34670a = role;
    }

    public abstract List<mc.f> s(ByteBuffer byteBuffer) throws InvalidDataException;

    public f t(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return u(byteBuffer, this.f34670a);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
