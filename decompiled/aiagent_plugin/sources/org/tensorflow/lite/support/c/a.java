package org.tensorflow.lite.support.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: TensorBuffer.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ByteBuffer f40607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f40608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f40609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f40610d;

    /* JADX INFO: renamed from: org.tensorflow.lite.support.c.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: TensorBuffer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40611a = null;

        static {
            int[] r0 = new int[org.tensorflow.lite.a.values().length];
            f40611a = r0;
            r0[org.tensorflow.lite.a.f40579a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f40611a[org.tensorflow.lite.a.f40581c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public abstract void a(float[] r1, int[] r2);

    public abstract org.tensorflow.lite.a b();

    public abstract int c();

    public static a a(org.tensorflow.lite.a r3) {
        int r0 = AnonymousClass1.f40611a[r3.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return new c();
    L9:
        throw new AssertionError("TensorBuffer does not support data type: " + r3);
    L11:
        return new b();
    }

    public ByteBuffer a() {
        return this.f40607a;
    }

    public void a(ByteBuffer r5, int[] r6) {
        org.tensorflow.lite.support.a.a.a.a(r5, "Byte buffer cannot be null.");
        org.tensorflow.lite.support.a.a.a.a(d(r6), "Values in TensorBuffer shape should be non-negative.");
        int r0 = a(r6);
        if (r5.limit() != (c() * r0)) goto L5;
        boolean r1 = true;
    L6:
        org.tensorflow.lite.support.a.a.a.a(r1, "The size of byte buffer and the shape do not match. Expected: " + (c() * r0) + " Actual: " + r5.limit());
        if (this.f40610d == true) goto L9;
        org.tensorflow.lite.support.a.a.a.a(Arrays.equals(r6, this.f40608b));
    L9:
        this.f40608b = (int[]) ZeusTransformUtils.preCheckCast(r6.clone(), int[].class, "com.obric.aiagent.plugin");
        this.f40609c = r0;
        r5.rewind();
        this.f40607a = r5;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public a() {
        this.f40609c = -1;
        this.f40610d = true;
        c(new int[]{0});
    }

    public static int a(int[] r4) {
        org.tensorflow.lite.support.a.a.a.a(r4, "Shape cannot be null.");
        int r0 = r4.length;
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 * r4[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public void b(int[] r3) {
        if (this.f40610d == false) goto L5;
        c(r3);
        return;
    L5:
        org.tensorflow.lite.support.a.a.a.a(Arrays.equals(r3, this.f40608b));
        this.f40608b = (int[]) ZeusTransformUtils.preCheckCast(r3.clone(), int[].class, "com.obric.aiagent.plugin");
    }

    public synchronized void d() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f40607a.isReadOnly() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        ByteBuffer r0 = ByteBuffer.allocateDirect(this.f40607a.capacity());     // Catch: Throwable -> L10
        r0.order(this.f40607a.order());     // Catch: Throwable -> L10
        r0.put(this.f40607a);     // Catch: Throwable -> L10
        r0.rewind();     // Catch: Throwable -> L10
        this.f40607a = r0;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private void c(int[] r4) {
        org.tensorflow.lite.support.a.a.a.a(r4, "TensorBuffer shape cannot be null.");
        org.tensorflow.lite.support.a.a.a.a(d(r4), "Values in TensorBuffer shape should be non-negative.");
        int r0 = a(r4);
        this.f40608b = (int[]) ZeusTransformUtils.preCheckCast(r4.clone(), int[].class, "com.obric.aiagent.plugin");
        if (this.f40609c != r0) goto L5;
        return;
    L5:
        this.f40609c = r0;
        ByteBuffer r5 = ByteBuffer.allocateDirect(r0 * c());
        this.f40607a = r5;
        r5.order(ByteOrder.nativeOrder());
    }

    private static boolean d(int[] r5) {
        if (r5.length != 0) goto L5;
        return true;
    L5:
        int r0 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L11;
        if (r5[r3] < 0) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
