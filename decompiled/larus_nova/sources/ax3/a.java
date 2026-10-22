package ax3;

import com.bytedance.applog.n;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<n> f16630a;

    public a() {
        this.f16630a = new CopyOnWriteArraySet();
    }

    public final void a(String r100, String r101) {
        Iterator<n> r102 = this.f16630a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    }
}
