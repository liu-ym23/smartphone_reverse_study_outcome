package v4;

import android.os.Handler;

/* loaded from: classes.dex */
public final class l implements s5.d {
    @Override // s5.d
    public final boolean a(c5.b bVar, d5.e eVar) {
        q7.k.e(bVar, "frame");
        q7.k.e(eVar, "source");
        return true;
    }

    @Override // s5.d
    public final Object b(c5.b bVar, d5.e eVar, g7.d dVar) {
        Handler handler = u5.g.f10127b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = 1800010 - (jCurrentTimeMillis - u5.g.f10126a);
        u5.g.f10126a = jCurrentTimeMillis;
        Handler handler2 = u5.g.f10127b;
        j1.p pVar = u5.g.f10128c;
        handler2.removeCallbacks(pVar);
        if (j2 > 0) {
            handler2.postDelayed(pVar, j2);
        } else {
            handler2.post(new j1.p(2));
        }
        return s5.b.f9498a;
    }

    @Override // s5.d
    public final String getId() {
        return "platform.keep-alive";
    }
}
