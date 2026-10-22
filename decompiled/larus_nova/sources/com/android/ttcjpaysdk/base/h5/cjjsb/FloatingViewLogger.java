package com.android.ttcjpaysdk.base.h5.cjjsb;

import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J$\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/FloatingViewLogger;", "", "schema", "", "(Ljava/lang/String;)V", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "createTimestamp", "", "getSchema", "()Ljava/lang/String;", WidgetCostModule.TYPE_ON_CREATE, "", "onLoadResult", "errorCode", "", "errorMsg", "sendEvent", "eventName", "params", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloatingViewLogger {
    public static final Companion Companion = null;
    public static final String WALLET_COUNTDOWN_WIDGET_CREATE = "wallet_countdown_widget_create";
    public static final String WALLET_COUNTDOWN_WIDGET_DESTROY = "wallet_countdown_widget_destroy";
    public static final String WALLET_COUNTDOWN_WIDGET_ERROR = "wallet_countdown_widget_error";
    public static final String WALLET_COUNTDOWN_WIDGET_LOAD_RESULT = "wallet_countdown_widget_load_result";
    public static final String WALLET_COUNTDOWN_WIDGET_PERFORMANCE = "wallet_countdown_widget_performance";
    private final CJContext cjContext;
    private long createTimestamp;
    private final String schema;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/FloatingViewLogger$Companion;", "", "()V", "WALLET_COUNTDOWN_WIDGET_CREATE", "", "WALLET_COUNTDOWN_WIDGET_DESTROY", "WALLET_COUNTDOWN_WIDGET_ERROR", "WALLET_COUNTDOWN_WIDGET_LOAD_RESULT", "WALLET_COUNTDOWN_WIDGET_PERFORMANCE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void onCreate() {
        this.createTimestamp = System.currentTimeMillis();
        sendEvent(WALLET_COUNTDOWN_WIDGET_CREATE, MapsKt.mapOf(TuplesKt.to("schema", this.schema)));
    }

    public final String getSchema() {
        return this.schema;
    }

    public FloatingViewLogger(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.schema = r100;
        Set<String> r101 = CJContext.f202254w;
        this.cjContext = CJContext.c.a("ttcjpay.createCountDownWidget", "", "", new HashMap());
        this.createTimestamp = -1;
    }

    private final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        CJReporter.h(CJReporter.f202294a, this.cjContext, r100, r101, null, 56);
        CJReporter.o(this.cjContext, r100, r101);
    }

    public final void onLoadResult(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        sendEvent(WALLET_COUNTDOWN_WIDGET_LOAD_RESULT, MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", this.schema), TuplesKt.to("error_code", Integer.valueOf(r100)), TuplesKt.to("error_msg", r101)}));
    }
}
