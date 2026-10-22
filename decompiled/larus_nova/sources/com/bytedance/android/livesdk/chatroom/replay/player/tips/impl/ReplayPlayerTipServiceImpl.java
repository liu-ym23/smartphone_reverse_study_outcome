package com.bytedance.android.livesdk.chatroom.replay.player.tips.impl;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.context.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.u;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u0014\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/player/tips/impl/ReplayPlayerTipServiceImpl;", "Lmq1/u;", "Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerTipsContext;", "provideVSPlayTipsContext", "", "key", "", "content", "", "needAlphaAnim", "", "showPlayerTip", "Landroid/view/View;", "view", "showPlayerTipWithCustomView", "hidePlayerTip", "mContext$delegate", "Lkotlin/Lazy;", "getMContext", "()Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerTipsContext;", "mContext", "tag", "Ljava/lang/String;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayerTipServiceImpl implements u {
    private final Lazy mContext$delegate;
    private final String tag;

    private final PlayerTipsContext getMContext() {
        return (PlayerTipsContext) this.mContext$delegate.getValue();
    }

    public ReplayPlayerTipServiceImpl() {
        this.mContext$delegate = LazyKt.lazy(ReplayPlayerTipServiceImpl$mContext$2.INSTANCE);
        this.tag = "IReplayPlayerTipService[" + hashCode() + ']';
    }

    @Override // mq1.u
    public PlayerTipsContext provideVSPlayTipsContext() {
        return getMContext();
    }

    @Override // mq1.u
    public void hidePlayerTip(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ALogger.d(this.tag, "start post hide event for " + r100);
        getMContext().getMHidePlayerTipEvent().post(r100);
    }

    @Override // mq1.u
    public void showPlayerTipWithCustomView(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "view");
        a r102 = new a(r100, r101);
        ALogger.d(this.tag, "start post show custom tip for ".concat(r100));
        getMContext().getMShowPlayerTipEvent().post(r102);
    }

    @Override // mq1.u
    public void showPlayerTip(String r100, CharSequence r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "content");
        a r102 = new a(r100, 0, r101, null, r110);
        ALogger.d(this.tag, "start post show default tip for ".concat(r100));
        getMContext().getMShowPlayerTipEvent().post(r102);
    }
}
