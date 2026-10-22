package com.stepos.core.common.log;

import android.os.Trace;
import gc.o;
import gc.q;
import gc.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiEngineAtrace {
    private static final int MAX_SECTION_NAME_LENGTH = 127;
    private static final String PREFIX = "AIEngine/";
    public static final AiEngineAtrace INSTANCE = new AiEngineAtrace();
    private static final AtomicInteger cookieCounter = new AtomicInteger(0);
    private static final ConcurrentHashMap<String, ActiveSection> activeSections = new ConcurrentHashMap<>();
    private static final Object registryLock = new Object();
    private static final AiEngineAtrace$syncSectionStack$1 syncSectionStack = new ThreadLocal<ArrayDeque<String>>() { // from class: com.stepos.core.common.log.AiEngineAtrace$syncSectionStack$1
        @Override // java.lang.ThreadLocal
        public ArrayDeque<String> initialValue() {
            return new ArrayDeque<>();
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ActiveSection {
        private final int cookie;
        private final String name;

        public ActiveSection(String name, int i10) {
            g.f(name, "name");
            this.name = name;
            this.cookie = i10;
        }

        public static /* synthetic */ ActiveSection copy$default(ActiveSection activeSection, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = activeSection.name;
            }
            if ((i11 & 2) != 0) {
                i10 = activeSection.cookie;
            }
            return activeSection.copy(str, i10);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.cookie;
        }

        public final ActiveSection copy(String name, int i10) {
            g.f(name, "name");
            return new ActiveSection(name, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActiveSection)) {
                return false;
            }
            ActiveSection activeSection = (ActiveSection) obj;
            return g.b(this.name, activeSection.name) && this.cookie == activeSection.cookie;
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
            return ai.onnxruntime.a.i("ActiveSection(name=", this.cookie, this.name, ", cookie=", ")");
        }
    }

    private AiEngineAtrace() {
    }

    public static final void begin(String correlationId, String path, String stage) {
        g.f(correlationId, "correlationId");
        g.f(path, "path");
        g.f(stage, "stage");
        AiEngineAtrace aiEngineAtrace = INSTANCE;
        if (aiEngineAtrace.isAsyncTraceEnabled()) {
            String strKey = aiEngineAtrace.key(correlationId, path, stage);
            ActiveSection activeSection = new ActiveSection(aiEngineAtrace.sectionName(path, stage), aiEngineAtrace.nextCookie());
            synchronized (registryLock) {
                try {
                    ConcurrentHashMap<String, ActiveSection> concurrentHashMap = activeSections;
                    ActiveSection activeSectionRemove = concurrentHashMap.remove(strKey);
                    if (activeSectionRemove != null) {
                        aiEngineAtrace.endSection(activeSectionRemove);
                    }
                    Trace.beginAsyncSection(activeSection.getName(), activeSection.getCookie());
                    concurrentHashMap.put(strKey, activeSection);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final void beginSync(String path, String stage) {
        g.f(path, "path");
        g.f(stage, "stage");
        AiEngineAtrace aiEngineAtrace = INSTANCE;
        if (aiEngineAtrace.isAsyncTraceEnabled()) {
            aiEngineAtrace.beginSyncSection(aiEngineAtrace.sectionName(path, stage));
        }
    }

    private final void beginSyncSection(String str) {
        Trace.beginSection(str);
        currentSyncStack().addLast(str);
    }

    private final ArrayDeque<String> currentSyncStack() {
        ArrayDeque<String> arrayDeque = syncSectionStack.get();
        if (arrayDeque != null) {
            return arrayDeque;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static final void end(String correlationId, String path, String stage) {
        g.f(correlationId, "correlationId");
        g.f(path, "path");
        g.f(stage, "stage");
        synchronized (registryLock) {
            ConcurrentHashMap<String, ActiveSection> concurrentHashMap = activeSections;
            AiEngineAtrace aiEngineAtrace = INSTANCE;
            ActiveSection activeSectionRemove = concurrentHashMap.remove(aiEngineAtrace.key(correlationId, path, stage));
            if (activeSectionRemove != null) {
                aiEngineAtrace.endSection(activeSectionRemove);
                n nVar = n.f10413a;
            }
        }
    }

    public static final void endAll(String correlationId) {
        int i10;
        g.f(correlationId, "correlationId");
        String strJ = a0.a.j(INSTANCE.normalizeCorrelationId(correlationId), "|");
        synchronized (registryLock) {
            try {
                Set<Map.Entry<String, ActiveSection>> setEntrySet = activeSections.entrySet();
                g.e(setEntrySet, "<get-entries>(...)");
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = setEntrySet.iterator();
                while (true) {
                    i10 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Object key = ((Map.Entry) next).getKey();
                    g.e(key, "<get-key>(...)");
                    if (o.k0((String) key, strJ, false)) {
                        arrayList.add(next);
                    }
                }
                int size = arrayList.size();
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    Map.Entry entry = (Map.Entry) obj;
                    if (activeSections.remove(entry.getKey(), entry.getValue())) {
                        AiEngineAtrace aiEngineAtrace = INSTANCE;
                        Object value = entry.getValue();
                        g.e(value, "<get-value>(...)");
                        aiEngineAtrace.endSection((ActiveSection) value);
                    }
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void endSection(ActiveSection activeSection) {
        Trace.endAsyncSection(activeSection.getName(), activeSection.getCookie());
    }

    public static final void endSync(String path, String stage) {
        g.f(path, "path");
        g.f(stage, "stage");
        AiEngineAtrace aiEngineAtrace = INSTANCE;
        aiEngineAtrace.endSyncSection(aiEngineAtrace.sectionName(path, stage), false);
    }

    private final void endSyncSection(String str, boolean z) {
        ArrayDeque<String> arrayDequeCurrentSyncStack = currentSyncStack();
        if (arrayDequeCurrentSyncStack.isEmpty()) {
            syncSectionStack.remove();
            return;
        }
        if (z || g.b(arrayDequeCurrentSyncStack.peekLast(), str)) {
            if (!z || arrayDequeCurrentSyncStack.contains(str)) {
                do {
                    String strRemoveLast = arrayDequeCurrentSyncStack.removeLast();
                    Trace.endSection();
                    if (g.b(strRemoveLast, str)) {
                        break;
                    }
                } while (!arrayDequeCurrentSyncStack.isEmpty());
                if (arrayDequeCurrentSyncStack.isEmpty()) {
                    syncSectionStack.remove();
                }
            }
        }
    }

    private final boolean isAsyncTraceEnabled() {
        return Trace.isEnabled();
    }

    private final String key(String str, String str2, String str3) {
        return normalizeCorrelationId(str) + "|" + normalizePart(str2) + "|" + normalizePart(str3);
    }

    private final int nextCookie() {
        AtomicInteger atomicInteger = cookieCounter;
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        return iIncrementAndGet != 0 ? iIncrementAndGet : atomicInteger.incrementAndGet();
    }

    private final String normalizeCorrelationId(String str) {
        return normalizePart(str);
    }

    private final String normalizePart(String str) {
        String strH0 = o.h0(o.h0(o.h0(q.L0(str).toString(), '|', '_'), '\n', '_'), (char) 0, '_');
        return q.t0(strH0) ? "unknown" : strH0;
    }

    public static final <T> T section(String path, String stage, zb.a<? extends T> block) {
        g.f(path, "path");
        g.f(stage, "stage");
        g.f(block, "block");
        AiEngineAtrace aiEngineAtrace = INSTANCE;
        if (!aiEngineAtrace.isAsyncTraceEnabled()) {
            return block.invoke();
        }
        String strSectionName = aiEngineAtrace.sectionName(path, stage);
        aiEngineAtrace.beginSyncSection(strSectionName);
        try {
            T tInvoke = block.invoke();
            aiEngineAtrace.endSyncSection(strSectionName, true);
            return tInvoke;
        } catch (Throwable th) {
            INSTANCE.endSyncSection(strSectionName, true);
            throw th;
        }
    }

    private final String sectionName(String str, String str2) {
        return r.R0(MAX_SECTION_NAME_LENGTH, PREFIX + normalizePart(str) + "/" + normalizePart(str2));
    }
}
