package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.os.Bundle;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.ChatAbilityAdapter;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.algorithm.chat.IChat;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.args.MultiImageBundle;
import com.stepos.aiengine.data.FloatArrayMap;
import com.stepos.aiengine.session.SessionManager;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ListContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.LinkHeader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\n2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u001ej\u0002`\u001f0\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\"J/\u0010$\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020,H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u001aH\u0016¢\u0006\u0004\b1\u0010\u001cJ!\u00102\u001a\u00020\u001a2\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u001ej\u0002`\u001f0\u0017H\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/stepos/aiengine/adapter/ChatAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/chat/IChat;", "Lcom/stepos/core/AbilityHandle;", "handle", "Lcom/stepos/aiengine/session/SessionManager;", "sessionManager", "<init>", "(Lcom/stepos/core/AbilityHandle;Lcom/stepos/aiengine/session/SessionManager;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", LinkHeader.Rel.PreLoad, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "", "name", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "openSession", "(Ljava/lang/String;Lcom/stepos/aiengine/api/task/IBundleCallback;)Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "LY8/t;", "closeSession", "(Ljava/lang/String;)V", "", "getSessions", "()Ljava/util/List;", "", "clearSessions", "()I", b.CREDENTIAL_TOKEN, "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "messages", "generateIn", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "encoded", "generate", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "bundle", "Lcom/stepos/aiengine/data/FloatArrayMap;", "embedding", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/data/FloatArrayMap;", "", e.f30860s, "", "cancel", "(J)Z", "resetContext", "()Z", "getMaxTokenLimit", "calculateTokenLength", "(Ljava/util/List;)I", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/aiengine/session/SessionManager;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatAbilityAdapter implements IChat {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SessionManager sessionManager;

    public ChatAbilityAdapter(AbilityHandle handle, SessionManager sessionManager) {
        p.i(handle, "handle");
        p.i(sessionManager, "sessionManager");
        this.handle = handle;
        this.sessionManager = sessionManager;
    }

    public static final t g(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("exception", msg);
        bundle.putInt("error_code", i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t h(IBundleCallback iBundleCallback, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t i(IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        Bundle bundle = new Bundle();
        bundle.putString("token_next", r10.getText());
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t j(IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        Bundle bundle = new Bundle();
        bundle.putString("token_next", r10.getText());
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t k(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("exception", msg);
        bundle.putInt("error_code", i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t l(IBundleCallback iBundleCallback, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int calculateTokenLength(List<LlmChatMessage> messages) {
        p.i(messages, "messages");
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
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int clearSessions() {
        return this.sessionManager.clearAll();
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public void closeSession(String name) {
        p.i(name, "name");
        this.sessionManager.close(name);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public FloatArrayMap embedding(AlgorithmToken token, Bundle bundle) {
        p.i(token, "token");
        p.i(bundle, "bundle");
        List<Pair<String, Content>> listLoadEmbeddingContents = MultiImageBundle.INSTANCE.loadEmbeddingContents(bundle);
        if (listLoadEmbeddingContents.isEmpty()) {
            return new FloatArrayMap(null, 1, null);
        }
        Parcelable parcelableExecute = this.handle.execute("embedBatch", new ListContent(listLoadEmbeddingContents));
        Map map = parcelableExecute instanceof Map ? (Map) parcelableExecute : null;
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
    public int generate(AlgorithmToken token, String encoded, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(encoded, "encoded");
        p.i(args, "args");
        p.i(callback, "callback");
        TextContent textContent = new TextContent(encoded);
        textContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), textContent, new p9.p() { // from class: O4.m
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatAbilityAdapter.i(callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.n
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatAbilityAdapter.g(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatAbilityAdapter.h(callback, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int generateIn(AlgorithmToken token, List<LlmChatMessage> messages, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(messages, "messages");
        p.i(args, "args");
        p.i(callback, "callback");
        MixedContent mixedContentB = ChatAbilityAdapterKt.b(messages);
        mixedContentB.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), mixedContentB, new p9.p() { // from class: O4.j
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatAbilityAdapter.j(callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.k
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatAbilityAdapter.k(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatAbilityAdapter.l(callback, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public int getMaxTokenLimit() {
        return 4096;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public List<String> getSessions() {
        return this.sessionManager.listNames();
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public IChatSession openSession(String name, IBundleCallback callback) {
        p.i(name, "name");
        IChatSession orCreate = this.sessionManager.getOrCreate(name, this.handle);
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
        p.i(args, "args");
        return this.handle.prepare() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChat
    public boolean resetContext() {
        try {
            Content contentExecute = this.handle.execute("resetChat", null);
            return p.d(contentExecute != null ? contentExecute.toString() : null, "true");
        } catch (Exception unused) {
            return false;
        }
    }
}
