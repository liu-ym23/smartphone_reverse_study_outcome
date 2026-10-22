package qd;

import kotlin.jvm.internal.g;
import sd.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    public static void a(e.a cursor, byte[] key) {
        long j10;
        g.f(cursor, "cursor");
        g.f(key, "key");
        int length = key.length;
        int i10 = 0;
        do {
            byte[] bArr = cursor.f11931e;
            int i11 = cursor.h;
            int i12 = cursor.f11932j;
            if (bArr != null) {
                while (i11 < i12) {
                    int i13 = i10 % length;
                    bArr[i11] = (byte) (bArr[i11] ^ key[i13]);
                    i11++;
                    i10 = i13 + 1;
                }
            }
            long j11 = cursor.f11930d;
            sd.e eVar = cursor.f11927a;
            g.c(eVar);
            if (j11 == eVar.f11926b) {
                throw new IllegalStateException("no more bytes");
            }
            j10 = cursor.f11930d;
        } while (cursor.o(j10 == -1 ? 0L : j10 + (cursor.f11932j - cursor.h)) != -1);
    }
}
