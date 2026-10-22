package L;

import H.h;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes2.dex */
public final class e implements B.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f920a;

    public e(f fVar) {
        this.f920a = fVar;
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    @Override // B.c
    public final void f(Activity activity) {
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"onBackground"}));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f fVar = this.f920a;
        fVar.b = jCurrentTimeMillis;
        f.a(fVar, "foreground", "foreground_rate", fVar.f921a, fVar.b);
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"onFront"}));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f fVar = this.f920a;
        fVar.f921a = jCurrentTimeMillis;
        if (fVar.c) {
            fVar.c = false;
        } else {
            f.a(fVar, "background", "background_rate", fVar.b, jCurrentTimeMillis);
        }
    }
}
