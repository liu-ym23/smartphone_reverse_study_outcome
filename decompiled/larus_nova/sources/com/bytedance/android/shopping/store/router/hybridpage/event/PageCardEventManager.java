package com.bytedance.android.shopping.store.router.hybridpage.event;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
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

/* JADX INFO: loaded from: classes14.dex */
public final class PageCardEventManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantReadWriteLock f185868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f185869b = null;

    static {
        f185868a = new ReentrantReadWriteLock();
        f185869b = LazyKt.lazy(PageCardEventManager$dListeners$2.INSTANCE);
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        final String r101 = "ECShopHybridList";
        Intrinsics.checkNotNullParameter("ECShopHybridList", "hybridListId");
        a(r100, new PageCardEventManager$hybridListRequestLoadMore$1(r101));
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        final String r101 = "createSearchSlicePageViewInfo return null";
        Intrinsics.checkNotNullParameter("createSearchSlicePageViewInfo return null", "errorMsg");
        a(r100, new PageCardEventManager$sliceLoadError$1(r101));
    }

    public static void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        a(r100, PageCardEventManager$viewDisappeared$1.INSTANCE);
    }

    public static void a(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "block");
        ReentrantReadWriteLock.ReadLock r102 = f185868a.readLock();
        r102.lock();
        Set r103 = (Set) ((Map) f185869b.getValue()).get(r100);     // Catch: Throwable -> L13
        if (r103 == null) goto L7;
        List r104 = CollectionsKt.toList(r103);     // Catch: Throwable -> L13
        if (r104 == null) goto L7;
    L8:
        r102.unlock();
        Iterator r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r101.invoke((a) r105.next());
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

    public static void i(String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        a(r100, new PageCardEventManager$sliceFinishLoad$1(r101));
    }

    public static void k(String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        a(r100, new PageCardEventManager$viewAppeared$1(r101));
    }

    public static void b(String r100, final Object r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        final String r103 = "search";
        Intrinsics.checkNotNullParameter("search", "apiName");
        a(r100, new PageCardEventManager$firstScreenApiCompleted$1(r103, r101, r102));
    }

    public static void g(String r100, final String r101, final Map r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "params");
        a(r100, new PageCardEventManager$publishXEvent$1(r101, r102));
    }

    public static void h(String r100, final String r101, final String r102, final String r103) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "searchQuery");
        Intrinsics.checkNotNullParameter(r102, "searchSource");
        Intrinsics.checkNotNullParameter(r103, "suggestGroupId");
        a(r100, new PageCardEventManager$searchResultSearch$1(r101, r102, r103));
    }

    public static void d(String r100, final String r101, final int r102, final int r110, final ECHybridListItemVO r111) {
        final int r103 = 2;
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "hybridListId");
        Intrinsics.checkNotNullParameter(r111, "itemModel");
        a(r100, new PageCardEventManager$hybridListCardDisappeared$1(r101, r103, r102, r110, r111));
    }

    public static void e(String r100, final String r101, final int r102, final int r103, final ECHybridListItemVO r104) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "hybridListId");
        Intrinsics.checkNotNullParameter(r104, "itemModel");
        a(r100, new PageCardEventManager$hybridListCardSelected$1(r101, r102, r103, r104));
    }

    public static void c(String r100, final String r101, final int r110, final int r111, final ECHybridListItemVO r112, final boolean r113) {
        final int r102 = 2;
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "hybridListId");
        Intrinsics.checkNotNullParameter(r112, "itemModel");
        a(r100, new PageCardEventManager$hybridListCardAppeared$1(r101, r102, r110, r111, r112, r113));
    }
}
