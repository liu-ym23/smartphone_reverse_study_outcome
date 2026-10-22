package com.stepos.core.ability.session;

import a0.a;
import android.util.Log;
import com.stepos.core.ability.IChatSession;
import com.stepos.core.ability.session.ChatMessage;
import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChatSessionImpl extends IChatSession.Stub {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_EMBEDDING_CACHE_BYTES = 524288;
    private static final int MAX_HISTORY_SIZE = 50;
    private static final String TAG = "ChatSession";
    private final String abilityId;
    private final int callerPid;
    private final int callerUid;
    private volatile boolean closed;
    private final long createdAt;
    private long embeddingCacheBytes;
    private final CopyOnWriteArrayList<ChatMessage> history;
    private final ChatSessionImpl$imageEmbeddingCache$1 imageEmbeddingCache;
    private final q<String, Content, IInferenceCallback, n> inferFn;
    private final String sessionIdValue;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ChatSessionImpl(String str, int i10, int i11, q qVar, int i12, e eVar) {
        this(str, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String contentToString(Content content) {
        return content instanceof TextContent ? ((TextContent) content).getText() : content.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentCacheBytes() {
        Collection<float[]> collectionValues = this.imageEmbeddingCache.values();
        g.e(collectionValues, "<get-values>(...)");
        long length = 0;
        while (collectionValues.iterator().hasNext()) {
            length += ((float[]) r6.next()).length * 4;
        }
        return length;
    }

    public final void addMessage(ChatMessage.Role role, String content) {
        g.f(role, "role");
        g.f(content, "content");
        this.history.add(new ChatMessage(role, content, System.currentTimeMillis()));
        while (this.history.size() > 100) {
            this.history.remove(0);
        }
    }

    public final void cacheImageEmbedding(String imageHash, float[] embedding) {
        g.f(imageHash, "imageHash");
        g.f(embedding, "embedding");
        synchronized (this.imageEmbeddingCache) {
            long length = embedding.length * 4;
            if (length > 524288) {
                return;
            }
            this.imageEmbeddingCache.put(imageHash, embedding);
            long jCurrentCacheBytes = currentCacheBytes();
            this.embeddingCacheBytes = jCurrentCacheBytes;
            Log.d(TAG, "Cached image embedding: hash=" + imageHash + ", size=" + length + "B, total=" + jCurrentCacheBytes + "B");
        }
    }

    @Override // com.stepos.core.ability.IChatSession
    public void clearHistory() {
        this.history.clear();
        a.v("History cleared: sessionId=", this.sessionIdValue, TAG);
    }

    @Override // com.stepos.core.ability.IChatSession
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.history.clear();
        synchronized (this.imageEmbeddingCache) {
            this.imageEmbeddingCache.clear();
            this.embeddingCacheBytes = 0L;
            n nVar = n.f10413a;
        }
        SessionRegistry.INSTANCE.unregister(this.sessionIdValue);
        a.y("Session closed: sessionId=", this.sessionIdValue, TAG);
    }

    @Override // com.stepos.core.ability.IChatSession
    public void generate(Content content, final IInferenceCallback iInferenceCallback) {
        if (this.closed) {
            ai.onnxruntime.a.x("generate: session ", this.sessionIdValue, " is closed", TAG);
            if (iInferenceCallback != null) {
                iInferenceCallback.onError("", -1, "Session is closed");
                return;
            }
            return;
        }
        if (content == null || iInferenceCallback == null) {
            Log.w(TAG, "generate: input or callback is null");
            if (iInferenceCallback != null) {
                iInferenceCallback.onError("", -2, "Input and callback are required");
                return;
            }
            return;
        }
        if (this.inferFn == null) {
            Log.w(TAG, "generate: no inference delegate configured");
            iInferenceCallback.onError("", -3, "Session not connected to inference pipeline");
            return;
        }
        addMessage(ChatMessage.Role.USER, contentToString(content));
        String str = this.sessionIdValue + ":" + System.currentTimeMillis();
        String str2 = this.sessionIdValue;
        int turnCount = getTurnCount();
        StringBuilder sbS = ai.onnxruntime.a.s("generate: sessionId=", str2, ", inferId=", str, ", turnCount=");
        sbS.append(turnCount);
        Log.d(TAG, sbS.toString());
        final StringBuilder sb2 = new StringBuilder();
        this.inferFn.invoke(str, content, new IInferenceCallback.Stub() { // from class: com.stepos.core.ability.session.ChatSessionImpl$generate$wrappedCallback$1
            @Override // com.stepos.core.callback.IInferenceCallback
            public void onComplete(String id2) {
                g.f(id2, "id");
                String string = sb2.toString();
                g.e(string, "toString(...)");
                if (string.length() > 0) {
                    this.addMessage(ChatMessage.Role.ASSISTANT, string);
                }
                String str3 = this.sessionIdValue;
                int length = string.length();
                int turnCount2 = this.getTurnCount();
                StringBuilder sbF = h0.e.f("generate complete: sessionId=", str3, ", response length=", length, ", turnCount=");
                sbF.append(turnCount2);
                Log.d("ChatSession", sbF.toString());
                iInferenceCallback.onComplete(id2);
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onError(String id2, int i10, String message) {
                g.f(id2, "id");
                g.f(message, "message");
                iInferenceCallback.onError(id2, i10, message);
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onOutput(String id2, Content output) {
                g.f(id2, "id");
                g.f(output, "output");
                sb2.append(this.contentToString(output));
                iInferenceCallback.onOutput(id2, output);
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onProgress(String inferId, int i10, Content content2) {
                g.f(inferId, "inferId");
                iInferenceCallback.onProgress(inferId, i10, content2);
            }

            @Override // com.stepos.core.callback.IInferenceCallback
            public void onRoutingDecision(String id2, String executionLocation, String reason) {
                g.f(id2, "id");
                g.f(executionLocation, "executionLocation");
                g.f(reason, "reason");
                iInferenceCallback.onRoutingDecision(id2, executionLocation, reason);
            }
        });
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final float[] getCachedEmbedding(String imageHash) {
        float[] fArr;
        g.f(imageHash, "imageHash");
        synchronized (this.imageEmbeddingCache) {
            fArr = (float[]) this.imageEmbeddingCache.get((Object) imageHash);
            if (fArr != null) {
                Log.d(TAG, "Embedding cache hit: hash=".concat(imageHash));
            }
        }
        return fArr;
    }

    public final int getCallerPid() {
        return this.callerPid;
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final List<ChatMessage> getHistory() {
        return kotlin.collections.a.O0(this.history);
    }

    @Override // com.stepos.core.ability.IChatSession
    public String getSessionId() {
        return this.sessionIdValue;
    }

    @Override // com.stepos.core.ability.IChatSession
    public int getTurnCount() {
        return this.history.size() / 2;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSessionImpl(String abilityId, int i10, int i11, q<? super String, ? super Content, ? super IInferenceCallback, n> qVar) {
        g.f(abilityId, "abilityId");
        this.abilityId = abilityId;
        this.callerUid = i10;
        this.callerPid = i11;
        this.inferFn = qVar;
        String string = UUID.randomUUID().toString();
        g.e(string, "toString(...)");
        this.sessionIdValue = string;
        this.history = new CopyOnWriteArrayList<>();
        this.imageEmbeddingCache = new ChatSessionImpl$imageEmbeddingCache$1(this);
        this.createdAt = System.currentTimeMillis();
    }
}
