package com.bytedance.android.bcm.impl.paramcheck;

import com.bytedance.android.bcm.impl.model.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BcmRuleStore$parseModel$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.IntRef $acceptedRule;
    final /* synthetic */ com.bytedance.android.bcm.impl.model.a $model;
    final /* synthetic */ Ref.IntRef $rejectRule;
    final /* synthetic */ BcmRuleStore this$0;

    public BcmRuleStore$parseModel$2(BcmRuleStore r100, com.bytedance.android.bcm.impl.model.a r101, Ref.IntRef r102, Ref.IntRef r103) {
        this.this$0 = r100;
        this.$model = r101;
        this.$acceptedRule = r102;
        this.$rejectRule = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("parse rule success, raw data size: ");
        List<e> r101 = this.$model.a().a();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(", rule size: ");
        r100.append(this.this$0.f41848b.size());
        r100.append(",accepted rules: ");
        r100.append(this.$acceptedRule.element);
        r100.append(", rejected rules: ");
        r100.append(this.$rejectRule.element);
        r100.append(",should check bcm size: ");
        r100.append(this.this$0.f41850d.size());
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
