package O0;

import C0.v;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import z0.C1342h;

/* loaded from: classes.dex */
public class j implements z0.i<InputStream, c> {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f4340a;

    /* renamed from: b, reason: collision with root package name */
    private final z0.i<ByteBuffer, c> f4341b;

    /* renamed from: c, reason: collision with root package name */
    private final D0.b f4342c;

    public j(List<ImageHeaderParser> list, z0.i<ByteBuffer, c> iVar, D0.b bVar) {
        this.f4340a = list;
        this.f4341b = iVar;
        this.f4342c = bVar;
    }

    private static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i5 = inputStream.read(bArr);
                if (i5 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
        } catch (IOException e6) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e6);
            return null;
        }
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<c> a(InputStream inputStream, int i5, int i6, C1342h c1342h) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f4341b.a(ByteBuffer.wrap(bArrE), i5, i6, c1342h);
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, C1342h c1342h) {
        return !((Boolean) c1342h.c(i.f4339b)).booleanValue() && com.bumptech.glide.load.a.b(this.f4340a, inputStream, this.f4342c) == ImageHeaderParser.ImageType.GIF;
    }
}
