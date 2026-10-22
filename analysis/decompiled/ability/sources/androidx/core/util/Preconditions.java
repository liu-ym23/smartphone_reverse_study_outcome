package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f, String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.l(str, " must not be NaN"));
        }
        if (Float.isInfinite(f)) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.l(str, " must not be infinite"));
        }
        return f;
    }

    public static int checkArgumentInRange(int i, int i6, int i10, String str) {
        if (i < i6) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i6 + ", " + i10 + "] (too low)");
        }
        if (i <= i10) {
            return i;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i6 + ", " + i10 + "] (too high)");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i, int i6) {
        if ((i & i6) == i) {
            return i;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i6) + " are allowed");
    }

    public static <T> T checkNotNull(T t9) {
        t9.getClass();
        return t9;
    }

    public static void checkState(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t9) {
        if (TextUtils.isEmpty(t9)) {
            throw new IllegalArgumentException();
        }
        return t9;
    }

    public static void checkArgument(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t9, Object obj) {
        if (t9 != null) {
            return t9;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z10) {
        checkState(z10, null);
    }

    public static void checkArgument(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t9, Object obj) {
        if (TextUtils.isEmpty(t9)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t9;
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t9, String str, Object... objArr) {
        if (TextUtils.isEmpty(t9)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t9;
    }

    public static long checkArgumentInRange(long j5, long j6, long j10, String str) {
        if (j5 < j6) {
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is out of range of [");
            sb.append(j6);
            sb.append(", ");
            throw new IllegalArgumentException(androidx.constraintlayout.core.dsl.a.e(j10, "] (too low)", sb));
        }
        if (j5 <= j10) {
            return j5;
        }
        Locale locale2 = Locale.US;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" is out of range of [");
        sb2.append(j6);
        sb2.append(", ");
        throw new IllegalArgumentException(androidx.constraintlayout.core.dsl.a.e(j10, "] (too high)", sb2));
    }

    public static float checkArgumentInRange(float f, float f7, float f9, String str) {
        if (f < f7) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f7), Float.valueOf(f9)));
        }
        if (f <= f9) {
            return f;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f7), Float.valueOf(f9)));
    }

    public static double checkArgumentInRange(double d, double d6, double d10, String str) {
        if (d < d6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d6), Double.valueOf(d10)));
        }
        if (d <= d10) {
            return d;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d6), Double.valueOf(d10)));
    }
}
