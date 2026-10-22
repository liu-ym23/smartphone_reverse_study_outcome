package com.obric.oui.color;

import android.content.res.Resources;
import com.obric.oui.graphic.BlendMode;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0192a f12867c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12868d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12870b;

    /* JADX INFO: renamed from: com.obric.oui.color.a$a, reason: collision with other inner class name */
    public static final class C0192a {
        public /* synthetic */ C0192a(DefaultConstructorMarker r10) {
            this();
        }

        public final a[] a(Resources r10, int r11) {
            kotlin.jvm.internal.q.g(r10, "resources");
            return b(r10.getIntArray(r11));
        }

        public final a[] b(int[] r10) {
            b[] r11 = b.g(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            ArrayList r12 = new ArrayList(r11.length);
            int r13 = r11.length;
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            b r15 = r11[r14];
            r12.add(new a(r15.i(), r15.h()));
            r14 = r14 + 1;
            goto L6
        L8:
            Object[] r16 = r12.toArray(new a[0]);
            if (r16 == null) goto L13;
            return (a[]) r16;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public C0192a() {
        }
    }

    static {
        f12867c = new C0192a(null);
        f12868d = new a(0, BlendMode.SRC_OVER);
    }

    public a(int r10, int r11) {
        this.f12869a = r10;
        this.f12870b = r11;
    }

    public static final a[] a(Resources r10, int r11) {
        return f12867c.a(r10, r11);
    }

    public final int b() {
        return this.f12870b;
    }

    public final int c() {
        return this.f12869a;
    }

    public final b d() {
        return new b(this.f12869a, this.f12870b);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f12869a == r11.f12869a) goto L12;
        return false;
    L12:
        if (this.f12870b == r11.f12870b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f12869a) * 31) + Integer.hashCode(this.f12870b);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("BlendConfig#");
        r10.append(hashCode());
        r10.append("(color=");
        String r11 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.f12869a)}, 1));
        kotlin.jvm.internal.q.f(r11, "format(this, *args)");
        r10.append(r11);
        r10.append(", blendMode=");
        r10.append(this.f12870b);
        r10.append(')');
        return r10.toString();
    }

    public a(int r10, BlendMode r11) {
        kotlin.jvm.internal.q.g(r11, "mode");
        this(r10, BlendMode.mapToLegacyObricBlend(r11));
    }
}
