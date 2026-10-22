package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f8141a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f8142b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f8143c = new Rect();

    static class a {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    @Deprecated
    public static boolean a(Drawable drawable) {
        return true;
    }

    static void b(Drawable drawable) {
        drawable.getClass();
    }

    public static Rect c(Drawable drawable) {
        Insets insetsA = a.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode d(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
