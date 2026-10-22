package com.obric.oui.common.style;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/common/style/IOUIStyleProvider;", "", "getAlphaHelper", "Lcom/obric/oui/common/style/IOUIAlpha;", "getEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "getLayoutHelper", "Lcom/obric/oui/common/style/IOUILayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOUIStyleProvider {
    @NotNull
    IOUIAlpha getAlphaHelper();

    @NotNull
    OUIEffectHelper getEffectHelper();

    @NotNull
    IOUILayout getLayoutHelper();
}
