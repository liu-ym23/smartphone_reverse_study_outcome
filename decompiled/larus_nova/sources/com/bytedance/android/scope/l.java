package com.bytedance.android.scope;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.scope.tree.NodeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class l {
    public static final void a(final j r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$enter");
        m.f163449e.getClass();
        Intrinsics.checkNotNullParameter(r110, "scope");
        if (m.c(r110) == null) goto L5;
        e33.c.a(new IllegalStateException("Scope " + r110 + " is already entered"));
        return;
    L5:
        final LinkedHashMap r100 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r110, "scopeInstance");
        Object r101 = null;
        if ((r110 instanceof e33.h) == true) goto L8;
        j r102 = null;
    L9:
        e33.h r103 = (e33.h) r102;
        if (r103 == null) goto L12;
        j r104 = r103.r();
    L13:
        if (r104 != null) goto L15;
        r104 = m.f163448d;
    L15:
        final com.bytedance.android.scope.tree.d r105 = m.c(r104);
        if (r105 != null) goto L18;
        e33.c.a(new IllegalStateException("Enclosing scope " + r104 + " is not entered"));
        return;
    L18:
        r100.put(r104, r105);
        if ((r110 instanceof e33.j) == false) goto L22;
        r101 = r110;
    L22:
        e33.j r106 = (e33.j) r101;
        final e33.i r107 = null;
        final KClass<? extends j> r108 = f33.b.a(r110);
        Collection r109 = r100.values();
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r112 = r109.iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        r111.add(((com.bytedance.android.scope.tree.d) r112.next()).f163461b);
        goto L24
    L26:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r111.iterator();     // Catch: Throwable -> L73
    L29:
        if (r114.hasNext() == false) goto L31;
        ReentrantReadWriteLock r115 = (ReentrantReadWriteLock) r114.next();     // Catch: Throwable -> L73
        r115.writeLock().lock();     // Catch: Throwable -> L73
        r113.add(r115);     // Catch: Throwable -> L73
        goto L29
    L31:
        Iterator r116 = r100.values().iterator();     // Catch: Throwable -> L73
    L33:
        if (r116.hasNext() == false) goto L39;
        com.bytedance.android.scope.tree.d r117 = (com.bytedance.android.scope.tree.d) r116.next();     // Catch: Throwable -> L73
        if (r117.f163460a == false) goto L33;
        throw new IllegalStateException("Enclosing scope " + r117.f163471j + " is destroyed");     // Catch: Throwable -> L73
    L39:
        com.bytedance.android.scope.tree.d r118 = new com.bytedance.android.scope.tree.d(r110, r108, r105, new ScopeManager$enterScope$$inlined$writeMultiple$lambda$1(r100, r110, r108, r105, r107));     // Catch: Throwable -> L73
        ReentrantReadWriteLock r119 = r118.f163461b;     // Catch: Throwable -> L73
        ReentrantReadWriteLock.ReadLock r120 = r119.readLock();     // Catch: Throwable -> L73
        int r121 = 0;
        if (r119.getWriteHoldCount() != 0) goto L42;
        int r122 = r119.getReadHoldCount();     // Catch: Throwable -> L73
    L43:
        int r123 = 0;
    L44:
        if (r123 >= r122) goto L46;
        r120.unlock();     // Catch: Throwable -> L73
        r123 = r123 + 1;     // Catch: Throwable -> L73
        goto L44
    L46:
        ReentrantReadWriteLock.WriteLock r124 = r119.writeLock();     // Catch: Throwable -> L73
        r124.lock();     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r118, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);     // Catch: Throwable -> L68
        r118.c(r105);     // Catch: Throwable -> L68
        r105.f163465d.add(r118);     // Catch: Throwable -> L68
        r105.f163467f.b(r118.f163471j, true);     // Catch: Throwable -> L68
        NodeManager r125 = m.f163447c;     // Catch: Throwable -> L68
        r125.getClass();     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r110, "scope");     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r118, "node");     // Catch: Throwable -> L68
        ((ConcurrentHashMap) r125.f163459b).put(r110, r118);     // Catch: Throwable -> L68
        KClass<? extends j> r126 = f33.b.a(r110);     // Catch: Throwable -> L68
        Iterator r127 = r100.values().iterator();     // Catch: Throwable -> L68
    L49:
        if (r127.hasNext() == false) goto L54;
        Collection<g> r128 = ((com.bytedance.android.scope.tree.d) r127.next()).h(r110);     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r128, "metaServices");     // Catch: Throwable -> L68
        ServiceContainer r129 = r118.f163467f;     // Catch: Throwable -> L68
        r129.getClass();     // Catch: Throwable -> L68
        Intrinsics.checkNotNullParameter(r128, "metaServices");     // Catch: Throwable -> L68
        Iterator r130 = ((ArrayList) r128).iterator();     // Catch: Throwable -> L68
    L52:
        if (r130.hasNext() == false) goto L49;
        r129.f163410e.a((g) r130.next());     // Catch: Throwable -> L68
        goto L52
    L54:
        LinkedHashMap r131 = new LinkedHashMap();     // Catch: Throwable -> L68
        m.f163449e.getClass();     // Catch: Throwable -> L68
        q r132 = m.f163446b;     // Catch: Throwable -> L68
        ReentrantReadWriteLock.ReadLock r133 = r132.f163454b.readLock();     // Catch: Throwable -> L68
        r133.lock();     // Catch: Throwable -> L68
        r131.putAll(r132.f163455c.a(r126));     // Catch: Throwable -> L65
        Unit r134 = Unit.INSTANCE;     // Catch: Throwable -> L65
        r133.unlock();     // Catch: Throwable -> L68
        r118.g(r131.values());     // Catch: Throwable -> L68
    L57:
        if (r121 >= r122) goto L59;
        r120.lock();     // Catch: Throwable -> L73
        r121 = r121 + 1;     // Catch: Throwable -> L73
        goto L57
    L59:
        r124.unlock();     // Catch: Throwable -> L73
        Unit r135 = Unit.INSTANCE;     // Catch: Throwable -> L73
        int r136 = r113.size();
    L61:
        r136 = r136 - 1;
        if (r136 < 0) goto L95;
        ((ReentrantReadWriteLock) ListProtector.get(r113, r136)).writeLock().unlock();
        goto L61
    L95:
        return;
    L65:
        th = move-exception;
        r133.unlock();     // Catch: Throwable -> L68
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
    L69:
        if (r121 >= r122) goto L71;
        r120.lock();     // Catch: Throwable -> L73
        r121 = r121 + 1;     // Catch: Throwable -> L73
        goto L69
    L71:
        r124.unlock();     // Catch: Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L42:
        r122 = 0;
    L73:
        th = move-exception;
        int r137 = r113.size();
    L75:
        r137 = r137 - 1;
        if (r137 < 0) goto L78;
        ((ReentrantReadWriteLock) ListProtector.get(r113, r137)).writeLock().unlock();
        goto L75
    L78:
        throw th;
    L12:
        r104 = null;
        goto L13
    L8:
        r102 = r110;
        goto L9
    }

    public static final boolean b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isEntered");
        m.f163449e.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        if (m.c(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$leave");
        m.f163449e.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        com.bytedance.android.scope.tree.d r101 = m.c(r100);
        if (r101 != null) goto L5;
        e33.c.a(new IllegalStateException("Scope " + r100 + " is not entered"));
        return;
    L5:
        NodeManager r102 = m.f163447c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        if (r101 != r102.f163458a) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        e33.c.a(new IllegalArgumentException("Cannot leave root scope"));
        return;
    L11:
        r101.e();
        return;
    L8:
        r103 = false;
        goto L9
    }
}
