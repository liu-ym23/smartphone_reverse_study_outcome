package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d extends q46.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f81936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f81937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f81938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f81939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f81940g;

    public interface a extends q46.a {
        void D(String r100);

        void E3(Throwable r100);

        void F(String r100, Throwable r101);

        void G(String r100);

        void r(String r100, Throwable r101);

        void vM(TalkRoomEmojiListResponse r100);

        void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r100);

        void w6(Throwable r100);
    }

    public abstract void c0(SilenceResponse r100);

    public abstract void d0(UnSilenceResponse r100);

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f81939f.clear();
    }

    public d(boolean r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f81940g = r100;
        this.f81939f = new CompositeDisposable();
    }
}
