package retrofit2;

import androidx.room.AbstractC0351g;
import h3.H;
import h3.T;
import h3.U;
import h3.V;
import h3.a0;
import h3.b0;
import h3.f0;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.OkHttpCall;

/* loaded from: classes2.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final f0 errorBody;
    private final b0 rawResponse;

    private Response(b0 b0Var, @Nullable T t4, @Nullable f0 f0Var) {
        this.rawResponse = b0Var;
        this.body = t4;
        this.errorBody = f0Var;
    }

    public static <T> Response<T> error(int i4, f0 f0Var) {
        Objects.requireNonNull(f0Var, "body == null");
        if (i4 < 400) {
            throw new IllegalArgumentException(AbstractC0351g.m("code < 400: ", i4));
        }
        ArrayList arrayList = new ArrayList(20);
        OkHttpCall.NoContentResponseBody noContentResponseBody = new OkHttpCall.NoContentResponseBody(f0Var.contentType(), f0Var.contentLength());
        Intrinsics.checkNotNullParameter("Response.error()", "message");
        T protocol = T.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        U u4 = new U();
        u4.g("http://localhost/");
        V request = u4.b();
        Intrinsics.checkNotNullParameter(request, "request");
        if (i4 < 0) {
            throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", Integer.valueOf(i4)).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return error(f0Var, new b0(request, protocol, "Response.error()", i4, null, new H((String[]) array), noContentResponseBody, null, null, null, 0L, 0L, null));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static <T> Response<T> success(@Nullable T t4, H h4) {
        Objects.requireNonNull(h4, "headers == null");
        a0 a0Var = new a0();
        a0Var.f12852c = 200;
        Intrinsics.checkNotNullParameter("OK", "message");
        a0Var.f12853d = "OK";
        T protocol = T.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        a0Var.f12851b = protocol;
        a0Var.c(h4);
        U u4 = new U();
        u4.g("http://localhost/");
        V request = u4.b();
        Intrinsics.checkNotNullParameter(request, "request");
        a0Var.f12850a = request;
        return success(t4, a0Var.a());
    }

    @Nullable
    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.f12867d;
    }

    @Nullable
    public f0 errorBody() {
        return this.errorBody;
    }

    public H headers() {
        return this.rawResponse.f12869f;
    }

    public boolean isSuccessful() {
        return this.rawResponse.d();
    }

    public String message() {
        return this.rawResponse.f12866c;
    }

    public b0 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(@Nullable T t4, b0 b0Var) {
        Objects.requireNonNull(b0Var, "rawResponse == null");
        if (b0Var.d()) {
            return new Response<>(b0Var, t4, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> success(int i4, @Nullable T t4) {
        if (i4 >= 200 && i4 < 300) {
            ArrayList arrayList = new ArrayList(20);
            Intrinsics.checkNotNullParameter("Response.success()", "message");
            T protocol = T.HTTP_1_1;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            U u4 = new U();
            u4.g("http://localhost/");
            V request = u4.b();
            Intrinsics.checkNotNullParameter(request, "request");
            if (i4 >= 0) {
                Object[] array = arrayList.toArray(new String[0]);
                if (array != null) {
                    return success(t4, new b0(request, protocol, "Response.success()", i4, null, new H((String[]) array), null, null, null, null, 0L, 0L, null));
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", Integer.valueOf(i4)).toString());
        }
        throw new IllegalArgumentException(AbstractC0351g.m("code < 200 or >= 300: ", i4));
    }

    public static <T> Response<T> error(f0 f0Var, b0 b0Var) {
        Objects.requireNonNull(f0Var, "body == null");
        Objects.requireNonNull(b0Var, "rawResponse == null");
        if (!b0Var.d()) {
            return new Response<>(b0Var, null, f0Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T t4) {
        ArrayList arrayList = new ArrayList(20);
        Intrinsics.checkNotNullParameter("OK", "message");
        T protocol = T.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        U u4 = new U();
        u4.g("http://localhost/");
        V request = u4.b();
        Intrinsics.checkNotNullParameter(request, "request");
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return success(t4, new b0(request, protocol, "OK", 200, null, new H((String[]) array), null, null, null, null, 0L, 0L, null));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
