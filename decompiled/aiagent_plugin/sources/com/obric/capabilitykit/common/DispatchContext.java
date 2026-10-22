package com.obric.capabilitykit.common;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DispatchContext {
    private final Context context;
    private final Map<String, String> ext;
    private final Long questionId;

    public DispatchContext(Context r3, Long r4, Map<String, String> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.questionId = r4;
        this.ext = r7;
    }

    public /* synthetic */ DispatchContext(Context r2, Long r3, Map r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        this(r7, r3, r8);
    }

    public static /* synthetic */ DispatchContext copy$default(DispatchContext r1, Context r2, Long r3, Map r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.context;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.questionId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.ext;
    L12:
        return r1.copy(r7, r3, r8);
    }

    public final Context component1() {
        return this.context;
    }

    public final Long component2() {
        return this.questionId;
    }

    public final Map<String, String> component3() {
        return this.ext;
    }

    public final DispatchContext copy(Context r2, Long r3, Map<String, String> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        return new DispatchContext(r1, r3, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DispatchContext.class) == true) goto L8;
        return false;
    L8:
        DispatchContext r6 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5, DispatchContext.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.questionId, r6.questionId) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.ext, r6.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        Long r1 = this.questionId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Map<String, String> r5 = this.ext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DispatchContext(context=" + this.context + ", questionId=" + this.questionId + ", ext=" + this.ext + ')';
    }
}
