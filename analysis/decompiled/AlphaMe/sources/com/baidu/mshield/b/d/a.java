package com.baidu.mshield.b.d;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public b f8267a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8268b;

    public a(Context context, Handler handler) {
        try {
            this.f8268b = context;
            this.f8267a = new b(context, handler);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public String a() {
        return this.f8267a.a();
    }

    public String a(String str, byte[] bArr) throws Throwable {
        if (str != null) {
            return !com.baidu.mshield.b.e.a.d(this.f8268b) ? "" : this.f8267a.a(str, bArr);
        }
        throw new IllegalArgumentException("postToServerForm request null");
    }
}
