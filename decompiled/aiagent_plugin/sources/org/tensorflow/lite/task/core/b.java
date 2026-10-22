package org.tensorflow.lite.task.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_ComputeSettings.java */
/* JADX INFO: loaded from: classes5.dex */
final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.b f40636a;

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoValue_ComputeSettings.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: AutoValue_ComputeSettings.java */
    static final class a extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private e.b f40637a;

        a() {
        }

        public e.a a(e.b r2) {
            Objects.requireNonNull(r2, "Null delegate");
            this.f40637a = r2;
            return this;
        }

        @Override // org.tensorflow.lite.task.core.e.a
        public e a() {
            String r1 = "";
            if (this.f40637a != null) goto L6;
            r1 = " delegate";
        L6:
            if (r1.isEmpty() == false) goto L10;
            return new b(this.f40637a, null);
        L10:
            throw new IllegalStateException("Missing required properties:" + r1);
        }
    }

    /* synthetic */ b(e.b r1, AnonymousClass1 r2) {
        this(r1);
    }

    private b(e.b r1) {
        this.f40636a = r1;
    }

    @Override // org.tensorflow.lite.task.core.e
    public e.b a() {
        return this.f40636a;
    }

    public String toString() {
        return "ComputeSettings{delegate=" + this.f40636a + "}";
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L9;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        return this.f40636a.equals(r4.a());
    L9:
        return false;
    }

    public int hashCode() {
        return this.f40636a.hashCode() ^ 1000003;
    }
}
