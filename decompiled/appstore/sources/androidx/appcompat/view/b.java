package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends android.view.ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActionMode f440b;

    public static class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final android.view.ActionMode.Callback f441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SimpleArrayMap f444d;

        public a(Context r10, android.view.ActionMode.Callback r11) {
            this.f442b = r10;
            this.f441a = r11;
            this.f443c = new ArrayList();
            this.f444d = new SimpleArrayMap();
        }

        public android.view.ActionMode a(ActionMode r10) {
            int r11 = this.f443c.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L10;
            b r13 = (b) this.f443c.get(r12);
            if (r13 == null) goto L9;
            if (r13.f440b != r10) goto L9;
            return r13;
        L9:
            r12 = r12 + 1;
            goto L3
        L10:
            b r14 = new b(this.f442b, r10);
            this.f443c.add(r14);
            return r14;
        }

        public final Menu b(Menu r10) {
            Menu r11 = (Menu) this.f444d.get(r10);
            if (r11 != null) goto L6;
            k r12 = new k(this.f442b, (SupportMenu) r10);
            this.f444d.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r10, MenuItem r11) {
            return this.f441a.onActionItemClicked(a(r10), new h(this.f442b, (SupportMenuItem) r11));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r10, Menu r11) {
            return this.f441a.onCreateActionMode(a(r10), b(r11));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r10) {
            this.f441a.onDestroyActionMode(a(r10));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r10, Menu r11) {
            return this.f441a.onPrepareActionMode(a(r10), b(r11));
        }
    }

    public b(Context r10, ActionMode r11) {
        this.f439a = r10;
        this.f440b = r11;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f440b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f440b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new k(this.f439a, (SupportMenu) this.f440b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f440b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f440b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f440b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f440b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f440b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f440b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f440b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View r10) {
        this.f440b.k(r10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r10) {
        this.f440b.m(r10);
    }

    @Override // android.view.ActionMode
    public void setTag(Object r10) {
        this.f440b.n(r10);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r10) {
        this.f440b.p(r10);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r10) {
        this.f440b.q(r10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r10) {
        this.f440b.l(r10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int r10) {
        this.f440b.o(r10);
    }
}
