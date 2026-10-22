package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import com.bytedance.android.ec.common.api.NewPromotionListItemModuleName;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getVisibility", "", EventConstant.Key.MODULE, "Lcom/bytedance/android/ec/common/api/NewPromotionListItemModuleName;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PromotionItemComponentUIConfig$updateUI$1 extends Lambda implements Function1<NewPromotionListItemModuleName, Integer> {
    final /* synthetic */ JSONObject $canShowModule;

    public PromotionItemComponentUIConfig$updateUI$1(JSONObject r100) {
        this.$canShowModule = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(NewPromotionListItemModuleName r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        JSONObject r101 = this.$canShowModule;
        if (r101 != null) goto L5;
        return 1;
    L5:
        if (r101.optBoolean(r100.getModuleName(), true) != true) goto L9;
        return 0;
    L9:
        return 1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(NewPromotionListItemModuleName r100) {
        return Integer.valueOf(invoke2(r100));
    }
}
