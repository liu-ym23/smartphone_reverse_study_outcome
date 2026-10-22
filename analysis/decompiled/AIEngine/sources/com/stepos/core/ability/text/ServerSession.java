package com.stepos.core.ability.text;

import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import lb.n;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ServerSession {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_EMBEDDING_CACHE_SIZE = 100;
    private static final int MAX_HISTORY_SIZE = 50;
    private final ServerSession$embeddingCache$1 embeddingCache;
    private final List<LlmChatMessage> history;
    private final Mutex inferLock;
    private volatile Job inflight;
    private final String name;
    private final int uid;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ServerSession(int i10, String name) {
        g.f(name, "name");
        this.uid = i10;
        this.name = name;
        this.history = new ArrayList();
        this.embeddingCache = new ServerSession$embeddingCache$1();
        this.inferLock = MutexKt.Mutex$default(false, 1, null);
    }

    private final void enforceHistoryLimit() {
        if (this.history.size() > 50) {
            int size = this.history.size() - 50;
            for (int i10 = 0; i10 < size; i10++) {
                this.history.remove(0);
            }
        }
    }

    public final void appendAssistant(String text) {
        g.f(text, "text");
        synchronized (this.history) {
            this.history.add(LlmChatMessage.Companion.assistant(text));
            enforceHistoryLimit();
            n nVar = n.f10413a;
        }
    }

    public final void appendUser(String prompt) {
        g.f(prompt, "prompt");
        synchronized (this.history) {
            this.history.add(LlmChatMessage.Companion.user(prompt));
            enforceHistoryLimit();
            n nVar = n.f10413a;
        }
    }

    public final int calculateHistoryTokenLength() {
        int i10;
        synchronized (this.history) {
            try {
                Iterator<T> it = this.history.iterator();
                int length = 0;
                while (it.hasNext()) {
                    String content = ((LlmChatMessage) it.next()).getContent();
                    length += content != null ? content.length() : 0;
                }
                i10 = length / 4;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    public final boolean cancelInflight() {
        Job job = this.inflight;
        if (job == null || !job.isActive()) {
            return false;
        }
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        return true;
    }

    public final int clearHistory() {
        int size;
        synchronized (this.history) {
            size = this.history.size();
            this.history.clear();
        }
        return size;
    }

    public final MixedContent composePrompt() {
        MixedContent mixedContent;
        synchronized (this.history) {
            mixedContent = ServerSessionKt.toMixedContent(this.history);
        }
        return mixedContent;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.data.LlmChatMessage getAndRemoveHistory(int r3) {
        /*
            r2 = this;
            java.util.List<com.stepos.core.data.LlmChatMessage> r0 = r2.history
            monitor-enter(r0)
            if (r3 < 0) goto L19
            java.util.List<com.stepos.core.data.LlmChatMessage> r1 = r2.history     // Catch: java.lang.Throwable -> L16
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L16
            if (r3 >= r1) goto L19
            java.util.List<com.stepos.core.data.LlmChatMessage> r2 = r2.history     // Catch: java.lang.Throwable -> L16
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L16
            com.stepos.core.data.LlmChatMessage r2 = (com.stepos.core.data.LlmChatMessage) r2     // Catch: java.lang.Throwable -> L16
            goto L1a
        L16:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L19:
            r2 = 0
        L1a:
            monitor-exit(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.ServerSession.getAndRemoveHistory(int):com.stepos.core.data.LlmChatMessage");
    }

    public final float[] getEmbedding(String id2) {
        float[] fArr;
        g.f(id2, "id");
        synchronized (this.embeddingCache) {
            fArr = (float[]) this.embeddingCache.get((Object) id2);
        }
        return fArr;
    }

    public final List<float[]> getEmbeddingList(List<String> ids) {
        ArrayList arrayList;
        g.f(ids, "ids");
        synchronized (this.embeddingCache) {
            arrayList = new ArrayList(m.Z(ids, 10));
            Iterator<T> it = ids.iterator();
            while (it.hasNext()) {
                arrayList.add((float[]) this.embeddingCache.get(it.next()));
            }
        }
        return arrayList;
    }

    public final LlmChatMessage getHistory(int i10) {
        LlmChatMessage llmChatMessage;
        synchronized (this.history) {
            llmChatMessage = (LlmChatMessage) kotlin.collections.a.w0(i10, this.history);
        }
        return llmChatMessage;
    }

    public final List<LlmChatMessage> getHistoryList() {
        List<LlmChatMessage> listO0;
        synchronized (this.history) {
            listO0 = kotlin.collections.a.O0(this.history);
        }
        return listO0;
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.history) {
            size = this.history.size();
        }
        return size;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUid() {
        return this.uid;
    }

    public final void putEmbedding(String id2, float[] vec) {
        g.f(id2, "id");
        g.f(vec, "vec");
        synchronized (this.embeddingCache) {
            this.embeddingCache.put(id2, vec);
            n nVar = n.f10413a;
        }
    }

    public final int putHistory(LlmChatMessage msg) {
        int size;
        g.f(msg, "msg");
        synchronized (this.history) {
            this.history.add(msg);
            enforceHistoryLimit();
            size = this.history.size();
        }
        return size;
    }

    public final int putHistoryList(List<LlmChatMessage> msgs) {
        int size;
        g.f(msgs, "msgs");
        synchronized (this.history) {
            this.history.addAll(msgs);
            enforceHistoryLimit();
            size = this.history.size();
        }
        return size;
    }

    public final void releaseInferLock() {
        Mutex.DefaultImpls.unlock$default(this.inferLock, null, 1, null);
    }

    public final boolean removeEmbedding(String id2) {
        boolean z;
        g.f(id2, "id");
        synchronized (this.embeddingCache) {
            z = this.embeddingCache.remove((Object) id2) != null;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean removeHistory(int r3) {
        /*
            r2 = this;
            java.util.List<com.stepos.core.data.LlmChatMessage> r0 = r2.history
            monitor-enter(r0)
            if (r3 < 0) goto L17
            java.util.List<com.stepos.core.data.LlmChatMessage> r1 = r2.history     // Catch: java.lang.Throwable -> L14
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L14
            if (r3 >= r1) goto L17
            java.util.List<com.stepos.core.data.LlmChatMessage> r2 = r2.history     // Catch: java.lang.Throwable -> L14
            r2.remove(r3)     // Catch: java.lang.Throwable -> L14
            r2 = 1
            goto L18
        L14:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L17:
            r2 = 0
        L18:
            monitor-exit(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.text.ServerSession.removeHistory(int):boolean");
    }

    public final int removeHistoryAfter(int i10) {
        int size;
        synchronized (this.history) {
            size = (this.history.size() - i10) - 1;
            if (size > 0) {
                List<LlmChatMessage> list = this.history;
                list.subList(i10 + 1, list.size()).clear();
            }
            if (size < 0) {
                size = 0;
            }
        }
        return size;
    }

    public final void setInflight(Job job) {
        this.inflight = job;
    }

    public final Object tryAcquireInferLock(qb.b<? super Boolean> bVar) {
        return Boolean.valueOf(Mutex.DefaultImpls.tryLock$default(this.inferLock, null, 1, null));
    }
}
