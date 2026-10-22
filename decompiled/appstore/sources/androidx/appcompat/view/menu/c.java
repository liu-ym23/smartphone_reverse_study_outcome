package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleArrayMap f543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleArrayMap f544c;

    public c(Context r10) {
        this.f542a = r10;
    }

    public final MenuItem a(MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L11;
        SupportMenuItem r11 = (SupportMenuItem) r10;
        if (this.f543b != null) goto L7;
        this.f543b = new SimpleArrayMap();
    L7:
        MenuItem r12 = (MenuItem) this.f543b.get(r11);
        if (r12 != null) goto L12;
        h r13 = new h(this.f542a, r11);
        this.f543b.put(r11, r13);
        return r13;
    L12:
        return r12;
    L11:
        return r10;
    }

    public final SubMenu b(SubMenu r10) {
        if ((r10 instanceof SupportSubMenu) == false) goto L11;
        SupportSubMenu r11 = (SupportSubMenu) r10;
        if (this.f544c != null) goto L7;
        this.f544c = new SimpleArrayMap();
    L7:
        SubMenu r12 = (SubMenu) this.f544c.get(r11);
        if (r12 != null) goto L12;
        n r13 = new n(this.f542a, r11);
        this.f544c.put(r11, r13);
        return r13;
    L12:
        return r12;
    L11:
        return r10;
    }

    public final void c() {
        SimpleArrayMap r10 = this.f543b;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        SimpleArrayMap r11 = this.f544c;
        if (r11 == null) goto L9;
        r11.clear();
        return;
    }

    public final void d(int r10) {
        if (this.f543b != null) goto L5;
        return;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.f543b.size()) goto L12;
        if (((SupportMenuItem) this.f543b.keyAt(r11)).getGroupId() != r10) goto L11;
        this.f543b.removeAt(r11);
        r11 = r11 - 1;
    L11:
        r11 = r11 + 1;
        goto L7
    }

    public final void e(int r10) {
        if (this.f543b != null) goto L5;
        return;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.f543b.size()) goto L15;
        if (((SupportMenuItem) this.f543b.keyAt(r11)).getItemId() == r10) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        this.f543b.removeAt(r11);
        return;
    }
}
