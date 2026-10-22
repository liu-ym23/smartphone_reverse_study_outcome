package com.stepos.motionkit.fx.material;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0013J\u001f\u0010\u001a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001a\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001b\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u0016J'\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001f\u0010 J?\u0010%\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0010H\u0007¢\u0006\u0004\b%\u0010&J?\u0010-\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0010H\u0007¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0014H\u0007¢\u0006\u0004\b0\u0010\u0016J7\u00105\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0014H\u0007¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0014H\u0007¢\u0006\u0004\b8\u0010\u0016J\u001f\u00109\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b9\u0010:J'\u0010=\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u0010H\u0007¢\u0006\u0004\b=\u0010 J\u001f\u0010>\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0014H\u0007¢\u0006\u0004\b>\u0010\u0016J\u001f\u0010?\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0014H\u0007¢\u0006\u0004\b?\u0010\u0016JG\u0010C\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0014H\u0007¢\u0006\u0004\bC\u0010DJ/\u0010F\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0007¢\u0006\u0004\bF\u0010GJ\u001f\u0010I\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0014H\u0007¢\u0006\u0004\bI\u0010\u0016J\u001f\u0010K\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u0014H\u0007¢\u0006\u0004\bK\u0010\u0016J'\u0010O\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020LH\u0007¢\u0006\u0004\bO\u0010PJI\u0010V\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010R\u001a\u00020Q2\u0010\u0010M\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030T0S2\u0016\u0010U\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010S\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\bV\u0010WR\u0018\u0010X\u001a\u0006\u0012\u0002\b\u00030T8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0006\u0012\u0002\b\u00030T8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010YR\u0018\u0010[\u001a\u0006\u0012\u0002\b\u00030T8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010YR\u001a\u0010\\\u001a\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010\u0003\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/stepos/motionkit/fx/material/CrossWindowGlass;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "host", "Landroid/graphics/drawable/Drawable;", "create", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "Landroid/view/Window;", "window", "(Landroid/view/Window;)Landroid/graphics/drawable/Drawable;", "glass", "LC7/r;", "release", "(Landroid/graphics/drawable/Drawable;)V", "", "px", "setBlurRadius", "(Landroid/graphics/drawable/Drawable;I)V", "", "setCornerRadius", "(Landroid/graphics/drawable/Drawable;F)V", "argb", "setColor", "value", "setFrost", "setDodge", "setOverlay", "mode", "scale", "setBlurGradient", "(Landroid/graphics/drawable/Drawable;II)V", "start", "middle", "end", "midpoint", "setColorGradient", "(Landroid/graphics/drawable/Drawable;IIIFI)V", "", "enabled", "width", "softness", "intensity", TypedValues.Custom.S_COLOR, "setGlassStroke", "(Landroid/graphics/drawable/Drawable;ZFFFI)V", "spread", "setStrokeSpread", "l0x", "l0y", "l1x", "l1y", "setLightDirs", "(Landroid/graphics/drawable/Drawable;FFFF)V", "ambient", "setAmbient", "setAnisoRim", "(Landroid/graphics/drawable/Drawable;Z)V", "edgeColor", "darkColor", "setEdgeColors", "setDarkWidth", "setEdgeWidth", "radius", "offsetX", "offsetY", "setInnerShadow", "(Landroid/graphics/drawable/Drawable;ZIFFFF)V", "strength", "setRefraction", "(Landroid/graphics/drawable/Drawable;ZFF)V", "depth", "setRefractionDepth", "dispersion", "setDispersion", "", "types", "colors", "setBlendArray", "(Landroid/graphics/drawable/Drawable;[I[I)V", "", HintConstants.AUTOFILL_HINT_NAME, "", "Ljava/lang/Class;", "args", "call", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "I", "Ljava/lang/Class;", "F", "B", "isAvailable", "()Z", "isAvailable$annotations", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrossWindowGlass {
    public static final Class<?> B;
    public static final Class<?> F;
    public static final Class<?> I;
    public static final CrossWindowGlass INSTANCE = new CrossWindowGlass();

    static {
        CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
        I = crossWindowMaterialBackend.getI();
        F = crossWindowMaterialBackend.getF();
        B = crossWindowMaterialBackend.getB();
    }

    private CrossWindowGlass() {
    }

    public static final void call(Drawable glass, String name, Class<?>[] types, Object... args) {
        k.f(glass, "glass");
        k.f(name, "name");
        k.f(types, "types");
        k.f(args, "args");
        CrossWindowMaterialBackend.INSTANCE.call(glass, name, types, Arrays.copyOf(args, args.length));
    }

    public static final Drawable create(View host) {
        k.f(host, "host");
        return CrossWindowMaterialBackend.INSTANCE.createRawDrawable$motionkit_fx_release(host);
    }

    public static final boolean isAvailable() {
        return CrossWindowMaterialBackend.INSTANCE.isAvailable();
    }

    public static /* synthetic */ void isAvailable$annotations() {
    }

    public static final void release(Drawable glass) {
        k.f(glass, "glass");
        glass.setVisible(false, false);
        glass.setCallback(null);
    }

    public static final void setAmbient(Drawable glass, float ambient) {
        k.f(glass, "glass");
        call(glass, "setAmbient", new Class[]{F}, Float.valueOf(ambient));
    }

    public static final void setAnisoRim(Drawable glass, boolean enabled) {
        k.f(glass, "glass");
        call(glass, "setAnisoRim", new Class[]{B}, Boolean.valueOf(enabled));
    }

    public static final void setBlendArray(Drawable glass, int[] types, int[] colors) {
        k.f(glass, "glass");
        k.f(types, "types");
        k.f(colors, "colors");
        call(glass, "setBlendArray", new Class[]{int[].class, int[].class}, types, colors);
    }

    public static final void setBlurGradient(Drawable glass, int mode, int scale) {
        k.f(glass, "glass");
        Class<?> cls = I;
        call(glass, "setBlurGradient", new Class[]{cls, cls}, Integer.valueOf(mode), Integer.valueOf(scale));
    }

    public static final void setBlurRadius(Drawable glass, int px) {
        k.f(glass, "glass");
        call(glass, "setBlurRadius", new Class[]{I}, Integer.valueOf(px));
    }

    public static final void setColor(Drawable glass, int argb) {
        k.f(glass, "glass");
        call(glass, "setColor", new Class[]{I}, Integer.valueOf(argb));
    }

    public static final void setColorGradient(Drawable glass, int start, int middle, int end, float midpoint, int mode) {
        k.f(glass, "glass");
        Class<?> cls = I;
        call(glass, "setColorGradient", new Class[]{cls, cls, cls, F, cls}, Integer.valueOf(start), Integer.valueOf(middle), Integer.valueOf(end), Float.valueOf(midpoint), Integer.valueOf(mode));
    }

    public static final void setCornerRadius(Drawable glass, float px) {
        k.f(glass, "glass");
        call(glass, "setCornerRadius", new Class[]{F}, Float.valueOf(px));
    }

    public static final void setDarkWidth(Drawable glass, float px) {
        k.f(glass, "glass");
        call(glass, "setDarkWidth", new Class[]{F}, Float.valueOf(px));
    }

    public static final void setDispersion(Drawable glass, float dispersion) {
        k.f(glass, "glass");
        call(glass, "setDispersion", new Class[]{F}, Float.valueOf(dispersion));
    }

    public static final void setDodge(Drawable glass, float value) {
        k.f(glass, "glass");
        call(glass, "setDodge", new Class[]{F}, Float.valueOf(value));
    }

    public static final void setEdgeColors(Drawable glass, int edgeColor, int darkColor) {
        k.f(glass, "glass");
        Class<?> cls = I;
        call(glass, "setEdgeColors", new Class[]{cls, cls}, Integer.valueOf(edgeColor), Integer.valueOf(darkColor));
    }

    public static final void setEdgeWidth(Drawable glass, float px) {
        k.f(glass, "glass");
        call(glass, "setEdgeWidth", new Class[]{F}, Float.valueOf(px));
    }

    public static final void setFrost(Drawable glass, float value) {
        k.f(glass, "glass");
        call(glass, "setFrost", new Class[]{F}, Float.valueOf(value));
    }

    public static final void setGlassStroke(Drawable glass, boolean enabled, float width, float softness, float intensity, int color) {
        k.f(glass, "glass");
        Class<?> cls = B;
        Class<?> cls2 = F;
        call(glass, "setGlassStroke", new Class[]{cls, cls2, cls2, cls2, I}, Boolean.valueOf(enabled), Float.valueOf(width), Float.valueOf(softness), Float.valueOf(intensity), Integer.valueOf(color));
    }

    public static final void setInnerShadow(Drawable glass, boolean enabled, int color, float radius, float offsetX, float offsetY, float intensity) {
        k.f(glass, "glass");
        Class<?> cls = B;
        Class<?> cls2 = I;
        Class<?> cls3 = F;
        call(glass, "setInnerShadow", new Class[]{cls, cls2, cls3, cls3, cls3, cls3}, Boolean.valueOf(enabled), Integer.valueOf(color), Float.valueOf(radius), Float.valueOf(offsetX), Float.valueOf(offsetY), Float.valueOf(intensity));
    }

    public static final void setLightDirs(Drawable glass, float l0x, float l0y, float l1x, float l1y) {
        k.f(glass, "glass");
        Class<?> cls = F;
        call(glass, "setLightDirs", new Class[]{cls, cls, cls, cls}, Float.valueOf(l0x), Float.valueOf(l0y), Float.valueOf(l1x), Float.valueOf(l1y));
    }

    public static final void setOverlay(Drawable glass, float value) {
        k.f(glass, "glass");
        call(glass, "setOverlay", new Class[]{F}, Float.valueOf(value));
    }

    public static final void setRefraction(Drawable glass, boolean enabled, float strength, float width) {
        k.f(glass, "glass");
        Class<?> cls = B;
        Class<?> cls2 = F;
        call(glass, "setRefraction", new Class[]{cls, cls2, cls2}, Boolean.valueOf(enabled), Float.valueOf(strength), Float.valueOf(width));
    }

    public static final void setRefractionDepth(Drawable glass, float depth) {
        k.f(glass, "glass");
        call(glass, "setRefractionDepth", new Class[]{F}, Float.valueOf(depth));
    }

    public static final void setStrokeSpread(Drawable glass, float spread) {
        k.f(glass, "glass");
        call(glass, "setStrokeSpread", new Class[]{F}, Float.valueOf(spread));
    }

    public static final Drawable create(Window window) {
        k.f(window, "window");
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            return null;
        }
        return CrossWindowMaterialBackend.INSTANCE.createRawDrawable$motionkit_fx_release(viewPeekDecorView);
    }
}
