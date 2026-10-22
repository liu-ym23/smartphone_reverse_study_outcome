package androidx.camera.lifecycle;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class LifecycleCameraRepository {
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners;
    CameraCoordinator mCameraCoordinator;
    private final Map<Key, LifecycleCamera> mCameraMap;
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap;
    private final Object mLock;

    public static abstract class Key {
        public Key() {
        }

        public abstract CameraUseCaseAdapter.CameraId getCameraId();

        public abstract LifecycleOwner getLifecycleOwner();

        public static Key create(LifecycleOwner r100, CameraUseCaseAdapter.CameraId r101) {
            return new AutoValue_LifecycleCameraRepository_Key(r100, r101);
        }
    }

    public static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner r100) {
            this.mLifecycleCameraRepository.unregisterLifecycle(r100);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner r100) {
            this.mLifecycleCameraRepository.setActive(r100);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner r100) {
            this.mLifecycleCameraRepository.setInactive(r100);
        }

        public LifecycleCameraRepositoryObserver(LifecycleOwner r100, LifecycleCameraRepository r101) {
            this.mLifecycleOwner = r100;
            this.mLifecycleCameraRepository = r101;
        }
    }

    public void clear() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Iterator r101 = new HashSet(this.mLifecycleObserverMap.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        unregisterLifecycle(((LifecycleCameraRepositoryObserver) r101.next()).getLifecycleOwner());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public Collection<LifecycleCamera> getLifecycleCameras() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Collection<LifecycleCamera> r101 = Collections.unmodifiableCollection(this.mCameraMap.values());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void unbindAll() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Iterator<Key> r101 = this.mCameraMap.keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        Key r102 = r101.next();     // Catch: Throwable -> L10
        LifecycleCamera r103 = this.mCameraMap.get(r102);     // Catch: Throwable -> L10
        r103.unbindAll();     // Catch: Throwable -> L10
        setInactive(r103.getLifecycleOwner());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public LifecycleCameraRepository() {
        this.mLock = new Object();
        this.mCameraMap = new HashMap();
        this.mLifecycleObserverMap = new HashMap();
        this.mActiveLifecycleOwners = new ArrayDeque();
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Iterator<LifecycleCameraRepositoryObserver> r102 = this.mLifecycleObserverMap.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L11;
        LifecycleCameraRepositoryObserver r103 = r102.next();     // Catch: Throwable -> L14
        if (r100.equals(r103.getLifecycleOwner()) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r103;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean hasUseCaseBound(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LifecycleCameraRepositoryObserver r102 = getLifecycleCameraRepositoryObserver(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return false;
    L8:
        Iterator<Key> r103 = this.mLifecycleObserverMap.get(r102).iterator();     // Catch: Throwable -> L18
    L10:
        if (r103.hasNext() == false) goto L16;
        Key r104 = r103.next();     // Catch: Throwable -> L18
        if (((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r104))).getUseCases().isEmpty() == true) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return true;
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    private void registerCamera(LifecycleCamera r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LifecycleOwner r102 = r100.getLifecycleOwner();     // Catch: Throwable -> L13
        Key r103 = Key.create(r102, CameraUseCaseAdapter.generateCameraId((RestrictedCameraInfo) r100.getCameraInfo(), (RestrictedCameraInfo) r100.getSecondaryCameraInfo()));     // Catch: Throwable -> L13
        LifecycleCameraRepositoryObserver r104 = getLifecycleCameraRepositoryObserver(r102);     // Catch: Throwable -> L13
        if (r104 == null) goto L7;
        Set<Key> r105 = this.mLifecycleObserverMap.get(r104);     // Catch: Throwable -> L13
    L8:
        r105.add(r103);     // Catch: Throwable -> L13
        this.mCameraMap.put(r103, r100);     // Catch: Throwable -> L13
        if (r104 != null) goto L11;
        LifecycleCameraRepositoryObserver r106 = new LifecycleCameraRepositoryObserver(r102, this);     // Catch: Throwable -> L13
        this.mLifecycleObserverMap.put(r106, r105);     // Catch: Throwable -> L13
        r102.getLifecycle().addObserver(r106);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        r105 = new HashSet();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void suspendUseCases(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LifecycleCameraRepositoryObserver r102 = getLifecycleCameraRepositoryObserver(r100);     // Catch: Throwable -> L14
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L8:
        Iterator<Key> r103 = this.mLifecycleObserverMap.get(r102).iterator();     // Catch: Throwable -> L14
    L10:
        if (r103.hasNext() == false) goto L12;
        Key r104 = r103.next();     // Catch: Throwable -> L14
        ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r104))).suspend();     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void unsuspendUseCases(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LifecycleCameraRepositoryObserver r102 = getLifecycleCameraRepositoryObserver(r100);     // Catch: Throwable -> L12
        Iterator<Key> r103 = this.mLifecycleObserverMap.get(r102).iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        Key r104 = r103.next();     // Catch: Throwable -> L12
        LifecycleCamera r105 = this.mCameraMap.get(r104);     // Catch: Throwable -> L12
        if (((LifecycleCamera) Preconditions.checkNotNull(r105)).getUseCases().isEmpty() == true) goto L6;
        r105.unsuspend();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setActive(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (hasUseCaseBound(r100) == true) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L9:
        if (this.mActiveLifecycleOwners.isEmpty() == false) goto L11;
        this.mActiveLifecycleOwners.push(r100);     // Catch: Throwable -> L21
    L18:
        unsuspendUseCases(r100);     // Catch: Throwable -> L21
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L11:
        CameraCoordinator r102 = this.mCameraCoordinator;     // Catch: Throwable -> L21
        if (r102 != null) goto L14;
    L15:
        LifecycleOwner r103 = this.mActiveLifecycleOwners.peek();     // Catch: Throwable -> L21
        if (r100.equals(r103) == true) goto L18;
        suspendUseCases(r103);     // Catch: Throwable -> L21
        this.mActiveLifecycleOwners.remove(r100);     // Catch: Throwable -> L21
        this.mActiveLifecycleOwners.push(r100);     // Catch: Throwable -> L21
        goto L18
    L14:
        if (r102.getCameraOperatingMode() == 2) goto L18;
        goto L15
    }

    public void setInactive(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mActiveLifecycleOwners.remove(r100);     // Catch: Throwable -> L9
        suspendUseCases(r100);     // Catch: Throwable -> L9
        if (this.mActiveLifecycleOwners.isEmpty() == true) goto L7;
        unsuspendUseCases(this.mActiveLifecycleOwners.peek());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void unbind(Collection<UseCase> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Iterator<Key> r102 = this.mCameraMap.keySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r102.hasNext() == false) goto L16;
        Key r103 = r102.next();     // Catch: Throwable -> L18
        LifecycleCamera r104 = this.mCameraMap.get(r103);     // Catch: Throwable -> L18
        if (r104.getUseCases().isEmpty() == true) goto L10;
        boolean r105 = true;
    L11:
        r104.unbind(r100);     // Catch: Throwable -> L18
        if (r105 == false) goto L6;
        if (r104.getUseCases().isEmpty() == false) goto L6;
        setInactive(r104.getLifecycleOwner());     // Catch: Throwable -> L18
        goto L6
    L10:
        r105 = false;
        goto L11
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void unregisterLifecycle(LifecycleOwner r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LifecycleCameraRepositoryObserver r102 = getLifecycleCameraRepositoryObserver(r100);     // Catch: Throwable -> L15
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        setInactive(r100);     // Catch: Throwable -> L15
        Iterator<Key> r103 = this.mLifecycleObserverMap.get(r102).iterator();     // Catch: Throwable -> L15
    L10:
        if (r103.hasNext() == false) goto L12;
        Key r104 = r103.next();     // Catch: Throwable -> L15
        this.mCameraMap.remove(r104);     // Catch: Throwable -> L15
        goto L10
    L12:
        this.mLifecycleObserverMap.remove(r102);     // Catch: Throwable -> L15
        r102.getLifecycleOwner().getLifecycle().removeObserver(r102);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public LifecycleCamera createLifecycleCamera(LifecycleOwner r100, CameraUseCaseAdapter r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        Key r103 = Key.create(r100, r101.getCameraId());     // Catch: Throwable -> L18
        if (this.mCameraMap.get(r103) != null) goto L7;
        boolean r104 = true;
    L8:
        Preconditions.checkArgument(r104, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");     // Catch: Throwable -> L18
        LifecycleCamera r105 = new LifecycleCamera(r100, r101);     // Catch: Throwable -> L18
        if (r101.getUseCases().isEmpty() == false) goto L12;
        r105.suspend();     // Catch: Throwable -> L18
    L12:
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L15;
        monitor-exit(r102);     // Catch: Throwable -> L18
        return r105;
    L15:
        registerCamera(r105);     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
        return r105;
    L7:
        r104 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public LifecycleCamera getLifecycleCamera(LifecycleOwner r100, CameraUseCaseAdapter.CameraId r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        LifecycleCamera r103 = this.mCameraMap.get(Key.create(r100, r101));     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public void bindToLifecycleCamera(LifecycleCamera r100, ViewPort r101, List<CameraEffect> r102, Collection<UseCase> r103, CameraCoordinator r104) {
        Object r105 = this.mLock;
        monitor-enter(r105);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (r103.isEmpty() == true) goto L7;
        boolean r106 = true;
    L8:
        Preconditions.checkArgument(r106);     // Catch: Throwable -> L35
        this.mCameraCoordinator = r104;     // Catch: Throwable -> L35
        LifecycleOwner r107 = r100.getLifecycleOwner();     // Catch: Throwable -> L35
        LifecycleCameraRepositoryObserver r108 = getLifecycleCameraRepositoryObserver(r107);     // Catch: Throwable -> L35
        if (r108 != null) goto L12;
        monitor-exit(r105);     // Catch: Throwable -> L35
        return;
    L12:
        Set<Key> r109 = this.mLifecycleObserverMap.get(r108);     // Catch: Throwable -> L35
        CameraCoordinator r110 = this.mCameraCoordinator;     // Catch: Throwable -> L35
        if (r110 != null) goto L15;
    L16:
        Iterator<Key> r111 = r109.iterator();     // Catch: Throwable -> L35
    L18:
        if (r111.hasNext() == false) goto L39;
        Key r112 = r111.next();     // Catch: Throwable -> L35
        LifecycleCamera r113 = (LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(r112));     // Catch: Throwable -> L35
        if (r113.equals(r100) == true) goto L18;
        if (r113.getUseCases().isEmpty() == true) goto L18;
        throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");     // Catch: Throwable -> L35
    L39:
        r100.getCameraUseCaseAdapter().setViewPort(r101);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
        r100.getCameraUseCaseAdapter().setEffects(r102);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
        r100.bind(r103);     // Catch: CameraUseCaseAdapter.CameraException -> L32 Throwable -> L35
    L28:
        if (r107.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L30;
        setActive(r107);     // Catch: Throwable -> L35
    L30:
        monitor-exit(r105);     // Catch: Throwable -> L35
        return;
    L32:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L35
    L15:
        if (r110.getCameraOperatingMode() == 2) goto L39;
    L7:
        r106 = false;
        goto L8
    }
}
