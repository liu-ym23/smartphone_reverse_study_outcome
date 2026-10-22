package com.baidu.platform.comapi.cache.sp;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbsStoreClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SpStorageService f32879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32880b;

    private void a() {
        if (TextUtils.isEmpty(this.f32880b) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException();
    }

    public void remove() {
        a();
        this.f32879a.a(this.f32880b);
    }

    public boolean readBoolean(boolean r100) {
        a();
        return this.f32879a.a(this.f32880b, r100);
    }

    public float readFloat(float r100) {
        a();
        return this.f32879a.a(this.f32880b, r100);
    }

    public int readInt(int r100) {
        a();
        return this.f32879a.a(this.f32880b, r100);
    }

    public long readLong(long r100) {
        a();
        return this.f32879a.a(this.f32880b, r100);
    }

    public String readString(String r100) {
        a();
        return this.f32879a.a(this.f32880b, r100);
    }

    public void writeBoolean(boolean r100) {
        a();
        this.f32879a.b(this.f32880b, r100);
    }

    public void writeFloat(float r100) {
        a();
        this.f32879a.b(this.f32880b, r100);
    }

    public void writeInt(int r100) {
        a();
        this.f32879a.b(this.f32880b, r100);
    }

    public void writeLong(long r100) {
        a();
        this.f32879a.b(this.f32880b, r100);
    }

    public void writeString(String r100) {
        a();
        this.f32879a.b(this.f32880b, r100);
    }

    public AbsStoreClient(SpStorageConfig r100, String r101) {
        this.f32879a = SpStorageService.a(r100);
        this.f32880b = r101;
    }
}
