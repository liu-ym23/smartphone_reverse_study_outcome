package P0;

import C0.v;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f4533a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4534b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // P0.e
    public v<byte[]> a(v<Bitmap> vVar, C1342h c1342h) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f4533a, this.f4534b, byteArrayOutputStream);
        vVar.b();
        return new L0.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i5) {
        this.f4533a = compressFormat;
        this.f4534b = i5;
    }
}
