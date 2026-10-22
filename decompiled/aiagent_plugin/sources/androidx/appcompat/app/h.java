package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.z;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: ToolbarActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class h extends ActionBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p f252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Window.Callback f253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AppCompatDelegateImpl.b f254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f256e;
    private boolean f;
    private ArrayList<ActionBar.a> g;
    private final Runnable h;
    private final Toolbar.c i;

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private final class a implements androidx.appcompat.view.menu.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f260b;

        a(h r1) {
            this.f259a = r1;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean onOpenSubMenu(MenuBuilder r2) {
            this.f259a.f253b.onMenuOpened(108, r2);
            return true;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void onCloseMenu(MenuBuilder r2, boolean r3) {
            if (this.f260b == false) goto L5;
            return;
        L5:
            this.f260b = true;
            this.f259a.f252a.o();
            this.f259a.f253b.onPanelClosed(108, r2);
            this.f260b = false;
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private final class b implements MenuBuilder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f261a;

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2) {
            MenuItem r0 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
            return false;
        }

        b(h r1) {
            this.f261a = r1;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public void onMenuModeChange(MenuBuilder r5) {
            if (this.f261a.f252a.j() == false) goto L6;
            this.f261a.f253b.onPanelClosed(108, r5);
            return;
        L6:
            if (this.f261a.f253b.onPreparePanel(0, null, r5) == false) goto L10;
            this.f261a.f253b.onMenuOpened(108, r5);
            return;
        }
    }

    /* JADX INFO: compiled from: ToolbarActionBar.java */
    private class c implements AppCompatDelegateImpl.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f262a;

        c(h r1) {
            this.f262a = r1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.b
        public boolean a(int r1) {
            if (r1 == 0) goto L4;
            return false;
        L4:
            if (this.f262a.f255d == true) goto L9;
            this.f262a.f252a.n();
            this.f262a.f255d = true;
            return false;
        L9:
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.b
        public View b(int r3) {
            if (r3 == 0) goto L4;
            return null;
        L4:
            return new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f262a.f252a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(boolean r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean r1) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d(boolean r1) {
    }

    h(Toolbar r6, CharSequence r7, Window.Callback r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        Window.Callback r10 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r8, Window.Callback.class, "com.obric.aiagent.plugin");
        this.g = new ArrayList();
        this.h = new AnonymousClass1(this);
        Toolbar.c r0 = new AnonymousClass2(this);
        this.i = r0;
        androidx.core.util.g.a(r6);
        z r2 = new z(r6, false);
        this.f252a = r2;
        this.f253b = (Window.Callback) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r10), Window.Callback.class, "com.obric.aiagent.plugin");
        r2.a(r10);
        r6.setOnMenuItemClickListener(r0);
        r2.a(r9);
        this.f254c = new c(this);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(float r1) {
        ViewCompat.a(this.f252a.a(), r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context b() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f252a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(int r1) {
        this.f252a.d(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration r1) {
        super.a(r1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f252a.a(r4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int a() {
        return this.f252a.p();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean c() {
        return this.f252a.l();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean d() {
        return this.f252a.m();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean e() {
        this.f252a.a().removeCallbacks(this.h);
        ViewCompat.a(this.f252a.a(), this.h);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        if (this.f252a.b() == false) goto L6;
        this.f252a.c();
        return true;
    L6:
        return false;
    }

    void h() {
        Menu r0 = i();
        if (ZeusTransformUtils.instanceOf(r0, MenuBuilder.class) == false) goto L5;
        MenuBuilder r1 = (MenuBuilder) ZeusTransformUtils.preCheckCast(r0, MenuBuilder.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L20;
        r1.stopDispatchingItemsChanged();
    L20:
        r0.clear();     // Catch: Throwable -> L16
        if (this.f253b.onCreatePanelMenu(0, r0) == true) goto L11;
    L12:
        r0.clear();     // Catch: Throwable -> L16
    L13:
        if (r1 == null) goto L22;
        r1.startDispatchingItemsChanged();
        return;
    L22:
        return;
    L11:
        if (this.f253b.onPreparePanel(0, null, r0) == true) goto L13;
    L16:
        th = move-exception;
        if (r1 == null) goto L19;
        r1.startDispatchingItemsChanged();
    L19:
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(KeyEvent r2) {
        if (r2.getAction() != 1) goto L5;
        c();
    L5:
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int r4, KeyEvent r5) {
        Menu r3 = i();
        if (r3 == null) goto L13;
        if (r5 == null) goto L6;
        int r1 = r5.getDeviceId();
    L7:
        boolean r2 = true;
        if (KeyCharacterMap.load(r1).getKeyboardType() != 1) goto L11;
        r2 = false;
    L11:
        r3.setQwertyMode(r2);
        return r3.performShortcut(r4, r5, 0);
    L6:
        r1 = -1;
        goto L7
    L13:
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    void g() {
        this.f252a.a().removeCallbacks(this.h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e(boolean r6) {
        if (r6 != this.f) goto L5;
        return;
    L5:
        this.f = r6;
        int r0 = this.g.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        ((ActionBar.a) ZeusTransformUtils.preCheckCast(this.g.get(r1), ActionBar.a.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L6
    }

    private Menu i() {
        if (this.f256e == true) goto L6;
        this.f252a.a(new a(this), new b(this));
        this.f256e = true;
    L6:
        return this.f252a.r();
    }
}
