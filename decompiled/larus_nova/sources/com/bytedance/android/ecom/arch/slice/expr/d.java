package com.bytedance.android.ecom.arch.slice.expr;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements zp.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f50065k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f50066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f50067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0855d f50068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f50069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f50070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f50071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f50072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f50073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, zp.b> f50074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Object, Object> f50075j;

    public static final class a {
        @JvmStatic
        public static String a(long r100, int r101) {
            if (r101 <= 0) goto L4;
            StringCompanionObject r102 = StringCompanionObject.INSTANCE;
            return String.format("%0" + r101 + Directory.UNIX_ID, Arrays.copyOf(new Object[]{Long.valueOf(r100)}, 1));
        L4:
            return String.valueOf(r100);
        }
    }

    public static final class b implements zp.b {
        public b() {
        }

        @Override // zp.b
        public final Object a(zp.a r100, List<? extends Object> r101) {
            return Double.valueOf(com.bytedance.android.ecom.arch.slice.render.context.i.a(r100));
        }
    }

    public static final class c implements zp.b {
        public c() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 0);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            boolean r103 = com.bytedance.android.ecom.arch.slice.render.util.b.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 2), 0);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = System.currentTimeMillis();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L21:
            double r108 = (r107 * 1.0d) / 86400000;
            if (r103 == false) goto L24;
            long r109 = (long) Math.ceil(r108);
        L25:
            int r116 = d.f50065k;
            return a.a(r109, r113);
        L24:
            r109 = (long) r108;
            goto L25
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.expr.d$d, reason: collision with other inner class name */
    public static final class C0855d implements zp.b {
        public C0855d() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 2);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            boolean r103 = com.bytedance.android.ecom.arch.slice.render.util.b.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = System.currentTimeMillis();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L21:
            double r108 = ((r107 * 1.0d) % 86400000) / 3600000;
            if (r103 == false) goto L24;
            r108 = Math.ceil(r108);
        L24:
            int r116 = d.f50065k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class e implements zp.b {
        public e() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 2);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            boolean r103 = com.bytedance.android.ecom.arch.slice.render.util.b.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = System.currentTimeMillis();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L21:
            double r108 = (r107 * 1.0d) / 3600000;
            if (r103 == false) goto L24;
            r108 = Math.ceil(r108);
        L24:
            int r116 = d.f50065k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class f implements zp.b {
        public f() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            if (r111 != null) goto L5;
            return null;
        L5:
            if (r111.size() != 3) goto L55;
            String r100 = com.bytedance.android.ecom.arch.slice.render.util.b.r(ListProtector.get(r111, 0));
            if (r100 == null) goto L49;
            String r101 = com.bytedance.android.ecom.arch.slice.render.util.b.r(ListProtector.get(r111, 1));
            if (r101 == null) goto L50;
            Object r112 = ListProtector.get(r111, 2);
            if (r112 != null) goto L16;
            r112 = Float.valueOf(0.0f);
        L16:
            if ((r112 instanceof Number) == false) goto L19;
            float r113 = ((Number) r112).floatValue();
        L23:
            Integer r102 = uq.b.h(r100);
            if (r102 == null) goto L53;
            int r103 = r102.intValue();
            Integer r104 = uq.b.h(r101);
            if (r104 == null) goto L54;
            int r114 = r104.intValue();
            if (r113 > 0.0f) goto L31;
            return r100;
        L31:
            if (r113 < 1.0f) goto L33;
            return r101;
        L33:
            float r105 = ((r103 >> 24) & 255) / 255.0f;
            float r106 = (float) Math.pow(((r103 >> 16) & 255) / 255.0f, 2.2d);
            float r107 = (float) Math.pow(((r103 >> 8) & 255) / 255.0f, 2.2d);
            float r108 = (float) Math.pow((r103 & 255) / 255.0f, 2.2d);
            float r109 = (float) Math.pow(((r114 >> 16) & 255) / 255.0f, 2.2d);
            float r115 = r105 + (((((r114 >> 24) & 255) / 255.0f) - r105) * r113);
            float r116 = r106 + ((r109 - r106) * r113);
            float r117 = r107 + ((((float) Math.pow(((r114 >> 8) & 255) / 255.0f, 2.2d)) - r107) * r113);
            float r118 = r108 + (r113 * (((float) Math.pow((r114 & 255) / 255.0f, 2.2d)) - r108));
            float r119 = 255;
            String r120 = Integer.toHexString(Math.round(((float) Math.pow(r118, 0.45454545454545453d)) * r119) | (((Math.round(r115 * r119) << 24) | (Math.round(((float) Math.pow(r116, 0.45454545454545453d)) * r119) << 16)) | (Math.round(((float) Math.pow(r117, 0.45454545454545453d)) * r119) << 8)));
            int r121 = 8 - r120.length();
            if (r121 == 0) goto L47;
            switch(r121) {
                case 1: goto L45;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L42;
                case 5: goto L41;
                case 6: goto L40;
                case 7: goto L39;
                default: goto L38;
            };
        L39:
            r120 = "0000000".concat(r120);
            goto L47
        L40:
            r120 = "000000".concat(r120);
            goto L47
        L41:
            r120 = "00000".concat(r120);
            goto L47
        L42:
            r120 = AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON.concat(r120);
            goto L47
        L43:
            r120 = "000".concat(r120);
            goto L47
        L44:
            r120 = CustomAlbumViewModel.DEFAULT_TAB_ID.concat(r120);
            goto L47
        L45:
            r120 = "0".concat(r120);
            goto L47
        L38:
            throw new IllegalArgumentException("insertZeroIfNeeded:Invalid count value: " + r121);
        L47:
            return "#" + r120;
        L54:
            return null;
        L53:
            return null;
        L19:
            if ((r112 instanceof String) == false) goto L51;
            Float r122 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r112);
            if (r122 == null) goto L52;
            r113 = r122.floatValue();
            goto L23
        L52:
            return null;
        L51:
            return null;
        L50:
            return null;
        L49:
            return null;
        L55:
            return null;
        }
    }

    public static final class g implements zp.b {
        public g() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 1);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 1), 0);
            if (r113 <= 0) goto L16;
            if (r113 > 3) goto L16;
        L17:
            long r103 = 1000;
            long r104 = r102 * r103;
            long r105 = System.currentTimeMillis();
            if (r110 == null) goto L20;
            Object r114 = r110.getService();
        L21:
            long r106 = r104 - (r105 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r103));
            if (r106 > 0) goto L25;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L25:
            if (r113 == 1) goto L36;
            if (r113 == 2) goto L33;
            if (r113 != 3) goto L32;
            int r116 = d.f50065k;
            return a.a(r106 % r103, r113);
        L32:
            throw new IllegalArgumentException("millisecondsUntil:Invalid digits value: " + r113);
        L33:
            int r117 = d.f50065k;
            return a.a((r106 % r103) / ((long) 10), r113);
        L36:
            return String.valueOf((r106 % r103) / ((long) 100));
        L20:
            r114 = null;
        L16:
            r113 = 1;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class h implements zp.b {
        public h() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 2);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            boolean r103 = com.bytedance.android.ecom.arch.slice.render.util.b.a(CollectionsKt.getOrNull(r111, 1));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 2), 2);
            long r104 = 1000;
            long r105 = r102 * r104;
            long r106 = System.currentTimeMillis();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r107 = r105 - (r106 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r104));
            if (r107 > 0) goto L21;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L21:
            double r108 = ((r107 * 1.0d) % 3600000) / 60000;
            if (r103 == false) goto L24;
            r108 = Math.ceil(r108);
        L24:
            int r116 = d.f50065k;
            return a.a((long) r108, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    public static final class i implements zp.b {
        public i() {
        }

        @Override // zp.b
        public final Object a(zp.a r110, List<? extends Object> r111) {
            List<? extends Object> r100 = r111;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L10:
            if (r101 == false) goto L13;
            int r112 = d.f50065k;
            return a.a(0, 2);
        L13:
            long r102 = com.bytedance.android.ecom.arch.slice.render.util.b.m(ListProtector.get(r111, 0));
            int r113 = com.bytedance.android.ecom.arch.slice.render.util.b.f(CollectionsKt.getOrNull(r111, 2), 2);
            long r103 = 1000;
            long r104 = r102 * r103;
            long r105 = System.currentTimeMillis();
            if (r110 == null) goto L16;
            Object r114 = r110.getService();
        L17:
            long r106 = r104 - (r105 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r114, 0) * r103));
            if (r106 > 0) goto L21;
            int r115 = d.f50065k;
            return a.a(0, r113);
        L21:
            int r116 = d.f50065k;
            return a.a((r106 % 60000) / 1000, r113);
        L16:
            r114 = null;
            goto L17
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L10
        }
    }

    static {
    }

    @Override // zp.a
    public final Object getService() {
        return this.f50075j.get("slc_server_time");
    }

    @Override // zp.a
    public final zp.b a(String r100) {
        switch(r100.hashCode()) {
            case -1733354757: goto L41;
            case -851270209: goto L36;
            case -633409492: goto L31;
            case -302968724: goto L26;
            case 183106591: goto L21;
            case 285097287: goto L16;
            case 1126050093: goto L11;
            case 1494276495: goto L6;
            default: goto L46;
        };
    L6:
        if (r100.equals("hoursUntil") == false) goto L46;
        C0855d r101 = this.f50068c;
        if (r101 != null) goto L47;
        C0855d r102 = new C0855d();
        this.f50068c = r102;
        return r102;
    L47:
        return r101;
    L11:
        if (r100.equals("curTime") == false) goto L46;
        b r103 = this.f50066a;
        if (r103 != null) goto L49;
        b r104 = new b();
        this.f50066a = r104;
        return r104;
    L49:
        return r103;
    L16:
        if (r100.equals("daysUntil") == false) goto L46;
        c r105 = this.f50067b;
        if (r105 != null) goto L51;
        c r106 = new c();
        this.f50067b = r106;
        return r106;
    L51:
        return r105;
    L21:
        if (r100.equals("secondsUntil") == false) goto L46;
        i r107 = this.f50071f;
        if (r107 != null) goto L53;
        i r108 = new i();
        this.f50071f = r108;
        return r108;
    L53:
        return r107;
    L26:
        if (r100.equals("millisecondsUntil") == false) goto L46;
        g r109 = this.f50072g;
        if (r109 != null) goto L55;
        g r110 = new g();
        this.f50072g = r110;
        return r110;
    L55:
        return r109;
    L31:
        if (r100.equals("lerpColor") == false) goto L46;
        f r111 = this.f50073h;
        if (r111 != null) goto L57;
        f r112 = new f();
        this.f50073h = r112;
        return r112;
    L57:
        return r111;
    L36:
        if (r100.equals("minutesUntil") == false) goto L46;
        h r113 = this.f50070e;
        if (r113 != null) goto L59;
        h r114 = new h();
        this.f50070e = r114;
        return r114;
    L59:
        return r113;
    L41:
        if (r100.equals("hoursWithoutDayUntil") == false) goto L46;
        e r115 = this.f50069d;
        if (r115 != null) goto L61;
        e r116 = new e();
        this.f50069d = r116;
        return r116;
    L61:
        return r115;
    L46:
        return this.f50074i.get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Map<String, ? extends zp.b> r100, Map<Object, ? extends Object> r101) {
        this.f50074i = r100;
        this.f50075j = r101;
    }
}
