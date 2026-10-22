package com.uxsense.core.pattern.builder;

import D7.v;
import S7.k;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.uxsense.core.dsl.ViewPatternDsl;
import com.uxsense.core.pattern.ViewPattern;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@ViewPatternDsl
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/uxsense/core/pattern/builder/NoneOfBuilder;", "", AppAgent.CONSTRUCT, "()V", "", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function1;", "Lcom/uxsense/core/pattern/builder/NodePatternBuilder;", "LC7/r;", "block", "node", "(Ljava/lang/String;LS7/k;)V", "(LS7/k;)V", "", "Lcom/uxsense/core/pattern/ViewPattern;", "build$uxsense_release", "()Ljava/util/List;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "patterns", "Ljava/util/List;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoneOfBuilder {
    private final List<ViewPattern> patterns = new ArrayList();

    public final List<ViewPattern> build$uxsense_release() {
        return v.f1(this.patterns);
    }

    public final void node(String name, k block) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(block, "block");
        List<ViewPattern> list = this.patterns;
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(name);
        block.invoke(nodePatternBuilder);
        list.add(nodePatternBuilder.build());
    }

    public final void node(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        List<ViewPattern> list = this.patterns;
        NodePatternBuilder nodePatternBuilder = new NodePatternBuilder(NodePatternBuilderKt.generateNodeName());
        block.invoke(nodePatternBuilder);
        list.add(nodePatternBuilder.build());
    }
}
