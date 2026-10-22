package com.obric.aikernel.phx.compat;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.utility.date.DateDef;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.SdkContext;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ParamsCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/phx/compat/ParamsCompat;", "", "()V", "TAG", "", "grantUri", "", Params.FILE_PATH, SlardarSettingsConsts.PERF_KEY_FD, "Landroid/content/res/AssetFileDescriptor;", "timeoutMs", "", "(Ljava/lang/String;Landroid/content/res/AssetFileDescriptor;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStartCompat", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCompat", "Landroid/os/Bundle;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParamsCompat {
    public static final ParamsCompat INSTANCE = null;
    private static final String TAG = "ParamsCompat";

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$grantUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0, 0, 0, 0}, l = {31}, m = "grantUri", n = {"this", Params.FILE_PATH, SlardarSettingsConsts.PERF_KEY_FD, "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        AnonymousClass1(ParamsCompat r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$grantUri(this.this$0, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$onStartCompat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {}, l = {25}, m = "onStartCompat", n = {}, s = {})
    static final class C02231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C02231(ParamsCompat r1, Continuation<? super C02231> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ParamsCompat.access$onStartCompat(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.compat.ParamsCompat$startCompat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ParamsCompat.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0}, l = {16}, m = "startCompat", n = {"$this$startCompat"}, s = {"L$0"})
    static final class C02241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ParamsCompat this$0;

        C02241(ParamsCompat r1, Continuation<? super C02241> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.startCompat(null, this);
        }
    }

    static {
        INSTANCE = new ParamsCompat();
    }

    private ParamsCompat() {
    }

    public static final /* synthetic */ Object access$grantUri(ParamsCompat r0, String r1, AssetFileDescriptor r2, long r3, Continuation r5) {
        return r0.grantUri(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object access$onStartCompat(ParamsCompat r0, RequestParams r1, Continuation r2) {
        return r0.onStartCompat(r1, r2);
    }

    public final Object startCompat(RequestParams r5, Continuation<? super Bundle> r6) {
        if ((r6 instanceof C02241) == false) goto L7;
        C02241 r0 = (C02241) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        RequestParams r4 = (RequestParams) r0.L$0;
        ResultKt.throwOnFailure(r7);
        r5 = r4;
    L20:
        return r5.start();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (SdkContext.INSTANCE.isLegacyArch() == false) goto L20;
        r0.L$0 = r5;
        r0.label = 1;
        if (onStartCompat(r5, r0) != r1) goto L20;
        return r1;
    L7:
        r0 = new C02241(this, r6);
        goto L8
    }

    private final Object onStartCompat(RequestParams r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C02231) == false) goto L7;
        C02231 r0 = (C02231) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        C02231 r6 = r0;
        Object r9 = r6.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        String r2 = r10.getBackend().getString(Params.FILE_PATH);
        if (r2 == null) goto L22;
        AssetFileDescriptor r3 = (AssetFileDescriptor) r10.getBackend().getParcelable(Params.FD_ASSET);
        if (r3 == null) goto L22;
        ParamsCompat r13 = INSTANCE;
        r6.label = 1;
        if (grantUri$default(r13, r2, r3, 0, r6, 4, null) != r12) goto L22;
        return r12;
    L7:
        r0 = new C02231(this, r11);
        goto L8
    }

    private final Object grantUri(String r5, AssetFileDescriptor r6, long r7, Continuation<? super Unit> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = r0.J$0;
        r6 = (AssetFileDescriptor) r0.L$2;
        r5 = (String) r0.L$1;
        ParamsCompat this = (ParamsCompat) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        AIKBinder r11 = (AIKBinder) r10;
        if (r11 != null) goto L27;
        AIKLog.INSTANCE.w(TAG, "grantUri get null binder!");
    L26:
        return Unit.INSTANCE;
    L27:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        Bundle r8 = BundleExtKt.setGlobalCall(new Bundle(), "_GrantUri", TAG, "grantUri");     // Catch: Throwable -> L21
        r8.putString("_uri", r5);     // Catch: Throwable -> L21
        r8.putParcelable("_fd", r6);     // Catch: Throwable -> L21
        r8.putLong("_timeout", r7);     // Catch: Throwable -> L21
        Object r12 = Result.m803constructorimpl(r11.callModelSync(r8));     // Catch: Throwable -> L21
    L23:
        Result.m802boximpl(r12);
    L21:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        SdkContext r14 = SdkContext.INSTANCE;
        r0.L$0 = this;
        r0.L$1 = r5;
        r0.L$2 = r6;
        r0.J$0 = r7;
        r0.label = 1;
        r10 = r14.getBinder(r0);
        if (r10 != r1) goto L17;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    static /* synthetic */ Object grantUri$default(ParamsCompat r6, String r7, AssetFileDescriptor r8, long r9, Continuation r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r9 = DateDef.HOUR;
    L6:
        return r6.grantUri(r7, r8, r9, r11);
    }
}
