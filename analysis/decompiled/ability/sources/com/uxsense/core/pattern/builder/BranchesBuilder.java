package com.uxsense.core.pattern.builder;

import D7.v;
import S7.k;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.uxsense.core.dsl.ViewPatternDsl;
import com.uxsense.core.pattern.NodeCondition;
import com.uxsense.core.pattern.ViewPattern;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@ViewPatternDsl
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/uxsense/core/pattern/builder/BranchesBuilder;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Lcom/uxsense/core/pattern/builder/ConditionBuilder;", "LC7/r;", "conditionBlock", "Lcom/uxsense/core/pattern/builder/BranchContentBuilder;", "block", "match", "(LS7/k;LS7/k;)V", "otherwise", "(LS7/k;)V", "", "Lcom/uxsense/core/pattern/ViewPattern$Branches$Branch;", "build$uxsense_release", "()Ljava/util/List;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "branches", "Ljava/util/List;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BranchesBuilder {
    private final List<ViewPattern.Branches.Branch> branches = new ArrayList();

    public final List<ViewPattern.Branches.Branch> build$uxsense_release() {
        return v.f1(this.branches);
    }

    public final void match(k conditionBlock, k block) {
        kotlin.jvm.internal.k.f(conditionBlock, "conditionBlock");
        kotlin.jvm.internal.k.f(block, "block");
        ConditionBuilder conditionBuilder = new ConditionBuilder();
        conditionBlock.invoke(conditionBuilder);
        NodeCondition nodeConditionBuild$uxsense_release = conditionBuilder.build$uxsense_release();
        BranchContentBuilder branchContentBuilder = new BranchContentBuilder();
        block.invoke(branchContentBuilder);
        this.branches.add(new ViewPattern.Branches.Branch(nodeConditionBuild$uxsense_release, branchContentBuilder.build$uxsense_release()));
    }

    public final void otherwise(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        BranchContentBuilder branchContentBuilder = new BranchContentBuilder();
        block.invoke(branchContentBuilder);
        this.branches.add(new ViewPattern.Branches.Branch(null, branchContentBuilder.build$uxsense_release()));
    }
}
