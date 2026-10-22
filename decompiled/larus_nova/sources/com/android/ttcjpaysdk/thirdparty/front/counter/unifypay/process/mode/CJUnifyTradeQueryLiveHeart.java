package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.mode;

import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter.CJUnifyPayAdapterProxy;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0007J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryLiveHeart;", "Ljava/lang/Runnable;", "tradeQueryParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryReqParams;", "queryCallBack", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryLiveHeart$UnifyQueryCallBack;", "adapterProxy", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryReqParams;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryLiveHeart$UnifyQueryCallBack;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterProxy;)V", "TAG", "", "currentRequestCount", "", "handler", "Landroid/os/Handler;", "isLastRequest", "", "()Z", "isQueryConnecting", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "maxRequestCount", "queryRequest", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "timeSpan", "askPayResult", "", "goOnQuerying", "processPayResultResponse", "data", "Lorg/json/JSONObject;", "run", "start", "stop", "UnifyQueryCallBack", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyTradeQueryLiveHeart implements Runnable {
    private final String TAG;
    private final CJUnifyPayAdapterProxy adapterProxy;
    private int currentRequestCount;
    private Handler handler;
    private volatile boolean isQueryConnecting;
    private final AtomicBoolean isRunning;
    private int maxRequestCount;
    private final UnifyQueryCallBack queryCallBack;
    private ICJPayRequest queryRequest;
    private final int timeSpan;
    private final CJUnifyTradeQueryReqParams tradeQueryParams;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryLiveHeart$UnifyQueryCallBack;", "", "onResponse", "", "tradeQueryBean", "Lorg/json/JSONObject;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnifyQueryCallBack {
        void onResponse(JSONObject r100);
    }

    public final void goOnQuerying() {
        this.isQueryConnecting = false;
        if (this.isRunning.get() == true) goto L5;
        return;
    L5:
        if (this.currentRequestCount >= this.maxRequestCount) goto L10;
        this.handler.postDelayed(this, this.timeSpan);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_process_mode_CJUnifyTradeQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final synchronized void start() {
        monitor-enter(this);
        this.isRunning.set(true);     // Catch: Throwable -> L9
        this.handler.removeCallbacks(this);     // Catch: Throwable -> L9
        ICJPayRequest r100 = this.queryRequest;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L9
    L6:
        this.queryRequest = null;     // Catch: Throwable -> L9
        this.isQueryConnecting = false;     // Catch: Throwable -> L9
        this.currentRequestCount = 0;     // Catch: Throwable -> L9
        this.handler.post(this);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void stop() {
        monitor-enter(this);
        this.isRunning.set(false);     // Catch: Throwable -> L9
        ICJPayRequest r100 = this.queryRequest;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L9
    L6:
        this.queryRequest = null;     // Catch: Throwable -> L9
        this.handler.removeCallbacks(this);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void askPayResult() {
        CJLogger.d(this.TAG, "askPayResult " + this.tradeQueryParams.getProcessInfo());
        ICJPayCallback r100 = new CJUnifyTradeQueryLiveHeart$askPayResult$callback$1(this);
        CJUnifyPayAdapterProxy r101 = this.adapterProxy;
        if (r101 == null) goto L5;
        ICJPayRequest r102 = r101.executeTradeQueryWithCallback(this.tradeQueryParams, r100);
    L6:
        this.queryRequest = r102;
        this.isQueryConnecting = true;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_process_mode_CJUnifyTradeQueryLiveHeart__run$___twin___() {
        if (this.isRunning.get() == true) goto L5;
        return;
    L5:
        if (this.currentRequestCount < this.maxRequestCount) goto L7;
        return;
    L7:
        if (this.isQueryConnecting == true) goto L18;
        this.currentRequestCount++;
        askPayResult();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyTradeQueryLiveHeart#run", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJUnifyTradeQueryLiveHeart#run", th);
        th.printStackTrace();
        return;
    }

    public final boolean isLastRequest() {
        if (this.currentRequestCount < this.maxRequestCount) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ String access$getTAG$p(CJUnifyTradeQueryLiveHeart r100) {
        return r100.TAG;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_process_mode_CJUnifyTradeQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(CJUnifyTradeQueryLiveHeart r100) {
        r100.com_android_ttcjpaysdk_thirdparty_front_counter_unifypay_process_mode_CJUnifyTradeQueryLiveHeart__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private final void processPayResultResponse(JSONObject r100) {
        UnifyQueryCallBack r101 = this.queryCallBack;     // Catch: JSONException -> L6
        if (r101 == null) goto L10;
        r101.onResponse(r100);     // Catch: JSONException -> L6
    L10:
        this.isQueryConnecting = false;
        return;
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyTradeQueryLiveHeart#processPayResultResponse", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJUnifyTradeQueryLiveHeart#processPayResultResponse", e);
        UnifyQueryCallBack r102 = this.queryCallBack;
        if (r102 == null) goto L10;
        r102.onResponse(null);
        goto L10
    }

    public static final /* synthetic */ void access$processPayResultResponse(CJUnifyTradeQueryLiveHeart r100, JSONObject r101) {
        r100.processPayResultResponse(r101);
    }

    public CJUnifyTradeQueryLiveHeart(CJUnifyTradeQueryReqParams r100, UnifyQueryCallBack r101, CJUnifyPayAdapterProxy r102) {
        Intrinsics.checkNotNullParameter(r100, "tradeQueryParams");
        this.tradeQueryParams = r100;
        this.queryCallBack = r101;
        this.adapterProxy = r102;
        this.TAG = "CJUnifyTradeQueryLiveHeart";
        this.timeSpan = 500;
        AtomicBoolean r103 = new AtomicBoolean(true);
        this.isRunning = r103;
        this.maxRequestCount = 5;
        this.handler = new Handler(Looper.getMainLooper());
        r103.set(true);
        if (r100.getQueryResultTimes() <= 0) goto L6;
        this.maxRequestCount = r100.getQueryResultTimes();
        return;
    }
}
