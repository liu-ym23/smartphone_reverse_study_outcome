package com.obric.contactsdk;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.GlobalProxyLancet;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.smssdk.SmsMmsObserver;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import defpackage.CallContentObserver;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSmsDataDonation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/contactsdk/CallSmsDataDonation;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCallFeatureObserverInit", "", "mContactsDonateObserverInit", "getMContext", "()Landroid/content/Context;", "mHandlerThreadInit", "mMmsDonateObserverInit", "mSmsMmsDonateHandler", "Landroid/os/Handler;", "mSmsMmsDonateHandlerThread", "Landroid/os/HandlerThread;", "initCallFeatureObserver", "", "initContactsDataAwareness", "initDataAwareness", "initHandlerThread", "initMmsSmsDataAwareness", "release", "Companion", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSmsDataDonation {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private boolean mCallFeatureObserverInit;
    private boolean mContactsDonateObserverInit;
    private final Context mContext;
    private boolean mHandlerThreadInit;
    private boolean mMmsDonateObserverInit;
    private Handler mSmsMmsDonateHandler;
    private HandlerThread mSmsMmsDonateHandlerThread;

    /* JADX INFO: compiled from: CallSmsDataDonation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/contactsdk/CallSmsDataDonation$Companion;", "", "()V", "TAG", "", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public CallSmsDataDonation(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.mContext = r2;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    static {
        Companion = new Companion(null);
        TAG = "CallSmsDataDonation";
    }

    private final void initHandlerThread() {
        if (this.mHandlerThreadInit == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initHandlerThread: mHandlerThreadInit is true");
        return;
    L6:
        HandlerThread r0 = new HandlerThread("SmsMmsDonateHandlerThread");
        this.mSmsMmsDonateHandlerThread = r0;
        r0.start();
        HandlerThread r1 = this.mSmsMmsDonateHandlerThread;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandlerThread");
        r1 = null;
    L9:
        this.mSmsMmsDonateHandler = new Handler(r1.getLooper());
        this.mHandlerThreadInit = true;
    }

    public final void initDataAwareness() {
        initHandlerThread();
        initMmsSmsDataAwareness();
        initContactsDataAwareness();
    }

    public final void initContactsDataAwareness() {
        if (this.mContactsDonateObserverInit == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initContactsDataAwareness: mContactsDonateObserverInit is true");
        return;
    L6:
        initHandlerThread();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        CallSmsDataDonation r1 = this;     // Catch: Throwable -> L9
        this.mContext.getContentResolver().registerContentObserver(ContractKt.getCONTACT_DATABASE_URI(), false, new CallContentObserver(new Handler(), this.mContext));     // Catch: Throwable -> L9
        initCallFeatureObserver();     // Catch: Throwable -> L9
        Object r2 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.m806exceptionOrNullimpl(r2);
        if (r3 == null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "initContactsDataAwareness: registerContentObserver failed", r3);
    L15:
        if (Result.m810isSuccessimpl(r2) == false) goto L20;
        Unit r4 = (Unit) r2;
        this.mContactsDonateObserverInit = true;
        return;
    L20:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void initMmsSmsDataAwareness() {
        if (this.mMmsDonateObserverInit == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initMmsSmsDataAwareness: mMmsDonateObserverInit is true");
        return;
    L6:
        initHandlerThread();
        ContentResolver r0 = this.mContext.getContentResolver();
        Uri r1 = SmsMmsDatabaseUtil.INSTANCE.getMMS_SMS_OBSERVER_URI();
        Handler r3 = this.mSmsMmsDonateHandler;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandler");
        r3 = null;
    L9:
        r0.registerContentObserver(r1, false, new SmsMmsObserver(r3, this.mContext));
        this.mMmsDonateObserverInit = true;
    }

    public final void initCallFeatureObserver() {
        if (this.mCallFeatureObserverInit == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initCallFeatureObserver: mCallFeatureObserverInit is true");
        return;
    L6:
        initHandlerThread();
        this.mContext.getContentResolver().registerContentObserver(CallFeatureEntityUtilKt.getCALL_FEATURE_URI(), false, new CallFeatureObserver(new Handler(), this.mContext));
        this.mCallFeatureObserverInit = true;
    }

    public final void release() {
        HandlerThread r0 = this.mSmsMmsDonateHandlerThread;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSmsMmsDonateHandlerThread");
        r0 = null;
    L5:
        r0.quitSafely();
    }
}
