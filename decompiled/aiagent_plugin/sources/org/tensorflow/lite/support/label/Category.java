package org.tensorflow.lite.support.label;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class Category {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f40614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f40617d;

    public static Category create(String r1, String r2, float r3, int r4) {
        return new Category(r1, r2, r3, r4);
    }

    public static Category create(String r2, String r3, float r4) {
        return new Category(r2, r3, r4, -1);
    }

    public Category(String r3, float r4) {
        this(r3, "", r4, -1);
    }

    private Category(String r1, String r2, float r3, int r4) {
        this.f40615b = r1;
        this.f40616c = r2;
        this.f40617d = r3;
        this.f40614a = r4;
    }

    public String a() {
        return this.f40615b;
    }

    public String b() {
        return this.f40616c;
    }

    public float c() {
        return this.f40617d;
    }

    public int d() {
        return this.f40614a;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Category.class) == false) goto L14;
        Category r5 = (Category) ZeusTransformUtils.preCheckCast(r4, Category.class, "com.obric.aiagent.plugin");
        if (r5.a().equals(this.f40615b) == true) goto L7;
        return false;
    L7:
        if (r5.b().equals(this.f40616c) == true) goto L9;
        return false;
    L9:
        if (Math.abs(r5.c() - this.f40617d) < 1.0E-6f) goto L11;
        return false;
    L11:
        if (r5.d() != this.f40614a) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f40615b, this.f40616c, Float.valueOf(this.f40617d), Integer.valueOf(this.f40614a)});
    }

    public String toString() {
        return "<Category \"" + this.f40615b + "\" (displayName=" + this.f40616c + " score=" + this.f40617d + " index=" + this.f40614a + ")>";
    }
}
