package com.stepos.ailauncher.common.privacy;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/common/privacy/b;", "", "<init>", "()V", "Lkotlin/Function0;", "", "checker", "LY8/t;", Const.INTENT_KEY_UMID, "(Lp9/a;)V", Const.INTENT_KEY_PKGNAME, "()Z", Const.JSON_KEY_PROVIDER, "Lp9/a;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static volatile InterfaceC5063a<Boolean> provider = new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.privacy.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return Boolean.valueOf(b.c());
        }
    };

    public static final boolean c() {
        return false;
    }

    public final boolean b() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean boolInvoke = provider.invoke();
            boolInvoke.booleanValue();
            objB = Result.b(boolInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void d(InterfaceC5063a<Boolean> checker) {
        p.i(checker, "checker");
        provider = checker;
    }
}
