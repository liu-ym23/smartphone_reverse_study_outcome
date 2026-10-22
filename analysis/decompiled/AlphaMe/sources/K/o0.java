package K;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f994a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f995b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f996c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f997d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f994a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f995b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f996c = declaredField3;
            declaredField3.setAccessible(true);
            f997d = true;
        } catch (ReflectiveOperationException e4) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e4.getMessage(), e4);
        }
    }
}
