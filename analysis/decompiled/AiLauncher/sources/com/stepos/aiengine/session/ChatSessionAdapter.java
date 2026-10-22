package com.stepos.aiengine.session;

import M5.b;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.os.Bundle;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.aiengine.args.MultiImageBundle;
import com.stepos.aiengine.session.ChatSessionAdapter;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ListContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.SessionCommandContent;
import com.stepos.core.data.SessionRefContent;
import com.stepos.core.data.SessionResultContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u0014\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\u00020\u000e2\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u001e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0\u001eH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010-J!\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020\nH\u0016¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u00106J%\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\u001e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b:\u0010;R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/stepos/aiengine/session/ChatSessionAdapter;", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "", "name", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Ljava/lang/String;Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "generateInHistory", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", HighlightArgsBundle.KEY_PROMPT, "generateWithPrompt", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", e.f30860s, "", "cancel", "(J)Z", "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "msg", "putHistory", "(Lcom/stepos/core/data/LlmChatMessage;Landroid/os/Bundle;)I", "", "msgs", "putHistoryList", "(Ljava/util/List;Landroid/os/Bundle;)I", "index", "getHistory", "(I)Lcom/stepos/core/data/LlmChatMessage;", "getHistoryList", "()Ljava/util/List;", "removeHistory", "(I)Z", "removeHistoryAfter", "(I)I", "getAndRemoveHistory", "clearHistory", "()I", "getHistorySize", "calculateHistoryTokenLength", "bundle", "", "embedding", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)[F", "id", "embedded", "(Ljava/lang/String;)[F", "ids", "embeddedList", "(Ljava/util/List;)Ljava/util/List;", "removeEmbedded", "(Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/core/AbilityHandle;", "getHandleRef", "()Lcom/stepos/core/AbilityHandle;", "handleRef", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatSessionAdapter implements IChatSession {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public ChatSessionAdapter(String name, AbilityHandle handle) {
        p.i(name, "name");
        p.i(handle, "handle");
        this.name = name;
        this.handle = handle;
    }

    public static final t g(StringBuilder sb2, IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        sb2.append(r10.getText());
        Bundle bundle = new Bundle();
        bundle.putString("token_next", r10.getText());
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t h(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("exception", msg);
        bundle.putInt("error_code", i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t i(IBundleCallback iBundleCallback, StringBuilder sb2, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
        bundle.putString(ChatCallback.KEY_SESSION_OUTPUT, sb2.toString());
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t j(IBundleCallback iBundleCallback, StringBuilder sb2, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
        bundle.putString(ChatCallback.KEY_SESSION_OUTPUT, sb2.toString());
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t k(StringBuilder sb2, IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        sb2.append(r10.getText());
        Bundle bundle = new Bundle();
        bundle.putString("token_next", r10.getText());
        bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t l(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("exception", msg);
        bundle.putInt("error_code", i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int calculateHistoryTokenLength() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentExecute = this.handle.execute("session.calcTokenLen", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int clearHistory() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentExecute = this.handle.execute("session.clearHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public float[] embedded(String id) {
        Bundle payload;
        p.i(id, "id");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putString(SessionCommandContent.KEY_EMBED_ID, id);
        Content contentExecute = this.handle.execute("session.embedded", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return null;
        }
        return payload.getFloatArray(SessionResultContent.KEY_FLOAT_ARRAY);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public List<float[]> embeddedList(List<String> ids) {
        Bundle payload;
        p.i(ids, "ids");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putStringArrayList(SessionCommandContent.KEY_EMBED_IDS, new ArrayList<>(ids));
        Content contentExecute = this.handle.execute("session.embeddedList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        Serializable serializable = (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) ? null : payload.getSerializable(SessionResultContent.KEY_FLOAT_ARRAYS);
        ArrayList arrayList = serializable instanceof ArrayList ? (ArrayList) serializable : null;
        if (arrayList != null) {
            return arrayList;
        }
        int size = ids.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(null);
        }
        return arrayList2;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public float[] embedding(AlgorithmToken token, Bundle bundle) {
        p.i(token, "token");
        p.i(bundle, "bundle");
        List<Pair<String, Content>> listLoadEmbeddingContents = MultiImageBundle.INSTANCE.loadEmbeddingContents(bundle);
        if (listLoadEmbeddingContents.isEmpty()) {
            return null;
        }
        Parcelable parcelableExecute = this.handle.execute("embedBatch", new ListContent(listLoadEmbeddingContents));
        Map map = parcelableExecute instanceof Map ? (Map) parcelableExecute : null;
        if (map != null) {
            return (float[]) map.get(((Pair) F.q0(listLoadEmbeddingContents)).e());
        }
        return null;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int generateInHistory(AlgorithmToken token, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(args, "args");
        p.i(callback, "callback");
        SessionRefContent sessionRefContent = new SessionRefContent(this.name, null, args);
        final StringBuilder sb2 = new StringBuilder();
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), sessionRefContent, new p9.p() { // from class: R4.a
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatSessionAdapter.g(sb2, callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: R4.b
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatSessionAdapter.h(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: R4.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatSessionAdapter.i(callback, sb2, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int generateWithPrompt(AlgorithmToken token, String prompt, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(prompt, "prompt");
        p.i(args, "args");
        p.i(callback, "callback");
        SessionRefContent sessionRefContent = new SessionRefContent(this.name, prompt, args);
        final StringBuilder sb2 = new StringBuilder();
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), sessionRefContent, new p9.p() { // from class: R4.d
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatSessionAdapter.k(sb2, callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: R4.e
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ChatSessionAdapter.l(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: R4.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatSessionAdapter.j(callback, sb2, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public LlmChatMessage getAndRemoveHistory(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentExecute = this.handle.execute("session.getAndRemoveHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return null;
        }
        return (LlmChatMessage) payload.getParcelable(SessionResultContent.KEY_MESSAGE);
    }

    /* renamed from: getHandleRef, reason: from getter */
    public final AbilityHandle getHandle() {
        return this.handle;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public LlmChatMessage getHistory(int index) {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putInt(SessionCommandContent.KEY_INDEX, index);
        Content contentExecute = this.handle.execute("session.getHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
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
        Content contentExecute = this.handle.execute("session.getHistoryList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        return (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null || (parcelableArrayList = payload.getParcelableArrayList(SessionResultContent.KEY_MESSAGES)) == null) ? C1173v.m() : parcelableArrayList;
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int getHistorySize() {
        Bundle payload;
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        Content contentExecute = this.handle.execute("session.getHistorySize", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
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
        p.i(msg, "msg");
        p.i(args, "args");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putParcelable(SessionCommandContent.KEY_MESSAGE, msg);
        Content contentExecute = this.handle.execute("session.putHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public int putHistoryList(List<LlmChatMessage> msgs, Bundle args) {
        Bundle payload;
        p.i(msgs, "msgs");
        p.i(args, "args");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putParcelableArrayList(SessionCommandContent.KEY_MESSAGES, new ArrayList<>(msgs));
        Content contentExecute = this.handle.execute("session.putHistoryList", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }

    @Override // com.stepos.aiengine.algorithm.chat.IChatSession
    public boolean removeEmbedded(String id) {
        Bundle payload;
        p.i(id, "id");
        Bundle bundle = new Bundle();
        bundle.putString(SessionCommandContent.KEY_NAME, this.name);
        bundle.putString(SessionCommandContent.KEY_EMBED_ID, id);
        Content contentExecute = this.handle.execute("session.removeEmbedded", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
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
        Content contentExecute = this.handle.execute("session.removeHistory", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
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
        Content contentExecute = this.handle.execute("session.removeHistoryAfter", new SessionCommandContent(bundle));
        SessionResultContent sessionResultContent = contentExecute instanceof SessionResultContent ? (SessionResultContent) contentExecute : null;
        if (sessionResultContent == null || (payload = sessionResultContent.getPayload()) == null) {
            return 0;
        }
        return payload.getInt(SessionResultContent.KEY_INT);
    }
}
