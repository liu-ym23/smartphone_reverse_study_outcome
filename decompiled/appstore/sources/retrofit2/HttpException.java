package retrofit2;

/* JADX INFO: loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public HttpException(Response<?> r10) {
        super(getMessage(r10));
        this.code = r10.b();
        this.message = r10.g();
        this.response = r10;
    }

    private static String getMessage(Response<?> r10) {
        i.b(r10, "response == null");
        return "HTTP " + r10.b() + " " + r10.g();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}
