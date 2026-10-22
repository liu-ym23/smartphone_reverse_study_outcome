package obric.api;

import android.content.res.Configuration;
import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class ConfigureRescourceSmt {
    static final String TAG = "ConfigureRescourceSmt";
    static final Singleton<ConfigureRescourceSmt> sConfiguration = null;
    private ConfigureResourceSmtImpl impl;

    /* synthetic */ ConfigureRescourceSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sConfiguration = new AnonymousClass1();
    }

    public static ConfigureRescourceSmt getInstance() {
        return (ConfigureRescourceSmt) sConfiguration.get();
    }

    private ConfigureRescourceSmt() {
        this.impl = new ConfigureResourceSmtImpl();
    }

    public boolean isSameCustomTheme(Configuration r1, Configuration r2) {
        return this.impl.isSameCustomTheme(r1, r2);
    }
}
