package net.sqlcipher.database;

/* loaded from: classes5.dex */
public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    private Object mLock = new Object();

    private String getObjInfo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb2.append("database = ");
            sb2.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb2.append("mSql = ");
            sb2.append(((SQLiteProgram) this).mSql);
        }
        sb2.append(") ");
        return sb2.toString();
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            try {
                int i10 = this.mReferenceCount;
                if (i10 <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());
                }
                this.mReferenceCount = i10 + 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void onAllReferencesReleased();

    public void onAllReferencesReleasedFromContainer() {
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            try {
                int i10 = this.mReferenceCount - 1;
                this.mReferenceCount = i10;
                if (i10 == 0) {
                    onAllReferencesReleased();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            try {
                int i10 = this.mReferenceCount - 1;
                this.mReferenceCount = i10;
                if (i10 == 0) {
                    onAllReferencesReleasedFromContainer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
