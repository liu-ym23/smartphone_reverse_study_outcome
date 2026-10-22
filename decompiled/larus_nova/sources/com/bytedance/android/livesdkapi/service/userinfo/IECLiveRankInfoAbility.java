package com.bytedance.android.livesdkapi.service.userinfo;

import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/userinfo/IECLiveRankInfoAbility;", "", "userInfo", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/service/userinfo/ECUserInfo;", "getUserInfo", "()Lio/reactivex/Observable;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLiveRankInfoAbility {
    Observable<ECUserInfo> getUserInfo();
}
