package com.uxsense.ruleTrigger;

import com.uxsense.ruleTrigger.ApexTriggerManager;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4209a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(int i, int i6) {
        this.f4209a = i6;
        this.b = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f4209a;
        int i6 = this.b;
        ApexTriggerManager.PkgCallbackData pkgCallbackData = (ApexTriggerManager.PkgCallbackData) obj;
        switch (i) {
            case 0:
                return ApexTriggerManager.lambda$performSetApexService$3(i6, pkgCallbackData);
            default:
                return ApexTriggerManager.lambda$onProcessDied$1(i6, pkgCallbackData);
        }
    }
}
