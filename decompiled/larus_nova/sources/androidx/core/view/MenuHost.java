package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(MenuProvider r100);

    void addMenuProvider(MenuProvider r100, LifecycleOwner r101);

    void addMenuProvider(MenuProvider r100, LifecycleOwner r101, Lifecycle.State r102);

    void invalidateMenu();

    void removeMenuProvider(MenuProvider r100);
}
