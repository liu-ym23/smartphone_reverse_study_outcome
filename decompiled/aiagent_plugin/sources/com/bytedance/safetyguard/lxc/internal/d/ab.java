package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: TcpProxyStream.kt */
/* JADX INFO: loaded from: classes.dex */
interface ab {

    /* JADX INFO: compiled from: TcpProxyStream.kt */
    public static final class a implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f10110a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10110a, r6.f10110a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f10110a);
        }

        public String toString() {
            return "Data(payload=" + Arrays.toString(this.f10110a) + ')';
        }

        public a(byte[] r2) {
            d.h.b.o.e(r2, "payload");
            this.f10110a = r2;
        }

        public final byte[] a() {
            return this.f10110a;
        }
    }

    /* JADX INFO: compiled from: TcpProxyStream.kt */
    public static final class b implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10111a = null;

        static {
            f10111a = new b();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1991392680;
        }

        public String toString() {
            return "HalfClose";
        }

        private b() {
        }
    }
}
