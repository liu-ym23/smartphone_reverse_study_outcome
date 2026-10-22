package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RequestBody {

    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f22788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteString f22789b;

        public a(MediaType r10, ByteString r11) {
            this.f22788a = r10;
            this.f22789b = r11;
        }

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f22789b.size();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f22788a;
        }

        @Override // okhttp3.RequestBody
        public void g(BufferedSink r10) {
            r10.write(this.f22789b);
        }
    }

    public static class b extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f22790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f22792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f22793d;

        public b(MediaType r10, int r11, byte[] r12, int r13) {
            this.f22790a = r10;
            this.f22791b = r11;
            this.f22792c = r12;
            this.f22793d = r13;
        }

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f22791b;
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f22790a;
        }

        @Override // okhttp3.RequestBody
        public void g(BufferedSink r10) {
            r10.write(this.f22792c, this.f22793d, this.f22791b);
        }
    }

    public RequestBody() {
    }

    public static RequestBody c(MediaType r10, String r11) {
        Charset r12 = Util.UTF_8;
        if (r10 == null) goto L9;
        Charset r13 = r10.a();
        if (r13 != null) goto L7;
        r10 = MediaType.c(r10 + "; charset=utf-8");
        goto L9
    L7:
        r12 = r13;
    L9:
        return e(r10, r11.getBytes(r12));
    }

    public static RequestBody d(MediaType r10, ByteString r11) {
        return new a(r10, r11);
    }

    public static RequestBody e(MediaType r10, byte[] r11) {
        return f(r10, r11, 0, r11.length);
    }

    public static RequestBody f(MediaType r10, byte[] r11, int r12, int r13) {
        if (r11 == null) goto L6;
        Util.checkOffsetAndCount(r11.length, r12, r13);
        return new b(r10, r13, r11, r12);
    L6:
        throw new NullPointerException("content == null");
    }

    public long a() {
        return -1;
    }

    public abstract MediaType b();

    public abstract void g(BufferedSink r10);
}
