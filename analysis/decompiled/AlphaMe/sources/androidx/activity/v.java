package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class v implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f2444a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f2445b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f2446c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f2447d;

    public v(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
        this.f2444a = function1;
        this.f2445b = function12;
        this.f2446c = function0;
        this.f2447d = function02;
    }

    public final void onBackCancelled() {
        this.f2447d.invoke();
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f2446c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.f2445b.invoke(new C0174b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        this.f2444a.invoke(new C0174b(backEvent));
    }
}
