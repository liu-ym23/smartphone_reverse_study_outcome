package com.bytedance.android.livesdkapi.paidlive;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u008f\u0001\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00072(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0016H&J\b\u0010\u001f\u001a\u00020\u0007H&J$\u0010 \u001a\u00020\u00032\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\"2\u0006\u0010#\u001a\u00020\u0007H&J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u0016H&J\b\u0010'\u001a\u00020\u0003H&J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020\u0003H&J!\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0003H&JM\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u00122\b\u00104\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u0007H&¢\u0006\u0002\u00106J\b\u00107\u001a\u00020\u0003H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=H&¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/IPaidLivePresenter;", "", "adaptLargeFontMode", "", "scene", "Lcom/bytedance/android/livesdk/vscore_api/paid/PaidSceneViewEntry;", "enable", "", "autoChangeMuteStatus", "autoChange", "bindData", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "hidePaidView", "mobExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callback", "Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveCallback;", "", "extraInfo", "Landroid/os/Bundle;", "messageManager", "Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveMessageManager;", "isCardSelect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;Landroid/view/ViewGroup;ZLjava/util/HashMap;Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveCallback;Ljava/lang/Integer;Landroid/os/Bundle;Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveMessageManager;Ljava/lang/Boolean;)V", "checkHasRight", "checkPaidLiveStatus", "checkTempWatchEndMaskShow", "clickBuyModule", "params", "", "bySchema", "currentWatchDuration", "", "getPaidLiveType", "logTempMaskShow", "logTempWatchEndDuration", d.f25928r, "onLiveFinish", "onLiveStart", "livePlayerClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;Ljava/lang/Boolean;)V", "onStopPreview", "openPaidPanel", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "jumpUrl", "autoGrab", "extraParams", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Z)V", "release", "setPaidMaskAdHolder", "holder", "Lcom/bytedance/android/livesdkapi/paidlive/IPaidMaskAdHolderWrapper;", "setPreviewPlayerGetter", "getter", "Lcom/bytedance/android/livesdkapi/paidlive/PreviewPlayClientGetter;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidLivePresenter {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onLiveStart$default(IPaidLivePresenter r100, ILivePlayerClient r101, Boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Boolean.TRUE;
        L6:
            r100.onLiveStart(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLiveStart");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openPaidPanel$default(IPaidLivePresenter r100, Context r101, String r102, Boolean r103, Map r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 8) == 0) goto L6;
            r110 = null;
        L6:
            Map r104 = r110;
            if ((r112 & 16) == 0) goto L9;
            boolean r105 = false;
        L10:
            r100.openPaidPanel(r101, r102, r103, r104, r105);
            return;
        L9:
            r105 = r111;
            goto L10
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPaidPanel");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bindData$default(IPaidLivePresenter r110, IRoom r111, ViewGroup r112, boolean r113, HashMap r114, PaidLiveCallback r115, Integer r116, Bundle r117, IPaidLiveMessageManager r210, Boolean r211, int r212, Object r213) {
            if (r213 != null) goto L31;
            if ((r212 & 4) == 0) goto L7;
            boolean r100 = false;
        L9:
            if ((r212 & 8) == 0) goto L11;
            HashMap r101 = null;
        L13:
            if ((r212 & 16) == 0) goto L15;
            PaidLiveCallback r102 = null;
        L17:
            if ((r212 & 64) == 0) goto L19;
            Bundle r103 = null;
        L21:
            if ((r212 & 128) == 0) goto L23;
            IPaidLiveMessageManager r118 = null;
        L25:
            if ((r212 & 256) == 0) goto L27;
            Boolean r119 = Boolean.TRUE;
        L28:
            r110.bindData(r111, r112, r100, r101, r102, r116, r103, r118, r119);
            return;
        L27:
            r119 = r211;
            goto L28
        L23:
            r118 = r210;
            goto L25
        L19:
            r103 = r117;
            goto L21
        L15:
            r102 = r115;
            goto L17
        L11:
            r101 = r114;
            goto L13
        L7:
            r100 = r113;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindData");
        }
    }

    void adaptLargeFontMode(PaidSceneViewEntry r100, boolean r101);

    void autoChangeMuteStatus(boolean r100);

    void bindData(IRoom r100, ViewGroup r101, boolean r102, HashMap<String, String> r103, PaidLiveCallback r104, Integer r105, Bundle r106, IPaidLiveMessageManager r107, Boolean r108);

    boolean checkHasRight();

    int checkPaidLiveStatus();

    boolean checkTempWatchEndMaskShow();

    void clickBuyModule(Map<String, String> r100, boolean r101);

    long currentWatchDuration();

    int getPaidLiveType();

    void logTempMaskShow();

    long logTempWatchEndDuration(boolean r100);

    void onLiveFinish();

    void onLiveStart(ILivePlayerClient r100, Boolean r101);

    void onStopPreview();

    void openPaidPanel(Context r100, String r101, Boolean r102, Map<String, String> r103, boolean r104);

    void release();

    void setPaidMaskAdHolder(IPaidMaskAdHolderWrapper r100);

    void setPreviewPlayerGetter(PreviewPlayClientGetter r100);
}
