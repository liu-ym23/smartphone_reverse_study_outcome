package c0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6025a = null;

    static {
        f6025a = new d();
    }

    public d() {
    }

    public static final File a(Context r10) {
        q.g(r10, "context");
        File r11 = r10.getNoBackupFilesDir();
        q.f(r11, "context.noBackupFilesDir");
        return r11;
    }
}
