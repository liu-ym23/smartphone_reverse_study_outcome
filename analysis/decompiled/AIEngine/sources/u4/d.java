package u4;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final a f13150a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.b f13151b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13152c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public OnBackInvokedCallback f13153a;

        public OnBackInvokedCallback a(final u4.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: u4.c
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    bVar.f();
                }
            };
        }

        public void b(u4.b bVar, View view, boolean z) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f13153a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackA = a(bVar);
                this.f13153a = onBackInvokedCallbackA;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? 1000000 : 0, onBackInvokedCallbackA);
            }
        }

        public void c(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f13153a == null || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f13153a);
            this.f13153a = null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u4.b f13154a;

            public a(u4.b bVar) {
                this.f13154a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackCancelled() {
                if (b.this.f13153a != null) {
                    this.f13154a.c();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                this.f13154a.f();
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackProgressed(BackEvent backEvent) {
                if (b.this.f13153a != null) {
                    this.f13154a.e(new b.a(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackStarted(BackEvent backEvent) {
                if (b.this.f13153a != null) {
                    this.f13154a.a(new b.a(backEvent));
                }
            }
        }

        @Override // u4.d.a
        public final OnBackInvokedCallback a(u4.b bVar) {
            return new a(bVar);
        }
    }

    public d(u4.b bVar, View view) {
        int i10 = Build.VERSION.SDK_INT;
        this.f13150a = i10 >= 34 ? new b() : i10 >= 33 ? new a() : null;
        this.f13151b = bVar;
        this.f13152c = view;
    }
}
