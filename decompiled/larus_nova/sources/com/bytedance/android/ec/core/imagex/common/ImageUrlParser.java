package com.bytedance.android.ec.core.imagex.common;

import android.net.Uri;
import com.alibaba.gaiax.model.GXAnimation;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.shopping.api.image.g0;
import com.bytedance.android.shopping.api.image.k0;
import com.bytedance.android.shopping.api.image.p0;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.UriProtector;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ImageUrlParser implements com.bytedance.android.shopping.api.image.r {
    public static final String[] B = null;
    public static final String[] C = null;
    public final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f44566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f44568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f44569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f44570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f44571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f44572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f44573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f44574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f44575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f44576l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f44577m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f44578n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f44579o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.shopping.api.image.t f44580p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f44581q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f44582r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o f44583s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Uri f44584t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f44585u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f44586v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Pair<Integer, Integer> f44587w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f44588x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f44589y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.ec.core.imagex.r f44590z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/ImageUrlParser$Type;", "", HTTP.PROTOCOL, "DOMAIN", "FLAG", "URI", "SERVICE_ID", "TMPL_NAME", "ParamValues", "FORMAT", GXAnimation.STATE_END, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type DOMAIN = null;
        public static final Type END = null;
        public static final Type FLAG = null;
        public static final Type FORMAT = null;
        public static final Type PROTOCOL = null;
        public static final Type ParamValues = null;
        public static final Type SERVICE_ID = null;
        public static final Type TMPL_NAME = null;
        public static final Type URI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f44598a = null;

        static {
            Type r100 = new Type(HTTP.PROTOCOL, 0);
            PROTOCOL = r100;
            Type r101 = new Type("DOMAIN", 1);
            DOMAIN = r101;
            Type r102 = new Type("FLAG", 2);
            FLAG = r102;
            Type r103 = new Type("URI", 3);
            URI = r103;
            Type r104 = new Type("SERVICE_ID", 4);
            SERVICE_ID = r104;
            Type r105 = new Type("TMPL_NAME", 5);
            TMPL_NAME = r105;
            Type r106 = new Type("ParamValues", 6);
            ParamValues = r106;
            Type r107 = new Type("FORMAT", 7);
            FORMAT = r107;
            Type r108 = new Type(GXAnimation.STATE_END, 8);
            END = r108;
            f44598a = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f44598a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Character[] f44599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h[] f44600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f44601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f44602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f44603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f44604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f44605g;

        public b() {
            int r100 = 0;
            Character r101 = Character.valueOf(Permission.WRITE);
            this.f44599a = new Character[]{'_', r101, r101, r101};
            h[] r102 = new h[2];
        L3:
            if (r100 >= 2) goto L5;
            r102[r100] = new com.bytedance.android.ec.core.imagex.common.a(8);
            r100 = r100 + 1;
            goto L3
        L5:
            this.f44600b = r102;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f44606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f44607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Type f44608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f44609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f44610e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.bytedance.android.ec.core.imagex.common.a f44611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final b f44612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final e f44613h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f44614i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ImageUrlParser f44615j;

        public c(ImageUrlParser r110) {
            this.f44615j = r110;
            this.f44608c = Type.PROTOCOL;
            this.f44609d = r110.f44588x.length();
            this.f44610e = new ArrayList();
            this.f44611f = new com.bytedance.android.ec.core.imagex.common.a(r110.f44582r);
            this.f44612g = new b();
            this.f44613h = new e();
            this.f44614i = -1;
            long r100 = System.nanoTime();
        L3:
            int r101 = this.f44607b;
            boolean r102 = false;
            if (r101 >= this.f44609d) goto L220;
            int r103 = r101 + 1;
            this.f44607b = r103;
            char r104 = this.f44615j.f44588x.charAt(r101);
            this.f44611f.a(r104);
            switch(n.f44653a[this.f44608c.ordinal()]) {
                case 1: goto L208;
                case 2: goto L202;
                case 3: goto L161;
                case 4: goto L66;
                case 5: goto L39;
                case 6: goto L28;
                case 7: goto L17;
                case 8: goto L8;
                default: goto L3;
            };
        L8:
            Character r105 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r105 == null) goto L15;
            if (r105.charValue() != '?') goto L15;
            this.f44607b++;
            this.f44615j.f44579o = this.f44611f.toString();
            this.f44611f.c();
            this.f44606a = true;
        L15:
            if (r101 < (this.f44609d - 1)) goto L3;
            this.f44615j.f44579o = this.f44611f.toString();
            this.f44608c = Type.END;
            goto L3
        L17:
            Character r106 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r106 == null) goto L23;
            if (r106.charValue() != ':') goto L23;
            ((ArrayList) this.f44610e).add(this.f44611f.toString());
            this.f44611f.c();
            this.f44607b++;
        L23:
            if (r106 == null) goto L3;
            if (r106.charValue() != '.') goto L3;
            this.f44607b++;
            ((ArrayList) this.f44610e).add(this.f44611f.toString());
            this.f44615j.f44578n = this.f44610e;
            this.f44611f.c();
            this.f44608c = Type.FORMAT;
            goto L3
        L28:
            Character r107 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r107 == null) goto L34;
            if (r107.charValue() != ':') goto L34;
            this.f44607b++;
            this.f44615j.f44577m = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.ParamValues;
        L34:
            if (r107 == null) goto L3;
            if (r107.charValue() != '.') goto L3;
            this.f44607b++;
            this.f44615j.f44577m = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.FORMAT;
            this.f44615j.f44578n = this.f44610e;
            goto L3
        L39:
            Character r108 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r108 == null) goto L56;
            if (r108.charValue() != '-') goto L56;
            String r109 = this.f44611f.toString();
            if (r109.length() != 10) goto L53;
            p0 r111 = TmplConvConfig.f44993k.b();
            if (r111 == null) goto L53;
            HashMap<String, g0> r112 = r111.e();
            if (r112 == null) goto L53;
            if (r112.containsKey(r109) != true) goto L53;
            r102 = true;
        L53:
            if (r102 == true) goto L54;
            this.f44608c = Type.TMPL_NAME;
            goto L3
        L54:
            this.f44607b++;
            this.f44615j.f44576l = r109;
            this.f44611f.c();
            this.f44608c = Type.TMPL_NAME;
        L56:
            if (r108 == null) goto L61;
            if (r108.charValue() != ':') goto L61;
            this.f44607b++;
            this.f44615j.f44577m = this.f44611f.toString();
            this.f44608c = Type.TMPL_NAME;
            this.f44611f.c();
            this.f44608c = Type.ParamValues;
        L61:
            if (r108 == null) goto L3;
            if (r108.charValue() != '.') goto L3;
            this.f44607b++;
            this.f44615j.f44577m = this.f44611f.toString();
            this.f44608c = Type.TMPL_NAME;
            this.f44611f.c();
            this.f44608c = Type.FORMAT;
            goto L3
        L66:
            Character r113 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (this.f44615j.f44573i != null) goto L73;
            if (r113 == null) goto L73;
            if (r113.charValue() != '/') goto L73;
            this.f44615j.f44573i = this.f44611f.toString();
        L73:
            e r114 = this.f44613h;
            Character r115 = StringsKt.getOrNull(this.f44615j.f44588x, r101 + 6);
            if (r114.f44621c == true) goto L90;
            int r116 = r114.f44620b;
            Character[] r117 = r114.f44619a;
            if (r116 >= r117.length) goto L90;
            char r118 = r117[r116].charValue();
            if (r115 != null) goto L81;
        L83:
            r114.f44620b = 0;
        L85:
            if (r114.f44620b < r114.f44619a.length) goto L87;
            boolean r119 = true;
        L88:
            r114.f44621c = r119;
            goto L90
        L87:
            r119 = false;
            goto L88
        L81:
            if (r118 != r115.charValue()) goto L83;
            r114.f44620b++;
        L90:
            if (r114.f44621c == false) goto L92;
            this.f44607b += 6;
            this.f44615j.f44572h = this.f44611f.toString();
            ImageUrlParser r120 = this.f44615j;
            r120.f44567c = true;
            r120.f44568d = "~tplv-";
            this.f44611f.c();
            this.f44608c = Type.SERVICE_ID;
        L114:
            if (Intrinsics.areEqual(this.f44615j.f44573i, "ecom-shop-material") == false) goto L159;
            b r121 = this.f44612g;
            if (this.f44608c == Type.URI) goto L118;
            boolean r122 = true;
        L120:
            if (r121.f44603e == true) goto L155;
            int r123 = r121.f44601c;
            Character[] r124 = r121.f44599a;
            if (r123 >= r124.length) goto L129;
            if (r124[r123].charValue() != r104) goto L127;
            r121.f44601c++;
            goto L155
        L127:
            r121.f44601c = 0;
            goto L155
        L129:
            if ('0' > r104) goto L146;
            if ('9' < r104) goto L146;
            r121.f44600b[r121.f44602d].a(r104);
            if (r122 == true) goto L136;
        L153:
            if (r122 == false) goto L155;
            r121.f44602d = 0;
            r121.f44601c = 0;
            r121.f44600b[0].c();
            r121.f44600b[1].c();
            r121.f44603e = true;
            goto L155
        L136:
            if (r121.f44602d != 1) goto L153;
            Integer r125 = StringsKt.toIntOrNull(r121.f44600b[0].toString());
            Integer r126 = StringsKt.toIntOrNull(r121.f44600b[1].toString());
            if (r125 == null) goto L153;
            if (r125.intValue() <= 0) goto L153;
            if (r126 == null) goto L153;
            if (r126.intValue() <= 0) goto L153;
            r121.f44603e = true;
            r121.f44604f = r125.intValue();
            r121.f44605g = r126.intValue();
            boolean r127 = true;
        L156:
            if (r127 == false) goto L159;
            this.f44615j.f44574j = Integer.valueOf(this.f44612g.f44604f);
            this.f44615j.f44575k = Integer.valueOf(this.f44612g.f44605g);
        L146:
            if (r104 == '-') goto L148;
        L152:
            r121.f44602d = 0;
            r121.f44601c = 0;
            r121.f44600b[0].c();
            r121.f44600b[1].c();
            goto L153
        L148:
            if (r121.f44602d != 0) goto L152;
            if (r121.f44600b[0].b() == false) goto L152;
            r121.f44602d++;
        L155:
            r127 = false;
            goto L156
        L118:
            r122 = false;
        L159:
            if (this.f44608c != Type.END) goto L3;
        L92:
            d r128 = ImageUrlParser.b(this.f44615j, r113, r103, 0);
            if (r128 == null) goto L95;
            ImageUrlParser r129 = this.f44615j;
            r129.f44568d = Constants.WAVE_SEPARATOR;
            r129.f44567c = true;
            r129.f44577m = r128.f44618c;
            r129.f44587w = new Pair(Integer.valueOf(r128.f44616a), Integer.valueOf(r128.f44617b));
            this.f44607b += r128.f44618c.length() + 2;
        L96:
            if (r128 == null) goto L98;
            this.f44615j.f44572h = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.FORMAT;
            goto L114
        L98:
            if (r113 != null) goto L101;
        L105:
            if (r113 == null) goto L111;
            if (r113.charValue() != '?') goto L111;
            this.f44615j.f44572h = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.END;
            this.f44606a = true;
        L111:
            if (r101 < (this.f44609d - 1)) goto L114;
            this.f44615j.f44572h = this.f44611f.toString();
            this.f44608c = Type.END;
            goto L114
        L101:
            if (r113.charValue() != '.') goto L105;
            ImageUrlParser r130 = this.f44615j;
            if (r130.f44587w == null) goto L105;
            this.f44607b++;
            r130.f44572h = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.FORMAT;
            goto L114
        L95:
            r128 = null;
            goto L96
        L161:
            Character r131 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r104 == '/') goto L163;
            if (r131 == null) goto L200;
            if (r131.charValue() != '?') goto L200;
            this.f44615j.f44572h = this.f44611f.toString();
            this.f44611f.c();
            this.f44608c = Type.END;
            this.f44606a = true;
        L200:
            if (r101 < (this.f44609d - 1)) goto L3;
            this.f44615j.f44572h = this.f44611f.toString();
            this.f44608c = Type.END;
            goto L3
        L163:
            String r132 = this.f44611f.toString();
            if (ArraysKt.contains(ImageUrlParser.C, r132) == true) goto L165;
            if (Intrinsics.areEqual(r132, "/aweme/") == false) goto L174;
            d r133 = ImageUrlParser.b(this.f44615j, null, r101, 1);
            if (r133 == null) goto L171;
            ImageUrlParser r134 = this.f44615j;
            r134.f44567c = true;
            r134.f44571g = "/aweme/" + r133.f44618c;
            this.f44615j.f44587w = new Pair(Integer.valueOf(r133.f44616a), Integer.valueOf(r133.f44617b));
            this.f44607b += r133.f44618c.length();
            d r135 = r133;
        L172:
            if (r135 == null) goto L174;
            this.f44611f.c();
            this.f44608c = Type.URI;
            goto L3
        L171:
            r135 = null;
        L174:
            this.f44608c = Type.URI;
            ImageUrlParser r136 = this.f44615j;
            if (r136.f44573i != null) goto L185;
            com.bytedance.android.ec.core.imagex.common.a r137 = this.f44611f;
            int r138 = r137.f44634c + 1;
            int r139 = r137.f44635d;
            int r140 = (r139 - 1) - 1;
            if (r139 <= 1) goto L183;
            int r141 = 1 + r140;
            if (1 > r141) goto L183;
            if (r139 < r141) goto L183;
            String r142 = new String(r137.f44633b, r138, r140);
        L184:
            r136.f44573i = r142;
        L183:
            r142 = null;
        L185:
            com.bytedance.android.ec.core.imagex.common.a r143 = this.f44611f;
            if (r143.f44635d <= 0) goto L188;
            Character r144 = Character.valueOf(r143.f44633b[0]);
        L189:
            if (r144 == null) goto L3;
            if (r144.charValue() != '/') goto L3;
            this.f44611f.f44634c = 1;
            goto L3
        L188:
            r144 = null;
            goto L189
        L165:
            this.f44615j.f44571g = r132;
            this.f44611f.c();
            this.f44608c = Type.URI;
            goto L3
        L202:
            Character r145 = StringsKt.getOrNull(this.f44615j.f44588x, r103);
            if (r145 == null) goto L3;
            if (r145.charValue() != '/') goto L3;
            this.f44607b++;
            this.f44615j.f44570f = this.f44611f.toString();
            com.bytedance.android.ec.core.imagex.common.a r146 = this.f44611f;
            char[] r147 = r146.f44633b;
            r146.f44635d = 1;
            r147[0] = '/';
            this.f44614i = r103;
            this.f44608c = Type.FLAG;
            goto L3
        L208:
            String r148 = this.f44611f.toString();
            if (r148.length() < 7) goto L217;
            String[] r149 = ImageUrlParser.B;
            if (ArraysKt.contains(r149, r148) == false) goto L217;
            ImageUrlParser r150 = this.f44615j;
            if (((Boolean) ImageSettings.f44474q.getValue()).booleanValue() == false) goto L215;
            r148 = r149[0];
        L215:
            r150.f44569e = r148;
            this.f44611f.c();
            this.f44608c = Type.DOMAIN;
        L217:
            if (r101 < 8) goto L3;
            this.f44607b = this.f44609d;
        L220:
            if (this.f44606a == false) goto L230;
            if (this.f44615j.isHierarchical() == false) goto L230;
            Iterator<T> r151 = UriProtector.getQueryParameterNames(this.f44615j.f44584t).iterator();
        L225:
            if (r151.hasNext() == false) goto L230;
            String r152 = (String) r151.next();
            String r153 = UriProtector.getQueryParameter(this.f44615j.f44584t, r152);
            if (r153 == null) goto L225;
            this.f44615j.f44583s.appendQueryParameter(r152, r153);
        L230:
            if (this.f44615j.A == false) goto L309;
            com.bytedance.android.ec.core.imagex.opt.w r154 = com.bytedance.android.ec.core.imagex.opt.w.f44922c;
            r154.getClass();
            if (com.bytedance.android.ec.core.imagex.opt.w.a() == false) goto L309;
            com.bytedance.android.shopping.api.image.k r155 = (com.bytedance.android.shopping.api.image.k) com.bytedance.android.ec.core.imagex.opt.w.f44921b.getValue(r154, com.bytedance.android.ec.core.imagex.opt.w.f44920a[0]);
            if (r155 == null) goto L287;
            ImageUrlParser r156 = this.f44615j;
            com.bytedance.android.ec.core.imagex.r r157 = r156.f44590z;
            Intrinsics.checkNotNullParameter(r155, "$this$matchSign");
            Intrinsics.checkNotNullParameter(r156, "imageUrlParser");
            List<com.bytedance.android.shopping.api.image.i> r158 = r155.b();
            if (r158 == null) goto L287;
            Iterator<T> r159 = r158.iterator();
        L240:
            if (r159.hasNext() == false) goto L287;
            com.bytedance.android.shopping.api.image.i r160 = (com.bytedance.android.shopping.api.image.i) r159.next();
            List<com.bytedance.android.shopping.api.image.j> r161 = r160.a();
            if (r161 == null) goto L284;
            Iterator<T> r162 = r161.iterator();
        L245:
            if (r162.hasNext() == false) goto L282;
            Object r163 = r162.next();
            com.bytedance.android.shopping.api.image.j r164 = (com.bytedance.android.shopping.api.image.j) r163;
            if (r156.f(r164.b(), r164.c()) == false) goto L278;
            String r165 = r164.a();
            if (r165 != null) goto L252;
        L255:
            boolean r166 = true;
        L256:
            if (r166 == true) goto L264;
            String r167 = r164.a();
            if (r157 == null) goto L260;
            String r168 = r157.f44943f;
        L262:
            if ((!Intrinsics.areEqual(r167, r168)) == false) goto L264;
        L260:
            r168 = null;
        L264:
            String r169 = r164.d();
            if (r169 != null) goto L267;
        L270:
            boolean r170 = true;
        L271:
            if (r170 == true) goto L279;
            String r171 = r164.d();
            if (r157 == null) goto L275;
            String r172 = r157.f44944g;
        L277:
            if ((!Intrinsics.areEqual(r171, r172)) == false) goto L279;
        L275:
            r172 = null;
        L279:
            boolean r173 = true;
        L280:
            if (r173 == false) goto L245;
        L283:
            com.bytedance.android.shopping.api.image.j r174 = (com.bytedance.android.shopping.api.image.j) r163;
        L285:
            if (r174 == null) goto L240;
            String r175 = r160.b();
        L288:
            if (r175 != null) goto L290;
        L293:
            boolean r176 = true;
        L294:
            if (r176 == true) goto L300;
            String r177 = this.f44615j.f44570f;
            if (r177 == null) goto L300;
            String r178 = null;
            if (true != StringsKt.contains$default(r177, "-sign", false, 2, null)) goto L301;
            r102 = true;
        L301:
            if (r102 == false) goto L303;
            String r179 = r175;
        L304:
            if (r179 == null) goto L309;
            ImageUrlParser r180 = this.f44615j;
            r180.f44586v = true;
            r180.f44581q.remove("lk3s");
            this.f44615j.f44581q.remove("x-signature");
            this.f44615j.f44581q.remove("x-expires");
            ImageUrlParser r181 = this.f44615j;
            if (r181.i(r179, r181.f44570f) == false) goto L309;
            r181.f44570f = r179;
            goto L309
        L303:
            r179 = r178;
        L300:
            r178 = null;
            goto L301
        L290:
            if (r175.length() == 0) goto L293;
            r176 = false;
            goto L294
        L267:
            if (StringsKt.isBlank(r169) == true) goto L270;
            r170 = false;
            goto L271
        L252:
            if (StringsKt.isBlank(r165) == true) goto L255;
            r166 = false;
        L278:
            r173 = false;
            goto L280
        L282:
            r163 = null;
            goto L283
        L284:
            r174 = null;
        L287:
            r175 = null;
        L309:
            this.f44615j.f44580p = new ImageUrlParser$Parser$onUrlParse$1(this);
            this.f44615j.f44590z.f("ec_local_duration_url_parser", Float.valueOf((System.nanoTime() - r100) / 1000000.0f));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f44617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f44618c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L12;
            d r101 = (d) r100;
            if (this.f44616a == r101.f44616a) goto L8;
            return false;
        L8:
            if (this.f44617b == r101.f44617b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f44618c, r101.f44618c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = ((this.f44616a * 31) + this.f44617b) * 31;
            String r101 = this.f44618c;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "SpecialTmpl(width=" + this.f44616a + ", height=" + this.f44617b + ", extraFlag=" + this.f44618c + ")";
        }

        public d(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "extraFlag");
            this.f44616a = r100;
            this.f44617b = r101;
            this.f44618c = r102;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Character[] f44619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f44620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f44621c;

        public e() {
            this.f44619a = new Character[]{'~', Character.valueOf(OthersPermission.STICKY_E), Character.valueOf(NamedPipe.UNIX_ID), Character.valueOf(Symlink.UNIX_ID), 'v', '-'};
        }
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final boolean isHierarchical() {
        return ((Boolean) this.f44585u.getValue()).booleanValue();
    }

    static {
        B = new String[]{"https://", "http://"};
        C = new String[]{"/img/", "/obj/"};
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final int a() {
        Integer r100 = this.f44575k;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final boolean d() {
        String r100 = this.f44569e;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (ArraysKt.contains(B, r100) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final int e() {
        Integer r100 = this.f44574j;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final String k() {
        if (this.f44586v == false) goto L88;
        if (d() == false) goto L88;
        boolean r100 = true;
        StringBuilder r101 = null;
        if (this.f44567c == false) goto L32;
        TmplConvConfig r102 = TmplConvConfig.f44993k;
        r102.getClass();
        if (((Boolean) TmplConvConfig.f44989g.getValue()).booleanValue() == false) goto L18;
        p0 r103 = r102.b();
        if (r103 == null) goto L14;
        Boolean r104 = r103.c();
    L16:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L32;
        String r106 = this.f44571g;
        if (r106 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L32;
        if (i("/img/", this.f44571g) == false) goto L32;
        this.f44571g = "/img/";
        goto L32
    L23:
        if (r106.length() == 0) goto L26;
        r107 = false;
        goto L27
    L14:
        r104 = null;
    L18:
        r105 = false;
    L32:
        if (this.f44565a == false) goto L34;
        this.f44565a = false;
        List<String> r108 = this.f44578n;
        StringBuilder r109 = new StringBuilder(this.f44582r * 2);
        String r110 = this.f44569e;
        String r111 = "";
        if (r110 != null) goto L38;
        r110 = "";
    L38:
        r109.append(r110);
        String r112 = this.f44570f;
        if (r112 != null) goto L41;
        r112 = "";
    L41:
        r109.append(r112);
        String r113 = this.f44571g;
        if (r113 != null) goto L44;
        r113 = "";
    L44:
        r109.append(r113);
        Character r114 = StringsKt.lastOrNull(r109);
        if (r114 != null) goto L47;
    L49:
        boolean r115 = false;
    L50:
        if (r115 == false) goto L52;
        r109.append('/');
    L52:
        String r116 = this.f44572h;
        if (r116 != null) goto L55;
        r116 = "";
    L55:
        r109.append(r116);
        if (this.f44567c == false) goto L82;
        String r117 = this.f44568d;
        if (r117 != null) goto L60;
        r117 = "";
    L60:
        r109.append(r117);
        String r118 = this.f44576l;
        if (r118 != null) goto L63;
    L66:
        if (r100 == true) goto L68;
        r109.append(this.f44576l);
        r109.append('-');
    L68:
        String r119 = this.f44577m;
        if (r119 == null) goto L72;
        r111 = r119;
    L72:
        r109.append(r111);
        if (r108 == null) goto L83;
        Iterator<T> r120 = r108.iterator();
    L76:
        if (r120.hasNext() == false) goto L78;
        String r121 = (String) r120.next();
        r109.append(":");
        r109.append(r121);
        goto L76
    L78:
        r109.append(".");
        String r122 = this.f44579o;
        if (r122 != null) goto L81;
        r122 = "image";
    L81:
        r109.append(r122);
    L83:
        if (r101 == null) goto L86;
        this.f44566b = r101.toString();
    L86:
        return this.f44566b;
    L63:
        if (r118.length() == 0) goto L66;
        r100 = false;
    L82:
        r101 = r109;
        goto L83
    L47:
        if (r114.charValue() == '/') goto L49;
        r115 = true;
        goto L50
    L34:
        return this.f44566b;
    L88:
        return this.f44588x;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String c() {
        return this.f44573i;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getDomain() {
        return this.f44570f;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getFlag() {
        return this.f44571g;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getFormat() {
        return this.f44579o;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getImageUri() {
        return this.f44572h;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getOriginUrl() {
        return this.f44589y;
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final com.bytedance.android.shopping.api.image.u getQuery() {
        return this.f44583s;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getServiceId() {
        return this.f44576l;
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final Pair<Integer, Integer> h() {
        return this.f44587w;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean j() {
        return this.f44567c;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String l() {
        return this.f44577m;
    }

    @Override // com.bytedance.android.shopping.api.image.r
    public final com.bytedance.android.shopping.api.image.t n() {
        return this.f44580p;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final boolean f(String r100, String r101) {
        if (r100 == null) goto L5;
        return Intrinsics.areEqual(c(), r100);
    L5:
        if (r101 == null) goto L22;
        String r102 = c();
        if (r102 != null) goto L9;
    L19:
        return false;
    L9:
        if (r102.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 != true) goto L19;
        return true;
    L14:
        if (StringsKt.contains$default(r101, r102, false, 2, null) == false) goto L16;
        r104 = true;
        goto L17
    L11:
        r103 = false;
        goto L12
    L22:
        return true;
    }

    public final boolean i(Object r100, Object r101) {
        if ((r100 instanceof Iterable) == false) goto L5;
    L6:
        if (r100 == r101) goto L10;
        this.f44565a = true;
        return true;
    L10:
        if ((!Intrinsics.areEqual(r100, r101)) == false) goto L13;
        this.f44565a = true;
        return true;
    L13:
        return false;
    L5:
        if ((r101 instanceof Iterable) == false) goto L10;
        goto L6
    }

    public ImageUrlParser(String r100, String r101, com.bytedance.android.ec.core.imagex.r r102) {
        Intrinsics.checkNotNullParameter(r100, "sourceUrl");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, "callerContext");
        this.f44588x = r100;
        this.f44589y = r101;
        this.f44590z = r102;
        this.A = true;
        this.f44566b = r100;
        this.f44581q = new LinkedHashMap();
        this.f44582r = r100.length();
        this.f44583s = new o(this);
        this.f44584t = UriProtector.parse(r100);
        this.f44585u = LazyKt.lazy(new AnonymousClass2(this));
        this.f44586v = com.bytedance.android.ec.core.imagex.transform.b.d(r100);
        new HashMap();
        new c(this);
    }

    public static final d b(ImageUrlParser r110, Character r111, int r112, int r113) {
        r110.getClass();
        if (r113 != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r113 != 1) goto L8;
        boolean r114 = true;
    L9:
        if (r100 == false) goto L15;
        if (r111 != null) goto L13;
    L14:
        boolean r115 = true;
    L16:
        p0 r101 = TmplConvConfig.f44993k.b();
        if (r101 == null) goto L19;
        List<k0> r102 = r101.j();
    L20:
        if (r102 == null) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L71;
        if (r115 == true) goto L74;
        StringBuilder r116 = new StringBuilder();
        int r104 = r112;
        Integer r105 = null;
        Integer r106 = null;
        int r107 = 0;
    L27:
        r104 = r104 + 1;
        if (r104 >= r110.f44588x.length()) goto L56;
        Character r108 = StringsKt.getOrNull(r110.f44588x, r104);
        if (r108 == null) goto L56;
        char r109 = r108.charValue();
        if ('0' > r109) goto L39;
        if ('9' < r109) goto L39;
    L55:
        r116.append(r109);
    L39:
        if (r109 != 'x') goto L43;
        Integer r117 = StringsKt.toIntOrNull(r116.substring(0, (r104 - r112) - 1));
        int r118 = r104 + 1;
        if (r117 == null) goto L56;
        r105 = Integer.valueOf(r117.intValue());
        r107 = r118;
        goto L55
    L43:
        if (r100 == false) goto L48;
        if (r105 == null) goto L48;
        if (r109 != '.') goto L48;
        r106 = StringsKt.toIntOrNull(r116.substring((r107 - r112) - 1, (r104 - r112) - 1));
    L48:
        if (r114 == false) goto L56;
        if (r105 == null) goto L56;
        if (r109 != '/') goto L56;
        Integer r119 = StringsKt.toIntOrNull(r116.substring((r107 - r112) - 1, (r104 - r112) - 1));
        if (r119 == null) goto L56;
        r106 = Integer.valueOf(r119.intValue());
    L56:
        if (r105 == null) goto L72;
        if (r106 != null) goto L59;
        return null;
    L59:
        return new d(r105.intValue(), r106.intValue(), r116.toString());
    L72:
        return null;
    L74:
        return null;
    L71:
        return null;
    L22:
        r103 = false;
        goto L23
    L19:
        r102 = null;
        goto L20
    L13:
        if (r111.charValue() != '~') goto L14;
    L15:
        r115 = false;
        goto L16
    L8:
        r114 = false;
        goto L9
    L5:
        r100 = false;
        goto L6
    }
}
