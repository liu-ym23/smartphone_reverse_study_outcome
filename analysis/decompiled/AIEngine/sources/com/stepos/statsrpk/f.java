package com.stepos.statsrpk;

import java.util.LinkedList;
import java.util.UUID;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList<b> f8079a;

    /* renamed from: b, reason: collision with root package name */
    public e f8080b;

    /* renamed from: c, reason: collision with root package name */
    public String f8081c;

    /* renamed from: d, reason: collision with root package name */
    public a f8082d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            StringBuilder sb2 = new StringBuilder("clean sessionId: ");
            f fVar = f.this;
            sb2.append(fVar.f8081c);
            ta.c.a("RpkPageController", sb2.toString());
            fVar.f8081c = null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f8084a;

        /* renamed from: b, reason: collision with root package name */
        public long f8085b;

        /* renamed from: c, reason: collision with root package name */
        public long f8086c;
    }

    public final String a() {
        if (this.f8081c == null) {
            synchronized (this) {
                this.f8081c = UUID.randomUUID().toString();
                ta.c.a("RpkPageController", "generate a sessionId: " + this.f8081c);
            }
        }
        return this.f8081c;
    }
}
