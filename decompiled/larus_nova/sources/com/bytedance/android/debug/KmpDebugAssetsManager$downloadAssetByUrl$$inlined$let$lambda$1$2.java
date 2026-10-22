package com.bytedance.android.debug;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\b"}, d2 = {"<anonymous>", "", "jsObj", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$onResult$2$1$1", "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$$special$$inlined$runCatching$lambda$1", "com/bytedance/android/debug/KmpDebugAssetsManager$downloadAssetByUrl$2$finalResult$1$onResult$$inlined$forEach$lambda$1"}, k = 3, mv = {1, 5, 1})
final class KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $file$inlined;
    final /* synthetic */ n this$0;

    public KmpDebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1$2(String r100, n r101) {
        this.$file$inlined = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsObj");
        boolean r101 = true;
        if (r100.has("requirement") == false) goto L13;
        if (JSONObjectProtectorUtils.getJSONObject(r100, "requirement").toString().length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L13;
        jy0.b.d("LiveAnchorPushStreamMockManager", "requirement " + JSONObjectProtectorUtils.getJSONObject(r100, "requirement"));
        throw null;
    L7:
        r102 = false;
    L13:
        if (r100.has("model_names") == true) goto L15;
        return;
    L15:
        if (JSONObjectProtectorUtils.getJSONObject(r100, "model_names").toString().length() > 0) goto L18;
        r101 = false;
    L18:
        if (r101 == false) goto L23;
        jy0.b.d("LiveAnchorPushStreamMockManager", "model_names " + JSONObjectProtectorUtils.getJSONObject(r100, "model_names"));
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
