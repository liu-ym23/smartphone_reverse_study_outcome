package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;

/* loaded from: classes.dex */
public class NAFavorite extends JNIBaseApi {

    /* renamed from: a, reason: collision with root package name */
    private long f9366a = 0;

    private native boolean nativeAdd(long j4, String str, String str2);

    private native boolean nativeClear(long j4);

    private native boolean nativeCloseCache(long j4);

    private native long nativeCreate();

    private native boolean nativeDelete(long j4);

    private native int nativeGetAll(long j4, Bundle bundle);

    private native int nativeGetLength(long j4);

    private native int nativeGetRelations(long j4, String str, Bundle bundle, int i4);

    private native String nativeGetValue(long j4, String str);

    private native boolean nativeIsExist(long j4, String str);

    private native boolean nativeLoad(long j4, String str, String str2, String str3, int i4, int i5, int i6);

    private native int nativeRelease(long j4);

    private native boolean nativeRemove(long j4, String str);

    private native boolean nativeResumeCache(long j4);

    private native boolean nativeSaveCache(long j4);

    private native boolean nativeSetType(long j4, int i4);

    private native boolean nativeUpdate(long j4, String str, String str2);

    private native boolean nativeUpdateInOrder(long j4, String str, String str2);

    public boolean a(String str, String str2, String str3, int i4, int i5, int i6) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeLoad(j4, str, str2, str3, i4, i5, i6);
    }

    public long b() {
        long jNativeCreate = nativeCreate();
        this.f9366a = jNativeCreate;
        return jNativeCreate;
    }

    public int c() {
        return nativeRelease(this.f9366a);
    }

    public boolean d() {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeSaveCache(j4);
    }

    public boolean b(String str, String str2) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeUpdate(j4, str, str2);
    }

    public boolean c(String str) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeRemove(j4, str);
    }

    public boolean a(int i4) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeSetType(j4, i4);
    }

    public boolean b(String str) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        try {
            return nativeIsExist(j4, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(String str, String str2) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeAdd(j4, str, str2);
    }

    public boolean a() {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return false;
        }
        return nativeClear(j4);
    }

    public String a(String str) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return null;
        }
        try {
            return nativeGetValue(j4, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public int a(Bundle bundle) {
        long j4 = this.f9366a;
        if (j4 == 0) {
            return 0;
        }
        try {
            return nativeGetAll(j4, bundle);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
