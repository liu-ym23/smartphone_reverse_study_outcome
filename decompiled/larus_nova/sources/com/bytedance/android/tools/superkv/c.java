package com.bytedance.android.tools.superkv;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f187612d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f187613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f187614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f187615c;

    static {
        f187612d = Charset.forName("UTF-8");
    }

    public final byte a() {
        return this.f187613a.get();
    }

    public c() {
        this.f187615c = new byte[1024];
    }
}
