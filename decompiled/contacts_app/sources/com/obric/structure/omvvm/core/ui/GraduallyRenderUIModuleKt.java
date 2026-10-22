package com.obric.structure.omvvm.core.ui;

import kotlin.Metadata;

/* JADX INFO: compiled from: GraduallyRenderUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"isGraduallyRenderUIModule", "", "module", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "omvvm-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GraduallyRenderUIModuleKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isGraduallyRenderUIModule(QUIModule r1) {
        if ((r1 instanceof GraduallyRenderUIModule) == true) goto L5;
    L7:
        return false;
    L5:
        if (((GraduallyRenderUIModule) r1).shouldGraduallyRender() == false) goto L7;
        return true;
    }
}
