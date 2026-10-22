package com.bytedance.android.live.profit.format.voicechat.viewmodel;

import com.bytedance.android.live.profit.format.voicechat.model.CloseReason;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements hu0.a.InterfaceC6196a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceChatViewModel.i f87810a;

    public f(VoiceChatViewModel.i r100) {
        this.f87810a = r100;
    }

    @Override // hu0.a.InterfaceC6196a
    public final void a(ju0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "topicMessage");
        VoiceChatViewModel.access$get_topics$p(this.f87810a.f87801a).setValue(r100);
    }

    @Override // hu0.a.InterfaceC6196a
    public final void b(VoiceChatState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        j.a(this, "on talk state change: " + r100);
        VoiceChatViewModel.access$get_chatState$p(this.f87810a.f87801a).setValue(r100);
    }

    @Override // hu0.a.InterfaceC6196a
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "detail");
        this.f87810a.f87801a.closeChat(false, CloseReason.OTHER, r100);
    }
}
