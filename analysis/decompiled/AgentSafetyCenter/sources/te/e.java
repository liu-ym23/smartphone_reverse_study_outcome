package te;

import android.content.Context;
import android.view.MenuItem;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class e extends f {

    /* renamed from: b, reason: collision with root package name */
    public final Context f13334b;

    /* renamed from: c, reason: collision with root package name */
    public p.e f13335c;

    public e(Context context, Object obj) {
        super(obj);
        this.f13334b = context;
    }

    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof h3.b)) {
            return menuItem;
        }
        h3.b bVar = (h3.b) menuItem;
        if (this.f13335c == null) {
            this.f13335c = new p.e(0);
        }
        MenuItem menuItem2 = (MenuItem) this.f13335c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        r rVar = new r(this.f13334b, bVar);
        this.f13335c.put(bVar, rVar);
        return rVar;
    }
}
