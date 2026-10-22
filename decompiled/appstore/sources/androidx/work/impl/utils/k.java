package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    @DoNotInline
    public static final void a(@NotNull ConnectivityManager r10, @NotNull ConnectivityManager.NetworkCallback r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "networkCallback");
        r10.registerDefaultNetworkCallback(r11);
    }
}
