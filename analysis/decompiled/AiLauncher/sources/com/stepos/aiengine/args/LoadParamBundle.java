package com.stepos.aiengine.args;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0007J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/args/LoadParamBundle;", "", "<init>", "()V", "", "key", "setPlugin", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/LoadParamBundle;", "setTargetModel", "", "strategy", "setInitStrategy", "(I)Lcom/stepos/aiengine/args/LoadParamBundle;", "path", "setModelPath", "", Const.SP_KEY_GSM_UPLOAD_MXSIZE, "setIdleTimeout", "(J)Lcom/stepos/aiengine/args/LoadParamBundle;", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "bundle", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadParamBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int INIT_STRATEGY_ASYNC = 1;
    public static final int INIT_STRATEGY_HOT = 0;
    public static final int INIT_STRATEGY_SYNC = 2;
    public static final String KEY_IDLE_TIMEOUT = "idle_timeout_ms";
    public static final String KEY_INIT_STRATEGY = "init_strategy";
    public static final String KEY_MODEL_PATH = "model_path";
    public static final String KEY_PLUGIN = "plugin";
    public static final String KEY_TARGET_MODEL = "target_model";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle = new Bundle();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/args/LoadParamBundle$Companion;", "", "<init>", "()V", "KEY_PLUGIN", "", "KEY_TARGET_MODEL", "KEY_INIT_STRATEGY", "KEY_MODEL_PATH", "KEY_IDLE_TIMEOUT", "INIT_STRATEGY_HOT", "", "INIT_STRATEGY_ASYNC", "INIT_STRATEGY_SYNC", "from", "Lcom/stepos/aiengine/args/LoadParamBundle;", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final LoadParamBundle from(Bundle bundle) {
            p.i(bundle, "bundle");
            LoadParamBundle loadParamBundle = new LoadParamBundle();
            loadParamBundle.bundle.putAll(bundle);
            return loadParamBundle;
        }

        public Companion() {
        }
    }

    public final LoadParamBundle setIdleTimeout(long ms) {
        this.bundle.putLong(KEY_IDLE_TIMEOUT, ms);
        return this;
    }

    public final LoadParamBundle setInitStrategy(int strategy) {
        this.bundle.putInt(KEY_INIT_STRATEGY, strategy);
        return this;
    }

    public final LoadParamBundle setModelPath(String path) {
        p.i(path, "path");
        this.bundle.putString(KEY_MODEL_PATH, path);
        return this;
    }

    public final LoadParamBundle setPlugin(String key) {
        p.i(key, "key");
        this.bundle.putString("plugin", key);
        return this;
    }

    public final LoadParamBundle setTargetModel(String key) {
        p.i(key, "key");
        this.bundle.putString(KEY_TARGET_MODEL, key);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }
}
