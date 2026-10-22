package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Result<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9987a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Failure implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f9988a;

        public Failure(Throwable exception) {
            g.f(exception, "exception");
            this.f9988a = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                return g.b(this.f9988a, ((Failure) obj).f9988a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f9988a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f9988a + ')';
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public /* synthetic */ Result(Object obj) {
        this.f9987a = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f9988a;
        }
        return null;
    }

    public final /* synthetic */ Object c() {
        return this.f9987a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Result) {
            return g.b(this.f9987a, ((Result) obj).f9987a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f9987a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f9987a;
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
