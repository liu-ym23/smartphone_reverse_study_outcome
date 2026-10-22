package c6;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.PluginState;
import com.bytedance.platform.godzilla.plugin.StartType;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PluginState f6062a;

    public a() {
    }

    public abstract String a();

    public void b(Application r10) {
        this.f6062a = PluginState.INITIALIZED;
    }

    public void c() {
        this.f6062a = PluginState.STARTED;
    }

    public StartType d() {
        return StartType.IMMEDIATE;
    }
}
