package com.uxsense.core;

import S7.k;
import com.uxsense.core.UserExtensionsKt;
import java.nio.file.Path;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4200a;

    public /* synthetic */ d(int i) {
        this.f4200a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4200a) {
            case 0:
                return Boolean.valueOf(UserExtensionsKt.AnonymousClass2.invokeSuspend$lambda$0((Path) obj));
            case 1:
                return ApexRuleManager.getCache$lambda$0((String) obj);
            default:
                return Boolean.valueOf(CreationExtensionsKt.archiveOldCreations$lambda$3$lambda$0((Path) obj));
        }
    }
}
