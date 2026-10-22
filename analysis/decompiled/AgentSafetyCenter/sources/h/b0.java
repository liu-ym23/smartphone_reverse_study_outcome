package h;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f4750a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4751b;

    public b0() {
        this.f4751b = new int[2];
    }

    public void c() {
        a0 a0Var = (a0) this.f4750a;
        if (a0Var != null) {
            try {
                ((e0) this.f4751b).f4794l.unregisterReceiver(a0Var);
            } catch (IllegalArgumentException unused) {
            }
            this.f4750a = null;
        }
    }

    public abstract IntentFilter d();

    public abstract int[] e(int i);

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof h3.b)) {
            return menuItem;
        }
        h3.b bVar = (h3.b) menuItem;
        if (((p0) this.f4751b) == null) {
            this.f4751b = new p0(0);
        }
        MenuItem menuItem2 = (MenuItem) ((p0) this.f4751b).get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        l.s sVar = new l.s((Context) this.f4750a, bVar);
        ((p0) this.f4751b).put(bVar, sVar);
        return sVar;
    }

    public int[] h(int i, int i3) {
        if (i < 0 || i3 < 0 || i == i3) {
            return null;
        }
        int[] iArr = (int[]) this.f4751b;
        iArr[0] = i;
        iArr[1] = i3;
        return iArr;
    }

    public String i() {
        String str = (String) this.f4750a;
        if (str != null) {
            return str;
        }
        yb.k.f("text");
        throw null;
    }

    public abstract void j();

    public abstract int[] k(int i);

    public void l() {
        c();
        IntentFilter intentFilterD = d();
        if (intentFilterD.countActions() == 0) {
            return;
        }
        if (((a0) this.f4750a) == null) {
            this.f4750a = new a0(this, 0);
        }
        ((e0) this.f4751b).f4794l.registerReceiver((a0) this.f4750a, intentFilterD);
    }

    public b0(Context context) {
        this.f4750a = context;
    }

    public b0(e0 e0Var) {
        this.f4751b = e0Var;
    }
}
