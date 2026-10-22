package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.b.g;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SupportActionModeWrapper extends ActionMode {
    final Context mContext;
    final b mWrappedObject;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<SupportActionModeWrapper> f293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final g<Menu, Menu> f294d;

        public a(Context r3, ActionMode.Callback r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            ActionMode.Callback r6 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r4, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            this.f292b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            this.f291a = r6;
            this.f293c = new ArrayList();
            this.f294d = new g();
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            return this.f291a.onCreateActionMode(b(r3), a(r5));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            return this.f291a.onPrepareActionMode(b(r3), a(r5));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b r5, MenuItem r6) {
            MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.aiagent.plugin");
            return this.f291a.onActionItemClicked(b(r5), new MenuItemWrapperICS(this.f292b, (SupportMenuItem) ZeusTransformUtils.preCheckCast(r7, SupportMenuItem.class, "com.obric.aiagent.plugin")));
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b r2) {
            this.f291a.onDestroyActionMode(b(r2));
        }

        private Menu a(Menu r5) {
            Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
            Menu r0 = (Menu) ZeusTransformUtils.preCheckCast(this.f294d.get(r6), Menu.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L6;
            MenuWrapperICS r1 = new MenuWrapperICS(this.f292b, (SupportMenu) ZeusTransformUtils.preCheckCast(r6, SupportMenu.class, "com.obric.aiagent.plugin"));
            this.f294d.put(r6, r1);
            return r1;
        L6:
            return r0;
        }

        public ActionMode b(b r6) {
            int r0 = this.f293c.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            SupportActionModeWrapper r2 = (SupportActionModeWrapper) ZeusTransformUtils.preCheckCast(this.f293c.get(r1), SupportActionModeWrapper.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L9;
            if (r2.mWrappedObject != r6) goto L9;
            return r2;
        L9:
            r1 = r1 + 1;
            goto L3
        L10:
            SupportActionModeWrapper r3 = new SupportActionModeWrapper(this.f292b, r6);
            this.f293c.add(r3);
            return r3;
        }
    }

    public SupportActionModeWrapper(Context r3, b r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mWrappedObject = r4;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.mWrappedObject.j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object r1) {
        this.mWrappedObject.a(r1);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mWrappedObject.b(r4);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mWrappedObject.a(r4);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.mContext, (SupportMenu) ZeusTransformUtils.preCheckCast(this.mWrappedObject.b(), SupportMenu.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.mWrappedObject.f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int r1) {
        this.mWrappedObject.a(r1);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mWrappedObject.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r1) {
        this.mWrappedObject.b(r1);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.mWrappedObject.i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View r1) {
        this.mWrappedObject.a(r1);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r1) {
        this.mWrappedObject.a(r1);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.h();
    }
}
