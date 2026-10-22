package v0;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f13294a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<l> f13295b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13296c = new HashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f13297a;

        /* renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.o f13298b;

        public a(Lifecycle lifecycle, androidx.lifecycle.o oVar) {
            this.f13297a = lifecycle;
            this.f13298b = oVar;
            lifecycle.a(oVar);
        }
    }

    public k(Runnable runnable) {
        this.f13294a = runnable;
    }

    public final void a(l lVar) {
        this.f13295b.remove(lVar);
        a aVar = (a) this.f13296c.remove(lVar);
        if (aVar != null) {
            aVar.f13297a.c(aVar.f13298b);
            aVar.f13298b = null;
        }
        this.f13294a.run();
    }
}
