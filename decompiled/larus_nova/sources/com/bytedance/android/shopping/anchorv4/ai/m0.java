package com.bytedance.android.shopping.anchorv4.ai;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.api.ai.AIChatMessage;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContextStore;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m0 implements xe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f165673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f165674b;

    @Override // xe.e
    public final void a(AIChatMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getMessageId();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f165673a.associateSnapshot(r100.getLocalMessageId(), r101);
        FragmentActivity r102 = this.f165674b.getActivity();
        if (r102 == null) goto L19;
        ConversationContextStore r103 = ConversationContextStore.f42797b;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r102, "activity");     // Catch: Throwable -> L16
        ConversationContextStore.a r104 = ConversationContextStore.b(r102);     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        ConversationContextStore.b r105 = r104.f42799b;     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r105.f42803d = false;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r103);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // xe.e
    public final void c(AIChatMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        View r101 = this.f165674b.c();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f165673a.d(r101, r100.getLocalMessageId());
    }

    @Override // xe.e
    public final void d(AIChatMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public m0(p0 r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        Intrinsics.checkNotNullParameter(r101, "host");
        this.f165673a = r100;
        this.f165674b = r101;
    }

    @Override // xe.e
    public final void b(String r100, xe.f r101) {
        Intrinsics.checkNotNullParameter(r100, "queryMsgId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r100, "queryMsgId");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
    }
}
