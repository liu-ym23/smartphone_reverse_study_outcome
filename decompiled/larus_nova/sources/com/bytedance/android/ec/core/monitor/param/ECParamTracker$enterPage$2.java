package com.bytedance.android.ec.core.monitor.param;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECParamTracker$enterPage$2 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $schema;
    final /* synthetic */ ECParamTracker this$0;

    public ECParamTracker$enterPage$2(ECParamTracker r100, String r101) {
        this.this$0 = r100;
        this.$schema = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        return ECParamTracker.o(this.this$0, UriProtector.parse(this.$schema));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
