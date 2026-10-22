package com.stepos.motionkit.fx.material.capability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/BlendParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "stages", "", "Lkotlin/Pair;", "", "getStages", "()Ljava/util/List;", "setStages", "(Ljava/util/List;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlendParams extends MaterialParams {
    private List<Pair<Integer, Integer>> stages = EmptyList.f4893a;

    public final List<Pair<Integer, Integer>> getStages() {
        return this.stages;
    }

    public final void setStages(List<Pair<Integer, Integer>> list) {
        k.f(list, "<set-?>");
        this.stages = list;
    }
}
