package com.bytedance.applet.utils;

import com.bytedance.applet.event.EventDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes14.dex */
public final class SuspendReceiveMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f192272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f192273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f192274c;

    public static final class a implements com.bytedance.applet.event.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuspendReceiveMessage f192275a;

        public a(SuspendReceiveMessage r100) {
            this.f192275a = r100;
        }

        @Override // com.bytedance.applet.event.n
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            if (r101.getMessageStatusLocal() == 21) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101.getLocalMessageId(), this.f192275a.f192273b) == false) goto L11;
            FLogger.f375446a.i("SuspendReceiveMessage", "onMessage");
            EventDispatcher r102 = EventDispatcher.f191774a;
            Intrinsics.checkNotNullParameter(this, "listener");
            EventDispatcher.f191781h.remove(this);
            Function1<? super Boolean, Unit> r103 = this.f192275a.f192272a;
            if (r103 == null) goto L12;
            r103.invoke(Boolean.TRUE);
            return;
        L12:
            return;
        }
    }

    public SuspendReceiveMessage() {
        this.f192274c = new a(this);
    }

    public final Object a(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof SuspendReceiveMessage$msgReceivedByLocalMsg$1) == false) goto L7;
        SuspendReceiveMessage$msgReceivedByLocalMsg$1 r102 = (SuspendReceiveMessage$msgReceivedByLocalMsg$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        Boolean r107 = (Boolean) r104;
        FLogger.f375446a.i("SuspendReceiveMessage", "msgReceivedByLocalMsg result " + r107);
        if (Intrinsics.areEqual(r107, Boxing.boxBoolean(true)) == true) goto L20;
        EventDispatcher r108 = EventDispatcher.f191774a;
        a r109 = this.f192274c;
        Intrinsics.checkNotNullParameter(r109, "listener");
        EventDispatcher.f191781h.remove(r109);
    L20:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("SuspendReceiveMessage", "msgReceivedByLocalMsg start " + r100);
        this.f192273b = r100;
        SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1 r110 = new SuspendReceiveMessage$msgReceivedByLocalMsg$receiveMsgResult$1(this, null);
        r102.label = 1;
        r104 = TimeoutKt.c(10000, r110, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new SuspendReceiveMessage$msgReceivedByLocalMsg$1(this, r101);
        goto L8
    }
}
