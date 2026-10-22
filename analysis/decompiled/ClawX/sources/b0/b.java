package b0;

import java.net.InetSocketAddress;
import java.util.Comparator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f809a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f809a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i8 = 0; i8 < bArr.length; i8++) {
                    byte b9 = bArr[i8];
                    byte b10 = bArr2[i8];
                    if (b9 != b10) {
                        return b9 - b10;
                    }
                }
                return 0;
            default:
                return Integer.compare(((InetSocketAddress) obj2).getAddress().getAddress().length, ((InetSocketAddress) obj).getAddress().getAddress().length);
        }
    }
}
