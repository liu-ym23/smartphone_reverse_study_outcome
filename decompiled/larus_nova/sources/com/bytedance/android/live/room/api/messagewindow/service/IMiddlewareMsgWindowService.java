package com.bytedance.android.live.room.api.messagewindow.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import d71.c;
import kotlin.Metadata;
import q71.b;
import r61.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u000e\u001a\u00020\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0018\u001a\u00020\u0017H&J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/service/IMiddlewareMsgWindowService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/live/datacontext/DataContext;", "roomContext", "initCardContext", "Lv61/a;", "cardWindow", "Lr61/a;", "cardAbilityImpl", "Ly61/b;", "middlewareCardCtx", "Le71/a;", "msgWindowManager", "Lu61/a;", "cardBuilder", "Ld71/c;", "cardRecorder", "Lq71/b;", "cardStateDispatcher", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "", "getCardContainerOptConfig", "Ljava/lang/Class;", "getBackendModelClass", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareMsgWindowService extends IService {
    a cardAbilityImpl(v61.a r100);

    u61.a cardBuilder();

    i cardMonitor();

    c cardRecorder();

    b cardStateDispatcher(DataCenter r100);

    Class<?> getBackendModelClass();

    boolean getCardContainerOptConfig();

    DataContext initCardContext(DataCenter r100, DataContext r101);

    y61.b middlewareCardCtx(DataCenter r100);

    e71.a msgWindowManager();
}
