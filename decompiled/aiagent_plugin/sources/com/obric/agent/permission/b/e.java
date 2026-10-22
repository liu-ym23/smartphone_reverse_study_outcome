package com.obric.agent.permission.b;

import com.google.gson.Gson;
import com.obric.agent.IAgentService;
import com.obric.agent.ObricService;
import com.obric.agent.permission.bean.Permission;
import com.obric.agent.permission.bean.RequestPermissionOption;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.w;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: RequestHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f15407a = null;

    static {
        f15407a = new e();
    }

    private e() {
    }

    public final RequestPermissionResult requestPermissions(RequestPermissionReq r11, DispatchContext r12) {
        o.e(r11, Ext.KEY_REQUEST);
        o.e(r12, "dispatchContext");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11.getPermissions(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (w.a(((Permission) ZeusTransformUtils.preCheckCast(r3, Permission.class, "com.obric.aiagent.plugin")).getAppletId()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if (r5.isEmpty() == true) goto L11;
        a(RequestPermissionReq.copy$default(r11, null, null, null, r5, 7, null), r12);
        return new RequestPermissionResult(RequestPermissionResult.a.f15409b, null, 2, null);
    L11:
        return new RequestPermissionResult(RequestPermissionResult.a.f15408a, null, 2, null);
    }

    private final void a(RequestPermissionReq r26, DispatchContext r27) {
        Gson r0 = EntityExtKt.a();
        DataSource r7 = new DataSource("System", "System_RequestPermissions", null, 4, null);
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        r1.put("KEY_TITLE", r26.getTitle());
        r1.put("KEY_CONTENT", r26.getContent());
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r26.getOptions(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(((RequestPermissionOption) ZeusTransformUtils.preCheckCast(r4.next(), RequestPermissionOption.class, "com.obric.aiagent.plugin")).getText());
        goto L4
    L6:
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        r1.put("KEY_OPTIONS", ObricService.INSTANCE.getGson().toJson(r5));
        x r6 = x.f38692a;
        String r18 = r0.toJson(new AppIntentMessage(r7, true, true, null, null, false, false, null, r10, (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin"), 248, null));
        IAgentService r17 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L11;
        o.a(r18);
        IAgentService.a.a(r17, r18, OAppIntentBizContentType.USER_REMIND_CARD, String.valueOf(r27.getQuestionId()), 0, null, 24, null);
        return;
    }
}
