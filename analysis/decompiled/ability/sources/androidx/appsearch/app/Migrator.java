package androidx.appsearch.app;

import androidx.annotation.WorkerThread;

/* loaded from: classes.dex */
public abstract class Migrator {
    @WorkerThread
    public abstract GenericDocument onDowngrade(int i, int i6, GenericDocument genericDocument);

    @WorkerThread
    public abstract GenericDocument onUpgrade(int i, int i6, GenericDocument genericDocument);

    public abstract boolean shouldMigrate(int i, int i6);
}
