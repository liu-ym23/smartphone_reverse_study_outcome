package com.stepos.core.model.inference;

import b7.k;
import com.stepos.base.protocol.ProtocolType;
import gc.o;
import gc.q;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Postprocessor implements x6.c {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Postprocessor";
    private long lastProcessTimeMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final String formatLLMOutput(String str) {
        return q.L0(o.i0(o.i0(str, "assistant\n", ""), "assistant:", "")).toString();
    }

    private final String formatToken(String str, k kVar) {
        return (q.l0(str, "<|im_end|>", false) || q.l0(str, "<|endoftext|>", false)) ? o.i0(o.i0(str, "<|im_end|>", ""), "<|endoftext|>", "") : str;
    }

    private final String formatVLMOutput(String str) {
        return q.L0(str).toString();
    }

    private final String processTextOutput(String str, k kVar) {
        String strRemoveSpecialTokens = removeSpecialTokens(str);
        if (kVar.c(ProtocolType.f6378a)) {
            strRemoveSpecialTokens = formatLLMOutput(strRemoveSpecialTokens);
        } else if (kVar.c(ProtocolType.f6379b)) {
            strRemoveSpecialTokens = formatVLMOutput(strRemoveSpecialTokens);
        }
        return q.L0(strRemoveSpecialTokens).toString();
    }

    private final String removeSpecialTokens(String str) {
        return o.i0(o.i0(o.i0(o.i0(o.i0(o.i0(str, "<|im_start|>", ""), "<|im_end|>", ""), "<|endoftext|>", ""), "<s>", ""), "</s>", ""), "<pad>", "");
    }

    public long getProcessTimeMs() {
        return this.lastProcessTimeMs;
    }

    @Override // x6.c
    public Object process(Object output, k modelConfig) {
        g.f(output, "output");
        g.f(modelConfig, "modelConfig");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (output instanceof String) {
            output = processTextOutput((String) output, modelConfig);
        }
        this.lastProcessTimeMs = System.currentTimeMillis() - jCurrentTimeMillis;
        return output;
    }

    @Override // x6.c
    public String processToken(String token, k modelConfig) {
        g.f(token, "token");
        g.f(modelConfig, "modelConfig");
        return formatToken(token, modelConfig);
    }
}
