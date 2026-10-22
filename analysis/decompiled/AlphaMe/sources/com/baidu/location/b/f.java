package com.baidu.location.b;

import android.os.Bundle;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Object f5221a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static f f5222b;

    /* renamed from: c, reason: collision with root package name */
    private int f5223c = -1;

    public static f a() {
        f fVar;
        synchronized (f5221a) {
            try {
                if (f5222b == null) {
                    f5222b = new f();
                }
                fVar = f5222b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public void a(int i4, int i5, String str) {
        if (i5 != this.f5223c) {
            this.f5223c = i5;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i4);
            bundle.putInt("diagtype", i5);
            bundle.putByteArray("diagmessage", str.getBytes());
            b.a().a(bundle, 303);
        }
    }
}
