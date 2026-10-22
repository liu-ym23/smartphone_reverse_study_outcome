package tb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltb/n;", "", "<init>", "()V", "", "username", "password", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5547n {

    /* renamed from: a, reason: collision with root package name */
    public static final C5547n f42218a = new C5547n();

    public static final String a(String username, String password, Charset charset) {
        kotlin.jvm.internal.p.i(username, "username");
        kotlin.jvm.internal.p.i(password, "password");
        kotlin.jvm.internal.p.i(charset, "charset");
        return "Basic " + ByteString.INSTANCE.c(username + ':' + password, charset).a();
    }
}
