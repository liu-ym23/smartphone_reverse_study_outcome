package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FallbackConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "FallbackConfirmHost";
    private final ConfirmUiHost fallback;
    private final String perfLabel;
    private final ConfirmUiHost primary;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public FallbackConfirmHost(ConfirmUiHost primary, ConfirmUiHost fallback) {
        kotlin.jvm.internal.g.f(primary, "primary");
        kotlin.jvm.internal.g.f(fallback, "fallback");
        this.primary = primary;
        this.fallback = fallback;
        this.perfLabel = com.stepos.core.ota.d.i(primary.getPerfLabel(), "->", fallback.getPerfLabel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n show$lambda$0(FallbackConfirmHost fallbackConfirmHost, ConfirmUiRequest confirmUiRequest) {
        String perfLabel = fallbackConfirmHost.primary.getPerfLabel();
        String perfLabel2 = fallbackConfirmHost.fallback.getPerfLabel();
        ai.onnxruntime.a.y(ai.onnxruntime.a.s("primary=", perfLabel, " failed, fallback=", perfLabel2, " reqId="), confirmUiRequest.getReqId(), TAG);
        fallbackConfirmHost.fallback.show(confirmUiRequest);
        return lb.n.f10413a;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(ConfirmUiRequest request) {
        kotlin.jvm.internal.g.f(request, "request");
        this.primary.show(ConfirmUiRequest.copy$default(request, null, null, null, 0L, new cb.d(7, this, request), 15, null));
    }
}
