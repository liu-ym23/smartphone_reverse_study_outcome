package com.obric.aikernel.sdk.autotest;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.SdkContext;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoTestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJE\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\r0\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/sdk/autotest/AutoTestManager;", "", "()V", "TAG", "", "autoTest", "Lcom/obric/aikernel/sdk/response/Response;", "context", "Landroid/content/Context;", "params", "Lorg/json/JSONObject;", "(Landroid/content/Context;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callAutoTestAsResponse", ExifInterface.GPS_DIRECTION_TRUE, "binder", "Lcom/obric/aikernel/AIKBinder;", "args", "Landroid/os/Bundle;", "timeoutMs", "", "block", "Lkotlin/Function1;", "(Lcom/obric/aikernel/AIKBinder;Landroid/os/Bundle;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAutoTestApp", "", "packageName", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoTestManager {
    public static final AutoTestManager INSTANCE = null;
    private static final String TAG = "AutoTestManager";

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoTestManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0, 0}, l = {38, 39}, m = "autoTest", n = {"this", "bArgs"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        AnonymousClass1(AutoTestManager r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.autoTest(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoTestManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0, 0, 0, 0}, l = {53}, m = "callAutoTestAsResponse", n = {"this", "args", "block", "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
    static final class C02361<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        C02361(AutoTestManager r1, Continuation<? super C02361> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return AutoTestManager.access$callAutoTestAsResponse(this.this$0, null, null, 0, null, this);
        }
    }

    static {
        INSTANCE = new AutoTestManager();
    }

    private AutoTestManager() {
    }

    public static final /* synthetic */ Object access$callAutoTestAsResponse(AutoTestManager r0, AIKBinder r1, Bundle r2, long r3, Function1 r5, Continuation r6) {
        return r0.callAutoTestAsResponse(r1, r2, r3, r5, r6);
    }

    public final Object autoTest(Context r18, JSONObject r19, Continuation<? super Response<Object>> r20) {
        if ((r20 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r20;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r9 = r2;
        Object r1 = r9.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r9.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L31:
        return r1;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r0 = (Bundle) r9.L$1;
        AutoTestManager r5 = (AutoTestManager) r9.L$0;
        ResultKt.throwOnFailure(r1);
    L24:
        AIKBinder r6 = (AIKBinder) r1;
        if (r6 == null) goto L27;
        AnonymousClass2 r7 = AnonymousClass2.INSTANCE;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.label = 2;
        r1 = r5.callAutoTestAsResponse(r6, r0, 5000, r7, r9);
        if (r1 != r3) goto L31;
        return r3;
    L27:
        return BundleExtKt.toBasicTypeResponse(BundleExtKt.setErr$default(new Bundle(), 102, null, 2, null));
    L16:
        ResultKt.throwOnFailure(r1);
        String r8 = r18.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r8, "context.packageName");
        if (isAutoTestApp(r8) == false) goto L19;
        Bundle r10 = BundleExtKt.json2Bundle$default(r19, false, 2, null);
        SdkContext r11 = SdkContext.INSTANCE;
        r9.L$0 = this;
        r9.L$1 = r10;
        r9.label = 1;
        Object r12 = r11.getBinder(r9);
        if (r12 != r3) goto L23;
        return r3;
    L23:
        r5 = this;
        r0 = r10;
        r1 = r12;
        goto L24
    L19:
        return BundleExtKt.toBasicTypeResponse(BundleExtKt.setErr$default(new Bundle(), 101, "only auto test app can call this method.", false, 4, null));
    L7:
        r2 = new AnonymousClass1(this, r20);
        goto L8
    }

    public final boolean isAutoTestApp(String r1) {
        Intrinsics.checkNotNullParameter(r1, "packageName");
        return Intrinsics.areEqual(r1, AutoTestConstant.AUTO_TEST_APP_PACKAGE_NAME);
    }

    private final <T> Object callAutoTestAsResponse(AIKBinder r15, Bundle r16, long r17, Function1<? super Bundle, ? extends T> r19, Continuation<? super T> r20) {
        AutoTestManager r0 = this;
        if ((r20 instanceof C02361) == false) goto L7;
        C02361 r2 = (C02361) r20;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        C02361 r9 = r2;
        Object r1 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r9.J$0;
        Function1<? super Bundle, ? extends T> r5 = (Function1) r9.L$2;
        Bundle r6 = (Bundle) r9.L$1;
        AutoTestManager r7 = (AutoTestManager) r9.L$0;
        ResultKt.throwOnFailure(r1);
        Function1<? super Bundle, ? extends T> r8 = r5;
        r0 = r7;
        Object r11 = r1;
        Bundle r12 = r6;
    L18:
        Bundle r13 = (Bundle) r11;
        if (r13 != null) goto L22;
        AIKLog.INSTANCE.v(TAG, "callAutoTestlAsResponse " + r12.getString("_M") + " timeout after " + r4 + " ms");
        r13 = BundleExtKt.setErr$default(new Bundle(), 107, "timeout after " + r4 + " ms", false, 4, null);
    L22:
        return r8.invoke(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        AutoTestManager$callAutoTestAsResponse$responseBundle$1 r14 = new AutoTestManager$callAutoTestAsResponse$responseBundle$1(r16, r17, r15, null);
        r9.L$0 = r0;
        r12 = r16;
        r9.L$1 = r12;
        r9.L$2 = r19;
        r9.J$0 = r17;
        r9.label = 1;
        Object r18 = TimeoutKt.withTimeoutOrNull(r17, r14, r9);
        if (r18 != r10) goto L17;
        return r10;
    L17:
        r8 = r19;
        r11 = r18;
        r4 = r17;
    L7:
        r2 = new C02361(this, r20);
        goto L8
    }

    static /* synthetic */ Object callAutoTestAsResponse$default(AutoTestManager r7, AIKBinder r8, Bundle r9, long r10, Function1 r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r10 = WsConstants.EXIT_DELAY_TIME;
    L6:
        return r7.callAutoTestAsResponse(r8, r9, r10, r12, r13);
    }
}
