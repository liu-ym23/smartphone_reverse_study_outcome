package com.android.ttcjpaysdk.integrated.counter.utils;

import android.os.Handler;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0007J\u0006\u0010\u001e\u001a\u00020\fJ\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayTradeQueryLiveHeart;", "Ljava/lang/Runnable;", "timeSpan", "", "maxRequestCount", "(II)V", "mCurrentRequestCount", "getMCurrentRequestCount", "()I", "setMCurrentRequestCount", "(I)V", "mIsQueryConnecting", "", "getMIsQueryConnecting", "()Z", "setMIsQueryConnecting", "(Z)V", "mIsRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mThread", "Ljava/lang/Thread;", "onTradeQueryListener", "Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayTradeQueryLiveHeart$OnTradeQueryListener;", "getOnTradeQueryListener", "()Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayTradeQueryLiveHeart$OnTradeQueryListener;", "setOnTradeQueryListener", "(Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayTradeQueryLiveHeart$OnTradeQueryListener;)V", "askPayResult", "", "goOnQuerying", "isLastRequest", "run", "start", "stop", "OnTradeQueryListener", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTradeQueryLiveHeart implements Runnable {
    private int mCurrentRequestCount;
    private volatile boolean mIsQueryConnecting;
    private AtomicBoolean mIsRunning;
    private Thread mThread;
    private int maxRequestCount;
    private OnTradeQueryListener onTradeQueryListener;
    private final int timeSpan;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/CJPayTradeQueryLiveHeart$OnTradeQueryListener;", "", "onTradeQuery", "", "params", "", "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTradeQueryListener {
        void onTradeQuery(Map<String, String> r100);
    }

    public final void goOnQuerying() {
        this.mIsQueryConnecting = false;
        new Handler().postDelayed(this, this.timeSpan);
    }

    @Override // java.lang.Runnable
    public void run() {
        com_android_ttcjpaysdk_integrated_counter_utils_CJPayTradeQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private final void askPayResult() {
        HashMap r100 = new HashMap();     // Catch: Exception -> L7
        OnTradeQueryListener r101 = this.onTradeQueryListener;     // Catch: Exception -> L7
        if (r101 == null) goto L5;
        r101.onTradeQuery(r100);     // Catch: Exception -> L7
    L5:
        this.mIsQueryConnecting = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeQueryLiveHeart#askPayResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeQueryLiveHeart#askPayResult", e);
        e.printStackTrace();
    }

    public void com_android_ttcjpaysdk_integrated_counter_utils_CJPayTradeQueryLiveHeart__run$___twin___() {
        if (this.mIsRunning.get() == false) goto L12;
        int r100 = this.mCurrentRequestCount;
        int r101 = this.maxRequestCount;
        if (r100 < r101) goto L9;
        if (r101 == (-1)) goto L9;
        return;
    L9:
        if (this.mIsQueryConnecting == true) goto L14;
        this.mCurrentRequestCount++;
        askPayResult();
        return;
    L14:
        return;
    }

    public final boolean isLastRequest() {
        if (this.mCurrentRequestCount < this.maxRequestCount) goto L5;
        return true;
    L5:
        return false;
    }

    public final void start() {
        this.mIsRunning.set(true);
        Thread r100 = this.mThread;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        if (ThreadMethodProxy.isAlive(r100) == false) goto L7;
        return;
    L7:
        Thread r101 = this.mThread;
        if (r101 == null) goto L11;
        ThreadMethodProxy.start(r101);
        return;
    }

    public final void stop() {
        this.mIsRunning.set(false);
        this.mThread = null;
    }

    public final int getMCurrentRequestCount() {
        return this.mCurrentRequestCount;
    }

    public final boolean getMIsQueryConnecting() {
        return this.mIsQueryConnecting;
    }

    public final OnTradeQueryListener getOnTradeQueryListener() {
        return this.onTradeQueryListener;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_android_ttcjpaysdk_integrated_counter_utils_CJPayTradeQueryLiveHeart_com_larus_apm_impl_protector_RunnableLancet_run(CJPayTradeQueryLiveHeart r100) {
        r100.com_android_ttcjpaysdk_integrated_counter_utils_CJPayTradeQueryLiveHeart__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void setMCurrentRequestCount(int r100) {
        this.mCurrentRequestCount = r100;
    }

    public final void setMIsQueryConnecting(boolean r100) {
        this.mIsQueryConnecting = r100;
    }

    public final void setOnTradeQueryListener(OnTradeQueryListener r100) {
        this.onTradeQueryListener = r100;
    }

    public CJPayTradeQueryLiveHeart(int r100, int r101) {
        this.timeSpan = r100;
        this.maxRequestCount = r101;
        AtomicBoolean r102 = new AtomicBoolean(true);
        this.mIsRunning = r102;
        r102.set(true);
        this.mThread = new PthreadThreadV2(this, "CJPayTradeQueryLiveHeart");
    }

    public /* synthetic */ CJPayTradeQueryLiveHeart(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 5;
    L5:
        this(r100, r101);
    }
}
