package com.bytedance.android.livesdk.dynamic;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.ct;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamic/DynamicService;", "Lcom/bytedance/android/livesdk/dynamic/IDynamicService;", "()V", "initRoomContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isVsRoom", "", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DynamicService implements IDynamicService {
    public DynamicService() {
    }

    @Override // com.bytedance.android.livesdk.dynamic.IDynamicService
    public void initRoomContext(final Context r100, DataContext r101, final DataCenter r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        if ((r101 instanceof MiddlewareRoomContext) == true) goto L5;
        r101 = null;
    L5:
        final MiddlewareRoomContext r104 = (MiddlewareRoomContext) r101;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        if (ct.f119977a.getValue().booleanValue() == false) goto L14;
        r104.getShortTermDynamicShowFramework().e(new AnonymousClass1(r100, r104, r102));
        return;
    }
}
