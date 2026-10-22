package androidx.camera.camera2.pipe.core;

import Oa.b;
import Ua.C1060i;
import Ua.M;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import z.z;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001a¨\u0006)"}, d2 = {"Landroidx/camera/camera2/pipe/core/WakeLock;", "", "LUa/M;", "scope", "", "timeout", "", "startTimeoutOnCreation", "Lkotlin/Function0;", "LY8/t;", "callback", "<init>", "(LUa/M;JZLp9/a;)V", "Lz/z;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lz/z;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "k", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_PKGNAME, "J", "c", "Z", Const.INTENT_KEY_UMID, "Lp9/a;", "e", "Ljava/lang/Object;", "lock", "", "f", "I", "count", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lkotlinx/coroutines/g;", "timeoutJob", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WakeLock {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long timeout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean startTimeoutOnCreation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<t> callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int count;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public g timeoutJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/camera/camera2/pipe/core/WakeLock$a;", "Lz/z;", "<init>", "(Landroidx/camera/camera2/pipe/core/WakeLock;)V", "", "release", "()Z", "LOa/a;", Const.INTENT_KEY_APIKEY, "LOa/a;", "_released", "released", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class a implements z {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Oa.a _released = b.a(false);

        public a() {
        }

        @Override // z.z
        public boolean a() {
            return this._released.b();
        }

        @Override // z.z
        public boolean release() {
            if (!this._released.a(false, true)) {
                return false;
            }
            WakeLock.this.j();
            return true;
        }
    }

    public WakeLock(M scope, long j10, boolean z10, InterfaceC5063a<t> callback) {
        p.i(scope, "scope");
        p.i(callback, "callback");
        this.scope = scope;
        this.timeout = j10;
        this.startTimeoutOnCreation = z10;
        this.callback = callback;
        Object obj = new Object();
        this.lock = obj;
        if (z10) {
            synchronized (obj) {
                k();
                t tVar = t.f7040a;
            }
        }
    }

    public final z h() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return null;
                }
                int i10 = this.count + 1;
                this.count = i10;
                if (i10 == 1) {
                    g gVar = this.timeoutJob;
                    if (gVar != null) {
                        g.Y0(gVar, null, 1, null);
                    }
                    this.timeoutJob = null;
                }
                t tVar = t.f7040a;
                return new a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                g gVar = this.timeoutJob;
                if (gVar != null) {
                    g.Y0(gVar, null, 1, null);
                }
                this.timeoutJob = null;
                t tVar = t.f7040a;
                C1060i.d(this.scope, null, null, new WakeLock$release$2(this, null), 3, null);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        synchronized (this.lock) {
            try {
                int i10 = this.count - 1;
                this.count = i10;
                if (i10 == 0 && !this.closed) {
                    k();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        this.timeoutJob = C1060i.d(this.scope, null, null, new WakeLock$startTimeout$1(this, null), 3, null);
    }
}
