package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class w {

    public static abstract class a {
        public a() {
        }

        public abstract w a();

        public abstract a b(int r10);

        public abstract a c(String r10);

        public abstract a d(int r10);

        public abstract a e(Map r10);

        public abstract a f(Map r10);

        public abstract a g(long r10);

        public abstract a h(int r10);

        public abstract a i(long r10);

        public abstract a j(String r10);

        public abstract a k(boolean r10);

        public abstract a l(List r10);

        public abstract a m(boolean r10);
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(w r10, int r11, String r12, String r13);

        public abstract void b(w r10, int r11, String r12);

        public void c(w r10, String r11) {
        }

        public abstract void d(w r10, ByteBuffer r11, int r12);

        public abstract void e(w r10, String r11, long r12, long r13, boolean r14);
    }

    public w() {
    }

    public abstract void a(ByteBuffer r10);

    public abstract void b(String r10);

    public abstract void c();

    public abstract boolean d();

    public abstract void e();

    public abstract void f();
}
