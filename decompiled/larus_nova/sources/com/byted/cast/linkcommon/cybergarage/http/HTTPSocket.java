package com.byted.cast.linkcommon.cybergarage.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPSocket {
    private InputStream sockIn;
    private OutputStream sockOut;
    private Socket socket;

    public boolean close() {
        InputStream r100 = this.sockIn;     // Catch: Exception -> L13
        if (r100 == null) goto L5;
        r100.close();     // Catch: Exception -> L13
    L5:
        OutputStream r101 = this.sockOut;     // Catch: Exception -> L13
        if (r101 == null) goto L9;
        r101.close();     // Catch: Exception -> L13
    L9:
        if (getSocket() == null) goto L17;
        getSocket().close();     // Catch: Exception -> L13
        return true;
    L17:
        return true;
    L13:
        return false;
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress().getHostAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public boolean open() {
        Socket r100 = getSocket();
        this.sockIn = r100.getInputStream();     // Catch: Exception -> L6
        this.sockOut = r100.getOutputStream();     // Catch: Exception -> L6
        return true;
    L6:
        return false;
    }

    private OutputStream getOutputStream() {
        return this.sockOut;
    }

    public void finalize() {
        close();
    }

    public InputStream getInputStream() {
        return this.sockIn;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public HTTPSocket(HTTPSocket r100) {
        this.socket = null;
        this.sockIn = null;
        this.sockOut = null;
        setSocket(r100.getSocket());
        setInputStream(r100.getInputStream());
        setOutputStream(r100.getOutputStream());
    }

    private void setInputStream(InputStream r100) {
        this.sockIn = r100;
    }

    private void setOutputStream(OutputStream r100) {
        this.sockOut = r100;
    }

    private void setSocket(Socket r100) {
        this.socket = r100;
    }

    public HTTPSocket(Socket r100) {
        this.socket = null;
        this.sockIn = null;
        this.sockOut = null;
        setSocket(r100);
        open();
    }

    public boolean post(HTTPResponse r110, long r111, long r112, boolean r113) {
        if (r110.hasContentInputStream() != true) goto L7;
        return post(r110, r110.getContentInputStream(), r111, r112, r113);
    L7:
        return post(r110, r110.getContent(), r111, r112, r113);
    }

    private boolean post(HTTPResponse r110, InputStream r111, long r112, long r210, boolean r211) {
        r110.setDate(Calendar.getInstance());
        OutputStream r100 = getOutputStream();
        r110.setContentLength(r210);     // Catch: Throwable -> L38 Exception -> L46
        r100.write(r110.getHeader().getBytes());     // Catch: Throwable -> L38 Exception -> L46
        r100.write("\r\n".getBytes());     // Catch: Throwable -> L38 Exception -> L46
        if (r211 != true) goto L11;
        r100.flush();     // Catch: Throwable -> L38 Exception -> L46
        r100.flush();     // Catch: IOException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        boolean r101 = r110.isChunked();     // Catch: Throwable -> L38 Exception -> L46
        long r102 = 0;
        if (0 >= r112) goto L14;
        r111.skip(r112);     // Catch: Throwable -> L38 Exception -> L46
    L14:
        int r113 = HTTP.getChunkSize();     // Catch: Throwable -> L38 Exception -> L46
        byte[] r114 = new byte[r113];     // Catch: Throwable -> L38 Exception -> L46
        long r115 = r113;
        if (r115 >= r210) goto L17;
        long r116 = r115;
    L18:
        int r117 = r111.read(r114, 0, (int) r116);     // Catch: Throwable -> L38 Exception -> L46
    L19:
        if (r117 <= 0) goto L31;
        if (r102 >= r210) goto L31;
        if (r101 != true) goto L24;
        r100.write(Long.toHexString(r117).getBytes());     // Catch: Throwable -> L38 Exception -> L46
        r100.write("\r\n".getBytes());     // Catch: Throwable -> L38 Exception -> L46
    L24:
        r100.write(r114, 0, r117);     // Catch: Throwable -> L38 Exception -> L46
        if (r101 != true) goto L27;
        r100.write("\r\n".getBytes());     // Catch: Throwable -> L38 Exception -> L46
    L27:
        r102 = r102 + ((long) r117);     // Catch: Throwable -> L38 Exception -> L46
        long r118 = r210 - r102;     // Catch: Throwable -> L38 Exception -> L46
        if (r115 >= r118) goto L30;
        r118 = r115;
    L30:
        r117 = r111.read(r114, 0, (int) r118);     // Catch: Throwable -> L38 Exception -> L46
    L31:
        if (r101 != true) goto L53;
        r100.write("0".getBytes());     // Catch: Throwable -> L38 Exception -> L46
        r100.write("\r\n".getBytes());     // Catch: Throwable -> L38 Exception -> L46
    L53:
        r100.flush();     // Catch: IOException -> L35
    L37:
        return true;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L17:
        r116 = r210;
    L38:
        th = move-exception;
        if (r100 == null) goto L66;
        r100.flush();     // Catch: IOException -> L43
        throw th;
    L43:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L66:
        throw th;
    L47:
        if (r100 != null) goto L59;
    L52:
        return false;
    L59:
        r100.flush();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    }

    private boolean post(HTTPResponse r100, byte[] r101, long r102, long r103, boolean r110) {
        r100.setDate(Calendar.getInstance());
        OutputStream r104 = getOutputStream();
        r100.setContentLength(r103);     // Catch: Throwable -> L22 Exception -> L29
        r104.write(r100.getHeader().getBytes());     // Catch: Throwable -> L22 Exception -> L29
        r104.write("\r\n".getBytes());     // Catch: Throwable -> L22 Exception -> L29
        if (r110 != true) goto L11;
        r104.flush();     // Catch: Throwable -> L22 Exception -> L29
        r104.flush();     // Catch: IOException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        boolean r105 = r100.isChunked();     // Catch: Throwable -> L22 Exception -> L29
        if (r105 != true) goto L14;
        r104.write(Long.toHexString(r103).getBytes());     // Catch: Throwable -> L22 Exception -> L29
        r104.write("\r\n".getBytes());     // Catch: Throwable -> L22 Exception -> L29
    L14:
        r104.write(r101, (int) r102, (int) r103);     // Catch: Throwable -> L22 Exception -> L29
        if (r105 != true) goto L41;
        r104.write("\r\n".getBytes());     // Catch: Throwable -> L22 Exception -> L29
        r104.write("0".getBytes());     // Catch: Throwable -> L22 Exception -> L29
        r104.write("\r\n".getBytes());     // Catch: Throwable -> L22 Exception -> L29
    L41:
        r104.flush();     // Catch: IOException -> L19
    L21:
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        th = move-exception;
        if (r104 != null) goto L37;
    L28:
        throw th;
    L37:
        r104.flush();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L30:
        if (r104 == null) goto L46;
        r104.flush();     // Catch: IOException -> L33
        return false;
    L33:
        e = move-exception;
        e.printStackTrace();
        return false;
    L46:
        return false;
    }
}
