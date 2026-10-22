package com.obric.aiagent.llm;

import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.t;
import java.util.List;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
interface ChatCompletionApi {
    @t(a = "/explore/chat/completion")
    Object chatCompletion(@l List<com.bytedance.retrofit2.b.b> r1, @com.bytedance.retrofit2.c.b b r2, d.c.d<? super String> r3);
}
