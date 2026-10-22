package com.bytedance.android.livesdkapi.roomplayer;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMultiDisplay;
import com.bytedance.android.livesdkapi.model.PlayerMultiLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerMultiRenderInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\u0013H&J!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMultiRenderController;", "", "commonLogParams", "", "", "cropMultiRender", "", "from", "forceCrop", "", "disable", "enable", "display", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;", "eventHub", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMultiRenderController$EventHub;", "handleMultiDisplay", "isEnable", "renderInfo", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiRenderInfo;", "setMultiRenderVisibility", RemoteMessageConst.Notification.VISIBILITY, "", "level", "(ILjava/lang/Integer;)V", "updateMultiLayout", "Lcom/bytedance/android/livesdkapi/model/PlayerMainApplyConfig;", "useScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "multiLayoutData", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiLayoutConfig;", "EventHub", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerMultiRenderController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void cropMultiRender$default(ILivePlayerMultiRenderController r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.cropMultiRender(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cropMultiRender");
        }

        public static /* synthetic */ void setMultiRenderVisibility$default(ILivePlayerMultiRenderController r100, int r101, Integer r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.setMultiRenderVisibility(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMultiRenderVisibility");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMultiRenderController$EventHub;", "", "multiRenderBottom", "Landroidx/lifecycle/MutableLiveData;", "", "getMultiRenderBottom", "()Landroidx/lifecycle/MutableLiveData;", "multiRenderIsShow", "", "getMultiRenderIsShow", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EventHub {
        MutableLiveData<Integer> getMultiRenderBottom();

        MutableLiveData<Boolean> getMultiRenderIsShow();
    }

    Map<String, String> commonLogParams();

    void cropMultiRender(String r100, boolean r101);

    void disable();

    boolean enable(PlayerMultiDisplay r100);

    EventHub eventHub();

    void handleMultiDisplay(PlayerMultiDisplay r100, String r101);

    boolean isEnable();

    PlayerMultiRenderInfo renderInfo();

    void setMultiRenderVisibility(int r100, Integer r101);

    PlayerMainApplyConfig updateMultiLayout(ILivePlayerScene r100, PlayerMultiLayoutConfig r101, String r102);
}
