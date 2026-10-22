package com.bytedanceos.common.ui.widget.oui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"findView", "T", "Landroid/view/View;", "id", "", "(Landroid/view/View;I)Landroid/view/View;", "appstorecommon_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ViewExtKt {
    @NotNull
    public static final <T extends View> T findView(@NotNull View r10, int r11) {
        q.g(r10, "<this>");
        T r12 = (T) r10.findViewById(r11);
        q.d(r12);
        return r12;
    }
}
