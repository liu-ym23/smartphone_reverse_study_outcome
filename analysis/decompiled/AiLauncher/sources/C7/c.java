package C7;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"LC7/c;", "", "<init>", "()V", "", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "DEFAULT_REDACTED_HEADERS", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1727a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Set<String> DEFAULT_REDACTED_HEADERS = Y.j("Authorization", "Cookie", "Set-Cookie", "Proxy-Authorization", "zy-app-id", "zy-sign", "zy-timestamp", "zy-nonce");

    public final Set<String> a() {
        return DEFAULT_REDACTED_HEADERS;
    }
}
