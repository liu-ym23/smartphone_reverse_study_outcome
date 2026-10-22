package androidx.camera.camera2.pipe.internal;

import Ua.InterfaceC1083u;
import Z8.C1165m;
import androidx.camera.camera2.pipe.internal.f;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import s.C5423E;
import w.H;
import w.InterfaceC5714u;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\b\u0018\u00010\u0007R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/internal/a;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "Landroidx/camera/camera2/pipe/t;", "request", "Landroidx/camera/camera2/pipe/internal/a$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/t;)Landroidx/camera/camera2/pipe/internal/a$a;", "LY8/t;", "close", "", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "lock", "LZ8/m;", Const.INTENT_KEY_PKGNAME, "LZ8/m;", "queue", "", "c", "Z", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C1165m<C0139a> queue = new C1165m<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/internal/a$a;", "", "Lw/u;", "frame", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lw/u;)V", "Lw/H;", "failureStatus", "e", "(I)V", "close", "()V", "Landroidx/camera/camera2/pipe/t;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroidx/camera/camera2/pipe/t;", "request", "LOa/a;", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "LUa/u;", "Landroidx/camera/camera2/pipe/internal/f;", "c", "LUa/u;", "result", "", "Lw/u$a;", Const.INTENT_KEY_UMID, "Ljava/util/List;", "frameListeners", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.a$a, reason: collision with other inner class name */
    public final class C0139a implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final t request;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Oa.a closed;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC1083u<f<InterfaceC5714u>> result;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public List<InterfaceC5714u.a> frameListeners;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f11015e;

        public final void b(InterfaceC5714u frame) throws Exception {
            List<InterfaceC5714u.a> list;
            p.i(frame, "frame");
            f.Companion companion = f.INSTANCE;
            if (!this.result.complete(f.b(f.c(frame)))) {
                C5423E.a(frame);
                return;
            }
            synchronized (this) {
                list = this.frameListeners;
                this.frameListeners = null;
                Y8.t tVar = Y8.t.f7040a;
            }
            if (list != null) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    frame.d1(list.get(i10));
                }
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() throws Exception {
            if (this.closed.a(false, true)) {
                e(H.INSTANCE.e());
                f.Companion companion = f.INSTANCE;
                InterfaceC1083u<f<InterfaceC5714u>> interfaceC1083u = this.result;
                Object obj = null;
                if (interfaceC1083u.g() && !interfaceC1083u.isCancelled()) {
                    Object result = interfaceC1083u.m().getResult();
                    if (f.e(result)) {
                        obj = result;
                    }
                }
                InterfaceC5714u interfaceC5714u = (InterfaceC5714u) obj;
                if (interfaceC5714u != null) {
                    C5423E.a(interfaceC5714u);
                }
                Object obj2 = this.f11015e.lock;
                a aVar = this.f11015e;
                synchronized (obj2) {
                    aVar.queue.remove(this);
                }
            }
        }

        public final void e(int failureStatus) {
            List<InterfaceC5714u.a> list;
            f.Companion companion = f.INSTANCE;
            if (this.result.complete(f.b(f.c(H.f(failureStatus))))) {
                synchronized (this) {
                    list = this.frameListeners;
                    this.frameListeners = null;
                    Y8.t tVar = Y8.t.f7040a;
                }
                if (list != null) {
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        list.get(i10).e();
                    }
                }
            }
        }

        /* renamed from: g, reason: from getter */
        public t getRequest() {
            return this.request;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Y8.t tVar = Y8.t.f7040a;
            Iterator<C0139a> it = this.queue.iterator();
            while (it.hasNext()) {
                it.next().e(H.INSTANCE.b());
            }
            this.queue.clear();
        }
    }

    public final C0139a g(t request) {
        C0139a next;
        p.i(request, "request");
        synchronized (this.lock) {
            try {
                C0139a c0139a = null;
                if (this.closed) {
                    return null;
                }
                Iterator<C0139a> it = this.queue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (p.d(next.getRequest(), request)) {
                        break;
                    }
                }
                C0139a c0139a2 = next;
                if (c0139a2 != null) {
                    this.queue.remove(c0139a2);
                    c0139a = c0139a2;
                }
                return c0139a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
