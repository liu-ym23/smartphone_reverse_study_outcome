package com.stepos.taskrobot.llmapi.stepfun.internal;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/internal/ConflictVisibilityDecider;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function0;", "", "block", "safeEval", "(LS7/a;)Z", "r1", "r2", "decide", "(LS7/a;LS7/a;)Z", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConflictVisibilityDecider {
    public static final ConflictVisibilityDecider INSTANCE = new ConflictVisibilityDecider();

    private ConflictVisibilityDecider() {
    }

    private final boolean safeEval(a block) {
        try {
            return ((Boolean) block.invoke()).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean decide(a r1, a r22) {
        boolean zBooleanValue;
        k.f(r1, "r1");
        k.f(r22, "r2");
        try {
            zBooleanValue = ((Boolean) r1.invoke()).booleanValue();
        } catch (Throwable unused) {
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            return true;
        }
        try {
            return ((Boolean) r22.invoke()).booleanValue();
        } catch (Throwable unused2) {
            return false;
        }
    }
}
