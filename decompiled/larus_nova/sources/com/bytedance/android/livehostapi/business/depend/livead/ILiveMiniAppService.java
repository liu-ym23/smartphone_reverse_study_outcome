package com.bytedance.android.livehostapi.business.depend.livead;

import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.DeleteStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveAdAuthResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.SaveStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampInfoResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.UpdateStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.UploadImageResponse;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.livead.LiveMiniAppService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J/\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0003H&J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fH&J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0015H&J\u0016\u0010\u0016\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\fH&J\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00192\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001a0\fH&J\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001e0\fH&J\u001e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020 2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020!0\fH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020$H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005H&J\u001e\u0010(\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020)2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fH&J \u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020,0\fH&¨\u0006-À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveMiniAppService;", "Lcom/bytedance/android/livehostapi/business/depend/livead/IMiddlewareLiveMiniAppService;", "changeLiveStreamStatus", "", "status", "", "checkSensitiveTitle", "Lio/reactivex/disposables/Disposable;", "businessType", "title", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;)Lio/reactivex/disposables/Disposable;", "closeFloatWindow", "deleteStamp", "data", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/DeleteStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "getCurrentRoomInfo", "", "hasChangeCoverAuth", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveAdAuthResponse;", "saveStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/SaveStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfoResponse;", "searchStamp", "request", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchResponse;", "selectStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionResponse;", "setMiniAppActivityStatue", "showing", "", "supportMiniApp", "updateCommerceCount", "count", "updateStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UpdateStampRequest;", "uploadImage", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UploadImageResponse;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMiniAppService extends IMiddlewareLiveMiniAppService {
    void changeLiveStreamStatus(int r100);

    Disposable checkSensitiveTitle(Integer r100, String r101, IMiniAppNetworkCallback<StampSensitiveResponse> r102);

    void closeFloatWindow();

    Disposable deleteStamp(DeleteStampRequest r100, IMiniAppNetworkCallback<BaseResponse> r101);

    Map<String, String> getCurrentRoomInfo();

    Disposable hasChangeCoverAuth(IMiniAppNetworkCallback<LiveAdAuthResponse> r100);

    Disposable saveStamp(SaveStampRequest r100, IMiniAppNetworkCallback<StampInfoResponse> r101);

    Disposable searchStamp(StampSearchRequest r100, IMiniAppNetworkCallback<StampSearchResponse> r101);

    Disposable selectStamp(StampSelectionRequest r100, IMiniAppNetworkCallback<StampSelectionResponse> r101);

    void setMiniAppActivityStatue(boolean r100);

    boolean supportMiniApp();

    void updateCommerceCount(int r100);

    Disposable updateStamp(UpdateStampRequest r100, IMiniAppNetworkCallback<BaseResponse> r101);

    Disposable uploadImage(String r100, IMiniAppNetworkCallback<UploadImageResponse> r101);
}
