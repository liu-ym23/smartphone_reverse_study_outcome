package brc;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.TypeCastException;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f20204g;

    @Override // brc.a
    public final int b() {
        return ((int) this.f20197b) + 6;
    }

    public b(crc.a r100) {
        super(r100);
        this.f20204g = new RectF();
    }

    @Override // brc.f
    public final void a(Canvas r110) {
        crc.a r100 = this.f20201f;
        if (r100.f465142d <= 1) goto L73;
        float r101 = r100.f465147i;
        this.f20199d.setColor(r100.f465143e);
        int r102 = this.f20201f.f465142d;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        int r104 = drc.a.f469802a;
        float r105 = 2;
        c(r110, drc.a.b(this.f20201f, this.f20197b, r103), this.f20197b / r105, r101 / r105);
        r103 = r103 + 1;
        goto L6
    L8:
        this.f20199d.setColor(this.f20201f.f465144f);
        crc.a r106 = this.f20201f;
        int r107 = r106.f465141c;
        if (r107 == 0) goto L70;
        if (r107 == 2) goto L70;
        if (r107 == 3) goto L69;
        Object r108 = null;
        if (r107 != 4) goto L16;
        int r109 = r106.f465149k;
        float r111 = r106.f465150l;
        int r112 = drc.a.f469802a;
        float r113 = drc.a.b(r106, this.f20197b, r109);
        float r114 = 2;
        float r115 = this.f20197b / r114;
        if (r111 >= 1) goto L49;
        ArgbEvaluator r116 = this.f20200e;
        if (r116 == null) goto L43;
        Object r117 = r116.evaluate(r111, Integer.valueOf(this.f20201f.f465144f), Integer.valueOf(this.f20201f.f465143e));
    L44:
        Paint r118 = this.f20199d;
        if (r117 == null) goto L48;
        r118.setColor(((Integer) r117).intValue());
        crc.a r119 = this.f20201f;
        float r120 = r119.f465148j / r114;
        c(r110, r113, r115, r120 - ((r120 - (r119.f465147i / r114)) * r111));
        goto L49
    L48:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L43:
        r117 = null;
    L49:
        crc.a r121 = this.f20201f;
        if (r109 != (r121.f465142d - 1)) goto L60;
        ArgbEvaluator r122 = this.f20200e;
        if (r122 == null) goto L54;
        r108 = r122.evaluate(r111, Integer.valueOf(r121.f465143e), Integer.valueOf(this.f20201f.f465144f));
    L54:
        Paint r123 = this.f20199d;
        if (r108 == null) goto L58;
        r123.setColor(((Integer) r108).intValue());
        float r124 = this.f20197b / r114;
        float r125 = this.f20198c / r114;
        c(r110, r124, r115, r125 + ((r124 - r125) * r111));
        return;
    L58:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L60:
        if (r111 <= 0) goto L76;
        ArgbEvaluator r126 = this.f20200e;
        if (r126 == null) goto L64;
        r108 = r126.evaluate(r111, Integer.valueOf(r121.f465143e), Integer.valueOf(this.f20201f.f465144f));
    L64:
        Paint r127 = this.f20199d;
        if (r108 == null) goto L68;
        r127.setColor(((Integer) r108).intValue());
        crc.a r128 = this.f20201f;
        float r129 = r113 + r128.f465145g;
        float r130 = r128.f465147i;
        float r131 = r129 + r130;
        float r132 = r130 / r114;
        c(r110, r131, r115, r132 + (((r128.f465148j / r114) - r132) * r111));
        return;
    L68:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L76:
        return;
    L16:
        if (r107 != 5) goto L79;
        int r133 = r106.f465149k;
        float r134 = r106.f465150l;
        int r135 = drc.a.f469802a;
        float r136 = drc.a.b(r106, this.f20197b, r133);
        float r137 = 2;
        float r138 = this.f20197b / r137;
        ArgbEvaluator r139 = this.f20200e;
        if (r139 == null) goto L21;
        Object r140 = r139.evaluate(r134, Integer.valueOf(this.f20201f.f465144f), Integer.valueOf(this.f20201f.f465143e));
    L22:
        Paint r141 = this.f20199d;
        if (r140 == null) goto L37;
        r141.setColor(((Integer) r140).intValue());
        c(r110, r136, r138, this.f20201f.f465147i / r137);
        ArgbEvaluator r142 = this.f20200e;
        if (r142 == null) goto L27;
        r108 = r142.evaluate(1 - r134, Integer.valueOf(this.f20201f.f465144f), Integer.valueOf(this.f20201f.f465143e));
    L27:
        Paint r143 = this.f20199d;
        if (r108 == null) goto L35;
        r143.setColor(((Integer) r108).intValue());
        crc.a r144 = this.f20201f;
        if (r133 != (r144.f465142d - 1)) goto L32;
        float r145 = drc.a.b(r144, this.f20197b, 0);
    L33:
        c(r110, r145, r138, this.f20201f.f465148j / r137);
        return;
    L32:
        r145 = (r136 + r144.f465145g) + r144.f465147i;
        goto L33
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L37:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L21:
        r140 = null;
        goto L22
    L79:
        return;
    L69:
        float r146 = r106.f465147i;
        float r147 = r106.f465150l;
        int r148 = r106.f465149k;
        float r149 = r106.f465145g + r146;
        int r150 = drc.a.f469802a;
        float r151 = drc.a.b(r106, this.f20197b, r148);
        float r152 = 2;
        float r153 = 3;
        this.f20204g.set(((RangesKt.coerceAtLeast(((r147 - 0.5f) * r149) * 2.0f, 0.0f) + r151) - (this.f20201f.f465147i / r152)) + r153, r153, ((r151 + RangesKt.coerceAtMost((r147 * r149) * 2.0f, r149)) + (this.f20201f.f465147i / r152)) + r153, r146 + r153);
        r110.drawRoundRect(this.f20204g, r146, r146, this.f20199d);
        return;
    L70:
        int r154 = r106.f465149k;
        int r155 = drc.a.f469802a;
        float r156 = drc.a.b(r106, this.f20197b, r154);
        crc.a r157 = this.f20201f;
        float r158 = drc.a.b(r157, this.f20197b, (r154 + 1) % r157.f465142d) - r156;
        crc.a r159 = this.f20201f;
        float r160 = 2;
        c(r110, r156 + (r158 * r159.f465150l), this.f20197b / r160, r159.f465148j / r160);
        return;
    }

    public final void c(Canvas r100, float r101, float r102, float r103) {
        float r104 = 3;
        r100.drawCircle(r101 + r104, r102 + r104, r103, this.f20199d);
    }
}
