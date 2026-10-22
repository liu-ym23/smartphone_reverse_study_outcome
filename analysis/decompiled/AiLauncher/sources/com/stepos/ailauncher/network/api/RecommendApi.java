package com.stepos.ailauncher.network.api;

import Ac.a;
import Ac.o;
import com.stepos.ailauncher.network.ApiResponse;
import com.stepos.ailauncher.network.model.RecommendCards;
import com.stepos.ailauncher.network.model.RecommendRequest;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/network/api/RecommendApi;", "", "Lcom/stepos/ailauncher/network/model/RecommendRequest;", "request", "Lcom/stepos/ailauncher/network/ApiResponse;", "Lcom/stepos/ailauncher/network/model/RecommendCards;", "getRecommendCards", "(Lcom/stepos/ailauncher/network/model/RecommendRequest;Le9/c;)Ljava/lang/Object;", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RecommendApi {
    @o("GetRecommendCards")
    Object getRecommendCards(@a RecommendRequest recommendRequest, InterfaceC4014c<? super ApiResponse<RecommendCards>> interfaceC4014c);
}
