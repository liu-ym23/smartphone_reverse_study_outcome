package com.bytedance.ai.resource.core.db;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {127, 127}, m = "cleanOutdatedFile$ai_sdk_release", n = {"appId", "packageName", "digest", "deploymentInfo", RuleConditionBean.VERSION_CODE_KEY, "appId", "packageName", "digest", "deploymentInfo", RuleConditionBean.VERSION_CODE_KEY}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
public final class AIPackageDao$cleanOutdatedFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageDao this$0;

    public AIPackageDao$cleanOutdatedFile$1(AIPackageDao r100, Continuation<? super AIPackageDao$cleanOutdatedFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, null, null, null, this);
    }
}
