package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ xb.l f709a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ xb.l f710b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ xb.a f711c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ xb.a f712d;

    public final void onBackCancelled() {
        this.f712d.invoke();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f711c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        backEvent.getClass();
        this.f710b.invoke(new c(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        backEvent.getClass();
        this.f709a.invoke(new c(backEvent));
    }
}
