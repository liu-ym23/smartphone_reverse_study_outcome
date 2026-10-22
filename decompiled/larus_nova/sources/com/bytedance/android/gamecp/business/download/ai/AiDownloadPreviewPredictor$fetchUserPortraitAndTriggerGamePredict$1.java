package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AiDownloadPreviewPredictor$fetchUserPortraitAndTriggerGamePredict$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ nv.a $callback;
    final /* synthetic */ JSONObject $jsonObject;

    public AiDownloadPreviewPredictor$fetchUserPortraitAndTriggerGamePredict$1(JSONObject r100, nv.a r101) {
        this.$jsonObject = r100;
        this.$callback = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.android.gamecp.host_api.a.b().getAiService().g1(this.$jsonObject, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
