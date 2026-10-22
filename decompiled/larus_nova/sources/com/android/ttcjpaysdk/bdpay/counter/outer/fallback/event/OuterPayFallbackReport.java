package com.android.ttcjpaysdk.bdpay.counter.outer.fallback.event;

import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/fallback/event/OuterPayFallbackReport;", "", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "(Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;)V", "report", "", "eventName", "", "params", "", "reportClick", "click", "reportImp", "from", "reportRetain", "action", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OuterPayFallbackReport {
    public static final String CLICK_EVENT_BACK = "back";
    public static final String CLICK_EVENT_CONFIRM = "confirm";
    public static final String CLICK_EVENT_REFRESH = "refresh";
    public static final Companion Companion = null;
    public static final String RETAIN_ACTION_CANCEL = "cancel";
    public static final String RETAIN_ACTION_CONFIRM = "confirm";
    public static final String RETAIN_ACTION_IMP = "imp";
    private final CJContext cjContext;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/fallback/event/OuterPayFallbackReport$Companion;", "", "()V", "CLICK_EVENT_BACK", "", "CLICK_EVENT_CONFIRM", "CLICK_EVENT_REFRESH", "RETAIN_ACTION_CANCEL", "RETAIN_ACTION_CONFIRM", "RETAIN_ACTION_IMP", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OuterPayFallbackReport(CJContext r100) {
        Intrinsics.checkNotNullParameter(r100, "cjContext");
        this.cjContext = r100;
    }

    public final void reportClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("click", r100);
        report("wallet_cashier_render_fallback_click", r101);
    }

    public final void reportImp(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("from", r100);
        report("wallet_cashier_render_fallback_imp", r101);
    }

    public final void reportRetain(String r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("action", r100);
        report("wallet_cashier_render_fallback_retain", r101);
    }

    private final void report(String r100, Map<String, ? extends Object> r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r101);
        CJReporter.h(CJReporter.f202294a, this.cjContext, r100, r102, null, 56);
    }
}
