package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.utils.j0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECAnchorFlashScreenShot$handle$1$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.hybrid.bridges.ECAnchorFlashScreenShot$handle$1$1$1", f = "ECAnchorFlashScreenShot.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath$inlined;
    int label;
    final /* synthetic */ ECAnchorFlashScreenShot$handle$1 this$0;

    public ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(Continuation r100, ECAnchorFlashScreenShot$handle$1 r101, String r102) {
        this.this$0 = r101;
        this.$filePath$inlined = r102;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(r101, this.this$0, this.$filePath$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        String r104 = (String) r100;
        dm.a.a("ECAnchorFlashScreenShot").a("base64Str = " + r104);
        if (r104 != null) goto L14;
    L17:
        if (r103 == true) goto L19;
        ECBaseBridgeMethod.a r105 = this.this$0.$iReturn;
        JSONObject r106 = new JSONObject();
        r106.put("img", "data:image/jpeg;base64," + r104);
        Unit r107 = Unit.INSTANCE;
        r105.onSuccess(r106);
    L21:
        return Unit.INSTANCE;
    L19:
        dm.a.a("ECAnchorFlashScreenShot").b("base64Str is empty", null);
        goto L21
    L14:
        if (r104.length() == 0) goto L17;
        r103 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        int r108 = j0.f153091a;
        PolarisFileWrapper r109 = new PolarisFileWrapper(new URI(this.$filePath$inlined));
        this.label = 1;
        r100 = j0.b(r109, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
