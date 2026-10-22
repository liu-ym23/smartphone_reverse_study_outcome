package com.obric.oui.markdown;

import android.content.Context;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: OMarkdownStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, Object> f35448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Object> f35449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, Object> f35450e;
    private final HashMap<String, Object> f;
    private final HashMap<String, Object> g;
    private final HashMap<String, Object> h;
    private final HashMap<String, Object> i;
    private final HashMap<String, Object> j;
    private final HashMap<String, Object> k;
    private final HashMap<String, Object> l;
    private final HashMap<String, Object> m;
    private final HashMap<String, Object> n;
    private final HashMap<String, Object> o;
    private final HashMap<String, Object> p;
    private final HashMap<String, Object> q;
    private final HashMap<String, Object> r;
    private boolean s;
    private int t;
    private boolean u;
    private int v;
    private int w;
    private int x;

    /* JADX INFO: compiled from: OMarkdownStyle.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        f35446a = new a(null);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L53;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f35447b, r4.f35447b) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f35448c, r4.f35448c) == true) goto L11;
        return false;
    L11:
        if (o.a(this.f35449d, r4.f35449d) == true) goto L13;
        return false;
    L13:
        if (o.a(this.f35450e, r4.f35450e) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f, r4.f) == true) goto L17;
        return false;
    L17:
        if (o.a(this.g, r4.g) == true) goto L19;
        return false;
    L19:
        if (o.a(this.h, r4.h) == true) goto L21;
        return false;
    L21:
        if (o.a(this.i, r4.i) == true) goto L23;
        return false;
    L23:
        if (o.a(this.j, r4.j) == true) goto L25;
        return false;
    L25:
        if (o.a(this.k, r4.k) == true) goto L27;
        return false;
    L27:
        if (o.a(this.l, r4.l) == true) goto L29;
        return false;
    L29:
        if (o.a(this.m, r4.m) == true) goto L31;
        return false;
    L31:
        if (o.a(this.n, r4.n) == true) goto L33;
        return false;
    L33:
        if (o.a(this.o, r4.o) == true) goto L35;
        return false;
    L35:
        if (o.a(this.p, r4.p) == true) goto L37;
        return false;
    L37:
        if (o.a(this.q, r4.q) == true) goto L39;
        return false;
    L39:
        if (o.a(this.r, r4.r) == true) goto L41;
        return false;
    L41:
        if (this.s == r4.s) goto L43;
        return false;
    L43:
        if (this.t == r4.t) goto L45;
        return false;
    L45:
        if (this.u == r4.u) goto L47;
        return false;
    L47:
        if (this.v == r4.v) goto L49;
        return false;
    L49:
        if (this.w == r4.w) goto L51;
        return false;
    L51:
        if (this.x == r4.x) goto L80;
        return false;
    L80:
        return true;
    L53:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    public int hashCode() {
        Context r0 = this.f35447b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HashMap<String, Object> r4 = this.f35448c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, Object> r7 = this.f35449d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, Object> r10 = this.f35450e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        HashMap<String, Object> r13 = this.f;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        HashMap<String, Object> r16 = this.g;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        HashMap<String, Object> r19 = this.h;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        HashMap<String, Object> r22 = this.i;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        HashMap<String, Object> r25 = this.j;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        HashMap<String, Object> r28 = this.k;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        HashMap<String, Object> r31 = this.l;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        HashMap<String, Object> r34 = this.m;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        HashMap<String, Object> r37 = this.n;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        HashMap<String, Object> r40 = this.o;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        HashMap<String, Object> r43 = this.p;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        HashMap<String, Object> r46 = this.q;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        HashMap<String, Object> r49 = this.r;
        if (r49 == null) goto L69;
        r1 = r49.hashCode();
    L69:
        int r50 = (r48 + r1) * 31;
        boolean r51 = this.s;
        ?? r52 = 1;
        ?? r53 = r51;
        if (r51 == false) goto L72;
        r53 = 1;
    L72:
        int r54 = (((r50 + r53) * 31) + Integer.hashCode(this.t)) * 31;
        boolean r55 = this.u;
        if (r55 == true) goto L77;
        r52 = r55;
    L77:
        return ((((((r54 + r52) * 31) + Integer.hashCode(this.v)) * 31) + Integer.hashCode(this.w)) * 31) + Integer.hashCode(this.x);
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "OMarkdownStyle(context=" + this.f35447b + ", normalText=" + this.f35448c + ", h1=" + this.f35449d + ", h2=" + this.f35450e + ", h3=" + this.f + ", h4=" + this.g + ", h5=" + this.h + ", h6=" + this.i + ", link=" + this.j + ", inlineCode=" + this.k + ", codeBlock=" + this.l + ", quote=" + this.m + ", orderedList=" + this.n + ", unorderedList=" + this.o + ", ref=" + this.p + ", table=" + this.q + ", tableCell=" + this.r + ", enableTypewriter=" + this.s + ", animationVelocity=" + this.t + ", typewriterAutoHeight=" + this.u + ", imageRadius=" + this.v + ", imageTextSpaceTop=" + this.w + ", imageTextSpaceBottom=" + this.x + ")";
    }

    public d(Context r18, HashMap<String, Object> r19, HashMap<String, Object> r20, HashMap<String, Object> r21, HashMap<String, Object> r22, HashMap<String, Object> r23, HashMap<String, Object> r24, HashMap<String, Object> r25, HashMap<String, Object> r26, HashMap<String, Object> r27, HashMap<String, Object> r28, HashMap<String, Object> r29, HashMap<String, Object> r30, HashMap<String, Object> r31, HashMap<String, Object> r32, HashMap<String, Object> r33, HashMap<String, Object> r34, boolean r35, int r36, boolean r37, int r38, int r39, int r40) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        o.e(r0, "context");
        o.e(r19, "normalText");
        o.e(r20, "h1");
        o.e(r21, "h2");
        o.e(r22, "h3");
        o.e(r23, "h4");
        o.e(r24, "h5");
        o.e(r25, "h6");
        o.e(r26, "link");
        o.e(r27, "inlineCode");
        o.e(r28, "codeBlock");
        o.e(r29, "quote");
        o.e(r30, "orderedList");
        o.e(r31, "unorderedList");
        o.e(r32, "ref");
        o.e(r33, "table");
        o.e(r34, "tableCell");
        this.f35447b = ZeusTransformUtils.wrapperContext(r0, "com.obric.aiagent.plugin");
        this.f35448c = r19;
        this.f35449d = r20;
        this.f35450e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
    }

    public final Context getContext() {
        return this.f35447b;
    }

    public final HashMap<String, Object> b() {
        return this.f35448c;
    }

    public /* synthetic */ d(Context r20, HashMap r21, HashMap r22, HashMap r23, HashMap r24, HashMap r25, HashMap r26, HashMap r27, HashMap r28, HashMap r29, HashMap r30, HashMap r31, HashMap r32, HashMap r33, HashMap r34, HashMap r35, HashMap r36, boolean r37, int r38, boolean r39, int r40, int r41, int r42, int r43, h r44) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        if ((r43 & 2) == 0) goto L5;
        HashMap r2 = new HashMap();
        r2.put("fontSize", 16);
        r2.put("lineHeight", 26);
        r2.put("paragraphSpace", 24);
        r2.put("color", e.a(r1, ZeusTransformUtils.mapRes(R.color.markdown_text_default_color, "color", "markdown_text_default_color")));
        x r11 = x.f38692a;
    L6:
        int r12 = 12;
        if ((r43 & 4) == 0) goto L9;
        HashMap r13 = new HashMap();
        r13.put("fontSize", 24);
        r13.put("lineHeight", 34);
        r13.put("paragraphSpace", 12);
        x r14 = x.f38692a;
    L11:
        if ((r43 & 8) == 0) goto L13;
        HashMap r15 = new HashMap();
        r15.put("fontSize", 20);
        r15.put("lineHeight", 28);
        r15.put("paragraphSpace", 12);
        x r16 = x.f38692a;
    L15:
        if ((r43 & 16) == 0) goto L17;
        HashMap r17 = new HashMap();
        r17.put("fontSize", 18);
        r17.put("lineHeight", 26);
        r17.put("paragraphSpace", 12);
        x r18 = x.f38692a;
    L19:
        if ((r43 & 32) == 0) goto L21;
        HashMap r19 = new HashMap();
        r19.put("fontSize", 16);
        r19.put("lineHeight", 24);
        r19.put("paragraphSpace", 12);
        x r4 = x.f38692a;
    L23:
        if ((r43 & 64) == 0) goto L25;
        HashMap r5 = new HashMap();
        r5.put("fontSize", 14);
        r5.put("lineHeight", 22);
        r12 = 12;
        r5.put("paragraphSpace", 12);
        x r110 = x.f38692a;
    L27:
        if ((r43 & 128) == 0) goto L29;
        HashMap r111 = new HashMap();
        r111.put("fontSize", Integer.valueOf(r12));
        r111.put("lineHeight", 20);
        r111.put("paragraphSpace", Integer.valueOf(r12));
        x r6 = x.f38692a;
    L31:
        if ((r43 & 256) == 0) goto L33;
        HashMap r7 = new HashMap();
        r7.put("color", e.a(r1, ZeusTransformUtils.mapRes(R.color.markdown_link_default_color, "color", "markdown_link_default_color")));
        x r112 = x.f38692a;
    L35:
        if ((r43 & 512) == 0) goto L37;
        HashMap r113 = new HashMap();
        r113.put("fontSize", 16);
        x r114 = x.f38692a;
    L39:
        if ((r43 & 1024) == 0) goto L41;
        HashMap r115 = new HashMap();
        r115.put("borderColor", e.a(r1, ZeusTransformUtils.mapRes(R.color.markdown_quote_text_default_color, "color", "markdown_quote_text_default_color")));
        x r8 = x.f38692a;
    L43:
        if ((r43 & 2048) == 0) goto L45;
        HashMap r9 = new HashMap();
        r9.put("fontSize", 12);
        r9.put("lineHeight", 18);
        r9.put("borderType", OProtocolTextEffectTextView.EffectNameNone);
        r9.put("color", "999999");
        x r10 = x.f38692a;
    L47:
        if ((r43 & 4096) == 0) goto L49;
        HashMap r45 = new HashMap();
        r45.put("indent", 26);
        r45.put("paragraphSpace", 8);
        r45.put("marginBottom", 16);
        x r46 = x.f38692a;
    L51:
        if ((r43 & 8192) == 0) goto L53;
        HashMap r47 = new HashMap();
        r47.put("markSize", 4);
        r47.put("markColor", e.a(r1, ZeusTransformUtils.mapRes(R.color.markdown_text_default_color, "color", "markdown_text_default_color")));
        int r3 = 8;
        r47.put("paragraphSpace", 8);
        r47.put("marginBottom", 16);
        r47.put("markMarginRight", 11);
        r47.put("markMarginLeft", 11);
        x r48 = x.f38692a;
    L55:
        if ((r43 & 16384) == 0) goto L57;
        HashMap r49 = new HashMap();
        x r50 = x.f38692a;
    L59:
        if ((32768 & r43) == 0) goto L61;
        HashMap r51 = new HashMap();
        x r52 = x.f38692a;
    L63:
        if ((65536 & r43) == 0) goto L65;
        HashMap r53 = new HashMap();
        x r54 = x.f38692a;
    L66:
        int r116 = 0;
        if ((131072 & r43) == 0) goto L69;
        boolean r55 = false;
    L71:
        if ((262144 & r43) == 0) goto L73;
        int r117 = 50;
    L75:
        if ((r43 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L77;
        boolean r118 = true;
    L79:
        if ((r43 & 1048576) == 0) goto L81;
        int r119 = r3;
    L83:
        if ((r43 & UiType.FLAG_REMOTE_CARD) != 0) goto L87;
        r3 = r41;
    L87:
        if ((r43 & UiType.FLAG_NO_FEEDBACK) != 0) goto L90;
        r116 = r42;
    L90:
        this(r1, r2, r13, r15, r17, r19, r5, r111, r7, r113, r115, r9, r45, r47, r49, r51, r53, r55, r117, r118, r119, r3, r116);
        return;
    L81:
        r119 = r40;
        goto L83
    L77:
        r118 = r39;
        goto L79
    L73:
        r117 = r38;
        goto L75
    L69:
        r55 = r37;
        goto L71
    L65:
        r53 = r36;
        goto L66
    L61:
        r51 = r35;
        goto L63
    L57:
        r49 = r34;
        goto L59
    L53:
        r3 = 8;
        r47 = r33;
        goto L55
    L49:
        r45 = r32;
        goto L51
    L45:
        r9 = r31;
        goto L47
    L41:
        r115 = r30;
        goto L43
    L37:
        r113 = r29;
        goto L39
    L33:
        r7 = r28;
        goto L35
    L29:
        r111 = r27;
        goto L31
    L25:
        r5 = r26;
        goto L27
    L21:
        r19 = r25;
        goto L23
    L17:
        r17 = r24;
        goto L19
    L13:
        r15 = r23;
        goto L15
    L9:
        r13 = r22;
        goto L11
    L5:
        r2 = r21;
        goto L6
    }

    public final HashMap<String, Object> c() {
        return this.f35449d;
    }

    public final HashMap<String, Object> d() {
        return this.f35450e;
    }

    public final HashMap<String, Object> e() {
        return this.f;
    }

    public final HashMap<String, Object> f() {
        return this.g;
    }

    public final HashMap<String, Object> g() {
        return this.h;
    }

    public final HashMap<String, Object> h() {
        return this.i;
    }

    public final HashMap<String, Object> i() {
        return this.j;
    }

    public final HashMap<String, Object> j() {
        return this.k;
    }

    public final HashMap<String, Object> k() {
        return this.m;
    }

    public final HashMap<String, Object> l() {
        return this.n;
    }

    public final HashMap<String, Object> m() {
        return this.o;
    }

    public final boolean n() {
        return this.s;
    }

    public final int o() {
        return this.t;
    }

    public final boolean p() {
        return this.u;
    }

    public final int q() {
        return this.v;
    }

    public final int r() {
        return this.w;
    }

    public final int s() {
        return this.x;
    }

    public final HashMap<String, Object> a() {
        HashMap<String, Object> r0 = new HashMap();
        a(r0, "normalText", this.f35448c);
        a(r0, "h1", this.f35449d);
        a(r0, "h2", this.f35450e);
        a(r0, "h3", this.f);
        a(r0, "h4", this.g);
        a(r0, "h5", this.h);
        a(r0, "h6", this.i);
        a(r0, "link", this.j);
        a(r0, "inlineCode", this.k);
        a(r0, "codeBlock", this.l);
        a(r0, "quote", this.m);
        a(r0, "orderedList", this.n);
        a(r0, "unorderedList", this.o);
        a(r0, "ref", this.p);
        a(r0, "table", this.q);
        a(r0, "tableCell", this.r);
        if (this.s == false) goto L5;
        HashMap<String, Object> r1 = new HashMap();
        r1.put("verticalAlign", "center");
        r1.put("customCursor", "default-cursor");
        a(r0, "typewriterCursor", r1);
    L5:
        return r0;
    }

    private final void a(HashMap<String, Object> r2, String r3, HashMap<String, Object> r4) {
        if ((!((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
        return;
    }
}
