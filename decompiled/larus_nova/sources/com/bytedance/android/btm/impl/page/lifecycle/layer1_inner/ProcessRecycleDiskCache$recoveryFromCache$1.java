package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ProcessRecycleDiskCache$recoveryFromCache$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ Integer $bcmChainMapSize;
    final /* synthetic */ int $chainMapSize;
    final /* synthetic */ Ref.ObjectRef $pageBufferBtm;
    final /* synthetic */ Ref.ObjectRef $pausedInfo;
    final /* synthetic */ Ref.IntRef $singletonMapSize;
    final /* synthetic */ int $unionChainMapSize;

    public ProcessRecycleDiskCache$recoveryFromCache$1(int r100, int r101, Integer r102, Ref.IntRef r103, Ref.ObjectRef r104, Ref.ObjectRef r105) {
        this.$chainMapSize = r100;
        this.$unionChainMapSize = r101;
        this.$bcmChainMapSize = r102;
        this.$singletonMapSize = r103;
        this.$pageBufferBtm = r104;
        this.$pausedInfo = r105;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        JSONObject r100 = new JSONObject();
        r100.put("chain_map_size", this.$chainMapSize);
        r100.put("union_chain_map_size", this.$unionChainMapSize);
        r100.put("bcm_chain_map_size", this.$bcmChainMapSize);
        r100.put("singleton_chain_map_size", this.$singletonMapSize.element);
        r100.put("launch_id", com.bytedance.android.btm.impl.b.f42125d);
        r100.put("pageBufferBtm", (BufferBtm) this.$pageBufferBtm.element);
        Lazy r101 = ProcessRecycleDiskCache.f42271a;
        r100.put("cachedInfoStack", null);
        r100.put("pausedInfo", (i) this.$pausedInfo.element);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
