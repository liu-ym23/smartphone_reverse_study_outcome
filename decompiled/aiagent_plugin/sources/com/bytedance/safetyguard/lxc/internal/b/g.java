package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: compiled from: TargetNormalizer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface g {

    /* JADX INFO: compiled from: TargetNormalizer.kt */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.m f9744c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9742a, r6.f9742a) == true) goto L12;
            return false;
        L12:
            if (this.f9743b == r6.f9743b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9742a.hashCode() * 31) + Integer.hashCode(this.f9743b);
        }

        public String toString() {
            return "Domain(host=" + this.f9742a + ", port=" + this.f9743b + ')';
        }

        public a(String r2, int r3) {
            d.h.b.o.e(r2, "host");
            this.f9742a = r2;
            this.f9743b = r3;
            this.f9744c = com.bytedance.safetyguard.lxc.internal.c.m.f9853b;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public String a() {
            return this.f9742a;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public int b() {
            return this.f9743b;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public com.bytedance.safetyguard.lxc.internal.c.m getType() {
            return this.f9744c;
        }
    }

    /* JADX INFO: compiled from: TargetNormalizer.kt */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InetAddress f9745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.m f9747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f9748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f9749e;

        public b(InetAddress r2, byte[] r3, int r4, com.bytedance.safetyguard.lxc.internal.c.m r5) {
            d.h.b.o.e(r2, SensitiveType.ADDRESS);
            d.h.b.o.e(r3, "addressBytes");
            d.h.b.o.e(r5, "type");
            this.f9745a = r2;
            this.f9746b = r4;
            this.f9747c = r5;
            byte[] r6 = Arrays.copyOf(r3, r3.length);
            d.h.b.o.c(r6, "copyOf(...)");
            this.f9748d = r6;
            String r7 = r2.getHostAddress();
            if (r7 == null) goto L7;
            this.f9749e = r7;
            return;
        L7:
            throw new t("IP address has no canonical host representation", null, 2, null);
        }

        public final InetAddress c() {
            return this.f9745a;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public int b() {
            return this.f9746b;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public com.bytedance.safetyguard.lxc.internal.c.m getType() {
            return this.f9747c;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.g
        public String a() {
            return this.f9749e;
        }

        public final byte[] d() {
            byte[] r1 = this.f9748d;
            byte[] r2 = Arrays.copyOf(r1, r1.length);
            d.h.b.o.c(r2, "copyOf(...)");
            return r2;
        }
    }

    String a();

    int b();

    com.bytedance.safetyguard.lxc.internal.c.m getType();
}
