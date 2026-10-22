package androidx.camera.camera2.pipe.internal;

import Ua.C1058h;
import Y8.t;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import z.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\f\b\u0001\u0018\u0000 (2\u00020\u0001:\u0002)\u0018B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010!\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010$\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001f¨\u0006*"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "", "Lkotlinx/coroutines/g;", "cameraPipeJob", "<init>", "(Lkotlinx/coroutines/g;)V", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime$ShutdownType;", "shutdownType", "Ljava/lang/Runnable;", "shutdownAction", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime$ShutdownType;Ljava/lang/Runnable;)V", "f", "()V", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Runnable;)Z", "c", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Lkotlinx/coroutines/g;", "Ljava/lang/Object;", "cameraLock", "Z", "isCameraShutdown", "", "Ljava/util/List;", "cameraShutdownActions", "scopeLock", "isScopeShutdown", "scopeShutdownActions", "threadLock", "isThreadShutdown", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "threadShutdownActions", "k", "ShutdownType", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraPipeLifetime {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g cameraPipeJob;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object cameraLock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isCameraShutdown;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<Runnable> cameraShutdownActions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object scopeLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isScopeShutdown;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List<Runnable> scopeShutdownActions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Object threadLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean isThreadShutdown;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final List<Runnable> threadShutdownActions;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime$ShutdownType;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "SCOPE", "THREAD", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShutdownType {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ShutdownType[] $VALUES;
        public static final ShutdownType CAMERA = new ShutdownType("CAMERA", 0);
        public static final ShutdownType SCOPE = new ShutdownType("SCOPE", 1);
        public static final ShutdownType THREAD = new ShutdownType("THREAD", 2);

        private static final /* synthetic */ ShutdownType[] $values() {
            return new ShutdownType[]{CAMERA, SCOPE, THREAD};
        }

        static {
            ShutdownType[] shutdownTypeArr$values = $values();
            $VALUES = shutdownTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(shutdownTypeArr$values);
        }

        private ShutdownType(String str, int i10) {
        }

        public static InterfaceC4149a<ShutdownType> getEntries() {
            return $ENTRIES;
        }

        public static ShutdownType valueOf(String str) {
            return (ShutdownType) Enum.valueOf(ShutdownType.class, str);
        }

        public static ShutdownType[] values() {
            return (ShutdownType[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10963a;

        static {
            int[] iArr = new int[ShutdownType.values().length];
            try {
                iArr[ShutdownType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShutdownType.SCOPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShutdownType.THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10963a = iArr;
        }
    }

    public CameraPipeLifetime(g cameraPipeJob) {
        p.i(cameraPipeJob, "cameraPipeJob");
        this.cameraPipeJob = cameraPipeJob;
        this.cameraLock = new Object();
        this.cameraShutdownActions = new ArrayList();
        this.scopeLock = new Object();
        this.scopeShutdownActions = new ArrayList();
        this.threadLock = new Object();
        this.threadShutdownActions = new ArrayList();
    }

    public final boolean b(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.cameraLock) {
            zAdd = this.isCameraShutdown ? false : this.cameraShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    public final boolean c(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.scopeLock) {
            zAdd = this.isScopeShutdown ? false : this.scopeShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    public final void d(ShutdownType shutdownType, Runnable shutdownAction) {
        boolean zB;
        p.i(shutdownType, "shutdownType");
        p.i(shutdownAction, "shutdownAction");
        int i10 = b.f10963a[shutdownType.ordinal()];
        if (i10 == 1) {
            zB = b(shutdownAction);
        } else if (i10 == 2) {
            zB = c(shutdownAction);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            zB = e(shutdownAction);
        }
        if (zB) {
            return;
        }
        if (k.f44508a.b()) {
            Log.e("CXCP", "CameraPipeLifetime already shut down. This is unexpected. Executing " + shutdownType + " shutdown action immediately...");
        }
        shutdownAction.run();
    }

    public final boolean e(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.threadLock) {
            zAdd = this.isThreadShutdown ? false : this.threadShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    public final void f() {
        g();
        h();
        i();
    }

    public final void g() {
        synchronized (this.cameraLock) {
            try {
                if (k.f44508a.a()) {
                    Log.d("CXCP", "Shutting down cameras...");
                }
                Iterator<Runnable> it = this.cameraShutdownActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final t h() {
        t tVar;
        synchronized (this.scopeLock) {
            try {
                if (k.f44508a.a()) {
                    Log.d("CXCP", "Shutting down scopes...");
                }
                Iterator<Runnable> it = this.scopeShutdownActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                tVar = (t) C1058h.b(null, new CameraPipeLifetime$shutdownScope$1$2(this, null), 1, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public final void i() {
        synchronized (this.threadLock) {
            try {
                if (k.f44508a.a()) {
                    Log.d("CXCP", "Shutting down threads...");
                }
                Iterator<Runnable> it = this.threadShutdownActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
