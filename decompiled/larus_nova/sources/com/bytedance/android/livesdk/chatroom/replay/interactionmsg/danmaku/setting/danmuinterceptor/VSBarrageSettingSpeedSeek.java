package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.ReplayBarrageSettingDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSettingSpeed;
import com.bytedance.live.datacontext.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/danmuinterceptor/VSBarrageSettingSpeedSeek;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/setting/danmuinterceptor/AbsReplayDanmakuSettingSeekView;", "", "getTitle", "", "getStepCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSBarrageSettingSpeedSeek extends AbsReplayDanmakuSettingSeekView {
    public VSBarrageSettingSpeedSeek(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSBarrageSettingSpeedSeek(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public String getTitle() {
        return "速度";
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public int getStepCount() {
        return ReplayBarrageSettingSpeed.values().length - 1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final String R5(int r100) {
        ReplayBarrageSettingSpeed.Companion.getClass();
        return ReplayBarrageSettingSpeed.a.a(r100).getDes();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final int S5(ReplayBarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        return r100.getSpeed().getLevel();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView
    public final void T5(int r100) {
        ReplayBarrageSettingDataContext r101 = ReplayBarrageSettingDataContext.Companion.getContext();
        if (r101 == null) goto L10;
        n<ReplayBarrageSetting> r102 = r101.getBarrageSetting();
        if (r102 == null) goto L11;
        ReplayBarrageSetting r103 = r102.getValue();
        if (r103 == null) goto L12;
        ReplayBarrageSettingSpeed.Companion.getClass();
        r103.setSpeed(ReplayBarrageSettingSpeed.a.a(r100));
        return;
    L12:
        return;
    L11:
        return;
    }

    public VSBarrageSettingSpeedSeek(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ VSBarrageSettingSpeedSeek(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
