package com.bytedance.android.ec.hybrid.xelement.ecomtextarea;

import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/hybrid/xelement/ecomtextarea/ECLynxTextArea;", "Lcom/bytedance/ies/xelement/input/LynxTextAreaView;", "", "mult", "", "lineSpacingMult", "extra", "lineSpacingExtra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxTextArea extends LynxTextAreaView {

    public static final class a {
    }

    static {
    }

    public ECLynxTextArea(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @LynxProp(name = "line-spacing-extra-android")
    public final void lineSpacingExtra(float r100) {
        getView().setLineSpacing(r100, 1.0f);
    }

    @LynxProp(name = "line-spacing-mult-android")
    public final void lineSpacingMult(float r100) {
        getView().setLineSpacing(0.0f, r100);
    }
}
