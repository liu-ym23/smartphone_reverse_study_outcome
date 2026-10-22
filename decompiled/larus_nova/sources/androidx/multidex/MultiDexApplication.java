package androidx.multidex;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes17.dex */
public class MultiDexApplication extends Application {
    public MultiDexApplication() {
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        MultiDex.install(this);
    }
}
