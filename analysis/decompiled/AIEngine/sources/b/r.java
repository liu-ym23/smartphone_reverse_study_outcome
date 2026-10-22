package b;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import androidx.lifecycle.j0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ androidx.compose.runtime.i f3031a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.compose.runtime.g f3032b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f3033c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j0 f3034d;

    public r(androidx.compose.runtime.i iVar, androidx.compose.runtime.g gVar, q qVar, j0 j0Var) {
        this.f3031a = iVar;
        this.f3032b = gVar;
        this.f3033c = qVar;
        this.f3034d = j0Var;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        this.f3034d.invoke();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f3033c.invoke();
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        kotlin.jvm.internal.g.f(backEvent, "backEvent");
        this.f3032b.invoke(new a(backEvent));
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        kotlin.jvm.internal.g.f(backEvent, "backEvent");
        this.f3031a.invoke(new a(backEvent));
    }
}
