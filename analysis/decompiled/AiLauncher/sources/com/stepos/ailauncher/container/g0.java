package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.api.IOverlayPageProvider;
import com.stepos.ailauncher.container.api.IOverlayPageRegistry;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/container/g0;", "Lcom/stepos/ailauncher/container/api/IOverlayPageRegistry;", "<init>", "()V", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", Const.JSON_KEY_PROVIDER, "LY8/t;", "registerPage", "(Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;)V", "", "pageId", "unregisterPage", "(Ljava/lang/String;)V", "", "getPages", "()Ljava/util/List;", "Lkotlin/Function0;", "listener", "addOnPagesChangedListener", "(Lp9/a;)V", "removeOnPagesChangedListener", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/CopyOnWriteArrayList;", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g0 implements IOverlayPageRegistry {
    private final CopyOnWriteArrayList<IOverlayPageProvider> providers = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<InterfaceC5063a<Y8.t>> listeners = new CopyOnWriteArrayList<>();

    public static final boolean c(String str, IOverlayPageProvider iOverlayPageProvider) {
        return kotlin.jvm.internal.p.d(iOverlayPageProvider.getPageId(), str);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageRegistry
    public void addOnPagesChangedListener(InterfaceC5063a<Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.listeners.add(listener);
    }

    public final void b() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC5063a) it.next()).invoke();
        }
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageRegistry
    public List<IOverlayPageProvider> getPages() {
        return Z8.F.m1(this.providers);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageRegistry
    public void registerPage(IOverlayPageProvider provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        this.providers.add(provider);
        b();
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageRegistry
    public void removeOnPagesChangedListener(InterfaceC5063a<Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageRegistry
    public void unregisterPage(final String pageId) {
        kotlin.jvm.internal.p.i(pageId, "pageId");
        Z8.A.L(this.providers, new InterfaceC5074l() { // from class: com.stepos.ailauncher.container.f0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(g0.c(pageId, (IOverlayPageProvider) obj));
            }
        });
        b();
    }
}
