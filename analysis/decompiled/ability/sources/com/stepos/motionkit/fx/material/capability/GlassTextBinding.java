package com.stepos.motionkit.fx.material.capability;

import C7.r;
import Ca.C0204c;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextClock;
import android.widget.TextView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialBinding;
import com.stepos.motionkit.fx.material.MaterialParams;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n*\u0003HKN\b\u0000\u0018\u0000 V2\u00020\u0001:\u0001VB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u0011J!\u0010!\u001a\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010-R\"\u00100\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00020\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010-R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010-R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010-R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010-R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010-R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010Q\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding;", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "token", "", "useTextMask", "hasBackdropBlur", AppAgent.CONSTRUCT, "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;ZZ)V", "v", "LC7/r;", "hideHostText", "(Landroid/view/View;)V", "restoreHostText", "detachPreDraw", "()V", "scheduleRefreshOnPreDraw", "Landroid/graphics/Path;", "glyph", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "p", "pushGlyph", "(Landroid/graphics/Path;Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;)V", "Ljava/lang/Class;", "ppClass", "", "newPathProvider", "(Ljava/lang/Class;)Ljava/lang/Object;", "refreshGlassText", "Lkotlin/Function1;", "block", "mergeGlassText", "(LS7/k;)V", "", "text", "setClockText", "(Ljava/lang/String;)V", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "params", "update", "(Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "release", "Lcom/stepos/motionkit/fx/material/backend/CrossWindowMaterialBackend$Token;", "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "lastParams", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "livePath", "Landroid/graphics/Path;", "pathProvider", "Ljava/lang/Object;", "glassTextOn", "preDrawPending", "Landroid/view/ViewTreeObserver;", "preDrawObs", "refreshPendingOnAttach", "awaitingLayout", "", "scrollRetry", "I", "Landroid/content/res/ColorStateList;", "savedTextColors", "Landroid/content/res/ColorStateList;", "hostTextHidden", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "com/stepos/motionkit/fx/material/capability/GlassTextBinding$textWatcher$1", "textWatcher", "Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding$textWatcher$1;", "com/stepos/motionkit/fx/material/capability/GlassTextBinding$preDrawListener$1", "preDrawListener", "Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding$preDrawListener$1;", "com/stepos/motionkit/fx/material/capability/GlassTextBinding$attachListener$1", "attachListener", "Lcom/stepos/motionkit/fx/material/capability/GlassTextBinding$attachListener$1;", "pathProviderClass", "Ljava/lang/Class;", "getOwnsMaskTint", "()Z", "ownsMaskTint", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassTextBinding implements MaterialBinding {
    private static final int MAX_SCROLL_RETRY = 3;
    private static final String TAG = "MotionKit.GlassText";
    private final GlassTextBinding$attachListener$1 attachListener;
    private boolean awaitingLayout;
    private boolean glassTextOn;
    private final boolean hasBackdropBlur;
    private boolean hostTextHidden;
    private GlassTextParams lastParams;
    private final View.OnLayoutChangeListener layoutListener;
    private final Path livePath;
    private Object pathProvider;
    private final Class<?> pathProviderClass;
    private final GlassTextBinding$preDrawListener$1 preDrawListener;
    private WeakReference<ViewTreeObserver> preDrawObs;
    private boolean preDrawPending;
    private boolean refreshPendingOnAttach;
    private ColorStateList savedTextColors;
    private int scrollRetry;
    private final GlassTextBinding$textWatcher$1 textWatcher;
    private final CrossWindowMaterialBackend.Token token;
    private final boolean useTextMask;
    private final WeakReference<View> viewRef;

    /* JADX WARN: Type inference failed for: r3v4, types: [com.stepos.motionkit.fx.material.capability.GlassTextBinding$textWatcher$1] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.stepos.motionkit.fx.material.capability.GlassTextBinding$preDrawListener$1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.stepos.motionkit.fx.material.capability.GlassTextBinding$attachListener$1] */
    public GlassTextBinding(View view, CrossWindowMaterialBackend.Token token, boolean z10, boolean z11) {
        Object objA;
        k.f(view, "view");
        k.f(token, "token");
        this.token = token;
        this.useTextMask = z10;
        this.hasBackdropBlur = z11;
        this.viewRef = new WeakReference<>(view);
        this.livePath = new Path();
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.motionkit.fx.material.capability.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
                GlassTextBinding.layoutListener$lambda$1(this.f3877a, view2, i, i6, i10, i11, i12, i13, i14, i15);
            }
        };
        this.textWatcher = new TextWatcher() { // from class: com.stepos.motionkit.fx.material.capability.GlassTextBinding$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s5) {
                this.this$0.scrollRetry = 0;
                this.this$0.scheduleRefreshOnPreDraw();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s5, int start, int before, int count) {
            }
        };
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.motionkit.fx.material.capability.GlassTextBinding$preDrawListener$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() throws IllegalArgumentException {
                GlassTextParams glassTextParams;
                this.this$0.detachPreDraw();
                if (((View) this.this$0.viewRef.get()) == null || (glassTextParams = this.this$0.lastParams) == null) {
                    return true;
                }
                this.this$0.update(GlassTextCapabilityKt.cloneGlassTextParams(glassTextParams));
                return true;
            }
        };
        this.attachListener = new View.OnAttachStateChangeListener() { // from class: com.stepos.motionkit.fx.material.capability.GlassTextBinding$attachListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v10) {
                k.f(v10, "v");
                if (this.this$0.refreshPendingOnAttach) {
                    this.this$0.refreshPendingOnAttach = false;
                    this.this$0.scheduleRefreshOnPreDraw();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v10) {
                k.f(v10, "v");
                this.this$0.detachPreDraw();
            }
        };
        try {
            objA = Class.forName("com.android.internal.graphics.backdrop.BackdropLayerDrawable$PathProvider");
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        this.pathProviderClass = (Class) (objA instanceof Result.Failure ? null : objA);
        view.addOnLayoutChangeListener(this.layoutListener);
        view.addOnAttachStateChangeListener(this.attachListener);
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.addTextChangedListener(this.textWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachPreDraw() {
        ViewTreeObserver viewTreeObserver;
        WeakReference<ViewTreeObserver> weakReference = this.preDrawObs;
        if (weakReference != null && (viewTreeObserver = weakReference.get()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
        }
        this.preDrawObs = null;
        this.preDrawPending = false;
    }

    private final boolean getOwnsMaskTint() {
        return this.useTextMask && !this.hasBackdropBlur;
    }

    private final void hideHostText(View v10) {
        TextView textView = v10 instanceof TextView ? (TextView) v10 : null;
        if (textView == null) {
            return;
        }
        if (!this.hostTextHidden) {
            this.savedTextColors = textView.getTextColors();
            this.hostTextHidden = true;
        } else if (textView.getCurrentTextColor() == 0) {
            return;
        }
        textView.setTextColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutListener$lambda$1(GlassTextBinding glassTextBinding, View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        GlassTextParams glassTextParams;
        if ((view.getWidth() == i14 - i12 && view.getHeight() == i15 - i13 && !glassTextBinding.awaitingLayout) || (glassTextParams = glassTextBinding.lastParams) == null) {
            return;
        }
        glassTextBinding.update(GlassTextCapabilityKt.cloneGlassTextParams(glassTextParams));
    }

    private final Object newPathProvider(Class<?> ppClass) throws IllegalArgumentException {
        Object objNewProxyInstance = Proxy.newProxyInstance(ppClass.getClassLoader(), new Class[]{ppClass}, new InvocationHandler() { // from class: com.stepos.motionkit.fx.material.capability.g
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return GlassTextBinding.newPathProvider$lambda$9(this.f3876a, obj, method, objArr);
            }
        });
        k.e(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object newPathProvider$lambda$9(GlassTextBinding glassTextBinding, Object obj, Method method, Object[] objArr) {
        if (k.b(method.getName(), "providePath")) {
            return glassTextBinding.livePath;
        }
        if (k.b(method.getName(), "hashCode")) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        boolean z10 = false;
        if (k.b(method.getName(), "equals")) {
            if (objArr != null) {
                if (!(objArr.length == 0) && objArr[0] == obj) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
        if (k.b(method.getName(), "toString")) {
            return "GlyphPathProvider";
        }
        if (method.getReturnType().isArray()) {
            return Array.newInstance(method.getReturnType().getComponentType(), 0);
        }
        return null;
    }

    private final void pushGlyph(Path glyph, GlassTextParams p) throws IllegalArgumentException {
        Class<?> cls = this.pathProviderClass;
        if (cls == null) {
            return;
        }
        this.livePath.rewind();
        this.livePath.addPath(glyph);
        this.livePath.setFillType(Path.FillType.WINDING);
        Object objNewPathProvider = this.pathProvider;
        if (objNewPathProvider == null) {
            objNewPathProvider = newPathProvider(cls);
            this.pathProvider = objNewPathProvider;
        }
        this.token.config(new C0204c(this, cls, p, objNewPathProvider, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r pushGlyph$lambda$8(GlassTextBinding glassTextBinding, Class cls, GlassTextParams glassTextParams, Object obj, Object d) {
        View view;
        k.f(d, "d");
        if (glassTextBinding.glassTextOn) {
            CrossWindowMaterialBackend.INSTANCE.call(d, "setPathProvider", new Class[]{cls}, null);
        }
        if (glassTextBinding.getOwnsMaskTint()) {
            CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
            crossWindowMaterialBackend.call(d, "setColor", new Class[]{crossWindowMaterialBackend.getI()}, 0);
        }
        CrossWindowMaterialBackend crossWindowMaterialBackend2 = CrossWindowMaterialBackend.INSTANCE;
        crossWindowMaterialBackend2.call(d, "setGlassText", new Class[]{crossWindowMaterialBackend2.getB(), crossWindowMaterialBackend2.getF(), crossWindowMaterialBackend2.getF()}, Boolean.valueOf(!glassTextBinding.useTextMask), Float.valueOf(glassTextParams.getSdfScale()), Float.valueOf(glassTextParams.getErode()));
        crossWindowMaterialBackend2.call(d, "setPathProvider", new Class[]{cls}, obj);
        glassTextBinding.glassTextOn = true;
        if (glassTextBinding.useTextMask && (view = glassTextBinding.viewRef.get()) != null) {
            glassTextBinding.hideHostText(view);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$3(Class cls, GlassTextBinding glassTextBinding, Object d) {
        k.f(d, "d");
        if (cls != null) {
            CrossWindowMaterialBackend.INSTANCE.call(d, "setPathProvider", new Class[]{cls}, null);
        }
        if (glassTextBinding.getOwnsMaskTint()) {
            CrossWindowMaterialBackend crossWindowMaterialBackend = CrossWindowMaterialBackend.INSTANCE;
            crossWindowMaterialBackend.call(d, "setColor", new Class[]{crossWindowMaterialBackend.getI()}, -1);
        }
        return r.f317a;
    }

    private final void restoreHostText(View v10) {
        if (this.hostTextHidden) {
            this.hostTextHidden = false;
            ColorStateList colorStateList = this.savedTextColors;
            this.savedTextColors = null;
            TextView textView = v10 instanceof TextView ? (TextView) v10 : null;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleRefreshOnPreDraw() {
        View view = this.viewRef.get();
        if (view == null || this.preDrawPending) {
            return;
        }
        if (!view.isAttachedToWindow()) {
            this.refreshPendingOnAttach = true;
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            view.post(new Runnable() { // from class: com.stepos.motionkit.fx.material.capability.f
                @Override // java.lang.Runnable
                public final void run() throws IllegalArgumentException {
                    this.f3875a.refreshGlassText();
                }
            });
            return;
        }
        this.preDrawPending = true;
        this.preDrawObs = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.preDrawListener);
    }

    public final void mergeGlassText(S7.k block) throws IllegalArgumentException {
        k.f(block, "block");
        GlassTextParams glassTextParams = this.lastParams;
        if (glassTextParams == null) {
            return;
        }
        GlassTextParams glassTextParamsCloneGlassTextParams = GlassTextCapabilityKt.cloneGlassTextParams(glassTextParams);
        block.invoke(glassTextParamsCloneGlassTextParams);
        update(glassTextParamsCloneGlassTextParams);
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void onFrame(long j5, float f) {
        MaterialBinding.DefaultImpls.onFrame(this, j5, f);
    }

    public final void refreshGlassText() throws IllegalArgumentException {
        GlassTextParams glassTextParams = this.lastParams;
        if (glassTextParams == null) {
            return;
        }
        update(GlassTextCapabilityKt.cloneGlassTextParams(glassTextParams));
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void release() {
        View view = this.viewRef.get();
        if (view != null) {
            view.removeOnLayoutChangeListener(this.layoutListener);
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.attachListener);
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.removeTextChangedListener(this.textWatcher);
        }
        restoreHostText(view);
        detachPreDraw();
        this.refreshPendingOnAttach = false;
        this.awaitingLayout = false;
        this.scrollRetry = 0;
        this.lastParams = null;
        this.pathProvider = null;
        this.glassTextOn = false;
        this.livePath.reset();
        this.token.release(new e(this.pathProviderClass, this, 1));
    }

    public final void setClockText(String text) throws IllegalArgumentException {
        k.f(text, "text");
        GlassTextParams glassTextParams = this.lastParams;
        if (glassTextParams == null) {
            return;
        }
        View view = this.viewRef.get();
        if (view instanceof TextClock) {
            Log.w(TAG, "setClockText ignored on TextClock; ticker/setText is followed automatically");
        } else if (!(view instanceof TextView)) {
            Log.w(TAG, "setClockText ignored: host is not TextView");
        } else {
            ((TextView) view).setText(text);
            update(GlassTextCapabilityKt.cloneGlassTextParams(glassTextParams));
        }
    }

    @Override // com.stepos.motionkit.fx.material.MaterialBinding
    public void update(MaterialParams params) throws IllegalArgumentException {
        k.f(params, "params");
        GlassTextParams glassTextParams = params instanceof GlassTextParams ? (GlassTextParams) params : null;
        if (glassTextParams == null) {
            return;
        }
        this.lastParams = glassTextParams;
        View view = this.viewRef.get();
        if (view == null) {
            return;
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        Path pathPathFromTextView = GlassTextCapabilityKt.pathFromTextView(textView);
        if (!pathPathFromTextView.isEmpty()) {
            this.awaitingLayout = false;
            this.scrollRetry = 0;
            pushGlyph(pathPathFromTextView, glassTextParams);
            if (!this.useTextMask && this.pathProviderClass != null) {
                hideHostText(view);
            }
            view.invalidate();
            return;
        }
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            Log.w(TAG, "glass text path empty (no text); clearing prior outline");
            pushGlyph(pathPathFromTextView, glassTextParams);
            return;
        }
        if (textView.getLayout() == null) {
            this.awaitingLayout = true;
            Log.w(TAG, "glass text path empty (layout null); waiting for next layout pass");
            return;
        }
        int i = this.scrollRetry;
        if (i < 3) {
            this.scrollRetry = i + 1;
            Log.w(TAG, "glass text path empty (outline outside view); retry on next pre-draw");
            scheduleRefreshOnPreDraw();
        } else {
            Log.w(TAG, "glass text path empty (outline outside view); gave up after " + i + " retries");
        }
    }

    public /* synthetic */ GlassTextBinding(View view, CrossWindowMaterialBackend.Token token, boolean z10, boolean z11, int i, kotlin.jvm.internal.e eVar) {
        this(view, token, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? false : z11);
    }
}
