package android.content.res.stepostheme.iconfilter.utils;

/* loaded from: classes.dex */
public class ConstrainUtils {
    public static int constrain(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static float constrain(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static float constrainLoop(float value, float min, float max) {
        float range = max - min;
        while (value < min) {
            value += range;
        }
        while (value >= max) {
            value -= range;
        }
        return value;
    }
}
