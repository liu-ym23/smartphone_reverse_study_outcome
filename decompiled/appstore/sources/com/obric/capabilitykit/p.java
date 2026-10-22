package com.obric.capabilitykit;

import android.content.Context;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap f11376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f11377c = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<cb.t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11378a = null;

        static {
            f11378a = new b();
        }

        public b() {
            super(0);
        }

        @NotNull
        public final cb.t a() {
            cb.t.a r10 = cb.t.f6104b;
            Context r11 = AppHost.Companion.getApplication().getApplicationContext();
            kotlin.jvm.internal.q.f(r11, "AppHost.application.applicationContext");
            return r10.a(r11);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ cb.t invoke() {
            return a();
        }
    }

    static {
        f11375a = new p();
        f11377c = kotlin.b.b(b.f11378a);
    }

    public p() {
    }

    public final cb.t a() {
        return (cb.t) f11377c.getValue();
    }

    public final String b(cb.u r10) {
        return e(r10.c(), r10.e(), r10.a().b());
    }

    public final void c(String r10, int r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "entityId");
        kotlin.jvm.internal.q.g(r12, "actionType");
        ConcurrentHashMap r13 = f11376b;
        if (r13 == null) goto L6;
        Integer r14 = (Integer) r13.remove(e(r10, r11, r12));
        return;
    }

    public final void d(List r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        Integer r14 = Integer.valueOf(((cb.u) r13).e());
        Object r15 = r11.get(r14);
        if (r15 != null) goto L8;
        r15 = new ArrayList();
        r11.put(r14, r15);
    L8:
        ((List) r15).add(r13);
        goto L4
    L9:
        Iterator r16 = r11.entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L17;
        Map.Entry r17 = (Map.Entry) r16.next();
        int r18 = ((Number) r17.getKey()).intValue();
        List r19 = (List) r17.getValue();
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L14:
        if (r21.hasNext() == false) goto L16;
        r20.add(((cb.u) r21.next()).c());
        goto L14
    L16:
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkDelete " + q.b(r20));
        EntityProvider.INSTANCE.bulkDelete(r20, r18);
        goto L11
    }

    public final String e(String r10, int r11, String r12) {
        return r10 + '_' + r11 + '_' + r12;
    }

    public final synchronized void f() {
        monitor-enter(this);
        db.a r10 = db.a.f19145a;     // Catch: Throwable -> L12
        Context r11 = AppHost.Companion.getApplication().getApplicationContext();     // Catch: Throwable -> L12
        kotlin.jvm.internal.q.f(r11, "AppHost.application.applicationContext");     // Catch: Throwable -> L12
        if (r10.a(r11) == MemoryServiceStatus.AVAILABLE) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger r12 = Logger.INSTANCE;     // Catch: Throwable -> L12
        r12.i("EntityHistoryManager", "restoreHistoryEntityProcess start");     // Catch: Throwable -> L12
        List r13 = a().i();     // Catch: Throwable -> L12
        if (r13.isEmpty() == false) goto L14;
        r12.i("EntityHistoryManager", "restoreHistoryEntityProcess entityHistoryList is empty");     // Catch: Throwable -> L12
        f11376b = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L14:
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Throwable -> L12
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L12
    L16:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();     // Catch: Throwable -> L12
        String r17 = ((cb.u) r16).c();     // Catch: Throwable -> L12
        Object r18 = r14.get(r17);     // Catch: Throwable -> L12
        if (r18 != null) goto L20;
        r18 = new ArrayList();     // Catch: Throwable -> L12
        r14.put(r17, r18);     // Catch: Throwable -> L12
    L20:
        ((List) r18).add(r16);     // Catch: Throwable -> L12
        goto L16
    L21:
        ArrayList r19 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L12
        ConcurrentHashMap r21 = new ConcurrentHashMap();     // Catch: Throwable -> L12
        Iterator r22 = r14.entrySet().iterator();     // Catch: Throwable -> L12
    L23:
        if (r22.hasNext() == false) goto L36;
        List r23 = (List) ((Map.Entry) r22.next()).getValue();     // Catch: Throwable -> L12
        cb.u r24 = (cb.u) b0.i0(r23);     // Catch: Throwable -> L12
        String r25 = f11375a.b(r24);     // Catch: Throwable -> L12
        ConcurrentHashMap r26 = f11376b;     // Catch: Throwable -> L12
        if (r26 == null) goto L28;
        Integer r27 = (Integer) r26.get(r25);     // Catch: Throwable -> L12
        if (r27 == null) goto L28;
    L29:
        kotlin.jvm.internal.q.f(r27, "restoreCountMap?.get(retryKey) ?: 0");     // Catch: Throwable -> L12
        int r28 = r27.intValue();     // Catch: Throwable -> L12
        if (r28 >= 20) goto L32;
        r21.put(r25, Integer.valueOf(r28 + 1));     // Catch: Throwable -> L12
        r19.add(r24);     // Catch: Throwable -> L12
    L34:
        if (r23.size() <= 1) goto L23;
        r20.addAll(b0.U(r23, 1));     // Catch: Throwable -> L12
        goto L23
    L32:
        r20.add(r24);     // Catch: Throwable -> L12
    L28:
        r27 = 0;     // Catch: Throwable -> L12
        goto L29
    L36:
        f11376b = r21;     // Catch: Throwable -> L12
        ArrayList r29 = new ArrayList(kotlin.collections.u.r(r20, 10));     // Catch: Throwable -> L12
        Iterator r30 = r20.iterator();     // Catch: Throwable -> L12
    L38:
        if (r30.hasNext() == false) goto L40;
        r29.add(Long.valueOf(((cb.u) r30.next()).d()));     // Catch: Throwable -> L12
        goto L38
    L40:
        a().g(r29);     // Catch: Throwable -> L12
        LinkedHashMap r31 = new LinkedHashMap();     // Catch: Throwable -> L12
        Iterator r32 = r19.iterator();     // Catch: Throwable -> L12
    L42:
        if (r32.hasNext() == false) goto L47;
        Object r33 = r32.next();     // Catch: Throwable -> L12
        m r34 = ((cb.u) r33).a();     // Catch: Throwable -> L12
        Object r35 = r31.get(r34);     // Catch: Throwable -> L12
        if (r35 != null) goto L46;
        r35 = new ArrayList();     // Catch: Throwable -> L12
        r31.put(r34, r35);     // Catch: Throwable -> L12
    L46:
        ((List) r35).add(r33);     // Catch: Throwable -> L12
        goto L42
    L47:
        Iterator r36 = r31.entrySet().iterator();     // Catch: Throwable -> L12
    L49:
        if (r36.hasNext() == false) goto L57;
        Map.Entry r37 = (Map.Entry) r36.next();     // Catch: Throwable -> L12
        m r38 = (m) r37.getKey();     // Catch: Throwable -> L12
        List r39 = (List) r37.getValue();     // Catch: Throwable -> L12
        int r40 = r38.ordinal();     // Catch: Throwable -> L12
        if (r40 != 0) goto L52;
        f11375a.g(r39);     // Catch: Throwable -> L12
        goto L49
    L52:
        if (r40 != 1) goto L49;
        f11375a.d(r39);     // Catch: Throwable -> L12
        goto L49
    L57:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void g(List r10) {
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        cb.u r14 = (cb.u) r13.next();
        r11.add(AppEntity.CREATOR.fromJsonKeepTimeStamp(r14.b()));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logger.INSTANCE.e("EntityHistoryManager", "handleBulkIndex parseAppEntityError", e);
        r12.add(Long.valueOf(r14.d()));
        goto L4
    L10:
        a().g(r12);
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkIndex " + q.b(q.a(r11)));
        EntityProvider.bulkIndexInner$capabilitykit_release$default(EntityProvider.INSTANCE, r11, null, 2, null);
    }
}
