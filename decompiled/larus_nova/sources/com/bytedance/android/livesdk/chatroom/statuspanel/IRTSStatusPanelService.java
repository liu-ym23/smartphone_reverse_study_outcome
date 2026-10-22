package com.bytedance.android.livesdk.chatroom.statuspanel;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.statuspanel.RTSStatusPanelService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001Jt\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2$\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013\u0012\u0004\u0012\u00020\u00100\u0012H&J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/statuspanel/IRTSStatusPanelService;", "Lcom/bytedance/android/live/base/IService;", "loadRelaxPage", "", "source", "", "roomId", "jumpTabKey", "anchorId", "perfContainer", "Landroid/view/ViewGroup;", "rtsContainer", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "closePanelAction", "Lkotlin/Function0;", "", "sendLogAction", "Lkotlin/Function2;", "", "releaseRelaxPage", "relax", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRTSStatusPanelService extends IService {
    Object loadRelaxPage(String r100, String r101, String r102, String r103, ViewGroup r104, ViewGroup r105, Context r106, Function0<Unit> r107, Function2<? super String, ? super Map<String, String>, Unit> r108);

    void releaseRelaxPage(Object r100);
}
