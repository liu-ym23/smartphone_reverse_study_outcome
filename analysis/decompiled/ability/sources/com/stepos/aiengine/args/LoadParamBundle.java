package com.stepos.aiengine.args;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0007J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/args/LoadParamBundle;", "", AppAgent.CONSTRUCT, "()V", "", "key", "setPlugin", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/LoadParamBundle;", "setTargetModel", "", "strategy", "setInitStrategy", "(I)Lcom/stepos/aiengine/args/LoadParamBundle;", SingleFileBundle.KEY_PATH, "setModelPath", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadParamBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int INIT_STRATEGY_ASYNC = 1;
    public static final int INIT_STRATEGY_HOT = 0;
    public static final int INIT_STRATEGY_SYNC = 2;
    public static final String KEY_INIT_STRATEGY = "init_strategy";
    public static final String KEY_MODEL_PATH = "model_path";
    public static final String KEY_PLUGIN = "plugin";
    public static final String KEY_TARGET_MODEL = "target_model";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3488a = new Bundle();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/args/LoadParamBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "Lcom/stepos/aiengine/args/LoadParamBundle;", TypedValues.TransitionType.S_FROM, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/LoadParamBundle;", "", "KEY_PLUGIN", "Ljava/lang/String;", "KEY_TARGET_MODEL", "KEY_INIT_STRATEGY", "KEY_MODEL_PATH", "", "INIT_STRATEGY_HOT", "I", "INIT_STRATEGY_ASYNC", "INIT_STRATEGY_SYNC", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public final LoadParamBundle from(Bundle bundle) {
            k.f(bundle, "bundle");
            LoadParamBundle loadParamBundle = new LoadParamBundle();
            loadParamBundle.f3488a.putAll(bundle);
            return loadParamBundle;
        }
    }

    public final LoadParamBundle setInitStrategy(int strategy) {
        this.f3488a.putInt(KEY_INIT_STRATEGY, strategy);
        return this;
    }

    public final LoadParamBundle setModelPath(String path) {
        k.f(path, "path");
        this.f3488a.putString(KEY_MODEL_PATH, path);
        return this;
    }

    public final LoadParamBundle setPlugin(String key) {
        k.f(key, "key");
        this.f3488a.putString("plugin", key);
        return this;
    }

    public final LoadParamBundle setTargetModel(String key) {
        k.f(key, "key");
        this.f3488a.putString(KEY_TARGET_MODEL, key);
        return this;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3488a);
    }
}
