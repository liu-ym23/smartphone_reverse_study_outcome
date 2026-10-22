package com.amap.api.col.jmsl;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.jmsl.C1602s0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class N1 extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    public SSLSocketFactory f16221a;

    /* renamed from: b, reason: collision with root package name */
    public Context f16222b;

    /* renamed from: c, reason: collision with root package name */
    public SSLContext f16223c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16224d = false;

    public N1(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f16222b = context.getApplicationContext();
            } catch (Throwable th) {
                try {
                    C1541c2.b(th, "myssl", "<init>");
                    try {
                        if (this.f16223c == null) {
                            this.f16223c = SSLContext.getDefault();
                        }
                    } catch (Throwable th2) {
                        C1541c2.b(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.f16221a == null) {
                            this.f16221a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        C1541c2.b(th3, "myssl", "<init3>");
                        return;
                    }
                } finally {
                }
            }
        }
        this.f16223c = sSLContext;
        if (sSLContext != null) {
            this.f16221a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f16223c == null) {
                this.f16223c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            C1541c2.b(th4, "myssl", "<init2>");
        }
        try {
            if (this.f16221a == null) {
                this.f16221a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            C1541c2.b(th5, "myssl", "<init3>");
        }
    }

    public static void e(Socket socket) {
        int i10 = Build.VERSION.SDK_INT;
        if (C1602s0.g.f16912c && C1602s0.g.f16914e && (socket instanceof SSLSocket)) {
            int i11 = C1602s0.g.f16915f;
            int i12 = C1602s0.g.f16913d;
            if (i11 > i12) {
                i11 = i12;
            }
            if (i11 <= 17 || i10 <= i11) {
                try {
                    socket.getClass().getMethod(C1604s2.m("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    C1541c2.b(th, "myssl", "sust");
                }
            }
        }
    }

    public final Socket a(Socket socket) {
        try {
            if (this.f16224d) {
                if (socket instanceof SSLSocket) {
                    ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
                    return socket;
                }
            } else if (C1602s0.g.f16911b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
            return socket;
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "stlv2");
            return socket;
        }
    }

    public void b() {
        int i10 = Build.VERSION.SDK_INT;
        if (!C1602s0.g.f16912c || this.f16222b == null || this.f16223c == null) {
            return;
        }
        int i11 = C1602s0.g.f16913d;
        if (i11 <= 17 || i10 <= i11) {
            c(new SSLSessionCache(this.f16222b));
        }
    }

    public final void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f16223c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(C1604s2.m("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String strM = C1604s2.m("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(strM)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket());
            e(socketA);
            return socketA;
        } finally {
            if (!z10) {
            }
        }
    }

    public void d(boolean z10) {
        this.f16224d = z10;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        boolean z11;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(socket, str, i10, z10));
            e(socketA);
            return socketA;
        } finally {
            if (!z11) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(str, i10));
            e(socketA);
            return socketA;
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "cs3");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(str, i10, inetAddress, i11));
            e(socketA);
            return socketA;
        } catch (Throwable th) {
            C1541c2.b(th, "myssl", "cs4");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(inetAddress, i10));
            e(socketA);
            return socketA;
        } finally {
            if (!z10) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        boolean z10;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f16221a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket socketA = a(sSLSocketFactory.createSocket(inetAddress, i10, inetAddress2, i11));
            e(socketA);
            return socketA;
        } finally {
            if (!z10) {
            }
        }
    }
}
