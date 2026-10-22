package net.zetetic.database.sqlcipher;

import java.io.Closeable;

/* loaded from: classes2.dex */
public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    public void acquireReference() {
        synchronized (this) {
            try {
                int i4 = this.mReferenceCount;
                if (i4 <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
                }
                this.mReferenceCount = i4 + 1;
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

    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void releaseReference() {
        boolean z4;
        synchronized (this) {
            z4 = true;
            int i4 = this.mReferenceCount - 1;
            this.mReferenceCount = i4;
            if (i4 != 0) {
                z4 = false;
            }
        }
        if (z4) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        boolean z4;
        synchronized (this) {
            z4 = true;
            int i4 = this.mReferenceCount - 1;
            this.mReferenceCount = i4;
            if (i4 != 0) {
                z4 = false;
            }
        }
        if (z4) {
            onAllReferencesReleasedFromContainer();
        }
    }
}
