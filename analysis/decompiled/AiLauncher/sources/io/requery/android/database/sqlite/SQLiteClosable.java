package io.requery.android.database.sqlite;

import java.io.Closeable;

/* loaded from: classes4.dex */
public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    public void acquireReference() {
        synchronized (this) {
            try {
                int i10 = this.mReferenceCount;
                if (i10 <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
                }
                this.mReferenceCount = i10 + 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }

    public abstract void onAllReferencesReleased();

    public void releaseReference() {
        boolean z10;
        synchronized (this) {
            z10 = true;
            int i10 = this.mReferenceCount - 1;
            this.mReferenceCount = i10;
            if (i10 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            onAllReferencesReleased();
        }
    }
}
