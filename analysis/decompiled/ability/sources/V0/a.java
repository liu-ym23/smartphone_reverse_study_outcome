package V0;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f1299a;
    public int b;
    public int c;
    public File d;
    public ArrayList e;

    public static a a(ByteBuffer byteBuffer) {
        try {
            if (byteBuffer.getShort() != 2082) {
                return null;
            }
            long j5 = byteBuffer.getLong();
            int i = byteBuffer.getInt();
            int i6 = byteBuffer.getInt();
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                int i12 = byteBuffer.getInt();
                i10 += i12;
                if (i10 > i6) {
                    return null;
                }
                byte[] bArr = new byte[i12];
                byteBuffer.get(bArr);
                b bVar = new b();
                bVar.f1300a = bArr;
                arrayList.add(bVar);
            }
            a aVar = new a();
            aVar.f1299a = j5;
            aVar.b = i;
            aVar.c = i6;
            aVar.e = arrayList;
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String toString() {
        return "LogFile{startID=" + this.f1299a + ", totalCount=" + this.b + ", totalBytes=" + this.c + ", source=" + this.d + ", logList=" + this.e + '}';
    }
}
