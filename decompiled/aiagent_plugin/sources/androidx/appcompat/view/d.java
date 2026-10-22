package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: StandaloneActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends b implements MenuBuilder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActionBarContextView f304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.a f305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<View> f306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f307e;
    private boolean f;
    private MenuBuilder g;

    public d(Context r3, ActionBarContextView r4, b.a r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b.a r8 = (b.a) ZeusTransformUtils.wrapperContextForParams(r5, b.a.class, "com.obric.aiagent.plugin");
        this.f303a = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f304b = r4;
        this.f305c = r8;
        MenuBuilder r9 = new MenuBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).setDefaultShowAsAction(1);
        this.g = r9;
        r9.setCallback(this);
        this.f = r6;
    }

    @Override // androidx.appcompat.view.b
    public void b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f304b.setTitle(r4);
    }

    @Override // androidx.appcompat.view.b
    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f304b.setSubtitle(r4);
    }

    @Override // androidx.appcompat.view.b
    public void a(int r2) {
        b(this.f303a.getString(r2));
    }

    @Override // androidx.appcompat.view.b
    public void b(int r2) {
        a(this.f303a.getString(r2));
    }

    @Override // androidx.appcompat.view.b
    public void a(boolean r1) {
        super.a(r1);
        this.f304b.setTitleOptional(r1);
    }

    @Override // androidx.appcompat.view.b
    public boolean h() {
        return this.f304b.isTitleOptional();
    }

    @Override // androidx.appcompat.view.b
    public void a(View r2) {
        this.f304b.setCustomView(r2);
        if (r2 == null) goto L5;
        WeakReference<View> r0 = new WeakReference(r2);
    L6:
        this.f306d = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.b
    public void d() {
        this.f305c.b(this, this.g);
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f307e == false) goto L5;
        return;
    L5:
        this.f307e = true;
        this.f305c.a(this);
    }

    @Override // androidx.appcompat.view.b
    public Menu b() {
        return this.g;
    }

    @Override // androidx.appcompat.view.b
    public CharSequence f() {
        return this.f304b.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f304b.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public View i() {
        WeakReference<View> r2 = this.f306d;
        if (r2 != null) goto L7;
        return null;
    L7:
        return (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater a() {
        return new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f304b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean onMenuItemSelected(MenuBuilder r2, MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return this.f305c.a(this, r4);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void onMenuModeChange(MenuBuilder r1) {
        d();
        this.f304b.showOverflowMenu();
    }
}
