package Fb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001a¨\u0006\u001c"}, d2 = {"LFb/i;", "LFb/j;", "LFb/i$a;", "socketAdapterFactory", "<init>", "(LFb/i$a;)V", "", Const.INTENT_KEY_PKGNAME, "()Z", "Ljavax/net/ssl/SSLSocket;", "sslSocket", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "LY8/t;", "f", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "c", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljavax/net/ssl/SSLSocket;)LFb/j;", "LFb/i$a;", "LFb/j;", "delegate", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a socketAdapterFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public j delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"LFb/i$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", Const.INTENT_KEY_APIKEY, "(Ljavax/net/ssl/SSLSocket;)Z", "LFb/j;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSocket;)LFb/j;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        boolean a(SSLSocket sslSocket);

        j b(SSLSocket sslSocket);
    }

    public i(a socketAdapterFactory) {
        p.i(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    @Override // Fb.j
    public boolean a(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        return this.socketAdapterFactory.a(sslSocket);
    }

    @Override // Fb.j
    public boolean b() {
        return true;
    }

    @Override // Fb.j
    public String c(SSLSocket sslSocket) {
        p.i(sslSocket, "sslSocket");
        j jVarG = g(sslSocket);
        if (jVarG != null) {
            return jVarG.c(sslSocket);
        }
        return null;
    }

    @Override // Fb.j
    public void f(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) {
        p.i(sslSocket, "sslSocket");
        p.i(protocols, "protocols");
        j jVarG = g(sslSocket);
        if (jVarG != null) {
            jVarG.f(sslSocket, hostname, protocols);
        }
    }

    public final synchronized j g(SSLSocket sslSocket) {
        try {
            if (this.delegate == null && this.socketAdapterFactory.a(sslSocket)) {
                this.delegate = this.socketAdapterFactory.b(sslSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }
}
