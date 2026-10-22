package com.obric.aiagent.llm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("prompt_tokens")
    private final int f18720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("completion_tokens")
    private final int f18721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("total_tokens")
    private final int f18722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("is_model_return")
    private final boolean f18723d;

    public i() {
        this(0, 0, 0, false, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f18720a == r6.f18720a) goto L12;
        return false;
    L12:
        if (this.f18721b == r6.f18721b) goto L15;
        return false;
    L15:
        if (this.f18722c == r6.f18722c) goto L18;
        return false;
    L18:
        if (this.f18723d == r6.f18723d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f18720a) * 31) + Integer.hashCode(this.f18721b)) * 31) + Integer.hashCode(this.f18722c)) * 31) + Boolean.hashCode(this.f18723d);
    }

    public String toString() {
        return "Usage(promptTokens=" + this.f18720a + ", completionTokens=" + this.f18721b + ", totalTokens=" + this.f18722c + ", isModelReturn=" + this.f18723d + ')';
    }

    public i(int r1, int r2, int r3, boolean r4) {
        this.f18720a = r1;
        this.f18721b = r2;
        this.f18722c = r3;
        this.f18723d = r4;
    }

    public /* synthetic */ i(int r2, int r3, int r4, boolean r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
