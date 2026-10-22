package com.stepos.core.ota.display;

import android.content.Context;
import com.stepos.core.common.display.ModelDisplayResolver;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLabelResolver {
    public static final ModelLabelResolver INSTANCE = new ModelLabelResolver();

    private ModelLabelResolver() {
    }

    public final String resolve(Context context, String otaId, String str) {
        g.f(context, "context");
        g.f(otaId, "otaId");
        return ModelDisplayResolver.INSTANCE.resolveDisplayName(context, otaId, str);
    }
}
