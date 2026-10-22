package androidx.core.view;

import android.view.MenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MenuItemCompat$1 implements MenuItem.OnActionExpandListener {
    final /* synthetic */ i.b val$listener;

    MenuItemCompat$1(i.b r3) {
        this.val$listener = (i.b) ZeusTransformUtils.wrapperContextForParams(r3, i.b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return this.val$listener.a(r4);
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        return this.val$listener.b(r4);
    }
}
