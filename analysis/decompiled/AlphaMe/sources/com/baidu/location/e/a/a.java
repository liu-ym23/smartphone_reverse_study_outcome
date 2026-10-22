package com.baidu.location.e.a;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Object> f5795a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Handler f5796b;

    /* renamed from: com.baidu.location.e.a.a$a, reason: collision with other inner class name */
    public static class C0014a {

        /* renamed from: a, reason: collision with root package name */
        private static a f5797a = new a();
    }

    public static a a() {
        return C0014a.f5797a;
    }

    public void b() {
        this.f5796b = new Handler();
    }
}
