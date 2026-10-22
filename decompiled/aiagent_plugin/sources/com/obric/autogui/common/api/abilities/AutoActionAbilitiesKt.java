package com.obric.autogui.common.api.abilities;

import com.obric.autogui.common.api.platform.AOPlatformTools;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionAbilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionAbilitiesKt {
    public static final boolean isSupported(AutoActionAbility r1) {
        o.e(r1, "<this>");
        return AOPlatformTools.INSTANCE.abilities().isSupported(r1);
    }
}
