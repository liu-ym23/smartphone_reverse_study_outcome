package V1;

import android.content.ComponentName;
import android.content.Context;
import com.stepos.digitalwellbeing.appwidget.DigitalWellbeingWidgetProvider2X2Histogram;
import com.stepos.digitalwellbeing.appwidget.DigitalWellbeingWidgetProvider2X2Text;
import com.stepos.digitalwellbeing.appwidget.DigitalWellbeingWidgetProvider4X2;
import com.stepos.digitalwellbeing.appwidget.DigitalWellbeingWidgetProvider4X4;
import e2.C0684b;

/* loaded from: classes.dex */
public class o {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5491a;

        static {
            int[] iArr = new int[A.values().length];
            f5491a = iArr;
            try {
                iArr[A.DIGITAL_WELLBEING_4x4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5491a[A.DIGITAL_WELLBEING_4x2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5491a[A.DIGITAL_WELLBEING_2x2_HISTOGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5491a[A.DIGITAL_WELLBEING_2x2_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static com.stepos.digitalwellbeing.appwidget.b a(Context context, A a6) {
        return b(context, a6, c(context, a6));
    }

    public static com.stepos.digitalwellbeing.appwidget.b b(Context context, A a6, ComponentName componentName) {
        if (C0684b.A()) {
            int i5 = a.f5491a[a6.ordinal()];
            if (i5 == 1) {
                return new w(context, componentName);
            }
            if (i5 == 2) {
                return new u(context, componentName);
            }
            if (i5 == 3) {
                return new q(context, componentName);
            }
            if (i5 != 4) {
                return null;
            }
            return new s(context, componentName);
        }
        int i6 = a.f5491a[a6.ordinal()];
        if (i6 == 1) {
            return new x(context, componentName);
        }
        if (i6 == 2) {
            return new v(context, componentName);
        }
        if (i6 == 3) {
            return new r(context, componentName);
        }
        if (i6 != 4) {
            return null;
        }
        return new t(context, componentName);
    }

    public static ComponentName c(Context context, A a6) {
        int i5 = a.f5491a[a6.ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? new ComponentName(context, (Class<?>) DigitalWellbeingWidgetProvider2X2Text.class) : new ComponentName(context, (Class<?>) DigitalWellbeingWidgetProvider2X2Histogram.class) : new ComponentName(context, (Class<?>) DigitalWellbeingWidgetProvider4X2.class) : new ComponentName(context, (Class<?>) DigitalWellbeingWidgetProvider4X4.class);
    }
}
