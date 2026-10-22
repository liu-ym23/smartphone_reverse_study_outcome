package androidx.camera.core;

import D.C0761b0;
import Y8.t;
import Z8.F;
import android.content.Context;
import android.view.OrientationEventListener;
import androidx.camera.core.l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0003\r\u0019\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010(R$\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/camera/core/l;", "", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "", "ignoreCanDetectForTest", "(Landroid/content/Context;Z)V", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/camera/core/l$c;", "listener", "c", "(Ljava/util/concurrent/Executor;Landroidx/camera/core/l$c;)Z", "LY8/t;", "e", "(Landroidx/camera/core/l$c;)V", "f", "()V", "", "newRotation", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)V", "orientation", Const.INTENT_KEY_UMID, "(I)I", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "lock", "Landroid/view/OrientationEventListener;", Const.INTENT_KEY_PKGNAME, "Landroid/view/OrientationEventListener;", "orientationListener", "", "Landroidx/camera/core/l$d;", "Ljava/util/Map;", "listeners", "I", "rotation", "Z", UxipConstants.f30680s, "isShutdown", "()Z", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final OrientationEventListener orientationListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<c, d> listeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile int rotation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean ignoreCanDetectForTest;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isShutdown;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/camera/core/l$a", "Landroid/view/OrientationEventListener;", "", "orientation", "LY8/t;", "onOrientationChanged", "(I)V", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f11636a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, l lVar) {
            super(context);
            this.f11636a = lVar;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            if (orientation == -1) {
                return;
            }
            this.f11636a.g(this.f11636a.d(orientation));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/core/l$c;", "", "", "rotation", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface c {
        void a(int rotation);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/camera/core/l$d;", "", "Landroidx/camera/core/l$c;", "listener", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Landroidx/camera/core/l$c;Ljava/util/concurrent/Executor;)V", "", "rotation", "LY8/t;", "c", "(I)V", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/core/l$c;", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", x5.d.EXTRA_ENABLED, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final c listener;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Executor executor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final AtomicBoolean enabled;

        public d(c listener, Executor executor) {
            p.i(listener, "listener");
            p.i(executor, "executor");
            this.listener = listener;
            this.executor = executor;
            this.enabled = new AtomicBoolean(true);
        }

        public static final void d(d dVar, int i10) {
            if (dVar.enabled.get()) {
                dVar.listener.a(i10);
            }
        }

        public final void b() {
            this.enabled.set(false);
        }

        public final void c(final int rotation) {
            if (this.enabled.get()) {
                try {
                    this.executor.execute(new Runnable() { // from class: D.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            l.d.d(this.f2132a, rotation);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    C0761b0.o("RotationProvider", "Failed to execute the command. Maybe the executor has been shutdown.");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(Context appContext) {
        this(appContext, false);
        p.i(appContext, "appContext");
    }

    public final boolean c(Executor executor, c listener) {
        p.i(executor, "executor");
        p.i(listener, "listener");
        synchronized (this.lock) {
            if (!this.ignoreCanDetectForTest && !this.orientationListener.canDetectOrientation()) {
                return false;
            }
            d dVar = new d(listener, executor);
            this.listeners.put(listener, dVar);
            if (this.rotation != -1) {
                dVar.c(this.rotation);
            }
            if (this.listeners.size() == 1) {
                this.orientationListener.enable();
            }
            t tVar = t.f7040a;
            return true;
        }
    }

    public final int d(int orientation) {
        if (this.rotation == -1) {
            if (orientation >= 0 && orientation < 45) {
                return 0;
            }
            if (45 <= orientation && orientation < 135) {
                return 3;
            }
            if (135 > orientation || orientation >= 225) {
                return (225 > orientation || orientation >= 315) ? 0 : 1;
            }
            return 2;
        }
        if ((orientation >= 0 && orientation < 40) || (320 <= orientation && orientation < 360)) {
            return 0;
        }
        if (50 <= orientation && orientation < 130) {
            return 3;
        }
        if (140 <= orientation && orientation < 220) {
            return 2;
        }
        if (230 > orientation || orientation >= 310) {
            return this.rotation;
        }
        return 1;
    }

    public final void e(c listener) {
        p.i(listener, "listener");
        synchronized (this.lock) {
            try {
                d dVar = this.listeners.get(listener);
                if (dVar != null) {
                    dVar.b();
                    this.listeners.remove(listener);
                }
                if (this.listeners.isEmpty()) {
                    this.orientationListener.disable();
                    this.rotation = -1;
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this.lock) {
            this.orientationListener.disable();
            this.listeners.clear();
            this.isShutdown = true;
            this.rotation = -1;
            t tVar = t.f7040a;
        }
    }

    public final void g(int newRotation) {
        List listM1;
        if (this.rotation != newRotation) {
            this.rotation = newRotation;
            synchronized (this.lock) {
                listM1 = F.m1(this.listeners.values());
                t tVar = t.f7040a;
            }
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ((d) it.next()).c(newRotation);
            }
        }
    }

    public l(Context appContext, boolean z10) {
        p.i(appContext, "appContext");
        this.lock = new Object();
        this.listeners = new LinkedHashMap();
        this.rotation = -1;
        this.ignoreCanDetectForTest = z10;
        this.orientationListener = new a(appContext, this);
    }
}
