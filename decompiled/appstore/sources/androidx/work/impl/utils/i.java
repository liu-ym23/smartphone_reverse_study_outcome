package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    @DoNotInline
    @Nullable
    public static final NetworkCapabilities a(@NotNull ConnectivityManager r10, @Nullable Network r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.getNetworkCapabilities(r11);
    }

    @DoNotInline
    public static final boolean b(@NotNull NetworkCapabilities r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.hasCapability(r11);
    }

    @DoNotInline
    public static final void c(@NotNull ConnectivityManager r10, @NotNull ConnectivityManager.NetworkCallback r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "networkCallback");
        r10.unregisterNetworkCallback(r11);
    }
}
