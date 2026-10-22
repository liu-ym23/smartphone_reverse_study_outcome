package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkAsrManager f80505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IJsBridgeManager f80506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f80507c;

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        MultiLinkAsrManager r101 = this.f80505a;
        AsrStateChangeEvent.Type r102 = AsrStateChangeEvent.Type.Failed;
        String r103 = r100.a();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        MultiLinkAsrManager.a(r101, r102, r103, this.f80506b);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        MultiLinkAsrManager.a(this.f80505a, AsrStateChangeEvent.Type.GetResulted, r100, this.f80506b);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        MultiLinkAsrManager.a(this.f80505a, AsrStateChangeEvent.Type.GetPartialResulted, r100, this.f80506b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void onStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        MultiLinkAsrManager.a(this.f80505a, AsrStateChangeEvent.Type.Started, r100, this.f80506b);
        this.f80507c.element = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void onStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        MultiLinkAsrManager.a(this.f80505a, AsrStateChangeEvent.Type.Finished, r100, this.f80506b);
    }

    public j(MultiLinkAsrManager r100, IJsBridgeManager r101, Ref.ObjectRef r102) {
        this.f80505a = r100;
        this.f80506b = r101;
        this.f80507c = r102;
    }
}
