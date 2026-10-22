package com.stepos.backend.onnx;

import android.content.Context;
import b6.i;
import b7.d;
import b7.k;
import com.stepos.core.model.factory.AIModelFactory;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TenVadOnnxModelInitializer implements d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$0(k config) {
        g.f(config, "config");
        return new TenVadOnnxModel(config);
    }

    @Override // b7.d
    public void initialize(Context context) {
        g.f(context, "context");
        AIModelFactory.Companion.m106registerModelFactoryxbr04nE("TEN_VAD_ONNX", new i(16));
    }
}
