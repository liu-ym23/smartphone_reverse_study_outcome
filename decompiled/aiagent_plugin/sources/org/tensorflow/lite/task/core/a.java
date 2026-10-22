package org.tensorflow.lite.task.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_BaseOptions.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f40621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40622b;

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoValue_BaseOptions.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_BaseOptions.java */
    static final class C1098a extends c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e f40623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f40624b;

        C1098a() {
        }

        public c.a a(e r2) {
            Objects.requireNonNull(r2, "Null computeSettings");
            this.f40623a = r2;
            return this;
        }

        @Override // org.tensorflow.lite.task.core.c.a
        public c.a a(int r1) {
            this.f40624b = Integer.valueOf(r1);
            return this;
        }

        @Override // org.tensorflow.lite.task.core.c.a
        public c a() {
            String r1 = "";
            if (this.f40623a != null) goto L6;
            r1 = " computeSettings";
        L6:
            if (this.f40624b != null) goto L9;
            r1 = r1 + " numThreads";
        L9:
            if (r1.isEmpty() == false) goto L13;
            return new a(this.f40623a, this.f40624b.intValue(), null);
        L13:
            throw new IllegalStateException("Missing required properties:" + r1);
        }
    }

    /* synthetic */ a(e r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private a(e r1, int r2) {
        this.f40621a = r1;
        this.f40622b = r2;
    }

    @Override // org.tensorflow.lite.task.core.c
    e a() {
        return this.f40621a;
    }

    @Override // org.tensorflow.lite.task.core.c
    int b() {
        return this.f40622b;
    }

    public String toString() {
        return "BaseOptions{computeSettings=" + this.f40621a + ", numThreads=" + this.f40622b + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == false) goto L14;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f40621a.equals(r6.a()) == false) goto L13;
        if (this.f40622b != r6.b()) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f40621a.hashCode() ^ 1000003) * 1000003;
        return this.f40622b ^ r0;
    }
}
