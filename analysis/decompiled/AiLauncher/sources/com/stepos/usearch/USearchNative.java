package com.stepos.usearch;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0087 ¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0087 ¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0004H\u0087 ¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0087 ¢\u0006\u0004\b$\u0010\u0011J \u0010%\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0087 ¢\u0006\u0004\b%\u0010\u0011J\u0018\u0010&\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0087 ¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0087 ¢\u0006\u0004\b(\u0010'J\u0018\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020\nH\u0087 ¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020)2\u0006\u0010\r\u001a\u00020\nH\u0087 ¢\u0006\u0004\b,\u0010+J \u0010/\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0087 ¢\u0006\u0004\b/\u00100J \u00101\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0087 ¢\u0006\u0004\b1\u00100J\u0018\u00102\u001a\u00020)2\u0006\u0010\r\u001a\u00020\nH\u0087 ¢\u0006\u0004\b2\u0010+J\u0010\u00103\u001a\u00020-H\u0087 ¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u000f¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u000f¢\u0006\u0004\b7\u00106R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00108¨\u0006:"}, d2 = {"Lcom/stepos/usearch/USearchNative;", "", "<init>", "()V", "", "dimension", "metric", "connectivity", "expansionAdd", "expansionSearch", "", "nativeCreate", "(IIIII)J", "handle", "capacity", "", "nativeReserve", "(JJ)Z", "addThreads", "searchThreads", "nativeReserveWithThreads", "(JJII)Z", "key", "", "vector", "nativeAdd", "(JJ[F)Z", "", "keys", "vectors", "nativeAddBatch", "(J[J[FI)I", "query", "k", "nativeSearch", "(J[FI)[F", "nativeRemove", "nativeContains", "nativeSize", "(J)J", "nativeCapacity", "LY8/t;", "nativeClear", "(J)V", "nativeCompact", "", "path", "nativeSave", "(JLjava/lang/String;)Z", "nativeLoad", "nativeDestroy", "nativeVersion", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "Z", "libraryLoaded", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class USearchNative {

    /* renamed from: a, reason: collision with root package name */
    public static final USearchNative f31118a = new USearchNative();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean libraryLoaded;

    public static final native boolean nativeAdd(long handle, long key, float[] vector);

    public static final native int nativeAddBatch(long handle, long[] keys, float[] vectors, int dimension);

    public static final native long nativeCapacity(long handle);

    public static final native void nativeClear(long handle);

    public static final native void nativeCompact(long handle);

    public static final native boolean nativeContains(long handle, long key);

    public static final native long nativeCreate(int dimension, int metric, int connectivity, int expansionAdd, int expansionSearch);

    public static final native void nativeDestroy(long handle);

    public static final native boolean nativeLoad(long handle, String path);

    public static final native boolean nativeRemove(long handle, long key);

    public static final native boolean nativeReserve(long handle, long capacity);

    public static final native boolean nativeReserveWithThreads(long handle, long capacity, int addThreads, int searchThreads);

    public static final native boolean nativeSave(long handle, String path);

    public static final native float[] nativeSearch(long handle, float[] query, int k10);

    public static final native long nativeSize(long handle);

    public static final native String nativeVersion();

    public final boolean a() {
        return libraryLoaded;
    }

    public final boolean b() {
        if (libraryLoaded) {
            return true;
        }
        try {
            System.loadLibrary("usearch_jni");
            libraryLoaded = true;
            return true;
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
