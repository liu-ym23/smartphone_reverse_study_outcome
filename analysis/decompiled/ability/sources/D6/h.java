package D6;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.View;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final View f384a;
    public final S7.a b;
    public boolean c;
    public long d;
    public boolean e;
    public final b f;

    public h(View view, S7.a aVar) {
        this.f384a = view;
        this.b = aVar;
        Context context = view.getContext();
        kotlin.jvm.internal.k.e(context, "getContext(...)");
        this.c = (context.getResources().getConfiguration().uiMode & 48) == 32;
        this.f = new b(this, 1);
    }

    public final void a(Configuration configuration) {
        boolean z10 = (configuration.uiMode & 48) == 32;
        if (z10 == this.c) {
            return;
        }
        this.c = z10;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j5 = jUptimeMillis - this.d;
        if (j5 >= 300) {
            this.d = jUptimeMillis;
            this.b.invoke();
        } else {
            if (this.e) {
                return;
            }
            this.e = true;
            this.f384a.postDelayed(this.f, 300 - j5);
        }
    }
}
