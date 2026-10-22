package com.stepos.core.ota.confirmui;

import android.util.Log;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/ota/confirmui/FallbackConfirmHost;", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "primary", "fallback", "<init>", "(Lcom/stepos/core/ota/confirmui/ConfirmUiHost;Lcom/stepos/core/ota/confirmui/ConfirmUiHost;)V", "Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;", "request", "LY8/t;", "show", "(Lcom/stepos/core/ota/confirmui/ConfirmUiRequest;)V", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "", "perfLabel", "Ljava/lang/String;", "getPerfLabel", "()Ljava/lang/String;", "Companion", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FallbackConfirmHost implements ConfirmUiHost {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "FallbackConfirmHost";
    private final ConfirmUiHost fallback;
    private final String perfLabel;
    private final ConfirmUiHost primary;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/core/ota/confirmui/FallbackConfirmHost$Companion;", "", "<init>", "()V", "TAG", "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public FallbackConfirmHost(ConfirmUiHost primary, ConfirmUiHost fallback) {
        kotlin.jvm.internal.p.i(primary, "primary");
        kotlin.jvm.internal.p.i(fallback, "fallback");
        this.primary = primary;
        this.fallback = fallback;
        this.perfLabel = primary.getPerfLabel() + "->" + fallback.getPerfLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t show$lambda$0(FallbackConfirmHost fallbackConfirmHost, ConfirmUiRequest confirmUiRequest) {
        Log.i(TAG, "primary=" + fallbackConfirmHost.primary.getPerfLabel() + " failed, fallback=" + fallbackConfirmHost.fallback.getPerfLabel() + " reqId=" + confirmUiRequest.getReqId());
        fallbackConfirmHost.fallback.show(confirmUiRequest);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public String getPerfLabel() {
        return this.perfLabel;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
    public void show(final ConfirmUiRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        this.primary.show(ConfirmUiRequest.copy$default(request, null, null, null, 0L, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FallbackConfirmHost.show$lambda$0(this.f29573a, request);
            }
        }, 15, null));
    }
}
