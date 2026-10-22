package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    @DoNotInline
    @Nullable
    public static final Network a(@NotNull ConnectivityManager r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.getActiveNetwork();
    }
}
