package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J,\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00192\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0014H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\tH&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020'H&J\u001a\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020'H&J\u0012\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0006H&J,\u0010.\u001a\u00020\u00032\"\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000600j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`1H&J0\u00102\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J \u00106\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J*\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&J!\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010>¨\u0006?À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "", "fillGameCpTrackAttrMap", "", "trackAttrMap", "", "", "roomUniqueKey", "isPreview", "", "getCurrentGameId", "getGameCpRoomControllerProvider", "getPreloadToolbarHandler", "roomId", "uniqueKey", "source", "injectPreviewData", "businessBundle", "Landroid/os/Bundle;", "injectPreviewToolbarData", "", "isCardVisible", "isCleanModeChange", "isCleanMode", "isGameCpToolbarShowSuccess", "Lkotlin/Pair;", "isPOI", "onAnchorClickToolbarIcon", "onAnchorPreRequestTransferPage", "onAudienceClickMoreIcon", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCardDataRaw", "data", "onInteractionVisibilityChanged", "visible", "onMoveToFold", "move", "from", "", "onOrientationChange", "requestedOrientation", "onReplaceResult", "isSuccess", "onWebDialogShow", "url", "reportCardDynamicEvent", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "roomEnterGameCpForPreload", "anchorId", "eventParams", "gameId", "sendGameCpToolbarCancelEvent", "sendResultGameStatus", "mContext", "inFold", "setParentView", "parentView", "Landroid/view/View;", "fold", "(Landroid/view/View;Ljava/lang/Boolean;)V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCpLiveService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onReplaceResult$default(IGameCpLiveService r100, boolean r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = -1;
        L6:
            r100.onReplaceResult(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReplaceResult");
        }

        public static /* synthetic */ void setParentView$default(IGameCpLiveService r100, View r101, Boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = Boolean.FALSE;
        L6:
            r100.setParentView(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setParentView");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onReplaceResult$default(IGameCpLiveService r100, boolean r101, int r102, int r103, Object r104) {
            CC.onReplaceResult$default(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void setParentView$default(IGameCpLiveService r100, View r101, Boolean r102, int r103, Object r104) {
            CC.setParentView$default(r100, r101, r102, r103, r104);
        }
    }

    void fillGameCpTrackAttrMap(Map<String, String> r100, String r101, boolean r102);

    String getCurrentGameId();

    Object getGameCpRoomControllerProvider();

    Object getPreloadToolbarHandler(String r100, String r101, String r102);

    void injectPreviewData(Bundle r100);

    void injectPreviewToolbarData(long r100, String r101, String r102);

    boolean isCardVisible();

    void isCleanModeChange(boolean r100);

    Pair<Boolean, Boolean> isGameCpToolbarShowSuccess(String r100, String r101, String r102);

    boolean isPOI();

    void onAnchorClickToolbarIcon();

    void onAnchorPreRequestTransferPage();

    void onAudienceClickMoreIcon(Context r100, String r101, boolean r102);

    void onCardDataRaw(String r100, long r101);

    void onInteractionVisibilityChanged(boolean r100);

    void onMoveToFold(boolean r100, int r101);

    void onOrientationChange(int r100);

    void onReplaceResult(boolean r100, int r101);

    void onWebDialogShow(String r100);

    void reportCardDynamicEvent(HashMap<String, String> r100);

    void roomEnterGameCpForPreload(String r100, String r101, String r102, String r103, String r104);

    void sendGameCpToolbarCancelEvent(String r100, String r101, String r102);

    void sendResultGameStatus(Context r100, boolean r101, String r102, boolean r103);

    void setParentView(View r100, Boolean r101);
}
