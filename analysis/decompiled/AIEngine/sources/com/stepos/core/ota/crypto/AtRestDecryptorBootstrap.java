package com.stepos.core.ota.crypto;

import a4.a;
import a9.b;
import android.content.Context;
import com.stepos.core.common.cloud.d;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.ota.c;
import com.stepos.core.ota.domain.port.OtaLogger;
import java.io.File;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtRestDecryptorBootstrap {
    public static final AtRestDecryptorBootstrap INSTANCE = new AtRestDecryptorBootstrap();
    private static final String TAG = "AtRestDecryptorBootstrap";
    private static final String TEMP_SUBDIR = "atrest_plain";
    private static volatile boolean installed;

    private AtRestDecryptorBootstrap() {
    }

    public static /* synthetic */ void install$default(AtRestDecryptorBootstrap atRestDecryptorBootstrap, Context context, OtaLogger otaLogger, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            otaLogger = OtaLogger.Noop.INSTANCE;
        }
        atRestDecryptorBootstrap.install(context, otaLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File install$lambda$3$lambda$0(Context context) {
        return new File(context.getCacheDir(), TEMP_SUBDIR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean install$lambda$3$lambda$1() {
        return EngineRuntimeConfig.INSTANCE.getSnapshot().getModelEncryptionEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean install$lambda$3$lambda$2(String modelId) {
        g.f(modelId, "modelId");
        return EngineRuntimeConfig.INSTANCE.shouldEncryptModel(modelId);
    }

    public final void install(Context context, OtaLogger log) {
        g.f(context, "context");
        g.f(log, "log");
        if (installed) {
            return;
        }
        synchronized (this) {
            if (installed) {
                return;
            }
            a.f37i = new OtaAtRestDecryptor(new KeystoreAtRestKeyStore(log), new ModelCryptoImpl(), log, new c(context.getApplicationContext(), 2), new b(17), new d(14));
            installed = true;
            log.i(TAG, "at-rest load-side decryptor installed");
            n nVar = n.f10413a;
        }
    }
}
