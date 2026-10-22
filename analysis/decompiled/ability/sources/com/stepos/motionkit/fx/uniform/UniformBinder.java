package com.stepos.motionkit.fx.uniform;

import D7.K;
import D7.q;
import D7.w;
import S7.a;
import S7.o;
import android.graphics.RuntimeShader;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.AnimationDefinition;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.TrackDefinition;
import com.stepos.motionkit.UniformSpec;
import com.stepos.motionkit.fx.anim.TrackEvaluator;
import com.stepos.motionkit.fx.anim.TrackState;
import i9.h;
import j9.InterfaceC1616j;
import j9.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import p9.c;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001b\u001a\u00020\b2\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J%\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010#J-\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010%J5\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010'J\u0019\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,J\u0011\u00100\u001a\u0004\u0018\u00010-H\u0000¢\u0006\u0004\b.\u0010/R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u00010-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R&\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d07068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R&\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0:0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00109R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010@\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "", "Lcom/stepos/motionkit/EffectDefinition;", "definition", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/EffectDefinition;)V", "", "elapsedMs", "LC7/r;", "resolve", "(J)V", "", AgentBusWakeContract.EXTRA_SOURCE, "bindShaderSource", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_NAME, "", "declaresFloatUniform", "(Ljava/lang/String;)Z", "Landroid/graphics/RuntimeShader;", "shader", "applyTo", "(Landroid/graphics/RuntimeShader;)V", "Lkotlin/Function3;", "", "", "uniformSetter", "applyToGles", "(LS7/o;)V", "", "value", "set", "(Ljava/lang/String;F)V", "x", "y", "(Ljava/lang/String;FF)V", "z", "(Ljava/lang/String;FFF)V", "w", "(Ljava/lang/String;FFFF)V", "", "snapshotUniforms", "()Ljava/util/Map;", "getTrackValue", "(Ljava/lang/String;)F", "Lcom/stepos/motionkit/fx/anim/TrackEvaluator;", "getEvaluator$motionkit_fx_release", "()Lcom/stepos/motionkit/fx/anim/TrackEvaluator;", "getEvaluator", "Lcom/stepos/motionkit/fx/uniform/UniformBuffer;", "buffer", "Lcom/stepos/motionkit/fx/uniform/UniformBuffer;", "evaluator", "Lcom/stepos/motionkit/fx/anim/TrackEvaluator;", "", "Lp9/c;", "flowBindings", "Ljava/util/Map;", "Lkotlin/Function0;", "completionActions", "", "invalidUniforms", "Ljava/util/Set;", "declaredFloatUniforms", "glesTemp", "[F", "getTotalDurationMs", "()J", "totalDurationMs", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UniformBinder {
    private final UniformBuffer buffer;
    private final Map<String, a> completionActions;
    private final Set<String> declaredFloatUniforms;
    private final TrackEvaluator evaluator;
    private final Map<String, c> flowBindings;
    private final float[] glesTemp;
    private final Set<String> invalidUniforms;
    private static final Companion Companion = new Companion(null);
    private static final Regex UNIFORM_DECL_REGEX = new Regex("uniform\\s+(\\w+)\\s+(\\w+)");
    private static final Set<String> FLOAT_UNIFORM_TYPES = q.K0(new String[]{TypedValues.Custom.S_FLOAT, "vec2", "vec3", "vec4", "float2", "float3", "float4", "half", "half2", "half3", "half4"});

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/motionkit/fx/uniform/UniformBinder$Companion;", "", AppAgent.CONSTRUCT, "()V", "UNIFORM_DECL_REGEX", "Lkotlin/text/Regex;", "getUNIFORM_DECL_REGEX", "()Lkotlin/text/Regex;", "FLOAT_UNIFORM_TYPES", "", "", "getFLOAT_UNIFORM_TYPES", "()Ljava/util/Set;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Set<String> getFLOAT_UNIFORM_TYPES() {
            return UniformBinder.FLOAT_UNIFORM_TYPES;
        }

        public final Regex getUNIFORM_DECL_REGEX() {
            return UniformBinder.UNIFORM_DECL_REGEX;
        }

        private Companion() {
        }
    }

    public UniformBinder(EffectDefinition definition) {
        k.f(definition, "definition");
        this.buffer = new UniformBuffer(0, 1, null);
        this.flowBindings = new LinkedHashMap();
        for (UniformSpec uniformSpec : definition.getUniforms()) {
            if (uniformSpec instanceof UniformSpec.Float1) {
                this.buffer.allocate(uniformSpec.getName(), 1);
                this.buffer.set(uniformSpec.getName(), ((UniformSpec.Float1) uniformSpec).getDefault());
            } else if (uniformSpec instanceof UniformSpec.Float2) {
                this.buffer.allocate(uniformSpec.getName(), 2);
                UniformBuffer uniformBuffer = this.buffer;
                String name = uniformSpec.getName();
                UniformSpec.Float2 float2 = (UniformSpec.Float2) uniformSpec;
                uniformBuffer.set(name, float2.getDefaultX(), float2.getDefaultY());
            } else if (uniformSpec instanceof UniformSpec.Float3) {
                this.buffer.allocate(uniformSpec.getName(), 3);
                UniformBuffer uniformBuffer2 = this.buffer;
                String name2 = uniformSpec.getName();
                UniformSpec.Float3 float3 = (UniformSpec.Float3) uniformSpec;
                uniformBuffer2.set(name2, float3.getDefaultX(), float3.getDefaultY(), float3.getDefaultZ());
            } else if (uniformSpec instanceof UniformSpec.Float4) {
                this.buffer.allocate(uniformSpec.getName(), 4);
                UniformBuffer uniformBuffer3 = this.buffer;
                String name3 = uniformSpec.getName();
                UniformSpec.Float4 float4 = (UniformSpec.Float4) uniformSpec;
                uniformBuffer3.set(name3, float4.getDefaultX(), float4.getDefaultY(), float4.getDefaultZ(), float4.getDefaultW());
            } else if (uniformSpec instanceof UniformSpec.Color) {
                this.buffer.allocate(uniformSpec.getName(), 4);
                int defaultColor = ((UniformSpec.Color) uniformSpec).getDefaultColor();
                this.buffer.set(uniformSpec.getName(), ((defaultColor >> 16) & 255) / 255.0f, ((defaultColor >> 8) & 255) / 255.0f, (defaultColor & 255) / 255.0f, ((defaultColor >> 24) & 255) / 255.0f);
            } else {
                if (!(uniformSpec instanceof UniformSpec.Mat3)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.buffer.allocate(uniformSpec.getName(), 9);
            }
        }
        AnimationDefinition animation = definition.getAnimation();
        if (animation != null) {
            List<TrackDefinition> tracks = animation.getTracks();
            ArrayList arrayList = new ArrayList(w.c0(tracks, 10));
            for (TrackDefinition trackDefinition : tracks) {
                arrayList.add(new TrackState(trackDefinition.getUniformName(), trackDefinition.getType(), trackDefinition.getComponent(), 0.0f, false, 24, null));
            }
            this.evaluator = new TrackEvaluator(arrayList);
            this.completionActions = animation.getCompletionActions();
        } else {
            this.evaluator = null;
            this.completionActions = kotlin.collections.a.M();
        }
        this.invalidUniforms = new LinkedHashSet();
        this.declaredFloatUniforms = new LinkedHashSet();
        this.glesTemp = new float[4];
    }

    public final void applyTo(RuntimeShader shader) {
        k.f(shader, "shader");
        for (String str : this.buffer.getNames()) {
            if (!this.invalidUniforms.contains(str) && declaresFloatUniform(str)) {
                int floatCount = this.buffer.getFloatCount(str);
                Integer offset = this.buffer.getOffset(str);
                if (offset != null) {
                    int iIntValue = offset.intValue();
                    float[] data = this.buffer.getData();
                    if (floatCount == 1) {
                        shader.setFloatUniform(str, data[iIntValue]);
                    } else if (floatCount == 2) {
                        shader.setFloatUniform(str, data[iIntValue], data[iIntValue + 1]);
                    } else if (floatCount == 3) {
                        shader.setFloatUniform(str, data[iIntValue], data[iIntValue + 1], data[iIntValue + 2]);
                    } else if (floatCount == 4) {
                        try {
                            float f = data[iIntValue];
                            float f7 = data[iIntValue + 1];
                            float f9 = data[iIntValue + 2];
                            float f10 = data[iIntValue + 3];
                            RuntimeShader runtimeShader = shader;
                            try {
                                runtimeShader.setFloatUniform(str, f, f7, f9, f10);
                                shader = runtimeShader;
                            } catch (IllegalArgumentException unused) {
                                shader = runtimeShader;
                                this.invalidUniforms.add(str);
                            }
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                }
            }
        }
    }

    public final void applyToGles(o uniformSetter) {
        k.f(uniformSetter, "uniformSetter");
        for (String str : this.buffer.getNames()) {
            int floatCount = this.buffer.getFloatCount(str);
            Integer offset = this.buffer.getOffset(str);
            if (offset != null) {
                System.arraycopy(this.buffer.getData(), offset.intValue(), this.glesTemp, 0, floatCount);
                uniformSetter.invoke(str, this.glesTemp, Integer.valueOf(floatCount));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindShaderSource(String source) {
        k.f(source, "source");
        this.declaredFloatUniforms.clear();
        h hVar = new h(Regex.c(UNIFORM_DECL_REGEX, source));
        while (hVar.hasNext()) {
            l lVar = (l) ((InterfaceC1616j) hVar.next());
            if (FLOAT_UNIFORM_TYPES.contains(((K) lVar.a()).get(1))) {
                this.declaredFloatUniforms.add(((K) lVar.a()).get(2));
            }
        }
    }

    public final boolean declaresFloatUniform(String name) {
        k.f(name, "name");
        return this.declaredFloatUniforms.isEmpty() || this.declaredFloatUniforms.contains(name);
    }

    /* renamed from: getEvaluator$motionkit_fx_release, reason: from getter */
    public final TrackEvaluator getEvaluator() {
        return this.evaluator;
    }

    public final long getTotalDurationMs() {
        TrackEvaluator trackEvaluator = this.evaluator;
        if (trackEvaluator != null) {
            return trackEvaluator.getTotalDurationMs();
        }
        return 0L;
    }

    public final float getTrackValue(String name) {
        k.f(name, "name");
        return this.buffer.get(name);
    }

    public final void resolve(long elapsedMs) {
        TrackEvaluator trackEvaluator = this.evaluator;
        if (trackEvaluator != null) {
            trackEvaluator.evaluate(elapsedMs);
            for (TrackState trackState : trackEvaluator.getTracks()) {
                if (trackState.getComponent() >= 0) {
                    this.buffer.setComponent(trackState.getName(), trackState.getComponent(), trackState.getValue());
                } else {
                    this.buffer.set(trackState.getName(), trackState.getValue());
                }
            }
            Iterator<String> it = trackEvaluator.isComplete(elapsedMs).iterator();
            while (it.hasNext()) {
                a aVar = this.completionActions.get(it.next());
                if (aVar != null) {
                    aVar.invoke();
                }
            }
        }
    }

    public final void set(String name, float value) {
        k.f(name, "name");
        this.buffer.set(name, value);
    }

    public final Map<String, float[]> snapshotUniforms() {
        HashMap map = new HashMap();
        for (String str : this.buffer.getNames()) {
            int floatCount = this.buffer.getFloatCount(str);
            Integer offset = this.buffer.getOffset(str);
            if (offset != null) {
                int iIntValue = offset.intValue();
                float[] data = this.buffer.getData();
                int i = floatCount + iIntValue;
                k.f(data, "<this>");
                z2.l.q(i, data.length);
                float[] fArrCopyOfRange = Arrays.copyOfRange(data, iIntValue, i);
                k.e(fArrCopyOfRange, "copyOfRange(...)");
                map.put(str, fArrCopyOfRange);
            }
        }
        return map;
    }

    public final void set(String name, float x10, float y) {
        k.f(name, "name");
        this.buffer.set(name, x10, y);
    }

    public final void set(String name, float x10, float y, float z10) {
        k.f(name, "name");
        this.buffer.set(name, x10, y, z10);
    }

    public final void set(String name, float x10, float y, float z10, float w8) {
        k.f(name, "name");
        this.buffer.set(name, x10, y, z10, w8);
    }
}
