package dagger.hilt.android.internal.modules;

import android.app.Application;
import android.content.Context;
import dagger.hilt.InstallIn;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn({SingletonComponent.class})
/* loaded from: classes2.dex */
public final class ApplicationContextModule {
    private final Context applicationContext;

    public ApplicationContextModule(Context context) {
        this.applicationContext = context;
    }

    public Application provideApplication() {
        return Contexts.getApplication(this.applicationContext);
    }

    @ApplicationContext
    public Context provideContext() {
        return this.applicationContext;
    }
}
