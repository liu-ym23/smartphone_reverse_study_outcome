package Bb;

import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.http2.ErrorCode;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"LBb/r;", "", "", "streamId", "", "LBb/a;", "requestHeaders", "", Const.INTENT_KEY_PKGNAME, "(ILjava/util/List;)Z", "responseHeaders", "last", "c", "(ILjava/util/List;Z)Z", "LMb/f;", "source", "byteCount", Const.INTENT_KEY_UMID, "(ILMb/f;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ILokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f1573a;

    /* renamed from: b, reason: collision with root package name */
    public static final r f1572b = new Companion.C0013a();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\b"}, d2 = {"LBb/r$a;", "", "<init>", "()V", "LBb/r;", "CANCEL", "LBb/r;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Bb.r$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f1573a = new Companion();

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"LBb/r$a$a;", "LBb/r;", "<init>", "()V", "", "streamId", "", "LBb/a;", "requestHeaders", "", Const.INTENT_KEY_PKGNAME, "(ILjava/util/List;)Z", "responseHeaders", "last", "c", "(ILjava/util/List;Z)Z", "LMb/f;", "source", "byteCount", Const.INTENT_KEY_UMID, "(ILMb/f;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ILokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: Bb.r$a$a, reason: collision with other inner class name */
        public static final class C0013a implements r {
            @Override // Bb.r
            public void a(int streamId, ErrorCode errorCode) {
                kotlin.jvm.internal.p.i(errorCode, "errorCode");
            }

            @Override // Bb.r
            public boolean b(int streamId, List<a> requestHeaders) {
                kotlin.jvm.internal.p.i(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // Bb.r
            public boolean c(int streamId, List<a> responseHeaders, boolean last) {
                kotlin.jvm.internal.p.i(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // Bb.r
            public boolean d(int streamId, InterfaceC0968f source, int byteCount, boolean last) throws IOException {
                kotlin.jvm.internal.p.i(source, "source");
                source.skip(byteCount);
                return true;
            }
        }
    }

    void a(int streamId, ErrorCode errorCode);

    boolean b(int streamId, List<a> requestHeaders);

    boolean c(int streamId, List<a> responseHeaders, boolean last);

    boolean d(int streamId, InterfaceC0968f source, int byteCount, boolean last) throws IOException;
}
