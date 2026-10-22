package com.android.ttcjpaysdk.thirdparty.voiceprint;

import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintOperation;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$recognizeVoicePrint$1", f = "VoicePrintSession.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 299, 300}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePrintSession$recognizeVoicePrint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VoicePrintOperation $op;
    final /* synthetic */ String $path;
    Object L$0;
    int label;
    final /* synthetic */ VoicePrintSession this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[VoicePrintOperation.values().length];
            r100[VoicePrintOperation.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoicePrintOperation.UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoicePrintOperation.VERIFY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public VoicePrintSession$recognizeVoicePrint$1(VoicePrintSession r100, VoicePrintOperation r101, String r102, Continuation<? super VoicePrintSession$recognizeVoicePrint$1> r103) {
        this.this$0 = r100;
        this.$op = r101;
        this.$path = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoicePrintSession$recognizeVoicePrint$1(this.this$0, this.$op, this.$path, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoicePrintSession$recognizeVoicePrint$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 != 3) goto L9;
        VoicePrintSession r103 = (VoicePrintSession) this.L$0;
        ResultKt.throwOnFailure(r100);
    L20:
        ICJPayRequest r104 = (ICJPayRequest) r100;
    L33:
        VoicePrintSession.access$setCurrentRequest$p(r103, r104);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r103 = (VoicePrintSession) this.L$0;
        ResultKt.throwOnFailure(r100);
    L27:
        r104 = (ICJPayRequest) r100;
        goto L33
    L11:
        r103 = (VoicePrintSession) this.L$0;
        ResultKt.throwOnFailure(r100);
    L32:
        r104 = (ICJPayRequest) r100;
        goto L33
    L12:
        ResultKt.throwOnFailure(r100);
        VoicePrintSession r105 = this.this$0;
        VoicePrintOperation r106 = this.$op;
        int r107 = WhenMappings.$EnumSwitchMapping$0[r106.ordinal()];
        if (r107 == 1) goto L28;
        if (r107 == 2) goto L23;
        if (r107 != 3) goto L22;
        VoicePrintSession r108 = this.this$0;
        String r109 = this.$path;
        this.L$0 = r105;
        this.label = 3;
        Object r110 = VoicePrintSession.access$requestVerify(r108, r109, this);
        if (r110 != r101) goto L19;
        return r101;
    L19:
        r103 = r105;
        r100 = r110;
        goto L20
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        VoicePrintSession r111 = this.this$0;
        String r112 = this.$path;
        this.L$0 = r105;
        this.label = 2;
        Object r113 = VoicePrintSession.access$requestOpenOrUpdate(r111, r112, this);
        if (r113 != r101) goto L26;
        return r101;
    L26:
        r103 = r105;
        r100 = r113;
        goto L27
    L28:
        VoicePrintSession r114 = this.this$0;
        String r115 = this.$path;
        this.L$0 = r105;
        this.label = 1;
        Object r116 = VoicePrintSession.access$requestOpenOrUpdate(r114, r115, this);
        if (r116 != r101) goto L31;
        return r101;
    L31:
        r103 = r105;
        r100 = r116;
        goto L32
    }
}
