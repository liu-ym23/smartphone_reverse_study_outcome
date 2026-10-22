package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$seiJsonObject$2 extends FunctionReferenceImpl implements Function0<JSONObject> {
    public RevSeiFrame$seiJsonObject$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "convertSeiToJson", "convertSeiToJson()Lorg/json/JSONObject;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        return ((RevSeiFrame) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
