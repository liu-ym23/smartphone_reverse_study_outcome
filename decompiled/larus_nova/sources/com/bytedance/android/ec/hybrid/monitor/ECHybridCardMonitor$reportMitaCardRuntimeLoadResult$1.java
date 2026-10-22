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
final class ECHybridCardMonitor$reportMitaCardRuntimeLoadResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ boolean $isReload;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $schema;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridCardMonitor$reportMitaCardRuntimeLoadResult$1 f47522a;

        public a(ECHybridCardMonitor$reportMitaCardRuntimeLoadResult$1 r100) {
            this.f47522a = r100;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            r100.put("type", "runtime");
            r100.put("schema", this.f47522a.$schema);
            r100.put("is_success", this.f47522a.$isSuccess);
            r100.put("is_reload", this.f47522a.$isReload);
            Integer r101 = this.f47522a.$errorCode;
            if (r101 == null) goto L5;
            r100.put("error_code", r101.intValue());
        L5:
            String r102 = this.f47522a.$errorMsg;
            if (r102 == null) goto L8;
            r100.put("error_msg", r102);
        L8:
            AppLogNewUtils.onEventV3("ec_mita_card_log", r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECHybridCardMonitor$reportMitaCardRuntimeLoadResult$1(String r100, boolean r101, boolean r102, Integer r103, String r104) {
        this.$schema = r100;
        this.$isSuccess = r101;
        this.$isReload = r102;
        this.$errorCode = r103;
        this.$errorMsg = r104;
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
