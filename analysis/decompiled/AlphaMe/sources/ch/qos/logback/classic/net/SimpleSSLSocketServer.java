package ch.qos.logback.classic.net;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import java.security.NoSuchAlgorithmException;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;

/* loaded from: classes.dex */
public class SimpleSSLSocketServer extends SimpleSocketServer {
    private final ServerSocketFactory socketFactory;

    public SimpleSSLSocketServer(LoggerContext loggerContext, int i4) throws NoSuchAlgorithmException {
        this(loggerContext, i4, SSLContext.getDefault());
    }

    public static void main(String[] strArr) throws Exception {
        SimpleSocketServer.doMain(SimpleSSLSocketServer.class, strArr);
    }

    @Override // ch.qos.logback.classic.net.SimpleSocketServer
    public ServerSocketFactory getServerSocketFactory() {
        return this.socketFactory;
    }

    public SimpleSSLSocketServer(LoggerContext loggerContext, int i4, SSLContext sSLContext) {
        super(loggerContext, i4);
        if (sSLContext == null) {
            throw new NullPointerException("SSL context required");
        }
        SSLParametersConfiguration sSLParametersConfiguration = new SSLParametersConfiguration();
        sSLParametersConfiguration.setContext(loggerContext);
        this.socketFactory = new ConfigurableSSLServerSocketFactory(sSLParametersConfiguration, sSLContext.getServerSocketFactory());
    }
}
