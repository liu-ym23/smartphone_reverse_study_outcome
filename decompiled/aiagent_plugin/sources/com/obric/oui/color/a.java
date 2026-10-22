package com.obric.oui.color;

import android.content.res.Resources;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: BlendConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0935a f34496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f34497b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34499d;

    /* JADX INFO: renamed from: com.obric.oui.color.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BlendConfig.kt */
    public static final class C0935a {
        public /* synthetic */ C0935a(h r1) {
            this();
        }

        private C0935a() {
        }

        public final a[] a(int[] r8) {
            b[] r7 = b.a(r8);
            if (r7 != null) goto L5;
            return null;
        L5:
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.aiagent.plugin");
            int r0 = r7.length;
            int r3 = 0;
        L6:
            if (r3 >= r0) goto L8;
            b r4 = r7[r3];
            r9.add(new a(r4.a(), r4.b()));
            r3 = r3 + 1;
            goto L6
        L8:
            Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new a[0]);
            Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (a[]) ZeusTransformUtils.preCheckCast(r10, a[].class, "com.obric.aiagent.plugin");
        }

        public final a[] a(Resources r2, int r3) {
            o.e(r2, "resources");
            return a(r2.getIntArray(r3));
        }
    }

    public static final a[] a(Resources r1, int r2) {
        return f34496a.a(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f34498c == r6.f34498c) goto L12;
        return false;
    L12:
        if (this.f34499d == r6.f34499d) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f34498c) * 31) + Integer.hashCode(this.f34499d);
    }

    public a(int r1, int r2) {
        this.f34498c = r1;
        this.f34499d = r2;
    }

    public final int a() {
        return this.f34498c;
    }

    public final int b() {
        return this.f34499d;
    }

    public a(int r2, com.obric.oui.a.a r3) {
        o.e(r3, "mode");
        this(r2, com.obric.oui.a.a.a(r3));
    }

    public final b c() {
        return new b(this.f34498c, this.f34499d);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("BlendConfig#").append(hashCode()).append("(color=");
        String r1 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.f34498c)}, 1));
        o.c(r1, "format(this, *args)");
        return r0.append(r1).append(", blendMode=").append(this.f34499d).append(')').toString();
    }

    static {
        f34496a = new C0935a(null);
        f34497b = new a(0, com.obric.oui.a.a.f33929d);
    }
}
