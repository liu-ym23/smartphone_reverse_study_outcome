package com.baidu.platform.comapi.cache.sp;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class AbsStoreClient {

    /* renamed from: a, reason: collision with root package name */
    private final SpStorageService f8737a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8738b;

    public AbsStoreClient(SpStorageConfig spStorageConfig, String str) {
        this.f8737a = SpStorageService.a(spStorageConfig);
        this.f8738b = str;
    }

    private void a() {
        if (TextUtils.isEmpty(this.f8738b)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean readBoolean(boolean z4) {
        a();
        return this.f8737a.a(this.f8738b, z4);
    }

    public float readFloat(float f4) {
        a();
        return this.f8737a.a(this.f8738b, f4);
    }

    public int readInt(int i4) {
        a();
        return this.f8737a.a(this.f8738b, i4);
    }

    public long readLong(long j4) {
        a();
        return this.f8737a.a(this.f8738b, j4);
    }

    public String readString(String str) {
        a();
        return this.f8737a.a(this.f8738b, str);
    }

    public void remove() {
        a();
        this.f8737a.a(this.f8738b);
    }

    public void writeBoolean(boolean z4) {
        a();
        this.f8737a.b(this.f8738b, z4);
    }

    public void writeFloat(float f4) {
        a();
        this.f8737a.b(this.f8738b, f4);
    }

    public void writeInt(int i4) {
        a();
        this.f8737a.b(this.f8738b, i4);
    }

    public void writeLong(long j4) {
        a();
        this.f8737a.b(this.f8738b, j4);
    }

    public void writeString(String str) {
        a();
        this.f8737a.b(this.f8738b, str);
    }
}
