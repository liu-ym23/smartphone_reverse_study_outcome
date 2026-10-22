package fi.iki.elonen;

import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import org.json.HTTP;
import z7.AbstractC2188i;
import z7.C2182c;
import z7.C2186g;
import z7.InterfaceC2187h;

/* loaded from: classes2.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2187h f4454a;
    public final String b;
    public final ByteArrayInputStream c;
    public final long d;
    public final Map e = new NanoHTTPD$Response$1(this);
    public final HashMap f = new HashMap();
    public NanoHTTPD$Method g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4455j;

    public a(InterfaceC2187h interfaceC2187h, String str, ByteArrayInputStream byteArrayInputStream, long j5) {
        this.f4454a = interfaceC2187h;
        this.b = str;
        this.c = byteArrayInputStream;
        this.d = j5;
        this.h = j5 < 0;
        this.f4455j = true;
    }

    public static void i(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append(HTTP.CRLF);
    }

    public final void b(String str) {
        ((NanoHTTPD$Response$1) this.e).put("X-Mcp-Nonce", str);
    }

    public final void c() {
        ((NanoHTTPD$Response$1) this.e).put("connection", "close");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.c;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    public final String f(String str) {
        return (String) this.f.get(str.toLowerCase());
    }

    public final boolean g() {
        return "close".equals(f("connection"));
    }

    public final void k(OutputStream outputStream) throws IOException, NumberFormatException {
        String str = this.b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        InterfaceC2187h interfaceC2187h = this.f4454a;
        try {
            if (interfaceC2187h == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new C2182c(str).a())), false);
            printWriter.append("HTTP/1.1 ").append(interfaceC2187h.getDescription()).append(" \r\n");
            if (str != null) {
                i(printWriter, HttpHeaders.CONTENT_TYPE, str);
            }
            if (f("date") == null) {
                i(printWriter, "Date", simpleDateFormat.format(new Date()));
            }
            for (Map.Entry entry : ((HashMap) this.e).entrySet()) {
                i(printWriter, (String) entry.getKey(), (String) entry.getValue());
            }
            if (f("connection") == null) {
                i(printWriter, "Connection", this.f4455j ? "keep-alive" : "close");
            }
            if (f("content-length") != null) {
                this.i = false;
            }
            if (this.i) {
                i(printWriter, "Content-Encoding", "gzip");
                this.h = true;
            }
            ByteArrayInputStream byteArrayInputStream = this.c;
            long jN = byteArrayInputStream != null ? this.d : 0L;
            NanoHTTPD$Method nanoHTTPD$Method = this.g;
            NanoHTTPD$Method nanoHTTPD$Method2 = NanoHTTPD$Method.c;
            if (nanoHTTPD$Method != nanoHTTPD$Method2 && this.h) {
                i(printWriter, "Transfer-Encoding", "chunked");
            } else if (!this.i) {
                jN = n(jN, printWriter);
            }
            printWriter.append(HTTP.CRLF);
            printWriter.flush();
            if (this.g != nanoHTTPD$Method2 && this.h) {
                C2186g c2186g = new C2186g(outputStream);
                if (this.i) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(c2186g);
                    l(gZIPOutputStream, -1L);
                    gZIPOutputStream.finish();
                } else {
                    l(c2186g, -1L);
                }
                c2186g.b();
            } else if (this.i) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                l(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                l(outputStream, jN);
            }
            outputStream.flush();
            AbstractC2188i.d(byteArrayInputStream);
        } catch (IOException e) {
            AbstractC2188i.i.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
        }
    }

    public final void l(OutputStream outputStream, long j5) throws IOException {
        byte[] bArr = new byte[(int) 16384];
        boolean z10 = j5 == -1;
        while (true) {
            if (j5 <= 0 && !z10) {
                return;
            }
            int i = this.c.read(bArr, 0, (int) (z10 ? 16384L : Math.min(j5, 16384L)));
            if (i <= 0) {
                return;
            }
            outputStream.write(bArr, 0, i);
            if (!z10) {
                j5 -= i;
            }
        }
    }

    public final long n(long j5, PrintWriter printWriter) throws NumberFormatException {
        String strF = f("content-length");
        if (strF != null) {
            try {
                j5 = Long.parseLong(strF);
            } catch (NumberFormatException unused) {
                AbstractC2188i.i.severe("content-length was no number ".concat(strF));
            }
        }
        printWriter.print("Content-Length: " + j5 + HTTP.CRLF);
        return j5;
    }

    public final void r(boolean z10) {
        this.i = z10;
    }

    public final void s(boolean z10) {
        this.f4455j = z10;
    }

    public final void w(NanoHTTPD$Method nanoHTTPD$Method) {
        this.g = nanoHTTPD$Method;
    }
}
