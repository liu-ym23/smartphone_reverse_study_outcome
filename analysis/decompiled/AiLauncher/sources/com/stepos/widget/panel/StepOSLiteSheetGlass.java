package com.stepos.widget.panel;

import Y8.t;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.stepos.widget.glass.GlassDelegate;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import y7.C5945a;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetGlass;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "LY8/t;", "clearMaterial", "()V", "", "topRadius", "bottomRadius", "", "blur", "tint", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(FFII)V", "release", "Landroid/view/View;", "Lcom/stepos/widget/glass/GlassDelegate;", "delegate", "Lcom/stepos/widget/glass/GlassDelegate;", "", "attempted", "Z", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "Ljava/lang/reflect/Method;", "setCorners", "Ljava/lang/reflect/Method;", "appliedBlur", "Ljava/lang/Integer;", "appliedTint", "Lcom/stepos/widget/panel/StepOSLiteSheetCorners;", "corners", "Lcom/stepos/widget/panel/StepOSLiteSheetCorners;", "isActive", "()Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetGlass {
    private Integer appliedBlur;
    private Integer appliedTint;
    private boolean attempted;
    private final StepOSLiteSheetCorners corners;
    private final GlassDelegate delegate;
    private Drawable drawable;
    private Method setCorners;
    private final View view;

    public StepOSLiteSheetGlass(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
        this.delegate = new GlassDelegate(view);
        this.corners = new StepOSLiteSheetCorners(new p9.p() { // from class: com.stepos.widget.panel.p
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return StepOSLiteSheetGlass.corners$lambda$1(this.f31298a, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        }, new InterfaceC5074l() { // from class: com.stepos.widget.panel.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSLiteSheetGlass.corners$lambda$2(this.f31299a, ((Float) obj).floatValue());
            }
        }, new InterfaceC5074l() { // from class: com.stepos.widget.panel.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSLiteSheetGlass.corners$lambda$3((Exception) obj);
            }
        });
    }

    private final void clearMaterial() {
        this.drawable = null;
        this.setCorners = null;
        this.appliedBlur = null;
        this.appliedTint = null;
        this.corners.reset();
        this.delegate.cancelCover$StepOSWidget_release();
        this.delegate.release$StepOSWidget_release();
        this.view.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t corners$lambda$1(StepOSLiteSheetGlass stepOSLiteSheetGlass, float f10, float f11) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = stepOSLiteSheetGlass.setCorners;
        if (method == null) {
            Class<?> cls = Class.forName("stepos.view.effects.StepOSBackdropLayer");
            Class cls2 = Float.TYPE;
            method = cls.getMethod("setCornerRadius", Drawable.class, cls2, cls2, cls2, cls2);
            stepOSLiteSheetGlass.setCorners = method;
        }
        Drawable drawable = stepOSLiteSheetGlass.drawable;
        if (drawable == null) {
            throw new IllegalStateException("Required value was null.");
        }
        method.invoke(null, drawable, Float.valueOf(f10), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f11));
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t corners$lambda$2(StepOSLiteSheetGlass stepOSLiteSheetGlass, float f10) {
        Drawable drawable = stepOSLiteSheetGlass.drawable;
        if (drawable == null) {
            throw new IllegalStateException("Required value was null.");
        }
        C5945a.e(drawable, f10);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t corners$lambda$3(Exception error) {
        kotlin.jvm.internal.p.i(error, "error");
        Log.w("StepOSLiteSheetGlass", "Corner update unavailable; keeping glass material", error);
        return t.f7040a;
    }

    public final boolean isActive() {
        return this.drawable != null && this.delegate.getIsActive();
    }

    public final void release() {
        clearMaterial();
        this.attempted = false;
    }

    public final void update(float topRadius, float bottomRadius, int blur, int tint) {
        if (!this.attempted || isActive()) {
            try {
                if (!this.attempted) {
                    this.attempted = true;
                    if (C5945a.b() && this.delegate.applyBlurOnly$StepOSWidget_release(1, topRadius, blur, tint)) {
                        Drawable background = this.view.getBackground();
                        if (background == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        this.drawable = background;
                    }
                    clearMaterial();
                    return;
                }
                Drawable drawable = this.drawable;
                if (drawable == null) {
                    return;
                }
                Integer num = this.appliedBlur;
                if (num == null || num.intValue() != blur) {
                    C5945a.c(drawable, blur);
                    this.appliedBlur = Integer.valueOf(blur);
                }
                Integer num2 = this.appliedTint;
                if (num2 == null || num2.intValue() != tint) {
                    C5945a.d(drawable, tint);
                    this.appliedTint = Integer.valueOf(tint);
                }
                this.corners.update(topRadius, bottomRadius);
            } catch (Exception e10) {
                Log.w("StepOSLiteSheetGlass", "Glass unavailable; using opaque sheet background", e10);
                clearMaterial();
            }
        }
    }
}
