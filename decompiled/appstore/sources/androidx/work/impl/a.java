package androidx.work.impl;

import android.content.Context;
import androidx.annotation.DoNotInline;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5434a = null;

    static {
        f5434a = new a();
    }

    public a() {
    }

    @DoNotInline
    @NotNull
    public final File a(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        File r11 = r10.getNoBackupFilesDir();
        kotlin.jvm.internal.q.f(r11, "context.noBackupFilesDir");
        return r11;
    }
}
