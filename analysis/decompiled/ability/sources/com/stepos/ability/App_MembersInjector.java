package com.stepos.ability;

import com.stepos.ability.api.application.IApp;
import x7.InterfaceC2117a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class App_MembersInjector implements InterfaceC2117a {
    private final InterfaceC2137b appProvider;

    private App_MembersInjector(InterfaceC2137b interfaceC2137b) {
        this.appProvider = interfaceC2137b;
    }

    public static InterfaceC2117a create(InterfaceC2137b interfaceC2137b) {
        return new App_MembersInjector(interfaceC2137b);
    }

    public static void injectApp(App app, IApp iApp) {
        app.app = iApp;
    }

    public void injectMembers(App app) {
        injectApp(app, (IApp) this.appProvider.get());
    }
}
