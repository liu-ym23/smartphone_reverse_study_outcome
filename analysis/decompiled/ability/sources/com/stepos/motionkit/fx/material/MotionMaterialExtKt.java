package com.stepos.motionkit.fx.material;

import android.view.View;
import com.stepos.motionkit.MotionKit;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"material", "Lcom/stepos/motionkit/fx/material/MaterialBuilder;", "Lcom/stepos/motionkit/MotionKit;", "view", "Landroid/view/View;", "materialText", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MotionMaterialExtKt {
    public static final MaterialBuilder material(MotionKit motionKit, View view) {
        k.f(motionKit, "<this>");
        k.f(view, "view");
        return new MaterialBuilder(view);
    }

    public static final MaterialBuilder materialText(MotionKit motionKit, View view) {
        k.f(motionKit, "<this>");
        k.f(view, "view");
        return new MaterialBuilder(view).asGlassText$motionkit_fx_release();
    }
}
