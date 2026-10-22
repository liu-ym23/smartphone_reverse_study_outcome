package bytekn.foundation.io.file;

import java.io.FileOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileOutputStream f21797a;

    public e() {
    }

    public void a() {
        FileOutputStream r100 = this.f21797a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        if (r100 == null) goto L8;
        r100.close();
        return;
    }

    @Override // bytekn.foundation.io.file.g
    public void close() {
        FileOutputStream r100 = this.f21797a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        if (r100 == null) goto L8;
        r100.close();
        return;
    }

    public void b(byte[] r100, int r101) {
        FileOutputStream r102 = this.f21797a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        if (r102 == null) goto L8;
        r102.write(r100, 0, r101);
        return;
    }
}
