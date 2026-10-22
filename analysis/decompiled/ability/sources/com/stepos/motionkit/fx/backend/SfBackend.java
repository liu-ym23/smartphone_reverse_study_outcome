package com.stepos.motionkit.fx.backend;

import C7.r;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.CompiledShader;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxBackend;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.fx.FxInstanceImpl;
import com.stepos.motionkit.fx.backend.sf.SfDrawableChannel;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SfBackend;", "Lcom/stepos/motionkit/FxBackend;", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/motionkit/MotionHost;", "host", "Landroid/view/View;", "targetView", "Lcom/stepos/motionkit/CompiledShader;", "compiled", "Lcom/stepos/motionkit/FxConfig;", "config", "Lcom/stepos/motionkit/EffectDefinition;", "definition", "Lcom/stepos/motionkit/FxInstance;", "createInstance", "(Lcom/stepos/motionkit/MotionHost;Landroid/view/View;Lcom/stepos/motionkit/CompiledShader;Lcom/stepos/motionkit/FxConfig;Lcom/stepos/motionkit/EffectDefinition;)Lcom/stepos/motionkit/FxInstance;", "LC7/r;", "release", "", "Lcom/stepos/motionkit/fx/backend/SfInstance;", "instances", "Ljava/util/List;", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SfBackend implements FxBackend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile S7.k channelFactory = new androidx.compose.ui.text.d(23);
    private final List<SfInstance> instances = new ArrayList();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SfBackend$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Lcom/stepos/motionkit/EffectDefinition;", "Lcom/stepos/motionkit/fx/backend/SfEffectChannel;", "channelFactory", "LS7/k;", "getChannelFactory", "()LS7/k;", "setChannelFactory", "(LS7/k;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final S7.k getChannelFactory() {
            return SfBackend.channelFactory;
        }

        public final void setChannelFactory(S7.k kVar) {
            kotlin.jvm.internal.k.f(kVar, "<set-?>");
            SfBackend.channelFactory = kVar;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SfDrawableChannel channelFactory$lambda$3(EffectDefinition effectDefinition) {
        kotlin.jvm.internal.k.f(effectDefinition, "<unused var>");
        return new SfDrawableChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$0(SfInstance sfInstance, long j5, float f) {
        sfInstance.pushFrame(j5);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createInstance$lambda$1(SfEffectChannel sfEffectChannel, SfBackend sfBackend, SfInstance sfInstance) {
        sfEffectChannel.detach();
        sfBackend.instances.remove(sfInstance);
        return r.f317a;
    }

    @Override // com.stepos.motionkit.FxBackend
    public FxInstance createInstance(MotionHost host, View targetView, CompiledShader compiled, FxConfig config, EffectDefinition definition) {
        kotlin.jvm.internal.k.f(host, "host");
        kotlin.jvm.internal.k.f(targetView, "targetView");
        kotlin.jvm.internal.k.f(compiled, "compiled");
        kotlin.jvm.internal.k.f(config, "config");
        kotlin.jvm.internal.k.f(definition, "definition");
        UniformBinder uniformBinder = new UniformBinder(definition);
        final SfEffectChannel sfEffectChannel = (SfEffectChannel) channelFactory.invoke(definition);
        sfEffectChannel.attach(targetView);
        sfEffectChannel.submitShader(compiled.getSource());
        sfEffectChannel.setBackgroundSampling(definition.getRequiresBackground());
        sfEffectChannel.start();
        sfEffectChannel.submitUniforms(uniformBinder.snapshotUniforms());
        final SfInstance sfInstance = new SfInstance(sfEffectChannel, uniformBinder);
        this.instances.add(sfInstance);
        return new FxInstanceImpl(System.nanoTime(), new f(sfInstance, 1), new S7.a() { // from class: com.stepos.motionkit.fx.backend.h
            @Override // S7.a
            public final Object invoke() {
                return SfBackend.createInstance$lambda$1(sfEffectChannel, this, sfInstance);
            }
        }, uniformBinder);
    }

    @Override // com.stepos.motionkit.FxBackend
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((SfInstance) it.next()).getChannel().detach();
        }
        this.instances.clear();
    }
}
