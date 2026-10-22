package com.stepos.core.transport.bridge;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.data.base.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/transport/bridge/InferenceRequest;", "", "requestId", "", "input", "Lcom/stepos/core/data/base/Content;", "<init>", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "getRequestId", "()Ljava/lang/String;", "getInput", "()Lcom/stepos/core/data/base/Content;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InferenceRequest {
    private final Content input;
    private final String requestId;

    public InferenceRequest(String requestId, Content input) {
        p.i(requestId, "requestId");
        p.i(input, "input");
        this.requestId = requestId;
        this.input = input;
    }

    public static /* synthetic */ InferenceRequest copy$default(InferenceRequest inferenceRequest, String str, Content content, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = inferenceRequest.requestId;
        }
        if ((i10 & 2) != 0) {
            content = inferenceRequest.input;
        }
        return inferenceRequest.copy(str, content);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final Content getInput() {
        return this.input;
    }

    public final InferenceRequest copy(String requestId, Content input) {
        p.i(requestId, "requestId");
        p.i(input, "input");
        return new InferenceRequest(requestId, input);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InferenceRequest)) {
            return false;
        }
        InferenceRequest inferenceRequest = (InferenceRequest) other;
        return p.d(this.requestId, inferenceRequest.requestId) && p.d(this.input, inferenceRequest.input);
    }

    public final Content getInput() {
        return this.input;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return (this.requestId.hashCode() * 31) + this.input.hashCode();
    }

    public String toString() {
        return "InferenceRequest(requestId=" + this.requestId + ", input=" + this.input + ")";
    }
}
