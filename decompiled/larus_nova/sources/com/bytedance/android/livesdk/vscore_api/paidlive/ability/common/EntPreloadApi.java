package com.bytedance.android.livesdk.vscore_api.paidlive.ability.common;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/common/EntPreloadApi;", "", "Lcom/google/gson/JsonObject;", ContainerPosition.BODY, "getBuyPanel", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface EntPreloadApi {
    @POST("/douyin/entertainment/order/buy_panel")
    Object getBuyPanel(@Body JsonObject r100, Continuation<? super JsonObject> r101);
}
