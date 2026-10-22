package com.stepos.aiengine.adapter;

import Q4.d;
import Q4.e;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.algorithm.chat.IChat;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.args.MultiImageBundle;
import com.stepos.aiengine.data.FloatArrayMap;
import com.stepos.aiengine.session.SessionManager;
import com.stepos.core.c;
import com.stepos.core.data.ListContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\n2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u001ej\u0002`\u001f0\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\"J/\u0010$\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020,H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u001aH\u0016¢\u0006\u0004\b1\u0010\u001cJ!\u00102\u001a\u00020\u001a2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u001ej\u0002`\u001f0\u0017H\u0016¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/aiengine/adapter/ChatAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/chat/IChat;", "Lcom/stepos/core/c;", "handle", "Lcom/stepos/aiengine/session/SessionManager;", "sessionManager", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;Lcom/stepos/aiengine/session/SessionManager;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "preload", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "openSession", "(Ljava/lang/String;Lcom/stepos/aiengine/api/task/IBundleCallback;)Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "LC7/r;", "closeSession", "(Ljava/lang/String;)V", "", "getSessions", "()Ljava/util/List;", "", "clearSessions", "()I", "token", "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "messages", "generateIn", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "encoded", "generate", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "bundle", "Lcom/stepos/aiengine/data/FloatArrayMap;", "embedding", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/data/FloatArrayMap;", "", "identity", "", "cancel", "(J)Z", "resetContext", "()Z", "getMaxTokenLimit", "calculateTokenLength", "(Ljava/util/List;)I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatAbilityAdapter implements IChat {

    /* renamed from: a, reason: collision with root package name */
    public final c f3457a;
    public final SessionManager b;

    public ChatAbilityAdapter(c handle, SessionManager sessionManager) {
        k.f(handle, "handle");
        k.f(sessionManager, "sessionManager");
        this.f3457a = handle;
        this.b = sessionManager;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int calculateTokenLength(List<LlmChatMessage> messages) {
        k.f(messages, "messages");
        Iterator<T> it = messages.iterator();
        int length = 0;
        while (it.hasNext()) {
            String content = ((LlmChatMessage) it.next()).getContent();
            length += content != null ? content.length() : 0;
        }
        return length / 4;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public boolean cancel(long identity) {
        return this.f3457a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int clearSessions() {
        return this.b.clearAll();
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public void closeSession(String name) {
        k.f(name, "name");
        this.b.close(name);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public FloatArrayMap embedding(AlgorithmToken token, Bundle bundle) {
        k.f(token, "token");
        k.f(bundle, "bundle");
        List<Pair<String, Content>> listLoadEmbeddingContents = MultiImageBundle.INSTANCE.loadEmbeddingContents(bundle);
        if (listLoadEmbeddingContents.isEmpty()) {
            return new FloatArrayMap(null, 1, null);
        }
        Parcelable parcelableC = this.f3457a.c("embedBatch", new ListContent(listLoadEmbeddingContents));
        Map map = parcelableC instanceof Map ? (Map) parcelableC : null;
        if (map == null) {
            return new FloatArrayMap(null, 1, null);
        }
        FloatArrayMap floatArrayMap = new FloatArrayMap(null, 1, null);
        for (Map.Entry entry : map.entrySet()) {
            floatArrayMap.put((String) entry.getKey(), (float[]) entry.getValue());
        }
        return floatArrayMap;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int generate(AlgorithmToken token, String encoded, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(encoded, "encoded");
        k.f(args, "args");
        k.f(callback, "callback");
        TextContent textContent = new TextContent(encoded);
        textContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        c.i(this.f3457a, String.valueOf(token.getIdentity()), textContent, new Q4.c(callback, 1), new d(callback, 1), new e(callback, 1));
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int generateIn(AlgorithmToken token, List<LlmChatMessage> messages, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(messages, "messages");
        k.f(args, "args");
        k.f(callback, "callback");
        MixedContent mixedContentAccess$toMixedContent = ChatAbilityAdapterKt.access$toMixedContent(messages);
        mixedContentAccess$toMixedContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        c.i(this.f3457a, String.valueOf(token.getIdentity()), mixedContentAccess$toMixedContent, new Q4.c(callback, 0), new d(callback, 0), new e(callback, 0));
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int getMaxTokenLimit() {
        return 4096;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public List<String> getSessions() {
        return this.b.listNames();
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public IChatSession openSession(String name, IBundleCallback callback) {
        k.f(name, "name");
        IChatSession orCreate = this.b.getOrCreate(name, this.f3457a);
        if (callback != null) {
            Bundle bundle = new Bundle();
            bundle.putString("session_name", name);
            bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
            callback.onCall(bundle);
        }
        return orCreate;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public AlgorithmToken preload(Bundle args) {
        k.f(args, "args");
        return this.f3457a.f3825a.acquire() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public boolean resetContext() {
        try {
            Content contentC = this.f3457a.c("resetChat", null);
            return k.b(contentC != null ? contentC.toString() : null, "true");
        } catch (Exception unused) {
            return false;
        }
    }
}
