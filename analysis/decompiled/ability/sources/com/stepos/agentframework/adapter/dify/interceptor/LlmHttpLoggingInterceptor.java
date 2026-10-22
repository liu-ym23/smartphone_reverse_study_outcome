package com.stepos.agentframework.adapter.dify.interceptor;

import F9.A;
import F9.B;
import F9.M;
import F9.w;
import N9.m;
import V9.g;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public final class LlmHttpLoggingInterceptor implements A {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: com.stepos.agentframework.adapter.dify.interceptor.LlmHttpLoggingInterceptor.Logger.1
            @Override // com.stepos.agentframework.adapter.dify.interceptor.LlmHttpLoggingInterceptor.Logger
            public void log(String str) {
                m.get().log(str, 4, null);
            }
        };

        void log(String str);
    }

    public LlmHttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private static boolean bodyHasUnknownEncoding(w wVar) {
        String strB = wVar.b("Content-Encoding");
        return (strB == null || strB.equalsIgnoreCase("identity") || strB.equalsIgnoreCase("gzip")) ? false : true;
    }

    private static boolean bodyIsStreaming(M m) {
        B bC = m.g.c();
        return bC != null && bC.b.equalsIgnoreCase("text") && bC.c.equalsIgnoreCase("event-stream");
    }

    public static boolean isPlaintext(g gVar) {
        g gVar2;
        int i;
        try {
            gVar2 = new g();
            long j5 = gVar.b;
            gVar.k(gVar2, 0L, j5 < 64 ? j5 : 64L);
        } catch (EOFException unused) {
        }
        for (i = 0; i < 16; i++) {
            if (gVar2.n()) {
                return true;
            }
            int iH = gVar2.H();
            if (Character.isISOControl(iH) && !Character.isWhitespace(iH)) {
                return false;
            }
        }
        return true;
    }

    private void logHeader(w wVar, int i) {
        String strH = this.headersToRedact.contains(wVar.e(i)) ? "██" : wVar.h(i);
        this.logger.log(wVar.e(i) + ": " + strH);
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018f  */
    @Override // F9.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public F9.M intercept(F9.z r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.dify.interceptor.LlmHttpLoggingInterceptor.intercept(F9.z):F9.M");
    }

    public void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.headersToRedact);
        treeSet.add(str);
        this.headersToRedact = treeSet;
    }

    public LlmHttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public LlmHttpLoggingInterceptor(Logger logger) {
        this.headersToRedact = Collections.EMPTY_SET;
        this.level = Level.NONE;
        this.logger = logger;
    }
}
