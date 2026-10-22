package okhttp3.internal.http;

import h3.L;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lh3/L;", "", "code", "", "shouldIgnoreAndWaitForRealResponse", "(I)Z", "Lh3/K;", "chain", "Lh3/b0;", "intercept", "(Lh3/K;)Lh3/b0;", "forWebSocket", "Z", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements L {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z4) {
        this.forWebSocket = z4;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0153 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164 A[Catch: IOException -> 0x00b7, TryCatch #1 {IOException -> 0x00b7, blocks: (B:39:0x00a9, B:41:0x00b2, B:44:0x00ba, B:46:0x00e0, B:48:0x00e9, B:49:0x00ec, B:50:0x010c, B:54:0x0117, B:56:0x0132, B:58:0x013e, B:65:0x0153, B:71:0x0164, B:75:0x0180, B:76:0x018a, B:74:0x0178, B:68:0x015a, B:60:0x0148, B:55:0x0124), top: B:86:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // h3.L
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h3.b0 intercept(@org.jetbrains.annotations.NotNull h3.K r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(h3.K):h3.b0");
    }
}
