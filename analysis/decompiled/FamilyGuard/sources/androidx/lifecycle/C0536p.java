package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0536p {

    /* renamed from: a, reason: collision with root package name */
    public static final C0536p f10893a = new C0536p();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10894b = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.p$a */
    public static final class a extends C0529i {
        @Override // androidx.lifecycle.C0529i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            j4.k.g(activity, "activity");
            H.f10809b.b(activity);
        }
    }

    private C0536p() {
    }

    public static final void a(Context context) {
        j4.k.g(context, "context");
        if (f10894b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        j4.k.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
