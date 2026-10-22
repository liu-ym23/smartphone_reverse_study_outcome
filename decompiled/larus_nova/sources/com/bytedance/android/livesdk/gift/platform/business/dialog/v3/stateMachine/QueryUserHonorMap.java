package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/QueryUserHonorMap;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "userHonorMap", "", "", "", "(Ljava/util/Map;)V", "getUserHonorMap", "()Ljava/util/Map;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QueryUserHonorMap extends GiftRepoAction {

    @TraceExclude
    private final Map<String, Object> userHonorMap;

    public final Map<String, Object> getUserHonorMap() {
        return this.userHonorMap;
    }

    public QueryUserHonorMap(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "userHonorMap");
        super("QueryUserHonorMap");
        this.userHonorMap = r100;
    }
}
