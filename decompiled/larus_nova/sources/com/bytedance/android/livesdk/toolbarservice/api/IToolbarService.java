package com.bytedance.android.livesdk.toolbarservice.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.arch.comp.b;
import com.bytedance.android.livesdk.arch.container.a;
import com.bytedance.android.livesdk.arch.container.d;
import com.bytedance.android.livesdk.arch.data.g;
import com.bytedance.android.livesdk.arch.data.q;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import ot2.c;
import ot2.f;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.toolbarservice.ToolbarServiceImpl")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0011\u001a\u00020\u0010H&J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J.\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/toolbarservice/api/IToolbarService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lot2/c;", "createBottomToolbarViewModelImpl", "Lot2/f;", "toolbarUtil", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initTbContext", "Lcom/bytedance/android/livesdk/arch/context/a;", "getTbContext", "Lke1/a;", "tbMonitor", "Lcom/bytedance/android/livesdk/arch/data/g;", "createDataProcessService", "Lcom/bytedance/android/livesdk/arch/data/q;", "tbDataSource", "Lcom/bytedance/android/livesdk/arch/comp/b;", "createTbComp", "Lcom/bytedance/android/livesdk/arch/container/d;", "type", "tbContext", "Lot2/d;", "compContainer", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "Lcom/bytedance/android/livesdk/arch/container/a;", "createTbContainer", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IToolbarService extends IService {
    c createBottomToolbarViewModelImpl(Context r100, DataCenter r101);

    g createDataProcessService(MiddlewareRoomContext r100, DataCenter r101);

    b createTbComp(Context r100, MiddlewareRoomContext r101, DataCenter r102, q r103);

    a<b> createTbContainer(d r100, com.bytedance.android.livesdk.arch.context.a r101, ot2.d r102, ViewGroup r103);

    com.bytedance.android.livesdk.arch.context.a getTbContext(MiddlewareRoomContext r100, DataCenter r101);

    DataContext initTbContext(Context r100, MiddlewareRoomContext r101, DataCenter r102);

    ke1.a tbMonitor();

    f toolbarUtil();
}
