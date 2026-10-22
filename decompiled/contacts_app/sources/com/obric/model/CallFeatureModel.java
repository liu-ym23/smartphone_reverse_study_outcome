package com.obric.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.database.entity.CallFeatureEntity;
import com.obric.model.bean.CallFeatureBean;
import com.obric.utils.GlobalUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: CallFeatureModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004ABCDB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0016J&\u0010)\u001a\u00020$2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\b\u0010+\u001a\u0004\u0018\u00010,J\u001c\u0010-\u001a\u00020$2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tJ\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0006J\u0018\u00101\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u0006J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0006J\u000e\u00103\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018J4\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0006J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020$H\u0002J\u000e\u0010<\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010=\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010>\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014J\u000e\u0010?\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0016J\b\u0010@\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0011\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00120\u0012 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0013\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00140\u0014 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0015\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00160\u0016 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t0\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/model/CallFeatureModel;", "", "()V", "MSG_RELOAD_DATA", "", "TAG", "", "callFeatureMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "Lcom/obric/model/bean/CallFeatureBean;", "callFeatureModelListeners", "", "Lcom/obric/model/CallFeatureModel$CallFeatureModelListener;", "kotlin.jvm.PlatformType", "", "callResultListeners", "Lcom/obric/model/CallFeatureModel$CallResultListener;", "callSummaryFinishedListeners", "Lcom/obric/model/CallFeatureModel$CallSummaryFinishedListener;", "callSummaryStartedListeners", "Lcom/obric/model/CallFeatureModel$CallSummaryStartedListener;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "isInitDone", "", "summarizingDataSet", "getSummarizingDataSet", "()Ljava/util/Set;", "transientSummaryFailures", "addCallFeatureModelListener", "", "listener", "addCallResultListener", "addCallSummaryFinishedListener", "addCallSummaryStartedListener", "callSummaryFinished", "data", "callSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "callSummaryStarted", "clearTransientSummaryFailure", "callCreateTime", "phoneNumber", "getCallFeature", "hasTransientSummaryFailure", "init", "notifyCallResult", "callForMeParams", "result", "status", "onHandleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "onMsgReloadData", "removeCallFeatureModelListener", "removeCallResultListener", "removeCallSummaryFinishedListener", "removeCallSummaryStartedListener", "triggerReloadData", "CallFeatureModelListener", "CallResultListener", "CallSummaryFinishedListener", "CallSummaryStartedListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureModel {
    public static final CallFeatureModel INSTANCE = null;
    private static final int MSG_RELOAD_DATA = 1;
    private static final String TAG = "CallFeatureModel";
    private static final ConcurrentHashMap<Pair<Long, String>, CallFeatureBean> callFeatureMap = null;
    private static final Set<CallFeatureModelListener> callFeatureModelListeners = null;
    private static final Set<CallResultListener> callResultListeners = null;
    private static final Set<CallSummaryFinishedListener> callSummaryFinishedListeners = null;
    private static final Set<CallSummaryStartedListener> callSummaryStartedListeners = null;
    private static Context context;
    private static final Handler handler = null;
    private static final HandlerThread handlerThread = null;
    private static boolean isInitDone;
    private static final Set<Pair<Long, String>> summarizingDataSet = null;
    private static final Set<Pair<Long, String>> transientSummaryFailures = null;

    /* JADX INFO: compiled from: CallFeatureModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/obric/model/CallFeatureModel$CallFeatureModelListener;", "", "onDataReady", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallFeatureModelListener {

        /* JADX INFO: compiled from: CallFeatureModel.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onDataReady(CallFeatureModelListener r0) {
            }
        }

        void onDataReady();
    }

    /* JADX INFO: compiled from: CallFeatureModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\f"}, d2 = {"Lcom/obric/model/CallFeatureModel$CallResultListener;", "", "onCallResult", "", "callForMeParams", "", "result", "", "status", "callCreateTime", "", "phoneNumber", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallResultListener {
        void onCallResult(String r1, boolean r2, String r3, long r4, String r6);
    }

    /* JADX INFO: compiled from: CallFeatureModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/obric/model/CallFeatureModel$CallSummaryFinishedListener;", "", "onCallSummaryFinished", "", "data", "Lkotlin/Pair;", "", "", "callSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallSummaryFinishedListener {
        void onCallSummaryFinished(Pair<Long, String> r1, CallSummaryResult r2);
    }

    /* JADX INFO: compiled from: CallFeatureModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/model/CallFeatureModel$CallSummaryStartedListener;", "", "onCallSummaryStarted", "", "data", "Lkotlin/Pair;", "", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallSummaryStartedListener {
        void onCallSummaryStarted(Pair<Long, String> r1);
    }

    private CallFeatureModel() {
    }

    public static final /* synthetic */ void access$onHandleMessage(CallFeatureModel r0, Message r1) {
        r0.onHandleMessage(r1);
    }

    public static final /* synthetic */ void access$triggerReloadData(CallFeatureModel r0) {
        r0.triggerReloadData();
    }

    static {
        INSTANCE = new CallFeatureModel();
        callSummaryStartedListeners = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        callSummaryFinishedListeners = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        callFeatureModelListeners = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        callResultListeners = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.9f, 1));
        callFeatureMap = new ConcurrentHashMap();
        HandlerThread r0 = new HandlerThread(TAG);
        handlerThread = r0;
        Set<Pair<Long, String>> r1 = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(r1, "newSetFromMap(ConcurrentHashMap())");
        summarizingDataSet = r1;
        Set<Pair<Long, String>> r2 = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(r2, "newSetFromMap(ConcurrentHashMap())");
        transientSummaryFailures = r2;
        r0.start();
        final Looper r3 = r0.getLooper();
        handler = new AnonymousClass1(r3);
    }

    public final Set<Pair<Long, String>> getSummarizingDataSet() {
        return summarizingDataSet;
    }

    public final synchronized void init(Context r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L10
        if (isInitDone == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Context r0 = r4.getApplicationContext();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r0, "context.applicationContext");     // Catch: Throwable -> L10
        context = r0;     // Catch: Throwable -> L10
        triggerReloadData();     // Catch: Throwable -> L10
        ContentResolver r5 = r4.getContentResolver();     // Catch: Throwable -> L10
        Uri r1 = ObricCallLogProviderHelper.INSTANCE.getCallFeatureUri();     // Catch: Throwable -> L10
        final Handler r2 = handler;     // Catch: Throwable -> L10
        r5.registerContentObserver(r1, true, new C03061(r2));     // Catch: Throwable -> L10
        isInitDone = true;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void addCallFeatureModelListener(CallFeatureModelListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callFeatureModelListeners.add(r1);
    }

    public final void removeCallFeatureModelListener(CallFeatureModelListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callFeatureModelListeners.remove(r1);
    }

    private final void triggerReloadData() {
        Handler r1 = handler;
        r1.removeMessages(1);
        r1.sendEmptyMessage(1);
    }

    private final void onHandleMessage(Message r3) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onHandleMessage " + r3.what);
        if (r3.what != 1) goto L6;
        onMsgReloadData();
        return;
    }

    public final CallFeatureBean getCallFeature(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "phoneNumber");
        ConcurrentHashMap<Pair<Long, String>, CallFeatureBean> r2 = callFeatureMap;
        monitor-enter(r2);
        CallFeatureBean r6 = r2.get(new Pair(Long.valueOf(r3), r5));     // Catch: Throwable -> L9
        if (r6 != null) goto L7;
        r6 = r2.get(new Pair(Long.valueOf(r3), null));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r2);
        return r6;
    L9:
        th = move-exception;
        throw th;
    }

    public final void addCallSummaryStartedListener(CallSummaryStartedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callSummaryStartedListeners.add(r1);
    }

    public final void removeCallSummaryStartedListener(CallSummaryStartedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callSummaryStartedListeners.remove(r1);
    }

    public final void addCallSummaryFinishedListener(CallSummaryFinishedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callSummaryFinishedListeners.add(r1);
    }

    public final void removeCallSummaryFinishedListener(CallSummaryFinishedListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callSummaryFinishedListeners.remove(r1);
    }

    public final void callSummaryStarted(Pair<Long, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        String r3 = r4.getSecond();
        if (r3 != null) goto L5;
        return;
    L5:
        summarizingDataSet.add(new Pair(r4.getFirst(), r3));
        transientSummaryFailures.remove(r4);
        StringBuilder r5 = new StringBuilder("model started date=").append(r4.getFirst().longValue()).append(" listenerCount=");
        Set<CallSummaryStartedListener> r0 = callSummaryStartedListeners;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r5.append(r0.size()).toString());
        Intrinsics.checkNotNullExpressionValue(r0, "callSummaryStartedListeners");
        Iterator<T> r6 = r0.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((CallSummaryStartedListener) r6.next()).onCallSummaryStarted(r4);
        goto L7
    }

    public final void callSummaryFinished(Pair<Long, String> r3, CallSummaryResult r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        StringBuilder r2 = new StringBuilder("model finished date=").append(r3.getFirst().longValue()).append(" resultError=");
        Integer r0 = null;
        if (r4 == null) goto L5;
        Integer r1 = Integer.valueOf(r4.getErrorCode());
    L6:
        StringBuilder r5 = r2.append(r1).append(" summaryError=");
        if (r4 == null) goto L11;
        CallSummary r6 = r4.getData();
        if (r6 == null) goto L11;
        r0 = Integer.valueOf(r6.getErrorCode());
    L11:
        StringBuilder r7 = r5.append(r0).append(" transient=");
        if (r4 != null) goto L14;
        boolean r8 = true;
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r7.append(r8).toString());
        TypeIntrinsics.asMutableCollection(summarizingDataSet).remove(r3);
        if (r4 != null) goto L18;
        transientSummaryFailures.add(r3);
    L19:
        Set<CallSummaryFinishedListener> r9 = callSummaryFinishedListeners;
        Intrinsics.checkNotNullExpressionValue(r9, "callSummaryFinishedListeners");
        Iterator<T> r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        ((CallSummaryFinishedListener) r10.next()).onCallSummaryFinished(r3, r4);
        goto L21
    L23:
        return;
    L18:
        transientSummaryFailures.remove(r3);
        goto L19
    L14:
        r8 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final boolean hasTransientSummaryFailure(long r2, String r4) {
        return transientSummaryFailures.contains(new Pair(Long.valueOf(r2), r4));
    }

    public final void clearTransientSummaryFailure(long r2, String r4) {
        transientSummaryFailures.remove(new Pair(Long.valueOf(r2), r4));
    }

    public final void addCallResultListener(CallResultListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callResultListeners.add(r1);
    }

    public final void removeCallResultListener(CallResultListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        callResultListeners.remove(r1);
    }

    public final void notifyCallResult(String r9, boolean r10, String r11, long r12, String r14) {
        Set<CallResultListener> r8 = callResultListeners;
        Intrinsics.checkNotNullExpressionValue(r8, "callResultListeners");
        Iterator<T> r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((CallResultListener) r13.next()).onCallResult(r9, r10, r11, r12, r14);
        goto L4
    }

    private final void onMsgReloadData() {
        long r0 = System.currentTimeMillis();
        ConcurrentHashMap<Pair<Long, String>, CallFeatureBean> r15 = callFeatureMap;
        monitor-enter(r15);
        r15.clear();     // Catch: Throwable -> L24
        ObricCallLogProviderHelper r2 = ObricCallLogProviderHelper.INSTANCE;     // Catch: Throwable -> L24
        Context r3 = context;     // Catch: Throwable -> L24
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("context");     // Catch: Throwable -> L24
        r3 = null;
    L7:
        Iterator<CallFeatureEntity> r4 = r2.getAllCallFeatureEntity(r3).iterator();     // Catch: Throwable -> L24
    L9:
        if (r4.hasNext() == false) goto L17;
        CallFeatureEntity r5 = r4.next();     // Catch: Throwable -> L24
        String r6 = r5.getSummary();     // Catch: Throwable -> L24
        if (r6 == null) goto L13;
        CallSummary r7 = (CallSummary) GlobalUtils.INSTANCE.getGson().fromJson(r6, CallSummary.class);     // Catch: Throwable -> L24
    L14:
        if (r7 != null) goto L16;
        r7 = new CallSummary(null, null, null, null, 0, 31, null);     // Catch: Throwable -> L24
    L16:
        callFeatureMap.put(new Pair(Long.valueOf(r5.getCallCreateTime()), r5.getPhoneNumber()), new CallFeatureBean(r5.getId(), r5.getFeature(), r5.getStatus(), r7, r5.getPhoneNumber()));     // Catch: Throwable -> L24
        goto L9
    L13:
        r7 = null;
        goto L14
    L17:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r15);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Reload data done! time: " + (System.currentTimeMillis() - r0) + " ms. Count is " + callFeatureMap.size());
        Set<CallFeatureModelListener> r16 = callFeatureModelListeners;
        Intrinsics.checkNotNullExpressionValue(r16, "callFeatureModelListeners");
        Iterator<T> r17 = r16.iterator();
    L21:
        if (r17.hasNext() == false) goto L23;
        ((CallFeatureModelListener) r17.next()).onDataReady();
        goto L21
    L23:
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
