package S;

import K.w0;
import androidx.camera.core.i;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final IncorrectJpegMetadataQuirk f5636a;

    public d(w0 w0Var) {
        this.f5636a = (IncorrectJpegMetadataQuirk) w0Var.b(IncorrectJpegMetadataQuirk.class);
    }

    public byte[] a(i iVar) {
        IncorrectJpegMetadataQuirk incorrectJpegMetadataQuirk = this.f5636a;
        if (incorrectJpegMetadataQuirk != null) {
            return incorrectJpegMetadataQuirk.f(iVar);
        }
        ByteBuffer byteBufferA = iVar.w0()[0].a();
        byte[] bArr = new byte[byteBufferA.capacity()];
        byteBufferA.rewind();
        byteBufferA.get(bArr);
        return bArr;
    }
}
