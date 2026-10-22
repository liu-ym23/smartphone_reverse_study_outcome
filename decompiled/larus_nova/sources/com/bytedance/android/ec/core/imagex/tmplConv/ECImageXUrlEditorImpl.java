package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.core.imagex.common.ImageUrlParser;
import com.bytedance.android.ec.core.imagex.common.l;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.api.image.f0;
import com.bytedance.android.shopping.api.image.g0;
import com.bytedance.android.shopping.api.image.i0;
import com.bytedance.android.shopping.api.image.j0;
import com.bytedance.android.shopping.api.image.k0;
import com.bytedance.android.shopping.api.image.l0;
import com.bytedance.android.shopping.api.image.m;
import com.bytedance.android.shopping.api.image.n;
import com.bytedance.android.shopping.api.image.o;
import com.bytedance.android.shopping.api.image.p;
import com.bytedance.android.shopping.api.image.p0;
import com.bytedance.android.shopping.api.image.q0;
import com.bytedance.android.shopping.api.image.x;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ECImageXUrlEditorImpl extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f44954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECImageXTmplParamsEditor f44955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f44956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageUrlParser f44957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f44958f;

    public final class ECImageXTmplParamsEditor implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f44959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f44960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f44961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f44962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f44963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f44964f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f44965g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f44966h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final x f44967i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Lazy f44968j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Lazy f44969k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Lazy f44970l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final c f44971m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ECImageXUrlEditorImpl f44972n;

        public final class a implements m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f44973a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f44974b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f44975c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f44976d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final TmplParamType f44977e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ ECImageXTmplParamsEditor f44978f;

            public a() {
                throw null;
            }

            @Override // com.bytedance.android.shopping.api.image.n
            public final String d() {
                if (b.f45030a[this.f44977e.ordinal()] == 1) goto L9;
                Integer r100 = getValue();
                if (r100 == null) goto L8;
                String r101 = String.valueOf(r100.intValue());
                if (r101 == null) goto L8;
                return r101;
            L8:
                return "0";
            L9:
                Integer r102 = getValue();
                if (r102 == null) goto L12;
                int r103 = r102.intValue();
            L14:
                return "q" + r103;
            L12:
                r103 = 0;
                goto L14
            }

            @Override // com.bytedance.android.shopping.api.image.n
            public final Integer getValue() {
                Integer r100 = this.f44973a;
                if (r100 == null) goto L5;
                return r100;
            L5:
                if (this.f44974b == true) goto L10;
                return null;
            L10:
                return Integer.valueOf(this.f44976d);
            }

            @Override // com.bytedance.android.shopping.api.image.n
            public final boolean a() {
                return this.f44974b;
            }

            @Override // com.bytedance.android.shopping.api.image.n
            public final Integer b(String r100) {
                int r101 = 1;
                int r102 = 0;
                if (r100 != null) goto L5;
            L8:
                boolean r103 = true;
            L10:
                if (r103 == false) goto L13;
                return null;
            L13:
                if (this.f44977e != TmplParamType.QUALITY) goto L17;
                if (r100.charAt(0) != 'q') goto L17;
            L20:
                int r104 = r100.length();
            L21:
                if (r101 >= r104) goto L30;
                char r105 = r100.charAt(r101);
                if ('0' > r105) goto L28;
                if ('9' < r105) goto L28;
                r102 = (r102 * 10) + (r105 - '0');
                r101 = r101 + 1;
            L28:
                return null;
            L30:
                return Integer.valueOf(r102);
            L17:
                if (r100.charAt(0) == 'Q') goto L20;
                r101 = 0;
                goto L20
            L5:
                if (r100.length() == 0) goto L8;
                r103 = false;
                goto L10
            }

            @Override // com.bytedance.android.shopping.api.image.m
            public final boolean c(Integer r100) {
                ECImageXTmplParamsEditor r101 = this.f44978f;
                boolean r102 = false;
                if (r101.f44972n.f44957e.f44586v == false) goto L23;
                if (r101.f44971m.f45031a == true) goto L23;
                if (Intrinsics.areEqual(r100, this.f44973a) == false) goto L11;
            L10:
                r102 = true;
                goto L23
            L11:
                ECImageXTmplParamsEditor r103 = this.f44978f;
                boolean r104 = r103.f44959a;
                if (r104 == false) goto L14;
            L17:
                this.f44973a = r100;
                if (r104 == true) goto L10;
                c r105 = r103.f44971m;
                if (r105.f45032b == true) goto L10;
                r105.f45032b = true;
                goto L10
            L14:
                if (this.f44974b == false) goto L23;
                if (this.f44975c == true) goto L17;
            L23:
                if (this.f44978f.f44959a == false) goto L26;
                if (r102 == false) goto L26;
                this.f44974b = true;
            L26:
                return r102;
            }

            public a(ECImageXTmplParamsEditor r100, TmplParamType r101, int r102) {
                if ((r102 & 2) == 0) goto L5;
                r101 = TmplParamType.NUMBER;
            L5:
                Intrinsics.checkNotNullParameter(r101, "type");
                this.f44978f = r100;
                this.f44976d = 0;
                this.f44977e = r101;
            }
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final String i() {
            return (String) this.f44969k.getValue();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final boolean m() {
            return ((Boolean) this.f44970l.getValue()).booleanValue();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final Integer k() {
            if (this.f44972n.e() > 0) goto L5;
        L26:
            return null;
        L5:
            if (this.f44972n.a() <= 0) goto L26;
            if (m() == true) goto L28;
            a r100 = this.f44960b;
            if (r100.f44974b == false) goto L26;
            if (this.f44961c.f44974b == false) goto L26;
            Integer r101 = r100.getValue();
            int r102 = 0;
            if (r101 == null) goto L16;
            int r103 = r101.intValue();
        L17:
            Integer r104 = this.f44961c.getValue();
            if (r104 == null) goto L20;
            r102 = r104.intValue();
        L20:
            if (r103 != 0) goto L23;
            if (r102 != 0) goto L23;
            return Integer.valueOf(this.f44972n.e() * this.f44972n.a());
        L23:
            if (r103 == 0) goto L31;
            return Integer.valueOf(((this.f44972n.a() * r103) / this.f44972n.e()) * r103);
        L31:
            return Integer.valueOf(((this.f44972n.e() * r102) / this.f44972n.a()) * r102);
        L16:
            r103 = 0;
            goto L17
        L28:
            return Integer.valueOf(this.f44972n.e() * this.f44972n.a());
        }

        public final m a(String r100) {
            if (r100 != null) goto L5;
        L28:
            return null;
        L5:
            switch(r100.hashCode()) {
                case -1050356101: goto L26;
                case 651215103: goto L23;
                case 1038216603: goto L20;
                case 1038216604: goto L17;
                case 1038216789: goto L14;
                case 1038216790: goto L11;
                case 1365704466: goto L8;
                default: goto L28;
            };
        L8:
            if (r100.equals("resize_height") == false) goto L28;
            return this.f44961c;
        L11:
            if (r100.equals("crop_ry") == false) goto L28;
            return this.f44965g;
        L14:
            if (r100.equals("crop_rx") == false) goto L28;
            return this.f44963e;
        L17:
            if (r100.equals("crop_ly") == false) goto L28;
            return this.f44964f;
        L20:
            if (r100.equals("crop_lx") == false) goto L28;
            return this.f44962d;
        L23:
            if (r100.equals(GearStrategyConsts.EV_QUALITY) == false) goto L28;
            return this.f44966h;
        L26:
            if (r100.equals("resize_width") == false) goto L28;
            return this.f44960b;
        }

        public ECImageXTmplParamsEditor(ECImageXUrlEditorImpl r100, c r101, a r102) {
            Intrinsics.checkNotNullParameter(r101, "editorController");
            this.f44972n = r100;
            this.f44971m = r101;
            this.f44960b = new a(this, null, 3);
            this.f44961c = new a(this, null, 3);
            this.f44962d = new a(this, null, 3);
            this.f44963e = new a(this, null, 3);
            this.f44964f = new a(this, null, 3);
            this.f44965g = new a(this, null, 3);
            boolean r103 = true;
            this.f44966h = new a(this, TmplParamType.QUALITY, 1);
            if (r102 == null) goto L5;
            x r104 = r102.f44981b;
        L6:
            this.f44967i = r104;
            Function0<String> r105 = new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$targetTmplName$2(this);
            LazyThreadSafetyMode r106 = LazyThreadSafetyMode.PUBLICATION;
            this.f44968j = LazyKt.lazy(r106, r105);
            this.f44969k = LazyKt.lazy(r106, new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$tmplType$2(this));
            this.f44970l = LazyKt.lazy(r106, new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$isOriginImage$2(this));
            this.f44959a = true;
            if (r102 != null) goto L9;
        L27:
            if (r102 == null) goto L59;
            List<String> r107 = r102.f44981b.a();
            List<String> r108 = r107;
            if (r108 != null) goto L31;
        L34:
            boolean r109 = true;
        L35:
            if (r109 == true) goto L46;
            Iterator<String> r110 = r107.iterator();
        L38:
            if (r110.hasNext() == false) goto L46;
            String r111 = r110.next();
            m r112 = r102.f44980a.a(r111);
            if (r112 == null) goto L42;
            Integer r113 = ((a) r112).getValue();
        L44:
            if (c(r111, r113, Boolean.TRUE) == true) goto L38;
        L234:
            this.f44959a = false;
            return;
        L42:
            r113 = null;
        L46:
            HashMap<String, Object> r114 = r102.f44981b.f();
            if (r114 != null) goto L49;
        L52:
            if (r103 == true) goto L234;
            Iterator<Map.Entry<String, Object>> r115 = r114.entrySet().iterator();
        L55:
            if (r115.hasNext() == false) goto L234;
            Map.Entry<String, Object> r116 = r115.next();
            if (c(r116.getKey(), r116.getValue(), null) == true) goto L55;
        L49:
            if (r114.isEmpty() == true) goto L52;
            r103 = false;
            goto L52
        L31:
            if (r108.isEmpty() == true) goto L34;
            r109 = false;
            goto L35
        L59:
            r100.n();
            if (r100.j() == false) goto L160;
            if (r100.h() == null) goto L89;
            p0 r117 = TmplConvConfig.f44993k.b();
            if (r117 == null) goto L193;
            List<k0> r118 = r117.j();
            if (r118 == null) goto L193;
            Iterator<T> r119 = r118.iterator();
        L69:
            if (r119.hasNext() == false) goto L73;
            Object r120 = r119.next();
            ECImageXUrlEditorImpl r121 = this.f44972n;
            if (l.b((k0) r120, r121.f44956d, r121) == false) goto L69;
        L74:
            k0 r122 = (k0) r120;
            if (r122 == null) goto L193;
            HashMap<String, Object> r123 = r122.f();
            if (r123 == null) goto L79;
            HashMap r124 = new HashMap(r123);
        L80:
            Pair<Integer, Integer> r125 = this.f44972n.h();
            if (r125 == null) goto L83;
            Integer r126 = r125.getFirst();
        L84:
            r124.put("resize_width", Integer.valueOf(r126.intValue()));
            Pair<Integer, Integer> r127 = this.f44972n.h();
            if (r127 == null) goto L87;
            Integer r128 = r127.getSecond();
        L88:
            r124.put("resize_height", Integer.valueOf(r128.intValue()));
            q0 r129 = k0.h(r122, r124);
        L194:
            this.f44967i = r129;
            if (r129 == null) goto L234;
            List<String> r130 = this.f44972n.f44957e.f44578n;
            if (r130 != null) goto L200;
            r130 = CollectionsKt.emptyList();
        L200:
            int r131 = r130.size();
            List<String> r132 = r129.a();
            if (r132 == null) goto L203;
            int r133 = r132.size();
        L204:
            if (r131 != r133) goto L234;
            HashMap<String, Object> r134 = r129.f();
            if (r134 != null) goto L209;
        L212:
            if (r103 == true) goto L219;
            Iterator<Map.Entry<String, Object>> r135 = r134.entrySet().iterator();
        L215:
            if (r135.hasNext() == false) goto L219;
            Map.Entry<String, Object> r136 = r135.next();
            if (c(r136.getKey(), r136.getValue(), null) == true) goto L215;
        L219:
            x r137 = this.f44967i;
            if (r137 == null) goto L222;
            List<String> r138 = r137.a();
        L223:
            Iterator<T> r139 = r130.iterator();
            int r140 = 0;
        L225:
            if (r139.hasNext() == false) goto L234;
            String r141 = (String) r139.next();
            if (r138 == null) goto L229;
            String r142 = (String) CollectionsKt.getOrNull(r138, r140);
        L231:
            if (c(r142, r141, Boolean.TRUE) == false) goto L234;
            r140 = r140 + 1;
            goto L225
        L229:
            r142 = null;
            goto L231
        L222:
            r138 = null;
            goto L223
        L209:
            if (r134.isEmpty() == true) goto L212;
            r103 = false;
            goto L212
        L203:
            r133 = 0;
            goto L204
        L87:
            r128 = null;
            goto L88
        L83:
            r126 = null;
            goto L84
        L79:
            r124 = new HashMap();
            goto L80
        L73:
            r120 = null;
        L193:
            r129 = null;
            goto L194
        L89:
            String r143 = r100.getServiceId();
            if (r143 != null) goto L92;
        L95:
            boolean r144 = true;
        L96:
            if (r144 == true) goto L124;
            String r145 = r100.l();
            if (r145 != null) goto L100;
        L103:
            boolean r146 = true;
        L104:
            if (r146 == true) goto L124;
            TmplConvConfig r147 = TmplConvConfig.f44993k;
            p0 r148 = r147.b();
            if (r148 == null) goto L119;
            HashMap<String, g0> r149 = r148.e();
            if (r149 == null) goto L119;
            g0 r150 = r149.get(r100.getServiceId());
            if (r150 == null) goto L119;
            HashMap<String, l0> r151 = r150.a();
            if (r151 == null) goto L116;
            l0 r152 = r151.get(r100.l());
            if (r152 == null) goto L116;
            Intrinsics.checkNotNullParameter(r150, "mather");
            l0.a r153 = new l0.a(r152, r150);
        L117:
            if (r153 == null) goto L119;
            r129 = r153;
        L116:
            r153 = null;
        L119:
            p0 r154 = r147.b();
            if (r154 == null) goto L193;
            HashMap<String, q0> r155 = r154.b();
            if (r155 == null) goto L193;
            r129 = r155.get(r100.l());
            goto L194
        L100:
            if (r145.length() == 0) goto L103;
            r146 = false;
        L124:
            String r156 = r100.getServiceId();
            if (r156 != null) goto L127;
        L130:
            boolean r157 = true;
        L131:
            if (r157 == false) goto L193;
            String r158 = r100.l();
            if (r158 != null) goto L135;
        L138:
            boolean r159 = true;
        L139:
            if (r159 == true) goto L193;
            p0 r160 = TmplConvConfig.f44993k.b();
            if (r160 == null) goto L193;
            HashMap<String, j0> r161 = r160.i();
            if (r161 == null) goto L193;
            j0 r162 = r161.get(r100.l());
            if (r162 == null) goto L193;
            List<f0> r163 = r162.b();
            if (r163 == null) goto L156;
            Iterator<T> r164 = r163.iterator();
        L150:
            if (r164.hasNext() == false) goto L154;
            Object r165 = r164.next();
            ECImageXUrlEditorImpl r166 = this.f44972n;
            if (l.b((f0) r165, r166.f44956d, r166) == false) goto L150;
        L155:
            f0 r167 = (f0) r165;
        L157:
            if (r167 == null) goto L193;
            Intrinsics.checkNotNullParameter(r167, PickerReporterConstants.KEY.TARGET);
            r129 = new j0.a(r162, r167);
            goto L194
        L154:
            r165 = null;
            goto L155
        L156:
            r167 = null;
            goto L157
        L135:
            if (r158.length() == 0) goto L138;
            r159 = false;
            goto L139
        L127:
            if (r156.length() == 0) goto L130;
            r157 = false;
            goto L131
        L92:
            if (r143.length() == 0) goto L95;
            r144 = false;
            goto L96
        L160:
            if (Intrinsics.areEqual(r100.getFlag(), "/obj/") == false) goto L173;
            p0 r168 = TmplConvConfig.f44993k.b();
            if (r168 == null) goto L193;
            List<i0> r169 = r168.h();
            if (r169 == null) goto L193;
            Iterator<T> r170 = r169.iterator();
        L167:
            if (r170.hasNext() == false) goto L171;
            Object r171 = r170.next();
            ECImageXUrlEditorImpl r172 = this.f44972n;
            if (l.b((i0) r171, r172.f44956d, r172) == false) goto L167;
        L172:
            r129 = (i0) r171;
            goto L194
        L171:
            r171 = null;
            goto L172
        L173:
            String r173 = r100.getFlag();
            if (r173 != null) goto L176;
        L179:
            boolean r174 = true;
        L180:
            if (r174 == false) goto L193;
            p0 r175 = TmplConvConfig.f44993k.b();
            if (r175 == null) goto L193;
            List<i0> r176 = r175.f();
            if (r176 == null) goto L193;
            Iterator<T> r177 = r176.iterator();
        L187:
            if (r177.hasNext() == false) goto L191;
            Object r178 = r177.next();
            ECImageXUrlEditorImpl r179 = this.f44972n;
            if (l.b((i0) r178, r179.f44956d, r179) == false) goto L187;
        L192:
            r129 = (i0) r178;
            goto L194
        L191:
            r178 = null;
            goto L192
        L176:
            if (r173.length() == 0) goto L179;
            r174 = false;
            goto L180
        L9:
            if (r102.f44982c == false) goto L27;
            List<String> r180 = r102.f44981b.a();
            List<String> r181 = r180;
            if (r181 != null) goto L13;
        L16:
            if (r103 == true) goto L234;
            Iterator<String> r182 = r180.iterator();
        L19:
            if (r182.hasNext() == false) goto L234;
            String r183 = r182.next();
            m r184 = r102.f44980a.a(r183);
            if (r184 == null) goto L23;
            Integer r185 = ((a) r184).getValue();
        L25:
            if (c(r183, r185, Boolean.TRUE) == true) goto L19;
        L23:
            r185 = null;
            goto L25
        L13:
            if (r181.isEmpty() == true) goto L16;
            r103 = false;
            goto L16
        L5:
            r104 = null;
            goto L6
        }

        public final boolean c(String r100, Object r101, Boolean r102) {
            m r103 = a(r100);
            if (r103 != null) goto L5;
        L22:
            return false;
        L5:
            if ((r101 instanceof String) == false) goto L10;
            String r104 = (String) r101;
            Integer r105 = r103.b(r104);
            if (r105 != null) goto L13;
            r105 = StringsKt.toIntOrNull(r104);
        L13:
            if (r102 == null) goto L20;
            if ((r103 instanceof a) == false) goto L20;
            a r106 = (a) r103;
            boolean r107 = r102.booleanValue();
            if (r106.f44978f.f44959a == false) goto L20;
            r106.f44975c = r107;
        L20:
            if (r103.c(r105) != true) goto L22;
            return true;
        L10:
            if ((r101 instanceof Number) == false) goto L12;
            r105 = Integer.valueOf(((Number) r101).intValue());
            goto L13
        L12:
            r105 = null;
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/tmplConv/ECImageXUrlEditorImpl$TmplParamType;", "", "NUMBER", "QUALITY", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TmplParamType extends Enum<TmplParamType> {
        public static final TmplParamType NUMBER = null;
        public static final TmplParamType QUALITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmplParamType[] f44979a = null;

        static {
            TmplParamType r100 = new TmplParamType("NUMBER", 0);
            NUMBER = r100;
            TmplParamType r101 = new TmplParamType("QUALITY", 1);
            QUALITY = r101;
            f44979a = new TmplParamType[]{r100, r101};
        }

        public static TmplParamType valueOf(String r100) {
            return (TmplParamType) r27.a.a(TmplParamType.class, r100);
        }

        public static TmplParamType[] values() {
            return (TmplParamType[]) f44979a.clone();
        }

        public TmplParamType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECImageXTmplParamsEditor f44980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x f44981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f44982c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f44980a, r101.f44980a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f44981b, r101.f44981b) == true) goto L10;
            return false;
        L10:
            if (this.f44982c == r101.f44982c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            ECImageXTmplParamsEditor r100 = this.f44980a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            x r104 = this.f44981b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            boolean r106 = this.f44982c;
            ?? r107 = r106;
            if (r106 == false) goto L13;
            r107 = 1;
        L13:
            return r105 + r107;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ReplaceModel(prepareParamsEditor=" + this.f44980a + ", replaceTmplModel=" + this.f44981b + ", isCloneEditor=" + this.f44982c + ")";
        }

        public a(ECImageXTmplParamsEditor r100, q0 r101) {
            Intrinsics.checkNotNullParameter(r100, "prepareParamsEditor");
            Intrinsics.checkNotNullParameter(r101, "replaceTmplModel");
            this.f44980a = r100;
            this.f44981b = r101;
            this.f44982c = false;
        }
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final n b() {
        return this.f44955c.f44961c;
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final n d() {
        return this.f44955c.f44960b;
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getFormat() {
        String r100 = this.f44957e.f44579o;
        if (r100 != null) goto L6;
        return "image";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final n getQuality() {
        return this.f44955c.f44966h;
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final String i() {
        return this.f44955c.i();
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final Integer k() {
        return this.f44955c.k();
    }

    @Override // com.bytedance.android.shopping.api.image.o
    public final boolean m() {
        return this.f44955c.m();
    }

    public final void q() {
        if (this.f44954b.f45032b == true) goto L5;
        return;
    L5:
        ImageUrlParser r100 = this.f44957e;
        ECImageXTmplParamsEditor r101 = this.f44955c;
        x r102 = r101.f44967i;
        if (r102 == null) goto L18;
        ArrayList r103 = new ArrayList();
        List<String> r104 = r102.a();
        boolean r105 = false;
        if (r104 == null) goto L16;
        Iterator<T> r106 = r104.iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        m r107 = r101.a((String) r106.next());
        if (r107 != null) goto L14;
        r105 = true;
        goto L11
    L14:
        r103.add(r107.d());
    L16:
        if (r105 == true) goto L18;
    L20:
        if (r100.i(r103, r100.f44578n) == false) goto L22;
        r100.f44578n = r103;
    L22:
        this.f44954b.f45032b = true;
        return;
    L18:
        r103 = null;
        goto L20
    }

    @Override // com.bytedance.android.shopping.api.image.q
    public final String g() {
        q();
        return this.f44957e.k();
    }

    @Override // com.bytedance.android.shopping.api.image.s
    public final String getOriginUrl() {
        return this.f44958f;
    }

    @Override // com.bytedance.android.shopping.api.image.p
    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ImageUrlParser r101 = this.f44957e;
        if (r101.f44567c == true) goto L5;
        return;
    L5:
        if (r101.i(r100, r101.f44579o) == false) goto L9;
        r101.f44579o = r100;
        return;
    }

    public ECImageXUrlEditorImpl(r r100, ImageUrlParser r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callerContext");
        Intrinsics.checkNotNullParameter(r101, "imageUrlParser");
        Intrinsics.checkNotNullParameter(r102, "originUrl");
        super(r101);
        this.f44956d = r100;
        this.f44957e = r101;
        this.f44958f = r102;
        c r103 = new c();
        this.f44954b = r103;
        this.f44955c = new ECImageXTmplParamsEditor(this, r103, null);
    }

    public final void p(String r100, String r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "tmplName");
        Intrinsics.checkNotNullParameter(r102, "targetTmplModel");
        if (r100 == null) goto L7;
        ImageUrlParser r103 = this.f44957e;
        if (r103.i(r100, r103.f44576l) == false) goto L7;
        r103.f44576l = r100;
    L7:
        ImageUrlParser r104 = this.f44957e;
        if (r104.i(r101, r104.f44577m) == false) goto L10;
        r104.f44577m = r101;
    L10:
        ImageUrlParser r105 = this.f44957e;
        if (r105.i(Boolean.TRUE, Boolean.valueOf(r105.f44567c)) == false) goto L13;
        r105.f44567c = true;
        r105.f44571g = "/img/";
    L13:
        ImageUrlParser r106 = this.f44957e;
        if (r106.f44567c == true) goto L16;
    L18:
        ImageUrlParser r107 = this.f44957e;
        if (r107.i("/img/", r107.f44571g) == false) goto L21;
        r107.f44571g = "/img/";
    L21:
        this.f44955c = new ECImageXTmplParamsEditor(this, this.f44954b, new a(this.f44955c, r102));
        this.f44954b.f45032b = true;
        return;
    L16:
        if (r106.i("~tplv-", r106.f44568d) == false) goto L18;
        r106.f44568d = "~tplv-";
        goto L18
    }
}
