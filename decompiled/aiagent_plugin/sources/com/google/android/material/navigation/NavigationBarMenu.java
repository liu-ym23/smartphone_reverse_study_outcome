package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    private final Class<?> viewClass;

    public NavigationBarMenu(Context r3, Class<?> r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.viewClass = r4;
        this.maxItemCount = r5;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int r1, int r2, int r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuItem addInternal(int r5, int r6, int r7, CharSequence r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if ((size() + 1) > this.maxItemCount) goto L9;
        stopDispatchingItemsChanged();
        MenuItem r10 = super.addInternal(r5, r6, r7, r9);
        if (ZeusTransformUtils.instanceOf(r10, MenuItemImpl.class) == false) goto L7;
        ((MenuItemImpl) ZeusTransformUtils.preCheckCast(r10, MenuItemImpl.class, "com.obric.aiagent.plugin")).setExclusiveCheckable(true);
    L7:
        startDispatchingItemsChanged();
        return r10;
    L9:
        String r11 = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + r11 + " is " + this.maxItemCount + ". Limit can be checked with " + r11 + "#getMaxItemCount()");
    }
}
