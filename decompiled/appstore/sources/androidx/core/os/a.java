package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2572a = null;

    static {
        f2572a = new a();
    }

    public a() {
    }

    @JvmStatic
    @DoNotInline
    public static final void a(@NotNull Bundle r10, @NotNull String r11, @Nullable IBinder r12) {
        q.g(r10, "bundle");
        q.g(r11, "key");
        r10.putBinder(r11, r12);
    }
}
