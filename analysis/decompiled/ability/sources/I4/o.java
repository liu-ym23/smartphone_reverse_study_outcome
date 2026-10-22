package I4;

import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.UniformSpec;
import g1.AbstractC1451a;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public abstract class o {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0015, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(android.widget.PopupWindow r2) {
        /*
            android.view.View r2 = r2.getContentView()
            r0 = 0
            if (r2 == 0) goto Lc
            android.view.ViewParent r2 = r2.getParent()
            goto Ld
        Lc:
            r2 = r0
        Ld:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L14
            android.view.View r2 = (android.view.View) r2
            goto L15
        L14:
            r2 = r0
        L15:
            if (r2 == 0) goto L26
            r1 = 0
            r2.setBackgroundColor(r1)
            android.view.ViewParent r2 = r2.getParent()
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L14
            android.view.View r2 = (android.view.View) r2
            goto L15
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.o.a(android.widget.PopupWindow):void");
    }

    public static final void b(FxInstance fxInstance, String str, float[] fArr) {
        int length = fArr.length;
        if (length == 1) {
            fxInstance.setUniform(str, fArr[0]);
            return;
        }
        if (length == 2) {
            fxInstance.setUniform(str, fArr[0], fArr[1]);
        } else if (length == 3) {
            fxInstance.setUniform(str, fArr[0], fArr[1], fArr[2]);
        } else {
            if (length != 4) {
                return;
            }
            fxInstance.setUniform(str, fArr[0], fArr[1], fArr[2], fArr[3]);
        }
    }

    public static final float c(A5.c cVar) {
        float fMax;
        float fT = cVar.t("uDuration");
        if (fT <= 0.0f) {
            fT = 1.4f;
        }
        float fT2 = cVar.t("uRingGap");
        if (fT2 < 0.0f) {
            fT2 = 0.0f;
        }
        float fT3 = cVar.t("uExitDur");
        if (fT3 <= 0.0f) {
            fT3 = 0.25f;
        }
        float fT4 = AbstractC1451a.t(cVar.t("uRefractFadeAt") * 0.01f, 0.02f, 0.98f);
        float f = (((1.0f - fT4) * 0.55f) + fT4) * fT;
        if (cVar.t("uRings") > 1.5f) {
            float f7 = fT / 1.767f;
            float f9 = f7 * 0.45f * 0.45f;
            fMax = Math.max((1.1f * f7) + f9, (f7 * 0.917f) + fT2 + f9);
        } else {
            fMax = cVar.t("uHold") < 0.5f ? (fT3 * 0.45f) + fT : fT;
        }
        float fMin = Math.min(fMax, Math.min(fT, f));
        if (fMin < 0.05f) {
            return 0.05f;
        }
        return fMin;
    }

    public static final LinkedHashMap d(EffectDefinition def) {
        float[] fArr;
        kotlin.jvm.internal.k.f(def, "def");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (UniformSpec uniformSpec : def.getUniforms()) {
            String name = uniformSpec.getName();
            if (uniformSpec instanceof UniformSpec.Float1) {
                fArr = new float[]{((UniformSpec.Float1) uniformSpec).getDefault()};
            } else if (uniformSpec instanceof UniformSpec.Float2) {
                UniformSpec.Float2 float2 = (UniformSpec.Float2) uniformSpec;
                fArr = new float[]{float2.getDefaultX(), float2.getDefaultY()};
            } else if (uniformSpec instanceof UniformSpec.Float3) {
                UniformSpec.Float3 float3 = (UniformSpec.Float3) uniformSpec;
                fArr = new float[]{float3.getDefaultX(), float3.getDefaultY(), float3.getDefaultZ()};
            } else if (uniformSpec instanceof UniformSpec.Float4) {
                UniformSpec.Float4 float4 = (UniformSpec.Float4) uniformSpec;
                fArr = new float[]{float4.getDefaultX(), float4.getDefaultY(), float4.getDefaultZ(), float4.getDefaultW()};
            } else if (uniformSpec instanceof UniformSpec.Color) {
                int defaultColor = ((UniformSpec.Color) uniformSpec).getDefaultColor();
                fArr = new float[]{((defaultColor >> 16) & 255) / 255.0f, ((defaultColor >> 8) & 255) / 255.0f, (defaultColor & 255) / 255.0f, ((defaultColor >> 24) & 255) / 255.0f};
            } else {
                fArr = new float[]{0.0f};
            }
            linkedHashMap.put(name, fArr);
        }
        return linkedHashMap;
    }
}
