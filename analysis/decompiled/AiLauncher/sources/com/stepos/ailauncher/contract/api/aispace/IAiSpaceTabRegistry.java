package com.stepos.ailauncher.contract.api.aispace;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabRegistry;", "", "Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabProvider;", Const.JSON_KEY_PROVIDER, "LY8/t;", "registerTab", "(Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabProvider;)V", "", "tabId", "unregisterTab", "(Ljava/lang/String;)V", "clearTabs", "()V", "", "getTabs", "()Ljava/util/List;", "Lkotlin/Function0;", "listener", "addOnTabsChangedListener", "(Lp9/a;)V", "removeOnTabsChangedListener", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAiSpaceTabRegistry {
    void addOnTabsChangedListener(InterfaceC5063a<t> listener);

    void clearTabs();

    List<IAiSpaceTabProvider> getTabs();

    void registerTab(IAiSpaceTabProvider provider);

    void removeOnTabsChangedListener(InterfaceC5063a<t> listener);

    void unregisterTab(String tabId);
}
