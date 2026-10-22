package com.bytedance.android.livesdk.chatroom.utils.pngloader;

import java.io.Closeable;
import po1.c;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f114590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f114591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f114592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f114593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f114594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f114595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f114596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f114597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f114598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f114599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f114600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f114601l;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f114595f = true;
    }

    public b() {
        byte[] r100 = po1.a.f530026a;
        this.f114591b = new byte[8];
        this.f114592c = 0;
        this.f114594e = false;
        this.f114595f = false;
        this.f114596g = 0;
        this.f114597h = 0;
        this.f114598i = -1;
        this.f114599j = 0;
        this.f114601l = null;
        this.f114590a = 8;
        this.f114593d = false;
    }
}
