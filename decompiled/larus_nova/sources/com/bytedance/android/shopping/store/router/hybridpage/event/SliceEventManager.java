package com.bytedance.android.shopping.store.router.hybridpage.event;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class SliceEventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantReadWriteLock f185870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f185871b = null;

    static {
        f185870a = new ReentrantReadWriteLock();
        f185871b = LazyKt.lazy(SliceEventManager$dListeners$2.INSTANCE);
    }

    public static void a(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "block");
        ReentrantReadWriteLock.ReadLock r102 = f185870a.readLock();
        r102.lock();
        Set r103 = (Set) ((Map) f185871b.getValue()).get(r100);     // Catch: Throwable -> L13
        if (r103 == null) goto L7;
        List r104 = CollectionsKt.toList(r103);     // Catch: Throwable -> L13
        if (r104 == null) goto L7;
    L8:
        r102.unlock();
        Iterator r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r101.invoke((b) r105.next());
        goto L10
    L12:
        return;
    L7:
        r104 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public static void b(String r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        a(r100, new SliceEventManager$onBindSliceDataSource$1(r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ECHybridListDTO c(String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "hybridListId");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        a(r100, new SliceEventManager$onGetHybridListDTO$1(r102, r101));
        return (ECHybridListDTO) r102.element;
    }
}
