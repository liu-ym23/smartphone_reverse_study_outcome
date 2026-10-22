package com.obric.oui.texteffects.runtime;

import com.GlobalProxyLancet;
import com.obric.oui.texteffects.TextEffectDebugLog;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerApplier;", "", "()V", "apply", "", "frame", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "bindings", "", "Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "parentWidthPx", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExternalViewLayerApplier {
    public static final ExternalViewLayerApplier INSTANCE = null;

    static {
        INSTANCE = new ExternalViewLayerApplier();
    }

    private ExternalViewLayerApplier() {
    }

    public final void apply(TextEffectFrame r8, Collection<ExternalViewLayerBinding> r9, float r10) {
        Intrinsics.checkNotNullParameter(r8, "frame");
        Intrinsics.checkNotNullParameter(r9, "bindings");
        Collection<ExternalViewLayerBinding> r7 = r9;
        Iterator<T> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ExternalViewLayerBinding) r0.next()).reset();
        goto L4
    L6:
        Iterator<T> r1 = r8.getLayers().iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L23;
        LayerFrame r3 = (LayerFrame) r1.next();
        String r4 = r3.getBindingKey();
        if (r4 == null) goto L8;
        Iterator<T> r5 = r7.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((ExternalViewLayerBinding) r6).getBindingKey(), r4) == false) goto L14;
    L19:
        ExternalViewLayerBinding r11 = (ExternalViewLayerBinding) r6;
        if (r11 == null) goto L8;
        r11.apply(r3, r10);
        r2 = r2 + 1;
        goto L8
    L18:
        r6 = null;
        goto L19
    L23:
        TextEffectDebugLog r12 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == true) goto L26;
        return;
    L26:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L41;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(Intrinsics.stringPlus("OUITextEffects/", "ExternalApplier"), "apply frameLayers=" + r8.getLayers().size() + ", bindings=" + r9.size() + ", applied=" + r2 + ", parentWidth=" + r10);
        return;
    }
}
