package com.stepos.aiengine.algorithm.chat;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.MultiImageBundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0015J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b \u0010\fJ\u0017\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010\u0017J\u0017\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010&\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b&\u0010\u0017J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020'¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0002¢\u0006\u0004\b-\u0010\u0012¨\u0006/"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "", "Landroid/os/Bundle;", "bundle", AppAgent.CONSTRUCT, "(Landroid/os/Bundle;)V", "", "", "ids", "setImageIds", "(Ljava/util/List;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getImageIds", "()Ljava/util/List;", "Lcom/stepos/aiengine/args/MultiImageBundle;", "multiImageBundle", "setEmbedding", "(Lcom/stepos/aiengine/args/MultiImageBundle;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getEmbedding", "()Landroid/os/Bundle;", "loraId", "setLora", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getLora", "()Ljava/lang/String;", "Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "args", "setLlmRuntimeArgs", "(Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getLlmRuntimeArgs", "()Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "option", "addGenerateOption", "getGenerateOptions", "prefix", "setOutputPrefix", "getOutputPrefix", "sessionId", "setSessionId", "getSessionId", "", "threads", "setThreads", "(I)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getThreads", "()I", "toBundle", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatArgsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GENERATE_OPTION_APPEND_TO_HISTORY = "gen.append.history";
    public static final String KEY_EMBEDDING = "msg.embedding";
    public static final String KEY_GENERATE_OPTION = "gen.option";
    public static final String KEY_GENERATE_OUTPUT_PREFIX = "gen.output.prefix";
    public static final String KEY_IMG = "msg.img";
    public static final String KEY_LORA = "lora";
    public static final String KEY_RUNTIME_ARGS = "llm.runtime.args";
    public static final String KEY_SESSION_ID = "session_id";
    public static final String KEY_THREADS = "gen.thread";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3480a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "", "KEY_IMG", "Ljava/lang/String;", "KEY_EMBEDDING", "KEY_LORA", "KEY_RUNTIME_ARGS", "KEY_GENERATE_OPTION", "KEY_GENERATE_OUTPUT_PREFIX", "KEY_SESSION_ID", "KEY_THREADS", "GENERATE_OPTION_APPEND_TO_HISTORY", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final ChatArgsBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new ChatArgsBundle(bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatArgsBundle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final ChatArgsBundle addGenerateOption(String option) {
        k.f(option, "option");
        Bundle bundle = this.f3480a;
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_GENERATE_OPTION);
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        stringArrayList.add(option);
        bundle.putStringArrayList(KEY_GENERATE_OPTION, stringArrayList);
        return this;
    }

    public final Bundle getEmbedding() {
        return this.f3480a.getBundle(KEY_EMBEDDING);
    }

    public final List<String> getGenerateOptions() {
        ArrayList<String> stringArrayList = this.f3480a.getStringArrayList(KEY_GENERATE_OPTION);
        return stringArrayList != null ? stringArrayList : EmptyList.f4893a;
    }

    public final List<String> getImageIds() {
        ArrayList<String> stringArrayList = this.f3480a.getStringArrayList(KEY_IMG);
        return stringArrayList != null ? stringArrayList : EmptyList.f4893a;
    }

    public final LlmRuntimeArgsBundle getLlmRuntimeArgs() {
        Bundle bundle = this.f3480a.getBundle(KEY_RUNTIME_ARGS);
        if (bundle == null) {
            return null;
        }
        return LlmRuntimeArgsBundle.INSTANCE.from(bundle);
    }

    public final String getLora() {
        return this.f3480a.getString("lora");
    }

    public final String getOutputPrefix() {
        return this.f3480a.getString(KEY_GENERATE_OUTPUT_PREFIX);
    }

    public final String getSessionId() {
        return this.f3480a.getString("session_id");
    }

    public final int getThreads() {
        return this.f3480a.getInt(KEY_THREADS, -1);
    }

    public final ChatArgsBundle setEmbedding(MultiImageBundle multiImageBundle) {
        k.f(multiImageBundle, "multiImageBundle");
        this.f3480a.putBundle(KEY_EMBEDDING, multiImageBundle.toBundle());
        return this;
    }

    public final ChatArgsBundle setImageIds(List<String> ids) {
        k.f(ids, "ids");
        this.f3480a.putStringArrayList(KEY_IMG, new ArrayList<>(ids));
        return this;
    }

    public final ChatArgsBundle setLlmRuntimeArgs(LlmRuntimeArgsBundle args) {
        k.f(args, "args");
        this.f3480a.putBundle(KEY_RUNTIME_ARGS, args.toBundle());
        return this;
    }

    public final ChatArgsBundle setLora(String loraId) {
        Bundle bundle = this.f3480a;
        if (loraId == null) {
            bundle.remove("lora");
            return this;
        }
        bundle.putString("lora", loraId);
        return this;
    }

    public final ChatArgsBundle setOutputPrefix(String prefix) {
        Bundle bundle = this.f3480a;
        if (prefix == null) {
            bundle.remove(KEY_GENERATE_OUTPUT_PREFIX);
            return this;
        }
        bundle.putString(KEY_GENERATE_OUTPUT_PREFIX, prefix);
        return this;
    }

    public final ChatArgsBundle setSessionId(String sessionId) {
        Bundle bundle = this.f3480a;
        if (sessionId == null) {
            bundle.remove("session_id");
            return this;
        }
        bundle.putString("session_id", sessionId);
        return this;
    }

    public final ChatArgsBundle setThreads(int threads) {
        this.f3480a.putInt(KEY_THREADS, threads);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3480a);
    }

    public ChatArgsBundle(Bundle bundle) {
        k.f(bundle, "bundle");
        this.f3480a = bundle;
    }

    public /* synthetic */ ChatArgsBundle(Bundle bundle, int i, e eVar) {
        this((i & 1) != 0 ? new Bundle() : bundle);
    }
}
