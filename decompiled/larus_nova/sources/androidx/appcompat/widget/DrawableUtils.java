package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
        sInsetsClazz = INVOKESTATIC_androidx_appcompat_widget_DrawableUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.Insets");     // Catch: ClassNotFoundException -> L5
        return;
    }

    private DrawableUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_widget_DrawableUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(Drawable r100) {
        if ((r100 instanceof DrawableContainer) == false) goto L13;
        Drawable.ConstantState r101 = r100.getConstantState();
        if ((r101 instanceof DrawableContainer.DrawableContainerState) == false) goto L24;
        Drawable[] r102 = ((DrawableContainer.DrawableContainerState) r101).getChildren();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L29;
        if (canSafelyMutateDrawable(r102[r104]) == false) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return false;
    L29:
        return true;
    L24:
        return true;
    L13:
        if ((r100 instanceof WrappedDrawable) == false) goto L17;
        return canSafelyMutateDrawable(((WrappedDrawable) r100).getWrappedDrawable());
    L17:
        if ((r100 instanceof DrawableWrapper) == false) goto L21;
        return canSafelyMutateDrawable(((DrawableWrapper) r100).getWrappedDrawable());
    L21:
        if ((r100 instanceof ScaleDrawable) == true) goto L23;
        return true;
    L23:
        return canSafelyMutateDrawable(((ScaleDrawable) r100).getDrawable());
    }

    public static void fixDrawable(Drawable r100) {
        if (Build.VERSION.SDK_INT == 21) goto L5;
        return;
    L5:
        if (VECTOR_DRAWABLE_CLAZZ_NAME.equals(r100.getClass().getName()) == false) goto L9;
        fixVectorDrawableTinting(r100);
        return;
    }

    private static void fixVectorDrawableTinting(Drawable r100) {
        int[] r101 = r100.getState();
        if (r101 != null) goto L5;
    L8:
        r100.setState(CHECKED_STATE_SET);
    L9:
        r100.setState(r101);
        return;
    L5:
        if (r101.length == 0) goto L8;
        r100.setState(EMPTY_STATE_SET);
        goto L9
    }

    public static Rect getOpticalBounds(Drawable r110) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Insets r111 = r110.getOpticalInsets();
        Rect r100 = new Rect();
        r100.left = r111.left;
        r100.right = r111.right;
        r100.top = r111.top;
        r100.bottom = r111.bottom;
        return r100;
    L7:
        if (sInsetsClazz == null) goto L40;
        Drawable r112 = DrawableCompat.unwrap(r110);     // Catch: Exception -> L41
        Object r113 = r112.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(r112, new Object[0]);     // Catch: Exception -> L41
        if (r113 == null) goto L40;
        Rect r101 = new Rect();     // Catch: Exception -> L41
        Field[] r102 = sInsetsClazz.getFields();     // Catch: Exception -> L41
        int r103 = r102.length;     // Catch: Exception -> L41
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L38;
        Field r105 = r102[r104];     // Catch: Exception -> L41
        String r106 = r105.getName();     // Catch: Exception -> L41
        switch(r106.hashCode()) {
            case -1383228885: goto L25;
            case 115029: goto L22;
            case 3317767: goto L19;
            case 108511772: goto L16;
            default: goto L27;
        };     // Catch: Exception -> L41
    L27:
        byte r107 = -1;
    L28:
        if (r107 == 0) goto L36;
        if (r107 == 1) goto L35;
        if (r107 == 2) goto L34;
        if (r107 != 3) goto L37;
        r101.bottom = r105.getInt(r113);     // Catch: Exception -> L41
    L37:
        r104 = r104 + 1;
        goto L11
    L34:
        r101.right = r105.getInt(r113);     // Catch: Exception -> L41
        goto L37
    L35:
        r101.top = r105.getInt(r113);     // Catch: Exception -> L41
        goto L37
    L36:
        r101.left = r105.getInt(r113);     // Catch: Exception -> L41
        goto L37
    L16:
        if (r106.equals("right") == false) goto L27;
        r107 = 2;
        goto L28
    L19:
        if (r106.equals("left") == false) goto L27;
        r107 = 0;
        goto L28
    L22:
        if (r106.equals("top") == false) goto L27;
        r107 = 1;
        goto L28
    L25:
        if (r106.equals("bottom") == false) goto L27;
        r107 = 3;
        goto L28
    L38:
        return r101;
    L40:
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int r100, PorterDuff.Mode r101) {
        if (r100 == 3) goto L21;
        if (r100 == 5) goto L19;
        if (r100 == 9) goto L17;
        switch(r100) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r101;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
