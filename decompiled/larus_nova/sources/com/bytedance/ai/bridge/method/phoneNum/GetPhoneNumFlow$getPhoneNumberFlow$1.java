package com.bytedance.ai.bridge.method.phoneNum;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow", f = "GetPhoneNumFlow.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9}, l = {144, 146, 149, 162, 164, 167, 169, 177, 179, 182}, m = "getPhoneNumberFlow", n = {IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", "loginContext", "phoneCode", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", "versionTag", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", "phoneMask", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", IFlowAppIntentIDL.PARAM_APPLET_ID, "loginContext", "loginContext", "phoneCode"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class GetPhoneNumFlow$getPhoneNumberFlow$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetPhoneNumFlow this$0;

    public GetPhoneNumFlow$getPhoneNumberFlow$1(GetPhoneNumFlow r100, Continuation<? super GetPhoneNumFlow$getPhoneNumberFlow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GetPhoneNumFlow.b(this.this$0, null, this);
    }
}
