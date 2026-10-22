package Y;

import android.app.Activity;
import android.os.Bundle;
import com.stepos.ability.task.executor.e;

/* loaded from: classes2.dex */
public final class c implements B.c {
    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // B.c
    public final void f(Activity activity) {
        e.e = true;
        e.g = false;
        e.h = activity.getComponentName().toShortString();
    }

    @Override // B.c
    public final void g(Bundle bundle) {
        e.f = bundle != null;
        e.g = true;
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
        e.i = activity.getComponentName().toShortString();
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
    }
}
