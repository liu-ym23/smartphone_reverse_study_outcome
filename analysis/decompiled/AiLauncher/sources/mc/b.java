package mc;

import com.amap.api.services.core.AMapException;
import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

/* loaded from: classes5.dex */
public class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public int f37210h;

    /* renamed from: i, reason: collision with root package name */
    public String f37211i;

    public b() {
        super(Opcode.CLOSING);
        r("");
        q(1000);
    }

    @Override // mc.g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f37210h != bVar.f37210h) {
            return false;
        }
        String str = this.f37211i;
        return str != null ? str.equals(bVar.f37211i) : bVar.f37211i == null;
    }

    @Override // mc.g, mc.f
    public ByteBuffer f() {
        return this.f37210h == 1005 ? pc.b.a() : super.f();
    }

    @Override // mc.d, mc.g
    public void h() throws InvalidDataException {
        super.h();
        if (this.f37210h == 1007 && this.f37211i.isEmpty()) {
            throw new InvalidDataException(AMapException.CODE_AMAP_INVALID_USER_DOMAIN, "Received text is no valid utf8 string!");
        }
        if (this.f37210h == 1005 && this.f37211i.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        int i10 = this.f37210h;
        if (i10 > 1015 && i10 < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        if (i10 == 1006 || i10 == 1015 || i10 == 1005 || i10 > 4999 || i10 < 1000 || i10 == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f37210h);
        }
    }

    @Override // mc.g
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.f37210h) * 31;
        String str = this.f37211i;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // mc.g
    public void j(ByteBuffer byteBuffer) {
        this.f37210h = 1005;
        this.f37211i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f37210h = 1000;
            return;
        }
        if (byteBuffer.remaining() == 1) {
            this.f37210h = 1002;
            return;
        }
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.position(2);
            byteBufferAllocate.putShort(byteBuffer.getShort());
            byteBufferAllocate.position(0);
            this.f37210h = byteBufferAllocate.getInt();
        }
        byteBuffer.reset();
        try {
            t(byteBuffer, byteBuffer.position());
        } catch (InvalidDataException unused) {
            this.f37210h = AMapException.CODE_AMAP_INVALID_USER_DOMAIN;
            this.f37211i = null;
        }
    }

    public int o() {
        return this.f37210h;
    }

    public String p() {
        return this.f37211i;
    }

    public void q(int i10) {
        this.f37210h = i10;
        if (i10 == 1015) {
            this.f37210h = 1005;
            this.f37211i = "";
        }
        s();
    }

    public void r(String str) {
        if (str == null) {
            str = "";
        }
        this.f37211i = str;
        s();
    }

    public final void s() {
        byte[] bArrF = pc.c.f(this.f37211i);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(this.f37210h);
        byteBufferAllocate.position(2);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArrF.length + 2);
        byteBufferAllocate2.put(byteBufferAllocate);
        byteBufferAllocate2.put(bArrF);
        byteBufferAllocate2.rewind();
        super.j(byteBufferAllocate2);
    }

    public final void t(ByteBuffer byteBuffer, int i10) throws InvalidDataException {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.f37211i = pc.c.e(byteBuffer);
            } catch (IllegalArgumentException unused) {
                throw new InvalidDataException(AMapException.CODE_AMAP_INVALID_USER_DOMAIN);
            }
        } finally {
            byteBuffer.position(i10);
        }
    }

    @Override // mc.g
    public String toString() {
        return super.toString() + "code: " + this.f37210h;
    }
}
