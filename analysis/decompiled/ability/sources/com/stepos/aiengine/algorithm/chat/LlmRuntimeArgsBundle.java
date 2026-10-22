package com.stepos.aiengine.algorithm.chat;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.ContentParams;
import d5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\u0017J\u0010\u0010+\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020/R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "", AppAgent.CONSTRUCT, "()V", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "topK", "", "topP", "minP", "maxLength", "maxNewTokens", "randomSeed", "repetitionPenalty", "diversityPenalty", "repetitionLastNPenalty", "tailFree", LlmRuntimeArgsBundle.KEY_TYPICAL, "doSample", "", LlmRuntimeArgsBundle.KEY_GREEDY, "enableThinking", "loraId", "", "classifyPrompt", "setTemperature", "value", "setTopK", "setTopP", "setMinP", "setMaxLength", "setMaxNewTokens", "setRandomSeed", "setRepetitionPenalty", "setDiversityPenalty", "setRepetitionLastNPenalty", "setTailFree", "setTypical", "setDoSample", "setGreedy", "setEnableThinking", "setLoraId", "key", "setClassifyPrompt", "toBundle", "Landroid/os/Bundle;", "toContentParams", "Lcom/stepos/core/data/ContentParams;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LlmRuntimeArgsBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float DEFAULT_DIVERSITY_PENALTY = 0.0f;
    public static final boolean DEFAULT_DO_SAMPLE = true;
    public static final boolean DEFAULT_ENABLE_THINKING = true;
    public static final boolean DEFAULT_GREEDY = false;
    public static final int DEFAULT_MAX_LENGTH = 4096;
    public static final int DEFAULT_MAX_NEW_TOKENS = 512;
    public static final float DEFAULT_MIN_P = 0.05f;
    public static final int DEFAULT_RANDOM_SEED = -1;
    public static final int DEFAULT_REPETITION_LAST_N_PENALTY = 64;
    public static final float DEFAULT_REPETITION_PENALTY = 1.0f;
    public static final float DEFAULT_TAIL_FREE = 1.0f;
    public static final float DEFAULT_TEMPERATURE = 0.7f;
    public static final int DEFAULT_TOP_K = 40;
    public static final float DEFAULT_TOP_P = 0.9f;
    public static final float DEFAULT_TYPICAL = 1.0f;
    public static final String KEY_CLASSIFY_PROMPT = "classify_prompt";
    public static final String KEY_DIVERSITY_PENALTY = "diversity_penalty";
    public static final String KEY_DO_SAMPLE = "do_sample";
    public static final String KEY_ENABLE_THINKING = "enable_thinking";
    public static final String KEY_GREEDY = "greedy";
    public static final String KEY_LORA = "lora";
    public static final String KEY_LORA_ID = "lora_id";
    public static final String KEY_MAX_LENGTH = "max_length";
    public static final String KEY_MAX_NEW_TOKENS = "max_new_tokens";
    public static final String KEY_MIN_P = "minp";
    public static final String KEY_RANDOM_SEED = "random_seed";
    public static final String KEY_REPETITION_LAST_N_PENALTY = "repetition_last_n_penalty";
    public static final String KEY_REPETITION_PENALTY = "repetition_penalty";
    public static final String KEY_TAIL_FREE = "tail_free";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_TOP_K = "topk";
    public static final String KEY_TOP_P = "topp";
    public static final String KEY_TYPICAL = "typical";
    public String classifyPrompt;
    public float diversityPenalty;
    public boolean greedy;
    public String loraId;
    public float temperature = 0.7f;
    public int topK = 40;
    public float topP = 0.9f;
    public float minP = 0.05f;
    public int maxLength = 4096;
    public int maxNewTokens = 512;
    public int randomSeed = -1;
    public float repetitionPenalty = 1.0f;
    public int repetitionLastNPenalty = 64;
    public float tailFree = 1.0f;
    public float typical = 1.0f;
    public boolean doSample = true;
    public boolean enableThinking = true;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0014\u0010%\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0014\u0010*\u001a\u00020 8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0014\u0010.\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010/¨\u00062"}, d2 = {"Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", TypedValues.TransitionType.S_FROM, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "default", "()Lcom/stepos/aiengine/algorithm/chat/LlmRuntimeArgsBundle;", "", "KEY_TEMPERATURE", "Ljava/lang/String;", "KEY_TOP_K", "KEY_TOP_P", "KEY_MIN_P", "KEY_MAX_LENGTH", "KEY_MAX_NEW_TOKENS", "KEY_RANDOM_SEED", "KEY_REPETITION_PENALTY", "KEY_DIVERSITY_PENALTY", "KEY_REPETITION_LAST_N_PENALTY", "KEY_TAIL_FREE", "KEY_TYPICAL", "KEY_DO_SAMPLE", "KEY_GREEDY", "KEY_ENABLE_THINKING", "KEY_LORA_ID", "KEY_LORA", "KEY_CLASSIFY_PROMPT", "", "DEFAULT_TEMPERATURE", "F", "", "DEFAULT_TOP_K", "I", "DEFAULT_TOP_P", "DEFAULT_MIN_P", "DEFAULT_MAX_LENGTH", "DEFAULT_MAX_NEW_TOKENS", "DEFAULT_RANDOM_SEED", "DEFAULT_REPETITION_PENALTY", "DEFAULT_DIVERSITY_PENALTY", "DEFAULT_REPETITION_LAST_N_PENALTY", "DEFAULT_TAIL_FREE", "DEFAULT_TYPICAL", "", "DEFAULT_DO_SAMPLE", "Z", "DEFAULT_GREEDY", "DEFAULT_ENABLE_THINKING", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        /* renamed from: default, reason: not valid java name */
        public final LlmRuntimeArgsBundle m7342default() {
            return new LlmRuntimeArgsBundle();
        }

        public final LlmRuntimeArgsBundle from(Bundle bundle) {
            k.f(bundle, "bundle");
            LlmRuntimeArgsBundle llmRuntimeArgsBundle = new LlmRuntimeArgsBundle();
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_TEMPERATURE)) {
                llmRuntimeArgsBundle.temperature = bundle.getFloat(LlmRuntimeArgsBundle.KEY_TEMPERATURE);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_TOP_K)) {
                llmRuntimeArgsBundle.topK = bundle.getInt(LlmRuntimeArgsBundle.KEY_TOP_K);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_TOP_P)) {
                llmRuntimeArgsBundle.topP = bundle.getFloat(LlmRuntimeArgsBundle.KEY_TOP_P);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_MIN_P)) {
                llmRuntimeArgsBundle.minP = bundle.getFloat(LlmRuntimeArgsBundle.KEY_MIN_P);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_MAX_LENGTH)) {
                llmRuntimeArgsBundle.maxLength = bundle.getInt(LlmRuntimeArgsBundle.KEY_MAX_LENGTH);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_MAX_NEW_TOKENS)) {
                llmRuntimeArgsBundle.maxNewTokens = bundle.getInt(LlmRuntimeArgsBundle.KEY_MAX_NEW_TOKENS);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_RANDOM_SEED)) {
                llmRuntimeArgsBundle.randomSeed = bundle.getInt(LlmRuntimeArgsBundle.KEY_RANDOM_SEED);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_REPETITION_PENALTY)) {
                llmRuntimeArgsBundle.repetitionPenalty = bundle.getFloat(LlmRuntimeArgsBundle.KEY_REPETITION_PENALTY);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_DIVERSITY_PENALTY)) {
                llmRuntimeArgsBundle.diversityPenalty = bundle.getFloat(LlmRuntimeArgsBundle.KEY_DIVERSITY_PENALTY);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_REPETITION_LAST_N_PENALTY)) {
                llmRuntimeArgsBundle.repetitionLastNPenalty = bundle.getInt(LlmRuntimeArgsBundle.KEY_REPETITION_LAST_N_PENALTY);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_TAIL_FREE)) {
                llmRuntimeArgsBundle.tailFree = bundle.getFloat(LlmRuntimeArgsBundle.KEY_TAIL_FREE);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_TYPICAL)) {
                llmRuntimeArgsBundle.typical = bundle.getFloat(LlmRuntimeArgsBundle.KEY_TYPICAL);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_DO_SAMPLE)) {
                llmRuntimeArgsBundle.doSample = bundle.getBoolean(LlmRuntimeArgsBundle.KEY_DO_SAMPLE);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_GREEDY)) {
                llmRuntimeArgsBundle.greedy = bundle.getBoolean(LlmRuntimeArgsBundle.KEY_GREEDY);
            }
            if (bundle.containsKey(LlmRuntimeArgsBundle.KEY_ENABLE_THINKING)) {
                llmRuntimeArgsBundle.enableThinking = bundle.getBoolean(LlmRuntimeArgsBundle.KEY_ENABLE_THINKING);
            }
            llmRuntimeArgsBundle.loraId = bundle.getString(LlmRuntimeArgsBundle.KEY_LORA_ID);
            llmRuntimeArgsBundle.classifyPrompt = bundle.getString(LlmRuntimeArgsBundle.KEY_CLASSIFY_PROMPT);
            return llmRuntimeArgsBundle;
        }
    }

    /* renamed from: default, reason: not valid java name */
    public static final LlmRuntimeArgsBundle m7341default() {
        return INSTANCE.m7342default();
    }

    public static final LlmRuntimeArgsBundle from(Bundle bundle) {
        return INSTANCE.from(bundle);
    }

    public final LlmRuntimeArgsBundle setClassifyPrompt(String value) {
        this.classifyPrompt = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setDiversityPenalty(float value) {
        this.diversityPenalty = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setDoSample(boolean value) {
        this.doSample = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setEnableThinking(boolean value) {
        this.enableThinking = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setGreedy(boolean value) {
        this.greedy = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setLoraId(String key) {
        this.loraId = key;
        return this;
    }

    public final LlmRuntimeArgsBundle setMaxLength(int value) {
        this.maxLength = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setMaxNewTokens(int value) {
        this.maxNewTokens = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setMinP(float value) {
        this.minP = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setRandomSeed(int value) {
        this.randomSeed = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setRepetitionLastNPenalty(int value) {
        this.repetitionLastNPenalty = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setRepetitionPenalty(float value) {
        this.repetitionPenalty = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setTailFree(float value) {
        this.tailFree = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setTemperature(float value) {
        this.temperature = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setTopK(int value) {
        this.topK = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setTopP(float value) {
        this.topP = value;
        return this;
    }

    public final LlmRuntimeArgsBundle setTypical(float value) {
        this.typical = value;
        return this;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(KEY_TEMPERATURE, this.temperature);
        bundle.putInt(KEY_TOP_K, this.topK);
        bundle.putFloat(KEY_TOP_P, this.topP);
        bundle.putFloat(KEY_MIN_P, this.minP);
        bundle.putInt(KEY_MAX_LENGTH, this.maxLength);
        bundle.putInt(KEY_MAX_NEW_TOKENS, this.maxNewTokens);
        bundle.putInt(KEY_RANDOM_SEED, this.randomSeed);
        bundle.putFloat(KEY_REPETITION_PENALTY, this.repetitionPenalty);
        bundle.putFloat(KEY_DIVERSITY_PENALTY, this.diversityPenalty);
        bundle.putInt(KEY_REPETITION_LAST_N_PENALTY, this.repetitionLastNPenalty);
        bundle.putFloat(KEY_TAIL_FREE, this.tailFree);
        bundle.putFloat(KEY_TYPICAL, this.typical);
        bundle.putBoolean(KEY_DO_SAMPLE, this.doSample);
        bundle.putBoolean(KEY_GREEDY, this.greedy);
        bundle.putBoolean(KEY_ENABLE_THINKING, this.enableThinking);
        String str = this.loraId;
        if (str != null) {
            bundle.putString(KEY_LORA_ID, str);
        }
        String str2 = this.classifyPrompt;
        if (str2 != null) {
            bundle.putString(KEY_CLASSIFY_PROMPT, str2);
        }
        return bundle;
    }

    public final ContentParams toContentParams() {
        b bVar = new b();
        bVar.c(KEY_TEMPERATURE, this.temperature);
        bVar.d(KEY_TOP_K, this.topK);
        bVar.c(KEY_TOP_P, this.topP);
        bVar.c(KEY_MIN_P, this.minP);
        bVar.d(KEY_MAX_LENGTH, this.maxLength);
        bVar.d(KEY_MAX_NEW_TOKENS, this.maxNewTokens);
        bVar.d(KEY_RANDOM_SEED, this.randomSeed);
        bVar.c(KEY_REPETITION_PENALTY, this.repetitionPenalty);
        bVar.c(KEY_DIVERSITY_PENALTY, this.diversityPenalty);
        bVar.d(KEY_REPETITION_LAST_N_PENALTY, this.repetitionLastNPenalty);
        bVar.c(KEY_TAIL_FREE, this.tailFree);
        bVar.c(KEY_TYPICAL, this.typical);
        bVar.b(KEY_DO_SAMPLE, this.doSample);
        bVar.b(KEY_GREEDY, this.greedy);
        bVar.b(KEY_ENABLE_THINKING, this.enableThinking);
        String str = this.loraId;
        if (str != null) {
            bVar.e("lora", str);
        }
        String str2 = this.classifyPrompt;
        if (str2 != null) {
            bVar.e(KEY_CLASSIFY_PROMPT, str2);
        }
        return bVar.a();
    }
}
