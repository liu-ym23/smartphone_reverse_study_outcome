package com.obric.oui.bouncelayout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BounceTranslationDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u000bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "", "getTotalTranslation", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "callback", "Lkotlin/Function1;", "", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "setOnBounceTranslationListener", "updateBounceListeners", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceTranslationDelegate {
    private final Function1<Float, Unit> callback;
    private final Function0<BounceEdgeEffect[]> effectsProvider;
    private final Function0<Float> getTotalTranslation;
    private OnBounceTranslationListener listener;

    public BounceTranslationDelegate(Function0<Float> r2, Function0<BounceEdgeEffect[]> r3) {
        Intrinsics.checkNotNullParameter(r2, "getTotalTranslation");
        Intrinsics.checkNotNullParameter(r3, "effectsProvider");
        this.getTotalTranslation = r2;
        this.effectsProvider = r3;
        this.callback = new BounceTranslationDelegate$callback$1(this);
    }

    public static final /* synthetic */ Function0 access$getGetTotalTranslation$p(BounceTranslationDelegate r0) {
        return r0.getTotalTranslation;
    }

    public static final /* synthetic */ OnBounceTranslationListener access$getListener$p(BounceTranslationDelegate r0) {
        return r0.listener;
    }

    public final void setOnBounceTranslationListener(OnBounceTranslationListener r1) {
        this.listener = r1;
        updateBounceListeners();
    }

    public final void updateBounceListeners() {
        BounceEdgeEffect[] r0 = this.effectsProvider.invoke();
        int r2 = 0;
        if (this.listener != null) goto L11;
        int r5 = r0.length;
    L5:
        if (r2 >= r5) goto L10;
        BounceEdgeEffect r1 = r0[r2];
        r2 = r2 + 1;
        if (r1 == null) goto L5;
        r1.setOnTranslationChanged(null);
        goto L5
    L10:
        return;
    L11:
        int r3 = r0.length;
    L12:
        if (r2 >= r3) goto L17;
        BounceEdgeEffect r4 = r0[r2];
        r2 = r2 + 1;
        if (r4 == null) goto L12;
        r4.setOnTranslationChanged(this.callback);
        goto L12
    }
}
