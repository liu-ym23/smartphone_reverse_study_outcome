package com.bytedance.android.ec.host.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import va8.t0;

/* JADX INFO: loaded from: classes44.dex */
public final class ECMessageObserverWrapper implements dw8.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xe.e f46193a;

    @Override // dw8.t
    public final void p(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // dw8.t
    public final void t() {
    }

    @Override // dw8.t
    public final void y() {
    }

    public final int hashCode() {
        return this.f46193a.hashCode();
    }

    public ECMessageObserverWrapper(xe.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f46193a = r100;
    }

    @Override // dw8.t
    public final void F1(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ECMessageObserverWrapper$onSendMessage$1(this, r100, null), 3, null);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof ECMessageObserverWrapper) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f46193a, ((ECMessageObserverWrapper) r100).f46193a) == false) goto L7;
        return true;
    }

    @Override // dw8.t
    public final void oa(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ECMessageObserverWrapper$onSendMessageResult$1(this, r100, null), 3, null);
    }

    @Override // dw8.t
    public final void za(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ECMessageObserverWrapper$onReceiveMessageEnd$1(this, r100, null), 3, null);
    }

    @Override // dw8.t
    public final void ba(String r100, t0 r101) {
        Intrinsics.checkNotNullParameter(r100, "queryMsgId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new ECMessageObserverWrapper$onReceiveRefreshCmd$1(this, r100, r101, null), 3, null);
    }
}
