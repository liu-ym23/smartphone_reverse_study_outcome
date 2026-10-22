package com.bytedance.android.scope;

import com.bytedance.android.scope.internal.ExperimentalApi;
import com.bytedance.android.scope.tree.NodeManager;
import com.bytedance.android.scope.tree.ScopeNode$walkInside$1;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f163446b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NodeManager f163447c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f163448d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f163449e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f33.a f163450a;

    static {
        f163449e = new m();
        f163446b = new q();
        NodeManager r100 = new NodeManager();
        f163447c = r100;
        f163448d = r100.f163458a.f163471j;
    }

    public m() {
        this.f163450a = f33.a.f475381a;
    }

    public static p b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        return new p(r100);
    }

    public static com.bytedance.android.scope.tree.d c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        NodeManager r101 = f163447c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        return (com.bytedance.android.scope.tree.d) ((ConcurrentHashMap) r101.f163459b).get(r100);
    }

    @ExperimentalApi
    public static void e(e33.f r110) {
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        q r100 = f163446b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        ReentrantReadWriteLock r101 = r100.f163454b;
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        Iterator<T> r107 = r110.getScopes().iterator();     // Catch: Throwable -> L27
    L12:
        if (r107.hasNext() == false) goto L22;
        KClass<? extends j> r108 = (KClass) r107.next();     // Catch: Throwable -> L27
        HashMap r109 = (HashMap) r100.f163453a;     // Catch: Throwable -> L27
        Object r111 = r109.get(r108);     // Catch: Throwable -> L27
        if (r111 != null) goto L16;
        r111 = new LinkedHashMap();     // Catch: Throwable -> L27
        r109.put(r108, r111);     // Catch: Throwable -> L27
    L16:
        Map r112 = (Map) r111;     // Catch: Throwable -> L27
        Iterator<T> r113 = r110.b(r108).iterator();     // Catch: Throwable -> L27
    L18:
        if (r113.hasNext() == false) goto L12;
        e33.l r114 = (e33.l) r113.next();     // Catch: Throwable -> L27
        Object r115 = r114.f470909a;     // Catch: Throwable -> L27
        if (r112.get(r115) != null) goto L18;
        r112.put(r115, r114);     // Catch: Throwable -> L27
        goto L18
    L22:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L23:
        if (r103 >= r104) goto L25;
        r102.lock();
        r103 = r103 + 1;
        goto L23
    L25:
        r106.unlock();
        return;
    L27:
        th = move-exception;
    L28:
        if (r103 >= r104) goto L30;
        r102.lock();
        r103 = r103 + 1;
        goto L28
    L30:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public static Object f(j r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.bytedance.android.scope.tree.d r102 = c(r100);
        if (r102 == null) goto L5;
        ReentrantReadWriteLock.ReadLock r103 = r102.f163461b.readLock();
        r103.lock();
        Object r104 = r101.invoke(SequencesKt.mapNotNull(CollectionsKt.asSequence(r102.f163467f.f163409d), ServiceContainer$visitServices$1.INSTANCE));     // Catch: Throwable -> L10
        r103.unlock();
        return r104;
    L10:
        th = move-exception;
        r103.unlock();
        throw th;
    L5:
        return r101.invoke(SequencesKt.emptySequence());
    }

    public final <T extends j, U extends j> U a(T r100, Class<U> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "scopeCls");
        this.f163450a.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "scopeCls");
        m r102 = f163449e;
        KClass r103 = JvmClassMappingKt.getKotlinClass(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r103, "scopeCls");
        com.bytedance.android.scope.tree.d r104 = c(r100);
        if (r104 == null) goto L20;
        ArrayDeque r105 = new ArrayDeque();
        r105.add(r104);
        Iterator r106 = SequencesKt.sequence(new ScopeNode$walkInside$1(r105, null)).iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((com.bytedance.android.scope.tree.d) r107).f163472k, r103) == false) goto L7;
    L12:
        com.bytedance.android.scope.tree.d r108 = (com.bytedance.android.scope.tree.d) r107;
        if (r108 != null) goto L15;
        return null;
    L15:
        return (U) r108.f163471j;
    L11:
        r107 = null;
        goto L12
    L20:
        return null;
    }

    public final <T extends j, S> S d(T r100, Class<S> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, NsdHelper.serviceTypeKey);
        this.f163450a.getClass();
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, NsdHelper.serviceTypeKey);
        f163449e.getClass();
        com.bytedance.android.scope.tree.d r102 = c(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        return (S) r102.b(JvmClassMappingKt.getKotlinClass(r101));
    }
}
