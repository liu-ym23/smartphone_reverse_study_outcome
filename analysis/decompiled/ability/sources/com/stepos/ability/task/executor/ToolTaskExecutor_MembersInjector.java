package com.stepos.ability.task.executor;

import android.content.Context;
import dagger.hilt.android.qualifiers.ApplicationContext;
import x7.InterfaceC2117a;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ToolTaskExecutor_MembersInjector implements InterfaceC2117a {
    private final InterfaceC2137b contextProvider;

    private ToolTaskExecutor_MembersInjector(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static InterfaceC2117a create(InterfaceC2137b interfaceC2137b) {
        return new ToolTaskExecutor_MembersInjector(interfaceC2137b);
    }

    @ApplicationContext
    public static void injectContext(g gVar, Context context) {
        gVar.getClass();
    }

    public void injectMembers(g gVar) {
        injectContext(gVar, (Context) this.contextProvider.get());
    }
}
