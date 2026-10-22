package com.obric.oui.bouncelayout;

import bg.h;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "", "sizePxProvider", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "maxOverscrollPx", "getMaxOverscrollPx", "()F", "applyMaxToEffects", "", "onSizeChanged", "setMaxOverscrollPx", CommonKey.KEY_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceOverscrollDelegate {

    @NotNull
    private final Function0<BounceEdgeEffect[]> effectsProvider;
    private float maxOverscrollPx;

    @NotNull
    private final Function0<Integer> sizePxProvider;

    public BounceOverscrollDelegate(@NotNull Function0<Integer> r10, @NotNull Function0<BounceEdgeEffect[]> r11) {
        q.g(r10, "sizePxProvider");
        q.g(r11, "effectsProvider");
        this.sizePxProvider = r10;
        this.effectsProvider = r11;
    }

    public final void applyMaxToEffects() {
        BounceEdgeEffect[] r10 = this.effectsProvider.invoke();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        BounceEdgeEffect r13 = r10[r12];
        r12 = r12 + 1;
        if (r13 == null) goto L3;
        r13.setMaxOverscrollPx(this.maxOverscrollPx);
        goto L3
    }

    public final float getMaxOverscrollPx() {
        return this.maxOverscrollPx;
    }

    public final void onSizeChanged() {
        int r10 = this.sizePxProvider.invoke().intValue();
        if (r10 <= 0) goto L5;
        setMaxOverscrollPx(r10);
        return;
    L5:
        applyMaxToEffects();
    }

    public final void setMaxOverscrollPx(float r10) {
        this.maxOverscrollPx = h.c(r10, 0.0f);
        applyMaxToEffects();
    }
}
