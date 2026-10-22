package com.stepos.alphame.utils;

import com.stepos.alphame.utils.NavigationBarUtils;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((NavigationBarUtils.OnNavigationChangeListener) obj).onNaviChanged();
    }
}
