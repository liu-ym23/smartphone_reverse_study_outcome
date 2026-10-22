package com.stepos.aiengine.algorithm.chat;

import Z8.C1173v;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.MultiImageBundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u00010B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0015J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b \u0010\fJ\u0017\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010\u0017J\u0017\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010\u0015J\u000f\u0010&\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b&\u0010\u0017J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020'¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0002¢\u0006\u0004\b-\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "", "", "ids", "setImageIds", "(Ljava/util/List;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getImageIds", "()Ljava/util/List;", "Lcom/stepos/aiengine/args/MultiImageBundle;", "multiImageBundle", "setEmbedding", "(Lcom/stepos/aiengine/args/MultiImageBundle;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getEmbedding", "()Landroid/os/Bundle;", "loraId", "setLora", "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getLora", "()Ljava/lang/String;", "Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "args", "setLlmRuntimeArgs", "(Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getLlmRuntimeArgs", "()Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "option", "addGenerateOption", "getGenerateOptions", "prefix", "setOutputPrefix", "getOutputPrefix", "sessionId", "setSessionId", "getSessionId", "", "threads", "setThreads", "(I)Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "getThreads", "()I", "toBundle", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
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

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle$Companion;", "", "<init>", "()V", "KEY_IMG", "", "KEY_EMBEDDING", "KEY_LORA", "KEY_RUNTIME_ARGS", "KEY_GENERATE_OPTION", "KEY_GENERATE_OUTPUT_PREFIX", "KEY_SESSION_ID", "KEY_THREADS", "GENERATE_OPTION_APPEND_TO_HISTORY", "fromBundle", "Lcom/stepos/aiengine/algorithm/chat/ChatArgsBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ChatArgsBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new ChatArgsBundle(bundle);
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatArgsBundle() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final ChatArgsBundle addGenerateOption(String option) {
        p.i(option, "option");
        ArrayList<String> stringArrayList = this.bundle.getStringArrayList(KEY_GENERATE_OPTION);
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        stringArrayList.add(option);
        this.bundle.putStringArrayList(KEY_GENERATE_OPTION, stringArrayList);
        return this;
    }

    public final Bundle getEmbedding() {
        return this.bundle.getBundle(KEY_EMBEDDING);
    }

    public final List<String> getGenerateOptions() {
        ArrayList<String> stringArrayList = this.bundle.getStringArrayList(KEY_GENERATE_OPTION);
        return stringArrayList != null ? stringArrayList : C1173v.m();
    }

    public final List<String> getImageIds() {
        ArrayList<String> stringArrayList = this.bundle.getStringArrayList(KEY_IMG);
        return stringArrayList != null ? stringArrayList : C1173v.m();
    }

    public final LlmRuntimeArgsBundle getLlmRuntimeArgs() {
        Bundle bundle = this.bundle.getBundle(KEY_RUNTIME_ARGS);
        if (bundle == null) {
            return null;
        }
        return LlmRuntimeArgsBundle.INSTANCE.from(bundle);
    }

    public final String getLora() {
        return this.bundle.getString("lora");
    }

    public final String getOutputPrefix() {
        return this.bundle.getString(KEY_GENERATE_OUTPUT_PREFIX);
    }

    public final String getSessionId() {
        return this.bundle.getString("session_id");
    }

    public final int getThreads() {
        return this.bundle.getInt(KEY_THREADS, -1);
    }

    public final ChatArgsBundle setEmbedding(MultiImageBundle multiImageBundle) {
        p.i(multiImageBundle, "multiImageBundle");
        this.bundle.putBundle(KEY_EMBEDDING, multiImageBundle.toBundle());
        return this;
    }

    public final ChatArgsBundle setImageIds(List<String> ids) {
        p.i(ids, "ids");
        this.bundle.putStringArrayList(KEY_IMG, new ArrayList<>(ids));
        return this;
    }

    public final ChatArgsBundle setLlmRuntimeArgs(LlmRuntimeArgsBundle args) {
        p.i(args, "args");
        this.bundle.putBundle(KEY_RUNTIME_ARGS, args.toBundle());
        return this;
    }

    public final ChatArgsBundle setLora(String loraId) {
        if (loraId == null) {
            this.bundle.remove("lora");
            return this;
        }
        this.bundle.putString("lora", loraId);
        return this;
    }

    public final ChatArgsBundle setOutputPrefix(String prefix) {
        if (prefix == null) {
            this.bundle.remove(KEY_GENERATE_OUTPUT_PREFIX);
            return this;
        }
        this.bundle.putString(KEY_GENERATE_OUTPUT_PREFIX, prefix);
        return this;
    }

    public final ChatArgsBundle setSessionId(String sessionId) {
        if (sessionId == null) {
            this.bundle.remove("session_id");
            return this;
        }
        this.bundle.putString("session_id", sessionId);
        return this;
    }

    public final ChatArgsBundle setThreads(int threads) {
        this.bundle.putInt(KEY_THREADS, threads);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public ChatArgsBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        this.bundle = bundle;
    }

    public /* synthetic */ ChatArgsBundle(Bundle bundle, int i10, i iVar) {
        this((i10 & 1) != 0 ? new Bundle() : bundle);
    }
}
