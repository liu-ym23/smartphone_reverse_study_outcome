package com.bytedance.android.live.core.tetris.layer.view;

import j70.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@ElementConstraintDSLMarker
public final class ElementConstraint {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ElementConstraint f65822n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f65825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f65826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f65827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f65828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f65829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f65830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f65831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<c> f65832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f65833k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f65834l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f65835m;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/view/ElementConstraint$Side;", "", "", "value", "I", "getValue", "()I", "LEFT", "RIGHT", "TOP", "BOTTOM", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Side extends Enum<Side> {
        public static final Side BOTTOM = null;
        public static final Side LEFT = null;
        public static final Side RIGHT = null;
        public static final Side TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Side[] f65836a = null;
        private final int value;

        static {
            Side r100 = new Side("LEFT", 0, 1);
            LEFT = r100;
            Side r101 = new Side("RIGHT", 1, 2);
            RIGHT = r101;
            Side r102 = new Side("TOP", 2, 3);
            TOP = r102;
            Side r103 = new Side("BOTTOM", 3, 4);
            BOTTOM = r103;
            f65836a = new Side[]{r100, r101, r102, r103};
        }

        public static Side valueOf(String r100) {
            return (Side) r27.a.a(Side.class, r100);
        }

        public static Side[] values() {
            return (Side[]) f65836a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Side(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f65837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f65839c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f65839c, ((a) r100).f65839c) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            f r100 = this.f65839c;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Anchor(anchorType=" + this.f65839c + ")";
        }

        public a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "anchorType");
            this.f65839c = r100;
            f r101 = f.f497555c;
            this.f65837a = Intrinsics.areEqual(r100, f.f497556d);
            this.f65838b = Intrinsics.areEqual(r100, f.f497557e);
        }
    }

    public static final class b {
        public static ElementConstraint a() {
            return new ElementConstraint(-1.0f, -1.0f);
        }
    }

    @ElementConstraintDSLMarker
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f65841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f65843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f65844e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L16;
            c r101 = (c) r100;
            if (this.f65840a == r101.f65840a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f65841b, r101.f65841b) == true) goto L10;
            return false;
        L10:
            if (this.f65842c == r101.f65842c) goto L12;
            return false;
        L12:
            if (Float.compare(this.f65843d, r101.f65843d) == 0) goto L14;
            return false;
        L14:
            if (this.f65844e == r101.f65844e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f65840a * 31;
            a r101 = this.f65841b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return ((((((r100 + r102) * 31) + this.f65842c) * 31) + Float.floatToIntBits(this.f65843d)) * 31) + this.f65844e;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Rule(startSide=" + this.f65840a + ", anchor=" + this.f65841b + ", endSide=" + this.f65842c + ", marginDp=" + this.f65843d + ", marginPx=" + this.f65844e + ")";
        }

        public c(int r100, a r101, int r102, float r103, int r104, int r105) {
            if ((r105 & 8) == 0) goto L6;
            r103 = 0.0f;
        L6:
            if ((r105 & 16) == 0) goto L8;
            r104 = 0;
        L8:
            Intrinsics.checkNotNullParameter(r101, "anchor");
            this.f65840a = r100;
            this.f65841b = r101;
            this.f65842c = r102;
            this.f65843d = r103;
            this.f65844e = r104;
        }
    }

    @ElementConstraintDSLMarker
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f65845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f65846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f65847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f65848d;

        public static final class a {
        }

        static {
        }

        public d() {
            this.f65845a = -2.0f;
            this.f65846b = -2.0f;
        }
    }

    public ElementConstraint() {
        float r100 = 0.0f;
        this(r100, 3);
    }

    static {
        f65822n = new ElementConstraint(-2.0f, -2.0f);
    }

    public final void j(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        d r101 = new d();
        r100.invoke(r101);
        this.f65834l = r101.f65845a;
        this.f65823a = r101.f65847c;
        this.f65835m = r101.f65846b;
        this.f65824b = r101.f65848d;
    }

    public ElementConstraint(float r100, float r101) {
        this.f65834l = r100;
        this.f65835m = r101;
        this.f65831i = -1;
        this.f65832j = new ArrayList();
    }

    public final void a(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Side r102 = Side.BOTTOM;
        c(r102, r100, r102, r101);
    }

    public final void f(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Side r102 = Side.LEFT;
        c(r102, r100, r102, r101);
    }

    public final void g(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        c(Side.LEFT, r100, Side.RIGHT, r101);
    }

    public final void h(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        c(Side.RIGHT, r100, Side.LEFT, r101);
    }

    public final void i(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Side r102 = Side.RIGHT;
        c(r102, r100, r102, r101);
    }

    public final void k(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        c(Side.TOP, r100, Side.BOTTOM, r101);
    }

    public final void l(f r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Side r102 = Side.TOP;
        c(r102, r100, r102, r101);
    }

    public /* synthetic */ ElementConstraint(float r100, int r101) {
        float r102 = -2.0f;
        if ((r101 & 1) == 0) goto L6;
        r100 = -2.0f;
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = 0.0f;
    L9:
        this(r100, r102);
    }

    public ElementConstraint(int r100, int r101) {
        this(0.0f, 0.0f);
        this.f65823a = r100;
        this.f65824b = r101;
    }

    public final void d(Side r100, Side r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "startSide");
        Intrinsics.checkNotNullParameter(r101, "parentSide");
        b(r100, f.f497556d, r101, r102);
    }

    @Deprecated(message = "建议使用诸如 leftToLeft 之类的调用", replaceWith = @ReplaceWith(expression = "leftToLeft,leftToRight...", imports = {}))
    public final void e(Side r100, Side r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "startSide");
        Intrinsics.checkNotNullParameter(r110, "parentSide");
        a r101 = new a(f.f497556d);
        c r102 = new c(r100.getValue(), r101, r110.getValue(), 0.0f, r111, 8);
        ((ArrayList) this.f65832j).add(r102);
    }

    public final void b(Side r100, f r110, Side r111, float r112) {
        Intrinsics.checkNotNullParameter(r100, "startSide");
        Intrinsics.checkNotNullParameter(r110, "anchorType");
        Intrinsics.checkNotNullParameter(r111, "endSide");
        a r101 = new a(r110);
        c r113 = new c(r100.getValue(), r101, r111.getValue(), r112, 0, 16);
        ((ArrayList) this.f65832j).add(r113);
    }

    public final void c(Side r100, f r101, Side r110, Function1 r111) {
        a r102 = new a(r101);
        c r103 = new c(r100.getValue(), r102, r110.getValue(), 0.0f, 0, 24);
        if (r111 == null) goto L5;
        r111.invoke(r103);
    L5:
        ((ArrayList) this.f65832j).add(r103);
    }
}
