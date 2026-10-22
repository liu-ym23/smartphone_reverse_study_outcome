package a7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import i8a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public abstract class k implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f2094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f2095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f2096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f2097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<BackgroundRepeat> f2098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j> f2099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LynxContext f2100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f2101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap.Config f2102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILynxImageService f2104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ILynxImageServiceExtension f2105l;

    public abstract boolean c();

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
    }

    public final int b() {
        if (((ArrayList) this.f2097d).isEmpty() == false) goto L6;
        return 1;
    L6:
        if (((ArrayList) this.f2094a).isEmpty() == true) goto L8;
        int r100 = ((ArrayList) this.f2094a).size() - 1;
        List<Integer> r101 = this.f2097d;
        return ((Integer) ListProtector.get(r101, r100 % ((ArrayList) r101).size())).intValue();
    L8:
        return ((Integer) ListProtector.get(this.f2097d, 0)).intValue();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        this.f2101h.invalidateSelf();
    }

    public k(LynxContext r100, Drawable r101) {
        ILynxImageServiceExtension r102 = null;
        this.f2102i = null;
        this.f2103j = false;
        this.f2104k = null;
        this.f2105l = null;
        this.f2100g = r100;
        this.f2101h = r101;
        this.f2094a = new ArrayList();
        this.f2095b = new ArrayList();
        this.f2096c = new ArrayList();
        this.f2097d = new ArrayList();
        this.f2098e = new ArrayList();
        this.f2099f = new ArrayList();
        ILynxImageService r103 = (ILynxImageService) n.c().a(ILynxImageService.class);
        this.f2104k = r103;
        if ((r103 instanceof ILynxImageServiceExtension) == false) goto L5;
        r102 = (ILynxImageServiceExtension) r103;
    L5:
        this.f2105l = r102;
    }

    public void d(ReadableArray r100, LynxBaseUI r101) {
        Iterator r102 = ((ArrayList) this.f2094a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((d) r102.next()).e();
        goto L4
    L6:
        ((ArrayList) this.f2094a).clear();
        if (r100 != null) goto L9;
        return;
    L9:
        Rect r103 = this.f2101h.getBounds();
        int r104 = r100.size();
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L37;
        int r106 = (int) r100.getLong(r105);
        if (r106 != 1) goto L23;
        r105 = r105 + 1;
        if (this.f2105l == null) goto L36;
        if (this.f2100g.isEnginePoolEnabled() == true) goto L36;
        d r107 = this.f2105l.createBackgroundImageDrawable(this.f2100g, r100.getString(r105));
        if (r107 == null) goto L36;
        r107.j(r101);
        r107.setCallback(this);
        ((ArrayList) this.f2094a).add(r107);
    L34:
        if (r103.isEmpty() == true) goto L36;
        List<d> r108 = this.f2094a;
        ((d) ListProtector.get(r108, ((ArrayList) r108).size() - 1)).g(r103.width(), r103.height());
    L36:
        r105 = r105 + 1;
        goto L10
    L23:
        if (r106 != 2) goto L26;
        r105 = r105 + 1;
        List<d> r109 = this.f2094a;
        ArrayList r110 = (ArrayList) r109;
        r110.add(new f(r100.getArray(r105)));
        goto L34
    L26:
        if (r106 != 3) goto L29;
        r105 = r105 + 1;
        List<d> r111 = this.f2094a;
        ArrayList r112 = (ArrayList) r111;
        r112.add(new i(r100.getArray(r105)));
        goto L34
    L29:
        if (r106 != 4) goto L31;
        r105 = r105 + 1;
        List<d> r113 = this.f2094a;
        ArrayList r114 = (ArrayList) r113;
        r114.add(new a(r100.getArray(r105)));
        goto L34
    L31:
        if (r106 != 0) goto L34;
        List<d> r115 = this.f2094a;
        ArrayList r116 = (ArrayList) r115;
        r116.add(new g());
        goto L34
    }

    public void a(Canvas r210, RectF r211, RectF r212, RectF r213, RectF r214, Path r215, Path r216, boolean r310) {
        k r100 = this;
        Canvas r101 = r210;
        if (((ArrayList) r100.f2094a).isEmpty() == false) goto L5;
        return;
    L5:
        int r102 = 1;
        int r103 = ((ArrayList) r100.f2094a).size() - 1;
        RectF r104 = r214;
    L6:
        if (r103 < 0) goto L173;
        if (((d) ListProtector.get(r100.f2094a, r103)).c() == true) goto L11;
        Canvas r105 = r101;
        r103 = r103;
    L172:
        r103 = r103 - 1;
        r100 = this;
        r101 = r105;
        r102 = 1;
        goto L6
    L11:
        if (c() == false) goto L13;
        RectF r106 = r211;
    L15:
        if (((ArrayList) r100.f2096c).isEmpty() == true) goto L25;
        int r107 = ((Integer) ListProtector.get(r100.f2096c, r103 % ((ArrayList) r100.f2096c).size())).intValue();
        if (r107 == 0) goto L23;
        if (r107 == r102) goto L22;
        if (r107 != 2) goto L25;
        r106 = r213;
        goto L25
    L22:
        r106 = r211;
        goto L25
    L23:
        r106 = r212;
    L25:
        if (((ArrayList) r100.f2097d).isEmpty() == true) goto L40;
        int r108 = ((Integer) ListProtector.get(r100.f2097d, r103 % ((ArrayList) r100.f2097d).size())).intValue();
        if (r108 == 0) goto L39;
        if (r108 == 2) goto L38;
        if (r108 == 4) goto L32;
        RectF r110 = r211;
        Path r111 = r215;
    L31:
        int r109 = r108;
        r104 = r110;
    L41:
        d r112 = (d) ListProtector.get(r100.f2094a, r103);
        r112.d();
        boolean r113 = r112 instanceof b;
        if (r113 == false) goto L44;
        float r114 = r106.width();
        float r115 = r106.height();
    L46:
        if (((ArrayList) r100.f2099f).isEmpty() == false) goto L48;
    L102:
        float r116 = r115;
    L104:
        if (Double.valueOf(r116).isNaN() == false) goto L106;
    L170:
        r105 = r101;
        RectF r117 = r104;
        r103 = r103;
    L171:
        r104 = r117;
        goto L172
    L106:
        if (Double.valueOf(r114).isNaN() == true) goto L170;
        if (r114 < 1.0f) goto L170;
        if (r116 < 1.0f) goto L170;
        float r118 = r106.left;
        float r119 = r106.top;
        if (c() == false) goto L119;
        if (((ArrayList) r100.f2095b).size() >= 2) goto L119;
        float r120 = (float) (((double) r118) + (((double) (r106.width() - r114)) * 0.5d));
        r119 = (float) (((double) r119) + (((double) (r106.height() - r116)) * 0.5d));
        r118 = r120;
    L119:
        if (((ArrayList) r100.f2095b).size() < 2) goto L122;
        int r121 = r103 % (((ArrayList) r100.f2095b).size() / 2);
        float r122 = r106.width() - r114;
        float r123 = r106.height() - r116;
        int r124 = r121 * 2;
        h r125 = (h) ListProtector.get(r100.f2095b, r124);
        h r126 = (h) ListProtector.get(r100.f2095b, r124 + 1);
        r118 = r118 + r125.f2081a.b(r122);
        r119 = r119 + r126.f2081a.b(r123);
    L122:
        BackgroundRepeat r127 = BackgroundRepeat.REPEAT;
        if (((ArrayList) r100.f2098e).size() < 2) goto L125;
        int r128 = (r103 % (((ArrayList) r100.f2098e).size() / 2)) * 2;
        BackgroundRepeat r129 = (BackgroundRepeat) ListProtector.get(r100.f2098e, r128);
        BackgroundRepeat r130 = (BackgroundRepeat) ListProtector.get(r100.f2098e, r128 + 1);
    L126:
        r112.i(r100.f2103j);
        int r131 = Math.round(r114);
        int r132 = Math.round(r116);
        r112.setBounds(new Rect(0, 0, r131, r132));
        if (r215 == null) goto L131;
        if (r113 == false) goto L131;
        if (r310 == true) goto L131;
        r112.f2077a = r215;
    L131:
        int r133 = r210.save();
        if (r111 == null) goto L137;
        if (r310 == false) goto L135;
    L136:
        r105 = r210;
        r105.clipPath(r111);
        r117 = r104;
    L138:
        BackgroundRepeat r134 = BackgroundRepeat.NO_REPEAT;
        if (r129 != r134) goto L142;
        if (r130 != r134) goto L142;
        r210.save();
        r105.translate(r118, r119);
        r112.draw(r105);
        r210.restore();
        r103 = r103;
    L169:
        r105.restoreToCount(r133);
    L142:
        RectF r135 = r106;
        float r136 = (int) Math.max(r135.right, r117.right);
        float r137 = (int) Math.max(r135.bottom, r117.bottom);
        if (r129 != r127) goto L145;
    L148:
        BackgroundRepeat r138 = r129;
        r118 = r118 - (((int) Math.ceil(((double) r118) / ((double) r131))) * r131);
    L149:
        if (r130 != r127) goto L151;
    L152:
        r119 = r119 - (((int) Math.ceil(((double) r119) / ((double) r132))) * r132);
    L153:
        r210.save();
        r105.clipRect(r117);
        float r139 = Math.round(r118);
        float r140 = Math.round(r119);
    L155:
        if (r139 >= r136) goto L168;
        float r141 = r140;
    L158:
        if (r141 >= r137) goto L163;
        r210.save();
        r105.translate(r139, r141);
        d r142 = r112;
        r142.draw(r105);
        r210.restore();
        if (r130 == BackgroundRepeat.NO_REPEAT) goto L164;
        r141 = r141 + r132;
        r112 = r142;
    L164:
        BackgroundRepeat r143 = r138;
        if (r143 == BackgroundRepeat.NO_REPEAT) goto L168;
        r139 = r139 + r131;
        r138 = r143;
        r112 = r142;
        goto L155
    L163:
        r142 = r112;
    L168:
        r210.restore();
        goto L169
    L151:
        if (r130 != BackgroundRepeat.REPEAT_Y) goto L153;
    L145:
        if (r129 == BackgroundRepeat.REPEAT_X) goto L148;
        r138 = r129;
        goto L149
    L135:
        if (r109 == 4) goto L136;
    L137:
        r105 = r210;
        r117 = r104;
        r105.clipRect(r117);
        goto L138
    L125:
        r130 = r127;
        r129 = r130;
        goto L126
    L48:
        if (((ArrayList) r100.f2099f).size() < 2) goto L102;
        int r144 = r103 * 2;
        if (r144 < ((ArrayList) r100.f2099f).size()) goto L52;
        List<j> r145 = r100.f2099f;
        j r146 = (j) ListProtector.get(r145, ((ArrayList) r145).size() - 2);
        List<j> r147 = r100.f2099f;
        j r148 = (j) ListProtector.get(r147, ((ArrayList) r147).size() - 1);
        j r149 = r146;
    L53:
        float r150 = r106.width();
        float r151 = r106.height();
        float r152 = r114 / r115;
        float r217 = r115;
        if (r149.f2093a.a() != (-33.0f)) goto L56;
        boolean r153 = true;
    L57:
        if (r153 == false) goto L63;
        float r154 = r150 / r152;
        if (r154 < r151) goto L69;
    L61:
        r116 = r154;
        r114 = r150;
    L69:
        r114 = r152 * r151;
        r116 = r151;
        goto L104
    L63:
        if (r149.f2093a.a() != (-34.0f)) goto L65;
        boolean r155 = true;
    L66:
        if (r155 == false) goto L72;
        r154 = r150 / r152;
        if (r154 <= r151) goto L61;
    L72:
        if (r149.f2093a.a() != (-32.0f)) goto L74;
        boolean r156 = true;
    L75:
        if (r156 == true) goto L79;
        r114 = r149.f2093a.b(r150);
    L79:
        if (r148.f2093a.a() != (-32.0f)) goto L81;
        boolean r157 = true;
    L82:
        if (r157 == false) goto L84;
        r116 = r217;
    L86:
        if (r149.f2093a.a() != (-32.0f)) goto L88;
        boolean r158 = true;
    L89:
        if (r158 == false) goto L95;
        if (r113 == false) goto L92;
        float r159 = r106.width();
    L93:
        r114 = r159;
        goto L95
    L92:
        r159 = r152 * r116;
    L95:
        if (r148.f2093a.a() != (-32.0f)) goto L97;
        boolean r160 = true;
    L98:
        if (r160 == false) goto L104;
        if (r113 == false) goto L101;
        r116 = r106.height();
        goto L104
    L101:
        r116 = r114 / r152;
        goto L104
    L97:
        r160 = false;
        goto L98
    L88:
        r158 = false;
        goto L89
    L84:
        r116 = r148.f2093a.b(r151);
        goto L86
    L81:
        r157 = false;
        goto L82
    L74:
        r156 = false;
        goto L75
    L65:
        r155 = false;
        goto L66
    L56:
        r153 = false;
        goto L57
    L52:
        j r161 = (j) ListProtector.get(r100.f2099f, r144);
        r148 = (j) ListProtector.get(r100.f2099f, r144 + 1);
        r149 = r161;
        goto L53
    L44:
        float r162 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        r114 = ((d) ListProtector.get(r100.f2094a, r103)).b() * r162;
        r115 = r162 * ((d) ListProtector.get(r100.f2094a, r103)).a();
        goto L46
    L32:
        Path r163 = new Path();
        r163.setFillType(Path.FillType.EVEN_ODD);
        if (r215 == null) goto L36;
        if (r216 == 0) goto L36;
        r163.addPath(r215);
        r163.addPath(r216);
        r110 = r211;
    L37:
        r111 = r163;
    L36:
        r110 = r211;
        r163.addRect(r110, Path.Direction.CW);
        r163.addRect(r212, Path.Direction.CCW);
        goto L37
    L38:
        r111 = r216;
        r109 = r108;
        r104 = r213;
        goto L41
    L39:
        r111 = r216;
        r109 = r108;
        r104 = r212;
        goto L41
    L40:
        r111 = r215;
        r109 = 1;
        goto L41
    L13:
        r106 = r212;
        goto L15
    }
}
