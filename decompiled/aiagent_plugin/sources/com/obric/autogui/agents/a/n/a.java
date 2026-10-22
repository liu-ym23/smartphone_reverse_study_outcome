package com.obric.autogui.agents.a.n;

import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ae;
import d.a.af;
import d.a.al;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.text.Normalizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f26731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f26732c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<Character> f26733d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<Character> f26734e = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final class C0671a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f26735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f26736b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0671a.class) == true) goto L8;
            return false;
        L8:
            C0671a r6 = (C0671a) ZeusTransformUtils.preCheckCast(r5, C0671a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26735a, r6.f26735a) == true) goto L12;
            return false;
        L12:
            if (this.f26736b == r6.f26736b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f26735a.hashCode() * 31) + this.f26736b.hashCode();
        }

        public String toString() {
            return "InputNodeMatch(node=" + this.f26735a + ", method=" + this.f26736b + ')';
        }

        public C0671a(e r2, b r3) {
            o.e(r2, "node");
            o.e(r3, "method");
            this.f26735a = r2;
            this.f26736b = r3;
        }

        public final e a() {
            return this.f26735a;
        }

        public final b b() {
            return this.f26736b;
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f26737a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f26738b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f26739c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f26740d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f26741e = null;
        private static final /* synthetic */ b[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final String f;

        private static final /* synthetic */ b[] b() {
            return new b[]{f26737a, f26738b, f26739c, f26740d, f26741e};
        }

        private b(String r1, int r2, String r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final String a() {
            return this.f;
        }

        static {
            f26737a = new b("EXACT_KEY", 0, "exact_key");
            f26738b = new b("RESOURCE_ID", 1, "resource_id");
            f26739c = new b("HINT", 2, "hint");
            f26740d = new b("FOCUSED", 3, "focused");
            f26741e = new b("UNIQUE_INPUT", 4, "unique_input");
            b[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f26742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f26743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f26744c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f26742a == r6.f26742a) goto L12;
            return false;
        L12:
            if (this.f26743b == r6.f26743b) goto L15;
            return false;
        L15:
            if (this.f26744c == r6.f26744c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f26742a) * 31) + Boolean.hashCode(this.f26743b)) * 31) + this.f26744c.hashCode();
        }

        public String toString() {
            return "InputTextEvaluation(matched=" + this.f26742a + ", reliable=" + this.f26743b + ", method=" + this.f26744c + ')';
        }

        public c(boolean r2, boolean r3, d r4) {
            o.e(r4, "method");
            this.f26742a = r2;
            this.f26743b = r3;
            this.f26744c = r4;
        }

        public final boolean a() {
            return this.f26742a;
        }

        public final boolean b() {
            return this.f26743b;
        }

        public final d c() {
            return this.f26744c;
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f26745a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f26746b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f26747c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f26748d = null;
        private static final /* synthetic */ d[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f26749e;

        private static final /* synthetic */ d[] b() {
            return new d[]{f26745a, f26746b, f26747c, f26748d};
        }

        private d(String r1, int r2, String r3) {
            super(r1, r2);
            this.f26749e = r3;
        }

        public final String a() {
            return this.f26749e;
        }

        static {
            f26745a = new d("EXACT", 0, "exact");
            f26746b = new d("DISPLAY_FORMATTED", 1, "display_formatted");
            f26747c = new d("NONE", 2, OProtocolTextEffectTextView.EffectNameNone);
            f26748d = new d("SENSITIVE_UNAVAILABLE", 3, "sensitive_unavailable");
            d[] r0 = b();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f26752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f26753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f26754e;
        private final boolean f;
        private final int g;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26750a, r6.f26750a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26751b, r6.f26751b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f26752c, r6.f26752c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f26753d, r6.f26753d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f26754e, r6.f26754e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.f26750a.hashCode() * 31) + this.f26751b.hashCode()) * 31) + this.f26752c.hashCode()) * 31) + this.f26753d.hashCode()) * 31) + this.f26754e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
        }

        public String toString() {
            return "NodeSnapshot(key=" + this.f26750a + ", resourceId=" + this.f26751b + ", className=" + this.f26752c + ", hint=" + this.f26753d + ", text=" + this.f26754e + ", isFocused=" + this.f + ", inputType=" + this.g + ')';
        }

        public e(String r2, String r3, String r4, String r5, String r6, boolean r7, int r8) {
            o.e(r2, "key");
            o.e(r3, "resourceId");
            o.e(r4, "className");
            o.e(r5, "hint");
            o.e(r6, "text");
            this.f26750a = r2;
            this.f26751b = r3;
            this.f26752c = r4;
            this.f26753d = r5;
            this.f26754e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final String a() {
            return this.f26750a;
        }

        public final String b() {
            return this.f26751b;
        }

        public final String c() {
            return this.f26752c;
        }

        public final String d() {
            return this.f26753d;
        }

        public final String e() {
            return this.f26754e;
        }

        public final boolean f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f26756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f26757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f26758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f26759e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26755a, r6.f26755a) == true) goto L12;
            return false;
        L12:
            if (this.f26756b == r6.f26756b) goto L15;
            return false;
        L15:
            if (this.f26757c == r6.f26757c) goto L18;
            return false;
        L18:
            if (this.f26758d == r6.f26758d) goto L21;
            return false;
        L21:
            if (this.f26759e == r6.f26759e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L44;
            return false;
        L44:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((this.f26755a.hashCode() * 31) + Integer.hashCode(this.f26756b)) * 31) + Integer.hashCode(this.f26757c)) * 31) + Integer.hashCode(this.f26758d)) * 31) + Boolean.hashCode(this.f26759e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ScrollState(key=").append(this.f26755a).append(", offset=").append(this.f26756b).append(", range=").append(this.f26757c).append(", extent=").append(this.f26758d).append(", canUp=").append(this.f26759e).append(", canDown=").append(this.f).append(", canLeft=").append(this.g).append(", canRight=").append(this.h).append(", screenLeft=").append(this.i).append(", screenTop=").append(this.j).append(", screenRight=").append(this.k).append(", screenBottom=");
            r0.append(this.l).append(')');
            return r0.toString();
        }

        public f(String r2, int r3, int r4, int r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, int r11, int r12, int r13) {
            o.e(r2, "key");
            this.f26755a = r2;
            this.f26756b = r3;
            this.f26757c = r4;
            this.f26758d = r5;
            this.f26759e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }

        public final String a() {
            return this.f26755a;
        }

        public final int b() {
            return this.f26756b;
        }

        public final int c() {
            return this.f26757c;
        }

        public final int d() {
            return this.f26758d;
        }

        public final boolean e() {
            return this.f26759e;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }

        public final int k() {
            return this.k;
        }

        public final int l() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f26760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f26761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f26762c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (this.f26760a == r6.f26760a) goto L12;
            return false;
        L12:
            if (this.f26761b == r6.f26761b) goto L15;
            return false;
        L15:
            if (o.a(this.f26762c, r6.f26762c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f26760a) * 31) + this.f26761b.hashCode()) * 31) + this.f26762c.hashCode();
        }

        public String toString() {
            return "TextFact(nodeIndex=" + this.f26760a + ", field=" + this.f26761b + ", value=" + this.f26762c + ')';
        }

        public g(int r2, h r3, String r4) {
            o.e(r3, "field");
            o.e(r4, "value");
            this.f26760a = r2;
            this.f26761b = r3;
            this.f26762c = r4;
        }

        public final int a() {
            return this.f26760a;
        }

        public final h b() {
            return this.f26761b;
        }

        public final String c() {
            return this.f26762c;
        }

        public final i d() {
            return new i(this.f26761b, this.f26762c);
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    private static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f26763a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f26764b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ h[] f26765d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f26766e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f26767c;

        private static final /* synthetic */ h[] b() {
            return new h[]{f26763a, f26764b};
        }

        private h(String r1, int r2, String r3) {
            super(r1, r2);
            this.f26767c = r3;
        }

        public final String a() {
            return this.f26767c;
        }

        static {
            f26763a = new h("TEXT", 0, "text");
            f26764b = new h("HINT", 1, "hint");
            h[] r0 = b();
            f26765d = r0;
            f26766e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static h valueOf(String r2) {
            return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
        }

        public static h[] values() {
            return (h[]) ZeusTransformUtils.preCheckCast(f26765d.clone(), h[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f26768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26769b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
            if (this.f26768a == r6.f26768a) goto L12;
            return false;
        L12:
            if (o.a(this.f26769b, r6.f26769b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f26768a.hashCode() * 31) + this.f26769b.hashCode();
        }

        public String toString() {
            return "TextFactKey(field=" + this.f26768a + ", value=" + this.f26769b + ')';
        }

        public i(h r2, String r3) {
            o.e(r2, "field");
            o.e(r3, "value");
            this.f26768a = r2;
            this.f26769b = r3;
        }
    }

    /* JADX INFO: compiled from: ActionEffectViewTreeFacts.kt */
    public /* synthetic */ class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26770a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.a.b.e.a.values().length];
            r0[com.obric.autogui.operator.a.b.e.a.f29659b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[com.obric.autogui.operator.a.b.e.a.f29660c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[com.obric.autogui.operator.a.b.e.a.f29661d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[com.obric.autogui.operator.a.b.e.a.f29662e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[com.obric.autogui.operator.a.b.e.a.f29658a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f26770a = r0;
        }
    }

    /* JADX INFO: compiled from: _Collections.kt */
    public static final class k implements ae<g, i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f26771a;

        public k(Iterable r3) {
            this.f26771a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        }

        @Override // d.a.ae
        public Iterator<g> a() {
            return this.f26771a.iterator();
        }

        @Override // d.a.ae
        public i a(g r2) {
            return ((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).d();
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class l<T> implements Comparator {
        public l() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).b().ordinal()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).b().ordinal()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class m<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f26772a;

        public m(Comparator r3) {
            this.f26772a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f26772a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).c(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).c(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    private a() {
    }

    public final List<VHNode> a(List<ViewHierarchyDump> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "viewTrees");
        List<VHNode> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        ArrayDeque r1 = new ArrayDeque();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        VHNode r2 = ((ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r7.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin")).getRootNode();
        if (r2 == null) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(r2);
        goto L4
    L8:
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        VHNode r9 = (VHNode) ZeusTransformUtils.preCheckCast(r1.removeFirst(), VHNode.class, "com.obric.aiagent.plugin");
        o.a(r9);
        r6.add(r9);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r10.hasNext() == false) goto L10;
        r1.addLast((VHNode) ZeusTransformUtils.preCheckCast(r10.next(), VHNode.class, "com.obric.aiagent.plugin"));
        goto L13
    L15:
        return r6;
    }

    public final e b(List<ViewHierarchyDump> r10) {
        List<ViewHierarchyDump> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r11), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r12.hasNext() == false) goto L27;
        Object r2 = r12.next();
        VHNode r3 = (VHNode) ZeusTransformUtils.preCheckCast(r2, VHNode.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (r3.isFocused() == true) goto L11;
    L24:
        r5 = false;
    L25:
        if (r5 == false) goto L7;
    L28:
        VHNode r13 = (VHNode) ZeusTransformUtils.preCheckCast(r2, VHNode.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L31;
        return null;
    L31:
        return a(r13);
    L11:
        if (r3.getInputType() > 0) goto L25;
        String r4 = r3.getClassName();
        String r6 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("EditText", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L25;
        String r7 = r3.getClassName();
        if (r7 == null) goto L22;
        r6 = r7;
    L22:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TextField", CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L24;
    L27:
        r2 = null;
        goto L28
    }

    public final C0671a a(List<ViewHierarchyDump> r5, e r6) {
        List<ViewHierarchyDump> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "before");
        if (r7 != null) goto L6;
        return null;
    L6:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(a(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        Object r2 = r9.next();
        if (c((VHNode) ZeusTransformUtils.preCheckCast(r2, VHNode.class, "com.obric.aiagent.plugin")) == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L14:
        if (r11.hasNext() == false) goto L17;
        VHNode r3 = (VHNode) ZeusTransformUtils.preCheckCast(r11.next(), VHNode.class, "com.obric.aiagent.plugin");
        r1.add(f26730a.a(r3));
        goto L14
    L17:
        return b((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), r6);
    }

    public final C0671a b(List<e> r11, e r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r13, "candidates");
        o.e(r12, "before");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if (o.a(((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a(), r12.a()) == false) goto L4;
    L9:
        e r1 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L12;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        Object r4 = r15.next();
        if (f26730a.a(r12, (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin")) == false) goto L15;
        r3.add(r4);
        goto L15
    L19:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (a(r12.b()) == false) goto L36;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r6 = false;
        Object r7 = null;
    L23:
        if (r10.hasNext() == false) goto L29;
        Object r8 = r10.next();
        if (o.a(((e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin")).b(), r12.b()) == false) goto L23;
        if (r6 == true) goto L30;
        r6 = true;
        r7 = r8;
    L30:
        r7 = null;
    L31:
        e r17 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L36;
        return new C0671a(r17, b.f26738b);
    L29:
        if (r6 == true) goto L31;
    L36:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.d(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L60;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r9 = false;
        Object r19 = null;
    L39:
        if (r18.hasNext() == false) goto L54;
        Object r20 = r18.next();
        e r21 = (e) ZeusTransformUtils.preCheckCast(r20, e.class, "com.obric.aiagent.plugin");
        if (o.a(r21.d(), r12.d()) == false) goto L49;
        a r22 = f26730a;
        if (r22.a(r12.b()) == true) goto L45;
    L48:
        boolean r23 = true;
    L50:
        if (r23 == false) goto L39;
        if (r9 == true) goto L55;
        r9 = true;
        r19 = r20;
    L55:
        r19 = null;
    L56:
        e r110 = (e) ZeusTransformUtils.preCheckCast(r19, e.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L60;
        return new C0671a(r110, b.f26739c);
    L45:
        if (r22.a(r21.b()) == false) goto L48;
        if (o.a(r12.b(), r21.b()) == true) goto L48;
    L49:
        r23 = false;
        goto L50
    L54:
        if (r9 == true) goto L56;
    L60:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r113 = r111.iterator();
    L62:
        if (r113.hasNext() == false) goto L80;
        Object r24 = r113.next();
        e r25 = (e) ZeusTransformUtils.preCheckCast(r24, e.class, "com.obric.aiagent.plugin");
        a r26 = f26730a;
        if (r26.a(r12.b()) == false) goto L70;
        if (r26.a(r25.b()) == false) goto L70;
        if (o.a(r12.b(), r25.b()) == true) goto L70;
    L76:
        boolean r27 = false;
    L78:
        if (r27 == false) goto L62;
        r112.add(r24);
    L70:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.d(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L72;
    L77:
        r27 = true;
        goto L78
    L72:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25.d(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L77;
        if (o.a(r12.d(), r25.d()) == false) goto L76;
    L80:
        List r114 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin");
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        Object r116 = null;
    L82:
        if (r115.hasNext() == false) goto L88;
        Object r28 = r115.next();
        if (((e) ZeusTransformUtils.preCheckCast(r28, e.class, "com.obric.aiagent.plugin")).f() == false) goto L82;
        if (r5 == true) goto L89;
        r5 = true;
        r116 = r28;
    L89:
        r116 = null;
    L90:
        e r117 = (e) ZeusTransformUtils.preCheckCast(r116, e.class, "com.obric.aiagent.plugin");
        if (r117 != null) goto L93;
        e r118 = (e) ZeusTransformUtils.preCheckCast(p.p(r114), e.class, "com.obric.aiagent.plugin");
        if (r118 != null) goto L97;
        return null;
    L97:
        return new C0671a(r118, b.f26741e);
    L93:
        return new C0671a(r117, b.f26740d);
    L88:
        if (r5 == true) goto L90;
    L12:
        return new C0671a(r1, b.f26737a);
    L8:
        r2 = null;
        goto L9
    }

    public final c a(e r4, e r5, String r6, boolean r7) {
        o.e(r4, "before");
        o.e(r5, "after");
        o.e(r6, "expectedText");
        boolean r1 = false;
        if (a(r4) == true) goto L29;
        if (a(r5) == true) goto L29;
        String r8 = c(r4.e());
        String r9 = c(r5.e());
        String r10 = c(r6);
        if (r7 == false) goto L10;
        boolean r0 = o.a(r9, r10);
    L12:
        if (r0 == false) goto L16;
        return new c(true, true, d.f26745a);
    L16:
        if (o.a(d(r10), r10) == false) goto L23;
        if (r7 == false) goto L19;
        boolean r3 = o.a(d(r9), r10);
    L20:
        if (r3 == false) goto L23;
        r1 = true;
        goto L23
    L19:
        r3 = a(d(r8), d(r9), r10);
    L23:
        if (r1 == false) goto L25;
        d r11 = d.f26746b;
    L27:
        return new c(r1, true, r11);
    L25:
        r11 = d.f26747c;
        goto L27
    L10:
        r0 = a(r8, r9, r10);
    L29:
        return new c(false, false, d.f26748d);
    }

    public final boolean a(e r2) {
        o.e(r2, "node");
        if (a(r2.g()) == false) goto L5;
    L8:
        return true;
    L5:
        if (b(r2.e()) == true) goto L8;
        return false;
    }

    public final Integer c(List<ViewHierarchyDump> r8) {
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        return null;
    L5:
        int r2 = 17;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r9), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r7.hasNext() == false) goto L45;
        VHNode r10 = (VHNode) ZeusTransformUtils.preCheckCast(r7.next(), VHNode.class, "com.obric.aiagent.plugin");
        int r3 = r2 * 31;
        String r4 = r10.getId();
        if (r4 == null) goto L11;
        int r5 = r4.hashCode();
    L12:
        int r6 = (r3 + r5) * 31;
        String r11 = r10.getClassName();
        if (r11 == null) goto L15;
        int r12 = r11.hashCode();
    L16:
        int r13 = (((((((((((r6 + r12) * 31) + r10.getBounds().toString().hashCode()) * 31) + r10.getVisibility()) * 31) + Boolean.hashCode(r10.isClickable())) * 31) + Boolean.hashCode(r10.isLongClickable())) * 31) + Boolean.hashCode(r10.isEnabled())) * 31;
        a r14 = f26730a;
        CharSequence r15 = r10.getText();
        if (r15 == null) goto L19;
        String r16 = r15.toString();
    L20:
        String r17 = "";
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        int r18 = (r13 + r14.c(r16).hashCode()) * 31;
        CharSequence r19 = r10.getHint();
        if (r19 == null) goto L26;
        String r20 = r19.toString();
    L27:
        if (r20 == null) goto L30;
        r17 = r20;
    L30:
        int r21 = ((((r18 + r14.c(r17).hashCode()) * 31) + Boolean.hashCode(r10.isFocused())) * 31) + r10.getInputType();
        if (ZeusTransformUtils.instanceOf(r10, ScrollableVTNode.class) == false) goto L33;
        ScrollableVTNode r22 = (ScrollableVTNode) ZeusTransformUtils.preCheckCast(r10, ScrollableVTNode.class, "com.obric.aiagent.plugin");
    L35:
        if (r22 != null) goto L37;
    L39:
        boolean r23 = false;
    L40:
        if (r23 == false) goto L42;
        int r24 = ((((((((((((((((r21 * 31) + Boolean.hashCode(true)) * 31) + Boolean.hashCode(r22.getScrollableVertical())) * 31) + Boolean.hashCode(r22.getScrollableHorizontal())) * 31) + Boolean.hashCode(r22.getScrollableUp())) * 31) + Boolean.hashCode(r22.getScrollableDown())) * 31) + Boolean.hashCode(r22.getScrollableLeft())) * 31) + Boolean.hashCode(r22.getScrollableRight())) * 31) + r22.getScrollableRange()) * 31;
        int r25 = r22.getScrollableExtent();
    L43:
        r2 = r24 + r25;
        goto L7
    L42:
        r24 = r21 * 31;
        r25 = Boolean.hashCode(false);
        goto L43
    L37:
        if (r22.isScrollable() != true) goto L39;
        r23 = true;
        goto L40
    L33:
        r22 = null;
        goto L35
    L26:
        r20 = null;
        goto L27
    L19:
        r16 = null;
        goto L20
    L15:
        r12 = 0;
        goto L16
    L11:
        r5 = 0;
        goto L12
    L45:
        return Integer.valueOf(r2);
    }

    public final Integer d(List<ViewHierarchyDump> r4) {
        List<ViewHierarchyDump> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        int r0 = 17;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(g(a(r5)), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new m((Comparator) ZeusTransformUtils.preCheckCast(new l(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        g r6 = (g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.aiagent.plugin");
        r0 = (((r0 * 31) + r6.b().ordinal()) * 31) + r6.c().hashCode();
        goto L8
    L11:
        return Integer.valueOf(r0);
    }

    public final String a(List<? extends VHNode> r8, List<? extends VHNode> r9) {
        List<? extends VHNode> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<? extends VHNode> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "before");
        o.e(r11, "after");
        List<g> r12 = g(r10);
        List<g> r7 = g(r11);
        Map r13 = ao.e(af.a((ae) ZeusTransformUtils.preCheckCast(new k((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")));
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r14.next(), g.class, "com.obric.aiagent.plugin");
        int r4 = f26730a.a((Integer) ZeusTransformUtils.preCheckCast(r13.get(r0.d()), Integer.class, "com.obric.aiagent.plugin"));
        if (r4 == 0) goto L8;
        if (r4 == 1) goto L10;
        r13.put(r0.d(), Integer.valueOf(r4 - 1));
        goto L4
    L10:
        r13.remove(r0.d());
        goto L4
    L8:
        return r0.a() + ':' + r0.b().a();
    L12:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();
        if (f26730a.a((Integer) ZeusTransformUtils.preCheckCast(r13.get(((g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin")).d()), Integer.class, "com.obric.aiagent.plugin")) <= 0) goto L18;
        boolean r1 = true;
    L19:
        if (r1 == false) goto L14;
    L22:
        g r17 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L25;
        return "-1:none";
    L25:
        return r17.a() + ':' + r17.b().a();
    L18:
        r1 = false;
        goto L19
    L21:
        r16 = null;
        goto L22
    }

    public final boolean e(List<ViewHierarchyDump> r9) {
        List<ViewHierarchyDump> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(a(r10), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L8;
    L10:
        Iterator r11 = r8.iterator();
    L12:
        if (r11.hasNext() == false) goto L34;
        String r12 = ((VHNode) ZeusTransformUtils.preCheckCast(r11.next(), VHNode.class, "com.obric.aiagent.plugin")).getClassName();
        if (r12 != null) goto L17;
        r12 = "";
    L17:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SurfaceView", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L19;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L12;
        return true;
    L19:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TextureView", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L24;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TouchView", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L24;
        r13 = false;
        goto L25
    L34:
        return false;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        return false;
    }

    public final List<f> f(List<ViewHierarchyDump> r21) {
        List<ViewHierarchyDump> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(a(r0), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L28;
        VHNode r4 = (VHNode) ZeusTransformUtils.preCheckCast(r2.next(), VHNode.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ScrollableVTNode.class) == false) goto L11;
        ScrollableVTNode r5 = (ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin");
    L12:
        if (r5 != null) goto L15;
    L13:
        f r6 = null;
    L25:
        if (r6 == null) goto L7;
        r3.add(r6);
        goto L7
    L15:
        if (r5.isScrollable() == false) goto L13;
        String[] r7 = new String[3];
        String r9 = r4.getId();
        String r10 = "";
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r7[0] = r9;
        String r11 = r4.getClassName();
        if (r11 == null) goto L24;
        r10 = r11;
    L24:
        r7[1] = r10;
        r7[2] = r4.getBounds().toString();
        r6 = new f(p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(r7), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("#", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null), r5.getScrollableOffset(), r5.getScrollableRange(), r5.getScrollableExtent(), r5.getScrollableUp(), r5.getScrollableDown(), r5.getScrollableLeft(), r5.getScrollableRight(), r4.getBounds().getScreenLeft(), r4.getBounds().getScreenTop(), r4.getBounds().getScreenRight(), r4.getBounds().getScreenBottom());
        goto L25
    L11:
        r5 = null;
        goto L12
    L28:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final f a(List<ViewHierarchyDump> r9, com.obric.autogui.operator.a.b.e.a r10, Float r11, Float r12) {
        Collection r8 = f((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"));
        Object r13 = null;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r11 == null) goto L25;
        if (r12 == null) goto L25;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L23;
        Object r3 = r15.next();
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
        if (r11.floatValue() >= r4.i()) goto L14;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L10;
        r2.add(r3);
        goto L10
    L14:
        if (r11.floatValue() > r4.k()) goto L20;
        if (r12.floatValue() < r4.j()) goto L20;
        if (r12.floatValue() > r4.l()) goto L20;
        r5 = true;
        goto L21
    L23:
        r8 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L25:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L28;
        r8 = null;
    L28:
        if (r8 != null) goto L30;
        return null;
    L30:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L32:
        if (r18.hasNext() == false) goto L36;
        Object r0 = r18.next();
        if (f26730a.a((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin"), r10) == false) goto L32;
        r17.add(r0);
        goto L32
    L36:
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        if (r19.isEmpty() == true) goto L40;
        r8 = r19;
    L40:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r20.hasNext() == false) goto L53;
        r13 = r20.next();
        if (r20.hasNext() == false) goto L53;
        f r110 = (f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin");
        long r111 = n.a(r110.k() - r110.i(), 0) * n.a(r110.l() - r110.j(), 0);
    L47:
        Object r112 = r20.next();
        f r1 = (f) ZeusTransformUtils.preCheckCast(r112, f.class, "com.obric.aiagent.plugin");
        long r6 = n.a(r1.k() - r1.i(), 0) * n.a(r1.l() - r1.j(), 0);
        if (r111 <= r6) goto L51;
        r13 = r112;
        r111 = r6;
    L51:
        if (r20.hasNext() == true) goto L47;
    L53:
        return (f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(f r2, com.obric.autogui.operator.a.b.e.a r3) {
        o.e(r2, "<this>");
        if (r3 != null) goto L5;
        int r4 = -1;
    L7:
        if (r4 == (-1)) goto L25;
        if (r4 == 1) goto L38;
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L36;
        if (r4 == 4) goto L35;
        if (r4 == 5) goto L25;
        throw new d.k();
    L35:
        return r2.g();
    L36:
        return r2.h();
    L37:
        return r2.e();
    L38:
        return r2.f();
    L25:
        if (r2.e() == false) goto L27;
        return true;
    L27:
        if (r2.f() == false) goto L29;
        return true;
    L29:
        if (r2.g() == false) goto L31;
        return true;
    L31:
        if (r2.h() == true) goto L42;
        return false;
    L42:
        return true;
    L5:
        r4 = j.f26770a[r3.ordinal()];
        goto L7
    }

    private final e a(VHNode r10) {
        VHNode r11 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r10, VHNode.class, "com.obric.aiagent.plugin");
        String r1 = b(r11);
        String r9 = r11.getId();
        if (r9 != null) goto L5;
        String r2 = "";
    L6:
        String r12 = r11.getClassName();
        if (r12 != null) goto L9;
        String r3 = "";
    L10:
        CharSequence r13 = r11.getHint();
        String r4 = null;
        if (r13 == null) goto L13;
        String r14 = r13.toString();
    L14:
        if (r14 != null) goto L16;
        r14 = "";
    L16:
        CharSequence r5 = r11.getText();
        if (r5 == null) goto L19;
        r4 = r5.toString();
    L19:
        if (r4 != null) goto L21;
        String r6 = "";
    L23:
        return new e(r1, r2, r3, r14, r6, r11.isFocused(), r11.getInputType());
    L21:
        r6 = r4;
        goto L23
    L13:
        r14 = null;
        goto L14
    L9:
        r3 = r12;
        goto L10
    L5:
        r2 = r9;
        goto L6
    }

    private final String b(VHNode r11) {
        VHNode r10 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r11, VHNode.class, "com.obric.aiagent.plugin");
        String[] r12 = new String[3];
        String r1 = r10.getId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r12[0] = r1;
        String r3 = r10.getClassName();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r12[1] = r2;
        r12[2] = r10.getBounds().toString();
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(r12), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("#", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    private final boolean c(VHNode r6) {
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r6, VHNode.class, "com.obric.aiagent.plugin");
        if (r5.getInputType() > 0) goto L18;
        String r7 = r5.getClassName();
        String r2 = "";
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("EditText", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L19;
        String r8 = r5.getClassName();
        if (r8 == null) goto L14;
        r2 = r8;
    L14:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TextField", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L20;
        return false;
    L20:
        return true;
    L19:
        return true;
    L18:
        return true;
    }

    private final boolean a(e r5, e r6) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L9:
        int r4 = r5.g() & 15;
        int r7 = r6.g() & 15;
        if (r4 == 0) goto L16;
        if (r7 == 0) goto L17;
        if (r4 != r7) goto L15;
        return true;
    L15:
        return false;
    L17:
        return true;
    L16:
        return true;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        if (o.a(r5.c(), r6.c()) == true) goto L9;
        return false;
    }

    private final boolean a(String r2) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return false;
    L6:
        Set<String> r1 = f26732c;
        String r3 = r2.toLowerCase(Locale.ROOT);
        o.c(r3, "toLowerCase(...)");
        return !r1.contains(r3);
    }

    private final boolean a(int r4) {
        int r3 = r4 & 15;
        int r5 = r4 & 4080;
        if (r3 != 1) goto L7;
        if (f26731b.contains(Integer.valueOf(r5)) == false) goto L7;
        return true;
    L7:
        if (r3 == 2) goto L9;
    L11:
        return false;
    L9:
        if (r5 != 16) goto L11;
        return true;
    }

    private final boolean b(String r7) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        return false;
    L8:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r3 = 0;
    L10:
        if (r3 >= r8.length()) goto L21;
        char r4 = r8.charAt(r3);
        if (d.o.a.a(r4) == false) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L19;
        r3 = r3 + 1;
        goto L10
    L19:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L34;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r11 = 0;
    L25:
        if (r11 >= r10.length()) goto L30;
        if (f26733d.contains(Character.valueOf(r10.charAt(r11))) == true) goto L28;
        r11 = r11 + 1;
        goto L25
    L28:
        boolean r12 = true;
    L31:
        if (r12 == false) goto L34;
        return true;
    L30:
        r12 = false;
    L34:
        return false;
    L14:
        if (f26733d.contains(Character.valueOf(r4)) == true) goto L17;
        r5 = false;
        goto L18
    L21:
        r9 = true;
        goto L22
    L5:
        r6 = false;
        goto L6
    }

    private final String c(String r13) {
        String r0 = Normalizer.normalize((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), Normalizer.Form.NFKC);
        o.c(r0, "normalize(...)");
        return d.o.o.a(d.o.o.a(r0, "\r\n", "\n", false, 4, null), '\r', '\n', false, 4, null);
    }

    private final List<g> g(List<? extends VHNode> r13) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List<g> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
    L4:
        if (r15.hasNext() == false) goto L34;
        Object r3 = r15.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        p.c();
    L8:
        VHNode r5 = (VHNode) ZeusTransformUtils.preCheckCast(r3, VHNode.class, "com.obric.aiagent.plugin");
        a r6 = f26730a;
        CharSequence r7 = r5.getText();
        String r8 = null;
        if (r7 == null) goto L11;
        String r9 = r7.toString();
    L12:
        String r10 = "";
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        String r11 = r6.c(r9);
        boolean r16 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L21;
        r14.add(new g(r2, h.f26763a, r11));
    L21:
        CharSequence r18 = r5.getHint();
        if (r18 == null) goto L24;
        r8 = r18.toString();
    L24:
        if (r8 == null) goto L27;
        r10 = r8;
    L27:
        String r19 = r6.c(r10);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L31;
        r16 = false;
    L31:
        if (r16 == false) goto L33;
        r14.add(new g(r2, h.f26764b, r19));
    L33:
        r2 = r4;
        goto L4
    L18:
        r17 = false;
        goto L19
    L11:
        r9 = null;
        goto L12
    L34:
        return r14;
    }

    private final int a(Integer r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.intValue();
    }

    private final boolean a(String r13, String r14, String r15) {
        if (r14.length() == (r13.length() + r15.length())) goto L5;
        return false;
    L5:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(new d.l.j(0, r13.length()), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L8;
    L10:
        Iterator r16 = r12.iterator();
    L12:
        if (r16.hasNext() == false) goto L30;
        int r0 = ((al) ZeusTransformUtils.preCheckCast(r16, al.class, "com.obric.aiagent.plugin")).a();
        if (d.o.o.a(r14, 0, r13, 0, r0, false, 16, null) == true) goto L16;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L12;
        return true;
    L16:
        if (d.o.o.a(r14, r0, r15, 0, r15.length(), false, 16, null) == false) goto L20;
        if (d.o.o.a(r14, r0 + r15.length(), r13, r0, r13.length() - r0, false, 16, null) == false) goto L20;
        r1 = true;
        goto L21
    L30:
        return false;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        return false;
    }

    static {
        f26730a = new a();
        f26731b = ax.a(new Integer[]{128, 144, 224});
        f26732c = ax.a(new String[]{"null", "no_id", OProtocolTextEffectTextView.EffectNameNone, "-1", "0"});
        f26733d = ax.a(new Character[]{'*', (char) 8226, (char) 9679, (char) 183, (char) 8729, (char) 9702, (char) 9642});
        f26734e = ax.a(new Character[]{'-', (char) 8208, (char) 8209, (char) 8210, (char) 8211, (char) 8212, '(', ')', '[', ']', ',', (char) 65292, '/', (char) 65295, ':', (char) 65306});
    }

    private final String d(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        Appendable r8 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.aiagent.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r6.length()) goto L19;
        char r3 = r6.charAt(r2);
        if (d.o.a.a(r3) == false) goto L8;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        r8.append(r3);
    L18:
        r2 = r2 + 1;
        goto L4
    L8:
        if (f26734e.contains(Character.valueOf(r3)) == true) goto L15;
        if (Character.getType(r3) == 26) goto L15;
        if (Character.getType(r3) == 16) goto L15;
        r4 = false;
        goto L16
    L19:
        String r9 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r8, StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        o.c(r9, "toString(...)");
        return r9;
    }
}
