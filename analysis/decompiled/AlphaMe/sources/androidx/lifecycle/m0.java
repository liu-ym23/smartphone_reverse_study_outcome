package androidx.lifecycle;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3966a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3967b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3968c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3969d;

    public m0(I registry, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(event, "event");
        this.f3968c = registry;
        this.f3969d = event;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3966a;
        Object obj = this.f3968c;
        Object obj2 = this.f3969d;
        switch (i4) {
            case 0:
                if (!this.f3967b) {
                    ((I) obj).e((EnumC0326x) obj2);
                    this.f3967b = true;
                    break;
                }
                break;
            default:
                Q.e eVar = ((SwipeDismissBehavior) obj2).f10394a;
                if (eVar != null && eVar.f()) {
                    ((View) obj).postOnAnimation(this);
                    break;
                }
                break;
        }
    }

    public m0(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z4) {
        this.f3969d = swipeDismissBehavior;
        this.f3968c = view;
        this.f3967b = z4;
    }
}
