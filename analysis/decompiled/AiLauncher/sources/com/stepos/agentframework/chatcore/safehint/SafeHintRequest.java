package com.stepos.agentframework.chatcore.safehint;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/b;", "", "", "user_input", "model_output", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUser_input", "getModel_output", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.safehint.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SafeHintRequest {
    private final String model_output;
    private final String user_input;

    public SafeHintRequest(String user_input, String model_output) {
        p.i(user_input, "user_input");
        p.i(model_output, "model_output");
        this.user_input = user_input;
        this.model_output = model_output;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafeHintRequest)) {
            return false;
        }
        SafeHintRequest safeHintRequest = (SafeHintRequest) other;
        return p.d(this.user_input, safeHintRequest.user_input) && p.d(this.model_output, safeHintRequest.model_output);
    }

    public int hashCode() {
        return (this.user_input.hashCode() * 31) + this.model_output.hashCode();
    }

    public String toString() {
        return "SafeHintRequest(user_input=" + this.user_input + ", model_output=" + this.model_output + ")";
    }
}
