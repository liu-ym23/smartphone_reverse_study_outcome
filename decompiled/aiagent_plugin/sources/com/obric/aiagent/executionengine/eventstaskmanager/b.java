package com.obric.aiagent.executionengine.eventstaskmanager;

import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: TaskListenerManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "TaskChangeListenerManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.a>> f16673b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.b>> f16674c = null;

    public static /* synthetic */ CopyOnWriteArrayList lambda$0hnEgYSvQuNfDK0Otocx5vq7Z8c(String r0) {
        return b(r0);
    }

    public static /* synthetic */ CopyOnWriteArrayList lambda$3AP_rjt9TCIouMpzZf6Yo1pz1qs(String r0) {
        return a(r0);
    }

    public static /* synthetic */ CopyOnWriteArrayList lambda$ARLbon8ZGDj2LxfhmMDr9o4bEBE(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CopyOnWriteArrayList lambda$WlvFboBi0Yg3t6ZTIpSv7Yz_hdk(d.h.a.b r0, Object r1) {
        return b(r0, r1);
    }

    private b() {
    }

    static {
        f16672a = new b();
        f16673b = new ConcurrentHashMap();
        f16674c = new ConcurrentHashMap();
    }

    private static final CopyOnWriteArrayList a(d.h.a.b r2, Object r3) {
        return (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
    }

    private static final CopyOnWriteArrayList a(String r1) {
        o.e(r1, "it");
        return new CopyOnWriteArrayList();
    }

    public final void a(String r4, com.obric.eventkit.task.api.a r5) {
        com.obric.eventkit.task.api.a r3 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "packageName");
        o.e(r3, "listener");
        ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.a>> r6 = f16673b;
        final $$Lambda$b$3AP_rjt9TCIouMpzZf6Yo1pz1qs r1 = $$Lambda$b$3AP_rjt9TCIouMpzZf6Yo1pz1qs.INSTANCE;
        ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.computeIfAbsent(r4, new $$Lambda$b$ARLbon8ZGDj2LxfhmMDr9o4bEBE(r1)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin")).add(r3);
        ITaskManagerApi r7 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        r7.setShortcutsActivityPkgName(r4);
    L5:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerEventTaskChangeListener, packageName = " + r4);
    }

    public final void b(String r4, com.obric.eventkit.task.api.a r5) {
        com.obric.eventkit.task.api.a r3 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "packageName");
        o.e(r3, "listener");
        ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.a>> r6 = f16673b;
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.get(r4), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r3);
        if (r0.isEmpty() == false) goto L8;
        r6.remove(r4, r0);
    L8:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterEventTaskChangeListener, packageName = " + r4);
    }

    private static final CopyOnWriteArrayList b(d.h.a.b r2, Object r3) {
        return (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
    }

    private static final CopyOnWriteArrayList b(String r1) {
        o.e(r1, "it");
        return new CopyOnWriteArrayList();
    }

    public final void a(String r4, com.obric.eventkit.task.api.b r5) {
        com.obric.eventkit.task.api.b r3 = (com.obric.eventkit.task.api.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.eventkit.task.api.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "packageName");
        o.e(r3, "listener");
        ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.b>> r6 = f16674c;
        final $$Lambda$b$0hnEgYSvQuNfDK0Otocx5vq7Z8c r1 = $$Lambda$b$0hnEgYSvQuNfDK0Otocx5vq7Z8c.INSTANCE;
        ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.computeIfAbsent(r4, new $$Lambda$b$WlvFboBi0Yg3t6ZTIpSv7Yz_hdk(r1)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin")).add(r3);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerEventTaskScheduleListener, packageName = " + r4);
    }

    public final void b(String r4, com.obric.eventkit.task.api.b r5) {
        com.obric.eventkit.task.api.b r3 = (com.obric.eventkit.task.api.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.eventkit.task.api.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "packageName");
        o.e(r3, "listener");
        ConcurrentHashMap<String, CopyOnWriteArrayList<com.obric.eventkit.task.api.b>> r6 = f16674c;
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.get(r4), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r3);
        if (r0.isEmpty() == false) goto L8;
        r6.remove(r4, r0);
    L8:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterEventTaskScheduleListener, packageName = " + r4);
    }

    public final void a(String r3, int r4) {
        o.e(r3, "packageName");
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(f16673b.get(r3), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.eventkit.task.api.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin")).onChanged(r4);
        goto L6
    L10:
        return;
    }

    public final void a(String r3, EventTask r4) {
        o.e(r3, "packageName");
        o.e(r4, "task");
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(f16674c.get(r3), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((com.obric.eventkit.task.api.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.eventkit.task.api.b.class, "com.obric.aiagent.plugin")).a(r4);
        goto L6
    L10:
        return;
    }
}
