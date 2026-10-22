package com.android.ttcjpaysdk.kmp.common.view.sms_input;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.android.ttcjpaysdk.kmp.common.view.sms_input.CJSmsInputKt$CJSmsInput$7$1", f = "CJSmsInput.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class CJSmsInputKt$CJSmsInput$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardManager;
    final /* synthetic */ boolean $triggerHiddenKeyboard;
    int label;

    public CJSmsInputKt$CJSmsInput$7$1(boolean r100, FocusRequester r101, SoftwareKeyboardController r102, Continuation<? super CJSmsInputKt$CJSmsInput$7$1> r103) {
        this.$triggerHiddenKeyboard = r100;
        this.$focusRequester = r101;
        this.$keyboardManager = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CJSmsInputKt$CJSmsInput$7$1(this.$triggerHiddenKeyboard, this.$focusRequester, this.$keyboardManager, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CJSmsInputKt$CJSmsInput$7$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        if (this.$triggerHiddenKeyboard == false) goto L16;
        this.$focusRequester.freeFocus();
        SoftwareKeyboardController r103 = this.$keyboardManager;
        if (r103 == null) goto L20;
        r103.hide();
    L20:
        return Unit.INSTANCE;
    L16:
        FocusRequester.m4489requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        SoftwareKeyboardController r104 = this.$keyboardManager;
        if (r104 == null) goto L20;
        r104.show();
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(100, this) != r101) goto L12;
        return r101;
    }
}
