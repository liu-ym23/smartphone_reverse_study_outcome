package fb;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\"\u001c\u0010\r\u001a\u00020\n*\u00060\bj\u0002`\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Ljava/io/OutputStream;", "Lfb/j;", Const.INTENT_KEY_APIKEY, "(Ljava/io/OutputStream;)Lfb/j;", "Ljava/io/InputStream;", "Lfb/k;", Const.INTENT_KEY_PKGNAME, "(Ljava/io/InputStream;)Lfb/k;", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "", "c", "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4080g {
    public static final InterfaceC4083j a(OutputStream outputStream) {
        kotlin.jvm.internal.p.i(outputStream, "<this>");
        return new RawSink(outputStream);
    }

    public static final InterfaceC4084k b(InputStream inputStream) {
        kotlin.jvm.internal.p.i(inputStream, "<this>");
        return new RawSource(inputStream);
    }

    public static final boolean c(AssertionError assertionError) {
        kotlin.jvm.internal.p.i(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? H.g0(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }
}
