package okhttp3.logging;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f23011c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f23012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Level f23013b;

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level BASIC = null;
        public static final Level BODY = null;
        public static final Level HEADERS = null;
        public static final Level NONE = null;

        static {
            Level r10 = new Level("NONE", 0);
            NONE = r10;
            Level r11 = new Level("BASIC", 1);
            BASIC = r11;
            Level r12 = new Level("HEADERS", 2);
            HEADERS = r12;
            Level r13 = new Level("BODY", 3);
            BODY = r13;
            $VALUES = new Level[]{r10, r11, r12, r13};
        }

        private Level(String r10, int r11) {
            super(r10, r11);
        }

        public static Level valueOf(String r10) {
            return (Level) Enum.valueOf(Level.class, r10);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    public interface Logger {
        public static final Logger DEFAULT = null;

        public class a implements Logger {
            public a() {
            }

            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String r10) {
                Platform.get().log(4, r10, null);
            }
        }

        static {
            DEFAULT = new a();
        }

        void log(String r10);
    }

    static {
        f23011c = Charset.forName("UTF-8");
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public static boolean b(Buffer r10) {
        Buffer r11 = new Buffer();     // Catch: EOFException -> L21
        if (r10.size() >= 64) goto L6;
        long r12 = r10.size();     // Catch: EOFException -> L21
    L7:
        r10.d(r11, 0, r12);     // Catch: EOFException -> L21
        int r13 = 0;
    L9:
        if (r13 >= 16) goto L29;
        if (r11.exhausted() == true) goto L19;
        int r14 = r11.readUtf8CodePoint();     // Catch: EOFException -> L21
        if (Character.isISOControl(r14) == false) goto L18;
        if (Character.isWhitespace(r14) == true) goto L18;
        return false;
    L18:
        r13 = r13 + 1;
        goto L9
    L19:
        return true;
    L29:
        return true;
    L6:
        r12 = 64;
    L21:
        return false;
    }

    public final boolean a(Headers r10) {
        String r11 = r10.b("Content-Encoding");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.equalsIgnoreCase("identity") == true) goto L7;
        return true;
    }

    public HttpLoggingInterceptor c(Level r10) {
        if (r10 == null) goto L6;
        this.f23013b = r10;
        return this;
    L6:
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r22) {
        Level r10 = this.f23013b;
        Request r11 = r22.request();
        if (r10 == Level.NONE) goto L5;
        boolean r12 = true;
        if (r10 != Level.BODY) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
    L15:
        boolean r14 = true;
    L16:
        RequestBody r15 = r11.a();
        if (r15 != null) goto L20;
        r12 = false;
    L20:
        Connection r16 = r22.connection();
        StringBuilder r17 = new StringBuilder();
        r17.append("--> ");
        r17.append(r11.g());
        r17.append(TokenParser.SP);
        r17.append(r11.k());
        if (r16 == null) goto L23;
        String r18 = " " + r16.protocol();
    L24:
        r17.append(r18);
        String r19 = r17.toString();
        if (r14 == true) goto L28;
        if (r12 == false) goto L28;
        r19 = r19 + " (" + r15.a() + "-byte body)";
    L28:
        this.f23012a.log(r19);
        if (r14 == false) goto L61;
        if (r12 == true) goto L32;
    L37:
        Headers r20 = r11.e();
        int r110 = r20.h();
        int r111 = 0;
    L38:
        if (r111 >= r110) goto L46;
        String r112 = r20.d(r111);
        int r113 = r110;
        if ("Content-Type".equalsIgnoreCase(r112) == true) goto L45;
        if ("Content-Length".equalsIgnoreCase(r112) == true) goto L45;
        this.f23012a.log(r112 + ": " + r20.j(r111));
    L45:
        r111 = r111 + 1;
        r110 = r113;
        r14 = r14;
        goto L38
    L46:
        boolean r21 = r14;
        if (r13 == false) goto L60;
        if (r12 == false) goto L60;
        if (a(r11.e()) == false) goto L53;
        this.f23012a.log("--> END " + r11.g() + " (encoded body omitted)");
    L62:
        long r23 = System.nanoTime();
        Response r24 = r22.proceed(r11);     // Catch: Exception -> L101
        long r25 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r23);
        ResponseBody r26 = r24.a();
        long r27 = r26.contentLength();
        if (r27 == (-1)) goto L67;
        String r114 = r27 + "-byte";
    L68:
        Logger r115 = this.f23012a;
        StringBuilder r116 = new StringBuilder();
        r116.append("<-- ");
        r116.append(r24.d());
        if (r24.l().isEmpty() == false) goto L71;
        String r28 = "";
        char r29 = TokenParser.SP;
    L72:
        r116.append(r28);
        r116.append(r29);
        r116.append(r24.r().k());
        r116.append(" (");
        r116.append(r25);
        r116.append("ms");
        if (r21 == true) goto L75;
        String r30 = ", " + r114 + " body";
    L76:
        r116.append(r30);
        r116.append(')');
        r115.log(r116.toString());
        if (r21 == false) goto L100;
        Headers r31 = r24.i();
        int r32 = r31.h();
        int r33 = 0;
    L79:
        if (r33 >= r32) goto L81;
        this.f23012a.log(r31.d(r33) + ": " + r31.j(r33));
        r33 = r33 + 1;
        goto L79
    L81:
        if (r13 == true) goto L83;
    L99:
        this.f23012a.log("<-- END HTTP");
        goto L100
    L83:
        if (HttpHeaders.hasBody(r24) == false) goto L99;
        if (a(r24.i()) == false) goto L88;
        this.f23012a.log("<-- END HTTP (encoded body omitted)");
        goto L100
    L88:
        BufferedSource r34 = r26.source();
        r34.request(Long.MAX_VALUE);
        Buffer r35 = r34.buffer();
        Charset r36 = f23011c;
        MediaType r37 = r26.contentType();
        if (r37 == null) goto L92;
        r36 = r37.b(r36);
    L92:
        if (b(r35) == true) goto L96;
        this.f23012a.log("");
        this.f23012a.log("<-- END HTTP (binary " + r35.size() + "-byte body omitted)");
        return r24;
    L96:
        if (r27 == 0) goto L98;
        this.f23012a.log("");
        this.f23012a.log(r35.b().readString(r36));
    L98:
        this.f23012a.log("<-- END HTTP (" + r35.size() + "-byte body)");
    L100:
        return r24;
    L75:
        r30 = "";
        goto L76
    L71:
        StringBuilder r38 = new StringBuilder();
        r29 = TokenParser.SP;
        r38.append(TokenParser.SP);
        r38.append(r24.l());
        r28 = r38.toString();
        goto L72
    L67:
        r114 = "unknown-length";
    L101:
        e = move-exception;
        this.f23012a.log("<-- HTTP FAILED: " + e);
        throw e;
    L53:
        Buffer r39 = new Buffer();
        r15.g(r39);
        Charset r40 = f23011c;
        MediaType r117 = r15.b();
        if (r117 == null) goto L56;
        r40 = r117.b(r40);
    L56:
        this.f23012a.log("");
        if (b(r39) == false) goto L59;
        this.f23012a.log(r39.readString(r40));
        this.f23012a.log("--> END " + r11.g() + " (" + r15.a() + "-byte body)");
        goto L62
    L59:
        this.f23012a.log("--> END " + r11.g() + " (binary " + r15.a() + "-byte body omitted)");
    L60:
        this.f23012a.log("--> END " + r11.g());
        goto L62
    L32:
        if (r15.b() == null) goto L35;
        this.f23012a.log("Content-Type: " + r15.b());
    L35:
        if (r15.a() == (-1)) goto L37;
        this.f23012a.log("Content-Length: " + r15.a());
        goto L37
    L61:
        r21 = r14;
        goto L62
    L23:
        r18 = "";
        goto L24
    L12:
        if (r10 == Level.HEADERS) goto L15;
        r14 = false;
        goto L16
    L9:
        r13 = false;
        goto L10
    L5:
        return r22.proceed(r11);
    }

    public HttpLoggingInterceptor(Logger r10) {
        this.f23013b = Level.NONE;
        this.f23012a = r10;
    }
}
