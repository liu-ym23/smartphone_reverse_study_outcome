package io.objectbox;

import io.objectbox.exception.DbException;
import java.io.Closeable;

/* loaded from: classes4.dex */
public class Transaction implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f34331g;

    /* renamed from: a, reason: collision with root package name */
    public final long f34332a;

    /* renamed from: b, reason: collision with root package name */
    public final BoxStore f34333b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f34334c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f34335d;

    /* renamed from: e, reason: collision with root package name */
    public int f34336e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f34337f;

    public Transaction(BoxStore boxStore, long j10, int i10) {
        this.f34333b = boxStore;
        this.f34332a = j10;
        this.f34336e = i10;
        this.f34334c = nativeIsReadOnly(j10);
        this.f34335d = f34331g ? new Throwable() : null;
    }

    public boolean A() {
        return this.f34334c;
    }

    public boolean G() {
        e();
        return nativeIsRecycled(this.f34332a);
    }

    public void J() {
        e();
        nativeRecycle(this.f34332a);
    }

    public void U() {
        e();
        this.f34336e = this.f34333b.f34320u;
        nativeRenew(this.f34332a);
    }

    public void b() {
        e();
        nativeAbort(this.f34332a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (!this.f34337f) {
                this.f34337f = true;
                this.f34333b.m1(this);
                boolean zNativeIsOwnerThread = nativeIsOwnerThread(this.f34332a);
                if (!zNativeIsOwnerThread) {
                    boolean zNativeIsActive = nativeIsActive(this.f34332a);
                    boolean zNativeIsRecycled = nativeIsRecycled(this.f34332a);
                    if (zNativeIsActive || zNativeIsRecycled) {
                        String str = " (initial commit count: " + this.f34336e + ").";
                        if (zNativeIsActive) {
                            System.err.println("Transaction is still active" + str);
                        } else {
                            System.out.println("Hint: use closeThreadResources() to avoid finalizing recycled transactions" + str);
                            System.out.flush();
                        }
                        if (this.f34335d != null) {
                            System.err.println("Transaction was initially created here:");
                            this.f34335d.printStackTrace();
                        }
                        System.err.flush();
                    }
                }
                if (this.f34333b.a1()) {
                    boolean zNativeIsActive2 = nativeIsActive(this.f34332a);
                    if (this.f34334c) {
                        System.out.printf("Info: closing read transaction after store was closed (isActive=%s, isOwnerThread=%s), this should be avoided.%n", Boolean.valueOf(zNativeIsActive2), Boolean.valueOf(zNativeIsOwnerThread));
                        System.out.flush();
                        if (!nativeIsActive(this.f34332a)) {
                            nativeDestroy(this.f34332a);
                        }
                    } else {
                        System.out.printf("WARN: closing write transaction after store was closed (isActive=%s, isOwnerThread=%s), this must be avoided.%n", Boolean.valueOf(zNativeIsActive2), Boolean.valueOf(zNativeIsOwnerThread));
                        System.out.flush();
                        if (nativeIsActive(this.f34332a) && this.f34333b.b1()) {
                            throw new IllegalStateException("Internal error: cannot close active write transaction for an already destroyed store");
                        }
                        nativeDestroy(this.f34332a);
                    }
                } else {
                    nativeDestroy(this.f34332a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e() {
        if (this.f34337f) {
            throw new IllegalStateException("Transaction is closed");
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void g() {
        e();
        this.f34333b.l1(this, nativeCommit(this.f34332a));
    }

    public void i() {
        g();
        close();
    }

    public boolean isClosed() {
        return this.f34337f;
    }

    public <T> Cursor<T> l(Class<T> cls) {
        e();
        EntityInfo<T> entityInfoY = this.f34333b.Y(cls);
        entityInfoY.r();
        if (nativeCreateCursor(this.f34332a, entityInfoY.I(), cls) == 0) {
            throw new DbException("Could not create native cursor");
        }
        throw null;
    }

    public BoxStore m() {
        return this.f34333b;
    }

    public boolean n() {
        return !this.f34337f && nativeIsActive(this.f34332a);
    }

    public native void nativeAbort(long j10);

    public native int[] nativeCommit(long j10);

    public native long nativeCreateCursor(long j10, String str, Class<?> cls);

    public native long nativeCreateKeyValueCursor(long j10);

    public native void nativeDestroy(long j10);

    public native boolean nativeIsActive(long j10);

    public native boolean nativeIsOwnerThread(long j10);

    public native boolean nativeIsReadOnly(long j10);

    public native boolean nativeIsRecycled(long j10);

    public native void nativeRecycle(long j10);

    public native void nativeRenew(long j10);

    public native void nativeReset(long j10);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TX ");
        sb2.append(Long.toString(this.f34332a, 16));
        sb2.append(" (");
        sb2.append(this.f34334c ? "read-only" : "write");
        sb2.append(", initialCommitCount=");
        sb2.append(this.f34336e);
        sb2.append(")");
        return sb2.toString();
    }
}
