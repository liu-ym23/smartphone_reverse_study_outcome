package com.bytedance.ai.applet.permission;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper", f = "AppletAuthorizeHelper.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {171, 189}, m = "authorizeOrThrow", n = {"scopeName", "authTaskSession", "resultDetail", "permissionCheckSession", "skipDialogIfDenied", "scopeName", "isAppletAlreadyGranted"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "I$0"})
public final class AppletAuthorizeHelper$authorizeOrThrow$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorizeOrThrow$1(AppletAuthorizeHelper r100, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppletAuthorizeHelper r101 = this.this$0;
        Lazy<Keva> r102 = AppletAuthorizeHelper.f34919d;
        return r101.f(null, false, null, null, null, this);
    }
}
