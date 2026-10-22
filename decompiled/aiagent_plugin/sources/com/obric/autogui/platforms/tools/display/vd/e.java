package com.obric.autogui.platforms.tools.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f30199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.platforms.tools.display.vd.b f30200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f30201c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f30199a == r6.f30199a) goto L12;
            return false;
        L12:
            if (o.a(this.f30200b, r6.f30200b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f30201c, r6.f30201c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30199a.hashCode() * 31) + this.f30200b.hashCode()) * 31) + this.f30201c.hashCode();
        }

        public String toString() {
            return "Accepted(decision=" + this.f30199a + ", effectiveTask=" + this.f30200b + ", updateTargets=" + this.f30201c + ')';
        }

        public final c a() {
            return this.f30199a;
        }

        public final f b() {
            return this.f30201c;
        }

        public a(c r2, com.obric.autogui.platforms.tools.display.vd.b r3, f r4) {
            o.e(r2, "decision");
            o.e(r3, "effectiveTask");
            o.e(r4, "updateTargets");
            super(null);
            this.f30199a = r2;
            this.f30200b = r3;
            this.f30201c = r4;
        }
    }

    /* JADX INFO: compiled from: TaskFrontLiveTopGate.kt */
    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f30202a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f30202a == r6.f30202a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f30202a.hashCode();
        }

        public String toString() {
            return "Rejected(decision=" + this.f30202a + ')';
        }

        public final c a() {
            return this.f30202a;
        }

        public b(c r2) {
            o.e(r2, "decision");
            super(null);
            this.f30202a = r2;
        }
    }

    public /* synthetic */ e(h r1) {
        this();
    }

    private e() {
    }
}
