package tb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltb/w;", "", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface w {

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0014\u0010(\u001a\u00020%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006)À\u0006\u0001"}, d2 = {"Ltb/w$a;", "", "Ltb/A;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "request", "Ltb/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/A;)Ltb/C;", "Ltb/j;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ltb/j;", "Ltb/e;", "call", "()Ltb/e;", "", "k", "()Z", "followSslRedirects", Const.INTENT_KEY_APIKEY, "followRedirects", "e", "retryOnConnectionFailure", "Ltb/b;", "f", "()Ltb/b;", "authenticator", "Ltb/m;", "c", "()Ltb/m;", "cookieJar", "Ltb/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ltb/c;", "cache", Const.INTENT_KEY_UMID, "proxyAuthenticator", "Ltb/q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ltb/q;", "eventListener", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        boolean a();

        C5528A b();

        InterfaceC5546m c();

        InterfaceC5538e call();

        InterfaceC5535b d();

        boolean e();

        InterfaceC5535b f();

        InterfaceC5543j g();

        AbstractC5550q h();

        C5530C i(C5528A request) throws IOException;

        C5536c j();

        boolean k();
    }

    C5530C intercept(a chain) throws IOException;
}
