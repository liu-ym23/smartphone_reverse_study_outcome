package com.obric.capabilitykit;

import android.content.Context;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityHistoryManager;", "", "()V", "ENTITY_MAX_RETRY_TIMES", "", "TAG", "", "dbHelper", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getDbHelper", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "restoreCountMap", "Ljava/util/concurrent/ConcurrentHashMap;", "clearRetryCount", "", "entityId", "entityType", "actionType", "getEntityHistoryDaoRetryKey", "entityHistoryDao", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "handleBulkDelete", "entityHistoryList", "", "handleBulkIndex", "restoreHistoryEntityProcess", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class p {
    public static final p a = null;
    private static final String b = "EntityHistoryManager";
    private static final int c = 20;
    private static ConcurrentHashMap<String, Integer> d;
    private static final Lazy e = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            m.values();
            int[] r1 = new int[2];
            m r2 = m.d;     // Catch: NoSuchFieldError -> L7
            r1[1] = 1;     // Catch: NoSuchFieldError -> L7
        L11:
            m r3 = m.c;     // Catch: NoSuchFieldError -> L8
            r1[0] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<n> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(0);
        }

        public final n a() {
            n.a r2 = n.b;
            Context r0 = AppHost.Companion.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(r0, "AppHost.application.applicationContext");
            return r2.a(r0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ n invoke() {
            return a();
        }
    }

    static {
        a = new p();
        e = LazyKt.lazy(b.a);
    }

    private p() {
    }

    private final n a() {
        return (n) e.getValue();
    }

    private final String a(o r3) {
        return b(r3.h(), r3.j(), r3.f().b());
    }

    private final void a(List<o> r5) {
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r0 = r6.next();
        Integer r1 = Integer.valueOf(((o) r0).j());
        Object r2 = r4.get(r1);
        if (r2 != null) goto L8;
        r2 = new ArrayList();
        r4.put(r1, r2);
    L8:
        ((List) r2).add(r0);
        goto L4
    L9:
        Iterator r7 = r4.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r8 = (Map.Entry) r7.next();
        int r3 = ((Number) r8.getKey()).intValue();
        List r9 = (List) r8.getValue();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r10.add(((o) r11.next()).h());
        goto L14
    L16:
        Logger.INSTANCE.i(b, "handleBulkDelete " + q.b(r10));
        EntityProvider.INSTANCE.bulkDelete(r10, r3);
        goto L11
    }

    private final String b(String r1, int r2, String r3) {
        return r1 + '_' + r2 + '_' + r3;
    }

    private final void b(List<o> r8) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L10;
        o r2 = (o) r9.next();
        r0.add(AppEntity.CREATOR.fromJsonKeepTimeStamp(r2.g()));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logger.INSTANCE.e(b, "handleBulkIndex parseAppEntityError", e);
        r1.add(Long.valueOf(r2.i()));
        goto L4
    L10:
        a().a(r1);
        Logger.INSTANCE.i(b, "handleBulkIndex " + q.b(q.a(r0)));
        EntityProvider.bulkIndexInner$capabilitykit_release$default(EntityProvider.INSTANCE, r0, null, 2, null);
    }

    public final void a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        ConcurrentHashMap<String, Integer> r0 = d;
        if (r0 == null) goto L6;
        Integer r1 = r0.remove(b(r2, r3, r4));
        return;
    }

    public final synchronized void b() {
        monitor-enter(this);
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;     // Catch: Throwable -> L57
        Context r1 = AppHost.Companion.getApplication().getApplicationContext();     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r1, "AppHost.application.applicationContext");     // Catch: Throwable -> L57
        if (r0.checkEntityProviderAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger r2 = Logger.INSTANCE;     // Catch: Throwable -> L57
        r2.i(b, "restoreHistoryEntityProcess start");     // Catch: Throwable -> L57
        List<o> r3 = a().b();     // Catch: Throwable -> L57
        if (r3.isEmpty() == false) goto L12;
        r2.i(b, "restoreHistoryEntityProcess entityHistoryList is empty");     // Catch: Throwable -> L57
        d = null;     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator<T> r5 = r3.iterator();     // Catch: Throwable -> L57
    L14:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();     // Catch: Throwable -> L57
        String r7 = ((o) r6).h();     // Catch: Throwable -> L57
        Object r8 = r4.get(r7);     // Catch: Throwable -> L57
        if (r8 != null) goto L18;
        r8 = new ArrayList();     // Catch: Throwable -> L57
        r4.put(r7, r8);     // Catch: Throwable -> L57
    L18:
        ((List) r8).add(r6);     // Catch: Throwable -> L57
        goto L14
    L19:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r11 = new ConcurrentHashMap();     // Catch: Throwable -> L57
        Iterator r12 = r4.entrySet().iterator();     // Catch: Throwable -> L57
    L21:
        if (r12.hasNext() == false) goto L34;
        List r13 = (List) ((Map.Entry) r12.next()).getValue();     // Catch: Throwable -> L57
        o r14 = (o) CollectionsKt.last(r13);     // Catch: Throwable -> L57
        String r15 = a.a(r14);     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r16 = d;     // Catch: Throwable -> L57
        if (r16 == null) goto L26;
        Integer r17 = r16.get(r15);     // Catch: Throwable -> L57
        if (r17 == null) goto L26;
    L27:
        Intrinsics.checkNotNullExpressionValue(r17, "restoreCountMap?.get(retryKey) ?: 0");     // Catch: Throwable -> L57
        int r18 = r17.intValue();     // Catch: Throwable -> L57
        if (r18 >= 20) goto L30;
        r11.put(r15, Integer.valueOf(r18 + 1));     // Catch: Throwable -> L57
        r9.add(r14);     // Catch: Throwable -> L57
    L32:
        if (r13.size() <= 1) goto L21;
        r10.addAll(CollectionsKt.dropLast(r13, 1));     // Catch: Throwable -> L57
        goto L21
    L30:
        r10.add(r14);     // Catch: Throwable -> L57
    L26:
        r17 = 0;     // Catch: Throwable -> L57
        goto L27
    L34:
        d = r11;     // Catch: Throwable -> L57
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L57
        Iterator r20 = r10.iterator();     // Catch: Throwable -> L57
    L36:
        if (r20.hasNext() == false) goto L38;
        r19.add(Long.valueOf(((o) r20.next()).i()));     // Catch: Throwable -> L57
        goto L36
    L38:
        a().a(r19);     // Catch: Throwable -> L57
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator r22 = r9.iterator();     // Catch: Throwable -> L57
    L40:
        if (r22.hasNext() == false) goto L45;
        Object r23 = r22.next();     // Catch: Throwable -> L57
        m r24 = ((o) r23).f();     // Catch: Throwable -> L57
        Object r25 = r21.get(r24);     // Catch: Throwable -> L57
        if (r25 != null) goto L44;
        r25 = new ArrayList();     // Catch: Throwable -> L57
        r21.put(r24, r25);     // Catch: Throwable -> L57
    L44:
        ((List) r25).add(r23);     // Catch: Throwable -> L57
        goto L40
    L45:
        Iterator r26 = r21.entrySet().iterator();     // Catch: Throwable -> L57
    L47:
        if (r26.hasNext() == false) goto L55;
        Map.Entry r27 = (Map.Entry) r26.next();     // Catch: Throwable -> L57
        m r28 = (m) r27.getKey();     // Catch: Throwable -> L57
        List<o> r29 = (List) r27.getValue();     // Catch: Throwable -> L57
        int r30 = r28.ordinal();     // Catch: Throwable -> L57
        if (r30 != 0) goto L50;
        a.b(r29);     // Catch: Throwable -> L57
        goto L47
    L50:
        if (r30 != 1) goto L47;
        a.a(r29);     // Catch: Throwable -> L57
        goto L47
    L55:
        monitor-exit(this);
        return;
    L57:
        th = move-exception;
        throw th;
    }
}
