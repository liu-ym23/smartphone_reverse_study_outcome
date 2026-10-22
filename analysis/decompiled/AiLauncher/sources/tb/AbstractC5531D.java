package tb;

import Mb.C0966d;
import Mb.InterfaceC0968f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;
import ub.C5642b;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000b2\u00020\u0001:\u0002\u001b\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Ltb/D;", "Ljava/io/Closeable;", "<init>", "()V", "Ltb/x;", "l", "()Ltb/x;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "Ljava/io/InputStream;", Const.INTENT_KEY_PKGNAME, "()Ljava/io/InputStream;", "LMb/f;", "n", "()LMb/f;", "Ljava/io/Reader;", "e", "()Ljava/io/Reader;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "LY8/t;", "close", "Ljava/nio/charset/Charset;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/nio/charset/Charset;", Const.INTENT_KEY_APIKEY, "Ljava/io/Reader;", "reader", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.D, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5531D implements Closeable {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC5531D f42132c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Reader reader;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Ltb/D$a;", "Ljava/io/Reader;", "LMb/f;", "source", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "<init>", "(LMb/f;Ljava/nio/charset/Charset;)V", "", "cbuf", "", W4.a.ENABLE_OFF, "len", "read", "([CII)I", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "LMb/f;", Const.INTENT_KEY_PKGNAME, "Ljava/nio/charset/Charset;", "", "c", "Z", AlipayXuiIsland.REASON_CLOSED, Const.INTENT_KEY_UMID, "Ljava/io/Reader;", "delegate", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.D$a */
    public static final class a extends Reader {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC0968f source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Charset charset;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean closed;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public Reader delegate;

        public a(InterfaceC0968f source, Charset charset) {
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int off, int len) throws IOException {
            kotlin.jvm.internal.p.i(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.r1(), ub.q.n(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, off, len);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u00020\u0007*\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ltb/D$b;", "", "<init>", "()V", "Lokio/ByteString;", "Ltb/x;", "contentType", "Ltb/D;", Const.INTENT_KEY_PKGNAME, "(Lokio/ByteString;Ltb/x;)Ltb/D;", "LMb/f;", "", "contentLength", Const.INTENT_KEY_APIKEY, "(LMb/f;Ltb/x;J)Ltb/D;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "c", "(Ltb/x;JLMb/f;)Ltb/D;", "EMPTY", "Ltb/D;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.D$b, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"tb/D$b$a", "Ltb/D;", "Ltb/x;", "l", "()Ltb/x;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "LMb/f;", "n", "()LMb/f;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.D$b$a */
        public static final class a extends AbstractC5531D {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f42138d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f42139e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ InterfaceC0968f f42140f;

            public a(x xVar, long j10, InterfaceC0968f interfaceC0968f) {
                this.f42138d = xVar;
                this.f42139e = j10;
                this.f42140f = interfaceC0968f;
            }

            @Override // tb.AbstractC5531D
            /* renamed from: i, reason: from getter */
            public long getF42139e() {
                return this.f42139e;
            }

            @Override // tb.AbstractC5531D
            /* renamed from: l, reason: from getter */
            public x getF42138d() {
                return this.f42138d;
            }

            @Override // tb.AbstractC5531D
            /* renamed from: n, reason: from getter */
            public InterfaceC0968f getF42140f() {
                return this.f42140f;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ AbstractC5531D d(Companion companion, ByteString byteString, x xVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = null;
            }
            return companion.b(byteString, xVar);
        }

        public final AbstractC5531D a(InterfaceC0968f interfaceC0968f, x xVar, long j10) {
            kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
            return new a(xVar, j10, interfaceC0968f);
        }

        public final AbstractC5531D b(ByteString byteString, x xVar) {
            kotlin.jvm.internal.p.i(byteString, "<this>");
            return a(new C0966d().j1(byteString), xVar, byteString.K());
        }

        public final AbstractC5531D c(x contentType, long contentLength, InterfaceC0968f content) {
            kotlin.jvm.internal.p.i(content, "content");
            return a(content, contentType, contentLength);
        }

        public Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f42132c = Companion.d(companion, ByteString.f37756e, null, 1, null);
    }

    public static final AbstractC5531D m(x xVar, long j10, InterfaceC0968f interfaceC0968f) {
        return INSTANCE.c(xVar, j10, interfaceC0968f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final String A() throws IOException {
        InterfaceC0968f f42140f = getF42140f();
        String th = null;
        try {
            String strS0 = f42140f.S0(ub.q.n(f42140f, g()));
            if (f42140f != null) {
                try {
                    f42140f.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            String str = th;
            th = strS0;
            th = str;
        } catch (Throwable th3) {
            th = th3;
            if (f42140f != null) {
                try {
                    f42140f.close();
                } catch (Throwable th4) {
                    Y8.d.a(th, th4);
                }
            }
        }
        if (th == 0) {
            return th;
        }
        throw th;
    }

    public final InputStream b() {
        return getF42140f().r1();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ub.n.f(getF42140f());
    }

    public final Reader e() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(getF42140f(), g());
        this.reader = aVar;
        return aVar;
    }

    public final Charset g() {
        return C5642b.a(getF42138d());
    }

    /* renamed from: i */
    public abstract long getF42139e();

    /* renamed from: l */
    public abstract x getF42138d();

    /* renamed from: n */
    public abstract InterfaceC0968f getF42140f();
}
