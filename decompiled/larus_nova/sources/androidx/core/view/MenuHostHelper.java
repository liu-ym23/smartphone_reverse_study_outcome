package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class MenuHostHelper {
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders;
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<MenuProvider, LifecycleContainer> mProviderToLifecycleContainers;

    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        public void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }

        public LifecycleContainer(Lifecycle r100, LifecycleEventObserver r101) {
            this.mLifecycle = r100;
            this.mObserver = r101;
            r100.addObserver(r101);
        }
    }

    public static /* synthetic */ void a(MenuHostHelper r100, Lifecycle.State r101, MenuProvider r102, LifecycleOwner r103, Lifecycle.Event r104) {
        r100.lambda$addMenuProvider$1(r101, r102, r103, r104);
    }

    public static /* synthetic */ void b(MenuHostHelper r100, MenuProvider r101, LifecycleOwner r102, Lifecycle.Event r103) {
        r100.lambda$addMenuProvider$0(r101, r102, r103);
    }

    public MenuHostHelper(Runnable r100) {
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r100;
    }

    public void addMenuProvider(MenuProvider r100) {
        this.mMenuProviders.add(r100);
        this.mOnInvalidateMenuCallback.run();
    }

    public void onMenuClosed(Menu r100) {
        Iterator<MenuProvider> r101 = this.mMenuProviders.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onMenuClosed(r100);
        goto L4
    }

    public boolean onMenuItemSelected(MenuItem r100) {
        Iterator<MenuProvider> r101 = this.mMenuProviders.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().onMenuItemSelected(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onPrepareMenu(Menu r100) {
        Iterator<MenuProvider> r101 = this.mMenuProviders.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPrepareMenu(r100);
        goto L4
    }

    public void removeMenuProvider(MenuProvider r100) {
        this.mMenuProviders.remove(r100);
        LifecycleContainer r101 = this.mProviderToLifecycleContainers.remove(r100);
        if (r101 == null) goto L5;
        r101.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(final MenuProvider r100, LifecycleOwner r101) {
        addMenuProvider(r100);
        Lifecycle r102 = r101.getLifecycle();
        LifecycleContainer r103 = this.mProviderToLifecycleContainers.remove(r100);
        if (r103 == null) goto L5;
        r103.clearObservers();
    L5:
        LifecycleEventObserver r104 = new f(this, r100);
        this.mProviderToLifecycleContainers.put(r100, new LifecycleContainer(r102, r104));
    }

    public void onCreateMenu(Menu r100, MenuInflater r101) {
        Iterator<MenuProvider> r102 = this.mMenuProviders.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onCreateMenu(r100, r101);
        goto L4
    }

    private /* synthetic */ void lambda$addMenuProvider$0(MenuProvider r100, LifecycleOwner r101, Lifecycle.Event r102) {
        if (r102 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r100);
        return;
    }

    public void addMenuProvider(final MenuProvider r100, LifecycleOwner r101, final Lifecycle.State r102) {
        Lifecycle r103 = r101.getLifecycle();
        LifecycleContainer r104 = this.mProviderToLifecycleContainers.remove(r100);
        if (r104 == null) goto L5;
        r104.clearObservers();
    L5:
        LifecycleEventObserver r105 = new g(this, r102, r100);
        this.mProviderToLifecycleContainers.put(r100, new LifecycleContainer(r103, r105));
    }

    private /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State r100, MenuProvider r101, LifecycleOwner r102, Lifecycle.Event r103) {
        if (r103 != Lifecycle.Event.upTo(r100)) goto L6;
        addMenuProvider(r101);
        return;
    L6:
        if (r103 != Lifecycle.Event.ON_DESTROY) goto L9;
        removeMenuProvider(r101);
        return;
    L9:
        if (r103 != Lifecycle.Event.downFrom(r100)) goto L14;
        this.mMenuProviders.remove(r101);
        this.mOnInvalidateMenuCallback.run();
        return;
    }
}
