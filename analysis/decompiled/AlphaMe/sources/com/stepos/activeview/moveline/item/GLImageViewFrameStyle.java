package com.stepos.activeview.moveline.item;

import com.stepos.activeview.moveline.item.FrameStyle;
import java.util.Set;

/* loaded from: classes.dex */
public class GLImageViewFrameStyle extends ViewFrameStyle {
    @Override // com.stepos.activeview.moveline.item.ViewFrameStyle, com.stepos.activeview.moveline.item.FrameStyle
    public Object getPropertyValue(String str) {
        return this.mStyleValueMap.get(str);
    }

    @Override // com.stepos.activeview.moveline.item.ViewFrameStyle, com.stepos.activeview.moveline.item.FrameStyle
    public FrameStyle.PropertyValueType getPropertyValueType(String str) {
        return str.equals(GLImageViewTweenItem.BLUR) ? FrameStyle.PropertyValueType.FLOAT : super.getPropertyValueType(str);
    }

    @Override // com.stepos.activeview.moveline.item.ViewFrameStyle, com.stepos.activeview.moveline.item.FrameStyle
    public Set<String> getUpdateProperties() {
        return this.mToUpdateStyles;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    @Override // com.stepos.activeview.moveline.item.ViewFrameStyle, com.stepos.activeview.moveline.item.FrameStyle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPropertyValue(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r5.hashCode()     // Catch: java.lang.ClassCastException -> L20
            r1 = 3027047(0x2e3067, float:4.241796E-39)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L2c
            r1 = 3642105(0x3792f9, float:5.103676E-39)
            if (r0 == r1) goto L22
            r1 = 870472592(0x33e25b90, float:1.05406E-7)
            if (r0 == r1) goto L16
            goto L36
        L16:
            java.lang.String r0 = "aperture"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.ClassCastException -> L20
            if (r0 == 0) goto L36
            r0 = r3
            goto L37
        L20:
            r4 = move-exception
            goto L47
        L22:
            java.lang.String r0 = "wave"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.ClassCastException -> L20
            if (r0 == 0) goto L36
            r0 = r2
            goto L37
        L2c:
            java.lang.String r0 = "blur"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.ClassCastException -> L20
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto L3e
            if (r0 == r2) goto L3e
            if (r0 == r3) goto L3e
            goto L43
        L3e:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.mStyleValueMap     // Catch: java.lang.ClassCastException -> L20
            r0.put(r5, r6)     // Catch: java.lang.ClassCastException -> L20
        L43:
            super.setPropertyValue(r5, r6)     // Catch: java.lang.ClassCastException -> L20
            goto L5f
        L47:
            java.lang.String r6 = "the value type of the property "
            java.lang.String r0 = " is illegal:"
            java.lang.StringBuilder r5 = B0.g.w(r6, r5, r0)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "moveline"
            android.util.Log.e(r5, r4)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.moveline.item.GLImageViewFrameStyle.setPropertyValue(java.lang.String, java.lang.Object):void");
    }
}
