package com.obric.aiagent.executionengine.eventstaskmanager.autoaction;

import android.os.IBinder;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.agent.autoaction.IAutoActionService;
import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.aiagent.executionengine.eventstaskmanager.common.c;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AutoActionTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "autoActionTaskManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16671a = null;

    static {
        f16671a = new a();
    }

    public static /* synthetic */ void lambda$lwNFLZw6KgEbw2CXbeaVEoO6NvI() {
        b();
    }

    private a() {
    }

    public final void a() {
        b.f16676a.a(TAG, "autoActionTaskManager init");
    }

    public final void a(String r4, StateInfo r5, boolean r6) {
        o.e(r4, "packageName");
        o.e(r5, "stateInfo");
        b.f16676a.b(TAG, r4 + ", openAssistantInputPanel");
        if (c.a(r4) == true) goto L8;
        if (o.a(r4, "com.larus.nova") == true) goto L8;
        return;
    L8:
        if (o.a(r4, "com.larus.nova") == false) goto L13;
        com.obric.aiagent.assistant.idl.bean.StateInfo r3 = a(r5);
        IAutoActionService r7 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L14;
        r7.openAssistantInputPanel(r3, r6);
        return;
    L14:
        return;
    }

    public final void a(String r3) {
        o.e(r3, "packageName");
        b.f16676a.b(TAG, r3 + " closeAssistantInputPanel");
        if (c.a(r3) == true) goto L6;
        return;
    L6:
        if (o.a(r3, "com.larus.nova") == false) goto L11;
        IAutoActionService r2 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        r2.closeAssistantInputPanel();
        return;
    L12:
        return;
    }

    public final void a(String r4, boolean r5, StateInfo r6) {
        o.e(r4, "packageName");
        o.e(r6, "stateInfo");
        ISecureLogDepend.Companion.i(TAG, r4 + " notifyAssistantState " + r5 + ' ' + r6);
        if (c.a(r4) == true) goto L6;
        return;
    L6:
        if (o.a(r4, "com.larus.nova") == false) goto L11;
        IAutoActionService r7 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L12;
        r7.notifyAssistantState(r5, a(r6));
        return;
    L12:
        return;
    }

    public final void a(String r5, IAssistantInteractionListener r6) {
        IAssistantInteractionListener r7 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r6, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "packageName");
        b.f16676a.a(TAG, r5 + " setAssistantInteractionListener " + r7);
        if (c.a(r5) == true) goto L6;
        return;
    L6:
        if (o.a(r5, "com.larus.nova") == false) goto L18;
        if (r7 == null) goto L11;
        IBinder r8 = r7.asBinder();
        if (r8 == null) goto L11;
        r8.linkToDeath($$Lambda$a$lwNFLZw6KgEbw2CXbeaVEoO6NvI.INSTANCE, 0);
    L11:
        IAutoActionService r9 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        if (r7 == null) goto L15;
        IAssistantInteractionListenerIDL r4 = a(r7);
    L16:
        r9.setAssistantInteractionListener(r4);
        return;
    L15:
        r4 = null;
        goto L16
    L19:
        return;
    }

    private static final void b() {
        IAutoActionService r0 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.onAssistantInteractionListenerDied();
        return;
    }

    public final void a(String r4, String r5, String r6, Map<?, ?> r7) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "packageName");
        o.e(r5, "content");
        o.e(r6, DBHelper.BATTERY_COL_SCENE);
        ISecureLogDepend.Companion.i(TAG, r4 + " requestSendMessage " + r5 + ' ' + r6 + ' ' + r3);
        if (c.a(r4) == true) goto L5;
        return;
    L5:
        Map<String, String> r8 = null;
        if (r3 == null) goto L25;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r3.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r2 = r1.getKey();
        if (r2 == null) goto L13;
        String r11 = r2.toString();
    L14:
        Object r12 = r1.getValue();
        if (r12 == null) goto L17;
        String r13 = r12.toString();
    L18:
        if (r11 == null) goto L21;
        if (r13 == null) goto L21;
        m r14 = s.a(r11, r13);
    L22:
        if (r14 == null) goto L9;
        r9.add(r14);
    L21:
        r14 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L24:
        r8 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L25:
        IAutoActionService r15 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L34;
        r15.requestSendMessage(r5, r6, r8);
        return;
    }

    private final com.obric.aiagent.assistant.idl.bean.StateInfo a(StateInfo r11) {
        return new com.obric.aiagent.assistant.idl.bean.StateInfo(r11.getRequestType(), r11.getContent(), r11.getRefMessageId(), r11.getTaskType(), r11.getTimeOut(), r11.isInIsland(), r11.getStartWithAsr(), r11.getExt());
    }

    private final IAssistantInteractionListenerIDL a(IAssistantInteractionListener r2) {
        final IAssistantInteractionListener r1 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        return (IAssistantInteractionListenerIDL) ZeusTransformUtils.preCheckCast(new AutoActionTaskManager$changeToIDL$1(r1), IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
