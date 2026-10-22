package bx2;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends bx2.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint.Cap f21311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint.Join f21312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint.Align f21313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f21314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f21317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f21318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f21319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21320k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f21321l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21322m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Shader f21323n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Xfermode f21324o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f21325p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f21326q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f21327r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21328s;

    public static final class a {
    }

    static {
    }

    @Override // bx2.a
    public final String h() {
        return "ps";
    }

    public j() {
        this.f21311b = Paint.Cap.BUTT;
        this.f21312c = Paint.Join.BEVEL;
        this.f21313d = Paint.Align.LEFT;
        this.f21314e = 20.0f;
        this.f21315f = -16777216;
        this.f21316g = -16777216;
        this.f21317h = 20.0f;
        this.f21325p = "";
        this.f21326q = "alphabetic";
        this.f21327r = Typeface.DEFAULT;
    }

    @Override // bx2.a
    public final void b(ax2.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = this.f21325p;
        switch(r101.hashCode()) {
            case 3104: goto L74;
            case 3146: goto L70;
            case 3277: goto L66;
            case 3278: goto L62;
            case 3447: goto L58;
            case 3454: goto L54;
            case 3467: goto L50;
            case 3487: goto L46;
            case 3664: goto L42;
            case 3679: goto L38;
            case 3680: goto L34;
            case 3685: goto L30;
            case 3686: goto L26;
            case 3693: goto L22;
            case 102163: goto L18;
            case 113963: goto L12;
            case 114149: goto L6;
            default: goto L96;
        };
    L96:
        return;
    L6:
        if (r101.equals("srd") == false) goto L97;
        Shader r102 = this.f21323n;
        if (r102 == null) goto L78;
        r100.f16614b.setShader(r102);
        return;
    L78:
        return;
    L97:
        return;
    L12:
        if (r101.equals("sld") == false) goto L98;
        Shader r103 = this.f21323n;
        if (r103 == null) goto L80;
        r100.f16614b.setShader(r103);
        return;
    L80:
        return;
    L98:
        return;
    L18:
        if (r101.equals("gco") == false) goto L99;
        r100.f16614b.setXfermode(this.f21324o);
        return;
    L99:
        return;
    L22:
        if (r101.equals("ta") == false) goto L100;
        r100.f16614b.setTextAlign(this.f21313d);
        return;
    L100:
        return;
    L26:
        if (r101.equals("sy") == false) goto L101;
        ax2.c r104 = r100.f16616d;
        float r105 = this.f21320k;
        r104.f16622f = r105;
        r100.f16614b.setShadowLayer(r104.f16623g, r104.f16621e, r105, r104.f16624h);
        return;
    L101:
        return;
    L30:
        if (r101.equals("sx") == false) goto L102;
        ax2.c r106 = r100.f16616d;
        float r107 = this.f21319j;
        r106.f16621e = r107;
        r100.f16614b.setShadowLayer(r106.f16623g, r107, r106.f16622f, r106.f16624h);
        return;
    L102:
        return;
    L34:
        if (r101.equals("ss") == false) goto L103;
        r100.f16614b.setShader(null);
        ax2.c r108 = r100.f16616d;
        r108.f16617a = this.f21316g;
        return;
    L103:
        return;
    L38:
        if (r101.equals(IVideoEventLogger.FEATURE_KEY_SR) == false) goto L104;
        ax2.c r109 = r100.f16616d;
        float r110 = this.f21321l;
        r109.f16623g = r110;
        r100.f16614b.setShadowLayer(r110, r109.f16621e, r109.f16622f, r109.f16624h);
        return;
    L104:
        return;
    L42:
        if (r101.equals(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L105;
        ax2.c r111 = r100.f16616d;
        int r112 = this.f21322m;
        r111.f16624h = r112;
        r100.f16614b.setShadowLayer(r111.f16623g, r111.f16621e, r111.f16622f, r112);
        return;
    L105:
        return;
    L46:
        if (r101.equals("ml") == false) goto L106;
        r100.f16614b.setStrokeMiter(this.f21318i);
        return;
    L106:
        return;
    L50:
        if (r101.equals("lw") == false) goto L107;
        r100.f16614b.setStrokeWidth(this.f21314e);
        return;
    L107:
        return;
    L54:
        if (r101.equals("lj") == false) goto L108;
        r100.f16614b.setStrokeJoin(this.f21312c);
        return;
    L108:
        return;
    L58:
        if (r101.equals("lc") == false) goto L109;
        r100.f16614b.setStrokeCap(this.f21311b);
        return;
    L109:
        return;
    L62:
        if (r101.equals("ft") == false) goto L110;
        Paint r113 = r100.f16614b;
        r113.setTypeface(this.f21327r);
        r113.setTextSize(this.f21317h);
        return;
    L110:
        return;
    L66:
        if (r101.equals("fs") == false) goto L111;
        r100.f16614b.setShader(null);
        ax2.c r114 = r100.f16616d;
        r114.f16618b = this.f21315f;
        return;
    L111:
        return;
    L70:
        if (r101.equals("bl") == false) goto L112;
        ax2.c r115 = r100.f16616d;
        String r116 = this.f21326q;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r115.f16620d = r116;
        return;
    L112:
        return;
    L74:
        if (r101.equals("aa") == false) goto L113;
        r100.f16614b.setAntiAlias(this.f21328s);
        return;
    }

    @Override // bx2.a
    public final void g(Map<String, ? extends Object> r210, ax2.c r211) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, "dataManager");
        Object r100 = r210.get(Segment.JsonKey.START);
        if (r100 == null) goto L252;
        String r101 = (String) r100;
        this.f21325p = r101;
        boolean r102 = true;
        boolean r103 = false;
        String r110 = "";
        switch(r101.hashCode()) {
            case 3104: goto L244;
            case 3146: goto L236;
            case 3277: goto L228;
            case 3278: goto L206;
            case 3290: goto L202;
            case 3447: goto L177;
            case 3454: goto L151;
            case 3467: goto L147;
            case 3487: goto L143;
            case 3664: goto L135;
            case 3679: goto L131;
            case 3680: goto L123;
            case 3685: goto L119;
            case 3686: goto L115;
            case 3693: goto L83;
            case 102163: goto L16;
            case 113963: goto L12;
            case 114149: goto L8;
            default: goto L270;
        };
    L270:
        return;
    L8:
        if (r101.equals("srd") == false) goto L271;
        float r111 = bx2.a.c(r210, "x0");
        float r112 = bx2.a.c(r210, "y0");
        float r113 = bx2.a.c(r210, "r0");
        bx2.a.c(r210, "x1");
        bx2.a.c(r210, "y1");
        bx2.a.c(r210, "r1");
        this.f21323n = new RadialGradient(r111, r112, r113, bx2.a.f(r210), bx2.a.d(r210), Shader.TileMode.MIRROR);
        return;
    L271:
        return;
    L12:
        if (r101.equals("sld") == false) goto L272;
        this.f21323n = new LinearGradient(bx2.a.c(r210, "x0"), bx2.a.c(r210, "y0"), bx2.a.c(r210, "x1"), bx2.a.c(r210, "y1"), bx2.a.f(r210), bx2.a.d(r210), Shader.TileMode.MIRROR);
        return;
    L272:
        return;
    L16:
        if (r101.equals("gco") == false) goto L273;
        String r104 = (String) r210.get(BaseSwitches.V);
        if (r104 == null) goto L23;
        r110 = r104;
    L23:
        if (r110.length() == 0) goto L26;
        r102 = false;
    L26:
        if (r102 == false) goto L29;
        return;
    L29:
        switch(r110.hashCode()) {
            case -1763725041: goto L77;
            case -1698458601: goto L73;
            case -1112602980: goto L69;
            case -131372090: goto L65;
            case -130953402: goto L61;
            case 118875: goto L57;
            case 3059573: goto L53;
            case 3392903: goto L51;
            case 94746189: goto L48;
            case 170546243: goto L44;
            case 912936772: goto L40;
            case 1158680499: goto L36;
            case 1159099187: goto L32;
            default: goto L80;
        };
    L51:
        r110.equals("null");
    L80:
        PorterDuffXfermode r105 = null;
    L81:
        this.f21324o = r105;
        return;
    L32:
        if (r110.equals("destination-over") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
        goto L81
    L36:
        if (r110.equals("destination-atop") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        goto L81
    L40:
        if (r110.equals("destination-in") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        goto L81
    L44:
        if (r110.equals("lighter") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
        goto L81
    L48:
        if (r110.equals("clear") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        goto L81
    L53:
        if (r110.equals("copy") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.ADD);
        goto L81
    L57:
        if (r110.equals("xor") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        goto L81
    L61:
        if (r110.equals("source-over") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        goto L81
    L65:
        if (r110.equals("source-atop") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        goto L81
    L69:
        if (r110.equals("source-out") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        goto L81
    L73:
        if (r110.equals("source-in") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        goto L81
    L77:
        if (r110.equals("destination-out") == false) goto L80;
        r105 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        goto L81
    L273:
        return;
    L83:
        if (r101.equals("ta") == false) goto L275;
        String r106 = (String) r210.get(BaseSwitches.V);
        if (r106 == null) goto L90;
        r110 = r106;
    L90:
        switch(r110.hashCode()) {
            case -1364013995: goto L109;
            case 100571: goto L105;
            case 3317767: goto L101;
            case 108511772: goto L97;
            case 109757538: goto L93;
            default: goto L112;
        };
    L112:
        Paint.Align r107 = Paint.Align.RIGHT;
    L113:
        this.f21313d = r107;
        return;
    L93:
        if (r110.equals("start") == false) goto L112;
        r107 = Paint.Align.LEFT;
        goto L113
    L97:
        if (r110.equals("right") == false) goto L112;
        r107 = Paint.Align.RIGHT;
        goto L113
    L101:
        if (r110.equals("left") == false) goto L112;
        r107 = Paint.Align.LEFT;
        goto L113
    L105:
        if (r110.equals("end") == false) goto L112;
        r107 = Paint.Align.RIGHT;
        goto L113
    L109:
        if (r110.equals("center") == false) goto L112;
        r107 = Paint.Align.CENTER;
        goto L113
    L275:
        return;
    L115:
        if (r101.equals("sy") == false) goto L276;
        this.f21320k = bx2.a.c(r210, BaseSwitches.V);
        return;
    L276:
        return;
    L119:
        if (r101.equals("sx") == false) goto L277;
        this.f21319j = bx2.a.c(r210, BaseSwitches.V);
        return;
    L277:
        return;
    L123:
        if (r101.equals("ss") == false) goto L278;
        String r108 = (String) r210.get(BaseSwitches.V);
        if (r108 == null) goto L129;
        r110 = r108;
    L129:
        Map<String, Integer> r109 = cx2.a.f465678a;
        this.f21316g = cx2.a.C5599a.d(r110);
        return;
    L278:
        return;
    L131:
        if (r101.equals(IVideoEventLogger.FEATURE_KEY_SR) == false) goto L279;
        this.f21321l = bx2.a.c(r210, BaseSwitches.V);
        return;
    L279:
        return;
    L135:
        if (r101.equals(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L280;
        String r114 = (String) r210.get(BaseSwitches.V);
        if (r114 == null) goto L141;
        r110 = r114;
    L141:
        Map<String, Integer> r115 = cx2.a.f465678a;
        this.f21322m = cx2.a.C5599a.d(r110);
        return;
    L280:
        return;
    L143:
        if (r101.equals("ml") == false) goto L281;
        this.f21318i = bx2.a.c(r210, BaseSwitches.V);
        return;
    L281:
        return;
    L147:
        if (r101.equals("lw") == false) goto L282;
        this.f21314e = bx2.a.c(r210, BaseSwitches.V);
        return;
    L282:
        return;
    L151:
        if (r101.equals("lj") == false) goto L283;
        String r116 = (String) r210.get(BaseSwitches.V);
        if (r116 == null) goto L157;
        r110 = r116;
    L157:
        int r117 = r110.hashCode();
        if (r117 == 93630586) goto L172;
        if (r117 == 103906565) goto L168;
        if (r117 == 108704142) goto L164;
    L174:
        Paint.Join r118 = Paint.Join.BEVEL;
    L175:
        this.f21312c = r118;
        return;
    L164:
        if (r110.equals("round") == false) goto L174;
        r118 = Paint.Join.ROUND;
        goto L175
    L168:
        if (r110.equals("miter") == false) goto L174;
        r118 = Paint.Join.MITER;
        goto L175
    L172:
        if (r110.equals("bevel") == false) goto L174;
        r118 = Paint.Join.BEVEL;
        goto L175
    L283:
        return;
    L177:
        if (r101.equals("lc") == false) goto L284;
        String r119 = (String) r210.get(BaseSwitches.V);
        if (r119 == null) goto L183;
        r110 = r119;
    L183:
        int r120 = r110.hashCode();
        if (r120 == (-894674659)) goto L197;
        if (r120 == 3035667) goto L194;
        if (r120 == 108704142) goto L190;
    L198:
        Paint.Cap r121 = Paint.Cap.BUTT;
    L200:
        this.f21311b = r121;
        return;
    L190:
        if (r110.equals("round") == false) goto L198;
        r121 = Paint.Cap.ROUND;
        goto L200
    L194:
        if (r110.equals("butt") == false) goto L198;
        r121 = Paint.Cap.BUTT;
        goto L200
    L197:
        if (r110.equals("square") == false) goto L198;
        r121 = Paint.Cap.SQUARE;
        goto L200
    L284:
        return;
    L202:
        if (r101.equals("ga") == false) goto L285;
        r211.f16619c = (int) (255 * bx2.a.c(r210, BaseSwitches.V));
        return;
    L285:
        return;
    L206:
        if (r101.equals("ft") == false) goto L286;
        String r122 = (String) r210.get(BaseSwitches.V);
        if (r122 == null) goto L213;
        r110 = r122;
    L213:
        if (r110.length() == 0) goto L216;
        r102 = false;
    L216:
        if (r102 == true) goto L287;
        HashMap<String, Integer> r123 = cx2.b.f465679a;
        cx2.b.C5600b r124 = cx2.b.a.b(r110);
        Float r125 = r124.f465683d;
        if (r125 == null) goto L221;
        float r126 = r125.floatValue();
    L222:
        this.f21317h = r126;
        String r127 = r124.f465681b;
        String r128 = r124.f465680a;
        Integer r129 = r124.f465682c;
        if (r129 == null) goto L225;
        int r130 = r129.intValue();
    L226:
        this.f21327r = cx2.b.a.a(r127, r128, r130);
        return;
    L225:
        r130 = 400;
        goto L226
    L221:
        r126 = 20.0f;
        goto L222
    L287:
        return;
    L286:
        return;
    L228:
        if (r101.equals("fs") == false) goto L288;
        String r131 = (String) r210.get(BaseSwitches.V);
        if (r131 == null) goto L234;
        r110 = r131;
    L234:
        Map<String, Integer> r132 = cx2.a.f465678a;
        this.f21315f = cx2.a.C5599a.d(r110);
        return;
    L288:
        return;
    L236:
        if (r101.equals("bl") == false) goto L289;
        String r133 = (String) r210.get(BaseSwitches.V);
        if (r133 == null) goto L242;
        r110 = r133;
    L242:
        this.f21326q = r110;
        return;
    L289:
        return;
    L244:
        if (r101.equals("aa") == false) goto L290;
        Boolean r134 = (Boolean) r210.get(BaseSwitches.V);
        if (r134 == null) goto L249;
        r103 = r134.booleanValue();
    L249:
        this.f21328s = r103;
        return;
    L290:
        return;
    L252:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
