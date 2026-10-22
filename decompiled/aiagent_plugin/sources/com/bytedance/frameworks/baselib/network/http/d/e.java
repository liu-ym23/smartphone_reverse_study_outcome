package com.bytedance.frameworks.baselib.network.http.d;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializableHttpCookie.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Serializable {
    private static final String TAG = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient f f8301a;

    static {
    }

    public e(f r1) {
        this.f8301a = r1;
    }

    public f a() {
        return this.f8301a;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L7;
        return this.f8301a.equals(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
        return false;
    L9:
        return this.f8301a.equals(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).f8301a);
    }

    public int hashCode() {
        return this.f8301a.hashCode();
    }

    public byte[] b() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        new ObjectOutputStream(r0).writeObject(this);     // Catch: IOException -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        Logger.e(TAG, "encodeCookie failed", e);
        return null;
    }

    public static e a(String r5, String r6, String r7, boolean r8, byte[] r9) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        if (r9 == null) goto L13;
        e r10 = (e) ZeusTransformUtils.preCheckCast(new com.bytedance.frameworks.baselib.network.http.e.a(new ByteArrayInputStream(r9), new Class[]{e.class}).readObject(), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r10.f8301a.a(r5, r8);     // Catch: Throwable -> L11
        r10.f8301a.a(r6);     // Catch: Throwable -> L11
        r10.f8301a.b(r7);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        Logger.e(TAG, "decodeCookie failed", th);
        goto L13
    }
}
