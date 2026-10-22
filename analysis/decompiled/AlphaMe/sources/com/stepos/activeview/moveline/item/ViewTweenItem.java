package com.stepos.activeview.moveline.item;

import B0.g;
import android.graphics.PathMeasure;
import android.util.Log;
import android.view.View;
import com.stepos.activeview.moveline.Config;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ViewTweenItem implements TweenItem {
    public static final String ALPHA = "alpha";
    public static final String LEFT = "left";
    public static final String PIVOT_X = "pivotX";
    public static final String PIVOT_Y = "pivotY";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TOP = "top";
    public static final String TRACK_PATH = "trackPath";
    protected WeakReference<View> mTarget;

    public ViewTweenItem(View view) {
        this.mTarget = new WeakReference<>(view);
    }

    @Override // com.stepos.activeview.moveline.item.TweenItem
    public FrameStyle buildFrameStyle() {
        return new ViewFrameStyle();
    }

    @Override // com.stepos.activeview.moveline.item.TweenItem
    public Object getPropertyValue(String str) {
        View view = this.mTarget.get();
        if (view == null) {
            return null;
        }
        if (str.equals(LEFT)) {
            return Float.valueOf(view.getTranslationX());
        }
        if (str.equals(TOP)) {
            return Float.valueOf(view.getTranslationY());
        }
        if (str.equals("scaleX")) {
            return Float.valueOf(view.getScaleX());
        }
        if (str.equals("scaleY")) {
            return Float.valueOf(view.getScaleY());
        }
        if (str.equals(ROTATION_X)) {
            return Float.valueOf(view.getRotationX());
        }
        if (str.equals(ROTATION_Y)) {
            return Float.valueOf(view.getRotationY());
        }
        if (str.equals(ALPHA)) {
            return Float.valueOf(view.getAlpha());
        }
        if (str.equals("rotation")) {
            return Float.valueOf(view.getRotation());
        }
        if (str.equals(PIVOT_X)) {
            return Float.valueOf(view.getPivotX());
        }
        if (str.equals(PIVOT_Y)) {
            return Float.valueOf(view.getPivotY());
        }
        str.equals(TRACK_PATH);
        return null;
    }

    @Override // com.stepos.activeview.moveline.item.TweenItem
    public boolean isUpdatable() {
        return this.mTarget.get() != null;
    }

    @Deprecated
    public void replaceTarget(View view) {
        this.mTarget = new WeakReference<>(view);
    }

    public void setTarget(View view) {
        this.mTarget = new WeakReference<>(view);
    }

    @Override // com.stepos.activeview.moveline.item.TweenItem
    public void updateProperty(String str, Object obj, float f4) {
        PathMeasure pathMeasure;
        View view = this.mTarget.get();
        if (view == null) {
            return;
        }
        try {
            if (str.equals(LEFT)) {
                view.setTranslationX(((Float) obj).floatValue());
            } else if (str.equals(TOP)) {
                view.setTranslationY(((Float) obj).floatValue());
            } else if (str.equals("scaleX")) {
                view.setScaleX(((Float) obj).floatValue());
            } else if (str.equals("scaleY")) {
                view.setScaleY(((Float) obj).floatValue());
            } else if (str.equals(ROTATION_X)) {
                view.setRotationX(((Float) obj).floatValue());
            } else if (str.equals(ROTATION_Y)) {
                view.setRotationY(((Float) obj).floatValue());
            } else if (str.equals(ALPHA)) {
                view.setAlpha(((Float) obj).floatValue());
            } else if (str.equals("rotation")) {
                view.setRotation(((Float) obj).floatValue());
            } else if (str.equals(PIVOT_X)) {
                view.setPivotX(((Float) obj).floatValue());
            } else if (str.equals(PIVOT_Y)) {
                view.setPivotY(((Float) obj).floatValue());
            } else if (str.equals(TRACK_PATH) && (obj instanceof Object[]) && (pathMeasure = (PathMeasure) ((Object[]) obj)[0]) != null) {
                float length = pathMeasure.getLength() * f4;
                float[] fArr = new float[2];
                pathMeasure.getPosTan(length, fArr, null);
                view.setTranslationX(fArr[0] - view.getPivotX());
                view.setTranslationY(fArr[1] - view.getPivotY());
            }
        } catch (ClassCastException e4) {
            StringBuilder sbW = g.w("the value type of the property ", str, " is illegal:");
            sbW.append(e4.getMessage());
            Log.e(Config.MOVELINE_LOG_TAG, sbW.toString());
        }
    }
}
