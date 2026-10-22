package com.stepos.motionkit.fx.backend;

import C7.r;
import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.CompiledShader;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxBackend;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import com.stepos.motionkit.fx.FxInstanceImpl;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SurfaceBackend;", "Lcom/stepos/motionkit/FxBackend;", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "findOverlayParent", "(Landroid/view/View;)Landroid/view/ViewGroup;", "Lcom/stepos/motionkit/MotionHost;", "host", "targetView", "Lcom/stepos/motionkit/CompiledShader;", "compiled", "Lcom/stepos/motionkit/FxConfig;", "config", "Lcom/stepos/motionkit/EffectDefinition;", "definition", "Lcom/stepos/motionkit/FxInstance;", "createInstance", "(Lcom/stepos/motionkit/MotionHost;Landroid/view/View;Lcom/stepos/motionkit/CompiledShader;Lcom/stepos/motionkit/FxConfig;Lcom/stepos/motionkit/EffectDefinition;)Lcom/stepos/motionkit/FxInstance;", "LC7/r;", "release", "", "Lcom/stepos/motionkit/fx/backend/SurfaceInstance;", "instances", "Ljava/util/List;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfaceBackend implements FxBackend {
    private final List<SurfaceInstance> instances = new ArrayList();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SurfacePresentation.values().length];
            try {
                iArr[SurfacePresentation.TEXTURE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurfacePresentation.SURFACE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SurfaceRendererType.values().length];
            try {
                iArr2[SurfaceRendererType.AGSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SurfaceRendererType.GLES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SurfaceRendererType.VULKAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$0(Ref$ObjectRef ref$ObjectRef) {
        Object obj = ref$ObjectRef.f4920a;
        if (obj != null) {
            ((FxInstanceImpl) obj).release();
            return r.f317a;
        }
        kotlin.jvm.internal.k.n("fx");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$1(SurfaceInstance surfaceInstance, long j5, float f) {
        surfaceInstance.renderFrame(j5);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$2(SurfaceInstance surfaceInstance, SurfaceBackend surfaceBackend) {
        surfaceInstance.release();
        surfaceBackend.instances.remove(surfaceInstance);
        return r.f317a;
    }

    private final ViewGroup findOverlayParent(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView().findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        while (view.getParent() instanceof View) {
            Object parent = view.getParent();
            kotlin.jvm.internal.k.d(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
        }
        ViewGroup viewGroup2 = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup2 != null) {
            return viewGroup2;
        }
        throw new IllegalArgumentException("SurfaceBackend: cannot find a ViewGroup to attach");
    }

    @Override // com.stepos.motionkit.FxBackend
    public FxInstance createInstance(MotionHost host, View targetView, CompiledShader compiled, FxConfig config, EffectDefinition definition) {
        FxRenderSurface transparentTextureView;
        SurfaceRenderer surfaceRenderer;
        kotlin.jvm.internal.k.f(host, "host");
        kotlin.jvm.internal.k.f(targetView, "targetView");
        kotlin.jvm.internal.k.f(compiled, "compiled");
        kotlin.jvm.internal.k.f(config, "config");
        kotlin.jvm.internal.k.f(definition, "definition");
        ViewGroup viewGroupFindOverlayParent = findOverlayParent(targetView);
        int i = WhenMappings.$EnumSwitchMapping$0[config.getSurfacePresentation().ordinal()];
        if (i == 1) {
            Context context = targetView.getContext();
            kotlin.jvm.internal.k.e(context, "getContext(...)");
            transparentTextureView = new TransparentTextureView(context);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Context context2 = targetView.getContext();
            kotlin.jvm.internal.k.e(context2, "getContext(...)");
            transparentTextureView = new TransparentSurfaceView(context2);
        }
        FxRenderSurface fxRenderSurface = transparentTextureView;
        UniformBinder uniformBinder = new UniformBinder(definition);
        int i6 = WhenMappings.$EnumSwitchMapping$1[config.getSurfaceRenderer().ordinal()];
        if (i6 == 1) {
            surfaceRenderer = SurfaceRenderer.AGSL;
        } else if (i6 == 2) {
            surfaceRenderer = SurfaceRenderer.GLES;
        } else {
            if (i6 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            surfaceRenderer = SurfaceRenderer.VULKAN;
        }
        SurfaceRenderer surfaceRenderer2 = surfaceRenderer;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        SurfaceInstance surfaceInstance = new SurfaceInstance(fxRenderSurface, uniformBinder, compiled.getSource(), surfaceRenderer2, viewGroupFindOverlayParent, new l(ref$ObjectRef, 1));
        this.instances.add(surfaceInstance);
        ref$ObjectRef.f4920a = new FxInstanceImpl(System.nanoTime(), new f(surfaceInstance, 2), new g(surfaceInstance, this, 1), uniformBinder);
        surfaceInstance.attach();
        Object obj = ref$ObjectRef.f4920a;
        if (obj != null) {
            return (FxInstanceImpl) obj;
        }
        kotlin.jvm.internal.k.n("fx");
        throw null;
    }

    @Override // com.stepos.motionkit.FxBackend
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((SurfaceInstance) it.next()).release();
        }
        this.instances.clear();
    }
}
