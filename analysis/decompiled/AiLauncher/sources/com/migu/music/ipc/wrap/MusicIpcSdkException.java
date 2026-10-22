package com.migu.music.ipc.wrap;

/* loaded from: classes2.dex */
public class MusicIpcSdkException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f21931a;

    public MusicIpcSdkException(int i10, String str) {
        super(str);
        this.f21931a = i10;
    }

    public int a() {
        return this.f21931a;
    }

    public MusicIpcSdkException(int i10, String str, Throwable th) {
        super(str, th);
        this.f21931a = i10;
    }
}
