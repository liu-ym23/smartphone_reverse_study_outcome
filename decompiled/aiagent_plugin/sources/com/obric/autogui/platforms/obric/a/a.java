package com.obric.autogui.platforms.obric.a;

import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.abilities.IAutoActionAbilityApi;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAutoActionAbilityImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionAbilityApi {
    private static final String TAG = "ObricAutoAbil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0789a f30058a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricAutoActionAbilityImpl.kt */
    public static final class C0789a {
        public /* synthetic */ C0789a(h r1) {
            this();
        }

        private C0789a() {
        }
    }

    static {
        f30058a = new C0789a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.common.api.abilities.IAutoActionAbilityApi
    public boolean isSupported(AutoActionAbility r3) {
        o.e(r3, "ability");
        if (r3 == AutoActionAbility.ProdDataDonation) goto L5;
    L8:
        return true;
    L5:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("enable_data_donation", false) == true) goto L8;
        Loog.INSTANCE.i(TAG, "enableDonation: settingsEnable false");
        return false;
    }
}
