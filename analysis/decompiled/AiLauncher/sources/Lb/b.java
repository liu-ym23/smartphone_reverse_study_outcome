package Lb;

import Mb.C0966d;
import Mb.InterfaceC0968f;
import Mb.x;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okio.ByteString;
import ub.n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0002\u0013\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017¨\u0006\u0019"}, d2 = {"LLb/b;", "", "LMb/f;", "source", "LLb/b$a;", "callback", "<init>", "(LMb/f;LLb/b$a;)V", "", Const.INTENT_KEY_UMID, "()Z", "", "id", "type", "LMb/d;", "data", "LY8/t;", "c", "(Ljava/lang/String;Ljava/lang/String;LMb/d;)V", Const.INTENT_KEY_APIKEY, "LMb/f;", Const.INTENT_KEY_PKGNAME, "LLb/b$a;", "Ljava/lang/String;", "lastId", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final x f4411e;

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f4412f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String lastId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"LLb/b$a;", "", "", "id", "type", "data", "LY8/t;", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "timeMs", Const.INTENT_KEY_PKGNAME, "(J)V", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void b(long timeMs);

        void c(String id, String type, String data);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LLb/b$b;", "", "<init>", "()V", "LMb/f;", "LMb/d;", "data", "LY8/t;", Const.INTENT_KEY_UMID, "(LMb/f;LMb/d;)V", "", "e", "(LMb/f;)J", "LMb/x;", "options", "LMb/x;", "c", "()LMb/x;", "Lokio/ByteString;", "CRLF", "Lokio/ByteString;", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Lb.b$b, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final x c() {
            return b.f4411e;
        }

        public final void d(InterfaceC0968f interfaceC0968f, C0966d c0966d) throws IOException {
            c0966d.writeByte(10);
            interfaceC0968f.O0(c0966d, interfaceC0968f.F(b.f4412f));
            interfaceC0968f.p0(c());
        }

        public final long e(InterfaceC0968f interfaceC0968f) throws IOException {
            return n.z(interfaceC0968f.h0(), -1L);
        }

        public Companion() {
        }
    }

    static {
        x.Companion companion = x.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        f4411e = companion.d(companion2.d(ServerSentEventKt.END_OF_LINE), companion2.d("\r"), companion2.d("\n"), companion2.d("data: "), companion2.d("data:"), companion2.d("data\r\n"), companion2.d("data\r"), companion2.d("data\n"), companion2.d("id: "), companion2.d("id:"), companion2.d("id\r\n"), companion2.d("id\r"), companion2.d("id\n"), companion2.d("event: "), companion2.d("event:"), companion2.d("event\r\n"), companion2.d("event\r"), companion2.d("event\n"), companion2.d("retry: "), companion2.d("retry:"));
        f4412f = companion2.d(ServerSentEventKt.END_OF_LINE);
    }

    public b(InterfaceC0968f source, a callback) {
        p.i(source, "source");
        p.i(callback, "callback");
        this.source = source;
        this.callback = callback;
    }

    public final void c(String id, String type, C0966d data) throws IOException {
        if (data.getSize() != 0) {
            this.lastId = id;
            data.skip(1L);
            this.callback.c(id, type, data.Y0());
        }
    }

    public final boolean d() throws IOException {
        String strH0 = this.lastId;
        C0966d c0966d = new C0966d();
        while (true) {
            String strH02 = null;
            while (true) {
                InterfaceC0968f interfaceC0968f = this.source;
                x xVar = f4411e;
                int iP0 = interfaceC0968f.p0(xVar);
                if (iP0 >= 0 && iP0 < 3) {
                    c(strH0, strH02, c0966d);
                    return true;
                }
                if (3 <= iP0 && iP0 < 5) {
                    INSTANCE.d(this.source, c0966d);
                } else if (5 <= iP0 && iP0 < 8) {
                    c0966d.writeByte(10);
                } else if (8 <= iP0 && iP0 < 10) {
                    strH0 = this.source.h0();
                    if (strH0.length() <= 0) {
                        strH0 = null;
                    }
                } else if (10 <= iP0 && iP0 < 13) {
                    strH0 = null;
                } else if (13 <= iP0 && iP0 < 15) {
                    strH02 = this.source.h0();
                    if (strH02.length() > 0) {
                    }
                } else if (15 > iP0 || iP0 >= 18) {
                    if (18 <= iP0 && iP0 < 20) {
                        long jE = INSTANCE.e(this.source);
                        if (jE != -1) {
                            this.callback.b(jE);
                        }
                    } else {
                        if (iP0 != -1) {
                            throw new AssertionError();
                        }
                        long jF = this.source.F(f4412f);
                        if (jF == -1) {
                            return false;
                        }
                        this.source.skip(jF);
                        this.source.p0(xVar);
                    }
                }
            }
        }
    }
}
