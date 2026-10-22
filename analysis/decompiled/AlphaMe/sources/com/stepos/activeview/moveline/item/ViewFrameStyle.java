package com.stepos.activeview.moveline.item;

import B0.g;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Log;
import com.stepos.activeview.moveline.Config;
import com.stepos.activeview.moveline.item.FrameStyle;
import com.stepos.activeview.utils.LogUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ViewFrameStyle implements FrameStyle {
    protected final Set<String> mToUpdateStyles = new HashSet();
    protected final Map<String, Object> mStyleValueMap = new HashMap();

    private PathMeasure buildPathMeasure(List<float[]> list) {
        if (list != null && list.size() != 0 && list.size() >= 4) {
            try {
                Path path = new Path();
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 3;
                    if (i5 >= list.size()) {
                        return new PathMeasure(path, false);
                    }
                    float[] fArr = list.get(i4);
                    float[] fArr2 = list.get(i4 + 1);
                    float[] fArr3 = list.get(i4 + 2);
                    float[] fArr4 = list.get(i5);
                    if (i4 == 0) {
                        path.moveTo(fArr[0], fArr[1]);
                    }
                    path.cubicTo(fArr2[0], fArr2[1], fArr3[0], fArr3[1], fArr4[0], fArr4[1]);
                    i4 = i5;
                }
            } catch (IndexOutOfBoundsException e4) {
                LogUtil.e("buildPathMeasure e=" + e4.toString());
            }
        }
        return null;
    }

    @Override // com.stepos.activeview.moveline.item.FrameStyle
    public Object getPropertyValue(String str) {
        return this.mStyleValueMap.get(str);
    }

    @Override // com.stepos.activeview.moveline.item.FrameStyle
    public FrameStyle.PropertyValueType getPropertyValueType(String str) {
        str.getClass();
        switch (str) {
        }
        return FrameStyle.PropertyValueType.OTHER;
    }

    @Override // com.stepos.activeview.moveline.item.FrameStyle
    public Set<String> getUpdateProperties() {
        return this.mToUpdateStyles;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v3 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setAlpha(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.mStyleValueMap
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            java.lang.String r0 = "alpha"
            r2.put(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.moveline.item.ViewFrameStyle.setAlpha(float):void");
    }

    public void setLeft(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.LEFT, Float.valueOf(f4));
    }

    public void setPivotX(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.PIVOT_X, Float.valueOf(f4));
    }

    public void setPivotY(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.PIVOT_Y, Float.valueOf(f4));
    }

    @Override // com.stepos.activeview.moveline.item.FrameStyle
    public void setPropertyValue(String str, Object obj) {
        try {
            if (str.equals(ViewTweenItem.LEFT)) {
                setLeft(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.TOP)) {
                setTop(((Float) obj).floatValue());
            } else if (str.equals("scaleX")) {
                setScaleX(((Float) obj).floatValue());
            } else if (str.equals("scaleY")) {
                setScaleY(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.ROTATION_X)) {
                setRotationX(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.ROTATION_Y)) {
                setRotationY(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.ALPHA)) {
                setAlpha(((Float) obj).floatValue());
            } else if (str.equals("rotation")) {
                setRotation(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.PIVOT_X)) {
                setPivotX(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.PIVOT_Y)) {
                setPivotY(((Float) obj).floatValue());
            } else if (str.equals(ViewTweenItem.TRACK_PATH)) {
                setTrackPath((List) obj);
            }
        } catch (ClassCastException e4) {
            StringBuilder sbW = g.w("the value type of the property ", str, " is illegal:");
            sbW.append(e4.getMessage());
            Log.e(Config.MOVELINE_LOG_TAG, sbW.toString());
        }
        this.mToUpdateStyles.add(str);
    }

    public void setRotation(float f4) {
        this.mStyleValueMap.put("rotation", Float.valueOf(f4));
    }

    public void setRotationX(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.ROTATION_X, Float.valueOf(f4));
    }

    public void setRotationY(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.ROTATION_Y, Float.valueOf(f4));
    }

    public void setScaleX(float f4) {
        this.mStyleValueMap.put("scaleX", Float.valueOf(f4));
    }

    public void setScaleY(float f4) {
        this.mStyleValueMap.put("scaleY", Float.valueOf(f4));
    }

    public void setTop(float f4) {
        this.mStyleValueMap.put(ViewTweenItem.TOP, Float.valueOf(f4));
    }

    public void setTrackPath(List<float[]> list) {
        PathMeasure pathMeasureBuildPathMeasure = buildPathMeasure(list);
        if (pathMeasureBuildPathMeasure != null) {
            this.mStyleValueMap.put(ViewTweenItem.TRACK_PATH, pathMeasureBuildPathMeasure);
        }
    }
}
