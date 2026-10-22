package com.uxsense.core.pattern.builder;

import androidx.autofill.HintConstants;
import com.uxsense.core.pattern.ViewPattern;
import j9.t;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "generateNodeName", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_NAME, "", "isAnonymousName", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lcom/uxsense/core/pattern/builder/NodePatternBuilder;", "LC7/r;", "block", "Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "viewPattern", "(Ljava/lang/String;LS7/k;)Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "(LS7/k;)Lcom/uxsense/core/pattern/ViewPattern$NodePattern;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nodeNameCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "ANONYMOUS_NAME_PREFIX", "Ljava/lang/String;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NodePatternBuilderKt {
    public static final String ANONYMOUS_NAME_PREFIX = "_anon_";
    private static final AtomicInteger nodeNameCounter = new AtomicInteger(0);

    public static final String generateNodeName() {
        return ANONYMOUS_NAME_PREFIX + nodeNameCounter.incrementAndGet();
    }

    public static final boolean isAnonymousName(String name) {
        k.f(name, "name");
        return t.e0(name, ANONYMOUS_NAME_PREFIX, false);
    }

    public static final ViewPattern.NodePattern viewPattern(String name, S7.k block) {
        k.f(name, "name");
        k.f(block, "block");
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(name);
        block.invoke(nodePatternBuilder);
        return nodePatternBuilder.build();
    }

    public static final ViewPattern.NodePattern viewPattern(S7.k block) {
        k.f(block, "block");
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(generateNodeName());
        block.invoke(nodePatternBuilder);
        return nodePatternBuilder.build();
    }
}
