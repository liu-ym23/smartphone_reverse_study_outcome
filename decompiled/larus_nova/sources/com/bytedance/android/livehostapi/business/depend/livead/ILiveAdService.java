package com.bytedance.android.livehostapi.business.depend.livead;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCommitRemoveResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountResp;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardRemoveRequest;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.livead.LiveAdServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\fH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J$\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018`\u0019H&J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H&J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdService;", "Lcom/bytedance/android/live/base/IService;", "canShowLiveAdCardWindow", "", "canShowLiveAdLandingPageDialogFragment", "clearAdParamsInLiveContainer", "", "commitCardRemove", "Lio/reactivex/disposables/Disposable;", "cardSwitchRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardRemoveRequest;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdNetWorkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCommitRemoveResp;", "getCardCount", "cardCountRequest", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardCountResp;", "getCurrentRoomInfo", "Lorg/json/JSONObject;", "activity", "Landroidx/fragment/app/FragmentActivity;", "initLiveParamsBeforeOpenMiniApp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "putAdParamsToLiveContainer", "adParams", "enterFrom", "roomId", "updateCurrentRoomInfo", "key", "value", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdService extends IService {
    boolean canShowLiveAdCardWindow();

    boolean canShowLiveAdLandingPageDialogFragment();

    void clearAdParamsInLiveContainer();

    Disposable commitCardRemove(CardRemoveRequest r100, ILiveAdNetWorkCallback<CardCommitRemoveResp> r101);

    Disposable getCardCount(CardCountRequest r100, ILiveAdNetWorkCallback<CardCountResp> r101);

    JSONObject getCurrentRoomInfo(FragmentActivity r100);

    HashMap<String, String> initLiveParamsBeforeOpenMiniApp();

    void putAdParamsToLiveContainer(JSONObject r100, String r101, String r102);

    void updateCurrentRoomInfo(FragmentActivity r100, String r101, Object r102);
}
