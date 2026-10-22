package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2573a = null;

    static {
        f2573a = new b();
    }

    public b() {
    }

    @JvmStatic
    @DoNotInline
    public static final void a(@NotNull Bundle r10, @NotNull String r11, @Nullable Size r12) {
        q.g(r10, "bundle");
        q.g(r11, "key");
        r10.putSize(r11, r12);
    }

    @JvmStatic
    @DoNotInline
    public static final void b(@NotNull Bundle r10, @NotNull String r11, @Nullable SizeF r12) {
        q.g(r10, "bundle");
        q.g(r11, "key");
        r10.putSizeF(r11, r12);
    }
}
