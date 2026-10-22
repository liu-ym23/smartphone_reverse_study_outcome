package bytekn.foundation.io.file;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f21786a;

    public b() {
    }

    @Override // bytekn.foundation.io.file.g
    public void close() {
        InputStream r100 = this.f21786a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputStream");
    L5:
        r100.close();
    }

    public int a(byte[] r100, int r101) {
        InputStream r102 = this.f21786a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inputStream");
    L6:
        return r102.read(r100, 0, r101);
    }
}
