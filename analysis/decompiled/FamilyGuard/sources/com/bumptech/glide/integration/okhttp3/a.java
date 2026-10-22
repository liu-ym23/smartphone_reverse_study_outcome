package com.bumptech.glide.integration.okhttp3;

import C4.A;
import C4.InterfaceC0275e;
import H0.g;
import H0.n;
import H0.o;
import H0.r;
import java.io.InputStream;
import y0.C1317a;
import z0.C1342h;

/* loaded from: classes.dex */
public class a implements n<g, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0275e.a f12016a;

    /* renamed from: com.bumptech.glide.integration.okhttp3.a$a, reason: collision with other inner class name */
    public static class C0159a implements o<g, InputStream> {

        /* renamed from: b, reason: collision with root package name */
        private static volatile InterfaceC0275e.a f12017b;

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0275e.a f12018a;

        public C0159a() {
            this(c());
        }

        private static InterfaceC0275e.a c() {
            if (f12017b == null) {
                synchronized (C0159a.class) {
                    try {
                        if (f12017b == null) {
                            f12017b = new A();
                        }
                    } finally {
                    }
                }
            }
            return f12017b;
        }

        @Override // H0.o
        public n<g, InputStream> a(r rVar) {
            return new a(this.f12018a);
        }

        @Override // H0.o
        public void b() {
        }

        public C0159a(InterfaceC0275e.a aVar) {
            this.f12018a = aVar;
        }
    }

    public a(InterfaceC0275e.a aVar) {
        this.f12016a = aVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(g gVar, int i5, int i6, C1342h c1342h) {
        return new n.a<>(gVar, new C1317a(this.f12016a, gVar));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar) {
        return true;
    }
}
