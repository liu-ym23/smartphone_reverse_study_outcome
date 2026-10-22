package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrewarmAdmissionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: compiled from: PrewarmAdmissionController.kt */
    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f28316a = null;

        static {
            f28316a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PrewarmAdmissionController.kt */
    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f28317a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f28317a == r6.f28317a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28317a.hashCode();
        }

        public String toString() {
            return "Rejected(reason=" + this.f28317a + ')';
        }

        public final o a() {
            return this.f28317a;
        }

        public b(o r2) {
            d.h.b.o.e(r2, "reason");
            super(null);
            this.f28317a = r2;
        }
    }

    public /* synthetic */ p(d.h.b.h r1) {
        this();
    }

    private p() {
    }
}
