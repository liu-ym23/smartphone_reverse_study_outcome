package com.stepos.motionkit.fx.backend;

import C7.r;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.CompiledShader;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxBackend;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.fx.FxInstanceImpl;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/motionkit/fx/backend/RuntimeShaderBackend;", "Lcom/stepos/motionkit/FxBackend;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/motionkit/MotionHost;", "host", "Landroid/view/View;", "targetView", "Lcom/stepos/motionkit/CompiledShader;", "compiled", "Lcom/stepos/motionkit/FxConfig;", "config", "Lcom/stepos/motionkit/EffectDefinition;", "definition", "Lcom/stepos/motionkit/FxInstance;", "createInstance", "(Lcom/stepos/motionkit/MotionHost;Landroid/view/View;Lcom/stepos/motionkit/CompiledShader;Lcom/stepos/motionkit/FxConfig;Lcom/stepos/motionkit/EffectDefinition;)Lcom/stepos/motionkit/FxInstance;", "LC7/r;", "release", "", "Lcom/stepos/motionkit/fx/backend/RuntimeShaderInstance;", "instances", "Ljava/util/List;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RuntimeShaderBackend implements FxBackend {
    private final List<RuntimeShaderInstance> instances = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createInstance$lambda$1(ShaderDrawable shaderDrawable, View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        shaderDrawable.setBounds(0, 0, i10 - i, i11 - i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$2(RuntimeShaderInstance runtimeShaderInstance, long j5, float f) {
        runtimeShaderInstance.update(j5);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$3(RuntimeShaderInstance runtimeShaderInstance, RuntimeShaderBackend runtimeShaderBackend) {
        runtimeShaderInstance.release();
        runtimeShaderBackend.instances.remove(runtimeShaderInstance);
        return r.f317a;
    }

    @Override // com.stepos.motionkit.FxBackend
    public FxInstance createInstance(MotionHost host, View targetView, CompiledShader compiled, FxConfig config, EffectDefinition definition) {
        Bitmap bitmapCreateBitmap;
        kotlin.jvm.internal.k.f(host, "host");
        kotlin.jvm.internal.k.f(targetView, "targetView");
        kotlin.jvm.internal.k.f(compiled, "compiled");
        kotlin.jvm.internal.k.f(config, "config");
        kotlin.jvm.internal.k.f(definition, "definition");
        RuntimeShader runtimeShader = compiled.getRuntimeShader();
        if (runtimeShader == null) {
            runtimeShader = new RuntimeShader(compiled.getSource());
        }
        RuntimeShader runtimeShader2 = runtimeShader;
        if ((m.h0(compiled.getSource(), "uniform shader sksl_background", false) || m.h0(compiled.getSource(), "uniform shader iBackground", false)) && targetView.getWidth() > 0 && targetView.getHeight() > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(targetView.getWidth(), targetView.getHeight(), Bitmap.Config.ARGB_8888);
            targetView.draw(new Canvas(bitmapCreateBitmap));
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap, tileMode, tileMode);
            if (m.h0(compiled.getSource(), "uniform shader sksl_background", false)) {
                runtimeShader2.setInputShader(SfBuiltinInput.BACKGROUND, bitmapShader);
            }
            if (m.h0(compiled.getSource(), "uniform shader sksl_layer", false)) {
                runtimeShader2.setInputShader(SfBuiltinInput.LAYER, bitmapShader);
            }
            if (m.h0(compiled.getSource(), "uniform shader iBackground", false)) {
                runtimeShader2.setInputShader("iBackground", bitmapShader);
            }
        } else {
            bitmapCreateBitmap = null;
        }
        Bitmap bitmap = bitmapCreateBitmap;
        UniformBinder uniformBinder = new UniformBinder(definition);
        uniformBinder.bindShaderSource(compiled.getSource());
        final ShaderDrawable shaderDrawable = new ShaderDrawable(runtimeShader2, uniformBinder);
        targetView.getOverlay().add(shaderDrawable);
        shaderDrawable.setBounds(0, 0, targetView.getWidth(), targetView.getHeight());
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.motionkit.fx.backend.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
                RuntimeShaderBackend.createInstance$lambda$1(shaderDrawable, view, i, i6, i10, i11, i12, i13, i14, i15);
            }
        };
        targetView.addOnLayoutChangeListener(onLayoutChangeListener);
        RuntimeShaderInstance runtimeShaderInstance = new RuntimeShaderInstance(runtimeShader2, uniformBinder, shaderDrawable, targetView, onLayoutChangeListener, bitmap);
        this.instances.add(runtimeShaderInstance);
        return new FxInstanceImpl(System.nanoTime(), new f(runtimeShaderInstance, 0), new g(runtimeShaderInstance, this, 0), uniformBinder);
    }

    @Override // com.stepos.motionkit.FxBackend
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((RuntimeShaderInstance) it.next()).release();
        }
        this.instances.clear();
    }
}
