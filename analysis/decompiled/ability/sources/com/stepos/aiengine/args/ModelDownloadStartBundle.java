package com.stepos.aiengine.args;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/args/ModelDownloadStartBundle;", "", AppAgent.CONSTRUCT, "()V", "", "plugin", "setPlugin", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/ModelDownloadStartBundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModelDownloadStartBundle {
    public static final String KEY_PLUGIN = "plugin";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3490a = new Bundle();

    public final Bundle getBundle() {
        return new Bundle(this.f3490a);
    }

    public final ModelDownloadStartBundle setPlugin(String plugin) {
        k.f(plugin, "plugin");
        this.f3490a.putString("plugin", plugin);
        return this;
    }
}
