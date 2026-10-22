package org.tensorflow.lite.task.core.a;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_ImageProcessingOptions.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f40625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.EnumC1100b f40626b;

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.a.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoValue_ImageProcessingOptions.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoValue_ImageProcessingOptions.java */
    static final class C1099a extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f40627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b.EnumC1100b f40628b;

        C1099a() {
        }

        @Override // org.tensorflow.lite.task.core.a.b.a
        public b.a a(Rect r2) {
            Objects.requireNonNull(r2, "Null roi");
            this.f40627a = r2;
            return this;
        }

        @Override // org.tensorflow.lite.task.core.a.b.a
        Rect a() {
            Rect r1 = this.f40627a;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("Property \"roi\" has not been set");
        }

        @Override // org.tensorflow.lite.task.core.a.b.a
        public b.a a(b.EnumC1100b r2) {
            Objects.requireNonNull(r2, "Null orientation");
            this.f40628b = r2;
            return this;
        }

        @Override // org.tensorflow.lite.task.core.a.b.a
        b b() {
            String r1 = "";
            if (this.f40627a != null) goto L6;
            r1 = " roi";
        L6:
            if (this.f40628b != null) goto L9;
            r1 = r1 + " orientation";
        L9:
            if (r1.isEmpty() == false) goto L13;
            return new a(this.f40627a, this.f40628b, null);
        L13:
            throw new IllegalStateException("Missing required properties:" + r1);
        }
    }

    /* synthetic */ a(Rect r1, b.EnumC1100b r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private a(Rect r1, b.EnumC1100b r2) {
        this.f40625a = r1;
        this.f40626b = r2;
    }

    @Override // org.tensorflow.lite.task.core.a.b
    public Rect a() {
        return this.f40625a;
    }

    @Override // org.tensorflow.lite.task.core.a.b
    public b.EnumC1100b b() {
        return this.f40626b;
    }

    public String toString() {
        return "ImageProcessingOptions{roi=" + this.f40625a + ", orientation=" + this.f40626b + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L14;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f40625a.equals(r6.a()) == false) goto L13;
        if (this.f40626b.equals(r6.b()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f40625a.hashCode() ^ 1000003) * 1000003;
        return this.f40626b.hashCode() ^ r0;
    }
}
