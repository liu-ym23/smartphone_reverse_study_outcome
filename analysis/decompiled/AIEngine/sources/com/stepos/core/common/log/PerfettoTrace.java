package com.stepos.core.common.log;

import android.os.Trace;
import gc.r;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerfettoTrace {
    private static final String TRACE_TAG = "AIEngine";
    public static final PerfettoTrace INSTANCE = new PerfettoTrace();
    private static final AtomicInteger asyncCookieCounter = new AtomicInteger(0);
    private static final ConcurrentHashMap<String, Long> counters = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class AsyncTraceToken {
        private final int cookie;
        private final String name;

        public AsyncTraceToken(String name, int i10) {
            g.f(name, "name");
            this.name = name;
            this.cookie = i10;
        }

        public static /* synthetic */ AsyncTraceToken copy$default(AsyncTraceToken asyncTraceToken, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = asyncTraceToken.name;
            }
            if ((i11 & 2) != 0) {
                i10 = asyncTraceToken.cookie;
            }
            return asyncTraceToken.copy(str, i10);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.cookie;
        }

        public final AsyncTraceToken copy(String name, int i10) {
            g.f(name, "name");
            return new AsyncTraceToken(name, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AsyncTraceToken)) {
                return false;
            }
            AsyncTraceToken asyncTraceToken = (AsyncTraceToken) obj;
            return g.b(this.name, asyncTraceToken.name) && this.cookie == asyncTraceToken.cookie;
        }

        public final int getCookie() {
            return this.cookie;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return Integer.hashCode(this.cookie) + (this.name.hashCode() * 31);
        }

        public String toString() {
            return ai.onnxruntime.a.i("AsyncTraceToken(name=", this.cookie, this.name, ", cookie=", ")");
        }
    }

    private PerfettoTrace() {
    }

    public static final int beginAsyncSection(String name) {
        g.f(name, "name");
        int iIncrementAndGet = asyncCookieCounter.incrementAndGet();
        if (isEnabled()) {
            Trace.beginAsyncSection(r.R0(127, name), iIncrementAndGet);
        }
        return iIncrementAndGet;
    }

    public static final void beginSection(String name) {
        g.f(name, "name");
        if (isEnabled()) {
            Trace.beginSection(r.R0(127, name));
        }
    }

    public static final void decrementCounter(String name) {
        g.f(name, "name");
        Long lCompute = counters.compute(name, new d(new c(1), 1));
        if (lCompute != null) {
            setCounter(name, lCompute.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long decrementCounter$lambda$3(String str, Long l10) {
        g.f(str, "<unused var>");
        return Long.valueOf(Math.max((l10 != null ? l10.longValue() : 0L) - 1, 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long decrementCounter$lambda$4(p pVar, Object obj, Object obj2) {
        return (Long) pVar.invoke(obj, obj2);
    }

    public static final void endAsync(AsyncTraceToken token) {
        g.f(token, "token");
        endAsyncSection(token.getName(), token.getCookie());
    }

    public static final void endAsyncSection(String name, int i10) {
        g.f(name, "name");
        if (isEnabled()) {
            Trace.endAsyncSection(r.R0(127, name), i10);
        }
    }

    public static final void endSection() {
        if (isEnabled()) {
            Trace.endSection();
        }
    }

    public static final void incrementCounter(String name) {
        g.f(name, "name");
        Long lCompute = counters.compute(name, new d(new c(0), 0));
        if (lCompute != null) {
            setCounter(name, lCompute.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long incrementCounter$lambda$0(String str, Long l10) {
        g.f(str, "<unused var>");
        return Long.valueOf((l10 != null ? l10.longValue() : 0L) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long incrementCounter$lambda$1(p pVar, Object obj, Object obj2) {
        return (Long) pVar.invoke(obj, obj2);
    }

    public static final boolean isEnabled() {
        return LogConfig.getEnableSystrace() && Trace.isEnabled();
    }

    public static final void setCounter(String name, long j10) {
        g.f(name, "name");
        if (isEnabled()) {
            Trace.setCounter(name, j10);
        }
    }

    public static final AsyncTraceToken startAsync(String name) {
        g.f(name, "name");
        return new AsyncTraceToken(name, beginAsyncSection(name));
    }

    public static final <T> T trace(String name, zb.a<? extends T> block) {
        g.f(name, "name");
        g.f(block, "block");
        beginSection(name);
        try {
            return block.invoke();
        } finally {
            endSection();
        }
    }
}
