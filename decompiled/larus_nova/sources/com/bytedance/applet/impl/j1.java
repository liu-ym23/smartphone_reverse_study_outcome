package com.bytedance.applet.impl;

import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.event.LocalPluginService;
import com.bytedance.applet.provider.impl.AppletLaneInitializer;
import com.larus.audio.AudioServiceDelegate;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class j1 implements Function0 {
    public /* synthetic */ j1() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int r100 = MainlandAppletServiceImpl.f191848d;
        AtomicReference<AppletLaneInitializer.Phase> r101 = AppletLaneInitializer.f192166a;
        if (jw3.c.f500707b.get() == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L22;
        if (AppletLaneInitializer.f192168c.compareAndSet(false, true) == false) goto L11;
        LocalPluginService r103 = LocalPluginService.f191791a;
        LocalPluginService.e();
    L11:
        if (AppletLaneInitializer.f192169d.compareAndSet(false, true) == false) goto L17;
        EventDispatcher r104 = EventDispatcher.f191774a;
        if (EventDispatcher.f191782i.compareAndSet(false, true) == false) goto L17;
        LocalPluginService r105 = LocalPluginService.f191791a;
        Intrinsics.checkNotNullParameter(r104, "listener");
        LocalPluginService.f191798h.add(r104);
        com.larus.im.d.e().registerOnGlobalMessageObserver(r104);
        AudioServiceDelegate.f288288a.r0().m(EventDispatcher.f191777d);
    L17:
        if (AppletLaneInitializer.f192170e.compareAndSet(false, true) == false) goto L20;
        EventDispatcher r106 = EventDispatcher.f191774a;
        com.bytedance.applet.event.e r107 = com.bytedance.applet.event.e.f191812a;
        Intrinsics.checkNotNullParameter(r107, "listener");
        EventDispatcher.f191780g.add(r107);
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("provider must be installed before applet facade lane-owned registration".toString());
    L5:
        r102 = false;
        goto L6
    }
}
