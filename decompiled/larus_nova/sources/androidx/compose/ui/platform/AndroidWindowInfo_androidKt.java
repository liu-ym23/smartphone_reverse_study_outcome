package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.compose.ui.unit.IntSize;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0082\u0010\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¨\u0006\u0014"}, d2 = {"calculateWindowSize", "Landroidx/compose/ui/unit/IntSize;", "androidComposeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)J", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "getNavigationBarHeight", "", PerfLog.PARAM_KEY_CONTEXT_ID, "getRectSizeFromDisplay", "", "activity", "bounds", "Landroid/graphics/Rect;", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidWindowInfo_androidKt {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_compose_ui_platform_AndroidWindowInfo_androidKt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static DisplayMetrics INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidWindowInfo_androidKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final /* synthetic */ DisplayCutout access$getCutoutForDisplay(Display r100) {
        return getCutoutForDisplay(r100);
    }

    public static final /* synthetic */ int access$getNavigationBarHeight(Context r100) {
        return getNavigationBarHeight(r100);
    }

    public static final long calculateWindowSize(AndroidComposeView r100) {
        Context r101 = r100.getContext();
        Activity r102 = findActivity(r101);
        if (r102 == null) goto L6;
        Rect r103 = BoundsHelper.Companion.getInstance().currentWindowBounds(r102);
        return IntSize.m7714constructorimpl((((long) r103.height()) & BodyPartID.bodyIdMax) | (((long) r103.width()) << 32));
    L6:
        Configuration r104 = r101.getResources().getConfiguration();
        float r105 = INVOKEVIRTUAL_androidx_compose_ui_platform_AndroidWindowInfo_androidKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()).density;
        int r106 = Math.round(r104.screenWidthDp * r105);
        return IntSize.m7714constructorimpl((((long) Math.round(r104.screenHeightDp * r105)) & BodyPartID.bodyIdMax) | (((long) r106) << 32));
    }

    private static final Activity findActivity(Context r100) {
    L3:
        if ((r100 instanceof Activity) == true) goto L12;
        if ((r100 instanceof ContextWrapper) == false) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L8:
        return null;
    L12:
        return (Activity) r100;
    }

    private static final DisplayCutout getCutoutForDisplay(Display r100) {
        Constructor r101 = INVOKESTATIC_androidx_compose_ui_platform_AndroidWindowInfo_androidKt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.DisplayInfo").getConstructor(new Class[0]);     // Catch: Exception -> L6
        r101.setAccessible(true);     // Catch: Exception -> L6
        Object r102 = r101.newInstance(new Object[0]);     // Catch: Exception -> L6
        Method r103 = r100.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r102.getClass()});     // Catch: Exception -> L6
        r103.setAccessible(true);     // Catch: Exception -> L6
        r103.invoke(r100, new Object[]{r102});     // Catch: Exception -> L6
        Field r104 = r102.getClass().getDeclaredField("displayCutout");     // Catch: Exception -> L6
        r104.setAccessible(true);     // Catch: Exception -> L6
        Object r105 = r104.get(r102);     // Catch: Exception -> L6
        if ((r105 instanceof DisplayCutout) == false) goto L21;
        return (DisplayCutout) r105;
    L21:
        return null;
    L6:
        e = move-exception;
        if ((e instanceof ClassNotFoundException) == true) goto L21;
        if ((e instanceof NoSuchMethodException) == true) goto L21;
        if ((e instanceof NoSuchFieldException) == true) goto L21;
        if ((e instanceof IllegalAccessException) == true) goto L21;
        if ((e instanceof InvocationTargetException) == true) goto L21;
        if ((e instanceof InstantiationException) == true) goto L21;
        throw e;
    }

    private static final int getNavigationBarHeight(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 > 0) goto L7;
        return 0;
    L7:
        return r101.getDimensionPixelSize(r102);
    }

    public static final /* synthetic */ void access$getRectSizeFromDisplay(Activity r100, Rect r101) {
        getRectSizeFromDisplay(r100, r101);
    }

    private static final void getRectSizeFromDisplay(Activity r100, Rect r101) {
        r100.getWindowManager().getDefaultDisplay().getRectSize(r101);
    }
}
