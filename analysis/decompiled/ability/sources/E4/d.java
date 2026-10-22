package E4;

import C7.r;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class d implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final File f474a;
    public final File b;

    public d(File file, File file2) {
        this.f474a = file;
        this.b = file2;
    }

    public final void b() throws IOException {
        Files.move(this.f474a.toPath(), this.b.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        Object objA;
        File file = this.f474a;
        try {
            if (file.exists() && !file.delete()) {
                Log.w("ModelStore", "could not remove pending user model");
            }
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("ModelStore", "remove pending user model failed", thA);
        }
    }
}
