package com.obric.autogui.platforms.tools.a;

import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.abilities.IAutoActionAbilityApi;
import d.h.b.o;

/* JADX INFO: compiled from: StandardAbilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements IAutoActionAbilityApi {

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardAbilities.kt */
    public /* synthetic */ class C0798a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30132a = null;

        static {
            int[] r0 = new int[AutoActionAbility.values().length];
            r0[AutoActionAbility.ProdDataDonation.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f30132a = r0;
        }
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.abilities.IAutoActionAbilityApi
    public boolean isSupported(AutoActionAbility r1) {
        o.e(r1, "ability");
        if (C0798a.f30132a[r1.ordinal()] != 1) goto L6;
        return false;
    L6:
        return true;
    }
}
