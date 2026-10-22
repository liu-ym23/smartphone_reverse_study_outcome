package w0;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.bytedance.services.apm.api.IZstdCompress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i implements IZstdCompress {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ZstdDictCompress f25288c;

    public i() {
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r10, byte[] r11, int r12) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (this.f25288c != null) goto L8;
    L11:
        this.f25288c = new ZstdDictCompress(r11, r12);
        this.f25286a = r11;
        this.f25287b = r12;
    L13:
        return ZstdCompress.compress(r10, this.f25288c);
    L8:
        if (Arrays.equals(r11, this.f25286a) == false) goto L11;
        if (r12 == this.f25287b) goto L13;
        goto L11
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r10, int r11) {
        return ZstdCompress.compress(r10, r11);
    }
}
