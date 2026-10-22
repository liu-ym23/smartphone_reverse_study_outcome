package a2;

import android.graphics.Rect;
import android.view.View;
import c5.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.List;
import javax.crypto.AEADBadTagException;
import k4.l;
import k4.m;
import kotlin.jvm.internal.p;
import v0.b0;
import v0.t;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f87a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f88b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f89c;

    public g(String content, List parameters) {
        this.f87a = 1;
        p.e(content, "content");
        p.e(parameters, "parameters");
        this.f88b = content;
        this.f89c = parameters;
    }

    public static g a(b0 b0Var, int i8) {
        if (i8 == 0) {
            return new t(b0Var, 0);
        }
        if (i8 == 1) {
            return new t(b0Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static byte[] q(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i8 = iRemaining % 16;
        int i9 = (i8 == 0 ? iRemaining : (iRemaining + 16) - i8) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i9 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i9);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    public byte[] b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            ((e) this.f89c).a(bArr, 0).get(bArr4);
            if (!MessageDigest.isEqual(a.a.m(bArr4, q(bArr2, byteBuffer)), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            e eVar = (e) this.f88b;
            eVar.getClass();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            eVar.k(bArr, byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        } catch (GeneralSecurityException e9) {
            throw new AEADBadTagException(e9.toString());
        }
    }

    public void c(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        e eVar = (e) this.f88b;
        eVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        eVar.k(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        ByteBuffer byteBufferA = ((e) this.f89c).a(bArr, 0);
        byte[] bArr4 = new byte[32];
        byteBufferA.get(bArr4);
        byte[] bArrM = a.a.m(bArr4, q(bArr3, byteBuffer));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrM);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o(View view);

    public abstract int p(View view);

    public abstract e r(byte[] bArr, int i8);

    public abstract void s(int i8);

    public String t(String name) {
        p.e(name, "name");
        List list = (List) this.f89c;
        int iJ0 = n.j0(list);
        if (iJ0 < 0) {
            return null;
        }
        int i8 = 0;
        while (true) {
            l lVar = (l) list.get(i8);
            if (u.W0(lVar.f3628a, name)) {
                return lVar.f3629b;
            }
            if (i8 == iJ0) {
                return null;
            }
            i8++;
        }
    }

    public String toString() {
        switch (this.f87a) {
            case 1:
                String str = (String) this.f88b;
                List<l> list = (List) this.f89c;
                if (list.isEmpty()) {
                    return str;
                }
                int length = str.length();
                int i8 = 0;
                int length2 = 0;
                for (l lVar : list) {
                    length2 += lVar.f3629b.length() + lVar.f3628a.length() + 3;
                }
                StringBuilder sb = new StringBuilder(length + length2);
                sb.append(str);
                int iJ0 = n.j0(list);
                if (iJ0 >= 0) {
                    while (true) {
                        l lVar2 = (l) list.get(i8);
                        sb.append("; ");
                        sb.append(lVar2.f3628a);
                        sb.append("=");
                        String str2 = lVar2.f3629b;
                        if (m.a(str2)) {
                            sb.append(m.b(str2));
                        } else {
                            sb.append(str2);
                        }
                        if (i8 != iJ0) {
                            i8++;
                        }
                    }
                }
                String string = sb.toString();
                p.b(string);
                return string;
            default:
                return super.toString();
        }
    }

    public g(byte[] bArr) throws GeneralSecurityException {
        this.f87a = 0;
        if (a8.b.a(1)) {
            this.f88b = r(bArr, 1);
            this.f89c = r(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public g(b0 b0Var) {
        this.f87a = 2;
        this.f89c = new Rect();
        this.f88b = b0Var;
    }
}
