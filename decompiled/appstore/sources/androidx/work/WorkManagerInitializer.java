package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5373a = null;

    static {
        f5373a = i.i("WrkMgrInitializer");
    }

    public WorkManagerInitializer() {
    }

    public WorkManager a(Context r10) {
        i.e().a(f5373a, "Initializing WorkManager with default configuration.");
        WorkManager.f(r10, new Configuration.b().a());
        return WorkManager.e(r10);
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ WorkManager create(Context r10) {
        return a(r10);
    }

    @Override // androidx.startup.Initializer
    public List dependencies() {
        return Collections.emptyList();
    }
}
