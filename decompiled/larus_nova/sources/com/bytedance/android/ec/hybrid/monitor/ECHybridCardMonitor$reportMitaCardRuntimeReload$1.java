package com.bytedance.android.ec.hybrid.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECHybridCardMonitor$reportMitaCardRuntimeReload$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $schema;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridCardMonitor$reportMitaCardRuntimeReload$1 f47523a;

        public a(ECHybridCardMonitor$reportMitaCardRuntimeReload$1 r100) {
            this.f47523a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
            r100.put("type", "runtime");     // Catch: Throwable -> L4
            r100.put("schema", this.f47523a.$schema);     // Catch: Throwable -> L4
            r100.put("is_reload", true);     // Catch: Throwable -> L4
            AppLogNewUtils.onEventV3("ec_mita_card_log", r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECHybridCardMonitor$reportMitaCardRuntimeReload$1(String r100) {
        this.$schema = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Schedulers.io().scheduleDirect(new a(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
