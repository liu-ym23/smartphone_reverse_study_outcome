package k;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d2.AbstractC0536a;
import java.io.Serializable;

/* renamed from: k.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0650d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13181a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13182b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f13183c;

    public AbstractC0650d() {
        this.f13181a = getClass().getSimpleName();
    }

    public abstract TrackerPayload c();

    public abstract AbstractC0536a d();

    public abstract String e(AbstractC0536a abstractC0536a);

    public abstract Intent[] f(Context context);

    public abstract String g();

    public abstract boolean h();

    public final MenuItem i(MenuItem menuItem) {
        if (!(menuItem instanceof F.b)) {
            return menuItem;
        }
        F.b bVar = (F.b) menuItem;
        if (((q.l) this.f13182b) == null) {
            this.f13182b = new q.l();
        }
        MenuItem menuItem2 = (MenuItem) ((q.l) this.f13182b).get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC0668v menuItemC0668v = new MenuItemC0668v((Context) this.f13181a, bVar);
        ((q.l) this.f13182b).put(bVar, menuItemC0668v);
        return menuItemC0668v;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AbstractC0650d(android.content.Context r8, java.lang.String r9, java.util.Map r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.AbstractC0650d.<init>(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public AbstractC0650d(Context context) {
        this.f13181a = context;
    }
}
