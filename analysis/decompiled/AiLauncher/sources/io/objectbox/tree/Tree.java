package io.objectbox.tree;

import java.io.Closeable;

/* loaded from: classes4.dex */
public class Tree implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public long f34389a;

    public static native long nativeCreate(long j10, long j11);

    public static native long nativeCreateWithUid(long j10, String str);

    public static native void nativeDelete(long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nativeDelete(this.f34389a);
        this.f34389a = 0L;
    }

    public native void nativeClearTransaction(long j10);

    public native LeafNode nativeGetLeafById(long j10, long j11);

    public native long nativeGetRootId(long j10);

    public native long nativePutBranch(long j10, long j11, long j12, long j13, String str);

    public native long nativePutMetaBranch(long j10, long j11, long j12, String str, String str2);

    public native long[] nativePutMetaBranches(long j10, long j11, String[] strArr);

    public native long nativePutMetaLeaf(long j10, long j11, long j12, String str, short s10, boolean z10, String str2);

    public native long nativePutValueFP(long j10, long j11, long j12, long j13, double d10);

    public native long nativePutValueInteger(long j10, long j11, long j12, long j13, long j14);

    public native long nativePutValueString(long j10, long j11, long j12, long j13, String str);

    public native boolean nativeSetTransaction(long j10, long j11);
}
