package com.stepos.agentframework.chatui.appui;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR.\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/f;", "", "<init>", "()V", "", "viewName", "Lkotlin/Function0;", "Lcom/stepos/agentframework/chatui/appui/a;", "factory", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatui/appui/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "bridgeFactoryMap", "Ljava/util/concurrent/ConcurrentHashMap;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    public static final f INSTANCE = new f();
    private static final ConcurrentHashMap<String, InterfaceC5063a<a<?, ?>>> bridgeFactoryMap = new ConcurrentHashMap<>();

    public final a<?, ?> a(String viewName) {
        p.i(viewName, "viewName");
        InterfaceC5063a<a<?, ?>> interfaceC5063a = bridgeFactoryMap.get(viewName);
        if (interfaceC5063a != null) {
            return interfaceC5063a.invoke();
        }
        return null;
    }

    public final void b(String viewName, InterfaceC5063a<? extends a<?, ?>> factory) {
        p.i(viewName, "viewName");
        p.i(factory, "factory");
        if (H.x0(viewName)) {
            throw new IllegalArgumentException("名称不能为空");
        }
        ConcurrentHashMap<String, InterfaceC5063a<a<?, ?>>> concurrentHashMap = bridgeFactoryMap;
        if (!concurrentHashMap.containsKey(viewName)) {
            concurrentHashMap.put(viewName, factory);
            return;
        }
        throw new IllegalArgumentException(("'" + viewName + "' 已注册").toString());
    }
}
