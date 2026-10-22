package z7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: z7.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2184e {

    /* renamed from: a, reason: collision with root package name */
    public final File f6977a;
    public final FileOutputStream b;

    public C2184e(File file) throws IOException {
        File fileCreateTempFile = File.createTempFile("NanoHTTPD-", "", file);
        this.f6977a = fileCreateTempFile;
        this.b = new FileOutputStream(fileCreateTempFile);
    }
}
