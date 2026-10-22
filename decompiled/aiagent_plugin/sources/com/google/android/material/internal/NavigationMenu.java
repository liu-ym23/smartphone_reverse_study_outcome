package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int r3, int r4, int r5, CharSequence r6) {
        MenuItemImpl r7 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(addInternal(r3, r4, r5, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin")), MenuItemImpl.class, "com.obric.aiagent.plugin");
        NavigationSubMenu r8 = new NavigationSubMenu((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, r7);
        r7.setSubMenu(r8);
        return r8;
    }
}
