package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Callables {
    private Callables() {
    }

    public static /* synthetic */ boolean access$000(String r10, Thread r11) {
        return trySetName(r10, r11);
    }

    @Beta
    @GwtIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> r10, final ListeningExecutorService r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass2(r11, r10);
    }

    public static <T> Callable<T> returning(@NullableDecl final T r10) {
        return new AnonymousClass1(r10);
    }

    @GwtIncompatible
    public static <T> Callable<T> threadRenaming(final Callable<T> r10, final Supplier<String> r11) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r10);
        return new AnonymousClass3(r11, r10);
    }

    @GwtIncompatible
    private static boolean trySetName(String r10, Thread r11) {
        r11.setName(r10);     // Catch: SecurityException -> L5
        return true;
    L5:
        return false;
    }

    @GwtIncompatible
    public static Runnable threadRenaming(final Runnable r10, final Supplier<String> r11) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r10);
        return new AnonymousClass4(r11, r10);
    }
}
