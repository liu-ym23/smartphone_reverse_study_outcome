package com.obric.aivoice.core.utils;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aivoice.core.data.IdlErrors;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.sdk.response.Response;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResponseExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a,\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a+\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\n\u001a\u0004\u0018\u0001H\u00022\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006\u001a\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a:\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00150\u00012\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0015\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u0017\u001a\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0019\u001a\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u0019\u001a0\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00192\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u001d\u001a0\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00192\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u001d¨\u0006\u001f"}, d2 = {"newErr", "Lcom/obric/aivoice/sdk/response/Response;", ExifInterface.GPS_DIRECTION_TRUE, AccountConst.KEY_ERROR_CODE, "", "errorInfo", "", "newFlowErr", "Lkotlinx/coroutines/flow/Flow;", "newRes", "data", "isFinish", "", "(Ljava/lang/Object;Z)Lcom/obric/aivoice/sdk/response/Response;", "toClassCastErrorResponse", "toErrorResponse", "code", NotificationCompat.CATEGORY_MESSAGE, "toNullResponse", "map", "Tt", "Ts", "block", "Lkotlin/Function1;", "toBasicTypeResponse", "Landroid/os/Bundle;", "toJsonResult", "Lorg/json/JSONObject;", "toNetResponse", "Lkotlin/Function2;", "toUserResponse", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ResponseExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.ResponseExtKt$newFlowErr$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResponseExt.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aivoice/sdk/response/Response;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aivoice.core.utils.ResponseExtKt$newFlowErr$1", f = "ResponseExt.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super Response<T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $errorCode;
        final /* synthetic */ String $errorInfo;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(int r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$errorCode = r1;
            this.$errorInfo = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$errorCode, this.$errorInfo, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((FlowCollector) r1, r2);
        }

        public final Object invoke(FlowCollector<? super Response<T>> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(ResponseExtKt.newErr(this.$errorCode, this.$errorInfo), this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Response newErr$default(int r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return newErr(r0, r1);
    }

    public static final <T> Response<T> newErr(int r9, String r10) {
        if (r10 != null) goto L5;
        r10 = IdlErrors.INSTANCE.getDefaultErrInfo().get(Integer.valueOf(r9));
    L5:
        return new Response(r9, r10, null, true, false, null, 32, null);
    }

    public static /* synthetic */ Flow newFlowErr$default(int r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return newFlowErr(r0, r1);
    }

    public static final <T> Flow<Response<T>> newFlowErr(int r2, String r3) {
        return FlowKt.flow(new AnonymousClass1(r2, r3, null));
    }

    public static /* synthetic */ Response newRes$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = true;
    L6:
        return newRes(r0, r1);
    }

    public static final <T> Response<T> newRes(T r10, boolean r11) {
        if (r11 == false) goto L6;
        return new Response(0, null, r10, r11, false, null, 32, null);
    L6:
        return new Response(1, null, r10, r11, false, null, 32, null);
    }

    public static final <Ts, Tt> Response<Tt> map(Response<Ts> r8, Function1<? super Ts, ? extends Tt> r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "block");
        return new Response(r8.getErrorCode(), r8.getErrorInfo(), r9.invoke(r8.getData()), r8.isFinish(), r8.isTaskId(), r8.getTimeLog());
    }

    public static final <T> Response<T> toBasicTypeResponse(Bundle r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new Response(r9.getInt("_EC", 0), r9.getString("_EI"), r9.get("_R"), r9.getBoolean("_IF", true), r9.getBoolean("_IT", false), r9.getBundle(IdlKeys.Args_TimeLog));
    }

    public static final <T> Response<T> toUserResponse(Bundle r11, Function2<? super Bundle, ? super String, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r3 = r11.getInt("_EC", 0);
        String r4 = r11.getString("_EI");
        boolean r6 = r11.getBoolean("_IF", true);
        boolean r7 = r11.getBoolean("_IT", false);
        return new Response(r3, r4, r12.invoke(r11, "_R"), r6, r7, null, 32, null);
    }

    public static final <T> Response<T> toNetResponse(Bundle r11, Function2<? super Bundle, ? super String, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r3 = r11.getInt("_EC", -1);
        String r4 = r11.getString("_EI");
        boolean r6 = r11.getBoolean("_IF", true);
        boolean r7 = r11.getBoolean("_IT", false);
        return new Response(r3, r4, r12.invoke(r11, "_R"), r6, r7, null, 32, null);
    }

    public static final Response<JSONObject> toJsonResult(Bundle r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        int r3 = r11.getInt("_EC", 0);
        String r4 = r11.getString("_EI");
        Bundle r0 = r11.getBundle("_R");
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, "getBundle(IdlKeys.Result)?: Bundle()");
        return new Response(r3, r4, BundleExtKt.bundle2json(r0), r11.getBoolean("_IF", true), r11.getBoolean("_IT", false), null, 32, null);
    }

    public static final <T> Response<T> toNullResponse() {
        return new Response(-1, "未知错误", null, false, false, null, 56, null);
    }

    public static final <T> Response<T> toClassCastErrorResponse() {
        return new Response(101, "invalid type cast.", null, false, false, null, 56, null);
    }

    public static final <T> Response<T> toErrorResponse(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        return new Response(r10, r11, null, false, false, null, 56, null);
    }
}
