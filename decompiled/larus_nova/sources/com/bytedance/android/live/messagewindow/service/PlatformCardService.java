package com.bytedance.android.live.messagewindow.service;

import com.bytedance.android.live.messagewindow.framework.ability.CardAbilityPlatformImpl;
import com.bytedance.android.live.messagewindow.framework.manager.CardManager;
import com.bytedance.android.live.messagewindow.framework.schedule.CardActionScheduler;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import d71.d;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r71.c;
import u61.a;
import y61.b;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/messagewindow/service/PlatformCardService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/IPlatformCardService;", "Lv61/a;", "cardWindow", "Lr61/a;", "newCardAbilityImpl", "Ly61/b;", "msgWindowCtx", "Le71/a;", "newCardManager", "Lq71/d;", "Lr71/c;", "recordState", "Ld71/d;", "Ld71/b;", "newRecordManager", "Lu61/a;", "newCardBuilder", "Li71/a;", "newCardScheduler", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PlatformCardService implements IPlatformCardService {
    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public a newCardBuilder() {
        return new cm0.a();
    }

    public PlatformCardService() {
        k.l(IPlatformCardService.class, this);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public i cardMonitor() {
        return fm0.a.f477774d;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public r61.a newCardAbilityImpl(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardWindow");
        IMiddlewareMsgWindowService r101 = (IMiddlewareMsgWindowService) k.f(IMiddlewareMsgWindowService.class);
        if (r101 == null) goto L6;
        r61.a r102 = r101.cardAbilityImpl(r100);
        if (r102 == null) goto L6;
    L7:
        if (r101 == null) goto L11;
        b r103 = r101.middlewareCardCtx(r100.getDataCenter());
        if (r103 == null) goto L11;
        r102.g(r103.getRoomContext(), r103.getDataCenter());
    L11:
        return r102;
    L6:
        r102 = new CardAbilityPlatformImpl(r100);
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public e71.a newCardManager(b r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindowCtx");
        return new CardManager(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public i71.a newCardScheduler(b r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindowCtx");
        return new CardActionScheduler(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService
    public d<v61.a, d71.b> newRecordManager(q71.d<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "recordState");
        return new em0.a(r100);
    }
}
