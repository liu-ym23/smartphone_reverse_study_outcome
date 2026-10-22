package com.stepos.aiengine.session;

import D7.v;
import Q4.d;
import U4.a;
import U4.b;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.args.MultiImageBundle;
import com.stepos.core.c;
import com.stepos.core.data.ListContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.SessionCommandContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.SessionResultContent;
import com.stepos.core.data.base.Content;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u0014\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\u00020\u000e2\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u001e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u001eH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010-J!\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020\nH\u0016¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u00106J%\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\u001e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b:\u0010;R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0011\u0010B\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/stepos/aiengine/session/ChatSessionAdapter;", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "generateInHistory", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", HighlightArgsBundle.KEY_PROMPT, "generateWithPrompt", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", "identity", "", "cancel", "(J)Z", "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", NotificationCompat.CATEGORY_MESSAGE, "putHistory", "(Lcom/stepos/core/data/LlmChatMessage;Landroid/os/Bundle;)I", "", "msgs", "putHistoryList", "(Ljava/util/List;Landroid/os/Bundle;)I", "index", "getHistory", "(I)Lcom/stepos/core/data/LlmChatMessage;", "getHistoryList", "()Ljava/util/List;", "removeHistory", "(I)Z", "removeHistoryAfter", "(I)I", "getAndRemoveHistory", "clearHistory", "()I", "getHistorySize", "calculateHistoryTokenLength", "bundle", "", "embedding", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)[F", "id", "embedded", "(Ljava/lang/String;)[F", "ids", "embeddedList", "(Ljava/util/List;)Ljava/util/List;", "removeEmbedded", "(Ljava/lang/String;)Z", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getHandleRef", "()Lcom/stepos/core/c;", "handleRef", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatSessionAdapter implements IChatSession {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;
    public final c b;

    public ChatSessionAdapter(String name, c handle) {
        k.f(name, "name");
        k.f(handle, "handle");
        this.name = name;
        this.b = handle;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int calculateHistoryTokenLength() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentC = this.b.c("session.calcTokenLen", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public boolean cancel(long identity) {
        return this.b.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int clearHistory() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentC = this.b.c("session.clearHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public float[] embedded(String id) {
        Bundle payload;
        k.f(id, "id");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putString(SessionCommandContent.KEY_EMBED_ID, id);
        Content contentC = this.b.c("session.embedded", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return null;
        }
        return payload.getFloatArray(SessionResultContent.KEY_FLOAT_ARRAY);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public List<float[]> embeddedList(List<String> ids) {
        Bundle payload;
        k.f(ids, "ids");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putStringArrayList(SessionCommandContent.KEY_EMBED_IDS, new ArrayList<>(ids));
        Content contentC = this.b.c("session.embeddedList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        Serializable serializable = (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) ? null : payload.getSerializable(SessionResultContent.KEY_FLOAT_ARRAYS);
        ArrayList arrayList = serializable instanceof ArrayList ? (ArrayList) serializable : null;
        if (arrayList != null) {
            return arrayList;
        }
        int size = ids.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        return arrayList2;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public float[] embedding(AlgorithmToken token, Bundle bundle) {
        k.f(token, "token");
        k.f(bundle, "bundle");
        List<Pair<String, Content>> listLoadEmbeddingContents = MultiImageBundle.INSTANCE.loadEmbeddingContents(bundle);
        if (listLoadEmbeddingContents.isEmpty()) {
            return null;
        }
        Parcelable parcelableC = this.b.c("embedBatch", new ListContent(listLoadEmbeddingContents));
        Map map = parcelableC instanceof Map ? (Map) parcelableC : null;
        if (map != null) {
            return (float[]) map.get(((Pair) v.A0(listLoadEmbeddingContents)).f4886a);
        }
        return null;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int generateInHistory(AlgorithmToken token, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(args, "args");
        k.f(callback, "callback");
        SessionRefContent sessionRefContent = new SessionRefContent(this.name, null, args);
        StringBuilder sb = new StringBuilder();
        c.i(this.b, String.valueOf(token.getIdentity()), sessionRefContent, new a(0, callback, sb), new d(callback, 5), new b(0, callback, sb));
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int generateWithPrompt(AlgorithmToken token, String prompt, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(prompt, "prompt");
        k.f(args, "args");
        k.f(callback, "callback");
        SessionRefContent sessionRefContent = new SessionRefContent(this.name, prompt, args);
        StringBuilder sb = new StringBuilder();
        c.i(this.b, String.valueOf(token.getIdentity()), sessionRefContent, new a(1, callback, sb), new d(callback, 6), new b(1, callback, sb));
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public LlmChatMessage getAndRemoveHistory(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentC = this.b.c("session.getAndRemoveHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return null;
        }
        return (LlmChatMessage) payload.getParcelable(SessionResultContent.KEY_MESSAGE);
    }

    /* renamed from: getHandleRef, reason: from getter */
    public final c getB() {
        return this.b;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public LlmChatMessage getHistory(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentC = this.b.c("session.getHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return null;
        }
        return (LlmChatMessage) payload.getParcelable(SessionResultContent.KEY_MESSAGE);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public List<LlmChatMessage> getHistoryList() {
        Bundle payload;
        ArrayList parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentC = this.b.c("session.getHistoryList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        return (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null || (parcelableArrayList = payload.getParcelableArrayList(SessionResultContent.KEY_MESSAGES)) == null) ? EmptyList.f4893a : parcelableArrayList;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int getHistorySize() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentC = this.b.c("session.getHistorySize", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int putHistory(LlmChatMessage msg, Bundle args) {
        Bundle payload;
        k.f(msg, "msg");
        k.f(args, "args");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putParcelable(SessionCommandContent.KEY_MESSAGE, msg);
        Content contentC = this.b.c("session.putHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int putHistoryList(List<LlmChatMessage> msgs, Bundle args) {
        Bundle payload;
        k.f(msgs, "msgs");
        k.f(args, "args");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putParcelableArrayList(SessionCommandContent.KEY_MESSAGES, new ArrayList<>(msgs));
        Content contentC = this.b.c("session.putHistoryList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public boolean removeEmbedded(String id) {
        Bundle payload;
        k.f(id, "id");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putString(SessionCommandContent.KEY_EMBED_ID, id);
        Content contentC = this.b.c("session.removeEmbedded", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return false;
        }
        return payload.getBoolean(SessionResultContent.KEY_BOOL);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public boolean removeHistory(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentC = this.b.c("session.removeHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return false;
        }
        return payload.getBoolean(SessionResultContent.KEY_BOOL);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int removeHistoryAfter(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentC = this.b.c("session.removeHistoryAfter", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentC instanceof SessionResultContent ? (SessionResultContent) contentC : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }
}
