package io.reactivex.internal.util;

import androidx.lifecycle.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static String a(String r10) {
        return "It is not allowed to subscribe with a(n) " + r10 + " multiple times. Please create a fresh instance of " + r10 + " and subscribe that to the target source instead.";
    }

    public static void b(Class r10) {
        qf.a.e(new ProtocolViolationException(a(r10.getName())));
    }

    public static boolean c(AtomicReference r10, Disposable r11, Class r12) {
        io.reactivex.internal.functions.a.b(r11, "next is null");
        if (p.a(r10, null, r11) == true) goto L9;
        r11.dispose();
        if (r10.get() == DisposableHelper.DISPOSED) goto L11;
        b(r12);
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean d(AtomicReference r10, Subscription r11, Class r12) {
        io.reactivex.internal.functions.a.b(r11, "next is null");
        if (p.a(r10, null, r11) == true) goto L9;
        r11.cancel();
        if (r10.get() == SubscriptionHelper.CANCELLED) goto L11;
        b(r12);
        return false;
    L11:
        return false;
    L9:
        return true;
    }
}
