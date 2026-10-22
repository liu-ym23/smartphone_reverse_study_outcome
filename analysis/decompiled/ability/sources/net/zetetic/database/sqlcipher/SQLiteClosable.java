package net.zetetic.database.sqlcipher;

import java.io.Closeable;

/* loaded from: classes4.dex */
public abstract class SQLiteClosable implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public int f5379a = 1;

    public final void b() {
        synchronized (this) {
            try {
                int i = this.f5379a;
                if (i <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
                }
                this.f5379a = i + 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f();
    }

    public final void f() {
        boolean z10;
        synchronized (this) {
            z10 = true;
            int i = this.f5379a - 1;
            this.f5379a = i;
            if (i != 0) {
                z10 = false;
            }
        }
        if (z10) {
            c();
        }
    }
}
