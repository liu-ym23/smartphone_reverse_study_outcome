package com.stepos.aiengine.args;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/args/ModelDownloadStartBundle;", "", "<init>", "()V", "", "plugin", "setPlugin", "(Ljava/lang/String;)Lcom/stepos/aiengine/args/ModelDownloadStartBundle;", "Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "_bundle", "getBundle", "()Landroid/os/Bundle;", "bundle", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ModelDownloadStartBundle {
    public static final String KEY_PLUGIN = "plugin";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle _bundle = new Bundle();

    public final Bundle getBundle() {
        return new Bundle(this._bundle);
    }

    public final ModelDownloadStartBundle setPlugin(String plugin) {
        p.i(plugin, "plugin");
        this._bundle.putString("plugin", plugin);
        return this;
    }
}
