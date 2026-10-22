package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ContentSafetyApi$checkContent$2", f = "ContentSafetyApi.kt", l = {56}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ContentSafetyApi$checkContent$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $content;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentSafetyApi$checkContent$2(String str, InterfaceC4014c<? super ContentSafetyApi$checkContent$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ContentSafetyApi$checkContent$2(this.$content, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ContentSafetyApi$checkContent$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c7 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:6:0x0031, B:28:0x01a0, B:30:0x01a8, B:32:0x01b0, B:37:0x01c1, B:39:0x01c7, B:41:0x01d5, B:43:0x01db, B:45:0x0214, B:48:0x021c, B:51:0x0223, B:53:0x0230, B:55:0x023f, B:57:0x0267, B:59:0x028b, B:61:0x0296, B:44:0x01f5, B:34:0x01b7, B:36:0x01bd, B:16:0x011b, B:18:0x013f, B:21:0x0147, B:25:0x0152), top: B:66:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f5 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:6:0x0031, B:28:0x01a0, B:30:0x01a8, B:32:0x01b0, B:37:0x01c1, B:39:0x01c7, B:41:0x01d5, B:43:0x01db, B:45:0x0214, B:48:0x021c, B:51:0x0223, B:53:0x0230, B:55:0x023f, B:57:0x0267, B:59:0x028b, B:61:0x0296, B:44:0x01f5, B:34:0x01b7, B:36:0x01bd, B:16:0x011b, B:18:0x013f, B:21:0x0147, B:25:0x0152), top: B:66:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0230 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:6:0x0031, B:28:0x01a0, B:30:0x01a8, B:32:0x01b0, B:37:0x01c1, B:39:0x01c7, B:41:0x01d5, B:43:0x01db, B:45:0x0214, B:48:0x021c, B:51:0x0223, B:53:0x0230, B:55:0x023f, B:57:0x0267, B:59:0x028b, B:61:0x0296, B:44:0x01f5, B:34:0x01b7, B:36:0x01bd, B:16:0x011b, B:18:0x013f, B:21:0x0147, B:25:0x0152), top: B:66:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023f A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:6:0x0031, B:28:0x01a0, B:30:0x01a8, B:32:0x01b0, B:37:0x01c1, B:39:0x01c7, B:41:0x01d5, B:43:0x01db, B:45:0x0214, B:48:0x021c, B:51:0x0223, B:53:0x0230, B:55:0x023f, B:57:0x0267, B:59:0x028b, B:61:0x0296, B:44:0x01f5, B:34:0x01b7, B:36:0x01bd, B:16:0x011b, B:18:0x013f, B:21:0x0147, B:25:0x0152), top: B:66:0x0011 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ContentSafetyApi$checkContent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
