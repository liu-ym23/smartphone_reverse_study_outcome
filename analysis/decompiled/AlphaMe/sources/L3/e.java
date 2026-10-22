package L3;

import android.content.Context;
import android.view.MenuItem;

/* loaded from: classes2.dex */
public abstract class e extends I.h {

    /* renamed from: c, reason: collision with root package name */
    public final Context f1272c;

    /* renamed from: d, reason: collision with root package name */
    public q.f f1273d;

    public e(Context context, Object obj) {
        super(4, obj);
        this.f1272c = context;
    }

    public final MenuItem h(MenuItem menuItem) {
        if (!(menuItem instanceof F.b)) {
            return menuItem;
        }
        F.b bVar = (F.b) menuItem;
        if (this.f1273d == null) {
            this.f1273d = new q.f(0);
        }
        MenuItem menuItem2 = (MenuItem) this.f1273d.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        s sVar = new s(this.f1272c, bVar);
        this.f1273d.put(bVar, sVar);
        return sVar;
    }
}
