package com.stepos.activeview.moveline;

import com.stepos.activeview.moveline.item.FrameStyle;
import com.stepos.activeview.moveline.item.TweenItem;
import com.stepos.alphame.utils.Property;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class Tween extends Animation {
    private FrameStyle mFrameStyle;
    private TweenItem mTarget;
    private final Map<String, Object> mTargetFromValues;

    public Tween(TweenItem tweenItem, int i4, FrameStyle frameStyle, int i5) {
        this.mTarget = tweenItem;
        this.duration = i4;
        this.mFrameStyle = frameStyle;
        this.repeatDelayTime = i5;
        this.mTargetFromValues = new HashMap();
    }

    private void updateFrame(float f4) {
        Set<String> updateProperties;
        Object propertyValue;
        Float fValueOf;
        FrameStyle frameStyle = this.mFrameStyle;
        if (frameStyle == null || (updateProperties = frameStyle.getUpdateProperties()) == null || updateProperties.size() <= 0) {
            return;
        }
        for (String str : updateProperties) {
            FrameStyle.PropertyValueType propertyValueType = this.mFrameStyle.getPropertyValueType(str);
            if (this.mTargetFromValues.containsKey(str)) {
                propertyValue = this.mTargetFromValues.get(str);
            } else {
                propertyValue = this.mTarget.getPropertyValue(str);
                this.mTargetFromValues.put(str, propertyValue);
            }
            Object propertyValue2 = this.mFrameStyle.getPropertyValue(str);
            if (propertyValue == null) {
                propertyValue = propertyValue2;
            }
            if (propertyValue == null || propertyValue2 == null) {
                return;
            }
            if (propertyValueType == FrameStyle.PropertyValueType.OTHER) {
                this.mTarget.updateProperty(str, new Object[]{propertyValue, propertyValue2}, f4);
            } else {
                if (propertyValueType == FrameStyle.PropertyValueType.INT) {
                    fValueOf = Float.valueOf(((((Integer) propertyValue2).intValue() - r2) * f4) + ((Integer) propertyValue).intValue());
                } else {
                    float fFloatValue = ((Float) propertyValue).floatValue();
                    fValueOf = Float.valueOf(((((Float) propertyValue2).floatValue() - fFloatValue) * f4) + fFloatValue);
                }
                this.mTarget.updateProperty(str, fValueOf, f4);
            }
        }
    }

    @Override // com.stepos.activeview.moveline.Animation
    public FrameStyle getFrameStyle() {
        return this.mFrameStyle;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void initAnimationValue() {
        if (this.mTargetFromValues.size() > 0) {
            for (Map.Entry<String, Object> entry : this.mTargetFromValues.entrySet()) {
                this.mTarget.updateProperty(entry.getKey(), entry.getValue(), Property.DEFAULT_FLOAT_VALUE);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    @Override // com.stepos.activeview.moveline.Animation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(long r8) {
        /*
            r7 = this;
            long r0 = r7.time
            int r2 = r7.duration
            long r3 = (long) r2
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r3 < 0) goto L10
            long r8 = (long) r2
            r7.time = r8
        Le:
            r8 = r4
            goto L1c
        L10:
            r2 = 0
            int r6 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r6 >= 0) goto L19
            r7.time = r2
            goto Le
        L19:
            r7.time = r8
            r8 = r5
        L1c:
            long r2 = r7.time
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 != 0) goto L23
            return
        L23:
            int r9 = r7.mPlayingState
            if (r9 == r4) goto L2c
            r7.mPlayingState = r4
            r7.notifyStartListeners()
        L2c:
            boolean r9 = r7.isActive
            if (r9 != 0) goto L32
            r7.isActive = r4
        L32:
            com.stepos.activeview.moveline.item.TweenItem r9 = r7.mTarget
            boolean r9 = r9.isUpdatable()
            if (r9 != 0) goto L3b
            goto L68
        L3b:
            long r0 = r7.time
            float r9 = (float) r0
            int r0 = r7.duration
            float r0 = (float) r0
            float r9 = r9 / r0
            android.view.animation.Interpolator r0 = r7.getInterpolator()
            if (r0 == 0) goto L51
            android.view.animation.Interpolator r0 = r7.getInterpolator()
            float r9 = r0.getInterpolation(r9)
            goto L63
        L51:
            com.stepos.activeview.moveline.BaseTimeline r0 = r7.timeline
            android.view.animation.Interpolator r0 = r0.getInterpolator()
            if (r0 == 0) goto L63
            com.stepos.activeview.moveline.BaseTimeline r0 = r7.timeline
            android.view.animation.Interpolator r0 = r0.getInterpolator()
            float r9 = r0.getInterpolation(r9)
        L63:
            r7.updateFrame(r9)
            if (r8 == 0) goto L70
        L68:
            r7.setActive(r5)
            r7.mPlayingState = r5
            r7.notifyEndListeners()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.moveline.Tween.update(long):void");
    }
}
