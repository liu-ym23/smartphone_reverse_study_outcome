package g;

import android.widget.TextView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b0 {
    public static int a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    public static void b(TextView textView, int i8, int i9, int i10, int i11) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i8, i9, i10, i11);
    }

    public static void c(TextView textView, int[] iArr, int i8) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i8);
    }

    public static boolean d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
