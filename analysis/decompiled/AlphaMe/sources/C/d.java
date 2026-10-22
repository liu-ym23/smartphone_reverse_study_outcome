package C;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f250d;

    /* renamed from: a, reason: collision with root package name */
    public int f251a;

    /* renamed from: b, reason: collision with root package name */
    public Object f252b;

    /* renamed from: c, reason: collision with root package name */
    public Object f253c;

    public d(Shader shader, ColorStateList colorStateList, int i4) {
        this.f252b = shader;
        this.f253c = colorStateList;
        this.f251a = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x023a, code lost:
    
        if (r10 == r1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x023c, code lost:
    
        r16 = (int[]) r0.f13620a;
        r17 = (float[]) r0.f13621b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x024a, code lost:
    
        if (r2 == 1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x024c, code lost:
    
        if (r2 == r1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024e, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0253, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0256, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0259, code lost:
    
        r4 = new android.graphics.LinearGradient(r12, r13, r27, r26, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0262, code lost:
    
        r4 = new android.graphics.SweepGradient(r21, r25, (int[]) r0.f13620a, (float[]) r0.f13621b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0274, code lost:
    
        r8 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027b, code lost:
    
        if (r22 <= com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027d, code lost:
    
        r1 = (int[]) r0.f13620a;
        r21 = (float[]) r0.f13621b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x028a, code lost:
    
        if (r2 == 1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x028d, code lost:
    
        if (r2 == 2) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x028f, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0292, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0295, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0297, code lost:
    
        r4 = new android.graphics.RadialGradient(r8, r25, r22, r1, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02ad, code lost:
    
        return new C.d(r4, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02b5, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cb, code lost:
    
        if (r11.size() <= 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cd, code lost:
    
        r0 = new m3.i();
        r1 = r11.size();
        r0.f13620a = new int[r1];
        r0.f13621b = new float[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01df, code lost:
    
        if (r3 >= r1) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e1, code lost:
    
        ((int[]) r0.f13620a)[r3] = ((java.lang.Integer) r11.get(r3)).intValue();
        ((float[]) r0.f13621b)[r3] = ((java.lang.Float) r8.get(r3)).floatValue();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0204, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0205, code lost:
    
        if (r0 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0207, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x020a, code lost:
    
        if (r19 == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x020c, code lost:
    
        r0 = new m3.i();
        r0.f13620a = new int[]{r4, r9, r24};
        r0.f13621b = new float[]{com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE, 0.5f, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0222, code lost:
    
        r0 = new m3.i();
        r0.f13620a = new int[]{r4, r24};
        r1 = 2;
        r0.f13621b = new float[]{com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0238, code lost:
    
        if (r10 == 1) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static C.d a(android.content.res.Resources r30, int r31, android.content.res.Resources.Theme r32) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C.d.a(android.content.res.Resources, int, android.content.res.Resources$Theme):C.d");
    }

    public final boolean b() {
        if (((Shader) this.f252b) == null) {
            Object obj = this.f253c;
            if (((ColorStateList) obj) != null && ((ColorStateList) obj).isStateful()) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(int[] iArr) {
        if (b()) {
            ColorStateList colorStateList = (ColorStateList) this.f253c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f251a) {
                this.f251a = colorForState;
                return true;
            }
        }
        return false;
    }
}
