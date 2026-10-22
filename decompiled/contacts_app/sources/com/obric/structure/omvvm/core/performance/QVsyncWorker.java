package com.obric.structure.omvvm.core.performance;

import android.view.Choreographer;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.structure.omvvm.core.extension.DisposalAction;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QVsyncWorker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\"H\u0007J*\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020)H\u0002J%\u0010*\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b-J%\u0010.\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b0J\u001d\u00101\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b2J\"\u00103\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002J\u001d\u00104\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020/H\u0001¢\u0006\u0002\b5J\b\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\u0011R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/structure/omvvm/core/performance/QVsyncWorker;", "", "()V", "COMMIT_INDEX", "", "DEBUG", "", "FRAME_CALLBACK_TOKEN", "getFRAME_CALLBACK_TOKEN", "()Ljava/lang/Object;", "FRAME_CALLBACK_TOKEN$delegate", "Lkotlin/Lazy;", "TAG", "", "postInternalMethod", "Ljava/lang/reflect/Method;", "getPostInternalMethod", "()Ljava/lang/reflect/Method;", "postInternalMethod$delegate", "printSupportLog", "Lcom/obric/structure/omvvm/core/extension/DisposalAction;", "getPrintSupportLog", "()Lcom/obric/structure/omvvm/core/extension/DisposalAction;", "removeInternalMethod", "getRemoveInternalMethod", "removeInternalMethod$delegate", "supportCommit", "commitErrorLog", "", "getFrameCallbackToken", "getPostMethod", "getRemoveMethod", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "runnable", "Lkotlin/Function0;", "postCallbackDelayedInternal", "choreographer", "Landroid/view/Choreographer;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "token", "delayMillis", "", "postCommitCallback", "frameCallback", "Landroid/view/Choreographer$FrameCallback;", "postCommitCallback$omvvm_core_release", "postCommitRunnable", "Ljava/lang/Runnable;", "postCommitRunnable$omvvm_core_release", "removeCommitCallback", "removeCommitCallback$omvvm_core_release", "removeCommitInternal", "removeCommitRunnable", "removeCommitRunnable$omvvm_core_release", "removeErrorLog", "supportLog", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QVsyncWorker {
    private static int COMMIT_INDEX = 0;
    private static final boolean DEBUG = false;
    private static final Lazy FRAME_CALLBACK_TOKEN$delegate = null;
    public static final QVsyncWorker INSTANCE = null;
    public static final String TAG = "QVsyncWorker";
    private static final Lazy postInternalMethod$delegate = null;
    private static final DisposalAction printSupportLog = null;
    private static final Lazy removeInternalMethod$delegate = null;
    private static volatile boolean supportCommit;

    private final void commitErrorLog() {
    }

    private final void removeErrorLog() {
    }

    private final void supportLog() {
    }

    private QVsyncWorker() {
    }

    public static final /* synthetic */ int access$getCOMMIT_INDEX$p() {
        return COMMIT_INDEX;
    }

    public static final /* synthetic */ Object access$getFrameCallbackToken(QVsyncWorker r0) {
        return r0.getFrameCallbackToken();
    }

    public static final /* synthetic */ Method access$getPostMethod(QVsyncWorker r0) {
        return r0.getPostMethod();
    }

    public static final /* synthetic */ Method access$getRemoveMethod(QVsyncWorker r0) {
        return r0.getRemoveMethod();
    }

    static {
        INSTANCE = new QVsyncWorker();
        COMMIT_INDEX = 4;
        supportCommit = true;
        COMMIT_INDEX = 4;
        FRAME_CALLBACK_TOKEN$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, QVsyncWorker$FRAME_CALLBACK_TOKEN$2.INSTANCE);
        postInternalMethod$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, QVsyncWorker$postInternalMethod$2.INSTANCE);
        removeInternalMethod$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, QVsyncWorker$removeInternalMethod$2.INSTANCE);
        printSupportLog = new DisposalAction(QVsyncWorker$printSupportLog$1.INSTANCE);
    }

    private final Object getFRAME_CALLBACK_TOKEN() {
        return FRAME_CALLBACK_TOKEN$delegate.getValue();
    }

    private final Method getPostInternalMethod() {
        return (Method) postInternalMethod$delegate.getValue();
    }

    private final Method getRemoveInternalMethod() {
        return (Method) removeInternalMethod$delegate.getValue();
    }

    public final boolean postCommitRunnable$omvvm_core_release(Choreographer r8, Runnable r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "choreographer");
        Intrinsics.checkNotNullParameter(r9, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return postCallbackDelayedInternal(r8, r9, null, r10);
    }

    public final boolean removeCommitRunnable$omvvm_core_release(Choreographer r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "choreographer");
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return removeCommitInternal(r2, r3, null);
    }

    public final boolean postCommitCallback$omvvm_core_release(Choreographer r7, Choreographer.FrameCallback r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "choreographer");
        Intrinsics.checkNotNullParameter(r8, "frameCallback");
        if (getFRAME_CALLBACK_TOKEN() != null) goto L7;
        return false;
    L7:
        return postCallbackDelayedInternal(r7, r8, getFRAME_CALLBACK_TOKEN(), r9);
    }

    private final boolean postCallbackDelayedInternal(Choreographer r5, Object r6, Object r7, long r8) {
        if (supportCommit == true) goto L5;
    L17:
        return false;
    L5:
        if (getPostInternalMethod() == null) goto L17;
        Method r0 = getPostInternalMethod();     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.invoke(r5, new Object[]{Integer.valueOf(COMMIT_INDEX), r6, r7, Long.valueOf(r8)});     // Catch: Exception -> L11
    L13:
        if (supportCommit == false) goto L16;
        supportLog();
    L16:
        return supportCommit;
    L11:
        supportCommit = false;
        commitErrorLog();
        goto L13
    }

    public final boolean removeCommitCallback$omvvm_core_release(Choreographer r2, Choreographer.FrameCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "choreographer");
        Intrinsics.checkNotNullParameter(r3, "frameCallback");
        if (getFRAME_CALLBACK_TOKEN() != null) goto L7;
        return false;
    L7:
        return removeCommitInternal(r2, r3, getFRAME_CALLBACK_TOKEN());
    }

    private final boolean removeCommitInternal(Choreographer r5, Object r6, Object r7) {
        if (supportCommit == true) goto L5;
    L14:
        return false;
    L5:
        if (getRemoveInternalMethod() == null) goto L14;
        Method r0 = getRemoveInternalMethod();     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.invoke(r5, new Object[]{Integer.valueOf(COMMIT_INDEX), r6, r7});     // Catch: Exception -> L11
    L13:
        return supportCommit;
    L11:
        supportCommit = false;
        removeErrorLog();
        goto L13
    }

    private final Object getFrameCallbackToken() {
        Field r2 = DoubleReflectHelper.INSTANCE.getField(Choreographer.class, "FRAME_CALLBACK_TOKEN");
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.get(null);
    }

    private final Method getPostMethod() {
        return DoubleReflectHelper.INSTANCE.getMethodInner(Choreographer.class, "postCallbackDelayedInternal", new Class[]{Integer.TYPE, Object.class, Object.class, Long.TYPE});
    L5:
        supportCommit = false;
        commitErrorLog();
        return null;
    }

    private final Method getRemoveMethod() {
        return DoubleReflectHelper.INSTANCE.getMethodInner(Choreographer.class, "removeCallbacksInternal", new Class[]{Integer.TYPE, Object.class, Object.class});
    L5:
        supportCommit = false;
        removeErrorLog();
        return null;
    }

    public final DisposalAction getPrintSupportLog() {
        return printSupportLog;
    }

    @Deprecated(message = "Deprecated", replaceWith = @ReplaceWith(expression = "QVsyncFrameCaller.post()", imports = {}))
    public final void post(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        QVsyncFrameCaller.INSTANCE.post(r1);
    }
}
