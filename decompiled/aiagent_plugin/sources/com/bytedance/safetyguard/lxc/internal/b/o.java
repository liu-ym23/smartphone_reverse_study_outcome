package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: TargetParser.kt */
/* JADX INFO: loaded from: classes.dex */
public interface o {

    /* JADX INFO: compiled from: TargetParser.kt */
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9780b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f9779a, r6.f9779a) == true) goto L12;
            return false;
        L12:
            if (this.f9780b == r6.f9780b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9779a.hashCode() * 31) + Integer.hashCode(this.f9780b);
        }

        public String toString() {
            return "Domain(value=" + this.f9779a + ", port=" + this.f9780b + ')';
        }

        public a(String r2, int r3) {
            d.h.b.o.e(r2, "value");
            this.f9779a = r2;
            this.f9780b = r3;
        }

        public final String b() {
            return this.f9779a;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.o
        public int a() {
            return this.f9780b;
        }
    }

    /* JADX INFO: compiled from: TargetParser.kt */
    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.m f9781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f9782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9783c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f9781a == r6.f9781a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f9782b, r6.f9782b) == true) goto L15;
            return false;
        L15:
            if (this.f9783c == r6.f9783c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f9781a.hashCode() * 31) + Arrays.hashCode(this.f9782b)) * 31) + Integer.hashCode(this.f9783c);
        }

        public String toString() {
            return "Ip(type=" + this.f9781a + ", addressBytes=" + Arrays.toString(this.f9782b) + ", port=" + this.f9783c + ')';
        }

        public b(com.bytedance.safetyguard.lxc.internal.c.m r2, byte[] r3, int r4) {
            d.h.b.o.e(r2, "type");
            d.h.b.o.e(r3, "addressBytes");
            this.f9781a = r2;
            this.f9782b = r3;
            this.f9783c = r4;
        }

        public final com.bytedance.safetyguard.lxc.internal.c.m getType() {
            return this.f9781a;
        }

        public final byte[] b() {
            return this.f9782b;
        }

        @Override // com.bytedance.safetyguard.lxc.internal.b.o
        public int a() {
            return this.f9783c;
        }
    }

    int a();
}
