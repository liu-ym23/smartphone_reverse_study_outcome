package com.bytedance.android.livesdkapi.roomplayer;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.model.PlayerGameExtraLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerGameExtraRenderInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerGameExtraRenderController;", "", "cropExtraRender", "", "from", "", "forceCrop", "", "curExtraRenderView", "Landroid/view/View;", "enable", "info", "Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderInfo;", "eventHub", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerGameExtraRenderController$EventHub;", "getGameLayoutType", "", "handleSei", "sei", "hideExtraRender", "invisibleExtraRender", "visible", "isEnable", "log", "msg", "suffix", "renderInfo", "showExtraRender", "updateExtraLayout", "config", "Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraLayoutConfig;", "EventHub", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerGameExtraRenderController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void cropExtraRender$default(ILivePlayerGameExtraRenderController r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.cropExtraRender(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cropExtraRender");
        }

        public static /* synthetic */ void log$default(ILivePlayerGameExtraRenderController r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.log(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerGameExtraRenderController$EventHub;", "", "extraRenderIsShow", "Landroidx/lifecycle/MutableLiveData;", "", "getExtraRenderIsShow", "()Landroidx/lifecycle/MutableLiveData;", "extraViewBottom", "", "getExtraViewBottom", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EventHub {
        MutableLiveData<Boolean> getExtraRenderIsShow();

        MutableLiveData<Integer> getExtraViewBottom();
    }

    void cropExtraRender(String r100, boolean r101);

    View curExtraRenderView();

    void enable(PlayerGameExtraRenderInfo r100);

    EventHub eventHub();

    int getGameLayoutType();

    void handleSei(String r100);

    void hideExtraRender();

    void invisibleExtraRender(boolean r100);

    boolean isEnable();

    void log(String r100, boolean r101);

    PlayerGameExtraRenderInfo renderInfo();

    void showExtraRender();

    void updateExtraLayout(PlayerGameExtraLayoutConfig r100, String r101);
}
