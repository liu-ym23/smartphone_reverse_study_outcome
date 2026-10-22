package g2;

import android.util.Log;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.WindowStrictModeException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<T> extends SpecificationComputer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f8955a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8956b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8957c;

    /* renamed from: d, reason: collision with root package name */
    public final a f8958d;

    /* renamed from: e, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f8959e;

    /* renamed from: f, reason: collision with root package name */
    public final WindowStrictModeException f8960f;

    public c(T value, String tag, String str, a logger, SpecificationComputer.VerificationMode verificationMode) {
        g.f(value, "value");
        g.f(tag, "tag");
        g.f(logger, "logger");
        g.f(verificationMode, "verificationMode");
        this.f8955a = value;
        this.f8956b = tag;
        this.f8957c = str;
        this.f8958d = logger;
        this.f8959e = verificationMode;
        String message = SpecificationComputer.b(value, str);
        g.f(message, "message");
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(message);
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        g.e(stackTrace, "stackTrace");
        Object[] array = l.c0(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.f8960f = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public final T a() throws WindowStrictModeException {
        int iOrdinal = this.f8959e.ordinal();
        if (iOrdinal == 0) {
            throw this.f8960f;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        String message = SpecificationComputer.b(this.f8955a, this.f8957c);
        this.f8958d.getClass();
        String tag = this.f8956b;
        g.f(tag, "tag");
        g.f(message, "message");
        Log.d(tag, message);
        return null;
    }

    @Override // androidx.window.core.SpecificationComputer
    public final SpecificationComputer<T> c(String str, zb.l<? super T, Boolean> condition) {
        g.f(condition, "condition");
        return this;
    }
}
