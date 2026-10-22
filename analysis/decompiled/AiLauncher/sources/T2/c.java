package T2;

import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import b.C1423c;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d f5850a;

    /* renamed from: b, reason: collision with root package name */
    public final T2.b f5851b;

    /* renamed from: c, reason: collision with root package name */
    public final View f5852c;

    public static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public OnBackInvokedCallback f5853a;

        public b() {
        }

        @Override // T2.c.d
        public void a(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f5853a == null || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f5853a);
            this.f5853a = null;
        }

        @Override // T2.c.d
        public void b(T2.b bVar, View view, boolean z10) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f5853a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(bVar);
                this.f5853a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z10 ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        public OnBackInvokedCallback c(final T2.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: T2.d
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    bVar.f();
                }
            };
        }

        public boolean d() {
            return this.f5853a != null;
        }
    }

    /* renamed from: T2.c$c, reason: collision with other inner class name */
    public static class C0103c extends b {

        /* renamed from: T2.c$c$a */
        public class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ T2.b f5854a;

            public a(T2.b bVar) {
                this.f5854a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (C0103c.this.d()) {
                    this.f5854a.d();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f5854a.f();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                if (C0103c.this.d()) {
                    this.f5854a.e(new C1423c(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                if (C0103c.this.d()) {
                    this.f5854a.b(new C1423c(backEvent));
                }
            }
        }

        public C0103c() {
            super();
        }

        @Override // T2.c.b
        public OnBackInvokedCallback c(T2.b bVar) {
            return new a(bVar);
        }
    }

    public interface d {
        void a(View view);

        void b(T2.b bVar, View view, boolean z10);
    }

    public <T extends View & T2.b> c(T t10) {
        this(t10, t10);
    }

    public static d a() {
        return new C0103c();
    }

    public boolean b() {
        return this.f5850a != null;
    }

    public void c() {
        d(false);
    }

    public final void d(boolean z10) {
        d dVar = this.f5850a;
        if (dVar != null) {
            dVar.b(this.f5851b, this.f5852c, z10);
        }
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.f5850a;
        if (dVar != null) {
            dVar.a(this.f5852c);
        }
    }

    public c(T2.b bVar, View view) {
        this.f5850a = a();
        this.f5851b = bVar;
        this.f5852c = view;
    }
}
