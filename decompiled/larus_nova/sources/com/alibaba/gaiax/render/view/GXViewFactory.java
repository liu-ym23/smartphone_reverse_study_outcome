package com.alibaba.gaiax.render.view;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.render.view.basic.GXIconFont;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alibaba.gaiax.render.view.basic.GXProgressView;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import com.alibaba.gaiax.render.view.basic.GXText;
import com.alibaba.gaiax.render.view.basic.GXView;
import com.alibaba.gaiax.render.view.container.GXGridView;
import com.alibaba.gaiax.render.view.container.GXScrollView;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J/\u0010\u0014\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0016J$\u0010\u0014\u001a\u00020\b\"\b\b\u0000\u0010\u000f*\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002R,\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXViewFactory;", "", "()V", "viewCreatorSupport", "", "", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "getViewCreatorSupport$GaiaX", "()Ljava/util/Map;", "viewSupport", "Ljava/lang/Class;", "getViewSupport$GaiaX", "createView", ExifInterface.GPS_DIRECTION_TRUE, PerfLog.PARAM_KEY_CONTEXT_ID, "type", "customViewClass", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;", "newInstance", "clazz", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXViewFactory {
    public static final GXViewFactory INSTANCE = null;
    private static final Map<String, Function1<Context, View>> viewCreatorSupport = null;
    private static final Map<String, Class<?>> viewSupport = null;

    private GXViewFactory() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        INSTANCE = new GXViewFactory();
        LinkedHashMap r100 = new LinkedHashMap();
        viewSupport = r100;
        viewCreatorSupport = new LinkedHashMap();
        r100.put(GXViewKey.VIEW_TYPE_GAIA_TEMPLATE, GXView.class);
        r100.put("view", GXView.class);
        r100.put("text", GXText.class);
        r100.put(GXViewKey.VIEW_TYPE_RICH_TEXT, GXText.class);
        r100.put("image", GXImageView.class);
        r100.put(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, GXScrollView.class);
        r100.put(GXViewKey.VIEW_TYPE_CONTAINER_GRID, GXGridView.class);
        r100.put("iconfont", GXIconFont.class);
        r100.put(GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, GXShadowLayout.class);
        r100.put(GXViewKey.VIEW_TYPE_CONTAINER_SLIDER, GXSliderView.class);
        r100.put("progress", GXProgressView.class);
    }

    public final Map<String, Function1<Context, View>> getViewCreatorSupport$GaiaX() {
        return viewCreatorSupport;
    }

    public final Map<String, Class<?>> getViewSupport$GaiaX() {
        return viewSupport;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_gaiax_render_view_GXViewFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private final <T extends View> View newInstance(String r100, Context r101) {
        if (r100 == null) goto L5;
        Object r102 = INVOKESTATIC_com_alibaba_gaiax_render_view_GXViewFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r101});
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.newInstance");
        return (View) r102;
    L5:
        return new GXView(r101);
    }

    private final <T extends View> T newInstance(Class<?> r100, Context r101) {
        if (r100 == null) goto L4;
        Object r102 = r100.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r101});
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.alibaba.gaiax.render.view.GXViewFactory.newInstance");
        return (T) r102;
    L4:
        return null;
    }

    public final <T extends View> T createView(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        T r103 = null;
        if (Intrinsics.areEqual("custom", r101) == false) goto L8;
        if (r102 == null) goto L8;
        View r104 = newInstance(r102, r100);     // Catch: Exception -> L18
    L7:
        r103 = (T) r104;
    L8:
        Map<String, Class<?>> r105 = viewSupport;     // Catch: Exception -> L18
        if (r105.containsKey(r101) == false) goto L11;
        r104 = newInstance(r105.get(r101), r100);     // Catch: Exception -> L18
        goto L7
    L11:
        Function1<Context, View> r106 = viewCreatorSupport.get(r101);     // Catch: Exception -> L18
        if (r106 == null) goto L15;
        r104 = r106.invoke(r100);     // Catch: Exception -> L18
    L15:
        if (r103 == null) goto L17;
        return r103;
    L17:
        return (T) new View(r100);
    }

    public static /* synthetic */ View createView$default(GXViewFactory r100, Context r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.createView(r101, r102, r103);
    }
}
