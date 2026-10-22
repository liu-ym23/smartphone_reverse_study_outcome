package com.bytedance.android.livesdk.chatroom.progressbar.widget;

import com.bytedance.android.livesdk.chatroom.vsplayer.api.d;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;", "p1", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "p2", "", "p3", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class PlayerProgressBarWidget$onCustomMarkClicked$2 extends FunctionReferenceImpl implements Function3<d, EpisodeHighLight, Boolean, Unit> {
    public static final PlayerProgressBarWidget$onCustomMarkClicked$2 INSTANCE = null;

    static {
        INSTANCE = new PlayerProgressBarWidget$onCustomMarkClicked$2();
    }

    public PlayerProgressBarWidget$onCustomMarkClicked$2() {
        super(3, d.class, "onClickHighLightMark", "onClickHighLightMark(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(d r100, EpisodeHighLight r101, Boolean r102) {
        invoke(r100, r101, r102.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(d r100, EpisodeHighLight r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        r100.v2(r101);
    }
}
