package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087@\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0001\u0004\u0088\u0001\u0005\u0092\u0001\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Failure", "value", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Result<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4887a;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Failure implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f4888a;

        public Failure(Throwable exception) {
            k.f(exception, "exception");
            this.f4888a = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                return k.b(this.f4888a, ((Failure) obj).f4888a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f4888a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f4888a + ')';
        }
    }

    public /* synthetic */ Result(Object obj) {
        this.f4887a = obj;
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f4888a;
        }
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final /* synthetic */ Object getF4887a() {
        return this.f4887a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Result) {
            return k.b(this.f4887a, ((Result) obj).f4887a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f4887a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f4887a;
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
