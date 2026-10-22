package bytekn.foundation.io.file;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends i {
    public h(e r100) {
        FileOutputStream r101 = r100.f21797a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        super(new OutputStreamWriter(r101));
    }
}
