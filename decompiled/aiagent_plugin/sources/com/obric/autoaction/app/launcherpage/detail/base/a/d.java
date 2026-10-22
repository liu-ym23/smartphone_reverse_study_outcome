package com.obric.autoaction.app.launcherpage.detail.base.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: TaskValidator.kt */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f23254c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f23252a == r6.f23252a) goto L12;
            return false;
        L12:
            if (o.a(this.f23253b, r6.f23253b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f23254c, r6.f23254c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f23252a) * 31) + this.f23253b.hashCode()) * 31;
            String r2 = this.f23254c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Fail(code=" + this.f23252a + ", msg=" + this.f23253b + ", detailReason=" + this.f23254c + ')';
        }

        public a(int r2, String r3, String r4) {
            o.e(r3, "msg");
            super(null);
            this.f23252a = r2;
            this.f23253b = r3;
            this.f23254c = r4;
        }

        public /* synthetic */ a(int r1, String r2, String r3, int r4, h r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final int a() {
            return this.f23252a;
        }

        public final String b() {
            return this.f23253b;
        }

        public final String c() {
            return this.f23254c;
        }
    }

    /* JADX INFO: compiled from: TaskValidator.kt */
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23255a = null;

        static {
            f23255a = new b();
        }

        private b() {
            super(null);
        }
    }

    public /* synthetic */ d(h r1) {
        this();
    }

    private d() {
    }
}
