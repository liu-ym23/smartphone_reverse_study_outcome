package com.obric.autogui.session.state.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.common.e f31362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n f31363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final q f31364c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f31362a, r6.f31362a) == true) goto L12;
            return false;
        L12:
            if (this.f31363b == r6.f31363b) goto L15;
            return false;
        L15:
            if (this.f31364c == r6.f31364c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f31362a.hashCode() * 31) + this.f31363b.hashCode()) * 31) + this.f31364c.hashCode();
        }

        public String toString() {
            return "Failed(status=" + this.f31362a + ", source=" + this.f31363b + ", stage=" + this.f31364c + ')';
        }

        public final com.obric.autogui.common.e a() {
            return this.f31362a;
        }

        public final n b() {
            return this.f31363b;
        }

        public final q c() {
            return this.f31364c;
        }

        public a(com.obric.autogui.common.e r2, n r3, q r4) {
            d.h.b.o.e(r2, "status");
            d.h.b.o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            d.h.b.o.e(r4, "stage");
            super(null);
            this.f31362a = r2;
            this.f31363b = r3;
            this.f31364c = r4;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f31365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n f31366b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f31365a == r6.f31365a) goto L12;
            return false;
        L12:
            if (this.f31366b == r6.f31366b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f31365a) * 31) + this.f31366b.hashCode();
        }

        public String toString() {
            return "Ready(displayId=" + this.f31365a + ", source=" + this.f31366b + ')';
        }

        public final int a() {
            return this.f31365a;
        }

        public final n b() {
            return this.f31366b;
        }

        public b(int r2, n r3) {
            d.h.b.o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            super(null);
            this.f31365a = r2;
            this.f31366b = r3;
        }
    }

    public /* synthetic */ p(d.h.b.h r1) {
        this();
    }

    private p() {
    }
}
