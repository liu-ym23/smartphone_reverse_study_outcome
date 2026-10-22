package bf0;

import com.bytedance.android.live.broadcastgame.api.xplay.g;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T> f18808a;

    public a() {
    }

    public abstract g b(Object r100);

    public final void a(T r100) {
        g r101 = b(r100);
        a<T> r102 = this.f18808a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
