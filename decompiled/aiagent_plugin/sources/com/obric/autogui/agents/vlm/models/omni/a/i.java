package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28172a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28172a, r6.f28172a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28172a.hashCode();
        }

        public String toString() {
            return "Blocked(reason=" + this.f28172a + ')';
        }

        public a(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f28172a = r2;
        }

        public final String a() {
            return this.f28172a;
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28173a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28173a, r6.f28173a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28173a.hashCode();
        }

        public String toString() {
            return "RetryLater(reason=" + this.f28173a + ')';
        }

        public b(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f28173a = r2;
        }

        public final String a() {
            return this.f28173a;
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28175b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f28174a == r6.f28174a) goto L12;
            return false;
        L12:
            if (o.a(this.f28175b, r6.f28175b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f28174a) * 31) + this.f28175b.hashCode();
        }

        public String toString() {
            return "ServerError(code=" + this.f28174a + ", reason=" + this.f28175b + ')';
        }

        public c(int r2, String r3) {
            o.e(r3, "reason");
            super(null);
            this.f28174a = r2;
            this.f28175b = r3;
        }

        public final int a() {
            return this.f28174a;
        }

        public final String b() {
            return this.f28175b;
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28176a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28176a, r6.f28176a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28176a.hashCode();
        }

        public String toString() {
            return "Skipped(reason=" + this.f28176a + ')';
        }

        public d(String r2) {
            o.e(r2, "reason");
            super(null);
            this.f28176a = r2;
        }

        public final String a() {
            return this.f28176a;
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
    public static final class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f28177a;

        public e() {
            this(false, 1, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f28177a == r6.f28177a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f28177a);
        }

        public String toString() {
            return "Success(terminalReported=" + this.f28177a + ')';
        }

        public e(boolean r2) {
            super(null);
            this.f28177a = r2;
        }

        public /* synthetic */ e(boolean r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f28177a;
        }
    }

    public /* synthetic */ i(d.h.b.h r1) {
        this();
    }

    private i() {
    }
}
