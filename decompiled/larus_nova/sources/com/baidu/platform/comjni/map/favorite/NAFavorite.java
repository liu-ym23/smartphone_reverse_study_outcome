package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: classes39.dex */
public class NAFavorite extends JNIBaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f33489a;

    private native boolean nativeAdd(long r100, String r101, String r102);

    private native boolean nativeClear(long r100);

    private native boolean nativeCloseCache(long r100);

    private native long nativeCreate();

    private native boolean nativeDelete(long r100);

    private native int nativeGetAll(long r100, Bundle r101);

    private native int nativeGetLength(long r100);

    private native int nativeGetRelations(long r100, String r101, Bundle r102, int r103);

    private native String nativeGetValue(long r100, String r101);

    private native boolean nativeIsExist(long r100, String r101);

    private native boolean nativeLoad(long r100, String r101, String r102, String r103, int r104, int r105, int r106);

    private native int nativeRelease(long r100);

    private native boolean nativeRemove(long r100, String r101);

    private native boolean nativeResumeCache(long r100);

    private native boolean nativeSaveCache(long r100);

    private native boolean nativeSetType(long r100, int r101);

    private native boolean nativeUpdate(long r100, String r101, String r102);

    private native boolean nativeUpdateInOrder(long r100, String r101, String r102);

    public boolean a() {
        long r100 = this.f33489a;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeClear(r100);
    }

    public int c() {
        return nativeRelease(this.f33489a);
    }

    public boolean d() {
        long r100 = this.f33489a;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeSaveCache(r100);
    }

    public NAFavorite() {
        this.f33489a = 0;
    }

    public long b() {
        long r100 = nativeCreate();
        this.f33489a = r100;
        return r100;
    }

    public int a(Bundle r100) {
        long r101 = this.f33489a;
        if (r101 != 0) goto L8;
        return 0;
    L8:
        return nativeGetAll(r101, r100);
    L7:
        return 0;
    }

    public boolean b(String r100) {
        long r101 = this.f33489a;
        if (r101 != 0) goto L8;
        return false;
    L8:
        return nativeIsExist(r101, r100);
    L7:
        return false;
    }

    public boolean c(String r100) {
        long r101 = this.f33489a;
        if (r101 != 0) goto L7;
        return false;
    L7:
        return nativeRemove(r101, r100);
    }

    public String a(String r100) {
        long r101 = this.f33489a;
        if (r101 != 0) goto L8;
        return null;
    L8:
        return nativeGetValue(r101, r100);
    L7:
        return null;
    }

    public boolean a(int r100) {
        long r101 = this.f33489a;
        if (r101 != 0) goto L7;
        return false;
    L7:
        return nativeSetType(r101, r100);
    }

    public boolean a(String r100, String r101) {
        long r102 = this.f33489a;
        if (r102 != 0) goto L7;
        return false;
    L7:
        return nativeAdd(r102, r100, r101);
    }

    public boolean b(String r100, String r101) {
        long r102 = this.f33489a;
        if (r102 != 0) goto L7;
        return false;
    L7:
        return nativeUpdate(r102, r100, r101);
    }

    public boolean a(String r110, String r111, String r112, int r113, int r114, int r115) {
        long r100 = this.f33489a;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeLoad(r100, r110, r111, r112, r113, r114, r115);
    }
}
