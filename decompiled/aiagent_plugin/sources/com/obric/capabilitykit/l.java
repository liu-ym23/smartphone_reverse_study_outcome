package com.obric.capabilitykit;

import android.app.Application;
import android.content.Context;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f32157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f32158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f32159c = null;

    public static final class a extends d.h.b.p implements d.h.a.a<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32160a = null;

        static {
            f32160a = new a();
        }

        public a() {
            super(0);
        }

        public final n a() {
            n.a r3 = n.f32162b;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r0, "AppHost.application.applicationContext");
            return r3.a(r0);
        }

        @Override // d.h.a.a
        public /* synthetic */ n invoke() {
            return a();
        }
    }

    static {
        f32157a = new l();
        f32159c = d.g.a(a.f32160a);
    }

    private l() {
    }

    private final String a(k r3) {
        return b(r3.b(), r3.d(), r3.e().a());
    }

    private final void a(List<k> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r11.next(), k.class, "com.obric.aiagent.plugin");
        r0.add(AppEntity.CREATOR.fromJsonKeepTimeStamp(r3.c()));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logger.INSTANCE.e("EntityHistoryManager", "handleBulkIndex parseAppEntityError", e);
        r2.add(Long.valueOf(r3.a()));
        goto L4
    L10:
        b().a(r2);
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkIndex " + m.a(m.b(r0)));
        EntityProvider.bulkIndexInner$capabilitykit_release$default(EntityProvider.INSTANCE, r0, null, 2, null);
    }

    private final n b() {
        return (n) ZeusTransformUtils.preCheckCast(f32159c.b(), n.class, "com.obric.aiagent.plugin");
    }

    private final String b(String r1, int r2, String r3) {
        return r1 + '_' + r2 + '_' + r3;
    }

    private final void b(List<k> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r1 = r8.next();
        Integer r2 = Integer.valueOf(((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin")).d());
        Object r3 = r7.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r7.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")).add(r1);
        goto L4
    L9:
        Iterator r9 = r7.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r10.getKey(), Number.class, "com.obric.aiagent.plugin")).intValue();
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10.getValue(), List.class, "com.obric.aiagent.plugin");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.add(((k) ZeusTransformUtils.preCheckCast(r13.next(), k.class, "com.obric.aiagent.plugin")).b());
        goto L14
    L16:
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkDelete " + m.a(r12));
        EntityProvider.INSTANCE.bulkDelete(r12, r4);
        goto L11
    }

    public final synchronized void a() {
        monitor-enter(this);
        com.obric.capabilitykit.entity.memory.a r0 = com.obric.capabilitykit.entity.memory.a.f32135a;     // Catch: Throwable -> L57
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        d.h.b.o.c(r1, "AppHost.application.applicationContext");     // Catch: Throwable -> L57
        if (r0.c(r1) == com.obric.capabilitykit.entity.memory.b.f32136a) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger r2 = Logger.INSTANCE;     // Catch: Throwable -> L57
        r2.i("EntityHistoryManager", "restoreHistoryEntityProcess start");     // Catch: Throwable -> L57
        List<k> r3 = b().b();     // Catch: Throwable -> L57
        if (r3.isEmpty() == false) goto L12;
        r2.i("EntityHistoryManager", "restoreHistoryEntityProcess entityHistoryList is empty");     // Catch: Throwable -> L57
        f32158b = null;     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator<T> r5 = r3.iterator();     // Catch: Throwable -> L57
    L14:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();     // Catch: Throwable -> L57
        String r7 = ((k) ZeusTransformUtils.preCheckCast(r6, k.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L57
        Object r8 = r4.get(r7);     // Catch: Throwable -> L57
        if (r8 != null) goto L18;
        r8 = new ArrayList();     // Catch: Throwable -> L57
        r4.put(r7, r8);     // Catch: Throwable -> L57
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin")).add(r6);     // Catch: Throwable -> L57
        goto L14
    L19:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r11 = new ConcurrentHashMap();     // Catch: Throwable -> L57
        Iterator r12 = r4.entrySet().iterator();     // Catch: Throwable -> L57
    L21:
        if (r12.hasNext() == false) goto L34;
        List r13 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        k r14 = (k) ZeusTransformUtils.preCheckCast(d.a.p.m(r13), k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        String r15 = f32157a.a(r14);     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r16 = f32158b;     // Catch: Throwable -> L57
        if (r16 == null) goto L26;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.get(r15), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        if (r17 == null) goto L26;
    L27:
        d.h.b.o.c(r17, "restoreCountMap?.get(retryKey) ?: 0");     // Catch: Throwable -> L57
        int r18 = r17.intValue();     // Catch: Throwable -> L57
        if (r18 >= 20) goto L30;
        r11.put(r15, Integer.valueOf(r18 + 1));     // Catch: Throwable -> L57
        r9.add(r14);     // Catch: Throwable -> L57
    L32:
        if (r13.size() <= 1) goto L21;
        r10.addAll(d.a.p.e(r13, 1));     // Catch: Throwable -> L57
        goto L21
    L30:
        r10.add(r14);     // Catch: Throwable -> L57
    L26:
        r17 = 0;     // Catch: Throwable -> L57
        goto L27
    L34:
        f32158b = r11;     // Catch: Throwable -> L57
        ArrayList r19 = new ArrayList(d.a.p.a(r10, 10));     // Catch: Throwable -> L57
        Iterator r20 = r10.iterator();     // Catch: Throwable -> L57
    L36:
        if (r20.hasNext() == false) goto L38;
        r19.add(Long.valueOf(((k) ZeusTransformUtils.preCheckCast(r20.next(), k.class, "com.obric.aiagent.plugin")).a()));     // Catch: Throwable -> L57
        goto L36
    L38:
        b().a(r19);     // Catch: Throwable -> L57
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator r22 = r9.iterator();     // Catch: Throwable -> L57
    L40:
        if (r22.hasNext() == false) goto L45;
        Object r23 = r22.next();     // Catch: Throwable -> L57
        j r24 = ((k) ZeusTransformUtils.preCheckCast(r23, k.class, "com.obric.aiagent.plugin")).e();     // Catch: Throwable -> L57
        Object r25 = r21.get(r24);     // Catch: Throwable -> L57
        if (r25 != null) goto L44;
        r25 = new ArrayList();     // Catch: Throwable -> L57
        r21.put(r24, r25);     // Catch: Throwable -> L57
    L44:
        ((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin")).add(r23);     // Catch: Throwable -> L57
        goto L40
    L45:
        Iterator r26 = r21.entrySet().iterator();     // Catch: Throwable -> L57
    L47:
        if (r26.hasNext() == false) goto L55;
        Map.Entry r27 = (Map.Entry) ZeusTransformUtils.preCheckCast(r26.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        j r28 = (j) ZeusTransformUtils.preCheckCast(r27.getKey(), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        List<k> r29 = (List) ZeusTransformUtils.preCheckCast(r27.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L57
        int r30 = r28.ordinal();     // Catch: Throwable -> L57
        if (r30 != 0) goto L50;
        f32157a.a(r29);     // Catch: Throwable -> L57
        goto L47
    L50:
        if (r30 != 1) goto L47;
        f32157a.b(r29);     // Catch: Throwable -> L57
        goto L47
    L55:
        monitor-exit(this);
        return;
    L57:
        th = move-exception;
        throw th;
    }

    public final void a(String r2, int r3, String r4) {
        d.h.b.o.e(r2, "entityId");
        d.h.b.o.e(r4, "actionType");
        ConcurrentHashMap<String, Integer> r0 = f32158b;
        if (r0 == null) goto L6;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.remove(b(r2, r3, r4)), Integer.class, "com.obric.aiagent.plugin");
        return;
    }
}
