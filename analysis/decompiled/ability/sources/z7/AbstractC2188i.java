package z7;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* renamed from: z7.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2188i {
    public static final Pattern f = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    public static final Pattern g = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    public static final Pattern h = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    public static final Logger i = Logger.getLogger(AbstractC2188i.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final String f6980a;
    public final int b;
    public volatile ServerSocket c;
    public Thread d;
    public InterfaceC2180a e;

    public AbstractC2188i(String str, int i6) {
        this.f6980a = str;
        this.b = i6;
        L9.a aVar = new L9.a();
        aVar.b = Collections.synchronizedList(new ArrayList());
        this.e = aVar;
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            i.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    public static fi.iki.elonen.a c(InterfaceC2187h interfaceC2187h, String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes;
        C2182c c2182c = new C2182c(str);
        if (str2 == null) {
            return new fi.iki.elonen.a(interfaceC2187h, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(c2182c.a()).newEncoder().canEncode(str2) && c2182c.c == null) {
                c2182c = new C2182c(str.concat("; charset=UTF-8"));
            }
            bytes = str2.getBytes(c2182c.a());
        } catch (UnsupportedEncodingException e) {
            i.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bytes = new byte[0];
        }
        return new fi.iki.elonen.a(interfaceC2187h, c2182c.f6975a, new ByteArrayInputStream(bytes), bytes.length);
    }

    public static final void d(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                i.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public static boolean h(fi.iki.elonen.a aVar) {
        String str = aVar.b;
        if (str != null) {
            return str.toLowerCase().contains("text/") || aVar.b.toLowerCase().contains("/json");
        }
        return false;
    }

    public abstract fi.iki.elonen.a e(C2185f c2185f);

    public final void f() throws IOException {
        this.c = new ServerSocket();
        this.c.setReuseAddress(true);
        C0.c cVar = new C0.c(this);
        Thread thread = new Thread(cVar);
        this.d = thread;
        thread.setDaemon(true);
        this.d.setName("NanoHttpd Main Listener");
        this.d.start();
        while (!cVar.b && ((IOException) cVar.c) == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = (IOException) cVar.c;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void g() throws InterruptedException {
        try {
            d(this.c);
            this.e.b();
            Thread thread = this.d;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e) {
            i.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }
}
