package pd;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.TextSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.s;
import kotlin.collections.t;
import od.c;
import od.d;
import od.e;
import od.f;
import od.g;
import od.h;
import od.i;
import od.j;
import od.k;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final od.a.b f23455b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final od.a.b f23456c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final od.a.b f23457d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final od.a.C0327a f23458e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final od.a.C0327a f23459f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final od.a.C0327a f23460g = null;

    static {
        f23454a = new a();
        f23455b = new od.a.b(0.33f, 0.0f, 0.67f, 1.0f);
        f23456c = new od.a.b(0.42f, 0.0f, 0.58f, 1.0f);
        f23457d = new od.a.b(0.26f, 0.0f, 0.6f, 0.2f);
        f23458e = new od.a.C0327a(0, 0.0f, 0.0f, 1, null);
        f23459f = new od.a.C0327a(0, 0.4f, 0.0f, 1, null);
        f23460g = new od.a.C0327a(0, 0.3f, 0.0f, 1, null);
    }

    public a() {
    }

    public static /* synthetic */ od.b.C0328b b(a r10, String r11, TextSource r12, List r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = t.i();
    L6:
        return r10.a(r11, r12, r13);
    }

    public static /* synthetic */ i d(a r10, Pair[] r11, od.a r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = f23456c;
    L6:
        return r10.c(r11, r12);
    }

    public static /* synthetic */ od.b.a g(a r10, long r11, long r12, float r13, float r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L5;
        r13 = -0.7f;
    L5:
        float r17 = r13;
        if ((r15 & 8) == 0) goto L9;
        r14 = 1.0f;
    L9:
        return r10.f(r11, r12, r17, r14);
    }

    public static /* synthetic */ i l(a r10, Pair[] r11, Direction r12, Direction r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = r12;
    L6:
        return r10.k(r11, r12, r13);
    }

    public static /* synthetic */ i n(a r10, Pair[] r11, od.a r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = f23456c;
    L6:
        return r10.m(r11, r12);
    }

    public static /* synthetic */ k u(a r10, boolean r11, float r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = 0.0f;
    L9:
        return r10.t(r11, r12);
    }

    public static /* synthetic */ i w(a r10, Pair[] r11, od.a r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = f23456c;
    L6:
        return r10.v(r11, r12);
    }

    public static /* synthetic */ i y(a r10, Pair[] r11, od.a r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = f23456c;
    L6:
        return r10.x(r11, r12);
    }

    public final od.b.C0328b a(String r10, TextSource r11, List r12) {
        return new od.b.C0328b(r10, r11, e.b.f22578a, null, r12, 8, null);
    }

    public final i c(Pair[] r10, od.a r11) {
        return e(EffectProperty.BlurRadius, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }

    public final i e(EffectProperty r10, od.a r11, Pair... r12) {
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        Pair r16 = r12[r15];
        r13.add(new f(((Number) r16.getFirst()).longValue(), new d.a(((Number) r16.getSecond()).floatValue())));
        r15 = r15 + 1;
        goto L3
    L6:
        return new i(r10, r13, r11, null, 8, null);
    }

    public final od.b.a f(long r11, long r13, float r15, float r16) {
        return p("enter_indicator", "enterScanIndicator", Direction.LeftToRight, r11, r13, r15, r16);
    }

    public final od.b.a h(long r11, long r13) {
        return p("exit_indicator", "exitScanIndicator", Direction.RightToLeft, r11, r13, -0.7f, 1.0f);
    }

    public final i i(EffectProperty r10, od.a r11, Pair... r12) {
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        Pair r16 = r12[r15];
        r13.add(new f(((Number) r16.getFirst()).longValue(), new d.b(((Number) r16.getSecond()).floatValue())));
        r15 = r15 + 1;
        goto L3
    L6:
        return new i(r10, r13, r11, null, 8, null);
    }

    public final k j(boolean r25) {
        long r17 = Math.max(1250, 1450);
        TextSource r10 = TextSource.Current;
        Float r12 = Float.valueOf(0.03f);
        Pair r11 = kotlin.d.a(150L, r12);
        Float r13 = Float.valueOf(0.0f);
        i r14 = w(this, new Pair[]{r11, kotlin.d.a(1250L, r13)}, null, 2, null);
        Float r15 = Float.valueOf(-0.5f);
        Pair r16 = kotlin.d.a(0L, r15);
        Float r18 = Float.valueOf(1.0f);
        Pair[] r19 = {r16, kotlin.d.a(1250L, r18)};
        Direction r110 = Direction.LeftToRight;
        od.b.C0328b r111 = a("generate_scan_base_text", r10, t.l(new i[]{r14, l(this, r19, r110, null, 4, null)}));
        Float r20 = Float.valueOf(0.8f);
        List r21 = t.n(new od.b[]{r111, o("generate_scan_text", r10, t.l(new i[]{n(this, new Pair[]{kotlin.d.a(0L, r20), kotlin.d.a(750L, r20), kotlin.d.a(1450L, r13)}, null, 2, null), w(this, new Pair[]{kotlin.d.a(150L, r12), kotlin.d.a(1400L, r13)}, null, 2, null), l(this, new Pair[]{kotlin.d.a(0L, r15), kotlin.d.a(1250L, r18)}, r110, null, 4, null)}))});
        if (r25 == false) goto L6;
        r21.add(f(0, 1250, -0.4f, 1.0f));
    L6:
        return new k("oui.dim_point.generate", 0, r17, null, t.n(new c[]{new c("generate_enter", 0, r17, r21)}), 10, null);
    }

    public final i k(Pair[] r10, Direction r11, Direction r12) {
        EffectProperty r13 = EffectProperty.GradientAlphaScan;
        ArrayList r14 = new ArrayList(r10.length);
        int r15 = r10.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L6;
        Pair r17 = r10[r16];
        r14.add(new f(((Number) r17.getFirst()).longValue(), new d.b(((Number) r17.getSecond()).floatValue())));
        r16 = r16 + 1;
        goto L3
    L6:
        return new i(r13, r14, f23456c, new j.b(r11, r12, 0.3f, 16.0f));
    }

    public final i m(Pair[] r10, od.a r11) {
        return i(EffectProperty.Alpha, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }

    public final od.b.C0328b o(String r10, TextSource r11, List r12) {
        b r13 = b.f23461a;
        return new od.b.C0328b(r10, r11, new e.a(r13.a(), r13.b()), BlendSpec.SCREEN, r12);
    }

    public final od.b.a p(String r16, String r17, Direction r18, long r19, long r21, float r23, float r24) {
        d.C0329d r10 = new d.C0329d(r23);
        d.C0329d r11 = new d.C0329d(r24);
        List r12 = s.c();
        if (r19 <= 0) goto L5;
        r12.add(new f(0, new d.b(0.0f)));
        r12.add(new f(r19, new d.b(0.0f)));
    L5:
        r12.add(new f(r19, new d.b(1.0f)));
        long r13 = r19 + r21;
        r12.add(new f(r13 - 1, new d.b(0.0f)));
        List r14 = s.a(r12);
        List r15 = s.c();
        if (r19 <= 0) goto L8;
        r15.add(new f(0, r10));
    L8:
        r15.add(new f(r19, r10));
        r15.add(new f(r13, r11));
        List r20 = s.a(r15);
        return new od.b.a(r16, r17, new h(r18), t.l(new i[]{new i(EffectProperty.Visibility, r14, od.a.c.f22556a, null, 8, null), new i(EffectProperty.TranslationX, r20, f23456c, null, 8, null)}));
    }

    public final k q() {
        g.a r10 = g.a.f22581a;
        TextSource r11 = TextSource.Current;
        od.b.C0328b r12 = b(this, "base_text", r11, null, 4, null);
        Float r13 = Float.valueOf(0.0f);
        return new k("oui.dim_point.pending", 0, 1500, r10, s.e(new c("pending_breath", 0, 1500, t.l(new od.b.C0328b[]{r12, o("gradient_overlay", r11, s.e(n(this, new Pair[]{kotlin.d.a(0L, r13), kotlin.d.a(750L, Float.valueOf(0.8f)), kotlin.d.a(1500L, r13)}, null, 2, null)))}))), 2, null);
    }

    public final i r() {
        return i(EffectProperty.Alpha, f23457d, new Pair[]{kotlin.d.a(0L, Float.valueOf(1.0f)), kotlin.d.a(150L, Float.valueOf(0.0f))});
    }

    public final k s() {
        return new k("oui.dim_point.prompt_pending_exit", 0, 150, null, s.e(new c("prompt_pending_exit", 0, 150, s.e(a("prompt_text_exit", TextSource.Current, s.e(r()))))), 10, null);
    }

    public final k t(boolean r32, float r33) {
        long r21 = Math.max(Math.max(1250, 1450), Math.max(600, Math.max(600, 600)));
        TextSource r14 = TextSource.Old;
        Float r10 = Float.valueOf(0.0f);
        Pair r11 = kotlin.d.a(0L, r10);
        Float r12 = Float.valueOf(16.0f);
        i r13 = d(this, new Pair[]{r11, kotlin.d.a(600L, r12)}, null, 2, null);
        Pair r15 = kotlin.d.a(0L, r10);
        Float r16 = Float.valueOf(3.0f);
        i r17 = y(this, new Pair[]{r15, kotlin.d.a(600L, r16)}, null, 2, null);
        Float r18 = Float.valueOf(-0.4f);
        Pair r19 = kotlin.d.a(0L, r18);
        Pair r20 = kotlin.d.a(50L, r18);
        Float r22 = Float.valueOf(1.0f);
        Pair[] r23 = {r19, r20, kotlin.d.a(600L, r22)};
        Direction r110 = Direction.RightToLeft;
        List r24 = t.n(new od.b[]{a("old_text_exit", r14, t.l(new i[]{r13, r17, l(this, r23, r110, null, 4, null)}))});
        Float r25 = Float.valueOf(0.8f);
        if (r33 <= 0.001f) goto L5;
        od.a r26 = null;
        Float r111 = r10;
        List r112 = r24;
        r112.add(o("old_gradient_exit", r14, t.l(new i[]{n(this, new Pair[]{kotlin.d.a(0L, Float.valueOf(bg.h.j(r33, 0.0f, 0.8f))), kotlin.d.a(600L, Float.valueOf(bg.h.j(r33, 0.0f, 0.8f)))}, null, 2, null), d(this, new Pair[]{kotlin.d.a(0L, r10), kotlin.d.a(600L, r12)}, null, 2, null), y(this, new Pair[]{kotlin.d.a(0L, r10), kotlin.d.a(600L, r16)}, null, 2, null), l(this, new Pair[]{kotlin.d.a(0L, r18), kotlin.d.a(600L, r22)}, r110, null, 4, null)})));
    L6:
        TextSource r27 = TextSource.New;
        i r28 = w(this, new Pair[]{kotlin.d.a(150L, Float.valueOf(0.03f)), kotlin.d.a(1400L, r111)}, r26, 2, r26);
        Pair[] r29 = {kotlin.d.a(0L, Float.valueOf(-0.5f)), kotlin.d.a(1250L, r22)};
        Direction r113 = Direction.LeftToRight;
        List r30 = t.n(new od.b[]{a("new_text_enter_base", r27, t.l(new i[]{r28, l(this, r29, r113, null, 4, null)})), o("new_text_enter", r27, t.l(new i[]{n(this, new Pair[]{kotlin.d.a(0L, r25), kotlin.d.a(750L, r25), kotlin.d.a(1450L, r111)}, r26, 2, r26), w(this, new Pair[]{kotlin.d.a(150L, Float.valueOf(0.03f)), kotlin.d.a(1400L, r111)}, r26, 2, r26), l(this, new Pair[]{kotlin.d.a(0L, Float.valueOf(-0.5f)), kotlin.d.a(1250L, r22)}, r113, null, 4, null)}))});
        if (r32 == false) goto L10;
        r112.add(h(0, 600));
        r30.add(g(this, 0, 1250, 0.0f, 0.0f, 12, null));
    L10:
        return new k("oui.dim_point.rewrite", 0, r21, null, t.n(new c[]{new c("rewrite", 0, r21, b0.n0(r112, r30))}), 10, null);
    L5:
        r112 = r24;
        r111 = r10;
        r26 = null;
        goto L6
    }

    public final i v(Pair[] r10, od.a r11) {
        return i(EffectProperty.Tracking, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }

    public final i x(Pair[] r10, od.a r11) {
        return e(EffectProperty.TranslationX, r11, (Pair[]) Arrays.copyOf(r10, r10.length));
    }
}
