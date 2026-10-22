package com.obric.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.google.gson.Gson;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import obric.util.Utils;

/* JADX INFO: compiled from: GlobalUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/utils/GlobalUtils;", "", "()V", "EVENT_DISPATCHER_HANDLER_THREAD_NAME", "", "TAG", "deviceId", "eventDispatcherHandlerThread", "Landroid/os/HandlerThread;", "getEventDispatcherHandlerThread", "()Landroid/os/HandlerThread;", "eventDispatcherHandlerThread$delegate", "Lkotlin/Lazy;", "globalIOCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getGlobalIOCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "execute", "", "runnable", "Ljava/lang/Runnable;", Utils.METHOD_GET_DEVICE_ID, "getDeviceIdOrImei", "getImei", "isMobileNetwork", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalUtils {
    private static final String EVENT_DISPATCHER_HANDLER_THREAD_NAME = "GlobalEventDispatcherHandlerThread";
    public static final GlobalUtils INSTANCE = null;
    private static final String TAG = "GlobalUtils";
    private static String deviceId;
    private static final Lazy eventDispatcherHandlerThread$delegate = null;
    private static final CoroutineScope globalIOCoroutineScope = null;
    private static final Gson gson = null;

    /* JADX INFO: renamed from: com.obric.utils.GlobalUtils$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.utils.GlobalUtils$execute$1", f = "GlobalUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Runnable $runnable;
        int label;

        AnonymousClass1(Runnable r1, Continuation<? super AnonymousClass1> r2) {
            this.$runnable = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.$runnable, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$runnable.run();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private GlobalUtils() {
    }

    public static final /* synthetic */ void access$setDeviceId$p(String r0) {
        deviceId = r0;
    }

    static {
        INSTANCE = new GlobalUtils();
        gson = new Gson();
        globalIOCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        eventDispatcherHandlerThread$delegate = LazyKt.lazy(GlobalUtils$eventDispatcherHandlerThread$2.INSTANCE);
    }

    public final Gson getGson() {
        return gson;
    }

    public final CoroutineScope getGlobalIOCoroutineScope() {
        return globalIOCoroutineScope;
    }

    public final HandlerThread getEventDispatcherHandlerThread() {
        return (HandlerThread) eventDispatcherHandlerThread$delegate.getValue();
    }

    public final void execute(Runnable r7) {
        Intrinsics.checkNotNullParameter(r7, "runnable");
        BuildersKt.launch$default(globalIOCoroutineScope, null, null, new AnonymousClass1(r7, null), 3, null);
    }

    public final String getDeviceIdOrImei() {
        String r0 = getDeviceId();
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = getImei();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getDeviceId deviceId is null, try to get imei " + r2.length());
        return r2;
    }

    public final String getDeviceId() {
        if (deviceId != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getDeviceId deviceId is null, try to get deviceId");
        deviceId = MatrixTeaManager.Companion.getInstance().getDeviceId();
    L6:
        if (deviceId != null) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getDeviceId deviceId is null, try to load deviceId");
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(new C04441());
    L8:
        String r1 = deviceId;
        if (r1 == null) goto L11;
        return r1;
    L11:
        return null;
    }

    public final String getImei() {
        Object r1 = ContactsApplication.getInstance().getApplicationContext().getSystemService("phone");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String r2 = ((TelephonyManager) r1).getImei();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public final boolean isMobileNetwork() {
        ContactsApplication r9 = ContactsApplication.getInstance();
        if (r9 == null) goto L5;
        Context r10 = r9.getApplicationContext();
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        Object r11 = r10.getSystemService("connectivity");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r12 = (ConnectivityManager) r11;
        Network[] r1 = r12.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(r1, "cm.allNetworks");
        Network[] r2 = r1;
        int r3 = r2.length;
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
    L11:
        if (r4 >= r3) goto L21;
        NetworkInfo r7 = r12.getNetworkInfo(r2[r4]);
        if (r7 == null) goto L20;
        if (r7.getType() != 1) goto L18;
        r5 = r5 | r7.isConnected();
    L18:
        if (r7.getType() != 0) goto L20;
        r6 = r6 | r7.isConnected();
    L20:
        r4 = r4 + 1;
        goto L11
    L21:
        if (r5 == true) goto L29;
        if (r6 == true) goto L24;
        return false;
    L24:
        return true;
    L29:
        return false;
    L5:
        r10 = null;
        goto L7
    }
}
