package com.stepos.aiengine.algorithm.chat;

import com.stepos.core.data.LlmToolCall;

/* loaded from: classes2.dex */
public final class LlmlToolCall {
    public static LlmToolCall create(String str, String str2, String str3) {
        String str4 = str3 != null ? str3 : "";
        if (str3 == null) {
            str3 = str;
        }
        return new LlmToolCall(str4, str, str2, str3);
    }
}
