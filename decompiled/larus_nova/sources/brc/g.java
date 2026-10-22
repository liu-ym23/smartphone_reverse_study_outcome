package brc;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.TypeCastException;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public class g extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f20207g;

    public void c(Canvas r100) {
    }

    public g(crc.a r100) {
        super(r100);
        this.f20207g = new RectF();
    }

    @Override // brc.f
    public final void a(Canvas r110) {
        crc.a r100 = this.f20201f;
        int r101 = r100.f465142d;
        int r102 = 1;
        if (r101 > 1) goto L5;
        return;
    L5:
        if (r100.f465147i != r100.f465148j) goto L7;
        boolean r103 = true;
    L8:
        float r104 = 0.0f;
        if (r103 == false) goto L48;
        if (r100.f465141c == 0) goto L48;
        int r105 = 0;
    L13:
        if (r105 >= r101) goto L15;
        this.f20199d.setColor(this.f20201f.f465143e);
        float r106 = r105;
        float r107 = this.f20197b;
        crc.a r111 = this.f20201f;
        float r112 = (r106 * r107) + (r106 * r111.f465145g);
        float r108 = this.f20198c;
        float r113 = r112 + (r107 - r108);
        this.f20207g.set(r113, 0.0f, r108 + r113, r111.a());
        d(r110, this.f20201f.a(), this.f20201f.a());
        r105 = r105 + 1;
        goto L13
    L15:
        this.f20199d.setColor(this.f20201f.f465144f);
        crc.a r109 = this.f20201f;
        int r114 = r109.f465141c;
        if (r114 != 2) goto L18;
        int r115 = r109.f465149k;
        float r116 = r109.f465145g;
        float r117 = r109.a();
        float r118 = r115;
        float r119 = this.f20197b;
        float r120 = ((r118 * r119) + (r118 * r116)) + ((r116 + r119) * this.f20201f.f465150l);
        this.f20207g.set(r120, 0.0f, r119 + r120, r117);
        d(r110, r117, r117);
        return;
    L18:
        if (r114 != 3) goto L20;
        float r121 = r109.a();
        crc.a r122 = this.f20201f;
        float r123 = r122.f465150l;
        int r124 = r122.f465149k;
        float r125 = r122.f465145g + r122.f465147i;
        int r126 = drc.a.f469802a;
        float r127 = drc.a.b(r122, this.f20197b, r124);
        float r128 = 2;
        this.f20207g.set((RangesKt.coerceAtLeast(((r123 - 0.5f) * r125) * 2.0f, 0.0f) + r127) - (this.f20201f.f465147i / r128), 0.0f, (r127 + RangesKt.coerceAtMost((r123 * r125) * 2.0f, r125)) + (this.f20201f.f465147i / r128), r121);
        d(r110, r121, r121);
        return;
    L20:
        if (r114 != 5) goto L141;
        int r129 = r109.f465149k;
        float r130 = r109.f465150l;
        float r131 = r129;
        float r132 = (this.f20198c * r131) + (r131 * r109.f465145g);
        if (r130 >= 0.99d) goto L33;
        ArgbEvaluator r133 = this.f20200e;
        if (r133 == null) goto L27;
        Object r134 = r133.evaluate(r130, Integer.valueOf(r109.f465144f), Integer.valueOf(this.f20201f.f465143e));
    L28:
        Paint r135 = this.f20199d;
        if (r134 == null) goto L32;
        r135.setColor(((Integer) r134).intValue());
        this.f20207g.set(r132, 0.0f, this.f20198c + r132, this.f20201f.a());
        d(r110, this.f20201f.a(), this.f20201f.a());
        goto L33
    L32:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L27:
        r134 = null;
    L33:
        crc.a r136 = this.f20201f;
        float r137 = (r132 + r136.f465145g) + r136.f465147i;
        if (r129 != (r136.f465142d - 1)) goto L36;
        r137 = 0.0f;
    L36:
        ArgbEvaluator r138 = this.f20200e;
        if (r138 == null) goto L39;
        Object r139 = r138.evaluate(1 - r130, Integer.valueOf(r136.f465144f), Integer.valueOf(this.f20201f.f465143e));
    L40:
        Paint r140 = this.f20199d;
        if (r139 == null) goto L44;
        r140.setColor(((Integer) r139).intValue());
        this.f20207g.set(r137, 0.0f, this.f20198c + r137, this.f20201f.a());
        d(r110, this.f20201f.a(), this.f20201f.a());
        return;
    L44:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L39:
        r139 = null;
        goto L40
    L141:
        return;
    L48:
        if (r100.f465141c != 4) goto L113;
        int r141 = 0;
    L50:
        if (r141 >= r101) goto L142;
        crc.a r142 = this.f20201f;
        int r143 = r142.f465144f;
        float r144 = r142.f465145g;
        float r145 = r142.a();
        crc.a r146 = this.f20201f;
        int r147 = r146.f465149k;
        float r148 = r146.f465147i;
        float r149 = r146.f465148j;
        if (r141 >= r147) goto L58;
        this.f20199d.setColor(r146.f465143e);
        crc.a r150 = this.f20201f;
        if (r147 != (r150.f465142d - r102)) goto L56;
        float r151 = r141;
        float r152 = ((r151 * r148) + (r151 * r144)) + ((r149 - r148) * r150.f465150l);
    L57:
        this.f20207g.set(r152, r104, r148 + r152, r145);
        d(r110, r145, r145);
    L112:
        r141 = r141 + 1;
        r102 = 1;
        r104 = 0.0f;
        goto L50
    L56:
        float r153 = r141;
        r152 = (r153 * r148) + (r153 * r144);
        goto L57
    L58:
        if (r141 != r147) goto L108;
        this.f20199d.setColor(r143);
        crc.a r154 = this.f20201f;
        float r155 = r154.f465150l;
        if (r147 != (r154.f465142d - r102)) goto L70;
        ArgbEvaluator r156 = this.f20200e;
        if (r156 == null) goto L64;
        Object r157 = r156.evaluate(r155, Integer.valueOf(r143), Integer.valueOf(this.f20201f.f465143e));
    L65:
        Paint r158 = this.f20199d;
        if (r157 == null) goto L69;
        r158.setColor(((Integer) r157).intValue());
        crc.a r159 = this.f20201f;
        float r160 = ((r159.f465142d - r102) * (r159.f465145g + r148)) + r149;
        this.f20207g.set((r160 - r149) + ((r149 - r148) * r155), 0.0f, r160, r145);
        d(r110, r145, r145);
    L82:
        if (r147 != (this.f20201f.f465142d - 1)) goto L97;
        if (r155 <= 0) goto L112;
        ArgbEvaluator r161 = this.f20200e;
        if (r161 == null) goto L88;
        Object r162 = r161.evaluate(1 - r155, Integer.valueOf(r143), Integer.valueOf(this.f20201f.f465143e));
    L89:
        Paint r163 = this.f20199d;
        if (r162 == null) goto L93;
        r163.setColor(((Integer) r162).intValue());
        this.f20207g.set(0.0f, 0.0f, (r148 + 0.0f) + ((r149 - r148) * r155), r145);
        d(r110, r145, r145);
        goto L112
    L93:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L88:
        r162 = null;
        goto L89
    L97:
        if (r155 <= 0) goto L112;
        ArgbEvaluator r164 = this.f20200e;
        if (r164 == null) goto L101;
        Object r165 = r164.evaluate(1 - r155, Integer.valueOf(r143), Integer.valueOf(this.f20201f.f465143e));
    L102:
        Paint r166 = this.f20199d;
        if (r165 == null) goto L106;
        r166.setColor(((Integer) r165).intValue());
        float r167 = r141;
        float r168 = (((r167 * r148) + (r167 * r144)) + r148) + (r144 + r149);
        this.f20207g.set((r168 - r148) - ((r149 - r148) * r155), 0.0f, r168, r145);
        d(r110, r145, r145);
        goto L112
    L106:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L101:
        r165 = null;
        goto L102
    L69:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L64:
        r157 = null;
        goto L65
    L70:
        float r169 = r102;
        if (r155 >= r169) goto L82;
        ArgbEvaluator r170 = this.f20200e;
        if (r170 == null) goto L75;
        Object r171 = r170.evaluate(r155, Integer.valueOf(r143), Integer.valueOf(this.f20201f.f465143e));
    L76:
        Paint r172 = this.f20199d;
        if (r171 == null) goto L80;
        r172.setColor(((Integer) r171).intValue());
        float r173 = r141;
        float r174 = (r173 * r148) + (r173 * r144);
        this.f20207g.set(r174, 0.0f, (r174 + r148) + ((r149 - r148) * (r169 - r155)), r145);
        d(r110, r145, r145);
        goto L82
    L80:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L75:
        r171 = null;
        goto L76
    L108:
        if ((r147 + 1) == r141) goto L110;
    L111:
        this.f20199d.setColor(r146.f465143e);
        float r175 = r141;
        float r176 = this.f20198c;
        float r177 = ((r175 * r176) + (r175 * r144)) + (r149 - r176);
        this.f20207g.set(r177, 0.0f, r176 + r177, r145);
        d(r110, r145, r145);
        goto L112
    L110:
        if (r146.f465150l != 0.0f) goto L112;
    L142:
        return;
    L113:
        float r178 = 0.0f;
        int r179 = 0;
    L114:
        if (r179 >= r101) goto L143;
        crc.a r180 = this.f20201f;
        int r181 = r180.f465149k;
        if (r179 != r181) goto L118;
        float r182 = this.f20197b;
    L119:
        Paint r183 = this.f20199d;
        if (r179 != r181) goto L122;
        int r184 = r180.f465144f;
    L123:
        r183.setColor(r184);
        this.f20207g.set(r178, 0.0f, r178 + r182, this.f20201f.a());
        d(r110, this.f20201f.a(), this.f20201f.a());
        r178 = r178 + (r182 + this.f20201f.f465145g);
        r179 = r179 + 1;
        goto L114
    L122:
        r184 = r180.f465143e;
        goto L123
    L118:
        r182 = this.f20198c;
        goto L119
    L143:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public void d(Canvas r100, float r101, float r102) {
        c(r100);
    }
}
