package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class DeferrableSurfaces {
    public static /* synthetic */ void a(ListenableFuture r100) {
        lambda$surfaceListWithTimeout$0(r100);
    }

    public static /* synthetic */ Object b(ListenableFuture r100, Executor r101, boolean r102, Collection r103, CallbackToFutureAdapter.Completer r104) {
        return lambda$surfaceListWithTimeout$1(r100, r101, r102, r103, r104);
    }

    private DeferrableSurfaces() {
    }

    public static void decrementAll(List<DeferrableSurface> r100) {
        Iterator<DeferrableSurface> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().decrementUseCount();
        goto L4
    }

    public static void incrementAll(List<DeferrableSurface> r100) throws DeferrableSurface.SurfaceClosedException {
        if (r100.isEmpty() == true) goto L13;
        int r101 = 0;
    L14:
        ((DeferrableSurface) ListProtector.get(r100, r101)).incrementUseCount();     // Catch: DeferrableSurface.SurfaceClosedException -> L8
        r101 = r101 + 1;     // Catch: DeferrableSurface.SurfaceClosedException -> L8
        if (r101 < r100.size()) goto L14;
        return;
    L8:
        e = move-exception;
        int r102 = r101 - 1;
    L10:
        if (r102 < 0) goto L12;
        ((DeferrableSurface) ListProtector.get(r100, r102)).decrementUseCount();
        r102 = r102 - 1;
        goto L10
    L12:
        throw e;
    }

    private static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture r100) {
        r100.cancel(true);
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> r100) {
        incrementAll(r100);     // Catch: DeferrableSurface.SurfaceClosedException -> L5
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ Object lambda$surfaceListWithTimeout$1(final ListenableFuture r100, Executor r101, final boolean r102, Collection r103, final CallbackToFutureAdapter.Completer r104) throws Exception {
        r104.addCancellationListener(new n(r100), r101);
        Futures.addCallback(r100, new AnonymousClass1(r102, r104), r101);
        return "surfaceList[" + r103 + "]";
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(final Collection<DeferrableSurface> r100, final boolean r101, long r102, final Executor r103, ScheduledExecutorService r104) {
        ArrayList r105 = new ArrayList();
        Iterator<DeferrableSurface> r106 = r100.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r105.add(Futures.nonCancellationPropagating(r106.next().getSurface()));
        goto L4
    L6:
        final ListenableFuture r107 = Futures.makeTimeoutFuture(r102, r104, Futures.successfulAsList(r105));
        return CallbackToFutureAdapter.getFuture(new m(r107, r103, r101, r100));
    }
}
