package com.bytedance.android.live.soloktv.tuningpanel.ability;

import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends TuningEffectAbility {
    @Override // com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility
    public final String d() {
        return com.bytedance.android.livesdk.sharedpref.c.S.getValue();
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility
    public final String e() {
        return com.bytedance.android.livesdk.sharedpref.c.R.getValue();
    }

    public d() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        e<String> r101 = com.bytedance.android.livesdk.sharedpref.c.S;
        r101.getClass();
        f.d(r101, r100);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        e<String> r101 = com.bytedance.android.livesdk.sharedpref.c.R;
        r101.getClass();
        f.d(r101, r100);
    }
}
