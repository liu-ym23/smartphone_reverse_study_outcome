package com.stepos.ailauncher.container.api;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/api/IOverlayPageRegistry;", "", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", Const.JSON_KEY_PROVIDER, "LY8/t;", "registerPage", "(Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;)V", "", "pageId", "unregisterPage", "(Ljava/lang/String;)V", "", "getPages", "()Ljava/util/List;", "Lkotlin/Function0;", "listener", "addOnPagesChangedListener", "(Lp9/a;)V", "removeOnPagesChangedListener", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IOverlayPageRegistry {
    void addOnPagesChangedListener(InterfaceC5063a<t> listener);

    List<IOverlayPageProvider> getPages();

    void registerPage(IOverlayPageProvider provider);

    void removeOnPagesChangedListener(InterfaceC5063a<t> listener);

    void unregisterPage(String pageId);
}
