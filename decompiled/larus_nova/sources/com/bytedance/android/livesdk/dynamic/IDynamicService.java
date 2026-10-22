package com.bytedance.android.livesdk.dynamic;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ServiceLookup("om.bytedance.android.livesdk.dynamic.DynamicService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/dynamic/IDynamicService;", "Lcom/bytedance/android/live/base/IService;", "initRoomContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isVsRoom", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDynamicService extends IService {
    void initRoomContext(Context r100, DataContext r101, DataCenter r102, boolean r103);
}
