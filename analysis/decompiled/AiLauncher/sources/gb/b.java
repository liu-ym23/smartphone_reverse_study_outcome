package gb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgb/a;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "", Const.INTENT_KEY_APIKEY, "(Lgb/a;Ljava/nio/charset/Charset;)Ljava/lang/String;", "kotlinx-io-bytestring"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {
    public static final String a(C4114a c4114a, Charset charset) {
        p.i(c4114a, "<this>");
        p.i(charset, "charset");
        return new String(c4114a.getData(), charset);
    }
}
