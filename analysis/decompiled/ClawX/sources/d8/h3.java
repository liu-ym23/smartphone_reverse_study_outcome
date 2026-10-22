package d8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h3 extends i3 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2015a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2016b;

    public h3(int i8) {
        this.f2015a = i8;
        switch (i8) {
            case 1:
                this.f2016b = new ArrayList();
                break;
            case 2:
                this.f2016b = new ArrayList();
                break;
            default:
                this.f2016b = new ArrayList();
                break;
        }
    }

    @Override // d8.i3
    public final void a(byte[] bArr) throws l4 {
        switch (this.f2015a) {
            case 0:
                ArrayList arrayList = this.f2016b;
                arrayList.clear();
                u uVar = new u(bArr);
                while (uVar.f2171a.remaining() > 0) {
                    arrayList.add(uVar.c());
                }
                return;
            case 1:
                ArrayList arrayList2 = this.f2016b;
                arrayList2.clear();
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.position();
                byteBufferWrap.limit();
                while (byteBufferWrap.remaining() >= 4) {
                    if (4 > byteBufferWrap.remaining()) {
                        throw new l4("end of input");
                    }
                    byte[] bArr2 = new byte[4];
                    byteBufferWrap.get(bArr2, 0, 4);
                    arrayList2.add(bArr2);
                }
                if (byteBufferWrap.remaining() > 0) {
                    throw new l4("Unexpected number of bytes in ipv4hint parameter");
                }
                return;
            default:
                ArrayList arrayList3 = this.f2016b;
                arrayList3.clear();
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                byteBufferWrap2.position();
                byteBufferWrap2.limit();
                while (byteBufferWrap2.remaining() >= 16) {
                    if (16 > byteBufferWrap2.remaining()) {
                        throw new l4("end of input");
                    }
                    byte[] bArr3 = new byte[16];
                    byteBufferWrap2.get(bArr3, 0, 16);
                    arrayList3.add(bArr3);
                }
                if (byteBufferWrap2.remaining() > 0) {
                    throw new l4("Unexpected number of bytes in ipv6hint parameter");
                }
                return;
        }
    }

    @Override // d8.i3
    public final byte[] b() {
        switch (this.f2015a) {
            case 0:
                b0.j jVar = new b0.j(2);
                ArrayList arrayList = this.f2016b;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    jVar.i((byte[]) obj);
                }
                return jVar.f();
            case 1:
                b0.j jVar2 = new b0.j(2);
                ArrayList arrayList2 = this.f2016b;
                int size2 = arrayList2.size();
                int i9 = 0;
                while (i9 < size2) {
                    Object obj2 = arrayList2.get(i9);
                    i9++;
                    jVar2.h((byte[]) obj2);
                }
                return jVar2.f();
            default:
                b0.j jVar3 = new b0.j(2);
                ArrayList arrayList3 = this.f2016b;
                int size3 = arrayList3.size();
                int i10 = 0;
                while (i10 < size3) {
                    Object obj3 = arrayList3.get(i10);
                    i10++;
                    jVar3.h((byte[]) obj3);
                }
                return jVar3.f();
        }
    }

    @Override // d8.i3
    public final String toString() {
        switch (this.f2015a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = this.f2016b;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList.get(i8);
                    i8++;
                    byte[] bArr = (byte[]) obj;
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(w2.a(bArr, false).replace(",", "\\,"));
                }
                return sb.toString();
            case 1:
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList2 = this.f2016b;
                int size2 = arrayList2.size();
                int i9 = 0;
                while (i9 < size2) {
                    Object obj2 = arrayList2.get(i9);
                    i9++;
                    byte[] bArr2 = (byte[]) obj2;
                    if (sb2.length() > 0) {
                        sb2.append(",");
                    }
                    sb2.append(a.a.e0(bArr2));
                }
                return sb2.toString();
            default:
                StringBuilder sb3 = new StringBuilder();
                ArrayList arrayList3 = this.f2016b;
                int size3 = arrayList3.size();
                int i10 = 0;
                while (i10 < size3) {
                    Object obj3 = arrayList3.get(i10);
                    i10++;
                    byte[] bArr3 = (byte[]) obj3;
                    if (sb3.length() > 0) {
                        sb3.append(",");
                    }
                    try {
                        sb3.append(InetAddress.getByAddress(null, bArr3).getHostAddress());
                    } catch (UnknownHostException e9) {
                        return e9.getMessage();
                    }
                }
                return sb3.toString();
        }
    }
}
