package com.bytedance.android.livesdk.pluggableinterface;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livehostapi.business.depend.share.ConversationCoreInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.share.QzonePublish;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H&J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/pluggableinterface/IShareGuideService;", "", "canShowGuide", "", "fetchSortedFansGroupFromServer", "", "anchorId", "", "roomId", "", "lifeOwner", "Landroidx/lifecycle/LifecycleOwner;", "getAutoRecordNoticeDialog", "Landroid/app/Dialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getFansGroupDialog", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "text", "getShareGuideWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "markShow", "enter", "notifyEffect", "returnSortedFansGroup", "", "Lcom/bytedance/android/livehostapi/business/depend/share/ConversationCoreInfo;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IShareGuideService {
    boolean canShowGuide();

    void fetchSortedFansGroupFromServer(String r100, long r101, LifecycleOwner r102);

    Dialog getAutoRecordNoticeDialog(Context r100);

    Dialog getFansGroupDialog(Context r100, String r101, String r102);

    LiveWidget getShareGuideWidget();

    void markShow(boolean r100);

    void notifyEffect(String r100, long r101, LifecycleOwner r102);

    List<ConversationCoreInfo> returnSortedFansGroup();
}
