package com.bytedance.android.ec.hybrid.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECHybridCardMonitor$reportSliceActionInvoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $actionParams;
    final /* synthetic */ String $actionType;
    final /* synthetic */ qj.c $cardInfo;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridCardMonitor$reportSliceActionInvoke$1 f47524a;

        public a(ECHybridCardMonitor$reportSliceActionInvoke$1 r100) {
            this.f47524a = r100;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            r100.put("type", "action_invoke");
            r100.put("card_name", this.f47524a.$cardInfo.f533274a);
            r100.put("action_type", this.f47524a.$actionType);
            Map r101 = this.f47524a.$actionParams;
            if (r101 == null) goto L8;
            Iterator r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = (String) r103.getKey();
            r100.put("action_param_" + r104, r103.getValue());
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

    public ECHybridCardMonitor$reportSliceActionInvoke$1(qj.c r100, String r101, Map r102) {
        this.$cardInfo = r100;
        this.$actionType = r101;
        this.$actionParams = r102;
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
