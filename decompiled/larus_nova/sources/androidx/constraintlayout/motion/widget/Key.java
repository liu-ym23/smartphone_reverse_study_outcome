package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes17.dex */
public abstract class Key {
    static final String ALPHA = "alpha";
    static final String CUSTOM = "CUSTOM";
    static final String ELEVATION = "elevation";
    static final String PIVOT_X = "transformPivotX";
    static final String PIVOT_Y = "transformPivotY";
    static final String PROGRESS = "progress";
    static final String ROTATION = "rotation";
    static final String ROTATION_X = "rotationX";
    static final String ROTATION_Y = "rotationY";
    static final String SCALE_X = "scaleX";
    static final String SCALE_Y = "scaleY";
    static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final String TRANSLATION_X = "translationX";
    static final String TRANSLATION_Y = "translationY";
    static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final String WAVE_OFFSET = "waveOffset";
    static final String WAVE_PERIOD = "wavePeriod";
    static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    public abstract void addValues(HashMap<String, SplineSet> r100);

    public abstract void getAttributeNames(HashSet<String> r100);

    public abstract void load(Context r100, AttributeSet r101);

    public void setInterpolation(HashMap<String, Integer> r100) {
    }

    public abstract void setValue(String r100, Object r101);

    public Key() {
        int r100 = UNSET;
        this.mFramePosition = r100;
        this.mTargetId = r100;
        this.mTargetString = null;
    }

    public boolean matches(String r100) {
        String r101 = this.mTargetString;
        if (r101 == null) goto L8;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.matches(r101);
    L8:
        return false;
    }

    public boolean toBoolean(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L6;
        return ((Boolean) r100).booleanValue();
    L6:
        return Boolean.parseBoolean(r100.toString());
    }

    public float toFloat(Object r100) {
        if ((r100 instanceof Float) == false) goto L6;
        return ((Float) r100).floatValue();
    L6:
        return CastFloatProtector.parseFloat(r100.toString());
    }

    public int toInt(Object r100) {
        if ((r100 instanceof Integer) == false) goto L6;
        return ((Integer) r100).intValue();
    L6:
        return CastIntegerProtector.parseInt(r100.toString());
    }
}
