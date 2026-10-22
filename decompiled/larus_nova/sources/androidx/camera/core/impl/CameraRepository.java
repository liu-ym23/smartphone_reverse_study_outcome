package androidx.camera.core.impl;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    private final Map<String, CameraInternal> mCameras;
    private final Object mCamerasLock;
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    private ListenableFuture<Void> mDeinitFuture;
    private final Set<CameraInternal> mReleasingCameras;

    public static /* synthetic */ Object a(CameraRepository r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$deinit$0(r101);
    }

    public static /* synthetic */ void b(CameraRepository r100, CameraInternal r101) {
        r100.lambda$deinit$1(r101);
    }

    public ListenableFuture<Void> deinit() {
        Object r100 = this.mCamerasLock;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameras.isEmpty() == false) goto L11;
        ListenableFuture<Void> r101 = this.mDeinitFuture;     // Catch: Throwable -> L21
        if (r101 != null) goto L9;
        r101 = Futures.immediateFuture(null);     // Catch: Throwable -> L21
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return r101;
    L11:
        ListenableFuture<Void> r102 = this.mDeinitFuture;     // Catch: Throwable -> L21
        if (r102 != null) goto L14;
        r102 = CallbackToFutureAdapter.getFuture(new e(this));     // Catch: Throwable -> L21
        this.mDeinitFuture = r102;     // Catch: Throwable -> L21
    L14:
        this.mReleasingCameras.addAll(this.mCameras.values());     // Catch: Throwable -> L21
        Iterator<CameraInternal> r103 = this.mCameras.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r103.hasNext() == false) goto L18;
        final CameraInternal r104 = r103.next();     // Catch: Throwable -> L21
        r104.release().addListener(new f(this, r104), CameraXExecutors.directExecutor());     // Catch: Throwable -> L21
        goto L16
    L18:
        this.mCameras.clear();     // Catch: Throwable -> L21
        monitor-exit(r100);     // Catch: Throwable -> L21
        return r102;
    }

    public Set<String> getCameraIds() {
        Object r100 = this.mCamerasLock;
        monitor-enter(r100);
        LinkedHashSet r101 = new LinkedHashSet(this.mCameras.keySet());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public LinkedHashSet<CameraInternal> getCameras() {
        Object r100 = this.mCamerasLock;
        monitor-enter(r100);
        LinkedHashSet<CameraInternal> r101 = new LinkedHashSet(this.mCameras.values());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraRepository() {
        this.mCamerasLock = new Object();
        this.mCameras = new LinkedHashMap();
        this.mReleasingCameras = new HashSet();
    }

    private /* synthetic */ Object lambda$deinit$0(CallbackToFutureAdapter.Completer r100) throws Exception {
        Object r101 = this.mCamerasLock;
        monitor-enter(r101);
        this.mDeinitCompleter = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return "CameraRepository-deinit";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$deinit$1(CameraInternal r100) {
        Object r101 = this.mCamerasLock;
        monitor-enter(r101);
        this.mReleasingCameras.remove(r100);     // Catch: Throwable -> L9
        if (this.mReleasingCameras.isEmpty() == false) goto L7;
        Preconditions.checkNotNull(this.mDeinitCompleter);     // Catch: Throwable -> L9
        this.mDeinitCompleter.set(null);     // Catch: Throwable -> L9
        this.mDeinitCompleter = null;     // Catch: Throwable -> L9
        this.mDeinitFuture = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public CameraInternal getCamera(String r100) {
        Object r101 = this.mCamerasLock;
        monitor-enter(r101);
        CameraInternal r102 = this.mCameras.get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L9:
        throw new IllegalArgumentException("Invalid camera: " + r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void init(CameraFactory r100) throws InitializationException {
        Object r101 = this.mCamerasLock;
        monitor-enter(r101);
        Iterator<String> r102 = r100.getAvailableCameraIds().iterator();     // Catch: Throwable -> L11 CameraUnavailableException -> L13
    L6:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();     // Catch: Throwable -> L11 CameraUnavailableException -> L13
        Logger.d(TAG, "Added camera: " + r103);     // Catch: Throwable -> L11 CameraUnavailableException -> L13
        this.mCameras.put(r103, r100.getCamera(r103));     // Catch: Throwable -> L11 CameraUnavailableException -> L13
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L13:
        e = move-exception;
        throw new InitializationException(e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
