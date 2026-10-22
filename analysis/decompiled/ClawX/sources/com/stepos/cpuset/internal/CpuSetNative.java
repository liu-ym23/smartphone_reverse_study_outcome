package com.stepos.cpuset.internal;

import a8.b;
import android.util.Log;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0083 ¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/cpuset/internal/CpuSetNative;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tid", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "coreIds", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nativeSetAffinity", "(I[I)Z", "cpuset_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CpuSetNative {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f1546a;

    static {
        try {
            System.loadLibrary("cpuset");
            f1546a = true;
            Log.i("CpuSetNative", "Native library cpuset loaded successfully");
        } catch (UnsatisfiedLinkError e9) {
            f1546a = false;
            b.y("Failed to load native library cpuset: ", e9.getMessage(), "CpuSetNative");
        }
    }

    public static boolean a(int[] iArr) {
        if (!f1546a) {
            Log.w("CpuSetNative", "Native library not loaded, cannot set affinity");
            return false;
        }
        try {
            return nativeSetAffinity(0, iArr);
        } catch (Exception e9) {
            Log.e("CpuSetNative", "Failed to set affinity for thread 0", e9);
            return false;
        }
    }

    private static final native boolean nativeSetAffinity(int tid, int[] coreIds);
}
