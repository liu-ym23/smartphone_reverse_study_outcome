package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTWebsocketConnection.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ae {

    /* JADX INFO: compiled from: TTWebsocketConnection.java */
    public static abstract class a {
        public abstract a a(int r1);

        public abstract a a(long r1);

        public abstract a a(String r1);

        public abstract a a(List<String> r1);

        public abstract a a(Map<String, String> r1);

        public abstract a a(boolean r1);

        public abstract ae a();

        public abstract a b(int r1);

        public abstract a b(long r1);

        public abstract a b(String r1);

        public abstract a b(Map<String, String> r1);

        public abstract a b(boolean r1);

        public abstract a c(int r1);

        public a() {
        }
    }

    /* JADX INFO: compiled from: TTWebsocketConnection.java */
    public static abstract class b {
        public abstract void a(ae r1, int r2, String r3);

        public abstract void a(ae r1, int r2, String r3, String r4);

        public void a(ae r1, String r2) {
        }

        public void a(ae r1, String r2, long r3, long r5, boolean r7) {
        }

        public abstract void a(ae r1, ByteBuffer r2, int r3);

        public b() {
        }
    }

    public abstract void a();

    public abstract void a(String r1);

    public abstract void a(ByteBuffer r1);

    public abstract void b();

    public abstract boolean c();

    public abstract void d();

    public ae() {
    }
}
