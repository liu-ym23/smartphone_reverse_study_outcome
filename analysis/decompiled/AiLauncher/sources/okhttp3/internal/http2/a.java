package okhttp3.internal.http2;

import Cb.WindowCounter;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lokhttp3/internal/http2/a;", "", "", "streamId", "LCb/a;", "windowCounter", "", "bufferSize", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ILCb/a;J)V", Const.INTENT_KEY_PKGNAME, "(LCb/a;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface a {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/http2/a$a;", "Lokhttp3/internal/http2/a;", "<init>", "()V", "", "streamId", "LCb/a;", "windowCounter", "", "bufferSize", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ILCb/a;J)V", Const.INTENT_KEY_PKGNAME, "(LCb/a;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    public static final class C0482a implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0482a f37647a = new C0482a();

        @Override // okhttp3.internal.http2.a
        public void a(int streamId, WindowCounter windowCounter, long bufferSize) {
            p.i(windowCounter, "windowCounter");
        }

        @Override // okhttp3.internal.http2.a
        public void b(WindowCounter windowCounter) {
            p.i(windowCounter, "windowCounter");
        }
    }

    void a(int streamId, WindowCounter windowCounter, long bufferSize);

    void b(WindowCounter windowCounter);
}
