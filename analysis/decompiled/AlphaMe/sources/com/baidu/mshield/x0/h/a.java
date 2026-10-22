package com.baidu.mshield.x0.h;

import android.content.Context;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.EngineImpl;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile long f8421a;

    /* renamed from: com.baidu.mshield.x0.h.a$a, reason: collision with other inner class name */
    public class C0040a extends com.baidu.mshield.x0.d.h.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f8422b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f8423c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f8424d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f8425e;

        public C0040a(a aVar, int i4, long j4, Context context, int i5) {
            this.f8422b = i4;
            this.f8423c = j4;
            this.f8424d = context;
            this.f8425e = i5;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            try {
                if (this.f8422b != 1) {
                    EngineImpl.getInstance(this.f8424d).uccs(this.f8425e, this.f8422b);
                    return;
                }
                synchronized (a.class) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (a.f8421a == 0 || jCurrentTimeMillis - a.f8421a >= this.f8423c) {
                            long unused = a.f8421a = jCurrentTimeMillis;
                            EngineImpl.getInstance(this.f8424d).uccs(this.f8425e, this.f8422b);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                d.a(th2);
            }
        }
    }

    public void a(Context context, int i4, int i5, long j4) {
        com.baidu.mshield.x0.d.h.d.b().a(new C0040a(this, i5, j4, context, i4));
    }
}
