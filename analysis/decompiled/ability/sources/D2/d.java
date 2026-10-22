package D2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class d extends SSLSocketFactory {
    public static final String[] b = {"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f375a;

    public d(SSLSocketFactory sSLSocketFactory) {
        this.f375a = sSLSocketFactory;
    }

    public static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(b);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z10) throws IOException {
        Socket socketCreateSocket = this.f375a.createSocket(socket, str, i, z10);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f375a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f375a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.f375a.createSocket(str, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i6) throws IOException {
        Socket socketCreateSocket = this.f375a.createSocket(str, i, inetAddress, i6);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.f375a.createSocket(inetAddress, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i6) throws IOException {
        Socket socketCreateSocket = this.f375a.createSocket(inetAddress, i, inetAddress2, i6);
        a(socketCreateSocket);
        return socketCreateSocket;
    }
}
