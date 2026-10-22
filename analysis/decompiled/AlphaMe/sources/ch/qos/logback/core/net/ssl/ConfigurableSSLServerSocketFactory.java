package ch.qos.logback.core.net.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: classes.dex */
public class ConfigurableSSLServerSocketFactory extends ServerSocketFactory {
    private final SSLServerSocketFactory delegate;
    private final SSLParametersConfiguration parameters;

    public ConfigurableSSLServerSocketFactory(SSLParametersConfiguration sSLParametersConfiguration, SSLServerSocketFactory sSLServerSocketFactory) {
        this.parameters = sSLParametersConfiguration;
        this.delegate = sSLServerSocketFactory;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i4, int i5, InetAddress inetAddress) throws IOException {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.delegate.createServerSocket(i4, i5, inetAddress);
        this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i4, int i5) throws IOException {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.delegate.createServerSocket(i4, i5);
        this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i4) throws IOException {
        SSLServerSocket sSLServerSocket = (SSLServerSocket) this.delegate.createServerSocket(i4);
        this.parameters.configure(new SSLConfigurableServerSocket(sSLServerSocket));
        return sSLServerSocket;
    }
}
