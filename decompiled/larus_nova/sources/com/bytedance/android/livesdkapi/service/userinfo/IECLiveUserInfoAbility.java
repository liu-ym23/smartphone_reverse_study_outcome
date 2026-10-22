package com.bytedance.android.livesdkapi.service.userinfo;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR;\u0010\u000b\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/userinfo/IECLiveUserInfoAbility;", "", "entranceDataSource", "Lcom/bytedance/android/livesdkapi/service/userinfo/IEntranceDataSource;", "getEntranceDataSource", "()Lcom/bytedance/android/livesdkapi/service/userinfo/IEntranceDataSource;", "followStateChanged", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/follow/IFollowPair;", "getFollowStateChanged", "()Lio/reactivex/Observable;", "showAnchorProfile", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "eventParams", "", "getShowAnchorProfile", "()Lkotlin/jvm/functions/Function1;", "userInfo", "Lcom/bytedance/android/livesdkapi/service/userinfo/ECUserInfo;", "getUserInfo", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLiveUserInfoAbility {
    IEntranceDataSource getEntranceDataSource();

    Observable<IFollowPair> getFollowStateChanged();

    Function1<Map<String, String>, Unit> getShowAnchorProfile();

    ECUserInfo getUserInfo();

    /* JADX INFO: renamed from: getUserInfo */
    Observable<ECUserInfo> mo8218getUserInfo();
}
