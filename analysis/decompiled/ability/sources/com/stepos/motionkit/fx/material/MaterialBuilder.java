package com.stepos.motionkit.fx.material;

import C7.r;
import D6.i;
import D7.v;
import S7.n;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.ErrorLevel;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.MotionKitError;
import com.stepos.motionkit.fx.material.MaterialHandle;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.backend.CrossWindowMaterialBackend;
import com.stepos.motionkit.fx.material.backend.InWindowMaterialBackend;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.GlassTextParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u000254B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0015J;\u0010!\u001a\u00020\u0000\"\b\b\u0000\u0010\u001c*\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%J\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010,R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010,R*\u00102\u001a\u0016\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010-¨\u00066"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "", "Landroid/view/View;", "view", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "LC7/r;", "injectGlassText", "()V", "", "requiresGlyphSdf", "()Z", "Lcom/stepos/motionkit/fx/material/MaterialHandle;", "bindPending", "()Lcom/stepos/motionkit/fx/material/MaterialHandle;", "enabled", "crossWindow", "(Z)Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "", "px", "cornerRadius", "(F)Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "asGlassText$motionkit_fx_release", "()Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "asGlassText", "v", "cornerSmoothness", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "P", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "capability", "Lkotlin/Function1;", "block", "apply", "(Lcom/stepos/motionkit/fx/material/MaterialCapability;LS7/k;)Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "effect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "commit", "Landroid/view/View;", "", "Lcom/stepos/motionkit/fx/material/MaterialBuilder$Pending;", "pending", "Ljava/util/List;", "Z", "F", "cornerRadiusExplicit", "glassTextMode", "Lkotlin/Function2;", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "glassTextFragment", "LS7/n;", "Companion", "Pending", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MaterialBuilder {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "MotionKitMaterial";
    private float cornerRadius;
    private boolean cornerRadiusExplicit;
    private float cornerSmoothness;
    private boolean crossWindow;
    private n glassTextFragment;
    private boolean glassTextMode;
    private final List<Pending<?>> pending;
    private final View view;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialBuilder$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialBuilder$Pending;", "P", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "", "capability", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "params", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/material/MaterialCapability;Lcom/stepos/motionkit/fx/material/MaterialParams;)V", "getCapability", "()Lcom/stepos/motionkit/fx/material/MaterialCapability;", "getParams", "()Lcom/stepos/motionkit/fx/material/MaterialParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", "id", "", "getId", "()Ljava/lang/String;", "isSupported", "", "view", "Landroid/view/View;", "bind", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "crossWindow", "cornerRadius", "", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Pending<P extends MaterialParams> {
        private final MaterialCapability<P> capability;
        private final P params;

        public Pending(MaterialCapability<P> capability, P params) {
            k.f(capability, "capability");
            k.f(params, "params");
            this.capability = capability;
            this.params = params;
        }

        public final MaterialBinding bind(View view, boolean crossWindow, float cornerRadius) {
            k.f(view, "view");
            this.params.setCrossWindow$motionkit_fx_release(crossWindow);
            this.params.setCornerRadius$motionkit_fx_release(cornerRadius);
            return this.capability.bind(view, this.params);
        }

        public final MaterialCapability<P> getCapability() {
            return this.capability;
        }

        public final String getId() {
            return this.capability.getId();
        }

        public final P getParams() {
            return this.params;
        }

        public final boolean isSupported(View view) {
            k.f(view, "view");
            MaterialCapability<P> materialCapability = this.capability;
            Context context = view.getContext();
            k.e(context, "getContext(...)");
            return materialCapability.isSupported(context);
        }
    }

    public MaterialBuilder(View view) {
        k.f(view, "view");
        this.view = view;
        this.pending = new ArrayList();
    }

    public static /* synthetic */ MaterialBuilder apply$default(MaterialBuilder materialBuilder, MaterialCapability materialCapability, S7.k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar = new androidx.compose.ui.text.d(25);
        }
        return materialBuilder.apply(materialCapability, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$0(MaterialParams materialParams) {
        k.f(materialParams, "<this>");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$1(GlassEffect glassEffect, float f, BlurParams apply) {
        k.f(apply, "$this$apply");
        glassEffect.getBlur().invoke(apply, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$2(GlassEffect glassEffect, float f, StrokeParams apply) {
        k.f(apply, "$this$apply");
        glassEffect.getStroke().invoke(apply, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$3(GlassEffect glassEffect, float f, InnerShadowParams apply) {
        k.f(apply, "$this$apply");
        glassEffect.getInnerShadow().invoke(apply, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$4(GlassEffect glassEffect, float f, RefractionParams apply) {
        k.f(apply, "$this$apply");
        glassEffect.getRefraction().invoke(apply, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r apply$lambda$5(GlassEffect glassEffect, float f, BlendParams apply) {
        k.f(apply, "$this$apply");
        glassEffect.getBlend().invoke(apply, Float.valueOf(f));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MaterialHandle bindPending() {
        MaterialBinding materialBindingBind;
        ArrayList arrayList = new ArrayList();
        for (Pending<?> pending : this.pending) {
            if (pending.isSupported(this.view)) {
                MotionKit motionKit = MotionKit.INSTANCE;
                try {
                    materialBindingBind = pending.bind(this.view, this.crossWindow, this.cornerRadius);
                } catch (Exception e) {
                    motionKit.handleError(new MotionKitError(ErrorLevel.DEGRADED, "FX operation failed", e));
                    materialBindingBind = null;
                }
                if (materialBindingBind == null) {
                    Log.w(TAG, "能力 " + pending.getId() + " 绑定失败，静默降级跳过");
                } else {
                    arrayList.add(new MaterialHandle.Entry(pending.getId(), materialBindingBind));
                }
            } else {
                Log.i(TAG, "能力 " + pending.getId() + " 当前设备不支持，静默降级跳过");
            }
        }
        this.pending.clear();
        if (this.crossWindow) {
            CrossWindowMaterialBackend.INSTANCE.setCornerRadius(this.view, this.cornerRadius);
        } else {
            InWindowMaterialBackend.INSTANCE.setCornerRadius(this.view, this.cornerRadius);
        }
        if (this.crossWindow) {
            CrossWindowMaterialBackend.INSTANCE.setCornerSmoothness(this.view, this.cornerSmoothness);
        } else {
            InWindowMaterialBackend.INSTANCE.setCornerSmoothness(this.view, this.cornerSmoothness);
        }
        Log.i(TAG, "commit: 完成，生效能力数=" + arrayList.size() + " [" + v.I0(arrayList, ",", null, null, new androidx.compose.ui.text.d(24), 30) + "]");
        return new MaterialHandle(this.view, this.crossWindow, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence bindPending$lambda$12(MaterialHandle.Entry it) {
        k.f(it, "it");
        return it.getCapabilityId();
    }

    private final void injectGlassText() {
        if (this.glassTextMode) {
            String id = Materials.INSTANCE.getGlassText$motionkit_fx_release().getId();
            List<Pending<?>> list = this.pending;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (k.b(((Pending) it.next()).getId(), id)) {
                        Log.i(TAG, "commit: 已登记 " + id + "，跳过入口注入(避免绑两份)");
                        return;
                    }
                }
            }
            float f = this.view.getResources().getDisplayMetrics().density;
            GlassTextParams glassTextParams = (GlassTextParams) Materials.INSTANCE.getGlassText$motionkit_fx_release().defaultParams();
            n nVar = this.glassTextFragment;
            if (nVar != null) {
                nVar.invoke(glassTextParams, Float.valueOf(f));
            }
            boolean z10 = true;
            glassTextParams.setUseTextMask$motionkit_fx_release(!requiresGlyphSdf());
            List<Pending<?>> list2 = this.pending;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                z10 = false;
            } else {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    Pending pending = (Pending) it2.next();
                    if (k.b(pending.getId(), Materials.INSTANCE.getBlur().getId()) || k.b(pending.getId(), Materials.GradientBlur.INSTANCE.getId())) {
                        break;
                    }
                }
                z10 = false;
            }
            glassTextParams.setHasBackdropBlur$motionkit_fx_release(z10);
            this.pending.add(new Pending<>(Materials.INSTANCE.getGlassText$motionkit_fx_release(), glassTextParams));
        }
    }

    private final boolean requiresGlyphSdf() {
        List<Pending<?>> list = this.pending;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (k.b(((Pending) it.next()).getId(), Materials.INSTANCE.getStroke().getId())) {
                return true;
            }
        }
        return false;
    }

    public final <P extends MaterialParams> MaterialBuilder apply(MaterialCapability<P> capability, S7.k block) {
        k.f(capability, "capability");
        k.f(block, "block");
        MaterialParams materialParamsDefaultParams = capability.defaultParams();
        block.invoke(materialParamsDefaultParams);
        this.pending.add(new Pending<>(capability, materialParamsDefaultParams));
        return this;
    }

    public final MaterialBuilder asGlassText$motionkit_fx_release() {
        this.glassTextMode = true;
        return this;
    }

    public final MaterialHandle commit() {
        if (this.glassTextMode && this.pending.isEmpty()) {
            return new MaterialHandle(this.view, this.crossWindow, EmptyList.f4893a);
        }
        injectGlassText();
        return this.crossWindow ? bindPending() : (MaterialHandle) InWindowMaterialBackend.INSTANCE.batch(new i(this, 21));
    }

    public final MaterialBuilder cornerRadius(float px) {
        this.cornerRadius = px;
        this.cornerRadiusExplicit = true;
        return this;
    }

    public final MaterialBuilder cornerSmoothness(float v10) {
        this.cornerSmoothness = v10;
        return this;
    }

    public final MaterialBuilder crossWindow(boolean enabled) {
        this.crossWindow = enabled;
        return this;
    }

    public final MaterialBuilder apply(final GlassEffect effect) {
        k.f(effect, "effect");
        final float f = this.view.getResources().getDisplayMetrics().density;
        if (!this.cornerRadiusExplicit) {
            this.cornerRadius = effect.getCornerRadiusDp() * f;
        }
        Materials materials = Materials.INSTANCE;
        final int i = 0;
        apply(materials.getBlur(), new S7.k() { // from class: com.stepos.motionkit.fx.material.d
            @Override // S7.k
            public final Object invoke(Object obj) {
                switch (i) {
                    case 0:
                        return MaterialBuilder.apply$lambda$1(effect, f, (BlurParams) obj);
                    case 1:
                        return MaterialBuilder.apply$lambda$2(effect, f, (StrokeParams) obj);
                    case 2:
                        return MaterialBuilder.apply$lambda$3(effect, f, (InnerShadowParams) obj);
                    case 3:
                        return MaterialBuilder.apply$lambda$4(effect, f, (RefractionParams) obj);
                    default:
                        return MaterialBuilder.apply$lambda$5(effect, f, (BlendParams) obj);
                }
            }
        });
        final int i6 = 1;
        apply(materials.getStroke(), new S7.k() { // from class: com.stepos.motionkit.fx.material.d
            @Override // S7.k
            public final Object invoke(Object obj) {
                switch (i6) {
                    case 0:
                        return MaterialBuilder.apply$lambda$1(effect, f, (BlurParams) obj);
                    case 1:
                        return MaterialBuilder.apply$lambda$2(effect, f, (StrokeParams) obj);
                    case 2:
                        return MaterialBuilder.apply$lambda$3(effect, f, (InnerShadowParams) obj);
                    case 3:
                        return MaterialBuilder.apply$lambda$4(effect, f, (RefractionParams) obj);
                    default:
                        return MaterialBuilder.apply$lambda$5(effect, f, (BlendParams) obj);
                }
            }
        });
        final int i10 = 2;
        apply(materials.getInnerShadow(), new S7.k() { // from class: com.stepos.motionkit.fx.material.d
            @Override // S7.k
            public final Object invoke(Object obj) {
                switch (i10) {
                    case 0:
                        return MaterialBuilder.apply$lambda$1(effect, f, (BlurParams) obj);
                    case 1:
                        return MaterialBuilder.apply$lambda$2(effect, f, (StrokeParams) obj);
                    case 2:
                        return MaterialBuilder.apply$lambda$3(effect, f, (InnerShadowParams) obj);
                    case 3:
                        return MaterialBuilder.apply$lambda$4(effect, f, (RefractionParams) obj);
                    default:
                        return MaterialBuilder.apply$lambda$5(effect, f, (BlendParams) obj);
                }
            }
        });
        final int i11 = 3;
        apply(materials.getRefraction(), new S7.k() { // from class: com.stepos.motionkit.fx.material.d
            @Override // S7.k
            public final Object invoke(Object obj) {
                switch (i11) {
                    case 0:
                        return MaterialBuilder.apply$lambda$1(effect, f, (BlurParams) obj);
                    case 1:
                        return MaterialBuilder.apply$lambda$2(effect, f, (StrokeParams) obj);
                    case 2:
                        return MaterialBuilder.apply$lambda$3(effect, f, (InnerShadowParams) obj);
                    case 3:
                        return MaterialBuilder.apply$lambda$4(effect, f, (RefractionParams) obj);
                    default:
                        return MaterialBuilder.apply$lambda$5(effect, f, (BlendParams) obj);
                }
            }
        });
        final int i12 = 4;
        apply(materials.getBlend(), new S7.k() { // from class: com.stepos.motionkit.fx.material.d
            @Override // S7.k
            public final Object invoke(Object obj) {
                switch (i12) {
                    case 0:
                        return MaterialBuilder.apply$lambda$1(effect, f, (BlurParams) obj);
                    case 1:
                        return MaterialBuilder.apply$lambda$2(effect, f, (StrokeParams) obj);
                    case 2:
                        return MaterialBuilder.apply$lambda$3(effect, f, (InnerShadowParams) obj);
                    case 3:
                        return MaterialBuilder.apply$lambda$4(effect, f, (RefractionParams) obj);
                    default:
                        return MaterialBuilder.apply$lambda$5(effect, f, (BlendParams) obj);
                }
            }
        });
        this.glassTextFragment = effect.getGlassText();
        return this;
    }
}
