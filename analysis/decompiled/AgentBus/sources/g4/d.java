package g4;

import i5.l;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import t3.k;
import t3.o;

/* loaded from: classes.dex */
public final class d implements o {

    /* renamed from: a, reason: collision with root package name */
    public l f3844a;

    @Override // t3.o
    public final InputStream a(InputStream inputStream, byte[] bArr) {
        l lVar = this.f3844a;
        b bVar = new b();
        bVar.f3839f = false;
        bVar.f3840g = null;
        bVar.f3842i = lVar;
        if (inputStream.markSupported()) {
            bVar.f3841h = inputStream;
        } else {
            bVar.f3841h = new BufferedInputStream(inputStream);
        }
        bVar.f3841h.mark(Integer.MAX_VALUE);
        bVar.f3843j = (byte[]) bArr.clone();
        return bVar;
    }

    @Override // t3.o
    public final OutputStream b(FileOutputStream fileOutputStream, byte[] bArr) {
        return ((o) ((k) this.f3844a.f4688h).f9718b).b(fileOutputStream, bArr);
    }
}
