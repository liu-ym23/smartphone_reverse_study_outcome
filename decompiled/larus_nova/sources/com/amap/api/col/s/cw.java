package com.amap.api.col.s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
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

/* JADX INFO: loaded from: classes28.dex */
public final class cw extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f26516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f26517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SSLContext f26518c;

    public final void a() {
        int r100 = Build.VERSION.SDK_INT;
        if (bj.f.f26242c == true) goto L6;
        return;
    L6:
        if (this.f26517b != null) goto L8;
        return;
    L8:
        if (this.f26518c == null) goto L26;
        int r101 = bj.f.f26243d;
        if (r101 <= 17) goto L14;
        if (r100 <= r101) goto L14;
        return;
    L14:
        SSLSessionCache r102 = new SSLSessionCache(this.f26517b);
        if (r100 < 28) goto L23;
        a(r102);
        return;
    L23:
        r102.getClass().getMethod(bs.c("MaW5zdGFsbA"), new Class[]{SSLSessionCache.class, SSLContext.class}).invoke(r102, new Object[]{r102, this.f26518c});     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        cg.c(th, "myssl", "isc1");
        a(r102);
        return;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        SSLSocketFactory r100 = this.f26516a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Socket r101 = a(r100.createSocket());     // Catch: Throwable -> L6
        b(r101);     // Catch: Throwable -> L6
        return r101;
    L9:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs1");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r100 = this.f26516a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        return r100.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        cg.c(th, "myssl", "gdcs");
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r100 = this.f26516a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        return r100.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        cg.c(th, "myssl", "gscs");
        goto L9
    }

    private void a(SSLSessionCache r110) {
        SSLContext r100 = this.f26518c;
        if (r100 != null) goto L16;
        return;
    L16:
        SSLSessionContext r101 = r100.getClientSessionContext();     // Catch: Throwable -> L13
        Field r102 = r110.getClass().getDeclaredField(bs.c("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L13
        r102.setAccessible(true);     // Catch: Throwable -> L13
        Object r111 = r102.get(r110);     // Catch: Throwable -> L13
        Method[] r103 = r101.getClass().getMethods();     // Catch: Throwable -> L13
        String r104 = bs.c("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L13
        int r105 = r103.length;     // Catch: Throwable -> L13
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        Method r107 = r103[r106];     // Catch: Throwable -> L13
        if (r107.getName().equals(r104) == true) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        r107.invoke(r101, new Object[]{r111});     // Catch: Throwable -> L13
        return;
    L12:
        return;
    L13:
        th = move-exception;
        cg.c(th, "myssl", "isc2");
    }

    private static void b(Socket r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (bj.f.f26242c == true) goto L5;
        return;
    L5:
        if (bj.f.f26244e == true) goto L8;
        return;
    L8:
        if ((r100 instanceof SSLSocket) == true) goto L10;
        return;
    L10:
        int r102 = bj.f.f26245f;
        int r103 = bj.f.f26243d;
        if (r102 <= r103) goto L14;
        r102 = r103;
    L14:
        if (r102 <= 17) goto L17;
        if (r101 <= r102) goto L17;
        return;
    L17:
        Class<?> r104 = r100.getClass();
        r104.getMethod(bs.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r100, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        cg.c(th, "myssl", "sust");
    }

    private static Socket a(Socket r100) {
    L8:
        th = move-exception;
        cg.c(th, "myssl", "stlv2");
    L10:
        return r100;
    L3:
        if (bj.f.f26241b == false) goto L10;
        if ((r100 instanceof SSLSocket) == false) goto L10;
        ((SSLSocket) r100).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L8
        goto L10
    }

    public cw(Context r100, SSLContext r101) {
        if (r100 != null) goto L58;
    L5:
        this.f26518c = r101;     // Catch: Throwable -> L21
        if (r101 == null) goto L54;
        this.f26516a = r101.getSocketFactory();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        cg.c(th, "myssl", "<init>");     // Catch: Throwable -> L36
    L27:
        th = move-exception;
        cg.c(th, "myssl", "<init2>");
    L62:
    L33:
        th = move-exception;
        cg.c(th, "myssl", "<init3>");
        return;
    L30:
        if (this.f26516a != null) goto L68;
        this.f26516a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L33
        return;
    L68:
        return;
    L24:
        if (this.f26518c != null) goto L62;
        this.f26518c = SSLContext.getDefault();     // Catch: Throwable -> L27
    L36:
        th = move-exception;
    L41:
        th = move-exception;
        cg.c(th, "myssl", "<init2>");
    L50:
    L47:
        th = move-exception;
        cg.c(th, "myssl", "<init3>");
        throw th;
    L44:
        if (this.f26516a != null) goto L70;
        this.f26516a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L47
        throw th;
    L70:
        throw th;
    L38:
        if (this.f26518c != null) goto L50;
        this.f26518c = SSLContext.getDefault();     // Catch: Throwable -> L41
    L54:
    L12:
        th = move-exception;
        cg.c(th, "myssl", "<init2>");
    L56:
    L18:
        th = move-exception;
        cg.c(th, "myssl", "<init3>");
        return;
    L15:
        if (this.f26516a != null) goto L66;
        this.f26516a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L18
        return;
    L66:
        return;
    L9:
        if (this.f26518c != null) goto L56;
        this.f26518c = SSLContext.getDefault();     // Catch: Throwable -> L12
        goto L56
    L58:
        this.f26517b = r100.getApplicationContext();     // Catch: Throwable -> L21
        goto L5
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        SSLSocketFactory r102 = this.f26516a;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        Socket r103 = a(r102.createSocket(r100, r101));     // Catch: Throwable -> L6
        b(r103);     // Catch: Throwable -> L6
        return r103;
    L11:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs3");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101) throws IOException {
        SSLSocketFactory r102 = this.f26516a;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        Socket r103 = a(r102.createSocket(r100, r101));     // Catch: Throwable -> L6
        b(r103);     // Catch: Throwable -> L6
        return r103;
    L9:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs5");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        SSLSocketFactory r104 = this.f26516a;     // Catch: Throwable -> L6
        if (r104 == null) goto L11;
        Socket r105 = a(r104.createSocket(r100, r101, r102, r103));     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        return r105;
    L11:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs4");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        SSLSocketFactory r104 = this.f26516a;     // Catch: Throwable -> L6
        if (r104 == null) goto L9;
        Socket r105 = a(r104.createSocket(r100, r101, r102, r103));     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        return r105;
    L9:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs6");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        SSLSocketFactory r104 = this.f26516a;     // Catch: Throwable -> L6
        if (r104 == null) goto L9;
        Socket r105 = a(r104.createSocket(r100, r101, r102, r103));     // Catch: Throwable -> L6
        b(r105);     // Catch: Throwable -> L6
        return r105;
    L9:
        return null;
    L6:
        th = move-exception;
        cg.c(th, "myssl", "cs2");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }
}
