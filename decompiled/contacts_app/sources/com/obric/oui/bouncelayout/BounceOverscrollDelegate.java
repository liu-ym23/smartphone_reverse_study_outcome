package com.obric.oui.bouncelayout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BounceOverscrollDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "", "sizePxProvider", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "maxOverscrollPx", "getMaxOverscrollPx", "()F", "applyMaxToEffects", "", "onSizeChanged", "setMaxOverscrollPx", "value", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceOverscrollDelegate {
    private final Function0<BounceEdgeEffect[]> effectsProvider;
    private float maxOverscrollPx;
    private final Function0<Integer> sizePxProvider;

    public BounceOverscrollDelegate(Function0<Integer> r2, Function0<BounceEdgeEffect[]> r3) {
        Intrinsics.checkNotNullParameter(r2, "sizePxProvider");
        Intrinsics.checkNotNullParameter(r3, "effectsProvider");
        this.sizePxProvider = r2;
        this.effectsProvider = r3;
    }

    public final float getMaxOverscrollPx() {
        return this.maxOverscrollPx;
    }

    public final void onSizeChanged() {
        int r0 = this.sizePxProvider.invoke().intValue();
        if (r0 <= 0) goto L5;
        setMaxOverscrollPx(r0);
        return;
    L5:
        applyMaxToEffects();
    }

    public final void setMaxOverscrollPx(float r2) {
        this.maxOverscrollPx = RangesKt.coerceAtLeast(r2, 0.0f);
        applyMaxToEffects();
    }

    public final void applyMaxToEffects() {
        BounceEdgeEffect[] r0 = this.effectsProvider.invoke();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BounceEdgeEffect r3 = r0[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L3;
        r3.setMaxOverscrollPx(this.maxOverscrollPx);
        goto L3
    }
}
