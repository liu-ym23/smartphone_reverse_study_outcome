package com.obric.aiagent.applog;

import android.os.Process;
import com.obric.aiagent.apm.IApm;
import com.obric.aiagent.assistant.ipc.BuildConfig;
import com.obric.aiagent.utils.a.c;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: CommonParamsImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommonParamsImpl implements ICommonParams {
    private final ConcurrentHashMap<String, String> headerCache;
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<ICommonParams.a>> paramUpdateCallbacks;

    public static /* synthetic */ x lambda$L01SwQS9z8vzueZXgyIaIRqFfSY(CommonParamsImpl r0, String r1) {
        return init$lambda$4(r0, r1);
    }

    public CommonParamsImpl() {
        this.headerCache = new ConcurrentHashMap();
        this.paramUpdateCallbacks = new ConcurrentHashMap();
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public void init() {
        ConcurrentHashMap<String, String> r0 = this.headerCache;
        r0.put("system_build_type", c.f22312a.a());
        r0.put("build_id", "0");
        r0.put("build_time", "2026-09-23");
        r0.put("build_git_branch", "obric/rls/15.2.0.1");
        r0.put("build_git_commit", "fc4b8ba9c915");
        r0.put("runtime_process_name", com.bytedance.apm.c.c());
        r0.put("runtime_process_id", String.valueOf(Process.myPid()));
        r0.put("idl_sign", BuildConfig.IPC_IDL_SIGN);
        r0.put("flow_app_variant", String.valueOf(com.obric.aiagent.assistant.ipc.a.f16298a.b()));
        Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.applog.impl.a.f16126a.a().a(r3, r4);
        IApm r5 = (IApm) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IApm.class), IApm.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        r5.putExtra(r3, r4);
    L8:
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks.get(r3), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L4;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r7.hasNext() == false) goto L4;
        ((ICommonParams.a) ZeusTransformUtils.preCheckCast(r7.next(), ICommonParams.a.class, "com.obric.aiagent.plugin")).a(r3, r4);
        goto L12
    L14:
        com.obric.aiagent.utils.a.a.f22293a.a(new $$Lambda$CommonParamsImpl$L01SwQS9z8vzueZXgyIaIRqFfSY(this));
    }

    private static final x init$lambda$4(CommonParamsImpl r4, String r5) {
        o.e(r5, "sysDid");
        com.obric.aiagent.applog.impl.a.f16126a.a().a("system_os_did", r5);
        IApm r0 = (IApm) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IApm.class), IApm.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.putExtra("system_os_did", r5);
    L5:
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r4.paramUpdateCallbacks.get("system_os_did"), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        ((ICommonParams.a) ZeusTransformUtils.preCheckCast(r7.next(), ICommonParams.a.class, "com.obric.aiagent.plugin")).a("system_os_did", r5);
    L12:
        return x.f38692a;
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public void addCommonParams(String r4, String r5) {
        o.e(r4, "key");
        o.e(r5, "value");
        ((Map) ZeusTransformUtils.preCheckCast(this.headerCache, Map.class, "com.obric.aiagent.plugin")).put(r4, r5);
        com.obric.aiagent.applog.impl.a.f16126a.a().a(r4, r5);
        CopyOnWriteArraySet r3 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks.get(r4), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        ((ICommonParams.a) ZeusTransformUtils.preCheckCast(r6.next(), ICommonParams.a.class, "com.obric.aiagent.plugin")).a(r4, r5);
        goto L6
    L10:
        return;
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public void putCommonParams(Map<String, String> r7) {
        Map<? extends String, ? extends String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "params");
        this.headerCache.putAll(r8);
        Iterator<Map.Entry<? extends String, ? extends String>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.applog.impl.a.f16126a.a().a(r2, r1);
        IApm r3 = (IApm) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IApm.class), IApm.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        r3.putExtra(r2, r1);
    L8:
        CopyOnWriteArraySet r4 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks.get(r2), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r5.hasNext() == false) goto L4;
        ((ICommonParams.a) ZeusTransformUtils.preCheckCast(r5.next(), ICommonParams.a.class, "com.obric.aiagent.plugin")).a(r2, r1);
        goto L12
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public String getCommonParam(String r2) {
        o.e(r2, "key");
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.headerCache.get(r2), String.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public void addParamUpdateListener(String r4, ICommonParams.a r5) {
        ICommonParams.a r6 = (ICommonParams.a) ZeusTransformUtils.wrapperContextForParams(r5, ICommonParams.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        o.e(r6, "listener");
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks.get(r4), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        ((Map) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks, Map.class, "com.obric.aiagent.plugin")).put(r4, r0);
    L5:
        r0.add(r6);
    }

    @Override // com.obric.aiagent.applog.ICommonParams
    public void removeParamUpdateListener(String r4, ICommonParams.a r5) {
        ICommonParams.a r6 = (ICommonParams.a) ZeusTransformUtils.wrapperContextForParams(r5, ICommonParams.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        o.e(r6, "listener");
        CopyOnWriteArraySet r0 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks.get(r4), CopyOnWriteArraySet.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        ((Map) ZeusTransformUtils.preCheckCast(this.paramUpdateCallbacks, Map.class, "com.obric.aiagent.plugin")).put(r4, r0);
    L5:
        r0.remove(r6);
    }
}
