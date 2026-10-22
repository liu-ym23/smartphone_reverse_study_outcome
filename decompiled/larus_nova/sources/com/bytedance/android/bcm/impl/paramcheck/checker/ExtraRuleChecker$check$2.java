package com.bytedance.android.bcm.impl.paramcheck.checker;

import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class ExtraRuleChecker$check$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.bcm.impl.paramcheck.c $target;

    public ExtraRuleChecker$check$2(com.bytedance.android.bcm.impl.paramcheck.c r100) {
        this.$target = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        JSONObject r101 = r100.putOpt("btm", this.$target.getBtm());
        Lazy r102 = BtmFormatUtils.f42489a;
        r101.putOpt("btm_page", BtmFormatUtils.b(this.$target.getBtm()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
