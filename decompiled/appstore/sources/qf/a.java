package qf;

import io.reactivex.Observer;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ExceptionHelper;
import mf.b;
import mf.e;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Consumer f23658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile BiFunction f23659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile BiFunction f23660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile BooleanSupplier f23661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f23662e;

    public static Object a(BiFunction r10, Object r11, Object r12) {
        return r10.apply(r11, r12);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static boolean b(Throwable r10) {
        if ((r10 instanceof OnErrorNotImplementedException) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof MissingBackpressureException) == false) goto L9;
        return true;
    L9:
        if ((r10 instanceof IllegalStateException) == false) goto L12;
        return true;
    L12:
        if ((r10 instanceof NullPointerException) == false) goto L15;
        return true;
    L15:
        if ((r10 instanceof IllegalArgumentException) == false) goto L18;
        return true;
    L18:
        if ((r10 instanceof CompositeException) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static boolean c() {
        return f23662e;
    }

    public static boolean d() {
        BooleanSupplier r10 = f23661d;
        if (r10 != null) goto L11;
        return false;
    L11:
        return r10.getAsBoolean();
    L6:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static void e(Throwable r10) {
        Consumer r11 = f23658a;
        if (r10 != null) goto L6;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r11 != null) goto L15;
    L13:
        r10.printStackTrace();
        h(r10);
        return;
    L15:
        r11.accept(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        h(th);
        goto L13
    L6:
        if (b(r10) == true) goto L8;
        r10 = new UndeliverableException(r10);
        goto L8
    }

    public static Observer f(e r10, Observer r11) {
        BiFunction r12 = f23660c;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (Observer) a(r12, r10, r11);
    }

    public static Subscriber g(b r10, Subscriber r11) {
        BiFunction r12 = f23659b;
        if (r12 != null) goto L5;
        return r11;
    L5:
        return (Subscriber) a(r12, r10, r11);
    }

    public static void h(Throwable r10) {
        Thread r11 = Thread.currentThread();
        r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
    }
}
