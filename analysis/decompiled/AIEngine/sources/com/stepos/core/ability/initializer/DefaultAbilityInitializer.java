package com.stepos.core.ability.initializer;

import android.content.Context;
import com.stepos.core.ability.config.AbilityConfigLoader;
import f.a;
import java.util.List;
import kotlin.jvm.internal.g;
import p6.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class DefaultAbilityInitializer implements e {
    @Override // p6.e
    public List<p6.a> initialize(Context context) {
        g.f(context, "context");
        return AbilityConfigLoader.INSTANCE.loadAbilities(context);
    }
}
