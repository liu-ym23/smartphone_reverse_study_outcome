package androidx.window.layout;

import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import com.bytedance.apm.constant.CommonKey;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements WindowBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f5298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f5299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f5300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f5301d;

    public static final class a implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f5302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f5303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i f5304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set f5305d;

        public a(Activity r10) {
            q.g(r10, "activity");
            this.f5302a = r10;
            this.f5303b = new ReentrantLock();
            this.f5305d = new LinkedHashSet();
        }

        public void a(WindowLayoutInfo r10) {
            q.g(r10, CommonKey.KEY_VALUE);
            ReentrantLock r11 = this.f5303b;
            r11.lock();
            this.f5304c = d.f5306a.b(this.f5302a, r10);     // Catch: Throwable -> L7
            Iterator r12 = this.f5305d.iterator();     // Catch: Throwable -> L7
        L5:
            if (r12.hasNext() == false) goto L9;
            ((androidx.core.util.Consumer) r12.next()).accept(this.f5304c);     // Catch: Throwable -> L7
            goto L5
        L9:
            Unit r13 = Unit.f21064a;     // Catch: Throwable -> L7
            r11.unlock();
            return;
        L7:
            th = move-exception;
            r11.unlock();
            throw th;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object r10) {
            a((WindowLayoutInfo) r10);
        }

        public final void b(androidx.core.util.Consumer r10) {
            q.g(r10, "listener");
            ReentrantLock r11 = this.f5303b;
            r11.lock();
            i r12 = this.f5304c;     // Catch: Throwable -> L10
            if (r12 == null) goto L7;
            r10.accept(r12);     // Catch: Throwable -> L10
        L7:
            this.f5305d.add(r10);     // Catch: Throwable -> L10
            r11.unlock();
            return;
        L10:
            th = move-exception;
            r11.unlock();
            throw th;
        }

        public final boolean c() {
            return this.f5305d.isEmpty();
        }

        public final void d(androidx.core.util.Consumer r10) {
            q.g(r10, "listener");
            ReentrantLock r11 = this.f5303b;
            r11.lock();
            this.f5305d.remove(r10);     // Catch: Throwable -> L6
            r11.unlock();
            return;
        L6:
            th = move-exception;
            r11.unlock();
            throw th;
        }
    }

    public c(WindowLayoutComponent r10) {
        q.g(r10, "component");
        this.f5298a = r10;
        this.f5299b = new ReentrantLock();
        this.f5300c = new LinkedHashMap();
        this.f5301d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r10, Executor r11, androidx.core.util.Consumer r12) {
        q.g(r10, "activity");
        q.g(r11, "executor");
        q.g(r12, "callback");
        ReentrantLock r13 = this.f5299b;
        r13.lock();
        a r14 = (a) this.f5300c.get(r10);     // Catch: Throwable -> L9
        if (r14 != null) goto L6;
        Unit r15 = null;
    L7:
        if (r15 != null) goto L11;
        a r16 = new a(r10);     // Catch: Throwable -> L9
        this.f5300c.put(r10, r16);     // Catch: Throwable -> L9
        this.f5301d.put(r12, r10);     // Catch: Throwable -> L9
        r16.b(r12);     // Catch: Throwable -> L9
        this.f5298a.addWindowLayoutInfoListener(r10, r16);     // Catch: Throwable -> L9
    L11:
        Unit r17 = Unit.f21064a;     // Catch: Throwable -> L9
        r13.unlock();
        return;
    L6:
        r14.b(r12);     // Catch: Throwable -> L9
        this.f5301d.put(r12, r10);     // Catch: Throwable -> L9
        r15 = Unit.f21064a;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r13.unlock();
        throw th;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(androidx.core.util.Consumer r10) {
        q.g(r10, "callback");
        ReentrantLock r11 = this.f5299b;
        r11.lock();
        Activity r12 = (Activity) this.f5301d.get(r10);     // Catch: Throwable -> L14
        if (r12 != null) goto L7;
        r11.unlock();
        return;
    L7:
        a r13 = (a) this.f5300c.get(r12);     // Catch: Throwable -> L14
        if (r13 != null) goto L11;
        r11.unlock();
        return;
    L11:
        r13.d(r10);     // Catch: Throwable -> L14
        if (r13.c() == false) goto L16;
        this.f5298a.removeWindowLayoutInfoListener(r13);     // Catch: Throwable -> L14
    L16:
        Unit r14 = Unit.f21064a;     // Catch: Throwable -> L14
        r11.unlock();
        return;
    L14:
        th = move-exception;
        r11.unlock();
        throw th;
    }
}
