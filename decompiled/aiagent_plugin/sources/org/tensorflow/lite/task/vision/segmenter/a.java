package org.tensorflow.lite.task.vision.segmenter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_ColoredLabel.java */
/* JADX INFO: loaded from: classes5.dex */
final class a extends ColoredLabel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f40674c;

    a(String r2, String r3, int r4) {
        Objects.requireNonNull(r2, "Null label");
        this.f40672a = r2;
        Objects.requireNonNull(r3, "Null displayName");
        this.f40673b = r3;
        this.f40674c = r4;
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public String a() {
        return this.f40672a;
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public String b() {
        return this.f40673b;
    }

    @Override // org.tensorflow.lite.task.vision.segmenter.ColoredLabel
    public int c() {
        return this.f40674c;
    }

    public String toString() {
        return "ColoredLabel{label=" + this.f40672a + ", displayName=" + this.f40673b + ", argb=" + this.f40674c + "}";
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ColoredLabel.class) == false) goto L16;
        ColoredLabel r6 = (ColoredLabel) ZeusTransformUtils.preCheckCast(r5, ColoredLabel.class, "com.obric.aiagent.plugin");
        if (this.f40672a.equals(r6.a()) == false) goto L15;
        if (this.f40673b.equals(r6.b()) == false) goto L15;
        if (this.f40674c != r6.c()) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = (((this.f40672a.hashCode() ^ 1000003) * 1000003) ^ this.f40673b.hashCode()) * 1000003;
        return this.f40674c ^ r0;
    }
}
