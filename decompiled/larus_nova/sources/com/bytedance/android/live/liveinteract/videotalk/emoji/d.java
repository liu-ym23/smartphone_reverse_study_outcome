package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d extends q46.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f79346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f79347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f79348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f79349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f79350g;

    public interface a extends q46.a {
        void A2(List<? extends j1> r100);

        void B4();

        void D(String r100);

        void E3(Throwable r100);

        void F(String r100, Throwable r101);

        void G(String r100);

        void G3(Throwable r100);

        void Lu(List<? extends ILinkmicInteractEntrance> r100);

        void ih(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r100);

        void j9(List<? extends ILinkmicInteractEntrance> r100);

        void r(String r100, Throwable r101);

        void ta(ContributeShowResponse.OwnerHonorInfo r100);

        void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r100);

        void w6(Throwable r100);
    }

    public abstract void d0(r1 r100);

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f79349f.clear();
    }

    public abstract void e0(c2 r100);

    public static VoiceChatMuteManager c0() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r100 = IVoiceChatAdminService.a.a();
        com.bytedance.android.live.liveinteract.voicechat.b r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.b r102 = r100.muteManager();
    L7:
        if ((r102 instanceof VoiceChatMuteManager) == false) goto L11;
        r101 = r102;
    L11:
        return (VoiceChatMuteManager) r101;
    L5:
        r102 = null;
        goto L7
    }

    public d(boolean r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f79350g = r100;
        this.f79349f = new CompositeDisposable();
    }
}
