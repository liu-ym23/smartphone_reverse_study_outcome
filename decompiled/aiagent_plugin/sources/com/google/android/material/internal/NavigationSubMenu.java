package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationSubMenu extends SubMenuBuilder {
    public NavigationSubMenu(Context r3, NavigationMenu r4, MenuItemImpl r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean r3) {
        super.onItemsChanged(r3);
        ((MenuBuilder) ZeusTransformUtils.preCheckCast(getParentMenu(), MenuBuilder.class, "com.obric.aiagent.plugin")).onItemsChanged(r3);
    }
}
