package androidx.camera.camera2.pipe.compat;

import Ua.CoroutineName;
import Ua.L0;
import Ua.M;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.a;
import androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl;
import androidx.camera.camera2.pipe.compat.j;
import androidx.camera.camera2.pipe.core.MutexesKt;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import z.C6047e;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010!R.\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010#\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0019R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AudioRestrictionControllerImpl;", "Landroidx/camera/camera2/pipe/compat/j;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeLifetime", "Lkotlinx/coroutines/g;", "cameraPipeJob", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlinx/coroutines/g;)V", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph;)V", "Landroidx/camera/camera2/pipe/compat/j$a;", "listener", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/j$a;)V", "c", "Landroidx/camera/camera2/pipe/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/camera/camera2/pipe/a;", "previousMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/a;)V", "LUa/M;", "LUa/M;", "scope", "Lz/e;", "Lz/e;", "coroutineMutex", "", "Ljava/lang/Object;", "lock", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/pipe/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setGlobalAudioRestrictionMode-3NUV5dA", "globalAudioRestrictionMode", "", "e", "Ljava/util/Map;", "audioRestrictionModeMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "activeListeners", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AudioRestrictionControllerImpl implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C6047e coroutineMutex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public androidx.camera.camera2.pipe.a globalAudioRestrictionMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<CameraGraph, androidx.camera.camera2.pipe.a> audioRestrictionModeMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<j.a> activeListeners;

    public AudioRestrictionControllerImpl(Threads threads, CameraPipeLifetime cameraPipeLifetime, kotlinx.coroutines.g cameraPipeJob) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraPipeLifetime, "cameraPipeLifetime");
        kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
        this.scope = kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-AudioRestrictionControllerImpl"))));
        this.coroutineMutex = new C6047e();
        this.lock = new Object();
        this.audioRestrictionModeMap = new LinkedHashMap();
        this.activeListeners = new CopyOnWriteArrayList<>();
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: x.w
            @Override // java.lang.Runnable
            public final void run() {
                AudioRestrictionControllerImpl.e(this.f43449a);
            }
        });
    }

    public static final void e(AudioRestrictionControllerImpl audioRestrictionControllerImpl) {
        kotlinx.coroutines.d.e(audioRestrictionControllerImpl.scope, null, 1, null);
    }

    @Override // androidx.camera.camera2.pipe.compat.j
    public void a(j.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        synchronized (this.lock) {
            try {
                this.activeListeners.add(listener);
                androidx.camera.camera2.pipe.a aVarG = g();
                if (aVarG != null) {
                    MutexesKt.e(this.coroutineMutex, this.scope, new AudioRestrictionControllerImpl$addListener$1$1(listener, aVarG, null));
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.j
    public void b(CameraGraph cameraGraph) {
        kotlin.jvm.internal.p.i(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            androidx.camera.camera2.pipe.a aVarG = g();
            this.audioRestrictionModeMap.remove(cameraGraph);
            i(aVarG);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.j
    public void c(j.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.activeListeners.remove(listener);
    }

    public final androidx.camera.camera2.pipe.a g() {
        Map<CameraGraph, androidx.camera.camera2.pipe.a> map = this.audioRestrictionModeMap;
        a.Companion companion = androidx.camera.camera2.pipe.a.INSTANCE;
        if (!map.containsValue(androidx.camera.camera2.pipe.a.d(companion.c()))) {
            androidx.camera.camera2.pipe.a aVarH = h();
            if (!(aVarH == null ? false : androidx.camera.camera2.pipe.a.g(aVarH.getValue(), companion.c()))) {
                if (!this.audioRestrictionModeMap.containsValue(androidx.camera.camera2.pipe.a.d(companion.b()))) {
                    androidx.camera.camera2.pipe.a aVarH2 = h();
                    if (!(aVarH2 == null ? false : androidx.camera.camera2.pipe.a.g(aVarH2.getValue(), companion.b()))) {
                        if (!this.audioRestrictionModeMap.containsValue(androidx.camera.camera2.pipe.a.d(companion.a()))) {
                            androidx.camera.camera2.pipe.a aVarH3 = h();
                            if (!(aVarH3 != null ? androidx.camera.camera2.pipe.a.g(aVarH3.getValue(), companion.a()) : false)) {
                                return null;
                            }
                        }
                        return androidx.camera.camera2.pipe.a.d(companion.a());
                    }
                }
                return androidx.camera.camera2.pipe.a.d(companion.b());
            }
        }
        return androidx.camera.camera2.pipe.a.d(companion.c());
    }

    public androidx.camera.camera2.pipe.a h() {
        androidx.camera.camera2.pipe.a aVar;
        synchronized (this.lock) {
            aVar = this.globalAudioRestrictionMode;
        }
        return aVar;
    }

    public final void i(androidx.camera.camera2.pipe.a previousMode) {
        androidx.camera.camera2.pipe.a aVarG = g();
        if (aVarG == null || kotlin.jvm.internal.p.d(aVarG, previousMode)) {
            return;
        }
        MutexesKt.e(this.coroutineMutex, this.scope, new AudioRestrictionControllerImpl$updateListenersMode$1(this, aVarG, null));
    }
}
