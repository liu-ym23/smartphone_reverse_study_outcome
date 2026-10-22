package com.stepos.agentframework.adapter.coze.interceptor;

import Mb.C0966d;
import Mb.InterfaceC0968f;
import Mb.n;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.platform.c;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5543j;
import tb.u;
import tb.w;
import tb.x;
import zb.C6481e;

/* loaded from: classes2.dex */
public final class LlmHttpLoggingInterceptor implements w {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Set<String> headersToRedact = Collections.EMPTY_SET;
    private volatile Level level = Level.NONE;
    private final a logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface a {
        public static final a DEFAULT = new C0244a();

        /* renamed from: com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        public class C0244a implements a {
            @Override // com.stepos.agentframework.adapter.coze.interceptor.LlmHttpLoggingInterceptor.a
            public void a(String str) {
                c.get().log(str, 4, null);
            }
        }

        void a(String str);
    }

    public LlmHttpLoggingInterceptor(a aVar) {
        this.logger = aVar;
    }

    public static boolean a(u uVar) {
        String strB = uVar.b(e.f30849h);
        return (strB == null || strB.equalsIgnoreCase(e.f30860s) || strB.equalsIgnoreCase("gzip")) ? false : true;
    }

    public static boolean b(C5530C c5530c) {
        x mediaType = c5530c.getBody().getMediaType();
        return mediaType != null && mediaType.getType().equalsIgnoreCase("text") && mediaType.getSubtype().equalsIgnoreCase("event-stream");
    }

    public static boolean c(C0966d c0966d) {
        try {
            C0966d c0966d2 = new C0966d();
            c0966d.V(c0966d2, 0L, c0966d.getSize() < 64 ? c0966d.getSize() : 64L);
            for (int i10 = 0; i10 < 16; i10++) {
                if (c0966d2.k()) {
                    return true;
                }
                int iU0 = c0966d2.U0();
                if (Character.isISOControl(iU0) && !Character.isWhitespace(iU0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void d(u uVar, int i10) {
        String strK = this.headersToRedact.contains(uVar.f(i10)) ? "██" : uVar.k(i10);
        this.logger.a(uVar.f(i10) + ": " + strK);
    }

    public LlmHttpLoggingInterceptor e(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.lang.Long] */
    @Override // tb.w
    public C5530C intercept(w.a aVar) throws Exception {
        long j10;
        boolean z10;
        String string;
        n nVar;
        Level level = this.level;
        C5528A request = aVar.getRequest();
        if (level == Level.NONE) {
            return aVar.i(request);
        }
        boolean z11 = level == Level.BODY;
        boolean z12 = z11 || level == Level.HEADERS;
        AbstractC5529B body = request.getBody();
        boolean z13 = body != null;
        InterfaceC5543j interfaceC5543jG = aVar.g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.getMethod());
        sb2.append(' ');
        sb2.append(request.getUrl());
        sb2.append(interfaceC5543jG != null ? " " + interfaceC5543jG.getProtocol() : "");
        String string2 = sb2.toString();
        if (!z12 && z13) {
            string2 = string2 + " (" + body.a() + "-byte body)";
        }
        this.logger.a(string2);
        if (z12) {
            if (z13) {
                if (body.getMedia() != null) {
                    a aVar2 = this.logger;
                    StringBuilder sb3 = new StringBuilder();
                    j10 = -1;
                    sb3.append("Content-Type: ");
                    sb3.append(body.getMedia());
                    aVar2.a(sb3.toString());
                } else {
                    j10 = -1;
                }
                if (body.a() != j10) {
                    this.logger.a("Content-Length: " + body.a());
                }
            } else {
                j10 = -1;
            }
            u headers = request.getHeaders();
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = headers.f(i10);
                if (!"Content-Type".equalsIgnoreCase(strF) && !"Content-Length".equalsIgnoreCase(strF)) {
                    d(headers, i10);
                }
            }
            if (!z11 || !z13) {
                this.logger.a("--> END " + request.getMethod());
            } else if (a(request.getHeaders())) {
                this.logger.a("--> END " + request.getMethod() + " (encoded body omitted)");
            } else {
                C0966d c0966d = new C0966d();
                body.g(c0966d);
                Charset charsetC = UTF8;
                x media = body.getMedia();
                if (media != null) {
                    charsetC = media.c(charsetC);
                }
                this.logger.a("");
                if (c(c0966d)) {
                    this.logger.a(c0966d.S0(charsetC));
                    this.logger.a("--> END " + request.getMethod() + " (" + body.a() + "-byte body)");
                } else {
                    this.logger.a("--> END " + request.getMethod() + " (binary " + body.a() + "-byte body omitted)");
                }
            }
        } else {
            j10 = -1;
        }
        long jNanoTime = System.nanoTime();
        try {
            C5530C c5530cI = aVar.i(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            AbstractC5531D body2 = c5530cI.getBody();
            long contentLength = body2.getContentLength();
            String str = contentLength != j10 ? contentLength + "-byte" : "unknown-length";
            a aVar3 = this.logger;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(c5530cI.getCode());
            if (c5530cI.getMessage().isEmpty()) {
                z10 = z12;
                string = "";
            } else {
                StringBuilder sb5 = new StringBuilder();
                z10 = z12;
                sb5.append(' ');
                sb5.append(c5530cI.getMessage());
                string = sb5.toString();
            }
            sb4.append(string);
            sb4.append(' ');
            sb4.append(c5530cI.getRequest().getUrl());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            sb4.append(z10 ? "" : ", " + str + " body");
            sb4.append(')');
            aVar3.a(sb4.toString());
            if (z10) {
                u headers2 = c5530cI.getHeaders();
                int size2 = headers2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    d(headers2, i11);
                }
                if (z11 && C6481e.a(c5530cI)) {
                    if (a(c5530cI.getHeaders())) {
                        this.logger.a("<-- END HTTP (encoded body omitted)");
                        return c5530cI;
                    }
                    if (b(c5530cI)) {
                        this.logger.a("<-- END HTTP (streaming)");
                        return c5530cI;
                    }
                    InterfaceC0968f source = body2.getSource();
                    source.request(Long.MAX_VALUE);
                    C0966d c0966dU = source.u();
                    n nVar2 = null;
                    if ("gzip".equalsIgnoreCase(headers2.b(e.f30849h))) {
                        ?? ValueOf = Long.valueOf(c0966dU.getSize());
                        try {
                            nVar = new n(c0966dU.clone());
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            c0966dU = new C0966d();
                            c0966dU.V0(nVar);
                            nVar.close();
                            nVar2 = ValueOf;
                        } catch (Throwable th2) {
                            th = th2;
                            nVar2 = nVar;
                            if (nVar2 != null) {
                                nVar2.close();
                            }
                            throw th;
                        }
                    }
                    Charset charsetC2 = UTF8;
                    x mediaType = body2.getMediaType();
                    if (mediaType != null) {
                        charsetC2 = mediaType.c(charsetC2);
                    }
                    if (!c(c0966dU)) {
                        this.logger.a("");
                        this.logger.a("<-- END HTTP (binary " + c0966dU.getSize() + "-byte body omitted)");
                        return c5530cI;
                    }
                    if (contentLength != 0) {
                        this.logger.a("");
                        this.logger.a(c0966dU.clone().S0(charsetC2));
                    }
                    if (nVar2 == null) {
                        this.logger.a("<-- END HTTP (" + c0966dU.getSize() + "-byte body)");
                        return c5530cI;
                    }
                    this.logger.a("<-- END HTTP (" + c0966dU.getSize() + "-byte, " + nVar2 + "-gzipped-byte body)");
                    return c5530cI;
                }
                this.logger.a("<-- END HTTP");
            }
            return c5530cI;
        } catch (Exception e10) {
            this.logger.a("<-- HTTP FAILED: " + e10);
            throw e10;
        }
    }
}
