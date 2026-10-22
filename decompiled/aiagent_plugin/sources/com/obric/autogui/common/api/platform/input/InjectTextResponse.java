package com.obric.autogui.common.api.platform.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: InjectTextResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InjectTextResponse {
    private final List<InjectTextViewTreeNode> inputNodes;
    private final InjectTextResponseType type;

    public static /* synthetic */ InjectTextResponse copy$default(InjectTextResponse r1, InjectTextResponseType r2, List r3, int r4, Object r5) {
        List<InjectTextViewTreeNode> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.inputNodes;
    L9:
        return r1.copy(r2, r6);
    }

    public final InjectTextResponseType component1() {
        return this.type;
    }

    public final List<InjectTextViewTreeNode> component2() {
        return this.inputNodes;
    }

    public final InjectTextResponse copy(InjectTextResponseType r2, List<InjectTextViewTreeNode> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "type");
        return new InjectTextResponse(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InjectTextResponse.class) == true) goto L8;
        return false;
    L8:
        InjectTextResponse r6 = (InjectTextResponse) ZeusTransformUtils.preCheckCast(r5, InjectTextResponse.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.inputNodes, r6.inputNodes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        List<InjectTextViewTreeNode> r1 = this.inputNodes;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "InjectTextResponse(type=" + this.type + ", inputNodes=" + this.inputNodes + ')';
    }

    public InjectTextResponse(InjectTextResponseType r3, List<InjectTextViewTreeNode> r4) {
        List<InjectTextViewTreeNode> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "type");
        this.type = r3;
        this.inputNodes = r5;
    }

    public final InjectTextResponseType getType() {
        return this.type;
    }

    public final List<InjectTextViewTreeNode> getInputNodes() {
        return this.inputNodes;
    }
}
